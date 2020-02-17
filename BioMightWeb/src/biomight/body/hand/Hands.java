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

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
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


/*************************************************************************
 * @author SurferJim
 *
 * Representation of the Hands
 * 
 ************************************************************************/


public class Hands extends BioMightBase {
	private ArrayList hands;
	Fingers fingers;
	Palm palm;
	
	
	/********************************************************************************************************************
	 *  HANDS
	 * 
	 * This method will instantiate the hands that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	public Hands()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.HandsRef, null, null);
	}

	/************************************************************************
	 * Hands Constructor 
	 *
	 ***********************************************************************/
	public Hands(String parentID)
	{
		//System.out.println("Calling parameterized Hands Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Hands Constructor 
	 *
	 ***********************************************************************/
	public Hands(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Hands with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Hands
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		setImage("images/Hands.jpg");
		setImageHeight(300);
		hands = new ArrayList();
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		/*
		// Represents the internal bounding boxes that are in
 		// each Hand
		HashMap boundingBoxesMap = null;
		
		System.out.println("Hands - Getting BoundBoxes & Connectors!");
		BioMightBoundBoxes componentBoundBoxes = null;
		if (bioMightConstruct == null)
		{
			// Its null, so set up default boundbox with connectors 
			// This will give me two bound boxes by default
			componentBoundBoxes = setupDefaultBoundBoxes();
		}
		else
		{
			// Use the incoming	bound boxes. A pair of boxes with associated 
			// connectors will be passed in through the 
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.HandsRef);			
		}
		
		System.out.println("Hands - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		BioMightGenerate generatedHands =  new BioMightGenerate();
		*/
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting HandsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.HandRef, parentID);
			System.out.println("Have Hands Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Hands");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.HandsRef+":0"; 	
		
		// Run through the collection of Hands and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Hands NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Hand: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			/*
			// Create and Load Constructor object
			System.out.println("In Hands - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Hands - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Hands - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Hands - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Hands - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Hands for each tranform specified for the organism
			Hand hand = new Hand(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("Hand Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			hands.add(hand);
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedHand = hand.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			//generatedHands.setMapComponent(bioMightTransform.getId(), generatedHand);
			System.out.println("Add HandBioGen to HandsBioGen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			initProperty(bioMightTransform.getName(), Constants.Hand, Constants.HandRef, bioMightTransform.getId());		
			System.out.println("Add Handss to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}
		
		// Store the information for the Generated Hand into the Hands object
		//this.bioMightGenerate = generatedHands;
	
		// Set up methods that will be available to the Hands
		initMethods();
	}
	
			
	
	public void initMethods() {
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setRadius");
		method.setDisplayName("Iris Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Pupil Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
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
		
		// Assemble the Hands
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hands.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Hands'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Hands");
		
		// Run through the collection of Hands and assemble the X3D for each
		for (int i=0; i<hands.size(); i++)
		{
			// Get the information for the eye
			Hand hand = (Hand) hands.get(i);
			System.out.println("Getting X3D for Hand");
			body += hand.getX3D(true);
		}		
		

		//System.out.println("Hands X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Hands.  The routine
	 * will return a set of bound boxes    
	 *
	 * @return
	 ********************************************************************/
	private BioMightBoundBoxes setupDefaultBoundBoxes() 
	{
		// Set up the collection to hold the Bounding Boxes
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
	
		// Initialize a BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize a Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = null;
	
		//********************************************************************* 
		// LEFT HAND BOUNDBOX
		// Set up the Bounding Box for the Hands
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Hands Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftHandRef, bioBoundBox);
	
	
		//********************************************************************* er
		// RIGHT HAND BOUNDBOX
		// Set up the Bounding Box for the Hand
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Hand Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightHandRef, bioBoundBox);
	
		// return the collection that holds both shoulder bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Hands. This divides
	 * the Hands into its vascular,muscular,tissue components   
	 *	
	 * As we are working with a collection, the hashmap will not contain
	 * a bunch of bound boxes with connectors.  It will contain two 
	 * BioMightBoxes.  Each BioMightBox has a hashmap.   with it will have all the
	 * inner connectors that are needed.
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBoxes bioMightBoundBoxesIn) 
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes
		HashMap boundingBoxesMap = new HashMap();
	
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
	
		// Initialize the BoundBoxes. These will have a bound
		// box for each Cnemis by default
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = null;
		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = null;
	
		// Use the information in the incoming Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxesIn != null)
		{
			// In the default instance,there will be two bound boxes
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftHandRef);
			System.out.println("LeftHand - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightHandRef);
			System.out.println("RightHand - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("Hands SetupBoundBoxes - Incoming BoundBoxes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT HANDS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Hands
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(8.0);
		yPos = new BigDecimal(-8.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Hands Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.HandEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Hand into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftHandRef, bioBoundBoxes);
		System.out.println("Adding - Left Hand bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT HANDS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Hands
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-8.0);
		yPos = new BigDecimal(-8.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Hands Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.HandEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Hand into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightHandRef, bioBoundBoxes);
		System.out.println("Adding - Right Hand bioBoundBoxes into BoxesMap"); 

		
		return (boundingBoxesMap);
	}

	
	
}
