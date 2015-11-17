package mum.cs544.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.AttendanceDAO;
import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.domain.Student;
import mum.cs544.service.AttendanceService;


@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService{

	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	public void save(Attendance attendance) {
		attendanceDAO.save(attendance);
	}
	
	public Attendance getAttendance(Student student, Course course) {
		return attendanceDAO.findByStudentAndCourse(student, course);
	}

	@Override
	public List<Attendance> getCourseByStudentId(int id) {
		
		return attendanceDAO.findByStudent_Id(id);
	}

}
