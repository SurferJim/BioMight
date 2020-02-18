/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.chest;

import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.veins.Vein;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SmallCardiacVein extends Vein  {
	protected EndotheliumTissue endothelium;
	
	
	public SmallCardiacVein()
	{
		create(Constants.SmallCardiacVein, null);
	}

	public SmallCardiacVein(String parentID)
	{
		create(parentID, null);
	}
	
	public SmallCardiacVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SmallCardiacVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SmallCardiacVeinInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SmallCardiacVeinRef, parentID);
			System.out.println("Have SmallCardiacVein Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SmallCardiacVein");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection of SmallCardiacVeins and build them into the model
		// In the default case, we get one instance of the SmallCardiacVein for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("SmallCardiacVein NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created SmallCardiacVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the Small Cardiac Vein
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			System.out.println("Creating SmallCardiacVein Endothelium: " + bioMightTransform.getId());				
			endothelium = new EndotheliumTissue("SmallCardiacVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
			initProperty("SmallCardiacVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateSmallCardiacVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING SmallCardiacVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	

	/**********************************************************************************************
	 * GENERATE SMALL CARDIAC VEIN
	 * 
	 * Comprised  
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the SmallCardiacVein		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SmallCardiacVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.125;
		
			
			if (componentID.equals("SmallCardiacVein:01")) 
			{	
				// Generate the SmallCardiacVein 
				// Create 5 sections
				double[] startPos = {-0.25,-12.0, -4.75};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];
				
				double[][] currentPoints = { 
		    			{x, y, z},
		    	 		{x-circumference,     y, z-circumference},
		    	   		{x-circumference,     y, z-circumference*2},
		    	   		{x,                   y, z-circumference*3},
		    	   		{x+circumference,     y, z-circumference*3},
		    	   		{x+(circumference*2), y, z-circumference*2},
		    	   		{x+(circumference*2),     y, z-circumference},
		    	  		{x+circumference, y, z}
		    	   		};
	
				System.out.println("Calling Generate SmallCardiacVein: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSmallCardiacVein("SmallCardiacVeinEndothelium:00001", "SmallCardiacVeinEndothelium", 
					"SmallCardiacVeinEndothelium", componentID, parentID, currentPoints);			
					
			}			
			else 
			{	
				// Generate the SmallCardiacVeinEndothelium 
				// Create 5 sections
				double[] startPos = {-0.25,-12.0, -5.25};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				// Runs side to side
				double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};
	
				System.out.println("Calling Generate SmallCardiacVeinEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSmallCardiacVein("SmallCardiacVeinEndothelium:00160", "SmallCardiacVeinEndothelium", 
					"SmallCardiacVeinEndothelium", componentID, parentID, currentPoints);							
			}
			
			System.out.println("Created SmallCardiacVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SmallCardiacVeinEndothelium");
			throw new ServerException("Remote Exception SmallCardiacVeinEndothelium():", e); 	
		}
	}
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
	
	}
		 					
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the SmallCardiacVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the SmallCardiacVein
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SmallCardiacVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SmallCardiacVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING){
			
			String sensor= "<TouchSensor DEF='StartSmallCardiacVein' \n" +
		                   " description='Conus Artery'\n" +
			               " containerField='children'/> \n";			
			
			//body = "<GROUP>" +
			//	endothelium.getX3D(true) + 	sensor +
			//	"</GROUP>";
			
			body = endothelium.getX3D(true);
		}
		else if (view == Constants.VIEW_DETACHED)
		{
			// Run through the collection of SmallCardiacVein  and build them into the model
			// In the default case, we get one instance of the SmallCardiacVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the SmallCardiacVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting SmallCardiacVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for SmallCardiacVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for SmallCardiacVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for SmallCardiacVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='SmallCardiacVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='SmallCardiacVein Shape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='SmallCardiacVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='SmallCardiacVein _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartSmallCardiacVein' \n" +
					      " description='Conus Artery'\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n" +
				 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				 "key='0 .5 1'\n" +
				 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='SmallCardiacVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("SmallCardiacVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
