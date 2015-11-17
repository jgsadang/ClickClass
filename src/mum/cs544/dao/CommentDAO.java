package mum.cs544.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.domain.Comment;
import mum.cs544.domain.Course;

@Repository
public interface CommentDAO extends JpaRepository <Comment, Integer>{
	public List<Comment> findByCourse(Course course);
}

