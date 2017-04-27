package org.cloud.product.server.service;

import java.util.List;
import java.util.Map;

import org.cloud.product.server.model.Keyword;
import org.cloud.product.server.model.Search;
import org.springframework.transaction.annotation.Transactional;

public interface SearchService {
	/**
	 * 添加
	 * @param catid
	 * @param name
	 */
	public void add(Search search);
	
	/**
	 * 获取列表及以下关键字
	 * @param catid
	 * @return
	 */
	public List<Map<String,List<Keyword>>> listKeywordsByCatid(long catid);
	
	/**
	 * 根据编号获取
	 * @param catid
	 * @return
	 */
	public Search getBySeaid(long seaid);
	
	/**
	 * 修改
	 * @param seaid
	 * @param name
	 */
	public void updBySeaid(Search search);
	
	/**
	 * 删除
	 * @param seaid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delBySeaid(long seaid);
}
