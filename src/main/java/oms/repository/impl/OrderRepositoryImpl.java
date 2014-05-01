package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import oms.model.Customer;
import oms.model.Order;
import oms.repository.OrderRepository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	private static final Map<Long, Order> orders = new HashMap<Long, Order>();

	@Override
	public List<Order> findAll() {
		System.out.println(this);
		System.out.println(orders.size());
		return new ArrayList<Order>(OrderRepositoryImpl.orders.values());
	}

	@Override
	public Order find(Long orderId) {
		return orders.get(orderId);
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long orderId) {

	}

	@PostConstruct
	public void loadDataset() {
		Order order = new Order(1L, new Customer(1L, "João Carlos"));
		OrderRepositoryImpl.orders.put(order.getOrderId(), order);
		
		order = new Order(2L, new Customer(2L, "Adriana Alves"));
		OrderRepositoryImpl.orders.put(order.getOrderId(), order);
	}
}
