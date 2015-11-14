package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.cs544.serviceImpl.InstructorServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;
	
	@RequestMapping("/")
	public String showMenu() {
		return "home";
	}
}
