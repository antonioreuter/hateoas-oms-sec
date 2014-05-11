package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.model.Customer;
import oms.repository.CustomerRepository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	private static final Map<Long, Customer> repo = new HashMap<Long, Customer>();

	@Override
	public List<Customer> findAll() {
		return new ArrayList<Customer>(repo.values());
	}

	@Override
	public Customer find(Long id) {
		return repo.get(id);
	}

	@Override
	public Customer save(Customer customer) {
		repo.put(customer.getId(), customer);
		return customer;
	}

	public void delete(Long id) {
		repo.remove(id);
	}
	
}
