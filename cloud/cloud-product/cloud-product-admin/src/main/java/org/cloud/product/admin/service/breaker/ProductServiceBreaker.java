package org.cloud.product.admin.service.breaker;

import java.util.List;

import org.cloud.product.admin.model.Product;
import org.cloud.product.admin.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceBreaker implements ProductService{

	@Override
	public List<Product> listByCatid(long catid,int page,int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getByProid(long proid) {
		// TODO Auto-generated method stub
		return null;
	}


}
