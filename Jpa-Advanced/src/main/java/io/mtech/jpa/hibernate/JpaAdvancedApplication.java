package io.mtech.jpa.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jpa.hibernate.repo.CourseRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@SpringBootConfiguration
public class JpaAdvancedApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Autowired
	private CourseRepository repository;

	@Override
	public void run(String... args) throws Exception {

		log.info("Course -> " + repository.findById(100001l));
		//repository.deleteById(100001l);
	}

}
