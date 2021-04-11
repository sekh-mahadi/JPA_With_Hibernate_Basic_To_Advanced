package io.mtech.jpa.hibernate.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Course;

@Repository
@Transactional
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

}
