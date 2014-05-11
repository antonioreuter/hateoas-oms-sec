package oms.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;


public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Customer customer;
	
	private Set<Payment> payments;
	
	private Set<Item> items;
	
	private Date createdAt = new Date();
	
	private OrderStatus status = OrderStatus.WAITING_FOR_PAYMENT;
	

	public Order() {
		
	}
	
	
	public void cancel() {
		this.status = OrderStatus.CANCELED;
	}

	
	public boolean isCanceled() {
		return this.status == OrderStatus.CANCELED;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Payment> getPayments() {
		if (CollectionUtils.isEmpty(this.payments)) {
			return Collections.EMPTY_SET;
		} else {
			return Collections.unmodifiableSet(payments);
		}
	}

	public void addPayments(Payment payment) {
		if (this.payments == null) {
			this.payments = new LinkedHashSet<Payment>();
		}
		this.payments.add(payment);
	}

	public Set<Item> getItems() {
		if (CollectionUtils.isEmpty(this.items)) {
			return Collections.EMPTY_SET;
		} else {
			return Collections.unmodifiableSet(items);
		}
	}

	public void addItem(Item item) {
		if (this.items == null) {
			this.items = new LinkedHashSet<Item>();
		}
		this.items.add(item);
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
}
