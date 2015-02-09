package org.fxsw.forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fxsw.DAO.CoursesDAO;
import org.fxsw.vo.Course;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoursesDAO dao=new CoursesDAO();
		List<Course> courses=dao.getAllCourses();
		
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    <center> ");
		out.println("<h2>课程列表</h2>");
		out.print("<table border=1>");
		out.print("<th><td>课程名称</td><td>课程时间</td><td>介绍</td></th>");
		for(Course course:courses){
			out.print("<tr><td>"+course.getName()+"</td><td>"+course.getDate()+"</td><td>"+course.getDescribe()+"</td></tr>");
			
		}
		out.print("</table>");
		out.print("    </center> ");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
