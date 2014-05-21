package oms.resource;

import oms.model.Address;
import oms.model.Customer;

import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport {
	private Long customerId;
	private String name;
	private String document;
	private Address address;
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void copyAttributesFrom(Customer customer) {
		this.customerId = customer.getId();
		this.name = customer.getName();
		this.document = customer.getDocument();
		this.address = customer.getAddress();	
	}	
	
}
