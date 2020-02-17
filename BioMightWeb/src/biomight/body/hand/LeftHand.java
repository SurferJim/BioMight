/*
 * Created on May 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hand;
import biomight.Constants;
import biomight.body.Back;
import biomight.body.BodyPart;
import biomight.body.neck.Neck;
import biomight.system.muscular.hand.*;
import biomight.system.vascular.arteries.DigitalArtery;
import biomight.view.BioMightPosition;

/**
 * @author SurferJim
 *
 * This object creates a representation of a hand.
 * 
 */

public class LeftHand extends Hand  {
	//private Fingers fingers;
	private LeftIndexFinger leftIndexFinger;
	private LeftMiddleFinger leftMiddleFinger;
	private LeftRingFinger leftRingFinger;
	private LeftLittleFinger leftLittleFinger;
	private LeftThumb leftThumb;
	private LeftPalm leftPalm;	 
	private DigitalArtery digitalArtery;
	private LumbricalMuscles lumbricalMuscles;
	private ThenarEminence thenarEminence;
	
	
	public LeftHand()
	{
		setImage("images/LeftHand.jpg");			
		setImageWidth(200);
		setImageHeight(300);
	}

	
	public LeftHand(BioMightPosition bioMightPosition)
	{
		setImage("images/LeftHand.jpg");			
		setImageWidth(200);
		setImageHeight(300);

		leftPalm = new LeftPalm(bioMightPosition);	 
		System.out.println("Left Palm is created");		

		leftThumb = new LeftThumb(bioMightPosition);	 
		System.out.println("Left Thumb is created");	

		leftIndexFinger = new LeftIndexFinger(bioMightPosition);	 
		System.out.println("Left Index Finger is created");	
		
		leftMiddleFinger = new LeftMiddleFinger(bioMightPosition);
		System.out.println("Left Middle Finger is created");
		
		leftRingFinger = new LeftRingFinger(bioMightPosition);
		System.out.println("Left Ring Finger is created");
		
		leftLittleFinger = new LeftLittleFinger(bioMightPosition);
		System.out.println("Left Little Finger is created");	
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the LeftHand
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LeftHand.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LeftHand'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D for LeftHand");
		String body = 
			leftPalm.getX3D(true) +
			leftIndexFinger.getX3D(true) +
			leftMiddleFinger.getX3D(true) +
			leftRingFinger.getX3D(true) + 
			leftLittleFinger.getX3D(true) +
			leftThumb.getX3D(true);
		
		System.out.println("LeftHand X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	public void openGrasp()
	{
	}
	
	public void closeGrasp()
	{
	}	
		
}
