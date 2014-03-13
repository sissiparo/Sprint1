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
 * Servlet implementation class UniqueFailureCountModel
 */
//@WebServlet("/UniqueFailureCountModel")
public class UniqueFailureCountModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniqueFailureCountModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "/countUniqueFailuresForModel.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);


		String TAC = request.getParameter("txtTAC");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left' >");
		
		out.print("<center><h1>Query results</h1></center>");
		out.print("<br><br>");
		
		if(TAC.length()<12){
			
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
	
				
				// in mySQL: select TAC, eventCauseID,causeDescription, count(*) as 'total' from basedata b, eventCause e where TAC=21060800 and b.eventCauseID=e.eventCauseCode group by b.TAC, b.eventCauseID;
				rs = stmt.executeQuery("SELECT TAC,eventCauseID,causeDescription,count(*) AS 'total' FROM basedata b, eventCause e WHERE TAC=" + TAC + " AND b.eventCauseID=e.eventCauseCode GROUP BY b.TAC, b.eventCauseID;");
				
				if (!rs.next()){
					out.print("<font color='red'> not present in the table.</font>");
				}
				
				else{
					System.out.println("First object returned? "+rs.getObject(1).toString());
					out.print("<br><br>");
					out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
					out.print("<th>TAC</th>"); 
					out.print("<th>EventCauseCode</th>"); 
					out.print("<th>Description</th>");
					out.print("<th>Count</th>"); 
				
					// displaying records
					do{
						System.out.println(rs.getObject(1).toString());
						out.print("<tr>");
						out.print("<td>" + rs.getObject(1).toString() + "</td>");
						out.print("<td>" + rs.getObject(2).toString() + "</td>");
						out.print("<td>" + rs.getObject(3).toString() + "</td>");
						out.print("<td>" + rs.getObject(4).toString() + "</td>");
						out.print("</tr>");
						
					}while(rs.next()!=false);
					
					System.out.println("No more results");
					out.print("</table>");
					out.print("<br><br><br><a href='/Database/countUniqueFailuresForModel.html'>Back</a><br>");
					out.print("<a href='/Database/navigation.html'>   Main</a><br>");
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
			out.print("<font color='red'>Invalid TAC!</font>");
			out.print("<br><br><a href='/Database/countUniqueFailuresForModel.html'>Back   </a><br>");
		}
		out.close();
	}
	
	

}
