package org.cloud.packet.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cloud.packet.server.model.PacUser;
import org.cloud.packet.server.model.Packet;
import org.cloud.packet.server.repository.PacUserRepository;
import org.cloud.packet.server.service.PacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacUserServiceImpl implements PacUserService{
	
	@Autowired
	private PacUserRepository pacUserRepository;
	
	@Override
	public List<Map<String, List<Object>>> listByUserid(String userid,Pageable pageable) {
		List<Map<String,List<Object>>> packetCategorys=new ArrayList<Map<String,List<Object>>>();
		List<Packet> packets=pacUserRepository.findByUserid(userid);
		if(packets.isEmpty()){
			return null;
		}
		//TODO
		return null;
	}

	@Override
	public void add(List<PacUser> pacUsers) {
		
	}

	@Override
	public void delByUseid(long useid) {
		
	}

	@Override
	public void updByUseid(PacUser pacUser) {
		pacUserRepository.saveAndFlush(pacUser);
	}

}
