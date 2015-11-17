package mum.cs544.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.domain.Attendance;
import mum.cs544.service.AttendanceService;
import mum.cs544.service.CourseService;
import mum.cs544.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	
	@Autowired
	AttendanceService attendanceService;
	
	
	
	@RequestMapping(value = "/studentCourses", method = RequestMethod.GET)
	public String getCourseById(Model model, Principal principal) {
		
		String name = principal.getName();
		
		
		List<Attendance> stCourses = attendanceService.getCourseByStudentId(studentService.getStudentByUserName(
						name).getId());

		if (stCourses.isEmpty()) {
			// System.out.println("true");
			model.addAttribute("emptylist", "true");
		}

		model.addAttribute("stCourses", stCourses);

		return "studentCourses";
	}

}
