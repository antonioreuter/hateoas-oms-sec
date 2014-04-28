package oms.model;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

public class DeliveryItem extends ResourceSupport {
	
	private Long deliveryItemId;
	
	private Item item;
	
	private int amount;
	
	private BigDecimal price;
	
	private int discount;

	public Long getDeliveryItemId() {
		return deliveryItemId;
	}

	public void setDeliveryItemId(Long deliveryItemId) {
		this.deliveryItemId = deliveryItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	

}
