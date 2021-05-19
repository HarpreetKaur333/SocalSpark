package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

/**
 * Servlet implementation class PostsOperationServlet
 */
@WebServlet("/PostsOperationServlet")
public class PostsOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsOperationServlet() {
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
		
		System.out.println("PostOperationServlet");
		HttpSession session = request.getSession();
		
		
	 	String Like = request.getParameter("Like");
        String unlike = request.getParameter("unlike");
        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String savepost = request.getParameter("savepost");
        
        String email = request.getParameter("email");
        int postid = Integer.parseInt(request.getParameter("postid"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        String Redirectsamepage = request.getParameter("Redirectsamepage");
        
        String postcontent=request.getParameter("postcontent");
  
        PostDBUtil postdbutil = new PostDBUtil(ds); 
        UserDBUtil userdbutil = new UserDBUtil(ds); 
        int loginsessionuserid = (int) session.getAttribute("loginuserid"); //get userid from session
        boolean done = false;
		
		if(Like != null) {
			try {
				done = postdbutil.LikePost(postid, userid );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		if(unlike != null) {
			try {
				done = postdbutil.UnlikePost(postid, userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(edit != null) {
			done = postdbutil.EditPost(postid,userid,postcontent);
		}
		
		if(savepost != null) {
			try {
				done =postdbutil.savedPost(postid, userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(delete != null) {
			try {
				done = postdbutil.DeletePost(postid, loginsessionuserid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if(done) {			
//			response.sendRedirect(Redirectsamepage);
			 RequestDispatcher dispatcher = request.getRequestDispatcher(Redirectsamepage);
 			 request.setAttribute("msg", "Operation performed.");
 			 dispatcher.forward(request, response);
		}
		else {
			 RequestDispatcher dispatcher = request.getRequestDispatcher(Redirectsamepage);
 			 request.setAttribute("msg", "Operation can not Performed.");
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
