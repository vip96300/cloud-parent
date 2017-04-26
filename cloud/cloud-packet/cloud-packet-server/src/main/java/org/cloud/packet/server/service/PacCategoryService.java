package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.PacCategory;

public interface PacCategoryService {
	
	public void add(PacCategory pacCategory);
	
	public void delByCatid(long catid);
	
	public List<PacCategory> listByPacid(long pacid);
}
