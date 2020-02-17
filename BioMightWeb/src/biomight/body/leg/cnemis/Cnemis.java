/*
 * Created on Jul 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg.cnemis;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.leg.Calf;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.leg.cnemis.ExtensorDigitorumLongusMuscle;
import biomight.system.muscular.leg.cnemis.ExtensorHallicusLongusMuscle;
import biomight.system.muscular.leg.cnemis.FlexorDigitorumLongusMuscle;
import biomight.system.muscular.leg.cnemis.FlexorHallicusLongusMuscle;
import biomight.system.muscular.leg.cnemis.GastrocnemiusMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusBrevisMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusLongusMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusTertiusMuscle;
import biomight.system.muscular.leg.cnemis.PlantarisMuscle;
import biomight.system.muscular.leg.cnemis.SoleusMuscle;
import biomight.system.muscular.leg.cnemis.TibialisAnteriorMuscle;
import biomight.system.muscular.leg.cnemis.TibialisPosteriorMuscle;
import biomight.system.skeletal.leg.Fibula;
import biomight.system.skeletal.leg.tibia.Tibia;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.head.FacialArteries;
import biomight.system.vascular.arteries.leg.AnteriorTibialArtery;
import biomight.system.vascular.arteries.leg.ArcuateArtery;
import biomight.system.vascular.arteries.leg.PeronealArtery;
import biomight.system.vascular.arteries.leg.PoplitealArtery;
import biomight.system.vascular.arteries.leg.PosteriorTibialArtery;
import biomight.system.vascular.arteries.leg.SuperficialFemoralArtery;
import biomight.system.vascular.veins.leg.AnteriorTibialVein;
import biomight.system.vascular.veins.leg.GreatSaphenousVein;
import biomight.system.vascular.veins.leg.PeronealVein;
import biomight.system.vascular.veins.leg.PoplitealVein;
import biomight.system.vascular.veins.leg.PosteriorTibialVein;
import biomight.system.vascular.veins.leg.SmallSaphenousVein;
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
import biomightweb.util.BioWebUtils;

/**********************************************************************
 * @author SurferJim
 *
 * Representation for the Cnemis, the lower section of the leg
 * 
 **********************************************************************/

public class Cnemis extends BioMightBase {
	protected EpitheliumTissue epithelium;

	
	// Muscle
	private TibialisAnteriorMuscle tibialisAnteriorMuscle;
	private ExtensorDigitorumLongusMuscle extensorDigitorumLongusMuscle;
	private ExtensorHallicusLongusMuscle extensorHallicusLongusMuscle;
	private PeroneusTertiusMuscle peroneusTertiusMuscle;
	private GastrocnemiusMuscle gastrocnemiusMuscle;
	private PlantarisMuscle plantarisMuscle;
	private SoleusMuscle soleusMuscle;
	private PeroneusLongusMuscle peroneusLongusMuscle;
  	private PeroneusBrevisMuscle peroneusBrevisMuscle;
  	private TibialisPosteriorMuscle tibialisPosteriorMuscle;
	private FlexorDigitorumLongusMuscle flexorDigitorumLongusMuscle;
	private FlexorHallicusLongusMuscle flexorHallicusLongusMuscle;
	
	private Calf calf;
	//private Shin shin;	
	
	// Arteries
	private SuperficialFemoralArtery superficialFemoralArtery;
	private PoplitealArtery poplitealArtery;
	private AnteriorTibialArtery anteriorTibialArtery;
	private PosteriorTibialArtery posteriorTibialArtery;
	private PeronealArtery peronealArtery;
	private ArcuateArtery arcuateArtery;
	
	// Veins
	private GreatSaphenousVein greatSaphenousVein;
	private SmallSaphenousVein smallSaphenousVein;	
	private PoplitealVein poplitealVein;
	private AnteriorTibialVein anteriorTibialVein;
	private PosteriorTibialVein posteriorTibialVein;
	private PeronealVein peronealVein;
	
	// Bones
	private Fibula fibula;
	private Tibia tibia;	
	
	
	
	public Cnemis()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CnemisRef, null, null);
	}

	public Cnemis(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Cnemis(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Cnemis Create");
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
		this.setImage("images/Cnemis.gif");
		setImageWidth(200);
		setImageHeight(150);
		componentID=parentID;
	
		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Cnemis
		// Either get from the Constructor or set up defaults
		System.out.println("Cnemis - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Cnemis - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Cnemis - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Cnemis - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Cnemis - BoundingBoxes are NULL");						
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
				System.out.println("NEED TO EXECUTE Cnemis METHODS: " + bioMightMethods.size());
			}

			// Generate the Thigh Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			/*
			System.out.println("In Cnemis - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Cnemis - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Cnemis - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Cnemis - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.CnemisEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Cnemis - Constructor has Epithelium BoundBox: " + Constants.CnemisEpitheliumRef);
			else
				System.out.println("In Cnemis - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.CnemisEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.CnemisEpitheliumRef, tempBoundBox);		
			System.out.println("In Cnemis - Epithelium Constructor Set");
			*/
			
			// Create the 'skin' for the portion of the Cnemis we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftCnemisRef)) 
			{
				startID="CnemisEpithelium:00001";
			}			
			// We are creating the Esophagus for the Cnemis
			else if (parentID.equals(Constants.RightCnemisRef)) 
			{	
				startID="CnemisEpithelium:00480";
			}
		
			System.out.println("Creating Cnemis Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.CnemisEpitheliumRef,  Constants.CnemisEpitheliumRef, parentID, bioMightProperties, bioMightMethods);		
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();		
			initProperty(Constants.CnemisEpitheliumRef, Constants.CnemisEpithelium, Constants.CnemisEpitheliumRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Cnemis - Stored generateEpithelium in: " + componentID);
			
			System.out.println("CnemisEpithelium is created");			

						
			System.out.println("Creating the Fibula for parent: " + parentID);
			fibula = new Fibula(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("Fibula", Constants.Fibula, Constants.FibulaRef, fibula.getComponentID());
			System.out.println("Created the Fibula");

			System.out.println("Creating the Tibia for parent: " + parentID);
			tibia = new Tibia(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("Tibia", Constants.Tibia, Constants.TibiaRef, tibia.getComponentID());
			System.out.println("Created the Tibia");			
			
			// Musculature
			System.out.println("Creating the ExtensorDigitorumLongus for parent: " + parentID);
			extensorDigitorumLongusMuscle = new ExtensorDigitorumLongusMuscle(parentID, bioMightMethods);
			initProperty("ExtensorDigitorumLongusMuscle", Constants.ExtensorDigitorumLongusMuscle, Constants.ExtensorDigitorumLongusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the ExtensorDigitorumLongus");
			
			System.out.println("Creating the ExtensorHallicusLongusMuscle for parent: " + parentID);
			extensorHallicusLongusMuscle = new ExtensorHallicusLongusMuscle(parentID, bioMightMethods);
			initProperty("ExtensorHallicusLongusMuscle", Constants.ExtensorHallicusLongusMuscle, Constants.ExtensorHallicusLongusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the ExtensorHallicusLongusMuscle");
	
			System.out.println("Creating the TibialisAnteriorMuscle for parent: " + parentID);
			tibialisAnteriorMuscle = new TibialisAnteriorMuscle(parentID, bioMightMethods);
			initProperty("ExtensorDigitorumLongusMuscle", Constants.ExtensorDigitorumLongusMuscle, Constants.ExtensorDigitorumLongusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the TibialisAnteriorMuscle");
	
			System.out.println("Creating the TibialisPosteriorMuscle for parent: " + parentID);
			tibialisPosteriorMuscle = new TibialisPosteriorMuscle(parentID, bioMightMethods);
			initProperty("TibialisPosteriorMuscle", Constants.TibialisPosteriorMuscle, Constants.TibialisPosteriorMuscleRef, epithelium.getComponentID());
			System.out.println("Created the TibialisPosteriorMuscle");
		
			System.out.println("Creating the PeroneusTertiusMuscle for parent: " + parentID);
			peroneusTertiusMuscle = new PeroneusTertiusMuscle(parentID, bioMightMethods);
			initProperty("PeroneusTertiusMuscle", Constants.PeroneusTertiusMuscle, Constants.PeroneusTertiusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the PeroneusTertiusMuscle");
		
			System.out.println("Creating the GastrocnemiusMuscle for parent: " + parentID);
			gastrocnemiusMuscle = new GastrocnemiusMuscle(parentID, bioMightMethods);
			initProperty("GastrocnemiusMuscle", Constants.GastrocnemiusMuscle, Constants.GastrocnemiusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the GastrocnemiusMuscle");
		
			System.out.println("Creating the PlantarisMuscle for parent: " + parentID);
			plantarisMuscle = new PlantarisMuscle(parentID, bioMightMethods);
			initProperty("PlantarisMuscle", Constants.PlantarisMuscle, Constants.PlantarisMuscleRef, epithelium.getComponentID());
			System.out.println("Created the PlantarisMuscle");
		
			System.out.println("Creating the PeroneusLongusMuscle for parent: " + parentID);
			peroneusLongusMuscle = new PeroneusLongusMuscle(parentID, bioMightMethods);
			initProperty("PeroneusLongusMuscle", Constants.ExtensorDigitorumLongusMuscle, Constants.ExtensorDigitorumLongusMuscleRef, peroneusLongusMuscle.getComponentID());
			System.out.println("Created the PeroneusLongusMuscle");
		
			System.out.println("Creating the PeroneusBrevisMuscle for parent: " + parentID);
			peroneusBrevisMuscle = new PeroneusBrevisMuscle(parentID, bioMightMethods);
			initProperty("PeroniusBrevisMuscle", Constants.PeroneusBrevisMuscle, Constants.PeroneusBrevisMuscleRef, peroneusBrevisMuscle.getComponentID());
			System.out.println("Created the PeroneusBrevisMuscle");
	
			System.out.println("Creating the FlexorDigitorumLongusMuscle for parent: " + parentID);
			flexorDigitorumLongusMuscle = new FlexorDigitorumLongusMuscle(parentID, bioMightMethods);
			initProperty("FlexorDigitorumLongusMuscle", Constants.FlexorDigitorumLongusMuscle, Constants.FlexorDigitorumLongusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the FlexorDigitorumLongusMuscle");
		
			System.out.println("Creating the FlexorHallicusLongusMuscle for parent: " + parentID);
			flexorHallicusLongusMuscle = new FlexorHallicusLongusMuscle(parentID, bioMightMethods);
			initProperty("FlexorHallicusLongusMuscle", Constants.FlexorHallicusLongusMuscle, Constants.FlexorHallicusLongusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the FlexorHallicusLongusMuscle");
		
			System.out.println("Creating the SoleusMuscle for parent: " + parentID);
			soleusMuscle = new SoleusMuscle(parentID, bioMightMethods);
			initProperty("SoleusMuscle", Constants.SoleusMuscle, Constants.SoleusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SoleusMuscle");
		
			// Vasculature		
			System.out.println("Creating the PoplitealVein for parent: " + parentID);
			poplitealVein = new PoplitealVein(parentID, bioMightMethods);
			initProperty("PoplitealVein", Constants.PoplitealVein, Constants.PoplitealVeinRef, poplitealVein.getComponentID());
			System.out.println("Created the PoplitealVein");
		
			System.out.println("Creating the AnteriorTibialArtery for parent: " + parentID);
			anteriorTibialArtery = new AnteriorTibialArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AnteriorTibialArtery", Constants.AnteriorTibialArtery, Constants.AnteriorTibialArteryRef, anteriorTibialArtery.getComponentID());
			System.out.println("Created the AnteriorTibialArtery");

			System.out.println("Creating the AnteriorTibialVein for parent: " + parentID);
			anteriorTibialVein = new AnteriorTibialVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AnteriorTibialVein", Constants.AnteriorTibialVein, Constants.AnteriorTibialVeinRef, anteriorTibialVein.getComponentID());
			System.out.println("Created the AnteriorTibialVein");			
		
			System.out.println("Creating the PosteriorTibialArtery for parent: " + parentID);
			posteriorTibialArtery = new PosteriorTibialArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PosteriorTibialArtery", Constants.PosteriorTibialArtery, Constants.PosteriorTibialArteryRef, posteriorTibialArtery.getComponentID());
			System.out.println("Created the PosteriorTibialArtery");
	
			System.out.println("Creating the SmallSaphenousVein for parent: " + parentID);
			smallSaphenousVein = new SmallSaphenousVein(parentID, bioMightMethods);
			initProperty("SmallSaphenousVein", Constants.SmallSaphenousVein, Constants.SmallSaphenousVeinRef, smallSaphenousVein.getComponentID());
			System.out.println("Created the SmallSaphenousVein");

			System.out.println("Creating the GreatSaphenousVein for parent: " + parentID);
			greatSaphenousVein = new GreatSaphenousVein(parentID, bioMightMethods);
			initProperty("GreatSaphenousVein", Constants.GreatSaphenousVein, Constants.GreatSaphenousVeinRef, greatSaphenousVein.getComponentID());
			System.out.println("Created the GreatSaphenousVein");
	
			System.out.println("Creating the PeronealVein for parent: " + parentID);
			peronealVein = new PeronealVein(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PeronealVeinRef, Constants.PeronealVein, Constants.PeronealVeinRef, peronealVein.getComponentID());
			System.out.println("Created the PeronealVein");
		
			/*****
			System.out.println("Creating the ArcuateArtery for parent: " + parentID);
			arcuateArtery = new ArcuateArtery(parentID, bioMightMethods);
			System.out.println("Created the ArcuateArtery");
		
			*****/
			
			System.out.println("Cnemis Instance is completed : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}
	

	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Cnemis");
		property.setCanonicalName(Constants.Cnemis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Knee");
		property.setCanonicalName(Constants.Knee);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Cnemus");
		property.setCanonicalName(Constants.Cnemis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Fibula");
		property.setCanonicalName(Constants.Fibula);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Patella");
		//property.setCanonicalName(Constants.Patella);
		properties.add(property);
		

		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdductorLongusMuscle");
		property.setCanonicalName(Constants.AdductorLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BicepsFemorisMuscle");
		property.setCanonicalName(Constants.BicepsFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GluteusMediusMuscle");
		property.setCanonicalName(Constants.GluteusMediusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GracilisMuscle");
		property.setCanonicalName(Constants.GracilisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliacusMuscle");
		property.setCanonicalName(Constants.IliacusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ObturatorExternusMuscle");
		property.setCanonicalName(Constants.ObturatorExternusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ObturatorInternusMuscle");
		property.setCanonicalName(Constants.ObturatorInternusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PectineusMuscle");
		property.setCanonicalName(Constants.PectineusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PopliteusMuscle");
		property.setCanonicalName(Constants.PopliteusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("QuadricepsFemorisMuscle");
		property.setCanonicalName(Constants.QuadricepsFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RectusFemorisMuscle");
		property.setCanonicalName(Constants.RectusFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SartoriusMuscle");
		property.setCanonicalName(Constants.SartoriusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemiMembranosusMuscle");
		property.setCanonicalName(Constants.SemiMembranosusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemitendinosusMuscle");
		property.setCanonicalName(Constants.SemitendinosusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TensorFasciaLataMuscle");
		property.setCanonicalName(Constants.TensorFasciaLataMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VastusInterMediusMuscle");
		property.setCanonicalName(Constants.VastusInterMediusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VastusLateralisMuscle");
		property.setCanonicalName(Constants.VastusLateralisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("VastusMedialisMuscle");
		property.setCanonicalName(Constants.VastusMedialisMuscle);
		properties.add(property);

		// ARTERIES
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CommonFemoralArtery");
		property.setCanonicalName(Constants.CommonFemoralArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DeepFemoralArtery");
		property.setCanonicalName(Constants.DeepFemoralArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialFemoralArtery");
		property.setCanonicalName(Constants.SuperficialFemoralArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PoplitealArtery");
		property.setCanonicalName(Constants.PoplitealArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorTibialArtery");
		property.setCanonicalName(Constants.AnteriorTibialArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorTibialArtery");
		property.setCanonicalName(Constants.PosteriorTibialArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PeronealArtery");
		property.setCanonicalName(Constants.PeronealArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArcuateArtery");
		property.setCanonicalName(Constants.ArcuateArtery);
		properties.add(property);
		
		// VEINS
		property = new BioMightPropertyView();
		property.setPropertyName("Veins");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreatSaphenousVein");
		property.setCanonicalName(Constants.GreatSaphenousVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SmallSaphenousVein");
		property.setCanonicalName(Constants.SmallSaphenousVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FemoralVein");
		property.setCanonicalName(Constants.FemoralVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PoplitealVein");
		property.setCanonicalName(Constants.PoplitealVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorTibialVein");
		property.setCanonicalName(Constants.AnteriorTibialVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorTibialVein");
		property.setCanonicalName(Constants.PosteriorTibialVein);
		properties.add(property);				
		
		property = new BioMightPropertyView();
		property.setPropertyName("PeronealVein");
		property.setCanonicalName(Constants.PeronealVein);
		properties.add(property);
				
		/**
		private  poplitealVein;
		private  anteriorTibialVein;
		private  posteriorTibialVein;
		private  peronealVein;
		**/
		
	}
	
	
	public void initMethods() {

		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Kick");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Quiver");
		method.setHtmlType("checkbox");
		methods.add(method);

	}
	

	/****************************************************
	 * GENERATE
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Wrist E		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Cnemis Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
	
		
			double radius = 2.25;
			
			if (parentID.equals("Cnemis:01")) {
				
				// Generate the small intestine
				double[] startPos = {4.5, -47.5, -4.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateCnemis("CnemisEpithelium:00001", "CnemisEpithelium", 
					"CnemisLeft", componentID, parentID, currentPoints);								
			}
			else if (parentID.equals("Cnemis:02")) {
				
				// Generate the small intestine
				double[] startPos = {-4.5, -47.5, -4.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateCnemis("CnemisEpithelium:00360", "CnemisEpithelium", 
						"CnemisRight", componentID, parentID, currentPoints);								
		
			}		
			else  
			{	
				System.out.println("Calling Generate WristEpithelium NoParent");		
			}

			
			System.out.println("Created CnemisEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CnemisEpithelium");
			throw new ServerException("Remote Exception CnemisEpithelium():", e); 	
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
		
		// Assemble the Cnemis
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cnemis.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cnemis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			epithelium.getX3D(true) +
			tibialisAnteriorMuscle.getX3D(true) +
			extensorDigitorumLongusMuscle.getX3D(true) +
			extensorHallicusLongusMuscle.getX3D(true) +
			peroneusTertiusMuscle.getX3D(true) +
			gastrocnemiusMuscle.getX3D(true) +
			plantarisMuscle.getX3D(true) +
			soleusMuscle.getX3D(true) +
			peroneusLongusMuscle.getX3D(true) +
			peroneusBrevisMuscle.getX3D(true) +
			tibialisPosteriorMuscle.getX3D(true) +
			flexorDigitorumLongusMuscle.getX3D(true) +
			flexorHallicusLongusMuscle.getX3D(true) +
			fibula.getX3D(true) + 
			tibia.getX3D(true) +
			poplitealVein.getX3D(true) +
			anteriorTibialArtery.getX3D(true) +
			anteriorTibialVein.getX3D(true) +
			posteriorTibialArtery.getX3D(true) +
			//peronealVein.getX3D(true) +
			smallSaphenousVein.getX3D(true) +
			greatSaphenousVein.getX3D(true);
	
		
		//System.out.println("Cnemis X3D: " + body);		
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Cnemis.  
	 * This routine will be called when looking at an individual Cnemis with
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
		// CNEMIS BOUND BOX		
		//
		// Set up the Bounding Box for the Cnemis
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
		// CNEMIS - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// CNEMIS - VASCULAR CONNECTORS  
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
		// CNEMIS - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// CNEMIS - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Cnemis.   These boxes will define
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
			System.out.println("Cnemis - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// CNEMES BOUND BOXES
		// Set up the Bounding Box for the Cnemis
		// On a porportioned human, the Cnemis are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT CNEMIS BOUNDBOX
		// Set up the Bounding Box for the Left Cnemis
		// On a porportioned human, the Cnemis are located in the --- 
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
			
		// CnemisEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftCnemisRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT CNEMIS BOUNDBOX
		// Set up the Bounding Box for the Cnemis
		// On a porportioned human, the Cnemis are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// CnemisEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightCnemisRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Cnemis 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.CnemesRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}	
	
	public AnteriorTibialArtery getAnteriorTibialArtery() {
		return anteriorTibialArtery;
	}


	public void setAnteriorTibialArtery(AnteriorTibialArtery anteriorTibialArtery) {
		this.anteriorTibialArtery = anteriorTibialArtery;
	}


	public AnteriorTibialVein getAnteriorTibialVein() {
		return anteriorTibialVein;
	}


	public void setAnteriorTibialVein(AnteriorTibialVein anteriorTibialVein) {
		this.anteriorTibialVein = anteriorTibialVein;
	}


	public ArcuateArtery getArcuateArtery() {
		return arcuateArtery;
	}


	public void setArcuateArtery(ArcuateArtery arcuateArtery) {
		this.arcuateArtery = arcuateArtery;
	}
	

	public Fibula getFibula() {
		return fibula;
	}


	public void setFibula(Fibula fibula) {
		this.fibula = fibula;
	}


	public GreatSaphenousVein getGreatSaphenousVein() {
		return greatSaphenousVein;
	}


	public void setGreatSaphenousVein(GreatSaphenousVein greatSaphenousVein) {
		this.greatSaphenousVein = greatSaphenousVein;
	}

	public PoplitealArtery getPoplitealArtery() {
		return poplitealArtery;
	}


	public void setPoplitealArtery(PoplitealArtery poplitealArtery) {
		this.poplitealArtery = poplitealArtery;
	}


	public PoplitealVein getPoplitealVein() {
		return poplitealVein;
	}


	public void setPoplitealVein(PoplitealVein poplitealVein) {
		this.poplitealVein = poplitealVein;
	}


	public PosteriorTibialArtery getPosteriorTibialArtery() {
		return posteriorTibialArtery;
	}


	public void setPosteriorTibialArtery(PosteriorTibialArtery posteriorTibialArtery) {
		this.posteriorTibialArtery = posteriorTibialArtery;
	}


	public PosteriorTibialVein getPosteriorTibialVein() {
		return posteriorTibialVein;
	}


	public void setPosteriorTibialVein(PosteriorTibialVein posteriorTibialVein) {
		this.posteriorTibialVein = posteriorTibialVein;
	}

	
	public SmallSaphenousVein getSmallSaphenousVein() {
		return smallSaphenousVein;
	}


	public void setSmallSaphenousVein(SmallSaphenousVein smallSaphenousVein) {
		this.smallSaphenousVein = smallSaphenousVein;
	}


	public SuperficialFemoralArtery getSuperficialFemoralArtery() {
		return superficialFemoralArtery;
	}


	public void setSuperficialFemoralArtery(
			SuperficialFemoralArtery superficialFemoralArtery) {
		this.superficialFemoralArtery = superficialFemoralArtery;
	}


}
