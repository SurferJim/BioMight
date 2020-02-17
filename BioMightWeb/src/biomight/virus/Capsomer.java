/*
 * Created on Oct 15, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.virus;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of a Capsomere.  It is composed of proteins.
 * 
 */

public class Capsomer extends BioMightBase{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;	
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;

	
	public Capsomer()
	{		
		// Create hte base Eye
		create(Constants.CapsomerRef, null);
	}
	
	
	public Capsomer(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Capsomer(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Capsomer.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CapsomerInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CapsomerRef, parentID);
			System.out.println("Have Capsomer Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Capsomer");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Capsomers and build them into the model
		// In the default case, we get one instance of the Capsomer for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Capsomer NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Capsomer: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create an instance of the Eye for each tranform specified for the organism
				System.out.println("Creating Eyes using ParentID: " + bioMightTransform.getId());
				eye = new Eye(bioMightTransform.getId());
				System.out.println("Eyes are created");
			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateCapsomer Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PUPIL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 *
	
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
			System.out.println("Init3D - Set Capsomer TranslationX: " + position.getXPos());
			System.out.println("Init3D - Set Capsomer TranslationY: " + position.getYPos());
			System.out.println("Init3D - Set Capsomer TranslationZ: " + position.getZPos());
		}
		else
			System.out.println("Capsomer - init3d - position is null!");
		
		// Set up the scale
		bioMightSphere.getScale().setXPos(1);
		bioMightSphere.getScale().setYPos(1);
		bioMightSphere.getScale().setZPos(1);
		//System.out.println("Init3D - Set Capsomer Scale...");
		
		// Set up the material information 
		bioMightSphere.getMaterial().setAmbientIntensity(0.200);
		bioMightSphere.getMaterial().setShininess(0.100);
		bioMightSphere.getMaterial().setTransparency(0.400);
		//System.out.println("Init3D - Set Capsomer Transparency...");
		
		// Set up the color of the material
		bioMightSphere.getMaterial().getDiffuseColor().setRed(1);
		bioMightSphere.getMaterial().getDiffuseColor().setGreen(1);
		bioMightSphere.getMaterial().getDiffuseColor().setBlue(0);
		//System.out.println("Init3D - Set Capsomer Color...");
	}
	******/
	
	
	

	private void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Capsomer");
		property.setCanonicalName(Constants.Capsomer);
		properties.add(property);
	}
	

	private void initMethods() {

		methods = new ArrayList<BioMightMethodView>();	
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Volumme");
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
		System.out.println("Capsomer Executing Methods");
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
	public String getX3D(boolean snipet) {
		
		// Assembe the Capsomer
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Capsomer.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Capsomer'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		// Run through the collection of Capsomers and build them into the model
		// In the default case, we get one instance of the Capsomer for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the capsomer we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Capsomer: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating Capsomer at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			

			int view = Constants.VIEW_FLOATING;

			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for CapsomerX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CapsomerY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CapsomerZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Capsomer'\n" +
			 		"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='Capsomer'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n" +
				    " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='CapsomerGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n"; 
			}
			else
			{
				body = "";//						
			}
		
	}
		
		System.out.println("Capsomer X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;					
	}
	
}	