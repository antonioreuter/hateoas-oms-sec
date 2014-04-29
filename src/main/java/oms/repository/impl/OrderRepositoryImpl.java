package oms.repository.impl;

import java.util.Set;

import oms.model.Order;
import oms.repository.OrderRepository;

import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

	@Override
	public Set<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order find(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long orderId) {
		
	}
	
}
