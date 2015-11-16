package mum.cs544.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import mum.cs544.domain.User;

@Repository
public interface UserDAO extends JpaRepository <User, Integer>{
	
	public User findByUsername(String username);
}

