/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg.cnemis;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
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


/*************************************************************
 * @author SurferJim
 *
 * Representation of the Cnemes.
 * 
 *************************************************************/

public class Cnemes extends BioMightBase {
	private ArrayList cnemes; 
	
	
	
	public Cnemes()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CnemesRef, null, null);
	}

	public Cnemes(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Cnemes(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Cnemes Create");
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
		setImage("images/Cnemes.jpg");
		setImageHeight(300);
 		setImageWidth(300);
 		
		cnemes = new ArrayList();
		
		/*
		// Represents the internal bounding boxes that are in
 		// each Cnemes
		HashMap boundingBoxesMap = null;
		
		System.out.println("Cnemes - Getting BoundBoxes & Connectors!");
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
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.CnemesRef);			
		}
		
		System.out.println("Cnemes - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		 */
		
		BioMightGenerate generatedCnemes =  new BioMightGenerate();

		
		// Get the information from the database via the Enterprise Bean			
		// Get the data for the Cnemes
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CnemesInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CnemisRef, parentID);
			System.out.println("Have Cnemes Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cnemes");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.CnemesRef+":0"; 

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

	
		// Run through the collection of Cnemes and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Cnemes NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Cnemis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			
			/*
			// Create and Load Constructor object
			System.out.println("In Cnemes - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Cnemes - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Cnemes - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Cnemes - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Cnemes - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Cnemes for each tranform specified for the organism
			Cnemis cnemis = new Cnemis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Cnemis Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			cnemes.add(cnemis);
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedCnemis = cnemis.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			generatedCnemes.setMapComponent(bioMightTransform.getId(), generatedCnemis);
			System.out.println("Add generatedCnemis to Map: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			initProperty(bioMightTransform.getName(), Constants.Cnemis, Constants.CnemisRef, cnemis.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			//initProperty(bioMightTransform.getName(), Constants.Cnemis, Constants.CnemisRef, bioMightTransform.getId());		
			System.out.println("Add Cnemis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			}

		// Set up methods that will be available to the Cnemes
		initMethods();
	}
			
	

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
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
		
		// Assemble the Cnemes
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cnemes.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cnemes'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Cnemes");
		
		// Run through the collection of Cnemes and assemble the X3D for each
		for (int i=0; i<cnemes.size(); i++)
		{
			// Get the information for the eye
			Cnemis cnemis = (Cnemis) cnemes.get(i);
			//System.out.println("Getting X3D for Cnemis");
			body += cnemis.getX3D(true);
		}		
		
		//System.out.println("Cnemes X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Cnemes.  The routine
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
		// LEFT CNEMIS BOUNDBOX
		// Set up the Bounding Box for the Cnemes
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(0.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(0.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Cnemes Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftCnemisRef, bioBoundBox);
	
	
		//********************************************************************* er
		// RIGHT CNEMES BOUNDBOX
		// Set up the Bounding Box for the Cnemis
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
		
		// Cnemis Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightCnemisRef, bioBoundBox);
	
		// return the collection that holds both cnemis bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Cnemes. This divides
	 * the Cnemes into its vascular,muscular,tissue components   
	 *	
	 * As we are working with a collection, the hashmap will not contain
	 * a bunch of bound boxes with connectors.  It will contain two 
	 * BioMightBoxes.  Each BioMightBox has a hashmap.   with it will have 
	 * all the inner connectors that are needed.
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
		// box for each cnemis by default
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
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftCnemisRef);
			System.out.println("LeftCnemis - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightCnemisRef);
			System.out.println("RightCnemis - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("Cnemes SetupBoundBoxes - Incoming BoundBoxes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT CNEMIS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Cnemes
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(8.0);
		yPos = new BigDecimal(-48.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Cnemes Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -48.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -58.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.CnemisEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Cnemis into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftCnemisRef, bioBoundBoxes);
		System.out.println("Adding - Left Cnemis bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT CNEMIS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Cnemes
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-8.0);
		yPos = new BigDecimal(-48.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Cnemes Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -48.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.5, -58.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.CnemisEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Shoulder into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightCnemisRef, bioBoundBoxes);
		System.out.println("Adding - Right Cnemis bioBoundBoxes into BoxesMap"); 

		return (boundingBoxesMap);
	}	
	
}
