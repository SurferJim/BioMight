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
 * An object that represents a material
 * 
 */

public class BioMightMaterial implements Serializable {
	private int materialId;
	private String materialName;
	private double ambientIntensity;
	private double shininess;
	private double transparency;
	private BioMightColor diffuseColor;
	private BioMightColor specularColor;
	private BioMightColor emissiveColor;
	
	
	public BioMightMaterial() {
		diffuseColor = new BioMightColor();
		specularColor = new BioMightColor();
		emissiveColor = new BioMightColor();
	}
	
	
	
	public int getMaterialId() {
		return materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public double getAmbientIntensity() {
		return ambientIntensity;
	}


	public void setAmbientIntensity(double ambientIntensity) {
		this.ambientIntensity = ambientIntensity;
	}


	public BioMightColor getDiffuseColor() {
		return diffuseColor;
	}


	public void setDiffuseColor(BioMightColor diffuseColor) {
		this.diffuseColor = diffuseColor;
	}


	public double getShininess() {
		return shininess;
	}


	public void setShininess(double shininess) {
		this.shininess = shininess;
	}


	public double getTransparency() {
		return transparency;
	}


	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	public BioMightColor getSpecularColor() {
		return specularColor;
	}

	public void setSpecularColor(BioMightColor specularColor) {
		this.specularColor = specularColor;
	}

	public BioMightColor getEmissiveColor() {
		return emissiveColor;
	}

	public void setEmissiveColor(BioMightColor emissiveColor) {
		this.emissiveColor = emissiveColor;
	}
	
}
