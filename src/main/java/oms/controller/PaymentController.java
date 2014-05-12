package oms.controller;

import java.util.List;

import oms.assembler.PaymentResourceAssembler;
import oms.resource.PaymentResource;
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
	
	@Autowired
	private PaymentResourceAssembler paymentResourceAssembler;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<PaymentResource> get() {
		return paymentResourceAssembler.toResources(paymentService.getAll());
	}
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public PaymentResource get(@PathVariable("id") Long id) {
		return paymentResourceAssembler.toResource(paymentService.get(id));
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public List<PaymentResource> getByOrder(@PathVariable("orderId") Long orderId) {
		return paymentResourceAssembler.toResources(paymentService.getByOrder(orderId));
	}
	
}
