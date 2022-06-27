package studentmanagementsyatem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsyatem.bean.User;
import studentmanagementsyatem.dao.LoginDao;
import studentmanagementsyatem.dao.LoginDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
		String email =request.getParameter("Username");
		String password =request.getParameter("Password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

				
	
		LoginDao logdao = new LoginDao();
		
		String userlog;
		
			userlog = LoginDao.Login(user);
			
			if(userlog.equals(email))
			{
				response.sendRedirect("index.jsp");	
			}
			else
			{
				response.sendRedirect("login.jsp");
			}						
	}

}
