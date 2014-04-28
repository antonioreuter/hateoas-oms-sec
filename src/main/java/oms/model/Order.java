package oms.model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.CollectionUtils;

public class Order extends ResourceSupport{
	
	private Long orderId;
	
	private Customer customer;
	
	private Set<Payment> payments;
	
	private Set<Delivery> deliveries;
	
	private Date createdAt;
	
	private OrderStatus status;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void addPayment(Payment payment) {
		if (CollectionUtils.isEmpty(this.payments)) {
			this.payments = new LinkedHashSet<Payment>();
		}
		this.payments.add(payment);
	}

	public Set<Delivery> getDeliveries() {
		return deliveries;
	}

	public void addDeliveries(Delivery delivery) {
		if (CollectionUtils.isEmpty(this.deliveries)) {
			this.deliveries = new LinkedHashSet<Delivery>();
		}
		this.deliveries.add(delivery);
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
