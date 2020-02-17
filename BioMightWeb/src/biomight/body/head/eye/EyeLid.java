/*
 * Created on May 19, 2006
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
import biomight.cell.epithelial.AmacrineCell;
import biomight.cell.neuron.BiPolarCell;
import biomight.cell.neuron.HorizontalCell;
import biomight.cell.neuronglial.GanglionicCell;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of an EyeLid
 * 
 */

public class EyeLid  extends BioMightBase {
	private BioMightTransform bioMightTransform;
	protected int viewPerspective;	
	
	protected EpitheliumTissue epithelium;
	
				
	public EyeLid()
	{		
		// Create hte base EyeLidLid
		create(Constants.EyeLidRef, null);
	}
	
	
	public EyeLid(String parentID)
	{				
		create(parentID, null);	
	}
	

	public EyeLid(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}
	
	
	/************************************************************************************
	 * 
	 * CREATE EYE
	 * @param eyeReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/LeftEyeLid.jpg");
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE EYELID METHODS: " + bioMightMethods.size());
			}
			
			componentID=parentID;
			// Generate the EyeLid Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			epithelium = new EpitheliumTissue("EyeLidEpithelium", parentID, bioMightMethods);
			System.out.println("EyeLid Epithelium completed for ForeArm: " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {

		}

		initProperties();
		initMethods();
	
	}
	
	
	/****************************************************
	 * GENERATE EYELID
	 * 
	 * Under normal conditions, there will be four eyelids on the
	 * human animal model
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the EyeLid		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the EyeLid Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double circumference = 0.200;
			double radius = 0.100;
			
			// Left Upper EyeLid
			if (componentID.equals("EyeLid:01")) {
				
				// Generate the Palm
				double[] startPos = {0.25, 0.5, 0.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	
	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-radius},
	    		   		{x-circumference,     y, z-radius*2},
	    		   		{x,                   y, z-radius*3},
	    		   		{x+circumference,     y, z-radius*3},
	    		   		{x+(circumference*2), y, z-radius*2},
	    		   		{x+(circumference*2),     y, z-radius},
	    		   		{x+circumference, y, z}
	    		   		};
					
				
				int success = bioMightBean.generateEyeLid("EyeLidEpithelium:00001", "EyeLidEpithelium", 
						"EyeLidEpithelium", componentID, currentPoints);			
				
			}
			// Left Lower EyeLid
			else if (componentID.equals("EyeLid:02"))
			{
				// Generate the Elbow
				double[] startPos = {0.25, -0.5, 0.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 

	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-radius},
	    		   		{x-circumference,     y, z-radius*2},
	    		   		{x,                   y, z-radius*3},
	    		   		{x+circumference,     y, z-radius*3},
	    		   		{x+(circumference*2), y, z-radius*2},
	    		   		{x+(circumference*2),     y, z-radius},
	    		   		{x+circumference, y, z}
	    		   		};
						
				
				int success = bioMightBean.generateEyeLid("EyeLidEpithelium:00080", "EyeLidEpithelium", 
					"EyeLidEpithelium", componentID, currentPoints);			
			}
			// Upper Right EyeLid
			else if (componentID.equals("EyeLid:03"))
			{
				// Generate the Elbow
				double[] startPos = {-0.25, 0.5, 0.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];

	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-radius},
	    		   		{x-circumference,     y, z-radius*2},
	    		   		{x,                   y, z-radius*3},
	    		   		{x+circumference,     y, z-radius*3},
	    		   		{x+(circumference*2), y, z-radius*2},
	    		   		{x+(circumference*2),     y, z-radius},
	    		   		{x+circumference, y, z}
	    		   		};
					
				
				int success = bioMightBean.generateEyeLid("EyeLidEpithelium:00160", "EyeLidEpithelium", 
					"EyeLidEpithelium", componentID, currentPoints);			
			}
			else if (componentID.equals("EyeLid:04"))
			{
				// Generate the Elbow
				double[] startPos = {-0.25,-0.5, 0.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 

	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-radius},
	    		   		{x-circumference,     y, z-radius*2},
	    		   		{x,                   y, z-radius*3},
	    		   		{x+circumference,     y, z-radius*3},
	    		   		{x+(circumference*2), y, z-radius*2},
	    		   		{x+(circumference*2),     y, z-radius},
	    		   		{x+circumference, y, z}
	    		   		};
				
				
				int success = bioMightBean.generateEyeLid("EyeLidEpithelium:00240", "EyeLidEpithelium", 
					"EyeLidEpithelium", componentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate EyeLidEpithelium NoParent");

				// Generate the Elbow
				double[] startPos = {-3.75,-25.0,0.5};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 

	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-radius},
	    		   		{x-circumference,     y, z-radius*2},
	    		   		{x,                   y, z-radius*3},
	    		   		{x+circumference,     y, z-radius*3},
	    		   		{x+(circumference*2), y, z-radius*2},
	    		   		{x+(circumference*2),     y, z-radius},
	    		   		{x+circumference, y, z}
	    		   		};
				
				
				int success = bioMightBean.generateEyeLid("EyeLidEpithelium:00320", "EyeLidEpithelium", 
					"EyeLidEpithelium", componentID, currentPoints);
			}

			
			System.out.println("Created EyeLidEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - EyeLidEpithelium");
			throw new ServerException("Remote Exception EyeLidEpithelium():", e); 	
		}
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("MedialCommissure");
		property.setCanonicalName(Constants.MedialCommissure);
		properties.add(property);

	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuspensoryLigament");
		property.setCanonicalName(Constants.SuspensoryLigament);
		properties.add(property);

	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();


		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Pupil Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Winks per minute:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		
		method = new BioMightMethodView();
		method.setMethodName("Tear");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Wink");
		method.setHtmlType("checkbox");
		methods.add(method);	

	}
	

	
	public void redraw(int parentID)
	{
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {

			System.out.println("EyeLid Redraw");
		} 
			
		this.setImage("images/LeftEyeLid.jpg");
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the EyeLid.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the EyeLid
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EyeLid.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EyeLid'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		int view = Constants.VIEW_FLOATING;
		String body = "";
		if (view == Constants.VIEW_FLOATING)
		{
			System.out.println("Getting composite X3D for eye");
			body = 				
				epithelium.getX3D(true) 
				;
		}
		else
		{
		body = "";
			/*

			*/
		}	
		//System.out.println("EyeLid X3D: " + body);		
		
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
		System.out.println("HEAD-Executing Methods");
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
	
	

	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}	
	
}
