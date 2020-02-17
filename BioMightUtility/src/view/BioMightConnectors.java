/*
 * Created on June 21, 2013
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.util.HashMap;
import java.io.Serializable;

/********************************************************************
 * @author SurferJim
 *
 * A collection of BioMightConnector objects.
 * 
 ********************************************************************/

public class BioMightConnectors implements Serializable{
	protected HashMap bioMightConnectors;
	
	
	// Default Constructor.  Allocate an arrayist so
	// we dont get null pointers accessing it
	public BioMightConnectors()
	{
		bioMightConnectors = new HashMap();
	}

	
	public HashMap getBioMightConnectors() {
		return bioMightConnectors;
	}

	
	public void setBioMightConnectors(HashMap bioMightConnectors) {
		this.bioMightConnectors = bioMightConnectors;
	}
	
	
	
	// Return a specific element from the HashMap
	public BioMightConnector getBioMightConnector(String boundBox) {
		BioMightConnector bioMightConnector = (BioMightConnector) bioMightConnectors.get(boundBox);
		return bioMightConnector;
	}	

	
	// Add an element to the HashMap
	public void setBioMightConnector(String boundBox, BioMightConnector bioMightConnector) {
		bioMightConnectors.put(boundBox, bioMightConnector);
	}
	
	
	public int getSize()
	{
		return bioMightConnectors.size();
	}
}
