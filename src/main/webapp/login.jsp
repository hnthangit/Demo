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
		<div class="row">
			<div class="col-md-9 col-lg-8 mx-auto">
				<h3 class="login-heading mb-4">Login page</h3>
				<form method="post" action="login">
					<div class="form-label-group">
						<label>Username</label> <input type="text" name="username" class="form-control required"> <small style="color: red" class="warning"></small>
					</div>

					<div class="form-label-group mb-4">
						<label>Password</label> <input type="password" name="password" class="form-control required"><small style="color: red" class="warning"></small>
					</div>
					<button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Login</button>
					<div class="text-center">
						<p>username: thang</p>
						<p>pass: 123</p>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>