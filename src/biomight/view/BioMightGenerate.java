/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;
import java.util.HashMap;


/************************************************************************
 * @author SurferJim
 *
 * BIOMIGHT GENERATE
 * 
 * An object that brings back information from a Generate command.  
 * It defines a set of properties for itself. It also contains a hashmap
 * of BioGenerate objects   
 * 
 *************************************************************************/

public class BioMightGenerate implements Serializable{
	
	// These are the basic object properties
	private String componentType="";
	private String componentName="";
	private String componentID="";
	private String parentID=""; 
		
	// What type of connector does this represent
	private String connectType = "";
	
	// What are the points 
	private double [][] connectPoints;

	// Stores a HashMap of other BioMightGenerate Objects
	// Models the drill down hierarchy of object construction
	// objects within object, boxes in a box, children, etc 
	HashMap componentMap;

	
	/*****************************************************************************
	 * BIOGENERATE CONSTRUCTORS
	 * Base Constructor
	 * 
	 ****************************************************************************/
	
	public BioMightGenerate()
	{
		componentMap = new HashMap();
	}

	/*****************************************************************************
	 * BIOGENERATE 
	 * 
	 * Constructor that takes come parameters
	 * 
	 ****************************************************************************/

	public BioMightGenerate(double [][] lastPoints, int retcode, String msg)
	{
		this.connectPoints = lastPoints;
		this.returnCode = retcode;
		this.errorMsg=msg;
		componentMap = new HashMap();
	}

	
	public String getConnectType() {
		return connectType;
	}

	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}

	// Did the generate method execute successfully
	private int returnCode=0;
	
	// Was there a warning generated during the generation process
	private String warningMsg="";
	
	// Was there an error generate during the generation process
	private String errorMsg="";

		
	public double[][] getConnectPoints() {
		return connectPoints;
	}

	
	// Add an object into the Component Map
	public void setMapComponent(String componentID, BioMightGenerate bioMightGenerate) {
		componentMap.put(componentID, bioMightGenerate);
	}
	
	// Add an object into the Component Map
	public BioMightGenerate getMapComponent(String componentID) {
		BioMightGenerate bioMightGenerate = (BioMightGenerate) componentMap.get(componentID);
		return (bioMightGenerate);
	}
		
	public HashMap getComponentMap() {
		return componentMap;
	}

	public void setComponentMap(HashMap componentMap) {
		this.componentMap = componentMap;
	}
	
	public void setConnectPoints(double[][] connectPoints) {
		this.connectPoints = connectPoints;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getWarningMsg() {
		return warningMsg;
	}

	public void setWarningMsg(String warningMsg) {
		this.warningMsg = warningMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
		
	
	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}
