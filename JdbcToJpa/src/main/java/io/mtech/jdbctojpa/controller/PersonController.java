package io.mtech.jdbctojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mtech.jdbctojpa.entity.Person;
import io.mtech.jdbctojpa.repo.PersonJdbcDao;

@Service
@RestController
public class PersonController {
	@Autowired
	private PersonJdbcDao dao;

	@RequestMapping(value = "/all_person", method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		return dao.findAll();
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public int addPerson(Person person) {
		return dao.addPerson(person);
	}

	@RequestMapping(value = "/findPerson/{id}", method = RequestMethod.GET)
	public Person findById(@PathVariable int id) {
		return dao.findById(id);
	}

	@DeleteMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable int id) {
		dao.deleteById(id);
	}

	@PostMapping("/update_person")
	public int upadatePerson(Person person) {
		return dao.updatePerson(person);
	}

}
