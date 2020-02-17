/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;

import org.apache.openejb.math.util.MathUtils;

import biomight.util.BioGraphics;

/**
 * @author SurferJim
 *
 * An object that represents a point of view in 3D space.
 * 
 */

public class BioMightOrientation implements Serializable  {
	private double xAxis;
	private double yAxis;
	private double zAxis;
	private double degrees;	
	
	
	public BioMightOrientation(){
		xAxis = 0.0;
		yAxis = 0.0;
		zAxis = 0.0;
		degrees = 0.0;
	}

	
	public BioMightOrientation(double xAxisIn, double yAxisIn, double zAxisIn, double degreesIn){
		xAxis = xAxisIn;
		yAxis = yAxisIn;
		zAxis = zAxisIn;
		degrees = MathUtils.round(Math.toRadians(degreesIn), 6);
		//System.out.println("BioMightOrientation Constructed: " + xAxis + " " + yAxis + "  " + zAxis + "  " + degrees);
	}

	public BioMightOrientation(String orientationStr){
		double [][] orientation = BioGraphics.getOrientationFromString(orientationStr);
		//System.out.println("Orientation Size: " + orientation.length  + "  String to Parse: " + orientationStr);
		xAxis = orientation[0][0];
		yAxis = orientation[0][1];
		zAxis = orientation[0][2];
		degrees = MathUtils.round(Math.toRadians(orientation[0][3]), 6);
		//System.out.println("BioMightOrientation Constructed: " + xAxis + " " + yAxis + "  " + zAxis + "  " + degrees);
	}

	
	// Rather than creating a new object- just update the existing base elements
	public void setOrientation(String orientationStr){
		double [][] orientation = BioGraphics.getOrientationFromString(orientationStr);
		//System.out.println("Orientation Size: " + orientation.length  + "  String to Parse: " + orientationStr);
		xAxis = orientation[0][0];
		yAxis = orientation[0][1];
		zAxis = orientation[0][2];
		degrees = MathUtils.round(Math.toRadians(orientation[0][3]), 6);
		//System.out.println("BioMightOrientation Constructed: " + xAxis + " " + yAxis + "  " + zAxis + "  " + degrees);
	}
	
	
	public double getXAxis() {
		return xAxis;
	}
	public String getXAxisStr() {
		return xAxis + "";
	}
	public void setXAxis(double Axis) {
		xAxis = Axis;
	}
	
	public double getYAxis() {
		return yAxis;
	}	
	public String getYAxisStr() {
		return yAxis + "";
	}	
	public void setYAxis(double Axis) {
		yAxis = Axis;
	}
	

	public void setZAxis(double Axis) {
		zAxis = Axis;
	}
	public double getZAxis() {
		return zAxis;
	}
	public String getZAxisStr() {
		return zAxis + "";
	}
	

	public double getRadians() {
		return degrees;
	}
	
	
	public String getRadianStr() {
		return  degrees + "";
	}	
	
	
	public double getDegrees() {
		return MathUtils.round(Math.toDegrees(degrees), 6);
	}
	
	
	public String getDegreeStr() {
		return  Math.toDegrees(degrees) + "";
	}	
	
	
	public void setDegrees(double degrees) {
		this.degrees = MathUtils.round(Math.toRadians(degrees), 6);
	}
	
	
	public String getOrientationStr() {
		
		return (xAxis + " " + yAxis + " " + zAxis + " " + degrees);
	}

	public String getOrientationStrWC() {
		
		return (xAxis + ",  " + yAxis + ",  " + zAxis + ",  " + degrees);
	}
}
