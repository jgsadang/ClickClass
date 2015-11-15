package mum.cs544.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.domain.Instructor;
import mum.cs544.domain.Student;
import mum.cs544.service.InstructorService;
import mum.cs544.service.StudentService;

@Controller
public class RegistrationController {
	
	
	@Autowired
   StudentService studentService;
	
	@Autowired
	InstructorService instructorService;
	
	
	
	@RequestMapping(value="/studentSignUp", method=RequestMethod.GET)
	public String StudentSignUp(@ModelAttribute Student student){
			
		return "studentSignUp";
	}
	
	@RequestMapping(value="/studentSignUp", method=RequestMethod.POST)
	public String processStudentSignUp(@ModelAttribute("student") Student student){
		System.out.println(student.getAddress().getCity());
		
		student.getUser().getAuthority().setUsername(student.getUser().getUsername());
		studentService.saveStudent(student);
		return "redirect:/welcome";
	}
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.GET)
	public String instructorSignup(@ModelAttribute Instructor instructor){
			
		return "instructorSignUp";
	}
	
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.POST)
	public String processInstructorSignUp(@ModelAttribute Instructor instructor){
		instructor.getUser().getAuthority().setUsername(instructor.getUser().getUsername());
		instructorService.saveInstructor(instructor);
		return "redirect:/welcome";
	}
}
