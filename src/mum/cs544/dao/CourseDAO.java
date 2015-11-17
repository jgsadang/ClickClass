package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Course;

@Repository
public interface CourseDAO extends JpaRepository <Course, Integer>{
	
	@Query("select c from Course c where c.title like ?1%")
	    public List<Course> find(String title);
	
	//List<Course> findByTitleStartsWith(String title);

	
	public List<Course> findByInstructor_Id(int id );
	
	int deleteById(int id);
	
	public List<Course> findByStatus(String status);

}
