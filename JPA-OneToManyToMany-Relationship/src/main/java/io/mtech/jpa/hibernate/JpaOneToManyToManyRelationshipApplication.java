package io.mtech.jpa.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Review;
import io.mtech.jpa.hibernate.entity.Student;
import io.mtech.jpa.hibernate.repo.CourseRepository;
import io.mtech.jpa.hibernate.repo.StudentRepository;

@SpringBootApplication
@SpringBootConfiguration
public class JpaOneToManyToManyRelationshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyToManyRelationshipApplication.class, args);
	}

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		//courseRepository.playWithEntityManager();
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addHardCodedReviewsForCourse();

//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great Hands-on Stuff."));
//		reviews.add(new Review("5", "Great Stuff."));
//		courseRepository.addReviewsForCourse(10003L, reviews);
		/*
		 * repository.deleteById(100001l); repository.save(new
		 * Course(10004l,"Microservices basic to advanced"));
		 */
		//studentRepository.insertHardCodedStudentAndCourse();
		studentRepository.insertCourseAndStudent( new Course("Kubernates and Docker-updated.."), new Student("Tamanna"));
	}
}
