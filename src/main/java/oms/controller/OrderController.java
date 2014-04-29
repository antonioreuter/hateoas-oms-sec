package oms.controller;

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
    public String getOrders() {
    	return "teste";
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
