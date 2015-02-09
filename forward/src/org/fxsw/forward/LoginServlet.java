package org.fxsw.forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore.PasswordProtection;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.fxsw.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		/*response.setContentType("text/html");
		         PrintWriter out = response.getWriter();
		         out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		         out.println("<HTML>");
		         out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		         out.println("  <BODY>");
		         
		         if(request.getParameter("name").equals("jian"))
		         {
		        	 System.out.println("hello,jian");
		        	 request.setAttribute("username", "jianxuewei");
		        	 RequestDispatcher rd=request.getRequestDispatcher("/success.do");
		        	 rd.forward(request, response);
		         }
		         
		         	 out.print("    This is "+request.getParameter("name"));
		         
		         out.println(", using the GET method");
		         out.println("  </BODY>");
		         out.println("</HTML>");
		         out.flush();
		         out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname=request.getParameter("name");
		String password=request.getParameter("password");
		Properties pro=new Properties();
		pro.load(this.getClass().getResourceAsStream("/user.properties"));
		response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
		if(loginname.equals(pro.getProperty("loginname"))&&password.equals(pro.getProperty("password"))){
			
			User user=new User(loginname,password,pro.getProperty("sex") ,Integer.parseInt(pro.getProperty("age")) );
			
			out.print("    µÇÂ¼³É¹¦ ");
			out.print("<br/>");
			out.println("<a href=course.do>Ìø×ª</a>");
			
		}else {
			out.println("error");
		}
		out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
	}

}
