package oms.service;

import java.util.List;

import oms.model.Customer;

public interface CustomerService {
	
	List<Customer> getAll();
	
	Customer get(Long id);
	
	Customer getByOrder(Long id);
	
	Customer save(Customer customer);
	
	void delete(Long id);

}
