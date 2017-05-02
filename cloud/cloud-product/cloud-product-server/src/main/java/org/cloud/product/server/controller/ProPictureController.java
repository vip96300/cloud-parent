package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.ProPicture;
import org.cloud.product.server.model.Product;
import org.cloud.product.server.service.ProPictureService;
import org.cloud.product.server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/product/picture")
public class ProPictureController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProPictureService pictureService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/list_proid",method=RequestMethod.GET)
	public List<ProPicture> list_proid(@RequestParam(value="proid",required=true)long proid){
		List<ProPicture> pictures=pictureService.listByProid(proid);
		return pictures;
	}

	@RequestMapping(value="/product/product/picture/list_proid_type",method=RequestMethod.GET)
	public List<ProPicture> list_proid_type(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="type",required=true)int type){
		List<ProPicture> pictures=pictureService.listByProidType(proid,type);
		return pictures;
	}
	
	@RequestMapping(value="/product/product/picture/get_picid",method=RequestMethod.GET)
	public ProPicture get_picid(@RequestParam(value="picid",required=true)long picid){
		ProPicture picture=pictureService.getByPicid(picid);
		return picture;
	}
	@Async
	@RequestMapping(value="/product/product/picture/add",method=RequestMethod.POST)
	public void add(@RequestBody ProPicture picture){
		Product product=productService.getByProid(picture.getProid());
		if(!ValidUtil.isValid(product)){
			return;
		}
		pictureService.add(picture);
	}
	@Async
	@RequestMapping(value="/product/product/picture/del_picid",method=RequestMethod.DELETE)
	public void delByPicid(@RequestParam(value="picid",required=true)long picid){
		pictureService.delByPicid(picid);
	}
	@Async
	@RequestMapping(value="/product/product/picture/upd_picid",method=RequestMethod.PUT)
	public void updByPicid(@RequestBody ProPicture picture){
		ProPicture hasPicture=pictureService.getByPicid(picture.getPicid());
		if(!ValidUtil.isValid(hasPicture)){
			return;
		}
		pictureService.updByPicid(picture);
	}
}
