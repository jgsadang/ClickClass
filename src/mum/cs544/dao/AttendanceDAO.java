package mum.cs544.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.domain.Student;

@Repository
public interface AttendanceDAO extends JpaRepository <Attendance, Integer>{
	
	public List<Attendance> findByStudent_Id(int id);
	public Attendance findByStudentAndCourse(Student student, Course course);
	public List<Attendance> findByDate(Date date);

}