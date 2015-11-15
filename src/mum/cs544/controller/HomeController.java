package mum.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.cs544.domain.Course;
import mum.cs544.service.CourseService;

@Controller
public class HomeController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/")
	public String showHomepage(Model model) {
		List <Course> courses = courseService.getCourses();
		model.addAttribute("courses", courses);
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String showWelcomepage() {
		return "home";
	}
	
	
}