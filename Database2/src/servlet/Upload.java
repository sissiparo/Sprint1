package servlet;

import main.Driver;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;
 
public class Upload extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
 
        String destination = "/up_success.html";
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
        
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
 
            try {
                List items = upload.parseRequest(req);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
 
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        if (fileName != null) {
                            fileName = FilenameUtils.getName(fileName);
                        }
 
                        

                        File path = new File("C:/Users/Mobile/Desktop/Workspace/WS1/Database");

                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
 
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                        Driver d = new Driver();
                    }
                    rd.forward(req, res);
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
