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
public class BioMightLoginForm extends BioMightForm {

	private String userName = "";
	private String passWord = "";
	
	
	/**
	 * @return
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param string
	 */
	public void setPassWord(String string) {
		passWord = string;
	}

	/**
	 * @param string
	 */
	public void setUserName(String string) {
		userName = string;
	}

}
