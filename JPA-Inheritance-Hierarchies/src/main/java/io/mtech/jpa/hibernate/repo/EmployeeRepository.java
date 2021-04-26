package io.mtech.jpa.hibernate.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Employee;
import io.mtech.jpa.hibernate.entity.FullTimeEmployee;
import io.mtech.jpa.hibernate.entity.PartTimeEmployee;
import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class EmployeeRepository {

	@Autowired
	EntityManager eManager;

	// insert Employee
	public void insert(Employee employee) {
		eManager.persist(employee);
	}

	public List<PartTimeEmployee> allPartTimeEmployees() {
		return eManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> allFullTimeEmployees() {
		return eManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
