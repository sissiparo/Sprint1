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

public class FailureCauseQuery extends HttpServlet {
	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{

		String destination = "/failureCauseQuery.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String failureClass = req.getParameter("FailureClassID");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/query.html'>Back</a><br>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		out.print("Failure Class = " + failureClass);
		out.print("<br><br>");
		out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
		out.print("<th>IMSI</th>"); 
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

			rs = stmt.executeQuery("select imsi from basedata where failureClassID = "+ Integer.parseInt(failureClass)+" group by imsi;");

			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getObject(1).toString() + "</td>");
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
