package com.reletion.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reletion.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	// This is custom search method JPQL QUERY
    @Query("SELECT p FROM User p WHERE " +
           "p.name LIKE CONCAT('%', :query, '%')" +
            "Or p.email LIKE CONCAT('%', :query, '%')" )
    List<User> searchUser(String query);
    
 // This is custom search method JPQL QUERY
    /*
    @Query("SELECT p FROM Profile p WHERE " +
           "p.address LIKE CONCAT('%', :query, '%')" +
           "p.phoneNumber LIKE CONCAT('%', :query, '%')" +
           "p.department LIKE CONCAT('%', :query, '%')" +
            "Or p.designation LIKE CONCAT('%', :query, '%')" )
    List<Profile> searchUserByProfile(String query); */
}

