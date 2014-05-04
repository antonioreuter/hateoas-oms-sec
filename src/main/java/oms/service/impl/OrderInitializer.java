package oms.service.impl;

import javax.annotation.PostConstruct;

import oms.model.Customer;
import oms.model.Order;
import oms.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInitializer {
	@Autowired
	private OrderRepository orderRepository;
	
	@PostConstruct
	public void loadDataset() {
		Order order = new Order(1L, new Customer(1L, "João Carlos"));
		orderRepository.save(order);
		
		order = new Order(2L, new Customer(2L, "Adriana Alves"));
		orderRepository.save(order);
	}
}
