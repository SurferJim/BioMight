/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;

import java.io.Serializable;
import java.util.ArrayList;

/************************************************************************
 * @author SurferJim
 *
 * This objects holds a collection of ViewPoints.  These guys interact
 * on the palette
 * 
 *************************************************************************/

public class BioMightViewPoints implements Serializable{
	private ArrayList viewpoints;
	

	public BioMightViewPoints() {
		viewpoints = new ArrayList();
	}
	
	// Get an Element from the ArrayList
	public BioMightViewPoint getElement(int i) {
		if (i<viewpoints.size())
			return (BioMightViewPoint) viewpoints.get(i);
		else
			return null;
	}

	// Get an Element from the ArrayList
	public void addElement(BioMightViewPoint bioMightViewPoint) {
		viewpoints.add(bioMightViewPoint);
	}
	
	// Get an Element from the ArrayList
	public void addElement(BioMightViewPoint bioMightViewPoint, int pos) {
		viewpoints.add(pos, bioMightViewPoint);
	}

	// Update an Element in the ArrayList
	public void setElement( int pos, BioMightViewPoint bioMightViewPoint) {
		if (pos<viewpoints.size())
			viewpoints.set(pos, bioMightViewPoint);
		else
			System.out.println("NOT Setting Element - pos out of range: " + pos + "      current: " + viewpoints.size());
	}
	
	// Get an Element from the ArrayList
	public int getSize() {
		return viewpoints.size();
	}
		
}
