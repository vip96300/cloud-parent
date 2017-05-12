package org.cloud.packet.client.service.breaker;

import java.util.Map;

import org.cloud.packet.client.service.CollectService;
import org.springframework.stereotype.Component;
@Component
public class CollectServiceBreaker implements CollectService{

	@Override
	public Map<String,Object> add(String userid, long pacid, String name,String packetKV) {
		throw new RuntimeException();
	}

	@Override
	public Map<String, Object> listPacCategorysProductsByUserid(String userid,int page,int size) {
		throw new RuntimeException();
	}

	@Override
	public void delByColid(long colid) {
		throw new RuntimeException();
	}



}
