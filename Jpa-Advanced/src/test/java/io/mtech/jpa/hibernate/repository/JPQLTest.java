package io.mtech.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.mtech.jpa.hibernate.entity.Course;
import io.mtech.jpa.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class JPQLTest {
	@Autowired
	EntityManager em;

	@Test
	public void jpql_Basic() {
		/* for JPQL */
		// Query query = em.createQuery("Select c from Course c");
		/* For NamedQuery */
		Query query = em.createNamedQuery("query_get_all_courses");
		List<?> resultList = query.getResultList();
		log.info("Select c from Course c -> {}", resultList);
	}

	@Test
	public void jpql_Typed() {
		/* For JPQL */
		// TypedQuery<?> query = em.createQuery("Select c from Course c", Course.class);
		/* For NamedQuery */
		TypedQuery<?> query = em.createNamedQuery("query_get_all_courses", Course.class);

		List<?> resultList = query.getResultList();
		log.info("Select c from Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<?> query = em.createNamedQuery("get_updated_courses", Course.class);
		List<?> resultList = query.getResultList();
		log.info("Select c from Course c where name like '%Updated.'-> {}", resultList);
	}

	@Test
	@Transactional
	public void jpql_Courses_Without_Students() {
		TypedQuery<?> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<?> resultList = query.getResultList();
		log.info("ResultList: -> {}", resultList);
	}

	@Test
	@Transactional
	public void jpql_Courses_atleast_2_Students() {
		TypedQuery<?> query = em.createQuery("select c from Course c where size(c.students) >=2", Course.class);
		List<?> resultList = query.getResultList();
		log.info("ResultList: -> {}", resultList);
	}

	@Test
	@Transactional
	public void jpql_Courses_Ordered_by_Students() {
		TypedQuery<?> query = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
		List<?> resultList = query.getResultList();
		log.info("ResultList: -> {}", resultList);
	}

	@Test
	@Transactional
	public void jpql_Students_With_Passport_in_a_certain_pattern() {
		TypedQuery<?> query = em.createQuery("select s from Student s where s.passport.number like '%800%'",
				Student.class);
		List<?> resultList = query.getResultList();
		log.info("Student With Passport: -> {}", resultList);
	}

	// like
	// BETWEEN
	// IS NULL
	// upper, lower, trim, length

	// JOIN => Select c, s from Course c JOIN c.students s
	// LEFT JOIN => Select c, s from Course c JOIN c.students s
	// CROSS JOIN => Select c, s from Course c, Student s

	@Test
	@Transactional
	public void jpql_Join() {
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());

		for (Object[] result : resultList) {

			log.info("Course{} Student{}", result[0], result[1]);

		}
	}

	@Test
	@Transactional
	public void jpql_left_Join() {
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());

		for (Object[] result : resultList) {

			log.info("Course{} Student{}", result[0], result[1]);

		}
	}

	@Test
	@Transactional
	public void jpql_cross_Join() {
		Query query = em.createQuery("Select c, s from Course c ,Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result Size -> {}", resultList.size());

		for (Object[] result : resultList) {

			log.info("Course{} Student{}", result[0], result[1]);

		}
	}
}
