/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.head;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the Facial Artery
 *************************************************************************************/


public class FacialArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public FacialArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}

	public FacialArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public FacialArtery(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/FacialArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating FacialArtery Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("FacialArteryEndothelium", parentID,bioMightMethods);
			initProperty("FacialArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting FacialArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.FacialArteryRef, parentID);
				System.out.println("Have FacialArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - FacialArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of FacialArterys and build them into the model
			// In the default case, we get one instance of the FacialArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("FacialArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created FacialArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating FacialArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("FacialArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("FacialArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("Create FacialArtery Completed");
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
		method.setMethodName("Embolize");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Rupture");
		method.setHtmlType("checkbox");
		methods.add(method);
	}


	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the FacialArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the FacialArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.0550;
		
			// Right FacialArtery
			if (componentID.equals("FacialArtery:01")) 
			{	
				// Generate the FacialArteryEndothelium of the neck
				// Create 5 sections
				double[] startPos = {1.68, -4.75, -3.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00001", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Left Facial Artery
			else if (componentID.equals("FacialArtery:02")) 
			{	
				double[] startPos = {1.68, -4.75, -1.35};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00160", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("FacialArtery:03")) 
			{	
				double[] startPos = {1.54, -4.75, -0.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00320", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			
			
			else if (componentID.equals("FacialArtery:04")) 
			{	
				double[] startPos = {-1.68, -4.75, -3.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00520", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (componentID.equals("FacialArtery:05")) 
			{	
				double[] startPos = {-1.68, -4.75, -1.35};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00760", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (componentID.equals("FacialArtery:06")) 
			{	
				double[] startPos = {-1.54, -4.75, -0.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FacialArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFacialArtery("FacialArteryEndothelium:00980", "FacialArteryEndothelium", 
					"FacialArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate FacialArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created FacialArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - FacialArteryEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Femoral Vein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FacialArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FacialArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of FacialArtery  and build them into the model
			// In the default case, we get one instance of the FacialArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the FacialArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting FacialArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for FacialArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for FacialArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for FacialArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='FacialArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='FacialArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='FacialArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='FacialArtery _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='FacialArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("FacialArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
