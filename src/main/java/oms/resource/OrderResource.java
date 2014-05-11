package oms.resource;

import java.util.Date;

import oms.model.Order;
import oms.model.OrderStatus;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
	private Long orderId;
	private Date createdAt;
	private String status;

	public Long getOrderId() {
		return orderId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getStatus() {
		return status;
	}
	
	public void copyAttributesFrom(Order order) {
		this.orderId = order.getId();
		this.createdAt = order.getCreatedAt();
		this.status = order.getStatus().toString();
	}
}
