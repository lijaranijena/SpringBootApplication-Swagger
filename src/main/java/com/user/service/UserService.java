package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public String addUser(User user) {
		User savedUser = userRepo.save(user);
		return (savedUser != null) ? "User Saved Successfully with Id - "
				+ savedUser.getUserId() : "User Not Saved!!";

	}

	public List<User> getUserList() {
		return userRepo.findAll();

	}
	
	public User getUserById(int id){
		Optional<User> userOpt = userRepo.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		throw new UserNotFoundException("user id is not available");
	}

}
