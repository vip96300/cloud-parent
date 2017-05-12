package org.cloud.product.server.controller;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.model.Property;
import org.cloud.product.server.service.PropertyService;
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
@RequestMapping(value="/product/product/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(value="/list_attValues_productid",method=RequestMethod.GET)
	public Map<String,List<AttValue>> list_attValues_productid(@RequestParam(value="productid",required=true)long productid){
		Map<String,List<AttValue>> propertyAttValues=propertyService.listAttValuesByProductid(productid);
		return propertyAttValues;
	}
	
	@RequestMapping(value="/get_proid",method=RequestMethod.GET)
	public Property get_proid(@RequestParam(value="proid",required=true)long proid) {
		Property property=propertyService.getByProid(proid);
		return property;
	}

	@Async
	@RequestMapping(value="/upd_proid",method=RequestMethod.PUT)
	public void upd_proid(@RequestBody Property property) {
		propertyService.updByProid(property);
	}
}
