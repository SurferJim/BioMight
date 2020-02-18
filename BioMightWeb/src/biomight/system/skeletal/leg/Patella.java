/*
* Created on Apr 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.leg;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataSecurityException;
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
import biomight.view.BioMightTransforms;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class Patella extends Bone {

	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private RadialNotch radialNotch;
	private UlnaCoronoidProcess ulnaCoronoidProcess;
	private SemiUlnarNotch semiUlnarNotch;
	private Olecranon olecranon;
	private Osteocytes osteocytes;
	

	public Patella()
	{
		create(Constants.PatellaRef, null);
	}

	public Patella(String parentID)
	{
		create(parentID, null);
	}

	public Patella(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Patella.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Patella.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Patella METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the Patella - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the Patella MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate Patella Osteocyte: " + parentID);	
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
	
				System.out.println("Creating Patella Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("PatellaOsteocytes", bioMightTransform.getId(), bioMightMethods);
				System.out.println("Patella Osteocytes completed: " + bioMightTransform.getId());		
				}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting PatellaInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.PatellaRef, parentID);
				System.out.println("Have Patella Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Patella");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			System.out.println("Created the Patella for parent: " + parentID);
			
			// Run through the collection of Patellas and build them into the model
			// In the default case, we get one instance of the Patella for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Patella NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created Patella: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Calling generate Patella Osteocyte: " + componentID);	
				// Generate the Patella OStocytes if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating Patella Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("PatellaOsteocytes", bioMightTransform.getId(), bioMightMethods);
				System.out.println("Patella Osteocytes completed: " + bioMightTransform.getId());		
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreatePatella Completed");
		
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
		// Generate the PatellaOsteocyte		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PatellaOsteocyte: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
	
			double radius = 0.17;
		
			// Patella
			if (componentID.equals("Patella:01")) 
			{	
				// Generate the PatellaOsteocyte
				double[] startPos = {1.75, -27.75, -2.6};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate PatellaOsteocyte: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generatePatella("PatellaOsteocyte:00001", "PatellaOsteocyte", 
				//	"PatellaOsteocyte", componentID, parentID, currentPoints);			
					
			}
			// Right 
			else if (componentID.equals("Patella:02")) 
			{	
				double[] startPos = {-1.40, -27.75, -2.6};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate PatellaOsteocyte: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generatePatella("PatellaOsteocyte:00320", "PatellaOsteocyte", 
				//	"PatellaOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate PatellaOsteocyte NoParent");
							
			}
			
			System.out.println("Created PatellaOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PatellaOsteocyte");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
		
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Patella
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Patella.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Patella'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = osteocytes.getX3D(true);
		
		System.out.println("Patella X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}		
	

}
