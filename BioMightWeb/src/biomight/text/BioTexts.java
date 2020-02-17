/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.text;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSymbolsBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of BioTexts
 ********************************************************************************/

public class BioTexts extends BioMightBase {
	private ArrayList<BioText> bioTexts;
	
	
	/********************************************************************************************************************
	 *  BIOTEXTS
	 * 
	 * This method will instantiate the BioTexts that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public BioTexts()
	{		
		// Create the Base BioTexts
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.BioTextsRef, null, null);
	}
	
	public BioTexts(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		
	
	public BioTexts(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
	}
	
		
	public BioTexts(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/BioTexts.jpg");
		
		bioTexts = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING BioTexts Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of BioTexts
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BioTexts Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BioTextRef, parentID);
			System.out.println("Have BioTexts Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BioTexts");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// init the properties
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of bioTexts and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have bioTexts NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the bioText we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating BioText: " + parentID + " new compid " + bioMightTransform.getId());
			System.out.println("Creating BioText: " + bioMightTransform.getTranslation().getXPos() 
					+ "  " + bioMightTransform.getTranslation().getYPos() );
			
			// Create an instance of a BioText for each tranform specified
			localVP =  Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			BioText bioText = new BioText(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("BioText Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioTexts.add(bioText);
			System.out.println("Add BioText to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Property
			initProperty(bioMightTransform.getName(), Constants.BioText, Constants.BioTextRef, bioMightTransform.getId());				
		}

		// Set up methods that will be available to the bioTexts
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioTexts);
		method.setMethodName("setColonySize");
		method.setDisplayName("Number Texts:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
		methods.add(method);	
		
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CostalCartilages.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BioTexts'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for BioTexts in Collection");
		
		lod = Constants.VIEW_HAWKEYE;
		if (lod == Constants.VIEW_HAWKEYE) 
		{			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating BioText: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()  +  "  " + transforms.size());
				System.out.println("Creating BioText at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
				
				
				//System.out.println("Getting X3D for BioTextX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BioTextY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BioTextZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='BioText'\n";
				
				body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";				
				
				body += "rotation='" 
			 			+ bioMightTransform.getOrientation().getXAxis() + " " 
 						+ bioMightTransform.getOrientation().getYAxis() + " "
 						+ bioMightTransform.getOrientation().getZAxis() +  " "
 						+ bioMightTransform.getOrientation().getDegrees() + "'\n";
				 					
				body +=  "scale='" 	
					+ bioMightTransform.getScale().getXScale() + " "
				 	+ bioMightTransform.getScale().getYScale() + " "
				 	+ bioMightTransform.getScale().getZScale() + "'>\n";
			
		
				body += 
				"<SHAPE>\n" 
			    + "<Appearance>\n"; 
				
				// Texture
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/SpeckledPink.png'/>";
			
				// Material
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				  
				    "shininess='" 		  + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	  + bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +    
				 	"</Appearance>\n" +
			
				  	// Text Definition
					"<Text DEF='BioText'\n" +
					"containerField='geometry'\n" +
						"string='" + bioMightTransform.getBioText() +"'\n" +
						"maxExtent='"+ bioMightTransform.getBioMightText().getMaxEnt() +  "'>\n" +
						
						// Font Definition
						"<FontStyle\n" +
						"containerField='fontStyle'\n" +
						"family='"+ bioMightTransform.getBioMightText().getFamily() +"'\n" + 
						"style='"+ bioMightTransform.getBioMightText().getStyle() + "'\n" + 
						"justify='\"BEGIN\" \"BEGIN\"'\n" +
						"size='"+ bioMightTransform.getBioMightText().getSize() + "'\n" + 
						"spacing='"+ bioMightTransform.getBioMightText().getSpacing()  + "'/>\n" +
						
					"</Text>\n" +
				"</SHAPE>\n" +
				
				 "</Transform>\n";

				}
		}
		else
		{	
		
			// Run through the collection of BioTexts and assemble the X3D for each
			for (int i=0; i<bioTexts.size(); i++)
			{
				// Get the information for the costalCartilages
				BioText bioText = (BioText) bioTexts.get(i);
				System.out.println("Getting X3D for BioTexts: " + i);
				body += bioText.getX3D(true);
			}		
		
		}
		body+= "<Viewpoint DEF='Viewpoint_BioTexts'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 60.0'\n" +
				 "orientation='0 0 1 0'/>\n";

		//System.out.println("BioTexts X3D: " + body);		
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
		System.out.println("BioTexts-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BioTexts: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.BioTexts)) {				
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
				System.out.println("BioTexts - Methods have fired.   Calling BioTexts Save method!");
			}
		}
	}

	
	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the BioTexts.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BioTexts-SetColonySize: " + size);
		
		// Generate the BioText		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BioText Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightSymbolsBeanLocal bioMightBean = (BioMightSymbolsBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightSymbolsBeanLocal");
		    		 					
			double currentPoints[][] = null;
			System.out.println("CallingGenerateBioTexts!!!");
			int success = bioMightBean.generateBioTexts(size, "BioText:00001", "BioText", 
				"BioText", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created BioText Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - BioText");
			throw new ServerException("Remote Exception BioTextEpithelium():", e); 	
		}
	}
	
}
