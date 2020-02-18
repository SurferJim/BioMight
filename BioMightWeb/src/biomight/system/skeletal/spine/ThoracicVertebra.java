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
 * Representation of the ThoracicVertebra
 *************************************************************************************/


public class ThoracicVertebra extends Vertebra {
	private Osteocytes osteocytes;
	
	public ThoracicVertebra()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ThoracicVertebraRef, null, null);
	}

	public ThoracicVertebra(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public ThoracicVertebra(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public ThoracicVertebra(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/ThoracicVertebra.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="ThoracicVertebra.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ThoracicVertebra METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the ThoracicVertebra - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the ThoracicVertebra			
				System.out.println("Getting the ThoracicVertebra MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating ThoracicVertebra Osteocytes:" + parentID);		
				osteocytes = new Osteocytes("ThoracicVertebraOsteocyte", parentID, bioMightMethods);
				initProperty("ThoracicVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("ThoracicVertebra Osteocytes completed: " + parentID);						
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ThoracicVertebraInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ThoracicVertebraRef, parentID);
				System.out.println("Have ThoracicVertebra Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ThoracicVertebra");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ThoracicVertebras and build them into the model
			// In the default case, we get one instance of the ThoracicVertebra for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ThoracicVertebra NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created ThoracicVertebra: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate ThoracicVertebra Osteocytes: " + parentID);	
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				System.out.println("Creating ThoracicVertebra Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("ThoracicVertebraOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("ThoracicVertebraOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("ThoracicVertebra Osteocytes completed: " + bioMightTransform.getId());			
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateThoracicVertebra Completed");
		
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
		// Generate the ThoracicVertebraEndothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ThoracicVertebraOsteocyte: " + componentID + "   parent: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.50;
			
			// ThoracicVertebra
			if (componentID.equals("ThoracicVertebra:01")) 
			{	
				// Generate the ThoracicVertebraEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.0, -7.50, -5.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:00001", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// ThoracicVertebra
			else if (componentID.equals("ThoracicVertebra:02")) 
			{	
				double[] startPos = {0.0, -8.30, -5.2};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:00320", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("ThoracicVertebra:03")) 
			{	
				double[] startPos = {0.0, -9.30, -5.60}	;
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:00640", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("ThoracicVertebra:04")) 
			{	
				double[] startPos = {0.0, -10.30, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:00860", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("ThoracicVertebra:05")) 
			{	
				double[] startPos = {0.0, -11.30, -6.3};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01020", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("ThoracicVertebra:06")) 
			{	
				double[] startPos = {0.0, -12.4, -6.3};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01200", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (componentID.equals("ThoracicVertebra:07")) 
			{	
				double[] startPos = {0.0, -13.50, -6.30};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01320", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte NoParent");
							
			}
			else if (componentID.equals("ThoracicVertebra:08")) 
			{	
				double[] startPos = {0.0, -14.6, -6.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01520", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte NoParent");
							
			}		
			else if (componentID.equals("ThoracicVertebra:09")) 
			{	
				double[] startPos = {0.0, -15.7, -6.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01720", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}			
			else if (componentID.equals("ThoracicVertebra:10")) 
			{	
				double[] startPos = {0.0, -16.8, -5.8};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:01920", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}		
			else if (componentID.equals("ThoracicVertebra:11")) 
			{	
				double[] startPos = {0.0, -17.9, -5.60};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:02120", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}	
			else if (componentID.equals("ThoracicVertebra:12")) 
			{	
				double[] startPos = {0.0, -19.0, -5.6};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateThoracicVertebra("ThoracicVertebraOsteocyte:02320", "ThoracicVertebraOsteocyte", 
					"ThoracicVertebraOsteocyte", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ThoracicVertebraOsteocyte NoParent");	
			}
			
			
			
			System.out.println("Created ThoracicVertebraOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ThoracicVertebraOsteocyte");
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
		 "<meta name='BioMightImage' content='ThoracicVertebra .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ThoracicVertebra '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body ="";
		System.out.println("Getting ThoracicVertebra X3D");
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
				
		
		//System.out.println("ThoracicVertebra X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
