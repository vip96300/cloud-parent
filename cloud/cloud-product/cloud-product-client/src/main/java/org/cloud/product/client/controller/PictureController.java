package org.cloud.product.client.controller;

import java.util.List;

import org.cloud.product.client.model.Picture;
import org.cloud.product.client.service.PictureService;
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
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/list_proId",method=RequestMethod.GET)
	public List<Picture> list_proId(@RequestParam(value="proId")long proId){
		List<Picture> pictures=pictureService.listByProId(proId);
		return pictures;
	}
}
