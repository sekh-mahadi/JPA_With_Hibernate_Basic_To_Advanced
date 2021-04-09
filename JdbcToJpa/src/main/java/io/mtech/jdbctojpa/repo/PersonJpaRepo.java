package io.mtech.jdbctojpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jdbctojpa.entity.Person;
import io.mtech.jdbctojpa.repo.PersonJdbcDao.PersonRowMapper;
import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class PersonJpaRepo {
	@PersistenceContext
	// @Autowired
	private EntityManager em;

	// find person by id
	public Person findById(int id) {
		return em.find(Person.class, id);
	}

	// insert person
	public Person insertPerson(Person person) {
		return em.merge(person);
	}

	// update person
	public Person updatePerson(Person person) {
		return em.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		log.info("Delete Person: " + person);
		em.remove(person);
	}

	// select *from person
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = em.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

}
