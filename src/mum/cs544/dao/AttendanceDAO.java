package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;

@Repository
public interface AttendanceDAO extends JpaRepository <Attendance, Integer>{
	
	public List<Attendance> findByStudent_Id(int id);

}
