package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	/*@Query("SELECT s FROM Student s WHERE s.user.username = :userName")
	public Instructor findStudentByUserName(@Param(value = "userName") String userName);*/

	public Student findByUser_Username(String userName);
	
	/*@Query("update Student s where s.id = ?1")
	public void updateStudent(int studentId);*/
}
