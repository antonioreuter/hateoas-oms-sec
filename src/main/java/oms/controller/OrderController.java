package oms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import oms.model.Order;
import oms.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
    @RequestMapping(method= RequestMethod.GET)
    public List<Order> getOrders() {
    	return orderService.getAll();
    }
    
    @RequestMapping("/{orderId}")
    public Order get(@PathVariable Long orderId) {
    	Order order = orderService.get(orderId);
    	order.add(linkTo(methodOn(OrderController.class).get(orderId)).withSelfRel());
    	
    	return order;
    }

    @RequestMapping(method= RequestMethod.POST)
    public Order purchase(Order order) {
    	return orderService.purchase(order); 
    }
    
    @RequestMapping(method= RequestMethod.PUT)
    public Order update(Order order) {
    	return orderService.update(order); 
    }
    
    @RequestMapping(method= RequestMethod.DELETE)
    public void delete(Long orderId) {
    	orderService.delete(orderId);
    }
    
    @RequestMapping(value="/{orderId}/cancel",  method= RequestMethod.PUT)
    public Order cancel(@PathVariable("orderId") Long orderId) {
    	return orderService.cancel(orderId);
    }
}
