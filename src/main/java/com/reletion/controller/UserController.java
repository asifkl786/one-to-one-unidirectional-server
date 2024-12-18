package com.reletion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reletion.dto.UserDTO;
import com.reletion.service.UserService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	// Build Create User REST API
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		logger.info("Recived Request to create User with id: {}",userDTO.getName());
		UserDTO user = userService.createUser(userDTO);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	// Build Get User By Id REST API
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		logger.info("Recived Request to get user by id:{}",id);
		UserDTO user = userService.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	// Build get all User REST API
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDTO>> getAlluser(){
		logger.info("Recived Request to get all user");
		List<UserDTO> users = userService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	// Build Update User REST API
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
		logger.info("Recived Request to Update User with Name:{}",userDTO.getName());
		UserDTO updatedUser = userService.updateUser(id, userDTO);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	// Build Delete User REST API
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		logger.info("Recived Request to Delete User With Id: {}",id);
		userService.deleteUser(id);
		return new ResponseEntity<>("User Successfully Deleted",HttpStatus.OK);
	}
	
	// Build Search User REST API
	@GetMapping("/search")
	public ResponseEntity<List<UserDTO>> searchUser(@RequestParam String query){
		logger.info("Recived Request to Search User with id: ", query);
		List<UserDTO> user = userService.searchUser(query);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	// Build Search User Profile REST API
	/*
	@GetMapping("/searchProfile")
	public ResponseEntity<List<Profile>> searchUserByProfile(@RequestParam String query){
		logger.info("Recived Request to Search UserProfile with Id: {}",query);
		List<Profile> searchUserProfile = userService.searchUserByProfile(query);
		return new ResponseEntity<>(searchUserProfile,HttpStatus.OK);
	} */
	

}
