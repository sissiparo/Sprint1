<!-- Group6- Ger Hennessy, Ian Murray, Paula Suciu, Muireann Walsh, Ronan Monahan, Fregal Byrne -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="../pageStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<table border="1" align="center" width=100% background="map.png">
		<tr>
			<td height=150px colspan="2"><tiles:insertAttribute
					name="header" /></td>
		</tr>
		<tr>
			<td height=570px><tiles:insertAttribute name="menu" /></td>
			<td width=80%><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td height=40px colspan="2"><tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>
</body>
</html>
