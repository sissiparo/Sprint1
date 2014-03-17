package servlet;

import java.io.*;
import java.util.*;

import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserStory4 extends HttpServlet {
	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{

		String destination = "/queries/userStory4.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String imsi = req.getParameter("IMSI");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body>");
		out.print("</div>"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		out.print("&nbsp;&nbsp; <a href='/Database4/queries/userStory4.html'>Back</a><br><br><br>");
		if(imsi.length()==15){
		out.print(" &nbsp;&nbsp;IMSI="+imsi);
		out.print("<br><br>");
		out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
		out.print("<th>Event ID</th>"); 
		out.print("<th>Cause Code</th>"); 
		}
		else{
			out.print("<font color='red'>Invalid IMSI!</font>");
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

			rs = stmt.executeQuery("SELECT imsi, eventID, causeCode FROM BaseData b, EventCause e" +
					" where imsi=" + imsi + " and b.eventCauseID=e.eventcauseCode;");
			//
			
			//
			// displaying records
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getObject(2).toString() + "</td>");
				out.print("<td>" + rs.getObject(3).toString() + "</td>");
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
