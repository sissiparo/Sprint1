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

public class UserStory7 extends HttpServlet {

	

	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{
		//Date startdate = new Date(); Date endDate =new Date();
		StringBuffer startdatebuffed = new StringBuffer("");
		startdatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), startdatebuffed, new FieldPosition(0));
		String startdate = startdatebuffed.toString();
		StringBuffer enddatebuffed = new StringBuffer("");
		enddatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), enddatebuffed, new FieldPosition(0));
		String enddate = enddatebuffed.toString();
		String destination = "/queries/userStory7.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

		// Takes the date from the form in String and converts it java.util.date which is how the buisness object is written


		startdate=req.getParameter("startDate");

		System.out.println(startdate);



		enddate=req.getParameter("endDate");// = new SimpleDateFormat("yyyy-MM-dd").format(, enddate, new FieldPosition(0));


		// Takes date from java.util.date and converts it to java.sql.date
		// java.sql.Date mySqlDate = new java.sql.Date(startdate.getTime());
		//java.sql.Date mySqlDate1 = new java.sql.Date(endDate.getTime());

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body>"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		out.print(" &nbsp;&nbsp; <a href='/Database4/queries/userStory7.html'>Back</a>"
				+ " &nbsp;&nbsp;<a href='/Database4/test/queriesPage.action'>Main</a> <br><br> ");
		if(!(startdate == null)){
			out.print(" &nbsp;&nbsp;<strong>All IMSIs with call failures<br>&nbsp;&nbsp; between "+startdate+ " and "+enddate+"</strong>");
			out.print("<br><br>");
			out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
			out.print("<th>DATE</th>"); 
			out.print("<th>IMSI</th>"); 
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
			String query = "SELECT BaseDate,imsi FROM BaseData b where baseDate between \"";
			query += startdate+"\" and \""+ enddate+"\" group by imsi order by baseDate";
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

