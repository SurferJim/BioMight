/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.carbohydrate.monosaccharide.pentose;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphicsDNA;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/***************************************************************************
 * @author SurferJim
 *
 * Representation for Riboses
 * 
 ***************************************************************************/

public class Riboses extends BioMightBase {
private ArrayList riboses;

	
	/********************************************************************************************************************
	 *  RIBOSES
	 * 
	 * This method will instantiate the Riboses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Riboses()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.RibosesRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  RIBOSES
	 * 
	 * This method will instantiate the Riboses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Riboses(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Riboses(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public Riboses(String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public Riboses(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE RIBOSES
	 * 
	 * This method will instantiate the Riboses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		this.setImage("images/Riboses.jpg");
		
		riboses = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Riboses Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Riboses
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Riboses Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RiboseRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Riboses");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of riboses and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Riboses NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the ribose we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Ribose: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Ribose for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			Ribose ribose = new Ribose(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Ribose Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			riboses.add(ribose);
			System.out.println("Add Ribose to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Ribose, Constants.RiboseRef, bioMightTransform.getId());				
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the riboses
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Riboses);
		method.setMethodName("setDNA");
		method.setDisplayName("DNA:");
		method.setDataType(Constants.BIO_TEXT);
		method.setHtmlType("text");
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
		double angle = 0;
		
		// Assemble the Riboses
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
		"title='Riboses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Riboses - size: " + riboses.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Ribose we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for Ribose at LOD (0): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for RiboseX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for RiboseY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for RiboseZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += getLocalX3DZ(bioMightTransform, angle);
				angle = angle + 10;
			}
		}			
		else
		{
			// Run through the collection of Riboses and assemble the X3D for each
			for (int i=0; i<riboses.size(); i++)
			{
				// Get the information for the ribose
				Ribose ribose = (Ribose) riboses.get(i);
				System.out.println("Getting X3D for Ribose: " + ribose.getComponentID());
				body += ribose.getX3D(true);
			}		
		
		}
		
		
		//System.out.println("Riboses X3D: " + body);		
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
		System.out.println("DNAs-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for DNAs: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
		
			if (canonicalName.equals(Constants.Riboses)) {				
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
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
						try {
							System.out.println("Locating Method(BIOTEXT)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with BIOTEXT Param: " + methodName);
							
							System.out.println("Before Execute Method(BIOTEXT)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(BIOTEXT)" + methodName);
									
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
				System.out.println("DNAs - Methods have fired.   Calling DNAs Save method!");
			}
		}
	}



	/********************************************************************************************************************
	 * GET LOCAL X3D
	 * 
	 * This method will return the X3D for the Riboses.  Each Ribose record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getLocalX3DZ(BioMightTransform bioMightTransform, double angle) 
	{

		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("Riboses.getLocalX3DZ()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double circumference = 0.25;
		String body = BioGraphicsDNA.getRibose(bioMightTransform, circumference, angle);
	
		//body += BioGraphicsDNA.getPhosphate(bioMightTransform, circumference, angle);
					
		//body += BioGraphicsDNA.getPentose(bioMightTransform, circumference, angle);
		
		//body += BioGraphicsDNA.getHexose(bioMightTransform, circumference, angle);
				
		return (body);
	}

	
		
}
