package org.cloud.packet.server.service;

import java.util.List;
import java.util.Map;

import org.cloud.packet.server.model.PacUser;

import org.springframework.data.domain.Pageable;

public interface PacUserService {

	public List<Map<String,List<Object>>> listByUserid(String userid,Pageable pageable);
	
	public void add(List<PacUser> pacUsers);
	
	public void delByUseid(long useid);

	public void updByUseid(PacUser pacUser);
}
