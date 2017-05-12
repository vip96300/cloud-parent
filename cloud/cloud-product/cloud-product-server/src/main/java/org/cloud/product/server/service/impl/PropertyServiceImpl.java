package org.cloud.product.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.model.Property;
import org.cloud.product.server.repository.AttValueRepository;
import org.cloud.product.server.repository.PropertyRepository;
import org.cloud.product.server.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
@Service
public class PropertyServiceImpl implements PropertyService{
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private AttValueRepository attValueRepository;
	@Override
	public Map<String,List<AttValue>> listAttValuesByProductid(long productid) {
		List<Property> propertys=propertyRepository.findByProductid(productid);
		List<AttValue> attValues=attValueRepository.findByProid(productid);
		//产品属性：属性值集合
		Map<String,List<AttValue>> propertyAttValues=new HashMap<String,List<AttValue>>();
		for(Property property:propertys){
			//属性值集
			List<AttValue> attValuesByProperty=new ArrayList<AttValue>();
			for(AttValue attValue:attValues){
				if(property.getAttid()==attValue.getAttid()){
					attValuesByProperty.add(attValue);
				}
			}
			propertyAttValues.put(new Gson().toJson(property), attValuesByProperty);
		}
		return propertyAttValues;
	}
	@Override
	public Property getByProid(long proid) {
		Property property=propertyRepository.getOne(proid);
		return property;
	}
	@Override
	public void updByProid(Property property) {
		propertyRepository.saveAndFlush(property);
	}
}
