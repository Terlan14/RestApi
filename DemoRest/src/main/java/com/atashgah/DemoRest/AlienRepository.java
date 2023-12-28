package com.atashgah.DemoRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;



public class AlienRepository 
{
	List<Alien>aliens;
	Connection con=null;
	public AlienRepository()   {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb","root","ibrahimliterlaN@2797");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public List<Alien>getAliens(){
		List<Alien>aliens=new ArrayList();
		String sql="select * from aliens";
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setAname(rs.getString(2));
				a.setPoints(rs.getInt(3));
				aliens.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aliens;
	}
	public Alien getAlien(int id) {
		Alien  a=new Alien();
		
		String sql="select * from aliens where id="+id;
		try 
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setAname(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return a;
		
	}
	public void create(Alien a1) {
		String sql="insert into aliens values(?,?,?)";
		try 
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getAname());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}

	}
	public void update(Alien a1) {
		String sql="update  aliens set name=?,points=? where id=?";
		try 
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, a1.getAname());
			st.setInt(2, a1.getPoints());
			st.setInt(3, a1.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
	
		}
	public void delete(int id) {
		String sql="delete from aliens where id=?";
		try 
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
	}
	}
