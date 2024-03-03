package com.org.captcha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s1")
public class CreatingCaptcha extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			out.print("<h1>Hello , "+name+"</h1>");
			
			Random rd = new Random();
			
			String captcha=""+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9);
			
			out.println("<h1>Please enter your captcha , "+captcha+"</h1>");
			
//			ServletContext context = getServletContext();
//			context.setAttribute("genCaptcha",captcha);
			
			HttpSession session = req.getSession();
			session.setAttribute("genCaptcha", captcha);
			
			out.println("<html>"
					+ "<body>"
					    + "<form action='verifyCaptcha' method='post'>"
					    + "<input type='text' name='userCaptcha'><br>"
					    + "<input type='submit'>"
					    + "</form>"
						+ "</body>"
					+ "</html>");
		}
}
