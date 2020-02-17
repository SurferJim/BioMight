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
import biomight.system.muscular.forearm.FlexorCarpiUlnarisMuscle;
import biomight.system.muscular.forearm.SupinatorMuscle;
import biomight.system.skeletal.arm.Ulna;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.arm.UlnarArtery;
import biomight.system.vascular.veins.arm.AccessoryCephalicVein;
import biomight.system.vascular.veins.arm.BasilicVein;
import biomight.system.vascular.veins.arm.CephalicVein;
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



/*****************************************************************************
 * BRONCHUS
 * 
 * @author SurferJim
 *
 * Representation of the Bronchus
 * 
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *****************************************************************************/

public class Bronchus extends BioMightBase {
	protected EpitheliumTissue epithelium;

	// Muscles
		
	// Ligaments
	//private AnnularLigament annularLigament;
	
	// Vessels
	//private AccessoryCephalicVein accessoryCephalicVein;
	
	
	public Bronchus(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Bronchus.jpg");
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
		System.out.println("BRONCHUS - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("BRONCHUS - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("BRONCHUS - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("BRONCHUS - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("BRONCHUS - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		***/
		
		this.componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{					
			System.out.println("Bronchus View Internal: " + parentID);
			/*
			System.out.println("In Bronchus - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Bronchus - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Bronchus - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Bronchus - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.BronchusEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Bronchus - Constructor has Epithelium BoundBox: " + Constants.BronchusEpitheliumRef);
			else
				System.out.println("In Bronchus - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.BronchusEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.BronchusEpitheliumRef, tempBoundBox);		
			System.out.println("In Bronchus - Epithelium Constructor Set");
			*/
			
			
			
			// Create the 'skin' for the portion of the Bronchus we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftBronchusRef)) 
			{
				startID="BronchusEpithelium:00001";
			}			
			// We are creating the Esophagus for the Chest
			else if (parentID.equals(Constants.RightBronchusRef)) 
			{	
				startID="BronchusEpithelium:00480";
			}
		
			// Generate the LobarBronchus 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating Bronchus Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(Constants.BronchusEpitheliumRef, parentID, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Bronchus - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.BronchusEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("Epithelium is created");			
		}
		else if (localVP == Constants.VIEW_FLOATING)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting BronchusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.BronchusRef, parentID);	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Bronchus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of Bronchuss and build them into the model
			// In the default case, we get one instance of the Bronchus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Bronchus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created Bronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating Bronchus Epithelium: " + bioMightTransform.getId());				
				epithelium = new EpitheliumTissue("BronchusEpithelium", bioMightTransform.getId(), bioMightMethods);
				initProperty("BronchusEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
					// Create the components of the curvature

				}*/
			}
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			//***************************************************************
			//***************************************************************
			// HACK!!!!!
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Bronchus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye BronchusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Bronchus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Component - Bronchus");
				throw new ServerException("Remote Exception getComponent():", e); 	
			}
				
			// Run through the collection of Bronchus and build them into the model
			// In the default case, we get one instance of the Bronchus for each Arm
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Bronchus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Bronchus
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				BioMightTransform gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating Bronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Bronchus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					System.out.println("Creating Bronchus Epithelium: " + parentID);				
					epithelium = new EpitheliumTissue("BronchusEpithelium", parentID, bioMightMethods);

					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Bronchus				
					System.out.println("Creating Bronchus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Bronchus -HawkEye 2X -  Epithelium: " + parentID);				
					epithelium = new EpitheliumTissue("BronchusEpithelium", parentID, bioMightMethods);
				}
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				// Vascular

				localVP = Constants.VIEW_DETACHED;
				localLOD = Constants.MAG1X;

				
				/*
					
				System.out.println("Creating the PronatorQuadratusMuscle for parent: " + parentID);
				pronatorQuadratusMuscle = new PronatorQuadratusMuscle(parentID, bioMightMethods);
				System.out.println("Created the PronatorQuadratusMuscle");
		
				*/
				
				System.out.println("Bronchus Instance is created : " + parentID);

				
			}			
		}
		

		//initProperties();
		initMethods();
		
		System.out.println("CreateBronchus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Bronchus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
	/*******************************************************************
	 * GENERATE BRONCHUS
	 * 
	 * When the user wants to update the model, we call upon the
	 * generate EJB to make the underlying changes
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public BioMightGenerate generate(String parentID, String componentID)
	{
		// Generate the Bronchus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BronchusEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
	
			double radius = 0.25;
				
			// Left Branch
			if (parentID.equals("Bronchus:01")) 
			{	
				// Generate the Bronchus
				double[] startPos = {0.20, -11.5, -3.20};
				double orient[] = {0, 0, 45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate Bronchus: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateBronchus("BronchusEpithelium:00001", "BronchusEpithelium", 
					"BronchusEpithelium", componentID, parentID, currentPoints);			
					
			}			
			// Right Branch
			else if (parentID.equals("Bronchus:02")) 
			{	
				// Generate the BronchusEpithelium of the stomach0
				// Create 5 sections
				double[] startPos = {-0.20, -11.40, -3.20};
				double orient[] = {0, 0, 135};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
	
				System.out.println("Calling Generate BronchusEpithelium: " + componentID + "    " + parentID);
				int success = bioMightBean.generateBronchus("BronchusEpithelium:00480", "BronchusEpithelium", 
					"BronchusEpithelium", componentID, parentID, currentPoints);							
			}			
			
				
			System.out.println("Created BronchusEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BronchusEpithelium");
			throw new ServerException("Remote Exception BronchusEpithelium():", e); 	
		}
		
		return (bioMightGenerate);
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
	 * This method will return the X3D for the Bronchus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Bronchus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Bronchus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bronchus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
			epithelium.getX3D(true)  
		 ; 
			
	
		//System.out.println("Bronchus X3D: " + body);		
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Bronchus.  
	 * This routine will be called when looking at an individual Bronchus with
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
		// BRONCHUS BOUND BOX		
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
		// CHEST - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ChestEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ChestEpitheliumRef, bioMightConnector);
	
		// Trachea Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -2.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.TracheaRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaRef, bioMightConnector);
	
		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// CHEST - VASCULAR CONNECTORS  
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
		// CHEST - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// CHEST - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Bronchus.   These boxes will define
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
			System.out.println("Bronchus - SetupBoundBoxes - Incoming BoundBox: " + 
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
		yPos = new BigDecimal(-12.0);
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
