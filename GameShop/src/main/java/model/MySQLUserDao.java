package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUserDao implements UserDao
{

Connection con;
	
	public MySQLUserDao() {
		try {
			//TODO
			con = Configuration.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean registerUser(User user) throws SQLException 
	{
		PreparedStatement pstmt = con.prepareStatement("select * from USERS WHERE email = '"+user.getEmail()+"'");
        ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			return false;
		else
		{	
			String insertStatement = "INSERT INTO USERS(Name, Password, Email) VALUES(?,?,?)";
        	PreparedStatement insertstmt = con.prepareStatement(insertStatement);
        	insertstmt.setString(1, user.getName());
        	insertstmt.setString(2,  user.getPassword());
        	insertstmt.setString(3, user.getEmail());
        	
        	insertstmt.executeUpdate();
        	return true;
		}
	}

	@Override
	public boolean checkUserPw(User user) throws SQLException
	{
		PreparedStatement pstmt = con.prepareStatement("select PASSWORD from USERS WHERE email = '"+user.getEmail()+ "'");
        ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			if(rs.getString(0)==user.getPassword())
				return true;
			else 
				return false;
		}
		else
		{	
        	return false;
		}
	}

}
