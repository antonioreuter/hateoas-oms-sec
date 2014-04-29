package oms.repository;

import java.util.Set;

import oms.model.Order;

public interface OrderRepository {
	
	Set<Order> findAll();
	
	Order find(Long orderId);
	
	Order save(Order order);
	
	void delete(Long orderId);

}
