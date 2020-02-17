/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.cocci.grampositive;
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
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of StaphylococciEpidermidis
 ********************************************************************************/

public class StaphylococciEpidermidis extends BioMightBase {
private ArrayList staphylococciEpidermidis;

	
	/********************************************************************************************************************
	 *  StaphylococciEpidermidis
	 * 
	 * This method will instantiate the StaphylococciEpidermidis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public StaphylococciEpidermidis()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  StaphylococciEpidermidis
	 * 
	 * This method will instantiate the StaphylococciEpidermidis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public StaphylococciEpidermidis(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public StaphylococciEpidermidis(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE StaphylococciEpidermidis
	 * 
	 * This method will instantiate the StaphylococciEpidermidis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/StaphylococciEpidermidis.jpg");
		
		staphylococciEpidermidis = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="StaphylococciEpidermidis.x3d";

		if (bioMightMethods != null){
			System.out.println("EXECUTING StaphylococciEpidermidis Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of StaphylococciEpidermidis
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting StaphylococciEpidermidis Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.StaphylococcusEpidermidisRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - StaphylococciEpidermidis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of staphylococciEpidermidis and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have StaphylococciEpidermidis NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the staphylococciEpidermidis we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating StaphylococciEpidermidis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a StaphylococciEpidermidis for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			StaphylococcusEpidermidis staphylococcusEpidermidis = new StaphylococcusEpidermidis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("StaphylococciEpidermidis Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			staphylococciEpidermidis.add(staphylococcusEpidermidis);
			System.out.println("Added staphylococcusEpidermidis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			String propDesc =  Constants.StaphylococciEpidermidisRef + "-GramPositive, Coccal, CoagulaseNegative "; 
			initProperty(bioMightTransform.getName(), Constants.StaphylococcusEpidermidis, Constants.StaphylococcusEpidermidisRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the staphylococciEpidermidis
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of StaphylococciEpidermidisMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.StaphylococciEpidermidis);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing StaphylococciEpidermidisMethods: " + bioMightMethodsIn.size());
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
		
		// Assemble the StaphylococciEpidermidis
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
		"title='StaphylococciEpidermidis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for StaphylococciEpidermidis HawkEyeView - size: " + staphylococciEpidermidis.size());
			
			// Run through the collection of StaphylococciEpidermidis and assemble the X3D for each
			for (int i=0; i<staphylococciEpidermidis.size(); i++)
			{
				// Get the information for the staphylococciEpidermidis
				//StaphylococciEpidermidis staphylococciEpidermidis = (StaphylococciEpidermidis) staphylococciEpidermidis.get(i);
				//System.out.println("Getting X3D for StaphylococciEpidermidis: " + staphylococciEpidermidis.getComponentID());
				//body += staphylococciEpidermidis.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for StaphylococciEpidermidis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for StaphylococciEpidermidisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for StaphylococciEpidermidisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for StaphylococciEpidermidisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
						
				double xPos = bioMightTransform.getTranslation().getXPos();  
				double yPos = bioMightTransform.getTranslation().getYPos();
				double zPos = bioMightTransform.getTranslation().getZPos();	
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
				
				
				int eRing = 0;
				double ringSize = radius * 1.25;
				ArrayList ringData = new ArrayList();	
		
				double[][] offSets0 = new double[7][3];
				
				offSets0[0][0] = ringSize;
				offSets0[0][1] = ringSize;
				offSets0[0][2] = 0;
						
				offSets0[1][0] = -ringSize;
				offSets0[1][1] = ringSize;
				offSets0[1][2] = 0;

				offSets0[2][0] = -ringSize;
				offSets0[2][1] = -ringSize;
				offSets0[2][2] = 0;
				
				offSets0[3][0] = ringSize;
				offSets0[3][1] = -ringSize;
				offSets0[3][2] = 0;
				
				offSets0[4][0] = 0;
				offSets0[4][1] = 0;
				offSets0[4][2] = ringSize;
				
				offSets0[5][0] = 0;
				offSets0[5][1] = 0;
				offSets0[5][2] = -ringSize;
				
				offSets0[6][0] = 0;
				offSets0[6][1] = 0;
				offSets0[6][2] = 0;
						
				ringData.add(0, offSets0);

				
				eRing = 1;
			    ringSize = radius * 2.5;
				double[][] offSets1 = new double[4][3];
				
				offSets1[0][0] = .707 * ringSize;
				offSets1[0][1] = 0;
				offSets1[0][2] = .707 * ringSize;
						
				offSets1[1][0] = -.707 * ringSize;
				offSets1[1][1] = 0;
				offSets1[1][2] = .707 * ringSize;		
						
				offSets1[2][0] = .707 * ringSize;
				offSets1[2][1] = 0;
				offSets1[2][2] = -.707 * ringSize;
				
				offSets1[3][0] = -.707 * ringSize;
				offSets1[3][1] = 0;
				offSets1[3][2] = -.707 * ringSize;
					
			
				ringData.add(1, offSets1);
				
				
				
				/*

				
				eRing = 2;
				ringSize = radius +  (2*radius * eRing);
				double[][] offSets2 = new double[18][3];
				
				offSets2[0][0] = 0;
				offSets2[0][1] = ringSize;
				offSets2[0][2] = ringSize;
				
				offSets2[1][0] = 0;
				offSets2[1][1] = ringSize;
				offSets2[1][2] = -ringSize;		
				
				offSets2[2][0] = 0;
				offSets2[2][1] = -ringSize;
				offSets2[2][2] = -ringSize;
				
				offSets2[3][0] = 0;
				offSets2[3][1] = -ringSize;
				offSets2[3][2] = ringSize;
				
				// y flat
				offSets2[4][0] = ringSize;
				offSets2[4][1] = 0;
				offSets2[4][2] = -ringSize;
				
				offSets2[5][0] = ringSize;
				offSets2[5][1] = 0;
				offSets2[5][2] = ringSize;
				
				offSets2[6][0] = -ringSize;
				offSets2[6][1] = 0;
				offSets2[6][2] = ringSize;
				
				offSets2[7][0] = -ringSize;
				offSets2[7][1] = 0;
				offSets2[7][2] = -ringSize;
				
				
				// Z Flat
				offSets2[8][0] = ringSize;
				offSets2[8][1] = 0;
				offSets2[8][2] = 0;
				
				offSets2[9][0] = 0;
				offSets2[9][1] = ringSize;
				offSets2[9][2] = 0;
				
				offSets2[10][0] = -ringSize;
				offSets2[10][1] = -ringSize;
				offSets2[10][2] = 0;
				
				offSets2[11][0] = -ringSize;
				offSets2[11][1] =  ringSize;
				offSets2[11][2] = 0;
				
				offSets2[12][0] = ringSize;
				offSets2[12][1] = ringSize;
				offSets2[12][2] = 0;
				
				offSets2[13][0] = ringSize;
				offSets2[13][1] = ringSize;
				offSets2[13][2] = 0;
				
				// Z-Y
				offSets2[14][0] = -ringSize * .707;
				offSets2[14][1] = 0;
				offSets2[14][2] = ringSize * .707;
				
				offSets2[15][0] = -ringSize;
				offSets2[15][1] = 0;
				offSets2[15][2] = -ringSize;
			
				offSets2[16][0] = -ringSize;
				offSets2[16][1] = 0;
				offSets2[16][2] = ringSize;
				
				offSets2[17][0] = -ringSize;
				offSets2[17][1] = 0;
				offSets2[17][2] = -ringSize;
				ringData.add(2, offSets2);

				*/
				
				
				body += BioWebX3DUtils.addCocci(bioMightTransform, ringData);

			
				
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for StaphylococciEpidermidis InternalView - size: " + staphylococciEpidermidis.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for StaphylococciEpidermidis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for StaphylococciEpidermidisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for StaphylococciEpidermidisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for StaphylococciEpidermidisZ: " + bioMightTransform.getTranslation().getZPos());
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
				    " url='../images/StaphylococciEpidermidis.png'/>";
				
				
				    
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
				 	"<Sphere DEF='StaphylococciEpidermidisGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='StreptococusPyogenes'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("StaphylococciEpidermidis X3D: " + body);		
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
		System.out.println("StaphylococciEpidermidis-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for StaphylococciEpidermidis: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.StaphylococciEpidermidis)) {				
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
				System.out.println("StaphylococciEpidermidis - Methods have fired.   Calling StaphylococciEpidermidis Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the StaphylococciEpidermidis.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("StaphylococciEpidermidis-SetColony Size: " + size);
		
		// Generate the StaphylococciEpidermidis		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the StaphylococciEpidermidis Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateStaphylococciEpidermidis(size, "StaphylococciEpidermidis:00001", "StaphylococciEpidermidis", 
		//		"StaphylococciEpidermidis", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created StaphylococciEpidermidis Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - StaphylococciEpidermidis");
			throw new ServerException("Remote Exception StaphylococciEpidermidisEpithelium():", e); 	
		}
	}
	
}
