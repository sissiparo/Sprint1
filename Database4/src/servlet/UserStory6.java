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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UniqueCauseCodes
 */
//@WebServlet("/UniqueCauseCodesQuery")
public class UserStory6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,
			HttpServletResponse res)
					throws IOException, ServletException{

		String destination = "/queries/userStory6.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String imsi = req.getParameter("IMSI");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<body>");
		out.print("<br><div style='text-align: left' >");

		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		if(imsi.length()==15){
			out.print("<br><br><br><a href='/Database/queries/userStory6.html'>Back</a>&nbsp&nbsp");
			out.print("IMSI="+imsi);


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

				rs = stmt.executeQuery("SELECT imsi, eventCauseID, eventCauseCode,causeCode, causeDescription FROM BaseData b, EventCause e" +
						" where imsi=" + imsi + " and b.eventCauseID=e.eventcauseCode GROUP BY e.causeCode;");



				if (!rs.next()){
					out.print("<font color='red'> not present in the table.</font>");
					out.print("<br><br><a href='/Database/queries/userStory6.html'>Back</a><br>");
				}
				//
				else{
					out.print("<br><br>");
					out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
					out.print("<th>EventCauseCode</th>"); 
					out.print("<th>Cause Code</th>"); 
					out.print("<th>Description</th>");

					// displaying records
					do{

						out.print("<tr>");
						out.print("<td>" + rs.getObject(3).toString() + "</td>");
						out.print("<td>" + rs.getObject(4).toString() + "</td>");
						out.print("<td>" + rs.getObject(5).toString() + "</td>");
						out.print("</tr>");

					}while(rs.next()!=false);

					out.print("</table>");

					out.print("</body></html>");
				}
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
			out.print("<font color='red'>Invalid IMSI!</font>");
			out.print("<br><br><a href='/Database/queries/userStory6.html'>Back</a><br>");
		}
		out.close();
	}

}
