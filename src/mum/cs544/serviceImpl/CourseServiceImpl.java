package mum.cs544.serviceImpl;

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
}
