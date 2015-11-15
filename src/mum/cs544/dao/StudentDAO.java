package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Person;

@Repository
public interface StudentDAO extends JpaRepository<Person, Integer> {
	

}
