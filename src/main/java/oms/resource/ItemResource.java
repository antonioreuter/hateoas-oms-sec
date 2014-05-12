package oms.resource;

import oms.model.Item;
import oms.model.Product;

import org.springframework.hateoas.ResourceSupport;

public class ItemResource extends ResourceSupport {
	private Long itemId;
	private Product product;
	private int quantity;
	private Long orderId;
	
	public Long getItemId() {
		return itemId;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	
		
	public void copyAttributesFrom(Item item) {
		this.itemId = item.getId();
		this.product = item.getProduct();
		this.quantity = item.getQuantity();
		this.orderId = item.getOrderId();
		
	}
		
	
}
