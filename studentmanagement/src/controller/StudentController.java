package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.Student;
import dao.StudentDao;
import db.DbConnection;

public class StudentController implements StudentDao
{
	Connection conn= DbConnection.getConnection();

	@Override
	public void add(Student s) 
	{
		try
		{
			String sql="insert into student(name, english, hindi, maths, science, social_science, total_marks) values(?, ?, ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getStud_name());
			ps.setInt(2, s.getEnglish_marks());
			ps.setInt(3, s.getHindi_marks());
			ps.setInt(4, s.getMaths_marks());
			ps.setInt(5, s.getScience_marks());
			ps.setInt(6, s.getSocialscience_marks());
			ps.setInt(7, s.getTotal_marks());
			int rowinserted = ps.executeUpdate();
			if(rowinserted > 0)
				System.out.println("Inserted");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void remove(int id) 
	{
		try
		{
			String sql="delete from student where roll_num = ?";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rowdeleted = ps.executeUpdate();
			if(rowdeleted > 0)
				System.out.println("Deleted");
			else
			{
				System.out.println("Empty set");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void update(Student s) 
	{
		try
		{
			String sql="update student set name=?, english=?, hindi=?, maths=?, science=?, social_science=?, total_marks=? where roll_num=?";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getStud_name());
			ps.setInt(2, s.getEnglish_marks());
			ps.setInt(3, s.getHindi_marks());
			ps.setInt(4, s.getMaths_marks());
			ps.setInt(5, s.getScience_marks());
			ps.setInt(6, s.getSocialscience_marks());
			ps.setInt(7, s.getTotal_marks());
			ps.setInt(8, s.getId());
			int rowupdated = ps.executeUpdate();
			if(rowupdated > 0)
				System.out.println("Updated");
			else
			{
				System.out.println("Empty set");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Student getStudent(int id) 
	{
		Student student=null;
		try
		{
			
			String sql="Select * from student where roll_num=?";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				student = new Student();
				student.setId(rs.getInt(1));
				student.setStud_name(rs.getString(2));
				student.setEnglish_marks(rs.getInt(3));
				student.setHindi_marks(rs.getInt(4));
				student.setMaths_marks(rs.getInt(5));
				student.setScience_marks(rs.getInt(6));
				student.setSocialscience_marks(rs.getInt(7));
				student.setTotal_marks(rs.getInt(8));
			}	
		}
		catch(Exception e)
		{
			System.out.println();
		}
		
		return student;
	}

	@Override
	public List<Student> getStudents() 
	{
		
		List<Student> students = new ArrayList<>();
		Student student=null;
		try
		{
			String sql="select * from student";
			java.sql.PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				student = new Student();
				student.setId(rs.getInt(1));
				student.setStud_name(rs.getString(2));
				student.setEnglish_marks(rs.getInt(3));
				student.setHindi_marks(rs.getInt(4));
				student.setMaths_marks(rs.getInt(5));
				student.setScience_marks(rs.getInt(6));
				student.setSocialscience_marks(rs.getInt(7));
				student.setTotal_marks(rs.getInt(8));
				students.add(student);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return students;
	}

	
	
	
}
