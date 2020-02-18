/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.pelvis;

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
 * Representation of the CommonIliac Artery
 *************************************************************************************/


public class CommonIliacArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public CommonIliacArtery()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CommonIliacArteryRef, null, null);
	}

	public CommonIliacArtery(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public CommonIliacArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public CommonIliacArtery(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/CommonIliacArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="CommonIliacArtery.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING CommonIliacArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the CommonIliacArtery - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the CommonIliacArtery MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate CommonIliacArtery Endothelium: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;	
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating CommonIliacArtery Endothelium: " + parentID);	
				endothelium = new EndotheliumTissue("CommonIliacArteryEndothelium", parentID,bioMightMethods);
				initProperty("CommonIliacArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CommonIliacArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.CommonIliacArteryRef, parentID);
				System.out.println("Have CommonIliacArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CommonIliacArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of CommonIliacArterys and build them into the model
			// In the default case, we get one instance of the CommonIliacArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("CommonIliacArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created CommonIliacArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate CommonIliacArtery Endothelium: " + componentID);	
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating CommonIliacArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("CommonIliacArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("CommonIliacArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateCommonIliacArtery Completed");
		
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
		// Generate the CommonIliacArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CommonIliacArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.40;
		
			// CommonIliacArtery
			if (componentID.equals("CommonIliacArtery:01")) 
			{	
				// Generate the CommonIliacArteryEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.4, -24.75, -4.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CommonIliacArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCommonIliacArtery("CommonIliacArteryEndothelium:00001", "CommonIliacArteryEndothelium", 
					"CommonIliacArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("CommonIliacArtery:02")) 
			{	
				double[] startPos = {0.2, -24.75, -4.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CommonIliacArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCommonIliacArtery("CommonIliacArteryEndothelium:00320", "CommonIliacArteryEndothelium", 
					"CommonIliacArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate CommonIliacArteryEndothelium NoParent");
							
			}
			
			
			System.out.println("Created CommonIliacArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CommonIliacArteryEndothelium");
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
		 "<meta name='BioMightImage' content='CommonIliacArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CommonIliacArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting CommonIliacArtery X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = endothelium.getX3D(true); 
		}
		else {
			body = endothelium.getX3D(true); 
		}
				
		
		//System.out.println("CommonIliacArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
