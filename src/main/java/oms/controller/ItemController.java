package oms.controller;

import java.util.List;

import oms.assembler.ItemResourceAssembler;
import oms.resource.ItemResource;
import oms.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemResourceAssembler itemResourceAssembler;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ItemResource get(@PathVariable("id") Long id) {
		return itemResourceAssembler.toResource(itemService.get(id));
	}
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public List<ItemResource> getByOrder(@PathVariable("orderId") Long orderId) {
		return itemResourceAssembler.toResources(itemService.getByOrder(orderId));
	}
}
