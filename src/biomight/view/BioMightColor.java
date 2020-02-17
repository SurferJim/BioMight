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
 * An object that represents a position in 3D space.
 * 
 */

public class BioMightColor implements Serializable{
	private double red;
	private double blue;
	private double green;

	public BioMightColor()
	{
		this.red = 1.0;
		this.green = 1.0;
		this.blue = 1.0;	
	}
	
	public BioMightColor(double red, double green, double blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;	
	}
	
	public double getBlue() {
		return blue;
	}
	public void setBlue(double blue) {
		this.blue = blue;
	}
	public double getGreen() {
		return green;
	}
	public void setGreen(double green) {
		this.green = green;
	}
	public double getRed() {
		return red;
	}
	public void setRed(double red) {
		this.red = red;
	}
	
	
}
