<!Doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<html>
<body background="images/light.jpg" >
<img alt="header" src="images/logo.gif" id="header" width=100%  /> 
<form action="Query8" method="post">
<head>
<script language="javascript" type="text/javascript" src="datetimepicker.js">

</script>
</head>
<%
    try{
    	String database = "testdb";
		String user = "root";
		String password = "jessie01";

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection 
				("jdbc:mysql://localhost:3306/" + database,user,password);
		Statement statement = connection.createStatement();
        resultset = statement.executeQuery("select TAC FROM BaseData group by TAC order by TAC") ;
%>

<center>
    <h3> Select TAC</h3>
        <select name="model" id="model">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select>
</center>

<%

        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

<p>Please enter dates to view selected model failures<p>
<table width="700" cellspacing=0 border="0" cellpadding="0" align="center" summary="">
	  <tr>
	  	<td>
	  		<div class="subtitle">Start Date</div>	
	  	
	  	</td>
	  </tr>
	  <tr>
	  	<td>
	  		<input type="Text" value="2013-11-01" name="startDate" id="startDate" maxlength="25" size="25"><a href="javascript:NewCal('startDate','ddmmmyyyy',true,24)"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<span class="descriptions"> Select date    </span>
	  	</td>
	  </tr>
	  <br>
	  <tr>
	  	<td>
	  		<div class="subtitle">End Date</div>	
	  	
	  	</td>
	  </tr>
	  
	 
	  <tr>
	  	<td>
	  		<input type="Text" value="2013-11-02" name="endDate" id="endDate" maxlength="25" size="25"><a href="javascript:NewCal('endDate','ddmmmyyyy',true,24)"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<span class="descriptions"> Select date..</span>
	  	</td>
	  </tr>
	  
       
</table>
   <div style="text-align: center">
      <input type="submit" value="Submit" align="center">
   </div>
   <br>
   
   		
</form>
<div style="text-align: left">
			<a href="/Database/navigation.html">Back</a>
			<form action="/Database/LogoutServlet" method="post">
			<input type="submit" value="Logout">
		</form>
		</div>

</body>
</html>
