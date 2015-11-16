package mum.cs544.service;




import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.domain.Student;

public interface AttendanceService {
	public void save(Attendance attendance);
	public Attendance getAttendance(Student student, Course course);
}
