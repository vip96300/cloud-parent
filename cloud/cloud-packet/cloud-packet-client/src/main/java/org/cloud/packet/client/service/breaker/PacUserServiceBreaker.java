package org.cloud.packet.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.packet.client.model.PacUser;
import org.cloud.packet.client.model.Packet;
import org.cloud.packet.client.service.PacUserService;
import org.springframework.stereotype.Component;
@Component
public class PacUserServiceBreaker implements PacUserService{

	@Override
	public List<Map<Packet, List<Object>>> listByUserid(String userid,
			int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(List<PacUser> pacUsers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByUseid(long useid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updByUseid(PacUser pacUser) {
		// TODO Auto-generated method stub
		
	}

}
