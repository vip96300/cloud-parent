package org.cloud.product.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.ProPicture;
import org.cloud.product.client.model.Product;
import org.cloud.product.client.service.ProPictureService;
import org.cloud.product.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/product/picture")
public class ProPictureController {
	
	@Autowired
	private ProPictureService pictureService;
	
	@ApiOperation(value="根据产品获取图片列表")
	@ApiImplicitParams({@ApiImplicitParam(name="产品编号",value="proid",required=true,dataType="long")})
	@RequestMapping(value="/list_proid",method=RequestMethod.POST)
	public Result<List> list_proId(@RequestParam(value="proid",required=true)long proid){
		List<ProPicture> pictures=pictureService.listByProid(proid);
		return new Result<List>(200,null,pictures);
	}
	
	@ApiOperation(value="根据产品编号和图片类型获取产品图片列表")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
			@ApiImplicitParam(name="type",value="产品图片类型",required=true,dataType="int")})
	@RequestMapping(value="/list_proid_type",method=RequestMethod.POST)
	public Result<List> list_proid_type(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="type",required=true)int type){
		List<ProPicture> pictures=pictureService.listByProidType(proid,type);
		return new Result<List>(200,null,pictures);
	}
	
	@ApiOperation(value="添加产品图片")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long"),
		@ApiImplicitParam(name="type",value="图片类型0效果图，1封面，2列表图",required=true,dataType="int")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="type",required=true)int type){
		ProPicture picture=new ProPicture();
		picture.setProid(proid);
		picture.setType(type);
		pictureService.add(picture);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据编号删除产品图片")
	@ApiImplicitParams({@ApiImplicitParam(name="picid",value="产品图片编号",required=true,dataType="long")})
	@RequestMapping(value="/del_picid",method=RequestMethod.POST)
	public Result<Object> del_picid(@RequestParam(value="picid",required=true)long picid){
		pictureService.delByPicid(picid);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据图片编号删除图片")
	@ApiImplicitParams({@ApiImplicitParam(name="picid",value="图片编号",required=true,dataType="long"),
		@ApiImplicitParam(name="url",value="图片路径",required=true,dataType="String")})
	@RequestMapping(value="upd_picid",method=RequestMethod.POST)
	public Result<Object> upd_picid(@RequestParam(value="picid",required=true)long picid,
			@RequestParam(value="url",required=true)String url){
		ProPicture proPicture=new ProPicture();
		proPicture.setPicid(picid);
		proPicture.setUrl(url);
		pictureService.updByPicid(proPicture);
		return new Result<Object>(200,null,null);
	}
}
