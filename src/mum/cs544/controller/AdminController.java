package mum.cs544.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs544.domain.Course;
import mum.cs544.service.CourseService;

@Controller
public class AdminController {
	
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/pendingCourses", method = RequestMethod.GET)
	public String pendingProducts(Course course, Model model) {
		List<Course> cour = courseService.findPendingCourses("pending");
		model.addAttribute("Courses", cour);

		if (cour.isEmpty()) {
			model.addAttribute("noCourse", "No Pending Course");
		}

		return "instructorCourses";
	}

	@RequestMapping(value = "/approveCourse")
	public String approveCourse(@ModelAttribute Course course,
			@RequestParam("id") Integer id, Model model, Principal principal) {

		Course newCourse = courseService.getCourse(id);
		newCourse.setStatus("approved");

		courseService.save(newCourse);

		return "redirect:/pendingCourses";
	}

	@RequestMapping(value = "/disapproveCourse")
	public String disapproveCourse(@ModelAttribute Course course,
			@RequestParam("id") Integer id, Model model) {

		Course newproduct = courseService.getCourse(id);
		newproduct.setStatus("disapproved");

		courseService.save(newproduct);

		return "redirect:/pendingCourses";

	}
	


}
