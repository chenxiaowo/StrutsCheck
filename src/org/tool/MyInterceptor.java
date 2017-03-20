package org.tool;

import org.action.StuAddAction;
import org.apache.struts2.impl.StrutsActionProxy;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		StuAddAction action = (StuAddAction) arg0.getAction();
		if(action.getStu().getName().equals("test"))
		{
			return action.ERROR;
		}
		return arg0.invoke();
	}

}
