package mum.cs544.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import mum.cs544.domain.Course;
import mum.cs544.service.AdminService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;
import mum.cs544.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

	@RequestMapping("/")
	public String showHomepage(Model model) {
		List<Course> courses = courseService.getCourses();
		model.addAttribute("courses", courses);
		return "home";
	}

	/*
	 * @RequestMapping("/welcome") public String showWelcomepage() { return
	 * "userPage"; }
	 */

	@RequestMapping("/userPage")
	public String getUserPage(Model model) {

		return "userPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "Invalid username or password!");
		return "login";
	}

	@RequestMapping(value = "/loginsucess", method = RequestMethod.GET)
	public String loginSucess(Model model, Principal principal, HttpServletRequest request, HttpSession session) {

		/*
		 * session.setAttribute("name", principal.getName()); String name =
		 * principal.getName();
		 */

		if (request.isUserInRole("ROLE_INSTRUCTOR")) {

			model.addAttribute("user", instructorService.getInstructorByUserName(principal.getName()));
			// session.setAttribute("name", principal.getName());
		} else if (request.isUserInRole("ROLE_STUDENT")) {
			// session.setAttribute("name", principal.getName());
			model.addAttribute("user", studentService.getStudentByUserName(principal.getName()));
		}

		else {
			model.addAttribute("user", adminService.getAdminByUserName(principal.getName()));
		}

		return "userPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session, SessionStatus status) {
		SecurityContextHolder.getContext().setAuthentication(null);
		status.setComplete();
		session.invalidate();

		return "redirect:/";
	}

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("courses", courseService.getCourses());
	}
}
