/*
- * Created on Sep 5, 2006
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
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the CervicalVertebra
 *************************************************************************************/


public class CervicalVertebra extends Vertebra {
	private Osteocytes osteocytes;
	
	public CervicalVertebra()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CervicalVertebraRef, null, null);
	}

	public CervicalVertebra(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public CervicalVertebra(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public CervicalVertebra(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/CervicalVertebra.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="CervicalVertebra.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING CervicalVertebra METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the CervicalVertebra - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the CervicalVertebra			
				System.out.println("Getting the CervicalVertebra MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating CervicalVertebra Osteocytes:" + parentID);		
				osteocytes = new Osteocytes("CervicalVertebraOsteocyte", parentID, bioMightMethods);
				initProperty("CervicalVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("CervicalVertebra Osteocytes completed: " + parentID);						
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CervicalVertebraInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.CervicalVertebraRef, parentID);
				System.out.println("Have CervicalVertebra Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CervicalVertebra");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of CervicalVertebras and build them into the model
			// In the default case, we get one instance of the CervicalVertebra for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("CervicalVertebra NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created CervicalVertebra: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate CervicalVertebra Osteocytes: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating CervicalVertebra Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("CervicalVertebraOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("CervicalVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("CervicalVertebra Osteocytes completed: " + bioMightTransform.getId());			
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateCervicalVertebra Completed");
		
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
		// Generate the CervicalVertebraEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CervicalVertebraOsteocyte: " + componentID + "   parent: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.45;
			
			// CervicalVertebra
			if (componentID.equals("CervicalVertebra:01")) 
			{	
				// Generate the CervicalVertebraEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.0, -1.8, -3.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:00001", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// CervicalVertebra
			else if (componentID.equals("CervicalVertebra:02")) 
			{	
				radius = 0.46;
				double[] startPos = {0.0, -2.35, -3.30};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:00320", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("CervicalVertebra:03")) 
			{	
				radius = 0.465;
				double[] startPos = {0.0, -2.95, -3.40};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Call	ing Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:00620", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("CervicalVertebra:04")) 
			{	
				radius = 0.48;
				double[] startPos = {0.0, -3.650, -3.90};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:00860", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("CervicalVertebra:05")) 
			{	
				radius = 0.5;
				double[] startPos = {0.0, -4.60, -4.15};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:001020", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("CervicalVertebra:06")) 
			{	
				radius = 0.5;
				double[] startPos = {0.0, -5.55, -4.55};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:001220", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("CervicalVertebra:07")) 
			{	
				double[] startPos = {0.0, -6.50, -4.8};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CervicalVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCervicalVertebra("CervicalVertebraOsteocyte:01480", "CervicalVertebraOsteocyte", 
					"CervicalVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate CervicalVertebraOsteocyte NoParent");
							
			}
			
			System.out.println("Created CervicalVertebraOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CervicalVertebraOsteocyte");
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
		 "<meta name='BioMightImage' content='CervicalVertebra .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CervicalVertebra '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting CervicalVertebra X3D");
		if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
				osteocytes.getX3D(true);
				//trochanterHead.getX3D(true) + 
		}
		else {
			body = 
				osteocytes.getX3D(true) ;
				//trochanterHead.getX3D(true) +
		}
				
		
		//System.out.println("CervicalVertebra X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
