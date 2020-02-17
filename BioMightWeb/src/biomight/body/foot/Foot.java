/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.foot;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.ligament.ankle.DeltoidLigament;
import biomight.system.ligament.ankle.LongPlantarLigament;
import biomight.system.muscular.foot.AbductorDigitiMinimiMuscle;
import biomight.system.muscular.foot.InterosselMuscle;
import biomight.system.muscular.foot.LumbriclesMuscle;
import biomight.system.muscular.foot.PlantarInterosseiMuscle;
import biomight.system.muscular.foot.QuadratusPlantaeMuscle;
import biomight.system.skeletal.foot.CalcaneusBone;
import biomight.system.skeletal.foot.CuboidBone;
import biomight.system.skeletal.foot.DistalPhalanages;
import biomight.system.skeletal.foot.MetaTarsalsBone;
import biomight.system.skeletal.foot.NavicularCuneiforms;
import biomight.system.skeletal.foot.ProximalPhalanges;
import biomight.system.skeletal.foot.TalusBone;
import biomight.system.skeletal.leg.Fibula;
import biomight.system.skeletal.leg.tibia.Tibia;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.foot.DeepPalmarArterialArch;
import biomight.system.vascular.arteries.foot.DorsalMetatarsalArteries;
import biomight.system.vascular.arteries.foot.LateralCalcanealArtery;
import biomight.system.vascular.arteries.foot.LateralPlantarArtery;
import biomight.system.vascular.arteries.foot.MedialCalcanealArtery;
import biomight.system.vascular.arteries.foot.MedialPlantarArtery;
import biomight.system.vascular.veins.foot.DorsalMetatarsalVeins;
import biomight.system.vascular.veins.foot.LateralMarginalVein;
import biomight.system.vascular.veins.foot.LateralPlantarVein;
import biomight.system.vascular.veins.foot.MedialMarginalVein;
import biomight.system.vascular.veins.foot.MedialPlantarVeins;
import biomight.system.vascular.veins.foot.PlantarMetatarsalVeins;
import biomight.system.vascular.veins.foot.PlantarVenousArch;
import biomight.system.vascular.veins.foot.SuperficialPalmarArch;
import biomight.system.vascular.veins.leg.DorsalisPedisVein;
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
import biomight.view.BioMightTransform;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Foot
 * 
 *****************************************************************************/

public class Foot extends BioMightBase {		
	protected EpitheliumTissue epithelium;	
	private Toes toes;
	private Heel heel;
	
	// Bones
	private Tibia tibia;
	private TalusBone talus;
	private CuboidBone cuboidBone;
	private DistalPhalanages distalPhalanages;
	private MetaTarsalsBone metaTarsals;
	private ProximalPhalanges proximalPhalanges;
	private Fibula fibula;
	private CalcaneusBone calcaneus;
	private NavicularCuneiforms navicularCuneiforms;

	// Ligaments that attach foot to ankle
	DeltoidLigament deltoidLigament;
	LongPlantarLigament LongPlantarLigament;
	//FirstDorsalCunconarvicLigament firstDorsalCunconarvicLigament;
		
	// Muscles
	private AbductorDigitiMinimiMuscle abductorDigitiMinimiMuscle;
	private InterosselMuscle interosselMuscle;
	private LumbriclesMuscle lumbriclesMuscle;
	private PlantarInterosseiMuscle plantarInterosselMuscle;
	private QuadratusPlantaeMuscle quadratusPlantaeMuscle;
	
	
	// Vascular Artery
	private DeepPalmarArterialArch deepPalmarArterialArch;
	private DorsalMetatarsalArteries dorsalMetatarsalArteries;
	private LateralCalcanealArtery lateralCalcanealArtery;
	private LateralPlantarArtery lateralPlantarArtery;
	private MedialCalcanealArtery medialCalcanealArtery;
	private MedialPlantarArtery medialPlantarArtery;
	
	
	private DorsalisPedisVein dorsalisPedisVein;
	private DorsalMetatarsalVeins dorsalMetatarsalVeins;
	private LateralMarginalVein lateralMarginalVein;
	private LateralPlantarVein lateralPlantarVein;
	private MedialMarginalVein medialMarginalVein;
	private MedialPlantarVeins medialPlantarVeins;
	private PlantarMetatarsalVeins plantarMetatarsalVeins;
	private PlantarVenousArch plantarVenousArch;
	private SuperficialPalmarArch superficialPalmarArch;
	
	
	
	
	public Foot()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.FootRef, null, null);
	}

	public Foot(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Foot(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Foot Create");
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
		this.setImage("images/Foot.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		componentID=parentID;
		
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Foot
		// Either get from the Constructor or set up defaults
		System.out.println("Foot - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Foot - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Foot - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Foot - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Foot - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/
		

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

	
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Foot METHODS: " + bioMightMethods.size());
			}
			
			/*
			System.out.println("In Foot - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Foot - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Foot - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Foot - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.FootEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Foot - Constructor has Epithelium BoundBox: " + Constants.FootEpitheliumRef);
			else
				System.out.println("In Foot - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.FootEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.FootEpitheliumRef, tempBoundBox);		
			System.out.println("In Foot - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Foot we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftFootRef)) 
			{
				startID="FootEpithelium:00001";
			}			
			// We are creating the Esophagus for the Foot
			else if (parentID.equals(Constants.RightFootRef)) 
			{	
				startID="FootEpithelium:00480";
			}
		
			System.out.println("Creating Foot Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.FootEpitheliumRef,  Constants.FootEpitheliumRef, parentID, bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			initProperty(Constants.FootEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Foot - Stored generateEpithelium in: " + componentID);
			
			System.out.println("FootEpithelium is created");			
	
			
			System.out.println("Creating the DeepPalmarArterialArch for ParentID: " + parentID);
			deepPalmarArterialArch = new DeepPalmarArterialArch(parentID, bioMightMethods);
			initProperty("DeepPalmarArterialArch", Constants.DorsalisPedisVein, Constants.DeepPalmarArterialArchRef, deepPalmarArterialArch.getComponentID());
			System.out.println("Created the DeepPalmarArterialArch");

			System.out.println("Creating the DorsalMetatarsalArteries for ParentID: " + parentID);
			dorsalMetatarsalArteries = new DorsalMetatarsalArteries(parentID, bioMightMethods);
			initProperty("DorsalMetatarsalArteries", Constants.DorsalMetatarsalArteries, Constants.DorsalMetatarsalArteriesRef, dorsalMetatarsalArteries.getComponentID());
			System.out.println("Created the DorsalMetatarsalArteries");
		
			System.out.println("Creating the LateralCalcanealArtery for ParentID: " + parentID);
			lateralCalcanealArtery = new LateralCalcanealArtery(parentID, bioMightMethods);
			initProperty("LateralCalcanealArtery", Constants.LateralCalcanealArtery, Constants.LateralCalcanealArteryRef, lateralCalcanealArtery.getComponentID());
			System.out.println("Created the LateralCalcanealArtery");
		
			System.out.println("Creating the LateralPlantarArtery for ParentID: " + parentID);
			lateralPlantarArtery = new LateralPlantarArtery(parentID, bioMightMethods);
			initProperty("LateralPlantarArtery", Constants.LateralPlantarArtery, Constants.LateralPlantarArteryRef, lateralPlantarArtery.getComponentID());
			System.out.println("Created the LateralPlantarArtery");
			
			System.out.println("Creating the MedialCalcanealArtery for ParentID: " + parentID);
			medialCalcanealArtery = new MedialCalcanealArtery(parentID, bioMightMethods);
			initProperty("MedialCalcanealArtery", Constants.MedialCalcanealArtery, Constants.MedialCalcanealArteryRef, medialCalcanealArtery.getComponentID());
			System.out.println("Created the MedialCalcanealArtery");
			
			System.out.println("Creating the MedialPlantarArtery for ParentID: " + parentID);
			medialPlantarArtery = new MedialPlantarArtery(parentID, bioMightMethods);
			initProperty("MedialPlantarArtery", Constants.MedialPlantarArtery, Constants.MedialPlantarArteryRef, medialPlantarArtery.getComponentID());
			System.out.println("Created the MedialPlantarArtery");
			
			System.out.println("Creating the DorsalisPedisVein for ParentID: " + parentID);
			dorsalisPedisVein = new DorsalisPedisVein(parentID, bioMightMethods);
			initProperty("DorsalisPedisVein", Constants.DorsalisPedisVein, Constants.DorsalisPedisVeinRef, dorsalisPedisVein.getComponentID());
			System.out.println("Created the DorsalisPedisVein");

			System.out.println("Creating the DorsalMetatarsalVeins for ParentID: " + parentID);
			dorsalMetatarsalVeins = new DorsalMetatarsalVeins(localVP, localLOD,  parentID, bioMightProperties, bioMightMethods);
			initProperty("DorsalMetatarsalVeins", Constants.DorsalMetatarsalVeins, Constants.DorsalMetatarsalVeinsRef, dorsalMetatarsalVeins.getComponentID());
			System.out.println("Created the DorsalMetatarsalVeins");

			System.out.println("Creating the LateralMarginalVein for ParentID: " + parentID);
			lateralMarginalVein = new LateralMarginalVein(parentID, bioMightMethods);
			initProperty("LateralMarginalVein", Constants.LateralMarginalVein, Constants.LateralMarginalVeinRef, lateralMarginalVein.getComponentID());
			System.out.println("Created the LateralMarginalVein");

			System.out.println("Creating the LateralPlantarVein for ParentID: " + parentID);
			lateralPlantarVein = new LateralPlantarVein(parentID, bioMightMethods);
			initProperty("LateralPlantarVein", Constants.LateralPlantarVein, Constants.LateralPlantarVeinRef, lateralPlantarVein.getComponentID());
			System.out.println("Created the LateralPlantarVein");

			System.out.println("Creating the MedialMarginalVein for ParentID: " + parentID);
			medialMarginalVein = new MedialMarginalVein(parentID, bioMightMethods);
			initProperty("MedialMarginalVein", Constants.MedialMarginalVein, Constants.MedialMarginalVeinRef, medialMarginalVein.getComponentID());
			System.out.println("Created the MedialMarginalVein");
	
			System.out.println("Creating the MedialPlantarVeins for ParentID: " + parentID);
			medialPlantarVeins = new MedialPlantarVeins(parentID, bioMightMethods);
			initProperty("MedialPlantarVeins", Constants.MedialPlantarVeins, Constants.MedialPlantarVeinsRef, medialPlantarVeins.getComponentID());
			System.out.println("Created the MedialPlantarVeins");
	
			System.out.println("Creating the PlantarMetatarsalVeins for ParentID: " + parentID);
			plantarMetatarsalVeins = new PlantarMetatarsalVeins(parentID, bioMightMethods);
			initProperty("PlantarMetatarsalVeins", Constants.PlantarMetatarsalVeins, Constants.PlantarMetatarsalVeinsRef, plantarMetatarsalVeins.getComponentID());
			System.out.println("Created the PlantarMetatarsalVeins");
	
			System.out.println("Creating the PlantarVenousArch for ParentID: " + parentID);
			plantarVenousArch = new PlantarVenousArch(parentID, bioMightMethods);
			initProperty("PlantarVenousArch", Constants.PlantarVenousArch, Constants.PlantarVenousArchRef, plantarVenousArch.getComponentID());
			System.out.println("Created the PlantarVenousArch");
	
			System.out.println("Creating the SuperficialPalmarArch for ParentID: " + parentID);
			superficialPalmarArch = new SuperficialPalmarArch(parentID, bioMightMethods);
			initProperty("SuperficialPalmarArch", Constants.SuperficialPalmarArch, Constants.SuperficialPalmarArchRef, superficialPalmarArch.getComponentID());
			System.out.println("Created the SuperficialPalmarArch");
	
			
			/****
			
			System.out.println("Creating the AbductorDigitiMinimiMuscle for parent: " + parentID);
			abductorDigitiMinimiMuscle = new AbductorDigitiMinimiMuscle(parentID, bioMightMethods);
			System.out.println("Created the AbductorDigitiMinimiMuscle");
	
			System.out.println("Creating the AbductorHallucisMuscle for parent: " + parentID);
			abductorHallucisMuscle = new AbductorHallucisMuscle(parentID, bioMightMethods);
			System.out.println("Created the AbductorHallucisMuscle");
	
			System.out.println("Creating the DorsalInterosseiMuscle for parent: " + parentID);
			dorsalInterosseiMuscle = new DorsalInterosseiMuscle(parentID, bioMightMethods);
			System.out.println("Created the DorsalInterosseiMuscle");
	
			System.out.println("Creating the InterosselMuscle for parent: " + parentID);
			interosselMuscle = new InterosselMuscle(parentID, bioMightMethods);
			System.out.println("Created the InterosselMuscle");
	
			System.out.println("Creating the LumbriclesMuscle for parent: " + parentID);
			lumbriclesMuscle = new LumbriclesMuscle(parentID, bioMightMethods);
			System.out.println("Created the LumbriclesMuscle");
	
			System.out.println("Creating the PlantarInterosseiMuscle for parent: " + parentID);
			plantarInterosseiMuscle = new PlantarInterosseiMuscle(parentID, bioMightMethods);
			System.out.println("Created the PlantarInterosseiMuscle");
	
			System.out.println("Creating the QuadratusPlantae for parent: " + parentID);
			quadratusPlantae = new QuadratusPlantae(parentID, bioMightMethods);
			System.out.println("Created the QuadratusPlantae");
			 ****	*/
		
			/*	
		
			System.out.println("Creating CuboidBone: " + parentID);				
			cuboidBone = new CuboidBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("CuboidBone is created : " + parentID);
			
			System.out.println("Creating DistalPhalanages: " + parentID);				
			//distalPhalanages = new DistalPhalanages(bioMightTransform.getId(), bioMightMethods);
			System.out.println("DistalPhalanages is created : " + parentID);
				
			System.out.println("Creating MetaTarsalsBone: " + parentID);				
			//metaTarsalsBone = new MetaTarsalsBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("MetaTarsalsBone is created : " + parentID);
		
			System.out.println("Creating ProximalPhalanges: " + parentID);				
			//proximalPhalanges = new ProximalPhalanges(bioMightTransform.getId(), bioMightMethods);
			System.out.println("ProximalPhalanges is created : " + parentID);
	
			System.out.println("Creating Fibula: " + parentID);				
			//fibula = new Fibula(bioMightTransform.getId(), bioMightMethods);
			System.out.println("Fibula is created : " + parentID);

			("Creating CalcaneusBone: " + parentID);				
			//calcaneusBone = new CalcaneusBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("CalcaneusBone is created : " + parentID);

			System.out.println("Creating NavicularCuneiforms: " + parentID);				
			//navicularCuneiforms = new NavicularCuneiforms(bioMightTransform.getId(), bioMightMethods);
			System.out.println("NavicularCuneiforms is created : " + parentID);
			 ****/

		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {

		}	

		//initProperties();
		initMethods();
	}
	
	
	
	/************************************************************************************
	 * 
	 * CREATE2
	 * @param FootReference
	 ***********************************************************************************/

		
	public void create2(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Foot.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting FootInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.FootRef, parentID);
			System.out.println("Have Foot Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Foot");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Run through Foot and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Foot NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Foot we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Foot: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			// Create the Skin for the Foot
			
			epithelium = new EpitheliumTissue("FootEpithelium", bioMightTransform.getId(), bioMightMethods);
			System.out.println("Foot Epithelium is created : " + parentID);

			
			
			System.out.println("Creating the SoleusMuscle for parent: " + parentID);
			//soleusMuscle = new SoleusMuscle(parentID, bioMightMethods);
			System.out.println("Created the SoleusMuscle");
		
			
			//System.out.println("Creating Foot Tibia: " + parentID);				
			//tibia = new Tibia(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Foot Epithelium is created : " + parentID);

			/*
			System.out.println("Creating CuboidBone: " + parentID);				
			cuboidBone = new CuboidBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("CuboidBone is created : " + parentID);
			
			System.out.println("Creating DistalPhalanages: " + parentID);				
			//distalPhalanages = new DistalPhalanages(bioMightTransform.getId(), bioMightMethods);
			System.out.println("DistalPhalanages is created : " + parentID);
			
			System.out.println("Creating MetaTarsalsBone: " + parentID);				
			//metaTarsalsBone = new MetaTarsalsBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("MetaTarsalsBone is created : " + parentID);
		
			System.out.println("Creating ProximalPhalanges: " + parentID);				
			//proximalPhalanges = new ProximalPhalanges(bioMightTransform.getId(), bioMightMethods);
			System.out.println("ProximalPhalanges is created : " + parentID);
	
			System.out.println("Creating Fibula: " + parentID);				
			//fibula = new Fibula(bioMightTransform.getId(), bioMightMethods);
			System.out.println("Fibula is created : " + parentID);

			System.out.println("Creating CalcaneusBone: " + parentID);				
			//calcaneusBone = new CalcaneusBone(bioMightTransform.getId(), bioMightMethods);
			System.out.println("CalcaneusBone is created : " + parentID);

			System.out.println("Creating NavicularCuneiforms: " + parentID);				
			//navicularCuneiforms = new NavicularCuneiforms(bioMightTransform.getId(), bioMightMethods);
			System.out.println("NavicularCuneiforms is created : " + parentID);
			****/
			
						
		}		


		initProperties();
		initMethods();
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bicep ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
		

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Foot.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Foot
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Foot.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Foot'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true); // + tibia.getX3D(true);  
		//System.out.println("Foot X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Foot.  
	 * This routine will be called when looking at an individual Foot with
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
		// FOOT BOUND BOX		
		//
		// Set up the Bounding Box for the Foot
		// For default model, length of chest is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);
		
		// Setuo the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// FOOT - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.FootEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.FootEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// FOOT - VASCULAR CONNECTORS  
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
		// FOOT - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// FOOT - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Foot.   These boxes will define
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
			System.out.println("Foot - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// FOOT BOUND BOXES
		// Set up the Bounding Box for the Foot
		// On a porportioned human, the Foot are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT FOOT BOUNDBOX
		// Set up the Bounding Box for the Left Foot
		// On a porportioned human, the Foot are located in the --- 
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
			
		// FootEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.FootEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.FootEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftFootRef, bioBoundBox);	

		//********************************************************************* 
		//FOOT BOUNDBOX
		// Set up the Bounding Box for the Foot
		// On a porportioned human, the Foot are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// FootEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.FootEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.FootEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightFootRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Foot 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.FeetRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}	
		
	public void Arch()
	{
	}

	public void wiggleToes()
	{
	}		

	public CalcaneusBone getCalcaneus() {
		return calcaneus;
	}

	public void setCalcaneus(CalcaneusBone calcaneus) {
		this.calcaneus = calcaneus;
	}

	public CuboidBone getCuboidBpne() {
		return cuboidBone;
	}

	public void setCuboidBone(CuboidBone cuboidBone) {
		this.cuboidBone = cuboidBone;
	}

	public DeltoidLigament getDeltoidLigament() {
		return deltoidLigament;
	}

	public void setDeltoidLigament(DeltoidLigament deltoidLigament) {
		this.deltoidLigament = deltoidLigament;
	}

	public DistalPhalanages getDistalPhalanages() {
		return distalPhalanages;
	}

	public void setDistalPhalanages(DistalPhalanages distalPhalanages) {
		this.distalPhalanages = distalPhalanages;
	}

	

	public Heel getHeel() {
		return heel;
	}

	public void setHeel(Heel heel) {
		this.heel = heel;
	}


	public LongPlantarLigament getLongPlantarLigament() {
		return LongPlantarLigament;
	}

	public void setLongPlantarLigament(LongPlantarLigament longPlantarLigament) {
		LongPlantarLigament = longPlantarLigament;
	}

	
	public MetaTarsalsBone getMetaTarsals() {
		return metaTarsals;
	}

	public void setMetaTarsals(MetaTarsalsBone metaTarsals) {
		this.metaTarsals = metaTarsals;
	}

	public NavicularCuneiforms getNavicularCuneiforms() {
		return navicularCuneiforms;
	}

	public void setNavicularCuneiforms(NavicularCuneiforms navicularCuneiforms) {
		this.navicularCuneiforms = navicularCuneiforms;
	}

	
	public ProximalPhalanges getProximalPhalanges() {
		return proximalPhalanges;
	}

	public void setProximalPhalanges(ProximalPhalanges proximalPhalanges) {
		this.proximalPhalanges = proximalPhalanges;
	}


	public TalusBone getTalus() {
		return talus;
	}

	public void setTalus(TalusBone talus) {
		this.talus = talus;
	}

	public Tibia getTibia() {
		return tibia;
	}

	public void setTibia(Tibia tibia) {
		this.tibia = tibia;
	}

	public Toes getToes() {
		return toes;
	}

	public void setToes(Toes toes) {
		this.toes = toes;
	}

}
