/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.arm;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.elements.Carbons;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the MiddleCollateral Artery
 ************************************************************************************/

public class MiddleCollateralArtery extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	protected EndotheliumTissue endothelium;
	
	
	public MiddleCollateralArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}

	public MiddleCollateralArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public MiddleCollateralArtery(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/MiddleCollateralArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.viewPerspective = localVP;
		this.lod = localLOD;
		

		// Build the model based on what you are looking based on LOD
		// If called from the Arm, it will be getting the data
		// If called from the MiddleCollateralArteries, it will not have to get data
		// If called from Drill-down, it needs to select by componnent
		if (viewPerspective == Constants.VIEW_DETACHED)			
		{
			System.out.println("In Create MiddleCollateralArtery - DETACHED VIEW");   	

			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(componentID, componentID);
			}
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting MiddleCollateralArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.MiddleCollateralArteryRef, parentID);
				System.out.println("Have MiddleCollateralArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - MiddleCollateralArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of MiddleCollateralArterys and build them into the model
			// In the default case, we get one instance of the MiddleCollateralArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("MiddleCollateralArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created MiddleCollateralArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
						
				System.out.println("Creating MiddleCollateralArtery Endothelium: " + bioMightTransform.getId());				
				endothelium = new EndotheliumTissue("MiddleCollateralArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("MiddleCollateralArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		//
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In MiddleCollateralArtery Create() - ViewInternal - Already Set from: " + parentID);				

			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			
			// We already have the data for the current instance of MiddleCollateralArtery,
			// Go get the details for the current MiddleCollateralArtery is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				// Go get the finer details of the MiddleCollateralArtery				
				System.out.println("Getting the MiddleCollateralArtery MAG1X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating MiddleCollateralArtery Endothelium: " + parentID);				
				endothelium = new EndotheliumTissue("MiddleCollateralArteryEndothelium", parentID, bioMightMethods);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the MiddleCollateralArtery				
				System.out.println("Getting the MiddleCollateralArtery MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating MiddleCollateralArtery Endothelium: " + parentID);				
				endothelium = new EndotheliumTissue("MiddleCollateralArteryEndothelium", parentID, bioMightMethods);
			}

			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			//***************************************************************
			//***************************************************************
			// HACK!!!!!
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a MiddleCollateralArtery directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye MiddleCollateralArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have MiddleCollateralArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - MiddleCollateralArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of MiddleCollateralArtery and build them into the model
			// In the default case, we get one instance of the MiddleCollateralArtery for each Arm
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("MiddleCollateralArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the MiddleCollateralArtery
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating MiddleCollateralArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating MiddleCollateralArtery at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					System.out.println("Creating MiddleCollateralArtery Endothelium: " + parentID);				
					endothelium = new EndotheliumTissue("MiddleCollateralArteryEndothelium", parentID, bioMightMethods);

					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the MiddleCollateralArtery				
					System.out.println("Creating MiddleCollateralArtery at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating MiddleCollateralArtery -HawkEye 2X -  Endothelium: " + parentID);				
					endothelium = new EndotheliumTissue("MiddleCollateralArteryEndothelium", parentID, bioMightMethods);
				}
				
			}			
		}
		
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateMiddleCollateralArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING MiddleCollateralArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
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

	

	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the MiddleCollateralArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the MiddleCollateralArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double radius = 0.0525;
		
			// MiddleCollateralArtery
			if (componentID.equals("MiddleCollateralArtery:01")) 
			{	
				// Generate the MiddleCollateralArteryEndothelium of the neck
				// Create 5 sections
				double[] startPos = {10.505, -17.30, -1.64};		  	
			  	//double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
			
				System.out.println("Calling Generate MiddleCollateralArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateMiddleCollateralArtery("MiddleCollateralArteryEndothelium:00001", "MiddleCollateralArteryEndothelium", 
					"MiddleCollateralArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("MiddleCollateralArtery:02")) 
			{	
				double[] startPos = {-10.505, -17.30, -1.64};		  	
			  	//double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
	
				System.out.println("Calling Generate MiddleCollateralArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateMiddleCollateralArtery("MiddleCollateralArteryEndothelium:00160", "MiddleCollateralArteryEndothelium", 
					"MiddleCollateralArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate MiddleCollateralArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created MiddleCollateralArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MiddleCollateralArteryEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the MiddleCollateralArtery.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the MiddleCollateralArtery
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='MiddleCollateralArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='MiddleCollateralArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting MiddleCollateralArtery X3D: ");	
		
		String body = "";

		if (viewPerspective == Constants.VIEW_DETACHED){
			System.out.println("Getting MiddleCollateralArtery X3D: VIEW_DETACHED ");
			String sensor= "<TouchSensor DEF='StartMiddleCollateralArtery' \n" +
		                   " description='MiddleCollateral Artery'\n" +
			               " containerField='children'/> \n";
			
			//body = "<GROUP>" +
			//	endothelium.getX3D(true) + 	sensor +
			//	"</GROUP>";
			
			body =
					endothelium.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL){
			System.out.println("Getting MiddleCollateralArtery X3D:   VIEW_INTERNAL  ");
			String sensor= "<TouchSensor DEF='StartMiddleCollateralArtery' \n" +
		                   " description='MiddleCollateral Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
					endothelium.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE){
			
			String sensor= "<TouchSensor DEF='StartMiddleCollateralArtery' \n" +
		                   " description='MiddleCollateral Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
				endothelium.getX3D(true);
			
		}
		// We draw at this level -- need to add an algorithm that draws it as cylinders interlocking
		else if (viewPerspective == Constants.VIEW_FLOATING)
		{
			// Run through the collection of MiddleCollateralArtery  and build them into the model
			// In the default case, we get one instance of the MiddleCollateralArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the MiddleCollateralArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting MiddleCollateralArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for MiddleCollateralArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for MiddleCollateralArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for MiddleCollateralArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='MiddleCollateralArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='MiddleCollateralArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='MiddleCollateralArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='MiddleCollateralArtery _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartMiddleCollateralArtery' \n" +
					      " description='MiddleCollateral Artery'\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n" +
				 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				 "key='0 .5 1'\n" +
				 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='MiddleCollateralArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("MiddleCollateralArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
