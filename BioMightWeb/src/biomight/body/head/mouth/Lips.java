/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.head.mouth.Lip;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.skull.cranial.CranialBones;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 *  Representation of the Lips
 */

public class Lips extends BioMightBase {
	//private UpperLip upperLip;
	//private LowerLip lowerLip;
	private Lip lip;
	private ArrayList lips;
	
	// Define the base points that comprise the lip.  These are
	// used by an algorithm to create a variety of lips.
	private BioMightPosition upperLipStartApex;
	private BioMightPosition upperLipStartBase;

	private BioMightPosition upperLipLeftMidPoint;
	private BioMightPosition upperLipRightMidPoint;
	
	private BioMightPosition upperLipLeftEndPoint;
	private BioMightPosition upperLipRightEndPoint;
	
	// Coordinates that define the lower lip
	private BioMightPosition lowerLipStartApex;
	private BioMightPosition lowerLipStartBase;

	private BioMightPosition lowerLipLeftMidPoint;
	private BioMightPosition lowerLipRightMidSPoint;
	
	private BioMightPosition lowerLipLeftEndPoint;
	private BioMightPosition lowerLipRightEndPoint;
	
	
	
	public Lips()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LipsRef, null, null);
	}

	public Lips(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Lips(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Lips Create");
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
		lips = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
				
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LipsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LipRef, parentID);
			System.out.println("Have Lips Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Get the collection of Lips from the database.  
		componentID = componentID;
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through the collection of Lips and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Lips NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Lip: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			componentID = bioMightTransform.getId();
			
			// Create an instance of the Lip for each tranform specified for the organism
			Lip lip = new Lip(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);			
			System.out.println("Lip Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			lips.add(lip);
			//String tempID = lip.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Lip, Constants.LipRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the lips
		initMethods();
	}

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Upper Lip");
		property.setCanonicalName(Constants.UpperLip);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Lower Lip");
		property.setCanonicalName(Constants.LowerLip);
		properties.add(property);
	}
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Kiss");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Pucker");
		method.setHtmlType("Checkbox");
		methods.add(method);	
	}	
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Lips.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Lips
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Lips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Lips'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = ""; 
	
		// Run through the collection of lips and assemble the X3D for each
		for (int i=0; i<lips.size(); i++)
		{
			
			// Get the information for the lip
			Lip lip = (Lip) lips.get(i);
			body += lip.getX3D(true);
		}			
		
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
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("LIPS-Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {

					String methodName = (String) methods.get(j).getMethodName(); 
					String htmlType = (String) methods.get(j).getHtmlType();
					String dataType = (String) methods.get(j).getDataType();
					System.out.println("Execute Method " + methodName + " Arg: "  +  methodParam);
					System.out.println("HtmlType " + htmlType + " with DataType: "  +  dataType);
										
					// Use the DataType parameter to convert the data into its base form
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// Locate the method through introspection
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
					
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + method.getName());
							
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(Integer)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred!");						
						}	
						
					}
				
					else if (dataType.equals("double")) {
						
					}
					else if (dataType.equals("")) {
						
					}			
				}
			}
		}
	}
	
	
	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CHEW"))
		{
			// Send a message to the brain
			
			// Start Digestion
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("SWALLOW"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("SPIT"))
		{
			// Send a message to the brain
			// Start Digestion 
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("EXPOSE TONGUE"))
		{
			// Send a message to the brain
			// Start Digestion 
		}	
			
	}

	
	/*****************************************************************************
	 * SET COLOR
	 * 
	 * @param color
	 * 
	 *****************************************************************************/
	public void setLipColor(String color) {

		int numColor = 1;
		
		String tempColor = color.toUpperCase();
		if (tempColor.equals("BLUE"))
			numColor=1;
		else if (tempColor.equals("GREEN"))
			numColor=2;
		else if (tempColor.equals("RED"))
			numColor=3;
		else if (tempColor.equals("BROWN"))
			numColor=4;		
		else if (tempColor.equals("HAZEL"))
			numColor=5;		
	
	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.setMaterial(Constants.LipsRef, parentID, numColor);
			System.out.println("Have Back Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

	}

	
	public void Ingest()
	{
		// This is the first step of digestion, 
		// placing food in one's mouth
	}

	public void Chew()
	{
		// Mastication
	}


	public void Salivate()
	{
		
	}


}
