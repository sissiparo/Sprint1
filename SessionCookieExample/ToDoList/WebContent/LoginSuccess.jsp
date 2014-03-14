<%@page import="persistence.PersistenceUtil"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>

<body>
	<%
		String userName = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
			}
		}
		int id = PersistenceUtil.findUserByUsername(userName).getId();
		if (userName == null)
			response.sendRedirect("login.html");
	%>

	<h1>
		<%=userName%>'s To-Do List
	</h1>
	<UL>
		<%
			for (int i = 0; i < (PersistenceUtil.findAllTasks(id)).size(); i++) {
				out.println("<LI>"
						+ (PersistenceUtil.findAllTasks(id)).get(i)
								.getTaskname());
			}
		%>
	</UL>
	<br>


	<br>

	<form action="TaskServlet" method="post">
		<label>Task:</label> <input type="text" name="taskname" /> <input
			type="submit" value="Add Task">

	</form>

	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>

	<form name="deleteForm" action="DeleteTask" method="post">
		<label>Task to Delete:</label> <input type="text" name="taskname" />
		<input type="submit" value="Delete Task">
	</form>

	<form action="DeleteUser" method="post">
		<label>Task to Delete:</label> <input type="submit"
			value="Delete Account">
	</form>

</body>
</html>