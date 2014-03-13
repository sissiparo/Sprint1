package servlet;


import java.io.*;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query11 extends HttpServlet {



	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{
		String destination = "/Query11.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

		// Takes the date from the form in String and converts it java.util.date which is how the buisness object is written


		String startdate=req.getParameter("startDate");

		//System.out.println(startdate);



		String enddate=req.getParameter("endDate");// = new SimpleDateFormat("yyyy-MM-dd").format(, enddate, new FieldPosition(0));


		// Takes date from java.util.date and converts it to java.sql.date
		// java.sql.Date mySqlDate = new java.sql.Date(startdate.getTime());
		//java.sql.Date mySqlDate1 = new java.sql.Date(endDate.getTime());

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/Query11.html'>Back</a><br>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		if(!(startdate == null)){
			out.print("<strong>Top Ten most frequent IMSI/Market/Operator Combinations<br>between "+startdate+ " and "+enddate+":</strong>");
			out.print("<br><br>");
			out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
			out.print("<th>Market</th>"); 
			out.print("<th>Operator</th>"); 
			out.print("<th>Cell ID</th>"); 
			out.print("<th>Count</th>"); 
		}
		else{
			out.print("<font color='red'>Invalid input!</font>");
		}
		// connecting to database
		Connection con = null;  
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Database information
			String database = "testdb";
			String user = "root";
			String password = "jessie01";


			Class.forName("com.mysql.jdbc.Driver");

			con =DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/" + database,user,password);
			stmt = con.createStatement();

			String query = "select `Country`.countryName as Market, `MCCMNC`.`operator` as Operator,"
					+" filteredBD.cellID as \"Cell ID\", count(*) as \"Count\" from" 
					+" `MCCMNC`,"
					+" `Country`,"
					+" (select baseDate, mccmncID, cellID from BaseData"
					+" where baseDate between '"+startdate+"' and '"+enddate+"') as filteredBD"
					+" where filteredBD.`mccmncID`=`MCCMNC`.`mccmncID`"
					+" AND `Country`.`mcc`= `MCCMNC`.`mcc`"
					+" group by Market, Operator, \"Cell ID\""
					+" order by Count DESC"
					+" limit 10;";

			System.out.println(query);
			rs = stmt.executeQuery(query);


			// displaying records
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getObject(1).toString() + "</td>");
				out.print("<td>" + rs.getObject(2).toString() + "</td>");
				out.print("<td>" + rs.getObject(3).toString() + "</td>");
				out.print("<td>" + rs.getObject(4).toString() + "</td>");
				out.print("</tr>");
			}
			out.print("</table></body></html>");
		} catch (SQLException e) {
			throw new ServletException("Servlet Could not display records.", e);
		} catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found.", e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {}
		}
		out.close();
	}
}
