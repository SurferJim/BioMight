/*
 * Created on Jul 23, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.body.organ.kidney;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;





import biomight.Constants;
import biomight.system.tissue.epithelial.*;
import biomight.system.tissue.muscle.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;

/*********************************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *********************************************************************************************/

public class Ureters extends Organ {
	private ArrayList ureters;
	private LeftUreter leftUreter;
	private RightUreter rightUreter;
	
	
	/********************************************************************************************************************
	 *  Ureters
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Ureters()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.UretersRef, null, null);
	}

	public Ureters(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Ureters(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Ureters Create");
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
		this.setImage("images/Ureters.jpg");
		
		ureters = new ArrayList();
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Ureters Transform: " + Constants.UreterRef + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.UreterRef, parentID);
			System.out.println("Have Ureters Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Ureters");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		componentID = Constants.UretersRef+":0"; 
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		// Run through the collection of ureters and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have ureters NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Ureter: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Ureter for each tranform specified for the organism
			Ureter ureter = new Ureter(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("Ureter Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			ureters.add(ureter);
			initProperty(bioMightTransform.getName(), Constants.Ureter, Constants.UreterRef, ureter.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);									
			System.out.println("Add Ureter to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Set up methods that will be available to the ureters
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setSkin");
		method.setDisplayName("Ureter Skin:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setDiameter");
		method.setDisplayName("Ureter Diameter:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the ureter.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Ureters
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
		"title='Hips'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Ureters");
		
		// Run through the collection of Ureters and assemble the X3D for each
		for (int i=0; i<ureters.size(); i++)
		{
			// Get the information for the ureter
			Ureter ureter = (Ureter) ureters.get(i);
			System.out.println("Getting X3D for Ureter");
			body += ureter.getX3D(true);
		}		
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_Ureters'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -30.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";

		//System.out.println("Ureters X3D: " + body);		
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
		System.out.println("Ureters-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Ureters: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Ureters)) {				
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
				System.out.println("Ureters - Methods have fired.   Calling Ureters Save method!");
				//save();
			}
		}
	}

	
}
