/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * A collection of BioMight Polygons (aka Indexed Faced Sets)
 * 
 */

public class BioMightPolygons {
	private ArrayList<BioMightPolygon> bioMightPolygons;
	int numElements = 0;
	
	
	// Default Constructor.  Allocate an 
	public BioMightPolygons()
	{
		bioMightPolygons = new ArrayList<BioMightPolygon> ();
	}

	public ArrayList getBioMightPolygons() {
		return bioMightPolygons;
	}

	public void setBioMightPolygons(ArrayList bioMightPolygons) {
		this.bioMightPolygons = bioMightPolygons;
	}
	
	// Return a specific element from the collection
	public BioMightPolygon getbioMightPolygon(int i) {
		
		BioMightPolygon bioMightPolygon = null;
		if (i < bioMightPolygons.size())
		{
			bioMightPolygon = (BioMightPolygon) bioMightPolygons.get(i);
		}
		return bioMightPolygon;
	}	

	// Set a specific element in the collection
	public void setbioMightPolygon(int i, BioMightPolygon bioMightPolygon) {
		bioMightPolygons.add(i, bioMightPolygon);
		numElements++;
	}
}
