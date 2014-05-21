package oms.service;

import java.util.List;

import oms.model.Payment;

public interface PaymentService {

	List<Payment> getAll();
	
	Payment get(Long id);
	
	List<Payment> getByOrder(Long id);
	
	Payment save(Payment payment);
	
	void delete(Long id);
	
}
