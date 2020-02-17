/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*************************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *************************************************************************************/

public class Lymphocytes  extends BioMightBase {
	private ArrayList lymphocytes;
	
		
	/********************************************************************************************************************
	 *  Lymphocytes
	 * 
	 * This method will instantiate the Lymphocytes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public Lymphocytes()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Lymphocytes
	 * 
	 * This method will instantiate the Lymphocytes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public Lymphocytes(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Lymphocytes(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Lymphocytes
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{		
		this.setImage("images/Lymphocytes.jpg");
		
		lymphocytes = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Lymphocytes Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Lymphocytes
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Lymphocytes Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LymphocyteRef, parentID);
			System.out.println("Have Lymphocytes Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Lymphocytes");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of lymphocytes and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have lymphocytes NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the lymphocyte we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Lymphocyte: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Lymphocyte for each tranform specified
			int LOD = Constants.VIEW_INTERNAL;
			Lymphocyte lymphocyte = new Lymphocyte(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Lymphocyte Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			lymphocytes.add(lymphocyte);
			System.out.println("Add Lymphocyte to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Lymphocyte, Constants.LymphocyteRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the lymphocytes
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lymphocytes);
		method.setMethodName("setColonySize");
		method.setDisplayName("Colony Size:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
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
		
		// Assemble the Lymphocytes
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Lymphocytes'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Lymphocytes - size: " + lymphocytes.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D INTERNAL for Lymphocyte: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for LymphocyteX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for LymphocyteY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for LymphocyteZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Lymphocyte'\n";
					
					
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
				}

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='Lymphocyte'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/SpeckledAmethyst.png'/>";
				
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='LymphocyteGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
	                   " description='Lymphocyte'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				
				ArrayList ranges = new ArrayList();
				BioMightPosition bioMightPosition = new BioMightPosition(0.05, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
				double nucleurRadius = bioMightTransform.getRadius()/4;
				bioMightTransform.setRadius(nucleurRadius);
			    //body += BioWebX3DUtils.generateSphereIrregular(bioMightTransform,  new double[] {bioMightPosition.getXPos(), bioMightPosition.getYPos(), bioMightPosition.getZPos()}, ranges);	

				bioMightTransform.setTextureFile("PowderBlue.png");
				bioMightTransform.setTextureID(1);
			  	body += BioWebX3DUtils.generateLymphocyte(bioMightTransform,  bioMightPosition, bioMightOrientation); 	

			    
			}
		}			
		else
		{
			// Run through the collection of Lymphocytes and assemble the X3D for each
			for (int i=0; i<lymphocytes.size(); i++)
			{
				// Get the information for the lymphocyte
				Lymphocyte lymphocyte = (Lymphocyte) lymphocytes.get(i);
				System.out.println("Getting X3D for Lymphocyte: " + lymphocyte.getComponentID());
				body += lymphocyte.getX3D(true);
			}		
		
		}
		
		
		
		body+= "<Viewpoint DEF='Viewpoint_Lymphocyte'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 3.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Lymphocytes X3D: " + body);		
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
		System.out.println("Lymphocytes-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Lymphocytes: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Lymphocytes)) {				
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
							System.out.println("After Execute Method(Integer)" + methodName);	
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
								System.out.println("After Execute Method(Double)" + methodName);
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
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("Lymphocytes - Methods have fired.   Calling Lymphocytes Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Lymphocytes.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Lymphocytes-Executing Methods: " + size);
		
		// Generate the Lymphocyte		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Lymphocyte Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			 
			
			double currentPoints[][] = null;
			int success = 0; //bioMightBean.generateLymphocytes(size, "Lymphocyte:00001", "Lymphocyte", 
				//"Lymphocyte", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Lymphocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Lymphocyte");
			throw new ServerException("Remote Exception LymphocyteEpithelium():", e); 	
		}
	}
	
}
