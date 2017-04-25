package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.controller.model.Packet;
import org.cloud.packet.client.service.PacketService;
import org.springframework.stereotype.Component;
@Component
public class PacketServiceBreaker implements PacketService{

	@Override
	public void add(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByPacid(long pacid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Packet> list(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
