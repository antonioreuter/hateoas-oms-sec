package oms.assembler;

import oms.controller.PaymentController;
import oms.model.Order;
import oms.model.Payment;
import oms.resource.PaymentResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PaymentResourceAssembler extends ResourceAssemblerSupport<Payment, PaymentResource>{

	@Autowired 
	private EntityLinks entityLinks;
	
	public PaymentResourceAssembler() {
		super(PaymentController.class, PaymentResource.class);
	}
	
	@Override
	public PaymentResource toResource(Payment payment) {
		PaymentResource resource = createResourceWithId(payment.getId(), payment);
		resource.copyAttributesFrom(payment);
		
		Long orderId = payment.getOrderId();
		Link orderLink = entityLinks.linkToSingleResource(Order.class, orderId).withRel("Order");
		resource.add(orderLink);
		
		return resource;
	}
	
}