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
 * Representation for a Sphere
 * 
 */

public class BioMightTransforms implements Serializable {
	private ArrayList transforms;

	
	
	public BioMightTransforms() {
		transforms = new ArrayList();
	}

	public void add(BioMightTransform bioMightTransform) {
		transforms.add(bioMightTransform);
	}
	
	public BioMightTransform get(int i) {
		BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		return (bioMightTransform);
	}
	

	public ArrayList getTransforms() {
		return transforms;
	}



	public void setTransforms(ArrayList transforms) {
		this.transforms = transforms;
	}



}
