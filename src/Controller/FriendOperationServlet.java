package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.NotificationDBUtil;
import DB.PostDBUtil;
import DB.UserDBUtil;
import Model.RegisterUser;

/**
 * Servlet implementation class FriendOperationServlet
 */
@WebServlet("/FriendOperationServlet")
public class FriendOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/Social_Spark_db")
    private DataSource ds;
    private UserDBUtil userdb;
    private PostDBUtil postdb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			userdb = new UserDBUtil(ds);
			postdb=new PostDBUtil(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("FreindsOperationServlet");
		// CREATE SESSION
		HttpSession session = request.getSession();
		
		UserDBUtil userdbutil = new UserDBUtil(ds); 
		NotificationDBUtil notdbutil=new NotificationDBUtil(ds);
		
		String loginsessionuserid = (String) session.getAttribute("loginuserid").toString(); //get userid from session
		String loginusername=(String) session.getAttribute("loginuser");
		
		// add friends
		 String Userid= request.getParameter("hiddenUserId");
		 String redirectsamepage = request.getParameter("redirectsamepage");	
		 
		String addfriend = request.getParameter("addfriend");  //it called from home page under friend suggestion
		String unfriend = request.getParameter("unfriend");		// it called from profile page
		String block = request.getParameter("block");
		String remove = request.getParameter("sendmessage");

		 String useridoffreind= request.getParameter("getuserfrndid"); //id from frndlist from
		
		 String frendName= request.getParameter("hiddenUserNameId"); //get frdn name for notifcation table
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectsamepage);
		
		String acceptreq = request.getParameter("accept");
		String rejectreq = request.getParameter("reject");
		
		boolean addedfrnd = false;
		boolean unfrnd = false;		
		boolean blockfrnd= false;			
		boolean acceptedreq = false;
		boolean rejectedreq  = false;
		if(addfriend != null) {					
			try {
				addedfrnd = userdbutil.AddFriend(Userid, 0); // add friend time status insert 0
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		if(unfriend != null) {			
			
			try {
				unfrnd = userdbutil.UnfriendFriend(useridoffreind);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		
		if(block != null) {	
			try {
				blockfrnd = userdbutil.blockFriend(useridoffreind,-1);// update staus -1
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if(acceptreq != null) {	
			try {
				acceptedreq = userdbutil.acceptRequest(loginsessionuserid, 1);  // add friend time status insert 0
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		
		if(rejectreq != null) {						
			try {
				rejectedreq = userdbutil.rejectRequest(loginsessionuserid);  // add friend time status insert 0
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
		 try {
//			boolean addedfrnd = userdbutil.AddFriend(Userid, 0);
			notdbutil.insertNotifications(1, loginsessionuserid, Userid,loginusername,frendName);  //here  entered data into notification
//			  System.out.println("send notifications");	
//			  1 for frnd request , 2 for message (type column in notification table
			
			if (addedfrnd || unfrnd || blockfrnd  || acceptedreq || rejectedreq )
				request.setAttribute("alertMsg", "Action performed.");
			else
				request.setAttribute("alertMsg", "Oops.. Something went wrong there.");
				dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
