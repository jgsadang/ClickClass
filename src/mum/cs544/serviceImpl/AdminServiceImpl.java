package mum.cs544.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.AdminDAO;
import mum.cs544.domain.Administrator;
import mum.cs544.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;

	@Override
	public Administrator getAdminByUserName(String userName) {

		return adminDao.findByUser_Username(userName);
	}

}
