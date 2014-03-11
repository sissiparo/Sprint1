package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Query8 extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		String destination = "/query8.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String model = req.getParameter("model");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/query8.html'>Back</a><br>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		if(!(model==null)){
		out.print("Model="+model);
		out.print("<br><br>");
		out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
		out.print("<th># of failures</th>"); 
		out.print("<th></th>"); 
		}
		else{
			out.print("<font color='red'>Invalid model!</font>");
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

			//rs = stmt.executeQuery("SELECT imsi, eventID, causeCode FROM BaseData b, EventCause e" +
					//" where imsi=" + imsi + " and b.eventCauseID=e.eventcauseCode;");
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
