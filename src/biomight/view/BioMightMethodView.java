package biomight.view;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author SurferJim
 *
 *  The BioMightMethodView represents an object similar to the Java Introspection object.
 *  It is more lightweight, does not need the BeanInfo class and allows one to declare the
 *  methods that a particular BioMight object posses.
 */
public class BioMightMethodView  implements Serializable {
	
	// The method name
	private String methodName = "";

	// The methods canonical Name
	private String canonicalName = "";
		
	// The display name
	private String displayName = "";
	
	// Picklist, dropdown, radio, checkbox, text etc
	private String htmlType = "";
	
	// If its a dropdown, then the values
	// that prefill it come from here
	private HashMap valueMap;

	// Input type - Int, String, Byte, Decimal, etc.
	private String dataType = "";
	
	// The Value
	private String methodParameter;
	
	
	/************************************************************
	 * 
	 * 
	 ************************************************************/
	public BioMightMethodView() {
		//System.out.println("In MethodView Constructor");
	}
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getHtmlType() {
		return htmlType;
	}
	public void setHtmlType(String htmlType) {
		this.htmlType = htmlType;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getCanonicalName() {
		return canonicalName;
	}
	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	// Convert into Struts Name-Value pairs
	/*
	public ArrayList getDropDownValues() {
		// Convert the arraylist of strings into the object
		// Needed by struts of value/label pairs
		ArrayList tempList = new ArrayList();
		for (int i=0; i<values.size(); i++) {
			DropDownPair ddPair = new DropDownPair(""+i, (String)values.get(i));
			tempList.add(ddPair);
		}
		
		return tempList;
	}
	 */

	

	public String getMethodParameter() {
		return methodParameter;
	}

	public HashMap getValueMap() {
		return valueMap;
	}

	public void setValueMap(HashMap valueMap) {
		this.valueMap = valueMap;
	}

	public void setMethodParameter(String parameter) {
		this.methodParameter = parameter;
	}
	
}
