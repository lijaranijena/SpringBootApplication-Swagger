package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.User;
import com.user.domain.UserResponse;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		String status = userService.addUser(user);
		return  new ResponseEntity<>(new UserResponse(status), HttpStatus.OK);
		
	}
	@GetMapping("/all")
	public ResponseEntity<?> getUserList(){
		List<User> userList = userService.getUserList();
		return ResponseEntity.ok(userList);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

}
