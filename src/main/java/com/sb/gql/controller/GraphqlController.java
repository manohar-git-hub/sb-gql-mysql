package com.sb.gql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sb.gql.UserService;
import com.sb.gql.entity.User;

@RestController
public class GraphqlController {

	@Autowired
	private UserService userService;

	@QueryMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@MutationMapping
	public String addUser(@Argument User user) {
		userService.saveUser(user);
		return HttpStatus.CREATED.toString();
	}
}
