package oms.service.impl;

import java.util.List;

import oms.model.Order;
import oms.repository.OrderRepository;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order get(Long orderId) {
		return orderRepository.find(orderId);
	}

	@Override
	public Order purchase(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order cancel(Long orderId) {
		Order pedido = get(orderId);
		pedido.cancel();
		
		return orderRepository.save(pedido);
	}

	@Override
	public void delete(Long orderId) {
		orderRepository.delete(orderId);
	}
}
