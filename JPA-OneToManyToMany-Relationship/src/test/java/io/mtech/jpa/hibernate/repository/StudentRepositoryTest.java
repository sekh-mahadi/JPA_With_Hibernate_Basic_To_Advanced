package io.mtech.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.mtech.jpa.hibernate.entity.Passport;
import io.mtech.jpa.hibernate.entity.Student;
import io.mtech.jpa.hibernate.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	StudentRepository repo;

	@Autowired
	EntityManager em;
	
	@Test
	public void someTest() {
		repo.someOperationToUnderstandPersistenceContext();
	}

	
	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student = em.find(Student.class, 20001L);
		log.info("Student -> {}", student);
		log.info("Student -> {}", student.getPassport());
//assertEquals("Spring Advanced", student.getName());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
	Passport passport = em.find(Passport.class, 40001L);
		log.info("Passport -> {}", passport);
		log.info("Student -> {}", passport.getStudent());
//assertEquals("Spring Advanced", student.getName());
	}
}
