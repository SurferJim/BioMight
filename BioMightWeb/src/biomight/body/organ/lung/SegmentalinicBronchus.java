/*
 * Created on May 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.lung;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;



/*****************************************************************************
 * SEGMENTALINIC BRONCHUS
 * 
 * @author SurferJim
 *
 * Representation of the SegmentalinicBronchus
 * 
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *****************************************************************************/

public class SegmentalinicBronchus extends BioMightBase {
	protected EpitheliumTissue epithelium;

	// Muscles
		
	// Ligaments
	//private AnnularLigament annularLigament;
	
	// Vessels
	//private AccessoryCephalicVein accessoryCephalicVein;
	
	

	public SegmentalinicBronchus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SegmentalinicBronchusRef, null, null);
	}

	public SegmentalinicBronchus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public SegmentalinicBronchus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public SegmentalinicBronchus(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/SegmentalinicBronchus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
	
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Neck
		// Either get from the Constructor or set up defaults
		System.out.println("SEGMENTAL BRONCHUS - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("SEGMENTAL BRONCHUS - Setting up Default BoundBox");
			//componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("SEGMENTAL BRONCHUS - Setting up internal Bounding Boxes!");
			//boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("SEGMENTAL BRONCHUS - Using incoming Bounding Box Map");		
			//boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("SEGMENTAL BRONCHUS - BoundingBoxes are NULL");						
			}
		}
		
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		this.componentID = parentID;
		
		if (localVP == Constants.VIEW_INTERNAL)
		{			
			/*
			System.out.println("In SegmentalinicBronchus - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In SegmentalinicBronchus - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In SegmentalinicBronchus - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In SegmentalinicBronchus - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In SegmentalinicBronchus - Constructor has Epithelium BoundBox: " + Constants.SegmentalinicBronchusEpitheliumRef);
			else
				System.out.println("In SegmentalinicBronchus - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.SegmentalinicBronchusEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, tempBoundBox);		
			System.out.println("In Bronchus - Epithelium Constructor Set");		
			*/
			
			// Generate the LobarBronchus Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			System.out.println("Creating SegmentalinicBronchus EpitheliumTissue objects: " + parentID);				
			epithelium = new EpitheliumTissue(Constants.SegmentalinicBronchusEpitheliumRef, parentID, bioMightMethods);
	
			initProperty(Constants.SegmentalinicBronchusEpitheliumRef, Constants.SegmentalinicBronchusEpithelium, Constants.SegmentalinicBronchusEpitheliumRef, epithelium.getComponentID());
			System.out.println("Epithelium is created");								
			}
		else if (localVP == Constants.VIEW_FLOATING)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting SegmentalinicBronchusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.SegmentalinicBronchusRef, parentID);	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SegmentalinicBronchus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of SegmentalinicBronchuss and build them into the model
			// In the default case, we get one instance of the SegmentalinicBronchus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("SegmentalinicBronchus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created SegmentalinicBronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating SegmentalinicBronchus Epithelium: " + bioMightTransform.getId());				
				epithelium = new EpitheliumTissue(Constants.SegmentalinicBronchusEpitheliumRef, bioMightTransform.getId(), bioMightMethods);
				initProperty(Constants.SegmentalinicBronchusEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
					// Create the components of the curvature

				}*/
			}
			
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateSegmentalinicBronchus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING SegmentalinicBronchus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
	/**************************************************************************************
	 * GENERATE SEGMENTALINIC BRONCHUS
	 * 
	 * When the user wants to update the model, we call upon the
	 * generate EJB to make the underlying changes
	 * 
	 * @param parentID
	 * @param componentID
	 **************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SegmentalinicBronchus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.20;
			String startID = "";
			
			//*********************************************************************
			// Top Left Branch  (appears on the right from frontal view)- Heads up
			//*********************************************************************
			if (parentID.equals("SegmentalinicBronchus:01")) 
			{	
				//Constants.LeftSuperiorApicoPosteriorBronchusRef 
				startID="SegmentalinicBronchusEpithelium:00001";
							
				// Generate the SegmentalinicBronchus
				double[] startPos = {2.9, -12.25, -3.1};
				double orient[] = {0, 0, -85.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			
				System.out.println("Calling Generate SegmentalinicBronchus: " + componentID + "    " + parentID);				
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
					Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);				
			}			
			// Top Left Branch - Middle heading out
			else if (parentID.equals("SegmentalinicBronchus:02")) 
			{	
				//Constants.LeftSuperiorAnteriorBronchusRef 
				startID="SegmentalinicBronchusEpithelium:00160";
			
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {2.8, -12.25, -3.1};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
					Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}
			// Top Left Branch bottom heading down
			else if (parentID.equals("SegmentalinicBronchus:03")) 
			{	
				//Constants.LeftSuperiorInferiorLingularBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:00320";
			
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {2.70,-11.90, -3.0};
				double orient[] = {0, 0, -85.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
				//		Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}	
			
			//*********************************************
			// Lower Left Branch heading up
			//**********************************************
			else if (parentID.equals("SegmentalinicBronchus:04")) 
			{	
				//Constants.LeftSuperiorSuperiorLingularBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:00480";
							
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {2.65, -14.50, -3.40};
				double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
						Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}			
			// Lower Left Branch  - Descends to corners
			else if (parentID.equals("SegmentalinicBronchus:05")) 
			{	
				//Constants.LeftInferiorSuperiorBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:00640";
				radius = 0.125;
				
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {3.40, -16.0, -3.2};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
						Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}				
			// Lower Left Branch descends inward
			else if (parentID.equals("SegmentalinicBronchus:06")) 
			{	
				//Constants.LeftInferiorAnteroMedialBasalBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:00800";
								
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {2.55, -14.45, -3.35};
				double orient[] = {0, 0, -15};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
						Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}			
			
			
			
			//*****************************************************************
			//
			// RIGHT SIDE
			//
			//*****************************************************************
			
			// Right Branch
			else if (parentID.equals("SegmentalinicBronchus:07")) 
			{	
				//Constants.LeftInferiorPosteriorBasalBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:00960";
								
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-1.85, -12.25, -3.1};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
						Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}
			// Right Branch
			else if (parentID.equals("SegmentalinicBronchus:08")) 
			{	
				//Constants.LeftInferiorLateralBasalBronchusRef)) 
				startID="SegmentalinicBronchusEpithelium:01120";
									
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-1.75,-12.35, -3.1};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, Constants.SegmentalinicBronchusEpitheliumRef, 
						Constants.SegmentalinicBronchusEpitheliumRef, componentID, parentID, currentPoints);							
			}

			// Right Middle Trunk Middle Branch - SegmentalinicBronchus:09
			else if (parentID.equals(Constants.RightSuperiorApicalBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:01280";
									
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-2.0, -12.5, -3.1};
				double orient[] = {0, 0, -45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			
			
			// Bottom Right Trunk - SegmentalinicBronchus:10
			else if (parentID.equals(Constants.RightSuperiorPosteriorBronchusRef)) 
			{	 
				startID="SegmentalinicBronchusEpithelium:01440";
								
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-3.0, -14.5, -3.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			
			
			
			// Right Branch  - SegmentalinicBronchus:11 - BOTTOMEST
			else if (parentID.equals(Constants.RightSuperiorAnteriorBronchusRef)) 
			{	
				 
				startID="SegmentalinicBronchusEpithelium:01600";
				radius = 0.150;
				
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-2.75, -15.5, -3.6};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			
			
			// Right Branch  - SegmentalinicBronchus:12  ---  BOTTOMEST 
			else if (parentID.equals(Constants.RightMiddleLateralBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:01760";
				radius = 0.150;
				
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-2.75, -15.50, -3.6};
				double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}
			
			// BOTTOM TRUNK - top Branch  - SegmentalinicBronchus:13
			else if (parentID.equals(Constants.RightMiddleMedialBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:01920";
									
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-3.0, -14.5, -3.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			// Right Branch  - SegmentalinicBronchus:14
			else if (parentID.equals(Constants.RightInferiorSuperiorBronchusRef)) 
			{	 
				startID="SegmentalinicBronchusEpithelium:02080";
								
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-3.0, -14.60, -3.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			// Right Branch - SegmentalinicBronchus:15
			else if (parentID.equals(Constants.RightInferiorMedialBasalBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:02240";
										
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-2.80, -13.85, -2.85};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			// Right Branch - SegmentalinicBronchus:16
			else if (parentID.equals(Constants.RightInferiorAnteriorBasalBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:02400";
				radius = 0.150;
				
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-3.75,-16.25, -2.95}; 
				double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
					"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			// Right Branch - SegmentalinicBronchus:17
			else if (parentID.equals(Constants.RightInferiorLateralBasalBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:02560";
									
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-1.15, -16.5, -2.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
				//	"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			// Right Branch - SegmentalinicBronchus:18
			else if (parentID.equals(Constants.RightInferiorPosteriorBasalBronchusRef)) 
			{	
				startID="SegmentalinicBronchusEpithelium:02720";
								
				// Generate the SegmentalinicBronchusEpithelium
				double[] startPos = {-3.5,-15.5, -2.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate SegmentalinicBronchusEpithelium: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateSegmentalinicBronchus(startID, "SegmentalinicBronchusEpithelium", 
				//	"SegmentalinicBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			else
			{
				
			}
			
			
			
			System.out.println("Created SegmentalinicBronchusEpithelium at " + startID + " using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SegmentalinicBronchusEpithelium");
			throw new ServerException("Remote Exception SegmentalinicBronchusEpithelium():", e); 	
		}
	}
	
	
	
	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		// BONES
		property = new BioMightPropertyView();
		property.setPropertyName("Humerus");
		property.setCanonicalName(Constants.Humerus);
		properties.add(property);		
		
			property = new BioMightPropertyView();
		property.setPropertyName("Palmaris Longus Muscle");
		property.setCanonicalName(Constants.PalmarisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Supinator Muscle");
		property.setCanonicalName(Constants.SupinatorMuscle);
		properties.add(property);		

		// LIGAMENTS
		property = new BioMightPropertyView();
		property.setPropertyName("Ligaments");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Annular Ligament");
		property.setCanonicalName(Constants.AnnularLigament);
		properties.add(property);		
		
		// VESSELS
		property = new BioMightPropertyView();
		property.setPropertyName("Vascular");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Accessory Cephalic Vein");
		property.setCanonicalName(Constants.AccessoryCephalicVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Brachial Vein");
		property.setCanonicalName(Constants.BrachialVein);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Basilic Vein");
		property.setCanonicalName(Constants.BasilicVein);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("BrachioCephalic Artery");
		property.setCanonicalName(Constants.BrachioCephalicArtery);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Cephalic Vein");
		property.setCanonicalName(Constants.CephalicVein);
		properties.add(property);		
	}
	
	
	public void initMethods() {
  
	
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Flex");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Punch");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Block");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Swing");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);	
	}
		
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the SegmentalinicBronchus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the SegmentalinicBronchus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SegmentalinicBronchus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SegmentalinicBronchus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
			epithelium.getX3D(true)  
		 ; 
			
	
		//System.out.println("SegmentalinicBronchus X3D: " + body);		
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the LobarBronchus.  
	 * This routine will be called when looking at an individual LobarBronchus with
	 * default values
	 * 
	 * @return
	 ****************************************************************************/
	private BioMightBoundBox setupDefaultBoundBox(String parentID) 
	{
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		
		//**********************************************************************
		// SEGMENTALINIC BRONCHUS BOUND BOX		
		//
		// Set up the Bounding Box for the Chest
		// For default model, length of chest is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);
		
		// Setuo the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// SEGMENTALINIC BRONCHUS - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusRef, bioMightConnector);
		
		//********************************************	
		// SEGMENTALINIC BRONCHUS - VASCULAR CONNECTORS  
		//********************************************
	
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// SEGMENTALINIC BRONCHUS - MUSCULAR CONNECTORS
		//********************************************

		// Stuff the Connectors into the Bounding Box 
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		return (bioBoundBox);	
	}	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Chest.   These boxes will define
	 *  the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBoxIn) 
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes
		HashMap boundingBoxMap = new HashMap();
		
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
			
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);

		// Initialize the BoundBoxes. This is used for
		// collections such as arms, legs,lungs,etc
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;

		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			System.out.println("LobarBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Chest
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-9.0);
		zPos= new BigDecimal(-1.0);
		
		xVector= new BigDecimal(9.0);
		yVector= new BigDecimal(8.0); 
		zVector= new BigDecimal(4.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Chest Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -9.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ChestEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("ChestEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		boundingBoxMap.put(Constants.ChestEpitheliumRef, bioBoundBox);
		
		
		//********************************************************************* 
		// TRACHEA BOUNDBOX
		// Set up the Bounding Box for the Trachea
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-6.0);
		zPos= new BigDecimal(-4.0);
		
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Trachea Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.TracheaEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaEpitheliumRef, bioMightConnector);
		
		// Trachea Muscle Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.00, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, "TracheaMuscle","connType");
		bioMightConnectors.setBioMightConnector("TracheaMuscle", bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.TracheaRef, bioBoundBox);
		
		
		//********************************************************************* 
		// ESOPHAGUS BOUNDBOX
		// Set up the Bounding Box for the Esophagus
		// On a porportioned human, the Esophagus lie in the middle of the... 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-6.0);
		zPos= new BigDecimal(-5.5);
		
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(5.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// EsophagusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.EsophagusRef, bioBoundBox);


		//********************************************************************* 
		// BRONCHI BOUND BOXES
		// Set up the Bounding Box for the Bronchi
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBoxes = new BioMightBoundBoxes();
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftBronchusRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT BRONCHI BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightBronchusRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Bronchi 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.BronchiRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
			
	
}
