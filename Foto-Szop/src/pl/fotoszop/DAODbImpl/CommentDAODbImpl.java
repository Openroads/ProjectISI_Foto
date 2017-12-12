package pl.fotoszop.DAODbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import pl.fotoszop.dao.CommentDAO;
import pl.fotoszop.model.Comment;

public class CommentDAODbImpl implements CommentDAO{

	 private static final Logger logger = LoggerFactory.getLogger(AccountDAODbImpl.class.getName());

	    private static final String SQL_GET_ALL_COMMENTS = "SELECT * from comments";

	    private DataSource dataSource;
	    
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }

		@Override
		public List<Comment> getAllComments() {

			Connection connection = null;
			Comment comment = null;
			List<Comment> comments = new ArrayList<>();
			
			try {
				connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(SQL_GET_ALL_COMMENTS);
	            
	            while(rs.next()){
	            	 comment = new Comment();
	            	comment.setId(rs.getInt("id_comment"));
	            	comment.setText(rs.getString("text"));
	            	comment.setCreationDate(rs.getDate("date_of_creation"));
	            	comment.setIdClient(rs.getInt("id_client"));
	            	comments.add(comment);
	            }
	            
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return comments;
		}

		@Override
		public int saveOrUpdate(Comment comment) {
			
			Connection connection = null;
			List<Comment> comments = new ArrayList<>();
			int rs = 0;
			
			try {
				connection = dataSource.getConnection();
				String insert = "INSERT INTO comments VALUES (?,?,?,?,?,?)";
				java.sql.PreparedStatement statement = connection.prepareStatement(insert);
				statement.setInt(1, comment.getId()); statement.setString(2, comment.getText());
				statement.setDate(3, comment.getCreationDate()); statement.setDate(4, comment.getCreationDate());
				statement.setInt(5, 1); statement.setInt(6, comment.getIdClient());
	            rs = statement.executeUpdate();
	       	    System.out.println(rs);  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return rs;
		}
	    

}
