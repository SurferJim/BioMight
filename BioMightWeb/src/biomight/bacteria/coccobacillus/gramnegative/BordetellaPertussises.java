/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.coccobacillus.gramnegative;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of BordetellaPertussises
 ********************************************************************************/

public class BordetellaPertussises extends BioMightBase {
private ArrayList bordetellaPertussises;

	
	/********************************************************************************************************************
	 *  BordetellaPertussises
	 * 
	 * This method will instantiate the BordetellaPertussises that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BordetellaPertussises()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  BordetellaPertussises
	 * 
	 * This method will instantiate the BordetellaPertussises that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BordetellaPertussises(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public BordetellaPertussises(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE BordetellaPertussises
	 * 
	 * This method will instantiate the BordetellaPertussises that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/BordetellaPertussises.jpg");
		
		bordetellaPertussises = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="BacilliAnthracis.x3d";

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING BordetellaPertussises Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of BordetellaPertussises
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BordetellaPertussises Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BordetellaPertussisRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BordetellaPertussises");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of bordetellaPertussises and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BordetellaPertussises NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the bordetellaPertussises we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating BordetellaPertussises: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a BordetellaPertussises for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			BordetellaPertussis bordetellaPertussis = new BordetellaPertussis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("BordetellaPertussises Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bordetellaPertussises.add(bordetellaPertussis);
			System.out.println("Added bordetellaPertussis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			String propDesc =   Constants.BordetellaPertussisesRef + "-GramNegative, aerobic coccobacillus capsulate";	
			initProperty(bioMightTransform.getName(), Constants.BordetellaPertussis, Constants.BordetellaPertussisRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);	
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the bordetellaPertussises
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of BordetellaPertussisesMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.BordetellaPertussises);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing BordetellaPertussisesMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the BordetellaPertussises
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
		"title='BordetellaPertussises'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for BordetellaPertussises HawkEyeView - size: " + bordetellaPertussises.size());
			
			// Run through the collection of BordetellaPertussises and assemble the X3D for each
			for (int i=0; i<bordetellaPertussises.size(); i++)
			{
				// Get the information for the bordetellaPertussises
				//BordetellaPertussises bordetellaPertussises = (BordetellaPertussises) bordetellaPertussises.get(i);
				//System.out.println("Getting X3D for BordetellaPertussises: " + bordetellaPertussises.getComponentID());
				//body += bordetellaPertussises.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for BordetellaPertussises: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BordetellaPertussisesX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BordetellaPertussisesY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BordetellaPertussisesZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				

				double rodOrient[][] = {
					{0.0, 0.0, 1.0,  1.57},
					{0.0, 0.0, 1.0,  1.50},
					{0.0, 0.0, 1.0,  -1.50},
					{0.0, 0.0, 1.0,  1.40},
				};
				 
			
				double xPos = bioMightTransform.getTranslation().getXPos();  
				double yPos = bioMightTransform.getTranslation().getYPos();
				double zPos = bioMightTransform.getTranslation().getZPos();	
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
				
				for (int k=0; k<8; k++) {
						
								
					//*************************************
					// Create the Body out of Cylinder
					//*************************************
					body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
						
					// Let's compute 
						
				 	body += "translation='" 
						+ xPos + " " 
	 					+ yPos + " "
	 					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					

				//	body +=  "rotation='" 
				//			+ rodOrient[k][0] + " "
				//			+ rodOrient[k][1] + " "
				//			+ rodOrient[k][2]  + " "
				//			+ rodOrient[k][3] + "'>\n\n";
		
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
			
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BordetellaPertussises.png'/>";  
					
					
					    
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='BordetellaPertussisesGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + (bioMightTransform.getRadius()) +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
		                   " description='BordetellaPertussises'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
									
					
				
					xPos = xPos + (radius*1.5);
					yPos = yPos +  radius*2.125; // (radius*.5) +
				}
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for BordetellaPertussises InternalView - size: " + bordetellaPertussises.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for BordetellaPertussises: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BordetellaPertussisesX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BordetellaPertussisesY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BordetellaPertussisesZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					

		 		body += "translation='" 
		 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
		

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
			
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BordetellaPertussises.png'/>";  
				
				
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='BordetellaPertussisesGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='StreptococusPyogenes'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("BordetellaPertussises X3D: " + body);		
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
		System.out.println("BordetellaPertussises-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BordetellaPertussises: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.BordetellaPertussises)) {				
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
				System.out.println("BordetellaPertussises - Methods have fired.   Calling BordetellaPertussises Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the BordetellaPertussises.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BordetellaPertussises-SetColony Size: " + size);
		
		// Generate the BordetellaPertussises		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BordetellaPertussises Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateBordetellaPertussises(size, "BordetellaPertussises:00001", "BordetellaPertussises", 
		//		"BordetellaPertussises", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created BordetellaPertussises Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - BordetellaPertussises");
			throw new ServerException("Remote Exception BordetellaPertussisesEpithelium():", e); 	
		}
	}
	
}
