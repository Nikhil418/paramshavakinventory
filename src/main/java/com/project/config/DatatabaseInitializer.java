package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.User;
import com.project.service.UserService;

@Component
public class DatatabaseInitializer implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
		if (userService.findByUsername("admin") == null)
			userService.addUser(new User("admin", "admin", "admin"));
	}

}
