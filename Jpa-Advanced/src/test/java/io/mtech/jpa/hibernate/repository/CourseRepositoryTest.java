package io.mtech.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Autowired
	 EntityManager em;

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
	//@Transactional
	public void findById_Course_firstLevelCacheDemo() {
		Course course = repo.findById(10001L);
		 log.info("First Course Retrieved -> {}", course);

		/*
		 * Optional<Course> courseOptional = repo.findById(10001L);
		 * log.info("First Course Retrieved -> {}", courseOptional.get());
		 * 
		 * assertEquals(true, courseOptional.isPresent());
		 */
		Course course1 = repo.findById(10001L);
		log.info("First Course Retrieved again -> {}", course1);

		/*
		 * Optional<Course> courseOptional1 = repo.findById(10001L);
		 * log.info("First Course Retrieved again -> {}", courseOptional1.get());
		 * 
		 * assertEquals(true, courseOptional1.isPresent());
		 */
		assertEquals("Jpa Advanced", course.getName());
		assertEquals("Jpa Advanced", course1.getName());

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

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repo.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repo.findById(10001l);
		log.info("Course Reviews: {}", course.getReviews());

	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001l);
		log.info("Course Reviews: {}", review.getCourse());
	}
	
}
