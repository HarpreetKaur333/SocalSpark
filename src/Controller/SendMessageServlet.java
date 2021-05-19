package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.MessageDBUtil;
import DB.PostDBUtil;
import DB.UserDBUtil;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("SendMessageServelet");
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		
		String msgcontent = request.getParameter("msgcontent");		
        int frndid = Integer.parseInt(request.getParameter("frndid"));
        int loginsessionuserid = (int) session.getAttribute("loginuserid"); //get userid from session
        String frndname = request.getParameter("frndname");
        MessageDBUtil msgdbutil = new MessageDBUtil(ds); 
//        String friendName = frndname.replaceAll(" ", "");   // it show error because space b/w first & last name
        
        try {
        	boolean msgsent = msgdbutil.insertMessage(loginsessionuserid, frndid, msgcontent);
        	
//        	response.sendRedirect("ViewMessagesServlet?frndid=" + frndid + "&friendName=" + friendName); 
        	
        	response.sendRedirect("ViewMessagesServlet?frndid=" + frndid );
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
