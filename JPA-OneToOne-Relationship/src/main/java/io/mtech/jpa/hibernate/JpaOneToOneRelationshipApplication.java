package io.mtech.jpa.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jpa.hibernate.repo.CourseRepository;
import io.mtech.jpa.hibernate.repo.StudentRepository;

@SpringBootApplication
@SpringBootConfiguration
public class JpaOneToOneRelationshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneRelationshipApplication.class, args);
	}
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		courseRepository.playWithEntityManager();
		studentRepository.saveStudentWithPassport();
		/*
		 * repository.deleteById(100001l); repository.save(new
		 * Course(10004l,"Microservices basic to advanced"));
		 */
	}

}
