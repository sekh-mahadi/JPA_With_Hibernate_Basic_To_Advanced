package io.mtech.jpa.hibernate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import io.mtech.jpa.hibernate.entity.Course;

@Repository
@RepositoryRestResource(path = "courses")
public interface CourseRepository extends JpaRepository<Course, Long> {
	public Course findByName(String name);

	List<Course> findByNameAndId(String name, Long id);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	@Query("select c from Course c where name like '%Advanced'")
	List<Course> courseWithAdvancedInName();

	@Query(value = "select * from Course where name like '%Advanced'", nativeQuery = true)
	List<Course> courseWithAdvancedInNameUsingNativeQuery();

	@Query(name = "get_updated_courses")
	List<Course> courseWithAdvancedInNameUsingNamedQuery();

}
