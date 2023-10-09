package com.sb.gql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.gql.entity.User;
import com.sb.gql.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> saveUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}

	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User removed !! " + id;
	}
}
