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

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.cell.epithelial.AmacrineCell;
import biomight.cell.neuron.BiPolarCell;
import biomight.cell.neuron.HorizontalCell;
import biomight.cell.neuronglial.GanglionicCell;
import biomight.chemistry.protein.*;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.tissue.connective.*;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomightweb.util.BioWebUtils;


 /******************************************************************************************************
 * IRIS 
 * 
 * Representation of an Iris
 * 
 *******************************************************************************************************/
 
public class Iris extends Organ{
	private IrisStroma irisStroma;
	
	
	public Iris()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.IrisRef, null, null);
	}

	public Iris(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Iris(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
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
		this.setImage("images/Iris.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
		this.parentID = parentID;
		
	System.out.println("CreateIris Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Iris METHODS: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting IrisInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.IrisRef, parentID);
			System.out.println("Have Iris Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Iris");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		// Run through the collection of Iriss and build them into the model
		// In the default case, we get one instance of the Iris for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Iris NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Iris we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Iris: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Iris Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				//String startID = "IrisEpithelium:00001";
				//System.out.println("HawkEye - Creating Iris Epithelium: " + parentID + "  startID: " + startID);				
				//epithelium = new EpitheliumTissue(localVP, localLOD, startID, "IrisEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("IrisEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
						
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Iris Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
						
				/*
				irisStroma = new IrisStroma(bioMightTransform.getId(), bioMightMethods);
				initProperty("IrisStroma", Constants.IrisStroma, Constants.IrisStromaRef, irisStroma.getComponentID());

				*/	
			}
				
		
		
		}
		initProperties();
		initMethods();
		
	
	}
	

	/****************************************************
	 * GENERATE IRIS
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Iris Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Iris: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.25;
		
			if (componentID.equals("Iris:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {3.5,-17.5, -1.75};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);

				System.out.println("Calling Generate Iris: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateIris("IrisEpithelium:00001", "IrisEpithelium", 
				//	"IrisEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created IrisEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - IrisEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.IrisStromaRef, Constants.IrisStroma, Constants.IrisStromaRef, "Iris:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	


	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioText);
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
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Iris
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Iris.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Iris'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		
		int view = Constants.VIEW_DETACHED;
		if (view == Constants.VIEW_FLOATING)
		{
			body = irisStroma.getX3D(true);
		}
		else if (view == Constants.VIEW_DETACHED)
		{		
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the pupil we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Iris: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		

				//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body = "<Transform DEF='Iris'\n" +
		 			   "translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 			+ bioMightTransform.getTranslation().getYPos() + " "
			 			+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		   "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 			+ bioMightTransform.getScale().getYPos() + " "
			 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
			 			"<Shape DEF='Iris'\n" +
			 			" containerField='children'>\n" +
			 			" <Appearance\n" +
			 			"  containerField='appearance'>\n" +
			 			" <Material DEF='Rust'\n" +
			            "containerField='material'\n" +
			            "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			            "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
			            "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
			            "diffuseColor='" + 
			            bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
			            bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
			            bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
			            "</Appearance>\n" +
			            "<Sphere DEF='IrisGeoSphere'\n" +
			            "containerField='geometry'\n" +
			            "radius='" + bioMightTransform.getRadius() +"'/>\n" +
			            "</Shape>\n" +
			            "</Transform>\n"; 
			}
		}
		else
		{
			body = "";//						
		}
		
		
		
		//System.out.println("Iris X3D: " + body);	
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
		System.out.println("IRIS-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for IRIS: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Iris)) {				
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
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Methods have fired.   Calling IRIS Save method!");
				//save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the iris
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.32;
		
		System.out.println("Setting IRIS Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating IRIS Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information back into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated IRIS Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the iris
	 * 
	 * Set the color of the Iris
	 * 
	 *****************************************************************************/
	public void setColor(String color) {

		int numColor = BioWebUtils.mapColor(color);
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting Membrane Color to: " + color + " for: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.setMaterial(parentID, numColor);
			System.out.println("Color is set: " + returnCode);   	
		}catch (Exception e) { 
			System.out.println("Exception Setting Iris Color");
			throw new ServerException("Remote Exception setColor():", e); 	
		}

	}


	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information back into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		

		String x3d = getX3D(true);
		System.out.println("SAVING X3D" + x3d);
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Transforms: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating IRIS Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			System.out.println("IRIS Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
			System.out.println("IRIS Tranforms Material is: " + bioMightTransform.getName() + "  " + bioMightTransform.getMaterialID());
		}

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Saving IRIS Data");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.IrisRef, parentID, bioMightTransform);
			System.out.println("Saved IRIS Data!");  	
			
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Iris");
			throw new ServerException("Remote Exception getComponents():" + e); 	
		}
		
	}
		
}
