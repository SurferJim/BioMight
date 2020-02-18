/*
 * Created on Sep 17, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.foot;

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
 * Representation of the DorsalMetatarsalVein
 *************************************************************************************/


public class DorsalMetatarsalVein extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public DorsalMetatarsalVein()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.DorsalMetatarsalVeinRef, null, null);
	}

	public DorsalMetatarsalVein(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public DorsalMetatarsalVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public DorsalMetatarsalVein(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/DorsalMetatarsalVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="DorsalMetatarsalVein.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING DorsalMetatarsalVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the DorsalMetatarsalVein - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the DorsalMetatarsalVein MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate DorsalMetatarsalVein Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating DorsalMetatarsalVein Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("DorsalMetatarsalVeinEndothelium", parentID,bioMightMethods);
				initProperty("DorsalMetatarsalVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting DorsalMetatarsalVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.DorsalMetatarsalVeinRef, parentID);
				System.out.println("Have DorsalMetatarsalVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - DorsalMetatarsalVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of DorsalMetatarsalVeins and build them into the model
			// In the default case, we get one instance of the DorsalMetatarsalVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("DorsalMetatarsalVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created DorsalMetatarsalVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate DorsalMetatarsalVein Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating DorsalMetatarsalVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("DorsalMetatarsalVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("DorsalMetatarsalVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateDorsalMetatarsalVein Completed");
		
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
		// Generate the DorsalMetatarsalVeinEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the DorsalMetatarsalVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.1;
		
			// DorsalMetatarsalVein
			if (componentID.equals("DorsalMetatarsalVein:01")) 
			{	
				System.out.println("Calling Generate DorsalMetatarsalVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the DorsalMetatarsalVeinEndothelium of the neck
				// Create 5 sections
				double[] startPos = {3.0, -47.75, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00001", "DorsalMetatarsalVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00180", "DorsalMetatarsalVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00360", "DorsalMetatarsalVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00540", "DorsalMetatarsalVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			// Right Side
			else if (componentID.equals("DorsalMetatarsalVein:02")) 
			{	

				System.out.println("Calling Generate DorsalMetatarsalVeinEndothelium: " + componentID + "    " + parentID);
		
				double[] startPos = {-3.0, -47.75, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);	
				int success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:01024", "DorsalMetatarsalVeinEndothelium", 
						"Main", componentID, parentID, currentPoints);			
						
				/*
					// Top Branch
					radius = 0.10;
					double[] startPosTop = {-4.15, -37.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
					success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:01300", "DorsalMetatarsalVeinEndothelium", 
						"Top", componentID, parentID, currentPoints);			
					
					// Middle Branch
					double[] startPosMid = {-3.40, -41.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
					success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:01420", "DorsalMetatarsalVeinEndothelium", 
						"Middle", componentID, parentID, currentPoints);			

					// Lower Branch
					double[] startPosBot = {-3.50, -45.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
					success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:01580", "DorsalMetatarsalVeinEndothelium", 
						"Bottom", componentID, parentID, currentPoints);					
					*/
			}
			
			else if (componentID.equals("DorsalMetatarsalVein:03")) 
			{	
				System.out.println("Calling Generate DorsalMetatarsalVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the DorsalMetatarsalVeinEndothelium
				// Create 5 sections
				double[] startPos = {3.5, -35.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:02048", "DorsalMetatarsalVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00180", "DorsalMetatarsalVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:0360", "DorsalMetatarsalVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00540", "DorsalMetatarsalVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			if (componentID.equals("DorsalMetatarsalVein:04")) 
			{	
				System.out.println("Calling Generate DorsalMetatarsalVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the DorsalMetatarsalVeinEndothelium
				// Create 5 sections
				double[] startPos = {-3.5, -35.00, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:03072", "DorsalMetatarsalVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00180", "DorsalMetatarsalVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00360", "DorsalMetatarsalVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateDorsalMetatarsalVein("DorsalMetatarsalVeinEndothelium:00540", "DorsalMetatarsalVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
	
			
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate DorsalMetatarsalVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created DorsalMetatarsalVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DorsalMetatarsalVeinEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the DorsalMetatarsalVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the DorsalMetatarsalVein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='DorsalMetatarsalVein.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='DorsalMetatarsalVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting DorsalMetatarsalVein X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
		
		//System.out.println("DorsalMetatarsalVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
