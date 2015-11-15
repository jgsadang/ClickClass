package mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.cs544.service.InstructorService;

@Controller
public class HomeController {
	/*@Autowired
	private InstructorService instructorServiceImpl;
	*/
	@RequestMapping("/")
	public String showMenu() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String showWelcomepage() {
		return "home";
	}
	
	
}
