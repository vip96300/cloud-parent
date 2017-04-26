package org.cloud.packet.server.service.impl;

import java.util.List;

import org.cloud.common.util.ValidUtil;
import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.repository.PacketRepository;
import org.cloud.packet.server.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacketServiceImpl implements PacketService{

	
	@Autowired
	private PacketRepository packetRepository;
	
	@Override
	public void add(Packet packet) {
		packetRepository.save(packet);
	}

	@Override
	public void delByPacid(long pacid) {
		Packet packet=packetRepository.findOne(pacid);
		if(!ValidUtil.isValid(packet)){
			return;
		}
		packet.setState(Packet.STATE_1);
		packetRepository.saveAndFlush(packet);
	}

	@Override
	public List<Packet> list(Pageable pageable) {
		List<Packet> packets=packetRepository.findAll(pageable).getContent();
		return packets;
	}

}
