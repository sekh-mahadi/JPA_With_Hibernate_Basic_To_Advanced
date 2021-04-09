package io.mtech.jdbctojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mtech.jdbctojpa.entity.Person;
import io.mtech.jdbctojpa.repo.PersonJpaRepo;

@Controller
@ResponseBody
public class PersonJpaController {
	
	@Autowired
	private PersonJpaRepo jpaRepo;

	@RequestMapping(value = "/singlePerson/{id}", method = RequestMethod.GET)
	public Person findById(@PathVariable int id) {
		return jpaRepo.findById(id);
	}
	
	@RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		return jpaRepo.insertPerson(person);
	}
	@RequestMapping(value = "/updatePerson", method = RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person) {
		return jpaRepo.updatePerson(person);
	}
	@RequestMapping(value = "/all_persons", method = RequestMethod.GET)
	public List<Person> findAllPersons(){
		return jpaRepo.findAll();
	}
}
