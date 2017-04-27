package org.cloud.packet.server.service;

import org.cloud.packet.server.model.PacProduct;

public interface PacProductService {

	public void add(PacProduct pacProduct);
	
	public void delByProductid(long productid);
}
