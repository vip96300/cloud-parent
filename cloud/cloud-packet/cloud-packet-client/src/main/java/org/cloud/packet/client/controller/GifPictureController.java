package org.cloud.packet.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.GifPicture;
import org.cloud.packet.client.service.GifPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/gift/picture")
public class GifPictureController {
	
	@Autowired
	private GifPictureService gifPictureService;
	
	
	@ApiOperation(value="添加礼物图片")
	@ApiImplicitParams({@ApiImplicitParam(name="gifid",value="礼物编号",required=true,dataType="long"),
		@ApiImplicitParam(name="type",value="图片类型",required=true,dataType="int"),
		@ApiImplicitParam(name="url",value="路径",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="gifid",required=true)long gifid,
			@RequestParam(value="type",required=true)int type,
			@RequestParam(value="url",required=true)String url){
		GifPicture gifPicture=new GifPicture();
		gifPicture.setGifid(gifid);
		gifPicture.setType(type);
		gifPicture.setUrl(url);
		gifPictureService.add(gifPicture);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据礼物编号获取礼物图片集合")
	@ApiImplicitParams({@ApiImplicitParam(name="gifid",value="礼物编号",required=true,dataType="long")})
	@RequestMapping(value="/list_gifid",method=RequestMethod.POST)
	public Result<List<GifPicture>> list_gifid(@RequestParam(value="gifid",required=true)long gifid){
		List<GifPicture> gifPictures=gifPictureService.listByGifid(gifid);
		return new Result<List<GifPicture>>(200,null,gifPictures);
	}
	
	@ApiOperation(value="删除礼物图片")
	@ApiImplicitParams({@ApiImplicitParam(name="picid",value="图片编号",required=true,dataType="long")})
	@RequestMapping(value="/del_picid",method=RequestMethod.POST)
	public Result<Object> del_picid(@RequestParam(value="picid",required=true)long picid){
		gifPictureService.delByPicid(picid);
		return new Result<Object>(200,null,null);
	}
}
