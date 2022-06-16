package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import bean.Student;
import dao.StudentOperationDao;
import db.DbConnection;

public class StudentOperationController implements StudentOperationDao
{

	Connection conn= DbConnection.getConnection();
	@Override
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
	@Override
	public void average_Mark()
	{
		
		try
		{
			String sql="select avg(english), avg(hindi), avg(maths), avg(science), avg(social_science) from student";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("English Average Marks:"+rs.getFloat(1));
				System.out.println("Hindi Average Marks:"+rs.getFloat(2));
				System.out.println("Maths Average Marks:"+rs.getFloat(3));
				System.out.println("Science Average Marks:"+rs.getFloat(4));
				System.out.println("Social Science Average Marks:"+rs.getFloat(5));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println();
		}
	
	}
	@Override
	public void display_HigherAverage() 
	{
		
		try
		{
			String sql1="select name, english as 'English' from student where english >= (select avg(english) from student)";
			String sql2="select name, hindi as Hindi from student where hindi >= (select avg(hindi) from student)";
			String sql3="select name, maths as Maths from student where maths >= (select avg(maths) from student)";
			String sql4="select name, science as Science from student where science >= (select avg(science) from student)";
			String sql5="select name, social_science as SocialScience from student where social_science >= (select avg(social_science) from student)";
			
			String sql="select english, hindi, maths, science, social_science from student";
			
			String sq="select avg(english), avg(hindi), avg(maths), avg(science), avg(social_science) from student";
			java.sql.PreparedStatement ps1 = conn.prepareStatement(sql1);
			java.sql.PreparedStatement ps2 = conn.prepareStatement(sql2);
			java.sql.PreparedStatement ps3 = conn.prepareStatement(sql3);
			java.sql.PreparedStatement ps4 = conn.prepareStatement(sql4);
			java.sql.PreparedStatement ps5 = conn.prepareStatement(sql5);
			java.sql.PreparedStatement ps6 = conn.prepareStatement(sql);
			java.sql.PreparedStatement ps7 = conn.prepareStatement(sq);
			
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			ResultSet rs6 = ps6.executeQuery();
			ResultSet rs7 = ps7.executeQuery();
			
			java.sql.ResultSetMetaData rsmd = rs6.getMetaData();
		
		while(rs7.next())
		{
			
		
			System.out.println("\n"+rsmd.getColumnName(1));
			System.out.println(rs7.getFloat(1));
			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
				System.out.println(rs1.getInt(2));
			}
			System.out.println("\n"+rsmd.getColumnName(2));
			System.out.println(rs7.getFloat(2));
			while(rs2.next())
			{
				System.out.println(rs2.getString(1));
				System.out.println(rs2.getInt(2));
			}
			System.out.println("\n"+rsmd.getColumnName(3));
			System.out.println(rs7.getFloat(3));
			while(rs3.next())
			{
				System.out.println(rs3.getString(1));
				System.out.println(rs3.getInt(2));
			}
			System.out.println("\n"+rsmd.getColumnName(4));
			System.out.println(rs7.getFloat(4));
			while(rs4.next())
			{
				System.out.println(rs4.getString(1));
				System.out.println(rs4.getInt(2));
			}
			System.out.println("\n"+rsmd.getColumnName(5));
			System.out.println(rs7.getFloat(5));
			while(rs5.next())
			{
				System.out.println(rs5.getString(1));
				System.out.println(rs5.getInt(2));
			}
			
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public void top_scorer() 
	{
		
		
		try
		{
			
			String sql1="select tbl.name, tbl.english from student tbl join ( select max(english) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.english";
			String sql2=" select tbl.name, tbl.hindi from student tbl join ( select max(hindi) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.hindi";
			String sql3=" select tbl.name, tbl.maths from student tbl join ( select max(maths) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.maths";
			String sql4=" select tbl.name, tbl.science from student tbl join ( select max(science) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.science";
			String sql5=" select tbl.name, tbl.social_science from student tbl join ( select max(social_science) as MaxMarks from student) tbl1 on tbl1.MaxMarks=tbl.social_science";
					
			
			String sq="select english, hindi, maths , science, social_science from student";
			
			java.sql.PreparedStatement ps1 = conn.prepareStatement(sql1);
			java.sql.PreparedStatement ps2 = conn.prepareStatement(sql2);
			java.sql.PreparedStatement ps3 = conn.prepareStatement(sql3);
			java.sql.PreparedStatement ps4 = conn.prepareStatement(sql4);
			java.sql.PreparedStatement ps5 = conn.prepareStatement(sql5);
			java.sql.PreparedStatement pss = conn.prepareStatement(sq);
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			
			ResultSet rss = pss.executeQuery();
			
			java.sql.ResultSetMetaData rsmd = rss.getMetaData();
			System.out.println("\n"+rsmd.getColumnName(1));
			while(rs1.next())
			{	
				System.out.println(rs1.getString(1));
			}
			System.out.println("\n"+rsmd.getColumnName(2));
			while(rs2.next())
			{	
				System.out.println(rs2.getString(1));
			}
			System.out.println("\n"+rsmd.getColumnName(3));
			while(rs3.next())
			{	
				System.out.println(rs3.getString(1));
			}
			System.out.println("\n"+rsmd.getColumnName(4));
			while(rs4.next())
			{	
				System.out.println(rs4.getString(1));
			}
			System.out.println("\n"+rsmd.getColumnName(5));
			while(rs5.next())
			{	
				System.out.println(rs5.getString(1));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	@Override
	public void academic_Details() 
	{
		try
		{
			String sq1="select name , english from student ";
			String sq2="select name , hindi from student";
			String sq3="select name , maths from student";
			String sq4="select name , science from student";
			String sq5="select name, social_science from student";
			
			java.sql.PreparedStatement ps1 = conn.prepareStatement(sq1);
			java.sql.PreparedStatement ps2 = conn.prepareStatement(sq2);
			java.sql.PreparedStatement ps3 = conn.prepareStatement(sq3);
			java.sql.PreparedStatement ps4 = conn.prepareStatement(sq4);
			java.sql.PreparedStatement ps5 = conn.prepareStatement(sq5);
			
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			
			java.sql.ResultSetMetaData rsmd1 = rs1.getMetaData();
			System.out.println("\n"+rsmd1.getColumnName(2));
			while(rs1.next())
			{
				System.out.println(rs1.getString(1));
				System.out.println(rs1.getInt(2));
			}
			
			java.sql.ResultSetMetaData rsmd2 = rs2.getMetaData();
			System.out.println("\n"+rsmd2.getColumnName(2));
			while(rs2.next())
			{
				System.out.println(rs2.getString(1));
				System.out.println(rs2.getInt(2));
			}
			
			java.sql.ResultSetMetaData rsmd3 = rs3.getMetaData();
			System.out.println("\n"+rsmd3.getColumnName(2));
			while(rs3.next())
			{
				System.out.println(rs3.getString(1));
				System.out.println(rs3.getInt(2));
			}
			
			java.sql.ResultSetMetaData rsmd4 = rs4.getMetaData();
			System.out.println("\n"+rsmd4.getColumnName(2));
			while(rs4.next())
			{
				System.out.println(rs4.getString(1));
				System.out.println(rs4.getInt(2));
			}
			
			java.sql.ResultSetMetaData rsmd5 = rs5.getMetaData();
			System.out.println("\n"+rsmd5.getColumnName(2));
			while(rs5.next())
			{
				System.out.println(rs5.getString(1));
				System.out.println(rs5.getInt(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	@Override
	public void subjectcount_HigherMarks() 
	{
		try
		{
			String sql="select count(name) as English from student where english >= (select avg(english) from student) union all"
					+ " select count(name) as Hindi from student where hindi >= (select avg(hindi) from student) union all"
					+ " select count(name) as Maths from student where maths >= (select avg(maths) from student) union all"
					+ " select count(name) as Science from student where science >= (select avg(science) from student) union all"
					+ " select count(name) as SocialScience from student where social_science >= (select avg(social_science) from student)";
			
			String sql1="select english, hindi, maths, science, social_science from student";
			
			
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			
			java.sql.PreparedStatement pss = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = pss.executeQuery();
			
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			
			int i=1;
			while(rs.next())
			{
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rs.getInt(1));
				i++;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
