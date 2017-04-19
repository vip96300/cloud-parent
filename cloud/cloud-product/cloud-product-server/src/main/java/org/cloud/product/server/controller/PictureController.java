package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.product.server.model.Picture;
import org.cloud.product.server.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	
	@RequestMapping(value="/list_proid",method=RequestMethod.GET)
	public List<Picture> list_proid(@RequestParam(value="proid",required=true)long proid){
		logger.debug(this.getClass().getName());
		List<Picture> pictures=pictureService.listByProId(proid);
		return pictures;
	}
}
