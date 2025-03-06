package com.reletion.mapper;

import org.springframework.stereotype.Component;

import com.reletion.dto.ProfileDTO;
import com.reletion.dto.UserDTO;
import com.reletion.entity.Profile;
import com.reletion.entity.User;

@Component
public class UserMapper {

	// Convert to Entity
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        

        if (userDTO.getProfile() != null) {
            Profile profile = new Profile();
            profile.setId(userDTO.getProfile().getId());
            profile.setAddress(userDTO.getProfile().getAddress());
            profile.setPhoneNumber(userDTO.getProfile().getPhoneNumber());
            profile.setDepartment(userDTO.getProfile().getDepartment());
            profile.setDesignation(userDTO.getProfile().getDesignation());
            user.setProfile(profile);
        }

        return user;
    }

    
    // Convert to DTO
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        if (user.getProfile() != null) {
            ProfileDTO profileDTO = new ProfileDTO();
            profileDTO.setId(user.getProfile().getId());
            profileDTO.setAddress(user.getProfile().getAddress());
            profileDTO.setPhoneNumber(user.getProfile().getPhoneNumber());
            profileDTO.setDepartment(user.getProfile().getDepartment());
            profileDTO.setDesignation(user.getProfile().getDesignation());
            userDTO.setProfile(profileDTO);
        }

        return userDTO;
    }
}

