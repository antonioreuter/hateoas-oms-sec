package oms.repository;

import oms.model.api.User;

public interface UserRepository  {

	User findByEmail(String email);
	
	
	
}
