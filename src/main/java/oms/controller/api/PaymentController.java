package oms.controller.api;

import java.util.List;

import oms.assembler.PaymentResourceAssembler;
import oms.model.Payment;
import oms.resource.PaymentResource;
import oms.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentResourceAssembler paymentResourceAssembler;

	@RequestMapping(method= RequestMethod.GET)
	public List<PaymentResource> payments() {
		return paymentResourceAssembler.toResources(paymentService.getAll());
	}

	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public PaymentResource payment(@PathVariable("id") Long id) {
		Payment payment = paymentService.get(id);
		PaymentResource resource = paymentResourceAssembler.toResource(payment);

		return resource;
	}

	@RequestMapping(value="/order/{order_id}", method=RequestMethod.GET)
	public List<PaymentResource> paymentsByOrder(@PathVariable("order_id") Long orderId) {
		return paymentResourceAssembler.toResources(paymentService.getByOrder(orderId));
	}

}
