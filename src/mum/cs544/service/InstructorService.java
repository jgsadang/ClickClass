package mum.cs544.service;

import mum.cs544.domain.Instructor;

public interface InstructorService {
	
	
	public void saveInstructor(Instructor instructor);
	public Instructor getInstructor(int id);
}
