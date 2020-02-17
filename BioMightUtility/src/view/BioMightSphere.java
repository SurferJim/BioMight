/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;


/**
 * @author SurferJim
 *
 * Representation for a Sphere
 * 
 */

public class BioMightSphere implements Serializable {
	private BioMightPosition translation;
	private BioMightPosition scale;
	private double radius;
	private BioMightMaterial material;
	
	
	public BioMightSphere() {
		translation = new BioMightPosition();
		scale = new BioMightPosition();
		material = new BioMightMaterial();
	}


	public BioMightPosition getScale() {
		return scale;
	}


	public void setScale(BioMightPosition scale) {
		this.scale = scale;
	}


	public BioMightMaterial getMaterial() {
		return material;
	}


	public void setMaterial(BioMightMaterial material) {
		this.material = material;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}





	public BioMightPosition getTranslation() {
		return translation;
	}


	public void setTranslation(BioMightPosition translation) {
		this.translation = translation;
	}
	
}
