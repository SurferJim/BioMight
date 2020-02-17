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
 * LOBAR BRONCHI
 * 
 * @author SurferJim
 *
 * Representation of a collection of LobarBronchus.    
 *
 * 
 *****************************************************************************/

public class LobarBronchi extends BioMightBase {
private ArrayList lobarBronchi;

	
	/********************************************************************************************************************
	 *  LOBAR BRONCHI
	 * 
	 * This method will instantiate the bronchis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
public LobarBronchi(int LocalVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
{
	create(LocalVP, localLOD, parentID, bioMightProperties, bioMightMethods);
}

/********************************************************************************************************************
* CREATE BRONCHI
* 
* This method will instantiate the Bronchi that are defined for the current model.  
*   
********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
	
		lobarBronchi = new ArrayList();
		setImage("images/LobarBronchi.jpg");
		setImageHeight(300);
			setImageWidth(300);
	
		// Represents the internal bounding boxes that are in
		// each LobarBronchus
		HashMap boundingBoxesMap = null;
		
		/*
		System.out.println("LOBAR BRONCHI - Getting BoundBoxes & Connectors!");
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
			// connectors will be passed in through the Neck
			componentBoundBoxes = bioMightConstruct.getBoundingBoxes(Constants.BronchiRef);			
		}
		
		System.out.println("LOBAR BRONCHI - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		*/
	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LobarBronchiInfo for ParentID: " +  Constants.LobarBronchusRef + "   " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LobarBronchusRef, parentID);   	
		}	catch (Exception e) { 
			System.out.println("Exception Getting Components - LobarBronchi");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = Constants.LobarBronchiRef + ":0";
		
		// Run through the collection of Lobar Bronchi and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("LobarBronchi-Bronchus NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating LobarBronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			/*
			// LOBAR BRONCHI
			// Create and Load Constructor object
			System.out.println("In Lobar Bronchi - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In LobarBronchi - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In LobarBronchi - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In LobarBronchi - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In LobarBronchi - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*/
			
			// Create an instance of the Bronchi for each tranform specified for the organism
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG2X;
			LobarBronchus lobarBronchus = new LobarBronchus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("LobarBronchus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			lobarBronchi.add(lobarBronchus);
		
			// Get BioGenerate object from the creation
			BioMightGenerate generatedBronchus = lobarBronchus.getBioMightGenerate();
			// Add the  details to collection object, store it based on its ID
			//generatedBronchi.setMapComponent(bioMightTransform.getId(), generatedBronchus);
			System.out.println("Add BronchusBioGen to LobarBronchiBioGen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			initProperty(bioMightTransform.getName(), Constants.LobarBronchus, Constants.LobarBronchusRef, bioMightTransform.getId());		
			System.out.println("Add LobarBronchis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}
	
		// Store the information for the Generated LobarBronchus into the Bronchi object
		//this.bioMightGenerate = generatedBronchi;
	
		// Set up methods that will be available to the Bronchi
		initMethods();
	}
		
			
	
	
	public void initMethods() {
	
		BioMightMethodView method;
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.LobarBronchus);
		method.setMethodName("setRadius");
		method.setDisplayName("LobarBronchus Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setLength");
		method.setDisplayName("LobarBronchus Length:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Bronchi.  It runs through each of its components and collects up their
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
	
		String body = ""; 
		System.out.println("Assembling X3D for Bronchi");
		
		// Run through the collection of Bronchi and assemble the X3D for each
		for (int i=0; i<lobarBronchi.size(); i++)
		{
			// Get the information for the Bronhus
			LobarBronchus lobarBronchus = (LobarBronchus) lobarBronchi.get(i);
			//System.out.println("Getting X3D for LobarBronchus");
			body += lobarBronchus.getX3D(true);
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
		 * Setup the Default Bounding Boxes for the LobarBronchi.  The routine
		 * will return a set of bound boxes    
		 *
		 * @return
		 ********************************************************************/
		private BioMightBoundBoxes setupDefaultBoundBoxes() 
		{
		// Set up the collection to hold the Bounding Boxes
		BioMightBoundBoxes bioBoundBoxes = new BioMightBoundBoxes();
	
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
		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = null;
	
		//********************************************************************* 
		// LEFT SUPERIOR LOBAR BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Lobar Bronchi
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
		startPos = getStartPoints(1.5, -12.00, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(2.0, -12.50, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorLobeBronchusRef, bioBoundBox);
	
		//********************************************************************* 
		// LEFT INFERIOR LOBAR BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Lobar Bronchi
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
		startPos = getStartPoints(1.5, -12.00, -3.0);;
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-2.5, -12.00, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorLobeBronchusRef, bioBoundBox);
		
	
		//********************************************************************* 
		// RIGHT SUPERIOR LOBAR BRONCHUS BOUNDBOX
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
		startPos = getStartPoints(-1.5, -12.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-2.0, -12.50, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightSuperiorLobeBronchusRef, bioBoundBox);
	
		//********************************************************************* 
		// RIGHT MIDDLE LOBAR BRONCHUS BOUNDBOX
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
		startPos = getStartPoints(-1.5, -12.50, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-2.5, -13.00, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightMiddleLobeBronchusRef, bioBoundBox);
	
		
		//********************************************************************* 
		// RIGHT INFERIOR LOBAR BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Trachea
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Bronchus Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-1.5, -12.25, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-1.75, -13.25, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
	
		// Associate the connector on the Box
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box in the collection
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorLobeBronchusRef, bioBoundBox);
	
	
		// return the collection that holds both bronchi bound boxes
		return (bioBoundBoxes);
	}
	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Internal Bounding Boxes for the Lobar Bronchi. This divides
	 * the Lobar Bronchi into its vascular,muscular,tissue components.   
	 *	
	 * As we are working with a collection, the hashmap will not contain
	 * a bunch of bound boxes with connectors.  It will contain five 
	 * BioMightBoxes.  Each BioMightBox has a hashmap.   with it will have all the
	 * inner connectors that are needed when passed to the specific bronchus
	 * that uses the information
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
	
		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = null;
	
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
	
		// Use the information in the incoming Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxesIn != null)
		{
			// In the default instance,there will be two bound boxes
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftSuperiorLobeBronchusRef);
			System.out.println("LeftSuperiorLobeBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftInferiorLobeBronchusRef);
			System.out.println("LeftInferiorLobeBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
				
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightSuperiorLobeBronchusRef);
			System.out.println("RightSuperiorLobeBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightMiddleLobeBronchusRef);
			System.out.println("RightMiddleLobeBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorLobeBronchusRef);
			System.out.println("RightInferiorLobe - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		
		}
	
		//********************************************************************* 
		// 01- LEFT SUPERIOR LOBAR BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-1.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		// Allocate the collection of boxes
		bioBoundBoxes = new BioMightBoundBoxes();
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(1.0, -12.0, -1.0);
		startPoints = BioGraphics.octogonXPlane(startPos, circumference);
		endPos = getEndPoints(2.75, -11.25, -1.0);
		endPoints = BioGraphics.octogonXPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - BoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.LobarBronchusEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftSuperiorLobeBronchusRef, bioBoundBoxes);
		System.out.println("Adding - LeftSuperiorLobeBronchus bioBoundBoxes into BoxesMap"); 
	
		
		//********************************************************************* 
		// 02- LEFT INFERIOR LOBAR BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		// Allocate the collection of boxes
		bioBoundBoxes = new BioMightBoundBoxes();
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(1.0, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(2.00, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - BoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.LobarBronchusEpitheliumRef, bioBoundBox);
		
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.LeftInferiorLobeBronchusRef, bioBoundBoxes);
		System.out.println("Adding - LeftInferiorLobeBronchus bioBoundBoxes into BoxesMap"); 
	
		//********************************************************************* 
		// 03- RIGHT SUPERIOR LOBAR BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		// Allocate the collection of boxes
		bioBoundBoxes = new BioMightBoundBoxes();
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -12.0, -1.0);
		startPoints = BioGraphics.octogonXPlane(startPos, circumference);
		endPos = getEndPoints(-2.25, -11.25, -1.0);
		endPoints = BioGraphics.octogonXPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - BoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.LobarBronchusEpitheliumRef, bioBoundBox);		
	
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightSuperiorLobeBronchusRef, bioBoundBoxes);
		System.out.println("Adding - RightSuperiorLobeBronchusRef bioBoundBoxes into BoxesMap"); 
	
		//********************************************************************* 
		// 04- RIGHT MIDDLE LOBAR BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		// Allocate the collection of boxes
		bioBoundBoxes = new BioMightBoundBoxes();
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-1.00, -12.00, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-3.50, -13.25, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.LobarBronchusEpitheliumRef, bioBoundBox);		
	
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightMiddleLobeBronchusRef, bioBoundBoxes);
		System.out.println("Adding - RightMiddleLobeBronchusRef bioBoundBoxes into BoxesMap"); 
		
		
		//********************************************************************* 
		// 05- RIGHT INFERIOR LOBAR BRONCHI EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(-2.5);
		yPos = new BigDecimal(-16.0);
		zPos= new BigDecimal(-3.0);
	
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);
	
		// Allocate the collection of boxes
		bioBoundBoxes = new BioMightBoundBoxes();
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
	
		// Bronchi Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-1.00, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-1.25, -13.50, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);		
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
		bioBoundBoxes.setBoundingBox(Constants.LobarBronchusEpitheliumRef, bioBoundBox);		
	
		// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
		boundingBoxesMap.put(Constants.RightInferiorLobeBronchusRef, bioBoundBoxes);
		System.out.println("Adding - RightInferiorLobeBronchusRef bioBoundBoxes into BoxesMap"); 
		
		return (boundingBoxesMap);
	}

	
}

