package org.cloud.packet.client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.packet.client.controller.dto.Result;
import org.cloud.packet.client.service.ColPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/packet/collect/packet")
public class ColPacketController {
	
	@Autowired
	private ColPacketService colPacketService;
	
	@ApiOperation(value="修改我收藏的优选包")
	@ApiImplicitParams({@ApiImplicitParam(name="colid",value="收藏编号",required=true,dataType="long"),
		@ApiImplicitParam(name="catid",value="类目编号",required=true,dataType="long"),
		@ApiImplicitParam(name="proid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/upd_colid",method=RequestMethod.POST)
	public Result<Object> upd_colid(@RequestParam(value="colid",required=true)long colid,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="proid",required=true)long proid){
		colPacketService.updByColid(colid, catid, proid);
		return new Result<Object>(200,null,null);
	}
}
