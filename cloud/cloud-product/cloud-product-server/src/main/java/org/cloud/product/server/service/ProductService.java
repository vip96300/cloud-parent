package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {
	
	/**
	 * 添加产品
	 * @param product
	 */
	@Transactional(rollbackFor=Exception.class)
	public void add(Product product);
	
	/**
	 * 根据类目编号获取产品列表
	 * @param catid
	 * @return
	 */
	public List<Product> listByCatid(long catid,Pageable pageable);
	
	/**
	 * 根据产品编号获取产品
	 * @param proid
	 * @return
	 */
	public Product getByProid(long proid);
	
	/**
	 * 根据产品编号集合获取产品列表
	 * @param proids
	 * @return
	 */
	public List<Product> listByProids(List<Long> proids);
	/**
	 * 修改产品
	 * @param product
	 */
	public void updByProid(Product product);
	/**
	 * 删除产品
	 * @param proid
	 */
	public void delByProid(long proid);
}
