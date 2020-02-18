package biomight.system.skeletal.hand;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebX3DUtils;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the HandProximalPhalange
 ************************************************************************************/

public class HandProximalPhalange extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	protected Osteocytes osteocytes;
	
	
	public HandProximalPhalange()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}

	public HandProximalPhalange(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public HandProximalPhalange(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/HandProximalPhalange.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.viewPerspective = localVP;
		this.lod = localLOD;
		

		// Build the model based on what you are looking based on LOD
		// If called from the Arm, it will be getting the data
		// If called from the RadialArteries, it will not have to get data
		// If called from Drill-down, it needs to select by componnent
		if (viewPerspective == Constants.VIEW_DETACHED)			
		{
			System.out.println("In Create HandProximalPhalange - DETACHED VIEW");   	
		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HandProximalPhalangeInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.HandProximalPhalangeRef, parentID);
				System.out.println("Have HandProximalPhalange Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - HandProximalPhalange");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of HandProximalPhalanges and build them into the model
			// In the default case, we get one instance of the HandProximalPhalange for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("HandProximalPhalange NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created HandProximalPhalange: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				

				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(componentID, componentID);
				}
				
				System.out.println("Creating HandProximalPhalange Osteocyte: " + bioMightTransform.getId());				
				osteocytes = new Osteocytes("HandProximalPhalangeOsteocyte", bioMightTransform.getId(),bioMightMethods);
				initProperty("HandProximalPhalangeOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());
			}
		}
		//
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In HandProximalPhalange Create() - ViewInternal - Already Set from: " + parentID);				

			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			
			// We already have the data for the current instance of ProximalPhalange,
			// Go get the details for the current ProximalPhalange is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				// Go get the finer details of the ProximalPhalange				
				System.out.println("Getting the HandProximalPhalange MAG1X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating HandProximalPhalange Osteocyte: " + parentID);				
				osteocytes = new Osteocytes("HandProximalPhalangeOsteocyte", parentID, bioMightMethods);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the ProximalPhalange				
				System.out.println("Getting the HandProximalPhalange MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating HandProximalPhalange Osteocyte: " + parentID);				
				osteocytes = new Osteocytes("HandProximalPhalangeOsteocyte", parentID, bioMightMethods);
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
		
			// This is when one is accessing a ProximalPhalange directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye HandProximalPhalangeInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have HandProximalPhalange Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - HandProximalPhalange");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of HandProximalPhalange and build them into the model
			// In the default case, we get one instance of the HandProximalPhalange for each Arm
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("HandProximalPhalange NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the HandProximalPhalange
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating HandProximalPhalange: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating HandProximalPhalange at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					System.out.println("Creating HandProximalPhalange Osteocyte: " + parentID);				
					osteocytes = new Osteocytes("HandProximalPhalangeOsteocyte", parentID, bioMightMethods);

					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the HandProximalPhalange				
					System.out.println("Creating HandProximalPhalange at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating HandProximalPhalange -HawkEye 2X -  Osteocyte: " + parentID);				
					osteocytes = new Osteocytes("HandProximalPhalangeOsteocyte", parentID, bioMightMethods);
				}
				
			}			
		}
		
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateHandProximalPhalange Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING HandProximalPhalange METHODS: " + bioMightMethods.size());
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
		// Generate the HandProximalPhalange Osteocyte		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the HandProximalPhalangeOsteocyte: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.020;
		
			// HandProximalPhalange
			if (componentID.equals("HandProximalPhalange:01")) 
			{	
				// Generate the HandProximalPhalangeOsteocyte of the neck
				// Create 5 sections
				double[] startPos = {9.25, -20.50, -5.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				
				System.out.println("Calling Generate HandProximalPhalangeOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateHandProximalPhalange("HandProximalPhalangeOsteocyte:00001", "HandProximalPhalangeOsteocyte", 
					"HandProximalPhalangeOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("HandProximalPhalange:02")) 
			{	
				double[] startPos = {-9.25, -20.50, -5.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate HandProximalPhalangeOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateHandProximalPhalange("HandProximalPhalangeOsteocyte:00160", "HandProximalPhalangeOsteocyte", 
					"HandProximalPhalangeOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate HandProximalPhalangeOsteocyte NoParent");
							
			}
			
			System.out.println("Created HandProximalPhalangeOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - HandProximalPhalangeOsteocyte");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the HandProximalPhalange.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the HandProximalPhalange
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='HandProximalPhalange .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='HandProximalPhalange '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting HandProximalPhalange X3D: ");	
		
		String body = "";

		if (viewPerspective == Constants.VIEW_DETACHED){
			System.out.println("Getting HandProximalPhalange X3D: VIEW_DETACHED ");
			String sensor= "<TouchSensor DEF='StartHandProximalPhalange' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			//body = "<GROUP>" +
			//	osteocytes.getX3D(true) + 	sensor +
			//	"</GROUP>";
			
			body =
					osteocytes.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL){
			System.out.println("Getting HandProximalPhalange X3D:   VIEW_INTERNAL  ");
			String sensor= "<TouchSensor DEF='StartHandProximalPhalange' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
					osteocytes.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE){
			
			String sensor= "<TouchSensor DEF='StartHandProximalPhalange' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
				osteocytes.getX3D(true);
			
		}
		// We draw at this level -- need to add an algorithm that draws it as cylinders interlocking
		else if (viewPerspective == Constants.VIEW_FLOATING)
		{
			// Run through the collection of HandProximalPhalange  and build them into the model
			// In the default case, we get one instance of the HandProximalPhalange  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the HandProximalPhalange we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting HandProximalPhalange X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for HandProximalPhalange X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for HandProximalPhalange Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for HandProximalPhalange Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='HandProximalPhalange '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='HandProximalPhalange Shape'\n" +
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
						 	"<IndexedFaceSet DEF='HandProximalPhalange IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='HandProximalPhalange _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartHandProximalPhalange' \n" +
					      " description='Radial Artery'\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n" +
				 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				 "key='0 .5 1'\n" +
				 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='HandProximalPhalange' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}

		
		//System.out.println("HandProximalPhalange X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
