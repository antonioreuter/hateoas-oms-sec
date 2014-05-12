package oms.resource;

import java.math.BigDecimal;
import java.util.Date;

import oms.model.Payment;
import oms.model.PaymentStatus;
import oms.model.PaymentType;

import org.springframework.hateoas.ResourceSupport;

public class PaymentResource extends ResourceSupport {
	
	private Long paymentId;
	
	private PaymentType type;
	
	private BigDecimal price;
	
	private PaymentStatus status;
	
	private Date createdAt;

	public Long getPaymentId() {
		return paymentId;
	}

	public PaymentType getType() {
		return type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void copyAttributesFrom(Payment payment) {
		this.paymentId = payment.getId();
		this.type = payment.getType();
		this.price = payment.getPrice();
		this.status = payment.getStatus();
		this.createdAt = payment.getCreatedAt();
	}
}