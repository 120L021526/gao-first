package cn.edu.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.*;
import cn.edu.hit.dao.Impl.*;
import cn.edu.hit.entity.*;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid");
		StudentDao dao=new StudentDaoImpl();
		dao.remove(sid);
		response.sendRedirect("student.jsp");
		//doPost(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==null){
			response.setContentType("text/html;charset=GBK");
			PrintWriter out=response.getWriter();
			out.println("你是非法用户，请登录");
			return ;
		}
		request.setCharacterEncoding("GBK");//该句只对post有效而对get无效
		String from=request.getParameter("from");
		if(from.equals("add")){
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String gender=request.getParameter("gender");
			int age=Integer.parseInt(request.getParameter("age"));
			String birthday=request.getParameter("birthday");
			String major=request.getParameter("major");
			StudentDao dao=new StudentDaoImpl();
			dao.add(new Student(sid, sname, age, birthday, gender, major));
	}else if(from.equals("modify")) {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String birthday=request.getParameter("birthday");
		String major=request.getParameter("major");
		StudentDao dao=new StudentDaoImpl();
		dao.modify(new Student(sid, sname, age, birthday, gender, major));
	}
		response.sendRedirect("student.jsp");
		//doGet(request, response);
	}

}
