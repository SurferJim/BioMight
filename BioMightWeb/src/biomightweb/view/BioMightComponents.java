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
 * This objects holds a collection of BioMight Components
 * 
 *************************************************************************/

public class BioMightComponents implements Serializable{
	private ArrayList bioMightComponents;
	
	
	public BioMightComponents() {
		bioMightComponents = new ArrayList();
	}
	
	// Get an Element from the ArrayList
	public BioMightComponent getElement(int i) {
		if (i<bioMightComponents.size())
			return (BioMightComponent) bioMightComponents.get(i);
		else
			return null;
	}

	// Update an Element in the ArrayList
	public void setElement( int pos, BioMightComponent bioMightComponent) {
		if (pos<bioMightComponents.size())
			bioMightComponents.set(pos, bioMightComponent);
		else
			System.out.println("NOT Setting BioMightView - out of range: " + pos + "   current: " + bioMightComponents.size());
	}
	
	// Get Delete an element from the ArrayList
	public void deleteElement(int i) {
		
		if (i<bioMightComponents.size())
			bioMightComponents.remove(i);

	}
	
	
	// Get an Element from the ArrayList
	public void addElement(BioMightComponent bioMightComponent) {
		bioMightComponents.add(bioMightComponent);
	}
	
	// Get an Element from the ArrayList
	public void addElement(BioMightComponent bioMightComponent, int pos) {
		bioMightComponents.add(pos, bioMightComponent);
	}
	
	
	// Get an Element from the ArrayList
	public int getSize() {
		return bioMightComponents.size();
	}

	
	public ArrayList getBioMightComponents() {
		return bioMightComponents;
	}

	public void setBioMightComponents(ArrayList bioMightComponents) {
		this.bioMightComponents = bioMightComponents;
	}
	
	
	
}
