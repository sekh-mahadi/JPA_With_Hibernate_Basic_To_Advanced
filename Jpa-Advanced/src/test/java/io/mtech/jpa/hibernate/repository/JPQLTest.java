package io.mtech.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.mtech.jpa.hibernate.entity.Course;
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
}
