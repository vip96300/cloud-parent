package org.cloud.packet.server.service;

import java.util.List;
import java.util.Map;

import org.cloud.packet.server.model.PacCategory;
import org.cloud.packet.server.model.Packet;
import org.springframework.data.domain.Pageable;

public interface PacketService{

	public void add(Packet packet);
	
	public Packet getByPacid(long pacid);
	
	public void updByPacid(Packet packet);

	public void delByPacid(long pacid);

	public List<Packet> list(Pageable pageable);
	
	public List<Packet> listBySome();
	
	public Map<String,List<PacCategory>> packetPacCategorys();
	
	public Map<String,List<PacCategory>> packetPacCategorysByPacid(long pacid);
	
	public List<Map<String,Object>> listByObjs(int page,int size);
}
