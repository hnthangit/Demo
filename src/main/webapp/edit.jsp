<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<form method="post">
			<input type="hidden" name="username" value="${ user.getUsername() }">
			<div class="form-group">
				<label>First Name *</label> <input type="text" class="form-control required string" value="${ user.getFirstName() }" name="firstname"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>Last Name *</label> <input type="text" class="form-control required string" value="${ user.getLastName() }" name="lastname"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<fmt:formatDate var="fmtDate" pattern="yyyy-MM-dd" value="${user.getBirthDate()}" />
				<label>Birth Date</label> <input type="text" class="form-control date" value="${fmtDate }" name="birthdate"> <small style="color: red" class="datewarning"></small>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea class="form-control" rows="3" name="description">${ user.getDescription() }</textarea>
			</div>
			<button type="submit" class="btn btn-primary submit">Save</button>
			<a href="edit?username=${ user.getUsername() }" type="submit" class="btn btn-warning">Reset</a>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>