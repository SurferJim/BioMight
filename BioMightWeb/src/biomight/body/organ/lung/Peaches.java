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
 * LOBAR BRONCHUS
 * 
 * @author SurferJim
 *
 * Representation of the LobarBronchus.   In the prototypical human,
 * there are 5 Lobar Bronchus, each going to a lobe of the Lung. Two
 * on the left side, and three on the right. Contain criss-crossing
 * muscle and epithelial tissue.
 * 
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *****************************************************************************/

public class Peaches extends BioMightBase {
	protected EpitheliumTissue epithelium;

	// Muscles
		
	// Ligaments
	//private AnnularLigament annularLigament;
	
	// Vessels
	//private AccessoryCephalicVein accessoryCephalicVein;
	

	/********************************************************************
	 * LOBAR BRONCHUS CONSTRUCTOR
	 * 
	 * @param parentID
	 * @param bioMightConstruct
	 * @param bioMightMethods
	 *******************************************************************************/
	public Peaches(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{

		this.setImage("images/LobarBronchus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
	
		/****
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Neck
		// Either get from the Constructor or set up defaults
		System.out.println("LOBAR BRONCHUS - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("LOBAR BRONCHUS - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("LOBAR BRONCHUS - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("LOBAR BRONCHUS - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("LOBAR BRONCHUS - BoundingBoxes are NULL");						
			}
		}
		
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		*******/

		this.componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{
			
			/*******
			System.out.println("In LobarBronchus - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In LobarBronchus - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In LobarBronchus - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In LobarBronchus - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.LobarBronchusEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In LobarBronchus - Constructor has Epithelium BoundBox: " + Constants.LobarBronchusEpitheliumRef);
			else
				System.out.println("In LobarBronchus - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.LobarBronchusEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.LobarBronchusEpitheliumRef, tempBoundBox);		
			System.out.println("In LobarBronchus - Epithelium Constructor Set");
			*****/
			
			// Generate the LobarBronchus 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			System.out.println("Creating LobarBronchus EpitheliumTissue objects: " + parentID);				
			epithelium = new EpitheliumTissue(Constants.LobarBronchusEpitheliumRef, parentID, bioMightMethods);
					
			initProperty(Constants.LobarBronchusEpitheliumRef, Constants.LobarBronchusEpithelium, Constants.LobarBronchusEpitheliumRef, epithelium.getComponentID());
			System.out.println("LobarBronchusEpithelium is created");						
		}
		else if (localVP == Constants.VIEW_FLOATING)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LobarBronchusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LobarBronchusRef, parentID);	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LobarBronchus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of LobarBronchuss and build them into the model
			// In the default case, we get one instance of the LobarBronchus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LobarBronchus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LobarBronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating LobarBronchus Epithelium: " + bioMightTransform.getId());				
				epithelium = new EpitheliumTissue("LobarBronchusEpithelium", bioMightTransform.getId(), bioMightMethods);
				initProperty("LobarBronchusEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
					// Create the components of the curvature

				}*/
			}
			
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateLobarBronchus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LobarBronchus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	/**************************************************************************************
	 * GENERATE LOBAR BRONCHUS
	 * 
	 * When the user wants to update the model, we call upon the
	 * generate EJB to make the underlying changes
	 * 
	 * @param parentID
	 * @param componentID
	 **************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the LobarBronchus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LobarBronchusEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.20;
				
			// Left Branch - Heads out and upward
			if (parentID.equals("LobarBronchus:01")) 
			{	
				
				// Generate the LobarBronchus
				double[] startPos = {1.90, -13.0, -3.15};
				radius = 0.25;
				double orient[] = {0, 0, -45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
				
				System.out.println("Calling Generate LobarBronchus: " + componentID + "    " + parentID);
				int success = bioMightBean.generateLobarBronchus("LobarBronchusEpithelium:00001", "LobarBronchusEpithelium", 
					"LobarBronchusEpithelium", componentID, parentID, currentPoints);			
					
			}			
			// Left Branch - Heads downward
			else if (parentID.equals("LobarBronchus:02")) 
			{	
				// Generate the LobarBronchus
				double[] startPos = {1.80, -13.00, -3.15};
				double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
				
				System.out.println("Calling Generate LobarBronchus: " + componentID + "    " + parentID);
				int success = bioMightBean.generateLobarBronchus("LobarBronchusEpithelium:00160", "LobarBronchusEpithelium", 
					"LobarBronchusEpithelium", componentID, parentID, currentPoints);							
			}
			
			//************************************************
			// Right Branch
			//************************************************
			
			else if (parentID.equals("LobarBronchus:03")) 
			{	
				// Generate the LobarBronchusEpithelium 
				double[] startPos = {-1.25, -12.35, -3.1};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate LobarBronchus: " + componentID + "    " + parentID);
				int success = bioMightBean.generateLobarBronchus("LobarBronchusEpithelium:00320", "LobarBronchusEpithelium", 
					"LobarBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			
			
			// Right Branch
			else if (parentID.equals("LobarBronchus:04")) 
			{	
				// Generate the LobarBronchusEpithelium of the stomach
				// Create 5 sections
				radius = 0.25;
				double[] startPos = {-2.5, -14.75, -3.5};	
				double orient[] = {0, 0, 135};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate LobarBronchus: " + componentID + "    " + parentID);
				int success = bioMightBean.generateLobarBronchus("LobarBronchusEpithelium:00480", "LobarBronchusEpithelium", 
					"LobarBronchusEpithelium", componentID, parentID, currentPoints);							
			}			
			// Right Branch - Closest to Center of body lnogest bronchus
			else if (parentID.equals("LobarBronchus:05")) 
			{	
				// Generate the LobarBronchusEpithelium
				// Create 5 sections
				radius = 0.25;
				double[] startPos = {-1.2, -12.35, -3.2};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate LobarBronchus: " + componentID + "    " + parentID);
				int success = bioMightBean.generateLobarBronchus("LobarBronchusEpithelium:00560", "LobarBronchusEpithelium", 
					"LobarBronchusEpithelium", componentID, parentID, currentPoints);							
			}	
			
			System.out.println("Created LobarBronchus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LobarBronchus");
			throw new ServerException("Remote Exception generateLobarBronchus():", e); 	
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
		property.setPropertyName("Ulna");
		property.setCanonicalName(Constants.Ulna);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Radius");
		property.setCanonicalName(Constants.Radius);
		properties.add(property);	
		
		// MUSCLES
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Anconeus Muscle");
		property.setCanonicalName(Constants.AnconeusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Brachialis Muscle");
		property.setCanonicalName(Constants.BrachialisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Triceps Brachii Muscle");
		property.setCanonicalName(Constants.TricepsBrachiiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Brachioradialis Muscle");
		property.setCanonicalName(Constants.BrachioradialisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Radialis Brevis Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisBrevisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Radialis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Ulnaris Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiUlnarisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Digiti Minimi");
		property.setCanonicalName(Constants.ExtensorDigitiMinimiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Digitorum Muscle");
		property.setCanonicalName(Constants.ExtensorDigitorumMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Digitorum Profundus Muscle");
		property.setCanonicalName(Constants.FlexorDigitorumProfundusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Digitorum Superficialis Muscle");
		property.setCanonicalName(Constants.FlexorDigitorumSuperficialisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.FlexorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Pollicis Brevis Muscle");
		property.setCanonicalName(Constants.FlexorPollicisBrevisMuscle);
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
	 * This method will return the X3D for the LobarBronchus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the LobarBronchus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LobarBronchus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LobarBronchus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
			epithelium.getX3D(true)  
		 ; 
			
	
		//System.out.println("LobarBronchus X3D: " + body);		
	
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
		// LOBAR BRONCHUS BOUND BOX		
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
		// LOBAR BRONCHUS - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ChestEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ChestEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// LOBAR BRONCHUS - VASCULAR CONNECTORS  
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
		// LOBAR BRONCHUS - MUSCULAR CONNECTORS
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
