package oms.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.controller.api.CustomerController;
import oms.model.Customer;
import oms.resource.CustomerResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


@Component
public class CustomerResourceAssembler extends ResourceAssemblerSupport<Customer, CustomerResource>{

	
	public CustomerResourceAssembler() {
		super(CustomerController.class, CustomerResource.class);
	}
	
	@Override
	public CustomerResource toResource(Customer customer) {
		CustomerResource resource = createResourceWithId(customer.getId(), customer);
		resource.copyAttributesFrom(customer);
		
		resource.add(linkTo(methodOn(CustomerController.class).orders(customer.getId())).withRel("My Orders"));
		
		return resource;
	}
	
}