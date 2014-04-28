package oms.service;

import java.util.Set;

import oms.model.Order;

public interface OrderService {
	
	Set<Order> getAll();
	
	Order get();
	
	Order purchase(Order order);
	
	Order update(Order order);
	
	Order cancel(Long orderId);
	
	void delete(Long orderId);
	
}
