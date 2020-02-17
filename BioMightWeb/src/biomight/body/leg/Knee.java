/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;










import biomight.Constants;
import biomight.body.BodyPart;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.ArticularCartilage;
import biomight.system.ligament.knee.AnteriorCruciateLigament;
import biomight.system.ligament.knee.LateralCollateralLigament;
import biomight.system.ligament.knee.LigamentumPatellae;
import biomight.system.ligament.knee.MedialCollateralLigament;
import biomight.system.ligament.knee.PosteriorCruciateLigament;
import biomight.system.skeletal.leg.Patella;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.leg.CommonFemoralArtery;
import biomight.system.vascular.arteries.leg.DescendingGenicularArtery;
import biomight.system.vascular.arteries.leg.DescendingGenicularArticularArtery;
import biomight.system.vascular.arteries.leg.DescendingGenicularSaphenousArtery;
import biomight.system.vascular.arteries.leg.PoplitealArtery;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Knee extends BodyPart {
	protected EpitheliumTissue epithelium;
	private AnteriorCruciateLigament anteriorCruciateLigament;
	private PosteriorCruciateLigament posteriorCruciateLigament;
	private LateralCollateralLigament lateralCollateralLigament;
	private MedialCollateralLigament medialCollateralLigament;
	private LigamentumPatellae ligamentumPatellae; 
	private ArticularCartilage articularCartilage;
	private LateralMeniscus lateralmeniscus;
	private MedialMeniscus medialMeniscus;
	private SupraPatellarBursa supraPatellarBursa;
	private PrePatellarBursa prePatellarBursa;
	//private Patella patella;
	private KneeSynovium kneeSynovialMembrane;
	
	// Bones
	private Patella patella;
	
	private PoplitealArtery poplitealArtery;
	private DescendingGenicularArticularArtery  descendingGenicularArticularArtery;
	private DescendingGenicularSaphenousArtery  descendingGenicularSaphenousArtery;	
	
	public Knee()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.KneeRef, null, null);
	}

	public Knee(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Knee(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Knee Create");
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
		this.setImage("images/Knee.gif");
		setImageWidth(200);
		setImageHeight(150);
	
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Knee
		// Either get from the Constructor or set up defaults
		System.out.println("Knee - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Knee - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Knee - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Knee - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Knee - BoundingBoxes are NULL");						
			}
		}
		
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		this.componentID = parentID;
	
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Knee METHODS: " + bioMightMethods.size());
			}
	
			
			// Generate the Knee Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			/*
			System.out.println("In Knee - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Knee - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Knee - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Knee - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.KneeEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Knee - Constructor has Epithelium BoundBox: " + Constants.KneeEpitheliumRef);
			else
				System.out.println("In Knee - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.KneeEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.KneeEpitheliumRef, tempBoundBox);		
			System.out.println("In Knee - Epithelium Constructor Set");
			*/
			
			int localVP = Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;

			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Bacterias.x3d";

			
			// Create the 'skin' for the portion of the Knee we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftKneeRef)) 
			{
				startID="KneeEpithelium:00001";
			}			
			// We are creating the Esophagus for the Knee
			else if (parentID.equals(Constants.RightKneeRef)) 
			{	
				startID="KneeEpithelium:00480";
			}
		
			System.out.println("Creating Knee Epithelium: " + parentID);					
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.KneeEpitheliumRef,  Constants.KneeEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.KneeEpitheliumRef, "ThighEpithelium", Constants.ThighEpitheliumRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
					
			System.out.println("Creating the PoplitealArtery for parent: " + parentID);
			poplitealArtery = new PoplitealArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PoplitealArtery", Constants.PoplitealArtery, Constants.PoplitealArteryRef, poplitealArtery.getComponentID());
			System.out.println("Created the PoplitealAtery");

			System.out.println("Creating the DescendingGenicularArticularArtery for parent: " + parentID);
			descendingGenicularArticularArtery = new DescendingGenicularArticularArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DescendingGenicularArticularArtery", Constants.DescendingGenicularArticularArtery, Constants.DescendingGenicularArticularArteryRef, descendingGenicularArticularArtery.getComponentID());
			System.out.println("Created the DescendingGenicularArticularArtery");
			
			System.out.println("Creating the DescendingGenicularSaphenousArtery for parent: " + parentID);
			descendingGenicularSaphenousArtery = new DescendingGenicularSaphenousArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DescendingGenicularSaphenousArtery", Constants.DescendingGenicularSaphenousArtery, Constants.DescendingGenicularSaphenousArteryRef, descendingGenicularSaphenousArtery.getComponentID());
			System.out.println("Created the DescendingGenicularSaphenousArtery");
			

			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Knee - Stored generateEpithelium in: " + componentID);	
			System.out.println("KneeEpithelium is created");			
			
			System.out.println("Creating the Knee for parent: " + parentID);
			//patella = new Patella(parentID, bioMightMethods);
			System.out.println("Created the Knee");	
			
		
			System.out.println("Knee Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	}
		
	
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Atrium Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Knee: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 3.25;
			if (parentID.equals("Knee:01")) {
				
				// Generate the KneeEpithelium
				double[] startPos = {4.40, -44.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
			
				int success = bioMightBean.generateKnee("KneeEpithelium:00001", "KneeEpithelium", 
						"KneeEpitheliumLeft", componentID, parentID, currentPoints);								
				
			}
			else {
				radius = 3.35;
				// Generate the KneeEpithelium
				double[] startPos = {-4.40, -44.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateKnee("KneeEpithelium:00360", "KneeEpithelium", 
						"KneeEpitheliumLeft", componentID, parentID, currentPoints);										
			}

			
			System.out.println("Created KneeEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - KneeEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCruciateLigament");
		property.setCanonicalName(Constants.AnteriorCruciateLigament);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorCruciateLigament");
		property.setCanonicalName(Constants.PosteriorCruciateLigament);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralCollateralLigament");
		property.setCanonicalName(Constants.LateralCollateralLigament);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedialCollateralLigament");
		property.setCanonicalName(Constants.MedialCollateralLigament);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LigamentumPatellae");
		property.setCanonicalName(Constants.LigamentumPatellae);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArticularCartilage");
		property.setCanonicalName(Constants.ArticularCartilage);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralMeniscus");
		property.setCanonicalName(Constants.LateralMeniscus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedialMeniscus");
		property.setCanonicalName(Constants.MedialMeniscus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SupraPatellarBursa");
		property.setCanonicalName(Constants.SupraPatellarBursa);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PrePatellarBursa");
		property.setCanonicalName(Constants.PrePatellarBursa);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Patella");
		//property.setCanonicalName(Constants.Patella);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("KneeSynovium");
		property.setCanonicalName(Constants.KneeSynovium);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Bend");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("Dislocate");
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
		
		// Assemble the Leg
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Leg.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Leg'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = //epithelium.getX3D(true) + 
				poplitealArtery.getX3D(true) +
				descendingGenicularArticularArtery.getX3D(true) +
				descendingGenicularSaphenousArtery.getX3D(true);
		//System.out.println("Knee X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	

	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Knee.  
	 * This routine will be called when looking at an individual Knee with
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
		// KNEES BOUND BOX		
		//
		// Set up the Bounding Box for the Knee
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
		// KNEE - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.KneeEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.KneeEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// KNEE - VASCULAR CONNECTORS  
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
		// KNEE - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// KNEE - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Knee.   These boxes will define
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
			System.out.println("Knee - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// KNEES BOUND BOXES
		// Set up the Bounding Box for the Knee
		// On a porportioned human, the Knee are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT KNEES BOUNDBOX
		// Set up the Bounding Box for the Left Knee
		// On a porportioned human, the Knee are located in the --- 
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
			
		// KneeEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.KneeEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.KneeEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftKneeRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT KNEES BOUNDBOX
		// Set up the Bounding Box for the Knee
		// On a porportioned human, the Knee are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// KneeEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.KneeEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.KneeEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightKneeRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Knee 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.KneesRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
		
}