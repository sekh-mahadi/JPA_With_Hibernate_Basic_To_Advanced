package io.mtech.jdbctojpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jdbctojpa.entity.Person;
import io.mtech.jdbctojpa.repo.PersonJdbcDao;
import io.mtech.jdbctojpa.repo.PersonJpaRepo;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JpaApplicationDemo implements CommandLineRunner {
	@Autowired
	PersonJpaRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplicationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("All Person List:\n" + dao.findAll());
		log.info("Person Id: " + repo.findById(10001));

		log.info("Add person: " + repo.insertPerson(
				new Person(10005, "Hobu Bou", "Bhola", new SimpleDateFormat("yyyy-mm-dd").parse("1998-11-20"))));
		log.info("Update person: " + repo.updatePerson(
				new Person(10001, "Sekh Mahadi", "Bhola", new SimpleDateFormat("yyyy-mm-dd").parse("1990-01-01"))));
		repo.deleteById(10001);

		log.info("All Person: " + repo.findAll());

		/*
		 * new SimpleDateFormat("yyyy-mm-dd").parse("2016-11-26"))));
		 * log.info("update person: "+ dao.updatePerson(new Person(10001,
		 * "Sekh Maenul Islam", "Dhaka", new
		 * SimpleDateFormat("yyyy-mm-dd").parse("1988-12-03")))); log.info("Person Id: "
		 * + dao.findById(10001));
		 */
		// log.info("Person Id deleted : "+ dao.deleteById(10002));
	}

}
