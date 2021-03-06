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

public class UserStory11 extends HttpServlet {



	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{
		String destination = "/queries/userStory11.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String startdate=req.getParameter("startDate");
		String enddate=req.getParameter("endDate");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body>");
		out.print("<br><div style='text-align: left'>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		out.print("&nbsp;&nbsp;<a href='/Database/queries/userStory11.html'>Back</a>"
				+ " &nbsp;&nbsp;<a href='/Database/test/queriesPage.action'>Main</a> <br><br> ");

		if(!(startdate == null)){
			out.print("<strong>&nbsp;&nbsp;Top Ten most frequent IMSI/Market/Operator Combinations<br>&nbsp;&nbsp;between "+startdate+ " and "+enddate+":</strong>");
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
			String password = "toor";


			Class.forName("com.mysql.jdbc.Driver");

			con =DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/" + database,user,password);
			stmt = con.createStatement();

			/*String query = "select `Country`.countryName as Market, `MCCMNC`.`operator` as Operator,"
					+" filteredBD.cellID as \"Cell ID\", count(*) as \"Count\" from" 
					+" `MCCMNC`,"
					+" `Country`,"
					+" (select baseDate, mccmncID, cellID from BaseData"
					+" where baseDate between '"+startdate+"' and '"+enddate+"') as filteredBD"
					+" where filteredBD.`mccmncID`=`MCCMNC`.`mccmncID`"
					+" AND `Country`.`mcc`= `MCCMNC`.`mcc`"
					+" group by Market, Operator, \"Cell ID\""
					+" order by Count DESC"
					+" limit 10;";*/



			String query = "select `Country`.countryName as Market, `MCCMNC`.`operator` as Operator,"
					+ "tiny.cellID as CellID, tiny.Count as Count"
					+" from"
					+" `MCCMNC`,"
					+" `Country`,"
					+"(select baseDate, MCCMNCID, cellID, count(*) as Count from BaseData"
					+" where baseDate between '"+startdate+"' and '"+enddate+"'"
					+" group by IMSI, MCCMNCID, cellID) tiny"
					+" where tiny.MCCMNCID=`MCCMNC`.`mccmncID`"
					+" AND `Country`.`mcc`= `MCCMNC`.`mcc`"
					+" order by Count DESC"
					+" limit 10;";

					System.out.println(query);
			rs = stmt.executeQuery(query);


			// displaying records
			if (rs.next()){
				do {
					out.print("<tr>");
					out.print("<td>" + rs.getObject(1).toString() + "</td>");
					out.print("<td>" + rs.getObject(2).toString() + "</td>");
					out.print("<td>" + rs.getObject(3).toString() + "</td>");
					out.print("<td>" + rs.getObject(4).toString() + "</td>");
					out.print("</tr>");
				}while(rs.next());
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

