/*
 * Created on Oct 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.head.eye.Eye;
import biomight.body.head.mouth.tongue.FiliformPapilla;
import biomight.body.head.mouth.tongue.Tongue;
import biomight.body.head.tooth.Teeth;
import biomight.body.head.tooth.Tooth;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.lymphatic.head.ParotidGlands;
import biomight.system.lymphatic.head.SupraMandibularGlands;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
/**
 * @author SurferJim
 *
 * Representation of Salivary Glands
 */

public class SalivaryGlands extends BioMightBase {
	private ArrayList salivaryGlands;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private ParotidGlands parotidGlands;
	private SupraMandibularGlands supraMandibularGlands;
	

	/********************************************************************************************************************
	 *  SalivaryGlands
	 * 
	 * This method will instantiate the SalivaryGlands that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	public SalivaryGlands()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SalivaryGlandsRef, null, null);
	}

	public SalivaryGlands(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public SalivaryGlands(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling SalivaryGlands Create");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{

		salivaryGlands = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("Executing SalivaryGlands METHODS: " + bioMightMethods.size());
		}
		
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SalivaryGlandsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SalivaryGlandRef, parentID);
			System.out.println("Have SalivaryGlands Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Get the collection of SalivaryGlands from the database.  
		this.componentID = componentID;
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of SalivaryGlands and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SalivaryGlands NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SalivaryGlands (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//parotidGlands = new ParotidGlands(bioMightTransform.getId(), bioMightMethods);
				//System.out.println("In SalivaryGlands - Created ParotidGlands");
				//supraMandibularGlands = new SupraMandibularGlands(bioMightTransform.getId(), bioMightMethods);
				//System.out.println("In SalivaryGlands - Created SupraMandibularGlands");

				// Create an instance of the SalivaryGland
				SalivaryGland salivaryGland = new SalivaryGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
				System.out.println("SalivaryGland Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				salivaryGlands.add(salivaryGland);
				//String tempID = eye.getComponentID();
				System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

				// initialize the Properties
				// in this case, rather than pass canonical name, we pass the name found in the collection
				initProperty(bioMightTransform.getName(), Constants.SalivaryGland, Constants.SalivaryGland, bioMightTransform.getId());
			
			}
			else if (view == Constants.VIEW_DETACHED)
			{
	
			}
			else
			{

			}	
		}		
	
		initProperties();
		initMethods();
		System.out.println("Created SalivaryGlands");
	}
	

	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("ParatoidGlands");
		property.setCanonicalName(Constants.Lips);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Teeth");
		property.setCanonicalName(Constants.Teeth);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tongue");
		property.setCanonicalName(Constants.Tongue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Salivary Glands");
		property.setCanonicalName(Constants.SalivaryGlands);
		properties.add(property);
	}
	
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView 	method = new BioMightMethodView();
		method.setCanonicalName(Constants.SalivaryGlands);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.SalivaryGlands);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
	
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Collection of SalivaryGlands.  It runs through each of its components 
	 * and collects up their representations and then assembles them into model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Salivary Glands
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SalivaryGlands.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Salivary'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for SalivaryGlands");
		
		// Run through the collection of SalivaryGlands and assemble the X3D for each
		for (int i=0; i<salivaryGlands.size(); i++)
		{
			
			// Get the information for the SalivaryGland
			SalivaryGland salivaryGland = (SalivaryGland) salivaryGlands.get(i);
			System.out.println("Getting X3D for SalivaryGland");
			body += salivaryGland.getX3D(true);
		}		
		

		//System.out.println("SalivaryGlands X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3DOld(boolean snipet) {
		
		// Assembe the SalivaryGlands
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SalivaryGlands.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SalivaryGlands'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		//body = parotidGlands.getX3D(true) + supraMandibularGlands.getX3D(true); 		
			
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
		System.out.println("SalivaryGlands-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for SalivaryGlands: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.SalivaryGlands)) {				
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
				System.out.println("SalivaryGlands - Methods have fired.   Calling SalivaryGlands Save method!");
				//save();
			}
		}
	}
	
	
	
	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}	

	
}
