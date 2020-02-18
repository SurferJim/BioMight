/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.leg;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the LateralCircumflexFemoralArtery Artery
 *************************************************************************************/


public class LateralCircumflexFemoralArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public LateralCircumflexFemoralArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LateralCircumflexFemoralArteryRef, null, null);
	}

	public LateralCircumflexFemoralArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public LateralCircumflexFemoralArtery(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LateralCircumflexFemoralArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="LateralCircumflexFemoralArtery.x3d";
	
		
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LateralCircumflexFemoralArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the LateralCircumflexFemoralArtery - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of Kidney,
			// Go get the details for the current Kidney is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the LateralCircumflexFemoralArtery MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				

				System.out.println("Calling generate LateralCircumflexFemoralArtery Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating LateralCircumflexFemoralArtery Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("LateralCircumflexFemoralArteryEndothelium", parentID,bioMightMethods);
				initProperty("LateralCircumflexFemoralArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LateralCircumflexFemoralArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LateralCircumflexFemoralArteryRef, parentID);
				System.out.println("Have LateralCircumflexFemoralArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LateralCircumflexFemoralArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of LateralCircumflexFemoralArterys and build them into the model
			// In the default case, we get one instance of the LateralCircumflexFemoralArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LateralCircumflexFemoralArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LateralCircumflexFemoralArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate LateralCircumflexFemoralArtery Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating LateralCircumflexFemoralArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("LateralCircumflexFemoralArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("LateralCircumflexFemoralArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateLateralCircumflexFemoralArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		}
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "LateralCircumflexFemoralArtery:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
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
		// Generate the LateralCircumflexFemoralArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LateralCircumflexFemoralArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.125;
		
			// LateralCircumflexFemoralArtery
			if (componentID.equals("LateralCircumflexFemoralArtery:01")) 
			{	
				
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double[] startPosLoop = {4.0, -33.0, -4.35};
				double[][]  currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosLoop, radius, 8);
				int success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:00001", "LateralCircumflexFemoralArteryEndothelium", 
					"Loop", componentID, parentID, currentPoints);	
				
		
				// Generate the LateralCircumflexFemoralArteryEndothelium
				radius = 0.075;
				double[] startPosBridge = {5.0, -33.0, -3.10};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBridge, radius, 8);
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:00360", "LateralCircumflexFemoralArteryEndothelium", 
					"Bridge", componentID, parentID, currentPoints);	
		
				
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double[] startPos = {5.0, -33.0, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:00720", "LateralCircumflexFemoralArteryEndothelium", 
					"Descend", componentID, parentID, currentPoints);			
			
				radius = 0.065;
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double orient[] = {0.45, 0.0, 0.0}; 
				double[] startPosBranch1 = {7.0, -36.5, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch1, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:00880", "LateralCircumflexFemoralArteryEndothelium", 
					"Branch1", componentID, parentID, currentPoints);			
			
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double orient2[] = {-0.45, 0.0, 0.0}; 
				double[] startPosBranch2 = {7.1, -38.25, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch2, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:00980", "LateralCircumflexFemoralArteryEndothelium", 
					"Branch2", componentID, parentID, currentPoints);			
			}
			// Right Internal Carotid Artery
			else if (componentID.equals("LateralCircumflexFemoralArtery:02")) 
			{	
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double[] startPosLoop = {-4.0, -33.0, -4.35};
				double[][]  currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosLoop, radius, 8);
				int success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:01060", "LateralCircumflexFemoralArteryEndothelium", 
					 "Loop", componentID, parentID, currentPoints);	
		
				
				// Generate the LateralCircumflexFemoralArteryEndothelium
				radius = 0.075;
				double[] startPosBridge = {-5.0, -33.0, -3.10};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBridge, radius, 8);
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:01420", "LateralCircumflexFemoralArteryEndothelium", 
					 "Bridge", componentID, parentID, currentPoints);	
			
				
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double[] startPos = {-5.0, -33.0, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:01760", "LateralCircumflexFemoralArteryEndothelium", 
					"Descend", componentID, parentID, currentPoints);			

				radius = 0.065;
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double orient[] = {0.45, 0.0, 0.0}; 
				double[] startPosBranch1 = {-7.0, -36.5, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch1, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:02000", "LateralCircumflexFemoralArteryEndothelium", 
					"Branch1", componentID, parentID, currentPoints);			
			
				// Generate the LateralCircumflexFemoralArteryEndothelium
				double orient2[] = {-0.45, 0.0, 0.0}; 
				double[] startPosBranch2 = {-7.1, -38.25, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch2, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralArtery("LateralCircumflexFemoralArteryEndothelium:02200", "LateralCircumflexFemoralArteryEndothelium", 
					"Branch2", componentID, parentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate LateralCircumflexFemoralArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created LateralCircumflexFemoralArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LateralCircumflexFemoralArteryEndothelium");
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
		 "<meta name='BioMightImage' content='LateralCircumflexFemoralArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LateralCircumflexFemoralArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting LateralCircumflexFemoralArtery X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
	
	
		
		//System.out.println("LateralCircumflexFemoralArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
