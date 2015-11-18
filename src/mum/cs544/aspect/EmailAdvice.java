package mum.cs544.aspect;



import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mum.cs544.domain.Course;
import mum.cs544.domain.Instructor;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;
import mum.cs544.smpt.EmailSettings;
import mum.cs544.smpt.EmailUtil;


@Aspect
@Component
public class EmailAdvice {
	
	@Autowired
	InstructorService instructorService ;
	@Autowired
	CourseService courseService ;
	
	
	@After("execution(* mum.cs544.controller.AdminController.disapproveCourse(..))")
	public void afterdisapproval(JoinPoint joinpoint ) {
		
	
	//send email 
			final String fromEmail = "clickclassgroup@gmail.com"; //requires valid gmail id
	        final String password = "clickclass"; // correct password for gmail id
			
	        Object[] args = joinpoint.getArgs();
	        
	        Integer cid = (Integer)args[1];
	        
	        
	        System.out.println("--------"+cid);
	        Course course = courseService.getCourse(cid);
	        
	        System.out.println("--------"+course.getDescription());
	        
	        Instructor instructor = instructorService.getInstructor(course.getInstructor().getId());
	        
	       final String toEmail = instructor.getEmail();

			
	        //create Authenticator object to pass in Session.getInstance argument
	        Authenticator auth = new Authenticator() {
	        //override the getPasswordAuthentication method
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };
			
			Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
			EmailUtil.sendEmail(session, toEmail, " Welcome " + instructor.getFirstName(), instructor.getFirstName()+course.getTitle()+" Course that You Uploaded in our website Has been DisApproved . ");


}
}
