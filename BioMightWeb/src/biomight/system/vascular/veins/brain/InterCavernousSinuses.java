/*
 * Created on Sep 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.brain;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the InterCavernousSinuses
 * 
 */

public class InterCavernousSinuses extends BioMightBase{
private ArrayList interCavernousSinuses;
		
	
	/********************************************************************************************************************
	 *  InterCavernousSinuses
	 * 
	 * This method will instantiate the InterCavernousSinuses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public InterCavernousSinuses()
	{		
		create(Constants.BodyRef, null);
	}
	
	/********************************************************************************************************************
	 *  InterCavernousSinuses
	 * 
	 * This method will instantiate the InterCavernousSinuses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public InterCavernousSinuses(String parentID)
	{		
		create(parentID, null);
	}

	
	public InterCavernousSinuses(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE InterCavernousSinuses
	 * 
	 * This method will instantiate the shoulders that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		interCavernousSinuses = new ArrayList();
		
		setImage("images/Lip.jpg");
		setImageHeight(300);
		setImageWidth(300);
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting InterCavernousSinusesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.ArmRef, Constants.InterCavernousSinusesRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.InterCavernousSinusRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InterCavernousSinuses");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of InterCavernousSinuses and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("InterCavernousSinuses NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating InterCavernousSinus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Arm for each tranform specified for the organism
			InterCavernousSinus interCavernousSinus = new InterCavernousSinus(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("InterCavernousSinus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			interCavernousSinuses.add(interCavernousSinus);
			initProperty(bioMightTransform.getName(), Constants.InterCavernousSinus, Constants.InterCavernousSinusRef, bioMightTransform.getId());		
			System.out.println("Add InterCavernousSinus to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Set up methods that will be available to the InterCavernousSinuses
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
		
		// Assemble the InterCavernousSinuses
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='InterCavernousSinuses.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='InterCavernousSinuses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for InterCavernousSinuses");
		
		// Run through the collection of InterCavernousSinuses and assemble the X3D for each
		for (int i=0; i<interCavernousSinuses.size(); i++)
		{
			// Get the information for the InterCavernousSinus
			InterCavernousSinus interCavernousSinus = (InterCavernousSinus) interCavernousSinuses.get(i);
			//System.out.println("Getting X3D for InterCavernousSinus");
			body += interCavernousSinus.getX3D(true);
		}		
		

		//System.out.println("InterCavernousSinuses X3D: " + body);		
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
		System.out.println("InterCavernousSinuses-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for InterCavernousSinuses: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.InterCavernousSinuses)) {				
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
				System.out.println("InterCavernousSinuses - Methods have fired.   Calling InterCavernousSinuses Save method!");
				//save();
			}
		}
	}
	
	
	
}