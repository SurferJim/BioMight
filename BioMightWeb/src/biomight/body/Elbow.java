/*
 * Created on Apr 16, 2007
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

/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Elbows
 * 
 *****************************************************************************/

public class Elbow extends BodyPart {
	protected EpitheliumTissue epithelium;
	

	/************************************************************************
	 * Elbow Constructor 
	 *
	 ***********************************************************************/
	public Elbow()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ElbowRef, null, null);
	}

	/************************************************************************
	 * Elbow Constructor 
	 *
	 ***********************************************************************/
	public Elbow(String parentID)
	{
		//System.out.println("Calling parameterized Elbow Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Elbow Constructor 
	 *
	 ***********************************************************************/
	public Elbow(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Elbow with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Elbow
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Elbow.gif");
		setImageWidth(200);
		setImageHeight(150);
		componentID=parentID;
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Elbow
		// Either get from the Constructor or set up defaults
		System.out.println("Elbow - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Elbow - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Elbow - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Elbow - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Elbow - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
	
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Elbow METHODS: " + bioMightMethods.size());
			}
			
			// Generate the Elbow Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			/*
			System.out.println("In Elbow - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Elbow - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Elbow - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Elbow - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.ElbowEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Elbow - Constructor has Epithelium BoundBox: " + Constants.ElbowEpitheliumRef);
			else
				System.out.println("In Elbow - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.ElbowEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.ElbowEpitheliumRef, tempBoundBox);		
			System.out.println("In Elbow - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Elbow we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftElbowRef)) 
			{
				startID="ElbowEpithelium:00001";
			}			
			// We are creating the Esophagus for the Elbow
			else if (parentID.equals(Constants.RightElbowRef)) 
			{	
				startID="ElbowEpithelium:00480";
			}
		
			System.out.println("Creating Elbow Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.ElbowEpitheliumRef,  Constants.ElbowEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
			
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Elbow - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.ElbowEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("ElbowEpithelium is created");			
	
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}
	
	
	/****************************************************
	 * GENERATE
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the GastroEpiploicVein Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Elbow Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double circumference = 1.4;
			
			if (parentID.equals("Elbow:01")) {
				
				// Generate the Elbow
				double[] startPos = {9.0,-19.0,0.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	
	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-circumference},
	    		   		{x-circumference,     y, z-circumference*2},
	    		   		{x,                   y, z-circumference*3},
	    		   		{x+circumference,     y, z-circumference*3},
	    		   		{x+(circumference*2), y, z-circumference*2},
	    		   		{x+(circumference*2),     y, z-circumference},
	    		   		{x+circumference, y, z}
	    		   		};
					
				
				int success = bioMightBean.generateElbow("ElbowEpithelium:00001", "ElbowEpithelium", 
					"ElbowEpithelium", parentID, currentPoints);			
			}
			else if (parentID.equals("Elbow:02"))
			{
				// Generate the Elbow
				double[] startPos = {-10.0,-19.0,0.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 
	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-circumference},
	    		   		{x-circumference,     y, z-circumference*2},
	    		   		{x,                   y, z-circumference*3},
	    		   		{x+circumference,     y, z-circumference*3},
	    		   		{x+(circumference*2), y, z-circumference*2},
	    		   		{x+(circumference*2),     y, z-circumference},
	    		   		{x+circumference, y, z}
	    		   		};
				
				
				int success = bioMightBean.generateElbow("ElbowEpithelium:00080", "ElbowEpithelium", 
					"ElbowEpithelium", parentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ElbowEpithelium NoParent");
							
			}

			
			System.out.println("Created Elbow Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ElbowEpithelium");
			throw new ServerException("Remote Exception ElbowEpithelium():", e); 	
		}
	}

	
	public void initProperties() {


		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AnteriorLigament");
		property.setCanonicalName(Constants.AnteriorLigament);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorLigament");
		property.setCanonicalName(Constants.PosteriorLigament);
		properties.add(property);		
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Bend");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);		
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Elbow.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Elbow
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Elbow.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Elbow'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("Elbow X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Elbow.  
	 * This routine will be called when looking at an individual Elbow with
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
		// ELBOWS BOUND BOX		
		//
		// Set up the Bounding Box for the Elbow
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
		// ELBOW - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// ELBOW - VASCULAR CONNECTORS  
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
		// ELBOW - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// ELBOW - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Elbow.   These boxes will define
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
			System.out.println("Elbow - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// ELBOWS BOUND BOXES
		// Set up the Bounding Box for the Elbow
		// On a porportioned human, the Elbow are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT ELBOWS BOUNDBOX
		// Set up the Bounding Box for the Left Elbow
		// On a porportioned human, the Elbow are located in the --- 
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
			
		// ElbowEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftElbowRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT ELBOWS BOUNDBOX
		// Set up the Bounding Box for the Elbow
		// On a porportioned human, the Elbow are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ElbowEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightElbowRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Elbow 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ElbowsRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
	
}
