<!-- Group5- Ger Hennessy, Ian Murray, Paula Suciu, Muireann Walsh, Ronan Monahan, Fregal Byrne -->
<%@taglib uri="/struts-tags" prefix="s"%>
<body>
<table bgcolor="#00b7ea">
	<tr>
		<td height=190px>
			<div class="menuButton">
	      		<span class="main blue"><a href="<s:url action='homePage'/>">Ericsson</a></span>
			</div>
		</td>
	</tr>
	<tr>
		<td height=190px>
			<div class="menuButton">
	      		<span class="main blue"><a href="queriesPage.action">Queries</a></span>
			</div>
		</td>
	</tr>
	<tr>
		<td height=180px>
			<form action="/Database/LogoutServlet" method="post">
				<center><input type="submit" value="LOGOUT" id="submit" style="background-color:#00b7ea; color:#fff; border-style:none; font: bold 15px/50px Arial;" /></center>
			</form>
		</td>
	</tr>
</table>

	
</body>