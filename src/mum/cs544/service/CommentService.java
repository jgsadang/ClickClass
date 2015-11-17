package mum.cs544.service;




import java.util.List;

import mum.cs544.domain.Comment;
import mum.cs544.domain.Course;

public interface CommentService {
	public void save(Comment comment);
	public List<Comment> getCommentsByCourse(Course course);
}
