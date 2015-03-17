package oms.controller.api;

import java.util.List;

import oms.assembler.CustomerResourceAssembler;
import oms.assembler.OrderResourceAssembler;
import oms.model.Customer;
import oms.model.Order;
import oms.resource.CustomerResource;
import oms.resource.OrderResource;
import oms.service.CustomerService;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderResourceAssembler orderResourceAssembler;

	@Autowired
	private CustomerResourceAssembler customerResourceAssembler;

	@RequestMapping(method= RequestMethod.GET)
	@ResponseBody
	public List<CustomerResource> customers() {
		return customerResourceAssembler.toResources(customerService.getAll());
	}

	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ResponseBody
	public CustomerResource customer(@PathVariable("id") Long customerId) {
		Customer customer = customerService.get(customerId);
		return customerResourceAssembler.toResource(customer);
	}

	@RequestMapping(value="/{customer_id}/orders", method= RequestMethod.GET)
	@ResponseBody
	public List<OrderResource> orders(@PathVariable("customer_id") Long customerId) {
		List<Order> orders = orderService.getByCustomer(customerId);
		return orderResourceAssembler.toResources(orders);
	}


	@RequestMapping(value="/order/{order_id}", method=RequestMethod.GET)
	@ResponseBody
	public CustomerResource customerByOrder(@PathVariable("order_id") Long orderId) {
		return customerResourceAssembler.toResource(customerService.getByOrder(orderId));
	}
	
	@Secured(value="ROLE_ADMIN")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("customer_id") Long customerId) {
		System.out.println("Deletando o customer "+customerId);
	}

}
