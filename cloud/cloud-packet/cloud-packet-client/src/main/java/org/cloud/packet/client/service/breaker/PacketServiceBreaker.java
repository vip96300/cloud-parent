package org.cloud.packet.client.service.breaker;

import java.util.List;

import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.service.PacketService;
import org.springframework.stereotype.Component;
@Component
public class PacketServiceBreaker implements PacketService{

	@Override
	public void add(Packet packet) {
		throw new RuntimeException();
	}

	@Override
	public void delByPacid(long pacid) {
		throw new RuntimeException();
	}

	@Override
	public List<Packet> list(int page, int size) {
		throw new RuntimeException();
	}

}
