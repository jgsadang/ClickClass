package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Instructor;

@Repository
public interface InstructorDAO extends JpaRepository <Instructor, Integer>{
	
	
	@Query("SELECT i FROM Instructor i WHERE i.user.username = :userName")
	public Instructor findInstructorByUserName(@Param(value = "userName") String userName);

}
