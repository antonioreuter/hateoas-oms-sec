package oms.model;

import java.util.Date;
import java.util.Set;

public class Order {
	
	private Long orderId;
	
	private Customer customer;
	
	private Set<Payment> payments;
	
	private Set<Item> items;
	
	private Date createdAt;
	
	private OrderStatus status;

	public Order(Long orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
		this.createdAt = new Date();
	}
	
	public void cancel() {
		this.status = OrderStatus.CANCELED;
	}

	public Long getOrderId() {
		return this.orderId;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
}
