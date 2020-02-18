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
 * Representation of the GreatSaphenousVein
 *************************************************************************************/


public class GreatSaphenousVein extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public GreatSaphenousVein()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.GreatSaphenousVeinRef, null, null);
	}

	public GreatSaphenousVein(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public GreatSaphenousVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public GreatSaphenousVein(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/GreatSaphenousVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="GreatSaphenousVein.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING GreatSaphenousVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the GreatSaphenousVein - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the GreatSaphenousVein MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate GreatSaphenousVein Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating GreatSaphenousVein Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("GreatSaphenousVeinEndothelium", parentID,bioMightMethods);
				initProperty("GreatSaphenousVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting GreatSaphenousVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.GreatSaphenousVeinRef, parentID);
				System.out.println("Have GreatSaphenousVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - GreatSaphenousVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of GreatSaphenousVeins and build them into the model
			// In the default case, we get one instance of the GreatSaphenousVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("GreatSaphenousVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created GreatSaphenousVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate GreatSaphenousVein Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating GreatSaphenousVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("GreatSaphenousVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("GreatSaphenousVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateGreatSaphenousVein Completed");
		
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
		// Generate the GreatSaphenousVeinEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.1;
		
			// GreatSaphenousVein
			if (componentID.equals("GreatSaphenousVein:01")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the GreatSaphenousVeinEndothelium of the neck
				// Create 5 sections
				//double[] startPos = {3.5, -32.25, -4.0};
				//double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				//int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00001", "GreatSaphenousVeinEndothelium", 
				//	"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00180", "GreatSaphenousVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00360", "GreatSaphenousVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00540", "GreatSaphenousVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			// Right Side
			if (componentID.equals("GreatSaphenousVein:02"))
			{	

				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
		
				//double[] startPos = {-3.5, -32.25, -4.0};
				//double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);	
				//int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:01024", "GreatSaphenousVeinEndothelium", 
				//	"Main", componentID, parentID, currentPoints);			
						
				/*
					// Top Branch
					radius = 0.10;
					double[] startPosTop = {-4.15, -37.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
					success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:01300", "GreatSaphenousVeinEndothelium", 
						"Top", componentID, parentID, currentPoints);			
					
					// Middle Branch
					double[] startPosMid = {-3.40, -41.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
					success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:01420", "GreatSaphenousVeinEndothelium", 
						"Middle", componentID, parentID, currentPoints);			

					// Lower Branch
					double[] startPosBot = {-3.50, -45.0, -6.0};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
					success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:01580", "GreatSaphenousVeinEndothelium", 
						"Bottom", componentID, parentID, currentPoints);					
					*/
			}
			
			else if (componentID.equals("GreatSaphenousVein:03")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the GreatSaphenousVeinEndothelium
				// Create 5 sections
				double[] startPos = {3.607, -44.25, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:02048", "GreatSaphenousVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00180", "GreatSaphenousVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:0360", "GreatSaphenousVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00540", "GreatSaphenousVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			if (componentID.equals("GreatSaphenousVein:04")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the GreatSaphenousVeinEndothelium
				// Create 5 sections
				double[] startPos = {-3.6, -44.25, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:03072", "GreatSaphenousVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00180", "GreatSaphenousVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00360", "GreatSaphenousVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00540", "GreatSaphenousVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			if (componentID.equals("GreatSaphenousVein:05")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the GreatSaphenousVeinEndothelium
				// Create 5 sections	
				double[] startPos = {3.58, -47.75, -3.95};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:04096", "GreatSaphenousVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00180", "GreatSaphenousVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00360", "GreatSaphenousVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00540", "GreatSaphenousVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
			if (componentID.equals("GreatSaphenousVein:06")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium: " + componentID + "    " + parentID);
				
				// Generate the GreatSaphenousVeinEndothelium
				// Create 5 sections
				double[] startPos = {-3.625, -47.75, -3.98};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:05120", "GreatSaphenousVeinEndothelium", 
					"Main", componentID, parentID, currentPoints);			
					
				/*
				// Top Branch
				radius = 0.10;
				double[] startPosTop = {4.15, -37.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosTop, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00180", "GreatSaphenousVeinEndothelium", 
					"Top", componentID, parentID, currentPoints);			
				
				// Middle Branch
				double[] startPosMid = {3.40, -41.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosMid, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00360", "GreatSaphenousVeinEndothelium", 
					"Middle", componentID, parentID, currentPoints);			

				// Lower Branch
				double[] startPosBot = {3.50, -45.0, -6.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosBot, radius, 8);
				success = bioMightBean.generateGreatSaphenousVein("GreatSaphenousVeinEndothelium:00540", "GreatSaphenousVeinEndothelium", 
					"Bottom", componentID, parentID, currentPoints);					
				*/
			}
	
			
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate GreatSaphenousVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created GreatSaphenousVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - GreatSaphenousVeinEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the GreatSaphenousVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the GreatSaphenousVein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='GreatSaphenousVein.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GreatSaphenousVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting GreatSaphenousVein X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
		
		//System.out.println("GreatSaphenousVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
