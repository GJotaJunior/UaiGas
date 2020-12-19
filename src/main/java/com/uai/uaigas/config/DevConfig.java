package com.uai.uaigas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.uai.uaigas.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Override
	public void run(String... args) throws Exception {
		
		if ("create".equals(strategy)) {
			dbService.InstantiateDatabase();
		}
		
	}

}