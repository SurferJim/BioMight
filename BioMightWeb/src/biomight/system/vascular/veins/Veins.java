/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.vascular.arteries.chest.BrachioCephalicArtery;
import biomight.system.vascular.veins.abdomen.CysticVein;
import biomight.system.vascular.veins.abdomen.HemiazygosVein;
import biomight.system.vascular.veins.abdomen.HepaticPortalVein;
import biomight.system.vascular.veins.abdomen.HepaticVein;
import biomight.system.vascular.veins.abdomen.IleocolicVein;
import biomight.system.vascular.veins.abdomen.IliolumbarVein;
import biomight.system.vascular.veins.abdomen.InferiorEpigastricVein;
import biomight.system.vascular.veins.abdomen.OvarianVein;
import biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVeins;
import biomight.system.vascular.veins.abdomen.RenalVeins;
import biomight.system.vascular.veins.abdomen.RetroperitonealVein;
import biomight.system.vascular.veins.abdomen.RightGastroEpiploicVein;
import biomight.system.vascular.veins.arm.AccessoryCephalicVein;
import biomight.system.vascular.veins.arm.BasilicVeins;
import biomight.system.vascular.veins.arm.BrachialVeins;
import biomight.system.vascular.veins.arm.CephalicVeins;
import biomight.system.vascular.veins.brain.AdrenalMedullaryVein;
import biomight.system.vascular.veins.brain.AnteriorCerebralVein;
import biomight.system.vascular.veins.brain.ArachnoidGranulations;
import biomight.system.vascular.veins.brain.BasalVein;
import biomight.system.vascular.veins.brain.BasalVeinOfRosenthal;
import biomight.system.vascular.veins.brain.BasilarPlexus;
import biomight.system.vascular.veins.brain.CavernousSinuses;
import biomight.system.vascular.veins.brain.CerebralVeins;
import biomight.system.vascular.veins.brain.ChoroidVein;
import biomight.system.vascular.veins.brain.ConfluenceOfTheSinuses;
import biomight.system.vascular.veins.brain.DeepMiddleCerebralVein;
import biomight.system.vascular.veins.brain.EmissaryVeins;
import biomight.system.vascular.veins.brain.GreatAnastomoticVeinOfTrolard;
import biomight.system.vascular.veins.brain.GreatCerebralVein;
import biomight.system.vascular.veins.brain.InferiorCerebellarVeins;
import biomight.system.vascular.veins.brain.InferiorCerebralVeins;
import biomight.system.vascular.veins.brain.InferiorOphthalmicVein;
import biomight.system.vascular.veins.brain.InferiorPetrosalSinus;
import biomight.system.vascular.veins.brain.InferiorSagittalSinus;
import biomight.system.vascular.veins.brain.InferiorStriateVeins;
import biomight.system.vascular.veins.brain.InterCavernousSinuses;
import biomight.system.vascular.veins.brain.MiddleCerebralVein;
import biomight.system.vascular.veins.brain.OccipitalSinus;
import biomight.system.vascular.veins.brain.PetrosquamousSinus;
import biomight.system.vascular.veins.brain.PosteriorAnastomoticVeinOfLabbe;
import biomight.system.vascular.veins.brain.SigmoidSinus;
import biomight.system.vascular.veins.brain.SphenoparietalSinus;
import biomight.system.vascular.veins.brain.StraightSinus;
import biomight.system.vascular.veins.brain.SuperiorCerebellarVeins;
import biomight.system.vascular.veins.brain.SuperiorCerebralVeins;
import biomight.system.vascular.veins.brain.SuperiorOphthalmicVein;
import biomight.system.vascular.veins.brain.SuperiorPetrosalSinus;
import biomight.system.vascular.veins.brain.SuperiorSagittalSinus;
import biomight.system.vascular.veins.brain.TerminalVein;
import biomight.system.vascular.veins.brain.TransverseSinuses;
import biomight.system.vascular.veins.chest.AzygosVein;
import biomight.system.vascular.veins.chest.BrachioCephaticVein;
import biomight.system.vascular.veins.chest.InferiorVenaCava;
import biomight.system.vascular.veins.chest.PulmonaryVein;
import biomight.system.vascular.veins.chest.SubclavianVein;
import biomight.system.vascular.veins.chest.SuperiorVenaCava;
import biomight.system.vascular.veins.foot.DorsalMetatarsalVeins;
import biomight.system.vascular.veins.foot.IntercapitularVein;
import biomight.system.vascular.veins.foot.LateralMarginalVein;
import biomight.system.vascular.veins.foot.LateralPlantarVein;
import biomight.system.vascular.veins.foot.MedialMarginalVein;
import biomight.system.vascular.veins.foot.MedialPlantarVein;
import biomight.system.vascular.veins.foot.PlantarVenousArch;
import biomight.system.vascular.veins.foot.SuperficialPalmarArch;
import biomight.system.vascular.veins.hand.DigitalVein;
import biomight.system.vascular.veins.hand.MedialAntebrachialVein;
import biomight.system.vascular.veins.hand.PalmarDigitalVeins;
import biomight.system.vascular.veins.head.AngularVein;
import biomight.system.vascular.veins.head.AngularVeins;
import biomight.system.vascular.veins.head.AqueousVein;
import biomight.system.vascular.veins.head.CommonFacialVein;
import biomight.system.vascular.veins.head.DeepFacialVein;
import biomight.system.vascular.veins.head.FacialVeins;
import biomight.system.vascular.veins.head.MentalVeins;
import biomight.system.vascular.veins.head.RetroMandibularVein;
import biomight.system.vascular.veins.head.SuperficialTemporalVein;
import biomight.system.vascular.veins.leg.AnteriorTibialVeins;
import biomight.system.vascular.veins.leg.DeepFemoralVeins;
import biomight.system.vascular.veins.leg.DorsalisPedisVein;
import biomight.system.vascular.veins.leg.GreatSaphenousVeins;
import biomight.system.vascular.veins.leg.LateralCircumflexFemoralVeins;
import biomight.system.vascular.veins.leg.PeronealVeins;
import biomight.system.vascular.veins.leg.PoplitealVein;
import biomight.system.vascular.veins.leg.PosteriorTibialVeins;
import biomight.system.vascular.veins.leg.SaphenousBranch;
import biomight.system.vascular.veins.leg.SmallSaphenousVein;
import biomight.system.vascular.veins.leg.SmallSaphenousVeins;
import biomight.system.vascular.veins.leg.SuperficialFemoralVeins;
import biomight.system.vascular.veins.neck.AxillaryVein;
import biomight.system.vascular.veins.neck.DeepCervicalVein;
import biomight.system.vascular.veins.neck.ExternalJugularVein;
import biomight.system.vascular.veins.neck.InferiorThyroidVein;
import biomight.system.vascular.veins.neck.InternalJugularVein;
import biomight.system.vascular.veins.neck.LeftInnominateVein;
import biomight.system.vascular.veins.neck.MiddleThyroidVein;
import biomight.system.vascular.veins.neck.RightInnominateVein;
import biomight.system.vascular.veins.neck.SuperiorThyroidVein;
import biomight.system.vascular.veins.pelvis.CommonIliacVeins;
import biomight.system.vascular.veins.pelvis.DeepDorsalVein;
import biomight.system.vascular.veins.pelvis.ExternalIliacVeins;
import biomight.system.vascular.veins.pelvis.ExternalPudendalVein;
import biomight.system.vascular.veins.pelvis.GonadalVein;
import biomight.system.vascular.veins.pelvis.HypogastricVein;
import biomight.system.vascular.veins.pelvis.InferiorGlutealVeins;
import biomight.system.vascular.veins.pelvis.InferiorHemorrhoidalVein;
import biomight.system.vascular.veins.pelvis.InferiorPhrenicVeins;
import biomight.system.vascular.veins.pelvis.InternalIliacVeins;
import biomight.system.vascular.veins.pelvis.LumbarVeins;
import biomight.system.vascular.veins.pelvis.MiddleHemorrhoidalVein;
import biomight.system.vascular.veins.pelvis.PerinealVein;
import biomight.system.vascular.veins.pelvis.PubicVein;
import biomight.system.vascular.veins.pelvis.SpermaticVeins;
import biomight.system.vascular.veins.pelvis.SuperficialDorsalVein;
import biomight.system.vascular.veins.pelvis.SuperiorGlutealVeins;
import biomight.system.vascular.veins.pelvis.UterineVeins;
import biomight.system.vascular.veins.pelvis.VaginalVein;
import biomight.system.vascular.veins.pelvis.VesicalVein;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Veins System
 * 
 * 
 *****************************************************************************/

public class Veins extends BioMightBase {

	// Brain
	private AdrenalMedullaryVein adrenalMedullaryVein;
	private AnteriorCerebralVein anteriorCerebralVein;
	private ArachnoidGranulations arachnoidGranulations;
	private BasalVein basalVein;
	private BasilarPlexus basilarPlexus;
	private BasalVeinOfRosenthal basalVeinOfRosenthal;
	private CavernousSinuses cavernousSinuses;
	private CerebralVeins cerebralVeins;
	private ChoroidVein choroidVein;
	private ConfluenceOfTheSinuses confluenceOfTheSinuses;
	private DeepMiddleCerebralVein beepMiddleCerebralVein;
	private EmissaryVeins emissaryVeins;
	private GreatAnastomoticVeinOfTrolard greatAnastomoticVeinOfTrolard;
	private GreatCerebralVein greatCerebralVein;
	private InferiorCerebellarVeins inferiorCerebellarVeins;
	private InferiorCerebralVeins inferiorCerebralVeins;
	private InferiorOphthalmicVein inferiorOphthalmicVein;
	private InferiorStriateVeins inferiorStriateVeins;
	private InterCavernousSinuses interCavernousSinuses;
	private InferiorPetrosalSinus inferiorPetrosalSinus;
	private InferiorSagittalSinus inferiorSagittalSinus;
	private MiddleCerebralVein middleCerebralVein;
	private OccipitalSinus occipitalSinus;
	private PetrosquamousSinus petrosquamousSinus;
	private PosteriorAnastomoticVeinOfLabbe posteriorAnastomoticVeinOfLabbe;
	private SigmoidSinus sigmoidSinus;
	private SphenoparietalSinus sphenoparietalSinus;
	private StraightSinus StraightSinus;
	private SuperiorCerebellarVeins superiorCerebellarVeins;
	private SuperiorCerebralVeins superiorCerebralVeins;
	private SuperiorOphthalmicVein superiorOphthalmicVein;
	private SuperiorPetrosalSinus superiorPetrosalSinus; 
	private SuperiorSagittalSinus superiorSagittalSinus;
	private TerminalVein TerminalVein;
	private TransverseSinuses transverseSinuses;
	
	
	// Head Veins
	private AqueousVein aqueousVein;
	private CommonFacialVein commonFacialVein;
	private DeepFacialVein deepFacialVein;
	private RetroMandibularVein retroMandibularVein;
	private SuperficialTemporalVein superficialTemporalVein;
	
	private AngularVeins angularVeins;
	private FacialVeins facialVeins;
	private MentalVeins mentalVeins;
	
	
	// Neck Veins
	private AxillaryVein axillaryVein;
	private DeepCervicalVein DeepCervicalVein;
	private ExternalJugularVein externalJugularVein;
	private InferiorThyroidVein inferiorThyroidVein;
	private InternalJugularVein internalJugularVein;
	private LeftInnominateVein leftInnominateVein;
	private MiddleThyroidVein middleThyroidVein;
	private RightInnominateVein rightInnominateVein;
	private SuperiorThyroidVein superiorThyroidVein;
	
	
	// Chest
	private InferiorVenaCava inferiorVenaCava;
	private PulmonaryVein pulmonaryVein;
	private SubclavianVein subclavianVein;
	private SuperiorVenaCava superiorVenaCava;
	private AzygosVein azygosVein;  // extends into abdomen
	private BrachioCephaticVein brachioCephaticVein;
		
		
	// Arms
	private AccessoryCephalicVein accessoryCephalicVein;
	private BrachialVeins brachialVeins;
	private BasilicVeins basilicVeins;	
	private BrachioCephalicArtery brachioCephalicArtery;
	private CephalicVeins cephalicVeins;
	
	
	// Hands
	private DigitalVein digitalVein;
	private MedialAntebrachialVein medialAntebrachialVein;


	// Abdomen
	private CysticVein cysticVein;
	private HemiazygosVein hemiazygosVein;
	private HepaticVein hepaticVein;
	private IleocolicVein ileocolicVein;
	private IliolumbarVein iliolumbarVein;
	private InferiorEpigastricVein inferiorEpigastricVein;
	private OvarianVein ovarianVein;
	private PancreaticoDuodenalVeins pancreaticoDuodenalVeins;
	private HepaticPortalVein portalVein;
	private RenalVeins renalVein;
	private RetroperitonealVein retroperitonealVein;
	private RightGastroEpiploicVein rightGastroEpiploicVein;
	
	
	// Pelvis
	private CommonIliacVeins commonIliacVeins;
	private ExternalIliacVeins externalIliacVeins;
	private GonadalVein gonadalVein;
	private HypogastricVein hypogastricVein;
	private InferiorPhrenicVeins inferiorPhrenicVeins;
	private InternalIliacVeins internalIliacVeins;
	private LumbarVeins lumbarVeins;
	private MiddleHemorrhoidalVein middleHemorrhoidalVein;
	private PubicVein PubicVein;
	private SpermaticVeins spermaticVeins;
	private ExternalPudendalVein ExternalPudendalVein;
	//private DeepIliacCircumflexVein	deepIliacCircumflexVein;
	private SuperiorGlutealVeins superiorGlutealVeins;
	private InferiorGlutealVeins inferiorGlutealVeins;
	private PerinealVein perinealVein;
	private InferiorHemorrhoidalVein inferiorHemorrhoidalVein;
	private SuperficialDorsalVein superficialDorsalVein;
	private DeepDorsalVein deepDorsalVein;
	private UterineVeins uterineVeins;
	private VesicalVein vesicalVein;

	
	
	// Legs
	private AnteriorTibialVeins anteriorTibialVeins;
	private PosteriorTibialVeins posteriorTibialVeins;
	private DeepFemoralVeins deepFemoralVeins;
	private GreatSaphenousVeins greatSaphenousVeins;
	private LateralCircumflexFemoralVeins lateralCircumflexFemoralVeins;
	private PeronealVeins peronealVeins;
	private IntercapitularVein intercapitularVeins;
	private DorsalisPedisVein dorsalisPedisVein;
	
	private PoplitealVein poplitealVein;	
	private SmallSaphenousVeins smallSaphenousVeins;
	private SuperficialFemoralVeins superficialFemoralVeins;
	
	// Foot
	private LateralPlantarVein lateralPlantarVein;
	private MedialPlantarVein medialPlantarVein;
	private PalmarDigitalVeins palmarDigitalVeins;
	private MedialMarginalVein medialMarginalVein;
	private LateralMarginalVein lateralMarginalVein;
	private SuperficialPalmarArch superficialVenousPalmarArch;
	private PlantarVenousArch plantarCutaneousVenousArch;
	private DorsalMetatarsalVeins metatarsalVeins;
	

	/************************************************************************
	 * VEINS Constructor 
	 *
	 ***********************************************************************/

	public Veins()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.Veins, null, null);
	}

	public Veins(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public Veins(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Veins.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		boolean bStored = false;
		
		
		if (localVP == Constants.VIEW_INTERNAL)
		{
				
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting VeinsInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.VeinsRef, parentID);
				//System.out.println("Have Veins Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Veins");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
		
			localVP = Constants.VIEW_HAWKEYE;
			localLOD = Constants.MAG1X;
	
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Veins.x3d";
			
			// Run through the collection of Veinss and build them into the model
			// In the default case, we get one instance of the Veins for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Veins NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Veins we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Retrieve Veins: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				//System.out.println("Creating Veins object: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
				
				// Get the Properties that the user set in the page last time we were in	
				// We will use the enable flag to see what should be turned on/off
				if (bioMightProperties == null ||bioMightProperties.size() == 0)
				{
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Getting Property info for CirculatorySystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						// overwrite the structure that was passed in, as they are empty
						bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
						//System.out.println("Have Veins Property Info from EJB - NumProps: " + bioMightProperties.size());   	
					}catch (Exception e) { 
						System.out.println("Exception Getting Components Properties - Veins");
						throw new ServerException("Remote Exception getComponents():", e); 	
					} 

					//System.out.println("Veins: Using Properties from Datastore");
					bStored = true;
				}
				else
				{
					//System.out.println("Veins - Using LocalProperties...");
				}
				//System.out.println("Veins - PropertiesSize: " + bioMightProperties.size());
	
				//dumpProperties();
				
				createComps(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);

				
				// Store the new set of properties based on the init Property methods called above	
				// This means the user set properties
				//System.out.println("Storing Veins PROPS" +  properties.size()     + "flag: "+   bStored);
				if (properties != null && !bStored) {
					if (properties.size()>0) {
					// Store the Properties that the user set in the page	
					// We will use the enable flag to see what should be turned on/off
						try {
							// Get the information from the database via the Enterprise Bean		
							//System.out.println("Setting Property info for Veins: " + bioMightTransform.getId());
							InitialContext ctx = new InitialContext();
							BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
							int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
									Constants.VeinsRef, bioMightTransform.getComponentName(), properties);      
							//System.out.println("Stored Veins Property Info into EJB: " + propSave);   	
							//dumpProperties();
						}catch (Exception e) { 
							System.out.println("Exception Storing Components Properties - Veins");
							throw new ServerException("Remote Exception insertComponentProps():", e); 	
						} 
					}
				}		


			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG2X;
			//***************************************************************
			//***************************************************************
			
			
			localVP = Constants.VIEW_HAWKEYE;
			//localLOD = Constants.MAG1X;
	
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Veins.x3d";
		
			// This is when one is accessing a Veins directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye VeinsInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Veins Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Veins");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Veins for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Veins NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Veins
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Veins: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Veins at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Veins				
					System.out.println("Creating Veins at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
	
				}

				
				// Get the Properties that the user set in the page last time we were in	
				// We will use the enable flag to see what should be turned on/off
				if (bioMightProperties == null ||bioMightProperties.size() == 0)
				{
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Getting Property info for CirculatorySystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						// overwrite the structure that was passed in, as they are empty
						bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
						System.out.println("Have Veins Property Info from EJB - NumProps: " + bioMightProperties.size());   	
					}catch (Exception e) { 
						System.out.println("Exception Getting Components Properties - Veins");
						throw new ServerException("Remote Exception getComponents():", e); 	
					} 

					//System.out.println("Veins: Using Properties from Datastore");
					bStored = true;
				}
				else
				{
					//System.out.println("Veins - Using LocalProperties...");
				}
				//System.out.println("Veins - PropertiesSize: " + bioMightProperties.size());	
				
				//dumpProperties();
				createComps(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				
				// Store the new set of properties based on the init Property methods called above	
				// This means the user set properties
				System.out.println("Storing Veins PROPS" +  properties.size()     + "flag: "+   bStored);
				if (properties != null && !bStored) {
					if (properties.size()>0) {
					// Store the Properties that the user set in the page	
					// We will use the enable flag to see what should be turned on/off
						try {
							// Get the information from the database via the Enterprise Bean		
							//System.out.println("Setting Property info for Veins: " + bioMightTransform.getId());
							InitialContext ctx = new InitialContext();
							BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
							int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
									Constants.VeinsRef, bioMightTransform.getComponentName(), properties);      
							//System.out.println("Stored Veins Property Info into EJB: " + propSave);   	
							//dumpProperties();
						}catch (Exception e) { 
							System.out.println("Exception Storing Components Properties - Veins");
							throw new ServerException("Remote Exception insertComponentProps():", e); 	
						} 
					}
				}		
			}
		}		
		else
		{
			
		}

		//initProperties();
		initMethods();
		
		System.out.println("Create Veins Completed");
	}

	
	
	public void createComps(int localVP, int localLOD, String parentID, ArrayList bioMightProperties, ArrayList bioMightMethods) {
		

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Veins.x3d";

		
		// VEINS				
		if (BioWebUtils.isViewEnabled(Constants.AngularVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the AngularVeins for ParentID: " + parentID);
			angularVeins = new AngularVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AngularVeins", Constants.AngularVeins, Constants.AngularVeinsRef, angularVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AngularVeins");
		}
		else
			initProperty("AngularVeins", Constants.AngularVeins, Constants.AngularVeinsRef, BioWebUtils.getPropertyID(Constants.AngularVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.MentalVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the MentalVeins for ParentID: " + parentID);
			mentalVeins = new MentalVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MentalVeinsRef, Constants.MentalVeins, Constants.MentalVeinsRef, mentalVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MentalVeins");
		}
		else
			initProperty(Constants.MentalVeinsRef, Constants.MentalVeins, Constants.MentalVeinsRef, BioWebUtils.getPropertyID(Constants.MentalVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.BrachialVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the BrachialVeins for parent: " + parentID);
			brachialVeins = new BrachialVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BrachialVeinsRef, Constants.BrachialVeins, Constants.BrachialVeinsRef, brachialVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BrachialVeins");
		}
		else
			initProperty(Constants.BrachialVeinsRef, Constants.BrachialVeins, Constants.BrachialVeinsRef, BioWebUtils.getPropertyID(Constants.BrachialVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
		
		if (BioWebUtils.isViewEnabled(Constants.BasilicVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the BasilicVeins for parent: " + parentID);
			basilicVeins = new BasilicVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BasilicVeinsRef, Constants.BasilicVeins, Constants.BasilicVeinsRef, basilicVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BasilicVein");
		}
		else
			initProperty(Constants.BasilicVeinsRef, Constants.BasilicVeins, Constants.BasilicVeinsRef, BioWebUtils.getPropertyID(Constants.BasilicVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.CephalicVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the CephalicVeins for parent: " + parentID);
			cephalicVeins = new CephalicVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.CephalicVeinsRef, Constants.CephalicVeins, Constants.CephalicVeinsRef, cephalicVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CephalicVein");
		}
		else
			initProperty(Constants.CephalicVeinsRef, Constants.CephalicVeins, Constants.CephalicVeinsRef, BioWebUtils.getPropertyID(Constants.CephalicVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorVenaCavaRef, bioMightProperties)) {	
			inferiorVenaCava = new InferiorVenaCava(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorVenaCavaRef, Constants.InferiorVenaCava, Constants.InferiorVenaCavaRef, inferiorVenaCava.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			//System.out.println("Created the InferiorVenaCava");
		}
		else
			initProperty(Constants.InferiorVenaCavaRef, Constants.InferiorVenaCava, Constants.InferiorVenaCavaRef, BioWebUtils.getPropertyID(Constants.InferiorVenaCavaRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorVenaCavaRef, bioMightProperties)) {	
			superiorVenaCava = new SuperiorVenaCava(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorVenaCavaRef, Constants.SuperiorVenaCava, Constants.SuperiorVenaCavaRef, superiorVenaCava.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorVenaCava");
		}
		else
			initProperty(Constants.SuperiorVenaCavaRef, Constants.SuperiorVenaCava, Constants.SuperiorVenaCavaRef, BioWebUtils.getPropertyID(Constants.SuperiorVenaCavaRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorTibialVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorTibialVeins for parent: " + parentID);
			anteriorTibialVeins = new AnteriorTibialVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorTibialVeinsRef, Constants.AnteriorTibialVeins, Constants.AnteriorTibialVeinsRef, anteriorTibialVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorTibialVein");
		}
		else
			initProperty(Constants.AnteriorTibialVeinsRef, Constants.AnteriorTibialVeins, Constants.AnteriorTibialVeinsRef, BioWebUtils.getPropertyID(Constants.AnteriorTibialVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorTibialVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorTibialVeins for parent: " + parentID);
			posteriorTibialVeins = new PosteriorTibialVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorTibialVeinsRef, Constants.PosteriorTibialVeins, Constants.PosteriorTibialVeinsRef, posteriorTibialVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorTibialVein");
		}
		else
			initProperty(Constants.PosteriorTibialVeinsRef, Constants.PosteriorTibialVeins, Constants.PosteriorTibialVeinsRef, BioWebUtils.getPropertyID(Constants.PosteriorTibialVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.DeepFemoralVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the DeepFemoralVeins for parent: " + parentID);
			deepFemoralVeins = new DeepFemoralVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DeepFemoralVeinsRef, Constants.DeepFemoralVeins, Constants.DeepFemoralVeinsRef, deepFemoralVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DeepFemoralVeins");
		}
		else
			initProperty(Constants.DeepFemoralVeinsRef, Constants.DeepFemoralVeins, Constants.DeepFemoralVeinsRef, BioWebUtils.getPropertyID(Constants.DeepFemoralVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SuperficialFemoralVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperficialFemoralVeins for parent: " + parentID);
			superficialFemoralVeins = new SuperficialFemoralVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperficialFemoralVeinsRef, Constants.SuperficialFemoralVeins, Constants.SuperficialFemoralVeinsRef, superficialFemoralVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperficialFemoralVeins");
		}
		else
			initProperty(Constants.SuperficialFemoralVeinsRef, Constants.SuperficialFemoralVeins, Constants.SuperficialFemoralVeinsRef, BioWebUtils.getPropertyID(Constants.SuperficialFemoralVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.CommonIliacVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the CommonIliacVeins for parent: " + parentID);
			commonIliacVeins = new CommonIliacVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.CommonIliacVeinsRef, Constants.CommonIliacVeins, Constants.CommonIliacVeinsRef, commonIliacVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CommonIliacVeins");
		}
		else
			initProperty(Constants.CommonIliacVeinsRef, Constants.CommonIliacVeins, Constants.CommonIliacVeinsRef, BioWebUtils.getPropertyID(Constants.CommonIliacVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.ExternalIliacVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the ExternalIliacVeins for parent: " + parentID);
			externalIliacVeins = new ExternalIliacVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ExternalIliacVeinsRef, Constants.ExternalIliacVeins, Constants.ExternalIliacVeinsRef, externalIliacVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DExternalIliacVeins");
		}
		else
			initProperty(Constants.ExternalIliacVeinsRef, Constants.ExternalIliacVeins, Constants.ExternalIliacVeinsRef, BioWebUtils.getPropertyID(Constants.ExternalIliacVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.InternalIliacVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the InternalIliacVeins for parent: " + parentID);
			internalIliacVeins = new InternalIliacVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InternalIliacVeinsRef, Constants.InternalIliacVeins, Constants.InternalIliacVeinsRef, internalIliacVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InternalIliacVeins");
		}
		else
			initProperty(Constants.InternalIliacVeinsRef, Constants.InternalIliacVeins, Constants.InternalIliacVeinsRef, BioWebUtils.getPropertyID(Constants.InternalIliacVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.GreatSaphenousVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the GreatSaphenousVeins for parent: " + parentID);
			greatSaphenousVeins = new GreatSaphenousVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.GreatSaphenousVeinsRef, Constants.GreatSaphenousVeins, Constants.GreatSaphenousVeinsRef, greatSaphenousVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the GreatSapheneousVeins");
		}
		else
			initProperty(Constants.GreatSaphenousVeinsRef, Constants.GreatSaphenousVeins, Constants.GreatSaphenousVeinsRef, BioWebUtils.getPropertyID(Constants.GreatSaphenousVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.PeronealVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the PeronealVeins for parent: " + parentID);
			peronealVeins = new PeronealVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PeronealVeinsRef, Constants.PeronealVeins, Constants.PeronealVeinsRef, peronealVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PeronealVeins");
		}
		else
			initProperty(Constants.PeronealVeinsRef, Constants.PeronealVeins, Constants.PeronealVeinsRef, BioWebUtils.getPropertyID(Constants.PeronealVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.LateralCircumflexFemoralVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the LateralCircumflexFemoralVeins for parent: " + parentID);
			lateralCircumflexFemoralVeins = new LateralCircumflexFemoralVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.LateralCircumflexFemoralVeinsRef, Constants.LateralCircumflexFemoralVeins, Constants.LateralCircumflexFemoralVeinsRef, lateralCircumflexFemoralVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the LateralCircumflexFemoralVeins");
		}
		else
			initProperty(Constants.LateralCircumflexFemoralVeinsRef, Constants.LateralCircumflexFemoralVeins, Constants.LateralCircumflexFemoralVeinsRef, BioWebUtils.getPropertyID(Constants.LateralCircumflexFemoralVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.SmallSaphenousVeinsRef, bioMightProperties)) {	
			//System.out.println("Creating the SmallSaphenousVeins for parent: " + parentID);
			smallSaphenousVeins = new SmallSaphenousVeins(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SmallSaphenousVeinsRef, Constants.SmallSaphenousVeins, Constants.SmallSaphenousVeinsRef, smallSaphenousVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SmallSapheneousVeins");
		}
		else
			initProperty(Constants.SmallSaphenousVeinsRef, Constants.SmallSaphenousVeins, Constants.SmallSaphenousVeinsRef, BioWebUtils.getPropertyID(Constants.SmallSaphenousVeinsRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	
	
	public void initProperties() {

		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Veins of Brain");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AdrenalMedullaryVein");
		property.setCanonicalName(Constants.AdrenalMedullaryVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCerebralVein");
		property.setCanonicalName(Constants.AnteriorCerebralVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArachnoidGranulations");
		property.setCanonicalName(Constants.ArachnoidGranulations);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BasalVein");
		property.setCanonicalName(Constants.BasalVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BasilarPlexus");
		property.setCanonicalName(Constants.BasilarPlexus);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BasalVeinOfRosenthal");
		property.setCanonicalName(Constants.BasalVeinOfRosenthal);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CavernousSinuses");
		property.setCanonicalName(Constants.CavernousSinuses);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CerebralVeins");
		property.setCanonicalName(Constants.CerebralVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ChoroidVein");
		property.setCanonicalName(Constants.ChoroidVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ConfluenceOfTheSinuses");
		property.setCanonicalName(Constants.ConfluenceOfTheSinuses);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeepMiddleCerebralVein");
		property.setCanonicalName(Constants.DeepMiddleCerebralVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("EmissaryVeins");
		property.setCanonicalName(Constants.EmissaryVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("GreatAnastomoticVeinOfTrolard");
		property.setCanonicalName(Constants.GreatAnastomoticVeinOfTrolard);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("GreatCerebralVein");
		property.setCanonicalName(Constants.GreatCerebralVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorCerebellarVeins");
		property.setCanonicalName(Constants.InferiorCerebellarVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorCerebralVeins");
		property.setCanonicalName(Constants.InferiorCerebralVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorOphthalmicVein");
		property.setCanonicalName(Constants.InferiorOphthalmicVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorStriateVeins");
		property.setCanonicalName(Constants.InferiorStriateVeins);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("IntercavernousSinuses");
		property.setCanonicalName(Constants.IntercavernousSinuses);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorPetrosalSinus");
		property.setCanonicalName(Constants.InferiorPetrosalSinus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorSagittalSinus");
		property.setCanonicalName(Constants.InferiorSagittalSinus);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MiddleCerebralVein");
		property.setCanonicalName(Constants.MiddleCerebralVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("OccipitalSinus");
		property.setCanonicalName(Constants.OccipitalSinus);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PetrosquamousSinus");
		property.setCanonicalName(Constants.PetrosquamousSinus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorAnastomoticVeinOfLabbe");
		property.setCanonicalName(Constants.PosteriorAnastomoticVeinOfLabbe);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SigmoidSinus");
		property.setCanonicalName(Constants.SigmoidSinus);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("SphenoparietalSinus");
		property.setCanonicalName(Constants.SphenoparietalSinus);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("StraightSinus");
		property.setCanonicalName(Constants.StraightSinus);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorCerebellarVeins");
		property.setCanonicalName(Constants.SuperiorCerebellarVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorCerebralVeins");
		property.setCanonicalName(Constants.SuperiorCerebralVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorOphthalmicVein");
		property.setCanonicalName(Constants.SuperiorOphthalmicVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorPetrosalSinus");
		property.setCanonicalName(Constants.SuperiorPetrosalSinus);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorSagittalSinus");
		property.setCanonicalName(Constants.SuperiorSagittalSinus);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("TerminalVein");
		property.setCanonicalName(Constants.TerminalVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TransverseSinuses");
		property.setCanonicalName(Constants.TransverseSinuses);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Head");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AqueousVein");
		property.setCanonicalName(Constants.AqueousVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CommonFacialVein");
		property.setCanonicalName(Constants.CommonFacialVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DeepFacialVein");
		property.setCanonicalName(Constants.DeepFacialVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("RetroMandibularVein");
		property.setCanonicalName(Constants.RetroMandibularVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Superficial Temporal Vein");
		property.setCanonicalName(Constants.SuperficialTemporalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AngularVein");
		property.setCanonicalName(Constants.AngularVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AxillaryVein");
		property.setCanonicalName(Constants.AxillaryVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("DeepCervicalVein");
		property.setCanonicalName(Constants.DeepCervicalVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalJugularVein");
		property.setCanonicalName(Constants.ExternalJugularVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorThyroidVein");
		property.setCanonicalName(Constants.InferiorThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InternalJugularVein");
		property.setCanonicalName(Constants.InternalJugularVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("LeftInnominateVein");
		property.setCanonicalName(Constants.LeftInnominateVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleThyroidVein");
		property.setCanonicalName(Constants.MiddleThyroidVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("RightInnominateVein");
		property.setCanonicalName(Constants.RightInnominateVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorThyroidVein");
		property.setCanonicalName(Constants.SuperiorThyroidVein);
		properties.add(property);	

		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorVenaCava");
		property.setCanonicalName(Constants.InferiorVenaCava);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PulmonaryVein");
		property.setCanonicalName(Constants.PulmonaryVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SubclavianVein");
		property.setCanonicalName(Constants.SubclavianVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorVenaCava");
		property.setCanonicalName(Constants.SuperiorVenaCava);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AzygosVein");
		property.setCanonicalName(Constants.AzygosVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BrachioCephaticVein");
		property.setCanonicalName(Constants.BrachioCephaticVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Arms");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AccessoryCephalicVein");
		property.setCanonicalName(Constants.AccessoryCephalicVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("BrachialVein");
		property.setCanonicalName(Constants.BrachialVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BasilicVein");
		property.setCanonicalName(Constants.BasilicVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BrachioCephalicArtery");
		property.setCanonicalName(Constants.BrachioCephalicArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CephalicVein");
		property.setCanonicalName(Constants.CephalicVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DigitalVein");
		property.setCanonicalName(Constants.DigitalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MedialAntebrachialVein");
		property.setCanonicalName(Constants.MedialAntebrachialVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Abdominal");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CysticVein");
		property.setCanonicalName(Constants.CysticVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("HemiazygosVein");
		property.setCanonicalName(Constants.HemiazygosVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("HepaticVein");
		property.setCanonicalName(Constants.HepaticVein);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("IleocolicVein");
		property.setCanonicalName(Constants.IleocolicVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("IliolumbarVein");
		property.setCanonicalName(Constants.IliolumbarVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorEpigastricVein");
		property.setCanonicalName(Constants.InferiorEpigastricVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("OvarianVein");
		property.setCanonicalName(Constants.OvarianVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PancreaticoDuodenalVeins");
		property.setCanonicalName(Constants.PancreaticoDuodenalVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("HepaticPortalVein");
		property.setCanonicalName(Constants.HepaticPortalVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("RenalVeins");
		property.setCanonicalName(Constants.RenalVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("RetroperitonealVein");
		property.setCanonicalName(Constants.RetroperitonealVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("RightGastroEpiploicVein");
		property.setCanonicalName(Constants.RightGastroEpiploicVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Pelvis");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CommonIliacVeins");
		property.setCanonicalName(Constants.CommonIliacVeins);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalIliacVeins");
		property.setCanonicalName(Constants.ExternalIliacVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("GonadalVein");
		property.setCanonicalName(Constants.GonadalVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HypogastricVein");
		property.setCanonicalName(Constants.HypogastricVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorPhrenicVeins");
		property.setCanonicalName(Constants.InferiorPhrenicVeins);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InternalIliacVein");
		property.setCanonicalName(Constants.InternalIliacVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LumbarVeins");
		property.setCanonicalName(Constants.LumbarVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MiddleHemorrhoidalVein");
		property.setCanonicalName(Constants.MiddleHemorrhoidalVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PubicVein");
		property.setCanonicalName(Constants.PubicVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SpermaticVeins");
		property.setCanonicalName(Constants.SpermaticVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExternalPudendalVein");
		property.setCanonicalName(Constants.ExternalPudendalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("DeepIliacCircumflexVein");
		property.setCanonicalName(Constants.DeepIliacCircumflexVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorGlutealVeins");
		property.setCanonicalName(Constants.SuperiorGlutealVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorGlutealVeins");
		property.setCanonicalName(Constants.InferiorGlutealVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorHemorrhoidalVein");
		property.setCanonicalName(Constants.InferiorHemorrhoidalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialDorsalVein");
		property.setCanonicalName(Constants.SuperficialDorsalVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeepDorsalVein");
		property.setCanonicalName(Constants.DeepDorsalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("UterineVeins");
		property.setCanonicalName(Constants.UterineVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("VesicalVein");
		property.setCanonicalName(Constants.VesicalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("VaginalVein");
		property.setCanonicalName(Constants.VaginalVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Legs");
		property.setCanonicalName(Constants.Title);
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
		property.setPropertyName("DeepFemoralVein");
		property.setCanonicalName(Constants.DeepFemoralVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DorsalisPedisVein");
		property.setCanonicalName(Constants.DorsalisPedisVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("FemoralVein");
		property.setCanonicalName(Constants.FemoralVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreatSaphenousVeins");
		property.setCanonicalName(Constants.GreatSaphenousVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("IntercapitularVeins");
		property.setCanonicalName(Constants.IntercapitularVeins);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralCircumflexFemoralVein");
		property.setCanonicalName(Constants.LateralCircumflexFemoralVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PeronealVeins");
		property.setCanonicalName(Constants.PeronealVeins);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PoplitealVein");
		property.setCanonicalName(Constants.PoplitealVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SaphenousBranch");
		property.setCanonicalName(Constants.SaphenousArterialBranch);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SmallSaphenousVein");
		property.setCanonicalName(Constants.SmallSaphenousVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Foot");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LateralPlantarVein");
		property.setCanonicalName(Constants.LateralPlantarVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MedialPlantarVein");
		property.setCanonicalName(Constants.MedialPlantarVein);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PalmarDigitalVeins");
		property.setCanonicalName(Constants.PalmarDigitalVeins);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MedialMarginalVein");
		property.setCanonicalName(Constants.MedialMarginalVein);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("LateralMarginalVein");
		property.setCanonicalName(Constants.LateralMarginalVein);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialVenousPalmarArch");
		property.setCanonicalName(Constants.SuperficialVenousPalmarArch);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PlantarVenousArch");
		property.setCanonicalName(Constants.PlantarVenousArch);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MetatarsalVeins");
		property.setCanonicalName(Constants.MetatarsalVeins);
		properties.add(property);
		
	}
	
	

	
	public void initMethods() {

		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Constrict");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Relax");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Muscle Density");
		method.setHtmlType("text");
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
		
	}

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Chin.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Chin'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		if (BioWebUtils.isViewEnabled(Constants.AngularVeinsRef, properties)) {
			body += angularVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MentalVeinsRef, properties)) {
			body += mentalVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BrachialVeinsRef, properties)) {
			body += brachialVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BasilicVeinsRef, properties)) {
			body += basilicVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CephalicVeinsRef, properties)) {
			body += cephalicVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorVenaCavaRef, properties)) {
			body += inferiorVenaCava.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperiorVenaCavaRef, properties)) {	
			body += superiorVenaCava.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorTibialVeinsRef, properties)) {
			body += anteriorTibialVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorTibialVeinsRef, properties)) {
			body += posteriorTibialVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DeepFemoralVeinsRef, properties)) {
			body += deepFemoralVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperficialFemoralVeinsRef, properties)) {
			body += superficialFemoralVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonIliacVeinsRef, properties)) {
			body += commonIliacVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ExternalIliacVeinsRef, properties)) {
			body += externalIliacVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalIliacVeinsRef, properties)) {
			body += internalIliacVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.GreatSaphenousVeinsRef, properties)) {
			body += greatSaphenousVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SmallSaphenousVeinsRef, properties)) {
			body += smallSaphenousVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LateralCircumflexFemoralVeinsRef, properties)) {
			body += lateralCircumflexFemoralVeins.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PeronealVeinsRef, properties)) {
			body +=  peronealVeins.getX3D(true);
		}
				  
		//System.out.println("Veins X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


}
