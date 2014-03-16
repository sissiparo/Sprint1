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

public class UserStory12 extends HttpServlet {



	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{

		String destination = "/queries/userStory12.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String startdate=req.getParameter("startDate");

		System.out.println(startdate);



		String enddate=req.getParameter("endDate");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body>"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/queries/userStory12.html'>Back</a><br>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		if(!(startdate == null)){
			out.print("<strong>The Top Ten IMSIs that had call failures<br>between "+startdate+ " and "+enddate+"</strong>");
			out.print("<br><br>");
			out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
			out.print("<th>IMSI</th>"); 
			out.print("<th>COUNT</th>"); 
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
			String query = "select imsi, count(imsi) as 'count' from"
					+" (select imsi from BaseData where baseDate between '"+startdate+"' and '"+enddate+"' )"
					+" AS selection"
					+" group by imsi order by count DESC limit 10;";
			System.out.println(query);
			rs = stmt.executeQuery(query);


			// displaying records
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getObject(1).toString() + "</td>");
				out.print("<td>" + rs.getObject(2).toString() + "</td>");
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

