package oms.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.controller.CustomerController;
import oms.controller.OrderController;
import oms.controller.PaymentController;
import oms.model.Order;
import oms.resource.OrderResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, OrderResource> {

	public OrderResourceAssembler() {
		super(OrderController.class, OrderResource.class);
	}

	@Override
	public OrderResource toResource(Order order) {
		OrderResource orderResource = createResourceWithId(order.getId(), order);
		orderResource.copyAttributesFrom(order);

		if (!order.isCanceled()) {
			orderResource.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
		}
		
		orderResource.add(linkTo(methodOn(CustomerController.class).getByOrder(order.getId())).withRel("Customer Detail"));
		orderResource.add(linkTo(methodOn(PaymentController.class).getByOrder(order.getId())).withRel("Payment Details"));
		

		
		return orderResource;
	}
}
