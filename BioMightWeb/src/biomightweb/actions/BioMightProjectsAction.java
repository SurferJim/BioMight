package biomightweb.actions;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import biomightweb.util.User;


/**
 * @version 	1.0
 * @author
 */
public class BioMightProjectsAction extends ActionSupport implements SessionAware {
	private Map session;
	private String pageAction = "";
	private String pageName = "";
	
	
	/***********************************************************************************
	 * 
	 * 
	 * 
	 ***********************************************************************************/
	
	public String execute() throws Exception
	{
		User user = (User) session.get("User");
		System.out.println("In BioMightProjectsAction: " + pageAction);		
								
			// Go to another page
			if (pageAction.equals("details"))
			{
				// Store the Frame ID in the session object
				// as this where the library objects will be added.
				//request.setAttribute("forwarded", "true");
				System.out.println("Going to Details...");
				return "sucess";
			}
			else
			{
				System.out.println("Staying here");
				return "success";
			}
	}
	

	/**
	 * @return
	 */
	public String getPageAction() {
		return pageAction;
	}
	
	/**
	 * @param string
	 */
	public void setPageAction(String string) {
		pageAction = string;
	}
	
	/**
	 * @return
	 */
	public String getPageName() {
		return pageName;
	}
	
	/**
	 * @param string
	 */
	public void setPageName(String string) {
		pageName = string;
	}


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}

	

}
