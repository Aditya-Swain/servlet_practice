package com.org.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/verifyCaptchaa")
public class verify_captcha2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userCaptcha = req.getParameter("userCaptcha");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		Object genCatcha = session.getAttribute("genCaptcha");
		
		if(userCaptcha.equals(genCatcha))
			out.print("<h1>Correct Captcha</h1>");
		else
			out.print("<h1>Incorrect Captcha</h1>");
	}
}
