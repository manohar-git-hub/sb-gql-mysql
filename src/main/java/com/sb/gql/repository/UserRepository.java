package com.sb.gql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.gql.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByName(String name);
}