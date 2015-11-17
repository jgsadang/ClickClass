package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	
	public Student findByUser_Username(String userName);
	

}
