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
  	<h1>添加学生信息</h1>
  	<s:form action="addStuInfo.action" method="post">
  		<s:textfield name="stu.stuNo" label="学号" ></s:textfield>
  		<s:textfield name="stu.name" label="姓名" ></s:textfield>
  		<s:radio list="#{1:'男',0:'女'}" name="stu.sex" label="性别"></s:radio>
  		<s:textfield name="stu.major" label="专业" ></s:textfield>
  		<sx:datetimepicker name="stu.birthDay" label="出生日期" displayFormat="yyyy-MM-dd" language="UTF-8"/>
  		<s:textfield name="stu.comment" label="备注" ></s:textfield>
  		<table>
  			<tr width="100%">
  				<td><s:submit name="submit" value="添加"/></td>
  				<td><s:submit name="reset" value="重置"/></td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>
