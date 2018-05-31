package jcdg;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //HttpSession session = request.getSession();
//    	Student student = (Student) session.getAttribute("student");// 这里的"student"对应Check.java第54行
//    	String id = student.getId();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		Student student = DatabaseCp.selectCp(id);
		
		if (student != null )
		{
			System.out.println("1111111");
			DatabaseCp.deleteCp(id);
			RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/JSP-file/deletestudent.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			System.out.println("2222222");
			RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/JSP-file/deletestudent_error.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}


