package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Driver;
 
public class Login extends HttpServlet  
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	String destination = "/navigation.html";
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
 
        String user=req.getParameter("userName");
        String pass=req.getParameter("userPassword");
 
        if(user.equals("admin")&&pass.equals("admin")) {
        		rd.forward(req, res);
        		}
                else
                 pw.println("Login Failed...!");
         pw.close();
 
    }
 
}

