/*
., * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;

import java.lang.reflect.Method;
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
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the Elbows
 * 
 *************************************************************************************/
public class Elbows extends BioMightBase {
	private ArrayList elbows;
		
	
	/********************************************************************************************************************
	 *  ELBOWS
	 * 
	 * This method will instantiate the elbows that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Elbows()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ElbowsRef, null, null);
	}

	/************************************************************************
	 * Elbows Constructor 
	 *
	 ***********************************************************************/
	public Elbows(String parentID)
	{
		//System.out.println("Calling parameterized Elbows Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Elbows Constructor 
	 *
	 ***********************************************************************/
	public Elbows(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Elbows with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Elbows
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Elbows.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		elbows = new ArrayList();
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		/*
		// Represents the internal bounding boxes that are in
 		// each Elbow
		HashMap boundingBoxesMap = null;
		
		System.out.println("Elbows - Getting BoundBoxes & Connectors!");
		BioMightBoundBoxes componentBoundBoxes = null;
		if (bioMightConstruct == null)
		{
			componentBoundBoxes = setupDefaultBoundBoxes();
		}
		else
		{
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.ElbowsRef);			
		}
		
		System.out.println("Elbows - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		BioMightGenerate generatedElbows =  new BioMightGenerate();
		*/
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ElbowsInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.ElbowRef, Constants.ElbowRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.ElbowRef, parentID);
			System.out.println("Have Elbows Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Elbows");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.ElbowsRef+":0"; 
		
		// Run through the collection of Elbows and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Elbows NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Elbow: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			/*
			// Create and Load Constructor object
			System.out.println("In Elbows - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Elbows - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Elbows - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Elbows - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Elbows - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Elbows for each tranform specified for the organism
			Elbow elbow = new Elbow(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Elbow Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			elbows.add(elbow);
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedElbow = elbow.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			//generatedElbows.setMapComponent(bioMightTransform.getId(), generatedElbow);
			System.out.println("Add GeneratedElbow to Map: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			initProperty(bioMightTransform.getName(), Constants.Elbow, Constants.ElbowRef, bioMightTransform.getId());		
			System.out.println("Add Elbowss to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			}

		// Set up methods that will be available to the Elbows
		initMethods();
	}
			
	
	
	
	public void initMethods() {

		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setBendAngle");
		method.setDisplayName("Elbow Angle:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setSize");
		method.setDisplayName("Elbow Size:");
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
		
		// Assemble the Elbows
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Elbows.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Elbows'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Elbows");
		
		// Run through the collection of Elbows and assemble the X3D for each
		for (int i=0; i<elbows.size(); i++)
		{
			// Get the information for the eye
			Elbow elbow = (Elbow) elbows.get(i);
			System.out.println("Getting X3D for Elbow");
			body += elbow.getX3D(true);
		}		
		

		//System.out.println("Elbows X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Elbows-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Elbows: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Elbows)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
						// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("Before Execute Method(Double)" + methodName);
							}
							else
								System.out.println("Not Executing Double - 0.0"); 
						}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Elbows - Methods have fired.   Calling Elbows Save method!");
				//save();
			}
		}
	}	

	
	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Elbows.  The routine
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
		// LEFT ELBOW BOUNDBOX
		// Set up the Bounding Box for the Elbows
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
	
		// Elbows Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftElbowRef, bioBoundBox);
	
	
		//********************************************************************* er
		// RIGHT ELBOW BOUNDBOX
		// Set up the Bounding Box for the Elbow
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
		
		// Elbow Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightElbowRef, bioBoundBox);
	
		// return the collection that holds both elbow bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Elbows. This divides
	 * the Elbows into its vascular,muscular,tissue components   
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
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftElbowRef);
			System.out.println("LeftElbow - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightElbowRef);
			System.out.println("RightElbow - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("Elbows SetupBoundBoxes - Incoming BoundBoxes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT ELBOWS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Elbows
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
	
		// Elbows Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.ElbowEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Elbow into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftElbowRef, bioBoundBoxes);
		System.out.println("Adding - Left Elbow bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT ELBOWS EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Elbows
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
	
		// Elbows Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.ElbowEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Elbow into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightElbowRef, bioBoundBoxes);
		System.out.println("Adding - Right Elbow bioBoundBoxes into BoxesMap"); 

		
		return (boundingBoxesMap);
	}

}
