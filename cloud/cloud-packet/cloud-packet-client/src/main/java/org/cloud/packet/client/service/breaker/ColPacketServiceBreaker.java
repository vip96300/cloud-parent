package org.cloud.packet.client.service.breaker;

import org.cloud.packet.client.service.ColPacketService;
import org.springframework.stereotype.Component;

@Component
public class ColPacketServiceBreaker implements ColPacketService{

	@Override
	public void updByColid(long colid, long catid, long proid) {
		throw new RuntimeException();
	}



}
