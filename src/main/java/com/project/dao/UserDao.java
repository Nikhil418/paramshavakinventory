package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	
	@Query("SELECT u FROM User u WHERE u.username= :uname and u.password= :password ")
	User findbyUsernamePassword(String uname,String password);
}
