/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.leg.femur;

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
 * Representation of the Femur
 *************************************************************************************/


public class Femur extends Bone {
	private TrochanterHead trochanterHead;
	private TrochanterNeck trochanterNeck;
	private Osteocytes osteocytes;
	
	public Femur()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.FemurRef, null, null);
	}

	public Femur(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public Femur(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public Femur(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Femur.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Femur.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Femur METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the Femur - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Femur			
				System.out.println("Getting the Femur MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
		
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating Femur Osteocytes:" + parentID);		
				osteocytes = new Osteocytes("FemurOsteocyte", parentID, bioMightMethods);
				initProperty("FemurOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Femur Osteocytes completed: " + parentID);
				
				
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;

				System.out.println("Creating the TrochanterHead for ParentID: " + parentID);
				trochanterHead = new TrochanterHead(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("TrochanterHead", Constants.TrochanterHead, Constants.TrochanterHeadRef, trochanterHead.getComponentID());
				System.out.println("Created the TrochanterHead");
		
				System.out.println("Creating the TrochanterNeck for ParentID: " + parentID);
				trochanterNeck = new TrochanterNeck(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("TrochanterNeck", Constants.TrochanterNeck, Constants.TrochanterNeckRef, trochanterNeck.getComponentID());
				System.out.println("Created the TrochanterNeck");
	
				System.out.println("Creating the TrochanterNeck for ParentID: " + parentID);
				trochanterNeck = new TrochanterNeck(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("TrochanterNeck", Constants.TrochanterNeck, Constants.TrochanterNeckRef, trochanterNeck.getComponentID());
				System.out.println("Created the TrochanterNeck");
	
				
				
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting FemurInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.FemurRef, parentID);
				System.out.println("Have Femur Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Femur");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of Femurs and build them into the model
			// In the default case, we get one instance of the Femur for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Femur NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created Femur: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate Femur Osteocytes: " + parentID);	
				// Generate the Osteocytes if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating Femur Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("FemurOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("FemurOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Femur Osteocytes completed: " + bioMightTransform.getId());		
				
				// Make the method look up the data as it has not ben retrieved
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;

				System.out.println("Creating the TrochanterHead for ParentID: " + bioMightTransform.getId());
				trochanterHead = new TrochanterHead(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("TrochanterHead", Constants.TrochanterHead, Constants.TrochanterHeadRef, trochanterHead.getComponentID());
				System.out.println("Created the TrochanterHead");

				System.out.println("Creating the TrochanterNeck for ParentID: " + bioMightTransform.getId());
				trochanterNeck = new TrochanterNeck(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("TrochanterNeck", Constants.TrochanterNeck, Constants.TrochanterNeckRef, trochanterNeck.getComponentID());
				System.out.println("Created the TrochanterNeck");
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateFemur Completed");
		
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
		// Generate the FemurEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the FemurEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.475;
		
			// Femur
			if (componentID.equals("Femur:01")) 
			{	
				// Generate the FemurEndothelium of the neck
				// Create 5 sections
				double[] startPos = {6.0, -31.0, -4.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FemurOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFemur("FemurOsteocyte:00001", "FemurOsteocyte", 
					"FemurOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// Femur
			else if (componentID.equals("Femur:02")) 
			{	
				double[] startPos = {-6.0, -31.0, -4.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate FemurOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateFemur("FemurOsteocyte:00320", "FemurOsteocyte", 
					"FemurOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate FemurOsteocyte NoParent");
							
			}
			
			System.out.println("Created FemurOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - FemurOsteocyte");
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
		 "<meta name='BioMightImage' content='Femur .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Femur '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting Femur X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
				osteocytes.getX3D(true) +
				trochanterHead.getX3D(true) +
				trochanterNeck.getX3D(true); 
		}
		else {
			body = 
				osteocytes.getX3D(true) +
				trochanterHead.getX3D(true) +
				trochanterNeck.getX3D(true); 
		}
				
		
		//System.out.println("Femur X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
