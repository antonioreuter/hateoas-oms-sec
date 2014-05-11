package oms.controller;

import java.util.List;

import oms.model.Payment;
import oms.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Payment> get() {
		return paymentService.getAll();
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public List<Payment> getByOrder(@PathVariable("orderId") Long orderId) {
		return paymentService.getByOrder(orderId);
	}
	
}
