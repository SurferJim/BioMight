/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.foot;
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
import biomight.view.BioMightTransforms;

/************************************************************************
 * AbductorOssisMetatarsiQuinti MUSCLES
 *  
 * @author SurferJim
 *
 ************************************************************************/

public class AbductorOssisMetatarsiQuintiMuscles extends BioMightBase {
	private ArrayList AbductorOssisMetatarsiQuintiMuscles;

	
	/********************************************************************************************************************
	 *  AbductorOssisMetatarsiQuintiMuscles
	 * 
	 * There are 11 AbductorOssisMetatarsiQuintiMuscles in this collection of AbductorOssisMetatarsiQuinti muscles.    
	 * 
	 ********************************************************************************************************************/

	public AbductorOssisMetatarsiQuintiMuscles()
	{		
		create(Constants.BodyRef, null);
	}
	
	/********************************************************************************************************************
	 *  AbductorOssisMetatarsiQuintiMuscles
	 * 
	 * This method will instantiate the AbductorOssisMetatarsiQuintiMuscles that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public AbductorOssisMetatarsiQuintiMuscles(String parentID)
	{		
		create(parentID, null);
	}

	
	public AbductorOssisMetatarsiQuintiMuscles(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE AbductorOssisMetatarsiQuinti Muscles
	 * 
	 * This method will instantiate the AbductorOssisMetatarsiQuinti that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		AbductorOssisMetatarsiQuintiMuscles = new ArrayList();
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AbductorOssisMetatarsiQuintiMusclesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.AbductorOssisMetatarsiQuintiMuscleRef, Constants.AbductorOssisMetatarsiQuintiMusclesRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.AbductorOssisMetatarsiQuintiMuscleRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AbductorOssisMetatarsiQuintiMuscles");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of AbductorOssisMetatarsiQuintiMuscles and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("AbductorOssisMetatarsiQuintiMuscles NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating AbductorOssisMetatarsiQuintiMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the AbductorOssisMetatarsiQuintiMuscle for each tranform specified for the organism
			AbductorOssisMetatarsiQuintiMuscle AbductorOssisMetatarsiQuintiMuscle = new AbductorOssisMetatarsiQuintiMuscle(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("AbductorOssisMetatarsiQuintiMuscle Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			AbductorOssisMetatarsiQuintiMuscles.add(AbductorOssisMetatarsiQuintiMuscle);
			System.out.println("Added AbductorOssisMetatarsiQuintiMuscle to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.AbductorOssisMetatarsiQuintiMuscle, Constants.AbductorOssisMetatarsiQuintiMuscleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the AbductorOssisMetatarsiQuintiMuscles
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
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the AbductorOssisMetatarsiQuintiMuscles.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the AbductorOssisMetatarsiQuintiMuscles
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AbductorOssisMetatarsiQuintiMuscles.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AbductorOssisMetatarsiQuintiMuscles'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for AbductorOssisMetatarsiQuintiMuscles");
		
		// Run through the collection of AbductorOssisMetatarsiQuintiMuscles and assemble the X3D for each
		for (int i=0; i<AbductorOssisMetatarsiQuintiMuscles.size(); i++)
		{
			// Get the information for the eye
			AbductorOssisMetatarsiQuintiMuscle AbductorOssisMetatarsiQuintiMuscle = (AbductorOssisMetatarsiQuintiMuscle) AbductorOssisMetatarsiQuintiMuscles.get(i);
			//System.out.println("Getting X3D for AbductorOssisMetatarsiQuintiMuscle");
			body += AbductorOssisMetatarsiQuintiMuscle.getX3D(true);
		}		
		

		//System.out.println("AbductorOssisMetatarsiQuintiMuscles X3D: " + body);		
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
		System.out.println("AbductorOssisMetatarsiQuintiMuscles-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for AbductorOssisMetatarsiQuintiMuscles: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.AbductorOssisMetatarsiQuintiMuscle)) {				
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
				System.out.println("AbductorOssisMetatarsiQuintiMuscles - Methods have fired.   Calling AbductorOssisMetatarsiQuintiMuscles Save method!");
				//save();
			}
		}
	}		

}
