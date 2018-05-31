package jcdg;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Servlet implementation class CheckUser
 */
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	Administrator administrator = (Administrator) session.getAttribute("administrator");
    	
    	String id = administrator.getUser_id();
    	String pass = administrator.getUser_password();
    	Boolean bl = false;
    	
    	List<Administrator> retAdministrators = DatabaseCp.selectAdmCp(id, pass);
    	int i = retAdministrators.size();
    	
    	if (i != 0)
    	{
    		bl = true;
    	}
    		
		if (bl)
		{
			request.setAttribute("result", true);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Login"); 
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("result", "管理员不存在");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/JSP-file/error.jsp"); 
			dispatcher.forward(request, response);
		}
	}


}
