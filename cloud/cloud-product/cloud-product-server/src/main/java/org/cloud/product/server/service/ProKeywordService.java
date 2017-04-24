package org.cloud.product.server.service;

import java.util.List;

import org.cloud.product.server.model.ProKeyword;
import org.springframework.transaction.annotation.Transactional;

public interface ProKeywordService {
	/**
	 * 批量添加
	 * @param proKeywords
	 */
	public void add(List<ProKeyword> proKeywords);
	
	/**
	 * 根据编号批量删除
	 * @param keyid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delByKeyids(List<Long> keyids);
}
