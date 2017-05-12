package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.Keyword;
import org.springframework.transaction.annotation.Transactional;

public interface KeywordService {
	/**
	 * 添加
	 * @param keyword
	 */
	public void add(Keyword keyword);
	/**
	 * 根据搜索编号获取关键字集合
	 * @param seaid
	 * @return
	 */
	public List<Keyword> listBySeaid(long seaid);
	/**
	 * 根据类目编号获取关键字集合
	 * @param catid
	 * @return
	 */
	public List<Keyword> listByCatid(long catid);
	
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
