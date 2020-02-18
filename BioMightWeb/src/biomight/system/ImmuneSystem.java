/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.Esophagus;
import biomight.body.gland.adrenal.AdrenalGlands;
import biomight.body.gland.spleen.Spleen;
import biomight.body.organ.kidney.Kidneys;
import biomight.body.organ.liver.Liver;
import biomight.body.organ.pancreas.Pancreas;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.body.organ.stomach.Stomach;
import biomight.body.organ.thymus.Thymus;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.cell.bloodandimmune.Eosinophils;
import biomight.cell.bloodandimmune.Leukocytes;
import biomight.cell.bloodandimmune.Lymphocytes;
import biomight.cell.bloodandimmune.Macrophages;
import biomight.cell.bloodandimmune.Monocytes;
import biomight.cell.bloodandimmune.Neutrophils;
import biomight.chemistry.compound.Thymosin;
import biomight.chemistry.protein.ComplementProteinC3B;
import biomight.chemistry.protein.ComplementProteinC6;
import biomight.chemistry.protein.ComplementProteinC7;
import biomight.chemistry.protein.ComplementProteinC8;
import biomight.chemistry.protein.ComplementProteinsC3B;
import biomight.chemistry.protein.ComplementProteinsC6;
import biomight.chemistry.protein.ComplementProteinsC7;
import biomight.chemistry.protein.ComplementProteinsC8;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.lymphatic.lymphnode.LymphNodes;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/**
 * @author SurferJim
 *
 * 
 */

public class ImmuneSystem extends BioMightBase {

	private int level = 100000;
	
	// Organs
	private Thymus thymus;
	private Liver liver;
	private Spleen spleen;
	private LymphNodes lymphNodes;
	private AdrenalGlands adrenalGlands;
	private Kidneys kidneys;
	
	
	// Number of elements
	private long numLeukocytes;
	private long numMonocytes;
	private long numMacrophages;
	private long numBasophils;
	private long numEosinophils;
	private long numNeutrophils;
	private long numLymphocytes;
	private long numThymosin;
	private long numComplementProteinsC3B;
	private long numComplementProteinsC6;
	private long numComplementProteinsC7;
	private long numComplementProteinsC8;
	
	// Elements that make up the immune system
	private Leukocytes leukocytes;
	private Monocytes monocytes;
	private Macrophages macrophages;
	private AnimalCells basophils;
	private Eosinophils eosinophils;
	private Neutrophils neutrophils;
	private Lymphocytes lymphocytes;

	private Thymosin thymosin;
	private ComplementProteinsC3B complementProteinsC3B;
	private ComplementProteinsC6 complementProteinsC6;
	private ComplementProteinsC7 complementProteinsC7;
	private ComplementProteinsC8 complementProteinsC8;

	private boolean isCompromised = false;
	
	// Humoral Immunity
	

	public ImmuneSystem(ImmuneSystemConfig immuneSystemConfig)
	{
		this.setImage("images/ImmuneSystem.jpg");	

		// If we are at Cellular level, instantiate the cells 
		//leukocytes = new Leukocytes(immuneSystemConfig.getNumLeukocytes());
		//monocytes = new Monocytes(immuneSystemConfig.getNumMonocytes());
		//macrophages = new Macrophages(immuneSystemConfig.getNumMacrophages());
		//basophils = new Basophils(immuneSystemConfig.getNumBasophils());
		//eosinophils = new Eosinophils(immuneSystemConfig.getNumEosinophils());
		//neutrophils = new Neutrophils(10);
		//lymphocytes = new Lymphocytes(10);
		
		// If we are the Molecular Level, instantiate the Complement
		if (level == biomight.Constants.MAG3X)
		{
			Thymosin thymosin;
			ComplementProteinC3B  complementProteinC3B;
			ComplementProteinC6 complementProteinC6;
			ComplementProteinC7 complementProteinC7;
			ComplementProteinC8 complementProteinC8;
		}
	}	

	

	/************************************************************************
	 * IMMUNE SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public ImmuneSystem()
	{
		System.out.print("Calling parameterized Organs Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ImmuneSystem, null, null);
	}

	public ImmuneSystem(String parentID)
	{
		System.out.print("Calling parameterized Organs Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public ImmuneSystem(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling ImmuneSystem : " + parentID);
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/ImmuneSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ImmuneSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ImmuneSystemRef, parentID);
			System.out.println("Have ImmuneSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ImmuneSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
			int localVP = Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Bacterias.x3d";
	
			
		// Run through the collection of ImmuneSystems and build them into the model
		// In the default case, we get one instance of the ImmuneSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("ImmuneSystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the ImmuneSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created ImmuneSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the ImmuneSystem Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}	
			
		
			// Create the Spleen
			//System.out.println("Creating the Esophagus for ParentID: " + bioMightTransform.getId());			
			spleen = new Spleen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedSpleen = spleen.getBioMightGenerate(); 
			initProperty(Constants.SpleenRef, Constants.Spleen, Constants.SpleenRef, spleen.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			System.out.println("Created the Spleen");
			
			// Create the Adrenal Glands
			//System.out.println("Creating the AdrenalGlands for ParentID: " + bioMightTransform.getId());			
			adrenalGlands = new AdrenalGlands(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedSpleen = spleen.getBioMightGenerate(); 
			initProperty(Constants.AdrenalGlandsRef, Constants.AdrenalGlands, Constants.AdrenalGlandsRef, adrenalGlands.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			System.out.println("Created the AdrenalGlands");
			
			// Create the Kidneys
			//System.out.println("Creating the Kidneys for ParentID: " + bioMightTransform.getId());			
			kidneys = new Kidneys(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedSpleen = spleen.getBioMightGenerate(); 
			initProperty(Constants.KidneysRef, Constants.Kidneys, Constants.KidneysRef, kidneys.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			System.out.println("Created the Kidneys");

		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateImmuneSystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ImmuneSystem METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/*******************************************************************
	 * GENERATE the ImmuneSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingImmuneSystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ImmuneSystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingImmuneSystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-8.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    			{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
	
				System.out.println("Calling Generate ImmuneSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateImmuneSystem("ImmuneSystemEndothelium:00001", "ImmuneSystemEndothelium", 
				//	"ImmuneSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("ImmuneSystemEndothelium:00001", "ImmuneSystemEndothelium", 
				//		"ImmuneSystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingImmuneSystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-14.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    			{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
	
				System.out.println("Calling Generate ImmuneSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateImmuneSystem("ImmuneSystemEndothelium:00080", "ImmuneSystemEndothelium", 
				//	"ImmuneSystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ImmuneSystemEndothelium NoParent");
							
			}
			
			System.out.println("Created ImmuneSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ImmuneSystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public ArrayList initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Mouth");
		property.setCanonicalName(Constants.Mouth);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Esophagus");
		property.setCanonicalName(Constants.Esophagus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Stomach");
		property.setCanonicalName(Constants.Stomach);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Liver");
		property.setCanonicalName(Constants.Liver);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Gall Bladder");
		property.setCanonicalName(Constants.GallBladder);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pancreas");
		property.setCanonicalName(Constants.Pancreas);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Intestines");
		property.setCanonicalName(Constants.Intestines);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SmallIntestine");
		property.setCanonicalName(Constants.SmallIntestine);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LargeIntestine");
		property.setCanonicalName(Constants.LargeIntestine);
		properties.add(property);
				
		return properties;
	}


	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}

	

	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Thymus:");
		property.setCanonicalName(Constants.Thymus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Liver");
		property.setCanonicalName(Constants.Liver);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Spleen");
		property.setCanonicalName(Constants.Spleen);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lymph Nodes");
		property.setCanonicalName(Constants.LymphNodes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Leukocytes");
		property.setCanonicalName(Constants.Leukocytes);
		properties.add(property);
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Monocytes");
		property.setCanonicalName(Constants.Monocytes);
		properties.add(property);
		

		property = new BioMightPropertyView();
		property.setPropertyName("Macrophages");
		property.setCanonicalName(Constants.Macrophages);
		properties.add(property);
		

		property = new BioMightPropertyView();
		property.setPropertyName("Basophils");
		property.setCanonicalName(Constants.Basophils);
		properties.add(property);
		

		property = new BioMightPropertyView();
		property.setPropertyName("Eosinophils");
		property.setCanonicalName(Constants.Eosinophils);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Neutrophils");
		property.setCanonicalName(Constants.Neutrophils);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lymphocytes");
		property.setCanonicalName(Constants.Lymphocytes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Thymosin");
		property.setCanonicalName(Constants.Thymosin);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ComplementProteinsC3B");
		property.setCanonicalName(Constants.ComplementProteinsC3B);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ComplementProteinsC6");
		property.setCanonicalName(Constants.ComplementProteinsC6);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ComplementProteinsC7");
		property.setCanonicalName(Constants.ComplementProteinsC7);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ComplementProteinsC8");
		property.setCanonicalName(Constants.ComplementProteinsC8);
		properties.add(property);
		
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Leukocytes: ");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Monocytes:");
		method.setHtmlType("text");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Macrophages:");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Macrophages:");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("Basophils:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Eosinophils:");
		method.setHtmlType("text");
		methods.add(method);	
				
		method = new BioMightMethodView();
		method.setMethodName("eutrophils:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Lymphocytes:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Thymosin:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("ComplementProteinsC3B:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("ComplementProteinsC6:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("ComplementProteinsC7:");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("ComplementProteinsC8:");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Comprised:");
		method.setHtmlType("checkbox");
		methods.add(method);
				
		return methods;
	}
		
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the BioMightSystems.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Abdomen
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ImmuneSystem.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ImmuneSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =
			spleen.getX3D(true) + adrenalGlands.getX3D(true) + kidneys.getX3D(true);
			//largeIntestine.getX3D(true) ;

		//System.out.println("ImmuneSystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	
	
	public void setComplementC3b()
	{
	}
	
	public void setComplementC6()
	{
	}
	
	public void setComplementC7()
	{
	}	

	public void setComplementC8()
	{
	}		

	public void setNeutrophilTiter()
	{
	}	
	
	public void setCD4Titer()
	{
	}

	public AnimalCells getBasophils() {
		return basophils;
	}

	public void setBasophils(AnimalCells basophils) {
		this.basophils = basophils;
	}

	public ComplementProteinsC3B getComplementProteinsC3B() {
		return complementProteinsC3B;
	}

	public void setComplementProteinsC3B(ComplementProteinsC3B complementProteinsC3B) {
		this.complementProteinsC3B = complementProteinsC3B;
	}

	public ComplementProteinsC6 getComplementProteinsC6() {
		return complementProteinsC6;
	}

	public void setComplementProteinsC6(ComplementProteinsC6 complementProteinsC6) {
		this.complementProteinsC6 = complementProteinsC6;
	}

	public ComplementProteinsC7 getComplementProteinsC7() {
		return complementProteinsC7;
	}

	public void setComplementProteinsC7(ComplementProteinsC7 complementProteinsC7) {
		this.complementProteinsC7 = complementProteinsC7;
	}

	public ComplementProteinsC8 getComplementProteinsC8() {
		return complementProteinsC8;
	}

	public void setComplementProteinsC8(ComplementProteinsC8 complementProteinsC8) {
		this.complementProteinsC8 = complementProteinsC8;
	}

	public Eosinophils getEosinophils() {
		return eosinophils;
	}

	public void setEosinophils(Eosinophils eosinophils) {
		this.eosinophils = eosinophils;
	}

	public Leukocytes getLeukocytes() {
		return leukocytes;
	}

	public void setLeukocytes(Leukocytes leukocytes) {
		this.leukocytes = leukocytes;
	}

	public Lymphocytes getLymphocytes() {
		return lymphocytes;
	}

	public void setLymphocytes(Lymphocytes lymphocytes) {
		this.lymphocytes = lymphocytes;
	}

	public Macrophages getMacrophages() {
		return macrophages;
	}

	public void setMacrophages(Macrophages macrophages) {
		this.macrophages = macrophages;
	}

	public Monocytes getMonocytes() {
		return monocytes;
	}

	public void setMonocytes(Monocytes monocytes) {
		this.monocytes = monocytes;
	}

	public Neutrophils getNeutrophils() {
		return neutrophils;
	}

	public void setNeutrophils(Neutrophils neutrophils) {
		this.neutrophils = neutrophils;
	}

	public Thymosin getThymosin() {
		return thymosin;
	}

	public void setThymosin(Thymosin thymosin) {
		this.thymosin = thymosin;
	}

	public Thymus getThymus() {
		return thymus;
	}

	public void setThymus(Thymus thymus) {
		this.thymus = thymus;
	}

	public long getNumBasophils() {
		return numBasophils;
	}

	public void setNumBasophils(long numBasophils) {
		this.numBasophils = numBasophils;
	}

	public long getNumEosinophils() {
		return numEosinophils;
	}

	public void setNumEosinophils(long numEosinophils) {
		this.numEosinophils = numEosinophils;
	}

	public long getNumLeukocytes() {
		return numLeukocytes;
	}

	public void setNumLeukocytes(long numLeukocytes) {
		this.numLeukocytes = numLeukocytes;
	}

	public long getNumLymphocytes() {
		return numLymphocytes;
	}

	public void setNumLymphocytes(long numLymphocytes) {
		this.numLymphocytes = numLymphocytes;
	}

	public long getNumMacrophages() {
		return numMacrophages;
	}

	public void setNumMacrophages(long numMacrophages) {
		this.numMacrophages = numMacrophages;
	}

	public long getNumMonocytes() {
		return numMonocytes;
	}

	public void setNumMonocytes(long numMonocytes) {
		this.numMonocytes = numMonocytes;
	}

	public long getNumNeutrophils() {
		return numNeutrophils;
	}

	public void setNumNeutrophils(long numNeutrophils) {
		this.numNeutrophils = numNeutrophils;
	}		
	
}
