package oms.resource;

import java.math.BigDecimal;
import java.util.Date;

import oms.model.Order;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
	private Long orderId;
	private Date createdAt;
	private String status;

	private BigDecimal value;


	public Long getOrderId() {
		return this.orderId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public String getStatus() {
		return this.status;
	}
	
	public BigDecimal getValue() {
		return this.value;
	}
	
	
	public void copyAttributesFrom(Order order) {
		this.orderId = order.getId();
		this.createdAt = order.getCreatedAt();

		this.status = order.getStatus().toString();
		this.value = order.getValue();

	}
}
