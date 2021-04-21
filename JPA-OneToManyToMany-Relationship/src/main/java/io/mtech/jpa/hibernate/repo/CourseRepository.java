package io.mtech.jpa.hibernate.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Review;
import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class CourseRepository {

	@Autowired
	EntityManager eManager;

	public Course findById(Long id) {
		return eManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		eManager.remove(course);
	}

//Insert and Update
	public Course save(Course course) {
		if (course.getId() == null) {
			// insert Course
			eManager.persist(course);
		} else {
			eManager.merge(course);
		}
		return course;
	}

	public void playWithEntityManager() {
		log.info("playWithEntityManager - Started");
		Course course1 = new Course("Web Services Basic to advanced");
		eManager.persist(course1);

		Course course2 = new Course("Angular Basic to advanced");
		eManager.persist(course2);

		/*
		 * Course course3 = findById(100002l);
		 * course3.setName("Spring Advanced- Updated.");
		 */
		eManager.flush();

		/*
		 * //Use flush not track in DB eManager.detach(course1);
		 * eManager.detach(course2);
		 */
		// use clear() instead of flush() for not track in database
		// eManager.clear();

		course1.setName("Web Services Basic to advanced - Updated.");
		course2.setName("Angular Basic to advanced - Updated.");
		eManager.refresh(course1);
		eManager.flush();
	}

	public void addHardCodedReviewsForCourse() {
		// retrieve Course 10003
		Course course = findById(10003L);
		log.info("Course Reviews -> {}", course.getReviews());
		// add 2 reviews to it
		Review review1 = new Review("5", "Great Hands-on Stuff.");
		Review review2 = new Review("5", "Great Stuff.");

		// Setting the relationship
		course.addReviews(review1);
		review1.setCourse(course);

		course.addReviews(review2);
		review2.setCourse(course);
		// save it to database
		eManager.persist(review1);
		eManager.persist(review2);

	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		// retrieve Course 10003
		Course course = findById(courseId);
		log.info("Course Reviews -> {}", course.getReviews());
		// add 2 reviews to it
		for (Review review : reviews) {

			// Setting the relationship
			course.addReviews(review);
			review.setCourse(course);
			// save it to database
			eManager.persist(review);
		}
	}
}
