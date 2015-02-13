package oms.service;

import java.util.Set;

import oms.model.api.User;

public interface UserService {
	
	Set<User> findAll();
	
	User findByEmail(String email);
	
	User findByLoginAndPassword(String login, String password);
	
	User findById(Long id);

}
