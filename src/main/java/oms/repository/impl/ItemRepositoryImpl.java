package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.model.Item;
import oms.repository.ItemRepository;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository{

	private static final Map<Long, Item> repo = new HashMap<Long, Item>();

	@Override
	public List<Item> findAll() {
		return new ArrayList<Item>(repo.values());
	}

	@Override
	public Item find(Long id) {
		return repo.get(id);
	}

	@Override
	public Item save(Item item) {
		repo.put(item.getId(), item);
		return item;
	}

	public void delete(Long id) {
		repo.remove(id);
	}
	
}