/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.misc;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

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
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of AcinetobacterBaumanniis
 ********************************************************************************/

public class AcinetobacterBaumanniis extends BioMightBase {
	private ArrayList acinetobacterBaumanniis;
	private int collectionSize = 0;
	
	
	/********************************************************************************************************************
	 *  AcinetobacterBaumanniis
	 * 
	 * This method will instantiate the AcinetobacterBaumanniis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public AcinetobacterBaumanniis()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  AcinetobacterBaumanniis
	 * 
	 * This method will instantiate the AcinetobacterBaumanniis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public AcinetobacterBaumanniis(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public AcinetobacterBaumanniis(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE AcinetobacterBaumanniis
	 * 
	 * This method will instantiate the AcinetobacterBaumanniis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/AcinetobacterBaumanniis.jpg");
		
		acinetobacterBaumanniis = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING AcinetobacterBaumanniis Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of AcinetobacterBaumanniis
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AcinetobacterBaumanniis Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AcinetobacterBaumanniiRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AcinetobacterBaumanniis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of AcinetobacterBaumannii and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have AcinetobacterBaumanniis NumTransforms: " + transforms.size());
		
		// If we are culling the data set		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the acinetobacterBaumannii we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating AcinetobacterBaumanniis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a AcinetobacterBaumanniis for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			AcinetobacterBaumannii acinetobacterBaumannii = new AcinetobacterBaumannii(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("AcinetobacterBaumanniis Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			acinetobacterBaumanniis.add(acinetobacterBaumannii);
			System.out.println("Added acinetobacterBaumannii to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.AcinetobacterBaumannii, Constants.AcinetobacterBaumanniiRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.AcinetobacterBaumanniis, Constants.AcinetobacterBaumanniisRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the acinetobacterBaumanniis
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of AcinetobacterBaumanniisMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.AcinetobacterBaumanniis);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing AcinetobacterBaumanniis Methods: " + bioMightMethodsIn.size());
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
		
		// Assemble the AcinetobacterBaumanniis
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
		"title='AcinetobacterBaumanniis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for AcinetobacterBaumanniis HawkEyeView - size: " + acinetobacterBaumanniis.size());
			
			// Run through the collection of AcinetobacterBaumanniis and assemble the X3D for each
			for (int i=0; i<acinetobacterBaumanniis.size(); i++)
			{
				// Get the information for the acinetobacterBaumanniis
				//AcinetobacterBaumanniis acinetobacterBaumanniis = (AcinetobacterBaumanniis) acinetobacterBaumanniis.get(i);
				//System.out.println("Getting X3D for AcinetobacterBaumanniis: " + acinetobacterBaumanniis.getComponentID());
				//body += acinetobacterBaumanniis.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for AcinetobacterBaumanniis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for AcinetobacterBaumanniisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for AcinetobacterBaumanniisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for AcinetobacterBaumanniisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				
				body += BioWebX3DUtils.generateRods(collectionSize, bioMightTransform,  new double[] {bioMightTransform.getTranslation().getXPos(), 
						bioMightTransform.getTranslation().getYPos(), bioMightTransform.getTranslation().getZPos()});

				//body += BioWebX3DUtils.generateDome(bioMightTransform,  new double[] {bioMightTransform.getTranslation().getXPos()+3, 
				//		bioMightTransform.getTranslation().getYPos(), bioMightTransform.getTranslation().getZPos()}, true);
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for AcinetobacterBaumanniis InternalView - size: " + acinetobacterBaumanniis.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for AcinetobacterBaumanniis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for AcinetobacterBaumanniisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for AcinetobacterBaumanniisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for AcinetobacterBaumanniisZ: " + bioMightTransform.getTranslation().getZPos());
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
				    " url='../images/AcinetobacterBaumanniis.jpg'/>";
				
				
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity=Pa'" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='AcinetobacterBaumanniisGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<PlaneSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='StreptococusPyogenes'\n" +
		               "</PlaneSensor> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("AcinetobacterBaumanniis X3D: " + body);		
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
		System.out.println("AcinetobacterBaumanniis-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for AcinetobacterBaumanniis: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.AcinetobacterBaumanniis)) {				
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
				System.out.println("AcinetobacterBaumanniis - Methods have fired.   Calling AcinetobacterBaumanniis Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the AcinetobacterBaumanniis.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("AcinetobacterBaumanniis-SetColony Size: " + size);
		collectionSize = size;
		
		// Generate the AcinetobacterBaumanniis		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AcinetobacterBaumanniis Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateAcinetobacterBaumanniis(size, "AcinetobacterBaumanniis:00001", "AcinetobacterBaumanniis", 
		//		"AcinetobacterBaumanniis", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created AcinetobacterBaumanniis Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - AcinetobacterBaumanniis");
			throw new ServerException("Remote Exception AcinetobacterBaumanniisEpithelium():", e); 	
		}
	}
	
	
}
