package org.test;

import java.sql.Date;

import org.database.DBHelper;
import org.model.Student;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		DBHelper.TestConn();
	
		Student stu = new Student();
		
		stu.setStuNo("000002");
		stu.setName("ÕÅÈ«µ°");
		stu.setSex(true);
		stu.setBirthDay(new Date(2014,1,1));
		stu.setMajor(1);
		stu.setComment("some comment");
		
		DBHelper.saveStu(stu);
		
	}

}
