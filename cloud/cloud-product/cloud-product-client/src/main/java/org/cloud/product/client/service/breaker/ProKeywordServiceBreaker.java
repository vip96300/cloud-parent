package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.ProKeyword;
import org.cloud.product.client.service.ProKeywordService;
import org.springframework.stereotype.Component;

@Component
public class ProKeywordServiceBreaker implements ProKeywordService{

	@Override
	public void add(List<ProKeyword> proKeywords) {
		throw new RuntimeException();
	}

	@Override
	public void delByKeyids(List<Long> keyids) {
		throw new RuntimeException();
	}


}
