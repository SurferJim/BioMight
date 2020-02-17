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
 * This objects holds a collection of Bound Boxes. This is needed when
 * we are working a collection of objects, as in eyes,arms,legs, lungs.
 * Places where we want to apply properties collectively to the group
 * 
 *************************************************************************/

public class BioMightBoundBoxes implements Serializable{
	HashMap boundBoxMap;

	
	// Allocate the HashMap for the bound boxes on 
	// object initialization
	public BioMightBoundBoxes()
	{
		boundBoxMap = new HashMap();
	}

	
	public HashMap getBoundBoxMap() {
		return boundBoxMap;
	}

	public void setBoundBoxMap(HashMap boundBoxMap) {
		this.boundBoxMap = boundBoxMap;
	}
	
	// Add a BoundBox to the Map
	public void setBoundingBox(String componentID, BioMightBoundBox bioMightBoundBox) {
		boundBoxMap.put(componentID, bioMightBoundBox);
	}
	
	// Get a boundbox from the Map
	public BioMightBoundBox getBoundingBox(String componentID) {
		BioMightBoundBox bioMightBoundBox = (BioMightBoundBox) boundBoxMap.get(componentID);
		if (bioMightBoundBox == null)
			System.out.println("ERROR-BoundBox not found for: " + componentID);
		return (bioMightBoundBox);
	}	
}
