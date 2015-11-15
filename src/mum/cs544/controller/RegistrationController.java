package mum.cs544.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.domain.Instructor;
import mum.cs544.domain.Student;
import mum.cs544.service.StudentService;

@Controller
public class RegistrationController {
	
	/*
	@Autowired
   StudentService studentService;*/
	
	/*public void setStudentService(StudentService studentService){
		this.studentService=studentService;
	}
*/
	
	@RequestMapping(value="/studentSignUp", method=RequestMethod.GET)
	public String StudentSignUp(@ModelAttribute Student student){
			
		return "studentSignUp";
	}
	
	@RequestMapping(value="/StudentSignUp", method=RequestMethod.POST)
	public String processStudentSignUp(@Valid @ModelAttribute Student student){
	
		//studentService.saveStudent(student);
		return "redirect:/welcome";
	}
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.GET)
	public String instructorSignup(@ModelAttribute Instructor instructor){
			
		return "instructorSignUp";
	}
	
	@RequestMapping(value="/instructorSignUp", method=RequestMethod.POST)
	public String processInstructorSignUp(@Valid @ModelAttribute Instructor instructor){
	
		
		return "redirect:/welcome";
	}
}
