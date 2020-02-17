package biomightweb.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomightweb.util.User;
import biomightweb.view.BioMightComponent;


/*******************************************************************************************************
 * The Action is associated with BioMightView page.  It determines what component will appear
 * on the web page.   
 * 
 * SurferJim
 ******************************************************************************************************/

public class BioMightGlobeAction extends ActionSupport implements SessionAware, ServletRequestAware, ParameterAware {
	private Map<String, Object> session;
	private HttpServletRequest request;
	private Map pMap;
	
	// This is what we are looking at
	private BioMightComponent bioMightComponent;
			
	// Store the Core fields directly here in the Palette Action as there
	// is only one instance per person per request.   It comes and goes
	private String bioMightProjectID = "";
	private String bioMightProjectName = "";
	private String pageAction = "";	
	private boolean resizeableObject = false;
	

	/****************************************************************************
	 * EXECUTE
	 * 
	 * Process the form
	 * 
	 ***************************************************************************/
	public String execute() throws Exception
	{
		System.out.println("\n\n----In BioMightViewAction");	
		User user = (User) session.get("User");
		//System.out.println("----In BioMightViewAction- Have user and session");
			
		// The user has posted the their selection.  The framework brings this into 
		// ViewAction class.  Values are hidden fields in the presentation layer 
		// and will instantiate and pre-populate the object
		System.out.println("ComponentID: |" + bioMightComponent.getBioMightComponentID() + "|");
		System.out.println("ComponentName: |" + bioMightComponent.getBioMightComponentName() + "|");
		System.out.println("ComponentType: |" + bioMightComponent.getBioMightComponentType()+ "|");
		System.out.println("ComponentRef: |" + bioMightComponent.getBioMightComponentRef() + "|");
		System.out.println("ParentID: |" + bioMightComponent.getBioMightComponentParentID() + "|");
		System.out.println("BuildComponentType: |" + bioMightComponent.getBioMightBuildComponentType()+ "|");
		System.out.println("CollectionInfo: |" + bioMightComponent.isBioMightCollection() + "|");
		System.out.println("ProjectName: |" + getBioMightProjectName() + "|");
		dumpMethods();
		
		// If there is nothing defined in the form, then set everything to the
		// base instance.  When we have a component ID this implies that an object
		// has been selected via the interface - otherwise we are getting the
		// base model/models
		//  MOVE TO INTERCEPTOR 
		if (bioMightComponent.getBioMightComponentID().equals("") || bioMightComponent.getBioMightComponentName().equals("")) {
			System.out.println("Error ----- No BioMight Component Selected!");
			return "success";
		}
		
		//bioMightForm.getBioMightComponentParentID();
		// Level of Detail will be passed into the constructor 
		int LOD = Constants.BIO_PARENT;
		int hierarchy = 0;
			
		boolean bChildren = false;
		boolean bCull = false;
		boolean bNewest = false;
		
		// If this is a Collection we need to carry down the
		// aggregates parent ID as it the childs real parent 
		if (bioMightComponent.isBioMightCollection())
		{
			// If we are drilling down from the Library view, we do not want
			// to see all the elements.  We want to cull the result set to one
			// Set a flag so that we will cull when the actual component is called
			System.out.println("Collection: Setting Parent: " + bioMightComponent.getBioMightComponentParentID() + " to " + bioMightComponent.getBioMightComponentID());
			
			if (bioMightComponent.getBioMightComponentID().equals("Cells:0")){
				//	System.out.println("Culling the Cells: " + bioMightComponent.getBioMightComponentParentID());
				//	bCull=true;
			}
			else if (bioMightComponent.getBioMightComponentID().equals("BioSymbols:0")){
				System.out.println("Culling the Symbols: " + bioMightComponent.getBioMightComponentParentID());
				//bCull = true;
			}
			else if (bioMightComponent.getBioMightComponentID().equals("BioAssemblies:0")){
				//System.out.println("Culling the Symbols: " + bioMightComponent.getBioMightComponentParentID());
				//bCull = true;
			}			
			System.out.println("Collection: Setting Parent: " + bioMightComponent.getBioMightComponentParentID() + " to " + bioMightComponent.getBioMightComponentID());
			bioMightComponent.setBioMightComponentParentID(bioMightComponent.getBioMightComponentID());
		}
		

		String propertyTitle = "";

		//********************************************************************
		// We are executing a method.  Get the parameters from the form
		// map the data into the components property and method objects
		// There are sent into the component to set the properties and
		//to eecute methods.
		//********************************************************************
		
		if (pageAction.equals("bioProcess"))
		{
			System.out.println("View Action - BioProcess - Passing Data to ExecuteMethods ---");	
		}
		else if (pageAction.equals("bioExplore"))
		{
			// The user selected the component's hyperlink
			// Drill into the Component 
			//System.out.println("ViewAction - BioExplore - Going to SubComponent");	
		}
		else if (pageAction.equals("expand"))
		{
			propertyTitle = bioMightComponent.getBioMightComponentName();
			System.out.println("Expand Property: " +  bioMightComponent.getBioMightComponentName());
		}
		
		else if (pageAction.equals("collapse"))
		{
			//propertyTitle = bioMightForm.getPropertyTitle();
			propertyTitle = bioMightComponent.getBioMightComponentName();
			System.out.println("Coillapsing Property: " +  propertyTitle);			
		}
		else if (pageAction.equals(""))
		{
			// Go back to the frame into which we are 
			// inserting the new object configuration
			System.out.println("In Action - PageAction not SET ");
			//String bioMightObjectName = (String) session.getAttribute("bioMightObjectName");	
			//System.out.println("Session - BioMightObject: " + bioMightObjectName);
		}					


		// If we are executing data in the form then we want to use the 
		// Property and Methods data that was submitted
		if (!pageAction.equals("bioProcess"))
		{
			// Clear the Properties and Methods as we are not going to be processing anything
			//System.out.println("No BioProcess - Clearing Methods and Properties");
			ArrayList tempProperties = new ArrayList(0);
			ArrayList tempMethods = new ArrayList(0);
			bioMightComponent.setBioMightMethods(tempMethods);
			bioMightComponent.setBioMightProperties(tempProperties);
		}
		else
		{
			// Use the Properties and Methods data as we are processing 
			//System.out.println("Performing BioProcess - Keeping Methods and Properties: ");
			//bioMightComponent.dumpProperties();
		}
		
		// Set Default Size
		bioMightComponent.setWidth(320);
		bioMightComponent.setHeight(500);
		
		// Declare the base and configuration classes
		Class bioMightClass = null;
		
		// Class bioMightConfigClass = null;
		Object bioMightInstance = null;
					
		// All objects in the palette should be generated as snippets
		// they will be combines into 1 world scene
		boolean snippet = true;
	
		// Get the BioMightKeys from the session.  The Keys keep track of the current 
		// linear path that one has taken.  The keys are stored in a hashmap and are 
		// labeled 1,2,3....n
		BioMightKeys bioMightKeys = (BioMightKeys) session.get("bioMightKeys");
		// Set up a holder for the current key
		BioMightKey bioMightKey;
		
		// If the keys are not defined, then this is the
		// first time in.  Set up the keys with the default values
		if (bioMightKeys == null)
		{	
			bioMightKeys = new BioMightKeys();
			bioMightKey = new BioMightKey();
			//System.out.println("Keys are null - Creating Keys");	
		}
		else
		{
			//System.out.println("There are Keys!");								
			//System.out.println("Parent for : " + bioMightComponent  + "   is: " + bioMightComponent.getBioMightComponentParentID());
			bioMightKey = new BioMightKey();			
		}

		// Use the Current Object posted through the form to reset
		// the objects.  If they match everything is fine
		// otherwise reset the page using the session information
		//bioMightKey = bioMightKeys.getKey(bioMightComponentRef);
		//if (bioMightKey != null) 
		//{
		//	System.out.println("BioMight Key is not null");												
		//}
		//else
		//{
		//	System.out.println("Key for Component not Found! - Creating new key");	
		//	// Create a new Key to represent this object				
		//	bioMightKey = new BioMightKey();
		//	bioMightKey.setComponentName(bioMightComponent.getBioMightComponentName());	
		//}			
			
		// Create the Real Object - send in the Property and Method Data
		try
		{			
			System.out.println("Creating Component with ParentID: " + bioMightComponent.getBioMightComponentParentID());			

										
			// Create a Class Object the represents the biomight object
			System.out.println("Doing ClassForName: " + bioMightComponent.getBioMightComponentRef());
			
			bioMightClass = Class.forName(bioMightComponent.getBioMightComponentRef());
			System.out.println("Created BioMight Class of Type: " + bioMightComponent.getBioMightComponentType());
			if (bioMightClass == null)
				System.out.println("BioMight Class is null: " + bioMightComponent.getBioMightComponentParentRef());				
			else
				System.out.println("Class is cool: " + bioMightClass.getName());
			
			// Create an instance of the class
			// The class will start up using it last persistent model
			//bioMightInstance = bioMightClass.newInstance();
			System.out.println("Creating BioMight Instance: " + bioMightComponent.getBioMightComponentRef());			
			Constructor constructor = null;
	       	

			// These will come from the user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
			int localVP = Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			
			System.out.println("Action---Creating BioInstance compParentID: " + bioMightComponent.getBioMightComponentParentID());
			// Only grab the parent record as we arenot going deep
			constructor = bioMightClass.getConstructor(new Class[] {int.class, int.class, new String().getClass(), new ArrayList().getClass(), new ArrayList().getClass() });
			//System.out.println("Creating Constructor: " + bioMightComponent.getBioMightComponentParentID());
			bioMightInstance = constructor.newInstance(new Object[] {localVP, localLOD, bioMightComponent.getBioMightComponentParentID(), bioMightComponent.getBioMightProperties(), bioMightComponent.getBioMightMethods()});					

			
			System.out.println("Created BioMight Instance: " + bioMightComponent);		
			}
		catch (ClassNotFoundException e) 
		{
			System.out.println("!!!BioMight Object not found: " + e.toString());
		}
		
		
		// Store the keys that use track where one is
		bioMightComponent.setBioMightKeys(bioMightKeys);
		
		//***********************************************************
		// MAP IT - Send it to Mapper to place into BioMight object
		//***********************************************************
		//System.out.println("Doing Mapping!");			
		BioMightViewMapper bioMightViewMapper = new BioMightViewMapper();
		bioMightComponent = bioMightViewMapper.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		//System.out.println("Done Mapping!");			
		
		// Put the Keys back  in the session
		System.out.println("Storing BioMight Keys in session!");
		session.put("bioMightKeys", bioMightKeys);
		
			
		/***********************************************************************************
		 *  Now that we have the object instantiated, let's do some useful work with it
		 *  
		 ***********************************************************************************/
		
		System.out.println("BioMightView Component is: " + bioMightComponent.getBioMightComponentType());
		System.out.println("BioMightView Image is: " + bioMightComponent.getImage());
		
		// Turn off the properties in the view that the user has decided not to display
		if (!propertyTitle.equals("") && pageAction.equals("collapse")) 
			bioMightComponent.collapseProperties(propertyTitle);

		// Turn off the properties in the view that the user has decided not to display
		if (!propertyTitle.equals("") && pageAction.equals("expand")) 
			bioMightComponent.expandProperties(propertyTitle);
				
		
		/***********************************************************************************
		 *  Load the dropdown data into DropDownBeans that are used by Struts to load
		 *  the dropdown lists in the Web Interface.  The data comes from the currently
		 *  instantiated BioMight Component.  Load the data into a stripped down method
		 *  object and store in the Session
		 ***********************************************************************************/

		/**********************************************
		ArrayList methods = bioMightView.getMethods();
		bioMightMethods = new ArrayList();
		DropDownBean dropDownBean = new DropDownBean();
		int k=0;
		if (methods != null)
		{	
			BioMightMethodView methodView;
			for (int i=0; i<methods.size(); i++)
			{
				methodView = (BioMightMethodView) methods.get(i);
				System.out.println("Loading WebPage Methods: " + methodView.getMethodName());
				
				// Create the Method Object from Method View
				BioMightMethodView bioMightMethod = new BioMightMethodView();  
				bioMightMethod.setMethodName(methodView.getMethodName());
				bioMightMethod.setCanonicalName(methodView.getCanonicalName());
				bioMightMethod.setDataType(methodView.getDataType());
				bioMightMethods.add(i,bioMightMethod);
				
				if (methodView.getHtmlType().equals("dropdown"))					
				{
					// We are procesing a drop-down.  Get the pairs
					ArrayList dropDownValues = methodView.getDropDownValues();
					if (dropDownValues != null)
					{
						// Run through the DropDownPairs that are defined for the objects
						// methods and store them into the DropDownBean
						for (int j=0; j<dropDownValues.size(); j++)
						{
							DropDownPair ddPair = (DropDownPair) dropDownValues.get(j);
							//System.out.println("Loading PickList: " + ddPair.getLabel() + "  " + ddPair.getValue());
						}
						// Stuff the ArrayList of DropDownPairs into the DropDeanBean
						//System.out.println("Setting Picklist in DDBean at pos: " + k);
						dropDownBean.setPicklist(k, dropDownValues);
						k++;
					}
				}
			}
		
		}	
		****************************/
		
		//System.out.println("Storing the DropDownBean in the RequestObject...");
		//request.setAttribute("ddBean", dropDownBean);		
		//session.put("bioMightMethods", bioMightMethods);		

		
		//dumpProperties()
		writeX3D();


	
		/**
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Storing Palette Info");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int status = bioMightBean.addComponentHistory(bioMightView.getBioMightComponentID(), bioMightView.getBioMightComponentName(), bioMightView.getBioMightComponentName(),  bioMightView.getBioMightComponentParentID(), X3D) ;
		    
			System.out.println("Stored Palette Object");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Iris");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		**/
		 
		
		// Store the view in the request so that it can be
		// grabbed in the JSP and be displayed.   We are going to be
		// Streaming the data into the HTML page directly
					
		return "success";
	}

	
	
	
	
	/******************************************************************************************************************
	 * Dump Properties
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public void dumpProperties() 
	{
		System.out.println("Confirming Properties...");
		if (bioMightComponent.getBioMightProperties() != null)
		{	
			BioMightPropertyView propertyView;
			for (int i=0; i<bioMightComponent.getBioMightProperties().size(); i++)
			{
				propertyView = (BioMightPropertyView) bioMightComponent.getBioMightProperties().get(i);
				System.out.println("Loading WebPage Property: " + propertyView.getCanonicalName());
				System.out.println("Loading WebPage Property: " + propertyView.getPropertyName());
			}
		
		}	
	
	}

	
	/******************************************************************************************************************
	 * Dump Methods
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public void dumpMethods() 
	{
		
		if (bioMightComponent.getBioMightMethods() != null && bioMightComponent.getBioMightMethods().size() > 0)
		{
			System.out.println("Methods Are-----");
			
			for (int i=0; i<bioMightComponent.getBioMightMethods().size(); i++)
			{
				BioMightMethodView methodView = (BioMightMethodView) bioMightComponent.getBioMightMethods().get(i);
				System.out.println("Name: " + methodView.getMethodName());
				System.out.println("DisplayName: " + methodView.getDisplayName());
				System.out.println("CanonicalName: " + methodView.getCanonicalName());
				System.out.println("Parameter: " + methodView.getMethodParameter());
				System.out.println("HtmlType: " + methodView.getHtmlType());
				System.out.println("DataType: " + methodView.getDataType());
			}
		}	
		else
			System.out.println("No Methods Are Defined");
	
	}
	
	
	/****************************************************************************************************************************
	 * WRITE X3D
	 * 
	 * Write the X3D to the OS file system
	 * 
	 ****************************************************************************************************************************/
	
	private int writeX3D() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String exportDate = dateFormat.format(date);
		
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		date = new Date();
		String exportTime = dateFormat.format(date);
		
		// Assemble the World Scene
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Body.jpg'/>\n" +
		 "<meta name='ExportTime' content='" +  exportTime +  "'/>\n" +
		 "<meta name='ExportDate' content='" + exportDate  +  "'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Body'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";
		
		String body = bioMightComponent.getX3D();			
		
		String footer = "</Scene>" + "</X3D>\n";
		
		
		// Set up the ViewPoint - we can have multiple viewpoints per
		// scene
		String bioViewPointGroup = "bioViewPointGroup1";
		body += "\n\n<Transform DEF='" + bioViewPointGroup + "'>\n";

		double fieldOfView = 0.57;
		BioMightPosition bioMightCameraPos = new BioMightPosition("0.0, -5.0, 35.0");
		BioMightOrientation bioMightCameraOrient = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		String bioViewPoint = "bioViewPointLow";
		body += "<Viewpoint DEF='" + bioViewPoint + "'\n"
				+ "   containerField='children'\n"
				+ "   description='Moving Camera'\n" 
				+ "  jump='" +  "true"
				+ "'\n" 
				+ "  fieldOfView='" + fieldOfView 
				+ "'\n"
				+ "   position='" + bioMightCameraPos.getPositionStr()
				+ "'\n" 
				+ "   orientation='" + bioMightCameraOrient.getOrientationStr()
				+ "'/>\n";

		body += "</Transform>\n\n";


		bioViewPointGroup = "bioViewPointGroup2";
		body += "\n\n<Transform DEF='" + bioViewPointGroup + "'>\n";

		fieldOfView = 0.57;
		bioMightCameraPos = new BioMightPosition("0.0, -20.0, 40.0");
		bioMightCameraOrient = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		bioViewPoint = "bioViewPointAll";
		body += "<Viewpoint DEF='" + bioViewPoint + "'\n"
				+ "   containerField='children'\n"
				+ "   description='Moving Camera'\n" 
				+ "  jump='" +  "true"
				+ "'\n" 
				+ "  fieldOfView='" + fieldOfView 
				+ "'\n"
				+ "   position='" + bioMightCameraPos.getPositionStr()
				+ "'\n" 
				+ "   orientation='" + bioMightCameraOrient.getOrientationStr()
				+ "'/>\n";

		body += "</Transform>\n\n";
		
		
		bioMightComponent.setX3D(header + body + footer);
		
		
		// If the X3D is defined, 
		// Dump the X3D data to a file to be rendered in the browser
		//System.out.println("Checking X3D for: " + bioMightComponentName);
		if (!bioMightComponent.getX3D().equals(""))
		 {
			 //System.out.println("Writing X3D for: " + bioMightComponent.getBioMightComponentName());	
			 String fileName =  request.getSession().getServletContext().getRealPath("/") + "x3d\\" + bioMightComponent.getBioMightComponentName() + ".x3d";
			 System.out.println("Writing X3D to: " + fileName);

			 try {
				 File myFile = new File(fileName);
				 boolean exists = myFile.exists();
				 if (exists)
				 {
					 myFile.delete();
				 }			
			 }
			 catch (Exception e)
			 {
				 System.out.println("There was error deleting the file.");
			 }
			
			 // Output the X3D to a file to be loaded by the browser
			 try {
				 BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				 out.write(bioMightComponent.getX3D());
				 out.flush();
				 out.close();
				 out = null;
			 }
			 catch (Exception e) {
				System.out.println("Error writing out X3D file!");
			 }
		
			try {
				File myFile = new File(fileName);
				//System.out.println("Created post FILE object");
				boolean exists = myFile.exists();
				//System.out.println("File Size is: " + myFile.getTotalSpace());
				//myFile.setReadable(true);
				//System.out.println("New X3D FILE Exists?" + exists);
			}
			catch (Exception e)
			{
				System.out.println("There was error reading the new file.");
			}
		}
		
		return(0);
	}
	
	
	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}
	
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
 
	public HttpServletRequest getServletRequest() {
		return this.request;
	}


	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public String getBioMightProjectName() {
		return bioMightProjectName;
	}


	public void setBioMightProjectName(String bioMightProjectName) {
		this.bioMightProjectName = bioMightProjectName;
	}

	
	public String getBioMightProjectID() {
		return bioMightProjectID;
	}

	public void setBioMightProjectID(String bioMightProjectID) {
		this.bioMightProjectID = bioMightProjectID;
	}


	public BioMightComponent getBioMightComponent() {
		return bioMightComponent;
	}

	public void setBioMightComponent(BioMightComponent bioMightComponent) {
		this.bioMightComponent = bioMightComponent;
	}
	
	public Map getParameters() {
		return pMap;
	}

	public void setParameters(Map inMap) {
		//System.out.println("-----Here are parameters--------");
		//Iterator iterator = inMap.entrySet().iterator();
		//while (iterator.hasNext()) {	
		//	Map.Entry entry = (Map.Entry) iterator.next(); 
		//	System.out.println("Key: " + entry.getKey() + "   value: " + entry.getValue());
		//}
		pMap = inMap;
	}
}
