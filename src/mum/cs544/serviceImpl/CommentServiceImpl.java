package mum.cs544.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.CommentDAO;
import mum.cs544.domain.Comment;
import mum.cs544.domain.Course;
import mum.cs544.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	public void save(Comment comment) {
		commentDAO.save(comment);
	}

	@Override
	public List<Comment> getCommentsByCourse(Course course) {		
		return commentDAO.findByCourse(course);
	}	
}
