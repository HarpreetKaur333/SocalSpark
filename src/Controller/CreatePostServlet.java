package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import Model.Post;
import Model.User;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
			System.out.println("CreatePostServelet");
		
		HttpSession session = request.getSession();
		
//		String user=(String)session.getAttribute("loginuser");
//	    String userid=(String)session.getAttribute("loginuserid");
//		
		
	    String uname= (String)request.getParameter("profileusername");
	    String unameid= (String)request.getParameter("profileuserid");
	    
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date = SDF.format(new Date());
	
//		System.out.println(user);
//		System.out.println(userid);
		 String postContent = request.getParameter("postContent");
		 String redirectsamepage = request.getParameter("redirectsamepage");
		 Post posttemp=new Post(unameid, uname, postContent, date);
	        
	     PostDBUtil postdbutil = new PostDBUtil(ds); 
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher(redirectsamepage);
	     
	        boolean createdposted;
			try {
				createdposted = postdbutil.createPost(posttemp);
				if (createdposted)
					request.setAttribute("alertMsg", "Post Created");
				else
					request.setAttribute("alertMsg", "Post cannot be Created");
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
