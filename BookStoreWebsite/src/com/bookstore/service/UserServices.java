package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;

public class UserServices {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UsersDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entityManagerFactory  = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UsersDAO(entityManager);
	}
	
	public void ListUser() throws ServletException, IOException{
	     ListUser(null);
		
	} 
	
	public void ListUser(String message) throws ServletException, IOException{
		List<Users> listUser = userDAO.listAll();
		request.setAttribute("userList", listUser);
		if(message != null) {
			request.setAttribute("message", message);
		}
	
		String listUserPage ="user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listUserPage);
		requestDispatcher.forward(request, response);
		
	}
	
	public void CreateUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		Users existUser = userDAO.findByEmail(email);
		
		if(existUser != null) {
			String message = "Could not create user . A user with email id " +email+ "already exist";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
			
		}else {

			Users createNewUser = new Users(email,password,fullname);
			userDAO.create(createNewUser);
			ListUser("New User Created Successfully");
		}
	
	}

	public void EditUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		String edit_page = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher =request.getRequestDispatcher(edit_page);
		requestDispatcher.forward(request, response);
		
		
	}

	public void UpdateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
	
		Users userByEmail = userDAO.findByEmail(email);
		Users userById = userDAO.get(userId);
		
		
		
		/*Users user = new Users(userId,email,password,fullname);
		userDAO.update(user);
		String messageUpdate = "User updated with user email";
		ListUser(messageUpdate);*/
	     if(userByEmail != null && userById.getUserId() != userByEmail.getUserId()) {
			
			String message = "Could not updated user using user with email ";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
			
		}else {
			Users user = new Users(userId,email,password,fullname);
			userDAO.update(user);
			String messageUpdate = "User updated with user email";
			ListUser(messageUpdate);
			
		}
		
		
		
		
	}
	
	

	
	
	

}
