/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.rods.gramnegative;
import java.lang.reflect.Method;
import java.util.ArrayList;

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
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of AeromonasHydrophilias
 ********************************************************************************/

public class AeromonasHydrophilias extends BioMightBase {
private ArrayList aeromonasHydrophilias;

	
	/********************************************************************************************************************
	 *  AeromonasHydrophilia
	 * 
	 * This method will instantiate the AeromonasHydrophilia that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public AeromonasHydrophilias()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.AeromonasHydrophiliasRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  AeromonasHydrophilia
	 * 
	 * This method will instantiate the AeromonasHydrophilia that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public AeromonasHydrophilias(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public AeromonasHydrophilias(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE AeromonasHydrophilia
	 * 
	 * This method will instantiate the AeromonasHydrophilia that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/AeromonasHydrophilia.jpg");
		
		aeromonasHydrophilias = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="AeromonasHydrophilia.x3d";

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING AeromonasHydrophilia Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of AeromonasHydrophilia
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AeromonasHydrophilia Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AeromonasHydrophiliaRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AeromonasHydrophilia");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of aeromonasHydrophilias and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have AeromonasHydrophilia NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the aeromonasHydrophilias we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating AeromonasHydrophilia: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a AeromonasHydrophilia for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			AeromonasHydrophilia aeromonasHydrophilia = new AeromonasHydrophilia(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("AeromonasHydrophilia Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			aeromonasHydrophilias.add(aeromonasHydrophilia);
			System.out.println("Added aeromonasHydrophilia to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.AeromonasHydrophilia, Constants.AeromonasHydrophiliaRef, bioMightTransform.getId());		

			String propDesc = Constants.AeromonasHydrophiliaRef + "-GramNegative, RodShaped, Heterotrophic, PolarFlagellum";
			initProperty(bioMightTransform.getName(), Constants.AeromonasHydrophilia, Constants.AeromonasHydrophiliaRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the aeromonasHydrophilias
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of AeromonasHydrophiliaMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.AeromonasHydrophilia);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing AeromonasHydrophiliaMethods: " + bioMightMethodsIn.size());
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
		
		// Assemble the AeromonasHydrophilia
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
		"title='AeromonasHydrophilia'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for AeromonasHydrophilia HawkEyeView - size: " + aeromonasHydrophilias.size());
			
			// Run through the collection of AeromonasHydrophilia and assemble the X3D for each
			for (int i=0; i<aeromonasHydrophilias.size(); i++)
			{
				// Get the information for the aeromonasHydrophilias
				//AeromonasHydrophilia aeromonasHydrophilias = (AeromonasHydrophilia) aeromonasHydrophilias.get(i);
				//System.out.println("Getting X3D for AeromonasHydrophilia: " + aeromonasHydrophilias.getComponentID());
				//body += aeromonasHydrophilias.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for AeromonasHydrophilia: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for AeromonasHydrophiliaX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for AeromonasHydrophiliaY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for AeromonasHydrophiliaZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				
				
				double rodOrient[][] = {
					{0.0, 0.0, 1.0,  1.57},
					{0.0, 0.0, 1.0,  1.50},
					{0.0, 0.0, 1.0,  -1.50},
					{0.0, 0.0, 1.0,  1.40},
					{0.0, 0.0, 1.0,  1.57},
					{0.0, 0.0, 1.0,  1.50},
					{0.0, 0.0, 1.0,  -1.50},
					{0.0, 0.0, 1.0,  1.40}
				};
				 
			
				double xPos = bioMightTransform.getTranslation().getXPos();  
				double yPos = bioMightTransform.getTranslation().getYPos();
				double zPos = bioMightTransform.getTranslation().getZPos();	
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
				
				for (int k=0; k<8; k++) {
						
					if (k == 2 || k == 5 || k == 6)
					{
						yPos--;
						xPos=0;
					}
					
					//*************************************
					// Create the Body out of Cylinder
					//*************************************
					body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
						
					// Let's compute 
						
				 	body += "translation='" 
						+ xPos + " " 
	 					+ yPos + " "
	 					+ zPos + "'\n";					
					

					body +=  "rotation='" 
							+ rodOrient[k][0] + " "
							+ rodOrient[k][1] + " "
							+ rodOrient[k][2]  + " "
							+ rodOrient[k][3] + "'>\n\n";
		
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
			
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/AeromonasHydrophilias.png'/>";
					
					
					    
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
					 	"<Cylinder DEF='AeromonasHydrophiliaGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +" '\n" +
					 	"height='" + (bioMightTransform.getHeight()) +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
		                   " description='AeromonasHydrophilia'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
									
					
					
					//************************************************
					// Create the Caps out of Spheres
					//************************************************
					for (int l=0; l<2; l++) {
					
						body += "<Transform DEF='TRANSFORM_BACTCAP" + l + bioMightTransform.getId() + "' \n";
						
						if (l==0) {
							System.out.println("Getting X3D -InternalView - L IS 0: " + (bioMightTransform.getTranslation().getYPos() - bioMightTransform.getHeight()* 0.5) );				
	
							body += "translation='" 
								+ (xPos-height*radius*2)  + " " 
			 					+ yPos + " "
			 					+ zPos + "'\n";
						}
						else {
							System.out.println("Getting X3D -InternalView - L IS NOT 0: " + (bioMightTransform.getTranslation().getYPos() + bioMightTransform.getHeight()* 0.5) );				
	
							body += "translation='" 
									+ (xPos+height*radius*2)  + " " 
				 					+ yPos + " "
				 					+ zPos + "'\n";				
						}
						
						 					
						body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
		
				
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/AeromonasHydrophilias.png'/>";
						
						
						    
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
						 	"<Sphere DEF='AeromonasHydrophiliaGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='AeromonasHydrophilia'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
					}
						
					xPos = xPos + height + (radius*2);
			
				}

				
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for AeromonasHydrophilia InternalView - size: " + aeromonasHydrophilias.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for AeromonasHydrophilia: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for AeromonasHydrophiliaX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for AeromonasHydrophiliaY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for AeromonasHydrophiliaZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					

		 		body += "translation='" 
		 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
		

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/AeromonasHydrophilia.png'/>";
				
				
				    
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
				 	"<Sphere DEF='AeromonasHydrophiliaGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='StreptococusPyogenes'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("AeromonasHydrophilia X3D: " + body);		
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
		System.out.println("AeromonasHydrophilia-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for AeromonasHydrophilia: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.AeromonasHydrophilia)) {				
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
				System.out.println("AeromonasHydrophilia - Methods have fired.   Calling AeromonasHydrophilia Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the AeromonasHydrophilia.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("AeromonasHydrophilia-SetColony Size: " + size);
		
		// Generate the AeromonasHydrophilia		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AeromonasHydrophilia Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateAeromonasHydrophilia(size, "AeromonasHydrophilia:00001", "AeromonasHydrophilia", 
		//		"AeromonasHydrophilia", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created AeromonasHydrophilia Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - AeromonasHydrophilia");
			throw new ServerException("Remote Exception AeromonasHydrophiliaEpithelium():", e); 	
		}
	}
	
}
