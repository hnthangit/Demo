<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<c:if test="${user !=null}">
			<p style="color: red">Password must equal repassword
			<p>
		</c:if>
		<form method="post">
			<div class="form-group">
				<label>Username *</label> <input type="text" class="form-control required" value="${ user.getFirstName() }" name="username"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>Password *</label> <input type="text" class="form-control required" name="password"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>Repassword *</label> <input type="text" class="form-control required" name="repassword"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>First Name *</label> <input type="text" class="form-control required string" value="${ user.getFirstName() }" name="firstname"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>Last Name *</label> <input type="text" class="form-control required string" value="${ user.getLastName() }" name="lastname"><small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<fmt:formatDate var="fmtDate" pattern="yyyy-MM-dd" value="${user.getBirthDate()}" />
				<label>Birth Date</label> <input type="text" class="form-control date" value="${fmtDate }" name="birthdate"><small style="color: red" class="datewarning"></small>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea class="form-control" rows="3" name="description">${ user.getDescription() }</textarea>
			</div>
			<button type="submit" id="submit" class="btn btn-primary submit">Add</button>
			<a href="add" type="submit" class="btn btn-warning">Reset</a>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>