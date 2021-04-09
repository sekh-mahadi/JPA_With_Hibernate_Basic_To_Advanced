package io.mtech.jdbctojpa.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.mtech.jdbctojpa.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate template;

	// Custom RowMapper
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();

			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("birth_date"));
			return person;
		}

	}

	// insert single person by Id
	public int addPerson(Person person) {
		return template.update("insert into person (id, name, location, birth_date) " + "values(?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirthDate() });
	}

	// insert single person by Id
	public int updatePerson(Person person) {
		return template.update(
				"update person" + " set name = ? , location = ?, birth_date = ? where id = " + person.getId(),
				new Object[] { person.getName(), person.getLocation(), person.getBirthDate() });
	}

	// select *from person
	public List<Person> findAll() {
		return template.query("select *from person", new PersonRowMapper());
	}

	// find single person by Id
	public Person findById(int id) {
		return template.queryForObject("select *from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	// delete single person by Id
	public int deleteById(int id) {
		return template.update("delete from person where id=?", new Object[] { id });
	}
}
