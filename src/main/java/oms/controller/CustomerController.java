package oms.controller;

import java.util.List;

import oms.assembler.CustomerResourceAssembler;
import oms.model.Customer;
import oms.resource.CustomerResource;
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
	
	@Autowired
	private CustomerResourceAssembler customerResourceAssembler;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<CustomerResource> customers() {
		return customerResourceAssembler.toResources(customerService.getAll());
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public CustomerResource customer(@PathVariable("id") Long customerId) {
		Customer customer = customerService.get(customerId);
		return customerResourceAssembler.toResource(customer);
	}
	
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public CustomerResource getByOrder(@PathVariable("orderId") Long orderId) {
		return customerResourceAssembler.toResource(customerService.getByOrder(orderId));
	}
	
}
