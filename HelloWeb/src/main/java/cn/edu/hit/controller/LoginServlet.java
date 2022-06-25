package cn.edu.hit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.UsersDao;
import cn.edu.hit.dao.Impl.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		if(username.equals("")||pwd.equals("")) {
			response.sendRedirect("login.jsp");
			return ;
		}
		UsersDao dao=new UsersDaoImpl();
		if(dao.login(username, pwd)) {
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
			String rem=request.getParameter("rem");
			if((rem!=null) &&(rem.equals("yes"))){
				Cookie c=new Cookie("username",username);
				c.setMaxAge(60*60*24);
				response.addCookie(c);
			}
			response.sendRedirect("student.jsp");
		}else {
			response.sendRedirect("error.html");
		}
	}

}
