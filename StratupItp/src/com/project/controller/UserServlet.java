package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.User;
import com.project.service.UserService;



public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString().trim();
		int age = Integer.parseInt(request.getParameter("age").toString());
		String address = request.getParameter("address").toString().trim();
		
		User user = new User(username, age, address);
		int results = UserService.addUser(user);
		
		System.out.println(results);
		response.sendRedirect("Jsp/UserList.jsp");
		//now pass user object to service 
		
	}

}
