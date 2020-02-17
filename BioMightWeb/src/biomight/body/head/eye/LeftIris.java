/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import java.util.ArrayList;

import biomight.Constants;
import biomight.cell.epithelial.AmacrineCell;
import biomight.cell.neuron.BiPolarCell;
import biomight.cell.neuron.HorizontalCell;
import biomight.cell.neuronglial.GanglionicCell;
import biomight.chemistry.protein.*;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.tissue.connective.*;
import biomight.system.tissue.connective.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
 
 /*
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
public class LeftIris extends Iris{
	BioMightSphere bioMightSphere;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private Fibrin fibrin;
	private ReticularConnectiveTissue reticularConnectiveTissue;
	
	public LeftIris()
	{
		this.setImage("images/LeftIris.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		initProperties();
		initMethods();
	}
	
	public LeftIris(BioMightPosition bioMightPosition)
	{
		this.setImage("images/LeftIris.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		/*int viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("LeftIris Eye is created");
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
		}
		*/
		System.out.println("Creating the LeftIris at Position: " + bioMightPosition.getXPos());
		init3D(bioMightPosition);
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
	
	
	/***************************************************************************
	 * Initialize the LeftIris in 3D
	 * 
	 * @param position
	 **************************************************************************/
	public void init3D(BioMightPosition position) {
		
		// Create a Sphere to represent the LeftIris
		bioMightSphere = new BioMightSphere();
		bioMightSphere.setRadius(25.00);

		if (position != null)
		{
			// Set up the origin - translation
			bioMightSphere.getTranslation().setXPos(position.getXPos());
			bioMightSphere.getTranslation().setYPos(position.getYPos());
			bioMightSphere.getTranslation().setZPos(position.getZPos());
			System.out.println("Init3D - Set LeftIris TranslationX: " + position.getXPos());
			System.out.println("Init3D - Set LeftIris TranslationY: " + position.getYPos());
			System.out.println("Init3D - Set LeftIris TranslationZ: " + position.getZPos());
		}
		else
			System.out.println("LeftIris - init3d - position is null!");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1);
		bioMightSphere.getScale().setYPos(1);
		bioMightSphere.getScale().setZPos(1);
		//System.out.println("Init3D - Set LeftIris Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.100);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set LeftIris Transparency...");
		
		// Set up the color of the material
		bioMightSphere.getMaterial().getDiffuseColor().setRed(0.0);
		bioMightSphere.getMaterial().getDiffuseColor().setGreen(0.0);
		bioMightSphere.getMaterial().getDiffuseColor().setBlue(1.0);
		//System.out.println("Init3D - Set LeftIris Color...");
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the LeftIris
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LeftIris.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LeftIris'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		int view = Constants.VIEW_FLOATING;
		String body = "";
		if (view == Constants.VIEW_FLOATING)
		{
			//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
			//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
			//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
			// Change the height and width based on the displacement.
			body = "<Transform DEF='LeftIris'\n" +
		 		"translation='" + bioMightSphere.getTranslation().getXPos() + " " 
			 					+ bioMightSphere.getTranslation().getYPos() + " "
			 					+ bioMightSphere.getTranslation().getZPos() + "'\n" +
			 	"scale='" 	+ bioMightSphere.getScale().getXPos() + " "
			 				+ bioMightSphere.getScale().getYPos() + " "
			 				+ bioMightSphere.getScale().getZPos() + "'>\n" +
			 	"<Shape DEF='LeftIris'\n" +
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
			 	"<Sphere DEF='LeftIrisGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightSphere.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n"; 
		}
		else
		{
			body = "";//						
		}
		
		System.out.println("LeftIris X3D: " + body);	
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
