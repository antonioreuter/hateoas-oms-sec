package oms.service.impl;

import java.util.ArrayList;
import java.util.List;

import oms.model.Item;
import oms.repository.ItemRepository;
import oms.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ItemServiceImpl implements ItemService{	
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item get(Long id) {
		return itemRepository.find(id);
	}

	@Override
	public List<Item> getByOrder(Long id) {
		List<Item> result = new ArrayList<Item> ();
		
		List<Item> items = itemRepository.findAll();
		if (!CollectionUtils.isEmpty(items)) {
			for (Item item : items) {
				if (item.getOrderId().equals(id)) {
					result.add(item);
				}
			}
		}

		return result;
	}
	

}
