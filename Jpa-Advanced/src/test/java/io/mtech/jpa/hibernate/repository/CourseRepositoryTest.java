package io.mtech.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import io.mtech.jpa.hibernate.JpaAdvancedApplication;
import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.repo.CourseRepository;

@SpringBootTest(classes = JpaAdvancedApplication.class)
//@ContextConfiguration(classes = {JpaAdvancedApplication.class, CourseRepository.class})
class CourseRepositoryTest {
	@Autowired
	private CourseRepository repo;

	@Test
	void contextLoads() {
		/*
		 * Course course = repo.findById(100002l); assertEquals("Spring Advanced",
		 * course.getName());
		 */
	}

	@Test
	public void findById_Basic() {
		Course course = repo.findById(100002l);
		assertEquals("Spring Advanced", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_Basic() {
		repo.deleteById(100002l);
		assertNull(repo.findById(100002l));
	}

	@Test
	@DirtiesContext
	public void save_Basic() {
		// get a Course
		Course course = repo.findById(100002l);
		assertEquals("Spring Advanced", course.getName());

		// update details
		course.setName("Spring Advanced - updated");
		repo.save(course);
		// Check the value
		Course course1 = repo.findById(100002l);
		assertEquals("Spring Advanced - updated", course1.getName());

	}
}
