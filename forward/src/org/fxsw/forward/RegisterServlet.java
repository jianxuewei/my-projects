package org.fxsw.forward;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		Properties pro=new Properties();
		pro.setProperty("loginname", request.getParameter("name"));
		pro.setProperty("password", request.getParameter("password"));
		pro.setProperty("sex", new String(request.getParameter("sex").getBytes("ISO-8859-1"),"GBK"));
		System.out.println(pro.getProperty("sex"));
		pro.setProperty("age", request.getParameter("age"));
		String path=this.getClass().getResource("/").toString();
		System.out.println(path);
		path=path.substring(path.indexOf("/")+1);
		System.out.println(path);
		pro.store(new FileOutputStream(path+"user.properties"), "");
		response.sendRedirect("login.html");
	}

}
