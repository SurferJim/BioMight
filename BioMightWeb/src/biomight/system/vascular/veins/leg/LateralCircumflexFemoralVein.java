/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.leg;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.veins.Vein;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the LateralCircumflexFemoralVein 
 *************************************************************************************/


public class LateralCircumflexFemoralVein extends Vein {
	protected EndotheliumTissue endothelium;
	
	
	public LateralCircumflexFemoralVein()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LateralCircumflexFemoralVeinRef, null, null);
	}

	public LateralCircumflexFemoralVein(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public LateralCircumflexFemoralVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public LateralCircumflexFemoralVein(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/LateralCircumflexFemoralVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="LateralCircumflexFemoralVein.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LateralCircumflexFemoralVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the LateralCircumflexFemoralVein - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the LateralCircumflexFemoralVein MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate LateralCircumflexFemoralVein Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating LateralCircumflexFemoralVein Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("LateralCircumflexFemoralVeinEndothelium", parentID,bioMightMethods);
				initProperty("LateralCircumflexFemoralVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LateralCircumflexFemoralVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LateralCircumflexFemoralVeinRef, parentID);
				System.out.println("Have LateralCircumflexFemoralVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LateralCircumflexFemoralVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of LateralCircumflexFemoralVeins and build them into the model
			// In the default case, we get one instance of the LateralCircumflexFemoralVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LateralCircumflexFemoralVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LateralCircumflexFemoralVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate LateralCircumflexFemoralVein Endothelium: " + componentID);	
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating LateralCircumflexFemoralVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("LateralCircumflexFemoralVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("LateralCircumflexFemoralVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateLateralCircumflexFemoralVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		}
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
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
		// Generate the LateralCircumflexFemoralVeinEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LateralCircumflexFemoralVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.125;
			
			// LateralCircumflexFemoralVein
			if (componentID.equals("LateralCircumflexFemoralVein:01")) 
			{	
				
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double[] startPosLoop = {4.0, -32.650, -4.35};
				double[][]  currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosLoop, radius, 8);
				int success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:00001", "LateralCircumflexFemoralVeinEndothelium", 
					"Loop", componentID, parentID, currentPoints);	
				
				// Generate the LateralCircumflexFemoralVeinEndothelium
				radius = 0.075;
				double[] startPosBridge = {5.350, -33.0, -3.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBridge, radius, 8);
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:00360", "LateralCircumflexFemoralVeinEndothelium", 
					 "Bridge", componentID, parentID, currentPoints);	
				
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double[] startPos = {5.25, -33.0, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:00720", "LateralCircumflexFemoralVeinEndothelium", 
					"Descend", componentID, parentID, currentPoints);			
			
				radius = 0.065;
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double orient[] = {0.45, 0.0, 0.0}; 
				double[] startPosBranch1 = {7.0, -36.5, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch1, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:00880", "LateralCircumflexFemoralVeinEndothelium", 
					"Branch1", componentID, parentID, currentPoints);			
			
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double orient2[] = {-0.45, 0.0, 0.0}; 
				double[] startPosBranch2 = {7.1, -38.25, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch2, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:00980", "LateralCircumflexFemoralVeinEndothelium", 
					"Branch2", componentID, parentID, currentPoints);			
			}
			// Right Internal Carotid Vein
			else if (componentID.equals("LateralCircumflexFemoralVein:02")) 
			{	
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double[] startPosLoop = {-4.0, -32.650, -4.35};
				double[][]  currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosLoop, radius, 8);
				int  success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:01060", "LateralCircumflexFemoralVeinEndothelium", 
					 "Loop", componentID, parentID, currentPoints);	
			
				// Generate the LateralCircumflexFemoralVeinEndothelium
				radius = 0.075;
				double[] startPosBridge = {-5.350, -33.0, -3.00};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBridge, radius, 8);
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:01420", "LateralCircumflexFemoralVeinEndothelium", 
					 "Bridge", componentID, parentID, currentPoints);	
				
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double[] startPos = {-5.25, -33.0, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:01760", "LateralCircumflexFemoralVeinEndothelium", 
					"Descend", componentID, parentID, currentPoints);			

				radius = 0.065;
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double orient[] = {0.45, 0.0, 0.0}; 
				double[] startPosBranch1 = {-7.0, -36.5, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch1, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:02000", "LateralCircumflexFemoralVeinEndothelium", 
					"Branch1", componentID, parentID, currentPoints);			
			
				// Generate the LateralCircumflexFemoralVeinEndothelium
				double orient2[] = {-0.45, 0.0, 0.0}; 
				double[] startPosBranch2 = {-7.1, -38.25, -5.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBranch2, radius, 8);				
				success = bioMightBean.generateLateralCircumflexFemoralVein("LateralCircumflexFemoralVeinEndothelium:02200", "LateralCircumflexFemoralVeinEndothelium", 
					"Branch2", componentID, parentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate LateralCircumflexFemoralVeinEndothelium NoParent");
							
			}
			
			
			System.out.println("Created LateralCircumflexFemoralVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LateralCircumflexFemoralVeinEndothelium");
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
		 "<meta name='BioMightImage' content='LateralCircumflexFemoralVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LateralCircumflexFemoralVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting LateralCircumflexFemoralVein X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); 
		}
				
		
		//System.out.println("LateralCircumflexFemoralVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
