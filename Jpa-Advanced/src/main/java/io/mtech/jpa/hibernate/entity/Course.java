package io.mtech.jpa.hibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "CourseDetails") if need one may use this annotation
//@NamedQuery(name = "query_get_all_courses", query = "select c from Course c")
@NamedQueries(value = {@NamedQuery( name = "query_get_all_courses", query = "select c from Course c"),
		@NamedQuery(name = "get_updated_courses", query = "Select c from Course c where name like '%Updated.'")})

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	
	public Course(String name) {
		this.name = name;
	}
}
