/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.spine;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the SacralVertebra
 *************************************************************************************/


public class SacralVertebra extends Bone {
	private Osteocytes osteocytes;
	
	public SacralVertebra()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SacralVertebraRef, null, null);
	}

	public SacralVertebra(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public SacralVertebra(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public SacralVertebra(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/SacralVertebra.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="SacralVertebra.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING SacralVertebra METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the SacralVertebra - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the SacralVertebra MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate SacralVertebra Osteocytes: " + parentID);	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating SacralVertebra Osteocytes for:" + parentID);		
				osteocytes = new Osteocytes("SacralVertebraOsteocyte", parentID, bioMightMethods);
				initProperty("SacralVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("SacralVertebra Osteocytes completed: " + parentID);
				
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;		
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting SacralVertebraInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.SacralVertebraRef, parentID);
				System.out.println("Have SacralVertebra Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SacralVertebra");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of SacralVertebras and build them into the model
			// In the default case, we get one instance of the SacralVertebra for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("SacralVertebra NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created SacralVertebra: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate SacralVertebra Osteocytes: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating SacralVertebra Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("SacralVertebraOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("SacralVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("SacralVertebra Osteocytes completed: " + bioMightTransform.getId());		
				
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;	
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateSacralVertebra Completed");
		
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
		// Generate the SacralVertebraEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SacralVertebraEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.50;
		
			// SacralVertebra
			if (componentID.equals("SacralVertebra:01")) 
			{	
				// Generate the SacralVertebraEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.0, -25.10, -7.80};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SacralVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSacralVertebra("SacralVertebraOsteocyte:00001", "SacralVertebraOsteocyte", 
					"SacralVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// SacralVertebra
			else if (componentID.equals("SacralVertebra:02")) 
			{	
				radius = 0.43;
				double[] startPos = {0.0, -25.70, -7.95};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SacralVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSacralVertebra("SacralVertebraOsteocyte:00320", "SacralVertebraOsteocyte", 
					"SacralVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// SacralVertebra
			else if (componentID.equals("SacralVertebra:03")) 
			{	
				radius = 0.40;
				double[] startPos = {0.0, -26.30, -8.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SacralVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSacralVertebra("SacralVertebraOsteocyte:00640", "SacralVertebraOsteocyte", 
					"SacralVertebraOsteocyte", componentID, parentID, currentPoints);			
						
			}
			// SacralVertebra
			else if (componentID.equals("SacralVertebra:04")) 
			{	
				radius = 0.30;
				double[] startPos = {0.0, -26.90, -8.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SacralVertebraOsteocyte: " + componentID + "    " + parentID);
					
				int success = bioMightBean.generateSacralVertebra("SacralVertebraOsteocyte:00960", "SacralVertebraOsteocyte", 
					"SacralVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// SacralVertebra
			else if (componentID.equals("SacralVertebra:05")) 
			{	
				radius = 0.28;
				double[] startPos = {0.0, -27.30, -8.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SacralVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSacralVertebra("SacralVertebraOsteocyte:01320", "SacralVertebraOsteocyte", 
					"SacralVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate SacralVertebraOsteocyte NoParent");
			}
			
			System.out.println("Created SacralVertebraOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SacralVertebraOsteocyte");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Femoral Vein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SacralVertebra .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SacralVertebra '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting SacralVertebra X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
				osteocytes.getX3D(true) ; 
		}
		else {
			body = 
				osteocytes.getX3D(true) ; 
		}
				
		
		//System.out.println("SacralVertebra X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
