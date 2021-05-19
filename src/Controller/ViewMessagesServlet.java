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

import DB.MessageDBUtil;
import DB.UserDBUtil;
import Model.Messages;

/**
 * Servlet implementation class ViewMessagesServlet
 */
@WebServlet("/ViewMessagesServlet")
public class ViewMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMessagesServlet() {
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
		System.out.println("ViewMessageServelet");
		
		 HttpSession session=request.getSession(false);
		
		String FriendId = request.getParameter("frndid");
		
		String loginsessionuserid = (String)session.getAttribute("loginuserid").toString();  
		
		 MessageDBUtil msgdbutil = new MessageDBUtil(ds); 
		 ArrayList<Messages> messagelist = new ArrayList<>();
		 ArrayList<Messages> GetFrndMessagelist = new ArrayList<>();
		
		try {
			messagelist =msgdbutil.getMessages(loginsessionuserid);
			GetFrndMessagelist =msgdbutil.getMessagesfromFrnd(FriendId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewMessage.jsp");
			request.setAttribute("messagelist", messagelist); 
			request.setAttribute("GetFrndMessagelist", GetFrndMessagelist); 
			dispatcher.forward(request, response);
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
