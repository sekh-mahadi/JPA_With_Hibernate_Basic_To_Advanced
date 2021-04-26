package io.mtech.jpa.hibernate;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Employee;
import io.mtech.jpa.hibernate.entity.FullTimeEmployee;
import io.mtech.jpa.hibernate.entity.PartTimeEmployee;
import io.mtech.jpa.hibernate.entity.Student;
import io.mtech.jpa.hibernate.repo.CourseRepository;
import io.mtech.jpa.hibernate.repo.EmployeeRepository;
import io.mtech.jpa.hibernate.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@SpringBootConfiguration
public class JpaAdvancedApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		// courseRepository.playWithEntityManager();
		// studentRepository.saveStudentWithPassport();
		// courseRepository.addHardCodedReviewsForCourse();

//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great Hands-on Stuff."));
//		reviews.add(new Review("5", "Great Stuff."));
//		courseRepository.addReviewsForCourse(10003L, reviews);
		/*
		 * repository.deleteById(100001l); repository.save(new
		 * Course(10004l,"Microservices basic to advanced"));
		 */
		// studentRepository.insertHardCodedStudentAndCourse();
		// studentRepository.insertCourseAndStudent( new Course("Kubernates and
		// Docker-updated.."), new Student("Tamanna"));
		
		//Sekh-Full time Employee wage-1000$
		//Rupon-Part time Employee wage-100$
		employeeRepository.insert(new PartTimeEmployee("Shekh Rupon", new BigDecimal("100")));
		employeeRepository.insert(new FullTimeEmployee("Sekh Mahadi", new BigDecimal("1000")));
		log.info("All Full time Employess:->{} ", employeeRepository.allPartTimeEmployees());
		log.info("All Part time Employess:->{} ", employeeRepository.allFullTimeEmployees());

	}

}
