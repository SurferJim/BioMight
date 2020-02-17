/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import java.util.ArrayList;

import biomight.cell.filaments.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.BioMightBase;
import biomight.Constants;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Centriole extends BioMightBase{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightSphere bioMightSphere;
	private MicroTubuleBlade microTubuleBlade1;
	private MicroTubuleBlade microTubuleBlade2;
	private MicroTubuleBlade microTubuleBlade3;
	private MicroTubuleBlade microTubuleBlade4;
	private MicroTubuleBlade microTubuleBlade5;
	private MicroTubuleBlade microTubuleBlade6;
	private MicroTubuleBlade microTubuleBlade7;
	private MicroTubuleBlade microTubuleBlade8;
	private MicroTubuleBlade microTubuleBlade9;
	
	
	public Centriole()
	{
		this.setImage("images/Centriole.jpg");

		initProperties();
		initMethods();
		init3D(null);
	}

	public Centriole(BioMightPosition position)
	{
		this.setImage("images/Centriole.jpg");

		initProperties();
		initMethods();
		init3D(position);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade1");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade2");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade3");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade4");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade5");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade6");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade7");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MicroTubuleBlade8");
		property.setCanonicalName(Constants.MicroTubuleBlade);
		properties.add(property);
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Expel Contents");
		method.setHtmlType("text");
		methods.add(method);


	}
	
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
		
		// Create a Sphere to represent the membrane
		// Its scale is defined such that the object is flattened
		bioMightSphere = new BioMightSphere();
		bioMightSphere.setRadius(0.25);

		if (position != null)
		{
			// Set up the origin - translation
			bioMightSphere.getTranslation().setXPos(position.getXPos());
			bioMightSphere.getTranslation().setYPos(position.getYPos());
			bioMightSphere.getTranslation().setZPos(position.getZPos());
			System.out.println("Init3D - Set Centriole TranslationX: " + position.getXPos());
			System.out.println("Init3D - Set Centriole TranslationY: " + position.getYPos());
			System.out.println("Init3D - Set Centriole TranslationZ: " + position.getZPos());
		}
		else
			System.out.println("Centriole - init3d - position is null!");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1);
		bioMightSphere.getScale().setYPos(1);
		bioMightSphere.getScale().setZPos(1);
		//System.out.println("Init3D - Set Centriole Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.100);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set Centriole Transparency...");
		
		// Set up the color of the material
		bioMightSphere.getMaterial().getDiffuseColor().setRed(.5);
		bioMightSphere.getMaterial().getDiffuseColor().setGreen(.5);
		bioMightSphere.getMaterial().getDiffuseColor().setBlue(.25);
		//System.out.println("Init3D - Set Centriole Color...");
	}

	public ArrayList getProperties() {
		return properties;
	}
	

	public ArrayList getMethods() {		
		return methods;
	}

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet)
	{
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Centriole.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='Centriole.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		//System.out.println("Getting X3D for endosomeX: " + bioMightSphere.getTranslation().getXPos());
		//System.out.println("Getting X3D for endosomeY: " + bioMightSphere.getTranslation().getYPos());
		//System.out.println("Getting X3D for endosomeZ: " + bioMightSphere.getTranslation().getZPos());
		// Change the height and width based on the displacement.
		String body = "<Transform DEF='Centriole'\n" +
		 	"translation='" + bioMightSphere.getTranslation().getXPos() + " " 
			 				+ bioMightSphere.getTranslation().getYPos() + " "
			 				+ bioMightSphere.getTranslation().getZPos() + "'\n" +
			 "scale='" 		+ bioMightSphere.getScale().getXPos() + " "
			 				+ bioMightSphere.getScale().getYPos() + " "
			 				+ bioMightSphere.getScale().getZPos() + "'>\n" +
			 "<Shape DEF='Centriole'\n" +
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
			 "<Sphere DEF='CentrioleGeoSphere'\n" +
			 "containerField='geometry'\n" +
			 "radius='" + bioMightSphere.getRadius() +"'/>\n" +
			 "</Shape>\n" +
			 "</Transform>\n"; 
		
		//System.out.println("Centriole Body X3D: " + body);
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);

		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
