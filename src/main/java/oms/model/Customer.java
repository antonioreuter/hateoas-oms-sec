package oms.model;

import org.springframework.hateoas.ResourceSupport;

public class Customer extends ResourceSupport {

	private Long customerId;

	private String name;

	private String document;

	private Address address;

	public Customer(Long customerId, String name) {
		this.setCustomerId(customerId);
		this.setName(name);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
