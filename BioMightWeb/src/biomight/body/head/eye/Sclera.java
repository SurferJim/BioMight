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
import biomight.cell.epithelial.AmacrineCell;
import biomight.cell.neuron.BiPolarCell;
import biomight.cell.neuron.HorizontalCell;
import biomight.cell.neuronglial.GanglionicCell;
import biomight.chemistry.protein.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.tissue.connective.*;
import biomight.system.tissue.connective.*;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
 
 /*
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
public class Sclera extends EyeSenseOrgan{
	private BioMightTransforms bioMightTransforms;
	private BioMightSphere bioMightSphere1;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private Fibrin fibrin;
	private ReticularConnectiveTissue reticularConnectiveTissue;
	private String componentID;
	private String parentID;
	
	public Sclera()
	{

		createSclera(Constants.ScleraRef, null);
	}

	
	public Sclera(String parentID)
	{
		createSclera(parentID, null);
	}
	
	public Sclera(String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		createSclera(parentID, bioMightMethods);
	}
	
	
	public void createSclera(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Sclera.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ScleraInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ScleraRef, parentID);
			System.out.println("Have Sclera Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Sclera");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Sclera: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateSclera Complete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING SCLERA METHODS: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
	}
	
	
	
	public void redraw(int eyeReference)
	{
		System.out.println("Sclera Redraw");
		init3D(eyeReference);
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	
	/***************************************************************************
	 * Initialize the Iris in 3D
	 * 
	 * @param position
	 **************************************************************************/
	public void init3D(int eyeReference) {
		

	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Sclera
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Sclera.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Sclera'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		
		// Run through the collection of Scleras and build them into the model
		// In the default case, we get one instance of the Sclera for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the sclera we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Creating Sclera: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
	
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
			//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
			//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
			//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
			// Change the height and width based on the displacement.
			body = "<Transform DEF='Sclera'\n" +
		 		"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
			 	"<Shape DEF='Sclera'\n" +
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
			 	"<Sphere DEF='ScleraGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n"; 
		}
		else
		{
			body = "";//						
		}
		
		}
		//System.out.println("Sclera X3D: " + body);	
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
		System.out.println("Sclera-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Sclera: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the Sclera
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Sclera)) {				
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
				System.out.println("Methods have fired.   Calling Sclera Save method!");
				save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the Sclera
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.5;
		
		System.out.println("Setting Sclera Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating Sclera Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information Sclera into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated Sclera Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the Sclera
	 * 
	 * Set the color of the Sclera
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
			System.out.println("Setting Sclera EyeColor: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
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
			
			System.out.println("Setting Sclera Color " + bioMightTransform.getName() + "  to: " + colorStr);
			
			bioMightTransform.getMaterial().setDiffuseColor(bioMightColor);
			bioMightTransform.setMaterialID(colorCode);
			// Store the updated information Sclera into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Stored Diffuse Color in transform");
		}
		
	}

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information Sclera into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms for Sclera: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating Sclera Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			//System.out.println("Sclera Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
		}
	
		
		// Save the data
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			System.out.println("Saving Sclera Data");
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			System.out.println("Saved Sclera Data!");
			int returnCode = bioMightBean.updateComponent(Constants.ScleraRef, parentID, bioMightTransform);
			System.out.println("Have Back Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
	}

	
}
