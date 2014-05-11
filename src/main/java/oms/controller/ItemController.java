package oms.controller;

import java.util.List;

import oms.model.Item;
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
	
	
	@RequestMapping(value="/order/{orderId}", method=RequestMethod.GET)
	public List<Item> getByOrder(@PathVariable("orderId") Long orderId) {
		return itemService.getByOrder(orderId);
	}
}
