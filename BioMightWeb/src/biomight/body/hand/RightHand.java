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

public class RightHand extends Hand  {
	//private Fingers fingers;
	private RightIndexFinger rightIndexFinger;
	private RightMiddleFinger rightMiddleFinger;
	private RightRingFinger rightRingFinger;
	private RightLittleFinger rightLittleFinger;
	private RightThumb rightThumb;
	private RightPalm rightPalm;	 
	private DigitalArtery digitalArtery;
	private LumbricalMuscles lumbricalMuscles;
	private ThenarEminence thenarEminence;
	
	
	public RightHand()
	{
		setImage("images/RightHand.jpg");			
		setImageWidth(200);
		setImageHeight(300);
	}

	
	public RightHand(BioMightPosition bioMightPosition)
	{
		setImage("images/RightHand.jpg");			
		setImageWidth(200);
		setImageHeight(300);

		rightPalm = new RightPalm(bioMightPosition);	 
		System.out.println("Right Palm is created");		

		rightThumb = new RightThumb(bioMightPosition);	 
		System.out.println("Right Thumb is created");	

		rightIndexFinger = new RightIndexFinger(bioMightPosition);	 
		System.out.println("Right Index Finger is created");	
		
		rightMiddleFinger = new RightMiddleFinger(bioMightPosition);
		System.out.println("Right Middle Finger is created");
		
		rightRingFinger = new RightRingFinger(bioMightPosition);
		System.out.println("Right Ring Finger is created");
		
		rightLittleFinger = new RightLittleFinger(bioMightPosition);
		System.out.println("Right Little Finger is created");	
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
		
		// Assemble the RightHand
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RightHand.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RightHand'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D for RightHand");
		String body = 
			rightPalm.getX3D(true) +
			rightIndexFinger.getX3D(true) +
			rightMiddleFinger.getX3D(true) +
			rightRingFinger.getX3D(true) + 
			rightLittleFinger.getX3D(true) +
			rightThumb.getX3D(true);
		
		System.out.println("RightHand X3D: " + body);		
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
