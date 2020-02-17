package biomightweb.actions;

import biomightweb.forms.BioMightCorpForm;
import biomightweb.util.User;

/**
 * @version 	1.0
 * @author
 */

public class BioMightCorporateAction {
	private BioMightCorpForm bioMightCorpForm;
	private String pageAction = "";

	
	
	/***********************************************************************************
	 * EXECUTE
	 * 
	 * 
	 ***********************************************************************************/
	
	public String execute() throws Exception
	{
		//User user = (User) session.get("User");
		System.out.println("CorporateAction - pageAction: " + pageAction);
		return pageAction;
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


	public BioMightCorpForm getBioMightCorpForm() {
		return bioMightCorpForm;
	}


	public void setBioMightCorpForm(BioMightCorpForm bioMightCorpForm) {
		this.bioMightCorpForm = bioMightCorpForm;
	}
			
	
}
