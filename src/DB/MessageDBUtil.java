package DB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import Model.Messages;
import Model.Post;
import Model.User;


public class MessageDBUtil {
private DataSource ds;
	
	public MessageDBUtil(DataSource ds) {
		this.ds = ds;
	}
	
public boolean insertMessage(int fromuserid, int touserId, String msgcontent) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null; 
    
	try {
		conn = this.ds.getConnection();
        String query = "insert into messages(FromUserId, ToUserId,message) values (?,?,?)"; 
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(1, fromuserid);
        preparedStatement.setInt(2, touserId);	   
        preparedStatement.setString(3, msgcontent);	
        preparedStatement.executeUpdate();
	}
	finally {
		close(conn,smt,preparedStatement,res);
	}
	return false;
	
}
public ArrayList<Messages> getMessages(String UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	ArrayList<Messages> viewmessagelist = new ArrayList<>();
	
	try {
		conn = this.ds.getConnection();
		String sql = "select msg.*, u.FirstName,u.LastName "
				+ "FROM messages msg "
				+ "join user u on u.UserId = msg.FromUserId "
				+ "WHERE msg.FromUserId = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, UserId);
		
		res = pstmt.executeQuery();
		
		while(res.next()) {
			
			String fromEmail = res.getString("FromUserId");
			String toEmail =  res.getString("ToUserId");
			String message =res.getString("message");
			
			viewmessagelist.add(new Messages(fromEmail, toEmail, message));	
		}
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return viewmessagelist;

}
public ArrayList<Messages> getMessagesfromFrnd(String FrndId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	ArrayList<Messages> getfrndmessagelist = new ArrayList<>();
	
	try {
		conn = this.ds.getConnection();
		String sql = "select msg.*, u.FirstName,u.LastName "
				+ "FROM messages msg "
				+ "join user u on u.UserId = msg.FromUserId "
				+ "WHERE msg.FromUserId = ? ";
		System.out.println(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(2, FrndId);
		
		res = pstmt.executeQuery();
		
		while(res.next()) {
			
			System.out.println("inside while get post");
			
			String fromEmail = res.getString("FromUserId");
			String toEmail =  res.getString("ToUserId");
			String message =res.getString("message");
			
			getfrndmessagelist.add(new Messages(fromEmail, toEmail, message));	
		}
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return getfrndmessagelist;

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
