/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.compound.Granzymes;
import biomight.chemistry.compound.Perforins;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomightweb.view.BioMightViewPoint;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EndoPlasmicReticulumRough extends BioMightBase{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightSphere bioMightSphere;
	//private BioMightViewpoint bioMightViewpoint;
	
	
	public EndoPlasmicReticulumRough()
	{
		this.setImage("images/EndoPlasmicReticulumRough.jpg");
		
		
		initProperties();
		initMethods();
		init3D(null);
	}

	public EndoPlasmicReticulumRough(BioMightPosition position)
	{
		this.setImage("images/EndoPlasmicReticulumRough.jpg");
		
		initProperties();
		initMethods();
		init3D(position);
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
		bioMightSphere.setRadius(1.75);

		// Set up the origin - translation
		bioMightSphere.getTranslation().setXPos(position.getXPos());
		bioMightSphere.getTranslation().setYPos(position.getYPos());
		bioMightSphere.getTranslation().setZPos(position.getZPos());
		System.out.println("Init3D - Rough ER- Set Translation...");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1.6);
		bioMightSphere.getScale().setYPos(1.4);
		bioMightSphere.getScale().setZPos(1.6);
		//System.out.println("Init3D - Set Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.200);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set Transparency...");
		
		// Set up the color of the material
		bioMightSphere.getMaterial().getDiffuseColor().setRed(0.69);
		bioMightSphere.getMaterial().getDiffuseColor().setGreen(0.47);
		bioMightSphere.getMaterial().getDiffuseColor().setBlue(0.46);
		//System.out.println("Init3D - Set Color...");

		}
		
		
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Cholesterol");
		property.setCanonicalName(Constants.Cholesterol);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PhosphoLipids");
		property.setCanonicalName(Constants.PhosphoLipids);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Lyse");
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
		
		// Assembe the Cell Membrane
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\"> " +
		"<X3D profile='Immersive' >" +
		"<head>" +
		 "<meta name='BioMightImage' content='EndoPlasmicReticulumRough.jpg'/>" +
		 "<meta name='ExportTime' content='7:45:30'/>" +
		 "<meta name='ExportDate' content='08/15/2008'/>" +
		 "<meta name='BioMight Version' content='1.0'/>" + 
		 "<meta name='FluxStudioSource' content='EndoPlasmicReticulumRough.fxw'/>" +
		"</head>" +
		"<Scene>" +
		"<WorldInfo" +
		"title='EndoPlasmicReticulumRough'" +
		"info='\"BioMight Generated X3D\">";
		
		String body = "<Transform DEF='EndoPlasmicReticulumRough'\n" +
		 "translation='" + bioMightSphere.getTranslation().getXPos() + " " 
		 				 + bioMightSphere.getTranslation().getYPos() + " "
		 				 + bioMightSphere.getTranslation().getZPos() + "'\n" +
		 "scale='" + bioMightSphere.getScale().getXPos() + " "
		 		   + bioMightSphere.getScale().getYPos() + " "
		 		   + bioMightSphere.getScale().getZPos() + "'>\n" +
		 "<Shape DEF='EndoPlasmicReticulumRough'\n" +
		 " containerField='children'>\n" +
		 " <Appearance\n" +
		 "  containerField='appearance'>\n" +
		 " <Material DEF='Rust'\n" +
		    "containerField='material'\n" +
		    "ambientIntensity='" + bioMightSphere.getMaterial().getAmbientIntensity() + "'\n" +
		    "shininess='" + bioMightSphere.getMaterial().getShininess() + "'\n" +
		    "transparency='" + bioMightSphere.getMaterial().getTransparency() + "'\n" +
		    "diffuseColor='" + 
		    	bioMightSphere.getMaterial().getDiffuseColor().getRed() + " " + 
		    	bioMightSphere.getMaterial().getDiffuseColor().getGreen() + " " +
		    	bioMightSphere.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
		  "</Appearance>\n" +
		  "<Sphere DEF='GeoSphere'\n" +
		   "containerField='geometry'\n" +
		   "radius='" + bioMightSphere.getRadius() +"'/>\n" +
		 "</Shape>\n" +
		"</Transform>\n";
		
		
		String footer = "</Scene>" + "</X3D>";

		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Perforins)
		{
			// Form a channel through the cell membrane
			// this leads to loss of cell contents and death
		}

		if (obj instanceof Granzymes)
		{
			// Protease that degrades the proteins in the cell membrane
			// leading to rupture and loss of cell contents
			// If there are enough of them, a=]nd the time is sustained, then
			// theoretically, the reactions should take place.
			// Lyse the membrane
		}
	}


	public void rupture()
	{
		// Rupture open a hole in the membrane at the point of most weakness
		
	}
	
	public void setVoltageGradient()
	{
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}
	
}
