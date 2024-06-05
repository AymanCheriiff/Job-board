package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(
						Role.builder()
								.name("USER")
								.build()
				);
			}
			if (roleRepository.findByName("EMPLOYEE").isEmpty()) {
				roleRepository.save(
						Role.builder()
								.name("EMPLOYEE")
								.build()
				);
			}
			if (roleRepository.findByName("JOB_SEEKER").isEmpty()) {
				roleRepository.save(
						Role.builder()
								.name("JOB_SEEKER")
								.build()
				);
			}
		};
	}
}
