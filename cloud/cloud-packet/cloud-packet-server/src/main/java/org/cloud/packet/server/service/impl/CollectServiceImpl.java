package org.cloud.packet.server.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.ColPacket;
import org.cloud.packet.server.model.Collect;
import org.cloud.packet.server.model.GifPicture;
import org.cloud.packet.server.model.Gift;
import org.cloud.packet.server.model.GiftDTO;
import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.model.PacProduct;
import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.model.PictureDTO;
import org.cloud.packet.server.model.ProductDTO;
import org.cloud.packet.server.repository.ColPacketRepository;
import org.cloud.packet.server.repository.CollectRepository;
import org.cloud.packet.server.repository.GifPictureRepository;
import org.cloud.packet.server.repository.GiftRepository;
import org.cloud.packet.server.repository.PacCategoryRepository;
import org.cloud.packet.server.repository.PacProductRepository;
import org.cloud.packet.server.repository.PacketRepository;
import org.cloud.packet.server.service.CollectService;
import org.cloud.packet.server.service.PictureService;
import org.cloud.packet.server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;


@Service
public class CollectServiceImpl implements CollectService{

	@Autowired
	private CollectRepository collectRepository;
	@Autowired
	private ColPacketRepository colPacketRepository;
	@Autowired
	private PacketRepository packetRepository;
	@Autowired
	private PacCategoryRepository pacCategoryRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private PacProductRepository pacProductRepository;
	@Autowired
	private GiftRepository giftRepository;
	@Autowired
	private GifPictureRepository gifPictureRepository;
	
	@Override
	public Map<String,Object> add(String userid, long pacid, String name,Map<String, String> packetMap) throws Exception {
		Packet packet=packetRepository.findOne(pacid);
		if(!ValidUtil.isValid(packet)){
			return null;
		}
		Collect collect=new Collect();
		collect.setUserid(userid);
		collect.setPacid(pacid);
		collect.setName(name);
		collect.setTime(System.currentTimeMillis());
		collectRepository.save(collect);
		List<PacCategory> pacCategorys=pacCategoryRepository.findByPacid(pacid);
		//产品编号集合
		List<Long> proids=new ArrayList<Long>();
		//收藏集合
		List<ColPacket> colPackets=new ArrayList<ColPacket>();
		for(PacCategory pacCategory:pacCategorys){
			ColPacket colPacket=new ColPacket();
			colPacket.setColid(collect.getColid());
			colPacket.setCatid(pacCategory.getCategoryid());
			String proid="";
			if(pacCategory.getProid()!=0){
				//固定产品类目
				proid=String.valueOf(pacCategory.getProid());
			}else{
				//非固定产品类目
				proid=packetMap.get(String.valueOf(pacCategory.getCategoryid()));
			}
			if(!ValidUtil.isValid(proid)&&pacCategory.getIsmust()!=0){
				throw new RuntimeException();
			}
			long proidL=0L;
			if(ValidUtil.isValid(proid)){
				proidL=Long.valueOf(proid);
			}
			proids.add(proidL);
			colPacket.setProid(proidL);
			colPacket.setTime(System.currentTimeMillis());
			colPackets.add(colPacket);
		}
		//产品集合
		List<ProductDTO> products=this.products(proids).get();
		//折扣价
		double discprice=0;
		for(PacCategory pacCategory:pacCategorys){
			boolean isExistByProduct=false;
			ProidOuter:for(Long proid:proids){
				if(proid!=0){
					for(ProductDTO product:products){
						if(product.getProid()==proid&&product.getCatid()==pacCategory.getCategoryid()){
							isExistByProduct=true;
							discprice+=product.getDiscprice();
							break ProidOuter;
						}
					}
				}
				if(proid==0&&pacCategory.getIsmust()==0){
					isExistByProduct=true;
				}
			}
			if(!isExistByProduct){
				throw new RuntimeException();
			}
		}
		this.saveColPackets(colPackets);
		//返回结果
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("colid",collect.getColid());
		result.put("discprice",discprice);
		return result;
	}
	
	@Async
	private void saveColPackets(List<ColPacket> colPackets){
		if(colPackets.isEmpty()){
			return;
		}
		colPacketRepository.save(colPackets);
	}
	
	@Override
	public Map<String, Object> listPacCategorysProductsByUserid(String userid,int page,int size) throws Exception {
		List<Collect> collects=collectRepository.findByUserid(userid,new PageRequest(page,size));
		if(collects.isEmpty()){
			return null;
		}
		//收藏编号集合
		List<Long> colids=new ArrayList<Long>();
		for(Collect collect:collects){
			colids.add(collect.getColid());
		}
		List<ColPacket> colPackets=colPacketRepository.findByColids(colids);
		if(colPackets.isEmpty()){
			return null;
		}
		//产品编号集合
		List<Long> proids=new ArrayList<Long>();
		//类目编号集合
		List<Long> catids=new ArrayList<Long>();	
		for(ColPacket colPacket:colPackets){
			proids.add(colPacket.getProid());
			catids.add(colPacket.getCatid());
		}
		Future<List<ProductDTO>> products=this.products(proids);
		Future<List<PacCategory>> pacCategorys=this.pacCategory(catids);
		Future<List<PictureDTO>> pictures=this.pictures(proids);
		Future<List<PacProduct>> pacProducts=this.pacProducts(proids);
		while(true){
			if(products.isDone()&&pacCategorys.isDone()&&pictures.isDone()&&pacProducts.isDone()){
				break;
			}
			Thread.sleep(100);
		}
		//优选包产品编号集合，非产品编号集合
		List<Long> pacProids=new ArrayList<Long>();
		for(PacProduct pacProduct:pacProducts.get()){
			pacProids.add(pacProduct.getProid());
		}
		Future<List<Gift>> gifts=this.gifts(pacProids);
		//礼物编号集合
		List<Long> gifids=new ArrayList<Long>();
		for(Gift gift:gifts.get()){
			gifids.add(gift.getGifid());
		}
		//礼物图片
		Future<List<GifPicture>> gifPictures=this.gifPictures(gifids);
		Map<String,Object> map=new HashMap<String,Object>();
		for(Collect collect:collects){
			List<Map<String,Object>> pacCategorysByCollect=new ArrayList<Map<String,Object>>();
			for(PacCategory pacCategory:pacCategorys.get()){
				Map<String,Object> pacCategoryByCollect=new HashMap<String,Object>();
				ProOuter:for(ProductDTO product:products.get()){
					//找到匹配的收藏优选包记录
					for(ColPacket colPacket:colPackets){
						if(colPacket.getColid()==collect.getColid()&&colPacket.getCatid()==pacCategory.getCategoryid()){
							if(colPacket.getProid()==0){
								//终止产品循环
								break ProOuter;
							}
						}
					}
					if(product.getCatid()==pacCategory.getCategoryid()){
						for(PictureDTO picture:pictures.get()){
							if(picture.getProid()==product.getProid()&&product.getPictures().isEmpty()){
								product.getPictures().add(picture);
								break;
							}
						}
						//装载产品礼品
						for(PacProduct pacProduct:pacProducts.get()){
							if(pacProduct.getProductid()==product.getProid()){
								for(Gift gift:gifts.get()){
									if(gift.getGifid()==pacProduct.getGifid()){
										GiftDTO giftDTO=new GiftDTO();
										BeanUtils.copyProperties(gift,giftDTO);
										//装载礼物图片
										for(GifPicture gifPicture:gifPictures.get()){
											if(gifPicture.getGifid()==gift.getGifid()){
												giftDTO.getGifPictures().add(gifPicture);
												break;
											}
										}
										product.setGiftDTO(giftDTO);
										break;
									}
								}
								break;
							}
						}
						//装载优选包类目产品
						pacCategoryByCollect.put("product",product);
						break;
					}
				}
				//装载优选包类目
				if(pacCategory.getPacid()==collect.getPacid()){
					pacCategoryByCollect.put("category",pacCategory);
					pacCategorysByCollect.add(pacCategoryByCollect);
				}
			}
			map.put(new Gson().toJson(collect),pacCategorysByCollect);
		}
		return map;
	}
	
	@Async
	private Future<List<ProductDTO>> products(List<Long> proids){
		if(proids.isEmpty()){
			return new AsyncResult<List<ProductDTO>>(null);
		}
		List<ProductDTO> products=productService.listByProids(proids);
		return new AsyncResult<List<ProductDTO>>(products);
	}
	
	@Async
	private Future<List<PacCategory>> pacCategory(List<Long> catids){
		if(catids.isEmpty()){
			return new AsyncResult<List<PacCategory>>(null);
		}
		List<PacCategory> pacCategorys=pacCategoryRepository.findByCategoryids(catids);
		return new AsyncResult<List<PacCategory>>(pacCategorys);
	}
	
	@Async
	private Future<List<PictureDTO>> pictures(List<Long> proids){
		if(proids.isEmpty()){
			return new AsyncResult<List<PictureDTO>>(null);
		}
		List<PictureDTO> pictures=pictureService.listByProids(proids);
		return new AsyncResult<List<PictureDTO>>(pictures);
	}
	
	@Async
	private Future<List<PacProduct>> pacProducts(List<Long> proids){
		if(proids.isEmpty()){
			return new AsyncResult<List<PacProduct>>(null);
		}
		List<PacProduct> pacProducts=pacProductRepository.findByProductids(proids);
		return new AsyncResult<List<PacProduct>>(pacProducts);
	}
	
	@Async
	private Future<List<Gift>> gifts(List<Long> proids){
		if(proids.isEmpty()){
			return new AsyncResult<List<Gift>>(null);
		}
		List<Gift> gifts=giftRepository.findByProids(proids);
		return new AsyncResult<List<Gift>>(gifts);
	}
	
	@Async
	private Future<List<GifPicture>> gifPictures(List<Long> gifids){
		if(gifids.isEmpty()){
			return new AsyncResult<List<GifPicture>>(null);
		}
		List<GifPicture> gifPictures=gifPictureRepository.findByTypeAndGifids(0,gifids);
		return new AsyncResult<List<GifPicture>>(gifPictures);
	}

	@Override
	public void delByColid(long colid) {
		collectRepository.delete(colid);
		colPacketRepository.deleteByColid(colid);
	}
}
