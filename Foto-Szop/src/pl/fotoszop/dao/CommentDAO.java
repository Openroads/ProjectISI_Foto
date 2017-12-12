package pl.fotoszop.dao;

import java.util.List;

import pl.fotoszop.model.Comment;

public interface CommentDAO {
	
	
	 List<Comment> getAllComments();
	 int saveOrUpdate(Comment comment);

}
