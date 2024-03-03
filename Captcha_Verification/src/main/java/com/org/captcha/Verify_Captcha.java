package com.org.captcha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/verifyCaptcha")
public class Verify_Captcha extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				String userCaptcha = req.getParameter("userCaptcha");
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				
				
//				ServletContext context = getServletContext();
//				String captcha = (String)context.getAttribute("genCaptcha");
				
				
				HttpSession session = req.getSession();
				Object genCaptcha = session.getAttribute("genCaptcha");
				if(userCaptcha.equals(genCaptcha)) {
					out.println("<h1>Correct Captcha</h1>");
				}
				else
					out.println("<h1>Incorrect Captcha</h1>");
				
		}
}
