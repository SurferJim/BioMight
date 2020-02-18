/*
* Created on Apr 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.skull.cranial;
import java.util.ArrayList;

import biomight.Constants;
import biomight.system.tissue.connective.bone.Bone;
import biomight.system.tissue.connective.bone.BoneTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class RightParietalBone extends Bone {

	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BoneTissue boneTissue;
	
	public RightParietalBone()
	{
		this.setImage("images/RightParietalBone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		boneTissue = new BoneTissue();
		initProperties();
		initMethods();
	}
	

	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bone Tissue");
		property.setCanonicalName(Constants.BoneTissue);
		properties.add(property);		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Bone It");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
		
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Skull
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RightParietalBone.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Right Parietal Bone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = boneTissue.getX3D(true);
		
		System.out.println("RightParietalBone X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}

}
