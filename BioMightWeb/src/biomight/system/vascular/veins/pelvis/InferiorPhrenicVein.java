/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.pelvis;

import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the AxillaryArtery
 */

public class InferiorPhrenicVein extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public InferiorPhrenicVein()
	{
		create(Constants.AxillaryArtery, null);
	}

	public InferiorPhrenicVein(String parentID)
	{
		create(parentID, null);
	}
	
	public InferiorPhrenicVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	/******************************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *****************************************************************************/
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/AxillaryArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		componentID=parentID;
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{
			// Generate the SubclavianVein Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating AxillaryArtery Endothelium: " + parentID);				
			endothelium = new EndotheliumTissue("AxillaryArteryEndothelium", parentID, bioMightMethods);
			initProperty("AxillaryArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
		
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting AxillaryArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.AxillaryArteryRef, parentID);
				System.out.println("Have AxillaryArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AxillaryArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
				
			// Run through the collection of AxillaryArterys and build them into the model
			// In the default case, we get one instance of the AxillaryArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("AxillaryArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created AxillaryArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating AxillaryArtery Endothelium: " + bioMightTransform.getId());				
				endothelium = new EndotheliumTissue("AxillaryArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("AxillaryArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if 
				{				
					// Create the components of the curvature

				}*/
			}
		
		}
		else
		{}
		
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateAxillaryArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING AxillaryArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/********************************************************************************
	 * GENERATE the AxillaryArteryEndothelium
	 * @param parentID
	 * @param componentID
	 ********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the AxillaryArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AxillaryArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.125;
		
			
			if (parentID.equals("AxillaryArtery:01")) 
			{	
				// Generate the AxillaryArteryEndothelium
				// Create 5 sections
				double[] startPos = {3.00,-8.00, -4.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				
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

	
				System.out.println("Calling Generate AxillaryArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateAxillaryArtery("AxillaryArteryEndothelium:00001", "AxillaryArteryEndothelium", 
					"AxillaryArteryEndothelium", componentID, parentID, currentPoints);			
					
			}			
			else if (parentID.equals("AxillaryArtery:02")) 
			{	
				// Generate the AxillaryArteryEndothelium
				// Create 5 sections
				double[] startPos = {-3.00,-7.75, -4.0};
				
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
	
				System.out.println("Calling Generate AxillaryArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateAxillaryArtery("AxillaryArteryEndothelium:00160", "AxillaryArteryEndothelium", 
					"AxillaryArteryEndothelium", componentID, parentID, currentPoints);							
			}
	

			System.out.println("Created AxillaryArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AxillaryArteryEndothelium");
			throw new ServerException("Remote Exception AxillaryArteryEndothelium():", e); 	
		}
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AxillaryArteryEndothelium");
		property.setCanonicalName(Constants.AxillaryArtery);
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
	 * This method will return the X3D for the AxillaryArtery.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the AxillaryArtery
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AxillaryArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AxillaryArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING){
			
			String sensor= "<TouchSensor DEF='StartAxillaryArtery' \n" +
		                   " description='Axillary Artery'\n" +
			               " containerField='children'/> \n";
			
			//body = "<GROUP>" +
			body=endothelium.getX3D(true);
			//	"</GROUP>";
			
		}
		else if (view == Constants.VIEW_DETACHED)
		{
			// Run through the collection of AxillaryArtery  and build them into the model
			// In the default case, we get one instance of the AxillaryArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the AxillaryArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting AxillaryArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for AxillaryArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for AxillaryArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for AxillaryArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='AxillaryArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='AxillaryArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='AxillaryArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='AxillaryArtery _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartAxillaryArtery' \n" +
					      " description='Axillary Artery'\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n" +
				 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				 "key='0 .5 1'\n" +
				 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='AxillaryArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("AxillaryArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
}
