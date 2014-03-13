package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.resources.comparators.Date;


public class Query8 extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		String destination = "/query8.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String model = req.getParameter("model");
//		StringBuffer startdatebuffed = new StringBuffer("");
//		startdatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), startdatebuffed, new FieldPosition(0));
//		String startdate = startdatebuffed.toString();
//		StringBuffer enddatebuffed = new StringBuffer("");
//		enddatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), enddatebuffed, new FieldPosition(0));
//		String enddate = enddatebuffed.toString();
		String startdate=req.getParameter("startDate");
		String enddate=req.getParameter("endDate");


		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/Query8.html'>Back</a><br>");
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		if(!(model==null)){
			out.print("<strong>Number of failures for selected model<br>between "+startdate+ " and "+enddate+"</strong>");
			out.print("<br><br>");
			out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
			out.print("<th>Model</th>"); 
			out.print("<th>Failures</th>"); 
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
			//ToDo query
			String quer = "select filtered.TAC as TAC, count(filtered.TAC)";
			quer+="as \"# of failures between X and Y\" from ";
			quer+="(select * from BaseData where baseDate between \'";
			quer+=startdate+"\' and \'"+enddate+"\') as filtered group by TAC;";
			System.out.println(quer);
			rs = stmt.executeQuery(quer);


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
