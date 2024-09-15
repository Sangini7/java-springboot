package com.sangini.app;

import com.sangini.app.model.Alien;
import com.sangini.app.model.Laptop;
import com.sangini.app.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootDemoApplication.class, args);
//		Alien al= context.getBean(Alien.class);
		Laptop laptop= context.getBean(Laptop.class);
		LaptopService laptopService= context.getBean(LaptopService.class);
		laptopService.addLaptop(laptop);
	}

}
