package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.UserDBUtil;
import Model.User;

/**
 * Servlet implementation class reset_password
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Login servelet");
		HttpSession session = request.getSession();
		boolean confirmchanged = false;
       
	 
	        UserDBUtil userdbutil = new UserDBUtil(ds); 
	        int loginsessionuserid = (int) session.getAttribute("loginuserid"); //get userid from session
	        
	    	System.out.println(loginsessionuserid);
//	        User userValidate = userdbutil.ForgotPassword(loginuser) ;
//	        String paassowrd=userValidate.getPassword();
//	        
//	        
//	        if(paassowrd!=null)
//	         {
//			  	request.setAttribute("fetchpassword", paassowrd);
//	           	request.getRequestDispatcher("form-login.jsp").forward(request, response);
//	         }
//	         else
//	         {
//	        	 RequestDispatcher dispatcher = request.getRequestDispatcher("form-login.jsp");
//	 			 request.setAttribute("error", "There were an error in fetching password.");
//	 			 dispatcher.forward(request, response);
//	         }
	        
	        //change password
	        String oldpassword = request.getParameter("oldpassword");
	        String newpassword = request.getParameter("newpassword");
	        String newconfirmpassword = request.getParameter("newPasswordConfirm");
	        
			try {
				confirmchanged=userdbutil.changepassword(oldpassword,newconfirmpassword,loginsessionuserid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("form-login.jsp");
			
			if(confirmchanged)
			{				
	 			 request.setAttribute("alertMsg", "Password changed successfully");
	 			 dispatcher.forward(request, response);
//				response.sendRedirect("form-login.jsp");
			}
			else {
	 			 request.setAttribute("alertMsg", "Something went wrong..!!");
	 			 dispatcher.forward(request, response);
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
