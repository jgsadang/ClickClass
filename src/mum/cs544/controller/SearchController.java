package mum.cs544.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import mum.cs544.service.CourseService;


@Controller
public class SearchController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/doSearch")
	public String getCoursesByCategory(Model model ,@RequestParam("searchKey") String title) {
		
		model.addAttribute("courses",courseService.getCourseByTitle(title));
		return "home";
		
	}
}
