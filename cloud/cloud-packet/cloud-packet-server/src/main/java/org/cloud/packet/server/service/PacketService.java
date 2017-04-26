package org.cloud.packet.server.service;

import java.util.List;

import org.cloud.packet.server.model.Packet;
import org.springframework.data.domain.Pageable;

public interface PacketService {

	public void add(Packet packet);

	public void delByPacid(long pacid);

	public List<Packet> list(Pageable pageable);
}
