package org.cloud.product.client.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.client.controller.dto.Result;
import org.cloud.product.client.model.AttValue;
import org.cloud.product.client.model.Property;
import org.cloud.product.client.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/product/product/property")
public class PropertyController {
	
	
	@Autowired
	private PropertyService propertyService;
	
	@ApiOperation(value="修改产品属性")
	@ApiImplicitParams({@ApiImplicitParam(name="proid",value="产品属性编号",required=true,dataType="long"),
		@ApiImplicitParam(name="value",value="属性值",required=true,dataType="String")})
	@RequestMapping(value="/upd_proid",method=RequestMethod.POST)
	public Result<Object> upd_proid(@RequestParam(value="proid",required=true)long proid,
			@RequestParam(value="value",required=true)String value){
		Property property=propertyService.getByProid(proid);
		if(!ValidUtil.isValid(property)){
			return null;
		}
		property.setValue(value);
		propertyService.updByProid(property);
		return new Result<Object>(200,null,null);
	}
	
	@ApiOperation(value="获取产品属性及属性选项集合")
	@ApiImplicitParams({@ApiImplicitParam(name="productid",value="产品编号",required=true,dataType="long")})
	@RequestMapping(value="/list_attValues_productid",method=RequestMethod.POST)
	public Result<Map> list_attValues_productid(@RequestParam(value="productid",required=true)long productid){
		Map<String,List<AttValue>> propertyAttValues=propertyService.listAttValuesByProductid(productid);
		return new Result<Map>(200,null,propertyAttValues);
	}
	
	
}
