package org.cloud.packet.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.packet.client.model.PacUser;
import org.cloud.packet.client.service.PacUserService;
import org.springframework.stereotype.Component;
@Component
public class PacUserServiceBreaker implements PacUserService{

	@Override
	public List<Map<String, List<Object>>> listByUserid(String userid, int page, int size) {
		throw new RuntimeException();
	}

	@Override
	public void add(List<PacUser> pacUsers) {
		throw new RuntimeException();
	}

	@Override
	public void delByUseid(long useid) {
		throw new RuntimeException();
	}

	@Override
	public void updByUseid(PacUser pacUser) {
		throw new RuntimeException();
	}

}
