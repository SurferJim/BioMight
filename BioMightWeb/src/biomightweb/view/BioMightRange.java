/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import biomight.BioMightKeys;
import biomight.Constants;
import biomight.view.BioMightAnimation;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;


/******************************************************************************
 * @author SurferJim
 *
 * BioMightRange Object
 * 
 *****************************************************************************/
public class BioMightRange implements Serializable {

	private double minLongRange;
	private double maxLongRange;
	private double minLatRange;	
	private double maxLatRange;
	
	private int sections;
	
	private double minWidth = 0;
	private double maxWidth = 0;
	
	private double minHeight = 0;
	private double maxHeight = 0;
	

	// Default Constructor
	public BioMightRange() 
	{
		System.out.println("Constructor - BioMightComponent");
			
		System.out.println("Constructor - BioMightComponent - Completed");
	}
	
	
	public BioMightRange(int sectionsIn, double minLongRangeIn, double maxLongRangeIn, double minLatRangeIn , double maxLatRangeIn,  
						 double minWidthIn,  double maxWidthIn, double minHeightIn, double maxHeightIn) 
	{
		System.out.println("Constructor - BioMightRange");
			
		sections = sectionsIn;
		
		minLongRange = minLongRangeIn;
		maxLongRange = maxLongRangeIn;
		
		minLatRange = minLatRangeIn;
		maxLatRange = maxLatRangeIn;
		
		minWidth = minWidthIn;
		maxWidth = maxWidthIn;
		
		minHeight = minHeightIn;
		maxHeight = maxHeightIn;
		
		System.out.println("Constructor - BioMightRange - Completed");
	}


	public double getMinLongRange() {
		return minLongRange;
	}


	public void setMinLongRange(double minLongRange) {
		this.minLongRange = minLongRange;
	}


	public double getMaxLongRange() {
		return maxLongRange;
	}


	public void setMaxLongRange(double maxLongRange) {
		this.maxLongRange = maxLongRange;
	}


	public double getMinLatRange() {
		return minLatRange;
	}


	public void setMinLatRange(double minLatRange) {
		this.minLatRange = minLatRange;
	}


	public double getMaxLatRange() {
		return maxLatRange;
	}


	public void setMaxLatRange(double maxLatRange) {
		this.maxLatRange = maxLatRange;
	}


	public double getMinWidth() {
		return minWidth;
	}


	public void setMinWidth(double minWidth) {
		this.minWidth = minWidth;
	}


	public double getMaxWidth() {
		return maxWidth;
	}


	public void setMaxWidth(double maxWidth) {
		this.maxWidth = maxWidth;
	}


	public double getMinHeight() {
		return minHeight;
	}


	public void setMinHeight(double minHeight) {
		this.minHeight = minHeight;
	}


	public double getMaxHeight() {
		return maxHeight;
	}


	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}


	public int getSections() {
		return sections;
	}


	public void setSections(int sections) {
		this.sections = sections;
	}



}
