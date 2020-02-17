/*
 * Created on Jul 19, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.system.cartilage;

import java.util.ArrayList;

import biomight.Constants;
import biomight.cell.misc.ChondrocyteExtraCellularMatrix;
import biomight.cell.misc.Chondrocytes;
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;

/**
 * @author SurferJim
 *
 * Representation of Cartilage
 * 
 * This is comprised of connective tissue surronded by Matrix material that
 * the cells excrete.  There is a structure that holds it all together and makes
 * it purposeful.
 * 
 */

public class Cartilage extends ConnectiveTissue {
	BioMightSphere bioMightSphere;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private Chondrocytes chondrocytes;
	private ChondrocyteExtraCellularMatrix chondrocyteExtraCellularMatrix;
	
	
	public Cartilage()
	{
		System.out.println("Creating Cartilage object!");
		this.setImage("images/Cartilage.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		//chondrocytes = new Chondrocytes();
		//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();

		initProperties();
		initMethods();
	}

	
	
	/***********************************************************************************
	 * Cartialge Constructor
	 *
	 * Using the DNA sequence, create a collection of cartiledge that conforms to the
	 * sequence.  DNA turns on proteins in each of the cartilage cells having them produce 
	 * the underlying keratin...
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	public Cartilage(String dnaSequence)
	{
		this.setImage("images/Cartilage.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		chondrocytes = new Chondrocytes();
		chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();	
		
		//init3D();
		initProperties();
		initMethods();
	}

	
	/***********************************************************************************
	 * Cartialge Constructor
	 *
	 * Using the DNA sequence, create a collection of cartiledge that conforms to the
	 * sequence.  DNA turns on proteins in each of the cartilage cells having them produce 
	 * the underlying keratin...
	 * 
	 * @param dnaSequence
	 **********************************************************************************/

	public Cartilage(BioMightPosition bioMightPosition, BioMightColor bioMightColor, double radius)
	{
		System.out.println("Creating Cartilage w position");
		this.setImage("images/Cartilage.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		init3D(bioMightPosition, bioMightColor, radius);
		initProperties();
		initMethods();
	}
	
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * Cartilage can be expressed as a simple 3D object as one is looking at from
	 * the body view.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position, BioMightColor bioMightColor, double radius) {
		
		// Create a Sphere to represent the Cartilage component
		bioMightSphere = new BioMightSphere();
		bioMightSphere.setRadius(radius);

		if (position != null)
		{
			// Set up the origin - translation
			bioMightSphere.getTranslation().setXPos(position.getXPos());
			bioMightSphere.getTranslation().setYPos(position.getYPos());
			bioMightSphere.getTranslation().setZPos(position.getZPos());
			System.out.println("Init3D - Set Cartilage TranslationX: " + position.getXPos());
			System.out.println("Init3D - Set Cartilage TranslationY: " + position.getYPos());
			System.out.println("Init3D - Set Cartilage TranslationZ: " + position.getZPos());
		}
		else
			System.out.println("Cartilage - init3d - position is null!");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1);
		bioMightSphere.getScale().setYPos(1);
		bioMightSphere.getScale().setZPos(1);
		//System.out.println("Init3D - Set Cartilage Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.100);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set Cartilage Transparency...");
		
		// Set up the color of the material
		if (bioMightColor != null)
		{
			bioMightSphere.getMaterial().getDiffuseColor().setRed(bioMightColor.getRed());
			bioMightSphere.getMaterial().getDiffuseColor().setGreen(bioMightColor.getGreen());
			bioMightSphere.getMaterial().getDiffuseColor().setBlue(bioMightColor.getBlue());
		}
		else
		{
			System.out.println("It is NULL COLOR - choosing default from BioMightBase");
			bioMightSphere.getMaterial().getDiffuseColor().setRed(this.bioMightColor.getRed());
			bioMightSphere.getMaterial().getDiffuseColor().setGreen(this.bioMightColor.getGreen());
			bioMightSphere.getMaterial().getDiffuseColor().setBlue(this.bioMightColor.getBlue());			
		}

		//System.out.println("Init3D - Set Cartilage Color...");
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
	 * This method will return the X3D for the Cartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet)
	{
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cartilage.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='Cartilage.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cartilage'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		
		int view = Constants.VIEW_FLOATING;
		String body = "";
		if (view == Constants.VIEW_FLOATING)
		{
			//System.out.println("Getting X3D for endosomeX: " + bioMightSphere.getTranslation().getXPos());
			//System.out.println("Getting X3D for endosomeY: " + bioMightSphere.getTranslation().getYPos());
			//System.out.println("Getting X3D for endosomeZ: " + bioMightSphere.getTranslation().getZPos());
			// Change the height and width based on the displacement.
			body = "<Transform DEF='Cartilage'\n" +
		 		"translation='" + bioMightSphere.getTranslation().getXPos() + " " 
			 				+ bioMightSphere.getTranslation().getYPos() + " "
			 				+ bioMightSphere.getTranslation().getZPos() + "'\n" +
			 	"scale='" 	+ bioMightSphere.getScale().getXPos() + " "
			 				+ bioMightSphere.getScale().getYPos() + " "
			 				+ bioMightSphere.getScale().getZPos() + "'>\n" +
			 	"<Shape DEF='Cartilage'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n" +
			    " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" 	+ bioMightSphere.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 			+ bioMightSphere.getMaterial().getShininess() + "'\n" +
			    "transparency='" 		+ bioMightSphere.getMaterial().getTransparency() + "'\n" +
			    "diffuseColor='" + 
			 	    bioMightSphere.getMaterial().getDiffuseColor().getRed() + " " + 
			 	    bioMightSphere.getMaterial().getDiffuseColor().getGreen() + " " +
			 	    bioMightSphere.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
			 	"</Appearance>\n" +
			 	"<Sphere DEF='CartilageGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightSphere.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n"; 
		}
		else
		{
			body = "";//leftEar.getX3D(true) + rightEar.getX3D(true);  
			System.out.println("Cartilage X3D: " + body);					
		}
		
		
		System.out.println("Cartilage Body X3D: " + body);
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);

		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
}
