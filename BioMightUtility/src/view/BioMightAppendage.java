/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;

import biomight.util.BioGraphics;

/**
 * @author SurferJim
 *
 * An object that represents a Scalar in 3D space.
 * 
 */

public class BioMightAppendage implements Serializable {
	private double minRadius = 0.0;
	private double maxRadius = 0.0;
	private double radius = 0.0;
	private double[] taperPoint = {};
	private double[] taperValue = {};
	private int minAppendages = 0;
	private int maxAppendages = 0;
	private double latitude = 0;
	private double longitude = 0;
	int minLatitudeDev = 0;
  	int angleLatitudeMinDev = 0;
  	int angleLatitudeMaxDev = 0;
  	int angleLongitudeMinDev = 0;	
  	int angleLongitudeMaxDev = 0;
	private double orbitalRadius = 0.0;
	String componentName = "";
	private String parent = "";

	// Not sure if these should stay here, 
	// if we should just slap a transform into here
	private int textureID = 0;
	private String textureName;
	private String textureFile;
	
	
	public BioMightAppendage()
	{
		super();
		minRadius = 0.25;
		maxRadius = 0.50;
		radius = 0.25;
		orbitalRadius = 1.0;
		taperPoint = initTaper();
		taperValue = initTaperValues();
		minAppendages = 1;
		maxAppendages = 15;
		double latitude = 0;
		double longitude = 0;
	}
	
	
	public BioMightAppendage(
			String componentNameIn,
			String parent,
			double orbitalRadius, double minRadius, double maxRadius, double radius, double[] taperPoint,
			double[] taperValue, int minAppendages, int maxAppendages,
			double latitude, double longitude, int minLat, int maxLat, int minLong, int maxLong, int textureIDIn, String textureFileIn) 
	{
		super();
		this.componentName = componentNameIn;
		this.parent = parent;
		this.minRadius = minRadius;
		this.maxRadius = maxRadius;
		this.radius = radius;
		this.orbitalRadius = orbitalRadius;
		
		this.taperPoint = taperPoint;
		this.taperValue = taperValue;
		this.minAppendages = minAppendages;
		this.maxAppendages = maxAppendages;
		this.latitude = latitude;
		this.longitude = longitude;
		this.angleLatitudeMinDev = minLat; 
		this.angleLatitudeMaxDev = maxLat;
		this.angleLongitudeMinDev = minLong;
		this.angleLongitudeMaxDev = maxLong;
		
		this.textureID = textureIDIn;
		this.textureFile = textureFileIn;
	}
	

	
	public String getComponentName() {
		return componentName;
	}


	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}


	public int getTextureID() {
		return textureID;
	}


	public void setTextureID(int textureID) {
		this.textureID = textureID;
	}


	public String getTextureName() {
		return textureName;
	}


	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}


	public String getTextureFile() {
		return textureFile;
	}


	public void setTextureFile(String textureFile) {
		this.textureFile = textureFile;
	}


	public double getMinRadius() {
		return minRadius;
	}


	public void setMinRadius(double minRadius) {
		this.minRadius = minRadius;
	}


	public double getMaxRadius() {
		return maxRadius;
	}


	public void setMaxRadius(double maxRadius) {
		this.maxRadius = maxRadius;
	}


	public String getParent() {
		return parent;
	}


	public void setParent(String parent) {
		this.parent = parent;
	}


	public double getOrbitalRadius() {
		return orbitalRadius;
	}


	public void setOrbitalRadius(double orbitalRadius) {
		this.orbitalRadius = orbitalRadius;
	}


	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double[] getTaperPoint() {
		return taperPoint;
	}
	public void setTaperPoint(double[] taperPoint) {
		this.taperPoint = taperPoint;
	}
	public double[] getTaperValue() {
		return taperValue;
	}
	public void setTaperValue(double[] taperValue) {
		this.taperValue = taperValue;
	}
	public int getMinAppendages() {
		return minAppendages;
	}
	public void setMinAppendages(int minAppendages) {
		this.minAppendages = minAppendages;
	}
	public int getMaxAppendages() {
		return maxAppendages;
	}
	public void setMaxAppendages(int maxAppendages) {
		this.maxAppendages = maxAppendages;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double[] initTaper() {
		double taper[] = {0.50, 0.75};
		return(taper);
	}
	
	public double[] initTaperValues() {
		double taperValues[] = {radius, radius/3};
		return (taperValues);
	}


	public int getMinLatitudeDev() {
		return minLatitudeDev;
	}


	public void setMinLatitudeDev(int minLatitudeDev) {
		this.minLatitudeDev = minLatitudeDev;
	}


	public int getAngleLatitudeMinDev() {
		return angleLatitudeMinDev;
	}


	public void setAngleLatitudeMinDev(int angleLatitudeMinDev) {
		this.angleLatitudeMinDev = angleLatitudeMinDev;
	}


	public int getAngleLatitudeMaxDev() {
		return angleLatitudeMaxDev;
	}


	public void setAngleLatitudeMaxDev(int angleLatitudeMaxDev) {
		this.angleLatitudeMaxDev = angleLatitudeMaxDev;
	}


	public int getAngleLongitudeMinDev() {
		return angleLongitudeMinDev;
	}


	public void setAngleLongitudeMinDev(int angleLongitudeMinDev) {
		this.angleLongitudeMinDev = angleLongitudeMinDev;
	}


	public int getAngleLongitudeMaxDev() {
		return angleLongitudeMaxDev;
	}


	public void setAngleLongitudeMaxDev(int angleLongitudeMaxDev) {
		this.angleLongitudeMaxDev = angleLongitudeMaxDev;
	}
	
}
