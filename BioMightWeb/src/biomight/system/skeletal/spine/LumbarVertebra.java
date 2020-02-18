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
 * Representation of the LumbarVertebra
 *************************************************************************************/


public class LumbarVertebra extends Bone {
	private Osteocytes osteocytes;
	
	public LumbarVertebra()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LumbarVertebraRef, null, null);
	}

	public LumbarVertebra(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public LumbarVertebra(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public LumbarVertebra(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/LumbarVertebra.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="LumbarVertebra.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LumbarVertebra METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the LumbarVertebra - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the LumbarVertebra MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate LumbarVertebra Osteocytes: " + parentID);	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating LumbarVertebra Osteocytes for:" + parentID);		
				osteocytes = new Osteocytes("LumbarVertebraOsteocyte", parentID, bioMightMethods);
				initProperty("LumbarVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("LumbarVertebra Osteocytes completed: " + parentID);
				
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;		
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LumbarVertebraInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LumbarVertebraRef, parentID);
				System.out.println("Have LumbarVertebra Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LumbarVertebra");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of LumbarVertebras and build them into the model
			// In the default case, we get one instance of the LumbarVertebra for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LumbarVertebra NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LumbarVertebra: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate LumbarVertebra Osteocytes: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating LumbarVertebra Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("LumbarVertebraOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("LumbarVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("LumbarVertebra Osteocytes completed: " + bioMightTransform.getId());		
				
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;	
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateLumbarVertebra Completed");
		
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
		// Generate the LumbarVertebraEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LumbarVertebraEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.50;
		
			// LumbarVertebra
			if (componentID.equals("LumbarVertebra:01")) 
			{	
				// Generate the LumbarVertebraEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.0, -20.1, -5.9};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate LumbarVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLumbarVertebra("LumbarVertebraOsteocyte:00001", "LumbarVertebraOsteocyte", 
					"LumbarVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// LumbarVertebra
			else if (componentID.equals("LumbarVertebra:02")) 
			{	
				double[] startPos = {0.0, -21.2, -6.3};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate LumbarVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLumbarVertebra("LumbarVertebraOsteocyte:00320", "LumbarVertebraOsteocyte", 
					"LumbarVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// LumbarVertebra
			else if (componentID.equals("LumbarVertebra:03")) 
			{	
				double[] startPos = {0.0, -22.3, -6.70};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate LumbarVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLumbarVertebra("LumbarVertebraOsteocyte:00640", "LumbarVertebraOsteocyte", 
					"LumbarVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// LumbarVertebra
			else if (componentID.equals("LumbarVertebra:04")) 
			{	
				double[] startPos = {0.0, -23.35, -7.1};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate LumbarVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLumbarVertebra("LumbarVertebraOsteocyte:00960", "LumbarVertebraOsteocyte", 
					"LumbarVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// LumbarVertebra
			else if (componentID.equals("LumbarVertebra:05")) 
			{		
				double[] startPos = {0.0, -24.4, -7.58};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate LumbarVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLumbarVertebra("LumbarVertebraOsteocyte:01320", "LumbarVertebraOsteocyte", 
					"LumbarVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate LumbarVertebraOsteocyte NoParent");
			}
			
			System.out.println("Created LumbarVertebraOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LumbarVertebraOsteocyte");
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
		 "<meta name='BioMightImage' content='LumbarVertebra .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LumbarVertebra '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting LumbarVertebra X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
				osteocytes.getX3D(true) ; 
		}
		else {
			body = 
				osteocytes.getX3D(true) ; 
		}
				
		
		//System.out.println("LumbarVertebra X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
