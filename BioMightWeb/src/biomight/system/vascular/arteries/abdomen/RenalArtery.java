/*
 * Created on Jul 23, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.system.vascular.arteries.abdomen;
import java.util.ArrayList;

import javax.naming.InitialContext;




import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the RenalArtery
 * 
 */

public class RenalArtery extends Artery {
protected EndotheliumTissue endothelium;
	
	
	public RenalArtery()
	{
		create(Constants.RenalArtery, null);
	}

	public RenalArtery(String parentID)
	{
		create(parentID, null);
	}
	
	public RenalArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
	
			
			// Generate the GreaterCurvature Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating RenalArtery Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("RenalArteryEndothelium", parentID,bioMightMethods);
			initProperty("RenalArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting RenalArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.RenalArteryRef, parentID);
				System.out.println("Have RenalArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - RenalArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of RenalArterys and build them into the model
			// In the default case, we get one instance of the RenalArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("RenalArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created RenalArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating RenalArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("RenalArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("RenalArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateRenalArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING RenalArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
	
	// generate the DescendingAortaArteryEndothelium
	public void generate(String parentID, String componentID)
	{
		// Generate the Greater Curvature Edothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the RenalArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double radius = 0.125;
		
			
			if (parentID.equals("RenalArtery:01")) 
			{	
				// Generate the DescendingAortaArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {0.20, -21.5, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:00001", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}	
			if (parentID.equals("RenalArtery:02")) 
			{	
				// Generate the DescendingAortaArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.4, -21.5, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:00240", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			
			if (parentID.equals("RenalArtery:03")) 
			{	
				// Generate the DescendingAortaArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.6, -21.5, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:00480", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			
			
			
			else if (parentID.equals("RenalArtery:04")) 
			{	
				// Generate the RenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {0.1, -22.0, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:00720", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
				
			}
			if (parentID.equals("RenalArtery:05")) 
			{	
				// Generate the DescendingAortaArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.20, -22.0, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:00940", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			if (parentID.equals("RenalArtery:06")) 
			{	
				// Generate the DescendingAortaArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.35, -22.0, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate RenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRenalArtery("RenalArteryEndothelium:01020", "RenalArteryEndothelium", 
					"RenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			
			
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate RenalArteryEndothelium NoParent");
							
			}

			
			System.out.println("Created RenalArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RenalArteryEndothelium");
			throw new ServerException("Remote Exception RenalArteryEndothelium():", e); 	
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
	 * This method will return the X3D for the RenalArtery.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the RenalArtery
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RenalArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RenalArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of RenalArtery  and build them into the model
			// In the default case, we get one instance of the RenalArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the RenalArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting RenalArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for RenalArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for RenalArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for RenalArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='RenalArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='RenalArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='RenalArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='RenalArtery _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartStomachBeat' \n" +
						  " containerField='children'/> \n" +
			 "</Transform>\n" +
			 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
			 "key='0 .5 1'\n" +
			 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
			 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
			 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='RenalArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("RenalArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
}
