package io.mtech.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Review;
import io.mtech.jpa.hibernate.repo.CourseRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//(classes = { JpaAdvancedApplication.class, CourseRepository.class })
//@ContextConfiguration(classes = {JpaAdvancedApplication.class, CourseRepository.class})
@ContextConfiguration
@Slf4j
class CourseRepositoryTest {

	@Autowired
	CourseRepository repo;

	@Test
	void contextLoads() {
		/*
		 * Course course = repo.findById(100002l); assertEquals("Spring Advanced",
		 * course.getName());
		 */
	}

	@Test
	@Transactional
	public void findById_Course_firstLevelCacheDemo() {
		Course course = repo.findByName("Jpa Advanced");
		// log.info("First Course Retrieved -> {}", course);

		/*
		 * Optional<Course> courseOptional = repo.findById(10001L);
		 * log.info("First Course Retrieved -> {}", courseOptional.get());
		 * 
		 * assertEquals(true, courseOptional.isPresent());
		 */
		Course course1 = repo.findByName("Jpa Advanced");
		log.info("First Course Retrieved again -> {}", course1);

		/*
		 * Optional<Course> courseOptional1 = repo.findById(10001L);
		 * log.info("First Course Retrieved again -> {}", courseOptional1.get());
		 * 
		 * assertEquals(true, courseOptional1.isPresent());
		 */
		assertEquals(10001L, course.getId());
		assertEquals(10001L, course1.getId());

	}

	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repo.findById(10002L);
		// assertEquals(true, courseOptional.isPresent());
		log.info("{}", courseOptional.isPresent());

	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repo.findById(20002L);
		// assertEquals(true, courseOptional.isPresent());
		log.info("{}", courseOptional.isPresent());
	}

	@Test
	public void plaayingAroundWithSpringDataRepository() {
		// Insert
		Course course = new Course("Reacti Native 20 steps.");
		repo.save(course);

		// Update
		course.setName("Reacti Native 20 steps.-Updated");
		repo.save(course);

		// Find All
		log.info("All Aourses: -> {}", repo.findAll());
		log.info("Count: -> {}", repo.count());

	}

	@Test
	public void sort() {
		// Sorting Courses By Name
		// Sort sort = Sort.by(Sort.Direction.DESC, "name");
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		log.info("Sorted Courses: -> {}", repo.findAll(sort));
	}

	@Test
	public void pagination() {
		// Pagination Courses
		// Pageable pageRequest = PageRequest.of(0, 3);
		PageRequest pageRequest = PageRequest.of(0, 3);

		Page<Course> firsePage = repo.findAll(pageRequest);
		log.info("First page -> {}", firsePage);

		Pageable secondPageable = firsePage.nextPageable();

		Page<Course> secondPage = repo.findAll(secondPageable);
		log.info("Second page -> {}", secondPage.getContent());
	}

	@Test
	public void findByName() {
		log.info("Find By Name: {}", repo.findByName("Jpa Advanced"));
	}
}
