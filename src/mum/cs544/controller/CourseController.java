package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.domain.Category;
import mum.cs544.domain.Course;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;

@Controller
public class CourseController {
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.GET)
	public String addCourse(Model model) {
		Category[] categories = Category.values();
		model.addAttribute("course", new Course());
		model.addAttribute("categories", categories);
		return "addCourse";
	}
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.POST)
	public String addCoursePost(Model model, Course course) {		
		course.setInstructor(instructorService.getInstructor(1));
		courseService.save(course);
		return "home";
	}
}
