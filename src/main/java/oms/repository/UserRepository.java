package oms.repository;

import java.util.Set;

import oms.model.api.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository  extends CrudRepository<User, Long>{

	User findByEmail(String email);
	
	User findByLoginAndPassword(String login, String password);
	
	Set<User> findAll();
}
