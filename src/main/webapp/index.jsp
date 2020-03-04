<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container-fluid">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Birth Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUsers}" var="item">
					<tr>
						<td><a href="edit/${item.getFirstName()}">${item.getFirstName()}</a><td>
						<td>${item.lastName}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${item.getBirthDate()}" /></td>
						<td><a class="btn btn-warning">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>