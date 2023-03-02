package com.microservice.userservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.service.UserService;
import com.mocroservice.userservice.VO.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value ="userService")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getUsers(){
		log.info("Inside getUsers Method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getAllUsers());
	}

	@GetMapping(value = "/user/{Id}")
	public ResponseEntity<User> getUser(@PathVariable("Id") long id){
		log.info("Inside getUser Method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getUser(id));
	}

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		log.info("Inside saveUser Method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.saveUser(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.updateUser(user));
	}

	@GetMapping("/userwithDept/{Id}")
	public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable ("Id") long id) {
		log.info("Inside saveUser getUserWithDepartment");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getUserWithDepartment(id)); 

	}
}
