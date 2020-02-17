/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.BodyPart;
import biomight.body.head.ear.LeftEar;
import biomight.body.head.ear.RightEar;
import biomight.cell.neuronglial.*;
import biomight.cell.epithelial.*;
import biomight.cell.neuron.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.muscular.head.eye.*;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * This class will instantiate the eyeLids that are defined for the body we
 * are working with.
 * 
 */

public class EyeLids extends BioMightBase {
	private ArrayList eyeLids;
	
	
	/********************************************************************************************************************
	 *  EYELIDSS
	 * 
	 * This method will instantiate the EyeLids that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public EyeLids()
	{		
		create(Constants.HeadRef, null);
	}
	
	/********************************************************************************************************************
	 *  EYELIDSS
	 * 
	 * This method will instantiate the EyeLids that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public EyeLids(String parentID)
	{		
		create(parentID, null);
	}

	
	public EyeLids(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the EyeLids that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		eyeLids = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
		
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EyeLidsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.EyeRef, Constants.EyeLidsRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.EyeLidRef, parentID);
			System.out.println("Have EyeLids Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Get the collection of EyeLids from the database.  
		this.componentID = componentID;
		
		// Run through the collection of EyeLids and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have EyeLids NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Eye: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the EyeLids for each tranform specified for the organism
			EyeLid eyeLid = new EyeLid(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("EyeLids Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			eyeLids.add(eyeLid);
			//String tempID = eye.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Eye, Constants.EyeRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the eyeLids
		initMethods();
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the EyeLids that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void createOld(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		eyeLids = new ArrayList();

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
		
		// Get the data for the eyeLids
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.EyeRef, Constants.EyeLidsRef+":0");
			System.out.println("Have Eye Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - EyeLids");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
	
		// Run through the collection of EyeLids and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have EyeLids NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Eye: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Eye for each tranform specified for the organism
			EyeLid eyeLid = new EyeLid(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("EyeLid Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			eyeLids.add(eyeLid);
			//String tempID = eye.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Eye, Constants.EyeRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the eyeLids
		initMethods();
	}	
	
	
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();



		/*
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setColor");
		method.setDisplayName("Pupil Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> pupilColor = new ArrayList<String>();
     	pupilColor.add("Black");
     	pupilColor.add("Dark Black");
     	pupilColor.add("Light Black");
    	method.setValues(pupilColor);
		methods.add(method);
		*/
		
		/*
		method = new BioMightMethodView();
		method.setMethodName("setPupilSize");
		method.setDisplayName("Pupil Size:");
		method.setHtmlType("dropdown");
		method.setDataType("double");
     	ArrayList<String> pupilSize = new ArrayList<String>();
     	eyeColor.add(".25");
     	eyeColor.add(".35");
     	eyeColor.add(".45");
     	eyeColor.add(".50");
    	method.setValues(pupilSize);
		methods.add(method);	
		*/

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Sclera);
		method.setMethodName("setRadius");
		method.setDisplayName("Sclera Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EyeLids.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EyeLids'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for EyeLids");
		
		// Run through the collection of eyeLids and assemble the X3D for each
		for (int i=0; i<eyeLids.size(); i++)
		{
			
			// Get the information for the eye
			EyeLid eyeLid = (EyeLid) eyeLids.get(i);
			System.out.println("Getting X3D for EyeLid");
			body += eyeLid.getX3D(true);
		}		
		

		//System.out.println("EyeLids X3D: " + body);		
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
		System.out.println("EyeLids-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for EyeLids: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.EyeLids)) {				
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
				System.out.println("EYES - Methods have fired.   Calling EyeLids Save method!");
				//save();
			}
		}
	}


	
}
