/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;

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
 * Representation of the Nipples
 */

public class Nipples extends BioMightBase {
	private ArrayList nipples;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	
	
	/********************************************************************************************************************
	 *  Nipples
	 * 
	 * This method will instantiate the Nipples that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nipples()
	{		
		create(Constants.NipplesRef, null);
	}
	
	/********************************************************************************************************************
	 *  EYELIDSS
	 * 
	 * This method will instantiate the Nipples that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nipples(String parentID)
	{		
		create(parentID, null);
	}

	
	public Nipples(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the Nipples that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		nipples = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
		
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NipplesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.NippleRef, Constants.NipplesRef+":0");
			bioMightTransforms = bioMightBean.getComponents(Constants.NippleRef, parentID);
			System.out.println("Have Nipples Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Get the collection of Nipples from the database.  
		this.componentID = componentID;
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Nipples and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Nipples NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the nipple we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Nipple: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Nipples for each tranform specified for the organism
			Nipple nipple = new Nipple(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Nipples Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			nipples.add(nipple);
			//String tempID = nipple.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Nipple, Constants.NippleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the nipples
		initMethods();
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the Nipples that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void createOld(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		nipples = new ArrayList();

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
		
		// Get the data for the nipples
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NippleRef, Constants.NipplesRef+":0");
			System.out.println("Have Nipple Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nipples");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of Nipples and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Nipples NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the nipple we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Nipple: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Nipple for each tranform specified for the organism
			Nipple nipple = new Nipple(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Nipple Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			nipples.add(nipple);
			//String tempID = nipple.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Nipple, Constants.NippleRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the nipples
		initMethods();
	}	
	
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Nipple);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Nipple);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
		
		
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
     	nippleColor.add(".25");
     	nippleColor.add(".35");
     	nippleColor.add(".45");
     	nippleColor.add(".50");
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
		 "<meta name='BioMightImage' content='Nipples.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Nipples'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Nipples");
		
		// Run through the collection of nipples and assemble the X3D for each
		for (int i=0; i<nipples.size(); i++)
		{
			
			// Get the information for the nipple
			Nipple nipple = (Nipple) nipples.get(i);
			System.out.println("Getting X3D for Nipple");
			body += nipple.getX3D(true);
		}		
		

		System.out.println("Nipples X3D: " + body);		
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
		System.out.println("Nipples-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Nipples: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Nipples)) {				
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
				System.out.println("EYES - Methods have fired.   Calling Nipples Save method!");
				//save();
			}
		}
	}

		
}
