package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.product.client.controller.dto.Result;
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
	
	@ApiOperation(value="根据产品获取图片列表")
	@ApiImplicitParams({@ApiImplicitParam(name="产品编号",value="proid",required=true,dataType="long")})
	@RequestMapping(value="/list_proid",method=RequestMethod.GET)
	public Result<List> list_proId(@RequestParam(value="proid",required=true)long proid){
		List<Picture> pictures=pictureService.listByProid(proid);
		return new Result<List>(200,null,pictures);
	}
}
