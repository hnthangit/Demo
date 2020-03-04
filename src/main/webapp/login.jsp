<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<form method="post" action="login">
			<div class="form-group">
				<label>Username</label> <input type="text" name="username" class="form-control required"> <small style="color: red" class="warning"></small>
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name="password" class="form-control required"><small style="color: red" class="warning"></small>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<p>username: thang</p>
		<p>pass: 123</p>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>