package org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
		
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();
        ArrayList<Student> stus = (ArrayList<Student>)session.get("stus");
        if(stus==null)
        {
        	stus = new ArrayList<Student>();
        }
        stus.add(stu);
        session.put("stus",stus);  
		return SUCCESS;
	}
	
	
}
