package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.Picture;
import org.cloud.product.server.model.Product;
import org.cloud.product.server.service.PictureService;
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
public class PictureController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PictureService pictureService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/list_proid",method=RequestMethod.GET)
	public List<Picture> list_proid(@RequestParam(value="proid",required=true)long proid){
		List<Picture> pictures=pictureService.listByProid(proid);
		return pictures;
	}

	@RequestMapping(value="/list_proid_type",method=RequestMethod.GET)
	public List<Picture> list_proid_type(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="type",required=true)int type){
		List<Picture> pictures=pictureService.listByProidType(proid,type);
		return pictures;
	}
	
	@RequestMapping(value="/get_picid",method=RequestMethod.GET)
	public Picture get_picid(@RequestParam(value="picid",required=true)long picid){
		Picture picture=pictureService.getByPicid(picid);
		return picture;
	}
	@Async
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(@RequestBody Picture picture){
		Product product=productService.getByProid(picture.getProid());
		if(!ValidUtil.isValid(product)){
			return;
		}
		pictureService.add(picture);
	}
	@Async
	@RequestMapping(value="/del_picid",method=RequestMethod.DELETE)
	public void del_picid(@RequestParam(value="picid",required=true)long picid){
		pictureService.delByPicid(picid);
	}
	@Async
	@RequestMapping(value="/upd_picid",method=RequestMethod.PUT)
	public void upd_picid(@RequestBody Picture picture){
		pictureService.updByPicid(picture);
	}
	
	@RequestMapping(value="/list_proids",method=RequestMethod.GET)
	public List<Picture> list_proids(@RequestParam(value="proids",required=true)List<Long> proids) {
		List<Picture> pictures=pictureService.listByProids(proids);
		return pictures;
	}
	
	@RequestMapping(value="/list_type_proids",method=RequestMethod.GET)
	public List<Picture> list_type_proids(@RequestParam(value="type",required=true)int type,
			@RequestParam(value="proids",required=true)List<Long> proids) {
		List<Picture> pictures=pictureService.listByTypeProids(type,proids);
		return pictures;
	}
}
