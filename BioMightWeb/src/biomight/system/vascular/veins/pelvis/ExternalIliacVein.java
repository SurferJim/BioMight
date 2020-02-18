/*
 * Created on Sep 5, 2006
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
 * Representation of the ExternalIliacVein
 *************************************************************************************/


public class ExternalIliacVein extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public ExternalIliacVein()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ExternalIliacVeinRef, null, null);
	}

	public ExternalIliacVein(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public ExternalIliacVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public ExternalIliacVein(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/ExternalIliacVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="ExternalIliacVein.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ExternalIliacVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the ExternalIliacVein - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the ExternalIliacVein MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate ExternalIliacVein Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating ExternalIliacVein Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("ExternalIliacVeinEndothelium", parentID,bioMightMethods);
				initProperty("ExternalIliacVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ExternalIliacVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ExternalIliacVeinRef, parentID);
				System.out.println("Have ExternalIliacVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ExternalIliacVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ExternalIliacVeins and build them into the model
			// In the default case, we get one instance of the ExternalIliacVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ExternalIliacVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created ExternalIliacVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate ExternalIliacVein Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating ExternalIliacVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("ExternalIliacVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("ExternalIliacVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateExternalIliacVein Completed");
		
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
		// Generate the ExternalIliacVeinEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ExternalIliacVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.1;
		
			// ExternalIliacVein
			if (componentID.equals("ExternalIliacVein:01")) 
			{	
				System.out.println("Calling Generate ExternalIliacVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the ExternalIliacVeinEndothelium of the neck
				// Create 5 sections
				double[] startPos = {3.25, -47.75, -4.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00001", "ExternalIliacVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00180", "ExternalIliacVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00360", "ExternalIliacVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00540", "ExternalIliacVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			// Right Side
			else if (componentID.equals("ExternalIliacVein:02")) 
			{	

				System.out.println("Calling Generate ExternalIliacVeinEndothelium: " + componentID + "    " + parentID);
		
				double[] startPos = {-2.40, -47.75, -4.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);	
				int success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:01024", "ExternalIliacVeinEndothelium", 
						"Main", componentID, parentID, currentPoints);			
						
				/*
					// Top Branch
					radius = 0.10;
					double[] startPosTop = {-4.15, -37.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
					success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:01300", "ExternalIliacVeinEndothelium", 
						"Top", componentID, parentID, currentPoints);			
					
					// Middle Branch
					double[] startPosMid = {-3.40, -41.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
					success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:01420", "ExternalIliacVeinEndothelium", 
						"Middle", componentID, parentID, currentPoints);			

					// Lower Branch
					double[] startPosBot = {-3.50, -45.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
					success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:01580", "ExternalIliacVeinEndothelium", 
						"Bottom", componentID, parentID, currentPoints);					
					*/
			}
			
			else if (componentID.equals("ExternalIliacVein:03")) 
			{	
				System.out.println("Calling Generate ExternalIliacVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the ExternalIliacVeinEndothelium
				// Create 5 sections
				double[] startPos = {3.5, -35.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:02048", "ExternalIliacVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00180", "ExternalIliacVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:0360", "ExternalIliacVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00540", "ExternalIliacVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			if (componentID.equals("ExternalIliacVein:04")) 
			{	
				System.out.println("Calling Generate ExternalIliacVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the ExternalIliacVeinEndothelium
				// Create 5 sections
				double[] startPos = {-3.5, -35.00, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:03072", "ExternalIliacVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00180", "ExternalIliacVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00360", "ExternalIliacVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateExternalIliacVein("ExternalIliacVeinEndothelium:00540", "ExternalIliacVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
	
			
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ExternalIliacVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created ExternalIliacVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ExternalIliacVeinEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the ExternalIliacVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the ExternalIliacVein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ExternalIliacVein.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ExternalIliacVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting ExternalIliacVein X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
		
		//System.out.println("ExternalIliacVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
