/*
 * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.ArticularHyalineCartilage;
import biomight.system.ligament.hip.IlioFemoralLigament;
import biomight.system.ligament.hip.LigamentumTeresFemoris;
import biomight.system.muscular.leg.thigh.AdductorMagnusMuscle;
import biomight.system.muscular.hip.ArticularisGenusMuscle;
import biomight.system.muscular.hip.CoccygeusMuscle;
import biomight.system.muscular.hip.GemelliMuscle;
import biomight.system.muscular.hip.GluteusMaximusMuscle;
import biomight.system.muscular.hip.IlotibialTractMuscle;
import biomight.system.muscular.hip.InferiorGemelliMuscle;
import biomight.system.muscular.hip.PiriformisMuscle;
import biomight.system.muscular.hip.SuperiorGemelliMuscle;
import biomight.system.muscular.leg.thigh.TensorFasciaLataMuscle;
import biomight.system.nervous.nerves.leg.thigh.ObturatorNerve;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.leg.MedialCircumflexFemoralArtery;
import biomight.system.vascular.arteries.pelvis.CommonIliacArteries;
import biomight.system.vascular.arteries.pelvis.CommonIliacArtery;
import biomight.system.vascular.arteries.pelvis.ExternalIliacArteries;
import biomight.system.vascular.arteries.pelvis.ExternalIliacArtery;
import biomight.system.vascular.arteries.pelvis.InternalIliacArteries;
import biomight.system.vascular.arteries.pelvis.InternalIliacArtery;
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

public class Hip extends BioMightBase {
	protected EpitheliumTissue epithelium;
	
	
	// Muscular
	//private AdductorBrevisMuscle adductorBrevisMuscle;
	private AdductorMagnusMuscle adductorMagnusMuscle;
	private ArticularisGenusMuscle articularisGenusMuscle;
	private CoccygeusMuscle coccygeusMuscle;
	private GemelliMuscle gemelliMuscle;
	private SuperiorGemelliMuscle superiorGemelliMuscle;
	private InferiorGemelliMuscle inferiorGemelliMuscle;
	private GluteusMaximusMuscle gluteusMaximusMuscle;
	private IlotibialTractMuscle ilotibialTractMuscle;
	private TensorFasciaLataMuscle tensorFasciaLataMuscle;
	private PiriformisMuscle piriformisMuscle;
	
	// Skeletal
	private Acetabulum acetabulum;
	
	// MultiAxial Ball and GemelliMuscle.javaSocket
	//private MultiAxialBallSocketJoint ballSocketJoint;
	private ArticularHyalineCartilage articularHyalineCartilage;
	private Labrum labrum;
	
	
	// Ligaments
	private IlioFemoralLigament ilioFemoralLigament;
	private LigamentumTeresFemoris ligamentumTeresFemoris;
	
	// Vascular
	private MedialCircumflexFemoralArtery medialCircumflexFemoralArtery;
	private CommonIliacArtery commonIliacArtery;
	private ExternalIliacArtery externalIliacArtery;
	private InternalIliacArtery internalIliacArtery;
	
	// Nerves
	private ObturatorNerve obturatorNerve;


	/********************************************************************
	 * HIP CONSTRUCTORS
	 * 
	 * @param parentID
	 * @param bioMightConstruct
	 * @param bioMightMethods
	 *******************************************************************************/

	public Hip()
	{		
		// Create hte base Eye
		create(Constants.HipRef, null, null, null);
	}
	
	
	public Hip(String parentID)
	{				
		create(parentID, null,null, null);	
	}
	

	public Hip(String parentID, ArrayList<BioMightMethodView> bioMightMethods, ArrayList<BioMightPropertyView> bioMightProperties)
	{				
		create(parentID, null, bioMightMethods, bioMightProperties);	
	}

	/********************************************************************
	 * HIP CONSTRUCTOR
	 * 
	 * @param parentID
	 * @param bioMightConstruct
	 * @param bioMightMethods
	 *******************************************************************************/
	public Hip(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods, ArrayList<BioMightPropertyView> bioMightProperties)
	{				
		create(parentID, bioMightConstruct, bioMightMethods, bioMightProperties);	
	}		
	
	
	/************************************************************************************
	 * 
	 * CREATE HIP
	 * @param HipReference
	 ***********************************************************************************/
	
	public void create(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods, ArrayList<BioMightPropertyView> bioMightProperties)
	{		
		this.setImage("images/Hip.gif");
		setImageWidth(200);
		setImageHeight(150);
	
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		/*
		// Get the Bounding Box and Connectors for the Hip
		// Either get from the Constructor or set up defaults
		System.out.println("Hip - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Hip - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Hip - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Hip - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Hip - BoundingBoxes are NULL");						
			}
		}
		*/
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
	
		componentID=parentID;
			
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Hip METHODS: " + bioMightMethods.size());
			}
			
			// Generate the Hip Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			/*
			System.out.println("In Hip - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Hip - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Hip - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Hip - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.HipEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Hip - Constructor has Epithelium BoundBox: " + Constants.HipEpitheliumRef);
			else
				System.out.println("In Hip - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.HipEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.HipEpitheliumRef, tempBoundBox);		
			System.out.println("In Hip - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Hip we are looking at 
			String startID = "";
			if (parentID.equals("Hip:01")) 
			{
				startID="HipEpithelium:00001";
			}
			else if (parentID.equals("Hip:02")) {	
				startID="HipEpithelium:00640";
			}

		
			System.out.println("Creating Hip Epithelium: " + parentID + "   Starting at: " + startID);				
			epithelium = new EpitheliumTissue(startID, Constants.HipEpitheliumRef,  Constants.HipEpitheliumRef, parentID, bioConstruct, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Hip - Stored generateEpithelium in: " + componentID);	
			initProperty(Constants.HipEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("HipEpithelium is created");			
	
			//adductorBrevisMuscle = new AdductorBrevisMuscle(parentID, bioMightMethods);
			//initProperty("AdductorBrevisMuscle", Constants.AdductorBrevisMuscle, Constants.AdductorBrevisMuscleRef, adductorBrevisMuscle.getComponentID());
			//System.out.println("AdductorBrevisMuscle completed for Hip: " + parentID);
			
			adductorMagnusMuscle = new AdductorMagnusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("AdductorMagnusMuscle", Constants.AdductorMagnusMuscle, Constants.AdductorMagnusMuscleRef, adductorMagnusMuscle.getComponentID());
			System.out.println("AdductorMagnusMuscle completed for Hip: " + parentID);
			
			articularisGenusMuscle = new ArticularisGenusMuscle(parentID, bioMightMethods);
			initProperty("ArticularisGenusMuscle", Constants.ArticularisGenusMuscle, Constants.ArticularisGenusMuscleRef, articularisGenusMuscle.getComponentID());
			System.out.println("ArticularisGenusMuscle completed for Hip: " + parentID);
			
			coccygeusMuscle = new CoccygeusMuscle(parentID, bioMightMethods);
			initProperty("CoccygeusMuscle", Constants.CoccygeusMuscle, Constants.CoccygeusMuscleRef, coccygeusMuscle.getComponentID());
			System.out.println("CoccygeusMuscle completed for Hip: " + parentID);
			
			gemelliMuscle = new GemelliMuscle(parentID, bioMightMethods);
			initProperty("GemelliMuscle", Constants.GemelliMuscle, Constants.GemelliMuscleRef, gemelliMuscle.getComponentID());
			System.out.println("GemelliMuscle completed for Hip: " + parentID);
			
			superiorGemelliMuscle = new SuperiorGemelliMuscle(parentID, bioMightMethods);
			initProperty("SuperiorGemelliMuscle", Constants.SuperiorGemelliMuscle, Constants.SuperiorGemelliMuscleRef, superiorGemelliMuscle.getComponentID());
			System.out.println("SuperiorGemelliMuscle completed for Hip: " + parentID);
			
			inferiorGemelliMuscle = new InferiorGemelliMuscle(parentID, bioMightMethods);
			initProperty("InferiorGemelliMuscle", Constants.InferiorGemelliMuscle, Constants.InferiorGemelliMuscleRef, inferiorGemelliMuscle.getComponentID());
			System.out.println("InferiorGemelliMuscle completed for Hip: " + parentID);
			
			gluteusMaximusMuscle = new GluteusMaximusMuscle(parentID, bioMightMethods);
			initProperty("GluteusMaximusMuscle", Constants.GluteusMaximusMuscle, Constants.GluteusMaximusMuscleRef, gluteusMaximusMuscle.getComponentID());
			System.out.println("InferiorGemelliMuscle completed for Hip: " + parentID);
			
			ilotibialTractMuscle = new IlotibialTractMuscle(parentID, bioMightMethods);
			initProperty("IlotibialTractMuscle", Constants.IlotibialTractMuscle, Constants.IlotibialTractMuscleRef, ilotibialTractMuscle.getComponentID());
			System.out.println("IlotibialTractMuscle completed for Hip: " + parentID);
					
			tensorFasciaLataMuscle = new TensorFasciaLataMuscle(parentID, bioMightMethods);
			initProperty("TensorFasciaLataMuscle", Constants.TensorFasciaLataMuscle, Constants.TensorFasciaLataMuscleRef, tensorFasciaLataMuscle.getComponentID());
			System.out.println("TensorFasciaLataMuscle completed for Hip: " + parentID);
			
			piriformisMuscle = new PiriformisMuscle(parentID, bioMightMethods);
			initProperty("PiriformisMuscle", Constants.PiriformisMuscle, Constants.PiriformisMuscleRef, piriformisMuscle.getComponentID());
			System.out.println("PiriformisMuscle completed for Hip: " + parentID);
			
			localVP = Constants.VIEW_HAWKEYE;;
			localLOD = Constants.MAG1X;

			System.out.println("Creating the CommonIliacArtery for ParentID: " + parentID);
			commonIliacArtery = new CommonIliacArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CommonIliacArtery", Constants.CommonIliacArtery, Constants.CommonIliacArteryRef, commonIliacArtery.getComponentID());
			System.out.println("Created the CommonIliacArtery");
	
			System.out.println("Creating the ExternalIliacArtery for ParentID: " + parentID);
			externalIliacArtery = new ExternalIliacArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("ExternalIliacArtery", Constants.ExternalIliacArtery, Constants.ExternalIliacArteryRef, externalIliacArtery.getComponentID());
			System.out.println("Created the ExternalIliacArtery");
	
			System.out.println("Creating the InternalIliacArtery for ParentID: " + parentID);
			internalIliacArtery = new InternalIliacArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("InternalIliacArtery", Constants.InternalIliacArtery, Constants.InternalIliacArteryRef, internalIliacArtery.getComponentID());
			System.out.println("Created the InternalIliacArtery");
					
			System.out.println("Hip Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	}

	

	public void generate(String parentID, String componentID)
	{
		// Generate the Trachea Epithelium
		int success = 0;
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Hip Epithelium for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
		if (parentID.equals("Hip:01")) {
			
			// Front Top face of Hip
			double[][] currentPoints = {
					{0.0, -28.0, -1.0},
					{6.5, -28.0, -1.0}
			};
			//success = bioMightBean.generateHip("HipEpithelium:00001", "HipEpithelium", 
			//		"FrontTop", componentID, parentID, currentPoints);			
	
	
			
			// Left Side of Hip
			double[][] sidePoints = {
					{7.75, -28.0, -4.5},
					{6.5, -28.0, -1.0}
					
			};
			//success = bioMightBean.generateHip("HipEpithelium:00160", "HipEpithelium", 
			//		"LeftFront", componentID, parentID, sidePoints);			
	
		
			
			// Left Side of Hip
			double[][] sidePoints2 = {
					{6.5, -28.0, -9.0},
					{7.75, -28.0, -4.5}
					
			};
			success = bioMightBean.generateHip("HipEpithelium:00320", "HipEpithelium", 
					"LeftBack", componentID, parentID, sidePoints2);			

			
			
			// Left Side Back of hip
			double[][] hip1Back = {
					{6.5, -28.0, -9.0},
					{0.0, -28.0, -9.0}
					
			};
			success = bioMightBean.generateHip("HipEpithelium:00480", "HipEpithelium", 
					"Back", componentID, parentID, hip1Back);				
		}
		else if (parentID.equals("Hip:02")) {
			
			// Create a line
			double[][] currentPoints = {
					{0.0,  -28.0, -1.0},
					{-6.5, -28.0, -1.0}
			};

			//success = bioMightBean.generateHip("HipEpithelium:00640", "HipEpithelium", 
			//		"FrontTop", componentID, parentID, currentPoints);				

		
			
			// Right Side of Hip
			double[][] sidePoints = {
					{-7.75, -28.0, -4.5},
					{-6.5, -28.0, -1.0}
					
			};
			
			success = bioMightBean.generateHip("HipEpithelium:00820", "HipEpithelium", 
					"RightFront", componentID, parentID, sidePoints);			
	
		
			
			// Right Side of Hip
			double[][] sidePoints2 = {
					{-6.5, -28.0, -9.0},
					{-7.75, -28.0, -4.5}
					
			};
			
			success = bioMightBean.generateHip("HipEpithelium:01024", "HipEpithelium", 
					"RightBack", componentID, parentID, sidePoints2);			

			
			
			// Right Side of Hip
			double[][] hip2Back = {
					{-6.5, -28.0, -9.0},
					{0.0, -28.0, -9.0}
					
			};
			
			success = bioMightBean.generateHip("HipEpithelium:01240", "HipEpithelium", 
					"Back", componentID, parentID, hip2Back);			

		}
	
			
			System.out.println("Created HipEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - HipEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Acetabulum");
		property.setCanonicalName(Constants.Acetabulum);
		properties.add(property);			
	}
	
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
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
		
		// Assemble the Hip
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hip.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Hip'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			//epithelium.getX3D(true) +
			commonIliacArtery.getX3D(true) +
			internalIliacArtery.getX3D(true) +
			externalIliacArtery.getX3D(true) ;
		
		
		//System.out.println("Hip X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	
	// Calls upon the methods in the Ball and Socket joint
	// to change the angles of movement
	public void setRightFlexionAngle()
	{
	}
	
	public void setLeftFlexionAngle()
	{
	}
	
	public void RotationAngle()
	{
	}
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Hip.  
	 * This routine will be called when looking at an individual Hip with
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
		// HIPS BOUND BOX		
		//
		// Set up the Bounding Box for the Hip
		// For default model, length of chest is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);
		
		// Setup the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// HIP - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.HipEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HipEpitheliumRef, bioMightConnector);
	
		//********************************************	
		// HIP - VASCULAR CONNECTORS  
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
		// HIP - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// HIP - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Hip.   These boxes will define
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
			System.out.println("Hip - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Hip
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
		
		// Hip Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -9.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "HipEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("HipEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		boundingBoxMap.put(Constants.HipEpitheliumRef, bioBoundBox);
		

		//********************************************************************* 
		// HIPS BOUNDBOXES
		// Set up the Bounding Box for the Hip
		// On a porportioned human, the Hip are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT HIP BOUNDBOX
		// Set up the Bounding Box for the Left Hip
		// On a porportioned human, the Hip are located in the --- 
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
			
		// HipEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HipEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HipEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftHipRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT HIP BOUNDBOX
		// Set up the Bounding Box for the Hip
		// On a porportioned human, the Hip are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// HipEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HipEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HipEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightHipRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Hip 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.HipsRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
		
	
	
}
