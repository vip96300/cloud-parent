package org.cloud.product.client.service.breaker;

import java.util.List;
import java.util.Map;

import org.cloud.product.client.model.Keyword;
import org.cloud.product.client.model.Search;
import org.cloud.product.client.service.SearchService;
import org.springframework.stereotype.Component;

@Component
public class SearchServiceBreaker implements SearchService{

	@Override
	public void add(Search search) {
		throw new RuntimeException();
		
	}

	@Override
	public List<Map<String, List<Keyword>>> listKeywordsByCatid(long catid) {
		throw new RuntimeException();
	}

	@Override
	public Search getBySeaid(long seaid) {
		throw new RuntimeException();
	}

	@Override
	public void updBySeaid(Search search) {
		throw new RuntimeException();
	}

	@Override
	public void delBySeaid(long seaid) {
		throw new RuntimeException();
	}




}
