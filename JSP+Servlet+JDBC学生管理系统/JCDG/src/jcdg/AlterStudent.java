package jcdg;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AlterStudent
 */
public class AlterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterStudent() {
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
		String id = request.getParameter("student_id");
		String name = request.getParameter("student_name");
		String school = request.getParameter("school");
		String tel = request.getParameter("student_tel");
		String qq = request.getParameter("student_qq");
		String address = request.getParameter("address");
		int tel1 = Integer.parseInt(tel);
		int qq1 = Integer.parseInt(qq);
		
		Student student = DatabaseCp.selectCp(id);
		
		try{
			if (id == null)
				id = student.getId();
			if (name == null)
				name = student.getName();
			if (school == null)
				school = student.getSchool();
			if (tel == null)
				tel1 = student.getTel();
			if (qq == null)
				qq1 = student.getQq();
			if (address == null)
				tel = student.getAddress();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		DatabaseCp.updateCp(id, name, school, address, tel1, qq1);
		RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/JSP-file/alterstudent.jsp");
		requestDispatcher.forward(request, response);
		}
} 

