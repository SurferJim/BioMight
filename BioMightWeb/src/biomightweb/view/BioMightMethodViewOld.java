/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;

import java.util.ArrayList;

/**
 * @author SurferJim
 *
 *  The BioMightScene View represents a scene in BioMight. A scene consists
 * of a name, description, create and modify dates, alon with a collection of
 * frames that make up the scene.
 */
public class BioMightMethodViewOld {
	
	// The display name
	private String methodName = "";
	// The name to call the method
	private String canonicalName = "";
	// Topic Area
	private String heading = "";
	// 
	private String type = "";
	// picklist, etc
	private ArrayList values;
	public String getCanonicalName() {
		return canonicalName;
	}
	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList getValues() {
		return values;
	}
	public void setValues(ArrayList values) {
		this.values = values;
	}
	
	
	
}
