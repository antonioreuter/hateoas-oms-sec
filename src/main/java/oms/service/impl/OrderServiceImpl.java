package oms.service.impl;

import java.util.Set;

import oms.model.Order;
import oms.model.OrderStatus;
import oms.repository.OrderRepository;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Set<Order> getAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order get(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.find(orderId);
	}

	@Override
	public Order purchase(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order cancel(Long orderId) {
		Order order = get(orderId);
		order.setStatus(OrderStatus.CANCELED);
		
		return orderRepository.save(order);
	}

	@Override
	public void delete(Long orderId) {
		orderRepository.delete(orderId);
	}
	
	

}
