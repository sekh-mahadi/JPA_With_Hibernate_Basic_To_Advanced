package io.mtech.jpa.hibernate.repo;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Passport;
import io.mtech.jpa.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class StudentRepository {

	@Autowired
	EntityManager eManager;
	


	public Student findById(Long id) {
		return eManager.find(Student.class, id);
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		eManager.remove(student);
	}

//Insert and Update
	public Student save(Student student) {
		if (student.getId() == null) {
			// insert Student
			eManager.persist(student);
		} else {
			eManager.merge(student);
		}
		return student;
	}
	public void someOperationToUnderstandPersistenceContext() {
		// Database Operation 1 -> Retrieve Student
		Student student = eManager.find(Student.class, 20001L);
		// Persistence Context(Student)

		// Database Operation 2 -> Retrieve Passport
		Passport passport = student.getPassport();
		// Persistence Context(Student, Passport)

		// Database Operation 3 -> Update Passport
		passport.setNumber("GF102011");
		// Persistence Context(Student, Passport++)

		// Database Operation 4 -> Update Student
		student.setName("Sekh Mahadi-Update.");
		// Persistence Context(Student++, Passport++)

//assertEquals("Spring Advanced", student.getName());
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("MA30012");
		eManager.persist(passport);
		
		Student student = new Student("Arisha");
		student.setPassport(passport);
		eManager.persist(student);

		/*
		 * Student student3 = findById(100002l);
		 * student3.setName("Spring Advanced- Updated.");
		 */
		eManager.flush();

		/*
		 * //Use flush not track in DB eManager.detach(student1);
		 * eManager.detach(student2);
		 */
		// use clear() instead of flush() for not track in database
		// eManager.clear();
	}
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Ariba");
		Course course = new Course("Kubernates and Docker");
		
		eManager.persist(student);
		eManager.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		
		eManager.persist(student);
		
	}
	public void insertStudentAndCourse(Student student, Course course) {
//		Student student = new Student("Ariba");
//		Course course = new Course("Kubernates and Docker");
		
		student.addCourse(course);
		course.addStudent(student);
		
		eManager.persist(student);
		eManager.persist(course);		
	}
	
	public void insertCourseAndStudent( Course course, Student student) {
//		Student student = new Student("Ariba");
//		Course course = new Course("Kubernates and Docker");
		
		student.addCourse(course);
		course.addStudent(student);
		
		eManager.persist(student);
		eManager.persist(course);
	}
}
