package io.mtech.jpa.hibernate;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mtech.jpa.hibernate.entity.FullTimeEmployee;
import io.mtech.jpa.hibernate.entity.PartTimeEmployee;
import io.mtech.jpa.hibernate.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JpaInheritanceHierarchiesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaInheritanceHierarchiesApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		// Sekh-Full time Employee wage-1000$
		// Rupon-Part time Employee wage-100$
		employeeRepository.insert(new PartTimeEmployee("Shekh Rupon", new BigDecimal("100")));
		employeeRepository.insert(new FullTimeEmployee("Sekh Mahadi", new BigDecimal("1000")));
		log.info("All Full time Employess:->{} ", employeeRepository.allPartTimeEmployees());
		log.info("All Part time Employess:->{} ", employeeRepository.allFullTimeEmployees());

	}
}