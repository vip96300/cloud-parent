package org.cloud.packet.server.service.impl;

import java.util.List;

import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.repository.PacCategoryRepository;
import org.cloud.packet.server.service.PacCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PacCategoryServiceImpl implements PacCategoryService{

	@Autowired
	private PacCategoryRepository pacCategoryRepository;
	
	@Override
	public void add(PacCategory pacCategory) {
		pacCategory.setTime(System.currentTimeMillis());
		pacCategoryRepository.save(pacCategory);
	}

	@Override
	public void delByCatid(long catid) {
		pacCategoryRepository.delete(catid);
	}

	@Override
	public List<PacCategory> listByPacid(long pacid) {
		List<PacCategory> pacCategory=pacCategoryRepository.findByPacid(pacid);
		return pacCategory;
	}

	@Override
	public PacCategory getByCategoryid(long categoryid) {
		PacCategory pacCategory=pacCategoryRepository.findByCategoryid(categoryid);
		return pacCategory;
	}

	@Override
	public PacCategory getByCatid(long catid) {
		PacCategory pacCateogyr=pacCategoryRepository.findOne(catid);
		return pacCateogyr;
	}

	@Override
	public void updByCatid(PacCategory pacCategory) {
		pacCategoryRepository.saveAndFlush(pacCategory);
	}

}
