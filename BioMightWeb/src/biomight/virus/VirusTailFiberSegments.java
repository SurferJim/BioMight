/****************************************************************************************
 * Created on Sep 26, 2006
 *
 * Represents a collection of AdenoViruses
 * 
 * 
 ****************************************************************************************/


package biomight.virus;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of VirusTailFiberSegments
 ********************************************************************************/

public class VirusTailFiberSegments extends BioMightBase {
private ArrayList virusTailFiberSegments;

	
	/********************************************************************************************************************
	 *  VirusTailFiberSegments
	 * 
	 * This method will instantiate the VirusTailFiberSegments that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public VirusTailFiberSegments()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  VirusTailFiberSegments
	 * 
	 * This method will instantiate the VirusTailFiberSegments that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public VirusTailFiberSegments(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public VirusTailFiberSegments(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/********************************************************************************************************************
	 * CREATE VirusTailFiberSegments
	 * 
	 * This method will instantiate a set of VirusTailFiberSegments that make up a VirusTailFiber.  There are a numerous
	 * TailFibers and each Fiber is comprised of segmented pieces that form the basepod legs.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/VirusTailFiberSegments.jpg");
		
		virusTailFiberSegments = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;

		this.properties = bioMightProperties;
		
		double rotationAngle = 60;
		BioMightOrientation bioMightOrientation = getPropertyOrientation(parentID);
		if (bioMightOrientation != null) {
			rotationAngle = bioMightOrientation.getDegrees();
			System.out.println("Setting Rotation Angle to: " + rotationAngle);
		}
		
		// Generate the Component if needed 
		boolean bGenerate = false;
		if (bGenerate) {
			System.out.println("Generating VirusTailFiberSegments!!!");
			generate(rotationAngle, parentID, componentID);
		}
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING VirusTailFiberSegments Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of VirusTailFiberSegments
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting VirusTailFiberSegments Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.VirusTailFiberSegmentRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - VirusTailFiberSegments");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of virusTailFiberSegments and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have VirusTailFiberSegments NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="AdenoViruses.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the virusTailFiber we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating VirusTailFiberSegment: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a VirusTailFiberSegment for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			VirusTailFiberSegment virusTailFiberSegment = new VirusTailFiberSegment(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			//System.out.println("VirusTailFiberSegment Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			virusTailFiberSegments.add(virusTailFiberSegment);
			System.out.println("Added VirusTailFiberSegment to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			initProperty(bioMightTransform.getName(), Constants.VirusTailFiberSegment, Constants.VirusTailFiberSegmentRef, bioMightTransform.getId());				
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the virusTailFiberSegments
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of VirusTailFiberSegmentsMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.VirusTailFiberSegments);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing VirusTailFiberSegmentsMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}

	
	
	/***************************************************************************************
	 * GENERATE 
	 * 
	 * Will create Tail Fiber Segment records in the database.   It will create
	 * a group from here.  
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************************/
	
	public void generate(double rotationAngle, String parentID, String componentID)
	{
		// Generate the Virus Tail Fibers		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the VirusTailFiberSegments: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			//int numSegments = 5;
			double circumference = 0.0040;
			
			
			// Create 5 sections
			double[] startPos = {0.005, -0.4725, 0.0};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			
			System.out.println("Calling Generate VirusTailFiberSegments: " + componentID + "    " + parentID);

			System.out.println("Calling Generate VirusTailFiberSegments: " + componentID + "    " + parentID);
			int success = bioMightBean.generateVirusTailFiberSegment(rotationAngle, "VirusTailFiberSegment", 
				"VirusTailFiberSegment", componentID, parentID, currentPoints);				
	
			System.out.println("Created VirusTailFiberSegmentInfo using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - VirusTailFiberSegment");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the VirusTailFibers.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the VirusTailFiberSegments
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='VirusTailFiberSegments'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 

			
		// Grab the data from the collection that we just created.
		
		if (viewPerspective == Constants.VIEW_DETACHED)
		{
			//System.out.println("Assembling X3D-VirusTailFiberSegments ViewDETACHED - size: " + virusTailFiberSegments.size());
			
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting X3D -InternalView - for VirusTailFiberSegment: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for VirusTailFiberSegmentX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for VirusTailFiberSegmentY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for VirusTailFiberSegmentZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";
				}

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'\n";
				 		
				 				
				body +=  "rotation='" + bioMightTransform.getOrientation().getXAxis() + " "
							+ bioMightTransform.getOrientation().getYAxis()  + " "
							+ bioMightTransform.getOrientation().getZAxis()  + " "
							+ bioMightTransform.getOrientation().getDegrees() + "'>\n\n";
					
				
			 				
				body +=  "<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						" containerField='children'>\n" +
						" <Appearance\n" +
						"  containerField='appearance'>\n";
			
			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/VirusTailFiberSegment.jpg'/>";
				
				
				    
				 body+= " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='VirusTailFiberSegmentIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='VirusTailFiberSegment_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
			    "</Shape>\n" +

	
				 "</Transform>\n";
								
			}

			
		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			//System.out.println("Assembling X3D for VirusTailFiberSegments InternalView - size: " + virusTailFiberSegments.size());
			//if (Constants.VIEW_INTERNAL)
			
			lod = Constants.MAG1X;
			if (lod == Constants.MAG2X) {
				// Run through the collection of VirusTailFiberSegments and assemble the X3D for each
				for (int i=0; i<virusTailFiberSegments.size(); i++)
				{
					// Force the level to grab the individual elements
					// Get the information for the virusTailFiber
					VirusTailFiberSegment virusTailFiberSegment = (VirusTailFiberSegment) virusTailFiberSegments.get(i);
					System.out.println("Getting X3D for HACKY SAKIE  VirusTailFiberSegment: " + virusTailFiberSegment.getComponentID());
					body += virusTailFiberSegment.getX3D(true);
				}
			}
			else if (lod == Constants.MAG1X) {
				
			
				
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Getting X3D -InternalView - for VirusTailFiberSegment: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				
	
					//System.out.println("Getting X3D for VirusTailFiberSegmentX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for VirusTailFiberSegmentY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for VirusTailFiberSegmentZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
						
						
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.10000:0"))
					{
						//body += "translation='" 
						//	+ bioMightPosition.getXPos() + " " 
				 		//	+ bioMightPosition.getYPos() + " "
				 		//	+ bioMightPosition.getZPos() + "'\n";
					}
					else
					{
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					}
	
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'\n";
	
	
					body +=  "rotation='" + bioMightTransform.getOrientation().getXAxis() + " "
							+ bioMightTransform.getOrientation().getYAxis()  + " "
							+ bioMightTransform.getOrientation().getZAxis()  + " "
							+ bioMightTransform.getOrientation().getDegrees() + "'>\n\n" ;
		
					 				
					body +=  "<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							" containerField='children'>\n" +
							" <Appearance\n" +
							"  containerField='appearance'>\n";
	
				
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/VirusTailFiberSegment.jpg'/>";
					
					
					    
					 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
							 	"<IndexedFaceSet DEF='VirusTailFiberSegmentIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='VirusTailFiberSegment_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
							    "</Shape>\n" +

		
					 "</Transform>\n";
									
				}
			}			

		
		}
		//System.out.println("VirusTailFiberSegments X3D: " + body);		
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
		System.out.println("VirusTailFiberSegments-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for VirusTailFiberSegments: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.VirusTailFiberSegments)) {				
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
							System.out.println("After Execute Method(Integer)" + methodName);	
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
								System.out.println("After Execute Method(Double)" + methodName);
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
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("VirusTailFiberSegments - Methods have fired.   Calling VirusTailFiberSegments Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the VirusTailFiberSegments.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("VirusTailFiberSegments-SetColony Size: " + size);
		
		// Generate the VirusTailFiberSegment		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the VirusTailFiberSegment Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateVirusTailFiberSegments(size, "VirusTailFiberSegment:00001", "VirusTailFiberSegment", 
		//		"VirusTailFiberSegment", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created VirusTailFiberSegment Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - VirusTailFiberSegment");
			throw new ServerException("Remote Exception VirusTailFiberSegmentEpithelium():", e); 	
		}
	}
	
}
