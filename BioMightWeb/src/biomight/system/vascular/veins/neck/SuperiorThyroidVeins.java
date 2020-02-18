/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.neck;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.arm.Arm;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/******************************************************************
 * @author SurferJim
 *
 * Representation of the SuperiorThyroidVeins
 * 
 *****************************************************************/

public class SuperiorThyroidVeins extends BioMightBase {
private ArrayList superiorThyroidVeins;
		
	
	/********************************************************************************************************************
	 *  SuperiorThyroidVeins
	 * 
	 * This method will instantiate the SuperiorThyroidVeins that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public SuperiorThyroidVeins()
	{		
		create(Constants.BodyRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  SuperiorThyroidVeins
	 * 
	 * This method will instantiate the SuperiorThyroidVeins that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public SuperiorThyroidVeins(String parentID)
	{		
		create(parentID, null, null);
	}

	
	public SuperiorThyroidVeins(String parentID,  BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightConstruct, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE SuperiorThyroidVeins
	 * 
	 * This method will instantiate the shoulders that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods) {

		superiorThyroidVeins = new ArrayList();
		
	
		setImage("images/Lip.jpg");
		setImageHeight(300);
		setImageWidth(300);
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SuperiorThyroidVeinsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.ArmRef, Constants.SuperiorThyroidVeinsRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.SuperiorThyroidVeinRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SuperiorThyroidVeins");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of SuperiorThyroidVeins and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("SuperiorThyroidVeins NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SuperiorThyroidVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Arm for each tranform specified for the organism
			SuperiorThyroidVein superiorThyroidVein = new SuperiorThyroidVein(bioMightTransform.getId(), bioMightConstruct, bioMightMethods);		
			System.out.println("SuperiorThyroidVein Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			superiorThyroidVeins.add(superiorThyroidVein);
			initProperty(bioMightTransform.getName(), Constants.SuperiorThyroidVein, Constants.SuperiorThyroidVeinRef, bioMightTransform.getId());		
			System.out.println("Add SuperiorThyroidVein to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Set up methods that will be available to the SuperiorThyroidVeins
		initMethods();
	}
			

	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setRadius");
		method.setDisplayName("Iris Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Pupil Radius:");
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
		
		// Assemble the SuperiorThyroidVeins
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SuperiorThyroidVeins.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SuperiorThyroidVeins'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for SuperiorThyroidVeins");
		
		// Run through the collection of SuperiorThyroidVeins and assemble the X3D for each
		for (int i=0; i<superiorThyroidVeins.size(); i++)
		{
			// Get the information for the SuperiorThyroidVein
			SuperiorThyroidVein superiorThyroidVein = (SuperiorThyroidVein) superiorThyroidVeins.get(i);
			//System.out.println("Getting X3D for SuperiorThyroidVein");
			body += superiorThyroidVein.getX3D(true);
		}		
		

		//System.out.println("SuperiorThyroidVeins X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Trachea.   These boxes will define
	 * the define the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBoxHead) 
	{
	
	// Set up the Bounding Boxes for the SuperiorThyroidVein
	// Build everything within in the confines of of the given box
	HashMap boundingBoxMap = new HashMap();

		
	// Set up the Bounding Box for the Head
	// On a porportioned human, the pupils lie in the middle of the face
	// For the Default model, the length is 7x9x9
	// This puts the bounding box at the center of the head
	BigDecimal xPos = new BigDecimal(0.0);
	BigDecimal yPos = new BigDecimal(0.0);
	BigDecimal zPos= new BigDecimal(-4.5);
	
	BigDecimal xVector= new BigDecimal(3.5);
	BigDecimal yVector= new BigDecimal(4.5); 
	BigDecimal zVector= new BigDecimal(4.5);
	//BioMightBoundBox bioMightBoundBoxHead = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
	
	// ENDOTHELIUM
	// Set up the Bounding Box for the Endothelium
	// For default model, length of nose is 4.5
	xPos = new BigDecimal(0.0);
	yPos = new BigDecimal(-7.75);
	zPos= new BigDecimal(-3.0); 
	
	xVector= new BigDecimal(2.5);
	yVector= new BigDecimal(2.0); 
	zVector= new BigDecimal(2.5);
	BioMightBoundBox bioMightBoundBoxNose = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	// Stuff in the Bounding Box Map
	boundingBoxMap.put("SuperiorThyroidVein:01",bioMightBoundBoxNose);
	
	

	return (boundingBoxMap);
	}
	

	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("SuperiorThyroidVeins-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for SuperiorThyroidVeins: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.SuperiorThyroidVeins)) {				
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
				System.out.println("SuperiorThyroidVeins - Methods have fired.   Calling SuperiorThyroidVeins Save method!");
				//save();
			}
		}
	}
	
}
