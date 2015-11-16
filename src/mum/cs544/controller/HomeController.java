package mum.cs544.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String showMenu() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String showWelcomepage() {
		return "home";
	}
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
	return "login";
	}
    
	@RequestMapping(value="/loginfailed", method =RequestMethod.GET)
	public String loginerror(Model model) {
	model.addAttribute("error", "Invalid username or password!");
	return "login";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
	return "redirect:/welcome";
	}
}
