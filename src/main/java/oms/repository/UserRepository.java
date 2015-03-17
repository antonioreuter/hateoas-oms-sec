package oms.repository;

import java.util.Set;

import oms.model.api.User;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository  extends CrudRepository<User, Long>{
	
	User findById(Long id);
	
	User findByLogin(String login);

	User findByEmail(String email);
	
	User findByLoginAndPassword(String login, String password);
	
	Set<User> findAll();
}
