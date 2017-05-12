package org.cloud.packet.server.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.transaction.annotation.Transactional;

public interface CollectService {
	
	/**
	 * 添加
	 * @param userid
	 * @param pacid
	 * @param name
	 * @param packetKV
	 */
	@Transactional(rollbackFor=Exception.class)
	public Map<String,Object> add(String userid,long pacid,String name,Map<String,String> packetMap) throws Exception;
	
	/**
	 * 用户收藏的优选包结合
	 * @param userid
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public Map<String,Object> listPacCategorysProductsByUserid(String userid,int page,int size) throws Exception;
	/**
	 * 根据编号删除
	 * @param colid
	 */
	@Transactional(rollbackFor=Exception.class)
	public void delByColid(long colid);
}
