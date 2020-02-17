/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;




import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.shoulder.DeltoideusMuscle;
import biomight.system.muscular.shoulder.InfraSpinatusMuscle;
import biomight.system.muscular.shoulder.SubScapularisMuscle;
import biomight.system.muscular.shoulder.SupraSpinatusMuscle;
import biomight.system.muscular.shoulder.TeresMajorMuscle;
import biomight.system.muscular.shoulder.TeresMinorMuscle;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**********************************************************************************
 * @author SurferJim
 *
 * Representation of a Shoulder
 **********************************************************************************/

public class Shoulder extends BodyPart {
	protected EpitheliumTissue epithelium;
	
	// Muscles
	protected DeltoideusMuscle deltoideusMuscle;
	protected InfraSpinatusMuscle infraSpinatusMuscle; 
	protected SubScapularisMuscle subScapularisMuscle;
	protected SupraSpinatusMuscle supraSpinatusMuscle;
	protected TeresMajorMuscle teresMajorMuscle; 
	protected TeresMinorMuscle teresMinorMuscle; 
	
	
	
	/************************************************************************
	 * Shoulder Constructor 
	 *
	 ***********************************************************************/
	public Shoulder()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ShoulderRef, null, null);
	}

	/************************************************************************
	 * Shoulder Constructor 
	 *
	 ***********************************************************************/
	public Shoulder(String parentID)
	{
		//System.out.println("Calling parameterized Shoulder Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Shoulder Constructor 
	 *
	 ***********************************************************************/
	public Shoulder(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Shoulder with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Shoulder
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Shoulder.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Shoulder
		// Either get from the Constructor or set up defaults
		System.out.println("Shoulder - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		//if (bioMightConstruct == null)
		//{
		///	System.out.println("Shoulder - Setting up Default BoundBox");
		//	componentBoundBox = setupDefaultBoundBox(parentID);		

		//	System.out.println("Shoulder - Setting up internal Bounding Boxes!");
		//	boundingBoxes = setupBoundBoxes(componentBoundBox);
		//}
		//else 
		//{
		//	System.out.println("Shoulder - Using incoming Bounding Box Map");		
		//	boundingBoxes = bioMightConstruct.getBoundBoxMap();
		//	if (boundingBoxes==null){
		//		System.out.println("Shoulder - BoundingBoxes are NULL");						
		//	}
		//}
		
	
		// Set up a Constructor that will be used to pass information into the components
		//BioMightConstruct bioConstruct = null; 
		
		this.componentID = parentID;
		
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{					
			/*
			System.out.println("In Shoulder - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Shoulder - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Shoulder - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Shoulder - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.ShoulderEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Shoulder - Constructor has Epithelium BoundBox: " + Constants.ShoulderEpitheliumRef);
			else
				System.out.println("In Shoulder - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.ShoulderEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.ShoulderEpitheliumRef, tempBoundBox);		
			System.out.println("In Shoulder - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Shoulder we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftShoulderRef)) 
			{
				startID="ShoulderEpithelium:00001";
			}			
			// We are creating the Esophagus for the Shoulder
			else if (parentID.equals(Constants.RightShoulderRef)) 
			{	
				startID="ShoulderEpithelium:00480";
			}
		
			int localVP = Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
		
			System.out.println("Creating Shoulder Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.ShoulderEpitheliumRef,  Constants.ShoulderEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
			//epithelium = new EpitheliumTissue(localVP, localLOD, "BackEpithelium:00001", Constants.BackEpitheliumRef,  Constants.BackEpitheliumRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);

			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Shoulder - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.ShoulderEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("ShoulderEpithelium is created");			

		
			System.out.println("Creating the DeltoideusMuscle for parent: " + parentID);
			deltoideusMuscle = new DeltoideusMuscle(parentID, bioMightMethods);
			initProperty("DeltoideusMuscle", Constants.DeltoideusMuscle, Constants.DeltoideusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the DeltoideusMuscle");
		
			System.out.println("Creating the InterSpinatusMuscle for parent: " + parentID);
			
			infraSpinatusMuscle = new InfraSpinatusMuscle(localVP, localLOD, parentID, null, bioMightMethods);
			initProperty("InterSpinatusMuscle", Constants.InterSpinatusMuscle, Constants.InterSpinatusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the InterSpinatusMuscle");
			
			System.out.println("Creating the SubScapularisMuscle for parent: " + parentID);
			subScapularisMuscle = new SubScapularisMuscle(parentID, bioMightMethods);
			initProperty("InterSpinatusMuscle", Constants.InterSpinatusMuscle, Constants.InterSpinatusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SubScapularisMuscle");
			
			System.out.println("Creating the SupraSpinatusMuscle for parent: " + parentID);
			supraSpinatusMuscle = new SupraSpinatusMuscle(parentID, bioMightMethods);
			initProperty("InterSpinatusMuscle", Constants.InterSpinatusMuscle, Constants.InterSpinatusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SupraSpinatusMuscle");
			
			System.out.println("Creating the TeresMajorMuscle for parent: " + parentID);
			teresMajorMuscle = new TeresMajorMuscle(parentID, bioMightMethods);
			initProperty("TeresMajorMuscle", Constants.TeresMajorMuscle, Constants.TeresMajorMuscleRef, epithelium.getComponentID());
			System.out.println("Created the TeresMajorMuscle");
			
			System.out.println("Creating the TeresMinorMuscle for parent: " + parentID);
			teresMinorMuscle = new TeresMinorMuscle(parentID, bioMightMethods);
			initProperty("TeresMinorMuscle", Constants.TeresMinorMuscle, Constants.TeresMinorMuscleRef, epithelium.getComponentID());
			System.out.println("Created the TeresMinorMuscle");
			
			System.out.println("Shoulder Instance is created : " + parentID);
		
		
		}
		else if (viewPerspective == Constants.VIEW_FLOATING)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ShoulderInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ShoulderRef, parentID);	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Shoulder");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of Shoulders and build them into the model
			// In the default case, we get one instance of the Shoulder for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Shoulder NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created Shoulder: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating Shoulder Epithelium: " + bioMightTransform.getId());				
				epithelium = new EpitheliumTissue("ShoulderEpithelium", bioMightTransform.getId(), bioMightMethods);
				initProperty("ShoulderEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
					// Create the components of the curvature

				}*/
			}
			
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateShoulder Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Shoulder METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Acetabulum");
		property.setCanonicalName(Constants.Acetabulum);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Gyrate");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Shoulder
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Shoulder.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Shoulder'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =
			epithelium.getX3D(true) +
			deltoideusMuscle.getX3D(true) +
			//infraSpinatusMuscle.getX3D(true) +
			subScapularisMuscle.getX3D(true) +
			supraSpinatusMuscle.getX3D(true) +
			teresMajorMuscle.getX3D(true) +
			teresMinorMuscle.getX3D(true);
		//System.out.println("Shoulder X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public ArrayList getProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Shoulder");
		property.setCanonicalName(Constants.Shoulder);
		properties.add(property);
			
		
		return properties;
	}
	
	
	public ArrayList getMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Rotate");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);	
			
		return methods;
	
	}
		
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Shoulder.  
	 * This routine will be called when looking at an individual Shoulder with
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
		// SHOULDERS BOUND BOX		
		//
		// Set up the Bounding Box for the Shoulder
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
		// SHOULDER - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ShoulderEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ShoulderEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// SHOULDER - VASCULAR CONNECTORS  
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
		// SHOULDER - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// SHOULDER - SKELETAL CONNECTORS
		//********************************************

		// ThoracicVertebrae T6 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		
		// Stuff the Connectors into the Bounding Box 
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		return (bioBoundBox);	
	}	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Shoulder.   These boxes will define
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
			System.out.println("Shoulder - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// SHOULDERS BOUND BOXES
		// Set up the Bounding Box for the Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT SHOULDERS BOUNDBOX
		// Set up the Bounding Box for the Left Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
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
			
		// ShoulderEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ShoulderEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ShoulderEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftShoulderRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT SHOULDERS BOUNDBOX
		// Set up the Bounding Box for the Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ShoulderEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ShoulderEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ShoulderEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightShoulderRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Shoulder 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ShouldersRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
	
}
