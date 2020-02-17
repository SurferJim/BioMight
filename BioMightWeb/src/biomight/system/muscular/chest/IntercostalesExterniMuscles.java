/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.chest;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class IntercostalesExterniMuscles extends BioMightBase {
	private ArrayList intercostalesExterniMuscles;	
	private IntercostalesExterniMuscleLeft1 intercostalesExterniMuscleLeft1;
	private IntercostalesExterniMuscleLeft2 intercostalesExterniMuscleLeft2;
	private IntercostalesExterniMuscleLeft3 intercostalesExterniMuscleLeft3;
	private IntercostalesExterniMuscleLeft4 intercostalesExterniMuscleLeft4;
	private IntercostalesExterniMuscleLeft5 intercostalesExterniMuscleLeft5;
	private IntercostalesExterniMuscleLeft6 intercostalesExterniMuscleLeft6;
	private IntercostalesExterniMuscleLeft7 intercostalesExterniMuscleLeft7;
	private IntercostalesExterniMuscleLeft8 intercostalesExterniMuscleLeft8;
	private IntercostalesExterniMuscleLeft9 intercostalesExterniMuscleLeft9;
	private IntercostalesExterniMuscleLeft10 intercostalesExterniMuscleLeft10;
	private IntercostalesExterniMuscleLeft11 intercostalesExterniMuscleLeft11;

	private IntercostalesExterniMuscleRight1 intercostalesExterniMuscleRight1;
	private IntercostalesExterniMuscleRight2 intercostalesExterniMuscleRight2;
	private IntercostalesExterniMuscleRight3 intercostalesExterniMuscleRight3;
	private IntercostalesExterniMuscleRight4 intercostalesExterniMuscleRight4;
	private IntercostalesExterniMuscleRight5 intercostalesExterniMuscleRight5;
	private IntercostalesExterniMuscleRight6 intercostalesExterniMuscleRight6;
	private IntercostalesExterniMuscleRight7 intercostalesExterniMuscleRight7;
	private IntercostalesExterniMuscleRight8 intercostalesExterniMuscleRight8;
	private IntercostalesExterniMuscleRight9 intercostalesExterniMuscleRight9;
	private IntercostalesExterniMuscleRight10 intercostalesExterniMuscleRight10;
	private IntercostalesExterniMuscleRight11 intercostalesExterniMuscleRight11;

	
	/********************************************************************************************************************
	 *  IntercostalesExterniMuscles
	 * 
	 * There are 11 IntercostalesExterniMuscles in this collection of IntercostalesExterni muscles.    
	 * 
	 ********************************************************************************************************************/

	public IntercostalesExterniMuscles()
	{		
		create(Constants.BodyRef, null);
	}
	
	/********************************************************************************************************************
	 *  IntercostalesExterniMuscles
	 * 
	 * This method will instantiate the IntercostalesExterniMuscles that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public IntercostalesExterniMuscles(String parentID)
	{		
		create(parentID, null);
	}

	
	public IntercostalesExterniMuscles(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE IntercostalesExterniMuscles
	 * 
	 * This method will instantiate the shoulders that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		intercostalesExterniMuscles = new ArrayList();
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting IntercostalesExterniMusclesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.IntercostalesExterniMuscleRef, Constants.IntercostalesExterniMusclesRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.IntercostalesExterniMuscleRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - IntercostalesExterniMuscles");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of IntercostalesExterniMuscles and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("IntercostalesExterniMuscles NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating IntercostalesExterniMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the IntercostalesExterniMuscle for each tranform specified for the organism
			IntercostalesExterniMuscle intercostalesExterniMuscle = new IntercostalesExterniMuscle(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("IntercostalesExterniMuscle Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			intercostalesExterniMuscles.add(intercostalesExterniMuscle);
			System.out.println("Added IntercostalesExterniMuscle to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.IntercostalesExterniMuscle, Constants.IntercostalesExterniMuscleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the IntercostalesExterniMuscles
		initMethods();
	}
			
	
	
	/********************************************************************************************************************
	 * CREATE IntercostalesExterniMuscles
	 * 
	 * This method will instantiate the intercostalesExterniMuscles based upon the ribs to which they are attached.
	 * Grab the ribs and then create a muscle for each one at an offset.
	 * 
	 ********************************************************************************************************************/

	private void create(String sumthing, String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		intercostalesExterniMuscles = new ArrayList();
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting IntercostalesExterniMusclesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.IntercostalesExterniMuscleRef, Constants.IntercostalesExterniMusclesRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.Rib, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Ribs");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of IntercostalesExterniMuscles and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Ribs NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating IntercostalesExterniMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the IntercostalesExterniMuscle for each tranform specified for the organism
			IntercostalesExterniMuscle intercostalesExterniMuscle = new IntercostalesExterniMuscle(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("IntercostalesExterniMuscle Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			intercostalesExterniMuscles.add(intercostalesExterniMuscle);
			System.out.println("Added IntercostalesExterniMuscle to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.IntercostalesExterniMuscle, Constants.IntercostalesExterniMuscleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the IntercostalesExterniMuscles
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
		
		// Assemble the IntercostalesExterniMuscles
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='IntercostalesExterniMuscles.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='IntercostalesExterniMuscles'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for IntercostalesExterniMuscles");
		
		// Run through the collection of IntercostalesExterniMuscles and assemble the X3D for each
		for (int i=0; i<intercostalesExterniMuscles.size(); i++)
		{
			// Get the information for the eye
			IntercostalesExterniMuscle intercostalesExterniMuscle = (IntercostalesExterniMuscle) intercostalesExterniMuscles.get(i);
			//System.out.println("Getting X3D for IntercostalesExterniMuscle");
			body += intercostalesExterniMuscle.getX3D(true);
		}		
		

		//System.out.println("IntercostalesExterniMuscles X3D: " + body);		
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
		System.out.println("IntercostalesExterniMuscles-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for IntercostalesExterniMuscles: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.IntercostalesExterniMuscle)) {				
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
				System.out.println("IntercostalesExterniMuscles - Methods have fired.   Calling IntercostalesExterniMuscles Save method!");
				//save();
			}
		}
	}	
	
}
