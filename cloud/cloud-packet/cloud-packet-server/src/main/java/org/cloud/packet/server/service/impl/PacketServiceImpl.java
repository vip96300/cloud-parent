package org.cloud.packet.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.model.PacketDTO;
import org.cloud.packet.server.model.ProductDTO;
import org.cloud.packet.server.repository.PacCategoryRepository;
import org.cloud.packet.server.repository.PacPictureRepository;
import org.cloud.packet.server.repository.PacketRepository;
import org.cloud.packet.server.service.PacketService;
import org.cloud.packet.server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class PacketServiceImpl implements PacketService{

	
	@Autowired
	private PacketRepository packetRepository;
	
	@Autowired
	private PacCategoryRepository pacCategoryRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private PacPictureRepository pacPictureRepository;
	
	@Override
	public void add(Packet packet) {
		packet.setTime(System.currentTimeMillis());
		packet.setIspk(0);
		packetRepository.save(packet);
	}

	@Override
	public void delByPacid(long pacid) {
		Packet packet=packetRepository.findOne(pacid);
		if(!ValidUtil.isValid(packet)){
			return;
		}
		packet.setIsdel(1);
		packet.setIspk(0);
		packetRepository.saveAndFlush(packet);
	}

	@Override
	public List<Packet> list(Pageable pageable) {
		List<Packet> packets=packetRepository.findByIsdel(0, pageable).getContent();
		return packets;
	}

	@Override
	public Packet getByPacid(long pacid) {
		Packet packet=packetRepository.findOne(pacid);
		return packet;
	}

	@Override
	public void updByPacid(Packet packet) {
		packetRepository.saveAndFlush(packet);
	}

	@Override
	public List<Packet> listBySome() {
		Pageable pageable=new PageRequest(0,1);
		List<Packet> packets=packetRepository.findAll(pageable).getContent();
		return packets;
	}

	@Override
	public Map<String, List<PacCategory>> packetPacCategorys() {
		List<Packet> packets=packetRepository.findByIspk(1);
		if(packets.isEmpty()){
			return new HashMap<String,List<PacCategory>>();
		}
		Packet packet=packets.get(0);
		List<PacCategory> pacCategorys=pacCategoryRepository.findByPacid(packet.getPacid());
		Map<String,List<PacCategory>> packetPacCategorys=new HashMap<String,List<PacCategory>>();
		packetPacCategorys.put(new Gson().toJson(packet),pacCategorys);
		return packetPacCategorys;
	}
	
	@Override
	public Map<String, List<PacCategory>> packetPacCategorysByPacid(long pacid) {
		Packet packet=packetRepository.findOne(pacid);
		List<PacCategory> pacCategorys=pacCategoryRepository.findByPacid(packet.getPacid());
		Map<String,List<PacCategory>> packetPacCategorys=new HashMap<String,List<PacCategory>>();
		packetPacCategorys.put(new Gson().toJson(packet),pacCategorys);
		return packetPacCategorys;
	}

	@Override
	public List<Map<String,Object>> listByObjs(int page, int size) {
		List<Packet> packets=packetRepository.findAll(new PageRequest(page, size)).getContent();
		if(packets.isEmpty()){
			return null;
		}
		List<Long> pacids=new ArrayList<Long>();
		for(Packet packet:packets){
			pacids.add(packet.getPacid());
		}
		List<PacCategory> pacCategorys=pacCategoryRepository.findByPacids(pacids);
		if(pacCategorys.isEmpty()){
			return null;
		}
		List<Long> proids=new ArrayList<Long>();
		for(PacCategory pacCategory:pacCategorys){
			proids.add(pacCategory.getProid());
		}
		List<ProductDTO> products=productService.listByProids(proids);
		//优选包图片集合
		//List<PacPicture> pacPictures=pacPictureRepository.findByTypeAndPacids(1, pacids);
		//最终结果集合
		List<Map<String,Object>> packetList=new ArrayList<Map<String,Object>>();
		for(Packet packet:packets){
			Map<String,Object> packetMap=new HashMap<String,Object>();
			PacketDTO packetDTO=new PacketDTO();
			BeanUtils.copyProperties(packet, packetDTO);
			//装载优选包图片
			/*for(PacPicture pacPicture:pacPictures){
				if(pacPicture.getPacid()==packet.getPacid()){
					packetDTO.getPacPictures().add(pacPicture);
					break;
				}
			}*/
			packetMap.put("packet",packetDTO);
			double discPrice=0;
			double sellPrice=0;
			for(PacCategory pacCategory:pacCategorys){
				for(ProductDTO product:products){
					if(product.getProid()==pacCategory.getProid()){
						discPrice+=product.getDiscprice();
						sellPrice+=product.getSellprice();
						break;
					}
				}
			}
			packetMap.put("discprice", discPrice);
			packetMap.put("sellprice", sellPrice);
			packetList.add(packetMap);
		}
		return packetList;
	}

}
