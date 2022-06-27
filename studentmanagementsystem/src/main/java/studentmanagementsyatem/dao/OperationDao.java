package studentmanagementsyatem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studentmanagementsyatem.bean.Student;
import studentmanagementsyatem.dbconn.DbConnection;

public class OperationDao 
{
	Connection conn = DbConnection.getConnection();
	public List<Student> display_Rankbased()
	{
		List<Student> students = new ArrayList<>();
		Student student=null;
		try
		{
			String sql="select roll_num, name, english, hindi, maths, science, social_science, total_marks, "
					+ "rank() over(order by total_marks desc) from student";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
				student.setRank(rs.getInt(9));
				students.add(student);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return students;
	}
	
	public List<Float> average_Mark()
	{
		List<Float> list = new ArrayList<>();
		
		try
		{
			String sql="select avg(english), avg(hindi), avg(maths), avg(science), avg(social_science) from student";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
	
				list.add(rs.getFloat(1));
				list.add(rs.getFloat(2));
				list.add(rs.getFloat(3));
				list.add(rs.getFloat(4));
				list.add(rs.getFloat(5));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	
	}
	
	}
