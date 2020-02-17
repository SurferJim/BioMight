/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.text;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSymbolsBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of BioArrows
 ********************************************************************************/

public class BioArrows extends BioMightBase {
private ArrayList bioArrows;
private BioMightPosition bioMightPosition;
	
	/********************************************************************************************************************
	 *  BIOTEXTS
	 * 
	 * This method will instantiate the BioArrows that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BioArrows()
	{		
		// Create the Base BioArrows
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.BioArrowsRef, null, null);
	}
	
	public BioArrows(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		
	
	public BioArrows(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
		
	public BioArrows(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		this.setImage("images/BioArrows.jpg");
		
		bioArrows = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING BioArrows Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of BioArrows
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BioArrows Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BioArrowRef, parentID);
			System.out.println("Have BioArrows Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BioArrows");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of bioArrows and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have bioArrows NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the bioArrow we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating BioArrow: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a BioArrow for each tranform specified
			int LOD = Constants.VIEW_INTERNAL;
			BioArrow bioArrow = new BioArrow(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("BioArrow Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioArrows.add(bioArrow);
			System.out.println("Add BioArrow to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Property
			initProperty(bioMightTransform.getName(), Constants.BioArrow, Constants.BioArrowRef, bioMightTransform.getId());				
		}

		// Set up methods that will be available to the bioArrows
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioArrows);
		method.setMethodName("setColonySize");
		method.setDisplayName("Number Texts:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
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
		
		// Assemble the BioArrows
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
		"title='BioArrows'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling BioArrows - size: " + bioArrows.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting X3D for BioArrow: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BioArrowX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BioArrowY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BioArrowZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='BioArrowTrans" + bioMightTransform.getId() + "'\n";
					

				// Use the positions from the database
			 	body += "translation='" 
			 		+ bioMightTransform.getTranslation().getXPos() + " " 
 					+ bioMightTransform.getTranslation().getYPos() + " "
 					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
							 					
				body +=  "scale='" 	
					+ bioMightTransform.getScale().getXPos() + " "
				 	+ bioMightTransform.getScale().getYPos() + " "
				 	+ bioMightTransform.getScale().getZPos() + "'>\n";
				 
				 body +="\n<Transform DEF='BioArrowTrans" + bioMightTransform.getId() + "'\n" +
							 "translation='-2.03983 -2.03661 .29996'\n" +
							 "rotation='1 0 0 3.142'>\n\n" +
				 
							 "<Shape DEF='Cone1'\n" +
							  "containerField='children'>\n" +
							  "<Appearance\n" +
							   "containerField='appearance'>\n" +
							   "<Material DEF='Red'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='0.200'\n" +
							    "shininess='0.200'\n" +
							    "diffuseColor='1 0 0'/>\n" +
							  "</Appearance>\n" +
							  "<Cone DEF='GeoCone1'\n" +
							   "containerField='geometry'\n" +
							   "height='2.000'\n" +
							   "bottomRadius='1.000'/>\n" +
							 "</Shape>\n" +
							 
							"</Transform>\n" +
							"<Transform DEF='dad_Cylinder1'\n" +
							 "translation='-2.01336 -.04576 .32031'>\n" +
							 "<Shape DEF='Cylinder1'\n" +
							  "containerField='children'>\n" +
							  "<Appearance\n" +
							   "containerField='appearance'>\n" +
							   "<Material\n" +
							    "containerField='material'\n" +
							    "USE='Red'/>\n" +
							  "</Appearance>\n" +
							  "<Cylinder DEF='GeoCylinder1'\n" +
							   "containerField='geometry'\n" +
							   "height='2.000'\n" +
							   "radius='0.500'/>\n" +
							 "</Shape>\n" +
							"</Transform>\n" +

					
					"\n<TouchSensor DEF='"+bioMightTransform.getId()+"'\n" +
	                   " description='BioArrow'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n\n";
						
				System.out.println("Set Transform: ");				

			}
		}			
		else
		{
			// Don't feel this section will be needed. We can assemble the
			// text at this level of introspection :-)
			// If we are not rendiring at the Text Level, go deeper
			// Run through the collection of BioArrows and 
			// assemble the X3D from the children
			for (int i=0; i<bioArrows.size(); i++)
			{
				// Get the information for the bioArrow
				BioArrow bioArrow = (BioArrow) bioArrows.get(i);
				System.out.println("Getting X3D for BioArrow: " + bioArrow.getComponentID());
				body += bioArrow.getX3D(true);
			}		
		
		}
		
		
		//System.out.println("BioArrows X3D: " + body);		
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
		System.out.println("BioArrows-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BioArrows: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.BioArrows)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals(Constants.BIO_INT)) {
						
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
					else if (dataType.equals(Constants.BIO_DOUBLE)) {
					
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
				System.out.println("BioArrows - Methods have fired.   Calling BioArrows Save method!");
			}
		}
	}

	
	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the BioArrows.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BioArrows-SetColonySize: " + size);
		
		// Generate the BioArrow		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BioArrow Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightSymbolsBeanLocal bioMightBean = (BioMightSymbolsBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightSymbolsBeanLocal");
	   		 					
			double currentPoints[][] = null;
			System.out.println("CallingGenerateBioArrows!!!");
			int success = bioMightBean.generateBioArrows(size, "BioArrow:00001", "BioArrow", 
				"BioArrow", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created BioArrow Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - BioArrow");
			throw new ServerException("Remote Exception BioArrowEpithelium():", e); 	
		}
	}
	
}
