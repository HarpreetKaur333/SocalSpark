package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.NotificationDBUtil;
import DB.PostDBUtil;
import DB.UserDBUtil;
import Model.Notifications;
import Model.Post;
import Model.RegisterUser;
import Model.SuggestedFriends;
import Model.User;

/**
 * Servlet implementation class GetUser
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/Social_Spark_db")
    private DataSource ds;
    private UserDBUtil userdb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			userdb = new UserDBUtil(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("LoginServelet");
			
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(); 
		        
		 	String username = request.getParameter("loginusername");
	        String password = request.getParameter("loginpassword");
	        String rememberme = request.getParameter("rememberme");
	        
	        
			if (username != null && password != null  && rememberme != null) {
			
				Cookie loginemail= new Cookie("loginuseremail", username.trim());
				Cookie loginpassword= new Cookie("loginpassword", password.trim());
				Cookie rnameCookie = new Cookie("rememberme", rememberme.trim());

				loginemail.setMaxAge(24*60*60*365);
				loginpassword.setMaxAge(24*60*60*365);
				rnameCookie.setMaxAge(24*60*60*365); 	
				
				response.addCookie(loginemail);
				response.addCookie(loginpassword);
				response.addCookie(rnameCookie);
			}
			
	       
	        User tempUser=new User(username, password);
	        
	        
	        UserDBUtil userdbutil = new UserDBUtil(ds); 
	        PostDBUtil postdbutil = new PostDBUtil(ds); 
	        NotificationDBUtil notfdbutil = new NotificationDBUtil(ds); 
	        
	        
			try {
				int userValidate = userdbutil.authenticateUser(tempUser);
				tempUser.setEmail(username); 
				tempUser.setPassword(password);
				
			    if(userValidate == 1) 
		         {	   
		        	
		        	 session.setAttribute("user",tempUser );
					 session.setAttribute("loginuser", username.trim());
					 session.setAttribute("loginuserid", tempUser.getUserId());		             
					 session.setAttribute("userObj", tempUser);
					 
		             // friend Suggestion
		             ArrayList<RegisterUser> FriendSugestionList = new ArrayList<>();
		             ArrayList<Post> allUserPostlist = new ArrayList<>();
		             ArrayList<Notifications> getNotificationslist = new ArrayList<>(); 
		             	try {	  
			            	   FriendSugestionList = userdbutil.getSugestion(tempUser.getUserId());
			            	   allUserPostlist = postdbutil.getAllPost();
			            	   getNotificationslist=notfdbutil.getNotifications(tempUser.getUserId());
			            	   
			            	   System.out.println(getNotificationslist);
			            	   request.setAttribute("FriendSugestionList", FriendSugestionList); 
			            	   request.setAttribute("allUserPostlist", allUserPostlist);	
			            	   request.setAttribute("getNotificationslist", getNotificationslist);	
							} catch (Exception e) {
								e.printStackTrace();
							}       
		             RequestDispatcher dispatcher = request.getRequestDispatcher("feed.jsp"); 
		             dispatcher.forward(request, response);
		         }
		         else
		         {
		        	 RequestDispatcher dispatcher = request.getRequestDispatcher("form-login.jsp");
		 			 request.setAttribute("alertMsg", "Incorrect Email or Password");
		 			 dispatcher.forward(request, response);
		         }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       	 
	       
	        
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
