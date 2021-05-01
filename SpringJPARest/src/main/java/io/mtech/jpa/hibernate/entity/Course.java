package io.mtech.jpa.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
		@NamedQuery(name = "get_updated_courses", query = "Select c from Course c where name like '%Updated.'") })
@Cacheable
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Setter(value = AccessLevel.NONE)
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	@ToString.Exclude
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	@UpdateTimestamp
	@ToString.Exclude
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	@ToString.Exclude
	private LocalDateTime createdDate;

	public Course(String name) {
		this.name = name;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}

	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
}
