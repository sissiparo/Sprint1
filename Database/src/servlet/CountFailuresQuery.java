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
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CountFailuresQuery extends HttpServlet {
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
		String destination = "/countFailuresQuery.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

		// Takes the date from the form in String and converts it java.util.date which is how the business object is written

		String imsi = req.getParameter("IMSI");
		startdate=req.getParameter("startDate");
		enddate=req.getParameter("endDate");


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
		
		if(imsi.length()==15){
			out.print("<br><br>");
			if(!(startdate == null)){

				out.print("<br><br>");
				out.print("<html> <body>");
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
				String query="SELECT count(*) from BaseData b where BaseDate between \""+startdate+"\" and \""+ enddate +"\" and imsi="+ imsi;
				rs = stmt.executeQuery(query);


				// displaying records
				while(rs.next()){
					if (rs.getObject(1).toString().equals("0")){
						out.print("There are no failures for the IMSI: "+imsi+" during the given time period.");
					}
					else{
						out.print("From <strong>"+startdate+ "</strong> to <strong>"+enddate+"</strong> there were ");
						out.print("<strong>"+rs.getObject(1).toString()+"</strong> failures for the given IMSI: <strong>"+ imsi+"</strong>.");
					}
				}
				out.print("<br><br><br>");
				out.print("<a href='/Database/countFailuresQuery.html'>Back   </a><br>");
				out.print("<a href='/Database/navigation.html'>   Main</a><br>");
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
		}else{
			out.print("<font color='red'>Invalid IMSI!</font>");
			out.print("<br><br><a href='/Database/countFailuresQuery.html'>Back   </a><br>");
		}
		out.close();
	}

}
