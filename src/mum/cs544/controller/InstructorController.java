package mum.cs544.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.service.AttendanceService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;


@Controller
public class InstructorController {
	
	@Autowired
	InstructorService instructorService;
	@Autowired
	CourseService courseService;
	
	@Autowired
	AttendanceService attendanceService;
	
	
	
	@RequestMapping(value = "/myCourses", method = RequestMethod.GET)
	public String getCourseById(Model model, Principal principal) {
		
		System.out.println(principal.getName());
		String name = principal.getName();
		List<Course> myCourses = courseService
				.getCoursesByInstructorId(instructorService.getInstructorByUserName(
						name).getId());

		if (myCourses.isEmpty()) {
			// System.out.println("true");
			model.addAttribute("emptylist", "true");
		}

		model.addAttribute("Courses", myCourses);

		return "instructorCourses";
	}
	
	
	
	

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public String deleteCourse(Model model, @RequestParam("id") String id ,
			RedirectAttributes redirectAttributes) {
		
		
	
		List<Attendance> lists = attendanceService.getAll();
		
		for (Attendance att : lists){
			if (att.getCourse().getId() == Integer.parseInt(id)){
				
				redirectAttributes.addFlashAttribute("error" ,"can not be deleted user already Enrolled in your Course");
				return "redirect:/myCourses";
			}
		}
		
		int delId =courseService.deletById(Integer.parseInt(id));
		
		return "redirect:/myCourses";

	}
}
