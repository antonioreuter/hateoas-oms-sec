package oms.service;

import java.util.List;

import oms.model.Item;

public interface ItemService {
	
	Item get(Long id);
	
	List<Item> getByOrder(Long id);
	
	
}
