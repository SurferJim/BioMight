/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.bladder;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;



/*******************************************************************************************
 * @author SurferJim 01/23/2012
 *
 * Representation of the Bladder
 * 
 ******************************************************************************************/

public class Bladder extends Organ {
	private EpitheliumTissue epithelium;
	
	
	public Bladder()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BladderRef, null, null);
	}

	public Bladder(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Bladder(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Bladder Create");
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
		this.setImage("images/Bladder.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BladderInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BladderRef, parentID);
			System.out.println("Have Bladder Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bladder");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";
			
		// Run through the collection of Bladders and build them into the model
		// In the default case, we get one instance of the Bladder for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Bladder NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Bladder we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Bladder: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
								
				// Generate the Bladder Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				// execute the methods against the children
				parentID = bioMightTransform.getId();  
				if (bioMightMethods != null){
					executeMethods(bioMightMethods);
				}
				
				String startID = "BladderEpithelium:00001";
				System.out.println("HawkEye - Creating Bladder Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "BladderEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BladderEpithelium", "BladderEpithelium", Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Bladder Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				
							
				/*
				System.out.println("Creating BladderLeftLateralLobe : " + bioMightTransform.getId());				
				BladderLeftLateralLobe = new BladderLeftLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.Hand, Constants.HandRef, bioMightTransform.getId());
		
				System.out.println("Creating BladderRightMedialLobe : " + bioMightTransform.getId());				
				BladderRightMedialLobe = new BladderRightMedialLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.BladderQuadrateLobe, Constants.BladderQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating BladderRightLateralLobe : " + bioMightTransform.getId());				
				BladderRightLateralLobe = new BladderRightLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.BladderQuadrateLobe, Constants.BladderQuadrateLobeRef, bioMightTransform.getId());

				*/	
			}
				
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateBladder Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Bladder METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		
		/*******************************************************************
		 * generate the Bladder
		 * 
		 * @param parentID
		 * @param componentID
		 ****************************************************************/
		
		public void generate(String parentID, String componentID)
		{
			// Generate the BladderEpithelium		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the BladderEpithelium: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double radius = 0.25;
			
				if (parentID.equals("Abdomen:01")) 
				{	
					// Generate the BladderEpithelium of the stomach
					// Create 5 sections
					double[] startPos = {-0.3, -32.75, -4.5};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
					
					System.out.println("Calling Generate BladderEpithelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateBladder("BladderEpithelium:00001", "BladderEpithelium", 
							"BladderEpithelium", componentID, currentPoints);			
					
				
					
				}			
				else if (parentID.equals("Chest:01")) 
				{	
					// Generate the BladderEpithelium of the stomach
					// Create 5 sections
					double[] startPos = {-0.3,-14.0, -6.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
					System.out.println("Calling Generate BladderEpithelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateBladder("BladderEpithelium:00001", "BladderEpithelium", 
							"BladderEpithelium", componentID, currentPoints);			
				
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate BladderEpithelium NoParent");
								
				}
				
				System.out.println("Created BladderEpithelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - BladderEpithelium");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		}
		
	

	
	
	public void initProperties() {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Bladder);
		method.setMethodName("setColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Bladder);
		method.setMethodName("setSkin");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
	}

	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Bladdeer-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			System.out.println("Bladder-Executing Methods: " + j);
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Bladder: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			//String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Bladder)) {				
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
							Method method = this.getClass().getMethod(methodName, paramsType);
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
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
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
				System.out.println("Bladder - Methods have fired!");
			}
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
		
		// Assemble the Bladder
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bladder'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_Bladder'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -34.0 10.0'\n" +
				 "orientation='0 0 1 0'/>\n";
	
		
		//System.out.println("Bladder X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/*****************************************************************************
	 * SET COLOR
	 * 
	 * Set the Color
	 * 
	 *****************************************************************************/
	public void setColor(int material) {
		System.out.println("Setting Color for: " + parentID + "  " + material);
		setMaterial(material, parentID); 
	}

	/*****************************************************************************
	 * SET SKIN
	 * 
	 * Set the Texture
	 * 
	 *****************************************************************************/
	public void setSkin(int material) {
		System.out.println("Setting Texture for: " + parentID + "  " + material);
		setTexture(material, parentID); 
	}
	
	
}
