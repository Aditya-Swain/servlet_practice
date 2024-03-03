package com.org.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/verify")
public class verify_captcha extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String ucaptcha = req.getParameter("ucaptcha");
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			
			HttpSession session = req.getSession();
			String genCaptcha =(String)session.getAttribute("genCaptcha");
			
			if(genCaptcha.equals(ucaptcha)) {
				out.print("<h2>correct captcha</h2>");
			}
			else
				out.print("<h2>incorrect  captcha</h2>");
		}
}
