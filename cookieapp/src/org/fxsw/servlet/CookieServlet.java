package org.fxsw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookie.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Cookie[] cookies=request.getCookies();
		if (cookies!=null){
			
		
			for(int i=0;i<cookies.length;i++){
				Cookie cookie=cookies[i];
				//System.out.println(i+"");
				out.write(cookie.getName()+":");
				if( cookie.getName().equals("lastAccessTime")){
					Long lastAccessTime=Long.parseLong(cookie.getValue());
					Date date=new Date(lastAccessTime);
					
					out.write(date.toString()+":<br/>");
					
				}
				else{
					out.write(cookie.getValue()+":<br/>");
				}
			}
		}else {
			out.write("这是您第一次登录");
		}
		Cookie cookie=new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
