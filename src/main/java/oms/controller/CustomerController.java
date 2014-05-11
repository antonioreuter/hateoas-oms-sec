package oms.controller;

import java.util.List;

import oms.model.Customer;
import oms.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Customer> get() {
		return customerService.getAll();
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public Customer getByOrder(@PathVariable("orderId") Long orderId) {
		return customerService.getByOrder(orderId);
	}
	
}
