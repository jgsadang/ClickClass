package mum.cs544.service;




import java.util.List;

import mum.cs544.domain.Course;

public interface CourseService {
	public void save(Course course);

	
	public List<Course> getCourseByTitle(String title);
	
	public List<Course> getCoursesByInstructorId (int id);

	public Course getCourse(int id);
	public List<Course> getCourses(String status);
	
	public int deletById(int id );
	
	public List<Course> findPendingCourses(String status);

}
