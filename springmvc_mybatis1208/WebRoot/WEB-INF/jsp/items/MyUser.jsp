<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户测试</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/user/queryUser.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>

<tr>
	<td>
		<a href="${pageContext.request.contextPath }/user/addUser.action?id=${user.id}">新增</a>
	</td>
</tr>
</table>
用户列表：
<table width="100%" border=1>
<tr>
	<td>姓名</td>
	<td>性别</td>
	<td>生日</td>
	<td>描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${userList }" var="user">
<tr>
	<td>${user.username }</td>
	<td>${user.sex }</td>
	<td>${user.birthday}"</td>
	<td>${user.address }</td>
	
	<td><a href="${pageContext.request.contextPath }/user/editUser.action?id=${user.id}">修改</a>
	/<a href="${pageContext.request.contextPath }/user/deleteUser.action?id=${user.id}">删除</a>
	</td>
</tr>
</c:forEach>

</table>
</form>
</body>

</html>