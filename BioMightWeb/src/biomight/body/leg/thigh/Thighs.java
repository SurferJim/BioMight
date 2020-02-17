/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg.thigh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.Esophagus;
import biomight.ejb.BioMightBeanLocal;
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
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*****************************************************************************
 * @author SurferJim
 *
 * Representation of the Thighs
 ****************************************************************************/

public class Thighs extends BioMightBase {
	private ArrayList thighs;
	
	
	public Thighs()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ThighsRef, null, null);
	}

	public Thighs(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Thighs(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Thighs Create");
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
		thighs = new ArrayList();
		
		setImage("images/Thighs.jpg");
		setImageHeight(300);
 		setImageWidth(300);
	
 		/*
		// Represents the internal bounding boxes that are in
 		// each Thigh
		HashMap boundingBoxesMap = null;
		
		System.out.println("Thighs - Getting BoundBoxes & Connectors!");
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
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.ThighsRef);			
		}
		
		System.out.println("Thighs - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		*/
		BioMightGenerate generatedThighs =  new BioMightGenerate();
		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
		}
		
		// Get the information from the database via the Enterprise Bean			
		// Get the data for the Thighs
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ThighsInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ThighRef, parentID);
			System.out.println("Have Thighs Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Thighs");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.ThighsRef+":0"; 
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		// Run through the collection of Thighs and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Thighs NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Thigh we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Thigh: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			/*
			// Create an instance of the Thigh for each tranform specified for the organism
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Thighs - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Thighs - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Thighs - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Thighs - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Thighs for each tranform specified for the organism
			Thigh thigh = new Thigh(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Thigh Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			thighs.add(thigh);
			initProperty(bioMightTransform.getName(), Constants.Thigh, Constants.ThighRef, thigh.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedThigh = thigh.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			generatedThighs.setMapComponent(bioMightTransform.getId(), generatedThigh);
			System.out.println("Added GeneratedThigh to Map: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Add Thighs to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
	}

		// Set up methods that will be available to the Thighs
		initMethods();
	}
			
	

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		property.setPropertyType(Constants.PARENT_COMPONENT);
		properties.add(property);
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
		
		// Assemble the Thighs
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thighs.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thighs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Thighs");
		
		// Run through the collection of Thighs and assemble the X3D for each
		for (int i=0; i<thighs.size(); i++)
		{
			// Get the information for the eye
			Thigh thigh = (Thigh) thighs.get(i);
			System.out.println("Getting X3D for Thigh");
			body += thigh.getX3D(true);
		}		
		
		//System.out.println("Thighs X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Thighs.  The routine
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
		// LEFT THIGH BOUNDBOX
		// Set up the Bounding Box for the Thighs
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-44.0);
		zPos= new BigDecimal(3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Thighs Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -44.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftThighRef, bioBoundBox);
	
	
		//********************************************************************* er
		// RIGHT THIGH BOUNDBOX
		// Set up the Bounding Box for the Thigh
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-44.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Thigh Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -44.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightThighRef, bioBoundBox);
	
		// return the collection that holds both thigh bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Thighs. This divides
	 * the Thighs into its vascular,muscular,tissue components   
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
		// box for each brocnchus by default
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
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftThighRef);
			System.out.println("LeftThigh - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightThighRef);
			System.out.println("RightThigh - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("Thighs SetupBoundBoxes - Incoming BoundBoxes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT THIGHS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Thighs
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(4.0);
		yPos = new BigDecimal(-34.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Thighs Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(4.0, -34.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -44.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.ThighEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Thigh into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftThighRef, bioBoundBoxes);
		System.out.println("Adding - Left Thigh bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT THIGHS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Thighs
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-4.0);
		yPos = new BigDecimal(-34.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Thighs Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-4.0, -34.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-4.0, -44.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.ThighEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Thigh into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightThighRef, bioBoundBoxes);
		System.out.println("Adding - Right Thigh bioBoundBoxes into BoxesMap"); 

		
		return (boundingBoxesMap);
	}

}
