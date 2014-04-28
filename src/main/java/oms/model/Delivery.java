package oms.model;

import java.util.Set;

import org.springframework.hateoas.ResourceSupport;

public class Delivery extends ResourceSupport {
	
	private Long deliveryId;
	
	private Set<DeliveryItem> items;
	
	private DeliveryStatus status;

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Set<DeliveryItem> getItems() {
		return items;
	}

	public void setItems(Set<DeliveryItem> items) {
		this.items = items;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

}
