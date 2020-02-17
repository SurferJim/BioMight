/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.stomach;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;







import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.chemistry.secretion.GastricJuice;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
/**
 * @author SurferJim
 *
 * Scattered among these secretory epithelial cells are G cells, which are endocrine 
 * cells that synthesize and secrete the hormone gastrin.
 * 
 */
public class Stomach extends Organ {
	protected EndotheliumTissue endothelium;
	private Antrum antrum;
	private Pylorus pylorus;
	private LesserCurvature lesserCurvature;
	private GreaterCurvature greaterCurvature;
	private LowerEsophagealSphincter lowerEsophagealSphincter;
	private GastricJuice gastricJuice;
	private StomachCardiacNotch stomachCardiacNotch;


	public Stomach()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.StomachRef, null, null);
	}
	
	
	public Stomach(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Stomach(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Stomach.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		viewPerspective = localVP;
		lod = localLOD;
			
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting StomachInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.StomachRef, parentID);
			System.out.println("Have Stomach Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Stomach");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
				
		// Run through the collection of Stomachs and build them into the model
		// In the default case, we get one instance of the Stomach for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Stomach NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Stomach: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
	
			// Generate the GreaterCurvature Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			localLOD = Constants.MAG1X;
			if (localLOD == Constants.MAG1X)
			{
				// execute the methods against the children
				parentID = bioMightTransform.getId();
				
				if (bioMightMethods != null){
					System.out.println("Execute methods with parent: " + parentID);
					executeMethods(bioMightMethods);
				}
				
				System.out.println("Creating Stomach Endothelium: " + bioMightTransform.getId());				
				endothelium = new EndotheliumTissue("StomachEndothelium", bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, bioMightTransform.getId());
			}
			else if (localLOD == Constants.MAG2X)
			{
				System.out.println("Creating GreaterCurvature: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				greaterCurvature = new GreaterCurvature(bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.StomachGreaterCurvature, Constants.StomachGreaterCurvatureRef, bioMightTransform.getId());
				
				/*
				System.out.println("Creating LesserCurvature: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				lesserCurvature = new LesserCurvature(bioMightTransform.getId(), bioMightMethods);
	
				System.out.println("Creating Antrum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				antrum = new Antrum(bioMightTransform.getId(), bioMightMethods);
	
				System.out.println("Creating Pylorus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				pylorus = new Pylorus(bioMightTransform.getId(), bioMightMethods);
				
				System.out.println("Creating LowerEsophagealSphincter: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				lowerEsophagealSphincter = new LowerEsophagealSphincter(bioMightTransform.getId(), bioMightMethods);
	
				System.out.println("Creating StomachCardiacNotch: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				stomachCardiacNotch = new StomachCardiacNotch(bioMightTransform.getId(), bioMightMethods);
				*/
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
				gastricJuice = new GastricJuice();
	
				}*/
			
			}
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateStomach Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Stomach METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	public void initProperties() {


		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(Constants.NOT_ACTIVATED);
		property.setPropertyDesc(Constants.Title);
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Antrum");
		property.setCanonicalName(Constants.Antrum);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Pylorus");
		property.setCanonicalName(Constants.Pylorus);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("LesserCurvature");
		property.setCanonicalName(Constants.StomachLesserCurvature);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreaterCurvature");
		property.setCanonicalName(Constants.StomachGreaterCurvature);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("LowerEsophagealSphincter");
		property.setCanonicalName(Constants.LowerEsophagealSphincter);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("CardiacNotch");
		property.setCanonicalName(Constants.StomachCardiacNotch);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("GastricJuice");
		property.setCanonicalName(Constants.GastricJuice);
		properties.add(property);	
	}
	
	
	public void initMethods() {
				
		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Stomach);
		method.setMethodName("setColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Stomach);
		method.setMethodName("setSkin");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);

		/*
		method = new BioMightMethodView();
		method.setMethodName("Excrete Gastric Juice");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Digest");
		method.setHtmlType("Digest");
		methods.add(method);
		*/		
	}
	

	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Greater Curvature Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Stomach: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
	
			double radius = 0.5;
		
		
			if (componentID.equals("Stomach:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.2, -17.0, -3.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				
				System.out.println("Calling GenerateStomach: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateStomach("StomachEndothelium:00001", "StomachEndothelium", 
					"StomachEndothelium", componentID, parentID, currentPoints);			
						
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created StomachEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - StomachEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
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
		System.out.println("Stomach-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			//System.out.println("Stomach-Executing Methods: " + j);
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Stomach: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			//String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the object
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Stomach)) {				
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
				System.out.println("Stomach Methods have fired!");
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
		
		// Assemble the Stomach
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Stomach.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Stomach'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		lod = Constants.MAG1X;
		if (lod == Constants.MAG1X)
		{				
			body = endothelium.getX3D(true);
		}
		else
		{	
			body = 
				/*
				antrum.getX3D(true) + 
				pylorus.getX3D(true) + 
				lesserCurvature.getX3D(true) + */
					greaterCurvature.getX3D(true);
				/*
				lowerEsophagealSphincter.getX3D(true) + 
				stomachCardiacNotch.getX3D(true);*/
		}
		
		//System.out.println("Stomach X3D: " + body);		
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_Stomach'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -20.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";

		
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
	
	
	public void secreteGastricJuice()
	{	
	}
	
	public void Peristalisis()
	{
	}

	public Antrum getAntrum() {
		return antrum;
	}

	public void setAntrum(Antrum antrum) {
		this.antrum = antrum;
	}

	public GastricJuice getGastricJuice() {
		return gastricJuice;
	}

	public void setGastricJuice(GastricJuice gastricJuice) {
		this.gastricJuice = gastricJuice;
	}

	public GreaterCurvature getGreaterCurvature() {
		return greaterCurvature;
	}

	public void setGreaterCurvature(GreaterCurvature greaterCurvature) {
		this.greaterCurvature = greaterCurvature;
	}

	public LesserCurvature getLesserCurvature() {
		return lesserCurvature;
	}

	public void setLesserCurvature(LesserCurvature lesserCurvature) {
		this.lesserCurvature = lesserCurvature;
	}

	public LowerEsophagealSphincter getLowerEsophagealSphincter() {
		return lowerEsophagealSphincter;
	}

	public void setLowerEsophagealSphincter(
			LowerEsophagealSphincter lowerEsophagealSphincter) {
		this.lowerEsophagealSphincter = lowerEsophagealSphincter;
	}

	public Pylorus getPylorus() {
		return pylorus;
	}

	public void setPylorus(Pylorus pylorus) {
		this.pylorus = pylorus;
	}

	
}


