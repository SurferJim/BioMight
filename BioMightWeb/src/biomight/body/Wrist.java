/*
 * Created on Jul 7, 2006
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


/****************************************************************************
 * @author SurferJim
 *
 * Representation of the Wrist
 ***************************************************************************/

public class Wrist extends BodyPart {
	protected EpitheliumTissue epithelium;
		
	/************************************************************************
	 * Wrist Constructor 
	 *
	 ***********************************************************************/
	public Wrist()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.WristRef, null, null);
	}

	/************************************************************************
	 * Wrist Constructor 
	 *
	 ***********************************************************************/
	public Wrist(String parentID)
	{
		//System.out.println("Calling parameterized Wrist Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Wrist Constructor 
	 *
	 ***********************************************************************/
	public Wrist(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Wrist with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Wrist
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Wrist.gif");
		setImageWidth(200);
		setImageHeight(150);
		componentID = parentID;
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Wrist
		// Either get from the Constructor or set up defaults
		System.out.println("Wrist - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Wrist - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Wrist - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Wrist - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Wrist - BoundingBoxes are NULL");						
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
				System.out.println("NEED TO EXECUTE Wrist METHODS: " + bioMightMethods.size());
			}
			
			// Generate the Elbow Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			/*
			System.out.println("In Wrist - Getting the BoundBox: " + parentID);
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Wrist - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Wrist - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Wrist - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.WristEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Wrist - Constructor has Epithelium BoundBox: " + Constants.WristEpitheliumRef);
			else
				System.out.println("In Wrist - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.WristEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.WristEpitheliumRef, tempBoundBox);		
			System.out.println("In Wrist - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Wrist we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftWristRef)) 
			{
				startID="WristEpithelium:00001";
			}			
			// We are creating the Esophagus for the Wrist
			else if (parentID.equals(Constants.RightWristRef)) 
			{	
				startID="WristEpithelium:00480";
			}
		
			System.out.println("Creating Wrist Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.WristEpitheliumRef,  Constants.WristEpitheliumRef, parentID, bioMightProperties, bioMightMethods);		
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Wrist - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.WristEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("WristEpithelium is created");			

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
		// Generate the Wrist E		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Wrist Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double circumference = 1.0;
			
			if (parentID.equals("Wrist:01")) {
				
				// Generate the Wrist
				double[] startPos = {9.0,-30.0,-0.25};
				
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
					
				
				int success = bioMightBean.generateWrist("WristEpithelium:00001", "WristEpithelium", 
					"WristEpithelium", parentID, currentPoints);			
			}
			else if (parentID.equals("Wrist:02"))
			{
				// Generate the Elbow
				double[] startPos = {-10.0,-30.0,-0.25};
				
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
				
				
				int success = bioMightBean.generateWrist("WristEpithelium:00080", "WristEpithelium", 
					"WristEpithelium", parentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate WristEpithelium NoParent");		
			}

			
			System.out.println("Created WristEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - WristEpithelium");
			throw new ServerException("Remote Exception WristEpithelium():", e); 	
		}
	}
	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bicep ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
		

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Wrist.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Wrist
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Wrist.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Wrist'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("Wrist X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	

	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Wrist.  
	 * This routine will be called when looking at an individual Wrist with
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
		// WRISTS BOUND BOX		
		//
		// Set up the Bounding Box for the Wrist
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
		// WRIST - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// WRIST - VASCULAR CONNECTORS  
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
		// WRIST - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// WRIST - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Wrist.   These boxes will define
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
			System.out.println("Wrist - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// WRISTS BOUND BOXES
		// Set up the Bounding Box for the Wrist
		// On a porportioned human, the Wrist are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT WRISTS BOUNDBOX
		// Set up the Bounding Box for the Left Wrist
		// On a porportioned human, the Wrist are located in the --- 
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
			
		// WristEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftWristRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT WRISTS BOUNDBOX
		// Set up the Bounding Box for the Wrist
		// On a porportioned human, the Wrist are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// WristEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightWristRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Wrist 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.WristsRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}	
	
}
