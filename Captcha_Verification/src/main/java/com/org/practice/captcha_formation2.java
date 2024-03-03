package com.org.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/a2")
public class captcha_formation2 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	Random rd = new Random();
	String genCaptcha=""+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9);
	HttpSession session = req.getSession();
	session.setAttribute("genCaptcha", genCaptcha);
	
	out.println("<h1>Hello ," +name+"</h1>");
	out.println("<h1>Enter your captcha  "+genCaptcha+"</h1>");
	out.println("<html>"
			+ "<body>"
				+ "<form action='verifyCaptchaa' method='post'>"
				+ "<input type='text' name='userCaptcha'><br>"
				+ "<input type='submit'>"
				+ "</form>"
			+ "</body>"
			+ "</html>");



}
}
