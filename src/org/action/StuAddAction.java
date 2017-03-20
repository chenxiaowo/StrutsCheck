package org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.database.DBHelper;
import org.model.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StuAddAction extends ActionSupport {
	
	
	
	private Student stu;

	public Student getStu() {
		return stu;
	}


	public void setStu(Student stu) {
		this.stu = stu;
	}

	

	@Override
	public String execute() throws Exception {
		System.out.println(stu.getStuNo());
		System.out.println(stu.getName());
		System.out.println(stu.getSex());
		System.out.println(stu.getBirthDay());
		System.out.println(stu.getMajor());
		System.out.println(stu.getComment());
		
		DBHelper.saveStu(stu);
		ArrayList<Student> stus = DBHelper.getStuInfo();
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();
        session.put("stus",stus);  
		return SUCCESS;
	}
	
	
}
