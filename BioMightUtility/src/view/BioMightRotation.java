/*
 * Created on November, 2013
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
 * An object that represents a rotation in 3D space.
 * 
 */

public class BioMightRotation implements Serializable {
	private double xAngle;
	private double yAngle;
	private double zAngle;

	
	public BioMightRotation()
	{
		xAngle = 0;
		yAngle = 0;
		zAngle = 0;
	}
	
	public BioMightRotation(double x, double y, double z)
	{
		xAngle = x;
		yAngle = y;
		zAngle = z;
	}

	
	// Pass in a String of Coordinates, and boom 
	// we translate that into a BioMightAngle object 
	public BioMightRotation(String positionStr)
	{
		double [][] bioAngles = BioGraphics.getPositionsFromString(positionStr);		
		xAngle = bioAngles[0][0];
		yAngle = bioAngles[0][1];
		zAngle = bioAngles[0][2];
	}
	
	
	public double getXAngle() {
		return xAngle;
	}
	
	public void setXAngle(double angle) {
		xAngle = angle;
	}
	public double getYAngle() {
		return yAngle;
	}
	public void setYAngle(double angle) {
		yAngle = angle;
	}
	public double getZAngle() {
		return zAngle;
	}
	public void setZAngle(double angle) {
		zAngle = angle;
	}
	

	public String getXAngleStr() {
		return xAngle + "";
	}

	public String getYAngleStr() {
		return yAngle + "";
	}
	
	public String getZAngleStr() {
		return zAngle + "";
	}
	
	public String getRotationStr()
	{
		return (xAngle + " " + yAngle + " " + zAngle); 
	}
	
}
