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

import javax.naming.Context;
import javax.naming.InitialContext;



import biomight.Constants;
import biomight.body.BodyPart;
import biomight.chemistry.protein.Fibrin;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.ReticularConnectiveTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UpperEyeLid extends EyeLid {
	BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;

	private EpitheliumTissue epithelium;
	

	public UpperEyeLid()
	{
		create(Constants.UpperEyeLidRef, null);
	}

	public UpperEyeLid(String parentID)
	{
		create(parentID, null);
	}
	
	public UpperEyeLid(String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		create(parentID, bioMightMethods);
	}


	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/EyelidLower.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting UpperEyeLidInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.UpperEyeLidRef, parentID);
			System.out.println("Have UpperEyeLid Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - UpperEyeLid");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}		
		// Run through the collection of UpperEyeLid and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have UpperEyeLidInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the UpperEyeLid we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating UpperEyeLid (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			epithelium = new EpitheliumTissue("EyeLidEpithelium", bioMightTransform.getId(), bioMightMethods);
			//epithelium.setComponentType("UpperEyeLidEpithelium");
			System.out.println("UpperEyeLid Epithelium completed");		
			
			/*int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("Iris Eye is created");
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
			*/
		}		
	
		initProperties();
		initMethods();
		
		System.out.println("Create UpperEyeLid Completed: " + parentID);
	
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING UpperEyeLid METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	
	}	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
	}
	
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioText);
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
	
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("UpperEyeLid-Executing Methods");
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
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the UpperEyeLid.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the UpperEyeLid
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='UpperEyeLid.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='UpperEyeLid'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		int view = Constants.VIEW_FLOATING;
		String body = "";
		if (view == Constants.VIEW_FLOATING)
		{
			System.out.println("Getting X3D for eyelid");
			
		
			BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
			BioMightPosition bioMightScale = new BioMightPosition(1.0, 1.0, 1.0);
			
			body = "<Transform DEF='LargeUpperEyeLid'\n" +
			"translation='" + bioMightPosition.getXPos() + " " 
 					+ bioMightPosition.getYPos() + " "
 					+ bioMightPosition.getZPos() + "'\n" +
 			"scale='" 	+ bioMightScale.getXPos() + " "
 					+ bioMightScale.getYPos() + " "
 					+ bioMightScale.getZPos() + "'>\n" 
 					+ epithelium.getX3D(true) + 		
		
 			"<TimeSensor DEF='BlinkTimer'\n" +
 				" containerField='children'\n " +
 				" cycleInterval='1.000'\n " + 
 				" loop='false' \n" +
 				" startTime='-1.000'/> \n" +
 			"<TouchSensor DEF='StartBlinkTimer' \n" +
 				" containerField='children'/> \n" +
 		"</Transform>\n" +
 		
 		"<PositionInterpolator DEF='BlinkAnim'\n" + 
 		"key='0 .5 1 1.5'\n" +
 		"keyValue='1 1 1.0  1 1 1.05   1 1 1.10   1 1 1.15'/>\n" + 
 		"<ROUTE fromNode='StartBlinkTimer' fromField='touchTime' toNode='BlinkTimer' toField='startTime'/>\n" +
 		"<ROUTE fromNode='BlinkTimer' fromField='fraction_changed' toNode='BlinkAnim' toField='set_fraction'/>\n" +
 		"<ROUTE fromNode='BlinkAnim' fromField='value_changed' toNode='LargeUpperEyeLid' toField='set_scale'/>\n";
			
			
			
			
		}
		else
		{
			body = "";
		}	
		//System.out.println("UpperEyeLid X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

}
