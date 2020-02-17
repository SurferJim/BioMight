/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;

/**
 * @author SurferJim
 *
 * The BioMight Palette View.   This holds the information on the 
 * objects/components that have been added to the palette, etc.
 * 
 */


public class BioMightBuilderView {

	private String bioMightObject = "";
	private String bioMightInstance = "";

	
	/**
	 * @return
	 */
	public String getBioMightInstance() {
		return bioMightInstance;
	}

	/**
	 * @return
	 */
	public String getBioMightObject() {
		return bioMightObject;
	}

	/**
	 * @param string
	 */
	public void setBioMightInstance(String string) {
		bioMightInstance = string;
	}

	/**
	 * @param string
	 */
	public void setBioMightObject(String string) {
		bioMightObject = string;
	}

}
