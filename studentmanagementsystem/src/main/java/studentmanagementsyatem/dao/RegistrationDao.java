package studentmanagementsyatem.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import studentmanagementsyatem.bean.User;
import studentmanagementsyatem.dbconn.DbConnection;

public class RegistrationDao 
{
	static Connection conn = DbConnection.getConnection();
	public static String register(User user) throws SQLException
	{
		try
		{
			String sql="insert into user(name, email, pass) values( ?, ?, ?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			int rowupdate=ps.executeUpdate();
			if(rowupdate>0)
				return "Success";
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Failed";
	}		
}
