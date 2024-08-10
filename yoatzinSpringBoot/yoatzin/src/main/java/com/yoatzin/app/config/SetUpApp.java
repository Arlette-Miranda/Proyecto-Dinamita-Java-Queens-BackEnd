package com.yoatzin.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.yoatzin.app.repository.AddressRepository;
import com.yoatzin.app.repository.CardRepository;
import com.yoatzin.app.repository.CommentRepository;
import com.yoatzin.app.repository.OrderRepository;
import com.yoatzin.app.repository.PrivilegeRepository;
import com.yoatzin.app.repository.ProductHasOrderRepository;
import com.yoatzin.app.repository.ProductRepository;
import com.yoatzin.app.repository.SizeRepository;
import com.yoatzin.app.repository.UserRepository;
import com.yoatzin.app.service.UserService;

@Configuration
public class SetUpApp implements CommandLineRunner {
	
	AddressRepository addRepository;
	CardRepository carRepository;
	CommentRepository commRepository;
	OrderRepository ordRepository;
	PrivilegeRepository priRepository;
	ProductHasOrderRepository porHorRepository;
	ProductRepository proRepository;
	SizeRepository siRepository;
	UserRepository usRepository;
	UserService userService;
	
	
	
	public SetUpApp(AddressRepository addRepository, CardRepository carRepository, CommentRepository commRepository,
			OrderRepository ordRepository, PrivilegeRepository priRepository,
			ProductHasOrderRepository porHorRepository, ProductRepository proRepository, SizeRepository siRepository,
			UserRepository usRepository, UserService userService) {
		this.addRepository = addRepository;
		this.carRepository = carRepository;
		this.commRepository = commRepository;
		this.ordRepository = ordRepository;
		this.priRepository = priRepository;
		this.porHorRepository = porHorRepository;
		this.proRepository = proRepository;
		this.siRepository = siRepository;
		this.usRepository = usRepository;
		this.userService = userService;
	}



	//@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
