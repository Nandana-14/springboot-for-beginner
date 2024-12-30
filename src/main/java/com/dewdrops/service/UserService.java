package com.dewdrops.service;

import java.util.List;

import com.dewdrops.entity.User;

public interface UserService {
	void saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Integer userId);

	void deleteUserById(Integer userId);
}