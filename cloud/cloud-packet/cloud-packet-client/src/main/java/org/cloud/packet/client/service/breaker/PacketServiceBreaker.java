package org.cloud.packet.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.packet.client.model.PacCategory;
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

	@Override
	public Packet getByPacid(long pacid) {
		throw new RuntimeException();
	}

	@Override
	public void updByPacid(Packet packet) {
		throw new RuntimeException();
	}

	@Override
	public List<Packet> listBySome() {
		throw new RuntimeException();
	}

	@Override
	public Map<String, List<PacCategory>> packetPacCategorys() {
		throw new RuntimeException();
	}

	@Override
	public Map<String, List<PacCategory>> packetPacCategorysByPacid(long pacid) {
		throw new RuntimeException();
	}

	@Override
	public List<Map<String,Object>> listByObjs(int page, int size) {
		throw new RuntimeException();
	}

}
