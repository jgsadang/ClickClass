package mum.cs544.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.StudentDAO;
import mum.cs544.domain.Person;
import mum.cs544.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	public void setStudentDao(StudentDAO studentDao){
		this.studentDao =studentDao;
	}
	
	@Override
	public void saveStudent(Person student) {
		studentDao.save(student);
		
	}

}
