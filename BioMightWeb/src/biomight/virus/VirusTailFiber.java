/*
 * Created on Oct 15, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.virus;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a VirusTailFiber.
 * 
 ************************************************************************************/

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.Endosomes;
import biomight.chemistry.compound.Granzymes;
import biomight.chemistry.compound.Perforins;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.chemistry.compound.LipidA;
import biomight.chemistry.compound.Peptidoglycan;
import biomight.chemistry.compound.TeichoicAcid;
import biomightweb.view.BioMightViewPoint;


public class VirusTailFiber extends BioMightBase {
	private VirusTailFiberSegments virusTailFiberSegments;	
	private Peptidoglycan peptidoglycan;
	private LipidA lipidA;
	private TeichoicAcid teichoicAcid;

	
	/************************************************************************
	 * VirusTailFiber Constructor 
	 *
	 ***********************************************************************/
	public VirusTailFiber()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.VirusTailFiberRef, null, null);
	}

	/************************************************************************
	 * VirusTailFiber Constructor 
	 *
	 ***********************************************************************/
	public VirusTailFiber (String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * VirusTailFiber Constructor 
	 *
	 ***********************************************************************/
	public VirusTailFiber(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create VirusTailFiber
	 *
	 ***********************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/VirusTailFiber.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="VirusTailFiber.x3d";

		
		if (localVP == Constants.VIEW_INTERNAL)			
		{			
			
			if (localLOD == Constants.MAG1X)
			{
				System.out.println("Creating VirusTailFiber at INTERNAL MAG1X with parent: " + parentID);
				// initialize the Properties
				initProperties();
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the VirusTailFiber				
				System.out.println("Creating VirusTailFiber at INTERNAL MAG2X with parent: " + parentID);
				localVP = Constants.VIEW_DETACHED; 
				localLOD = Constants.MAG1X;
				
				System.out.println("In VirusTailFiber- Creating VirusTailFiberSegments");
				virusTailFiberSegments = new VirusTailFiberSegments(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.VirusTailFiberSegmentsRef, Constants.VirusTailFiberSegments, Constants.VirusTailFiberSegmentsRef, virusTailFiberSegments.getComponentID());
				System.out.println("In Adenovirus - VirusTailFiber is complete");
				}
		
		}
		// We are looking at the element outside the scope of the collection
	
		// We have to get the data from the repository as 
		else if (localVP == Constants.VIEW_DETACHED)			
		{			
			// Generate the Component if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			// The component is being called from within another component.  We
			// have a parent ID and know what type it is.
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting VirusTailFiberInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.VirusTailFiberRef, parentID);
				System.out.println("Have VirusTailFiberInfo from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - VirusTailFiber");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have VirusTailFiberTransforms : " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{	
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating VirusTailFiber: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				

				if (localLOD == Constants.MAG1X)
				{
					// initialize the Properties
					initProperties();
					System.out.println("DETACHED - MAG 1X - Do Nada");
				}
				else if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the VirusTailFiber				
					System.out.println("MAG2X - DETACHED - Creating VirusTailFiber: " + parentID + " lod: " + localLOD);
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;

					this.properties = bioMightProperties;
										
					virusTailFiberSegments = new VirusTailFiberSegments(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.VirusTailFiberSegmentsRef, Constants.VirusTailFiberSegments, Constants.VirusTailFiberSegmentsRef, virusTailFiberSegments.getComponentID());
					System.out.println("In Adenovirus - VirusTailFibers is complete");
				}
			}
		}
		// When one drills directly into a component.  As we have the ID,
		// we can directly get it from the database.
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			// Generate the Component if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			// This is when one is accessing a VirusTailFiberdirectly
			// We have the ID of the component through the Drill-down
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				//System.out.println("Getting HawkEye VirusTailFiberInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				//System.out.println("Have VirusTailFiberInfo from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - VirusTailFiber");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of VirusTailFibers and build them into the model
			// In the default case, we get one instance of the VirusTailFiberfor each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("VirusTailFiberNumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the VirusTailFiber
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating VirusTailFiber: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();


				if (localLOD == Constants.MAG1X)
				{
					// initialize the Properties
					initProperties();
				}
				else if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the VirusTailFiber				
					//System.out.println("Creating VirusTailFiber: " + parentID + " lod: " + localLOD);
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;

					//System.out.println("In VirusTailFiber- Creating Capsomeres");
					//capsomeres = new Capsomeres(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Capsiod - Capsomeres is complete");
					//initProperty(Constants.CapsomeresRef, Constants.Capsomeres, Constants.CapsomeresRef, capsomeres.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				}
				
			}
		}		
		else
		{
				
		}
				
				
		initProperties();
		initMethods();
		
		System.out.println("Create VirusTailFiberComplete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cell Membrane METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
	}
			
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Capsomere");
		property.setCanonicalName(Constants.Cholesterol);
		properties.add(property);
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("checkbox");
		methods.add(method);
	}

	
	/***************************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Liver Edothelium		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the VirusTailFiber: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double circumference = 0.0025;
			// Generate the GreaterCurvature of the stomach
			// Create 5 sections
			double[] startPos = {0.0, -0.30, 0.00};
			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	      		
			System.out.println("Calling Generate VirusTailFiber: " + componentID + "    " + parentID);
			int success = bioMightBean.generateVirusTailFiber("VirusTailFiber:00001", "VirusTailFiber", 
				"VirusTailFiber", componentID, parentID, currentPoints);			
			
			System.out.println("Created VirusTailFiberInfo using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - VirusTailFiber");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the VirusTailFiber.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the VirusTailFiber
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='VirusTailFiber.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='VirusTailFiber'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";

	
		if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			if (lod == Constants.MAG1X)
			{
				System.out.println("In VirusTailFiber- INTERNAL - Getting X3D - MAG1X - Get from parent - do nada");
			}
			else if (lod == Constants.MAG2X)
			{	
				// Run through the collection of VirusTailFibers and assemble the X3D for each
				System.out.println("In VirusTailFiber-INTERNAL -Getting X3D - MAG2X");
				body += virusTailFiberSegments.getX3D(true);
			}

		}
		else if (viewPerspective == Constants.VIEW_DETACHED)
		{
			if (lod == Constants.MAG2X)
			{	
				body = virusTailFiberSegments.getX3D(true);
			}
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			if (lod == Constants.MAG2X)
			{	
				body = virusTailFiberSegments.getX3D(true);
			}
		}		
		
		//System.out.println("VirusTailFiberX3D: " + body);	
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
		System.out.println("VirusTailFiber-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for VirusTailFiber: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the VirusTailFiber
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.VirusTailFiber)) {				
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
				System.out.println("Methods have fired.   Calling VirusTailFiberSave method!");
				save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the VirusTailFiber
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.5;
		
		System.out.println("Setting VirusTailFiberRadius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating VirusTailFiberRadius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information VirusTailFiberinto the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated VirusTailFiberRadius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the VirusTailFiber
	 * 
	 * Set the color of the VirusTailFiber
	 * 
	 *****************************************************************************/
	public void setColor(String colorStr) {

		BioMightColor bioMightColor = null;
		int colorCode = 1;
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Setting VirusTailFiberEyeColor: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			if (colorStr.toUpperCase().equals("Bright White")) {
				bioMightColor = new BioMightColor(0.0, 0.0, 1.0);
				colorCode=1;
			}
			else if (colorStr.toUpperCase().equals("Pearl White")) {
				bioMightColor = new BioMightColor(0.0, 1.0, 0.0);
				colorCode=2;
			}
			else if (colorStr.toUpperCase().equals("Tarnished White")) {
				bioMightColor = new BioMightColor(0.5, 0.29, 0.3);
				colorCode=4;
			}							
			else
			{
				bioMightColor = new BioMightColor(0.0, 0.0, 1.0);
				colorCode=1;
			}
			
			System.out.println("Setting VirusTailFiberColor " + bioMightTransform.getName() + "  to: " + colorStr);
			
			bioMightTransform.getMaterial().setDiffuseColor(bioMightColor);
			bioMightTransform.setMaterialID(colorCode);
			// Store the updated information VirusTailFiberinto the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Stored Diffuse Color in transform");
		}
		
	}

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information VirusTailFiberinto the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms for VirusTailFiber: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating VirusTailFiberTranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			//System.out.println("VirusTailFiberTranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
		}
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Save the information via the update call	
			System.out.println("Saving VirusTailFiberData");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.VirusTailFiberRef, parentID, bioMightTransform);

			System.out.println("Saved VirusTailFiberData!");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		
	}

	/*************************************************************************
	 * OnContact
	 * 
	 * When the cell membrane comes in contact with an object, they exchange
	 * the exchange is reflected here.
	 ************************************************************************/
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Perforins)
		{
			// Form a channel through the cell membrane
			// this leads to loss of cell contents and death
		}

		if (obj instanceof Granzymes)
		{
			// Protease that degrades the proteins in the cell membrane
			// leading to rupture and loss of cell contents
			// If there are enough of them, a=]nd the time is sustained, then
			// theoretically, the reactions should take place.
			// Lyse the membrane
		}
	}

	
	public void rupture()
	{
		// Rupture open a hole in the membrane at the point of most weakness
		
	}
	
	public void setVoltageGradient()
	{
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
