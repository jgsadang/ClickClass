package mum.cs544.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.InstructorDAO;
import mum.cs544.domain.Instructor;
import mum.cs544.service.InstructorService;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	private InstructorDAO instructorDAO;
	
	public Instructor getInstructor(int id) {
		return instructorDAO.findOne(id);
	}
}
