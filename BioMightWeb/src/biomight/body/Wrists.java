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

import javax.naming.Context;
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

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Wrists extends BioMightBase {
	private ArrayList wrists;
	 

	/********************************************************************************************************************
	 *  WRISTS
	 * 
	 * This method will instantiate the wrists that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Wrists()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.WristsRef, null, null);
	}

	/************************************************************************
	 * Wrists Constructor 
	 *
	 ***********************************************************************/
	public Wrists(String parentID)
	{
		//System.out.println("Calling parameterized Wrists Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Wrists Constructor 
	 *
	 ***********************************************************************/
	public Wrists(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Wrists with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Wrists
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		setImage("images/Wrists");
		setImageHeight(300);
 		setImageWidth(300);
		wrists = new ArrayList();
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		
		/*
		// Represents the internal bounding boxes that are in
 		// each Wrist
		HashMap boundingBoxesMap = null;
		
		System.out.println("Wrists - Getting BoundBoxes & Connectors!");
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
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.WristsRef);			
		}
		
		System.out.println("Wrists - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		BioMightGenerate generatedWrists =  new BioMightGenerate();


		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting WristsInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.WristRef, parentID);
			System.out.println("Have Wrists Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Wrists");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.WristsRef+":0"; 
		
		// Run through the collection of Wrists and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Wrists NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Wrist: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			/*
			// Create and Load Constructor object
			System.out.println("In Wrists - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Wrists - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Wrists - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Wrists - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Wrists - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Wrists for each tranform specified for the organism
			Wrist wrist = new Wrist(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("Wrist Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			wrists.add(wrist);
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedWrist = wrist.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			generatedWrists.setMapComponent(bioMightTransform.getId(), generatedWrist);
			System.out.println("Add WristBioGen to WristsBioGen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			initProperty(bioMightTransform.getName(), Constants.Wrist, Constants.WristRef, bioMightTransform.getId());		
			System.out.println("Add Wristss to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

		}

		// Set up methods that will be available to the Wrists
		initMethods();
	}
		
	
		
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();

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
		
		// Assemble the Wrists
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Wrists.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Wrists'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Wrists");
		
		// Run through the collection of Wrists and assemble the X3D for each
		for (int i=0; i<wrists.size(); i++)
		{
			// Get the information for the eye
			Wrist wrist = (Wrist) wrists.get(i);
			System.out.println("Getting X3D for Wrist");
			body += wrist.getX3D(true);
		}		
		

		//System.out.println("Wrists X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Wrists.  The routine
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
		// LEFT WRIST BOUNDBOX
		// Set up the Bounding Box for the Wrists
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
	
		// Wrists Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftWristRef, bioBoundBox);
	
	
		//********************************************************************* er
		// RIGHT WRIST BOUNDBOX
		// Set up the Bounding Box for the Wrist
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
		
		// Wrist Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightWristRef, bioBoundBox);
	
		// return the collection that holds both wrist bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Wrists. This divides
	 * the Wrists into its vascular,muscular,tissue components   
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
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftWristRef);
			System.out.println("LeftWrist - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightWristRef);
			System.out.println("RightWrist - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("Wrists SetupBoundBoxes - Incoming BoundBoxes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT WRISTS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Wrists
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(8.0);
		yPos = new BigDecimal(-30.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Wrists Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -31.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.WristEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Wrist into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftWristRef, bioBoundBoxes);
		System.out.println("Adding - Left Wrist bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT WRISTS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Wrists
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-8.0);
		yPos = new BigDecimal(-30.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Wrists Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.5, -31.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.WristEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Wrist into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightWristRef, bioBoundBoxes);
		System.out.println("Adding - Right Wrist bioBoundBoxes into BoxesMap"); 

		
		return (boundingBoxesMap);
	}
	
}
