package studentmanagementsyatem.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsyatem.bean.User;
import studentmanagementsyatem.dao.RegistrationDao;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher=null;
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("password");
		
		User user = new User();
		user.setName(uname);
		user.setEmail(uemail);
		user.setPassword(upass);
		
		RegistrationDao regdao = new RegistrationDao();
		
		String usereg;
		
			try 
			{
				usereg = RegistrationDao.register(user);
				if(usereg.equals("Success"))
				{
					response.sendRedirect("login.jsp");	
				}
					
				else
				{
					request.setAttribute("status", "failed");
					request.getRequestDispatcher("registration.jsp");
				}
			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
			
		

		
			
	}

}
