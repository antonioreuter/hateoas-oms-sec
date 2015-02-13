package oms.resource;

import java.util.Set;

import oms.model.api.Role;
import oms.model.api.User;

import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {
	private Long userId;
	private String name;
	private String login;
	private String email;
	private Set<Role> roles;
	private boolean enabled;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void copyAttributesFrom(User user) {
		this.userId = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.login = user.getLogin();
		this.enabled = user.isEnabled();
		this.roles = user.getRoles();
	}
	
}	