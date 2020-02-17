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
 * An object that represents a position in 3D space.
 * 
 */

public class BioMightPosition implements Serializable {
	private double xPos;
	private double yPos;
	private double zPos;

	
	public BioMightPosition()
	{
		xPos = 0;
		yPos = 0;
		zPos = 0;
	}
	
	public BioMightPosition(double x, double y, double z)
	{
		xPos = x;
		yPos = y;
		zPos = z;
	}

	
	// Pass in a String of Coordinates, and boom 
	// we translate that into a BioMightPosition object 
	public BioMightPosition(String positionStr)
	{
		double [][] bioPositions = BioGraphics.getPositionsFromString(positionStr);	
		xPos = bioPositions[0][0];
		yPos = bioPositions[0][1];
		zPos = bioPositions[0][2];
	}

	
	// Pass in a String of Coordinates, and boom 
	// we translate that into a BioMightPosition object 
	public  void setPosition(String positionStr)
	{
		double [][] bioPositions = BioGraphics.getPositionsFromString(positionStr);	
		xPos = bioPositions[0][0];
		yPos = bioPositions[0][1];
		zPos = bioPositions[0][2];
	}
	
	
	public double getXPos() {
		return xPos;
	}
	public String getXPosStr() {
		return xPos + "";
	}
	public void setXPos(double pos) {
		xPos = pos;
	}
	public String getYPosStr() {
		return yPos + "";
	}	
	public double getYPos() {
		return yPos;
	}
	public void setYPos(double pos) {
		yPos = pos;
	}
	public String getZPosStr() {
		return zPos + "";
	}
	public double getZPos() {
		return zPos;
	}
	public void setZPos(double pos) {
		zPos = pos;
	}
	
	
	public String getPositionStr()
	{
		return (xPos + " " + yPos + " " + zPos); 
	}

	public String getPositionStrWC()
	{
		return (xPos + ", " + yPos + ", " + zPos); 
	}
}
