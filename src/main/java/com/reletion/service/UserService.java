package com.reletion.service;

import java.util.List;

import com.reletion.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	UserDTO getUserById(Long id);
	List<UserDTO> getAllUser();
	UserDTO updateUser(Long id , UserDTO userDTO);
	void deleteUser(Long id);
	List<UserDTO> searchUser(String query);
	//List<Profile> searchUserByProfile(String query);

}
