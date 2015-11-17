package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Administrator;


@Repository
public interface AdminDAO extends JpaRepository <Administrator, Integer>{
	
	public Administrator findByUser_Username(String userName);

}
