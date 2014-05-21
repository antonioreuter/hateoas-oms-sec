package oms.service.impl;

import java.util.List;

import oms.model.Customer;
import oms.model.Order;
import oms.repository.CustomerRepository;
import oms.repository.OrderRepository;
import oms.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer get(Long id) {
		return customerRepository.find(id);
	}

	@Override
	public Customer getByOrder(Long id) {
		Customer customer = null;
		
		List<Order> orders = orderRepository.findAll();
		if (!CollectionUtils.isEmpty(orders)) {
			for (Order order : orders) {
				if (order.getId().equals(id)) {
					customer = order.getCustomer(); 
					break;
				}
			}
		}

		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	
	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}

}
