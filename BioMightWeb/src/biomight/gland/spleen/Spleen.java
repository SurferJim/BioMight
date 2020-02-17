/*
 * Created on May 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.spleen;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.system.vascular.arteries.abdomen.*;
import biomight.system.ligament.*;
import biomight.system.vascular.veins.abdomen.*;
import biomight.system.lymphatic.*;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;


/**
 * @author SurferJim
 *
 * The size and weight of the spleen are liable to very extreme variations at 
 * different periods of life, in different individuals, and in the same individual 
 * different conditions. In the adult it is usually about 12 cm. in length, 7 cm. 
 * in breadth, and 3 or 4 cm. in thickness, and weighs about 200 grams
 * 
 */

public class Spleen extends Organ {
	private SpleenAnteriorBorder spleenAnteriorBorder;
	private SpleenPosteriorBorder spleenPosteriorBorder;
	private SpleenInferiorBorder spleenInferiorBorder;
	private SpleenAreolae spleenAreolae;
	private SpleenExternalSerousCoat externalSerousCoat;
	private SpleenFibroelasticCoat fibroelasticCoat;
	private SpleenGastricSurface spleenGastricSurface;
	private SpleenRenalSurface spleenRenalSurface;
	private MalpighianBodies malpighianBodies;
	private PulpVein pulpVein;
	private TrabecularArtery trabecularArtery;
	private TrabecularVein trabecularVein;
	private GastrolienalLigament gastrolienalLigament;
	private PhrenicolienalLigament phrenicolienalLigament;
	private SplenicPulp splenicPulp;
	private SplenicCord splenicCord;
	private SplenicSinus splenicSinus;
	private LymphaticVessels lymphaticVessels;

	
	
	/************************************************************************
	 * Spleen Constructor 
	 *
	 ***********************************************************************/
	public Spleen()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SpleenRef, null, null);
	}

	/************************************************************************
	 * Spleen Constructor 
	 *
	 ***********************************************************************/
	public Spleen(String parentID)
	{
		System.out.print("Calling parameterized Spleen Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Spleen Constructor 
	 *
	 ***********************************************************************/
	public Spleen(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Spleen with MethodParams!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Spleen
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Spleen.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SpleenInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SpleenRef, parentID);
			System.out.println("Have Spleen Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Spleen");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through Spleen and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Spleen NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Spleen we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SpleenSerousCoat (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			externalSerousCoat = new SpleenExternalSerousCoat(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(Constants.SpleenExternalSerousCoatRef, Constants.SpleenExternalSerousCoat, Constants.SpleenExternalSerousCoatRef, externalSerousCoat.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			
			/*
			spleenAnteriorBorder = new SpleenAnteriorBorder();
			spleenPosteriorBorder = new SpleenPosteriorBorder();
			spleenInferiorBorder = new SpleenInferiorBorder();
			spleenAreolae = new SpleenAreolae();
			fibroelasticCoat = new SpleenFibroelasticCoat()  ;
			spleenGastricSurface = new SpleenGastricSurface()  ;
			spleenRenalSurface = new SpleenRenalSurface()  ;
			malpighianBodies = new MalpighianBodies()  ;
			linealArtery = new LienalArtery()  ;
			pulpVein = new PulpVein();
			trabecularArtery = new TrabecularArtery();
			trabecularVein = new TrabecularVein();
			gastrolienalLigament = new GastrolienalLigament();
			phrenicolienalLigament = new PhrenicolienalLigament();
			splenicPulp = new SplenicPulp();
			splenicCord = new SplenicCord();
			splenicSinus = new SplenicSinus() ;
			lymphaticVessels = new LymphaticVessels()
			*/
		
			
			System.out.println("Spleen completed");			
		}			
		//initProperties();
		initMethods();
	}
	
	
	/*******************************************************************
	 * generate the Spleen
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SpleenEpithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SpleenEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.25;
		
			if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the SpleenEpithelium 
				// Create 5 sections
				double[] startPos = {4.50,-14.5, -4.5};
				
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate SpleenEpithelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSpleen("SpleenEpithelium:00001", "SpleenEpithelium", 
						"SpleenEpithelium", componentID, currentPoints);			
			
			}			
			else if (parentID.equals("Chest:01")) 
			{	
				// This is a mutant case
				double[] startPos = {4.50,-22.0, -4.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate SpleenEpithelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSpleen("SpleenEpithelium:00180", "SpleenEpithelium", 
						"SpleenEpithelium", componentID, currentPoints);			
			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate SpleenEpithelium NoParent");
							
			}
			
			System.out.println("Created SpleenEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SpleenEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	

	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Anterior Border:");
		property.setCanonicalName(Constants.SpleenAnteriorBorder);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Areolae");
		property.setCanonicalName(Constants.SpleenAreolae);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("External Serous Coat");
		property.setCanonicalName(Constants.SpleenExternalSerousCoat);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Fibroelastic Coat");
		property.setCanonicalName(Constants.SpleenFibroelasticCoat);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Gastric Surface");
		property.setCanonicalName(Constants.SpleenGastricSurface);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Malpighian Bodies");
		property.setCanonicalName(Constants.MalpighianBodies);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Posterior Border");
		property.setCanonicalName(Constants.SpleenPosteriorBorder);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Gastrolienal Ligament");
		property.setCanonicalName(Constants.GastrolienalLigament);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lienal Artery");
		property.setCanonicalName(Constants.LienalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Pulp Vein");
		property.setCanonicalName(Constants.PulpVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Trabecular Artery");
		property.setCanonicalName(Constants.TrabecularArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Trabecular Vein");
		property.setCanonicalName(Constants.TrabecularVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Phrenicolienal Ligament");
		property.setCanonicalName(Constants.PhrenicolienalLigament);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Splenic Pulp");
		property.setCanonicalName(Constants.SplenicPulp);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Splenic Cord");
		property.setCanonicalName(Constants.SplenicChord); 
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Splenic Sinus");
		property.setCanonicalName(Constants.SplenicSinus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lymphatic Vessels");
		property.setCanonicalName(Constants.LymphaticVessels);
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
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Bladder);
		method.setMethodName("Leukocytes: ");
		method.setDisplayName("Leukocyte Count");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Bladder);
		method.setMethodName("Monocytes:");
		method.setDisplayName("Monocyte Count");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
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
		System.out.println("Spleen-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			//System.out.println("Spleen-Executing Methods: " + j);
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			//System.out.println("Have BioMightMethod for Spleen: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
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
			if (canonicalName.equals(Constants.Spleen)) {				
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
				System.out.println("Spleen Methods have fired!");
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
		
		// Assembe the Spleen
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Spleen.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Spleen'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = externalSerousCoat.getX3D(true);  
		//System.out.println("Spleen X3D: " + body);		
		
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
	
	
	public void rupture()
	{
	}


	public SpleenExternalSerousCoat getExternalSerousCoat() {
		return externalSerousCoat;
	}


	public void setExternalSerousCoat(SpleenExternalSerousCoat externalSerousCoat) {
		this.externalSerousCoat = externalSerousCoat;
	}


	public SpleenFibroelasticCoat getFibroelasticCoat() {
		return fibroelasticCoat;
	}


	public void setFibroelasticCoat(SpleenFibroelasticCoat fibroelasticCoat) {
		this.fibroelasticCoat = fibroelasticCoat;
	}


	public GastrolienalLigament getGastrolienalLigament() {
		return gastrolienalLigament;
	}


	public void setGastrolienalLigament(GastrolienalLigament gastrolienalLigament) {
		this.gastrolienalLigament = gastrolienalLigament;
	}


	public LymphaticVessels getLymphaticVessels() {
		return lymphaticVessels;
	}


	public void setLymphaticVessels(LymphaticVessels lymphaticVessels) {
		this.lymphaticVessels = lymphaticVessels;
	}


	public MalpighianBodies getMalpighianBodies() {
		return malpighianBodies;
	}


	public void setMalpighianBodies(MalpighianBodies malpighianBodies) {
		this.malpighianBodies = malpighianBodies;
	}


	public PhrenicolienalLigament getPhrenicolienalLigament() {
		return phrenicolienalLigament;
	}


	public void setPhrenicolienalLigament(
			PhrenicolienalLigament phrenicolienalLigament) {
		this.phrenicolienalLigament = phrenicolienalLigament;
	}


	public PulpVein getPulpVein() {
		return pulpVein;
	}


	public void setPulpVein(PulpVein pulpVein) {
		this.pulpVein = pulpVein;
	}


	public SplenicCord getSplenicCord() {
		return splenicCord;
	}


	public void setSplenicCord(SplenicCord splenicCord) {
		this.splenicCord = splenicCord;
	}


	public SplenicPulp getSplenicPulp() {
		return splenicPulp;
	}


	public void setSplenicPulp(SplenicPulp splenicPulp) {
		this.splenicPulp = splenicPulp;
	}


	public SplenicSinus getSplenicSinus() {
		return splenicSinus;
	}


	public void setSplenicSinus(SplenicSinus splenicSinus) {
		this.splenicSinus = splenicSinus;
	}


	public TrabecularArtery getTrabecularArtery() {
		return trabecularArtery;
	}


	public void setTrabecularArtery(TrabecularArtery trabecularArtery) {
		this.trabecularArtery = trabecularArtery;
	}


	public TrabecularVein getTrabecularVein() {
		return trabecularVein;
	}


	public void setTrabecularVein(TrabecularVein trabecularVein) {
		this.trabecularVein = trabecularVein;
	}
	
}
