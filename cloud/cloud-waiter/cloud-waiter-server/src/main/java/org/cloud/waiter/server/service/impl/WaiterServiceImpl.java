package org.cloud.waiter.server.service.impl;

import java.util.List;

import org.cloud.waiter.server.model.Waiter;
import org.cloud.waiter.server.repository.WaiterRepository;
import org.cloud.waiter.server.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WaiterServiceImpl implements WaiterService{

	@Autowired
	private WaiterRepository waiterRepository;
	
	@Override
	public void add(Waiter waiter) {
		waiter.setTime(System.currentTimeMillis());
		waiterRepository.save(waiter);
	}

	@Override
	public List<Waiter> list(int page, int size) {
		List<Waiter> waiters=waiterRepository.findAll(new PageRequest(page, size)).getContent();
		return waiters;
	}

}
