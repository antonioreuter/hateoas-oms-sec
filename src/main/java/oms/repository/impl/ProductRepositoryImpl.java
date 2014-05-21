package oms.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.model.Product;
import oms.repository.ProductRepository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private static final Map<Long, Product> repo = new HashMap<Long, Product>();

	@Override
	public List<Product> findAll() {
		return new ArrayList<Product>(repo.values());
	}

	@Override
	public Product find(Long id) {
		return repo.get(id);
	}

	@Override
	public Product save(Product product) {
		repo.put(product.getId(), product);
		return product;
	}

	public void delete(Long id) {
		repo.remove(id);
	}	

}
