package biomight.body.arm;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.muscular.forearm.AntiBrachialFascia;
import biomight.system.muscular.forearm.FlexorCarpiRadialisMuscle;
import biomight.system.muscular.forearm.FlexorCarpiUlnarisMuscle;
import biomight.system.muscular.forearm.PronatorQuadratusMuscle;
import biomight.system.muscular.forearm.PronatorTeresMuscle;
import biomight.system.muscular.forearm.SupinatorMuscle;
import biomight.system.skeletal.arm.Radius;
import biomight.system.skeletal.arm.Ulna;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.arm.RadialArtery;
import biomight.system.vascular.arteries.arm.UlnarArtery;
import biomight.system.vascular.veins.arm.AccessoryCephalicVein;
import biomight.system.vascular.veins.arm.BasilicVein;
import biomight.system.vascular.veins.arm.CephalicVein;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/*************************************************************************************
 * @author SurferJim
 *
 * Representation of the ForeArm 
 ************************************************************************************/

public class ForeArm extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	protected EpitheliumTissue epithelium;
	
	// Muscles
	private PronatorTeresMuscle pronatorTeresMuscle;
	private PronatorQuadratusMuscle pronatorQuadratusMuscle;
	private FlexorCarpiRadialisMuscle flexorCarpiRadialisMuscle;
	private FlexorCarpiUlnarisMuscle flexorCarpiUlnarisMuscle;
	private SupinatorMuscle supinatorMuscle;

	// Bones
	private Radius radius;
	private Ulna ulna;
	
	// Muscles
	
	// Vascular
	private UlnarArtery ulnarArtery;
	private RadialArtery radialArtery;	
	private AntiBrachialFascia antibrachialFascia;
	private CephalicVein cephalicVein;
	private AccessoryCephalicVein accessoryCephalicVein;
	private BasilicVein basilicVein;
	
	// Aponuerouses

	// Nerves
	
	
	public ForeArm()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ForeArmRef, null, null);
	}

	public ForeArm(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public ForeArm(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/ForeArm.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.viewPerspective = localVP;
		this.lod = localLOD;
		

		// Build the model based on what you are looking based on LOD
		// If called from the Arm, it will be getting the data
		// If called from the ForeArmArteries, it will not have to get data
		// If called from Drill-down, it needs to select by componnent
		if (viewPerspective == Constants.VIEW_DETACHED)			
		{
			System.out.println("In Create ForeArm - DETACHED VIEW");   	
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ForeArmInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ForeArmRef, parentID);
				System.out.println("Have ForeArm Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ForeArm");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ForeArms and build them into the model
			// In the default case, we get one instance of the ForeArm for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ForeArm NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created ForeArm: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating ForeArm Epithelium: " + bioMightTransform.getId());				
				epithelium = new EpitheliumTissue("ForeArmEpithelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("ForeArmEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());	
				//BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();

				// Vascular

				localVP = Constants.VIEW_DETACHED;
				localLOD = Constants.MAG1X;
				
				parentID=componentID;

				System.out.println("Creating the Ulna for parent: " + parentID);
				ulna = new Ulna(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("Ulna", Constants.Ulna, Constants.UlnaRef, ulna.getComponentID());
				System.out.println("Created the Ulna");

				System.out.println("Creating the Radius for parent: " + parentID);
				//radius = new Radius(localVP, localLOD,  parentID, bioMightProperties, bioMightMethods);
				//initProperty("Radius", Constants.Radius, Constants.RadiusRef, radius.getComponentID());
				System.out.println("Created the Radius");

				System.out.println("Creating the SupinatorMuscle for parent: " + parentID);
				supinatorMuscle = new SupinatorMuscle(parentID, bioMightMethods);
				initProperty("SupinatorMuscle", Constants.SupinatorMuscle, Constants.SupinatorMuscleRef, supinatorMuscle.getComponentID());
				System.out.println("Created the SupinatorMuscle");

				System.out.println("Creating the FlexorCarpiUlnarisMuscle for parent: " + parentID);
				flexorCarpiUlnarisMuscle = new FlexorCarpiUlnarisMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				System.out.println("Created the FlexorCarpiUlnarisMuscle");
			
				// VEINS
				System.out.println("Creating the BasilicVein for parent: " + parentID);
				basilicVein = new BasilicVein(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.BasilicVein, Constants.BasilicVeinRef, basilicVein.getComponentID());
				System.out.println("Created the BasilicVein");
				
				System.out.println("Creating the AccessoryCephalicVein for parent: " + parentID);
				accessoryCephalicVein = new AccessoryCephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("AccessoryCephalicVein", Constants.AccessoryCephalicVein, Constants.AccessoryCephalicVeinRef, accessoryCephalicVein.getComponentID());
				System.out.println("Created the AccessoryCephalicVein");
			
				System.out.println("Creating the CephalicVein for parent: " + parentID);
				cephalicVein = new CephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("CephalicVein", Constants.CephalicVein, Constants.CephalicVeinRef, cephalicVein.getComponentID());
				System.out.println("Created the CephalicVein");
	
				System.out.println("Creating the UlnarArtery for parent: " + parentID);
				ulnarArtery = new UlnarArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
				initProperty("UlnarArtery", Constants.UlnarArtery, Constants.UlnarArteryRef, ulnarArtery.getComponentID());
				System.out.println("Created the UlnarArtery");
				
				/*
					
				System.out.println("Creating the PronatorQuadratusMuscle for parent: " + parentID);
				pronatorQuadratusMuscle = new PronatorQuadratusMuscle(parentID, bioMightMethods);
				System.out.println("Created the PronatorQuadratusMuscle");
		
				*/
				
				System.out.println("ForeArm Instance is created : " + parentID);
				
			}
		}
		//
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In ForeArm Create() - ViewInternal - Already Set from: " + parentID);				

			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			
			// We already have the data for the current instance of ForeArm,
			// Go get the details for the current ForeArm is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				// Go get the finer details of the ForeArm				
				System.out.println("Getting the ForeArm MAG1X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating ForeArm Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("ForeArmEpithelium", parentID, bioMightMethods);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the ForeArm				
				System.out.println("Getting the ForeArm MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				System.out.println("Creating ForeArm Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("ForeArmEpithelium", parentID, bioMightMethods);
			}

		
		
			// Vascular

			localVP = Constants.VIEW_DETACHED;
			localLOD = Constants.MAG1X;

			System.out.println("Creating the Ulna for parent: " + parentID);
			ulna = new Ulna(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("Ulna", Constants.Ulna, Constants.UlnaRef, ulna.getComponentID());
			System.out.println("Created the Ulna");

			System.out.println("Creating the Radius for parent: " + parentID);
			//radius = new Radius(localVP, localLOD,  parentID, bioMightProperties, bioMightMethods);
			//initProperty("Radius", Constants.Radius, Constants.RadiusRef, radius.getComponentID());
			System.out.println("Created the Radius");

			System.out.println("Creating the SupinatorMuscle for parent: " + parentID);
			supinatorMuscle = new SupinatorMuscle(parentID, bioMightMethods);
			initProperty("SupinatorMuscle", Constants.SupinatorMuscle, Constants.SupinatorMuscleRef, supinatorMuscle.getComponentID());
			System.out.println("Created the SupinatorMuscle");

			System.out.println("Creating the FlexorCarpiUlnarisMuscle for parent: " + parentID);
			flexorCarpiUlnarisMuscle = new FlexorCarpiUlnarisMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			System.out.println("Created the FlexorCarpiUlnarisMuscle");
		
			System.out.println("Creating the BasilicVein for parent: " + parentID);
			basilicVein = new BasilicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BasilicVein, Constants.BasilicVeinRef, basilicVein.getComponentID());
			System.out.println("Created the BasilicVein");
			
			System.out.println("Creating the AccessoryCephalicVein for parent: " + parentID);
			accessoryCephalicVein = new AccessoryCephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AccessoryCephalicVein", Constants.AccessoryCephalicVein, Constants.AccessoryCephalicVeinRef, accessoryCephalicVein.getComponentID());
			System.out.println("Created the AccessoryCephalicVein");
		
			System.out.println("Creating the CephalicVein for parent: " + parentID);
			cephalicVein = new CephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CephalicVein", Constants.CephalicVein, Constants.CephalicVeinRef, cephalicVein.getComponentID());
			System.out.println("Created the CephalicVein");
			
			System.out.println("Creating the UlnarArtery for parent: " + parentID);
			ulnarArtery = new UlnarArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
			initProperty("UlnarArtery", Constants.UlnarArtery, Constants.UlnarArteryRef, ulnarArtery.getComponentID());
			System.out.println("Created the UlnarArtery");
			
			/*
				
			System.out.println("Creating the PronatorQuadratusMuscle for parent: " + parentID);
			pronatorQuadratusMuscle = new PronatorQuadratusMuscle(parentID, bioMightMethods);
			System.out.println("Created the PronatorQuadratusMuscle");
	
			*/
			
			System.out.println("ForeArm Instance is created : " + parentID);

			
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			//***************************************************************
			//***************************************************************
			// HACK!!!!!
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a ForeArm directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye ForeArmInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have ForeArm Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ForeArm");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ForeArm and build them into the model
			// In the default case, we get one instance of the ForeArm for each Arm
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ForeArm NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the ForeArm
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating ForeArm: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating ForeArm at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					System.out.println("Creating ForeArm Epithelium: " + parentID);				
					epithelium = new EpitheliumTissue("ForeArmEpithelium", parentID, bioMightMethods);

					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the ForeArm				
					System.out.println("Creating ForeArm at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating ForeArm -HawkEye 2X -  Epithelium: " + parentID);				
					epithelium = new EpitheliumTissue("ForeArmEpithelium", parentID, bioMightMethods);
				}
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				// Vascular

				localVP = Constants.VIEW_DETACHED;
				localLOD = Constants.MAG1X;

				System.out.println("Creating the Ulna for parent: " + parentID);
				ulna = new Ulna(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("Ulna", Constants.Ulna, Constants.UlnaRef, ulna.getComponentID());
				System.out.println("Created the Ulna");

				System.out.println("Creating the Radius for parent: " + parentID);
				//radius = new Radius(localVP, localLOD,  parentID, bioMightProperties, bioMightMethods);
				//initProperty("Radius", Constants.Radius, Constants.RadiusRef, radius.getComponentID());
				System.out.println("Created the Radius");

				System.out.println("Creating the SupinatorMuscle for parent: " + parentID);
				supinatorMuscle = new SupinatorMuscle(parentID, bioMightMethods);
				initProperty("SupinatorMuscle", Constants.SupinatorMuscle, Constants.SupinatorMuscleRef, supinatorMuscle.getComponentID());
				System.out.println("Created the SupinatorMuscle");

				System.out.println("Creating the FlexorCarpiUlnarisMuscle for parent: " + parentID);
				flexorCarpiUlnarisMuscle = new FlexorCarpiUlnarisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("Created the FlexorCarpiUlnarisMuscle");
			
				System.out.println("Creating the BasilicVein for parent: " + parentID);
				basilicVein = new BasilicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.BasilicVein, Constants.BasilicVeinRef, basilicVein.getComponentID());
				System.out.println("Created the BasilicVein");
				
				System.out.println("Creating the AccessoryCephalicVein for parent: " + parentID);
				accessoryCephalicVein = new AccessoryCephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("AccessoryCephalicVein", Constants.AccessoryCephalicVein, Constants.AccessoryCephalicVeinRef, accessoryCephalicVein.getComponentID());
				System.out.println("Created the AccessoryCephalicVein");
			
				System.out.println("Creating the CephalicVein for parent: " + parentID);
				cephalicVein = new CephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty("CephalicVein", Constants.CephalicVein, Constants.CephalicVeinRef, cephalicVein.getComponentID());
				System.out.println("Created the CephalicVein");
				
				System.out.println("Creating the UlnarArtery for parent: " + parentID);
				ulnarArtery = new UlnarArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
				initProperty("UlnarArtery", Constants.UlnarArtery, Constants.UlnarArteryRef, ulnarArtery.getComponentID());
				System.out.println("Created the UlnarArtery");
				
				/*
					
				System.out.println("Creating the PronatorQuadratusMuscle for parent: " + parentID);
				pronatorQuadratusMuscle = new PronatorQuadratusMuscle(parentID, bioMightMethods);
				System.out.println("Created the PronatorQuadratusMuscle");
		
				*/
				
				System.out.println("ForeArm Instance is created : " + parentID);

				
			}			
		}
		
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateForeArm Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ForeArm METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
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

	

	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the ForeArmEpithelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ForeArmEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double circumference = 0.0825;
		
			// ForeArm
			if (componentID.equals("ForeArm:01")) 
			{	
				// Generate the ForeArmEpithelium of the neck
				// Create 5 sections
				double[] startPos = {-8.60, -20.50, -1.75};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ForeArmEpithelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateForeArm("ForeArmEpithelium:00001", "ForeArmEpithelium", 
				//	"ForeArmEpithelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid  - Cervicle Region
			else if (componentID.equals("ForeArm:02")) 
			{	
				double[] startPos = {8.60, -20.50, -1.75};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ForeArmEpithelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateForeArm("ForeArmEpithelium:00160", "ForeArmEpithelium", 
				//	"ForeArmEpithelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ForeArmEpithelium NoParent");
							
			}
			
			System.out.println("Created ForeArmEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ForeArmEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the ForeArm.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the ForeArm
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ForeArm .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ForeArm '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting ForeArm X3D: ");	
		
		String body = "";

		if (viewPerspective == Constants.VIEW_DETACHED){
			System.out.println("Getting ForeArm X3D: VIEW_DETACHED ");
			String sensor= "<TouchSensor DEF='StartForeArm' \n" +
		                   " description='ForeArm '\n" +
			               " containerField='children'/> \n";
			
			//body = "<GROUP>" +
			//	epithelium.getX3D(true) + 	sensor +
			//	"</GROUP>";
			
			
			 body = 
					epithelium.getX3D(true) + 
					supinatorMuscle.getX3D(true) +
					ulna.getX3D(true) + 
					//radius.getX3D(true)+
					cephalicVein.getX3D(true) +
					accessoryCephalicVein.getX3D(true) +
					basilicVein.getX3D(true) +
				    ulnarArtery.getX3D(true);
				
			
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL){
			System.out.println("Getting ForeArm X3D:   VIEW_INTERNAL  ");
			String sensor= "<TouchSensor DEF='StartForeArm' \n" +
		                   " description='ForeArm '\n" +
			               " containerField='children'/> \n";
			 
			body = 
						epithelium.getX3D(true) + 
						supinatorMuscle.getX3D(true) +
						ulna.getX3D(true) + 
						//radius.getX3D(true)+
						cephalicVein.getX3D(true) +
						accessoryCephalicVein.getX3D(true) +
						basilicVein.getX3D(true) +
					    ulnarArtery.getX3D(true);
					
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE){
			
			String sensor= "<TouchSensor DEF='StartForeArm' \n" +
		                   " description='ForeArm '\n" +
			               " containerField='children'/> \n";
			
			 body = 
						epithelium.getX3D(true) + 
						supinatorMuscle.getX3D(true) +
						ulna.getX3D(true) + 
						//radius.getX3D(true)+
						cephalicVein.getX3D(true) +
						accessoryCephalicVein.getX3D(true) +
						basilicVein.getX3D(true) +
					    ulnarArtery.getX3D(true);
					
			
		}
		// We draw at this level -- need to add an algorithm that draws it as cylinders interlocking
		else if (viewPerspective == Constants.VIEW_FLOATING)
		{
			// Run through the collection of ForeArm  and build them into the model
			// In the default case, we get one instance of the ForeArm  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the ForeArm we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting ForeArm X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for ForeArm X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for ForeArm Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for ForeArm Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='ForeArm '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='ForeArm Shape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='ForeArm IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='ForeArm _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartForeArm' \n" +
					      " description='ForeArm '\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n" +
				 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				 "key='0 .5 1'\n" +
				 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='ForeArm' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("ForeArm X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
