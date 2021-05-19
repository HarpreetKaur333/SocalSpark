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

import DB.UserDBUtil;
import Model.Post;
import Model.RegisterUser;
import Model.SuggestedFriends;
import Model.User;
import Model.Post;
import DB.PostDBUtil;



/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				System.out.println("ProfileServlet");
				HttpSession session = request.getSession();
				
				User user = (User) session.getAttribute("user");				
				UserDBUtil userdbutil = new UserDBUtil(ds); 

			        
				int loginsessionuserid = (int) session.getAttribute("loginuserid"); //get userid from session
				ArrayList<SuggestedFriends> friendslist = new ArrayList<>();
				ArrayList<Post> UserPostlist = new ArrayList<>();
				try {
					UserPostlist=postdb.getUserPosts(user);
					
					session.setAttribute("user", user);	
					
					 friendslist = userdbutil.friendlist(loginsessionuserid);

				} catch (Exception e) {
					e.printStackTrace();
				}finally {		
					RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
					request.setAttribute("friendslist", friendslist); 
					request.setAttribute("UserPostlist", UserPostlist); 
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
