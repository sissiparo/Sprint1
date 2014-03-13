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
		
		
		String destination = "/registration.html";
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
		
		out.print("<body background='images/light.jpg' >");
		out.print("</div>");
		out.print("<img alt='header' src='images/logo.gif' id='header' width=100%  />"); 
		out.print("<br><div style='text-align: left'>");
		out.print("<a href='/Database/registration.html'>Back</a><br>");
		
	

			
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
