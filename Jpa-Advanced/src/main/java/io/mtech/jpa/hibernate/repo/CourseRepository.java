package io.mtech.jpa.hibernate.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Course;
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
		eManager.flush();
	
		/*//Use flush not track in DB
		 * eManager.detach(course1); eManager.detach(course2);
		 */
		// use clear() instead of flush() for not track in database
		//eManager.clear();
		
		course1.setName("Web Services Basic to advanced - Updated.");
		course2.setName("Angular Basic to advanced - Updated.");
		eManager.refresh(course1);
		eManager.flush();
	}
}
