package oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import oms.model.Payment;
import oms.repository.PaymentRepository;
import oms.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
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
		List<Payment> result = new ArrayList<Payment>();
		
		List<Payment> payments = paymentRepository.findAll();
		if (!CollectionUtils.isEmpty(payments)) {
			for (Payment payment : payments) {
				if (payment.getOrderId() == id) {
					result.add(payment);
				}
			}
		}

		return result;
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
