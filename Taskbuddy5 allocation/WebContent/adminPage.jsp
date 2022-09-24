<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page import="com.taskbuddy.entities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello,${username }
	
	<a href="${pageContext.request.contextPath}/dream/add">add new Tasker</a>
<br>
<table border="1" cellpadding="2" cellspacing="2">
<thead>
<tr>

<th>username</th>
<th>email</th>
<th>password</th>
<th>role</th>

</tr>
</thead>
<c:forEach var="pb" items="${listTasker}">


<tr>

<td>${pb.username}</td>
<td>${pb.email }</td>
<td>${pb.password }</td>
<td>${pb.role}</td>
<td>
<a href="${pageContext.request.contextPath}/dream/delete/${loginid}" onclick="return confirm('Are you Sure.?')">Delete</a>
<a href="${pageContext.request.contextPath}/dream/update/${loginid}" onclick="return confirm('Are you Sure.?')">Update</a>
</td>

</tr>

</c:forEach>

</table>
	
	
	</table>

<table border="1" cellpadding="2" cellspacing="2">
<thead>
<tr>

<th>userfirst</th>
<th>userlastname</th>
<th>gender</th>
<th>contactno</th>
<th>address</th>
<th>location</th>
<th>city</th>
<th>state</th>
<th>country</th>


</tr>
</thead>
<c:forEach var="uf" items="${userinfo}">


<tr>

<td>${uf.userfirstname}</td>
<td>${uf.userlastname }</td>
<td>${uf.gender }</td>
<td>${uf.contactno}</td>
<td>${uf.address}</td>
<td>${uf.location}</td>
<td>${uf.pincode}</td>
<td>${uf.city}</td>
<td>${uf.state}</td>
<td>${uf.country}</td>
<td>
<a href="${pageContext.request.contextPath}/dream/delete/${loginid}" onclick="return confirm('Are you Sure.?')">Delete</a>
<a href="${pageContext.request.contextPath}/dream/update/${loginid}" onclick="return confirm('Are you Sure.?')">Update</a>
</td>

</tr>

</c:forEach>

</table>

<table border="1" cellpadding="2" cellspacing="2">
<thead>
<tr>

<th>OperationId</th>
<th>LoginId</th>
<th>TaskerId</th>
<th>Review</th>
<th>rating</th>
<th>date</th>
<th>address</th>



</tr>
</thead>
<c:forEach var="op" items="${operation}">


<tr>

<td>${ op.opid }</td>
<td>${ op.logininfo.loginid }</td>
<td>${ op.taskerinfo.taskerid }</td>
<td>${ op.reveiw }</td>
<td>${ op.rating }</td>
<td>${ op.date }</td>
<td>${ op.address }</td>



</tr>

</c:forEach>

</table>
	
</body>
</html>