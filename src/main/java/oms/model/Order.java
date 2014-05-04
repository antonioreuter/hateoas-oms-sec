package oms.model;

import java.util.Date;
import java.util.Set;

public class Order {
	
	private Long id;
	
	private Customer customer;
	
	private Set<Payment> payments;
	
	private Set<Item> items;
	
	private Date createdAt;
	
	private OrderStatus status;

	public Order(Long id, Customer customer) {
		this.id = id;
		this.customer = customer;
		this.status = OrderStatus.WAITING_FOR_PAYMENT;
		this.createdAt = new Date();
	}
	
	public void cancel() {
		this.status = OrderStatus.CANCELED;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public Long getId() {
		return this.id;
	}

	public boolean isCanceled() {
		return this.status == OrderStatus.CANCELED;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public OrderStatus getStatus() {
		return this.status;
	}
}
