/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.io.Serializable;

import biomight.Constants;

/***************************************************************************
 * @author SurferJim
 *
 * BIOMIGHT ANIMATION
 * 
 * This object represents a simple animation, whether it be a transformation,
 * rotation, or scaling operation. 
 * 
 ***************************************************************************/

public class BioMightAnimation implements Serializable {

	// Each object can move around through time.
	private String componentID = "";
	private String animationName = "";
	private int animationType = Constants.TRANSLATE;
	private int startTime = 0;
	private int endTime = 0;
	private BioMightPosition startPosition;
	private BioMightPosition endPosition;
	private BioMightOrientation startOrientation;
	private BioMightOrientation endOrientation;
	private BioMightScale startScale; 
	private BioMightScale endScale;
	private double startPOV;
	private double endPOV;
	

	/*********************************************************************
	 * BIOANIMATION CONSTRUCTOR
	 * 
	 * All String Constructor
	 * ********************************************************************/
	
	public BioMightAnimation(String componentIDIn, String animName, int animTypeIn, 
							 String startTime, String endTime,  
			                 String startPositionIn, String endPositionIn, 
			                 String startOrientationIn, String endOrientationIn, 
			                 String startScaleIn, String endScaleIn, 
			                 String startPOVIn, String endPOVIn ) 
	{
		System.out.println("String Constructor - BioMightAnimation");
		this.componentID = componentIDIn;
		this.animationName = animName;
		this.animationType = animTypeIn;
		
		
		try {
			this.startTime = Integer.parseInt(startTime);
			this.endTime = Integer.parseInt(endTime);
		}
		catch (Exception e)
		{}
		
		this.startPosition = new BioMightPosition(startPositionIn);
		this.endPosition = new BioMightPosition(endPositionIn);
		this.startOrientation = new BioMightOrientation(startOrientationIn);
		this.endOrientation = new BioMightOrientation(endOrientationIn);
		this.startScale = new BioMightScale(startScaleIn);
		this.endScale = new BioMightScale(endScaleIn);
		try {
			this.startPOV = Double.parseDouble(startPOVIn);
			this.endPOV = Double.parseDouble(endPOVIn);
		}
		catch (Exception e)
		{}
	}

	/*********************************************************************
	 * BIOANIMATION CONSTRUCTOR
	 * 
	 * Regular Types Constructor
	 * ********************************************************************/

	
	public BioMightAnimation(String componentIDIn, String animNameIn, int animTypeIn, 
			 	int startTimeIn, int endTimeIn,  
	            BioMightPosition startPositionIn, BioMightPosition endPositionIn, 
	            BioMightOrientation startOrientationIn, BioMightOrientation endOrientationIn, 
	            BioMightScale startScaleIn, BioMightScale endScaleIn,
	            double startPOVIn, double endPOVIn) 
	{
		System.out.println("Core Values Constructor - BioMightAnimation");
		this.componentID = componentIDIn;
		this.animationName = animNameIn;
		this.animationType= animTypeIn;
		this.startTime = startTimeIn;
		this.endTime = endTimeIn;
		this.startPosition = startPositionIn;
		this.endPosition = endPositionIn;
		this.startOrientation = startOrientationIn;
		this.endOrientation = endOrientationIn;
		this.startScale = startScaleIn;  
		this.endScale = endScaleIn;	
		this.startPOV = startPOVIn;
		this.endPOV = endPOVIn;
	}
		
	/*********************************************************************
	 * BIOANIMATION CONSTRUCTOR
	 * 
	 * No Argument Constructor
	 * ********************************************************************/

	
	public BioMightAnimation() 
	{
		System.out.println("Default Constructor - BioMightAnimation");
		this.componentID = "Component:0";
		this.animationName = "Animate 1";
		this.animationType= Constants.TRANSLATE;
		this.startTime = 1;
		this.endTime = 4;
	
		this.startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		this.endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		this.startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		this.endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		this.startScale = new BioMightScale("1.0, 1.0, 1.0");  
		this.endScale = new BioMightScale("1.0, 1.0, 1.0");
		System.out.println("Constructor - BioMightAnimation Completed");
	}


	
	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public int getAnimationType() {
		return animationType;
	}


	public void setAnimationType(int animationTypeIn) {
		this.animationType = animationTypeIn;
	}

	public String getAnimationName() {
		return animationName;
	}


	public void setAnimationName(String animationName) {
		this.animationName = animationName;
	}


	public int getStartTime() {
		return startTime;
	}

	public String getStartTimeStr() {
		return startTime + "";
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setStartTime(String startTimeIn) {
		try {
			this.startTime = Integer.parseInt(startTimeIn);
		}
		catch (Exception e)
		{}
	}
	
	public int getEndTime() {
		return endTime;
	}

	public String getEndTimeStr() {
		return endTime + "";
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void setEndTime(String endTimeIn) {
		try {
			this.endTime = Integer.parseInt(endTimeIn);
		}
		catch (Exception e)
		{}
	}

	//***************************************
	// START POSITION Getter-Setters
	//***************************************
	public BioMightPosition getStartPosition() {
		return startPosition;
	}

	public String getStartPositionStr() {
		return startPosition.getPositionStr();
	}
	
	public void setStartPosition(BioMightPosition startPosition) {
		this.startPosition = startPosition;
	}

	public void setStartPosition(String startPositionIn) {
		this.startPosition.setPosition(startPositionIn);
	}
	
	//***************************************
	// END POSITION Getter-Setters
	//***************************************

	public BioMightPosition getEndPosition() {
		return endPosition;
	}

	public String getEndPositionStr() {
		return endPosition.getPositionStr();
	}


	public void setEndPosition(BioMightPosition endPosition) {
		this.endPosition = endPosition;
	}

	public void setEndPosition(String endPositionIn) {
		this.endPosition.setPosition(endPositionIn);
	}
	
	//***************************************
	// START ORIENTATION Getter-Setters
	//***************************************

	public BioMightOrientation getStartOrientation() {
		return startOrientation;
	}

	public String getStartOrientationStr() {
		return startOrientation.getOrientationStr();
	}
	public void setStartOrientation(BioMightOrientation startOrientation) {
		this.startOrientation = startOrientation;
	}

	public void setStartOrientation(String startOrientation) {
		this.startOrientation.setOrientation(startOrientation);
	}

	//***************************************
	// END ORIENTATION Getter-Setters
	//***************************************
	public BioMightOrientation getEndOrientation() {
		return endOrientation;
	}

	public String getEndOrientationStr() {
		return endOrientation.getOrientationStr();
	}
	
	public void setEndOrientation(BioMightOrientation endOrientation) {
		this.endOrientation = endOrientation;
	}

	public void setEndOrientation(String endOrientation) {
		this.endOrientation.setOrientation(endOrientation);;
	}

	//***************************************
	// START SCALE Getter-Setters
	//***************************************
	public BioMightScale getStartScale() {
		return startScale;
	}

	public String getStartScaleStr() {
		return startScale.getScaleStr();
	}
	
	public void setStartScale(String startScale) {
		this.startScale.setScale(startScale);
	}

	public void setStartScale(BioMightScale startScaleIn) {
		this.startScale = startScaleIn;
	}

	//***************************************
	// END SCALE Getter-Setters
	//***************************************

	public BioMightScale getEndScale() {
		return endScale;
	}

	public String getEndScaleStr() {
		return endScale.getScaleStr();
	}

	public void setEndScale(BioMightScale endScale) {
		this.endScale = endScale;
	}

	public void setEndScale(String endScale) {
		this.endScale.setScale(endScale);
	}

	public double getStartPOV() {
		return startPOV;
	}

	public void setStartPOV(double startPOV) {
		this.startPOV = startPOV;
	}

	public double getEndPOV() {
		return endPOV;
	}

	public void setEndPOV(double endPOV) {
		this.endPOV = endPOV;
	}
	
	

}
