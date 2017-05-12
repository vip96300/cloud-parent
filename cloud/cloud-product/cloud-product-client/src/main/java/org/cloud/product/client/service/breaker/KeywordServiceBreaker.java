package org.cloud.product.client.service.breaker;

import java.util.List;

import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.service.KeywordService;
import org.springframework.stereotype.Component;

@Component
public class KeywordServiceBreaker implements KeywordService{

	@Override
	public void add(Keyword keyword) {
		throw new RuntimeException();
	}

	@Override
	public Keyword getByKeyid(long keyid) {
		throw new RuntimeException();
	}

	@Override
	public void updByKeyid(Keyword keyword) {
		throw new RuntimeException();
	}

	@Override
	public void delByKeyid(long keyid) {
		throw new RuntimeException();
	}

	@Override
	public List<Keyword> listBySeaid(long seaid) {
		throw new RuntimeException();
	}

	@Override
	public List<Keyword> listByCatid(long catid) {
		throw new RuntimeException();
	}


}
