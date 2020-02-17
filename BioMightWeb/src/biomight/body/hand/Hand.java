/*
 * Created on May 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hand;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import biomight.Constants;
import biomight.body.BodyPart;
import biomight.system.muscular.hand.LumbricalMuscles;
import biomight.system.muscular.hand.ThenarEminence;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.DigitalArtery;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.system.vascular.arteries.hand.DeepPalmarArchArtery;
import biomight.system.vascular.arteries.hand.PalmarCarpalBranchArtery;
import biomight.system.vascular.arteries.hand.PrincepsPollicisArtery;
import biomight.system.vascular.arteries.hand.RadialisIndicisArtery;
import biomight.system.vascular.arteries.hand.SuperficialPalmarArchArtery;
import biomight.system.vascular.arteries.hand.PalmarMetacarpalArtery;

/**
 * @author SurferJim
 *
 * This object creates a representation of a hand.
 * 
 */

public class Hand extends BodyPart  {
	private Fingers fingers;
	private Thumb thumb;
	private Palm palm;	 
	private DigitalArtery digitalArtery;
	private LumbricalMuscles lumbricalMuscles;
	private ThenarEminence thenarEminence;
	protected EpitheliumTissue epithelium;
	private SuperficialPalmarArchArtery superficialPalmarArchArtery;
	private DeepPalmarArchArtery deepPalmarArchArtery;
	private PalmarCarpalBranchArtery palmarCarpalBranchArtery;
	private PrincepsPollicisArtery princepsPollicisArtery;
	private RadialisIndicisArtery radialisIndicisArtery;
	private PalmarMetacarpalArtery palmarMetacarpalArtery;
	
	
	/************************************************************************
	 * Hand Constructor 
	 *
	 ***********************************************************************/
	public Hand()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.HandRef, null, null);
	}

	/************************************************************************
	 * Hand Constructor 
	 *
	 ***********************************************************************/
	public Hand(String parentID)
	{
		//System.out.println("Calling parameterized Hand Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Hand Constructor 
	 *
	 ***********************************************************************/
	public Hand(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Hand with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Hand
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		this.setImage("images/Hand.gif");
		setImageWidth(200);
		setImageHeight(150);
		componentID = parentID;
		
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Hand METHODS: " + bioMightMethods.size());
		}
		
		
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Hand
		// Either get from the Constructor or set up defaults
		System.out.println("Hand - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Hand - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Hand - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Hand - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Hand - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
				
			/*
			System.out.println("In Hand - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Hand - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Hand - Constructor NOT Loaded with: " + parentID + "BoundBox");
			/*
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Hand - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.HandEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Hand - Constructor has Epithelium BoundBox: " + Constants.HandEpitheliumRef);
			else
				System.out.println("In Hand - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.HandEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.HandEpitheliumRef, tempBoundBox);		
			System.out.println("In Hand - Epithelium Constructor Set");
			*/
		
			// Create the 'skin' for the portion of the Hand we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftHandRef)) 
			{
				startID="HandEpithelium:00001";
			}			
			// We are creating the Esophagus for the Hand
			else if (parentID.equals(Constants.RightHandRef)) 
			{	
				startID="HandEpithelium:00480";
			}
		
			System.out.println("Creating Hand Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.HandEpitheliumRef,  Constants.HandEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
	
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Hand - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.HandEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("HandEpithelium is created");			

			System.out.println("Creating Hand Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue("HandEpithelium", parentID, bioMightMethods);
			initProperty("HandEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			
			System.out.println("Creating Thumb: " + parentID);					
			thumb = new Thumb(parentID, bioMightMethods);
			initProperty("Thumb", Constants.Thumb, Constants.ThumbRef, thumb.getComponentID());

			System.out.println("Creating Palm: " + parentID);					
			palm = new Palm(parentID, bioMightMethods);
			initProperty("Palm", Constants.Palm, Constants.PalmRef, palm.getComponentID());
			
			System.out.println("Creating Fingers: " + parentID);					
			fingers = new Fingers(parentID, bioMightMethods);
			initProperty("Fingers", Constants.Fingers, Constants.FingersRef, fingers.getComponentID());
	
			//System.out.println("Creating DigitalArtery: " + parentID);					
			//digitalArtery = new DigitalArtery(parentID, bioMightMethods);
			//initProperty("DigitalArtery", Constants.DigitalArtery, Constants.DigitalArteryRef, digitalArtery.getComponentID());
			
			System.out.println("Creating SuperficialPalmarArchArtery: " + parentID);					
			superficialPalmarArchArtery = new SuperficialPalmarArchArtery(parentID, bioMightMethods);
			initProperty("SuperficialPalmarArchArtery", Constants.SuperficialPalmarArchArtery, Constants.SuperficialPalmarArchArteryRef, superficialPalmarArchArtery.getComponentID());
			
			System.out.println("Creating DeepPalmarArchArtery: " + parentID);					
			deepPalmarArchArtery = new DeepPalmarArchArtery(parentID, bioMightMethods);
			initProperty("DeepPalmarArchArtery", Constants.DeepPalmarArchArtery, Constants.DeepPalmarArchArteryRef, deepPalmarArchArtery.getComponentID());
			
			System.out.println("Creating PalmarCarpalBranchArtery: " + parentID);					
			palmarCarpalBranchArtery = new PalmarCarpalBranchArtery(parentID, bioMightMethods);
			initProperty("PalmarCarpalBranchArtery", Constants.PalmarCarpalBranchArtery, Constants.PalmarCarpalBranchArteryRef, palmarCarpalBranchArtery.getComponentID());
			
			System.out.println("Creating PrincepsPollicisArtery: " + parentID);					
			princepsPollicisArtery = new PrincepsPollicisArtery(parentID, bioMightMethods);
			initProperty("PrincepsPollicisArtery", Constants.PrincepsPollicisArtery, Constants.PrincepsPollicisArteryRef, princepsPollicisArtery.getComponentID());
			
			System.out.println("Creating RadialisIndicisArtery: " + parentID);					
			radialisIndicisArtery = new RadialisIndicisArtery(parentID, bioMightMethods);
			initProperty("RadialisIndicisArtery", Constants.RadialisIndicisArtery, Constants.RadialisIndicisArteryRef, radialisIndicisArtery.getComponentID());
			
			System.out.println("Creating PalmarMetacarpalArtery: " + parentID);					
			palmarMetacarpalArtery = new PalmarMetacarpalArtery(parentID, bioMightMethods);
			initProperty("PalmarMetacarpalArtery", Constants.PalmarMetacarpalArtery, Constants.PalmarMetacarpalArteryRef, palmarMetacarpalArtery.getComponentID());
			
			
		} 
		else if (viewPerspective == Constants.VIEW_DETACHED) {
			
			System.out.println("Creating Hand Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue("HandEpithelium", parentID, bioMightMethods);
			initProperty("HandEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			
			System.out.println("Creating SuperficialPalmarArchArtery: " + parentID);					
			superficialPalmarArchArtery = new SuperficialPalmarArchArtery(parentID, bioMightMethods);
			initProperty("SuperficialPalmarArchArtery", Constants.SuperficialPalmarArchArtery, Constants.SuperficialPalmarArchArteryRef, superficialPalmarArchArtery.getComponentID());
			
			System.out.println("Creating DeepPalmarArchArtery: " + parentID);					
			deepPalmarArchArtery = new DeepPalmarArchArtery(parentID, bioMightMethods);
			initProperty("DeepPalmarArchArtery", Constants.DeepPalmarArchArtery, Constants.DeepPalmarArchArteryRef, deepPalmarArchArtery.getComponentID());
			
			System.out.println("Creating PalmarCarpalBranchArtery: " + parentID);					
			palmarCarpalBranchArtery = new PalmarCarpalBranchArtery(parentID, bioMightMethods);
			initProperty("PalmarCarpalBranchArtery", Constants.PalmarCarpalBranchArtery, Constants.PalmarCarpalBranchArteryRef, palmarCarpalBranchArtery.getComponentID());
			
			System.out.println("Creating PrincepsPollicisArtery: " + parentID);					
			princepsPollicisArtery = new PrincepsPollicisArtery(parentID, bioMightMethods);
			initProperty("PrincepsPollicisArtery", Constants.PrincepsPollicisArtery, Constants.PrincepsPollicisArteryRef, princepsPollicisArtery.getComponentID());
			
			System.out.println("Creating RadialisIndicisArtery: " + parentID);					
			radialisIndicisArtery = new RadialisIndicisArtery(parentID, bioMightMethods);
			initProperty("RadialisIndicisArtery", Constants.RadialisIndicisArtery, Constants.RadialisIndicisArteryRef, radialisIndicisArtery.getComponentID());
			
			System.out.println("Creating PalmarMetacarpalArtery: " + parentID);					
			palmarMetacarpalArtery = new PalmarMetacarpalArtery(parentID, bioMightMethods);
			initProperty("PalmarMetacarpalArtery", Constants.PalmarMetacarpalArtery, Constants.PalmarMetacarpalArteryRef, palmarMetacarpalArtery.getComponentID());
			
			
		}

		System.out.println("Hand is created : " + parentID);
		
		//initProperties();
		initMethods();
	
	}		

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Fingers");
		property.setCanonicalName(Constants.Fingers);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Thumb");
		property.setCanonicalName(Constants.Thumb);
		properties.add(property);				

		property = new BioMightPropertyView();
		property.setPropertyName("Palm");
		property.setCanonicalName(Constants.Palm);
		properties.add(property);		
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Girth");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);	
	}	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Hand.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Hand
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hand.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Hand'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		int view = Constants.VIEW_FLOATING;
		
		
		if (view == Constants.VIEW_DETACHED)
		{
			body = epithelium.getX3D(true) 
					+ superficialPalmarArchArtery.getX3D(true) 
					+ deepPalmarArchArtery.getX3D(true) 
					+ palmarCarpalBranchArtery.getX3D(true) 
					+ princepsPollicisArtery.getX3D(true) 
					+ radialisIndicisArtery.getX3D(true) 
					+ palmarMetacarpalArtery.getX3D(true);
		}
		
		
		else if (view == Constants.VIEW_FLOATING)
		{
			body =	epithelium.getX3D(true) 
					+ superficialPalmarArchArtery.getX3D(true) 
					+ deepPalmarArchArtery.getX3D(true) 
					+ palmarCarpalBranchArtery.getX3D(true) 
					+ princepsPollicisArtery.getX3D(true) 
					+ radialisIndicisArtery.getX3D(true) 
					+ palmarMetacarpalArtery.getX3D(true);
			/*		
			digitalArtery.getX3D(true) +
			thumb.getX3D(true) +
			palm.getX3D(true) + 
			fingers.getX3D(true) +*/ 
		}
		
		//System.out.println("Hand X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Hand.  
	 * This routine will be called when looking at an individual Hand with
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
		// Set up the Bounding Box for the Hand
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
		bioMightConnector = new BioMightConnector(startPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
		
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
	 * Setup the Bounding Boxes for the Hand.   These boxes will define
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
			System.out.println("Hand - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// SHOULDERS BOUND BOXES
		// Set up the Bounding Box for the Hand
		// On a porportioned human, the Hand are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT SHOULDERS BOUNDBOX
		// Set up the Bounding Box for the Left Hand
		// On a porportioned human, the Hand are located in the --- 
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
			
		// HandEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftHandRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT SHOULDERS BOUNDBOX
		// Set up the Bounding Box for the Hand
		// On a porportioned human, the Hand are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// HandEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightHandRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Hand 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.HandsRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
	
	
	public void openGrasp()
	{
	}
	
	public void closeGrasp()
	{
	}	
	
	
}
