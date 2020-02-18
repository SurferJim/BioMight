/*
* Created on Jul 11, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.ribs;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightPosition;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class FalseRibs extends Bone {
	private LeftRib8  leftRib8;
	private LeftRib9  leftRib9;
	private LeftRib10 leftRib10;
	private RightRib8  rightRib8;
	private RightRib9  rightRib9;
	private RightRib10 rightRib10;	
	
	public FalseRibs()
	{
		this.setImage("images/FalseRibs.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}

	public FalseRibs(BioMightPosition bioMightPosition)
	{
		this.setImage("images/TrueRibs.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Create the Left ribs
		leftRib8 = new LeftRib8(bioMightPosition);
		leftRib9 = new LeftRib9(bioMightPosition);
		leftRib10 = new LeftRib10(bioMightPosition);

	
		// Create the Left ribs
		rightRib8 = new RightRib8(bioMightPosition);
		rightRib9 = new RightRib9(bioMightPosition);
		rightRib10 = new RightRib10(bioMightPosition);	
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the False Ribs
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FalseRibs.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FalseRibs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =   
			leftRib8.getX3D(true) + 
			leftRib9.getX3D(true) + 
			leftRib10.getX3D(true) + 
			rightRib8.getX3D(true) +
			rightRib9.getX3D(true) +
			rightRib10.getX3D(true);
		
		System.out.println("False Ribs X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	


	public LeftRib10 getLeftRib10() {
		return leftRib10;
	}

	public void setLeftRib10(LeftRib10 leftRib10) {
		this.leftRib10 = leftRib10;
	}

	public LeftRib8 getLeftRib8() {
		return leftRib8;
	}

	public void setLeftRib8(LeftRib8 leftRib8) {
		this.leftRib8 = leftRib8;
	}

	public LeftRib9 getLeftRib9() {
		return leftRib9;
	}

	public void setLeftRib9(LeftRib9 leftRib9) {
		this.leftRib9 = leftRib9;
	}

	public RightRib10 getRightRib10() {
		return rightRib10;
	}

	public void setRightRib10(RightRib10 rightRib10) {
		this.rightRib10 = rightRib10;
	}

	public RightRib8 getRightRib8() {
		return rightRib8;
	}

	public void setRightRib8(RightRib8 rightRib8) {
		this.rightRib8 = rightRib8;
	}

	public RightRib9 getRightRib9() {
		return rightRib9;
	}

	public void setRightRib9(RightRib9 rightRib9) {
		this.rightRib9 = rightRib9;
	}


}
