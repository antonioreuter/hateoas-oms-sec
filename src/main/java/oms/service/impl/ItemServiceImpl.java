package oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import oms.model.Item;
import oms.model.Order;
import oms.repository.OrderRepository;
import oms.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ItemServiceImpl implements ItemService{

	
	
	@Autowired
	private OrderRepository orderRepository;

	

	

	@Override
	public List<Item> getByOrder(Long id) {
		List<Item> items = new ArrayList<Item> ();
		
		List<Order> orders = orderRepository.findAll();
		if (!CollectionUtils.isEmpty(orders)) {
			for (Order order : orders) {
				if (order.getId() == id) {
					items.addAll(order.getItems());
				}
			}
		}

		return items;
	}

	

}
