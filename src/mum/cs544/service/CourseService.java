package mum.cs544.service;

import java.util.List;

import mum.cs544.domain.Course;

public interface CourseService {
	public void save(Course course);
	public Course getCourse(int id);
	public List<Course> getCourses();
}
