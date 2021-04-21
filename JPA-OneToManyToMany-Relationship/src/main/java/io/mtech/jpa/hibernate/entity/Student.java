package io.mtech.jpa.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Exclude
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Passport passport;

	@ManyToMany
	private List<Course> courses = new ArrayList<>();

	public Student(String name) {
		this.name = name;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
}
