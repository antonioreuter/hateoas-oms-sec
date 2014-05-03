package oms.model;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
	private Order order;
	
	public OrderResource(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return this.order;
	}
}
