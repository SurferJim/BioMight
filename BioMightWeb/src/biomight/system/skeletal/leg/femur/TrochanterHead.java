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
import biomight.system.skeletal.arm.Olecranon;
import biomight.system.skeletal.arm.RadialNotch;
import biomight.system.skeletal.arm.SemiUlnarNotch;
import biomight.system.skeletal.arm.UlnaCoronoidProcess;
import biomight.system.tissue.connective.bone.Bone;
import biomight.system.vascular.arteries.pelvis.CommonIliacArtery;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the TrochanterHead Artery
 *************************************************************************************/


public class TrochanterHead extends Bone {
	private TrochanterHead trochanterHead;
	private Osteocytes osteocytes;
	private FoveaCapitis FoveaCapitis;
	
	
	public TrochanterHead()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.TrochanterHeadRef, null, null);
	}

	public TrochanterHead(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public TrochanterHead(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public TrochanterHead(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/TrochanterHead.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="TrochanterHead.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING TrochanterHead METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the TrochanterHead - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the TrochanterHead MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate TrochanterHead Osteocytes: " + parentID);	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating TrochanterHead Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("TrochanterHeadOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("TrochanterHeadOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("TrochanterHead Osteocytes completed: " + bioMightTransform.getId());		
				
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting TrochanterHeadInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.TrochanterHeadRef, parentID);
				System.out.println("Have TrochanterHead Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - TrochanterHead");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of TrochanterHeads and build them into the model
			// In the default case, we get one instance of the TrochanterHead for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("TrochanterHead NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created TrochanterHead: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate TrochanterHead Endothelium: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating TrochanterHead Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("TrochanterHeadOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("TrochanterHeadOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("TrochanterHead Osteocytes completed: " + bioMightTransform.getId());		
		
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateTrochanterHead Completed");
		
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
		// Generate the TrochanterHeadEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the TrochanterHeadEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.25;
		
			// TrochanterHead
			if (componentID.equals("TrochanterHead:01")) 
			{	
				// Generate the TrochanterHead
				double[] startPos = {3.50, -30.00, -4.75};
				double orient[] = {0, 0, 45.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate TrochanterHeadOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateTrochanterHead("TrochanterHeadOsteocyte:00001", "TrochanterHeadOsteocyte", 
					"TrochanterHeadOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// TrochanterHead
			else if (componentID.equals("TrochanterHead:02")) 
			{	
				double[] startPos = {-3.50, -30.00, -4.75};
				double orient[] = {0, 0, 135.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate TrochanterHeadOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateTrochanterHead("TrochanterHeadOsteocyte:00320", "TrochanterHeadOsteocyte", 
					"TrochanterHeadOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate TrochanterHeadOsteocyte NoParent");
							
			}
			
			System.out.println("Created TrochanterHeadOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - TrochanterHeadOsteocyte");
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
		 "<meta name='BioMightImage' content='TrochanterHead .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='TrochanterHead '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting TrochanterHead X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
				osteocytes.getX3D(true);
		}
		else {
			body = 
				osteocytes.getX3D(true);
		}
				
		
		//System.out.println("TrochanterHead X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
