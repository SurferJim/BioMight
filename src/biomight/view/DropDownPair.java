/*
 * Created on Jan 28, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */


public class DropDownPair  {
	private String value;
    private String label;

    
    public DropDownPair(){
    }

	
    public DropDownPair(String label, String value){
    	this.label = label;
    	this.value = value;
    }

    
    public String getValue() {
    	return value;
    }
    	
    public void setLabel(String label) {
    	this.label = label;
    }

    public String getLabel() {
    	return label;
    }    
}