package studentmanagementsyatem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsyatem.bean.Student;
import studentmanagementsyatem.dao.StudentDao;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDao studentdao = new StudentDao();
 
    public AddStudentServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		Student student = new Student();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		student.setStud_name(request.getParameter("name"));
		student.setEnglish_marks(Integer.parseInt(request.getParameter("english_marks")));
		student.setHindi_marks(Integer.parseInt(request.getParameter("hindi_marks")));
		student.setMaths_marks(Integer.parseInt(request.getParameter("maths_marks")));
		student.setScience_marks(Integer.parseInt(request.getParameter("science_marks")));
		student.setSocialscience_marks(Integer.parseInt(request.getParameter("socialscience_marks")));
		student.setTotal_marks(student.getEnglish_marks()+student.getHindi_marks()+student.getMaths_marks()+
				student.getScience_marks()+student.getSocialscience_marks());
		
		int status=studentdao.add(student);
		
		if(status>0)
		{
			out.print("<p> Record Added Successfully</p>");
			response.sendRedirect("index.jsp");
		}
		else
		{
			out.print("<p> sorry unable to store</p>");
		}
		out.close();
	}

}
