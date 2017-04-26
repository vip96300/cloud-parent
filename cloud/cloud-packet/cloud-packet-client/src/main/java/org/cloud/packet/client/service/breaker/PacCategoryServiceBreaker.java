package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.service.PacCategoryService;
import org.springframework.stereotype.Component;
@Component
public class PacCategoryServiceBreaker implements PacCategoryService{

	@Override
	public void add(PacCategory pacCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByCatid(long catid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PacCategory> listByPacid(long pacid) {
		// TODO Auto-generated method stub
		return null;
	}

}
