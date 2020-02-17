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
import biomight.system.skeletal.spine.CoccygealVertebra1;
import biomight.system.skeletal.spine.CoccygealVertebra2;
import biomight.system.skeletal.spine.CoccygealVertebra3;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of the Coccyx
 * 
 */
public class Coccyx extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	CoccygealVertebra1 coccygealVertebra1;
	CoccygealVertebra2 coccygealVertebra2;
	CoccygealVertebra3 coccygealVertebra3;	
	
	public Coccyx()
	{
		this.setImage("images/Coccyx.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		initProperties();
		initMethods();
	}
	
	
	public Coccyx(BioMightPosition bioMightPosition)
	{
		this.setImage("images/Coccyx.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		coccygealVertebra1 = new CoccygealVertebra1(bioMightPosition);
		coccygealVertebra2 = new CoccygealVertebra2(bioMightPosition);
		coccygealVertebra3 = new CoccygealVertebra3(bioMightPosition);	
		
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
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
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
		
		// Assemble the Coccyx
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Coccyx.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Coccyx'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			coccygealVertebra1.getX3D(true) +
			coccygealVertebra2.getX3D(true) +
			coccygealVertebra3.getX3D(true);
		
		System.out.println("Coccyx X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
