package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.PacProduct;

public interface PacProductService {

	public void add(PacProduct pacProduct);
	
	public void delByProductid(long productid);
	
	public List<PacProduct> list(int page,int size);
	/**
	 * 根据类目编号获取产品集合
	 * @param catid
	 * @param page
	 * @param size
	 * @return
	 */
	public List<PacProduct> listByCatid(long catid,int page,int size);
}
