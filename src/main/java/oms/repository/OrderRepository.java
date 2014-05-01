package oms.repository;

import java.util.List;

import oms.model.Order;

public interface OrderRepository {
	
	List<Order> findAll();
	
	Order find(Long orderId);
	
	Order save(Order order);
	
	void delete(Long orderId);

}
