package io.mtech.jdbctojpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jdbctojpa.entity.Person;
import io.mtech.jdbctojpa.repo.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;

//@SpringBootApplication
@Slf4j
public class JdbcToJpaApplication implements CommandLineRunner {
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcToJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("All Person List:\n" + dao.findAll());
		log.info("Person Id: " + dao.findById(10001));
		log.info("Add person: "+ dao.addPerson(new Person(10005, "Arisha", "Bhola", new SimpleDateFormat("yyyy-mm-dd").parse("2016-11-26"))));
		log.info("update person: "+ dao.updatePerson(new Person(10001, "Sekh Maenul Islam", "Dhaka", new SimpleDateFormat("yyyy-mm-dd").parse("1988-12-03"))));
		log.info("Person Id: " + dao.findById(10001));
		//log.info("Person Id deleted : "+ dao.deleteById(10002));
	}

}
