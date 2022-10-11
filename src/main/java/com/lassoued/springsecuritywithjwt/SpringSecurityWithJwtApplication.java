package com.lassoued.springsecuritywithjwt;

import com.lassoued.springsecuritywithjwt.domain.AppUser;
import com.lassoued.springsecuritywithjwt.domain.Role;
import com.lassoued.springsecuritywithjwt.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner commandLineRunner(AppUserService appUserService){
		return args -> {
			appUserService.saveRole(new Role("ROLE_USER"));
			appUserService.saveRole(new Role("ROLE_ADMIN"));
			appUserService.saveRole(new Role("ROLE_MANAGER"));
			appUserService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			appUserService.saveUser(new AppUser("Motez Lassoued","motez16","1234",new ArrayList()));
			appUserService.saveUser(new AppUser("Mehdi Lassoued","mehdi21","1234",new ArrayList()));
			appUserService.saveUser(new AppUser("Emna Lassoued","emna26","1234",new ArrayList()));
			appUserService.saveUser(new AppUser("Sihem Hamza","sihem18","1234",new ArrayList()));

			appUserService.addRoleToUser("motez16","ROLE_SUPER_ADMIN");
			appUserService.addRoleToUser("motez16","ROLE_ADMIN");
			appUserService.addRoleToUser("motez16","ROLE_MANAGER");
			appUserService.addRoleToUser("mehdi21","ROLE_MANAGER");
			appUserService.addRoleToUser("emna26","ROLE_USER");
			appUserService.addRoleToUser("sihem18","ROLE_ADMIN");


		};
	}

}
