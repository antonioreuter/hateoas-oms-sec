package oms.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.controller.OrderController;
import oms.controller.PaymentController;
import oms.model.Payment;
import oms.resource.PaymentResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PaymentResourceAssembler extends ResourceAssemblerSupport<Payment, PaymentResource>{

	
	public PaymentResourceAssembler() {
		super(PaymentController.class, PaymentResource.class);
	}
	
	@Override
	public PaymentResource toResource(Payment payment) {
		PaymentResource resource = createResourceWithId(payment.getId(), payment);
		resource.copyAttributesFrom(payment);
		
		resource.add(linkTo(methodOn(OrderController.class).get(payment.getOrderId())).withRel("Order"));
		
		return resource;
	}
	
}