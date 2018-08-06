package com.training.demo.restfulworks.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.training.demo.restfulworks.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDAOService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUSers() {
		return userDaoService.getAllUsers();
	}

	@GetMapping("/usersold/{userId}")
	public User getOneUSer(@PathVariable int userId) {
		User getUSer = userDaoService.getUser(userId);
		if (getUSer == null) {
			throw new UserNotFoundException("id - " + userId);
		}
		return getUSer;
	}

	@GetMapping("/users/{userId}")
	public Resource<User> getOneUServ2(@PathVariable int userId) {
		User getUSer = userDaoService.getUser(userId);
		if (getUSer == null) {
			throw new UserNotFoundException("id - " + userId);
		}

		// give the link for getting all users with meta data"all-uses" SERVER-PATH +
		// "/users"

		Resource<User> resource = new Resource<User>(getUSer);
		
		ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getAllUSers());
		
		ControllerLinkBuilder linkTo1 = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getOneUSer(userId));

		resource.add(linkTo.withRel("all-users"));
		resource.add(linkTo1.withRel("one-users"));
		return resource;
	}
	@PostMapping("/usersold")
	public void createUser(@RequestBody User user) {
		User savedUSer = userDaoService.saveUser(user);
		System.out.println("Saved User : " + savedUSer);
	}
	
	@PostMapping("/users")
	public Resource<User> createUserv2(@RequestBody User user) {
		
		User savedUSer = userDaoService.saveUser(user);
		Resource<User> resource = new Resource<User>(savedUSer);
		
		ControllerLinkBuilder linkTo1 = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getOneUSer(savedUSer.getUserId()));
		resource.add(linkTo1.withRel("one-users"));
		
		System.out.println("Saved User : " + savedUSer);
		return resource;
	}

	// custom Response Code
	@PostMapping("/usersv2")
	public ResponseEntity<Object> createUserResponseCode(@RequestBody User user) {

		User savedUSer = userDaoService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUSer.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

}
