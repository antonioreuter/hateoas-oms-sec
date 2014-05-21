package oms.repository;

import java.io.Serializable;
import java.util.List;

public interface ResourceRepository <T extends Serializable>{
	
	List<T> findAll();
	
	T find(Long id);
	
	T save(T object);
	
	void delete(Long id);

}
