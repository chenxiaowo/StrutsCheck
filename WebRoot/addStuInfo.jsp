<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<sx:head parseContent="true" extraLocales="UTF-8" />
    <title>添加学生信息</title>
  </head>
  
  <body>
  	<s:i18n name="messageResource">
  	<h3><s:text name="title"/></h3>
  	
  	<s:form action="addStuInfo.action" method="post">
  		<s:textfield name="stu.stuNo" key="stuNo" ></s:textfield>
  		<s:textfield name="stu.name" key="name" ></s:textfield>
  		<s:radio list="#{1:getText('male'),0:getText('female')}" name="stu.sex" key="sex"></s:radio>
  		<s:textfield name="stu.major" key="major" ></s:textfield>
  		<sx:datetimepicker name="stu.birthDay" key="birthDay" displayFormat="yyyy-MM-dd" language="UTF-8"/>
  		<s:textfield name="stu.comment" key="comment" ></s:textfield>
  		<table>
  			<tr width="100%">
  				<td><s:submit name="submit" value="添加"/></td>
  				<td><s:submit name="reset" value="重置"/></td>
  			</tr>
  		</table>
  	</s:form>
  	
  	</s:i18n>
  	
  </body>
</html>
