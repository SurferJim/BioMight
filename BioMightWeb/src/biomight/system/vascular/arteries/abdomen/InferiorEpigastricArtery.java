/*
 * Created on Sep 5, 2006
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
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.Artery;
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
 * Representation of the InferiorEpigastric Artery
 *************************************************************************************/


public class InferiorEpigastricArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public InferiorEpigastricArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.InferiorEpigastricArteryRef, null, null);
	}

	public InferiorEpigastricArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public InferiorEpigastricArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public InferiorEpigastricArtery(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/InferiorEpigastricArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="InferiorEpigastricArtery.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING InferiorEpigastricArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the InferiorEpigastricArtery - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the InferiorEpigastricArtery MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate InferiorEpigastricArtery Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating InferiorEpigastricArtery Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("InferiorEpigastricArteryEndothelium", parentID,bioMightMethods);
				initProperty("InferiorEpigastricArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting InferiorEpigastricArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.InferiorEpigastricArteryRef, parentID);
				System.out.println("Have InferiorEpigastricArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - InferiorEpigastricArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of InferiorEpigastricArterys and build them into the model
			// In the default case, we get one instance of the InferiorEpigastricArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("InferiorEpigastricArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created InferiorEpigastricArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate InferiorEpigastricArtery Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating InferiorEpigastricArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("InferiorEpigastricArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("InferiorEpigastricArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateInferiorEpigastricArtery Completed");
		
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
		// Generate the InferiorEpigastricArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the InferiorEpigastricArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.08;
		
			// InferiorEpigastricArtery
			if (componentID.equals("InferiorEpigastricArtery:01")) 
			{	
				System.out.println("Calling Generate InferiorEpigastricArteryEndothelium: " + componentID + "    " + parentID);
				
				// Generate the InferiorEpigastricArteryEndothelium
				radius = 0.08;
				double[] startPos = {3.5, -32.15, -3.8};  
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				int success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:00001", "InferiorEpigastricArteryEndothelium", 
					"Main", componentID, parentID, currentPoints);							
				
				// Top Branches
				radius = 0.07;
				double[] startPosTop = {1.68, -31.0, -3.68};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:00300", "InferiorEpigastricArteryEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				radius = 0.05;
				double[] startPosTopB1 = {2.45, -30.80, -3.75};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosTopB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:00500", "InferiorEpigastricArteryEndothelium", 
					"TopB1", componentID, parentID, currentPoints);
			
				double[] startPosTopB2 = {3.00, -30.6, -4.05};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosTopB2, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:00700", "InferiorEpigastricArteryEndothelium", 
					"TopB2", componentID, parentID, currentPoints);
			
				// Middle Branch
				radius = 0.07;
				double[] startPosMid = {1.00, -30.0, -3.88};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:00900", "InferiorEpigastricArteryEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				radius = 0.05;
				double[] startPosMidB1 = {2.0, -29.80, -4.10};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosMidB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:01100", "InferiorEpigastricArteryEndothelium", 
					"MiddleB1", componentID, parentID, currentPoints);
					
				// Lower Branch on way upward
				radius = 0.07;
				double[] startPosBot = 	{0.75, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:01300", "InferiorEpigastricArteryEndothelium", 
					"Bottom", componentID, parentID, currentPoints);
				
				radius = 0.05;
				double[] startPosBotB1 = 	{1.0, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBotB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:01500", "InferiorEpigastricArteryEndothelium", 
					"BottomB1", componentID, parentID, currentPoints);
			
				radius = 0.04;
				double[] startPosBotB2 = 	{1.15, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBotB2, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:01700", "InferiorEpigastricArteryEndothelium", 
					"BottomB2", componentID, parentID, currentPoints);
			}
			// Right Side
			else if (componentID.equals("InferiorEpigastricArtery:02")) 
			{

				System.out.println("Calling Generate InferiorEpigastricArteryEndothelium: " + componentID + "    " + parentID);
				double[] startPos = {-3.50, -32.15, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				int success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:03000", "InferiorEpigastricArteryEndothelium", 
						"Main", componentID, parentID, currentPoints);			
										
				// Top Branch
				radius = 0.08;
				double[] startPosTop = {-1.68, -31.0, -3.68};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:03300", "InferiorEpigastricArteryEndothelium", 
					"Top", componentID, parentID, currentPoints);			
		
				radius = 0.05;
				double[] startPosTopB1 = {-2.45, -30.80, -3.75};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosTopB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:03500", "InferiorEpigastricArteryEndothelium", 
					"TopB1", componentID, parentID, currentPoints);
			
				double[] startPosTopB2 = {-3.00, -30.6, -4.05};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosTopB2, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:03700", "InferiorEpigastricArteryEndothelium", 
					"TopB2", componentID, parentID, currentPoints);
		
				// Middle Branch
				radius = 0.07;
				double[] startPosMid = {-1.00, -30.0, -3.88};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:03900", "InferiorEpigastricArteryEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				radius = 0.05;
				double[] startPosMidB1 = {-2.0, -29.80, -4.10};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosMidB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:04100", "InferiorEpigastricArteryEndothelium", 
					"MiddleB1", componentID, parentID, currentPoints);
								
				// Lower Branch
				radius = 0.07;
				double[] startPosBot = {-0.75, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:04300", "InferiorEpigastricArteryEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					

				radius = 0.05;
				double[] startPosBotB1 = {-1.0, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBotB1, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:04500", "InferiorEpigastricArteryEndothelium", 
					"BottomB1", componentID, parentID, currentPoints);
			
				double[] startPosBotB2 = {-1.15, -29.0, -3.80};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosBotB2, radius, 8);
				success = bioMightBean.generateInferiorEpigastricArtery("InferiorEpigastricArteryEndothelium:04700", "InferiorEpigastricArteryEndothelium", 
					"BottomB2", componentID, parentID, currentPoints);

			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate InferiorEpigastricArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created InferiorEpigastricArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InferiorEpigastricArteryEndothelium");
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
		 "<meta name='BioMightImage' content='InferiorEpigastricArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='InferiorEpigastricArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting InferiorEpigastricArtery X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
		
		//System.out.println("InferiorEpigastricArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
