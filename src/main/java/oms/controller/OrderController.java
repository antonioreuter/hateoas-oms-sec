package oms.controller;

import java.util.List;

import oms.assembler.CustomerResourceAssembler;
import oms.assembler.OrderResourceAssembler;
import oms.model.Order;
import oms.resource.OrderResource;
import oms.service.CustomerService;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@ExposesResourceFor(Order.class)

public class OrderController {

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
    public List<OrderResource> orders() {
    	List<Order> orders = orderService.getAll();
    	return orderResourceAssembler.toResources(orders);
    }
    

    @RequestMapping("/{order_id}")
	@ResponseBody
    public OrderResource order(@PathVariable("order_id") Long orderId) {
    	Order order = orderService.get(orderId);
    	return orderResourceAssembler.toResource(order);
    }

    @RequestMapping(method= RequestMethod.POST)
	@ResponseBody
    public OrderResource purchase(@RequestBody Order order) {
    	order = orderService.purchase(order);
		return orderResourceAssembler.toResource(order);
    }

    @RequestMapping(method= RequestMethod.PUT)
	@ResponseBody
    public OrderResource update(@RequestBody Order order) {
		order = orderService.save(order);
    	return orderResourceAssembler.toResource(order);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public void delete(Long orderId) {
    	orderService.delete(orderId);
    }

    @RequestMapping(value="/{order_id}/cancel",  method= RequestMethod.DELETE)
	@ResponseBody
    public OrderResource cancel(@PathVariable("order_id") Long orderId) {
    	Order canceledOrder = orderService.cancel(orderId);
    	return orderResourceAssembler.toResource(canceledOrder);
    }
}
