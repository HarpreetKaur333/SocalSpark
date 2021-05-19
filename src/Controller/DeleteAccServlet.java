package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.PostDBUtil;
import DB.UserDBUtil;
import Model.User;

/**
 * Servlet implementation class DeleteAccServlet
 */
@WebServlet("/DeleteAccServlet")
public class DeleteAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccServlet() {
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
		System.out.println("DeleteServelet");
		
		PrintWriter out = response.getWriter();
		
		boolean donecleardataAcc=false;
		boolean deleteUserAcc=false;
		
	 	String deleteacc = request.getParameter("deleteacc");
        String cleardataacc = request.getParameter("cleardataacc");
        
        HttpSession session = request.getSession(); 
        
        
        UserDBUtil userdbutil = new UserDBUtil(ds);  
        
        int loginsessionuserid = (int) session.getAttribute("loginuserid"); //get userid from session
	       
        
        if(cleardataacc != null ) {	
			try {			
				donecleardataAcc = userdbutil.ClearPostData(loginsessionuserid);
				donecleardataAcc = userdbutil.ClearFriendData(loginsessionuserid);
				donecleardataAcc = userdbutil.ClearSavedPostData(loginsessionuserid);
				donecleardataAcc = userdbutil.ClearMeassgeData(loginsessionuserid);
				donecleardataAcc = userdbutil.ClearlikesData(loginsessionuserid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(donecleardataAcc) {
//				response.sendRedirect("ProfileServlet");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileServlet");
	 			 request.setAttribute("alertMsg", "Cleared all Data Of User.");
	 			 dispatcher.forward(request, response);
			}
		}	
        
        if(deleteacc != null ) {	
			try {	
				deleteUserAcc = userdbutil.DeleteUser(loginsessionuserid);
				deleteUserAcc = userdbutil.ClearPostData(loginsessionuserid);
				deleteUserAcc = userdbutil.ClearFriendData(loginsessionuserid);
				deleteUserAcc = userdbutil.ClearSavedPostData(loginsessionuserid);
				deleteUserAcc = userdbutil.ClearMeassgeData(loginsessionuserid);
				deleteUserAcc = userdbutil.ClearlikesData(loginsessionuserid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(deleteUserAcc) {
//				response.sendRedirect("ProfileServlet");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("form-login.jsp");
	 			 request.setAttribute("alertMsg", "Cleared all Data Of User.");
	 			 dispatcher.forward(request, response);
			}
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
