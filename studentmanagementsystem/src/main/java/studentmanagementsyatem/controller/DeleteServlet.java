package studentmanagementsyatem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsyatem.bean.Student;
import studentmanagementsyatem.dao.StudentDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDao sd = new StudentDao();

    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		sd.remove(student.getId());
		response.sendRedirect("viewstudent.jsp");
	}

}
