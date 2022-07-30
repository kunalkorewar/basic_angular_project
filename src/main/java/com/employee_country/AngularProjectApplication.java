package com.employee_country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AngularProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularProjectApplication.class, args);
		System.out.println("tomcat start..");
	}

}
