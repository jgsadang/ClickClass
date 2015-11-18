package mum.cs544.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.cs544.domain.Administrator;
import mum.cs544.domain.Instructor;
import mum.cs544.domain.Student;
import mum.cs544.service.AdminService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;
import mum.cs544.service.StudentService;

@Controller

public class RegistrationController {
	
	
	@Autowired
   StudentService studentService;
	
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	AdminService adminService;
	
	
	
	@RequestMapping(value="/studentSignUp", method=RequestMethod.GET)
	public String StudentSignUp(@ModelAttribute Student student){
			
		return "studentSignUp";
	}
	
	@RequestMapping(value="/studentSignUp", method=RequestMethod.POST)
	public String processStudentSignUp(@Valid @ModelAttribute("student") Student student ,
			BindingResult result){
		if(result.hasErrors()){
			return "studentSignUp";
		}
		student.getUser().getAuthority().setUsername(student.getUser().getUsername());
		studentService.saveStudent(student);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.GET)
	public String instructorSignup(@ModelAttribute Instructor instructor){
			
		return "instructorSignUp";
	}
	
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.POST)
	public String processInstructorSignUp(@Valid @ModelAttribute Instructor instructor
			,BindingResult result){
		
		if(result.hasErrors()){
			return "instructorSignUp";
		}
		instructor.getUser().getAuthority().setUsername(instructor.getUser().getUsername());
		instructorService.saveInstructor(instructor);
		return "redirect:/";
	}
	
	@RequestMapping(value="/administratorSignUp", method=RequestMethod.GET)
	public String administratorSignUp(@ModelAttribute Administrator administrator){
			
		return "administratorSignUp";
	}
	
	@RequestMapping(value="/administratorSignUp", method=RequestMethod.POST)
	public String processAdminstratorSignUp(@Valid @ModelAttribute("administrator") Administrator administrator ,
			BindingResult result){
		if (result.hasErrors()) {
			return "administratorSignUp";
		}
		administrator.getUser().getAuthority().setUsername(administrator.getUser().getUsername());
		adminService.saveAdministrator(administrator);
		return "redirect:/";
	}
	
	
	
	
	
	

}
