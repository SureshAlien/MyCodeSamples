package com.login.dao;

import java.sql.*;


public class LoginDao 
{
	String sql="select * from login where uname=? and pass=?";
	String url ="jdbc:mysql://localhost:3306/telusko?useSSL=false";
	String username="root";
	String password="1234";
	public boolean check(String uname,String passw)
	{
		System.out.println("hey suresh you are in DAO*******************************");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2,passw );
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return false;
	}

}
