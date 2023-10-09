package com.sb.gql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.gql.UserService;
import com.sb.gql.entity.User;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/health")
	public String healthCheck() {
		return "Application is up and running!.";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/user")
	public String addUser(@RequestBody User user) {
		userService.saveUser(user);
		return HttpStatus.CREATED.toString();
	}

	@GetMapping("/user/{name}")
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
