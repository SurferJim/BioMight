/*
 * Created on May 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class IonChannel extends BioMightBase{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightSphere bioMightSphere;
	
	
	public IonChannel()
	{
		this.setImage("images/IonChannel.jpg");

		initProperties();
		initMethods();
		init3D(null);
	}

	public IonChannel(BioMightPosition position)
	{
		this.setImage("images/IonChannel.jpg");

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
		bioMightSphere.setRadius(0.25);

		if (position != null)
		{
			// Set up the origin - translation
			bioMightSphere.getTranslation().setXPos(position.getXPos());
			bioMightSphere.getTranslation().setYPos(position.getYPos());
			bioMightSphere.getTranslation().setZPos(position.getZPos());
			//System.out.println("Init3D - Set IonChannel TranslationX: " + position.getXPos());
			//System.out.println("Init3D - Set IonChannel TranslationY: " + position.getYPos());
			//System.out.println("Init3D - Set IonChannel TranslationZ: " + position.getZPos());
		}
		else
			System.out.println("IonChannel - init3d - position is null!");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1);
		bioMightSphere.getScale().setYPos(1);
		bioMightSphere.getScale().setZPos(1);
		//System.out.println("Init3D - Set IonChannel Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.100);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set IonChannel Transparency...");
		
		// Set up the color of the material
		bioMightSphere.getMaterial().getDiffuseColor().setRed(0);
		bioMightSphere.getMaterial().getDiffuseColor().setGreen(1);
		bioMightSphere.getMaterial().getDiffuseColor().setBlue(1);
		//System.out.println("Init3D - Set IonChannel Color...");
	}
	

	private void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("IonChannel");
		property.setCanonicalName(Constants.IonChannel);
		properties.add(property);
	}
	

	private void initMethods() {

		methods = new ArrayList<BioMightMethodView>();	
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Pump Rate");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Pump Volume");
		method.setHtmlType("text");
		methods.add(method);
	}


	public ArrayList getProperties() {
		return properties;
	}
	

	public ArrayList getMethods() {		
		return methods;
	}
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and execute the 
		// associated methods
		System.out.println("IonChannel Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {
					//String methodName = (String) methods.get[j]; 
					//System.out.println("Applying " + methods.get(j) + " with arg: "  +  methodParam);
				}
			}
		}
		
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
		 "<meta name='BioMightImage' content='IonChannel.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='IonChannel.fxw'/>\n" +
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
		String body = "<Transform DEF='IonChannel'\n" +
		 	"translation='" + bioMightSphere.getTranslation().getXPos() + " " 
			 				+ bioMightSphere.getTranslation().getYPos() + " "
			 				+ bioMightSphere.getTranslation().getZPos() + "'\n" +
			 "scale='" 		+ bioMightSphere.getScale().getXPos() + " "
			 				+ bioMightSphere.getScale().getYPos() + " "
			 				+ bioMightSphere.getScale().getZPos() + "'>\n" +
			 "<Shape DEF='IonChannel'\n" +
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
			 "<Sphere DEF='IonChannelGeoSphere'\n" +
			 "containerField='geometry'\n" +
			 "radius='" + bioMightSphere.getRadius() +"'/>\n" +
			 "</Shape>\n" +
			 "</Transform>\n"; 
		
		//System.out.println("IonChannel Body X3D: " + body);
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);

		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
}
