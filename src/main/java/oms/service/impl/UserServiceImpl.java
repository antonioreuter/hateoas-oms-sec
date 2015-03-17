package oms.service.impl;

import java.util.HashSet;
import java.util.Set;

import oms.model.api.Role;
import oms.model.api.RoleEnum;
import oms.model.api.User;
import oms.repository.UserRepository;
import oms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Set<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByLoginAndPassword(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public User createUser(User user) {
		createUserDefault(user);
		
		user = userRepository.save(user);		
		return user;
	}
	
	@Override
	public User createSeller(User user) {
		createUserDefault(user);
		user.getRoles().add(new Role(RoleEnum.SELLER.toString(), user));
		
		user = userRepository.save(user);
		return user;
	}
	
	@Override
	public User createAdmin(User user) {
		createUserDefault(user);
		user.getRoles().add(new Role(RoleEnum.ADMIN.toString(), user));

		user = userRepository.save(user);
		return user;
	}
	
	private void createUserDefault(User user) {
		if (user == null) {
			throw new IllegalArgumentException("O usuário não foi informado!");
		}
		
		if (user.getId() != null && user.getId() != 0L) {
			throw new IllegalArgumentException("Não é possível criar para o usuário. Já esta cadastrado.");
		}
	
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new IllegalArgumentException("O email usuário não foi preenchido!");
		}
		
		if (StringUtils.isEmpty(user.getLogin())) {
			throw new IllegalArgumentException("O login usuário não foi preenchido!");
		}
	
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new IllegalArgumentException("A senha usuário não foi preenchida!");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Set<Role> userRoles = new HashSet<Role>();
		userRoles.add(new Role(RoleEnum.USER.toString(), user));
		user.setRoles(userRoles);
	}

}
