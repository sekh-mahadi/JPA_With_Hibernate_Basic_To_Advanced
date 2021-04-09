package io.mtech.jdbctojpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String location;
	private Date birthDate;

	public Person(String name, String location, Date birthDate) {
		
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
}