package com.dewdrops.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dewdrops.entity.User;
import com.dewdrops.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		if (user.getUserId() == null) {
			userRepository.save(user);
		} else {
			User staffUpdate = userRepository.findById(user.getUserId()).get();
			staffUpdate.setUserName(user.getUserName());
			staffUpdate.setPassword(user.getPassword());
			staffUpdate.setRole(user.getRole());
			staffUpdate.setPhoneNo(user.getPhoneNo());
			userRepository.save(staffUpdate);
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).get();

	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}
}
