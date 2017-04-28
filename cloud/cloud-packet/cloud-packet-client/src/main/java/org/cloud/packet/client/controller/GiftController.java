package org.cloud.packet.client.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.model.Gift;
import org.cloud.packet.client.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/gift")
public class GiftController {
	
	@Autowired
	private GiftService giftService;
	
	@ApiOperation(value="添加礼物")
	@ApiImplicitParams({@ApiImplicitParam(name="name",required=true,dataType="String")})
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Result<Object> add(@RequestParam(value="name",required=true)String name){
		Gift gift=new Gift();
		gift.setName(name);
		giftService.add(gift);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="获取礼物列表")
	@ApiImplicitParams({@ApiImplicitParam(name="page",value="当前页",required=true,dataType="int"),
		@ApiImplicitParam(name="size",value="每页显示数",required=true,dataType="int")})
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Result<List<Gift>> list(@RequestParam(value="page",required=true)int page,@RequestParam(value="size",required=true)int size){
		List<Gift> gifts=giftService.list(page,size);
		return new Result<List<Gift>>(200,null,gifts);
	}
	
	@ApiOperation(value="修改礼物")
	@ApiImplicitParams({@ApiImplicitParam(name="gifid",value="礼物编号",required=true,dataType="long"),
		@ApiImplicitParam(name="name",value="礼物名称",required=true,dataType="String")})
	@RequestMapping(value="/upd_gifid",method=RequestMethod.POST)
	public Result<Object> upd_gifid(@RequestParam(value="gifid",required=true)long gifid ,@RequestParam(value="name",required=true)String name){
		Gift gift=giftService.getByGifid(gifid);
		if(!ValidUtil.isValid(gift)){
			return null;
		}
		gift.setName(name);
		giftService.updByGifid(gift);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="根据编号删除礼物，会级联删除礼物图片")
	@ApiImplicitParams({@ApiImplicitParam(name="gifid",value="礼物编号",required=true,dataType="long")})
	@RequestMapping(value="/del_gifid",method=RequestMethod.POST)
	public Result<Object> del_gifid(@RequestParam(value="gifid",required=true)long gifid){
		giftService.delByGifid(gifid);
		return new Result<Object>(200,null,null);
	}
}
