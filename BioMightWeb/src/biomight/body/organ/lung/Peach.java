/*
 * Created on May 2, 2006
 *
 * Humans have two lungs, with the left being divided into two lobes and the 
 * right into three lobes. Together, the lungs contain approximately 1500 miles 
 * (2,400 km) of airways and 300 to 500 million alveoli, having a total surface 
 * area of about 75 m2 in adults — roughly the same area as a tennis court. 
 * If all of the capillaries that surround the alveoli were unwound and laid end to end, 
 * they would extend for about 620 miles.
 * 
 */
package biomight.body.organ.lung;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

/**
 * @author SurferJim
 *
 * Object the represents a lung
 */

public class Peach extends Organ {	
	BioMightTransform gbioMightTransform; 
	
	// 2 Surfaces
	private ApexPulmonis apexPulmonis;
	private BasisPulmonis basisPulmonis;
	
	// 3 Borders
	private LungAnteriorBorder lungAnteriorBorder;
	private LungApexPulmonis lungApexPulmonis;
	private LungBasisPulmonis lungBasisPulmonis;
	private LungCardiacImpression lungCardiacImpression;
	private LungCostalSurface lungCostalSurface;
	private LungHilum lungHilum;
	private LungInferiorBorder lungInferiorBorder;
	private LungInferiorLobe lungInferiorLobe;
	private LungMediastinalSurface lungMediastinalSurface;
	private LungPosteriorBorder lungPosteriorBorder;
	private LungSuperiorLobe lungSuperiorLobe;	
	private LungMiddleLobe lungMiddleLobe;	
	
	// The average adult lung contains about 600 million alveoli
	private Lobes lobes;
	private Alveoli alveoli;
	private Bronchioles bronchioles;
	
	// Vital capacity is the maximum volume of air that a person can exhale after maximum inhalation
	private BigDecimal vitalCapacity;
	private boolean bronchoconstriction;
	private boolean bronchodilation;
	protected EpitheliumTissue epithelium;
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Peach()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LungRef, null, null);
	}

	public Peach(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Peach(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}


	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Lung.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Lung for: " + parentID);
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Lung Create() - ViewInternal - Already Set: " + parentID);				
			
			// We already have the data for the current instance of Lung,
			// Go get the details for the current Lung is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				
				// Generate the Lung Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving Lung Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("LungEpithelium", parentID, bioMightMethods);

			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Lung				
				System.out.println("Getting the Lung MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Lung Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving Lung Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("LungEpithelium", parentID, bioMightMethods);

				/*	
				System.out.println("Creating the LungAnteriorBorder for parent: " + parentID);
				lungAnteriorBorder = new LungAnteriorBorder(parentID, bioMightMethods);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				
				System.out.println("Created the LungAnteriorBorder for parent: " + parentID);
				
				/*
				System.out.println("Creating the LungApexPulmonis for parent: " + parentID);
				lungApexPulmonis = new LungApexPulmonis(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungApexPulmonis for parent: " + parentID);
				
				System.out.println("Creating the LungBasisPulmonis for parent: " + parentID);
				lungBasisPulmonis = new LungBasisPulmonis(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungBasisPulmonis for parent: " + parentID);
				
				System.out.println("Creating the LungCardiacImpression for parent: " + parentID);
				lungCardiacImpression = new LungCardiacImpression(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungCardiacImpression for parent: " + parentID);
		
				System.out.println("Creating the LungSuperiorLobe for parent: " + parentID);
				lungSuperiorLobe = new LungSuperiorLobe(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungSuperiorLobe for parent: " + parentID);
				
				System.out.println("Creating the LungInferiorLobe for parent: " + parentID);
				lungInferiorLobe = new LungInferiorLobe(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungInferiorLobe for parent: " + parentID);
		
				System.out.println("Creating the LungMiddleLobe for parent: " + parentID);
				lungMiddleLobe = new LungMiddleLobe(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungMiddleLobe for parent: " + parentID);
			
				System.out.println("Creating the LungHilum for parent: " + parentID);
				lungHilum = new LungHilum(parentID);
				initProperty("LungAnteriorBorder", Constants.LungAnteriorBorder, Constants.LungAnteriorBorderRef, lungAnteriorBorder.getComponentID());
				System.out.println("Created the LungHilum for parent: " + parentID);
				*/	
			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("Lung Instance is created : " + parentID);
		} 
		else if (localVP == Constants.VIEW_DETACHED  || localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Lung directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye LungInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Lung Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Lung");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			if (bioMightMethods != null){
				executeMethods(bioMightMethods);
			}
			
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Lung for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Lung NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Lung
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
				
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating Lung: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Lung at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties

					// Go get the finer details of the Lung				
					System.out.println("Creating Lung at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving Lung Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("LungEpithelium", parentID, bioMightMethods);
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Lung				
					System.out.println("Creating Lung at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving Lung Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("LungEpithelium", parentID, bioMightMethods);
					initProperty(Constants.EpitheliumTissueRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
					
					//System.out.println("Creating Lung HawkEye - 2X : " + parentID);
					//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					//System.out.println("In Lung - CarbonsRef is complete");

					/*	
				    calyces = new Calyces(parentID, bioMightMethods);
					System.out.println("Lung Calxes created: " + parentID);
					renalArtery = new RenalArtery(parentID, bioMightMethods);
					System.out.println("RenalArtery completed for Lung: " + parentID);

					renalVein = new RenalVein(parentID, bioMightMethods);
					System.out.println("RenalVein completed for Lung: " + parentID);

					renalSinus = new RenalSinus(parentID, bioMightMethods);
					System.out.println("RenalSinus completed for Lung: " + parentID);

					renalPelvis = new RenalPelvis(parentID, bioMightMethods);
					System.out.println("RenalPelvis completed for Lung: " + parentID);

					LungVisceralEpithelium = new LungVisceralEpithelium(parentID, bioMightMethods);
					System.out.println("LungVisceralEpithelium completed for Lung: " + parentID);

					maculaDensa = new MaculaDensa(parentID, bioMightMethods);
					System.out.println("MaculaDensa completed for Lung: " + parentID);

					renalFibrousCapsule = new RenalFibrousCapsule(parentID, bioMightMethods);
					System.out.println("RenalFibrousCapsule completed for Lung: " + parentID);

					renalPapilla = new RenalPapilla(parentID, bioMightMethods);
					System.out.println("RenalPapilla completed for Lung: " + parentID);		
					*/				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	
	System.out.println("CreateLung Completed");
	}
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Apex Pulmonis");
		property.setCanonicalName(Constants.LungApexPulmonis);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Basis Pulmonis");
		property.setCanonicalName(Constants.LungBasisPulmonis);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Costal Surface");
		property.setCanonicalName(Constants.LungCostalSurface);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Mediastinal Surface");
		property.setCanonicalName(Constants.LungMediastinalSurface);
		properties.add(property);
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lung);
		method.setMethodName("setLungColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lung);
		method.setMethodName("setLungTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
		
		/*
		method = new BioMightMethodView();
		method.setMethodName("Breaths");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Inhale");
		method.setHtmlType("checkbox");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("Exhale");
		method.setHtmlType("checkbox");
		methods.add(method);	
		*/
	}
	
	/****************************************************
	 * GENERATE LUNG
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Lung		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Lung Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 0.00125;
			
			if (componentID.equals("Lung:01")) {
				
				// Generate the Palm
				int numPoints = 8;
				double[] startPos = {2.35, -9.5, -2.75};
	    		double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, numPoints);			
				int success = bioMightBean.generateLung("LungEpithelium:00001", "LungEpithelium", 
						"LungEpithelium", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Lung:02"))
			{
				// Generate the Elbow
				int numPoints = 8;	 
				double[] startPos = {-2.35, -9.5, -2.75};	
	    		double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, numPoints);			
				
				int success = bioMightBean.generateLung("LungEpithelium:00620", "LungEpithelium", 
					"LungEpithelium", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate LungEpithelium NoParent");		
			}

			
			System.out.println("Created LungEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LungEpithelium");
			throw new ServerException("Remote Exception LungEpithelium():", e); 	
		}
	}
	
	
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Lung-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			System.out.println("Lung-Executing Methods: " + j);
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Lung: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
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
			if (canonicalName.equals(Constants.Lung)) {				
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
				System.out.println("Lung - Methods have fired.   Calling Lungs Save method!");
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
		
		// Assemble the Right Lung
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Lung.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Lung'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		//System.out.println("Getting X3D for Lung");
		String body = "";
		
		System.out.println("Getting Lung X3D");
		if (viewPerspective == Constants.VIEW_INTERNAL) {
			System.out.println("Getting Lung Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting Lung Epithelium X3D");
			body = epithelium.getX3D(true); 

			body+= "<Viewpoint DEF='Viewpoint_Lung'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -12.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) {
			System.out.println("Getting Lung Epithelium X3D");
			body = epithelium.getX3D(true); 
			
			body+= "<Viewpoint DEF='Viewpoint_Lung'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -12.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";
		}
		else
		{
			body = epithelium.getX3D(true); 
			//body = 		
			//lungAnteriorBorder.getX3D(true);
			
			/*
			+ lungApexPulmonis.getX3D(true) 
			+ lungBasisPulmonis.getX3D(true)
			+ lungCardiacImpression.getX3D(true)
			+ lungSuperiorLobe.getX3D(true)
			+ lungInferiorLobe.getX3D(true)
			+ lungMiddleLobe.getX3D(true)
			+ lungHilum.getX3D(true);*/
		}

		//System.out.println("Lung X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	/*****************************************************************************
	 * SET LUNG COLOR
	 * 
	 * Set the color of the Lungs
	 * 
	 *****************************************************************************/
	public void setLungColor(int material) {
		System.out.println("Setting Color for Lung: " + parentID + "  " + material);
		setMaterial(material, parentID); 
	}

	/*****************************************************************************
	 * SET LUNG TEXTURE
	 * 
	 * Set the color of the Texture
	 * 
	 *****************************************************************************/
	public void setLungTexture(int material) {
		System.out.println("Setting Texture for Lung: " + parentID + "  " + material);
		setTexture(material, parentID); 
	}
}
