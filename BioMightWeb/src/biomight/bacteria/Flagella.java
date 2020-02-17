/*
 * Created on Nov 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

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



/***************************************************************************************
 * @author SurferJim
 *
 * Representation of Flagella
 * 
 **************************************************************************************/

public class Flagella  extends BioMightBase{
	private ArrayList<Flagellum> flagella;	
	
	
	/********************************************************************************************************************
	 *  Flagella
	 * 
	 * This method will instantiate the Flagella that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Flagella()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Flagella
	 * 
	 * This method will instantiate the Flagella that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Flagella(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Flagella(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Flagella
	 * 
	 * This method will instantiate the Flagella that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/Flagellums.jpg");
		
		flagella = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Flagellums Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		
		// Generate the SubclavianArtery Endothelium if needed 
		boolean bGenerate = false;
		if (bGenerate) {
			generate(parentID, componentID);
		}
		
	
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Flagellums
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting Flagellums Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.FlagellumRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Flagellums");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of flagella and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println("Have Flagellums NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the flagellum we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Creating Flagellum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Flagellum for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			Flagellum flagellum = new Flagellum(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			//System.out.println("Flagellum Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			flagella.add(flagellum);
			//System.out.println("Add Flagellum to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Flagellum, Constants.FlagellumRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.Flagellum, Constants.FlagellumRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the flagella
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Flagellum);
		method.setMethodName("setColonySize");
		method.setDisplayName("Colony Size:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
		methods.add(method);

	}
	
	

	/********************************************************************************
	 * GENERATE
	 * @param parentID
	 * @param componentID
	 ********************************************************************************/
	public void generate(String parentID, String componentID)
	{
		
		// Run through the argument list and executes the 
		// associated methods
		int size = 10;
		boolean fired = false;
		//System.out.println("Flagellae-SetColony Size: " + size);
		
		// Generate the Flagella		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Generating the Flagella: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
			//int success = bioMightBean.generateFlagellae(size, "Flagella:00001", "Flagella", 
			//	"Flagella", componentID, parentID, currentPoints);
			
			//System.out.println("Created Flagella Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Flagella");
			throw new ServerException("Remote Exception FlagellaEpithelium():", e); 	
		}

	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Flagella.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Flagella
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
		"title='Flagella'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = null;
		
		
		//System.out.println("Assembling X3D for Flagella Collectoin");
		
		
		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			//System.out.println("Assembling X3D for flagella HawkEyeView - size: " + flagella.size());
			
			// Run through the collection of flagella and assemble the X3D for each
			for (int i=0; i<flagella.size(); i++)
			{
				// Get the information for the Flagella
				//Flagella Flagella = (Flagella) flagella.get(i);
				//System.out.println("Getting X3D for Flagella: " + Flagella.getComponentID());
				//body += Flagella.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting X3D -HawkEyeView - for Flagella: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				


				// Set up a Group that assembles the flagellum
				if (i==0) {
					body += "\n<Transform DEF='" + bioGroup + "'\n";
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() + "'\n";
					body += "  scale='" + bioMightTransform.getScale().getScaleStr() + "'\n";
					body += "  rotation='" + bioMightTransform.getOrientation().getOrientationStr() + "'>\n\n";
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
				}

				// As we set up this group pivot point we need to adjust all the coordinates so
				// that the Pivot point is subtracted.
				
				//System.out.println("Getting X3D for FlagellaX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for FlagellaY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for FlagellaZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
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
			 			+ (bioMightTransform.getTranslation().getXPos() - baseTransform.getTranslation().getXPos())  + " " 
 						+ (bioMightTransform.getTranslation().getYPos() - baseTransform.getTranslation().getYPos())  + " "
 						+ (bioMightTransform.getTranslation().getZPos() - baseTransform.getTranslation().getZPos())  + "'\n";
				}

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'\n";
				 		
				 				
				body +=  "rotation='" + bioMightTransform.getOrientation().getXAxis() + " "
							+ bioMightTransform.getOrientation().getYAxis()  + " "
							+ bioMightTransform.getOrientation().getZAxis()  + " "
							+ bioMightTransform.getOrientation().getDegrees() + "'>\n" +
					
				 	
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/SpeckledGreen.png'/>";
				
				    
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
				 	"<Cylinder DEF='FlagellaGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'\n" +
				 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='Flagella'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
			
			// Set up a Group that assembles the flagellum
			body += "\n\n</Transform>\n\n";

			
		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			//System.out.println("Assembling X3D for flagella InternalView - size: " + flagella.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting X3D -InternalView - for Flagella: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				// Set up a Group that assembles the flagellum
				if (i==0) {
					bioGroup = "FlagellaGroup";
					body += "\n<Transform DEF='" + bioGroup + "'\n";
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() + "'\n";
	
					body += "  scale='" + bioMightTransform.getScale().getScaleStr() + "'\n";
	
					body += "  rotation='" + bioMightTransform.getOrientation().getOrientationStr() + "'>\n\n";
					
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
				}
					
				
				//System.out.println("Getting X3D for FlagellaX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for FlagellaY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for FlagellaZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
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
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/SpeckledGreen.png'/>";
				
								    
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
				 	"<Cylinder DEF='FlagellaGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'\n" +
				 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='Flagella'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
			
			
			// Set up a Group that assembles the flagellum
			body += "\n\n</Transform>\n\n";
			
		}			
		
		
		body += animate(bioGroup, baseTransform); 
		
		//System.out.println("Flagella X3D: " + body);		
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
		//System.out.println("Flagellums-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			//System.out.println("Have BioMightMethod for Flagellums: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Flagella)) {				
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
							//System.out.println("Could not Convert to int: " + methodParam);						
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
							//System.out.println("Locating Method(Double)" + methodName);
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
				System.out.println("Flagellums - Methods have fired.   Calling Flagellums Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Flagellums.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Flagellums-SetColony Size: " + size);
		
		// Generate the Flagellum		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Flagellum Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			
		    		 					
			double currentPoints[][] = null;
			//int success = bioMightBean.generateFlagellums(size, "Flagellum:00001", "Flagellum", 
			//	"Flagellum", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Flagellum Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Flagellum");
			throw new ServerException("Remote Exception FlagellumEpithelium():", e); 	
		}
	}

	
	

	/******************************************************************************************
	 * ANIMATE 
	 *
	 * This method will animate  the component.  The input comes in through the methods
	 * that are presented on the view.  
	 *****************************************************************************************/
	
	public String animate(String bioGroup, BioMightTransform baseTransform) {
		BioMightPosition bioMightPosition= baseTransform.getTranslation();
		BioMightScale bioMightScale= baseTransform.getScale();		
		BioMightOrientation bioMightOrientationStart =  new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		BioMightOrientation bioMightOrientationEnd = new BioMightOrientation("0.0, 1.0, 0.0, 0.50");
		
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

		String bioTimer = "flagellaTimer";
		body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
				+ " containerField='children'\n "
				+ " cycleInterval='" + 0.6 + "'\n "
				+ " loop='true' \n"
				+ " startTime='0.0'/> \n\n";

		// Setup a Script that will set the TimeStart for each
		// of
		// the animation events.
		String bioScript = "flagellaScript";
		body += "<Script DEF='" + bioScript + "'>\n";

		String bioScriptStartTime = "flagellaScriptStartTime";
		body += "<field name='flagellaScriptStartTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		String bioScriptEndTime = "flagellaScriptEndTime";
		body += "<field name='flagellaScriptEndTime "
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		String bioScriptTimeVar = "flagellaScriptTimeVar";
		//body += "\n<![CDATA[\n" + "ecmascript:\n"
		//		+ "function initialize () {\n" + "var "
		//		+ bioScriptTimeVar
		//		+ "= new Date().getTime() + " + startTime
		//		+ ";\n" + bioScriptStartTime + " = "
		//		+ bioScriptTimeVar + ";	\n" + "}\n" + "]]>\n"
		body +=  "</Script>\n\n";

		String bioAnimation = "flagellaAnimation";

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
		bioAnimation = "rotBioAnimation";
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
		bioAnimation = "sizBioAnimation";

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


		// System.out.println("\n\n In Palette, BODY: " + body);
		return (body);
	}


	
	
	
}
