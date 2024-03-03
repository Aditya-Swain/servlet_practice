package com.fortune;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FortuneTeller extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String[] arr= {"you will get a job in the next year",
					   "you will be get fired from your current job",
					   "Be careful, you will have a toxic friend soon",
					   "Sorry, You will die before 2025",
					   "You will become a good programmer ",
					   "You will become a CM in next year",
					   "You will marry before 2025",
					   "You will have a baby soon",
					   "You will be prouded for your work in 2024",
					   "You will always be single",
					   "You will be the richest person in your village by 2024"};
		Random random = new Random();
		int value = random.nextInt(arr.length-1);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1 style='color:orange'><i><b>"+arr[value]+"</b></i></h1>");
		
	}

}
