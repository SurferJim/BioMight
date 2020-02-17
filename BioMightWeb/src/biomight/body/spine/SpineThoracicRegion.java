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
import biomight.system.skeletal.spine.ThoracicVertebraT1;
import biomight.system.skeletal.spine.ThoracicVertebraT10;
import biomight.system.skeletal.spine.ThoracicVertebraT11;
import biomight.system.skeletal.spine.ThoracicVertebraT12;
import biomight.system.skeletal.spine.ThoracicVertebraT2;
import biomight.system.skeletal.spine.ThoracicVertebraT3;
import biomight.system.skeletal.spine.ThoracicVertebraT4;
import biomight.system.skeletal.spine.ThoracicVertebraT5;
import biomight.system.skeletal.spine.ThoracicVertebraT6;
import biomight.system.skeletal.spine.ThoracicVertebraT7;
import biomight.system.skeletal.spine.ThoracicVertebraT8;
import biomight.system.skeletal.spine.ThoracicVertebraT9;
import biomight.system.skeletal.spine.ThoracicVertebrae;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the SpineThoracicRegion
 * 
 */

public class SpineThoracicRegion extends BioMightBase {	
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightTransforms bioMightTransforms;
	private ThoracicVertebrae thoracicVertebra; 
	private ArrayList cervicalVertebrae;
	
	
	private ThoracicVertebraT1 thoracicVertebraT1;
	private ThoracicVertebraT2 thoracicVertebraT2;
	private ThoracicVertebraT3 thoracicVertebraT3;
	private ThoracicVertebraT4 thoracicVertebraT4;
	private ThoracicVertebraT5 thoracicVertebraT5;
	private ThoracicVertebraT6 thoracicVertebraT6;
	private ThoracicVertebraT7 thoracicVertebraT7;
	private ThoracicVertebraT8 thoracicVertebraT8;
	private ThoracicVertebraT9 thoracicVertebraT9;
	private ThoracicVertebraT10 thoracicVertebraT10;
	private ThoracicVertebraT11 thoracicVertebraT11;
	private ThoracicVertebraT12 thoracicVertebraT12;
	
	
	public SpineThoracicRegion()
	{
		this.setImage("images/SpineThoracicRegion.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		initProperties();
		initMethods();
	}

	
	public SpineThoracicRegion(BioMightPosition bioMightPosition)
	{
		this.setImage("images/SpineThoracicRegion.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300); 

		System.out.println("Creating the ThoracicVertebraT1 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT1 = new ThoracicVertebraT1(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT1 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT2 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT2 = new ThoracicVertebraT2(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT2 at Position: " + bioMightPosition.getXPos());
	
		System.out.println("Creating the ThoracicVertebraT3 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT3 = new ThoracicVertebraT3(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT3 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT4 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT4 = new ThoracicVertebraT4(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT4 at Position: " + bioMightPosition.getXPos());
		
		System.out.println("Creating the ThoracicVertebraT5 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT5 = new ThoracicVertebraT5(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT5 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT6 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT6 = new ThoracicVertebraT6(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT6 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT7 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT7 = new ThoracicVertebraT7(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT7 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT8 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT8 = new ThoracicVertebraT8(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT8 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT9 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT9 = new ThoracicVertebraT9(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT9 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT10 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT10 = new ThoracicVertebraT10(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT10 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT11 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT11 = new ThoracicVertebraT11(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT11 at Position: " + bioMightPosition.getXPos());

		System.out.println("Creating the ThoracicVertebraT12 at Position: " + bioMightPosition.getXPos());
		thoracicVertebraT12 = new ThoracicVertebraT12(bioMightPosition);
		System.out.println("Created the ThoracicVertebraT12 at Position: " + bioMightPosition.getXPos());

		
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
		
		// Assemble the SpineThoracicRegion
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SpineThoracicRegion.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SpineThoracicRegion'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting SpineThoracicRegion X3D");	
		String body = 
			thoracicVertebraT1.getX3D(true) + thoracicVertebraT2.getX3D(true) +
			thoracicVertebraT3.getX3D(true) + thoracicVertebraT4.getX3D(true) + 
		  	thoracicVertebraT5.getX3D(true) + thoracicVertebraT6.getX3D(true) +
		  	thoracicVertebraT7.getX3D(true) + thoracicVertebraT8.getX3D(true) +
		  	thoracicVertebraT9.getX3D(true) + thoracicVertebraT10.getX3D(true) +
		  	thoracicVertebraT11.getX3D(true) + thoracicVertebraT12.getX3D(true);
		System.out.println("SpineThoracicRegion X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
