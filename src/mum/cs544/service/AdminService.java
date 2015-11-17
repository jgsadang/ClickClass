package mum.cs544.service;

import mum.cs544.domain.Administrator;

public interface AdminService {
	
	public Administrator getAdminByUserName(String userName);

}
