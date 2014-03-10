package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Driver;
 
public class Login extends HttpServlet  
{
    protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
    {
    	String destination = "/navigation.html";
        PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
 
        String user=request.getParameter("userName");
        String pass=request.getParameter("userPassword");
 
        if(user.equals("admin")&&pass.equals("admin")) {
          	Cookie loginCookie = new Cookie("user", user);
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			RequestDispatcher rdi = getServletContext().getRequestDispatcher(destination);
			rdi.include(request, response);

		} else {
			PrintWriter out = response.getWriter();
			out.println("<html><body><script>alert('User does not exist!');</script></body></html>");
			RequestDispatcher rdir = getServletContext().getRequestDispatcher("/index.html");
			rdir.include(request, response);
		}
         pw.close();
 
    }
 
}

