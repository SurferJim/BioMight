/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * 
 * A collection of BioMightPosition objects.
 * 
 */

public class BioMightPositions implements Serializable{
	protected ArrayList<BioMightPosition> bioMightPositions;
	
	
	// Default Constructor.  Allocate an 
	public BioMightPositions()
	{
		bioMightPositions = new ArrayList<BioMightPosition> ();
	}

	public ArrayList getBioMightPositions() {
		return bioMightPositions;
	}

	public void setBioMightPositions(ArrayList bioMightPositions) {
		this.bioMightPositions = bioMightPositions;
	}
	
	// Return a specific element from the collection
	public BioMightPosition getBioMightPosition(int i) {
		
		BioMightPosition bioMightPosition = null;
		if (i < bioMightPositions.size())
		{
			bioMightPosition = (BioMightPosition) bioMightPositions.get(i);
		}
		return bioMightPosition;
	}	

	// Set a specific element in the collection
	public void setBioMightPosition(int i, BioMightPosition bioMightPosition) {
		bioMightPositions.add(i, bioMightPosition);
	}

	// Add a specific element into the collection
	public void addBioMightPosition(int i, BioMightPosition bioMightPosition) {
		bioMightPositions.add(i, bioMightPosition);
	}
	
	
	public int getSize()
	{
		return bioMightPositions.size();
	}
}
