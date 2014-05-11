package oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import oms.model.Order;
import oms.model.Payment;
import oms.repository.OrderRepository;
import oms.repository.PaymentRepository;
import oms.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment get(Long id) {
		return paymentRepository.find(id);
	}

	@Override
	public List<Payment> getByOrder(Long id) {
		List<Payment> payments = new ArrayList<Payment>();
		
		List<Order> orders = orderRepository.findAll();
		if (!CollectionUtils.isEmpty(orders)) {
			for (Order order : orders) {
				if (order.getId() == id) {
					payments.addAll(order.getPayments()); 
					
				}
			}
		}

		return payments;
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	
	@Override
	public void delete(Long id) {
		paymentRepository.delete(id);
	}
	
}
