/*
 * Created on Jul 18, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
package biomight.body.spine;

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.skeletal.spine.LumbarVertebrae;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SpineLumbarRegion extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private LumbarVertebrae lumbarVertebrae;
	
	
	public SpineLumbarRegion()
	{
		this.setImage("images/SpineLumbarRegion.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		LumbarVertebrae lumbarVertebrae = new LumbarVertebrae();
		
		initProperties();
		initMethods();
	}

	public SpineLumbarRegion(BioMightPosition bioMightPosition)
	{
		this.setImage("images/SpineLumbarRegion.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		LumbarVertebrae lumbarVertebrae = new LumbarVertebrae();
		
		initProperties();
		initMethods();
	}
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {
		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Fracture");
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
		
		// Assemble the SpineLumbarRegion
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SpineLumbarRegion.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SpineLumbarRegion'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = lumbarVertebrae.getX3D(true);; 
		System.out.println("SpineLumbarRegion X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
