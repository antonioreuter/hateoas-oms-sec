package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.model.Payment;
import oms.repository.PaymentRepository;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository{
	
	private static final Map<Long, Payment> repo = new HashMap<Long, Payment>();

	@Override
	public List<Payment> findAll() {
		return new ArrayList<Payment>(repo.values());
	}

	@Override
	public Payment find(Long id) {
		return repo.get(id);
	}

	@Override
	public Payment save(Payment payment) {
		repo.put(payment.getId(), payment);
		return payment;
	}

	public void delete(Long id) {
		repo.remove(id);
	}

}
