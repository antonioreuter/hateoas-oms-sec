package oms.model;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
	private Long orderId;
	private Customer customer;
	private Date createdAt;
	private OrderStatus status;

	public Long getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}
	
	public void copyAttributesFrom(Order order) {
		this.orderId = order.getId();
		this.customer = order.getCustomer();
		this.createdAt = order.getCreatedAt();
		this.status = order.getStatus();
	}
}
