package oms.assembler;

import oms.controller.api.UserController;
import oms.model.api.User;
import oms.resource.UserResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

	public UserResourceAssembler() {
		super(UserController.class, UserResource.class);
	}
	
	@Override
	public UserResource toResource(User user) {
		if (user == null) {
			throw new IllegalArgumentException("Usuário não informado!");
		}
		
		UserResource resource = createResourceWithId(user.getId(), user);
		resource.copyAttributesFrom(user);
		
		return resource;
	}

}
