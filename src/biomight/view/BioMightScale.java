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

public class BioMightScale implements Serializable {
	private double xScale;
	private double yScale;
	private double zScale;

	
	public BioMightScale()
	{
		xScale = 1.0;
		yScale = 1.0;
		zScale = 1.0;
	}
	
	
	
	// Pass in a String of Coordinates, and boom 
	// we translate that into a BioMightPosition object 
	public BioMightScale(String positionStr)
	{
		double [][] bioScale = BioGraphics.getPositionsFromString(positionStr);		
		xScale = bioScale[0][0];
		yScale = bioScale[0][1];
		zScale = bioScale[0][2];
	}
		
	public BioMightScale(double x, double y, double z)
	{
		xScale = x;
		yScale = y;
		zScale = z;
	}
	
	
	public void setScale(String positionStr)
	{
		double [][] bioScale = BioGraphics.getPositionsFromString(positionStr);		
		xScale = bioScale[0][0];
		yScale = bioScale[0][1];
		zScale = bioScale[0][2];
	}

	public void setScale(double scaleX, double scaleY, double scaleZ)
	{	
		xScale = scaleX;
		yScale = scaleY;
		zScale = scaleZ;
	}
	
	
	public String getXScaleStr() {
		return xScale + "";
	}
	public double getXScale() {
		return xScale;
	}
	
	public void setXScale(double scale) {
		xScale = scale;
	}
	
	public String getYScaleStr() {
		return yScale + "";
	}
	
	public double getYScale() {
		return yScale;
	}
	
	public void setYScale(double scale) {
		yScale = scale;
	}
	
	public String getZScaleStr() {
		return zScale + "";
	}
	
	public double getZScale() {
		return zScale;
	}
	
	public void setZScale(double scale) {
		zScale = scale;
	}
		
	public String getScaleStr()
	{
		return (xScale + " " + yScale + " " + zScale); 
	}
	
	public String getScaleStrWC()
	{
		return (xScale + ", " + yScale + ", " + zScale); 
	}
	
	public double getXPos() {
		return xScale;
	}
	
	public double getYPos() {
		return yScale;
	}
	
	public double getZPos() {
		return zScale;
	}
	
}
