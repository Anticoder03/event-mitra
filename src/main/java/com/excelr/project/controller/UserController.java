package com.excelr.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.project.entity.User;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	//Create User
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user1) {
		try {
			return new ResponseEntity<User>(userService.createUser(user1),HttpStatus.CREATED);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	//Get All Users
	@GetMapping
	public ResponseEntity<List<User>> showAllUser(){
		return new ResponseEntity<List<User>>(userService.showAllUser(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> showUserById(@PathVariable int id){
		try {
			return new ResponseEntity<User>(userService.showUserById(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<?> showUserByEmail(@PathVariable String email){
		try {
			return new ResponseEntity<User>(userService.showUserByEmail(email),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User newdata){
		try {
			return new ResponseEntity<User>(userService.updateUser(id,newdata),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		try {
			return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.OK);
		}
		catch(ResourceNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
}
