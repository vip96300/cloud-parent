package org.cloud.packet.server.service;


public interface ColPacketService {
	
	/**
	 * 修改收藏的优选包的类型的产品
	 * @param colid
	 * @param catid
	 * @param proid
	 */
	public void updByColid(long colid,long catid,long proid);
}
