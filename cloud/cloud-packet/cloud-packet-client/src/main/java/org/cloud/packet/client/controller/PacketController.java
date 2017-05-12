package org.cloud.packet.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.model.Picture;
import org.cloud.packet.client.model.Product;
import org.cloud.packet.client.service.PacketService;
import org.cloud.packet.client.service.PictureService;
import org.cloud.packet.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/packet")
public class PacketController {
	
	
	@Autowired
	private PacketService packetService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PictureService pictureService;
	
	@ApiOperation(value="添加优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="name",value="优选包名称",required=true,dataType="String"),
		@ApiImplicitParam(name="title",value="标题",required=true,dataType="String"),
		@ApiImplicitParam(name="depict",value="优选包描述",required=true,dataType="String"),
		@ApiImplicitParam(name="surface",value="封面图",required=true,dataType="String"),
		@ApiImplicitParam(name="banner",value="横幅图片",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="name",required=true)String name,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="depict",required=true)String depict,
			@RequestParam(value="surface",required=true)String surface,
			@RequestParam(value="banner",required=true)String banner){
		Packet packet=new Packet();
		packet.setName(name);
		packet.setTitle(title);
		packet.setDepict(depict);
		packet.setSurface(surface);
		packet.setBanner(banner);
		packetService.add(packet);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="修改优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="优选包名称",required=true,dataType="String"),
		@ApiImplicitParam(name="title",value="标题",required=true,dataType="String"),
		@ApiImplicitParam(name="depict",value="优选包描述",required=true,dataType="String"),
		@ApiImplicitParam(name="surface",value="封面图",required=true,dataType="String"),
		@ApiImplicitParam(name="banner",value="横幅图片",required=true,dataType="String")})
	@RequestMapping(value="/upd_pacid",method=RequestMethod.POST)
	public Result<Object> upd_pacid(@RequestParam(value="pacid",required=true)long pacid,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="depict",required=true)String depict,
			@RequestParam(value="surface",required=true)String surface,
			@RequestParam(value="banner",required=true)String banner){
		Packet packet=packetService.getByPacid(pacid);
		if(!ValidUtil.isValid(packet)){
			return null;
		}
		packet.setName(name);
		packet.setTitle(title);
		packet.setDepict(depict);
		packet.setSurface(surface);
		packet.setBanner(banner);
		packetService.updByPacid(packet);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据编号删除优选包，级联删除该优选包图片列表，及该优选包下所有类目")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long")})
	@RequestMapping(value="del_pacid",method=RequestMethod.POST)
	public Result<Object> del_pacid(@RequestParam(value="pacid",required=true)long pacid){
		packetService.delByPacid(pacid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="优选包列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页显示数",required=true,dataType="int")})
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Result<List<Packet>> list(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<Packet> packets=packetService.list(page,size);
		return new Result<List<Packet>>(200,null,packets);
	}
	
	@ApiOperation(value="获取某个优选包")
	@ApiImplicitParams({})
	@RequestMapping(value="/list_some",method={RequestMethod.GET,RequestMethod.POST})
	public Result<List<Packet>> list_some(){
		List<Packet> packets=packetService.listBySome();
		return new Result<List<Packet>>(200,null,packets);
	}

	@ApiOperation(value="/根据优选包编号获取优选包及该优选包类目集合")
	@ApiImplicitParams({})
	@RequestMapping(value="/packet_pacCategorys",method={RequestMethod.GET,RequestMethod.POST})
	public Result<Map> packet_pacCategorys(){
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,List<PacCategory>> packetPacCategorys=packetService.packetPacCategorys();
		//获取类目编号集合
		List<Long> proids=new ArrayList<Long>();
		for(Map.Entry<String,List<PacCategory>> packetMap:packetPacCategorys.entrySet()){
			for(PacCategory pacCategory:packetMap.getValue()){
				if(pacCategory.getProid()!=0){
					proids.add(pacCategory.getProid());
				}
			}
		}
		if(!proids.isEmpty()){
			List<Product> products=productService.listByProids(proids);
			List<Picture> pictures=pictureService.listByTypeProids(0, proids);
			for(Map.Entry<String,List<PacCategory>> packetMap:packetPacCategorys.entrySet()){
				for(PacCategory pacCategory:packetMap.getValue()){
					if(pacCategory.getProid()!=0){
						for(Product product:products){
							if(pacCategory.getProid()==product.getProid()){
								pacCategory.setProduct(product);
							}
							//如果图片为空
							if(pictures.isEmpty()){
								continue;
							}
							List<Picture> picturesByProduct=new ArrayList<Picture>();
							for(Picture picture:pictures){
								if(product.getProid()==picture.getProid()){
									picturesByProduct.add(picture);
									break;
								}
							}
							product.setPictures(picturesByProduct);
						}
					}
				}
			}
		}
		
		List<Packet> packets=packetService.list(0,5);
		map.put("packet",packetPacCategorys);
		map.put("packets",packets);
		return new Result<Map>(200,null,map);
	}
	
	@ApiOperation(value="优选包列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页数",required=true,dataType="int")})
	@RequestMapping(value="/list_objs",method=RequestMethod.POST)
	public Result<List<Map<String,Object>>> list_objs(@RequestParam(value="page",required=true)int page,
			@RequestParam(value="size",required=true)int size){
		List<Map<String,Object>> map=packetService.listByObjs(page,size);
		return new Result<List<Map<String,Object>>>(200,null,map);
	}
	
	@ApiOperation(value="获取优选包详情")
	@ApiImplicitParams({@ApiImplicitParam(name="pacid",value="优选包编号",required=true,dataType="long")})
	@RequestMapping(value="/get_pacCategorys_pacid",method={RequestMethod.GET,RequestMethod.POST})
	public Result<Map> get_pacCategorys_catid(@RequestParam(value="pacid",required=true)long pacid){
		Map<String,List<PacCategory>> packetPacCategorys=packetService.packetPacCategorysByPacid(pacid);
		//获取类目编号集合
		List<Long> proids=new ArrayList<Long>();
		for(Map.Entry<String,List<PacCategory>> packetMap:packetPacCategorys.entrySet()){
			for(PacCategory pacCategory:packetMap.getValue()){
				if(pacCategory.getProid()!=0){
					proids.add(pacCategory.getProid());
				}
			}
		}
		if(!proids.isEmpty()){
			List<Product> products=productService.listByProids(proids);
			List<Picture> pictures=pictureService.listByTypeProids(0, proids);
			for(Map.Entry<String,List<PacCategory>> packetMap:packetPacCategorys.entrySet()){
				for(PacCategory pacCategory:packetMap.getValue()){
					if(pacCategory.getProid()!=0){
						for(Product product:products){
							if(pacCategory.getProid()==product.getProid()){
								pacCategory.setProduct(product);
							}
							//如果图片为空
							if(pictures.isEmpty()){
								continue;
							}
							List<Picture> picturesByProduct=new ArrayList<Picture>();
							for(Picture picture:pictures){
								if(product.getProid()==picture.getProid()){
									picturesByProduct.add(picture);
									break;
								}
							}
							product.setPictures(picturesByProduct);
						}
					}
				}
			}
		}
		return new Result<Map>(200,null,packetPacCategorys);
	}
}
