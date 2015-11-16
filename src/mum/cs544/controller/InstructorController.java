package mum.cs544.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.domain.Course;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;



public class InstructorController {
	
	@Autowired
	InstructorService instructorService;
	@Autowired
	CourseService courseService;
	
	
	
	@RequestMapping(value = "/myProducts", method = RequestMethod.GET)
	public String getItemById(Model model, Principal principal) {
		String name = principal.getName();
		List<Course> myCourses = courseService
				.getCoursesByInstructorId(instructorService.getInstructorByUserName(
						name).getId());

		if (myCourses.isEmpty()) {
			// System.out.println("true");
			model.addAttribute("emptylist", "true");
		}

		model.addAttribute("instructorCourses", myCourses);

		return "myProducts";
	}

	@RequestMapping("/vendor")
	public String getVendorPage(Model model) {

		return "VendorPage";
	}

}
