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
 * An object that sends information to a Generate command.  This serves
 * as a value object for Object Consturuction.  -- Give me a BoundBox
 * abd a starting point,and let nature's algorithm take care of the rest
 * 
 * ???
 * Make two constructors, or make the constructor hold bound box or
 * collection of bound boxes,or just create a mixed hashmap.  We are
 * using a mixed hashmap for now  
 * 
 *************************************************************************/

public class BioMightConstruct implements Serializable{
	private HashMap boundBoxMap;
	private BioMightGenerate bioMightGenerate;
	
	
	/***********************************
	 * BIOMIGHTCONSTRUCT
	 *
	 * Base Constructor Class
	 *
	 *************************************/
	public BioMightConstruct()
	{
		boundBoxMap = new HashMap();
		bioMightGenerate = new BioMightGenerate();
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
		return (bioMightBoundBox);
	}

	// Add a collection of BoundBoxes to the Map
	public void setBoundingBoxes(String componentID, BioMightBoundBoxes bioMightBoundBoxes) {
		boundBoxMap.put(componentID, bioMightBoundBoxes);
	}
	
	// Get a collection of Boundboxes from the Map
	public BioMightBoundBoxes getBoundingBoxes(String componentID) {
		BioMightBoundBoxes bioMightBoundBoxes = (BioMightBoundBoxes) boundBoxMap.get(componentID);
		if (bioMightBoundBoxes == null)
			System.out.println("ERROR-BoundBoxes not found for: " + componentID);
		return (bioMightBoundBoxes);
	}


	public BioMightGenerate getBioMightGenerate() {
		return bioMightGenerate;
	}

	public void setBioMightGenerate(BioMightGenerate bioGenerate) {
		this.bioMightGenerate = bioGenerate;
	}
	
}
