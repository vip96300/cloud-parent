package org.cloud.waiter.client.service.breaker;

import java.util.List;

import org.cloud.waiter.client.model.Waiter;
import org.cloud.waiter.client.service.WaiterService;
import org.springframework.stereotype.Component;

@Component
public class WaiterServiceBreaker implements WaiterService{

	@Override
	public void add(Waiter waiter) {
		throw new RuntimeException();
	}

	@Override
	public List<Waiter> list(int page, int size) {
		throw new RuntimeException();
	}

}
