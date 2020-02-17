/*
2 * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.arm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.ligament.radius.AnnularLigament;
import biomight.system.muscular.PalmarisLongusMuscle;
import biomight.system.muscular.arm.AnconeusMuscle;
import biomight.system.muscular.arm.BicepsBrachiiMuscle;
import biomight.system.muscular.arm.BrachialisMuscle;
import biomight.system.muscular.arm.BrachioradialisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisBrevisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisLongusMuscle;
import biomight.system.muscular.arm.ExtensorCarpiUlnarisMuscle;
import biomight.system.muscular.arm.ExtensorDigitiMinimiMuscle;
import biomight.system.muscular.arm.ExtensorDigitorumMuscle;
import biomight.system.muscular.arm.ExtensorPollicisLongusMuscle;
import biomight.system.muscular.arm.TricepsBrachiiMuscle;
import biomight.system.muscular.forearm.FlexorDigitorumProfundusMuscle;
import biomight.system.muscular.forearm.FlexorDigitorumSuperficialisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisBrevisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisLongusMuscle;
import biomight.system.skeletal.arm.Humerus;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.arm.AnteriorCircumflexHumeralArteries;
import biomight.system.vascular.arteries.arm.AnteriorCircumflexHumeralArtery;
import biomight.system.vascular.arteries.arm.BrachialArtery;
import biomight.system.vascular.arteries.arm.DeepBrachialArteries;
import biomight.system.vascular.arteries.arm.DeepBrachialArtery;
import biomight.system.vascular.arteries.arm.InferiorUlnarCollateralArteries;
import biomight.system.vascular.arteries.arm.InferiorUlnarCollateralArtery;
import biomight.system.vascular.arteries.arm.MiddleCollateralArteries;
import biomight.system.vascular.arteries.arm.MiddleCollateralArtery;
import biomight.system.vascular.arteries.arm.PosteriorCircumflexHumeralArtery;
import biomight.system.vascular.arteries.arm.RadialCollateralArteries;
import biomight.system.vascular.arteries.arm.RadialCollateralArtery;
import biomight.system.vascular.arteries.arm.SuperiorUlnarCollateralArteries;
import biomight.system.vascular.arteries.arm.SuperiorUlnarCollateralArtery;
import biomight.system.vascular.veins.arm.AccessoryCephalicVein;
import biomight.system.vascular.veins.arm.BasilicVein;
import biomight.system.vascular.veins.arm.BrachialVein;
import biomight.system.vascular.veins.arm.CephalicVein;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;


/**
 * @author SurferJim
 *
 * Representation of the Arm
 */

public class Arm extends BioMightBase {
	protected EpitheliumTissue epithelium;

	
	// Muscles
	private AnconeusMuscle anconeusMuscle;
	private BrachialisMuscle brachialisMuscle;
	private BicepsBrachiiMuscle bicepsBrachiiMuscle;
	private TricepsBrachiiMuscle tricepsBrachiiMuscle;
	private BrachioradialisMuscle brachioradialisMuscle;
	private ExtensorCarpiRadialisBrevisMuscle extensorCarpiRadialisBrevisMuscle;
	private ExtensorCarpiRadialisLongusMuscle extensorCarpiRadialisLongusMuscle;
	private ExtensorCarpiUlnarisMuscle extensorCarpiUlnarisMuscle;
	private ExtensorDigitiMinimiMuscle extensorDigitiMinimiMuscle;
	private ExtensorDigitorumMuscle extensorDigitorumMuscle;
	private ExtensorPollicisLongusMuscle extensorPollicisLongusMuscle;
	private FlexorDigitorumProfundusMuscle flexorDigitorumProfundusMuscle;
	private FlexorDigitorumSuperficialisMuscle flexorDigitorumSuperficialisMuscle;
	private FlexorPollicisLongusMuscle flexorPollicisLongusMuscle;
	private FlexorPollicisBrevisMuscle flexorPollicisBrevisMuscle;
	private PalmarisLongusMuscle palmarisLongusMuscle;
	
	// Ligaments
	private AnnularLigament annularLigament;
	
	
	// Bones
	private Humerus humerus;

	// Vessels
	private AccessoryCephalicVein accessoryCephalicVein;
	private BrachialVein brachialVein;
	private BrachialArtery brachialArtery;
	private DeepBrachialArtery deepBrachialArtery;
	private AnteriorCircumflexHumeralArtery anteriorCircumflexHumeralArtery;
	private PosteriorCircumflexHumeralArtery posteriorCircumflexHumeralArtery;

	private SuperiorUlnarCollateralArtery superiorUlnarCollateralArtery;
	private InferiorUlnarCollateralArtery inferiorUlnarCollateralArtery;
	private MiddleCollateralArtery middleCollateralArtery;
	private RadialCollateralArtery radialCollateralArtery;

	private BasilicVein basilicVein;	
	private CephalicVein cephalicVein;
	

	/********************************************************************
	 * ARM CONSTRUCTOR
	 * 
	 * @param parentID
	 * @param bioMightConstruct
	 * @param bioMightMethods
	 *******************************************************************************/
	public Arm()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ArmRef, null, null);
	}

	/************************************************************************
	 * Arm Constructor 
	 *
	 ***********************************************************************/
	public Arm(String parentID)
	{
		//System.out.println("Calling parameterized Arm Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Arm Constructor 
	 *
	 ***********************************************************************/
	public Arm(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Arm with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Arm
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Arm.gif");
		setImageWidth(200);
		setImageHeight(150);

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Neck
		// Either get from the Constructor or set up defaults
		System.out.println("Arm - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Arm - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Arm - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Arm - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Arm - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
		
		componentID = parentID;
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				//System.out.println("NEED TO EXECUTE Arm METHODS: " + bioMightMethods.size());
			}
	
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Arm.x3d";
		
			
			/*
			System.out.println("In Arm - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Arm - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Arm - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Arm - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.ArmEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Arm - Constructor has Epithelium BoundBox: " + Constants.ArmEpitheliumRef);
			else
				System.out.println("In Arm - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.ArmEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.ArmEpitheliumRef, tempBoundBox);		
			System.out.println("In Arm - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Arm we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftArmRef)) 
			{
				startID="ArmEpithelium:00001";
			}			
			// We are creating the Esophagus for the Arm
			else if (parentID.equals(Constants.RightArmRef)) 
			{	
				startID="ArmEpithelium:00480";
			}
		
			System.out.println("Creating Arm Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.ArmEpitheliumRef,  Constants.ArmEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Arm - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.ArmEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("ArmEpithelium is created");
			
				
			// Bones
			System.out.println("Creating Humerus for parent: " + parentID);
			humerus = new Humerus(localVP, localLOD, parentID, null, bioMightMethods);
			initProperty("Humerus", Constants.Humerus, Constants.HumerusRef, humerus.getComponentID());
			System.out.println("Created Humerus");

			// Muscles
			System.out.println("Creating BrachialisMuscle for parent: " + parentID);
			brachialisMuscle = new BrachialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BrachialisMuscle", Constants.BrachialisMuscle, Constants.BrachialisMuscleRef, brachialisMuscle.getComponentID());
			System.out.println("Created BrachialBrachialisMuscleArtery");
			
			System.out.println("Creating the TricepsBrachiiMuscle for parent: " + parentID);
			tricepsBrachiiMuscle = new TricepsBrachiiMuscle(parentID, bioMightMethods);
			initProperty("TricepsBrachiiMuscle", Constants.TricepsBrachiiMuscle, Constants.TricepsBrachiiMuscleRef, tricepsBrachiiMuscle.getComponentID());
			System.out.println("Created the TricepsBrachiiMuscle");
			
			System.out.println("Creating the BicepsBrachiiMuscle for parent: " + parentID);
			bicepsBrachiiMuscle = new BicepsBrachiiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BicepsBrachiiMuscle", Constants.BicepsBrachiiMuscle, Constants.BicepsBrachiiMuscleRef, bicepsBrachiiMuscle.getComponentID());
			System.out.println("Created the BicepsBrachiiMuscle");
			
			System.out.println("Creating the BrachioradialisMuscle for parent: " + parentID);
			brachioradialisMuscle = new BrachioradialisMuscle(parentID, bioMightMethods);
			initProperty("BrachioradialisMuscle", Constants.BrachioradialisMuscle, Constants.BrachioradialisMuscleRef, brachioradialisMuscle.getComponentID());
			System.out.println("Created the BrachioradialisMuscle");
			
			System.out.println("Creating the ExtensorCarpiRadialisBrevisMuscle for parent: " + parentID);
			extensorCarpiRadialisBrevisMuscle = new ExtensorCarpiRadialisBrevisMuscle(parentID, bioMightMethods);
			initProperty("ExtensorCarpiRadialisBrevisMuscle", Constants.ExtensorCarpiRadialisBrevisMuscle, Constants.ExtensorCarpiRadialisBrevisMuscleRef, extensorCarpiRadialisBrevisMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiRadialisBrevisMuscle");
	
			System.out.println("Creating the ExtensorCarpiRadialisLongusMuscle for parent: " + parentID);
			extensorCarpiRadialisLongusMuscle = new ExtensorCarpiRadialisLongusMuscle(parentID, bioMightMethods);
			initProperty("ExtensorCarpiRadialisLongusMuscle", Constants.ExtensorCarpiRadialisLongusMuscle, Constants.ExtensorCarpiRadialisLongusMuscleRef, extensorCarpiRadialisLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiRadialisLongusMuscle");
	
			System.out.println("Creating the ExtensorCarpiUlnarisMuscle for parent: " + parentID);
			extensorCarpiUlnarisMuscle = new ExtensorCarpiUlnarisMuscle(parentID, bioMightMethods);
			initProperty("ExtensorCarpiUlnarisMuscle", Constants.ExtensorCarpiUlnarisMuscle, Constants.ExtensorCarpiUlnarisMuscleRef, extensorCarpiUlnarisMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiRadialisLongusMuscle");
	
			System.out.println("Creating the PalmarisLongusMuscle for parent: " + parentID);
			palmarisLongusMuscle = new PalmarisLongusMuscle(parentID, bioMightMethods);
			initProperty("PalmarisLongusMuscle", Constants.PalmarisLongusMuscle, Constants.PalmarisLongusMuscleRef, palmarisLongusMuscle.getComponentID());
			System.out.println("Created the PalmarisLongusMuscle");

			System.out.println("Creating the ExtensorDigitiMinimiMuscle for parent: " + parentID);
			extensorDigitiMinimiMuscle = new ExtensorDigitiMinimiMuscle(parentID, bioMightMethods);
			initProperty("ExtensorDigitiMinimiMuscle", Constants.ExtensorDigitiMinimiMuscle, Constants.ExtensorDigitiMinimiMuscleRef, extensorDigitiMinimiMuscle.getComponentID());
			System.out.println("Created the ExtensorDigitiMinimiMuscle");

			System.out.println("Creating the ExtensorDigitorumMuscle for parent: " + parentID);
			extensorDigitorumMuscle = new ExtensorDigitorumMuscle(parentID, bioMightMethods);
			initProperty("ExtensorDigitorumMuscle", Constants.ExtensorDigitorumMuscle, Constants.ExtensorDigitorumMuscleRef, extensorDigitorumMuscle.getComponentID());
			System.out.println("Created the ExtensorDigitorumMuscle");

			System.out.println("Creating the ExtensorPollicisLongusMuscle for parent: " + parentID);
			extensorPollicisLongusMuscle = new ExtensorPollicisLongusMuscle(parentID, bioMightMethods);
			initProperty("ExtensorPollicisLongusMuscle", Constants.ExtensorPollicisLongusMuscle, Constants.ExtensorPollicisLongusMuscleRef, extensorPollicisLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorPollicisLongusMuscle");

			System.out.println("Creating the FlexorDigitorumProfundusMuscle for parent: " + parentID);
			flexorDigitorumProfundusMuscle = new FlexorDigitorumProfundusMuscle(parentID, bioMightMethods);
			initProperty("FlexorDigitorumProfundusMuscle", Constants.FlexorDigitorumProfundusMuscle, Constants.FlexorDigitorumProfundusMuscleRef, flexorDigitorumProfundusMuscle.getComponentID());
			System.out.println("Created the FlexorDigitorumProfundusMuscle");
			
			System.out.println("Creating the FlexorDigitorumSuperficialisMuscle for parent: " + parentID);
			flexorDigitorumSuperficialisMuscle = new FlexorDigitorumSuperficialisMuscle(parentID, bioMightMethods);
			initProperty("FlexorDigitorumSuperficialisMuscle", Constants.FlexorDigitorumSuperficialisMuscle, Constants.FlexorDigitorumSuperficialisMuscleRef, flexorDigitorumSuperficialisMuscle.getComponentID());
			System.out.println("Created the FlexorDigitorumSuperficialisMuscle");
		
			System.out.println("Creating the FlexorPollicisLongusMuscle for parent: " + parentID);
			flexorPollicisLongusMuscle = new FlexorPollicisLongusMuscle(parentID, bioMightMethods);
			initProperty("FlexorPollicisLongusMuscle", Constants.FlexorPollicisLongusMuscle, Constants.FlexorPollicisLongusMuscleRef, flexorPollicisLongusMuscle.getComponentID());
			System.out.println("Created the FlexorPollicisLongusMuscle");
		
			System.out.println("Creating the FlexorPollicisBrevisMuscle for parent: " + parentID);
			flexorPollicisBrevisMuscle = new FlexorPollicisBrevisMuscle(parentID, bioMightMethods);
			initProperty("flexorPollicisBrevisMuscle", Constants.FlexorPollicisBrevisMuscle, Constants.FlexorPollicisBrevisMuscleRef, flexorPollicisBrevisMuscle.getComponentID());
			System.out.println("Created the FlexorPollicisBrevisMuscle");
			
			// Vascular

			localVP = Constants.VIEW_DETACHED;
			localLOD = Constants.MAG1X;

			System.out.println("Creating the BrachialArtery for parent: " + parentID);
			brachialArtery = new BrachialArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BrachialArtery", Constants.BrachialArtery, Constants.BrachialArteryRef, brachialArtery.getComponentID());
			System.out.println("Created the BrachialArtery");

			System.out.println("Creating the BrachialArtery for parent: " + parentID);
			deepBrachialArtery = new DeepBrachialArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DeepBrachialArtery", Constants.DeepBrachialArtery, Constants.DeepBrachialArteryRef, deepBrachialArtery.getComponentID());
			System.out.println("Created the DeepBrachialArtery");
			
			System.out.println("Creating the AnteriorCircumflexHumeralArtery for ParentID: " + parentID);
			anteriorCircumflexHumeralArtery = new AnteriorCircumflexHumeralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorCircumflexHumeralArteryRef, Constants.AnteriorCircumflexHumeralArtery, Constants.AnteriorCircumflexHumeralArteryRef, anteriorCircumflexHumeralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorCircumflexHumeralArtery");
		
			System.out.println("Creating the PosteriorCircumflexHumeralArtery for ParentID: " + parentID);
			posteriorCircumflexHumeralArtery = new PosteriorCircumflexHumeralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorCircumflexHumeralArteryRef, Constants.PosteriorCircumflexHumeralArtery, Constants.PosteriorCircumflexHumeralArteryRef, posteriorCircumflexHumeralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorCircumflexHumeralArtery");

			System.out.println("Creating the SuperiorUlnarCollateralArtery for ParentID: " + parentID);
			superiorUlnarCollateralArtery = new SuperiorUlnarCollateralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorUlnarCollateralArteryRef, Constants.SuperiorUlnarCollateralArtery, Constants.SuperiorUlnarCollateralArteryRef, superiorUlnarCollateralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorUlnarCollateralArtery");

			System.out.println("Creating the InferiorUlnarCollateralArtery for ParentID: " + parentID);
			inferiorUlnarCollateralArtery = new InferiorUlnarCollateralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorUlnarCollateralArteryRef, Constants.InferiorUlnarCollateralArtery, Constants.InferiorUlnarCollateralArteryRef, inferiorUlnarCollateralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorUlnarCollateralArtery");

			System.out.println("Creating the RadialCollateralArtery for ParentID: " + parentID);
			radialCollateralArtery = new RadialCollateralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.RadialCollateralArteryRef, Constants.RadialCollateralArtery, Constants.RadialCollateralArteryRef, radialCollateralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RadialCollateralArtery");
		
			System.out.println("Creating the MiddleCollateralArtery for ParentID: " + parentID);
			middleCollateralArtery = new MiddleCollateralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MiddleCollateralArteryRef, Constants.MiddleCollateralArtery, Constants.MiddleCollateralArteryRef, middleCollateralArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MiddleCollateralArtery");
		
			System.out.println("Creating the BrachialVein for parent: " + parentID);
			brachialVein = new BrachialVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BrachialVein", Constants.BrachialVein, Constants.BrachialVeinRef, brachialVein.getComponentID());
			System.out.println("Created the BrachialVein");

			System.out.println("Creating the BasilicVein for parent: " + parentID);
			basilicVein = new BasilicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BasilicVein, Constants.BasilicVeinRef, basilicVein.getComponentID());
	
			System.out.println("Creating the BrachioCephalicArtery for parent: " + parentID);
			cephalicVein = new CephalicVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CephalicVein", Constants.CephalicVein, Constants.CephalicVeinRef, cephalicVein.getComponentID());
			System.out.println("Created the CephalicVein");
	
			
			localVP = Constants.VIEW_HAWKEYE;
			localLOD = Constants.MAG1X;

			
		
			//System.out.println("Creating the AnnularLigament for parent: " + parentID);
			//annularLigament = new AnnularLigament(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			//initProperty("AnnularLigament", Constants.AnnularLigament, Constants.AnnularLigamentRef, annularLigament.getComponentID());
			//System.out.println("Created the AnnularLigament");

			
			
			System.out.println("Created the Arm");
			
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}

	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		// BONES
		property = new BioMightPropertyView();
		property.setPropertyName("Humerus");
		property.setCanonicalName(Constants.Humerus);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ulna");
		property.setCanonicalName(Constants.Ulna);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Radius");
		property.setCanonicalName(Constants.Radius);
		properties.add(property);	
		
		// MUSCLES
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Anconeus Muscle");
		property.setCanonicalName(Constants.AnconeusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Brachialis Muscle");
		property.setCanonicalName(Constants.BrachialisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Triceps Brachii Muscle");
		property.setCanonicalName(Constants.TricepsBrachiiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Brachioradialis Muscle");
		property.setCanonicalName(Constants.BrachioradialisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Radialis Brevis Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisBrevisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Radialis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Ulnaris Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiUlnarisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Digiti Minimi");
		property.setCanonicalName(Constants.ExtensorDigitiMinimiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Digitorum Muscle");
		property.setCanonicalName(Constants.ExtensorDigitorumMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Digitorum Profundus Muscle");
		property.setCanonicalName(Constants.FlexorDigitorumProfundusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Digitorum Superficialis Muscle");
		property.setCanonicalName(Constants.FlexorDigitorumSuperficialisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.ExtensorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Pollicis Longus Muscle");
		property.setCanonicalName(Constants.FlexorPollicisLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Pollicis Brevis Muscle");
		property.setCanonicalName(Constants.FlexorPollicisBrevisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Palmaris Longus Muscle");
		property.setCanonicalName(Constants.PalmarisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Supinator Muscle");
		property.setCanonicalName(Constants.SupinatorMuscle);
		properties.add(property);		

		// LIGAMENTS
		property = new BioMightPropertyView();
		property.setPropertyName("Ligaments");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Annular Ligament");
		property.setCanonicalName(Constants.AnnularLigament);
		properties.add(property);		
		
		// VESSELS
		property = new BioMightPropertyView();
		property.setPropertyName("Vascular");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Accessory Cephalic Vein");
		property.setCanonicalName(Constants.AccessoryCephalicVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Brachial Vein");
		property.setCanonicalName(Constants.BrachialVein);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Basilic Vein");
		property.setCanonicalName(Constants.BasilicVein);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("BrachioCephalic Artery");
		property.setCanonicalName(Constants.BrachioCephalicArtery);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Cephalic Vein");
		property.setCanonicalName(Constants.CephalicVein);
		properties.add(property);		
	}
	
	
	public void initMethods() {
  
	
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Flex");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Punch");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Block");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Swing");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);	
	}
		
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Arm.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Arm
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Arm.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Arm'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
			epithelium.getX3D(true) + 
			humerus.getX3D(true) +  
			brachialArtery.getX3D(true) +
			deepBrachialArtery.getX3D(true) +
			anteriorCircumflexHumeralArtery.getX3D(true) +
			posteriorCircumflexHumeralArtery.getX3D(true) +
			superiorUlnarCollateralArtery.getX3D(true) +
			inferiorUlnarCollateralArtery.getX3D(true) +
			middleCollateralArtery.getX3D(true) +
			radialCollateralArtery.getX3D(true) +
			brachialVein.getX3D(true) +
			basilicVein.getX3D(true) +
			cephalicVein.getX3D(true) +
			brachialisMuscle.getX3D(true) +
			bicepsBrachiiMuscle.getX3D(true) + 
			tricepsBrachiiMuscle.getX3D(true) +
			brachioradialisMuscle.getX3D(true) +
			extensorCarpiRadialisBrevisMuscle.getX3D(true) +
			extensorCarpiRadialisLongusMuscle.getX3D(true) +
			extensorCarpiUlnarisMuscle.getX3D(true) +
			palmarisLongusMuscle.getX3D(true) ;
			/***
			extensorDigitiMinimiMuscle.getX3D(true) +
			extensorDigitorumMuscle.getX3D(true) +
			extensorPollicisLongusMuscle.getX3D(true) +
			flexorDigitorumProfundusMuscle.getX3D(true) +
			flexorDigitorumSuperficialisMuscle.getX3D(true) +
			flexorPollicisLongusMuscle.getX3D(true) +
			flexorPollicisBrevisMuscle.getX3D(true)+
			annularLigament.getX3D(true) ; 
			****/
	
		//System.out.println("Arm X3D: " + body);		
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Arm.  
	 * This routine will be called when looking at an individual Arm with
	 * default values
	 * 
	 * @return
	 ****************************************************************************/
	private BioMightBoundBox setupDefaultBoundBox(String parentID) 
	{
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		
		//**********************************************************************
		// ARMS BOUND BOX		
		//
		// Set up the Bounding Box for the Arms
		// For default model, length of arms is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);
		
		// Setup the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// ARM - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ArmEpitheliumRef, bioMightConnector);
	
		//********************************************	
		// ARMS - VASCULAR CONNECTORS  
		//********************************************
	
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// ARMS - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// ARMS - SKELETAL CONNECTORS
		//********************************************

		// ThoracicVertebrae T6 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		
		// Stuff the Connectors into the Bounding Box 
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		return (bioBoundBox);	
	}	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Arm.   These boxes will define
	 *  the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBoxIn) 
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes
		HashMap boundingBoxMap = new HashMap();
		
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
			
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);

		// Initialize the BoundBoxes. This is used for
		// collections such as arms, legs,lungs,etc
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;

		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			System.out.println("Arm - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Arm
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-12.0);
		zPos= new BigDecimal(-1.0);
		
		xVector= new BigDecimal(9.0);
		yVector= new BigDecimal(8.0); 
		zVector= new BigDecimal(4.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Arm Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -9.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ArmEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("ArmEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		boundingBoxMap.put(Constants.ArmEpitheliumRef, bioBoundBox);
		
		
		

		//********************************************************************* 
		// ARMS BOUND BOXES
		// Set up the Bounding Box for the Bronchi
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT ARMS BOUNDBOX
		// Set up the Bounding Box for the Left Arm
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBoxes = new BioMightBoundBoxes();
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ArmEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftArmRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT ARMS BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ArmEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightArmRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Bronchi 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.BronchiRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}
	
	
	
	public AccessoryCephalicVein getAccessoryCephalicVein() {
		return accessoryCephalicVein;
	}

	public void setAccessoryCephalicVein(AccessoryCephalicVein accessoryCephalicVein) {
		this.accessoryCephalicVein = accessoryCephalicVein;
	}

	public AnconeusMuscle getAnconeusMuscle() {
		return anconeusMuscle;
	}

	public void setAnconeusMuscle(AnconeusMuscle anconeusMuscle) {
		this.anconeusMuscle = anconeusMuscle;
	}

	public AnnularLigament getAnnularLigament() {
		return annularLigament;
	}

	public void setAnnularLigament(AnnularLigament annularLigament) {
		this.annularLigament = annularLigament;
	}

	public BasilicVein getBasilicVein() {
		return basilicVein;
	}

	public void setBasilicVein(BasilicVein basilicVein) {
		this.basilicVein = basilicVein;
	}

	public BrachialisMuscle getBrachialisMuscle() {
		return brachialisMuscle;
	}

	public void setBrachialisMuscle(BrachialisMuscle brachialisMuscle) {
		this.brachialisMuscle = brachialisMuscle;
	}

	public BrachialVein getBrachialVein() {
		return brachialVein;
	}

	public void setBrachialVein(BrachialVein brachialVein) {
		this.brachialVein = brachialVein;
	}

	public BrachioradialisMuscle getBrachioradialisMuscle() {
		return brachioradialisMuscle;
	}

	public CephalicVein getCephalicVein() {
		return cephalicVein;
	}

	public void setCephalicVein(CephalicVein cephalicVein) {
		this.cephalicVein = cephalicVein;
	}

	public ExtensorCarpiRadialisBrevisMuscle getExtensorCarpiRadialisBrevisMuscle() {
		return extensorCarpiRadialisBrevisMuscle;
	}

	public void setExtensorCarpiRadialisBrevisMuscle(
			ExtensorCarpiRadialisBrevisMuscle extensorCarpiRadialisBrevisMuscle) {
		this.extensorCarpiRadialisBrevisMuscle = extensorCarpiRadialisBrevisMuscle;
	}

	public ExtensorCarpiRadialisLongusMuscle getExtensorCarpiRadialisLongusMuscle() {
		return extensorCarpiRadialisLongusMuscle;
	}

	public void setExtensorCarpiRadialisLongusMuscle(
			ExtensorCarpiRadialisLongusMuscle extensorCarpiRadialisLongusMuscle) {
		this.extensorCarpiRadialisLongusMuscle = extensorCarpiRadialisLongusMuscle;
	}

	public ExtensorCarpiUlnarisMuscle getExtensorCarpiUlnarisMuscle() {
		return extensorCarpiUlnarisMuscle;
	}

	public void setExtensorCarpiUlnarisMuscle(
			ExtensorCarpiUlnarisMuscle extensorCarpiUlnarisMuscle) {
		this.extensorCarpiUlnarisMuscle = extensorCarpiUlnarisMuscle;
	}


	public ExtensorDigitorumMuscle getExtensorDigitorumMuscle() {
		return extensorDigitorumMuscle;
	}

	public void setExtensorDigitorumMuscle(
			ExtensorDigitorumMuscle extensorDigitorumMuscle) {
		this.extensorDigitorumMuscle = extensorDigitorumMuscle;
	}

	public ExtensorPollicisLongusMuscle getExtensorPollicisLongusMuscle() {
		return extensorPollicisLongusMuscle;
	}

	public void setExtensorPollicisLongusMuscle(
			ExtensorPollicisLongusMuscle extensorPollicisLongusMuscle) {
		this.extensorPollicisLongusMuscle = extensorPollicisLongusMuscle;
	}

	public FlexorDigitorumProfundusMuscle getFlexorDigitorumProfundusMuscle() {
		return flexorDigitorumProfundusMuscle;
	}

	public void setFlexorDigitorumProfundusMuscle(
			FlexorDigitorumProfundusMuscle flexorDigitorumProfundusMuscle) {
		this.flexorDigitorumProfundusMuscle = flexorDigitorumProfundusMuscle;
	}

	public FlexorDigitorumSuperficialisMuscle getFlexorDigitorumSuperficialisMuscle() {
		return flexorDigitorumSuperficialisMuscle;
	}

	public void setFlexorDigitorumSuperficialisMuscle(
			FlexorDigitorumSuperficialisMuscle flexorDigitorumSuperficialisMuscle) {
		this.flexorDigitorumSuperficialisMuscle = flexorDigitorumSuperficialisMuscle;
	}

	public FlexorPollicisBrevisMuscle getFlexorPollicisBrevisMuscle() {
		return flexorPollicisBrevisMuscle;
	}

	public void setFlexorPollicisBrevisMuscle(
			FlexorPollicisBrevisMuscle flexorPollicisBrevisMuscle) {
		this.flexorPollicisBrevisMuscle = flexorPollicisBrevisMuscle;
	}

	public FlexorPollicisLongusMuscle getFlexorPollicisLongusMuscle() {
		return flexorPollicisLongusMuscle;
	}

	public void setFlexorPollicisLongusMuscle(
			FlexorPollicisLongusMuscle flexorPollicisLongusMuscle) {
		this.flexorPollicisLongusMuscle = flexorPollicisLongusMuscle;
	}

	public Humerus getHumerus() {
		return humerus;
	}

	public void setHumerus(Humerus humerus) {
		this.humerus = humerus;
	}

	public PalmarisLongusMuscle getPalmarisLongusMuscle() {
		return palmarisLongusMuscle;
	}

	public void setPalmarisLongusMuscle(PalmarisLongusMuscle palmarisLongusMuscle) {
		this.palmarisLongusMuscle = palmarisLongusMuscle;
	}

	public TricepsBrachiiMuscle getTricepsBrachiiMuscle() {
		return tricepsBrachiiMuscle;
	}

	public void setTricepsBrachiiMuscle(TricepsBrachiiMuscle tricepsBrachiiMuscle) {
		this.tricepsBrachiiMuscle = tricepsBrachiiMuscle;
	}
	
}
