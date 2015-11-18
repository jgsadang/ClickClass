package mum.cs544.scheduler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import mum.cs544.domain.Attendance;
import mum.cs544.domain.Course;
import mum.cs544.domain.Instructor;
import mum.cs544.service.AttendanceService;
import mum.cs544.service.CourseService;
import mum.cs544.service.InstructorService;

public class ReportGenerator {
	@Autowired
	private AttendanceService attendanceService;
	
	@Scheduled(cron="0 0/1 * * * *") 
	public void salesReport() {
		Date date = Date.valueOf(LocalDate.now());
		List <Attendance> sales = this.attendanceService.getAttendanceByDate(date);
		String filename = date.toString() + "_Sales.txt";
		try {
			File dir = new File(File.separator + "report");
			if (!dir.exists())
				dir.mkdirs();
			File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
			System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			
			BufferedWriter wr = new BufferedWriter(new FileWriter(serverFile));
			wr.write("Sales Report for " + date.toString()); wr.newLine(); wr.newLine();
			int count = 0;
			for (Attendance sale: sales) {
				count++;
				Course course = sale.getCourse();
				Instructor instructor = course.getInstructor();
				
				wr.write(count + ". " + course.getPrice() + " :  " + course.getTitle() + " by " + instructor.getFirstName() + " " + instructor.getLastName() + " Email: " + instructor.getEmail());
				wr.newLine();
			}			
			wr.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
