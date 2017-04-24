package org.cloud.product.admin.service.breaker;

import org.cloud.product.admin.model.Keyword;
import org.cloud.product.admin.service.KeywordService;
import org.springframework.stereotype.Component;

@Component
public class KeywordServiceBreaker implements KeywordService{

	@Override
	public void add(Keyword keyword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Keyword getByKeyid(long keyid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updByKeyid(Keyword keyword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delByKeyid(long keyid) {
		// TODO Auto-generated method stub
		
	}


}
