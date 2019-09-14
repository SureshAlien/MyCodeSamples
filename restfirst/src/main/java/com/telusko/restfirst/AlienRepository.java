package com.telusko.restfirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.sql.*;


public class AlienRepository 
{
	List<Alien> aliens ;

	Connection con = null;
	
	public  AlienRepository()
	{
		String url ="jdbc:mysql://localhost:3306/restdb?useSSL=false";

		//String url ="jdbc:mysql://localhost:3306/restdb";
		String username="root";
		String password="1234";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password); 
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public List<Alien> getAliens()
	{
		System.out.println("from get Aliens() in alien repository");
		System.out.println(" checking ");	

		List<Alien> aliens = new ArrayList<>();
		String sql ="select * from alien";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next())
			{
				Alien a= new Alien();
				a.setId(rs.getInt(1));
				System.out.println("from get Aliens() aliens::::::::"+rs.getInt(1));

				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
				System.out.println("from get Aliens() aliens::::::::"+aliens);


			}
			
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return aliens;
	}

	public Alien getAlien(int id)
	{
		System.out.println("debuging one alien id"+id);

		Alien a= new Alien();

		String sql ="select * from alien where id="+id;
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next())
			{
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
					
			}
			
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println("debuging one alien classss"+a.getName());

		return a;
		
	
	}

	public void update(Alien a1) 
	{
		//UPDATE table_name SET column1 = value1, column2 = value2, ...WHERE condition;
		String sql ="update alien set name=?,points=? where id=?";
		try 
		{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a1.getName());
			pst.setInt(2,a1.getPoints());
			pst.setInt(3,a1.getId()); //third ques mark,so 3

		    pst.executeUpdate();

			
		} 
		catch (SQLException e) {
			System.out.println(e);
		}		
	}
	public void create(Alien a1) 
	{
		String sql ="insert into alien values(?,?,?)";
		try 
		{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,a1.getId());
			pst.setString(2,a1.getName());
			pst.setInt(3,a1.getPoints());
		    pst.executeUpdate();

			
		} 
		catch (SQLException e) {
			System.out.println(e);
		}		
	}
	public void deleteAlien(int id) 
	{
		//DELETE FROM `table_name` [WHERE condition];

		String sql ="delete from alien  where id =?";
		try 
		{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,id);
		    pst.executeUpdate();
			
		} 
		catch (SQLException e) {
		}		
	}



}
