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
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class NativeQueriesTest {
	@Autowired
	EntityManager em;

	@Test
	public void native_queries_Basic() {
		/*Native Queries */
		Query query = em.createNativeQuery("Select *from Course", Course.class);
		List<?> resultList = query.getResultList();
		log.info("Select *from Course -> {}", resultList);
	}

	@Test
	public void native_queries_with_parameter() {
		/*Native Queries */
		Query query = em.createNativeQuery("Select *from Course where id = ?", Course.class);
		query.setParameter(1, 100001l);
		List<?> resultList = query.getResultList();
		log.info("Select *from Course where id = ? -> {}", resultList);
	}
	
	@Test
	public void native_queries_named_parameter() {
		/*Native Queries */
		Query query = em.createNativeQuery("Select *from Course where id = :id", Course.class);
		query.setParameter("id", 100001l);
		List<?> resultList = query.getResultList();
		log.info("Select *from Course where id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		/*Native Queries */
		Query query = em.createNativeQuery("Update Course set last_updated_date=sysdate()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		log.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
	}
	/*
	 * @Test public void jpql_Typed() { For JPQL // TypedQuery<?> query =
	 * em.createQuery("Select c from Course c", Course.class); For NamedQuery
	 * TypedQuery<?> query = em.createNamedQuery("query_get_all_courses",
	 * Course.class);
	 * 
	 * List<?> resultList = query.getResultList();
	 * log.info("Select c from Course c -> {}", resultList); }
	 * 
	 * @Test public void jpql_where() { TypedQuery<?> query =
	 * em.createNamedQuery("get_updated_courses", Course.class); List<?> resultList
	 * = query.getResultList();
	 * log.info("Select c from Course c where name like '%Updated.'-> {}",
	 * resultList); }
	 */
}
