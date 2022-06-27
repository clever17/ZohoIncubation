package studentmanagementsyatem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import studentmanagementsyatem.bean.User;
import studentmanagementsyatem.dbconn.DbConnection;

public class LoginDao 
{
	static Connection conn = DbConnection.getConnection();
	static public String Login(User user)
	{
		try
		{
			String sql="Select * from user where email=? and pass=?";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				return user.getEmail();
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "failed";
	}
	
	
}
