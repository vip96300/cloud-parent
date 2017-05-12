package org.cloud.product.server.controller;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.service.AttValueService;
import org.cloud.product.server.service.AttributeService;
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
@RequestMapping(value="/product/category/attribute/attValue")
public class AttValueController {

	@Autowired
	private AttValueService attValueService;
	@Autowired
	private AttributeService attributeService;
	@Async
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public void add(@RequestBody AttValue attValue){
		Attribute attribute=attributeService.getByAttid(attValue.getAttid());
		if(!ValidUtil.isValid(attribute)){
			return;
		}
		if(attribute.getType()==Attribute.T0){
			//文本无属性集
			return;
		}
		attValue.setCatid(attribute.getCatid());
		attValueService.add(attValue);
	}
	
	@RequestMapping(value="/list_attid",method=RequestMethod.GET)
	public List<AttValue> list_attid(@RequestParam(value="attid",required=true)long attid) {
		List<AttValue> attValues=attValueService.listByAttid(attid);
		return attValues;
	}
	
	@RequestMapping(value="/get_valid",method=RequestMethod.GET)
	public AttValue get_valid(@RequestParam(value="valid",required=true)long valid){
		AttValue attValue=attValueService.getByValid(valid);
		return attValue;
	}
	@Async
	@RequestMapping(value="/del_valid",method={RequestMethod.DELETE})
	public void del_valid(@RequestParam(value="valid",required=true)long valid){
		attValueService.delByValid(valid);
	}
	@Async
	@RequestMapping(value="/upd_valid",method={RequestMethod.PUT})
	public void upd_valid(@RequestBody AttValue attValue){
		attValueService.updByValid(attValue);
	}
}
