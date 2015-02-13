package oms.assembler;

import oms.controller.api.ItemController;
import oms.model.Item;
import oms.model.Order;
import oms.resource.ItemResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ItemResourceAssembler extends ResourceAssemblerSupport<Item, ItemResource>{

	@Autowired
	private EntityLinks entityLinks;
	
	public ItemResourceAssembler() {
		super(ItemController.class, ItemResource.class);
	}
	
	@Override
	public ItemResource toResource(Item item) {
		ItemResource resource = createResourceWithId(item.getId(), item);
		resource.copyAttributesFrom(item);
		
		Long orderId = item.getOrderId();
		Link orderLink = entityLinks.linkToSingleResource(Order.class, orderId).withRel("Order");
		resource.add(orderLink);
		
		return resource;
	}
	
}
