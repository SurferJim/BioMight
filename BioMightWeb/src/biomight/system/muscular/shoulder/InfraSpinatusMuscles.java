/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.shoulder;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightMuscularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/************************************************************************
 * INFRA SPINATUS MUSCLES
 *  
 * @author SurferJim
 * 
 * Represenation of the InfraSpinatusMuscles
 *
 ************************************************************************/

public class InfraSpinatusMuscles extends BioMightBase {
	private ArrayList infraSpinatusMuscles;

	
	/********************************************************************************************************************
	 *  InfraSpinatusMuscles
	 * 
	 * There are 11 InfraSpinatusMuscles in this collection of InfraSpinatus muscles.    
	 * 
	 ********************************************************************************************************************/

	public InfraSpinatusMuscles()
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	

	}
	
	/********************************************************************************************************************
	 *  InfraSpinatusMuscles
	 * 
	 * This method will instantiate the InfraSpinatusMuscles that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public InfraSpinatusMuscles(String parentID)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public InfraSpinatusMuscles(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
	}
	
	/********************************************************************************************************************
	 * CREATE InfraSpinatus Muscles
	 * 
	 * This method will instantiate the InfraSpinatus that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {

		infraSpinatusMuscles = new ArrayList();
			
		// Generate the InfraSpinatus Muscles if we are creating a customized set
		boolean bGenerate = false;
		if (bGenerate) {
			generate(parentID, componentID);
		}
	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting InfraSpinatusMusclesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.InfraSpinatusMuscleRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InfraSpinatusMuscles");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		componentID = Constants.InfraSpinatusMusclesRef+":0";
		
		// Run through the collection of InfraSpinatusMuscles and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("InfraSpinatusMuscles NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating InfraSpinatusMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			InfraSpinatusMuscle InfraSpinatusMuscle = new InfraSpinatusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("InfraSpinatusMuscle Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			infraSpinatusMuscles.add(InfraSpinatusMuscle);
			System.out.println("Added InfraSpinatusMuscle to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.InfraSpinatusMuscle, Constants.InfraSpinatusMuscleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the InfraSpinatusMuscles
		initMethods();
	}
			
	
	/**************************************************************
	 * INIT METHODS
	 * 
	 *************************************************************/
	
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
	
	
	/**********************************************************************
	 * GENERATE InfraSpinatus Muscle
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the InfraSpinatusMuscle Epithelium		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the InfraSpinatusMuscle ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal"); 
	
			// Generate the Left InfraSpinatusMuscles
			double circumference = 0.125;
			double[] startPos = {1.5, -30.0, -2.0};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);				
	    	
			int success = bioMightBean.generateInfraSpinatusMuscle("InfraSpinatusMuscle:01", "InfraSpinatusMuscleTissue", 
					"InfraSpinatusMuscle", componentID, parentID, currentPoints);			
		
			// Generate the Right InfraSpinatusMuscles 
			startPos[0] = -1.5;
			startPos[1] =-30.0;
			startPos[2] = -2.0;
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
	
	    	success = bioMightBean.generateInfraSpinatusMuscle("InfraSpinatusMuscle:02", "InfraSpinatusMuscle", 
					"InfraSpinatusMuscle", componentID, parentID, currentPoints);			
		
		
			System.out.println("Created InfraSpinatusMuscles Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InfraSpinatusMuscles");
			throw new ServerException("Remote Exception generateInfraSpinatusMuscles():", e); 	
		}
	}

	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the InfraSpinatusMuscles.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the InfraSpinatusMuscles
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='InfraSpinatusMuscles.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='InfraSpinatusMuscles'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for InfraSpinatusMuscles");
		
		// Run through the collection of InfraSpinatusMuscles and assemble the X3D for each
		for (int i=0; i<infraSpinatusMuscles.size(); i++)
		{
			// Get the information for the eye
			InfraSpinatusMuscle infraSpinatusMuscle = (InfraSpinatusMuscle) infraSpinatusMuscles.get(i);
			System.out.println("Getting X3D for InfraSpinatusMuscle");
			body += infraSpinatusMuscle.getX3D(true);
		}		
		

		//System.out.println("InfraSpinatusMuscles X3D: " + body);		
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
		System.out.println("InfraSpinatusMuscles-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for InfraSpinatusMuscles: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.InfraSpinatusMuscle)) {				
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
				System.out.println("InfraSpinatusMuscles - Methods have fired.   Calling InfraSpinatusMuscles Save method!");
				//save();
			}
		}
	}		

}
