/*
 * Created on May 3, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.heart.AorticArch;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.vascular.arteries.abdomen.AbdominalAortaArtery;
import biomight.system.vascular.arteries.abdomen.AdrenalArteries;
import biomight.system.vascular.arteries.abdomen.AppendicularArtery;
import biomight.system.vascular.arteries.abdomen.CommonHepaticArtery;
import biomight.system.vascular.arteries.abdomen.CysticArtery;
import biomight.system.vascular.arteries.abdomen.GastricArteries;
import biomight.system.vascular.arteries.abdomen.GastroDuodenalArtery;
import biomight.system.vascular.arteries.abdomen.GastroEpiploicArteries;
import biomight.system.vascular.arteries.abdomen.HepaticArteries;
import biomight.system.vascular.arteries.abdomen.InferiorEpigastricArteries;
import biomight.system.vascular.arteries.abdomen.InferiorEpigastricArtery;
import biomight.system.vascular.arteries.abdomen.InferiorMesentericArtery;
import biomight.system.vascular.arteries.abdomen.InferiorPancreaticoDuodenalArtery;
import biomight.system.vascular.arteries.abdomen.InferiorPhrenicArteries;
import biomight.system.vascular.arteries.abdomen.InferiorSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.LeftColicArtery;
import biomight.system.vascular.arteries.abdomen.MiddleSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.PancreaticoDuodenalArteries;
import biomight.system.vascular.arteries.abdomen.ProperHepaticArtery;
import biomight.system.vascular.arteries.abdomen.RenalArteries;
import biomight.system.vascular.arteries.abdomen.SpleenCentralArteries;
import biomight.system.vascular.arteries.abdomen.SplenicArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorEpigastricArteries;
import biomight.system.vascular.arteries.abdomen.SuperiorMesentericArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorPancreaticoDuodenalArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.TrabecularArteries;
import biomight.system.vascular.arteries.arm.AnteriorCircumflexHumeralArteries;
import biomight.system.vascular.arteries.arm.AnteriorInterosseousArteries;
import biomight.system.vascular.arteries.arm.AnteriorUlnarRecurrentArteries;
import biomight.system.vascular.arteries.arm.BrachialArteries;
import biomight.system.vascular.arteries.arm.DeepBrachialArteries;
import biomight.system.vascular.arteries.arm.DorsalMetacarpalArtery;
import biomight.system.vascular.arteries.arm.InferiorUlnarCollateralArteries;
import biomight.system.vascular.arteries.arm.InterosseousRecurrentArteries;
import biomight.system.vascular.arteries.arm.MiddleCollateralArteries;
import biomight.system.vascular.arteries.arm.PosteriorCircumflexHumeralArteries;
import biomight.system.vascular.arteries.arm.PosteriorInterosseousArteries;
import biomight.system.vascular.arteries.arm.PosteriorUlnarRecurrentArteries;
import biomight.system.vascular.arteries.arm.RadialArteries;
import biomight.system.vascular.arteries.arm.RadialCollateralArteries;
import biomight.system.vascular.arteries.arm.RadialRecurrentArteries;
import biomight.system.vascular.arteries.arm.SuperiorUlnarCollateralArteries;
import biomight.system.vascular.arteries.arm.UlnarArteries;
import biomight.system.vascular.arteries.brain.ArterialCircleOfWillis;
import biomight.system.vascular.arteries.brain.CallosoMarginalArtery;
import biomight.system.vascular.arteries.brain.cortical.CorticalShortArteries;
import biomight.system.vascular.arteries.brain.cortical.MedullaryArteries;
import biomight.system.vascular.arteries.chest.AortaArtery;
import biomight.system.vascular.arteries.chest.AscendingAortaArtery;
import biomight.system.vascular.arteries.chest.AxillaryArteries;
import biomight.system.vascular.arteries.chest.BrachioCephalicArtery;
import biomight.system.vascular.arteries.chest.BronchialArteries;
import biomight.system.vascular.arteries.chest.ConusArtery;
import biomight.system.vascular.arteries.chest.CoronaryArteries;
import biomight.system.vascular.arteries.chest.DescendingAortaArtery;
import biomight.system.vascular.arteries.chest.InferiorAlveolarArtery;
import biomight.system.vascular.arteries.chest.ObtuseMarginalArtery;
import biomight.system.vascular.arteries.chest.PulmonaryArteries;
import biomight.system.vascular.arteries.chest.SubclavianArteries;
import biomight.system.vascular.arteries.chest.ThoracicArteries;
import biomight.system.vascular.arteries.foot.DeepPalmarArterialArch;
import biomight.system.vascular.arteries.foot.LateralCalcanealArtery;
import biomight.system.vascular.arteries.foot.LateralPlantarArtery;
import biomight.system.vascular.arteries.foot.MedialPlantarArtery;
import biomight.system.vascular.arteries.foot.PalmarDigitalArtery;
import biomight.system.vascular.arteries.foot.SuperficialPalmerArterialArch;
import biomight.system.vascular.arteries.hand.DeepPalmarArchArteries;
import biomight.system.vascular.arteries.hand.PalmarCarpalBranchArteries;
import biomight.system.vascular.arteries.hand.PalmarMetacarpalArteries;
import biomight.system.vascular.arteries.hand.PrincepsPollicisArteries;
import biomight.system.vascular.arteries.hand.RadialisIndicisArteries;
import biomight.system.vascular.arteries.hand.SuperficialPalmarArchArteries;
import biomight.system.vascular.arteries.head.*;
import biomight.system.vascular.arteries.leg.AnteriorTibialArteries;
import biomight.system.vascular.arteries.leg.CommonFemoralArteries;
import biomight.system.vascular.arteries.leg.DeepFemoralArteries;
import biomight.system.vascular.arteries.leg.DescendingGenicularArteries;
import biomight.system.vascular.arteries.leg.DescendingGenicularArticularArteries;
import biomight.system.vascular.arteries.leg.DescendingGenicularSaphenousArteries;
import biomight.system.vascular.arteries.leg.DorsalisPedisArtery;
import biomight.system.vascular.arteries.leg.InferiorGlutealArtery;
import biomight.system.vascular.arteries.leg.LateralCircumflexFemoralArteries;
import biomight.system.vascular.arteries.leg.MedialCircumflexFemoralArteries;
import biomight.system.vascular.arteries.leg.ObturatorArteries;
import biomight.system.vascular.arteries.leg.PeronealArteries;
import biomight.system.vascular.arteries.leg.PoplitealArteries;
import biomight.system.vascular.arteries.leg.PosteriorTibialArteries;
import biomight.system.vascular.arteries.leg.ProfundaFemorisArtery;
import biomight.system.vascular.arteries.leg.SuperficialFemoralArteries;
import biomight.system.vascular.arteries.neck.SuperiorThyroidAtery;
import biomight.system.vascular.arteries.pelvis.CommonIliacArteries;
import biomight.system.vascular.arteries.pelvis.ExternalIliacArteries;
import biomight.system.vascular.arteries.pelvis.GonadalArtery;
import biomight.system.vascular.arteries.pelvis.InternalIliacArteries;
import biomight.system.vascular.arteries.pelvis.LateralEpiphysealArtery;
import biomight.system.vascular.arteries.pelvis.OvarianArtery;
import biomight.system.vascular.arteries.pelvis.RectalArtery;
import biomight.system.vascular.arteries.abdomen.RenalArtery;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;



/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Arteries System
 * 
 * 
 *****************************************************************************/

public class Arteries extends BioMightBase {
	
	// Head
	private AcuteMarginalArtery acuteMarginalArtery;
	private AnteriorCecalArtery anteriorCecalArtery;
	private CircumflexArtery circumflexArtery;
	private CircumflexScapularArtery circumflexScapularArtery;
	private DiagonalArtery diagonalArtery;
	private DiagonalCoronaryArtery diagonalCoronaryArtery;
	private ExternalPudendalArtery externalPudendalArtery;
	private IleocolicArtery ileocolicArtery;
	private IliolumbarArtery iliolumbarArtery;
	private AnteriorInterosseousArteries anteriorInterosseousArteries;
	private PosteriorInterosseousArteries posteriorInterosseousArteries;
	private InterosseousRecurrentArteries interosseousRecurrentArteries;
	private LabyrinthineArtery labyrinthineArtery;
	private LeftAnteriorDescendingArtery leftAnteriorDescendingArtery;
	private PeriCardiaCophrenicArtery periCardiaCophrenicArtery;
	private PosteriorDescendingArtery posteriorDescendingArtery;
	private PosteriorLateralArtery posteriorLateralArtery;
	

	// Arteries of Brain
	private AccessoryMeningealArtery accessoryMeningealArtery;
	private ArterialCircleOfWillis arterialCircleOfWillis;
	private CallosoMarginalArtery callosoMarginalArtery;
	private CorticalShortArteries CorticalShortArteries;
	private MedullaryArteries medullaryArteries;
	

	// Arteries of Head
	private AngularArtery angularArtery;
	private AnteriorCerebralArtery anteriorCerebralArtery;
	private AnteriorChoroidalArtery anteriorChoroidalArtery;
	private AnteriorCommunicatingArtery anteriorCommunicatingArtery;
	private AnteriorDeepTemporalArtery anteriorDeepTemporalArtery;
	private AnteriorEthmoidalArtery anteriorEthmoidalArtery;
	private AnteriorInferiorCerebellarArtery anteriorInferiorCerebellarArtery;
	private AscendingPalatineArtery ascendingPalatineArtery;
	private BuccalArtery buccalArtery;
	private CaroticoTympanicBranch caroticoTympanicBranch;
	private CarotidArteries carotidArteries;
	private CerebellarArtery cerebellarArtery;
	private CiliaryArteries ciliaryArteries;
	private CirculusArteriosusMajor circulusArteriosusMajor;
	private CirculusArteriosusMinor circulusArteriosusMinor;
	private CommonCarotidArtery commonCarotidArtery;
	private ConjunctivalArtery conjunctivalArtery;
	private DeepLingualArtery deepLingualArtery;
	private DorsalLingualArtery dorsalLingualArtery;
	private DorsalNasalArtery dorsalNasalArtery;
	private FirstSeptalArtery firstSeptalArtery;
	private FrontalArtery frontalArtery;
	private GlomusCaroticum glomusCaroticum;
	private GlomusCoccygeum glomusCoccygeum;
	private InferiorLabialArtery inferiorLabialArtery;
	private InferiorLateralPalpebralArteries inferiorLateralPalpebralArteries;
	private InferiorMedialPalpebralArtery InferiorMedialPalpebralArtery;
	private InferiorTympanicArtery inferiorTympanicArtery;
	private LacrimalArtery lacrimalArtery;
	private LateralPalpebralArteries lateralPalpebralArteries;
	private LongPosteriorCiliaryArteries longPosteriorCiliaryArteries;
	private MedialPalpebralArteries medialPalpebralArteries;		
	private MentalArtery mentalArtery;	
	private MiddleCerebralArtery middleCerebralArtery;
	private OccipitalArtery occipitalArtery;
	private OccipitalArteryAuricularBranch occipitalArteryAuricularBranch;
	private OccipitalArteryDescendingBranch occipitalArteryDescendingBranch;
	
	private OphthalmicArtery ophthalmicArtery;
	private PosteriorAuricularArtery posteriorAuricularArtery;
	private PosteriorCommunicatingArtery posteriorCommunicatingArtery;	
	private PosteriorDeepTemporalArtery posteriorDeepTemporalArtery;	
	private PosteriorEthmoidalArtery posteriorEthmoidalArtery;
	private PosteriorInferiorCerebellarArtery posteriorInferiorCerebellarArtery;
	private RanineArtery ranineArtery;
	private RetinaCentralArtery retinaCentralArtery;		
	private SemilunarBranches semilunarBranches;
	private ShortPosteriorCiliaryArteries shortPosteriorCiliaryArteries;
	private SternocleidomastoidArtery sternocleidomastoidArtery;
	private StylomastoidArtery stylomastoidArtery;
	private SubLingualArtery subLingualArtery;
	private SubmentalArtery submentalArtery;
	private SuperficialTemporalArtery superficialTemporalArtery;
	private SuperiorLabialArtery superiorLabialArtery;
	private SuperiorLateralPalpebralArteries superiorLateralPalpebralArteries;
	private SuperiorMedialPalpebralArtery superiorMedialPalpebralArtery;
	private ThyroidArtery thyroidArtery;
	
	
	private LingualArteries lingualArteries;
	private ConjunctivalArteries conjunctivalArteries;
	private InfraOrbitalArteries infraOrbitalArteries;
	private SupraOrbitalArteries supraOrbitalArteries;
	private InferiorLabialArteries inferiorLabialArteries;
	private SuperiorLabialArteries superiorLabialArteries;
	private SupraTrochlearArteries supraTrochlearArteries;
	private FacialArteries facialArteries;
	
	private AngularArteries angularArteries;
	private BasilarArtery basilarArtery;
	private BuccalArteries buccalArteries;
	private TransverseFacialArteries transverseFacialArteries;
	private DorsalNasalArteries  dorsalNasalArteries;
	private LacrimalArteries lacrimalArteries;
	private OphthalmicArteries ophthalmicArteries;
	private OccipitalArteries occipitalArteries;
	private MentalArteries mentalArteries;
	private RanineArteries ranineArteries;
	private PontineArteries pontineArteries;

	//private ExternalMaxillaryArteries externalMaxillaryArteries;
	private InternalMaxillaryArteries internalMaxillaryArteries;
	private SuperficialTemporalArteries superficialTemporalArteries;

	private FrontalArteries frontalArteries;
	private InternalCarotidArteries internalCarotidArteries;
	private ExternalCarotidArteries externalCarotidArteries;
	private StylomastoidArteries stylomastoidArteries;

	private PosteriorCommunicatingArteries posteriorCommunicatingArteries;
	private VertebralArteries vertebralArteries;	
	private AnteriorSpinalArteries anteriorSpinalArteries;	
	
	//private HypophysealArteries hypophysealArteries;
	private SuperiorHypophysealArteries superiorHypophysealArteries;
	private InferiorHypophysealArteries inferiorHypophysealArteries;
	
	//private CerebellarArteries cerebellarArteries;
	private SuperiorCerebellarArteries superiorCerebellarArteries;
	private AnteriorInferiorCerebellarArteries anteriorInferiorCerebellarArteries;
	private PosteriorInferiorCerebellarArteries posteriorInferiorCerebellarArteries;
	
	//private CerebralArteries cerebralArteries;
	private AnteriorCerebralArteries anteriorCerebralArteries;
	private MiddleCerebralArteries middleCerebralArteries;
	private PosteriorCerebralArteries posteriorCerebralArteries;
	
	// Arteries of the Neck
	private AscendingPharyngealArtery ascendingPharyngealArtery;
	private SuperiorThyroidAtery superiorThyroidAtery;
	

	
	// Arteries of the Chest/Thorax
	private AortaArtery aortaArtery;
	private AscendingAortaArtery ascendingAortaArtery;
	private AorticArch aorticArch;
	private AxillaryArteries axillaryArteries;
	private BronchialArteries bronchialArteries;
	private ConusArtery conusArtery;
	private DescendingAortaArtery descendingAortaArtery;
	private InferiorAlveolarArtery inferiorAlveolarArtery;
	private CoronaryArteries coronaryArteries;
	private CommonCarotidArteries commonCarotidArteries;
	private ObtuseMarginalArtery obtuseMarginalArtery;
	private PulmonaryArteries pulmonaryArteries;
	private SubclavianArteries subclavianArteries;
	private ThoracicArteries thoracicArteries;
	private BrachioCephalicArtery brachioCephalicArtery;

		
	// Back
	private VertebralArtery vertebralArtery;
	
	
	// Arteries of the Arms
	private AnteriorCircumflexHumeralArteries anteriorCircumflexHumeralArteries;
	private PosteriorCircumflexHumeralArteries posteriorCircumflexHumeralArteries;
	private BrachialArteries brachialArteries;
	private DeepBrachialArteries deepBrachialArteries;
	private SuperiorUlnarCollateralArteries superiorUlnarCollateralArteries;
	private InferiorUlnarCollateralArteries inferiorUlnarCollateralArteries;
	private MiddleCollateralArteries middleCollateralArteries;
	private RadialCollateralArteries radialCollateralArteries;
	private RadialRecurrentArteries radialRecurrentArteries;
	private RadialArteries radialArteries;
	private UlnarArteries ulnarArteries;
	private AnteriorUlnarRecurrentArteries anteriorUlnarRecurrentArteries;
	private PosteriorUlnarRecurrentArteries posteriorUlnarRecurrentArteries;	
	
	// Arteries of the Hands
	private DigitalArtery digitalArteries;
	private DorsalMetacarpalArtery dorsalMetacarpalArtery;
	
	// Arteries of the Hands	
	private SuperficialPalmarArchArteries superficialPalmarArchArteries;
	private DeepPalmarArchArteries deepPalmarArchArteries;
	private PalmarCarpalBranchArteries palmarCarpalBranchArteries;
	private PrincepsPollicisArteries princepsPollicisArteries;
	private RadialisIndicisArteries radialisIndicisArteries;
	private PalmarMetacarpalArteries palmarMetacarpalArteries;
	
	// Arteries of the Abdominal Region
	//private AdrenalArteries adrenalArteries;
	private AbdominalAortaArtery abdominalAortaArtery;
	private AppendicularArtery appendicularArtery;
	private CysticArtery cysticArtery;
	private ProperHepaticArtery properHepaticArtery;
	private CommonHepaticArtery commonHepaticArtery;
	private HepaticArteries hepaticArteries;
	private InferiorEpigastricArtery inferiorEpigastricArtery;
	private InferiorMesentericArtery inferiorMesentericArtery;
	private LeftColicArtery leftColicArtery;
	private PancreaticoDuodenalArteries pancreaticoDuodenalArteries;
	private SuperiorMesentericArtery superiorMesentericArtery;
	
	private GastroDuodenalArtery gastroDuodenalArtery;
	private GastroEpiploicArteries gastroEpiploicArteries;
	private InferiorEpigastricArteries inferiorEpigastricArteries;
	private CeliacArtery celiacArtery;

	private InferiorSupraRenalArteries inferiorSupraRenalArteries;
	private MiddleSupraRenalArteries middleSupraRenalArteries;
	private SuperiorSupraRenalArteries superiorSupraRenalArteries;
	private RenalArteries renalArteries;
	private InferiorPhrenicArteries inferiorPhrenicArteries;
	
	//private PancreaticoDuodenalArteries pancreaticoDuodenalArteries;
	private InferiorPancreaticoDuodenalArtery inferiorPancreaticoDuodenalArtery;
	private SuperiorPancreaticoDuodenalArtery superiorPancreaticoDuodenalArtery;
	private SpleenCentralArteries spleenCentralArteries;
	private SplenicArtery splenicArtery;
	private GastricArteries gastricArteries;
	private SuperiorEpigastricArteries superiorEpigastricArteries;
	private TrabecularArteries trabecularArteries;

	
	
	// Arteries of the Back  
	
	// Arteries of the Hip/Pelvis
	private CommonIliacArteries commonIliacArteries;
	private ExternalIliacArteries externalIliacArteries;
	private InternalIliacArteries internalIliacArteries;
	private GonadalArtery gonadalArtery;
	private LateralEpiphysealArtery lateralEpiphysealArtery;
	private OvarianArtery ovarianArtery;
	private RectalArtery RectalArtery;
	private RenalArtery RenalArtery;
	
	// Arteries of the Legs
	private AnteriorTibialArteries anteriorTibialArteries;
	private PosteriorTibialArteries posteriorTibialArteries;
	private PeronealArteries peronealArteries;
	private CommonFemoralArteries commonFemoralArteries;
	private DeepFemoralArteries deepFemoralArteries;
	private DorsalisPedisArtery dorsalisPedisArtery;
	private InferiorGlutealArtery inferiorGlutealArtery;
	private LateralCircumflexFemoralArteries lateralCircumflexFemoralArteries;
	private MedialCircumflexFemoralArteries medialCircumflexFemoralArteries;
	//private LateralSuperiorGenicularArteries lateralSuperiorGenicularArteries;

	//private PosteriorTibialArteries posteriorTibialArteries;
	private ProfundaFemorisArtery profundaFemorisArtery;
	private SuperficialFemoralArteries superficialFemoralArteries;
	private ObturatorArteries  obturatorArteries;

	private PoplitealArteries poplitealArteries;
	private DescendingGenicularArteries descendingGenicularArteries;
	private DescendingGenicularArticularArteries  descendingGenicularArticularArteries;
	private DescendingGenicularSaphenousArteries  descendingGenicularSaphenousArteries;	

	
	// Ateries of the foot
	private LateralCalcanealArtery calcaneanArtery;
	private DeepPalmarArterialArch deepPalmarArterialArch;
	private LateralPlantarArtery lateralPlantarArtery;
	private MedialPlantarArtery medialPlantarArtery;
	private PalmarDigitalArtery palmarDigitalArtery;
	//private PosteriorTibialArtery posteriorTibialArtery;
	private SuperficialPalmerArterialArch superficialPalmerArterialArch;

	//private PalatineArteries palatineArteries;
	private AscendingPalatineArteries ascendingPalatineArteries;
	private DescendingPalatineArteries descendingPalatineArteries;

	private AccessoryMeningealArteries accessoryMeningealArteries;
	private MiddleMeningealArteries middleMeningealArteries;
	private PosteriorMeningealArteries posteriorMeningealArteries;
	private AscendingPharyngealArteries ascendingPharyngealArteries;


	/************************************************************************
	 * ARTERIES Constructor 
	 *
	 ***********************************************************************/

	public Arteries()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.Arteries, null, null);
	}

	public Arteries(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public Arteries(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE ARTERIES
	 * 
	 * @param parentID
	 * @param bioMightMethodsx`
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Arteries.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		boolean bStored = false;
	
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ArteriesInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ArteriesRef, parentID);
				System.out.println("Have Arteries Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Arteries");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}	
			
			
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
						
			// Run through the collection of Arteriess and build them into the model
			// In the default case, we get one instance of the Arteries for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Arteries NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Arteries we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				componentID = bioMightTransform.getId();
				System.out.println("Creating Arteries object: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
				
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
						//System.out.println("Have Arteries Property Info from EJB - NumProps: " + bioMightProperties.size());   	
					}catch (Exception e) { 
						System.out.println("Exception Getting Components Properties - Arteries");
						throw new ServerException("Remote Exception getComponents():", e); 	
					} 

					//System.out.println("Arteries: Using Properties from Datastore");
					bStored = true;
				}
				else
				{
					//System.out.println("Arteries - Using LocalProperties...");
				}
				//System.out.println("Arteries - PropertiesSize: " + bioMightProperties.size());
				//dumpProperties();
				
				createEm(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				
				// Store the new set of properties based on the init Property methods called above	
				// This means the user set properties
				System.out.println("Storing Arteries PROPS" +  properties.size()     + "flag: "+   bStored);
				if (properties != null && !bStored) {
					if (properties.size()>0) {
					// Store the Properties that the user set in the page	
					// We will use the enable flag to see what should be turned on/off
						try {
							// Get the information from the database via the Enterprise Bean		
							//System.out.println("Setting Property info for Arteries: " + bioMightTransform.getId());
							InitialContext ctx = new InitialContext();
							BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
							int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
									Constants.ArteriesRef, bioMightTransform.getComponentName(), properties);
							//dumpProperties();
							//System.out.println("Stored Arteries Property Info into EJB: " + propSave);   	
						}catch (Exception e) { 
							System.out.println("Exception Storing Components Properties - Arteries");
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
			
			// ON the drill down go into the detail
			localLOD = Constants.MAG2X;
			//***************************************************************
			//***************************************************************
			
			localVP = Constants.VIEW_HAWKEYE;
			//localLOD = Constants.MAG1X;
			
			// This is when one is accessing a Arteries directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye ArteriesInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ArteriesRef, parentID); 	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Arteries");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Arteries for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Arteries NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Arteries
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				componentID = bioMightTransform.getId();
				System.out.println("Creating Arteries: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
				
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
						//System.out.println("Have Arteries Property Info from EJB - NumProps: " + bioMightProperties.size());   	
					}catch (Exception e) { 
						System.out.println("Exception Getting Components Properties - Arteries");
						throw new ServerException("Remote Exception getComponents():", e); 	
					} 

					//System.out.println("Arteries: Using Properties from Datastore");
					bStored = true;
				}
				else
				{
					//System.out.println("Arteries - Using LocalProperties...");
				}
				//System.out.println("Arteries - PropertiesSize: " + bioMightProperties.size());
				//dumpProperties();
				

				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
				createEm(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				
				
				// Store the new set of properties based on the init Property methods called above	
				// This means the user set properties
				//System.out.println("Storing Arteries PROPS" +  properties.size()     + "flag: "+   bStored);
				if (properties != null && !bStored) {
					if (properties.size()>0) {
					// Store the Properties that the user set in the page	
					// We will use the enable flag to see what should be turned on/off
						try {
							// Get the information from the database via the Enterprise Bean		
							//System.out.println("Setting Property info for Arteries: " + bioMightTransform.getId());
							InitialContext ctx = new InitialContext();
							BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
							int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
									Constants.ArteriesRef, bioMightTransform.getComponentName(), properties);      
							//System.out.println("Stored Arteries Property Info into EJB: " + propSave);  
							//dumpProperties();
						}catch (Exception e) { 
							System.out.println("Exception Storing Components Properties - Arteries");
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
		
		System.out.println("Create Arteries Completed");
	}
	
	/******************************************************************************
	 * CREATE EM
	 * @param localVP
	 * @param localLOD
	 * @param parentID
	 * @param bioMightProperties
	 * @param bioMightMethods
	 *******************************************************************************/
	
	private void createEm(int localVP, int localLOD, String parentID, ArrayList bioMightProperties, ArrayList bioMightMethods) {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Arteries.x3d";

		
		initProperty("---"+Constants.HeadRef+"-----", Constants.Head, Constants.HeadRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.AngularArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AngularArteries for ParentID: " + parentID);
			angularArteries = new AngularArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AngularArteries", Constants.AngularArteries, Constants.AngularArteriesRef, angularArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AngularArteries");
		}
		else
			initProperty(Constants.AngularArteriesRef, Constants.AngularArteries, Constants.AngularArteriesRef, BioWebUtils.getPropertyID(Constants.AngularArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
			
		if (BioWebUtils.isViewEnabled(Constants.BasilarArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the BasilarArtery for ParentID: " + parentID);
			basilarArtery = new BasilarArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BasilarArteryRef, Constants.BasilarArtery, Constants.BasilarArteryRef, basilarArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BasilarArtery");
		}
		else
			initProperty("BasilarArtery", Constants.BasilarArtery, Constants.BasilarArteryRef, BioWebUtils.getPropertyID(Constants.BasilarArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.BuccalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the BuccalArteries for ParentID: " + parentID);
			buccalArteries = new BuccalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BuccalArteriesRef, Constants.BuccalArteries, Constants.BuccalArteriesRef, buccalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BuccalArteries");
		}
		else
			initProperty(Constants.BuccalArteriesRef, Constants.BuccalArteries, Constants.BuccalArteriesRef, BioWebUtils.getPropertyID(Constants.BuccalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.FacialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the FacialArteries for ParentID: " + parentID);
			facialArteries = new FacialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.FacialArteriesRef, Constants.FacialArteries, Constants.FacialArteriesRef, facialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the FacialArteries");
		}
		else
			initProperty(Constants.FacialArteriesRef, Constants.FacialArteries, Constants.FacialArteriesRef, BioWebUtils.getPropertyID(Constants.FacialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.TransverseFacialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the TransverseFacialArteries for ParentID: " + parentID);
			transverseFacialArteries = new TransverseFacialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.TransverseFacialArteriesRef, Constants.TransverseFacialArteries, Constants.TransverseFacialArteriesRef, transverseFacialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the TransverseFacialArteries");
		}
		else
			initProperty(Constants.TransverseFacialArteriesRef, Constants.TransverseFacialArteries, Constants.TransverseFacialArteriesRef, BioWebUtils.getPropertyID(Constants.TransverseFacialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.DorsalNasalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the DorsalNasalArteries for ParentID: " + parentID);
			dorsalNasalArteries = new DorsalNasalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DorsalNasalArteriesRef, Constants.DorsalNasalArteries, Constants.DorsalNasalArteriesRef, dorsalNasalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DorsalNasalArteries");
		}
		else
			initProperty("DorsalNasalArteries", Constants.DorsalNasalArteries, Constants.DorsalNasalArteriesRef, BioWebUtils.getPropertyID(Constants.DorsalNasalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.LacrimalArteriesRef, bioMightProperties)) {	
			lacrimalArteries = new LacrimalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("LacrimalArteries", Constants.LacrimalArteries, Constants.LacrimalArteriesRef, lacrimalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the LacrimalArteries");
		}
		else
			initProperty(Constants.LacrimalArteriesRef, Constants.LacrimalArteries, Constants.LacrimalArteriesRef, BioWebUtils.getPropertyID(Constants.LacrimalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.OccipitalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the OccipitalArteries for ParentID: " + parentID);
			occipitalArteries = new OccipitalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("OccipitalArteries", Constants.OccipitalArteries, Constants.OccipitalArteriesRef, occipitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the OccipitalArteries");
		}
		else
			initProperty(Constants.OccipitalArteriesRef, Constants.OccipitalArteries, Constants.OccipitalArteriesRef, BioWebUtils.getPropertyID(Constants.OccipitalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.OphthalmicArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the OphthalmicArteries for ParentID: " + parentID);
			ophthalmicArteries = new OphthalmicArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.OphthalmicArteriesRef, Constants.OphthalmicArteries, Constants.OphthalmicArteriesRef, ophthalmicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the OphthalmicArteries");
		}
		else
			initProperty(Constants.OphthalmicArteriesRef, Constants.OphthalmicArteries, Constants.OphthalmicArteriesRef, BioWebUtils.getPropertyID(Constants.OphthalmicArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.MentalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MentalArteries for ParentID: " + parentID);
			mentalArteries = new MentalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("MentalArteries", Constants.MentalArteries, Constants.MentalArteriesRef, mentalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MentalArteries");
		}
		else
			initProperty("MentalArteries", Constants.MentalArteries, Constants.MentalArteriesRef, BioWebUtils.getPropertyID(Constants.MentalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.RanineArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the RanineArteries for ParentID: " + parentID);
			ranineArteries = new RanineArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("RanineArteries", Constants.RanineArteries, Constants.RanineArteriesRef, ranineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RanineArteries");
		}
		else
			initProperty(Constants.RanineArteriesRef, Constants.RanineArteries, Constants.RanineArteriesRef, BioWebUtils.getPropertyID(Constants.RanineArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.FrontalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the FrontalArteries for ParentID: " + parentID);
			frontalArteries = new FrontalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("FrontalArteries", Constants.FrontalArteries, Constants.FrontalArteriesRef, frontalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the FrontalArteries");
		}
		else
			initProperty(Constants.FrontalArteriesRef, Constants.FrontalArteries, Constants.FrontalArteriesRef, BioWebUtils.getPropertyID(Constants.FrontalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.InternalCarotidArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InternalCarotidArteries for ParentID: " + parentID);
			internalCarotidArteries = new InternalCarotidArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("InternalCarotidArteries", Constants.InternalCarotidArteries, Constants.InternalCarotidArteriesRef, internalCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InternalCarotidArteries");
		}
		else
			initProperty("InternalCarotidArteries", Constants.InternalCarotidArteries, Constants.InternalCarotidArteriesRef, BioWebUtils.getPropertyID(Constants.InternalCarotidArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.ExternalCarotidArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the ExternalCarotidArteries for ParentID: " + parentID);
			externalCarotidArteries = new ExternalCarotidArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("ExternalCarotidArteries", Constants.ExternalCarotidArteries, Constants.ExternalCarotidArteriesRef, externalCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ExternalCarotidArteries");
			}
		else
			initProperty("ExternalCarotidArteries", Constants.ExternalCarotidArteries, Constants.ExternalCarotidArteriesRef, BioWebUtils.getPropertyID(Constants.ExternalCarotidArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.StylomastoidArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the StylomastoidArteries for ParentID: " + parentID);
			stylomastoidArteries = new StylomastoidArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.StylomastoidArteriesRef, Constants.StylomastoidArteries, Constants.StylomastoidArteriesRef, stylomastoidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the StylomastoidArteries");
			}
		else
			initProperty(Constants.StylomastoidArteriesRef, Constants.StylomastoidArteries, Constants.StylomastoidArteriesRef, BioWebUtils.getPropertyID(Constants.StylomastoidArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.MedialPalpebralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MedialPalpebralArteries for ParentID: " + parentID);
			medialPalpebralArteries = new MedialPalpebralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MedialPalpebralArteriesRef, Constants.MedialPalpebralArteries, Constants.MedialPalpebralArteriesRef, medialPalpebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MedialPalebralArteries");
		}
		else
			initProperty(Constants.MedialPalpebralArteriesRef, Constants.MedialPalpebralArteries, Constants.MedialPalpebralArteriesRef, BioWebUtils.getPropertyID(Constants.MedialPalpebralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		//System.out.println("Creating the CerebellarArteries for ParentID: " + parentID);
		//cerebellarArteries = new CerebellarArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
		//initProperty("CerebellarArteries", Constants.CerebellarArteries, Constants.CerebellarArteriesRef, anteriorInferiorCerebellarArteries.getComponentID());
		//System.out.println("Created the CerebellarArteries");

		if (BioWebUtils.isViewEnabled(Constants.SuperiorCerebellarArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorCerebellarArteries for ParentID: " + parentID);
			superiorCerebellarArteries = new SuperiorCerebellarArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SuperiorCerebellarArteries", Constants.SuperiorCerebellarArteries, Constants.SuperiorCerebellarArteriesRef, superiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorCerebellarArteries");
		}
		else
			initProperty("SuperiorCerebellarArteries", Constants.SuperiorCerebellarArteries, Constants.SuperiorCerebellarArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorCerebellarArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorInferiorCerebellarArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorInferiorCerebellarArteries for ParentID: " + parentID);
			anteriorInferiorCerebellarArteries = new AnteriorInferiorCerebellarArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorInferiorCerebellarArteriesRef, Constants.AnteriorInferiorCerebellarArteries, Constants.AnteriorInferiorCerebellarArteriesRef, anteriorInferiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorInferiorCerebellarArteries");
		}
		else
			initProperty(Constants.AnteriorInferiorCerebellarArteriesRef, Constants.AnteriorInferiorCerebellarArteries, Constants.AnteriorInferiorCerebellarArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorInferiorCerebellarArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorInferiorCerebellarArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorInferiorCerebellarArteries for ParentID: " + parentID);
			posteriorInferiorCerebellarArteries = new PosteriorInferiorCerebellarArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorInferiorCerebellarArteriesRef, Constants.PosteriorInferiorCerebellarArteries, Constants.PosteriorInferiorCerebellarArteriesRef, posteriorInferiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorInferiorCerebellarArteries");
		}
		else
			initProperty(Constants.PosteriorInferiorCerebellarArteriesRef, Constants.PosteriorInferiorCerebellarArteries, Constants.PosteriorInferiorCerebellarArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorInferiorCerebellarArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCerebralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorCerebralArteries for ParentID: " + parentID);
			anteriorCerebralArteries = new AnteriorCerebralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorCerebralArteriesRef, Constants.AnteriorCerebralArteries, Constants.AnteriorCerebralArteriesRef, anteriorCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorCerebralArteries");
		}
		else
			initProperty(Constants.AnteriorCerebralArteriesRef, Constants.AnteriorCerebralArteries, Constants.AnteriorCerebralArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorCerebralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.MiddleCerebralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MiddleCerebralArteries for ParentID: " + parentID);
			middleCerebralArteries = new MiddleCerebralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MiddleCerebralArteriesRef, Constants.MiddleCerebralArteries, Constants.MiddleCerebralArteriesRef, middleCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MiddleCerebralArteries");
		}
		else
			initProperty(Constants.MiddleCerebralArteriesRef, Constants.MiddleCerebralArteries, Constants.MiddleCerebralArteriesRef, BioWebUtils.getPropertyID(Constants.MiddleCerebralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCerebralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorCerebralArteries for ParentID: " + parentID);
			posteriorCerebralArteries = new PosteriorCerebralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorCerebralArteriesRef, Constants.PosteriorCerebralArteries, Constants.PosteriorCerebralArteriesRef, posteriorCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorCerebralArteries");
			}
		else
			initProperty(Constants.PosteriorCerebralArteriesRef, Constants.PosteriorCerebralArteries, Constants.PosteriorCerebralArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorCerebralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		//System.out.println("Creating the HypophysealArteries for ParentID: " + parentID);
		//hypophysealArteries = new HypophysealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
		//initProperty("HypophysealArteries", Constants.HypophysealArteries, Constants.HypophysealArteriesRef, hypophysealArteries.getComponentID());
		//System.out.println("Created the HypophysealArteries");

		if (BioWebUtils.isViewEnabled(Constants.SuperiorHypophysealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorHypophysealArteries for ParentID: " + parentID);
			superiorHypophysealArteries = new SuperiorHypophysealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorHypophysealArteriesRef, Constants.SuperiorHypophysealArteries, Constants.SuperiorHypophysealArteriesRef, superiorHypophysealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorHypophysealArteries");
		}
		else
			initProperty(Constants.SuperiorHypophysealArteriesRef, Constants.SuperiorHypophysealArteries, Constants.SuperiorHypophysealArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorHypophysealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.InferiorHypophysealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorHypophysealArteries for ParentID: " + parentID);
			inferiorHypophysealArteries = new InferiorHypophysealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorHypophysealArteriesRef, Constants.InferiorHypophysealArteries, Constants.InferiorHypophysealArteriesRef, inferiorHypophysealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the HypophysealArteries");
		}
		else
			initProperty(Constants.InferiorHypophysealArteriesRef, Constants.InferiorHypophysealArteries, Constants.InferiorHypophysealArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorHypophysealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCommunicatingArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorCommunicatingArtery for ParentID: " + parentID);
			anteriorCommunicatingArtery = new AnteriorCommunicatingArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorCommunicatingArteryRef, Constants.AnteriorCommunicatingArtery, Constants.AnteriorCommunicatingArteryRef, anteriorCommunicatingArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorCommunicatingArtery");
		}
		else
			initProperty(Constants.AnteriorCommunicatingArteryRef, Constants.AnteriorCommunicatingArtery, Constants.AnteriorCommunicatingArteryRef, BioWebUtils.getPropertyID(Constants.AnteriorCommunicatingArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCommunicatingArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorCommunicatingArteries for ParentID: " + parentID);
			posteriorCommunicatingArteries = new PosteriorCommunicatingArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorCommunicatingArteriesRef, Constants.PosteriorCommunicatingArteries, Constants.PosteriorCommunicatingArteriesRef, posteriorCommunicatingArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorCommunicatingArteries");
		}
		else
			initProperty(Constants.PosteriorCommunicatingArteriesRef, Constants.PosteriorCommunicatingArteries, Constants.PosteriorCommunicatingArteriesRef ,BioWebUtils.getPropertyID(Constants.PosteriorCommunicatingArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.VertebralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the VertebralArteries for ParentID: " + parentID);
			vertebralArteries = new VertebralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.VertebralArteriesRef, Constants.VertebralArteries, Constants.VertebralArteriesRef, vertebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the VertebralArteries");
		}
		else
			initProperty(Constants.VertebralArteriesRef, Constants.VertebralArteries, Constants.VertebralArteriesRef, BioWebUtils.getPropertyID(Constants.VertebralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorSpinalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorSpinalArteries for ParentID: " + parentID);
			anteriorSpinalArteries = new AnteriorSpinalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorSpinalArteriesRef, Constants.AnteriorSpinalArteries, Constants.AnteriorSpinalArteriesRef,anteriorSpinalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorSpinalArteries");
		}
		else
			initProperty(Constants.AnteriorSpinalArteriesRef, Constants.AnteriorSpinalArteries, Constants.AnteriorSpinalArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorSpinalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.PontineArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PontineArteries for ParentID: " + parentID);
			pontineArteries = new PontineArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PontineArteries", Constants.PontineArteries, Constants.PontineArteriesRef, pontineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PontineArteries");
		}
		else
			initProperty("PontineArteries", Constants.PontineArteries, Constants.PontineArteriesRef, BioWebUtils.getPropertyID(Constants.PontineArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.AscendingPalatineArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AscendingPalatineArteries for ParentID: " + parentID);
			ascendingPalatineArteries = new AscendingPalatineArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AscendingPalatineArteriesRef, Constants.AscendingPalatineArteries, Constants.AscendingPalatineArteriesRef, ascendingPalatineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AscendingPalatineArteries");
			}
		else
			initProperty(Constants.AscendingPalatineArteriesRef, Constants.AscendingPalatineArteries, Constants.AscendingPalatineArteriesRef, BioWebUtils.getPropertyID(Constants.AscendingPalatineArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.DescendingPalatineArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the DescendingPalatineArteries for ParentID: " + parentID);
			descendingPalatineArteries = new DescendingPalatineArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DescendingPalatineArteriesRef, Constants.DescendingPalatineArteries, Constants.DescendingPalatineArteriesRef, descendingPalatineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingPalatineArteries");
		}
		else
			initProperty(Constants.DescendingPalatineArteriesRef, Constants.DescendingPalatineArteries, Constants.DescendingPalatineArteriesRef, BioWebUtils.getPropertyID(Constants.DescendingPalatineArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		//System.out.println("Creating the ExternalMaxillaryArteries for ParentID: " + parentID);
		//externalMaxillaryArteries = new ExternalMaxillaryArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
		//initProperty("ExternalMaxillaryArteries", Constants.ExternalMaxillaryArteries, Constants.ExternalMaxillaryArteriesRef, externalMaxillaryArteries.getComponentID());
		//System.out.println("Created the ExternalMaxillaryArteries");

		if (BioWebUtils.isViewEnabled(Constants.InternalMaxillaryArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InternalMaxillaryArteries for ParentID: " + parentID);
			internalMaxillaryArteries = new InternalMaxillaryArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InternalMaxillaryArteriesRef, Constants.InternalMaxillaryArteries, Constants.InternalMaxillaryArteriesRef, internalMaxillaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InternalMaxillaryArteries");
		}
		else
			initProperty(Constants.InternalMaxillaryArteriesRef, Constants.InternalMaxillaryArteries, Constants.InternalMaxillaryArteriesRef, BioWebUtils.getPropertyID(Constants.InternalMaxillaryArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.SuperficialTemporalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperficialTemporalArteries for ParentID: " + parentID);
			superficialTemporalArteries = new SuperficialTemporalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SuperficialTemporalArteries", Constants.SuperficialTemporalArteries, Constants.SuperficialTemporalArteriesRef, superficialTemporalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperficialTemporalArteries");
		}
		else
			initProperty("SuperficialTemporalArteries", Constants.SuperficialTemporalArteries, Constants.SuperficialTemporalArteriesRef, BioWebUtils.getPropertyID(Constants.SuperficialTemporalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
		if (BioWebUtils.isViewEnabled(Constants.LingualArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the LingualArteries for ParentID: " + parentID);
			lingualArteries = new LingualArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.LingualArteriesRef, Constants.LingualArteries, Constants.LingualArteriesRef, lingualArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the LingualArteries");
			}
		else
			initProperty(Constants.LingualArteriesRef, Constants.LingualArteries, Constants.LingualArteriesRef, BioWebUtils.getPropertyID(Constants.LingualArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.AccessoryMeningealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AccessoryMeningealArteries for ParentID: " + parentID);
			accessoryMeningealArteries = new AccessoryMeningealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AccessoryMeningealArteriesRef, Constants.AccessoryMeningealArteries, Constants.AccessoryMeningealArteriesRef, accessoryMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AccessoryMeningealArteries");
		}
		else
			initProperty(Constants.AccessoryMeningealArteriesRef, Constants.AccessoryMeningealArteries, Constants.AccessoryMeningealArteriesRef, BioWebUtils.getPropertyID(Constants.AccessoryMeningealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.MiddleMeningealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MiddleMeningealArteries for ParentID: " + parentID);
			middleMeningealArteries = new MiddleMeningealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MiddleMeningealArteriesRef, Constants.MiddleMeningealArteries, Constants.MiddleMeningealArteriesRef, middleMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MiddleMeningealArteries");
			}
		else
			initProperty(Constants.MiddleMeningealArteriesRef, Constants.MiddleMeningealArteries, Constants.MiddleMeningealArteriesRef, BioWebUtils.getPropertyID(Constants.MiddleMeningealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorMeningealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorMeningealArteries for ParentID: " + parentID);
			posteriorMeningealArteries = new PosteriorMeningealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorMeningealArteriesRef, Constants.PosteriorMeningealArteries, Constants.PosteriorMeningealArteriesRef, posteriorMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorMeningealArteries");
		}
		else
			initProperty(Constants.PosteriorMeningealArteriesRef, Constants.PosteriorMeningealArteries, Constants.PosteriorMeningealArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorMeningealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.AscendingPharyngealArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AscendingPharyngealArteries for ParentID: " + parentID);
			ascendingPharyngealArteries = new AscendingPharyngealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AscendingPharyngealArteriesRef, Constants.AscendingPharyngealArteries, Constants.AscendingPharyngealArteriesRef, ascendingPharyngealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AscendingPharyngealArteries");
		}
		else
			initProperty(Constants.AscendingPharyngealArteriesRef, Constants.AscendingPharyngealArteries, Constants.AscendingPharyngealArteriesRef,BioWebUtils.getPropertyID(Constants.AscendingPharyngealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.InfraOrbitalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InfraOrbitalArteries for ParentID: " + parentID);
			infraOrbitalArteries = new InfraOrbitalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InfraOrbitalArteriesRef, Constants.InfraOrbitalArteries, Constants.InfraOrbitalArteriesRef, infraOrbitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InfraOrbitalArteries");
		}
		else
			initProperty(Constants.InfraOrbitalArteriesRef, Constants.InfraOrbitalArteries, Constants.InfraOrbitalArteriesRef, BioWebUtils.getPropertyID(Constants.InfraOrbitalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SupraOrbitalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SupraOrbitalArteries for ParentID: " + parentID);
			supraOrbitalArteries = new SupraOrbitalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SupraOrbitalArteriesRef, Constants.SupraOrbitalArteries, Constants.SupraOrbitalArteriesRef, supraOrbitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SupraOrbitalArteries");
		}
		else
			initProperty(Constants.SupraOrbitalArteriesRef, Constants.SupraOrbitalArteries, Constants.SupraOrbitalArteriesRef, BioWebUtils.getPropertyID(Constants.SupraOrbitalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.InferiorLabialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorLabialArteries for ParentID: " + parentID);
			inferiorLabialArteries = new InferiorLabialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorLabialArteriesRef, Constants.InferiorLabialArteries, Constants.InferiorLabialArteriesRef, inferiorLabialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorLabialArteries");
		}
		else
			initProperty(Constants.InferiorLabialArteriesRef, Constants.InferiorLabialArteries, Constants.InferiorLabialArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorLabialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorLabialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorLabialArteries for ParentID: " + parentID);
			superiorLabialArteries = new SuperiorLabialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorLabialArteriesRef, Constants.SuperiorLabialArteries, Constants.SuperiorLabialArteriesRef, superiorLabialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorLabialArteries");
		}
		else
			initProperty(Constants.SuperiorLabialArteriesRef, Constants.SuperiorLabialArteries, Constants.SuperiorLabialArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorLabialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SupraTrochlearArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SupraTrochlearArteries for ParentID: " + parentID);
			supraTrochlearArteries = new SupraTrochlearArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SupraTrochlearArteriesRef, Constants.SupraTrochlearArteries, Constants.SupraTrochlearArteriesRef, supraTrochlearArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SupraTrochlearArteries");
		}
		else
			initProperty(Constants.SupraTrochlearArteriesRef, Constants.SupraTrochlearArteries, Constants.SupraTrochlearArteriesRef, BioWebUtils.getPropertyID(Constants.SupraTrochlearArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		//*****************************************************************
		// NECK
		//*****************************************************************
		
		initProperty("-----"+Constants.NeckRef+"------", Constants.Neck, Constants.NeckRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.CommonCarotidArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the CommonCarotidArteries for ParentID: " + parentID);
			commonCarotidArteries = new CommonCarotidArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			BioMightGenerate generatedCommonCarotidArteries = commonCarotidArteries.getBioMightGenerate(); 
			initProperty(Constants.CommonCarotidArteriesRef, Constants.CommonCarotidArteries, Constants.CommonCarotidArteriesRef, commonCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CommonCarotidArteries");
		}
		else
			initProperty(Constants.CommonCarotidArteriesRef, Constants.CommonCarotidArteries, Constants.CommonCarotidArteriesRef, BioWebUtils.getPropertyID(Constants.CommonCarotidArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		//********************************************
		// CHEST
		//********************************************

		initProperty("-----"+Constants.ChestRef+"-------", Constants.Chest, Constants.ChestRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PulmonaryArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating PulmonaryArteries using ParentID: " + parentID);
			pulmonaryArteries = new PulmonaryArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PulmonaryArteriesRef, Constants.PulmonaryArteries, Constants.PulmonaryArteriesRef, pulmonaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("PulmonaryArteries is created");
		}
		else
			initProperty(Constants.PulmonaryArteriesRef, Constants.PulmonaryArteries, Constants.PulmonaryArteriesRef, BioWebUtils.getPropertyID(Constants.PulmonaryArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.BrachioCephalicArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the BrachioCephalicArtery for ParentID: " + parentID);
			brachioCephalicArtery = new BrachioCephalicArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BrachioCephalicArteryRef, Constants.BrachioCephalicArtery, Constants.BrachioCephalicArteryRef, brachioCephalicArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BrachioCephalicArtery");
		}
		else
			initProperty(Constants.BrachioCephalicArteryRef, Constants.BrachioCephalicArtery, Constants.BrachioCephalicArteryRef, BioWebUtils.getPropertyID(Constants.BrachioCephalicArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.ThoracicArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the ThoracicArteries for ParentID: " + parentID);
			thoracicArteries = new ThoracicArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ThoracicArteriesRef, Constants.ThoracicArteries, Constants.ThoracicArteriesRef, thoracicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ThoracicArteries");
		}
		else
			initProperty(Constants.ThoracicArteriesRef, Constants.ThoracicArteries, Constants.ThoracicArteriesRef, BioWebUtils.getPropertyID(Constants.ThoracicArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SubclavianArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SubclavianArteries for ParentID: " + parentID);
			subclavianArteries = new SubclavianArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SubclavianArteriesRef, Constants.SubclavianArteries, Constants.SubclavianArteriesRef, subclavianArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SubclavianArteries");
		}
		else
			initProperty("SubclavianArteries", Constants.SubclavianArteries, Constants.SubclavianArteriesRef, BioWebUtils.getPropertyID(Constants.SubclavianArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.BronchialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the BronchialArteries for ParentID: " + parentID);
			bronchialArteries = new BronchialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BronchialArteries", Constants.BronchialArteries, Constants.BronchialArteriesRef, bronchialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BronchialArtery");
		}
		else
			initProperty("BronchialArteries", Constants.BronchialArteries, Constants.BronchialArteriesRef, BioWebUtils.getPropertyID(Constants.BronchialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);


		if (BioWebUtils.isViewEnabled(Constants.ConusArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the ConusArtery for ParentID: " + parentID);
			conusArtery = new ConusArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ConusArteryRef, Constants.ConusArtery, Constants.ConusArteryRef, conusArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ConusArtery");
		}
		else
			initProperty(Constants.ConusArteryRef, Constants.ConusArtery, Constants.ConusArteryRef, BioWebUtils.getPropertyID(Constants.ConusArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		//System.out.println("Creating the AortaArtery for ParentID: " + parentID);
		//aortaArtery = new AortaArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
		//initProperty("AortaArtery", Constants.AortaArtery, Constants.AortaArteryRef, aortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true););
		//System.out.println("Created the AortaArtery");

		if (BioWebUtils.isViewEnabled(Constants.DescendingAortaArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the DescendingAortaArtery for ParentID: " + parentID);
			descendingAortaArtery = new DescendingAortaArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DescendingAortaArteryRef, Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, descendingAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingAortaArtery");
		}
		else
			initProperty(Constants.DescendingAortaArteryRef, Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, BioWebUtils.getPropertyID(Constants.DescendingAortaArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.AorticArchRef, bioMightProperties)) {	
			//System.out.println("Creating the AorticArch for ParentID: " + parentID);
			aorticArch = new AorticArch(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AorticArchRef, Constants.AorticArch, Constants.AorticArchRef, aorticArch.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AorticArch");
		}
		else
			initProperty(Constants.AorticArchRef, Constants.AorticArch, Constants.AorticArchRef, BioWebUtils.getPropertyID(Constants.AorticArchRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the AscendingAortaArtery for ParentID: " + parentID);
			ascendingAortaArtery = new AscendingAortaArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AscendingAortaArteryRef, Constants.AscendingAortaArtery, Constants.AscendingAortaArteryRef, ascendingAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AscendingAortaArtery");
		}
		else
			initProperty(Constants.AscendingAortaArteryRef, Constants.AscendingAortaArtery, Constants.AscendingAortaArteryRef, BioWebUtils.getPropertyID(Constants.AscendingAortaArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.AxillaryArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AxillaryArteries for ParentID: " + parentID);
			axillaryArteries = new AxillaryArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AxillaryArteriesRef, Constants.AxillaryArteries, Constants.AxillaryArteriesRef, axillaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AxillaryArteries");	
		}
		else
			initProperty(Constants.AxillaryArteriesRef, Constants.AxillaryArteries, Constants.AxillaryArteriesRef, BioWebUtils.getPropertyID(Constants.AxillaryArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.CoronaryArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the CoronaryArteries for ParentID: " + parentID);
			coronaryArteries = new CoronaryArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CoronaryArteries", Constants.CoronaryArteries, Constants.CoronaryArteriesRef, coronaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CoronaryArteries");
		}
		else
			initProperty("CoronaryArteries", Constants.CoronaryArteries, Constants.CoronaryArteriesRef, BioWebUtils.getPropertyID(Constants.CoronaryArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.ObtuseMarginalArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the ObtuseMarginalArtery for ParentID: " + parentID);
			obtuseMarginalArtery = new ObtuseMarginalArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("ObtuseMarginalArtery", Constants.ObtuseMarginalArtery, Constants.ObtuseMarginalArteryRef, obtuseMarginalArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ObtuseMarginalArtery");
		}
		else
			initProperty(Constants.ObtuseMarginalArteryRef, Constants.ObtuseMarginalArtery, Constants.ObtuseMarginalArteryRef, BioWebUtils.getPropertyID(Constants.ObtuseMarginalArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		//*************************************
		// ABDOMEN
		//**************************************

		initProperty("------"+Constants.AbdomenRef+"------", Constants.Abdomen, Constants.AbdomenRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		/* if (BioWebUtils.isViewEnabled(Constants.DescendingAortaArteryRef, bioMightProperties)) {	
			System.out.println("Creating the Descending for ParentID: " + parentID);
			descendingAortaArtery = new DescendingAortaArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DescendingAortaArtery", Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, descendingAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingAortaArtery");
		}
		else
			initProperty(Constants.DescendingAortaArteryRef, Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, BioWebUtils.getPropertyID(Constants.DescendingAortaArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		*/
		
		if (BioWebUtils.isViewEnabled(Constants.AbdominalAortaArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the AbdominalAortaArtery for ParentID: " + parentID);
			abdominalAortaArtery = new AbdominalAortaArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AbdominalAortaArteryRef, Constants.AbdominalAortaArtery, Constants.AbdominalAortaArteryRef, abdominalAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AbdominalAortaArtery");
		}
		else
			initProperty(Constants.AbdominalAortaArteryRef, Constants.AbdominalAortaArtery, Constants.AbdominalAortaArteryRef, BioWebUtils.getPropertyID(Constants.AbdominalAortaArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		

		if (BioWebUtils.isViewEnabled(Constants.CeliacArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the CeliacArtery for ParentID: " + parentID);
			celiacArtery = new CeliacArtery(Constants.VIEW_DETACHED, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.CeliacArteryRef, Constants.CeliacArtery, Constants.CeliacArteryRef, celiacArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CeliacArtery");
		}
		else
			initProperty(Constants.CeliacArteryRef, Constants.CeliacArtery, Constants.CeliacArteryRef, BioWebUtils.getPropertyID(Constants.CeliacArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		//	System.out.println("Creating the AdrenalArteries for parent: " + parentID);
		//	adrenalArteries = new AdrenalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
		//	initProperty("AdrenalArteries", Constants.AdrenalArteries, Constants.AdrenalArteriesRef, adrenalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true););
		//	System.out.println("Created the AdrenalArteries");	

		
		if (BioWebUtils.isViewEnabled(Constants.AppendicularArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the AppendicularArtery for parent: " + parentID);
			appendicularArtery = new AppendicularArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AppendicularArteryRef, Constants.AppendicularArtery, Constants.AppendicularArteryRef, appendicularArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AppendicularArtery");	
		}
		else
			initProperty(Constants.AppendicularArteryRef, Constants.AppendicularArtery, Constants.AppendicularArteryRef, BioWebUtils.getPropertyID(Constants.AppendicularArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.CommonHepaticArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the CommonHepaticArtery for parent: " + parentID);
			commonHepaticArtery = new CommonHepaticArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.CommonHepaticArteryRef, Constants.CommonHepaticArtery, Constants.CommonHepaticArteryRef, commonHepaticArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CommonHepaticArtery");	
		}
		else
			initProperty("CommonHepaticArtery", Constants.CommonHepaticArtery, Constants.CommonHepaticArteryRef, BioWebUtils.getPropertyID(Constants.CommonHepaticArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.CysticArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the CysticArtery for parent: " + parentID);
			cysticArtery = new CysticArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CysticArtery", Constants.CysticArtery, Constants.CysticArteryRef, cysticArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CysticArtery");	
		}
		else
			initProperty("CysticArtery", Constants.CysticArtery, Constants.CysticArteryRef, BioWebUtils.getPropertyID(Constants.CysticArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.GastroDuodenalArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the GastroDuodenalArtery for parent: " + parentID);
			gastroDuodenalArtery = new GastroDuodenalArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.GastroDuodenalArteryRef, Constants.GastroDuodenalArtery, Constants.GastroDuodenalArteryRef, gastroDuodenalArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the GastroEpiploicArteries");	
		}
		else
			initProperty("GastroDuodenalArtery", Constants.GastroDuodenalArtery, Constants.GastroDuodenalArteryRef, BioWebUtils.getPropertyID(Constants.GastroDuodenalArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.GastroEpiploicArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the GastroEpiploicArteries for parent: " + parentID);
			gastroEpiploicArteries = new GastroEpiploicArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("GastroEpiploicArteries", Constants.GastroEpiploicArteries, Constants.GastroEpiploicArteriesRef, gastroEpiploicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the GastroEpiploicArteries");	
		}
		else
			initProperty("GastroEpiploicArteries", Constants.GastroEpiploicArteries, Constants.GastroEpiploicArteriesRef, BioWebUtils.getPropertyID(Constants.GastroEpiploicArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorEpigastricArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorEpigastricArteries for parent: " + parentID);
			inferiorEpigastricArteries = new InferiorEpigastricArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorEpigastricArteriesRef, Constants.InferiorEpigastricArteries, Constants.InferiorEpigastricArteriesRef, inferiorEpigastricArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorEpigastricArteries");	
		}
		else
			initProperty("InferiorEpigastricArteries", Constants.InferiorEpigastricArteries, Constants.InferiorEpigastricArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorEpigastricArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorMesentericArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorMesentericArtery for parent: " + parentID);
			inferiorMesentericArtery = new InferiorMesentericArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorMesentericArteryRef, Constants.InferiorMesentericArtery, Constants.InferiorMesentericArteryRef, inferiorMesentericArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorMesentericArtery");	
		}
		else
			initProperty(Constants.InferiorMesentericArteryRef, Constants.InferiorMesentericArtery, Constants.InferiorMesentericArteryRef, BioWebUtils.getPropertyID(Constants.InferiorMesentericArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.RenalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the RenalArteries for parent: " + parentID);
			renalArteries = new RenalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.RenalArteriesRef, Constants.RenalArteries, Constants.RenalArteriesRef, renalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RenalArteries");	
		}
		else
			initProperty("RenalArteries", Constants.RenalArteries, Constants.RenalArteriesRef, BioWebUtils.getPropertyID(Constants.RenalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorSupraRenalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorSupraRenalArteries for parent: " + parentID);
			inferiorSupraRenalArteries = new InferiorSupraRenalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorSupraRenalArteriesRef, Constants.InferiorSupraRenalArteries, Constants.InferiorSupraRenalArteriesRef, inferiorSupraRenalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorSupraRenalArteries");	
		}
		else
			initProperty(Constants.InferiorSupraRenalArteriesRef, Constants.InferiorSupraRenalArteries, Constants.InferiorSupraRenalArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorSupraRenalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.MiddleSupraRenalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MiddleSupraRenalArteries for parent: " + parentID);
			middleSupraRenalArteries = new MiddleSupraRenalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MiddleSupraRenalArteriesRef, Constants.MiddleSupraRenalArteries, Constants.MiddleSupraRenalArteriesRef, middleSupraRenalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MiddleSupraRenalArteries");	
		}
		else
			initProperty(Constants.MiddleSupraRenalArteriesRef, Constants.MiddleSupraRenalArteries, Constants.MiddleSupraRenalArteriesRef, BioWebUtils.getPropertyID(Constants.MiddleSupraRenalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorPhrenicArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorPhrenicArteries for parent: " + parentID);
			inferiorPhrenicArteries = new InferiorPhrenicArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorPhrenicArteriesRef, Constants.InferiorPhrenicArteries, Constants.InferiorPhrenicArteriesRef, inferiorPhrenicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorPhrenicArteries");	
		}
		else
			initProperty(Constants.InferiorPhrenicArteriesRef, Constants.InferiorPhrenicArteries, Constants.InferiorPhrenicArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorPhrenicArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorPancreaticoDuodenalArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorPancreaticoDuodenalArtery for parent: " + parentID);
			inferiorPancreaticoDuodenalArtery = new InferiorPancreaticoDuodenalArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorPancreaticoDuodenalArteryRef, Constants.InferiorPancreaticoDuodenalArtery, Constants.InferiorPancreaticoDuodenalArteryRef, inferiorPancreaticoDuodenalArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorPancreaticoDuodenalArtery");	
		}
		else
			initProperty(Constants.InferiorPancreaticoDuodenalArteryRef, Constants.InferiorPancreaticoDuodenalArtery, Constants.InferiorPancreaticoDuodenalArteryRef, BioWebUtils.getPropertyID(Constants.InferiorPancreaticoDuodenalArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.ProperHepaticArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the ProperHepaticArtery for parent: " + parentID);
			properHepaticArtery = new ProperHepaticArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ProperHepaticArteryRef, Constants.ProperHepaticArtery, Constants.ProperHepaticArteryRef, properHepaticArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ProperHepaticArtery");	
		}
		else
			initProperty(Constants.ProperHepaticArteryRef, Constants.ProperHepaticArtery, Constants.ProperHepaticArteryRef, BioWebUtils.getPropertyID(Constants.ProperHepaticArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.HepaticArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the HepaticArteries for ParentID: " + parentID);
			hepaticArteries = new HepaticArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.HepaticArteriesRef, Constants.HepaticArteries, Constants.HepaticArteriesRef, hepaticArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the HepaticArteriesRef");
		}
		else
			initProperty(Constants.HepaticArteriesRef, Constants.HepaticArteries, Constants.HepaticArteriesRef, BioWebUtils.getPropertyID(Constants.HepaticArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SplenicArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the SplenicArtery for parent: " + parentID);
			splenicArtery = new SplenicArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SplenicArtery", Constants.SplenicArtery, Constants.SplenicArteryRef, splenicArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SplenicArtery");	
		}
		else
			initProperty("SplenicArtery", Constants.SplenicArtery, Constants.SplenicArteryRef, BioWebUtils.getPropertyID(Constants.SplenicArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.GastricArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the GastricArteries for parent: " + parentID);
			gastricArteries = new GastricArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.GastricArteriesRef, Constants.GastricArteries, Constants.GastricArteriesRef, gastricArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the GastricArteries");	
		}
		else
			initProperty(Constants.GastricArteriesRef, Constants.GastricArteries, Constants.GastricArteriesRef, BioWebUtils.getPropertyID(Constants.GastricArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.SpleenCentralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SpleenCentralArteries for parent: " + parentID);
			spleenCentralArteries = new SpleenCentralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SpleenCentralArteriesRef, Constants.SpleenCentralArteries, Constants.SpleenCentralArteriesRef, spleenCentralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SpleenCentralArteries");	
		}
		else
			initProperty(Constants.SpleenCentralArteriesRef, Constants.SpleenCentralArteries, Constants.SpleenCentralArteriesRef, BioWebUtils.getPropertyID(Constants.SpleenCentralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorEpigastricArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorEpigastricArteries for parent: " + parentID);
			superiorEpigastricArteries = new SuperiorEpigastricArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorEpigastricArteriesRef, Constants.SuperiorEpigastricArteries, Constants.SuperiorEpigastricArteriesRef, superiorEpigastricArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorEpigastricArteries");	
		}
		else
			initProperty(Constants.SuperiorEpigastricArteriesRef, Constants.SuperiorEpigastricArteries, Constants.SuperiorEpigastricArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorEpigastricArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorMesentericArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorMesentericArtery for parent: " + parentID);
			superiorMesentericArtery = new SuperiorMesentericArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorMesentericArteryRef, Constants.SuperiorMesentericArtery, Constants.SuperiorMesentericArteryRef, superiorMesentericArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorMesentericArtery");	
		}
		else
			initProperty(Constants.SuperiorMesentericArteryRef, Constants.SuperiorMesentericArtery, Constants.SuperiorMesentericArteryRef, BioWebUtils.getPropertyID(Constants.SuperiorMesentericArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorPancreaticoDuodenalArteryRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorPancreaticoDuodenalArtery for parent: " + parentID);
			superiorPancreaticoDuodenalArtery = new SuperiorPancreaticoDuodenalArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorPancreaticoDuodenalArteryRef, Constants.SuperiorPancreaticoDuodenalArtery, Constants.SuperiorPancreaticoDuodenalArteryRef, superiorPancreaticoDuodenalArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorPancreaticoDuodenalArtery");	
		}
		else
			initProperty(Constants.SuperiorPancreaticoDuodenalArteryRef, Constants.SuperiorPancreaticoDuodenalArtery, Constants.SuperiorPancreaticoDuodenalArteryRef, BioWebUtils.getPropertyID(Constants.SuperiorPancreaticoDuodenalArteryRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorSupraRenalArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorSupraRenalArteries for parent: " + parentID);
			superiorSupraRenalArteries = new SuperiorSupraRenalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorSupraRenalArteriesRef, Constants.SuperiorSupraRenalArteries, Constants.SuperiorSupraRenalArteriesRef, superiorSupraRenalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorSupraRenalArteries");	
		}
		else
			initProperty(Constants.SuperiorSupraRenalArteriesRef, Constants.SuperiorSupraRenalArteries, Constants.SuperiorSupraRenalArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorSupraRenalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.TrabecularArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the TrabecularArteries for parent: " + parentID);
			trabecularArteries = new TrabecularArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.TrabecularArteriesRef, Constants.TrabecularArteries, Constants.TrabecularArteriesRef, trabecularArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the TrabecularArteries");				
		}
		else
			initProperty(Constants.TrabecularArteriesRef, Constants.TrabecularArteries, Constants.TrabecularArteriesRef, BioWebUtils.getPropertyID(Constants.TrabecularArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		//*****************************************************
		// ARMS
		//*****************************************************
		initProperty("-----"+Constants.ArmsRef+"-------", Constants.Arms, Constants.ArmsRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
		if (BioWebUtils.isViewEnabled(Constants.BrachialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the BrachialArteries for ParentID: " + parentID);
			brachialArteries = new BrachialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.BrachialArteriesRef, Constants.BrachialArteries, Constants.BrachialArteriesRef, brachialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the BrachialArteries");
		}
		else
			initProperty(Constants.BrachialArteriesRef, Constants.BrachialArteries, Constants.BrachialArteriesRef, BioWebUtils.getPropertyID(Constants.BrachialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.DeepBrachialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the DeepBrachialArteries for ParentID: " + parentID);
			deepBrachialArteries = new DeepBrachialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DeepBrachialArteriesRef, Constants.DeepBrachialArteries, Constants.DeepBrachialArteriesRef, deepBrachialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DeepBrachialArteries");
		}
		else
			initProperty(Constants.DeepBrachialArteriesRef, Constants.DeepBrachialArteries, Constants.DeepBrachialArteriesRef, BioWebUtils.getPropertyID(Constants.DeepBrachialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
		if (BioWebUtils.isViewEnabled(Constants.RadialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the RadialArteries for ParentID: " + parentID);
			radialArteries = new RadialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.RadialArteriesRef, Constants.RadialArteries, Constants.RadialArteriesRef, radialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RadialArteriesRef");
		}
		else
			initProperty(Constants.RadialArteriesRef, Constants.RadialArteries, Constants.RadialArteriesRef, BioWebUtils.getPropertyID(Constants.RadialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.UlnarArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the UlnarArteries for ParentID: " + parentID);
			ulnarArteries = new UlnarArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.UlnarArteriesRef, Constants.UlnarArteries, Constants.UlnarArteriesRef, ulnarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the UlnarArteries");
		}
		else
			initProperty(Constants.UlnarArteriesRef, Constants.UlnarArteries, Constants.UlnarArteriesRef, BioWebUtils.getPropertyID(Constants.UlnarArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);


		if (BioWebUtils.isViewEnabled(Constants.SuperiorUlnarCollateralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the SuperiorUlnarCollateralArteries for ParentID: " + parentID);
			superiorUlnarCollateralArteries = new SuperiorUlnarCollateralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperiorUlnarCollateralArteriesRef, Constants.SuperiorUlnarCollateralArteries, Constants.SuperiorUlnarCollateralArteriesRef, superiorUlnarCollateralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperiorUlnarCollateralArteries");
		}
		else
			initProperty(Constants.SuperiorUlnarCollateralArteriesRef, Constants.SuperiorUlnarCollateralArteries, Constants.SuperiorUlnarCollateralArteriesRef, BioWebUtils.getPropertyID(Constants.SuperiorUlnarCollateralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.InferiorUlnarCollateralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InferiorUlnarCollateralArteries for ParentID: " + parentID);
			inferiorUlnarCollateralArteries = new InferiorUlnarCollateralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InferiorUlnarCollateralArteriesRef, Constants.InferiorUlnarCollateralArteries, Constants.InferiorUlnarCollateralArteriesRef, inferiorUlnarCollateralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InferiorUlnarCollateralArteries");
		}
		else
			initProperty(Constants.InferiorUlnarCollateralArteriesRef, Constants.InferiorUlnarCollateralArteries, Constants.InferiorUlnarCollateralArteriesRef, BioWebUtils.getPropertyID(Constants.InferiorUlnarCollateralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.RadialCollateralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the RadialCollateralArteries for ParentID: " + parentID);
			radialCollateralArteries = new RadialCollateralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.RadialCollateralArteriesRef, Constants.RadialCollateralArteries, Constants.RadialCollateralArteriesRef, radialCollateralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RadialCollateralArteries");
		}
		else
			initProperty(Constants.RadialCollateralArteriesRef, Constants.RadialCollateralArteries, Constants.RadialCollateralArteriesRef, BioWebUtils.getPropertyID(Constants.RadialCollateralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.MiddleCollateralArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the MiddleCollateralArteries for ParentID: " + parentID);
			middleCollateralArteries = new MiddleCollateralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MiddleCollateralArteriesRef, Constants.MiddleCollateralArteries, Constants.MiddleCollateralArteriesRef, middleCollateralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the MiddleCollateralArteries");
		}
		else
			initProperty(Constants.MiddleCollateralArteriesRef, Constants.MiddleCollateralArteries, Constants.MiddleCollateralArteriesRef, BioWebUtils.getPropertyID(Constants.MiddleCollateralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.RadialRecurrentArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the RadialRecurrentArteries for ParentID: " + parentID);
			radialRecurrentArteries = new RadialRecurrentArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.RadialRecurrentArteriesRef, Constants.RadialRecurrentArteries, Constants.RadialRecurrentArteriesRef, radialRecurrentArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the RadialRecurrentArteries");
		}
		else
			initProperty(Constants.RadialRecurrentArteriesRef, Constants.RadialRecurrentArteries, Constants.RadialRecurrentArteriesRef, BioWebUtils.getPropertyID(Constants.RadialRecurrentArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorInterosseousArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorInterosseousArteries for ParentID: " + parentID);
			anteriorInterosseousArteries = new AnteriorInterosseousArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorInterosseousArteriesRef, Constants.AnteriorInterosseousArteries, Constants.AnteriorInterosseousArteriesRef, anteriorInterosseousArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorInterosseousArteries");
		}
		else
			initProperty(Constants.AnteriorInterosseousArteriesRef, Constants.AnteriorInterosseousArteries, Constants.AnteriorInterosseousArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorInterosseousArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorInterosseousArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorInterosseousArteries for ParentID: " + parentID);
			posteriorInterosseousArteries = new PosteriorInterosseousArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorInterosseousArteriesRef, Constants.PosteriorInterosseousArteries, Constants.PosteriorInterosseousArteriesRef, posteriorInterosseousArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorInterosseousArteries");
		}
		else
			initProperty(Constants.PosteriorInterosseousArteriesRef, Constants.PosteriorInterosseousArteries, Constants.PosteriorInterosseousArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorInterosseousArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.InterosseousRecurrentArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the InterosseousRecurrentArteries for ParentID: " + parentID);
			interosseousRecurrentArteries = new InterosseousRecurrentArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.InterosseousRecurrentArteriesRef, Constants.InterosseousRecurrentArteries, Constants.InterosseousRecurrentArteriesRef, interosseousRecurrentArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InterosseousRecurrentArteries");
			}
		else
			initProperty(Constants.InterosseousRecurrentArteriesRef, Constants.InterosseousRecurrentArteries, Constants.InterosseousRecurrentArteriesRef, BioWebUtils.getPropertyID(Constants.InterosseousRecurrentArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.AnteriorUlnarRecurrentArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorUlnarRecurrentArteries for ParentID: " + parentID);
			anteriorUlnarRecurrentArteries = new AnteriorUlnarRecurrentArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorUlnarRecurrentArteriesRef, Constants.AnteriorUlnarRecurrentArteries, Constants.AnteriorUlnarRecurrentArteriesRef, anteriorUlnarRecurrentArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorUlnarRecurrentArteries");
		}
		else
			initProperty(Constants.AnteriorUlnarRecurrentArteriesRef, Constants.AnteriorUlnarRecurrentArteries, Constants.AnteriorUlnarRecurrentArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorUlnarRecurrentArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorUlnarRecurrentArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the PosteriorUlnarRecurrentArteries for ParentID: " + parentID);
			posteriorUlnarRecurrentArteries = new PosteriorUlnarRecurrentArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorUlnarRecurrentArteriesRef, Constants.PosteriorUlnarRecurrentArteries, Constants.PosteriorUlnarRecurrentArteriesRef, posteriorUlnarRecurrentArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorUlnarRecurrentArteries");
			}
		else
			initProperty(Constants.PosteriorUlnarRecurrentArteriesRef, Constants.PosteriorUlnarRecurrentArteries, Constants.PosteriorUlnarRecurrentArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorUlnarRecurrentArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		// HAND
		if (BioWebUtils.isViewEnabled(Constants.SuperficialPalmarArchArteriesRef, bioMightProperties)) {	
			System.out.println("Creating SuperficialPalmarArchArteries: " + parentID);					
			superficialPalmarArchArteries = new SuperficialPalmarArchArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperficialPalmarArchArteriesRef, Constants.SuperficialPalmarArchArteries, Constants.SuperficialPalmarArchArteriesRef, superficialPalmarArchArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty(Constants.SuperficialPalmarArchArteriesRef, Constants.SuperficialPalmarArchArteries, Constants.SuperficialPalmarArchArteriesRef, BioWebUtils.getPropertyID(Constants.SuperficialPalmarArchArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.DeepPalmarArchArteriesRef, bioMightProperties)) {	
			System.out.println("Creating DeepPalmarArchArteries: " + parentID);					
			deepPalmarArchArteries = new DeepPalmarArchArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DeepPalmarArchArteriesRef, Constants.DeepPalmarArchArteries, Constants.DeepPalmarArchArteriesRef, deepPalmarArchArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty(Constants.DeepPalmarArchArteriesRef, Constants.DeepPalmarArchArteries, Constants.DeepPalmarArchArteriesRef, BioWebUtils.getPropertyID(Constants.DeepPalmarArchArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PalmarCarpalBranchArteriesRef, bioMightProperties)) {	
			System.out.println("Creating PalmarCarpalBranchArteries: " + parentID);					
			palmarCarpalBranchArteries = new PalmarCarpalBranchArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PalmarCarpalBranchArteries", Constants.PalmarCarpalBranchArteries, Constants.PalmarCarpalBranchArteriesRef, palmarCarpalBranchArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty("PalmarCarpalBranchArteries", Constants.PalmarCarpalBranchArteries, Constants.PalmarCarpalBranchArteriesRef, BioWebUtils.getPropertyID(Constants.PalmarCarpalBranchArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PrincepsPollicisArteriesRef, bioMightProperties)) {	
			System.out.println("Creating PrincepsPollicisArteries: " + parentID);					
			princepsPollicisArteries = new PrincepsPollicisArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PrincepsPollicisArteries", Constants.PrincepsPollicisArteries, Constants.PrincepsPollicisArteriesRef, princepsPollicisArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty("PrincepsPollicisArteries", Constants.PrincepsPollicisArteries, Constants.PrincepsPollicisArteriesRef, BioWebUtils.getPropertyID(Constants.PrincepsPollicisArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.RadialisIndicisArteriesRef, bioMightProperties)) {	
			System.out.println("Creating RadialisIndicisArteries: " + parentID);					
			radialisIndicisArteries = new RadialisIndicisArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("RadialisIndicisArteries", Constants.RadialisIndicisArteries, Constants.RadialisIndicisArteriesRef, radialisIndicisArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty("RadialisIndicisArteries", Constants.RadialisIndicisArteries, Constants.RadialisIndicisArteriesRef, BioWebUtils.getPropertyID(Constants.RadialisIndicisArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PalmarMetacarpalArteriesRef, bioMightProperties)) {	
			System.out.println("Creating PalmarMetacarpalArteries: " + parentID);					
			palmarMetacarpalArteries = new PalmarMetacarpalArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PalmarMetacarpalArteries", Constants.PalmarMetacarpalArteries, Constants.PalmarMetacarpalArteriesRef, palmarMetacarpalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty("PalmarMetacarpalArteries", Constants.PalmarMetacarpalArteries, Constants.PalmarMetacarpalArteriesRef, BioWebUtils.getPropertyID(Constants.PalmarMetacarpalArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		//***********************************************************
		// PELVIS
		//***********************************************************
		initProperty("-----"+Constants.PelvisRef+"-------", Constants.Pelvis, Constants.PelvisRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.CommonIliacArteriesRef, bioMightProperties)) {	
			commonIliacArteries = new CommonIliacArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CommonIliacArteries", Constants.CommonIliacArteries, Constants.CommonIliacArteriesRef, commonIliacArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CommonIliacArteries");
		}
		else
			initProperty("CommonIliacArteries", Constants.CommonIliacArteries, Constants.CommonIliacArteriesRef, BioWebUtils.getPropertyID(Constants.CommonIliacArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.ExternalIliacArteriesRef, bioMightProperties)) {	
			externalIliacArteries = new ExternalIliacArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("ExternalIliacArteries", Constants.ExternalIliacArteries, Constants.ExternalIliacArteriesRef, externalIliacArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ExternalIliacArteries");
		}
		else
			initProperty("ExternalIliacArteries", Constants.ExternalIliacArteries, Constants.ExternalIliacArteriesRef, BioWebUtils.getPropertyID(Constants.ExternalIliacArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.InternalIliacArteriesRef, bioMightProperties)) {	
			internalIliacArteries = new InternalIliacArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("InternalIliacArteries", Constants.InternalIliacArteries, Constants.InternalIliacArteriesRef, internalIliacArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the InternalIliacArteries");
		}
		else
			initProperty("InternalIliacArteries", Constants.InternalIliacArteries, Constants.InternalIliacArteriesRef, BioWebUtils.getPropertyID(Constants.InternalIliacArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		//************************************************************************
		// LEGS
		//************************************************************************
		
		initProperty("-----PevlisAndLeg-------", Constants.Pelvis, Constants.PelvisRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
	
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCircumflexHumeralArteriesRef, bioMightProperties)) {	
			anteriorCircumflexHumeralArteries = new AnteriorCircumflexHumeralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorCircumflexHumeralArteriesRef, Constants.AnteriorCircumflexHumeralArteries, Constants.AnteriorCircumflexHumeralArteriesRef, anteriorCircumflexHumeralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorCircumflexHumeralArteries");
		}
		else
			initProperty(Constants.AnteriorCircumflexHumeralArteriesRef, Constants.AnteriorCircumflexHumeralArteries, Constants.AnteriorCircumflexHumeralArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorCircumflexHumeralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCircumflexHumeralArteriesRef, bioMightProperties)) {	
			posteriorCircumflexHumeralArteries = new PosteriorCircumflexHumeralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PosteriorCircumflexHumeralArteriesRef, Constants.PosteriorCircumflexHumeralArteries, Constants.PosteriorCircumflexHumeralArteriesRef, posteriorCircumflexHumeralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorCircumflexHumeralArteries");
		}
		else
			initProperty(Constants.PosteriorCircumflexHumeralArteriesRef, Constants.PosteriorCircumflexHumeralArteries, Constants.PosteriorCircumflexHumeralArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorCircumflexHumeralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		
		if (BioWebUtils.isViewEnabled(Constants.CommonFemoralArteriesRef, bioMightProperties)) {	
			commonFemoralArteries = new CommonFemoralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.CommonFemoralArteriesRef, Constants.CommonFemoralArteries, Constants.CommonFemoralArteriesRef, commonFemoralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the CommonFemoralArteries");
		}
		else
			initProperty(Constants.CommonFemoralArteriesRef, Constants.CommonFemoralArteries, Constants.CommonFemoralArteriesRef, BioWebUtils.getPropertyID(Constants.CommonFemoralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.DeepFemoralArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the DeepFemoralArteries for ParentID: " + parentID);
			deepFemoralArteries = new DeepFemoralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DeepFemoralArteriesRef, Constants.DeepFemoralArteries, Constants.DeepFemoralArteriesRef, deepFemoralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DeepFemoralArteries");
		}
		else
			initProperty(Constants.DeepFemoralArteriesRef, Constants.DeepFemoralArteries, Constants.DeepFemoralArteriesRef, BioWebUtils.getPropertyID(Constants.DeepFemoralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.SuperficialFemoralArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the SuperficialFemoralArteries for parent: " + parentID);
			superficialFemoralArteries = new SuperficialFemoralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.SuperficialFemoralArteriesRef, Constants.SuperficialFemoralArteries, Constants.SuperficialFemoralArteriesRef, superficialFemoralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the SuperficialFemoralArteries");
		}
		else
			initProperty(Constants.SuperficialFemoralArteriesRef, Constants.SuperficialFemoralArteries, Constants.SuperficialFemoralArteriesRef, BioWebUtils.getPropertyID(Constants.SuperficialFemoralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
		/*
		 // Arteries of the Legs
	
			private ArcuateArtery arcuateArtery;
			private CommonFemoralArtery commonFemoralArtery;
			private DescendingGenicularArtery descendingGenicularArtery;
			private DorsalisPedisArtery dorsalisPedisArtery;
			private InferiorGlutealArtery inferiorGlutealArtery;
			private LateralSuperiorGenicularArtery lateralSuperiorGenicularArtery;
			private ProfundaFemorisArtery profundaFemorisArtery;
		
			
			// Ateries of the foot
			private LateralCalcanealArtery calcaneanArtery;
			private DeepPalmarArterialArch deepPalmarArterialArch;
			private LateralPlantarArtery lateralPlantarArtery;
			private MedialPlantarArtery medialPlantarArtery;
			private PalmarDigitalArtery palmarDigitalArtery;
			private SuperficialPalmerArterialArch superficialPalmerArterialArch;
		
			//private PalatineArteries palatineArteries;
			private AscendingPalatineArteries ascendingPalatineArteries;
			private DescendingPalatineArteries descendingPalatineArteries;
		
			private AccessoryMeningealArteries accessoryMeningealArteries;
			private MiddleMeningealArteries middleMeningealArteries;
			private PosteriorMeningealArteries posteriorMeningealArteries;
			private AscendingPharyngealArteries ascendingPharyngealArteries;
			

		 */
		
		//***********************************************************************
		// THIGHS
		//***********************************************************************
		initProperty("-----" + Constants.ThighRef + "-------", Constants.Thigh, Constants.ThighRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.ObturatorArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the ObturatorArteries for parent: " + parentID);
			obturatorArteries = new ObturatorArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ObturatorArteriesRef, Constants.ObturatorArteries, Constants.ObturatorArteriesRef, obturatorArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the ObturatorArteries");
		}
		else
			initProperty(Constants.ObturatorArteriesRef, Constants.ObturatorArteries, Constants.ObturatorArteriesRef, BioWebUtils.getPropertyID(Constants.ObturatorArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		if (BioWebUtils.isViewEnabled(Constants.LateralCircumflexFemoralArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the LateralCircumflexFemoralArteries for parent: " + parentID);
			lateralCircumflexFemoralArteries = new LateralCircumflexFemoralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.LateralCircumflexFemoralArteriesRef, Constants.LateralCircumflexFemoralArteries, Constants.LateralCircumflexFemoralArteriesRef, lateralCircumflexFemoralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty(Constants.LateralCircumflexFemoralArteriesRef, Constants.LateralCircumflexFemoralArteries, Constants.LateralCircumflexFemoralArteriesRef, BioWebUtils.getPropertyID(Constants.LateralCircumflexFemoralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		if (BioWebUtils.isViewEnabled(Constants.MedialCircumflexFemoralArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the MedialCircumflexFemoralArteries for parent: " + parentID);
			medialCircumflexFemoralArteries = new MedialCircumflexFemoralArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.MedialCircumflexFemoralArteriesRef, Constants.MedialCircumflexFemoralArteries, Constants.MedialCircumflexFemoralArteriesRef, medialCircumflexFemoralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		}
		else
			initProperty(Constants.MedialCircumflexFemoralArteriesRef, Constants.MedialCircumflexFemoralArteries, Constants.MedialCircumflexFemoralArteriesRef, BioWebUtils.getPropertyID(Constants.MedialCircumflexFemoralArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		
		if (BioWebUtils.isViewEnabled(Constants.PeronealArteriesRef, bioMightProperties)) {	
			peronealArteries = new PeronealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PeronealArteriesRef,  Constants.PeronealArteries, Constants.PeronealArteriesRef, peronealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PeronealArteries");
		}
		else
			initProperty(Constants.PeronealArteriesRef,  Constants.PeronealArteries, Constants.PeronealArteriesRef, BioWebUtils.getPropertyID(Constants.PeronealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);


		if (BioWebUtils.isViewEnabled(Constants.AnteriorTibialArteriesRef, bioMightProperties)) {	
			//System.out.println("Creating the AnteriorTibialArteries for ParentID: " + parentID);
			anteriorTibialArteries = new AnteriorTibialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorTibialArteriesRef,  Constants.AnteriorTibialArteries, Constants.AnteriorTibialArteriesRef, anteriorTibialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorTibialArteries");
		}
		else
			initProperty(Constants.AnteriorTibialArteriesRef,  Constants.AnteriorTibialArteries, Constants.AnteriorTibialArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorTibialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		//**********************************************************************
		// KNEES
		//***********************************************************************
		
		initProperty("-----" + Constants.KneeRef + "-------", Constants.Knee, Constants.KneeRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.PoplitealArteriesRef, bioMightProperties)) {				System.out.println("Creating the PoplitealArteries for parent: " + parentID);
			poplitealArteries = new PoplitealArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.PoplitealArteriesRef, Constants.PoplitealArteries, Constants.PoplitealArteriesRef, poplitealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PoplitealAtery");
		}
		else
			initProperty(Constants.PoplitealArteriesRef, Constants.PoplitealArteries, Constants.PoplitealArteriesRef, BioWebUtils.getPropertyID(Constants.PoplitealArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularArteriesRef, bioMightProperties)) {	
			descendingGenicularArteries = new DescendingGenicularArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DescendingGenicularArteriesRef, Constants.DescendingGenicularArteries, Constants.DescendingGenicularArteriesRef, descendingGenicularArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingGenicularArteries");
		}
		else
			initProperty(Constants.DescendingGenicularArteriesRef, Constants.DescendingGenicularArteries, Constants.DescendingGenicularArteriesRef, BioWebUtils.getPropertyID(Constants.DescendingGenicularArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularArticularArteriesRef, bioMightProperties)) {	
			descendingGenicularArticularArteries = new DescendingGenicularArticularArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DescendingGenicularArticularArteriesRef, Constants.DescendingGenicularArticularArteries, Constants.DescendingGenicularArticularArteriesRef, descendingGenicularArticularArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingGenicularArticularArteries");
		}
		else
			initProperty(Constants.DescendingGenicularArticularArteriesRef, Constants.DescendingGenicularArticularArteries, Constants.DescendingGenicularArticularArteriesRef, BioWebUtils.getPropertyID(Constants.DescendingGenicularArticularArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularSaphenousArteriesRef, bioMightProperties)) {	
			descendingGenicularSaphenousArteries = new DescendingGenicularSaphenousArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.DescendingGenicularSaphenousArteriesRef, Constants.DescendingGenicularSaphenousArteries, Constants.DescendingGenicularSaphenousArteriesRef, descendingGenicularSaphenousArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the DescendingGenicularSaphenousArteries");
			}
		else
			initProperty(Constants.DescendingGenicularSaphenousArteriesRef, Constants.DescendingGenicularSaphenousArteries, Constants.DescendingGenicularSaphenousArteriesRef, BioWebUtils.getPropertyID(Constants.DescendingGenicularSaphenousArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		//*****************************************************
		// CNEMIS
		//*****************************************************

		initProperty("-----" + Constants.CnemisRef + "-------", Constants.Cnemis, Constants.CnemisRef, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.AnteriorTibialArteriesRef, bioMightProperties)) {	
			anteriorTibialArteries = new AnteriorTibialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.AnteriorTibialArteriesRef, Constants.AnteriorTibialArteries, Constants.AnteriorTibialArteriesRef, anteriorTibialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the AnteriorTibialArteries");
		}
		else
			initProperty(Constants.AnteriorTibialArteriesRef, Constants.AnteriorTibialArteries, Constants.AnteriorTibialArteriesRef, BioWebUtils.getPropertyID(Constants.AnteriorTibialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		if (BioWebUtils.isViewEnabled(Constants.PosteriorTibialArteriesRef, bioMightProperties)) {	
			System.out.println("Creating the PosteriorTibialArteries for parent: " + parentID);
			posteriorTibialArteries = new PosteriorTibialArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PosteriorTibialArteries", Constants.PosteriorTibialArteries, Constants.PosteriorTibialArteriesRef, posteriorTibialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			System.out.println("Created the PosteriorTibialArteries");
		}
		else
			initProperty(Constants.PosteriorTibialArteriesRef, Constants.PosteriorTibialArteries, Constants.PosteriorTibialArteriesRef, BioWebUtils.getPropertyID(Constants.PosteriorTibialArteriesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);


		// FEET
			
		
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
		
	public void initProperties() {
		
		BioMightPropertyView property;
		
		String bodyPart = "";
		
		if (bodyPart.equals(Constants.Leg))
		{
			property = new BioMightPropertyView();
			property.setPropertyName("AnteriorTibialArtery");
			property.setCanonicalName(Constants.AnteriorTibialArtery);
			properties.add(property);	
			
			property = new BioMightPropertyView();
			property.setPropertyName("ArcuateArtery");
			property.setCanonicalName(Constants.ArcuateArtery);
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
			property.setPropertyName("DescendingGenicularArtery");
			property.setCanonicalName(Constants.DescendingGenicularArtery);
			properties.add(property);	
			
			property = new BioMightPropertyView();
			property.setPropertyName("DorsalisPedisArtery");
			property.setCanonicalName(Constants.DorsalisPedisArtery);
			properties.add(property);	

			property = new BioMightPropertyView();
			property.setPropertyName("InferiorGlutealArtery");
			property.setCanonicalName(Constants.InferiorGlutealArtery);
			properties.add(property);

			property = new BioMightPropertyView();
			property.setPropertyName("LateralCircumflexFemoralArtery");
			property.setCanonicalName(Constants.LateralCircumflexFemoralArtery);
			properties.add(property);	

			property = new BioMightPropertyView();
			property.setPropertyName("LateralSuperiorGenicularArtery");
			property.setCanonicalName(Constants.LateralSuperiorGenicularArtery);
			properties.add(property);	
			
			property = new BioMightPropertyView();
			property.setPropertyName("MedialCircumflexFemoralArtery");
			property.setCanonicalName(Constants.MedialCircumflexFemoralArtery);
			properties.add(property);	

			property = new BioMightPropertyView();
			property.setPropertyName("ObturatorArtery");
			property.setCanonicalName(Constants.ObturatorArtery);
			properties.add(property);

			property = new BioMightPropertyView();
			property.setPropertyName("PeronealArtery");
			property.setCanonicalName(Constants.PeronealArtery);
			properties.add(property);	
			
			property = new BioMightPropertyView();
			property.setPropertyName("PoplitealArtery");
			property.setCanonicalName(Constants.PoplitealArtery);
			properties.add(property);

			property = new BioMightPropertyView();
			property.setPropertyName("PosteriorTibialArtery");
			property.setCanonicalName(Constants.PosteriorTibialArtery);
			properties.add(property);

			property = new BioMightPropertyView();
			property.setPropertyName("ProfundaFemorisArtery");
			property.setCanonicalName(Constants.ProfundaFemorisArtery);
			properties.add(property);	

			property = new BioMightPropertyView();
			property.setPropertyName("SuperficialFemoralArtery");
			property.setCanonicalName(Constants.SuperficialFemoralArtery);
			properties.add(property);		
		}

		
		
	
		// This is the list that comes from the Circulatory System,
		property = new BioMightPropertyView();
		property.setPropertyName("AcuteMarginalArtery");
		property.setCanonicalName(Constants.AcuteMarginalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCecalArtery");
		property.setCanonicalName(Constants.AnteriorCecalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CircumflexArtery");
		property.setCanonicalName(Constants.CircumflexArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CircumflexScapularArtery");
		property.setCanonicalName(Constants.CircumflexScapularArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DiagonalArtery");
		property.setCanonicalName(Constants.DiagonalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DiagonalCoronaryArtery");
		property.setCanonicalName(Constants.DiagonalCoronaryArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalPudendalArtery");
		property.setCanonicalName(Constants.ExternalPudendalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("IleocolicArtery");
		property.setCanonicalName(Constants.IleocolicArtery);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("IliolumbarArtery");
		property.setCanonicalName(Constants.IliolumbarArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorInterosseousArtery");
		property.setCanonicalName(Constants.AnteriorInterosseousArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorInterosseousArtery");
		property.setCanonicalName(Constants.PosteriorInterosseousArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LabyrinthineArtery");
		property.setCanonicalName(Constants.LabyrinthineArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftAnteriorDescendingArtery");
		property.setCanonicalName(Constants.LeftAnteriorDescendingArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PeriCardiaCophrenicArtery");
		property.setCanonicalName(Constants.PeriCardiaCophrenicArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorDescendingArtery");
		property.setCanonicalName(Constants.PosteriorDescendingArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorLateralArtery");
		property.setCanonicalName(Constants.PosteriorLateralArtery);
		properties.add(property);	
	
		// Arteries of Brain
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries of Brain");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AccessoryMeningealArtery");
		property.setCanonicalName(Constants.AccessoryMeningealArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArterialCircleOfWillis");
		property.setCanonicalName(Constants.ArterialCircleOfWillis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CallosoMarginalArtery");
		property.setCanonicalName(Constants.CallosoMarginalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CorticalShortArteries");
		property.setCanonicalName(Constants.CorticalShortArteries);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedullaryArteries");
		property.setCanonicalName(Constants.MedullaryArteries);
		properties.add(property);	
		
		// Arteries of Head
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries of the Head");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AngularArtery");
		property.setCanonicalName(Constants.AngularArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCerebralArtery");
		property.setCanonicalName(Constants.AnteriorCerebralArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorChoroidalArtery");
		property.setCanonicalName(Constants.AnteriorChoroidalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCommunicatingArtery");
		property.setCanonicalName(Constants.AnteriorCommunicatingArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorDeepTemporalArtery");
		property.setCanonicalName(Constants.AnteriorDeepTemporalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorEthmoidalArtery");
		property.setCanonicalName(Constants.AnteriorEthmoidalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorInferiorCerebellarArtery");
		property.setCanonicalName(Constants.AnteriorInferiorCerebellarArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorMeningealBranch");
		property.setCanonicalName(Constants.AnteriorMeningealArterialBranch);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AscendingPalatineArtery");
		property.setCanonicalName(Constants.AscendingPalatineArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("BuccalArtery");
		property.setCanonicalName(Constants.BuccalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CaroticoTympanicBranch");
		property.setCanonicalName(Constants.CaroticoTympanicArterialBranch);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarotidArteries");
		property.setCanonicalName(Constants.CarotidArteries);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CerebellarArtery");
		property.setCanonicalName(Constants.CerebellarArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CiliaryArteries");
		property.setCanonicalName(Constants.CiliaryArteries);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CirculusArteriosusMajor");
		property.setCanonicalName(Constants.CirculusArteriosusMajor);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CirculusArteriosusMinor");
		property.setCanonicalName(Constants.CirculusArteriosusMinor);
		properties.add(property);	
			
		property = new BioMightPropertyView();
		property.setPropertyName("CommonCarotidArtery");
		property.setCanonicalName(Constants.CommonCarotidArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ConjunctivalArtery");
		property.setCanonicalName(Constants.ConjunctivalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("DeepLingualArtery");
		property.setCanonicalName(Constants.DeepLingualArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DorsalLingualArtery");
		property.setCanonicalName(Constants.DorsalLingualArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DorsalNasalArtery");
		property.setCanonicalName(Constants.DorsalNasalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("FacialArtery");
		property.setCanonicalName(Constants.FacialArtery);
		properties.add(property);	
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("FirstSeptalArtery");
		property.setCanonicalName(Constants.FirstSeptalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("FrontalArtery");
		property.setCanonicalName(Constants.FrontalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("GlomusCaroticum");
		property.setCanonicalName(Constants.GlomusCaroticum);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GlomusCoccygeum");
		property.setCanonicalName(Constants.GlomusCoccygeum);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorLabialArtery");
		property.setCanonicalName(Constants.InferiorLabialArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorLateralPalpebralArteries");
		property.setCanonicalName(Constants.InferiorLateralPalpebralArteries);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorMedialPalpebralArtery");
		property.setCanonicalName(Constants.InferiorMedialPalpebralArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorTympanicArtery");
		property.setCanonicalName(Constants.InferiorTympanicArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InternalCarotidArtery");
		property.setCanonicalName(Constants.InternalCarotidArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("LacrimalArtery");
		property.setCanonicalName(Constants.LacrimalArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralPalpebralArteries");
		property.setCanonicalName(Constants.LateralPalpebralArteries);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LongPosteriorCiliaryArteries");
		property.setCanonicalName(Constants.LongPosteriorCiliaryArteries);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedialPalpebralArteries");
		property.setCanonicalName(Constants.MedialPalpebralArteries);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("MentalArtery");
		property.setCanonicalName(Constants.MentalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MiddleCerebralArtery");
		property.setCanonicalName(Constants.MiddleCerebralArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("OccipitalArtery");
		property.setCanonicalName(Constants.OccipitalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("OccipitalArteryAuricularBranch");
		property.setCanonicalName(Constants.OccipitalArteryAuricularBranch);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("OccipitalArteryDescendingBranch");
		property.setCanonicalName(Constants.OccipitalArteryDescendingBranch);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OphthalmicArtery");
		property.setCanonicalName(Constants.OphthalmicArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorAuricularArtery");
		property.setCanonicalName(Constants.PosteriorAuricularArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorCommunicatingArtery");
		property.setCanonicalName(Constants.PosteriorCommunicatingArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorDeepTemporalArtery");
		property.setCanonicalName(Constants.PosteriorDeepTemporalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorEthmoidalArtery");
		property.setCanonicalName(Constants.PosteriorEthmoidalArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorInferiorCerebellarArtery");
		property.setCanonicalName(Constants.PosteriorInferiorCerebellarArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RanineArtery");
		property.setCanonicalName(Constants.RanineArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("RetinaCentralArtery");
		property.setCanonicalName(Constants.RetinaCentralArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemilunarBranches");
		property.setCanonicalName(Constants.SemilunarBranches);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ShortPosteriorCiliaryArteries");
		property.setCanonicalName(Constants.ShortPosteriorCiliaryArteries);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SternocleidomastoidArtery");
		property.setCanonicalName(Constants.SternocleidomastoidArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("StylomastoidArtery");
		property.setCanonicalName(Constants.StylomastoidArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SubLingualArtery");
		property.setCanonicalName(Constants.SubLingualArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubmentalArtery");
		property.setCanonicalName(Constants.SubmentalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Superficial Temporal Artery");
		property.setCanonicalName(Constants.SuperficialTemporalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Superior Labial Artery");
		property.setCanonicalName(Constants.SuperiorLabialArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Superior Lateral Palpebral Arteries");
		property.setCanonicalName(Constants.SuperiorLateralPalpebralArteries);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Superior Medial Palpebral Artery");
		property.setCanonicalName(Constants.SuperiorMedialPalpebralArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Thyroid Artery");
		property.setCanonicalName(Constants.ThyroidArtery);
		properties.add(property);	

		// Arteries of the Nexk
		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ascending Pharyngeal Artery");
		property.setCanonicalName(Constants.AscendingPharyngealArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Superior Thyroid Atery");
		property.setCanonicalName(Constants.SuperiorThyroidAtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Chest and Torax");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Aorta");
		property.setCanonicalName(Constants.AortaArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ascending Aorta");
		property.setCanonicalName(Constants.AscendingAortaArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AxillaryArtery");
		property.setCanonicalName(Constants.AxillaryArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BronchialArtery");
		property.setCanonicalName(Constants.BronchialArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CardiacArtery");
		property.setCanonicalName(Constants.GreatCardiacVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ConusArtery");
		property.setCanonicalName(Constants.ConusArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DescendingAorta");
		property.setCanonicalName(Constants.DescendingAortaArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorAlveolarArtery");
		property.setCanonicalName(Constants.InferiorAlveolarArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LeftCoronaryArtery");
		property.setCanonicalName(Constants.LeftCoronaryArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftMainCoronaryArtery");
		property.setCanonicalName(Constants.LeftMainCoronaryArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Obtuse Marginal Artery");
		property.setCanonicalName(Constants.ObtuseMarginalArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pulmonary Artery");
		property.setCanonicalName(Constants.PulmonaryArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Right Coronary Artery");
		property.setCanonicalName(Constants.RightCoronaryArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Subclavian Artery");
		property.setCanonicalName(Constants.SubclavianArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Thoracic Artery");
		property.setCanonicalName(Constants.ThoracicArtery);
		properties.add(property);

		// BACK
		property = new BioMightPropertyView();
		property.setPropertyName("Back");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("VertebralArtery");
		property.setCanonicalName(Constants.VertebralArtery);
		properties.add(property);	

		// ARMS
		property = new BioMightPropertyView();
		property.setPropertyName("Arms");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCircumflexHumeralArtery");
		property.setCanonicalName(Constants.AnteriorCircumflexHumeralArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BrachialArtery");
		property.setCanonicalName(Constants.BrachialArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeepBrachialArtery");
		property.setCanonicalName(Constants.DeepBrachialArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Dorsal Metacarpal Artery");
		property.setCanonicalName(Constants.DorsalMetacarpalArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Radial Artery");
		property.setCanonicalName(Constants.RadialArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ulnar Artery");
		property.setCanonicalName(Constants.UlnarArtery);
		properties.add(property);	
		
		// HANDS
		property = new BioMightPropertyView();
		property.setPropertyName("Hands");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("DigitalArtery");
		property.setCanonicalName(Constants.DigitalArtery);
		properties.add(property);

		// ABDOMINAL
		property = new BioMightPropertyView();
		property.setPropertyName("Abdominal");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdrenalArteries");
		property.setCanonicalName(Constants.AdrenalArteries);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("AppendicularArtery");
		property.setCanonicalName(Constants.AppendicularArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CysticArtery");
		property.setCanonicalName(Constants.CysticArtery);
		properties.add(property);
			
		property = new BioMightPropertyView();
		property.setPropertyName("CommonHepaticArtery");
		property.setCanonicalName(Constants.CommonHepaticArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorEpigastricArtery");
		property.setCanonicalName(Constants.InferiorEpigastricArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorMesentericArtery");
		property.setCanonicalName(Constants.InferiorMesentericArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("LeftColicArtery");
		property.setCanonicalName(Constants.LeftColicArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LienalArtery");
		property.setCanonicalName(Constants.LienalArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PancreaticoDuodenalArteries");
		property.setCanonicalName(Constants.PancreaticoDuodenalArteries);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ProperHepaticArtery");
		property.setCanonicalName(Constants.ProperHepaticArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GastroEpiploicArteries");
		property.setCanonicalName(Constants.GastroEpiploicArteries);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorMesentericArtery");
		property.setCanonicalName(Constants.SuperiorMesentericArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Hip and Plevis");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("CommonIliacArtery");
		property.setCanonicalName(Constants.CommonIliacArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ExternalIliacArtery");
		property.setCanonicalName(Constants.ExternalIliacArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("GonadalArtery");
		property.setCanonicalName(Constants.GonadalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LateralEpiphysealArtery");
		property.setCanonicalName(Constants.LateralEpiphysealArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("OvarianArtery");
		property.setCanonicalName(Constants.OvarianArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("RectalArtery");
		property.setCanonicalName(Constants.RectalArtery);
		properties.add(property);

			
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries of the Foot");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CalcaneanArtery");
		property.setCanonicalName(Constants.MedialCalcanealArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeepPalmarArterialArch");
		property.setCanonicalName(Constants.DeepPalmarArterialArch);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("LateralPlantarArtery");
		property.setCanonicalName(Constants.LateralPlantarArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedialPlantarArtery");
		property.setCanonicalName(Constants.MedialPlantarArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("PalmarDigitalArtery");
		property.setCanonicalName(Constants.PalmarDigitalArtery);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorTibialArtery");
		property.setCanonicalName(Constants.PosteriorTibialArtery);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialPalmerArterialArch");
		property.setCanonicalName(Constants.SuperficialPalmerArterialArch);
		properties.add(property);	
	}
	
	
	public void initMethods(String bodyPart) {

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
	
	

	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SupraTrochlearArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Arteries: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.0125;

			double[] startPos = {-2.50, 0.750, 0.46};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
	
			System.out.println("Calling Generate Arteries: " + componentID + "    " + parentID);
				
			int success = bioMightBean.generateArteries("Arteries:0", "Arteries", 
				"Arteries", componentID, parentID, currentPoints);			
			
			System.out.println("Created Arteries Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Arteries");
			throw new ServerException("Remote Exception getComponents():", e); 	
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
		
		if (BioWebUtils.isViewEnabled(Constants.AngularArteriesRef, properties)) {
			body += angularArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FacialArteriesRef, properties)) {
			body += facialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.BasilarArteryRef, properties)) {
			//body += basilarArtery.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.BuccalArteriesRef, properties)) {
			body += buccalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.DorsalNasalArteriesRef, properties)) {
			body += dorsalNasalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.OphthalmicArteriesRef, properties)) {
			body += ophthalmicArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.OccipitalArteriesRef, properties)) {
			body += occipitalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MentalArteriesRef, properties)) {
			body += mentalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FrontalArteriesRef, properties)) {
			body += frontalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.RanineArteriesRef, properties)) {
			body += ranineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalCarotidArteriesRef, properties)) {
			body += internalCarotidArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.ExternalCarotidArteriesRef, properties)) {
			body += externalCarotidArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.StylomastoidArteriesRef, properties)) {
			body += stylomastoidArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.MedialPalpebralArteriesRef, properties)) {
			body += medialPalpebralArteries.getX3D(true); 
		}	
		if (BioWebUtils.isViewEnabled(Constants.SuperiorHypophysealArteriesRef, properties)) {
			body += superiorHypophysealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.InferiorHypophysealArteriesRef, properties)) {
			body += inferiorHypophysealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorCerebellarArteriesRef, properties)) {
			body += superiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorInferiorCerebellarArteriesRef, properties)) {
			body += anteriorInferiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorInferiorCerebellarArteriesRef, properties)) {
			body += posteriorInferiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCerebralArteriesRef, properties)) {
			body += anteriorCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MiddleCerebralArteriesRef, properties)) {
			body += middleCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCerebralArteriesRef, properties)) {
			body += posteriorCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCommunicatingArteryRef, properties)) {
			body += anteriorCommunicatingArtery.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCommunicatingArteriesRef, properties)) {
			body += posteriorCommunicatingArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.VertebralArteriesRef, properties)) {
			body += vertebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorSpinalArteriesRef, properties)) {
			body += anteriorSpinalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PontineArteriesRef, properties)) {
			body += pontineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalMaxillaryArteriesRef, properties)) {
			body += internalMaxillaryArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperficialTemporalArteriesRef, properties)) {
			body += superficialTemporalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AscendingPalatineArteriesRef, properties)) {
			body += ascendingPalatineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingPalatineArteriesRef, properties)) {
			body += descendingPalatineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AccessoryMeningealArteriesRef, properties)) {
			body += accessoryMeningealArteries.getX3D(true); 
		}
		System.out.println("Getm X3D fur: " + Constants.MiddleMeningealArteriesRef);
		if (BioWebUtils.isViewEnabled(Constants.MiddleMeningealArteriesRef, properties)) {
			body += middleMeningealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.PosteriorMeningealArteriesRef, properties)) {
			//body += posteriorMeningealArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AscendingPharyngealArteriesRef, properties)) {
			body += ascendingPharyngealArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.LingualArteriesRef, properties)) {
			body += lingualArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InfraOrbitalArteriesRef, properties)) {
			body += infraOrbitalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SupraOrbitalArteriesRef, properties)) {
			body += supraOrbitalArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.InferiorLabialArteriesRef, properties)) {
			body += inferiorLabialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperiorLabialArteriesRef, properties)) {
			//body += superiorLabialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SupraTrochlearArteriesRef, properties)) {
			body += supraTrochlearArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.RadialRecurrentArteriesRef, properties)) {
			body += radialRecurrentArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorInterosseousArteriesRef, properties)) {
			//body += anteriorInterosseousArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorInterosseousArteriesRef, properties)) {
			body += posteriorInterosseousArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InterosseousRecurrentArteriesRef, properties)) {
			//body += interosseousRecurrentArteries.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.InferiorUlnarCollateralArteriesRef, properties)) {
			body += inferiorUlnarCollateralArteries.getX3D(true);
		}			
		if (BioWebUtils.isViewEnabled(Constants.AnteriorUlnarRecurrentArteriesRef, properties)) {
			//body += anteriorUlnarRecurrentArteries.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.PosteriorUlnarRecurrentArteriesRef, properties)) {
			body += posteriorUlnarRecurrentArteries.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.ExternalCarotidArteriesRef, properties)) {
			body += externalCarotidArteries.getX3D(true);
		}
		
		// CHEST
		if (BioWebUtils.isViewEnabled(Constants.CoronaryArteriesRef, properties)) {
			body += coronaryArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonCarotidArteriesRef, properties)) {
			body += commonCarotidArteries.getX3D(true);
		}
		System.out.println("Getm X3D fur: " + Constants.AortaArteryRef);
		if (BioWebUtils.isViewEnabled(Constants.AortaArteryRef, properties)) {
			 //body += aortaArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, properties)) {
			body += ascendingAortaArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AorticArchRef, properties)) {
			body += aorticArch.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingAortaArteryRef, properties)) {
			body += descendingAortaArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ConusArteryRef, properties)) {
			//body += conusArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ObtuseMarginalArteryRef, properties)) {
			//body += obtuseMarginalArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PulmonaryArteriesRef, properties)) {
			body += pulmonaryArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BrachioCephalicArteryRef, properties)) {
			body += brachioCephalicArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AxillaryArteriesRef, properties)) {
			body += axillaryArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BronchialArteriesRef, properties)) {
			body += bronchialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ThoracicArteriesRef, properties)) {
			body += thoracicArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SubclavianArteriesRef, properties)) {
			body += subclavianArteries.getX3D(true);
		}
		
		//************************************************************
		// ABDOMINAL
		//************************************************************
		if (BioWebUtils.isViewEnabled(Constants.AbdominalAortaArteryRef, properties)) {
			body += abdominalAortaArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AdrenalArteriesRef, properties)) {
			//body += adrenalArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AppendicularArteryRef, properties)) {
			body += appendicularArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonHepaticArteryRef, properties)) {
			body += commonHepaticArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.HepaticArteriesRef, properties)) {
			body += hepaticArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CeliacArteryRef, properties)) {
			body += celiacArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CysticArteryRef, properties)) {
			body += cysticArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.GastroEpiploicArteriesRef, properties)) {
			body += gastroEpiploicArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.GastroDuodenalArteryRef, properties)) {
			body += gastroDuodenalArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorEpigastricArteriesRef, properties)) {
			body += inferiorEpigastricArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorMesentericArteryRef, properties)) {
			body += inferiorMesentericArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.RenalArteriesRef, properties)) {
			body += renalArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorSupraRenalArteriesRef, properties)) {
			body += inferiorSupraRenalArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.MiddleSupraRenalArteriesRef, properties)) {
			body += middleSupraRenalArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorPhrenicArteriesRef, properties)) {
			body += inferiorPhrenicArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorPancreaticoDuodenalArteryRef, properties)) {
			body += inferiorPancreaticoDuodenalArtery.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.ProperHepaticArteryRef, properties)) {
			body += properHepaticArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SplenicArteryRef, properties)) {
			body += splenicArtery.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.GastricArteriesRef, properties)) {
			body += gastricArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SpleenCentralArteriesRef, properties)) {
			body += spleenCentralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperiorEpigastricArteriesRef, properties)) {
			//body += superiorEpigastricArteries.getX3D(true);
		}
		System.out.println("Getm X3D fur: " + Constants.SuperiorMesentericArteryRef);
		if (BioWebUtils.isViewEnabled(Constants.SuperiorMesentericArteryRef, properties)) {
			body += superiorMesentericArtery.getX3D(true);
		}
		System.out.println("Getm X3D fur: " + Constants.SuperiorPancreaticoDuodenalArteryRef);
		if (BioWebUtils.isViewEnabled(Constants.SuperiorPancreaticoDuodenalArteryRef, properties)) {
			body += superiorPancreaticoDuodenalArtery.getX3D(true);
		}
		System.out.println("Getm X3D fur: " + Constants.SuperiorSupraRenalArteriesRef);
		if (BioWebUtils.isViewEnabled(Constants.SuperiorSupraRenalArteriesRef, properties)) {
			body += superiorSupraRenalArteries.getX3D(true) ;
		}

		//*****************************************************
		// ARMS
		//****************************************************
		if (BioWebUtils.isViewEnabled(Constants.BrachialArteriesRef, properties)) {
			body += brachialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DeepBrachialArteriesRef, properties)) {
			body += deepBrachialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCircumflexHumeralArteriesRef, properties)) {
			body += anteriorCircumflexHumeralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCircumflexHumeralArteriesRef, properties)) {
			body += posteriorCircumflexHumeralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperiorUlnarCollateralArteriesRef, properties)) {
			body += superiorUlnarCollateralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InferiorUlnarCollateralArteriesRef, properties)) {
			body += inferiorUlnarCollateralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.MiddleCollateralArteriesRef, properties)) {
			body += middleCollateralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.RadialCollateralArteriesRef, properties)) {
			body += radialCollateralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.RadialArteriesRef, properties)) {
			body += radialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.UlnarArteriesRef, properties)) {
			body += ulnarArteries.getX3D(true);
		}

		//**************************************************************
		// HANDS
		//*************************************************************
		
		if (BioWebUtils.isViewEnabled(Constants.SuperficialPalmarArchArteriesRef, properties)) {
			body += superficialPalmarArchArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DeepPalmarArchArteriesRef, properties)) {
			body += deepPalmarArchArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PalmarCarpalBranchArteriesRef, properties)) {
			body += palmarCarpalBranchArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PrincepsPollicisArteriesRef, properties)) {
			body += princepsPollicisArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.RadialisIndicisArteriesRef, properties)) {
			body += radialisIndicisArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PalmarMetacarpalArteriesRef, properties)) {
			//body += palmarMetacarpalArteries.getX3D(true);
		}
		
		
		// THIGHS
		if (BioWebUtils.isViewEnabled(Constants.ObturatorArteriesRef, properties)) {
			body += obturatorArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonFemoralArteriesRef, properties)) {
			body += commonFemoralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DeepFemoralArteriesRef, properties)) {
			body += deepFemoralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonIliacArteriesRef, properties)) {
			body += commonIliacArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ExternalIliacArteriesRef, properties)) {
			body += externalIliacArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalIliacArteriesRef, properties)) {
			body += internalIliacArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LateralCircumflexFemoralArteriesRef, properties)) {
			body += lateralCircumflexFemoralArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.MedialCircumflexFemoralArteriesRef, properties)) {
			body += medialCircumflexFemoralArteries.getX3D(true);
		}
		
		// KNEES
		if (BioWebUtils.isViewEnabled(Constants.PoplitealArteriesRef, properties)) {
			body += poplitealArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularArteriesRef, properties)) {
			body += descendingGenicularArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularArticularArteriesRef, properties)) {	
			body +=descendingGenicularArticularArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingGenicularSaphenousArteriesRef, properties)) {
			body += descendingGenicularSaphenousArteries.getX3D(true);	
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperficialFemoralArteriesRef, properties)) {
			body += superficialFemoralArteries.getX3D(true);
		}
	 
		// CNEMIS
		if (BioWebUtils.isViewEnabled(Constants.PosteriorTibialArteriesRef, properties)) {
			body += posteriorTibialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorTibialArteriesRef, properties)) {
			body += anteriorTibialArteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.PeronealArteriesRef, properties)) {
			body += peronealArteries.getX3D(true);
		}
	

/*
		if (BioWebUtils.isViewEnabled(Constants.ConjunctivalArteriesRef, properties)) {
			body += conjunctivalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.CiliaryArteriesRef, properties)) {
			body += ciliaryArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.TransverseFacialArteriesRef, properties)) {
			body += transverseFacialArteries.getX3D(true); 
		}
	*/	
		
		System.out.println("Arteries X3D is done!");		
		
		String footer = "</Scene>" + "</X3D>\n";
			
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
}
