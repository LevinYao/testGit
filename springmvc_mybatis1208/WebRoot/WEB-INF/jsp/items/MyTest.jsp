<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body> 

<form id="userForm" action="${pageContext.request.contextPath }/user/editUserSubmit.action" method="post" >
<input type="hidden" name="id" value="${userCustom.id }"/>
修改用户信息：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td><input type="text" name="username" value="${userCustom.username }"/></td>
</tr>
<tr>
	<td>性别</td>
	<td><input type="text" name="sex" value="${userCustom.sex }"/></td>
</tr>
<tr>
	<td>生日</td>
	<td><input type="text" name="birthday" value="${userCustom.birthday}"/></td>
</tr>
<%-- <tr>
	<td>商品图片</td>
	<td>
		<c:if test="${item.pic !=null}">
			<img src="/pic/${item.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="pictureFile"/> 
	</td>
</tr> --%>
<tr>
	<td>地址</td>
	<td>
	<textarea rows="3" cols="30" name="address">${userCustom.address }</textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>
