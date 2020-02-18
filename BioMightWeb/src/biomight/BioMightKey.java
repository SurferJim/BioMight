package biomight;
import java.io.Serializable;
import java.util.HashMap;



/**
 * @author SurferJim
 *
 * As we move from page to page, we need to determine what instances on the
 * objects in the database should be changed, and this is determined by the keys
 * that are contained here.
 */

public class BioMightKey implements Serializable {
	String componentName = "";
	String componentID = "";
	

	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String component) {
		this.componentName = component;
	}
	public String getComponentID() {
		return componentID;
	}
	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	

	
}
