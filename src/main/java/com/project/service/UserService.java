package com.project.service;

import com.project.model.User;

public interface UserService {

	User authenticateuser(String uname, String password);

	void addUser(User user);

	User findByUsername(String uname);

}
