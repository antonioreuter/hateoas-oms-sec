package oms.service;

import java.util.List;

import oms.model.Order;

public interface OrderService {
	
	List<Order> getAll();
	
	Order get(Long orderId);
	
	Order purchase(Order order);
	
	Order save(Order order);
	
	Order cancel(Long orderId);
	
	void delete(Long orderId);
	
}
