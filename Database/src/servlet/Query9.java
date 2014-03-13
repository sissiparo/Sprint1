package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Query9
 */
//@WebServlet("/Query9")
public class Query9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{

		StringBuffer startdatebuffed = new StringBuffer("");
		startdatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), startdatebuffed, new FieldPosition(0));
		String startdate = startdatebuffed.toString();
		StringBuffer enddatebuffed = new StringBuffer("");
		enddatebuffed = new SimpleDateFormat("yyyy-MM-dd").format(new Date(), enddatebuffed, new FieldPosition(0));
		String enddate = enddatebuffed.toString();
		String destination = "/Query9.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

		// Takes the date from the form in String and converts it java.util.date which is how the business object is written


		startdate=req.getParameter("startDate");
		enddate=req.getParameter("endDate");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		if (enddate==""){
			enddate=dateFormat.format(date);
		}


		// Takes date from java.util.date and converts it to java.sql.date
		// java.sql.Date mySqlDate = new java.sql.Date(startdate.getTime());
		//java.sql.Date mySqlDate1 = new java.sql.Date(endDate.getTime());

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");

		out.print("<center><h1>Query results</h1></center>");


		out.print("<br><br>");
		out.print("<html>");
		out.print("<body>");

		if(!(startdate == "")){
	
			out.print("<br><br><a href='/Database/Query9.html'>Back</a> &nbsp &nbsp   ");
			out.print("<a href='/Database/navigation.html'>Main</a><br><br><br>");
			out.print("From <strong>"+startdate+ "</strong> to <strong>"+enddate+"</strong>");



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
				String query="SELECT imsi,count(imsi) as Occurrences,sum(duration) as TotalDuration from BaseData b where BaseDate between \""+startdate+"\" and \""+ enddate +"\" group by imsi";
				rs = stmt.executeQuery(query);
				if(!rs.next()){
					out.print("<br>There are no failures during the given time period.");
				}
				else{
					// displaying records

					out.print("<table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
					out.print("<br><tr>");
					out.print("<th>IMSI</th>"); 
					out.print("<th># Of Call Failures</th>");
					out.print("<th> TotalDuration</th><tbody>");
					do{
						out.print("<tr>");
						out.print("<td align=\"center\">" + rs.getObject(1).toString() + "</td>");
						out.print("<td align=\"center\">" + rs.getObject(2).toString() + "</td>");
						out.print("<td align=\"center\">" + rs.getObject(3).toString() + "</td>");
						out.print("</tr>");					
					}while(rs.next());
				}
				out.print("</table><br><br><br>");
				out.print("</body></html>");
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
		}
		else{
			out.print("<font color='red'>Invalid input!</font>");
			out.print("<br><a href='/Database/Query9.html'>Back</a><br>");
		}
		out.close();
	}
}
