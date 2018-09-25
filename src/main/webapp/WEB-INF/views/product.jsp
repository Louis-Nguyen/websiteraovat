<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="getall">Get All Product</a>
		<hr />
		<form action="login" method="post">
			<input type="text" name="account" placeholder="Email">
			<input type="password" name="password" placeholder="Password">
			<input type="submit" value="Login"> 
		</form>
		<hr /> 
		<form action="insert" method="post">
			<input type="text" name="name" placeholder="Họ và tên">
			<input type="text" name="account" placeholder="Email">
			<input type="password" name="password" placeholder="Password">
			<input type="text" name="phanquyen" placeholder="Phân quyền">
			<input type="submit" value="Insert User"> 
		</form>
		<hr /> 
		<form action="" method="get">
			<input type="text" name="account" placeholder="Email">
			<input type="submit" value="Search User"> 
		</form>
		<hr /> 
</body>
</html>