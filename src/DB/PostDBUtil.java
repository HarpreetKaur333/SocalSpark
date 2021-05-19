package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import Model.Post;
import Model.User;
import Model.Post;
import DB.PostDBUtil;

public class PostDBUtil {
private DataSource ds;
	
	public PostDBUtil(DataSource ds) {
		this.ds = ds;
	}
	
	public boolean createPost(Post post) throws Exception {
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		String UserId = post.getUserId();
		String email = post.getEmail();
		String content = post.getContent();
		String date = post.getDate();	
		
		try {
			conn = this.ds.getConnection();
			
			String sql = String.format("INSERT "
					+ "INTO post (UserId,email,content,date) "
					+ "VALUES ('%s', '%s', '%s', '%s')",UserId,email,content,date);
			smt = conn.createStatement();
			smt.executeUpdate(sql);
						
		}catch(Exception e) {
       	 e.printStackTrace();
       }
		return true;	
	}
public ArrayList<Post> getAllPost() throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		ArrayList<Post> allUserPosts = new ArrayList<>();
			
		try {
			conn = this.ds.getConnection();
			
			String sql = "SELECT p.*, u.FirstName, u.LastName, count(l.PostId) as likes \r\n" + 
					"FROM post p \r\n" + 
					"LEFT JOIN likes l ON p.PostId = l.PostId\r\n" + 
					"JOIN user u ON p.UserId = u.UserId\r\n" + 
					"GROUP BY p.PostId";
			
			smt = conn.createStatement();
			res = smt.executeQuery(sql);
//			System.out.println(sql);
			while(res.next()) {
				String postId = Integer.toString(res.getInt("PostId"));
				String userId = Integer.toString(res.getInt("UserId"));
				String fullname = res.getString("FirstName") + " " + res.getString("LastName");								
				String content = res.getString("content").toString();
				String email = res.getString("email").toString();
				String date = res.getString("date").toString();
				String likes = res.getString("likes").toString();
//				System.out.println("hii");
				allUserPosts.add(new Post(postId,userId,fullname, content, email,date,likes));
			}
					
		}finally {
			close(conn,smt,psmt,res);
		}

		return allUserPosts;
	}
	// get user post(like login user and show on their profile)
	public ArrayList<Post> getUserPosts(User user) throws Exception{
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		ArrayList<Post> UserPosts = new ArrayList<>();
		
		try {
			conn = this.ds.getConnection();
			String sql = "SELECT p.*, u.FirstName, u.LastName, count(l.PostId) as likes FROM post p \r\n" + 
					"					LEFT JOIN likes l ON p.PostId = l.PostId \r\n" + 
					"                    JOIN user u ON p.UserId = u.UserId\r\n" + 
					"					GROUP BY  p.PostId HAVING  p.UserId =  ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,user.getUserId());
			res = pstmt.executeQuery();
//			System.out.println(sql);
//			System.out.println(user.getUserId());
			while(res.next()) {
				String postId = Integer.toString(res.getInt("PostId"));
				String UserId = Integer.toString(res.getInt("UserId"));
				String fullname = res.getString("FirstName") + " " + res.getString("LastName");								
				String content = res.getString("content").toString();
				String email = res.getString("email").toString();
				String date = res.getString("date").toString();
				String likes = res.getString("likes").toString();
//				System.out.println("hello");
				UserPosts.add(new Post(postId,UserId,fullname, content, email,date,likes));		
				
			}
//			 user.setPost(tempPosts);
//			 System.out.println(tempPosts);
//			 System.out.println("hii");
		}
		finally {
			close(conn,smt,pstmt,res);
		}
		return UserPosts;
	}
	
public boolean savedPost(int PostId, int UserId) throws SQLException
	{
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
	    PreparedStatement preparedStatement = null;         
	    try
	    {
	    	conn = this.ds.getConnection();
	        String query = "insert into savedposts(PostId, UserId) values (?,?)"; 
	        preparedStatement = conn.prepareStatement(query); 
	        preparedStatement.setInt(1, PostId);
	        preparedStatement.setInt(2, UserId);	        
	        preparedStatement.executeUpdate();
//	        System.out.println("hii");
	    }
	    catch(SQLException e)
	    {
	       e.printStackTrace();
	    }    
		return true;
}
public boolean LikePost(int PostId, int UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into likes(PostId, UserId) values (?,?)"; 
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(1, PostId);
        preparedStatement.setInt(2, UserId);
        preparedStatement.executeUpdate();
//        System.out.println("likepost");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return true;
}
public boolean UnlikePost(int PostId, int UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
    	String query = String.format("DELETE "
				+ "FROM likes "
				+ "WHERE UserId = ? AND PostId = ?");
    	
    	System.out.println(query);
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(1, PostId);
        preparedStatement.setInt(2, UserId);
        preparedStatement.executeUpdate();
//        System.out.println("unlike");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return true;
}
public boolean DeletePost(int PostId, int UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
    	String query = String.format("DELETE "
				+ "FROM post "
				+ "WHERE UserId = ? AND PostId = ?");
    	
    	System.out.println(query);
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(1, PostId);
        preparedStatement.setInt(2, UserId);
        preparedStatement.executeUpdate();
//        System.out.println("delete");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return true;
}
public boolean EditPost(int PostId,int UserId, String postcontent)
{
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "update post \r\n" +"set content=\"\r\n" + postcontent + "\" \r\n" + 
        		"where postID ="+ PostId+" and UserId="+UserId;  
        preparedStatement = conn.prepareStatement(query); 
//        preparedStatement.setInt(1, postIDEdit);
//        preparedStatement.setInt(2, userID);
//        preparedStatement.setString(3, editText);
        
        preparedStatement.executeUpdate();
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }   
    return true; 
}
private void close(Connection conn, Statement smt, PreparedStatement pstmt, ResultSet res) {
	try {	
		if(conn != null) {
			conn.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(smt != null) {
			smt.close();
		}
		if(res != null) {
			res.close();
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
}
