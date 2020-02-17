/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/******************************************************************************************
 * @author SurferJim
 *
 * This Class represents the EndoPlasmicReticulum . It contains characteristics that 
 * are common to all cells.
 * 
 *****************************************************************************************/

public class EndoPlasmicReticulumOld extends BioMightBase  {
	private EndoPlasmicReticulumRough endoPlasmicReticulumRough;
	private EndoPlasmicReticulumSmooth endoPlasmicReticulumSmooth;	
	
	
	public EndoPlasmicReticulumOld()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.EndoPlasmicReticulumRef, null);
	}

	public EndoPlasmicReticulumOld(String parentID)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null);
	}
	
	public EndoPlasmicReticulumOld(String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightMethods);
	}

	public EndoPlasmicReticulumOld(int lod, String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightMethods);
	}
	
	public EndoPlasmicReticulumOld(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightMethods);	
	}

	public EndoPlasmicReticulumOld(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightMethods);	
	}
	
	/*****************************************************************************************
	 * CREATE ENDOPLASMIC RETICULUM
	 * 
	 * Create the EndoPlasmicReticulum
	 * 
	 * ***************************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/EndoPlasmicReticulum.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		this.viewPerspective = localVP;
		this.lod = localLOD;

		
		// At this momment, there is one Cell Membrane per Cell
		if (localVP == Constants.VIEW_DETACHED)
		{	
		
		}
		// Get the data from the database
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			// Generate the EndoPlasmicReticulum based on the
			// updated parameters that were passed in through 
			// the client interface
			boolean bGenerate = true;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting EndoPlasmicReticulumInfo - HawkEye - for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.EndoPlasmicReticulumRef, parentID);
				System.out.println("Have EndoPlasmicReticulum Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - EndoPlasmicReticulum");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		
			
			// Build the membrane from its constituent components
			// Run through the collection of ---- and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have EndoPlasmicReticulum NumTransforms: " + transforms.size());
	
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the EndoPlasmicReticulum we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating EndoPlasmicReticulum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
	
				if  (localLOD == Constants.MAG1X)
				{
					// We are grabbing our data for the Cell Membrane at this level
					// It will be represented by a simple sphere

					System.out.println("Using EndoPlasmicReticulum at LOD: " + localLOD);
				}	
				else if (localLOD == Constants.MAG2X)
				{
					System.out.println("Using EndoPlasmicReticulum at LOD: " + localLOD);					
					
					System.out.println("Creating Cholesterol Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());							
					//cholesterols = new Cholesterols("Cholesterol", bioMightTransform.getId(), bioMightMethods);
					//initProperty("EndoPlasmicReticulumChloresterol", Constants.Cholesterol, Constants.CholesterolRef, cholesterols.getComponentID());	
					System.out.println("Erythrocyte - Cell Membrane is created");
				}
										
			}
		}
		
		
		//initProperties();
		initMethods();
		
		System.out.println("Create EndoPlasmicReticulum Complete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cell Membrane METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
	}
	
		
	
	public void initProperties() {		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("EndoPlasmicReticulumRough");
		property.setCanonicalName(Constants.EndoPlasmicReticulumRough);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("EndoPlasmicReticulumSmooth");
		property.setCanonicalName(Constants.Centriole);
		properties.add(property);

	}
	
	
	
	public void initMethods() {
	
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Manufacture");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Cleanse");
		method.setHtmlType("checkbox");
		methods.add(method);
		
	}

	/*******************************************************************
	 * Generate the EndoPlasmicReticulum
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SpleenEpithelium		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the EndoPlasmicReticulum: " + componentID + "    " + parentID);
			
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			
			double[] startPos = {0.250, 0.0, -0.250};
	 		double radius = 0.0045;
	 		
			System.out.println("Calling Generate EndoPlasmicReticulum: " + componentID + "    " + parentID);
				
			int success = bioMightBean.generateGolgiApparatus("EndoPlasmicReticulumEpithelium:00001", "EndoPlasmicReticulumEpithelium", 
				"EndoPlasmicReticulumEpithelium", componentID, parentID, radius, startPos);		
					
			System.out.println("Created EndoPlasmicReticulum Info using EJB");
			
		}catch (Exception e) { 
			System.out.println("Exception Generate EndoPlasmicReticulum");
			throw new ServerException("Remote Exception generateEndoPlasmicReticulum():", e); 	
		}
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the EndoPlasmicReticulum.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the EndoPlasmicReticulum
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EndoPlasmicReticulum.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EndoPlasmicReticulum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// Run through the collection of EndoPlasmicReticulums and build them into the model
			// In the default case, we get one instance of the EndoPlasmicReticulum for each Cell
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("In EndoPlasmicReticulum - Getting X3D: " + transforms.size());
		
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the sclera we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Creating EndoPlasmicReticulum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

				if (lod == Constants.MAG1X)
				{	
					//System.out.println("Getting X3D for EndoPlasmicReticulumSerousCoatX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for EndoPlasmicReticulumSerousCoatY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for EndoPlasmicReticulumSerousCoatZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='EndoPlasmicReticulumSerousCoat'\n" +
			 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape DEF='EndoPlasmicReticulumSerousCoat'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n" +
							    " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
							 	"<IndexedFaceSet DEF='EndoPlasmicReticulumSerousCoatIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='EndoPlasmicReticulumSerousCoat_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
						"</Shape>\n" +
				 "</Transform>\n"; 
				}
				else if (lod == Constants.MAG2X)
				{
					// Build from the constituent components
					System.out.println("Getting Cholesterols X3D for Cell Membrane:  " + parentID);
					body = ""; //cholesterols.getX3D(true);
					System.out.println("Have Cholesterols X3D for Cell Membrane:  " + body);
				}
			}
		}		
		else
		{
			body = "";//						
		}
		
		//System.out.println("EndoPlasmicReticulum X3D: " + body);	
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
		System.out.println("EndoPlasmicReticulum-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for EndoPlasmicReticulum: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the EndoPlasmicReticulum
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.EndoPlasmicReticulum)) {				
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
				System.out.println("Methods have fired.   Calling EndoPlasmicReticulum Save method!");
				save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the EndoPlasmicReticulum
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.5;
		
		System.out.println("Setting EndoPlasmicReticulum Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating EndoPlasmicReticulum Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information back into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated EndoPlasmicReticulum Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the EndoPlasmicReticulum
	 * 
	 * Set the color of the EndoPlasmicReticulum
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
			System.out.println("Setting EndoPlasmicReticulum EyeColor: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
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
			
			System.out.println("Setting EndoPlasmicReticulum Color " + bioMightTransform.getName() + "  to: " + colorStr);
			
			bioMightTransform.getMaterial().setDiffuseColor(bioMightColor);
			bioMightTransform.setMaterialID(colorCode);
			// Store the updated information back into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Stored Diffuse Color in transform");
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
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms for EndoPlasmicReticulum: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating EndoPlasmicReticulum Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			//System.out.println("EndoPlasmicReticulum Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
		}
		
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Saving EndoPlasmicReticulum Data");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.EndoPlasmicReticulumRef, parentID, bioMightTransform);;
			System.out.println("Have BioMight EJB");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
	}	
	
	
	

	
}
