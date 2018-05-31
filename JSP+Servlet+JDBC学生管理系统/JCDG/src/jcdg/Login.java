package jcdg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String piccode=(String) request.getSession().getAttribute("piccode");
		String checkCode=request.getParameter("checkCode");  
		piccode=piccode.toLowerCase();
		checkCode=checkCode.toLowerCase();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out=response.getWriter();
		if(checkCode.equals(piccode)) {
			out.println("验证码输入正确！");
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/ShowStudent");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/JSP-file/checkCode_error.jsp");
			dispatcher.forward(request, response);
		}
		    out.flush();
		    out.close();
	}
}

