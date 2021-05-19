package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import Model.Notifications;;

public class NotificationDBUtil {

private DataSource ds;
	
	public NotificationDBUtil(DataSource ds) {
		this.ds = ds;
	}

	public void insertNotifications(int type,String FromUserId, String ToUserId,String Username,String ToUserName) throws Exception {
	 	Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
	    PreparedStatement preparedStatement = null;

	try {
		conn = this.ds.getConnection();
	    String query = "insert into notifications(type,FromUserId,ToUserId,Username,ToUserName) values (?,?,?,?,?)"; 
//	    System.out.println("inside try");	
	    preparedStatement = conn.prepareStatement(query); 
	    preparedStatement.setInt(1, type);
	    preparedStatement.setString(2, FromUserId);
	    preparedStatement.setString(3, ToUserId);
	    preparedStatement.setString(4, Username);
	    preparedStatement.setString(5, ToUserName);
	    preparedStatement.executeUpdate();
//	    System.out.println("send notifications");	
	}finally {
		close(conn,smt,preparedStatement,res);	
	}	
	}
public ArrayList<Notifications> getNotifications(int Userid) throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		ArrayList<Notifications> getNotifications = new ArrayList<>();
			
		try {
			conn = this.ds.getConnection();
			
			String sql = "select * from notifications WHERE FromUserId =?";
			psmt = conn.prepareStatement(sql);			
			psmt.setInt(1, Userid);			
			res = psmt.executeQuery();
			while(res.next()) {
				 int id = res.getInt("id");
				 int type  = res.getInt("type"); 
				 String FromUserId   = res.getString("FromUserId").toString(); 
				 String ToUserId   = res.getString("ToUserId").toString(); 
				 String Username   = res.getString("Username").toString(); 
				 String TouserName   = res.getString("TouserName").toString(); 
				System.out.println("inside while hii");
				getNotifications.add(new Notifications(type,FromUserId,ToUserId, Username, TouserName));
			}
					
		}finally {
			close(conn,smt,psmt,res);
		}

		return getNotifications;
	}
	private void close(Connection conn, Statement smt, PreparedStatement psmt, ResultSet res) {
		// TODO Auto-generated method stub
		try {
			if(conn != null)	
				conn.close();
			
			if(smt != null)
				smt.close();
			
			if(psmt != null)
				psmt.close();
			
			if(res != null)
				res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
