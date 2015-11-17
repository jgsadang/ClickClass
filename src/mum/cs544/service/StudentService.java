package mum.cs544.service;


import mum.cs544.domain.Student;

public interface StudentService  {
	
	
	public void saveStudent(Student student);
	
	public Student getStudentByUserName(String userNmae);
	
	/*public void updateStudent(int studentId);*/
	
}