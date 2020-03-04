<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container-fluid">
		<form>
			<div class="form-group">
				<label>Username</label> <input type="text" class="form-control"> <small id="emailHelp" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" class="form-control" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>