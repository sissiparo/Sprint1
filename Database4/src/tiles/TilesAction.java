package tiles;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class TilesAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{

	
	public String home() {
		return "home";
	}
	
	public String queries() {
		String q = null;
		System.out.println("------------------");
		for(Cookie c : servletRequest.getCookies()) {
			System.out.println(c.getName());
		      if (c.getName().equals("SysAdmin")){
		    	  q = "queries";
		    	  break;
		      }
		      else if (c.getName().equals("NetMan")){
		    	  q = "queries2";
		    	  break;
		      }
		      else if (c.getName().equals("SupEng")){
		    	  q = "queries3";
		    	  break;
		      }
		      else if (c.getName().equals("CustRep")){
		    	  q = "queries4";
		    	  break;
		      }
		    }
		return q;
	}
	
	protected HttpServletResponse servletResponse;
	  @Override
	  public void setServletResponse(HttpServletResponse servletResponse) {
	    this.servletResponse = servletResponse;
	  }

	  protected HttpServletRequest servletRequest;
	  @Override
	  public void setServletRequest(HttpServletRequest servletRequest) {
	    this.servletRequest = servletRequest;
	  }

}