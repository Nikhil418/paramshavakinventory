package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.model.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDao userDao;

	public UserServiceImplementation() {
		System.out.println("Service");
	}

	@Override
	public User authenticateuser(String uname, String password) {
		return userDao.findbyUsernamePassword(uname, password);

	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public User findByUsername(String uname) {
		return userDao.findByUsername(uname);
	}

}
