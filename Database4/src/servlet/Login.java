package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.PersistenceUtil;
import entity.User;
import main.Driver;
 
public class Login extends HttpServlet  
{
    protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
    {
    	String destination = "/pages/link.jsp";
        PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
 
        String user=request.getParameter("userName");
        String pass=request.getParameter("userPassword");
        
        List<User> rs = PersistenceUtil.findAllUsers();
		
			if(Validate.checkUser(user, pass).equals("System Administrator")){
				    Cookie loginCookie = new Cookie("SysAdmin", user);
				    loginCookie.setMaxAge(30 * 60);
				    response.addCookie(loginCookie);
					RequestDispatcher rdi = getServletContext().getRequestDispatcher(destination);
					rdi.include(request, response);
			}
			else if(Validate.checkUser(user, pass).equals("Network Management Engineer")){
			    Cookie loginCookie = new Cookie("NetMan", user);
			    loginCookie.setMaxAge(30 * 60);
			    response.addCookie(loginCookie);
				RequestDispatcher rdi = getServletContext().getRequestDispatcher(destination);
				rdi.include(request, response);
			}
			else if(Validate.checkUser(user, pass).equals("Support Engineer")){
			    Cookie loginCookie = new Cookie("SupEng", user);
			    loginCookie.setMaxAge(30 * 60);
			    response.addCookie(loginCookie);
				RequestDispatcher rdi = getServletContext().getRequestDispatcher(destination);
				rdi.include(request, response);
			}
			else if(Validate.checkUser(user, pass).equals("Customer Service Rep")){
			    Cookie loginCookie = new Cookie("CustRep", user);
			    loginCookie.setMaxAge(30 * 60);
			    response.addCookie(loginCookie);
				RequestDispatcher rdi = getServletContext().getRequestDispatcher(destination);
				rdi.include(request, response);
			}
			
			else {
				PrintWriter out = response.getWriter();
				out.println("<html><body><script>alert('User does not exist!');</script></body></html>");
				RequestDispatcher rdir = getServletContext().getRequestDispatcher("/index.html");
				rdir.include(request, response);
			}
			
			pw.close();
			for(Cookie c : request.getCookies()) {
				System.out.println(c.getName());
	        }
 
    }
 
}

