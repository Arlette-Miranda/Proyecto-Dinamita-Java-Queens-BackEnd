package com.yoatzin.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.yoatzin.app.model.User;
import com.yoatzin.app.service.UserService;

@Configuration
public class SetUpApp implements CommandLineRunner {
	
	UserService userService;
	
	public SetUpApp(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void run(String...args) throws Exception{
		User jazz = new User(); 
		jazz.setName("Jazz");
		userService.createUser(  jazz  );
	}
}
