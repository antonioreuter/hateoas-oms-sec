package oms.service;

import java.util.List;

import oms.model.Item;

public interface ItemService {
	
	List<Item> getByOrder(Long id);
	
	
}
