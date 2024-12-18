package com.reletion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reletion.dto.UserDTO;
import com.reletion.entity.Profile;
import com.reletion.entity.User;
import com.reletion.exception.ResourceNotFoundException;
import com.reletion.mapper.UserMapper;
import com.reletion.repository.UserRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImple implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImple.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;
	
	// Create User
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		logger.info("Create User with id:{}",userDTO.getName());
		User user = userMapper.toEntity(userDTO);
		User savedUser = userRepository.save(user);
		logger.info("{} User Successfully create",savedUser.getName());
		return userMapper.toDTO(savedUser);
	}

	
	// Get User By id 
	@Override
	public UserDTO getUserById(Long id) {
		logger.info("Get user By Id : {}",id);
		User user = userRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		User savedUser = userRepository.save(user);
		logger.info("{} User Successfully Found",savedUser.getName());
		return userMapper.toDTO(savedUser);
	}

	
	// Get All User
	@Override
	public List<UserDTO> getAllUser() {
		logger.info("Get all User");
		List<User> users = userRepository.findAll();
		logger.info("{} Users Successfully Found",users.size());
		return users.stream().map(userMapper::toDTO).collect(Collectors.toList());
	}

	// Update User
	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
		logger.info("Update User to With id : {}",userDTO.getName());
		User user = userRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		//user.setProfile(userDTO.getProfile()); ye nahi set ho raha tha
		
		// Set profile from profile table
		if(userDTO != null) {
			Profile profile = new Profile();
			profile.setId(userDTO.getProfile().getId());
			profile.setAddress(userDTO.getProfile().getAddress());
			profile.setPhoneNumber(userDTO.getProfile().getPhoneNumber());
			profile.setDepartment(userDTO.getProfile().getDepartment());
			profile.setDesignation(userDTO.getProfile().getDesignation());
			user.setProfile(profile);	
		}
		// save user into database
		User savedUser = userRepository.save(user);
		logger.info("{} User Successfully Updated",savedUser.getName());
		return userMapper.toDTO(savedUser);
	}

	
	// Delete User By Id
	@Override
	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		userRepository.delete(user);
		logger.info("{} User Successfully deleted",user.getName());	
	}


	// Search User By Name and Email
	@Override
	public List<UserDTO> searchUser(String query) {
		logger.info("{} Search User With Id : ",query);
		List<User> users = userRepository.searchUser(query);
		logger.info("{} User Successfully Found",query);
		return users.stream().map(userMapper::toDTO).collect(Collectors.toList());
	}
	
	
	// Search User By Profile Field
	/*
		@Override
		public List<Profile> searchUserByProfile(String query) {
			logger.info("{} Search User By Profile With Id : ",query);
			List<Profile> usersProfile = userRepository.searchUserByProfile(query);
			logger.info("{} User Profile Successfully Found",query);
			return usersProfile.stream().collect(Collectors.toList());
		}
           */
	
	
}
