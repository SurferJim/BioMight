/*
 * Created on May 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.lung;

import java.lang.reflect.Method;
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

/*****************************************************************************
 * BRONCHI
 * 
 * Representation of the Bronchi.   A collection of Bronchus which in the
 * human model is comprised of a left and a right
 * 
 *****************************************************************************/

public class Bronchi extends BioMightBase {
	private ArrayList bronchi;


	/********************************************************************************************************************
	 *  BRONCHI
	 * 
	 * This method will instantiate the bronchi that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Bronchi(int LocalVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(LocalVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

  /********************************************************************************************************************
   * CREATE BRONCHI
   * 
   * This method will instantiate the Bronchi that are defined for the current model.  
   *   
   ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {

		bronchi = new ArrayList();
		setImage("images/Bronchi.jpg");
		setImageHeight(300);
 		setImageWidth(300);
	
 		/****************88
		// Represents the internal bounding boxes that are in
 		// each Bronchus
		HashMap boundingBoxesMap = null;
		
		System.out.println("BRONCHI - Getting BoundBoxes & Connectors!");
		BioMightBoundBoxes componentBoundBoxes = null;
		if (bioMightConstruct == null)
		{
			// Its null, so set up default boundbox with connectors 
			// This will give me two bound boxes by default
			System.out.println("BRONCHI - Setting up Default BoundBoxes");
			componentBoundBoxes = setupDefaultBoundBoxes();
		}
		else
		{
			// Use the incoming	bound boxes. A pair of boxes with associated 
			// connectors will be passed in through the Neck
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.BronchiRef);			
		}
		
		System.out.println("BRONCHI - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
		// Set up a Generate Object that will be used to return data related
		// to the construction of this object. We drive the process via
		// parameterization, but randomness may be introduced that makes the
		// outcome unpredictable
		BioMightGenerate generatedBronchi =  new BioMightGenerate();
		*/
 		
 		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BronchiInfo for ParentID: " +  Constants.BronchusRef + "   " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BronchusRef, parentID);   	
		}	catch (Exception e) { 
			System.out.println("Exception Getting Components - Bronchi");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = Constants.BronchiRef + ":0";
	
		// Run through the collection of Bronchi and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Bronchi-Bronchus NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Bronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			/*
			// BRONCHI
			// Create and Load Constructor object
			System.out.println("In Bronchi - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In Bronchi - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Bronchi - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In Bronchi - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In Bronchi - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Bronchi for each tranform specified for the organism
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG2X;
			Bronchus bronchus = new Bronchus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Bronchus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bronchi.add(bronchus);
		
			/*
			// Get BioGenerate object from the creation
			BioMightGenerate generatedBronchus = bronchus.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			generatedBronchi.setMapComponent(bioMightTransform.getId(), generatedBronchus);
			System.out.println("Add BronchusBioGen to BronchiBioGen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			*/
			
			initProperty(bioMightTransform.getName(), Constants.Bronchus, Constants.BronchusRef, bioMightTransform.getId());		
			System.out.println("Add Bronchis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Store the information for the Generated Bronchus into the Bronchi object
		//this.bioMightGenerate = generatedBronchi;
	
		// Set up methods that will be available to the Bronchi
		initMethods();
	}
		


	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Bronchus);
		method.setMethodName("setRadius");
		method.setDisplayName("Bronchus Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setLength");
		method.setDisplayName("Bronchus Length:");
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
	
		// Assemble the Bronchi
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		"<meta name='BioMightImage' content='Bronchi.jpg'/>\n" +
		"<meta name='ExportTime' content='7:45:30'/>\n" +
		"<meta name='ExportDate' content='08/15/2008'/>\n" +
		"<meta name='BioMight Version' content='1.0'/>\n" + 	
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bronchi'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
 
		System.out.println("Assembling X3D for Bronchi");
	
		String body = "";
		for (int i=0; i<bronchi.size(); i++)
		{
			
			// Get the information for the Lung
			Bronchus bronchus = (Bronchus) bronchi.get(i);
			System.out.println("Getting X3D for Bronchus");
			body += bronchus.getX3D(true);
		}		
		
		//System.out.println("Bronchi X3D: " + body);		
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
		System.out.println("Bronchi-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
		
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Bronchi: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
		
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Bronchi)) {				
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
				System.out.println("Bronchi - Methods have fired.   Calling Bronchi Save method!");
				//save();
			}
		}
	}	


	/********************************************************************
	 * SETUP DEFAULT BOUNDBOXES
	 * 
	 * Setup the Default Bounding Boxes for the Bronchi.  The routine
	 * will return a set of bound boxes    
	 *
	 * @return
	 ********************************************************************/
	private BioMightBoundBoxes setupDefaultBoundBoxes() 
	{
		// Set up the collection to hold the Bounding Boxes
		BioMightBoundBoxes bioBoundBoxes = new BioMightBoundBoxes() ;
	
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
		// LEFT BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Bronchi
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
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftBronchusRef, bioBoundBox);
	
	
		//********************************************************************* 
		// RIGHT BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Trachea
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
		
		// Bronchus Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(2.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightBronchusRef, bioBoundBox);
	
		// return the collection that holds both bronchi bound boxes
		return (bioBoundBoxes);
	}


	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Bronchi. This divides
	 * the Bronchi into its vascular,muscular,tissue components   
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
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftBronchusRef);
			System.out.println("LeftBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());

			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightBronchusRef);
			System.out.println("RightBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		}
		else
		{
			System.out.println("BronchiSetupBoundBoxes - Incoming BoundBoes are Null");
		}
	
	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -11.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - LeftBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.BronchusEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftBronchusRef, bioBoundBoxes);
		System.out.println("Adding - Left Bronchus bioBoundBoxes into BoxesMap"); 

	
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// RIGHT BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -11.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.5, -12.00, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.BronchusEpitheliumRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightBronchusRef, bioBoundBoxes);
		System.out.println("Adding - Right Bronchus bioBoundBoxes into BoxesMap"); 

		
		return (boundingBoxesMap);
	}

	
}
