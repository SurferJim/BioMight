/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.cocci.gramnegative;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of Gonococci
 ********************************************************************************/

public class Gonococci extends BioMightBase {
private ArrayList gonococci;

	
	/********************************************************************************************************************
	 *  Gonococci
	 * 
	 * This method will instantiate the Gonococci that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Gonococci()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Gonococci
	 * 
	 * This method will instantiate the Gonococci that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Gonococci(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Gonococci(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Gonococci
	 * 
	 * This method will instantiate the Gonococci that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/Gonococci.jpg");
		
		gonococci = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="Gonococci.x3d";

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Gonococci Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Gonococci
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Gonococci Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.GonococcusRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Gonococci");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of gonococci and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Gonococci NumTransforms: " + transforms.size());
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the gonococci we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Gonococci: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Gonococci for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			Gonococcus gonococcus = new Gonococcus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Gonococci Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			gonococci.add(gonococcus);
			System.out.println("Added gonococcus to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			String propDesc = Constants.GonococciRef + "(Neisseria gonorrhoeae) GramNegative, Diplococci, BeanShaped";
			initProperty(bioMightTransform.getName(), Constants.Gonococcus, Constants.GonococcusRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		}

		// Set up methods that will be available to the gonococci
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of GonococciMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.Gonococci);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing GonococciMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Gonococci
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
		"title='Gonococci'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		int transformCount = 0;

		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for Gonococci HawkEyeView - size: " + gonococci.size());
			
			// Run through the collection of Gonococci and assemble the X3D for each
			for (int i=0; i<gonococci.size(); i++)
			{
				// Get the information for the gonococci
				//Gonococci gonococci = (Gonococci) gonococci.get(i);
				//System.out.println("Getting X3D for Gonococci: " + gonococci.getComponentID());
				//body += gonococci.getX3D(true);
			}		
			
			body="";
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D - Hawkeye for Gonococci: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for GonococciX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for GonococciY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for GonococciZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				BioMightPosition bioMightPosition = new BioMightPosition(0.025, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
				body += BioWebX3DUtils.generateGonococci(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for Gonococci InternalView - size: " + gonococci.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for Gonococci: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for GonococciX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for GonococciY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for GonococciZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
			
				BioMightPosition bioMightPosition = new BioMightPosition(0.025, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
				body += BioWebX3DUtils.generateGonococci(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
		
			}
		}			

		
		body+= "<Viewpoint DEF='Viewpoint_Gonococci'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("Gonococci X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	


	/******************************************************************************************
	 * ANIMATE 
	 *
	 * This method will animate  the component.  The input comes in through the methods
	 * that are presented on the view.  
	 *****************************************************************************************/
	
	public String animate(String bioGroup, BioMightTransform baseTransform, int transformCount) {

		//System.out.println("In Animate() Method");
		
		BioMightPosition bioMightPosition= baseTransform.getTranslation();
		//System.out.println("Have Position");

		BioMightScale bioMightScale= baseTransform.getScale();		
		//System.out.println("Have Scale");

		BioMightOrientation bioMightOrientationStart =  new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		BioMightOrientation bioMightOrientationEnd = new BioMightOrientation("0.0, 1.0, 0.0, 0.10");
		

		//System.out.println("Performed Animate Initialization");
		
		String body = "";
		

		// If we are kicking off via a TouchSensor,add it into ths scene
		// String bioTouchSensor = "BioTouchSensor"+ numElem;
		boolean bStartByTouch = false;
		if (bStartByTouch) {
			// body +=
			// "<TouchSensor DEF='" + bioTouchSensor + "'\n" +
			// " description='Palette Touch Sensor1'\n" +
			// " containerField='children'/> \n" ;
		}
		
		
		int startTime = 0;
		int endTime = 1;
		int speed = Constants.SLOW;

		// Default it
		int duration = endTime - startTime;

		//bioGroup += "_" + transformCount;
		String bioTimer = bioGroup + "_Timer";
		body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
				+ " containerField='children'\n "
				+ " cycleInterval='" + 0.6 + "'\n "
				+ " loop='true' \n"
				+ " startTime='0.0'/> \n\n";


		//System.out.println("\n\n Setup HEADER");
		
		// Setup a Script that will set the TimeStart for each
		// of
		// the animation events.
		String bioScript = bioGroup + "_flagellaScript";
		body += "<Script DEF='" + bioScript + "'>\n";

		String bioScriptStartTime = bioGroup + "_StartTime";
		body += "<field name='flagellaScriptStartTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";


		//System.out.println("\n\n SETup START");
		
		String bioScriptEndTime = bioGroup + "_EndTime";
		body += "<field name='flagellaScriptEndTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		/*
		String bioScriptTimeVar = bioGroup + "_TimeVar";
		//body += "\n" // + "ecmascript:\n" 
				+ "function initialize_"   + bioGroup + "() {\n" 
				+ "var "
				+ bioScriptTimeVar
				+ "= new Date().getTime() + " + startTime
				+ ";\n" 
				+ bioScriptStartTime + " = "
				+ bioScriptTimeVar + ";	\n" 
				+ "}\n\n";\
		*/
		body		+= "</Script>\n\n";
		

		//System.out.println("\n\n Setup Group");
		
		String bioAnimation = bioGroup + "_Animation";

		// ***************************************************************
		// Setup the Position Interpolator to account for
		// movement
		// ****************************************************************
		body += "<PositionInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		String keys = BioGraphics.getVectorKeys(speed, 10);
		String keyVals = BioGraphics.getPositionKeyVals(speed,
				baseTransform.getTranslation(),
				baseTransform.getTranslation(), 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body += "<ROUTE fromNode='" + bioScript
				+ "' fromField='" + bioScriptStartTime
				+ "' toNode='" + bioTimer
				+ "' toField='startTime'/>\n\n"
				+ "<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup
				+ "' toField='set_translation'/>\n\n";

		// *********************************************************
		// Setup the Orientation Interpolator to account for
		// rotaton
		// **********************************************************
		bioAnimation = bioGroup + "_rotBioAnimation";
		body += "<OrientationInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		keys = BioGraphics.getVectorKeys(speed, 10);
		keyVals = BioGraphics.getRotationKeyVals(speed,
				bioMightOrientationStart,
				bioMightOrientationEnd, 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body +=
		// "<ROUTE fromNode='" + bioScript +
		// "' fromField='"+bioScriptStartTime+"' toNode='"+
		// bioTimer +"' toField='startTime'/>\n\n" +
		"<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup + "' toField='set_rotation'/>\n\n";

		// *********************************************************
		// Setup the Scale Interpolator to account for rotaton
		// **********************************************************
		bioAnimation = bioGroup + "_scaleBioAnimation";

		body += "<PositionInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		keys = BioGraphics.getVectorKeys(speed, 10);

		keyVals = BioGraphics.getScalarKeyVals(speed,
				baseTransform.getScale(),
				baseTransform.getScale(), 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body +=
		// "<ROUTE fromNode='" + bioScript +
		// "' fromField='"+bioScriptStartTime+"' toNode='"+
		// bioTimer +"' toField='startTime'/>\n\n" +
		"<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup + "' toField='set_scale'/>\n\n";
				


				if (bStartByTouch) {
					// body+=
					// "<ROUTE fromNode='"+ bioTouchSensor
					// +"' fromField='touchTime' toNode='"+ bioTimer
					// +"' toField='startTime'/>\n\n" ;
				}


		//System.out.println("\n\n In Gonnoreah Bacteria, BODY: " + body);
		return (body);
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		//System.out.println("Gonococci-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			//System.out.println("Have BioMightMethod for Gonococci: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Gonococcus)) {				
				if (!methodParam.equals(""))
				{
					//System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					//System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							//System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							//System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							//System.out.println("After Execute Method(Integer)" + methodName);	
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
								//System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								//System.out.println("After Execute Method(Double)" + methodName);
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
							//System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							//System.out.println("Method with String Param: " + methodName);
							
							//System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							//System.out.println("After Execute Method(String)" + methodName);
									
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
				//System.out.println("Gonococci - Methods have fired.   Calling Gonococci Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Gonococci.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		//System.out.println("Gonococci-SetColony Size: " + size);
		
		// Generate the Gonococci		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Generating the Gonococci Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateGonococci(size, "Gonococci:00001", "Gonococci", 
		//		"Gonococci", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Gonococci Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Gonococci");
			throw new ServerException("Remote Exception GonococciEpithelium():", e); 	
		}
	}
	
}
