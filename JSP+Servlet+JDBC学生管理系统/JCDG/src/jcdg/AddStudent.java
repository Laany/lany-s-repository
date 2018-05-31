package jcdg;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		String id = (String) request.getParameter("student_id");
		String name = (String) request.getParameter("student_name");
		String school = (String) request.getParameter("school");
		String tel = (String) request.getParameter("student_tel");
		String qq = (String) request.getParameter("student_qq");
		String address = (String) request.getParameter("address");
		int tel1 = Integer.parseInt(tel);
		int qq1 = Integer.parseInt(qq);
		//String str = "insert into students (student_id, student_name, school, student_tel, student_qq, address) values " + "('" + id + "' ,'" + name + "' ,'" + school + "' ,'" + tel1 + "','" + qq + "' ,'" + address + "')" + ";";
		//String str = "insert into students (student_id, student_name, school, student_tel, student_qq, address) values (?, ?, ?, ?, ?, ?)";
		DatabaseCp.insertCp(id, name, school, address, tel1, qq1);
		
		RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/JSP-file/addstudent.jsp");
		requestDispatcher.forward(request, response);
	}

}
