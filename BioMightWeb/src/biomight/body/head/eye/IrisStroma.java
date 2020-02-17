/*
 * Created on Jul 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EpithelialCells;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.FibrousConnectiveTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of a irisStroma
 * 
 */

public class IrisStroma extends BioMightBase {
	private FibrousConnectiveTissue fibrousConnectiveTissue;
	private EpithelialCells epithelialCells;
	
	
	public IrisStroma()
	{
		create(Constants.IrisStromaRef, null);
	}
	

	public IrisStroma(String parentID)
	{		
		System.out.println("Creating the IrisStroma: " + parentID);
		create(parentID, null);
	}

	public IrisStroma(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		System.out.println("Creating the IrisStroma: " + parentID);
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/IrisStroma.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting IrisStromaInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.IrisStromaRef, parentID);
			System.out.println("Have IrisStroma Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - IrisStroma");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// Run through the collection of IrisStromas and build them into the model
		// In the default case, we get one instance of the IrisStroma for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("IrisStroma NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Iris Stroma we are creating
			// Consists of layer if connective tissue layered upon Epithelial Cells
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating IrisStroma: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			fibrousConnectiveTissue  = new FibrousConnectiveTissue("IrisStromaConnectiveTissue", bioMightTransform.getId(), bioMightMethods);
			initProperty("FibrousConnectiveTissue", Constants.FibrousConnectiveTissue, Constants.FibrousConnectiveTissueRef, fibrousConnectiveTissue.getComponentID());
			System.out.println("Creating FibrousConnectiveTissue - IrisStroma: " + bioMightTransform.getId());	

			epithelialCells  = new EpithelialCells("IrisStromaEpithelialCell", bioMightTransform.getId(), bioMightMethods);
			initProperty("EpithelialCells", Constants.EpithelialCells, Constants.EpithelialCellsRef, epithelialCells.getComponentID());
			System.out.println("Creating EpithelialCells - IrisStroma: " + bioMightTransform.getId());	
		
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateIrisStroma Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PUPIL METHODS: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
	}
	

	public void redraw(int eyeReference)
	{
		System.out.println("IrisStroma Redraw");
		//init3D(eyeReference);
	}

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("CornealEpithelium");
		property.setCanonicalName(Constants.CornealEpithelium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BowmansLayer");
		property.setCanonicalName(Constants.BowmansLayer);
		properties.add(property);
		
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.IrisStroma);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.IrisStroma);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
		
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.IrisStroma);
		method.setMethodName("setRadius");
		method.setDisplayName("Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Fovea.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Fovea
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Fovea.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Fovea'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body =  
			fibrousConnectiveTissue.getX3D(true);
			//just commented because lod is low
			//epithelialCells.getX3D(true);
		
		
		//System.out.println("IrisStroma X3D: " + body);		
		
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
		System.out.println("IrisStroma-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			//System.out.println("Have BioMightMethod for IrisStroma: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IrisStroma
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.IrisStroma)) {				
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
				System.out.println("Methods have fired.   Calling IrisStroma Save method!");
				save();
			}
		}
	}
	
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the IrisStroma
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.225;
		
		System.out.println("Setting IrisStroma Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the irisStroma we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating IrisStroma Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information IrisStroma into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated IrisStroma Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the IrisStroma
	 * 
	 * Set the color of the IrisStroma
	 * 
	 *****************************************************************************/
	public void setColor(String colorStr) {

		BioMightColor bioMightColor = null;
		int colorCode = 1;
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the irisStroma we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Setting IrisStroma EyeColor: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			if (colorStr.toUpperCase().equals("BLUE")) {
				bioMightColor = new BioMightColor(0.0, 0.0, 1.0);
				colorCode=1;
			}
			else if (colorStr.toUpperCase().equals("GREEN")) {
				bioMightColor = new BioMightColor(0.0, 1.0, 0.0);
				colorCode=2;
			}
			else if (colorStr.toUpperCase().equals("BROWN")) {
				bioMightColor = new BioMightColor(0.5, 0.29, 0.3);
				colorCode=4;
			}		
			else if (colorStr.toUpperCase().equals("HAZEL")) {
				bioMightColor = new BioMightColor(0.27, 0.0, 0.72);
				colorCode=6;
			}					
			else
			{
				bioMightColor = new BioMightColor(0.0, 0.0, 1.0);
				colorCode=1;
			}
			
			System.out.println("Setting IrisStroma Color " + bioMightTransform.getName() + "  to: " + colorStr);
			
			bioMightTransform.getMaterial().setDiffuseColor(bioMightColor);
			bioMightTransform.setMaterialID(colorCode);
			// Store the updated information IrisStroma into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Stored Diffuse Color in transform");
		}
		
	}

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information IrisStroma into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		

		String x3d = getX3D(true);
		System.out.println("SAVING X3D" + x3d);
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the irisStroma we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating PUPIL Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			System.out.println("PUPIL Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
			System.out.println("PUPIL Tranforms Material is: " + bioMightTransform.getName() + "  " + bioMightTransform.getMaterialID());

		}
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			System.out.println("Saving PUPIL Data");
			int returnCode = bioMightBean.updateComponent(Constants.IrisStromaRef, parentID, bioMightTransform);
			System.out.println("Saved IrisStroma Data!");
			System.out.println("Have Back Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
	}

}
