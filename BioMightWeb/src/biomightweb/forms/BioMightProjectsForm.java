/*
 * Created on Jan 28, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.forms;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BioMightProjectsForm {

	private String biomightObject = "";
	private String pageAction = "";
	private String pageName = "";
	
	
	public String getObjectName()
	{
		int len = biomightObject.lastIndexOf(".");
		String name = biomightObject.substring(len);
		return name;
	}
	
	/**
	 * @return
	 */
	public String getBiomightObject() {
		return biomightObject;
	}

	/**
	 * @param string
	 */
	public void setBiomightObject(String string) {
		biomightObject = string;
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

}
