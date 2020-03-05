<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<a class="btn btn-secondary float-right my-3" href="add">Add</a>
		<table class="table table-striped">
			<thead>
				<tr class="table-success">
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Birth Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUsers}" var="item">
					<tr>
						<td><a href="edit?username=${item.getUsername()}">${item.getFirstName()}</a></td>
						<td>${item.getLastName()}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.getBirthDate()}" /></td>
						<td><a href="delete?username=${item.getUsername()}" class="btn btn-outline-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>