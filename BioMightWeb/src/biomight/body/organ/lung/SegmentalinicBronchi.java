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
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

	/*********************************************************************************************
	 * SEGMENTALINIC BRONCHI
	 * 
	 *	@author SurferJim
	 *
	 * Representation of the Segmentalinic Bronchi.   A collection of SegmentalinicBronchus which 
	 * in the human model is comprised of a 8 on the left and 10 on the right.   There would be
	 * 10 on boht sides, but two on the left side are fused.
	 * 
	 ****************************************************************************************************/

	public class SegmentalinicBronchi extends BioMightBase {
		private ArrayList segmentalinicBronchi;


		public SegmentalinicBronchi()
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, Constants.SegmentalinicBronchiRef, null, null);
		}
		
		public SegmentalinicBronchi(String parentID)
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, parentID, null, null);
		}
		
		public SegmentalinicBronchi(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
		{
			create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
		}
		
		/*****************************************************************
		 * CREATE
		 * 
		 * @param parentID
		 * @param bioMightMethods
		 ******************************************************************/
		public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
		{
			
		segmentalinicBronchi = new ArrayList();
	
		setImage("images/SegmentalinicBronchi.jpg");
		setImageHeight(300);
		setImageWidth(300);

		/*
		// Represents the internal bounding boxes that are in
		// each SegmentalinicBronchus
		HashMap boundingBoxesMap = null;
		

		System.out.println("SEGMENTALINIC BRONCHI - Getting BoundBoxes & Connectors!");
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
		
		System.out.println("SEGMENTALINIC BRONCHI - Setting up internal Bounding Boxes!");
		boundingBoxesMap = setupBoundBoxes(componentBoundBoxes);
			
		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SegmentalinicBronchiInfo for ParentID: " +  Constants.SegmentalinicBronchusRef + "   " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SegmentalinicBronchusRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bronchi");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = Constants.SegmentalinicBronchiRef + ":0";
	
		// Run through the collection of Bronchi and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("SegmentalinicBronchi-Bronchus NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SegmentalinicBronchus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			/*******
			// SEGMENTAL BRONCHI
			// Create and Load Constructor object
			System.out.println("In SegmentalinicBronchi - Setting up Constructor");
			bioConstruct = new BioMightConstruct(); 	
		
			System.out.println("In SegmentalinicBronchi - Load the appropriate bound box: " + bioMightTransform.getId());			
			BioMightBoundBoxes tempBioMightBoundBoxes = (BioMightBoundBoxes) boundingBoxesMap.get(bioMightTransform.getId());
			if (tempBioMightBoundBoxes != null)
				System.out.println("In SegmentalinicBronchi - Constructor Loaded with: " + bioMightTransform.getId());
			else
				System.out.println("In SegmentalinicBronchi - Constructor NOT Loaded with: " + bioMightTransform.getId());	
			bioConstruct.setBoundingBoxes(bioMightTransform.getId(), tempBioMightBoundBoxes);
			System.out.println("In SegmentalinicBronchi - Constructor Loaded with BoundingBoxes: " + bioMightTransform.getId());
			*****/
			
			// Create an instance of the SegmentalinicBronchi for each tranform specified for the organism
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG2X;
			SegmentalinicBronchus segmentalinicBronchus = new SegmentalinicBronchus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("SegmentalinicBronchus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			segmentalinicBronchi.add(segmentalinicBronchus);
			initProperty(bioMightTransform.getName(), Constants.SegmentalinicBronchus, Constants.SegmentalinicBronchusRef, bioMightTransform.getId());		
			System.out.println("Add SegmentalinicBronchis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Set up methods that will be available to the Bronchi
		initMethods();
	}
		

	
	public void initMethods() {
	
		BioMightMethodView method;
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.SegmentalinicBronchus);
		method.setMethodName("setRadius");
		method.setDisplayName("SegmentalinicBronchus Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setLength");
		method.setDisplayName("SegmentalinicBronchus Length:");
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
		for (int i=0; i<segmentalinicBronchi.size(); i++)
		{
			// Get the information for the Bronhus
			SegmentalinicBronchus segmentalinicBronchus = (SegmentalinicBronchus) segmentalinicBronchi.get(i);
			//System.out.println("Getting X3D for SegmentalinicBronchus");
			body += segmentalinicBronchus.getX3D(true);
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
		 * Setup the Default Bounding Boxes for the SegmentalinicBronchi.  
		 * The routine will return a set of bound boxes    
		 *
		 * @return
		 ********************************************************************/
		private BioMightBoundBoxes setupDefaultBoundBoxes() 
		{
			// Set up the collection to hold the Bounding Boxes
			BioMightBoundBoxes bioBoundBoxes =  new BioMightBoundBoxes();
	
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
			// LEFT SUPERIOR APICO POSTERIOR SEGMENTALINIC BRONCHUS BOUNDBOX
			// Set up the Bounding Box for the Segmentalinic Bronchi
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
			bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
			bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
			// Associate the connector on the Box
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
			// Put the Bounding Box in the collection
			bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorApicoPosteriorBronchusRef, bioBoundBox);
		
			//********************************************************************* 
			// LEFT SUPERIORANTERIOR SEGMENTALINIC BRONCHUS BOUNDBOX
			// Set up the Bounding Box for the Segmentalinic Bronchi
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
			bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
			bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
			// Associate the connector on the Box
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
			// Put the Bounding Box in the collection
			bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorAnteriorBronchusRef, bioBoundBox);
				
			
			//********************************************************************* 
			// RIGHT SUPERIOR INFERIOR LINGULAR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorInferiorLingularBronchusRef, bioBoundBox);
		
	
			//********************************************************************* 
			// LEFT SUPERIOR SUPERIOR LINGULAR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorSuperiorLingularBronchusRef, bioBoundBox);
	
			//********************************************************************* 
			// LEFT INFERIOR SUPERIOR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftInferiorSuperiorBronchusRef, bioBoundBox);
	
			
			// Left Tertiary Brounchus - 8 of them (should be 10, but two are fused) 
	
			//********************************************************************* 
			// LEFT INFERIOR ANTERIOR MEDIAL BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftInferiorAnteroMedialBasalBronchusRef, bioBoundBox);
	
			//********************************************************************* 
			// LEFT INFERIOR POSTERIOR BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftInferiorPosteriorBasalBronchusRef, bioBoundBox);
			
			//********************************************************************* 
			// LEFT INFERIOR LATERAL BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.LeftInferiorLateralBasalBronchusRef, bioBoundBox);
			 

			//********************************************************************* 
			// RIGHT SUPERIOR APICAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightSuperiorApicalBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT SUPERIOR POSTERIOR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightSuperiorPosteriorBronchusRef, bioBoundBox);

			//********************************************************************* 
			// RIGHT SUPERIOR ANTERIOR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightSuperiorAnteriorBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT MIDDLE LATERAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightMiddleLateralBronchusRef, bioBoundBox);

			
			//********************************************************************* 
			// RIGHT MIDDLE MEDIAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightMiddleMedialBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT INFERIOR SUPERIOR BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightInferiorSuperiorBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT INFERIOR MEDIAL BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightInferiorMedialBasalBronchusRef, bioBoundBox);
			 
					 
			//********************************************************************* 
			// RIGHT INFERIOR ANTERIOR BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightInferiorAnteriorBasalBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT INFERIOR LATERAL BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightInferiorLateralBasalBronchusRef, bioBoundBox);
			 
			//********************************************************************* 
			// RIGHT INFERIOR POSTERIOR BASAL BRONCHUS (SEGMENTALINIC) BOUNDBOX
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
			bioBoundBoxes.setBoundingBox(Constants.RightInferiorPosteriorBasalBronchusRef, bioBoundBox);
			 
			 
		
			// return the collection that holds both bronchi bound boxes
			return (bioBoundBoxes);
		}
	
	
		/********************************************************************
		* SETUP BOUND BOXES
		* 
		* Setup the Internal Bounding Boxes for the Segmentalinic Bronchi. This divides
		* the Segmentalinic Bronchi into its vascular,muscular,tissue components.   
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
			
			// LEFT SIDE
			// In the default instance,there will be two bound boxes
			BioMightBoundBox bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftSuperiorApicoPosteriorBronchusRef);
			System.out.println("LeftSuperiorApicoPosteriorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
		
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftSuperiorAnteriorBronchusRef);
			System.out.println("LeftSuperiorAnteriorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
				
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftSuperiorInferiorLingularBronchusRef);
			System.out.println("LeftSuperiorInferiorLingularBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftSuperiorSuperiorLingularBronchusRef);
			System.out.println("LeftSuperiorSuperiorLingularBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftInferiorSuperiorBronchusRef);
			System.out.println("LeftInferiorSuperiorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
						
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftInferiorAnteroMedialBasalBronchusRef);
			System.out.println("LeftInferiorAnteroMedialBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftInferiorPosteriorBasalBronchusRef);
			System.out.println("LeftInferiorPosteriorBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
		
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.LeftInferiorLateralBasalBronchusRef);
			System.out.println("LeftInferiorLateralBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
	
			// RIGHT SIDE
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightSuperiorApicalBronchusRef);
			System.out.println("RightSuperiorApicalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightSuperiorPosteriorBronchusRef);
			System.out.println("RightSuperiorPosteriorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightSuperiorAnteriorBronchusRef);
			System.out.println("RightSuperiorAnteriorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());		
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightMiddleLateralBronchusRef);
			System.out.println("RightMiddleLateralBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightMiddleMedialBronchusRef);
			System.out.println("RightMiddleMedialBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorSuperiorBronchusRef);
			System.out.println("RightInferiorSuperiorBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
	
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorMedialBasalBronchusRef);
			System.out.println("RightInferiorMedialBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
	
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorAnteriorBasalBronchusRef);
			System.out.println("RightInferiorAnteriorBasalBronchusRef - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
	
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorLateralBasalBronchusRef);
			System.out.println("RightInferiorLateralBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
	
			
			// In the default instance,there will be two bound boxes
			bioMightBoundBoxTemp = bioMightBoundBoxesIn.getBoundingBox(Constants.RightInferiorPosteriorBasalBronchusRef);
			System.out.println("RightInferiorPosteriorBasalBronchus - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxTemp.getXPos() + " " +
					bioMightBoundBoxTemp.getYPos() + " " +
					bioMightBoundBoxTemp.getZPos());
		}
		
	
	//********************************************************************* 
	// 01- LEFT SUPERIOR-APICO-POSTERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
	// Set up the Bounding Box for the Bronchi
	// The connector for this will come from the incoming Bound Box
	// Both are defined like and bolt and they lock into position at the
	// interestion of both connectors
	//**********************************************************************
	xPos = new BigDecimal(1.0);
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
	startPos = getStartPoints(1.0, -14.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftSuperiorApicoPosteriorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftSuperiorApicoPosteriorBronchus bioBoundBoxes into BoxesMap"); 
	
	
	//********************************************************************* 
	// 02- LEFT-SUPERIOR-ANTERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftSuperiorAnteriorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftSuperiorAnteriorBronchus bioBoundBoxes into BoxesMap"); 
	

	//**************************************************************************** 
	// 03- LEFT SUPERIOR-INFERIOR-LINGULAR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
	// Set up the Bounding Box for the Bronchi
	// The connector for this will come from the incoming Bound Box
	// Both are defined like and bolt and they lock into position at the
	// interestion of both connectors
	//***************************************************************************
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftSuperiorInferiorLingularBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftSuperiorInferiorLingularBronchus bioBoundBoxes into BoxesMap"); 

	
	//***************************************8************************************* 
	// 04- LEFT-SUPERIOR-SUPERIOR-LINGULARSEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
	// Set up the Bounding Box for the Bronchi
	// The connector for this will come from the incoming Bound Box
	// Both are defined like and bolt and they lock into position at the
	// interestion of both connectors
	//*****************************************************************************
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftSuperiorSuperiorLingularBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftSuperiorSuperiorLingularBronchus bioBoundBoxes into BoxesMap"); 

	//********************************************************************* 
	// 05- LEFT INFERIOR-SUPERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftInferiorSuperiorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftInferiorSuperiorBronchus bioBoundBoxes into BoxesMap"); 

	
	//********************************************************************* 
	// 06- LEFT INFERIOR-ANTEROMEDIAL-BASAL  SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftInferiorAnteroMedialBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftInferiorAnteroMedialBasalBronchus bioBoundBoxes into BoxesMap"); 

	//********************************************************************* 
	// 07- LEFT INFERIOR-POSTERIOR-BASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftInferiorPosteriorBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftInferiorPosteriorBasalBronchus bioBoundBoxes into BoxesMap"); 

	//********************************************************************* 
	// 08- LEFT INFERIOR-LATERAL-BASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.LeftInferiorLateralBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - LeftInferiorLateralBasalBronchusRef bioBoundBoxes into BoxesMap"); 


	//********************************************************************* 
	// 01- RIGHT SUPERIOR-APICAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-1.0, -14.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - BoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);		
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightSuperiorApicalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightSuperiorApicalBronchus bioBoundBoxes into BoxesMap"); 
	
	//********************************************************************* 
	// 02- RIGHT SUPERIOR-POSTERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.0, -15.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);		
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightSuperiorPosteriorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightSuperiorPosteriorBronchus bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 03- RIGHT SUPERIOR-ANTERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightSuperiorAnteriorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightSuperiorAnteriorBronchus bioBoundBoxes into BoxesMap"); 
	
	
	//********************************************************************* 
	// 04- RIGHT MIDDLE-LATERAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightMiddleLateralBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightMiddleLateralBronchus bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 05- RIGHT MIDDLE-MEDIAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightMiddleMedialBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightMiddleMedialBronchus bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 06- RIGHT INFERIOR-SUPERIOR SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightInferiorSuperiorBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightInferiorSuperiorBronchus bioBoundBoxes into BoxesMap"); 
	
	
	//********************************************************************* 
	// 07- RIGHT INFERIOR MEDIALBASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightInferiorMedialBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightInferiorMedialBasalBronchus bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 08- RIGHT INFERIOR ANTERIORBASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightInferiorAnteriorBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightInferiorAnteriorBasalBronchus bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 09- RIGHT INFERIOR-LATERALBASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightInferiorLateralBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightInferiorLateralBasalBronchusRef bioBoundBoxes into BoxesMap"); 
	

	//********************************************************************* 
	// 10- RIGHT INFERIOR LATERALBASAL SEGMENTALINIC BRONCHI EPITHELIUM BOUNDBOX
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
	startPos = getStartPoints(-2.5, -16.0, -3.0);
	startPoints = BioGraphics.octogonYPlane(startPos, circumference);
	bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
	bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
	
	bioBoundBox.setBioMightConnectors(bioMightConnectors);		
	
	// Put the Bounding Box into the Collection of Bounding Boxes 
	System.out.println("Adding - RightBoundBox to bioBoundBoxes"); 
	bioBoundBoxes.setBoundingBox(Constants.SegmentalinicBronchusEpitheliumRef, bioBoundBox);
	
	// Put the BioMight BoundBoxes for the Left Bronchus into the BoundingBoxMap 
	boundingBoxesMap.put(Constants.RightInferiorPosteriorBasalBronchusRef, bioBoundBoxes);
	System.out.println("Adding - RightInferiorPosteriorBasalBronchusRef bioBoundBoxes into BoxesMap"); 
	
	
	return (boundingBoxesMap);
	}


	
}
