package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Product;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	
	/**
	 * 根据类目编号获取产品列表
	 * @param catid
	 * @return
	 */
	public List<Product> listByCatid(long catid,Pageable pageable);
}
