package oms.controller.api;

import java.util.List;

import oms.assembler.UserResourceAssembler;
import oms.resource.UserResource;
import oms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResourceAssembler userResourceAssembler;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserResource findById(@PathVariable("id") Long id) {
		return userResourceAssembler.toResource(userService.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserResource> findAll() {
		return userResourceAssembler.toResources(userService.findAll());
	}
	
}
