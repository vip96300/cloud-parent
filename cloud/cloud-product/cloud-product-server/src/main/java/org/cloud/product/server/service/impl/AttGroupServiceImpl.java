package org.cloud.product.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.AttGroup;
import org.cloud.product.server.model.AttValue;
import org.cloud.product.server.model.Attribute;
import org.cloud.product.server.repository.AttGroupRepository;
import org.cloud.product.server.repository.AttValueRepository;
import org.cloud.product.server.repository.AttributeRepository;
import org.cloud.product.server.repository.PropertyRepository;
import org.cloud.product.server.service.AttGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttGroupServiceImpl implements AttGroupService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AttGroupRepository attGroupRepository;
	@Autowired
	private AttributeRepository attributeRepository;
	@Autowired
	private AttValueRepository attValueRepository;
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public List<Map<AttGroup, List<Object>>> listAttributesAttValuesByCatid(long catid) {
		List<AttGroup> attGroups=attGroupRepository.findByCatid(catid);
		if(attGroups.isEmpty()){
			return null;
		}
		List<Attribute> attributes=attributeRepository.findByCatid(catid);
		if(attributes.isEmpty()){
			return null;
		}
		List<AttValue> attValues=attValueRepository.findByCatid(catid);
		//属性组集合<属性组名称：属性集合<属性：属性值集合>>
		List<Map<AttGroup,List<Object>>> attGroupsAttributes=new ArrayList<Map<AttGroup,List<Object>>>();
		for(AttGroup attGroup:attGroups){
			//属性组：属性集合
			Map<AttGroup,List<Object>> attGroupAttributesMap=new HashMap<AttGroup,List<Object>>();
			//属性集合<属性：属性值集合>
			List<Object> attributesByAttGroup=new ArrayList<Object>();
			//属性：属性值
			Map<Attribute,List<AttValue>> attributeAttValues=new HashMap<Attribute,List<AttValue>>();
			for(Attribute attribute:attributes){
				if(attribute.getGroid()==attGroup.getGroid()){
					List<AttValue> attValuesByAttribute=null;
					if(attribute.getType()!=Attribute.T0){
						attValuesByAttribute=new ArrayList<AttValue>();
						for(AttValue attValue:attValues){
							if(attValue.getAttid()==attribute.getAttid()){
								attValuesByAttribute.add(attValue);
							}
						}
					}
					attributeAttValues.put(attribute, attValuesByAttribute);
					attributesByAttGroup.add(attributeAttValues);
				}
			}
			attGroupAttributesMap.put(attGroup,attributesByAttGroup);
			attGroupsAttributes.add(attGroupAttributesMap);
		}
		return attGroupsAttributes;
	}

	@Override
	public void add(AttGroup attGroup) {
		attGroup.setTime(System.currentTimeMillis());
		attGroupRepository.save(attGroup);
	}

	@Override
	public AttGroup getByGroid(long groid) {
		AttGroup attGroup=attGroupRepository.findOne(groid);
		return attGroup;
	}
	
	/**
	 * 需要先删除产品属性才删除属性，不然会找不到属性删除不掉产品属性
	 */
	@Override
	public void delByGroid(long groid) {
		attGroupRepository.delete(groid);
		propertyRepository.deleteByGroid(groid);
		attributeRepository.deleteByGroid(groid);
	}

	@Override
	public void updByGroid(AttGroup attGroup) {
		attGroupRepository.saveAndFlush(attGroup);
	}
}
