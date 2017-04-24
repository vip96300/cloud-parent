package org.cloud.product.server.service;

import org.cloud.product.server.model.Keyword;
import org.springframework.transaction.annotation.Transactional;

public interface KeywordService {
	/**
	 * 添加
	 * @param keyword
	 */
	public void add(Keyword keyword);
	
	/**
	 * 根据编号获取
	 * @param keyid
	 * @return
	 */

	public Keyword getByKeyid(long keyid);
	
	/**
	 * 修改
	 * @param keyword
	 */
	public void updByKeyid(Keyword keyword);
	
	/**
	 * 根据编号删除
	 * @param keyid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delByKeyid(long keyid);
}
