/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import biomight.Constants;
import biomight.view.BioMightAnimation;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightScale;


/************************************************************************
 * @author SurferJim
 *
 * An object that represents a Viewpoint in 3D space.   A Viewpoint, like
 * actors, can be moved around in the world automatically via Animations 
 * 
 * A configuration value will determine how many Animations/ViewPoint
 * as this will be limited per account.  For now, provide 5
 ************************************************************************/

public class BioMightViewPoint implements Serializable {

	private String viewPointName = "Camera";
	private boolean jump = true;
	private double fieldOfView = 0.50;
	private BioMightPosition position;
	private BioMightOrientation orientation;
	// Each object can move around through time.
	private List bioMightAnimations;

	
	public BioMightViewPoint() {
		System.out.println("Default Constructor - BioMightViewPoint");
		position = new BioMightPosition(0.0, 0.0, 20.0);		
		orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
		int startTime = 0;
		int endTime = 0;
		double startPOV =  0.50;
		double endPOV = 0.50;
		bioMightAnimations = new ArrayList();

		BioMightAnimation bioMightAnimation = null;
		
		BioMightPosition startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightPosition endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightOrientation startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightOrientation endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightScale startScale = new BioMightScale("1.0, 1.0, 1.0");
		BioMightScale endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate1", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
		
		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate2", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);

		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate3", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);


		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate4", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);

		
		System.out.println("Constructor - BioMightViewPoint - Completed - 4 Animations allocated");
	
		
	}
	
	public BioMightViewPoint(String viewpointName, boolean jumpval, double fov) {
		System.out.println("Core Constructor - BioMightViewPoint");
		this.viewPointName = viewpointName;
		jump = jumpval;
		fieldOfView = fov;
		position = new BioMightPosition(0.0, 0.0, 20.0);
		orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
		
		// InTime, OutTime, StartPos, EndPos, StartRot,EndRot, StartScale, EndScale
		int startTime = 0;
		int endTime = 0;
		double startPOV =  0.50;
		double endPOV = 0.50;
		
		bioMightAnimations = new ArrayList();
		BioMightAnimation bioMightAnimation = null;
			
		BioMightPosition startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightPosition endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightOrientation startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightOrientation endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightScale startScale = new BioMightScale("1.0, 1.0, 1.0");
		BioMightScale endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate1", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
		
		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate2", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);

		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate3", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
	

		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Camera:0", "Animate4", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
	
	}

	
	public double getFieldOfView() {
		return fieldOfView;
	}

	public String getFieldOfViewStr() {
		return fieldOfView + "";
	}
	
	public void setFieldOfView(double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}
	public boolean isJump() {
		return jump;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	
	public BioMightOrientation getOrientation() {
		return orientation;
	}
	
	public String getOrientationStr() {
		return (orientation.getOrientationStr());
	}

	public String getOrientationStrRadians() {
		return (orientation.getOrientationStr());
	}
	
	public void setOrientation(BioMightOrientation orientation) {
		this.orientation = orientation;
	}
	
	public BioMightPosition getPosition() {
		return position;
	}

	public String getPositionStr() {
		return position.getPositionStr();
	}
	
	public void setPosition(BioMightPosition position) {
		this.position = position;
	}
	
	public List getBioMightAnimations() {
		return bioMightAnimations;
	}
	
	public void setBioMightAnimations(List bioMightAnimations) {
		this.bioMightAnimations = bioMightAnimations;
	}

	public String getViewPointName() {
		return viewPointName;
	}

	public void setViewPointName(String viewPointName) {
		this.viewPointName = viewPointName;
	}

	
}
