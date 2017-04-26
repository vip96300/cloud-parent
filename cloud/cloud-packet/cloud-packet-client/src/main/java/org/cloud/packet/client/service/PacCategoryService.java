package org.cloud.packet.client.service;

import java.util.List;

import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.service.breaker.PacCategoryServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=PacCategoryServiceBreaker.class)
public interface PacCategoryService {
	
	@RequestMapping(value="/packet/category/add",method=RequestMethod.POST)
	public void add(@RequestBody PacCategory pacCategory);
	
	@RequestMapping(value="/packet/category/del_catid",method=RequestMethod.DELETE)
	public void delByCatid(@RequestParam(value="catid",required=true)long catid);
	
	@RequestMapping(value="/packet/category/list_pacid",method=RequestMethod.GET)
	public List<PacCategory> listByPacid(@RequestParam(value="pacid",required=true)long pacid);
}
