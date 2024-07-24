//package com.demoapp.jee;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.demoapp.login.UserValidationService;
//
//@WebServlet(urlPatterns = "/login.run")
//public class LoginServlet extends HttpServlet {
//	private UserValidationService validationService = new UserValidationService();
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String name = request.getParameter("name");
//		request.setAttribute("name", name);
//		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		if (validationService.isUserValid(name, password)) {
//			request.setAttribute("name", name);
//			request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response);
//		} else {
//			request.setAttribute("errors", "Username or Password is not correct");
//			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//		}
//
//	}
//}
