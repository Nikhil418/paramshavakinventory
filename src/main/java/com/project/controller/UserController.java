package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String login()
	{
		System.out.println("login page");
		return "login";
	}  
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@RequestParam("uname") String uname,@RequestParam("password") String password)
	{  
		User user=userService.authenticateuser(uname,password);
		//System.out.println(user);
		if(user!=null && user.getRole().equals("admin"))
		{   
			
			System.out.println("user is authenticated");
			return new ModelAndView("home");
			
		}
		String msg="invalid credentials please login again ";
		return new ModelAndView("login","message",msg);
				
	}  
	@RequestMapping("/addnew")
	public String addnew() {
		return "addnew";
	}  
	@RequestMapping("/viewAll")
	public String viewAll() {
		return "viewAll";
	}
}
