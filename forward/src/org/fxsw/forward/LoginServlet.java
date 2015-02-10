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
import org.apache.catalina.valves.rewrite.RewriteValve;
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname=request.getParameter("name");
		String password=request.getParameter("password");
		Properties pro=new Properties();
		try {
			pro.load(this.getClass().getResourceAsStream("/user.properties"));
		} catch (Exception e) {
			System.out.println("load error");
		}
		
		response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
		if(loginname.equals(pro.getProperty("loginname"))&&password.equals(pro.getProperty("password"))){
			
			User user=new User(loginname,password,pro.getProperty("sex") ,Integer.parseInt(pro.getProperty("age")) );
			request.setAttribute("user", user);
			request.getRequestDispatcher("/book.do").forward(request, response);
			
			
		}else {
			out.println("error");
		}
		out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
	}

}
