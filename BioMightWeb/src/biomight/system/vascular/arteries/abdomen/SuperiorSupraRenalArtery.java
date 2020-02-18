/*
 * Created on August 17, 2016
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
 * Representatoin of the SuperiorSupraRenalArtery
 * 
 */

public class SuperiorSupraRenalArtery extends Artery {
protected EndotheliumTissue endothelium;
	
	
	public SuperiorSupraRenalArtery()
	{
		create(Constants.SuperiorSupraRenalArtery, null);
	}

	public SuperiorSupraRenalArtery(String parentID)
	{
		create(parentID, null);
	}
	
	public SuperiorSupraRenalArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
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
		
			
			System.out.println("Creating SuperiorSupraRenalArtery Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("SuperiorSupraRenalArteryEndothelium", parentID,bioMightMethods);
			initProperty("SuperiorSupraRenalArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting SuperiorSupraRenalArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.SuperiorSupraRenalArteryRef, parentID);
				System.out.println("Have SuperiorSupraRenalArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SuperiorSupraRenalArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of SuperiorSupraRenalArterys and build them into the model
			// In the default case, we get one instance of the SuperiorSupraRenalArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("SuperiorSupraRenalArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created SuperiorSupraRenalArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating SuperiorSupraRenalArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("SuperiorSupraRenalArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("SuperiorSupraRenalArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateSuperiorSupraRenalArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING SuperiorSupraRenalArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/*****
	 * 
	 * Generate the SuperiorSupraRenalArtery
	 * @param parentID
	 * @param componentID
	 */
	
	public void generate(String parentID, String componentID)
	{
		// Generate the CysticArtery Edothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double radius = 0.050;
		
			
			if (parentID.equals("SuperiorSupraRenalArtery:01")) 
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.25, -20.20, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00001", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);			
					
			}			
			else if (parentID.equals("SuperiorSupraRenalArtery:02"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.35, -19.90, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00120", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			else if (parentID.equals("SuperiorSupraRenalArtery:03"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.45, -19.70, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00240", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			else if (parentID.equals("SuperiorSupraRenalArtery:04"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.50, -19.40, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00360", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			else if (parentID.equals("SuperiorSupraRenalArtery:05"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {1.51, -19.10, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
			
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00480", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			

			//*****************************************
			// Right Side
			//*****************************************
			else if (parentID.equals("SuperiorSupraRenalArtery:06"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.00, -20.40, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
			
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00620", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			
			else if (parentID.equals("SuperiorSupraRenalArtery:07"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.15, -20.20, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00740", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			else if (parentID.equals("SuperiorSupraRenalArtery:08"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.18, -19.90, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:00960", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}
			else if (parentID.equals("SuperiorSupraRenalArtery:09"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.40, -19.50, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:01200", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}			
			else if (parentID.equals("SuperiorSupraRenalArtery:10"))
			{	
				// Generate the SuperiorSupraRenalArteryEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-1.40, -19.20, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SuperiorSupraRenalArteryEndothelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSuperiorSupraRenalArtery("SuperiorSupraRenalArteryEndothelium:01400", "SuperiorSupraRenalArteryEndothelium", 
					"SuperiorSupraRenalArteryEndothelium", componentID, parentID, currentPoints);							
			}	

			
			System.out.println("Created SuperiorSupraRenalArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SuperiorSupraRenalArteryEndothelium");
			throw new ServerException("Remote Exception SuperiorSupraRenalArteryEndothelium():", e); 	
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
	 * This method will return the X3D for the SuperiorSupraRenalArtery.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the SuperiorSupraRenalArtery
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SuperiorSupraRenalArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SuperiorSupraRenalArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of SuperiorSupraRenalArtery  and build them into the model
			// In the default case, we get one instance of the SuperiorSupraRenalArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the SuperiorSupraRenalArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting SuperiorSupraRenalArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for SuperiorSupraRenalArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for SuperiorSupraRenalArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for SuperiorSupraRenalArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='SuperiorSupraRenalArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='SuperiorSupraRenalArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='SuperiorSupraRenalArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='SuperiorSupraRenalArtery _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='SuperiorSupraRenalArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("SuperiorSupraRenalArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
}
