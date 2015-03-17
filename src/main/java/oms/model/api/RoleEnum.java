package oms.model.api;

public enum RoleEnum {
	USER, SELLER, CUSTOMER_SERVICE, ADMIN;
	
	private static final String prefix = "ROLE_";
	
	@Override
	public String toString() {
		return prefix + this.name();
	}
	
}
