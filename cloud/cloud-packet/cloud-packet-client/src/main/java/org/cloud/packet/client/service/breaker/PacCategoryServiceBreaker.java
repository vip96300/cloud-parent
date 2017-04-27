package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.model.PacCategory;
import org.cloud.packet.client.service.PacCategoryService;
import org.springframework.stereotype.Component;
@Component
public class PacCategoryServiceBreaker implements PacCategoryService{

	@Override
	public void add(PacCategory pacCategory) {
		throw new RuntimeException();
	}

	@Override
	public void delByCatid(long catid) {
		throw new RuntimeException();
	}

	@Override
	public List<PacCategory> listByPacid(long pacid) {
		throw new RuntimeException();
	}

}
