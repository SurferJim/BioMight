package biomightweb.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * @version 	1.0
 * @author
 */

public class LoginAction implements  ServletRequestAware {
	private String username;
	private String password;
	private HttpServletRequest request;
	
	
	public String execute() {
		System.out.println("In LoginAction: " + username);

		
		HttpSession loginSessionObj = (HttpSession)request.getSession(false);         
        if (loginSessionObj!=null)  
           {  
              //loginSessionObj.removeAttribute("bioUser");  
                 
               if(loginSessionObj!=null)  
               {  
                   loginSessionObj.invalidate();  
                   loginSessionObj = (HttpSession)request.getSession(false);  
               }    
           }  
          
		
		// Get a new session and attach binding listener
		//if (this.username.equals("surferjim") && this.password.equals("biomight") 
		if ( (this.username.equals("surferjim") && this.password.equals("biomight")) ||
		     (this.username.equals("guest")     && this.password.equals("guest")) ||
		     (this.username.equals("") && this.password.equals(""))) {
			return "success";
		} 
		else {
			return "error";
		}
	
		
		
		
		
		
		
		// Create a user object and store it in the session
		//User user = new User();
		//user.setUserName("SurferJim");
		//user.setFirstName("Jim");
		//session.setAttribute("user", user);
	}
	
	 	
	public String getUsername() {
		return username;
	}
	
	 
	public void setUsername(String username) {
		this.username = username;
	}

	 

	public String getPassword() {
		return password;	
	}

	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
 
	public HttpServletRequest getServletRequest() {
		return this.request;
	}

		
}
