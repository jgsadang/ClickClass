package mum.cs544.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Category;
import mum.cs544.domain.Course;
import mum.cs544.domain.Instructor;
import mum.cs544.domain.Student;
import mum.cs544.service.AttendanceService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;
import mum.cs544.service.StudentService;

@Controller
public class CourseController implements ServletContextAware {
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;	
	@Autowired
	private AttendanceService attendanceService;	
	@Autowired
	ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	}
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.GET)
	public String addCourse(Model model) {
		Category[] categories = Category.values();
		model.addAttribute("course", new Course());
		model.addAttribute("categories", categories);
		return "addCourse";
	}
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.POST)
	public String addCoursePost(@RequestParam("file") MultipartFile[] files, Model model, Course course,
			@RequestParam("update") String update) 
	{
    
		
		
		if (files.length != 2) {
			return "uploadError";
		}
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				//String rootPath = System.getProperty("catalina.home");
				String folder = "CourseImages";
				if (i==0) {
					folder = "CourseVideos";
				}
				File dir = new File(this.servletContext.getRealPath("/resources") + File.separator + folder);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			} catch (Exception e) {
				return "uploadError";
			}
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		Instructor instructor = instructorService.getInstructorByUserName(username);
		
		course.setInstructor(instructor);
		course.setThumburl(files[0].getOriginalFilename());
		course.setVideo(files[1].getOriginalFilename());
		
		
		course.setStatus("pending");
		
		courseService.save(course);
		return "redirect:/loginsucess";
		
		
	}
	
	/*@RequestMapping(value = "/resources/CourseVideos/{resource}", method=RequestMethod.GET)
	public String restrictAccess(@PathVariable String resource) {
		//redirect to home
		return resource;
	}*/
	
	@RequestMapping(value = "/showCourse", method=RequestMethod.GET)
	public String showCourse(@RequestParam Integer id, Model model) {
		
		
		Course course = this.courseService.getCourse(id);
		Instructor instructor = course.getInstructor();
		model.addAttribute("instructor", instructor);
		model.addAttribute("course", course);
		return "showCourse";
	}
	
	@RequestMapping(value = "/viewCourse", method=RequestMethod.POST)
	public String viewCourse(@RequestParam Integer id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    Student student = this.studentService.getStudent(username);
	    if (student != null) {
	    	Course course = this.courseService.getCourse(id);
	    	Attendance attendance = this.attendanceService.getAttendance(student, course);
	    	if (attendance!=null) {
	    		model.addAttribute("attendance", attendance);
	    	}
	    }
		Course course = courseService.getCourse(id);
		model.addAttribute("course", course);
		return "viewCourse";
	}
	 
	@RequestMapping(value = "/editCourse", method=RequestMethod.GET)
	public String editCourse(Course course ,Model model,@RequestParam("id") Integer id) {
		
		model.addAttribute("course", courseService.getCourse(id));
		
		
		return "addCourse";
	}
	
	
	
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("categories", Category.values());
	}
	
	@RequestMapping(value = "/submitRating", method=RequestMethod.POST)
	public String submitRating(@RequestParam Integer id, Model model, @RequestParam Integer userRating) {
		//redirect to home
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    Student student = this.studentService.getStudent(username);
	    if (student != null) {
	    	Course course = this.courseService.getCourse(id);
	    	Attendance attendance = this.attendanceService.getAttendance(student, course);
	    	if (attendance!=null) {
	    		attendance.setRating(userRating);
	    		this.attendanceService.save(attendance);
	    		model.addAttribute("attendance", attendance);
	    		int rate = userRating;
	    		if (course.getRating() > 0) {
					double rating = (userRating + course.getRating())/2;
					rate = (int)Math.round(rating);
	    		}
				course.setRating(rate);
				this.courseService.save(course);
	    	}
	    }
		Course course = courseService.getCourse(id);
		model.addAttribute("course", course);
		return "viewCourse";
	}
}
