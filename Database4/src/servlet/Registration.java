package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import persistence.PersistenceUtil;
import persistence.PersistenceUtil.*;


public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		
		
		String destination = "/queries/registration.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		
		String userName = request.getParameter("txtUserName");
		String userPassword = request.getParameter("txtPassword");
		String employeeNumber = request.getParameter("txtEmployeeNumber");
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		String userType=request.getParameter("txtUserType");
		
		// set up page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<body");
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/queries/registration.html'>Back</a><br>");
		
	

			
			// validation
			//check if userName already exists
			if(PersistenceUtil.findUserName(userName)!=null){
				out.print("<font color='red'>The user name: "+userName+" already exists, please choose a different user name</font>");
			}else if(doesNotContainInvalidCharacters(userName)){
				out.print("<font color='red'>User Name contains punctuation, please choose a different user name</font>");
			}else if(userName.length()<4){
				out.print("<font color='red'>User Name is too short, please choose a user name greater than 4 characters in length</font>");
			}else{
				// maybe make this a form and have a confirm button
				User user=new User(userName, userPassword, employeeNumber, firstName, lastName,userType);
				saveUserDetails(user);
		
				out.print("<center><h1>User Saved:</h1></center>");
				out.print("<br><br>");
				out.print("<br><br>");
				out.print("<html><body><table align='center' border=\"1\" cellspacing=10 cellpadding=5>");
				out.print("<th>Field</th>"); 
				out.print("<th>User Input</th>");
				out.print("<tr><td>User Name</td><td>"+userName+"</td></tr>");
				out.print("<tr><td>Password</td><td>"+userPassword+"</td></tr>");
				out.print("<tr><td>Employee Number</td><td>"+employeeNumber+"</td></tr>");
				out.print("<tr><td>First Name</td><td>"+firstName+"</td></tr>");
				out.print("<tr><td>Last Name</td><td>"+lastName+"</td></tr>");
				out.print("<tr><td>User Type</td><td>"+userType+"</td></tr>");
				out.print("</table></body></html>");
				
			}
			out.close();
	}
			/*
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
	
				
				
				
			//TODO this should be done in persistence
			rs = stmt.executeQuery("SELECT imsi, eventID, causeCode FROM BaseData b, EventCause e" +
					" where imsi=" + imsi + " and b.eventCauseID=e.eventcauseCode;");
			
			// displaying records
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getObject(2).toString() + "</td>");
				out.print("<td>" + rs.getObject(3).toString() + "</td>");
				out.print("</tr>");
			}
			
		} 
		
		catch (SQLException e) {
			throw new ServletException("Servlet Could not display records.", e);
		}
		
		catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found.", e);
		} 
		
		
		//close everything
		finally {
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
			}
			
			catch (SQLException e) {}
	*/	
	private void saveUserDetails(User user) {
		PersistenceUtil.persist(user);
		
	}

	private boolean doesNotContainInvalidCharacters(String word) {
		for(int i=0; i<word.length();i++){
			if(!Character.isLetterOrDigit(word.charAt(i))){
				return true;
			}
		}
		return false;
	}


}
