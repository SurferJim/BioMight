/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.hand;

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
 * Representation of the DeepFemoral Artery
 *************************************************************************************/


public class PrincepsPollicisArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public PrincepsPollicisArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PrincepsPollicisArteryRef, null, null);
	}

	public PrincepsPollicisArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public PrincepsPollicisArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public PrincepsPollicisArtery(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/PrincepsPollicisArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="PrincepsPollicisArtery.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PrincepsPollicisArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the PrincepsPollicisArtery - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the PrincepsPollicisArtery MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate PrincepsPollicisArtery Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating PrincepsPollicisArtery Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("PrincepsPollicisArteryEndothelium", parentID,bioMightMethods);
				initProperty("PrincepsPollicisArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting PrincepsPollicisArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.PrincepsPollicisArteryRef, parentID);
				System.out.println("Have PrincepsPollicisArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - PrincepsPollicisArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of PrincepsPollicisArterys and build them into the model
			// In the default case, we get one instance of the PrincepsPollicisArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("PrincepsPollicisArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created PrincepsPollicisArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate PrincepsPollicisArtery Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				// 
				
				System.out.println("Creating PrincepsPollicisArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("PrincepsPollicisArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("PrincepsPollicisArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreatePrincepsPollicisArtery Completed");
		
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
		// Generate the PrincepsPollicisArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PrincepsPollicisArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.07; 
		
			// PrincepsPollicisArtery
			if (componentID.equals("PrincepsPollicisArtery:01")) 
			{	
				System.out.println("Calling Generate PrincepsPollicisArteryEndothelium: " + componentID + "    " + parentID);
				
				
				double[] startPos = {8.75, -29.4, -0.85}; 
				
				
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generatePrincepsPollicisArtery("PrincepsPollicisArteryEndothelium:00001", "PrincepsPollicisArteryEndothelium", 
					"Main", componentID, parentID, currentPoints);							
				
							
				
			}
			// Right Side
			else if (componentID.equals("PrincepsPollicisArtery:02")) 
			{

				System.out.println("Calling Generate PrincepsPollicisArteryEndothelium: " + componentID + "    " + parentID);
				
				//z = -0.85: Same plane as Superficial Palmar Arch
				
				//! Object becomes invisible when it enters "gap" area (black hole)
				
				double[] startPos = {-10.6, -29.5, -0.85}; 
				
				
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				int success = bioMightBean.generatePrincepsPollicisArtery("PrincepsPollicisArteryEndothelium:01024", "PrincepsPollicisArteryEndothelium", 
						"Main", componentID, parentID, currentPoints);			
						
							
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate PrincepsPollicisArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created PrincepsPollicisArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PrincepsPollicisArteryEndothelium");
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
		 "<meta name='BioMightImage' content='PrincepsPollicisArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PrincepsPollicisArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting PrincepsPollicisArtery X3D");
		
		if (viewPerspective == Constants.VIEW_DETACHED) {
			
			System.out.println("EXECUTING 1");
			body = endothelium.getX3D(true); 
		}
		
		
		else {
			
			//System.out.println("EXECUTING 2");
			body = ""; 
			/* endothelium.getX3D(true); 
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) ;	*/
		}
				
		//System.out.println("FINISHEDPROCESS");
		
		//System.out.println("PrincepsPollicisArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
