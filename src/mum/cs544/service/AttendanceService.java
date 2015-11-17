package mum.cs544.service;

import java.util.List;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;

public interface AttendanceService {
	
	public void save(Attendance  att);
	
	public List<Attendance> getCourseByStudentId(int id);
}
