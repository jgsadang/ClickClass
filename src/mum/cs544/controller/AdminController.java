/*package mum.cs544.controller;

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
	
	@RequestMapping(value = "/pendingProducts", method = RequestMethod.GET)
	public String pendingProducts(Course course, Model model) {
		List<Course> p = courseService.findPendingCourses();
		model.addAttribute("Courses", p);

		if (p.isEmpty()) {
			model.addAttribute("noproduct", "empty");
		}

		return "pendingProducts";
	}

	@RequestMapping(value = "/approveCourse")
	public String approveCourse(@ModelAttribute Course course,
			@RequestParam("id") String id, Model model, Principal principal) {

		Course newCourse = courseService.find(Long.parseLong(id));
		course.setApproval("approved");

		courseService.save(newCourse);

		return "redirect:/pendingProducts";
	}

	@RequestMapping(value = "/disapproveProduct")
	public String disapproveCourse(@ModelAttribute Product product,
			@RequestParam("id") String id, Model model) {

		Course newproduct = courseService.find(Long.parseLong(id));
		newproduct.setApproval("disapproved");

		courseService.save(newproduct);

		return "redirect:/pendingProducts";

	}
	


}
*/