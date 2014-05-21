package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.model.Order;
import oms.repository.OrderRepository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	private static final Map<Long, Order> orders = new HashMap<Long, Order>();

	@Override
	public List<Order> findAll() {
		return new ArrayList<Order>(orders.values());
	}

	@Override
	public Order find(Long orderId) {
		return orders.get(orderId);
	}

	@Override
	public Order save(Order order) {
		orders.put(order.getId(), order);
		return order;
	}

	public void delete(Long orderId) {
		orders.remove(orderId);
	}
}
