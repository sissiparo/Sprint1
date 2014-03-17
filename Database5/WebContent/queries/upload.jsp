<!-- Group5- Ger Hennessy, Ian Murray, Paula Suciu, Muireann Walsh, Ronan Monahan, Fergal Byrne -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>File Upload</title>
</head>

<body>

	<table border="1" align="center" width=100%>
		<tr ALIGN="CENTER">
			<td>
				<center>
					<img alt="header" src="../images/logo.gif" id="header" width=80%
						height=150px />
				</center>
			</td>
		</tr>
		<tr ALIGN="CENTER">
			<td height=570px>
				<h1>File Upload Form</h1>
				<hr />

				<fieldset>
					<legend>Upload File</legend>
					<form action="Upload" method="post" enctype="multipart/form-data">
						<label for="filename_1">File: </label> <input id="filename_1"
							type="file" name="filename_1" size="50" /><br /> <br /> <input
							type="submit" value="Upload File" />
					</form>
				</fieldset> <br>
				<div style="text-align: left">
					<a href="/Database/test/queriesPage.action">Back</a>
					<form action="/Database/LogoutServlet" method="post">
						<input type="submit" value="Logout">
					</form>
				</div>
			</td>
		</tr>
		<tr ALIGN="CENTER">
			<td height=40px>
				<div align="center">Group5- Ger Hennessy, Ian Murray, Paula
					Suciu, Muireann Walsh, Ronan Monahan, Fergal Byrne</div>
			</td>
		</tr>
	</table>



</body>
</html>


