package mum.cs544.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.CourseDAO;
import mum.cs544.domain.Course;
import mum.cs544.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	public Course getCourse(int id) {
		return courseDAO.findOne(id);
	}
	
	public void save(Course course) {
		courseDAO.save(course);
	}


	@Override
	public List<Course> getCourseByTitle(String title) {
		
		
		return courseDAO. find(title);
	}

	@Override
	public List<Course> getCoursesByInstructorId(int id) {
		
		return courseDAO.findByInstructor_Id(id);
	}
	
	public List<Course> getCourses() {
		return courseDAO.findAll();

	}

	@Override
	public int deletById(int id) {
		return courseDAO.deleteById(id);
	}

	@Override
	public List<Course> findPendingCourses(String status) {
		
		return courseDAO.findByStatus(status);
	}
}
