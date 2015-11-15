package mum.cs544.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.AuthorityDAO;
import mum.cs544.dao.StudentDAO;
import mum.cs544.dao.UserDAO;
import mum.cs544.domain.Student;
import mum.cs544.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private AuthorityDAO authorityDao;
	
	
	public void setStudentDao(StudentDAO studentDao){
		this.studentDao =studentDao;
	}
	
	@Override
	public void saveStudent(Student student) {
		userDao.save(student.getUser());
		studentDao.save(student);
		
	}

}
