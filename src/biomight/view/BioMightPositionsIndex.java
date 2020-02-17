/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

/**
 * @author SurferJim
 *
 * The tells how to construct a polygon using the verticies in BioMightPositions
 * Was thinking about extending, but they are packaged in a polygon
 */

public class BioMightPositionsIndex {
	private int[] coordIndex;
	int numElements = 0;
	
	
	// Default Constructor.  
	public BioMightPositionsIndex()
	{
	}

	// Default Constructor.  Allocate an 
	public BioMightPositionsIndex(int numElements)
	{
		coordIndex = new int[numElements];
	}
	

	public int[] getCoordIndex() {
		return coordIndex;
	}

	
	public double getCoordIndexElement(int element){
		// If the element is within the domain then 
		// return the value
		if (element > coordIndex.length)
			return 0.0;
		else
			return coordIndex[element];
	}
	
	
	public String getCoordIndexElementStr(int element){
		// If the element is within the domain then 
		// return the value
		if (element > coordIndex.length)
			return "0.0";
		else
		{
			return "" + coordIndex[element];
		}
	}
	
	
	public void setCoordIndex(int[] coordIndex) {
		this.coordIndex = null;
		this.coordIndex = coordIndex;
	}

}
