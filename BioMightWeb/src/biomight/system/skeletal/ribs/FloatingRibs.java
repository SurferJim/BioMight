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
public class FloatingRibs extends Bone {
	private LeftRib11  leftRib11;
	private LeftRib12  leftRib12;
	
	private RightRib11 rightRib11;
	private RightRib12  rightRib12;
	
	public FloatingRibs()
	{
		this.setImage("images/FloatingRibs.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
	
	public FloatingRibs(BioMightPosition bioMightPosition)
	{
		this.setImage("images/FloatingRibs.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Create the Left ribs
		leftRib11 = new LeftRib11(bioMightPosition);
		leftRib12 = new LeftRib12(bioMightPosition);

		// Create the Left ribs
		rightRib11 = new RightRib11(bioMightPosition);
		rightRib12 = new RightRib12(bioMightPosition);	
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the FloatingRibs
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FloatingRibs.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FloatingRibs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =   
			leftRib11.getX3D(true) + 
			leftRib12.getX3D(true) + 
			rightRib11.getX3D(true) +
			rightRib12.getX3D(true);
		
		System.out.println("True Ribs X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
}
