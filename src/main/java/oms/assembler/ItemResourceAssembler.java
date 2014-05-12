package oms.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.controller.ItemController;
import oms.controller.OrderController;
import oms.model.Item;
import oms.resource.ItemResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ItemResourceAssembler extends ResourceAssemblerSupport<Item, ItemResource>{

	
	public ItemResourceAssembler() {
		super(ItemController.class, ItemResource.class);
	}
	
	@Override
	public ItemResource toResource(Item item) {
		ItemResource resource = createResourceWithId(item.getId(), item);
		resource.copyAttributesFrom(item);
		
		resource.add(linkTo(methodOn(OrderController.class).get(item.getOrderId())).withRel("Order"));
		
		return resource;
	}
	
}
