package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import Model.RegisterUser;
import Model.SuggestedFriends;
import Model.User;


public class UserDBUtil {

private DataSource ds;
	
	public UserDBUtil(DataSource ds) {
		this.ds = ds;
	}

public int authenticateUser(User loginBean)  throws Exception
{		
	 String userEmail = loginBean.getEmail();
     String userpassword = loginBean.getPassword();

     
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		int userIDDB = 0;
        try {      	
			conn = this.ds.getConnection();
			
			String sql = "select UserId, Email,Password from user where Email=?";
			psmt = conn.prepareStatement(sql);			
			psmt.setString(1, userEmail);			
			res = psmt.executeQuery();
			while(res.next()) {
				    userIDDB = res.getInt("UserId");				  
				    loginBean.setUserId(userIDDB);
					String  userEmailDB = res.getString("Email").toString();
					String passwordDB = res.getString("Password").toString(); 
					if(userEmail.equals(userEmailDB) && userpassword.equals(passwordDB))
					{
	                  return 1; 
					}
			}
	        }catch(Exception e) {
	        	 e.printStackTrace();
	        }
        
        return 0;		
 }

//here function for register user
public String registerUser(RegisterUser registerBean)
{
	//System.out.print("hiiii");
    String fName = registerBean.getFirstName();
    String lname=registerBean.getLastName();
    String regemail = registerBean.getEmail();
    String regpassword = registerBean.getPassword();
    
    Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
//    	System.out.print(conn);
    	conn = this.ds.getConnection();
        String query = "insert into user(FirstName,LastName,Email,Password) values (?,?,?,?)"; 
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setString(1, fName);
        preparedStatement.setString(2, lname);
        preparedStatement.setString(3, regemail);
        preparedStatement.setString(4, regpassword);
        
        int i= preparedStatement.executeUpdate();
        
        if (i!=0)  //Just to ensure data has been inserted into the database
        return "SUCCESS"; 
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }       
    return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
}
public  User ForgotPassword(User loginBean)
{
     	String userpassword = loginBean.getPassword();    
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
	      
        try {      	
        	 conn = ds.getConnection();
			
			  PreparedStatement stmt = conn.prepareStatement("Select Password from user where Email=?");
		      stmt.setString(1,loginBean.getEmail());
		      ResultSet rs = stmt.executeQuery();
			//System.out.print(conn);
		      if (rs.next()) {
		         loginBean.setPassword(rs.getString("Password"));
		        }
	        }catch(Exception e) {
	        	 e.printStackTrace();
	        }
        
        return loginBean;	
}
public String SearchUser(String txtsearchname ) throws SQLException 
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	String tempusername = null;
	try {
		 
		conn = ds.getConnection();
		String sql="SELECT FirstName FROM user   WHERE FirstName=?";
		pstmt = conn.prepareStatement(sql);		
		pstmt.setString(1, txtsearchname);		
		res = pstmt.executeQuery();
		System.out.println(sql);
		if(res.next()) {
			 tempusername = res.getString("FirstName").toString();
			
 
		}
	}finally {
		
		close(conn,smt,pstmt,res);
		
	}
	return tempusername;
	
}
public boolean changepassword(String oldpassword, String newpassword, int UserId) throws Exception {
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	System.out.println(UserId+"\n   hello");
	try {
		conn = this.ds.getConnection();
		
		String sql = "select * from user WHERE UserId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);		
		res=pstmt.executeQuery();
		
		while(res.next()) {
			String dbpass = res.getString("Password").toString();		
				if(dbpass.equals(oldpassword)){			
				Connection con = null;
				Statement smt1 = null;
				PreparedStatement pstmt1 = null;
//				ResultSet res = null;
					try {
						con= this.ds.getConnection();			
						String sql1 = "UPDATE User SET Password = ? WHERE UserId = ?";
						pstmt1 = con.prepareStatement(sql1);
						pstmt1.setString(1, newpassword);
						pstmt1.setInt(2, UserId);
						pstmt1.executeUpdate();
						 System.out.print("Password changed successfully");
						  return true;
					}finally {
						close(conn,smt,pstmt,res);	
					}
				}
				else{
					System.out.print("Invalid Current Password");
					return false;
				}
		}
		
	}finally {
		close(conn,smt,pstmt,res);	
	}	
	return false;	
}
//public User getUser(int UserId) throws Exception{
//	
//	User user = null;
//	
//	Connection conn = null;
//	Statement smt = null;
//	PreparedStatement psmt = null;
//	ResultSet res = null;
//		
//	try {
//		conn = this.ds.getConnection();
//		
//		String sql = "SELECT * FROM user where userID = " + UserId;
//		
//		smt = conn.createStatement();
//		res = smt.executeQuery(sql);
//		
//		while(res.next()) {
//			String fname = res.getString("FirstName").toString();
//			String lname = res.getString("LastName").toString();
//			String email = res.getString("Email").toString();
//			
//			user = new User(fname,lname,email,"");
//		}
//		
//	}finally {
//		close(conn,smt,psmt,res);
//	}
//
//	return user;
//}

//get frnd
public ArrayList<RegisterUser> getSugestion(int UserId ) throws Exception
{ 
	 ArrayList<RegisterUser> getSuggestionpUsers = new ArrayList<>();
 
	 Connection conn = null; Statement smt = null; 
	 PreparedStatement psmt = null;
	 ResultSet res = null;
 
	 try { 
		  conn = this.ds.getConnection(); 	  		  
		  PreparedStatement ps=conn.prepareStatement("SELECT * FROM user where UserId != ? ");  
		  ps.setInt(1,UserId);  
		  res=ps.executeQuery();
//		  System.out.println(ps);
//		  System.out.print("sugestionfrnd" );
		 while(res.next())
		 {		 
			 int uid = res.getInt("UserId");
			 String fname  = res.getString("FirstName").toString(); 
			 String Lname   = res.getString("LastName").toString(); 
			 String email   = res.getString("Email").toString(); 
//			 System.out.println( uid+fname+Lname );
			 getSuggestionpUsers.add(new RegisterUser(uid,fname,Lname ,email,"")); 
		 }
 
 }finally
 { 
	  close(conn,smt,psmt,res); 
	  }
 
 return getSuggestionpUsers; 
 }

// friend list method
 public ArrayList<SuggestedFriends> friendlist(int Userid )  throws Exception{ 
	
	 ArrayList<SuggestedFriends>friendlist = new ArrayList<>();
	  
	  Connection conn = null; 
	  Statement smt = null; 
	  PreparedStatement psmt = null;
	  ResultSet res = null;
	  	  
	  try { 
		  conn = this.ds.getConnection(); 
		  PreparedStatement ps=conn.prepareStatement("SELECT f.FrndId,u.UserId,u.Email,u.FirstName,u.LastName,f.Status  FROM friends f , user u  where u.UserId=f.UserId and f.status  = ?");  		  
		  ps.setInt(1,1);  
		  res=ps.executeQuery();

	  while(res.next())
	  { 
		 int FrndId=res.getInt("FrndId");
		 int UserId=res.getInt("UserId");
		 String email  = res.getString("Email").toString(); 
		 String fullname  =  res.getString("FirstName") + " " + res.getString("LastName");		
		 int status   = res.getInt("Status"); 

		friendlist.add(new SuggestedFriends(FrndId, UserId, email, fullname, status)); 
	  }
	  
	  }finally
	  { 
		  close(conn,smt,psmt,res); 
		  }
	  
	  return friendlist; 
	  }
//insert into friends
	public boolean AddFriend(String UserId, int Status) throws Exception {
		 	Connection conn = null;
			Statement smt = null;
			PreparedStatement psmt = null;
			ResultSet res = null;
		    PreparedStatement preparedStatement = null;
		
		try {
			conn = this.ds.getConnection();
	        String query = "insert into friends(UserId,Status) values (?,?)"; 
	        preparedStatement = conn.prepareStatement(query); 
	        preparedStatement.setString(1, UserId);
	        preparedStatement.setInt(2, 0);  //send request status =0
	        preparedStatement.executeUpdate();
	        System.out.println("add frnd");	
		}finally {
			close(conn,smt,preparedStatement,res);	
		}	
		return true;
}
public boolean UnfriendFriend(String userid) throws Exception {
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			conn = this.ds.getConnection();			
			String sql = "delete from friends WHERE UserId =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
			 System.out.println(sql);
			  System.out.println("delete frnd");
		}finally {
			close(conn,smt,pstmt,res);	
		}
		return true;	
}
public boolean blockFriend(String userid,int Status) throws Exception {
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();			
		String sql = "UPDATE friends SET status =? WHERE UserId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,-1); //block friend status update -1
		pstmt.setString(2, userid);
		pstmt.executeUpdate();
//		 System.out.println(sql);
//		  System.out.println("block frnd");
	}finally {
		close(conn,smt,pstmt,res);	
	}
	return true;	
}
public boolean acceptRequest(String userid,int Status) throws Exception {
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();
		
		String sql = "UPDATE friends SET status =? WHERE UserId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1); //accept request status update 1
		pstmt.setString(2, userid);
		
		int done = pstmt.executeUpdate();
		
		if(done != 0) {
			String sql1 = String.format("INSERT INTO friends VALUES('%s','%s')",userid,'1');
			smt = conn.createStatement();
			smt.executeUpdate(sql1);	
		}
		
	}finally {
		close(conn,smt,pstmt,res);	
	}
	return true;	
}
public boolean rejectRequest(String userid) throws Exception {
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();
		
		String sql = "DELETE from friends WHERE UserId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.executeUpdate();
		
	}finally {
		close(conn,smt,pstmt,res);	
	}	
	return true;	
}
//clear all data of loginuser
public boolean ClearPostData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM post WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearFriendData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM friends WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearSavedPostData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM savedposts WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearMeassgeData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM messages WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearlikesData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM likes WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearNotificationsData(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM notifications WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean DeleteUser(int UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM user WHERE UserId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
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

	/*
	 * public String FindUserPassword (RegisterUser registerBean) {
	 * 
	 * Connection conn = null; Statement smt = null; PreparedStatement psmt = null;
	 * ResultSet res = null; PreparedStatement preparedStatement = null; try {
	 * String sql = "Select password from user where login=? ";
	 * 
	 * smt = conn.createStatement(); res = smt.executeQuery(sql); preparedStatement
	 * = conn.prepareStatement(sql); //Making use of prepared statements here to
	 * insert bunch of data preparedStatement.setString(1, registerBean.getEmail());
	 * ResultSet rs = preparedStatement.executeQuery(); if (rs.next()) { user = new
	 * RegisterUser(sql, sql, sql, sql);
	 * 
	 * user.setPassword(rs.getString("password")); } } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return user;
	 * 
	 * }
	 */
	
}
