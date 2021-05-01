package io.mtech.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.mtech.jpa.hibernate.entity.Course;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class CriteriaQueryTest {
	@Autowired
	EntityManager em;

	@Test
	public void all_Courses() {
		/* Criteria Queries */
		// "Select c From Course c"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		// 3. Define Predicates etc using Criteria Builder

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Select *from Course -> {}", resultList);
	}

	@Test
	@Transactional
	public void all_Courses_having_advanced() {
		/* Criteria Queries */
		// "Select c From Course c where name like '%Advanced' "
		
		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		// 3. Define Predicates etc using Criteria Builder
		Predicate likeAdvanced = cb.like(courseRoot.get("name"), "%Advanced");
		// 4. Add Predicates etc to the Criteria Query
		cq.where(likeAdvanced);
		// 5. Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Select from Course -> {}", resultList);
	}
	
	@Test
	public void all_Courses_without_students() {
		/* Criteria Queries */
		// "Select c From Course c where c.students is empty"
		
		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		// 3. Define Predicates etc using Criteria Builder
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		// 4. Add Predicates etc to the Criteria Query
		cq.where(studentsIsEmpty);
		// 5. Build the TypedQuery using the entity manager and criteria query

		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		log.info("Typed Result -> {}", resultList);
	}
	@Test
	public void join() {
		// "Select c From Course c join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		log.info("Typed Query -> {}", resultList);
		//[Course(id=10001, name=Jpa Advanced)][Course(id=10001, name=Jpa Advanced)]
		//[Course(id=10001, name=Jpa Advanced)] [Course(id=10003, name=Spring Boot Advanced)]
	}
	@Test
	public void left_join() {
		// "Select c From Course c join c.students s"

		// 1. Use Criteria Builder to create a Criteria Query returning the
		// expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define Predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		// 4. Add Predicates etc to the Criteria Query

		// 5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = query.getResultList();

		log.info("Typed Query -> {}", resultList);
		//[Course(id=10001, name=Jpa Advanced)][Course(id=10001, name=Jpa Advanced)]
		//[Course(id=10001, name=Jpa Advanced)] [Course(id=10003, name=Spring Boot Advanced)]
	}
}
