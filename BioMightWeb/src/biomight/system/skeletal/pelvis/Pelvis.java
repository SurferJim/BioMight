/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.pelvis;

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

import java.util.ArrayList;

import javax.naming.InitialContext;



/*******************************************************************************************
 * @author SurferJim 01/23/2017
 *
 * Representation of the Pelvis
 * 
 ******************************************************************************************/

public class Pelvis extends Bone {
	private SymphysisPubis symphysisPubis;
	private Iliums iliums;
	private Ischium ischium;
	private Pubis pubis;
	private Osteocytes osteocytes;
	
	
	public Pelvis()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PelvisRef, null, null);
	}

	public Pelvis(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Pelvis(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Pelviss Create");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Pelvis.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PelvisInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PelvisRef, parentID);
			System.out.println("Have Pelvis Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Pelvis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";
			
		// Run through the collection of Pelviss and build them into the model
		// In the default case, we get one instance of the Pelvis for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Pelvis NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Pelvis we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Pelvis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE  || localVP == Constants.VIEW_DETACHED) {
				
				// Generate the Pelvis Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
						
				System.out.println("Creating Pelvis Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("PelvisOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("PelvisOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Pelvis Osteocytes completed: " + bioMightTransform.getId());		
	
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;

				//System.out.println("Creating the Iliums for ParentID: " + bioMightTransform.getId());
				//iliums = new Iliums(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("Iliums", Constants.Iliums, Constants.IliumsRef, iliums.getComponentID());
				//System.out.println("Created the Iliums");
					
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Pelvis Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				
				// Generate the Pelvis Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				System.out.println("Creating Pelvis Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("PelvisOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("PelvisOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Pelvis Osteocytes completed: " + bioMightTransform.getId());		
				
				/*			
				System.out.println("Creating IliumRightLateralLobe : " + bioMightTransform.getId());				
				IliumRightLateralLobe = new IliumRightLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.IliumQuadrateLobe, Constants.IliumQuadrateLobeRef, bioMightTransform.getId());

				*/	
			}
				
		}
		//initProperties();
		//initMethods();
		
		System.out.println("Create Pelvis Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Pelvis METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		
		/*******************************************************************
		 * generate the Pelvis
		 * 
		 * @param parentID
		 * @param componentID
		 ****************************************************************/
		
		public void generate(String parentID, String componentID)
		{
			// Generate the PelvisOsteocytes		
			BioMightSkeletalBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the PelvisOsteocytes: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
		
				double radius = 0.15;
			
				if (parentID.equals("Abdomen:01")) 
				{	
					// Generate the Left PelvisOsteocytes
					double[] startPos = {1.0, -29.75, -7.5};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
					System.out.println("Calling Generate PelvisOsteocyte IliumLeft: " + componentID + "    " + parentID);	
					int success = bioMightBean.generatePelvis("PelvisOsteocyte:00001", "PelvisOsteocyte", 
						"IliumLeft", componentID, parentID, currentPoints);								

					// Generate the Right PelvisOsteocytes
					double[] startPos2 = {-1.0, -29.75, -7.5};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos2, radius, 8);
					
					System.out.println("Calling Generate PelvisOsteocyte IliumRight: " + componentID + "    " + parentID);
					success = bioMightBean.generatePelvis("PelvisOsteocyte:00360", "PelvisOsteocyte", 
						"IliumRight", componentID, parentID, currentPoints);				
					
					
					// Generate the Left PelvisOsteocytes
					double[] ischiumStartPosLeft = {4.0, -30.5, -6.60};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, ischiumStartPosLeft, radius, 8);
					
					System.out.println("Calling Generate PelvisOsteocyte Ischium: " + componentID + "    " + parentID);
					success = bioMightBean.generatePelvis("PelvisOsteocyte:00720", "PelvisOsteocyte", 
						"IschiumLeft", componentID, parentID, currentPoints);	
					
					
					// Generate the Right PelvisOsteocytes
					double[] ischiumStartPosRight = {-4.0, -30.5, -6.60};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, ischiumStartPosRight, radius, 8);
					
					System.out.println("Calling Generate PelvisOsteocyte Ischium: " + componentID + "    " + parentID);
					success = bioMightBean.generatePelvis("PelvisOsteocyte:01080", "PelvisOsteocyte", 
						"IschiumRight", componentID, parentID, currentPoints);	
		
					
					// Generate the Sacrum
					//double[] sacrumStartPos = {0.0, -29.5, -7.5};
					//currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, sacrumStartPos, radius, 8);
					
					//System.out.println("Calling Generate PelvisOsteocyte: " + componentID + "    " + parentID);
					//success = bioMightBean.generatePelvis("PelvisOsteocyte:01460", "PelvisOsteocyte", 
					//	"Sacrum", componentID, parentID, currentPoints);	
	
	
					radius = 0.5;
					// Generate the Left PelvisOsteocytes
					double[] ischiumLoopStartPosLeft = {3.25, -35., -6.25};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, ischiumLoopStartPosLeft, radius, 8);
					
					System.out.println("Calling Generate PelvisOsteocyte Loop: " + componentID + "    " + parentID);
					success = bioMightBean.generatePelvis("PelvisOsteocyte:01420", "PelvisOsteocyte", 
						"IschiumLoopLeft", componentID, parentID, currentPoints);	
					
					
					// Generate the Right PelvisOsteocytes
					double[] ischiumLoopStartPosRight = {-3.25, -35.0, -6.25};
					currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, ischiumLoopStartPosRight, radius, 8);
					
					System.out.println("Calling Generate PelvisOsteocyte Loop: " + componentID + "    " + parentID);
					success = bioMightBean.generatePelvis("PelvisOsteocyte:01780", "PelvisOsteocyte", 
						"IschiumLoopRight", componentID, parentID, currentPoints);	
				}			
	
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate PelvisOsteocytes NoParent");
				}
				
				System.out.println("Created PelvisOsteocytes Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - PelvisOsteocytes");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		}
		
	
	
	public void redraw(String parentID)
	{
		/*int viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Sclera Eye is created");
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
		}
		*/
		
		System.out.println("Pelvis Redraw");
	}	
	
	
	public void initProperties() {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
		
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Pelvis
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Pelvis.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Pelvis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = osteocytes.getX3D(true);
		
		//System.out.println("Pelvis X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		body+= "<Viewpoint DEF='Viewpoint_Pelvis'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -30.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";

		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
