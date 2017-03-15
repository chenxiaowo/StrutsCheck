<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
</head>
<body>

	
	<h1>学生信息</h1>
	
	
   <s:iterator value="#session.stus" id="resultobject" status="status">  
   <table border="2" width="400px">  
       <tr>
       <td>学号：</td>
       <td> <s:property value="#resultobject.stuNo"/></td>
       </tr>         
       <tr>
       <td>姓名：</td>
       <td> <s:property value="#resultobject.name"/></td>
       </tr>         
       <tr>
       <td>性别：</td>
       <td> <s:property value="#resultobject.sex"/></td>
       </tr>         
       <tr>
       <td>专业：</td>
       <td> <s:property value="#resultobject.major"/></td>
       </tr>         
       <tr>
       <td>生日：</td>
       <td> <s:property value="#resultobject.birthDay"/></td>
       </tr>    
       <tr>
       <td>备注：</td>
       <td> <s:property value="#resultobject.comment"/></td>
       </tr>                
      	<tr></tr>
      	</table>
      		<hr/>
   </s:iterator>
	<button   type=button   onclick="javascript:window.open('addStuInfo.jsp');">继续添加</button>
</body>
</html>
