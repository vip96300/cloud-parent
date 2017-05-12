package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.PacCategory;

public interface PacCategoryService {
	
	public void add(PacCategory pacCategory);
	
	public void delByCatid(long catid);
	
	public List<PacCategory> listByPacid(long pacid);
	
	/**
	 * 根据类目编号获取优选包的类目
	 * @param categoryid
	 * @return
	 */
	public PacCategory getByCategoryid(long categoryid);
	
	public PacCategory getByCatid(long catid);
	
	public void updByCatid(PacCategory pacCategory);
}
