package org.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.config.DBConfig;
import org.model.Student;

public class DBHelper {
	
	public static Connection getConn()
	{
		
		Connection con = null;
		try {
	        Class.forName("org.gjt.mm.mysql.Driver");
	    } catch (ClassNotFoundException ce) {
	        System.out.println(ce);
	    }
	    try {
	        String url = "jdbc:mysql://"+DBConfig.DB_SERVER_IP+":"+DBConfig.DB_SERVER_PORT+"/XSCJ?useUnicode=true&characterEncoding=utf-8";
	        System.out.println(url);
	        String dbUsername= DBConfig.COMMON_USER;
	        String pwd = DBConfig.COMMON_USER_PWD;
	        con = DriverManager.getConnection(url,dbUsername,pwd);
//	        Statement s = con.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_INSENSITIVE);
//	        s.close();
//	        con.close();
	        
	        
	    } catch (SQLException ce) {
	        System.out.println(ce);
	    }
		return con; 
	}
	
	public void closeConn(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void saveStu(Student stu)
	{
		Connection conn = getConn();
		try {
			String addStr = "insert into XSB values(?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(addStr);
			st.setString(1, stu.getStuNo());
			st.setString(2, stu.getName());
			st.setBoolean(3, stu.getSex());
			st.setDate(4, (Date) stu.getBirthDay());
			st.setInt(5, stu.getMajor());
			st.setString(6, stu.getComment());
			st.execute();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Student> getStuInfo()
	{
		ArrayList<Student> stus = new ArrayList<Student>();
		stus.clear();
		Connection conn = getConn();
		String getStr = "select * from XSB";
		try {
			PreparedStatement st = conn.prepareStatement(getStr);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Student stu = new Student();
				stu.setStuNo(rs.getString("XH"));
				stu.setName(rs.getString("XM"));
				stu.setSex(rs.getBoolean("XB"));
				stu.setBirthDay(rs.getDate("CSSJ"));
				stu.setMajor(rs.getInt("ZY_ID"));
				stu.setComment(rs.getString("BZ"));
				stus.add(stu);
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stus;
	}
	
	public static void TestConn()
	{
		Connection conn = getConn();
		String testStr = "select * from XSB";
		
		try {
			PreparedStatement st = conn.prepareStatement(testStr);
//			st.setString(1, "XSB");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(2));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
