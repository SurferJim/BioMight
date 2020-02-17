/*
 * Created on Oct 25, 2006
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
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/************************************************************************************
 * @author SurferJim
 *
 * Representation of a BioArrow.  It is composed of proteins.
 * 
 ************************************************************************************/

public class BioArrow extends BioMightBase {	
	private BioMightPosition bioMightPosition;
	
		
	/************************************************************************
	 * BioArrow Constructor 
	 *
	 ***********************************************************************/
	public BioArrow()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BioArrowRef, null, null);
	}

	/************************************************************************
	 * BioArrow Constructor 
	 *
	 ***********************************************************************/
	public BioArrow(String parentID)
	{
		System.out.print("Calling parameterized BioArrow Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * BioArrow Constructor 
	 *
	 ***********************************************************************/
	public BioArrow(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling BioArrow with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	
	/************************************************************************
	 * Create BioArrow
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/BioArrow.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;

			if (bioMightMethods != null){
				System.out.println("EXECUTING BioArrow Methods: " + bioMightMethods.size());
				executeMethods(bioMightMethods);
			}
			
			
			if (lod == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In BioArrow Create() - Already Set: " + parentID);				
			}	
			else if (lod == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a BioArrow directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye BioArrowInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have BioArrow Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - BioArrow");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of BioArrows and build them into the model
				// In the default case, we get one instance of the BioArrow for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("BioArrow NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the BioArrow
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating BioArrow: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
					// initialize the Properties
					initProperty(bioMightTransform.getName(), Constants.BioArrow, Constants.BioArrowRef, bioMightTransform.getId());

				}
			}
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateBioArrow Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
		}
		

	
		private void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("BioArrow");
			property.setCanonicalName(Constants.BioArrow);
			properties.add(property);
		}
		
		
		/****************************************************
		 * GENERATE BIOTEXT
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the BioArrow		
			//BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the BioArrow : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
				double circumference = 0.125;
				
				if (componentID.equals("BioArrow:01")) {
					
					// Generate the Palm
					double[] startPos = {3.75,-23.0,-6.0};
					
					// Create a equilateral octogon
		    		double x =  startPos[0];
		    		double y =  startPos[1];
		    		double z =  startPos[2];
		
		    		double[][] currentPoints = { 
			   				 {x, y, z},
			     				 {x, y-circumference,     z-circumference},
			     				 {x, y-(circumference*2), z-circumference},
			     				 {x, y-(circumference*3), z},
			     				 {x, y-(circumference*3), z+(circumference)},
			     				 {x, y-(circumference*2), z+(circumference*2)},
			     				 {x, y-circumference,     z+(circumference*2)},
			     				 {x, y, z+circumference}
			      		};

						
					//int success = bioMightBean.generateBioArrow("BioArrow:00001", "BioArrow", 
					//		"BioArrow", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("BioArrow:02"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75,-23.0,-6.0};
					
					// Create a equilateral octogon
		    		double x =  startPos[0];
		    		double y =  startPos[1];
		    		double z =  startPos[2];
		    		 
		    		
					double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};

					
					
					//int success = bioMightBean.generateBioArrow("BioArrow:00160", "BioArrow", 
					//	"BioArrow", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate BioArrow NoParent");		
				}

				
				System.out.println("Created BioArrow Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - BioArrow");
				throw new ServerException("Remote Exception BioArrow():", e); 	
			}
		}
		
		
		/*********************************************************************
		 * INIT METHODS
		 * 
		 * 
		 ********************************************************************/
		public void initMethods() {
				
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioArrow);
			method.setMethodName("setText");
			method.setDisplayName("Text:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_TEXT);
			methods.add(method);

			method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioArrow);
			method.setMethodName("setFont");
			method.setDisplayName("Font:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_TEXT);
			methods.add(method);
			
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioArrows);
			method.setMethodName("setSize");
			method.setDisplayName("Size:");
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
			
			// Assembe the BioArrow
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='BioArrow.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='BioArrow'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (lod == Constants.VIEW_HAWKEYE) 
			{			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating BioArrow: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating BioArrow at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					

					//System.out.println("Getting X3D for BioArrowX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for BioArrowY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for BioArrowZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='BioArrow'\n";
					
					
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.10000:0"))
					{
						body += "translation='" 
							+ bioMightPosition.getXPos() + " " 
				 			+ bioMightPosition.getYPos() + " "
				 			+ bioMightPosition.getZPos() + "'\n";
					}
					else
					{
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					}
					 					
					body +=  "scale='" 	
						+ bioMightTransform.getScale().getXPos() + " "
					 	+ bioMightTransform.getScale().getYPos() + " "
					 	+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	
					
					 "\n<Transform DEF='BioArrowTrans" + bioMightTransform.getId() + "'\n" +
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
					
					
					
							}
			}
			else
			{
				body = "";					
			}
			
			
			//System.out.println("BioArrow X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

		
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("BioArrow-Executing Methods: " + bioMightMethods.size());
			for (int j=0; j<bioMightMethods.size(); j++){
				
				// Get the parameter from the list and if it is not
				// empty execute the associated method using it
				BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
				System.out.println("Have BioMightMethod for BioArrow: " + bioMightMethod.getMethodName() + "   " + bioMightMethod.getCanonicalName());	
				String methodName = bioMightMethod.getMethodName();
				String canonicalName = bioMightMethod.getCanonicalName(); 
				String dataType = bioMightMethod.getDataType();
				String methodParam = bioMightMethod.getMethodParameter(); 
				if (methodParam == null)
					methodParam = "";
				
				// We only execute those methods that are targeted for the IRIS
				// If a parameter is specified then we fire the method, otherwise
				// we just jump over it
				if (canonicalName.equals(Constants.BioArrow)) {				
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
						else if (dataType.equals(Constants.BIO_TEXT)) {
							
							
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

	

}
