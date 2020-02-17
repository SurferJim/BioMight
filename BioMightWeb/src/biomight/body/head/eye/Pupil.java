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



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of a pupil
 * 
 */

public class Pupil extends EyeSenseOrgan{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	
	
	public Pupil()
	{
		create(Constants.PupilRef, null);
	}
	

	public Pupil(String parentID)
	{		
		System.out.println("Creating the Pupil: " + parentID);
		create(parentID, null);
	}

	public Pupil(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		System.out.println("Creating the Pupil: " + parentID);
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Pupil.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PupilInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PupilRef, parentID);
			System.out.println("Have Pupil Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Pupil");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Pupil NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Pupil: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create an instance of the Eye for each tranform specified for the organism
				System.out.println("Creating Eyes using ParentID: " + bioMightTransform.getId());
				eye = new Eye(bioMightTransform.getId());
				System.out.println("Eyes are created");
			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreatePupil Completed");
		
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
		System.out.println("Pupil Redraw");
		//init3D(eyeReference);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
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

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Radius:");
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
		
		// Assembe the Pupil
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Pupil.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Pupil'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Creating Pupil: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			//System.out.println("Creating Pupil at Position: " + bioMightTransform.getTranslation());
			

			int view = Constants.VIEW_FLOATING;

			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for PupilX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for PupilY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for PupilZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body = "<Transform DEF='Pupil'\n" +
			 		"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='Pupil'\n" +
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
				 	"<Sphere DEF='PupilGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"<TouchSensor DEF='StartPupil' \n" +
	                   " description='Pupil'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n"; 
			}
			else
			{
				body = "";//						
			}
		
	}
		
		//System.out.println("Pupil X3D: " + body);		
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
		System.out.println("Pupil-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			//System.out.println("Have BioMightMethod for Pupil: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the Pupil
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Pupil)) {				
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
				System.out.println("Methods have fired.   Calling Pupil Save method!");
				save();
			}
		}
	}
	
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the Pupil
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.225;
		
		System.out.println("Setting Pupil Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating Pupil Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information Pupil into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated Pupil Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the Pupil
	 * 
	 * Set the color of the Pupil
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
			System.out.println("Setting Pupil EyeColor: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
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
			
			System.out.println("Setting Pupil Color " + bioMightTransform.getName() + "  to: " + colorStr);
			
			bioMightTransform.getMaterial().setDiffuseColor(bioMightColor);
			bioMightTransform.setMaterialID(colorCode);
			// Store the updated information Pupil into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Stored Diffuse Color in transform");
		}
		
	}

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information Pupil into the database.
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
			// Get the information for the pupil we are creating
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
			int returnCode = bioMightBean.updateComponent(Constants.PupilRef, parentID, bioMightTransform);
			System.out.println("Saved Pupil Data!");
			System.out.println("Have Back Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
	}
	
	
}
