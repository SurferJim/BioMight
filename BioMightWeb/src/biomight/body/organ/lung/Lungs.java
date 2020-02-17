/*
 * Created on May 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.lung;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;







import biomight.Constants;
import biomight.bacteria.misc.CoxiellaBurnetii;
import biomight.bacteria.rods.grampositive.AnthraxSpores;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/***********************************************************************************
 * @author SurferJim
 *
 * Represents a collection of right and left lung
 **********************************************************************************/

public class Lungs extends Organ {
	private ArrayList lungs;

	
	/********************************************************************************************************************
	 *  LUNGS
	 * 
	 * This method will instantiate the Lungs that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Lungs()
	{		
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LungsRef, null, null);
	}
	

	/********************************************************************************************************************
	 *  LUNGS
	 * 
	 * This method will instantiate the Lungs that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Lungs(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	/********************************************************************************************************************
	 *  LUNGS
	 * 
	 * This method will instantiate the Lungs that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public Lungs(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
	this.setImage("images/Lungs.jpg");	
	lungs = new ArrayList();	
	
	
	
	// Get the information from the database via the Enterprise Bean			
	try {
		// Get the information from the database via the Enterprise Bean		
		System.out.println("Getting Lungs Transform: " + Constants.LungsRef + "   " +  parentID);
		InitialContext ctx = new InitialContext();
		BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
		bioMightTransforms = bioMightBean.getComponents(Constants.LungRef, parentID);
		System.out.println("Have Lungs Info from EJB");   	
	}catch (Exception e) { 
		System.out.println("Exception Getting Components - Lungs");
		throw new ServerException("Remote Exception getComponents():", e); 	
	}
	
	// This is a collection, so set the parent of the children
	// to that of the aggregation object
	componentID = Constants.LungsRef + ":0";
	 
		
	// Run through the collection of Lungs and build them into the model
	// In the Default case, we get two instances of the eys, one
	// positioned on the right and one positioned on the left
	ArrayList transforms = bioMightTransforms.getTransforms();
	System.out.println("Have Lungs NumTransforms: " + transforms.size());
	for (int i=0; i<transforms.size(); i++)
	{
		// Get the information for the Lung we are creating
		BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		System.out.println("Creating Lung: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		// execute the methods against the children
		parentID = bioMightTransform.getId();  
		if (bioMightMethods != null){
			executeMethods(bioMightMethods);
		}
		
		// Create an instance of the Lung for each tranform specified for the organism
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG2X;
		Lung lung = new Lung(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
		
		System.out.println("Lung Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		lungs.add(lung);
		initProperty(bioMightTransform.getName(), Constants.Lung, Constants.LungRef, bioMightTransform.getId());		
		System.out.println("Lung Added to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

	}
	
		//initProperties();
		initMethods();		
	}
		

	
	/*********************************************************************
	 * INIT METHODS
	 * 
	 * 
	 ********************************************************************/
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lung);
		method.setMethodName("setColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lung);
		method.setMethodName("setSkin");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
	}
	
	

	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Lungs-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			System.out.println("Lung-Executing Methods: " + j);
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Lungs: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			//String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Lungs)) {				
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
							Method method = this.getClass().getMethod(methodName, paramsType);
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
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("Lung - Methods have fired.   Calling Lungs Save method!");
			}
		}
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Lungs.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Lungs
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Lungs.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Lungs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Lungs");
		
		// Run through the collection of Lungs and assemble the X3D for each
		for (int i=0; i<lungs.size(); i++)
		{
			
			// Get the information for the Lung
			Lung lung = (Lung) lungs.get(i);
			System.out.println("Getting X3D for Lung");
			body += lung.getX3D(true);
		}		
		
		
		body+= "<Viewpoint DEF='Viewpoint_Lungs'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -12.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";


		//System.out.println("Lungs X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
		
	public void onContact(Object obj)
	{
		

		if (obj instanceof AnthraxSpores)
		{
			// Contract Pulonary Antrhrax
			// It moves to the MediastinalLymphNodes 
		}

		if (obj instanceof CoxiellaBurnetii)
		{
			// QFever
		}


	}
	
		
	public void setSporeCount()
	{
	}
	
	
	/*****************************************************************************
	 * SET COLOR
	 * 
	 * Set the Color
	 * 
	 *****************************************************************************/
	public void setColor(int material) {
		System.out.println("Setting Color for: " + parentID + "  " + material);
		setMaterial(material, parentID); 
	}

	/*****************************************************************************
	 * SET SKIN
	 * 
	 * Set the Texture
	 * 
	 *****************************************************************************/
	public void setSkin(int material) {
		System.out.println("Setting Texture for: " + parentID + "  " + material);
		setTexture(material, parentID); 
	}

}
