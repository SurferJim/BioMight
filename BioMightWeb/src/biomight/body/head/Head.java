/*
 * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.brain.Brain;
import biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Cerebellum;
import biomight.body.brain.rhombencephalon.metencephalon.pons.Pons;
import biomight.body.brain.rhombencephalon.myelencephalon.MedullaOblongata;
import biomight.body.gland.pineal.PinealGland;
import biomight.body.gland.pituitary.PituitaryGland;
import biomight.body.hair.Hair;
import biomight.body.head.ear.Ears;
import biomight.body.head.eye.EyeLids;
import biomight.body.head.eye.Eyes;
import biomight.body.head.face.Cheeks;
import biomight.body.head.face.Chin;
import biomight.body.head.mouth.Mouth;
import biomight.body.head.nose.Nose;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.muscular.chest.DiaphragmMuscle;
import biomight.system.muscular.head.AuricularisAnteriorMuscle;
import biomight.system.muscular.head.EpicraniusMuscle;
import biomight.system.muscular.head.FrontalisMuscle;
import biomight.system.muscular.head.eye.InferiorObliqueMuscle;
import biomight.system.muscular.head.eye.InferiorRectusMuscle;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.muscular.head.eye.MediallRectusMuscle;
import biomight.system.muscular.head.eye.SuperiorObliqueMuscle;
import biomight.system.muscular.head.eye.SuperiorRectusMuscle;
import biomight.system.muscular.head.eyelid.CorrugatorMuscle;
import biomight.system.muscular.head.eyelid.LevatorPalpebraeSuperiorisMuscle;
import biomight.system.muscular.head.eyelid.SuperiorisMuscle;
import biomight.system.muscular.head.facial.CorrugatorSuperciliiMuscle;
import biomight.system.muscular.head.facial.LevatorLabiiSuperiorisAlaequeNasiMuscle;
import biomight.system.muscular.head.facial.LevatorLabiiSuperiorisMuscle;
import biomight.system.muscular.head.facial.OrbicularisOrisMuscle;
import biomight.system.muscular.head.mastication.MasseterMuscle;
import biomight.system.muscular.head.mastication.PterygoideusExternusMuscle;
import biomight.system.muscular.head.mastication.PterygoideusInternusMuscle;
import biomight.system.muscular.head.mastication.TemporalisMuscle;
import biomight.system.muscular.head.mouth.BuccinatorMuscle;
import biomight.system.muscular.head.mouth.CaninusMuscle;
import biomight.system.muscular.head.mouth.DepressorAnguliOrisMuscle;
import biomight.system.muscular.head.mouth.DepressorLabiiInferiorisMuscle;
import biomight.system.muscular.head.mouth.LevatorAnguliOrisMuscle;
import biomight.system.muscular.head.mouth.MentalisMuscle;
import biomight.system.muscular.head.mouth.QuadratusLabiiInferiorisMuscle;
import biomight.system.muscular.head.mouth.QuadratusLabiiSuperiorisMuscle;
import biomight.system.muscular.head.mouth.RisoriusMuscle;
import biomight.system.muscular.head.mouth.TriangularisMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMajorMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMinorMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMuscle;
import biomight.system.muscular.head.mouth.tongue.InferiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.SuperiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.TransversusMuscle;
import biomight.system.muscular.head.mouth.tongue.VerticalisMuscle;
import biomight.system.muscular.head.nose.DepressorSeptiNasiMuscle;
import biomight.system.muscular.head.nose.DilatatorNarisPosterior;
import biomight.system.muscular.head.nose.NasalisMuscle;
import biomight.system.muscular.head.nose.ProcerusMuscle;
import biomight.system.nervous.nerves.cervicalspinal.GreatAuricularNerve;
import biomight.system.nervous.nerves.cervicalspinal.GreatOccipitalNerve;
import biomight.system.nervous.nerves.cervicalspinal.LesserOccipitalNerve;
import biomight.system.nervous.nerves.cervicalspinal.PhrenicNerve;
import biomight.system.nervous.nerves.cervicalspinal.PosteriorAuricularNerve;
import biomight.system.nervous.nerves.cervicalspinal.SubOccipitalNerve;
import biomight.system.nervous.nerves.cranial.AbducentNerve;
import biomight.system.nervous.nerves.cranial.AccessoryNerve;
import biomight.system.nervous.nerves.cranial.AcousticNerve;
import biomight.system.nervous.nerves.cranial.FacialNerve;
import biomight.system.nervous.nerves.cranial.GlossopharyngealNerve;
import biomight.system.nervous.nerves.cranial.HypoglossalNerve;
import biomight.system.nervous.nerves.cranial.OculomotorNerve;
import biomight.system.nervous.nerves.cranial.OlfactoryNerve;
import biomight.system.nervous.nerves.cranial.OpticNerves;
import biomight.system.nervous.nerves.cranial.TrigeminalNerve;
import biomight.system.nervous.nerves.cranial.TrochlearNerve;
import biomight.system.nervous.nerves.cranial.VagusNerve;
import biomight.system.nervous.nerves.head.BuccalNerve;
import biomight.system.nervous.nerves.head.ChordaTympaniNerve;
import biomight.system.nervous.nerves.head.LongCiliaryNerve;
import biomight.system.nervous.nerves.head.ShortCiliaryNerve;
import biomight.system.nervous.nerves.head.ear.AuditoryNerve;
import biomight.system.nervous.nerves.head.ear.CochlearNerve;
import biomight.system.nervous.nerves.head.ear.VestibularNerve;
import biomight.system.skeletal.skull.Skull;
import biomight.system.skeletal.skull.facial.HyoidBone;
import biomight.system.skeletal.skull.facial.InferiorNasalConchaBone;
import biomight.system.skeletal.skull.facial.LacrimalBone;
import biomight.system.skeletal.skull.facial.MandibleBone;
import biomight.system.skeletal.skull.facial.MaxillaeBone;
import biomight.system.skeletal.skull.facial.PalatineBone;
import biomight.system.skeletal.skull.facial.VomerBone;
import biomight.system.skeletal.skull.facial.ZygomaticBone;
import biomight.system.vascular.arteries.head.AccessoryMeningealArteries;
import biomight.system.vascular.arteries.head.AngularArteries;
import biomight.system.vascular.arteries.head.AnteriorCerebralArteries;
import biomight.system.vascular.arteries.head.AnteriorCommunicatingArteries;
import biomight.system.vascular.arteries.head.AnteriorCommunicatingArtery;
import biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArteries;
import biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArtery;
import biomight.system.vascular.arteries.head.AnteriorSpinalArteries;
import biomight.system.vascular.arteries.head.AscendingPalatineArteries;
import biomight.system.vascular.arteries.head.AscendingPharyngealArteries;
import biomight.system.vascular.arteries.head.BasilarArteries;
import biomight.system.vascular.arteries.head.BasilarArtery;
import biomight.system.vascular.arteries.head.BuccalArteries;
import biomight.system.vascular.arteries.head.CerebellarArteries;
import biomight.system.vascular.arteries.head.CerebralArteries;
import biomight.system.vascular.arteries.head.CiliaryArteries;
import biomight.system.vascular.arteries.head.ConjunctivalArteries;
import biomight.system.vascular.arteries.head.DescendingPalatineArteries;
import biomight.system.vascular.arteries.head.DorsalNasalArteries;
import biomight.system.vascular.arteries.head.ExternalCarotidArteries;
import biomight.system.vascular.arteries.head.ExternalMaxillaryArteries;
import biomight.system.vascular.arteries.head.FacialArteries;
import biomight.system.vascular.arteries.head.FrontalArteries;
import biomight.system.vascular.arteries.head.HypophysealArteries;
import biomight.system.vascular.arteries.head.InferiorHypophysealArteries;
import biomight.system.vascular.arteries.head.InferiorLabialArteries;
import biomight.system.vascular.arteries.head.InfraOrbitalArteries;
import biomight.system.vascular.arteries.head.InternalCarotidArteries;
import biomight.system.vascular.arteries.head.InternalMaxillaryArteries;
import biomight.system.vascular.arteries.head.LacrimalArteries;
import biomight.system.vascular.arteries.head.LingualArteries;
import biomight.system.vascular.arteries.head.MedialPalpebralArteries;
import biomight.system.vascular.arteries.head.MentalArteries;
import biomight.system.vascular.arteries.head.MiddleCerebralArteries;
import biomight.system.vascular.arteries.head.MiddleMeningealArteries;
import biomight.system.vascular.arteries.head.OccipitalArteries;
import biomight.system.vascular.arteries.head.OphthalmicArteries;
import biomight.system.vascular.arteries.head.PalatineArteries;
import biomight.system.vascular.arteries.head.PontineArteries;
import biomight.system.vascular.arteries.head.PosteriorCerebralArteries;
import biomight.system.vascular.arteries.head.PosteriorCommunicatingArteries;
import biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArteries;
import biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArtery;
import biomight.system.vascular.arteries.head.PosteriorMeningealArteries;
import biomight.system.vascular.arteries.head.RanineArteries;
import biomight.system.vascular.arteries.head.StylomastoidArteries;
import biomight.system.vascular.arteries.head.SuperficialTemporalArteries;
import biomight.system.vascular.arteries.head.SuperiorCerebellarArteries;
import biomight.system.vascular.arteries.head.SuperiorCerebellarArtery;
import biomight.system.vascular.arteries.head.SuperiorHypophysealArteries;
import biomight.system.vascular.arteries.head.SuperiorLabialArteries;
import biomight.system.vascular.arteries.head.SupraOrbitalArteries;
import biomight.system.vascular.arteries.head.SupraTrochlearArteries;
import biomight.system.vascular.arteries.head.TransverseFacialArteries;
import biomight.system.vascular.arteries.head.VertebralArteries;
import biomight.system.vascular.veins.brain.EmissaryVeins;
import biomight.system.vascular.veins.head.AngularVeins;
import biomight.system.vascular.veins.head.FacialVeins;
import biomight.system.vascular.veins.head.MassetericVeins;
import biomight.system.vascular.veins.head.MentalVeins;
import biomight.system.vascular.veins.head.OphthalmicVeins;
import biomight.system.vascular.veins.neck.ExternalJugularVeins;
import biomight.system.vascular.veins.neck.InternalJugularVeins;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
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
 *  Representation of a human head.  It consists of the 
 *  anatomical components that comprise it
 ******************************************************************************/


public class Head extends BioMightBase{
	ArrayList<BioMightPropertyView> localBioMightProperties;
	private Brain brain;
	private Cerebellum cerebellum;
	private Pons pons;
	private MedullaOblongata medullaOblongata;
	private PituitaryGland pituitaryGland;
	private PinealGland pinealGland;
	private Skull skull;
	private Scalp scalp;
	private Mouth mouth;
	private Ears ears;
	private Eyes eyes;
	private EyeLids eyeLids;
	private Nose nose;
	private Jaw jaw;
	private Chin chin;
	private Hair hair;
	private Forehead forehead;
	private Cheeks cheeks;

	
	/**********************************
	 * MUSCLES of the HEAD
	 *********************************/
	 private EpicraniusMuscle epicraniusMuscle;	
	 private FrontalisMuscle frontalisMuscle;
	 private DiaphragmMuscle diaphragm;

	 // Facial
	 private AuricularisAnteriorMuscle AuricularisAnteriorMuscle;
	 private CorrugatorSuperciliiMuscle corrugatorSuperciliiMuscle;
	 private LevatorLabiiSuperiorisAlaequeNasiMuscle LevatorLabiiSuperiorisAlaequeNasiMusc;
	 private LevatorLabiiSuperiorisMuscle LevatorLabiiSuperiorisMuscle;
	 //private OrbicularisOculiMuscle orbicularisOculiMuscle;
	 private OrbicularisOrisMuscle orbicularisOrisMuscle;

	 // Eyelid
	 private CorrugatorMuscle corrugatorMuscle;
	 private LevatorPalpebraeSuperiorisMuscle levatorPalpebraeSuperiorisMuscle;
	 //private OrbicularisOculiMuscle OrbicularisOculiMuscle;
	 private SuperiorisMuscle superiorisMuscle;
	
	// Fat
	 private MalarFatPad malarFatPad;
	 private SubOrbicularisFatPad SubOrbicularisFatPad;
	
	 // Eye
	 private InferiorObliqueMuscle inferiorObliqueMuscle;
	 private InferiorRectusMuscle inferiorRectusMuscle;
	 private LateralRectusMuscle lateralRectusMuscle;
	 private MediallRectusMuscle mediallRectusMuscle;
	 private SuperiorObliqueMuscle superiorObliqueMuscle;
	 private SuperiorRectusMuscle superiorRectusMuscle;
	
	 // Mouth
	 private BuccinatorMuscle buccinatorMuscle;
	 private CaninusMuscle caninusMuscle;
	 private DepressorAnguliOrisMuscle depressorAnguliOrisMuscle;
	 private DepressorLabiiInferiorisMuscle depressorLabiiInferiorisMuscle;
	 private LevatorAnguliOrisMuscle levatorAnguliOrisMuscle;
	 private MentalisMuscle mentalisMuscle;
	 private QuadratusLabiiInferiorisMuscle quadratusLabiiInferiorisMuscle;
	 private QuadratusLabiiSuperiorisMuscle quadratusLabiiSuperiorisMuscle; 
	 private RisoriusMuscle RisoriusMuscle;
	 private TriangularisMuscle triangularisMuscle; 
	 private ZygomaticusMajorMuscle zygomaticusMajorMuscle;
	 private ZygomaticusMinorMuscle zygomaticusMinorMuscle;
	 private ZygomaticusMuscle zygomaticusMuscle;
	
	 // Masstication
	 private MasseterMuscle masseterMuscle;
	 private PterygoideusExternusMuscle PterygoideusExternusMuscle;
	 private PterygoideusInternusMuscle PterygoideusInternusMuscle; 
	 private TemporalisMuscle temporalisMuscle;
	
	 // Tongue
	 private InferiorLongitudinalMuscle inferiorLongitudinalMuscle;
	 private SuperiorLongitudinalMuscle superiorLongitudinalMuscle;
	 private TransversusMuscle transversusMuscle;
	 private VerticalisMuscle verticalisMuscle;
	
	 // Nose
	 private DepressorSeptiNasiMuscle depressorSepti;
	 private DilatatorNarisPosterior dilatatorNarisPosterior;
	 private NasalisMuscle nasalis;
	 private ProcerusMuscle procerusMuscle;


	/**********************************
	 * NERVES of the HEAD
	 *********************************/
	private BuccalNerve buccalNerve;
	private ChordaTympaniNerve ChordaTympaniNerve;
	private LongCiliaryNerve longCiliaryNerve;
	private ShortCiliaryNerve shortCiliaryNerve;
	
	// Ear
	private AuditoryNerve auditoryNerve;
	private CochlearNerve cochlearNerve;
	private VestibularNerve vestibularNerve;
	
	// Cranial
	private AbducentNerve abducentNerve;
	private AccessoryNerve accessoryNerve;
	private AcousticNerve acousticNerve;
	private FacialNerve facialNerve;
	private GlossopharyngealNerve glossopharyngealNerve;
	private HypoglossalNerve hypoglossalNerve;
	private OculomotorNerve oculomotorNerve;
	private OlfactoryNerve olfactoryNerve;
	private OpticNerves opticNerves;
	private TrigeminalNerve trigeminalNerve;
	private TrochlearNerve trochlearNerve;
	private VagusNerve vagusNerve;
	
	// Cervical Spinal
	private GreatAuricularNerve greatAuricularNerve;
	private GreatOccipitalNerve greatOccipitalNerve;
	private LesserOccipitalNerve lesserOccipitalNerve;
	private PhrenicNerve phrenicNerve;
	private PosteriorAuricularNerve posteriorAuricularNerve;
	private SubOccipitalNerve subOccipitalNerve;

	
	/**********************************
	 * BONES of the FACE
	 *********************************/	
	private HyoidBone hyoidBone;
	private InferiorNasalConchaBone inferiorNasalConchaBone;
	private LacrimalBone LlacrimalBone;
	private MandibleBone mandibleBone;
	private MaxillaeBone maxillaeBone;
	private PalatineBone palatineBone;
	private VomerBone vomerBone;
	private ZygomaticBone zygomaticBone;
	
	
	// Vascular
	private AngularArteries angularArteries;
	private BasilarArtery basilarArtery;
	private BuccalArteries buccalArteries;
	private FacialArteries facialArteries;
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
	private MedialPalpebralArteries medialPalpebralArteries;
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
	
	//private PalatineArteries palatineArteries;
	private AscendingPalatineArteries ascendingPalatineArteries;
	private DescendingPalatineArteries descendingPalatineArteries;

	private AccessoryMeningealArteries accessoryMeningealArteries;
	private MiddleMeningealArteries middleMeningealArteries;
	private PosteriorMeningealArteries posteriorMeningealArteries;
	private AscendingPharyngealArteries ascendingPharyngealArteries;
	
	private LingualArteries lingualArteries;
	private ConjunctivalArteries conjunctivalArteries;
	private CiliaryArteries ciliaryArteries;
	private InfraOrbitalArteries infraOrbitalArteries;
	private SupraOrbitalArteries supraOrbitalArteries;
	private InferiorLabialArteries inferiorLabialArteries;
	private SuperiorLabialArteries superiorLabialArteries;
	private SupraTrochlearArteries supraTrochlearArteries;
	
	
	// Veins
	private AngularVeins angularVeins;
	private FacialVeins facialVeins;
	private MentalVeins mentalVeins;
	private OphthalmicVeins ophthalmicVeins;
	private EmissaryVeins emmissaryVeins;
	private MassetericVeins massetericVeins;
	private InternalJugularVeins internalJugularVeins;
	private ExternalJugularVeins externalJugularVeins;
	private AnteriorCommunicatingArtery anteriorCommunicatingArtery;
	private PosteriorCommunicatingArteries posteriorCommunicatingArteries;
	private VertebralArteries vertebralArteries;	
	private AnteriorSpinalArteries anteriorSpinalArteries;		
	
	public Head()
	{
		// Create the head using the base body references 
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BodyRef, null, null);
	}

	
	public Head (String parentID)
	{
		// Create the base head
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Head(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling BODY with Proprty & Method Params: " + parentID);
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/******************************************************************************
	 * CREATE HEAD
	 *
	 * Creates a representation of the head based on the selected model
	 * @param parentID
	 *****************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Head.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);
		localBioMightProperties	 = bioMightProperties;
			
		// Get the Bounding Box passed in from the Body that defines the basic
		// attributes for the head
		BioMightConstruct bioMightConstruct = null;
		if (bioMightConstruct != null) {
			System.out.println("We are changing size of the head...");
			HashMap boundingBoxes = setupBoundBoxes(bioMightConstruct.getBoundingBox(Constants.HeadRef));
		}
	
		System.out.println("Bounding Boxes for Head Created");
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting HeadInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.HeadRef, parentID);
			System.out.println("Have Head Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Head");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}


		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Head.x3d";
		boolean bStored = false;
		
		// Run through the collection of Heads and build them into the model
		// In the default case, we get one instance of the head
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Creating Head - NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Head: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			ArrayList<BioMightPropertyView> bioMightStoredProperties;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting Property info for Head: " + bioMightTransform.getId());
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightStoredProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
				System.out.println("Have Head Property Info from EJB - NumProps: " + bioMightStoredProperties.size());   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components Properties - Head");
				throw new ServerException("Remote Exception getComponents():", e); 	
			} 
			
			
			// If localProperties are null, meaning we are coming into the screen from somewhere
			// else, then use the storedProperties
			if (localBioMightProperties == null || localBioMightProperties.size() == 0)
			{
				System.out.println("In Head - BioMightLocalProperties are Null");
				localBioMightProperties = bioMightStoredProperties;
				System.out.println("Using Property Data from Database");
				bStored = true;
			}
			else
			{
				System.out.println("In Head - BioMightLocalProperties nonNull Size is: " + localBioMightProperties.size());
			}
			
			
			componentID = bioMightTransform.getId();
			System.out.println("Created Head - Set ComponentID: "  + bioMightTransform.getId());
			int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{
						
				System.out.println("Creating the Brain for ParentID: " + bioMightTransform.getId());
				brain = new Brain(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedBrain = brain.getBioMightGenerate(); 
				initProperty(Constants.BrainRef, Constants.Brain, Constants.BrainRef, brain.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Brain");

				System.out.println("Creating the Cerebellum for ParentID: " + bioMightTransform.getId());
				cerebellum = new Cerebellum(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedCerebellum = cerebellum.getBioMightGenerate(); 
				initProperty(Constants.CerebellumRef, Constants.Cerebellum, Constants.CerebellumRef, cerebellum.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Cerebellum");
			
				System.out.println("Creating the Pons for ParentID: " + bioMightTransform.getId());
				pons = new Pons(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedPons = pons.getBioMightGenerate(); 
				initProperty(Constants.PonsRef, Constants.Pons, Constants.PonsRef, pons.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Pons");
			
				System.out.println("Creating the MedullaOblongata for ParentID: " + bioMightTransform.getId());
				medullaOblongata = new MedullaOblongata(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedMedullaOblongata = medullaOblongata.getBioMightGenerate(); 
				initProperty(Constants.MedullaOblongataRef, Constants.MedullaOblongata, Constants.MedullaOblongataRef, medullaOblongata.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.MedullaOblongataRef, localBioMightProperties));								
				System.out.println("Created the MedullaOblongata");
			
				System.out.println("Creating the PituitaryGland for ParentID: " + bioMightTransform.getId());
				pituitaryGland = new PituitaryGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedPituitaryGland = pituitaryGland.getBioMightGenerate(); 
				initProperty(Constants.PituitaryGlandRef, Constants.PituitaryGland, Constants.PituitaryGlandRef, pituitaryGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.PituitaryGlandRef, localBioMightProperties));								
				System.out.println("Created the PituitaryGland");

				System.out.println("Creating the PinealGland for ParentID: " + bioMightTransform.getId());
				pinealGland = new PinealGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedPinealGland = pinealGland.getBioMightGenerate(); 
				initProperty(Constants.PinealGlandRef, Constants.PinealGland, Constants.PinealGlandRef, pinealGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.PinealGlandRef, localBioMightProperties));								
				System.out.println("Created the PinealGland");
	
				// Store the ID brought Head from the database so we can get to
				// all the child objects below
				System.out.println("Creating Ears using ParentID: " + bioMightTransform.getId());
				ears = new Ears(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Ears", Constants.Ears, Constants.EarsRef, parentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.EarsRef, localBioMightProperties));
				System.out.println("Ears are created");
				
				// Create an instance of the Eye for each tranform specified for the organism
				System.out.println("Creating Eyes using ParentID: " + bioMightTransform.getId());
				eyes = new Eyes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.EyesRef, Constants.Eyes, Constants.EyesRef, eyes.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.EyesRef, localBioMightProperties));
				System.out.println("Eyes are created");
	
				// Create an instance of the Eye for each tranform specified for the organism
				eyeLids  = new EyeLids(parentID, bioMightMethods);
				initProperty(Constants.EyeLidsRef, Constants.EyeLids, Constants.EyeLidsRef, eyeLids.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
				System.out.println("EyeLids - EyeLids are created : " + parentID);
		
				System.out.println("Creating Nose using ParentID: " + bioMightTransform.getId());
				nose = new Nose(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Nose", Constants.Nose, Constants.NoseRef, nose.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.NoseRef, localBioMightProperties));					
				System.out.println("Nose is created");

				System.out.println("Creating Mouth using ParentID: " + bioMightTransform.getId());	
				mouth = new Mouth(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.MouthRef, Constants.Mouth, Constants.MouthRef, mouth.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.MouthRef, localBioMightProperties));					
				System.out.println("Mouth is created");
			
				System.out.println("Creating Chin using ParentID: " + bioMightTransform.getId());
				chin = new Chin(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Chin", Constants.Chin, Constants.ChinRef, chin.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ChinRef, localBioMightProperties));					
				System.out.println("Chin is created");
			
				System.out.println("Creating Hair using ParentID: " + bioMightTransform.getId());
				hair = new Hair(bioMightTransform.getId(), bioMightMethods);
				initProperty("Scalp Hair", Constants.Hair, Constants.HairRef, hair.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.MouthRef, localBioMightProperties));					
				System.out.println("Hair is created");

				System.out.println("Creating Forehead using ParentID: " + bioMightTransform.getId());
				forehead = new Forehead(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Forehead", Constants.Forehead, Constants.ForeheadRef, forehead.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ForeheadRef, localBioMightProperties));
				System.out.println("Forehead is created");

				System.out.println("Creating Jaw using ParentID: " + bioMightTransform.getId());
				jaw = new Jaw(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedjaw = jaw.getBioMightGenerate();
				generatedjaw.setComponentName("JawMan");
				initProperty(Constants.JawRef, Constants.Jaw, Constants.JawRef, jaw.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.JawRef, localBioMightProperties));
				System.out.println("Jaw is created");

				System.out.println("Creating Cheeks using ParentID: " + bioMightTransform.getId());
				cheeks = new Cheeks(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Cheeks", Constants.Cheeks, Constants.CheeksRef, cheeks.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.CheeksRef, localBioMightProperties));
				System.out.println("Cheeks are created");
			
				System.out.println("Creating Skull using ParentID: " + bioMightTransform.getId());
				skull = new Skull(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Skull", Constants.Skull, Constants.Skull, skull.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SkullRef, localBioMightProperties));
				System.out.println("Skull is created");

				System.out.println("Creating Scalp using ParentID: " + bioMightTransform.getId());
				scalp = new Scalp(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Scalp", Constants.Scalp, Constants.Scalp, scalp.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ScalpRef, localBioMightProperties));
				System.out.println("Scalp is created");
				
				System.out.println("Creating the AngularArteries for ParentID: " + bioMightTransform.getId());
				angularArteries = new AngularArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("AngularArteries", Constants.AngularArteries, Constants.AngularArteriesRef, angularArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AngularArteriesRef, localBioMightProperties));
				System.out.println("Created the AngularArteries");

				System.out.println("Creating the BasilarArtery for ParentID: " + bioMightTransform.getId());
				basilarArtery = new BasilarArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilarArteries", Constants.BasilarArteries, Constants.BasilarArteriesRef, basilarArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BasilarArteryRef, localBioMightProperties));
				System.out.println("Created the BasilarArtery");
		
				System.out.println("Creating the BuccalArteries for ParentID: " + bioMightTransform.getId());
				buccalArteries = new BuccalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BuccalArtery", Constants.BuccalArteries, Constants.BuccalArteriesRef, buccalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BuccalArteriesRef, localBioMightProperties));
				System.out.println("Created the BuccalArteries");

				System.out.println("Creating the FacialArteries for ParentID: " + bioMightTransform.getId());
				facialArteries = new FacialArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.FacialArteriesRef, Constants.FacialArteries, Constants.FacialArteriesRef, facialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.FacialArteriesRef, localBioMightProperties));
				System.out.println("Created the FacialArteries");
		
				System.out.println("Creating the TransverseFacialArteries for ParentID: " + bioMightTransform.getId());
				transverseFacialArteries = new TransverseFacialArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.TransverseFacialArteriesRef, Constants.TransverseFacialArteries, Constants.TransverseFacialArteriesRef, transverseFacialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.TransverseFacialArteryRef, localBioMightProperties));
				System.out.println("Created the TransverseFacialArteries");
		
				System.out.println("Creating the DorsalNasalArteries for ParentID: " + bioMightTransform.getId());
				dorsalNasalArteries = new DorsalNasalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("DorsalNasalArteries", Constants.DorsalNasalArteries, Constants.DorsalNasalArteriesRef, dorsalNasalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.DorsalNasalArteriesRef, localBioMightProperties));
				System.out.println("Created the DorsalNasalArteries");

				System.out.println("Creating the LacrimalArteries for ParentID: " + bioMightTransform.getId());
				lacrimalArteries = new LacrimalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("LacrimalArteries", Constants.LacrimalArteries, Constants.LacrimalArteriesRef, lacrimalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.LacrimalArteriesRef, localBioMightProperties));
				System.out.println("Created the LacrimalArteries");

				System.out.println("Creating the OccipitalArteries for ParentID: " + bioMightTransform.getId());
				occipitalArteries = new OccipitalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("OccipitalArteries", Constants.OccipitalArteries, Constants.OccipitalArteriesRef, occipitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.OccipitalArteriesRef, localBioMightProperties));
				System.out.println("Created the OccipitalArteries");
	
				System.out.println("Creating the OphthalmicArteries for ParentID: " + bioMightTransform.getId());
				ophthalmicArteries = new OphthalmicArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("OphthalmicArteries", Constants.OphthalmicArteries, Constants.OccipitalArteriesRef, ophthalmicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.OphthalmicArteriesRef, localBioMightProperties));
				System.out.println("Created the OphthalmicArteries");
			
				System.out.println("Creating the MentalArteries for ParentID: " + bioMightTransform.getId());
				mentalArteries = new MentalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("MentalArteries", Constants.MentalArteries, Constants.MentalArteriesRef, mentalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.MentalArteriesRef, localBioMightProperties));
				System.out.println("Created the MentalArteries");
				
				System.out.println("Creating the RanineArteries for ParentID: " + bioMightTransform.getId());
				ranineArteries = new RanineArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("RanineArteries", Constants.RanineArteries, Constants.RanineArteriesRef, ranineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the RanineArteries");
	
				System.out.println("Creating the FrontalArteries for ParentID: " + bioMightTransform.getId());
				frontalArteries = new FrontalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("FrontalArteries", Constants.FrontalArteries, Constants.FrontalArteriesRef, frontalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the FrontalArteries");
	
				System.out.println("Creating the InternalCarotidArteries for ParentID: " + bioMightTransform.getId());
				internalCarotidArteries = new InternalCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("InternalCarotidArteries", Constants.InternalCarotidArteries, Constants.InternalCarotidArteriesRef, internalCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InternalCarotidArteries");
		
				System.out.println("Creating the ExternalCarotidArteries for ParentID: " + bioMightTransform.getId());
				externalCarotidArteries = new ExternalCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("ExternalCarotidArteries", Constants.ExternalCarotidArteries, Constants.ExternalCarotidArteriesRef, externalCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the ExternalCarotidArteries");
				
				System.out.println("Creating the StylomastoidArteries for ParentID: " + bioMightTransform.getId());
				stylomastoidArteries = new StylomastoidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("StylomastoidArteries", Constants.StylomastoidArteries, Constants.StylomastoidArteries, stylomastoidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the StylomastoidArteries");
				
				System.out.println("Creating the MedialPalpebralArteries for ParentID: " + bioMightTransform.getId());
				medialPalpebralArteries = new MedialPalpebralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("StylomastoidArteries", Constants.MedialPalpebralArteries, Constants.MedialPalpebralArteriesRef, medialPalpebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the MedialPalebralArteries");
					
				//System.out.println("Creating the CerebellarArteries for ParentID: " + bioMightTransform.getId());
				//cerebellarArteries = new CerebellarArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("CerebellarArteries", Constants.CerebellarArteries, Constants.CerebellarArteriesRef, anteriorInferiorCerebellarArteries.getComponentID());
				//System.out.println("Created the CerebellarArteries");
	
				System.out.println("Creating the SuperiorCerebellarArteries for ParentID: " + bioMightTransform.getId());
				superiorCerebellarArteries = new SuperiorCerebellarArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("SuperiorCerebellarArteries", Constants.SuperiorCerebellarArteries, Constants.SuperiorCerebellarArteriesRef, superiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SuperiorCerebellarArteries");
	
				System.out.println("Creating the AnteriorInferiorCerebellarArteries for ParentID: " + bioMightTransform.getId());
				anteriorInferiorCerebellarArteries = new AnteriorInferiorCerebellarArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("AnteriorInferiorCerebellarArteries", Constants.AnteriorInferiorCerebellarArteries, Constants.AnteriorInferiorCerebellarArteriesRef, anteriorInferiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AnteriorInferiorCerebellarArteries");
	
				System.out.println("Creating the PosteriorInferiorCerebellarArteries for ParentID: " + bioMightTransform.getId());
				posteriorInferiorCerebellarArteries = new PosteriorInferiorCerebellarArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("PosteriorInferiorCerebellarArteries", Constants.PosteriorInferiorCerebellarArteries, Constants.PosteriorInferiorCerebellarArteriesRef, posteriorInferiorCerebellarArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PosteriorInferiorCerebellarArteries");
				
				System.out.println("Creating the AnteriorCerebralArteries for ParentID: " + bioMightTransform.getId());
				anteriorCerebralArteries = new AnteriorCerebralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AnteriorCerebralArteriesRef, Constants.AnteriorCerebralArteries, Constants.AnteriorCerebralArteriesRef, anteriorCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AnteriorCerebralArteries");
			
				System.out.println("Creating the MiddleCerebralArteries for ParentID: " + bioMightTransform.getId());
				middleCerebralArteries = new MiddleCerebralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.MiddleCerebralArteriesRef, Constants.MiddleCerebralArteries, Constants.MiddleCerebralArteriesRef, middleCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the MiddleCerebralArteries");
			
				System.out.println("Creating the PosteriorCerebralArteries for ParentID: " + bioMightTransform.getId());
				posteriorCerebralArteries = new PosteriorCerebralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.PosteriorCerebralArteriesRef, Constants.PosteriorCerebralArteries, Constants.PosteriorCerebralArteriesRef, posteriorCerebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PosteriorCerebralArteries");
			
				//System.out.println("Creating the HypophysealArteries for ParentID: " + bioMightTransform.getId());
				//hypophysealArteries = new HypophysealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("HypophysealArteries", Constants.HypophysealArteries, Constants.HypophysealArteriesRef, hypophysealArteries.getComponentID());
				//System.out.println("Created the HypophysealArteries");
	
				System.out.println("Creating the SuperiorHypophysealArteries for ParentID: " + bioMightTransform.getId());
				superiorHypophysealArteries = new SuperiorHypophysealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SuperiorHypophysealArteriesRef, Constants.SuperiorHypophysealArteries, Constants.SuperiorHypophysealArteriesRef, superiorHypophysealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SuperiorHypophysealArteries");
	
				System.out.println("Creating the InferiorHypophysealArteries for ParentID: " + bioMightTransform.getId());
				inferiorHypophysealArteries = new InferiorHypophysealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.InferiorHypophysealArteriesRef, Constants.InferiorHypophysealArteries, Constants.InferiorHypophysealArteriesRef, inferiorHypophysealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the HypophysealArteries");
	
				System.out.println("Creating the AnteriorCommunicatingArtery for ParentID: " + bioMightTransform.getId());
				anteriorCommunicatingArtery = new AnteriorCommunicatingArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("CerebralArtery", Constants.AnteriorCommunicatingArtery, Constants.AnteriorCommunicatingArtery, anteriorCommunicatingArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AnteriorCommunicatingArtery");
				
				System.out.println("Creating the PosteriorCommunicatingArteries for ParentID: " + bioMightTransform.getId());
				posteriorCommunicatingArteries = new PosteriorCommunicatingArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("PosteriorCommunicatingArteries", Constants.PosteriorCommunicatingArteries, Constants.PosteriorCommunicatingArteries,posteriorCommunicatingArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PosteriorCommunicatingArteries");
				
				System.out.println("Creating the VertebralArteries for ParentID: " + bioMightTransform.getId());
				vertebralArteries = new VertebralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("VertebralArteries", Constants.VertebralArteries, Constants.VertebralArteries,vertebralArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the VertebralArteries");
	
				System.out.println("Creating the AnteriorSpinalArteries for ParentID: " + bioMightTransform.getId());
				anteriorSpinalArteries = new AnteriorSpinalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("AnteriorSpinalArteries", Constants.AnteriorSpinalArteries, Constants.AnteriorSpinalArteries,anteriorSpinalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AnteriorSpinalArteries");
	
				System.out.println("Creating the PontineArteries for ParentID: " + bioMightTransform.getId());
				pontineArteries = new PontineArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("PontineArteries", Constants.PontineArteries, Constants.PontineArteriesRef, pontineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PontineArteries");
				
				System.out.println("Creating the AscendingPalatineArteries for ParentID: " + bioMightTransform.getId());
				ascendingPalatineArteries = new AscendingPalatineArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AscendingPalatineArteriesRef, Constants.AscendingPalatineArteries, Constants.AscendingPalatineArteriesRef, ascendingPalatineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AscendingPalatineArteries");
	
				System.out.println("Creating the DescendingPalatineArteries for ParentID: " + bioMightTransform.getId());
				descendingPalatineArteries = new DescendingPalatineArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.DescendingPalatineArteriesRef, Constants.DescendingPalatineArteries, Constants.DescendingPalatineArteriesRef, descendingPalatineArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the DescendingPalatineArteries");

				//System.out.println("Creating the ExternalMaxillaryArteries for ParentID: " + bioMightTransform.getId());
				//externalMaxillaryArteries = new ExternalMaxillaryArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("ExternalMaxillaryArteries", Constants.ExternalMaxillaryArteries, Constants.ExternalMaxillaryArteriesRef, externalMaxillaryArteries.getComponentID());
				//System.out.println("Created the ExternalMaxillaryArteries");
		
				System.out.println("Creating the InternalMaxillaryArteries for ParentID: " + bioMightTransform.getId());
				internalMaxillaryArteries = new InternalMaxillaryArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("InternalMaxillaryArteries", Constants.InternalMaxillaryArteries, Constants.InternalMaxillaryArteriesRef, internalMaxillaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InternalMaxillaryArteries");
		
				System.out.println("Creating the SuperficialTemporalArteries for ParentID: " + bioMightTransform.getId());
				superficialTemporalArteries = new SuperficialTemporalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("SuperficialTemporalArteries", Constants.SuperficialTemporalArteries, Constants.SuperficialTemporalArteriesRef, superficialTemporalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SuperficialTemporalArteries");
					
				System.out.println("Creating the LingualArteries for ParentID: " + bioMightTransform.getId());
				lingualArteries = new LingualArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("LingualArteries", Constants.LingualArteries, Constants.LingualArteriesRef, lingualArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the LingualArteries");
		
				System.out.println("Creating the AccessoryMeningealArteries for ParentID: " + bioMightTransform.getId());
				accessoryMeningealArteries = new AccessoryMeningealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("AccessoryMeningealArteries", Constants.AccessoryMeningealArteries, Constants.AccessoryMeningealArteriesRef, accessoryMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AccessoryMeningealArteries");
				
				System.out.println("Creating the MiddleMeningealArteries for ParentID: " + bioMightTransform.getId());
				middleMeningealArteries = new MiddleMeningealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("MiddleMeningealArteries", Constants.MiddleMeningealArteries, Constants.MiddleMeningealArteriesRef, middleMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the MiddleMeningealArteries");

				System.out.println("Creating the PosteriorMeningealArteries for ParentID: " + bioMightTransform.getId());
				posteriorMeningealArteries = new PosteriorMeningealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("PosteriorMeningealArteries", Constants.PosteriorMeningealArteries, Constants.PosteriorMeningealArteriesRef, posteriorMeningealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PosteriorMeningealArteries");
			
				System.out.println("Creating the AscendingPharyngealArteries for ParentID: " + bioMightTransform.getId());
				ascendingPharyngealArteries = new AscendingPharyngealArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AscendingPharyngealArteriesRef, Constants.AscendingPharyngealArteries, Constants.AscendingPharyngealArteriesRef, ascendingPharyngealArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AscendingPharyngealArteries");
			
				System.out.println("Creating the InfraOrbitalArteries for ParentID: " + bioMightTransform.getId());
				infraOrbitalArteries = new InfraOrbitalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.InfraOrbitalArteriesRef, Constants.InfraOrbitalArteries, Constants.InfraOrbitalArteriesRef, infraOrbitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InfraOrbitalArteries");
			
				System.out.println("Creating the SupraOrbitalArteries for ParentID: " + bioMightTransform.getId());
				supraOrbitalArteries = new SupraOrbitalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SupraOrbitalArteriesRef, Constants.SupraOrbitalArteries, Constants.SupraOrbitalArteriesRef, supraOrbitalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SupraOrbitalArteries");
				
				System.out.println("Creating the InferiorLabialArteries for ParentID: " + bioMightTransform.getId());
				inferiorLabialArteries = new InferiorLabialArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.InferiorLabialArteriesRef, Constants.InferiorLabialArteries, Constants.InferiorLabialArteriesRef, inferiorLabialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InferiorLabialArteries");
			
				System.out.println("Creating the SuperiorLabialArteries for ParentID: " + bioMightTransform.getId());
				superiorLabialArteries = new SuperiorLabialArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SuperiorLabialArteriesRef, Constants.SuperiorLabialArteries, Constants.SuperiorLabialArteriesRef, superiorLabialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SuperiorLabialArteries");
			
				System.out.println("Creating the SupraTrochlearArteries for ParentID: " + bioMightTransform.getId());
				supraTrochlearArteries = new SupraTrochlearArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SupraTrochlearArteriesRef, Constants.SupraTrochlearArteries, Constants.SupraTrochlearArteriesRef, supraTrochlearArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the SupraTrochlearArteries");
			
						
				
				// VEINS				
				System.out.println("Creating the AngularVeins for ParentID: " + bioMightTransform.getId());
				angularVeins = new AngularVeins(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("AngularVeins", Constants.AngularVeins, Constants.AngularVeinsRef, angularVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AngularVeins");
	
				System.out.println("Creating the MentalVeins for ParentID: " + bioMightTransform.getId());
				mentalVeins = new MentalVeins(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("FacialVeins", Constants.MentalVeins, Constants.MentalVeinsRef, mentalVeins.getComponentID());
				System.out.println("Created the MentalVeins");

				
				initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
			
				System.out.println("Creating the ConjunctivalArteries for ParentID: " + bioMightTransform.getId());
				conjunctivalArteries = new ConjunctivalArteries(bioMightTransform.getId(), bioMightMethods);
				initProperty("ConjunctivalArteries", Constants.ConjunctivalArteries, Constants.ConjunctivalArteriesRef, conjunctivalArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the ConjunctivalArteries");
	
				System.out.println("Creating the CiliaryArteries for ParentID: " + bioMightTransform.getId());
				ciliaryArteries = new CiliaryArteries(bioMightTransform.getId(), bioMightMethods);
				initProperty("CiliaryArteries", Constants.CiliaryArteries, Constants.CiliaryArteriesRef, ciliaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the ConjunctivalArteries");

				
				// VEINS


				System.out.println("Creating the FacialVeins for ParentID: " + bioMightTransform.getId());
				facialVeins = new FacialVeins(bioMightTransform.getId(), bioMightMethods);
				initProperty("FacialVeins", Constants.FacialVeins, Constants.FacialVeinsRef, facialVeins.getComponentID());
				System.out.println("Created the FacialVeins");
		
	
				System.out.println("Creating the EmissaryVeins for ParentID: " + bioMightTransform.getId());
				emmissaryVeins = new EmissaryVeins(bioMightTransform.getId(), bioMightMethods);
				initProperty("EmissaryVeins", Constants.EmissaryVeins, Constants.EmissaryVeinsRef, emmissaryVeins.getComponentID());
				System.out.println("Created the EmissaryVeins");

				System.out.println("Creating the MassetericVeins for ParentID: " + bioMightTransform.getId());
				massetericVeins = new MassetericVeins(bioMightTransform.getId(), bioMightMethods);
				initProperty("MassetericVeins", Constants.MassetericVeins, Constants.MassetericVeinsRef, massetericVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the MassetericVeins");

				System.out.println("Creating the InternalJugularVeins for ParentID: " + bioMightTransform.getId());
				internalJugularVeins = new InternalJugularVeins(bioMightTransform.getId(), bioMightMethods);
				initProperty("InternalJugularVeins", Constants.InternalJugularVeins, Constants.InternalJugularVeinsRef, internalJugularVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InternalJugularVeins");

				System.out.println("Creating the ExternalJugularVeins for ParentID: " + bioMightTransform.getId());
				externalJugularVeins = new ExternalJugularVeins(bioMightTransform.getId(), bioMightMethods);
				BioMightGenerate generatedExternalJugularVeins = externalJugularVeins.getBioMightGenerate(); 				
				initProperty("ExternalJugularVeins", Constants.ExternalJugularVeins, Constants.ExternalJugularVeinsRef, externalJugularVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the ExternalJugularVeins");
				
				System.out.println("Creating the OpticNerves for ParentID: " + bioMightTransform.getId());
				opticNerves = new OpticNerves(bioMightTransform.getId(), bioMightMethods);
				BioMightGenerate generatedOpticNerves = opticNerves.getBioMightGenerate(); 				
				initProperty("OpticNerves", Constants.OpticNerves, Constants.OpticNervesRef, opticNerves.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the OpticNerves");
				
				// Store all the connection points for the HeadMap.  
				// Then stuff this map into the BioGeneate Object for the Head.  
				// Hard Code ths one right now so we can build trachea and esophagus	
				// Set up default points - TEMP
				double circumference = 0.3;
				double[] startPos = {0.0,-5.0, -1.0};
				double[][] nasalPharnyxPoints = BioGraphics.octogonYPlane(startPos, circumference);
				BioMightGenerate bioMightGenNasalPharnyx = new BioMightGenerate(nasalPharnyxPoints, 0, "");	
				this.bioMightGenerate.setMapComponent("NasalPharnyx:01", bioMightGenNasalPharnyx);
				
				this.bioMightGenerate.setMapComponent("ExternalJugularVeins:0", generatedExternalJugularVeins);
				this.bioMightGenerate.setMapComponent("Jaw:01", generatedjaw);
							
				
				if (localBioMightProperties != null && !bStored) {
					if (localBioMightProperties.size()>0) {
					// Store the Properties that the user set in the page	
					// We will use the enable flag to see what should be turned on/off
						try {
							// Get the information from the database via the Enterprise Bean		
							System.out.println("Setting Property info for Head: " + bioMightTransform.getId());
							InitialContext ctx = new InitialContext();
							BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
							int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
									Constants.HeadRef, bioMightTransform.getComponentName(), bioMightProperties);      
							System.out.println("Stored Head Property Info into EJB: " + propSave);   	
						}catch (Exception e) { 
							System.out.println("Exception Storing Components Properties - Head");
							throw new ServerException("Remote Exception insertComponentProps():", e); 	
						} 
					}
				}
				
				System.out.println("Stored Generated Objects BioMightGenerateHead");
		
				
			}
			
		}
		
	
		//initProperties();
		initMethods();
		System.out.println("Head - Methods and Properties are initialized");
	}

	
	
	public void initProperties() {
		

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Hair");
		property.setCanonicalName(Constants.Hair);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Eyes");
		property.setCanonicalName(Constants.Eyes);
		property.setPropertyRef(Constants.EyesRef);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Nose");
		property.setCanonicalName(Constants.Nose);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Mouth");
		property.setCanonicalName(Constants.Mouth);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Chin");
		property.setCanonicalName(Constants.Chin);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Jaw");
		property.setCanonicalName(Constants.Jaw);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ears");
		property.setCanonicalName(Constants.Ears);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("Brain");
		property.setCanonicalName(Constants.Brain);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Skull");
		property.setCanonicalName(Constants.Skull);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Skull");
		property.setCanonicalName(Constants.Skull);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HyoidBone");
		property.setCanonicalName(Constants.HyoidBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorNasalConchaBone");
		property.setCanonicalName(Constants.InferiorNasalConchaBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LacrimalBone");
		property.setCanonicalName(Constants.LacrimalBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MandibleBone");
		property.setCanonicalName(Constants.MandibleBone);
		properties.add(property);
			
		property = new BioMightPropertyView();
		property.setPropertyName("MaxillaeBone");
		property.setCanonicalName(Constants.MaxillaeBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("EpicraniusMuscle");
		property.setCanonicalName(Constants.EpicraniusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FrontalisMuscle");
		property.setCanonicalName(Constants.FrontalisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DiaphragmMuscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);

		
		property = new BioMightPropertyView();
		property.setPropertyName("DiaphragmMuscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);

		// Facial
		
		property = new BioMightPropertyView();
		property.setPropertyName("AuricularisAnteriorMuscle");
		property.setCanonicalName(Constants.AuricularisAnteriorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CorrugatorSuperciliiMuscle");
		property.setCanonicalName(Constants.CorrugatorSuperciliiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LevatorLabiiSuperiorisAlaequeNasiMuscle");
		property.setCanonicalName(Constants.LevatorLabiiSuperiorisAlaequeNasiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LevatorLabiiSuperiorisMuscle");
		property.setCanonicalName(Constants.LevatorLabiiSuperiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OrbicularisOculiMuscle");
		property.setCanonicalName(Constants.OrbicularisOculiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OrbicularisOrisMuscle");
		property.setCanonicalName(Constants.OrbicularisOrisMuscle);
		properties.add(property);

		// EYELID
		property = new BioMightPropertyView();
		property.setPropertyName("CorrugatorMuscle");
		property.setCanonicalName(Constants.CorrugatorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LevatorPalpebraeSuperiorisMuscle");
		property.setCanonicalName(Constants.LevatorPalpebraeSuperiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OrbicularisOculiMuscle");
		property.setCanonicalName(Constants.OrbicularisOculiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorisMuscle");
		property.setCanonicalName(Constants.SuperiorisMuscle);
		properties.add(property);

		// EYE
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorObliqueMuscle");
		property.setCanonicalName(Constants.InferiorObliqueMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorRectusMuscle");
		property.setCanonicalName(Constants.InferiorRectusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LateralRectusMuscle");
		property.setCanonicalName(Constants.LateralRectusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MediallRectusMuscle");
		property.setCanonicalName(Constants.MediallRectusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorObliqueMuscle");
		property.setCanonicalName(Constants.SuperiorObliqueMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorRectusMuscle");
		property.setCanonicalName(Constants.SuperiorRectusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BuccinatorMuscle");
		property.setCanonicalName(Constants.BuccinatorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CaninusMuscle");
		property.setCanonicalName(Constants.CaninusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DepressorAnguliOrisMuscle");
		property.setCanonicalName(Constants.DepressorAnguliOrisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DepressorLabiiInferioris");
		property.setCanonicalName(Constants.DepressorLabiiInferiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LevatorAnguliOrisMuscle");
		property.setCanonicalName(Constants.LevatorAnguliOrisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MentalisMuscle");
		property.setCanonicalName(Constants.MentalisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("QuadratusLabiiInferioris");
		property.setCanonicalName(Constants.QuadratusLabiiInferiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("QuadratusLabiiSuperioris");
		property.setCanonicalName(Constants.QuadratusLabiiSuperiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("RisoriusMuscle");
		property.setCanonicalName(Constants.RisoriusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TriangularisMuscle");
		property.setCanonicalName(Constants.TriangularisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ZygomaticusMajorMuscle");
		property.setCanonicalName(Constants.ZygomaticusMajorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ZygomaticusMinorMuscle");
		property.setCanonicalName(Constants.ZygomaticusMinorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ZygomaticusMuscle");
		property.setCanonicalName(Constants.ZygomaticusMuscle);
		properties.add(property);

		 // Mouth

		 // Masstication
		property = new BioMightPropertyView();
		property.setPropertyName("MasseterMuscle");
		property.setCanonicalName(Constants.MasseterMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PterygoideusExternusMuscle");
		property.setCanonicalName(Constants.PterygoideusExternusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PterygoideusInternusMuscle");
		property.setCanonicalName(Constants.PterygoideusInternusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TemporalisMuscle");
		property.setCanonicalName(Constants.TemporalisMuscle);
		properties.add(property);

		 // Tongue
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorLongitudinalMuscle");
		property.setCanonicalName(Constants.InferiorLongitudinalMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorLongitudinalMuscle");
		property.setCanonicalName(Constants.SuperiorLongitudinalMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TransversusMuscle");
		property.setCanonicalName(Constants.TransversusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("VerticalisMuscle");
		property.setCanonicalName(Constants.VerticalisMuscle);
		properties.add(property);

		 // Nose
		property = new BioMightPropertyView();
		property.setPropertyName("DepressorSeptiNasiMuscle");
		property.setCanonicalName(Constants.DepressorSeptiNasiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DilatatorNarisPosterior");
		property.setCanonicalName(Constants.DilatatorNarisPosterior);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("NasalisMuscle");
		property.setCanonicalName(Constants.NasalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ProcerusMuscle");
		property.setCanonicalName(Constants.ProcerusMuscle);
		properties.add(property);
		
		// FAT
		/**property = new BioMightPropertyView();
		property.setPropertyName("MalarFatPad");
		property.setCanonicalName(Constants.MalarFatPad);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubOrbicularisFatPad");
		property.setCanonicalName(Constants.SubOrbicularisFatPad);
		properties.add(property);
		**/
		
	}
	
	
	public void initMethods() {

		/*
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Hair);
		method.setMethodName("setHairColor");
		method.setDisplayName("Hair Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> hairColor = new ArrayList<String>();
     	hairColor.add("Blond");
     	hairColor.add("Light Blond");
     	hairColor.add("Strawberry Blonde");
     	hairColor.add("Dirty Blond");
     	hairColor.add("Dark Blond");
     	hairColor.add("Brown");
     	hairColor.add("Light Brown");
     	hairColor.add("Dark Brown");
     	hairColor.add("Brunette");
     	hairColor.add("Fiery Red");
     	hairColor.add("Ruby Red");
     	hairColor.add("Dark Red");
     	hairColor.add("More");
    	method.setValues(hairColor);
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Hair);
		method.setMethodName("setHairTexture");
		method.setDisplayName("Hair Texture:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> hairTexture = new ArrayList<String>(); 
     	hairTexture.add("Curly");     	
     	hairTexture.add("Straight");   
     	hairTexture.add("Wavy"); 
     	hairTexture.add("Coarse");   
     	hairTexture.add("Thin");     	
    	method.setValues(hairTexture);
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setColor");
		method.setDisplayName("Eye Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> eyeColor = new ArrayList<String>();
     	eyeColor.add("Blue");
     	eyeColor.add("Brown");
     	eyeColor.add("Green");
     	eyeColor.add("Hazel");
     	eyeColor.add("Red");
     	eyeColor.add("More");
     	method.setValues(eyeColor);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("setNoseType");
		method.setDisplayName("Nose:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> noseType = new ArrayList<String>();
     	noseType.add("concave");
     	noseType.add("convex");
     	noseType.add("Schnooze");     	
    	method.setValues(noseType);
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("setLipsType");
		method.setDisplayName("Lips:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> lipsType = new ArrayList<String>();
     	lipsType.add("full");
     	lipsType.add("modest");
     	lipsType.add("thin");     	
    	method.setValues(lipsType);
		methods.add(method);
		
		
		method = new BioMightMethodView();
		method.setMethodName("blinkEyes");
		method.setDisplayName("Blink Eyes");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
	
		method = new BioMightMethodView();
		method.setMethodName("wink");
		method.setDisplayName("Winks/min:");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		
		/*
		method = new BioMightMethodView();
		method.setMethodName("Squint:");
		method.setDisplayName("Squint:");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Laugh:");
		method.setDisplayName("Laugh:");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);


		method = new BioMightMethodView();
		method.setMethodName("Sing:");
		method.setDisplayName("Sing:");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
		
				method = new BioMightMethodView();
		method.setMethodName("sneeze");
		method.setDisplayName("Sneeze:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> sneezeType = new ArrayList<String>();
     	sneezeType.add("full");
     	sneezeType.add("modest");
     	sneezeType.add("mild");     	
    	method.setValues(sneezeType);
		methods.add(method);
		*/
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Talk:");
		method.setDisplayName("Talk:");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);
	
	}
	
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("HEAD-Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {

					String methodName = (String) methods.get(j).getMethodName(); 
					String htmlType = (String) methods.get(j).getHtmlType();
					String dataType = (String) methods.get(j).getDataType();
					System.out.println("Execute Method " + methodName + " Arg: "  +  methodParam);
					System.out.println("HtmlType " + htmlType + " with DataType: "  +  dataType);
										
					// Use the DataType parameter to convert the data into its base form
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);
							
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
					
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + method.getName());
							
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(Integer)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred!");						
						}	
						
					}
				
					else if (dataType.equals("double")) {
						
					}
					else if (dataType.equals("")) {
						
					}			
				}
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Head.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Head'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D for head;");
		String body = ""; 
	
		if (BioWebUtils.isViewEnabled(Constants.MouthRef, localBioMightProperties)) {
			body += mouth.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BrainRef, localBioMightProperties)) {
			body += brain.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CerebellumRef, localBioMightProperties)) {
			body += cerebellum.getX3D(true);
		}			
		if (BioWebUtils.isViewEnabled(Constants.PonsRef, localBioMightProperties)) {
			body += pons.getX3D(true);
		}				
		if (BioWebUtils.isViewEnabled(Constants.MedullaOblongataRef, localBioMightProperties)) {
			body += medullaOblongata.getX3D(true);
		}		
		if (BioWebUtils.isViewEnabled(Constants.PituitaryGlandRef, localBioMightProperties)) {
			body += pituitaryGland.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.MedullaOblongataRef, localBioMightProperties)) {
			body += medullaOblongata.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.PinealGlandRef, localBioMightProperties)) {
			body += pinealGland.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.EarsRef, localBioMightProperties)) {
			body += ears.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.EyesRef, localBioMightProperties)) {
			body += eyes.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.EyeLidsRef, localBioMightProperties)) {
			body += eyeLids.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.NoseRef, localBioMightProperties)) {
			body += nose.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.MedullaOblongataRef, localBioMightProperties)) {
			body += medullaOblongata.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.ChinRef, localBioMightProperties)) {
			body += chin.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.HairRef, localBioMightProperties)) {
			body += hair.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ForeheadRef, localBioMightProperties)) {
			body += forehead.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.JawRef, localBioMightProperties)) {
			body += jaw.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CheeksRef, localBioMightProperties)) {
			body += cheeks.getX3D(true);
		}		
		if (BioWebUtils.isViewEnabled(Constants.SkullRef, localBioMightProperties)) {
			body += skull.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.ScalpRef, localBioMightProperties)) {
			body += scalp.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AngularArteriesRef, localBioMightProperties)) {
			body += angularArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FacialArteriesRef, localBioMightProperties)) {
			body += facialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.BasilarArteryRef, localBioMightProperties)) {
			body += basilarArtery.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.BuccalArteriesRef, localBioMightProperties)) {
			body += buccalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.DorsalNasalArteriesRef, localBioMightProperties)) {
			body += dorsalNasalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.OphthalmicArteriesRef, localBioMightProperties)) {
			body += ophthalmicArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.OccipitalArteriesRef, localBioMightProperties)) {
			body += occipitalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MentalArteriesRef, localBioMightProperties)) {
			body += mentalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FrontalArteriesRef, localBioMightProperties)) {
			body += frontalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.RanineArteriesRef, localBioMightProperties)) {
			body += ranineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalCarotidArteriesRef, localBioMightProperties)) {
			body += internalCarotidArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.ExternalCarotidArteriesRef, localBioMightProperties)) {
			body += externalCarotidArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.StylomastoidArteriesRef, localBioMightProperties)) {
			body += stylomastoidArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.MedialPalpebralArteriesRef, localBioMightProperties)) {
			body += medialPalpebralArteries.getX3D(true); 
		}	
		if (BioWebUtils.isViewEnabled(Constants.SuperiorHypophysealArteriesRef, localBioMightProperties)) {
			body += superiorHypophysealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.InferiorHypophysealArteriesRef, localBioMightProperties)) {
			body += inferiorHypophysealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.SuperiorCerebellarArteriesRef, localBioMightProperties)) {
			body += superiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorInferiorCerebellarArteriesRef, localBioMightProperties)) {
			body += anteriorInferiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorInferiorCerebellarArteriesRef, localBioMightProperties)) {
			body += posteriorInferiorCerebellarArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCerebralArteriesRef, localBioMightProperties)) {
			body += anteriorCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MiddleCerebralArteriesRef, localBioMightProperties)) {
			body += middleCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCerebralArteriesRef, localBioMightProperties)) {
			body += posteriorCerebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorCommunicatingArteryRef, localBioMightProperties)) {
			body += anteriorCommunicatingArtery.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PosteriorCommunicatingArteriesRef, localBioMightProperties)) {
			body += posteriorCommunicatingArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.VertebralArteriesRef, localBioMightProperties)) {
			body += vertebralArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AnteriorSpinalArteriesRef, localBioMightProperties)) {
			body += anteriorSpinalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.PontineArteriesRef, localBioMightProperties)) {
			body += pontineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalMaxillaryArteriesRef, localBioMightProperties)) {
			body += internalMaxillaryArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperficialTemporalArteriesRef, localBioMightProperties)) {
			body += superficialTemporalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AscendingPalatineArteriesRef, localBioMightProperties)) {
			body += ascendingPalatineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingPalatineArteriesRef, localBioMightProperties)) {
			body += descendingPalatineArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AccessoryMeningealArteriesRef, localBioMightProperties)) {
			body += accessoryMeningealArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.DescendingPalatineArteriesRef, localBioMightProperties)) {
			body += middleMeningealArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.DescendingPalatineArteriesRef, localBioMightProperties)) {
			body += posteriorMeningealArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AscendingPharyngealArteriesRef, localBioMightProperties)) {
			body += ascendingPharyngealArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.LingualArteriesRef, localBioMightProperties)) {
			body += lingualArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InfraOrbitalArteriesRef, localBioMightProperties)) {
			body += infraOrbitalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SupraOrbitalArteriesRef, localBioMightProperties)) {
			body += supraOrbitalArteries.getX3D(true); 
		}		
		if (BioWebUtils.isViewEnabled(Constants.InferiorLabialArteriesRef, localBioMightProperties)) {
			body += inferiorLabialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SuperiorLabialArteriesRef, localBioMightProperties)) {
			body += superiorLabialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.SupraTrochlearArteriesRef, localBioMightProperties)) {
			body += supraTrochlearArteries.getX3D(true); 
		}		

		
		if (BioWebUtils.isViewEnabled(Constants.ConjunctivalArteriesRef, localBioMightProperties)) {
			body += conjunctivalArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.CiliaryArteriesRef, localBioMightProperties)) {
			body += ciliaryArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.AngularVeinsRef, localBioMightProperties)) {
			body += angularVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FacialVeinsRef, localBioMightProperties)) {
			body += facialVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.TransverseFacialArteriesRef, localBioMightProperties)) {
			body += transverseFacialArteries.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MentalVeinsRef, localBioMightProperties)) {
			body += mentalVeins.getX3D(true); 
		}
		//if (BioWebUtils.isViewEnabled(Constants.EmmissaryVeinsRef, localBioMightProperties)) {
		//	body += emmissaryVeins.getX3D(true); 
		//}
		if (BioWebUtils.isViewEnabled(Constants.FacialVeinsRef, localBioMightProperties)) {
			body += facialVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.MassetericVeinsRef, localBioMightProperties)) {
			body += massetericVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.InternalJugularVeinsRef, localBioMightProperties)) {
			body += internalJugularVeins.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.ExternalJugularVeinsRef, localBioMightProperties)) {
			body += externalJugularVeins.getX3D(true); 
		}
		//if (BioWebUtils.isViewEnabled(Constants.OpticNervesVeinsRef, localBioMightProperties)) {
		//	body += opticNerves.getX3D(true); 
		//}	
		
		//System.out.println("Head X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Head.   These boxes will define
	 * the define the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
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
		
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
		
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			
			
		//********************************************************************* 
		// NOSE BOUNDBOX
		// Set up the Bounding Box for the Nose
		// On a porportioned human, the pupils lie in the middle of the face
		// For the Default model, the length is 7x9x9 
		// This puts the bounding box at the center of the head
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(0.0);
		zPos= new BigDecimal(-4.5);
		
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(4.5); 
		zVector= new BigDecimal(4.5);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Septum Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "SeptimEpithelium","connType");
		bioMightConnectors.setBioMightConnector("SeptimEpithelium", bioMightConnector);
		
		// Pharnyx Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.03, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "PharnyxEpithelium","connType");
		bioMightConnectors.setBioMightConnector("PharnyxEpithelium", bioMightConnector);
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("Nose", bioBoundBox);
		
		
		//********************************************************************* 
		// MOUTH BOUNDBOX
		// Set up the Bounding Box for the Mouth
		// On a porportioned human, the pupils lie in the middle of the face
		// For the Default model, the length is 7x9x9 
		// This puts the bounding box at the center of the head
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(0.0);
		zPos= new BigDecimal(-4.5);
		
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(4.5); 
		zVector= new BigDecimal(4.5);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Septum Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "MouthEpithelium","connType");
		bioMightConnectors.setBioMightConnector("MouthEpithelium", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("Mouth", bioBoundBox);
		
		
	
	return (boundingBoxMap);
	}
	
	
	
	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}

	public AbducentNerve getAbducentNerve() {
		return abducentNerve;
	}


	public void setAbducentNerve(AbducentNerve abducentNerve) {
		this.abducentNerve = abducentNerve;
	}


	public AccessoryNerve getAccessoryNerve() {
		return accessoryNerve;
	}


	public void setAccessoryNerve(AccessoryNerve accessoryNerve) {
		this.accessoryNerve = accessoryNerve;
	}


	public AcousticNerve getAcousticNerve() {
		return acousticNerve;
	}


	public void setAcousticNerve(AcousticNerve acousticNerve) {
		this.acousticNerve = acousticNerve;
	}


	public AuditoryNerve getAuditoryNerve() {
		return auditoryNerve;
	}


	public void setAuditoryNerve(AuditoryNerve auditoryNerve) {
		this.auditoryNerve = auditoryNerve;
	}


	public AuricularisAnteriorMuscle getAuricularisAnteriorMuscle() {
		return AuricularisAnteriorMuscle;
	}


	public void setAuricularisAnteriorMuscle(
			AuricularisAnteriorMuscle auricularisAnteriorMuscle) {
		AuricularisAnteriorMuscle = auricularisAnteriorMuscle;
	}


	public Brain getBrain() {
		return brain;
	}


	public void setBrain(Brain brain) {
		this.brain = brain;
	}


	public BuccalNerve getBuccalNerve() {
		return buccalNerve;
	}


	public void setBuccalNerve(BuccalNerve buccalNerve) {
		this.buccalNerve = buccalNerve;
	}


	public BuccinatorMuscle getBuccinatorMuscle() {
		return buccinatorMuscle;
	}


	public void setBuccinatorMuscle(BuccinatorMuscle buccinatorMuscle) {
		this.buccinatorMuscle = buccinatorMuscle;
	}


	public CaninusMuscle getCaninusMuscle() {
		return caninusMuscle;
	}


	public void setCaninusMuscle(CaninusMuscle caninusMuscle) {
		this.caninusMuscle = caninusMuscle;
	}


	public Chin getChin() {
		return chin;
	}


	public void setChin(Chin chin) {
		this.chin = chin;
	}


	public ChordaTympaniNerve getChordaTympaniNerve() {
		return ChordaTympaniNerve;
	}


	public void setChordaTympaniNerve(ChordaTympaniNerve chordaTympaniNerve) {
		ChordaTympaniNerve = chordaTympaniNerve;
	}


	public CochlearNerve getCochlearNerve() {
		return cochlearNerve;
	}


	public void setCochlearNerve(CochlearNerve cochlearNerve) {
		this.cochlearNerve = cochlearNerve;
	}


	public CorrugatorMuscle getCorrugatorMuscle() {
		return corrugatorMuscle;
	}


	public void setCorrugatorMuscle(CorrugatorMuscle corrugatorMuscle) {
		this.corrugatorMuscle = corrugatorMuscle;
	}


	public CorrugatorSuperciliiMuscle getCorrugatorSuperciliiMuscle() {
		return corrugatorSuperciliiMuscle;
	}


	public void setCorrugatorSuperciliiMuscle(
			CorrugatorSuperciliiMuscle corrugatorSuperciliiMuscle) {
		this.corrugatorSuperciliiMuscle = corrugatorSuperciliiMuscle;
	}


	public DepressorAnguliOrisMuscle getDepressorAnguliOrisMuscle() {
		return depressorAnguliOrisMuscle;
	}


	public void setDepressorAnguliOrisMuscle(
			DepressorAnguliOrisMuscle depressorAnguliOrisMuscle) {
		this.depressorAnguliOrisMuscle = depressorAnguliOrisMuscle;
	}


	public DepressorLabiiInferiorisMuscle getDepressorLabiiInferiorisMuscle() {
		return depressorLabiiInferiorisMuscle;
	}


	public void setDepressorLabiiInferioris(
			DepressorLabiiInferiorisMuscle depressorLabiiInferioris) {
		this.depressorLabiiInferiorisMuscle = depressorLabiiInferiorisMuscle;
	}


	public DepressorSeptiNasiMuscle getDepressorSepti() {
		return depressorSepti;
	}


	public void setDepressorSepti(DepressorSeptiNasiMuscle depressorSepti) {
		this.depressorSepti = depressorSepti;
	}


	public DiaphragmMuscle getDiaphragm() {
		return diaphragm;
	}


	public void setDiaphragm(DiaphragmMuscle diaphragm) {
		this.diaphragm = diaphragm;
	}


	public DilatatorNarisPosterior getDilatatorNarisPosterior() {
		return dilatatorNarisPosterior;
	}


	public void setDilatatorNarisPosterior(
			DilatatorNarisPosterior dilatatorNarisPosterior) {
		this.dilatatorNarisPosterior = dilatatorNarisPosterior;
	}


	public EpicraniusMuscle getEpicraniusMuscle() {
		return epicraniusMuscle;
	}


	public void setEpicraniusMuscle(EpicraniusMuscle epicraniusMuscle) {
		this.epicraniusMuscle = epicraniusMuscle;
	}


	public FacialNerve getFacialNerve() {
		return facialNerve;
	}


	public void setFacialNerve(FacialNerve facialNerve) {
		this.facialNerve = facialNerve;
	}


	public FrontalisMuscle getFrontalisMuscle() {
		return frontalisMuscle;
	}


	public void setFrontalisMuscle(FrontalisMuscle frontalisMuscle) {
		this.frontalisMuscle = frontalisMuscle;
	}


	public GlossopharyngealNerve getGlossopharyngealNerve() {
		return glossopharyngealNerve;
	}


	public void setGlossopharyngealNerve(GlossopharyngealNerve glossopharyngealNerve) {
		this.glossopharyngealNerve = glossopharyngealNerve;
	}


	public GreatAuricularNerve getGreatAuricularNerve() {
		return greatAuricularNerve;
	}


	public void setGreatAuricularNerve(GreatAuricularNerve greatAuricularNerve) {
		this.greatAuricularNerve = greatAuricularNerve;
	}


	public GreatOccipitalNerve getGreatOccipitalNerve() {
		return greatOccipitalNerve;
	}


	public void setGreatOccipitalNerve(GreatOccipitalNerve greatOccipitalNerve) {
		this.greatOccipitalNerve = greatOccipitalNerve;
	}


	public Hair getHair() {
		return hair;
	}


	public void setHair(Hair hair) {
		this.hair = hair;
	}


	public HypoglossalNerve getHypoglossalNerve() {
		return hypoglossalNerve;
	}


	public void setHypoglossalNerve(HypoglossalNerve hypoglossalNerve) {
		this.hypoglossalNerve = hypoglossalNerve;
	}


	public InferiorLongitudinalMuscle getInferiorLongitudinalMuscle() {
		return inferiorLongitudinalMuscle;
	}


	public void setInferiorLongitudinalMuscle(
			InferiorLongitudinalMuscle inferiorLongitudinalMuscle) {
		this.inferiorLongitudinalMuscle = inferiorLongitudinalMuscle;
	}


	public InferiorObliqueMuscle getInferiorObliqueMuscle() {
		return inferiorObliqueMuscle;
	}


	public void setInferiorObliqueMuscle(InferiorObliqueMuscle inferiorObliqueMuscle) {
		this.inferiorObliqueMuscle = inferiorObliqueMuscle;
	}


	public InferiorRectusMuscle getInferiorRectusMuscle() {
		return inferiorRectusMuscle;
	}


	public void setInferiorRectusMuscle(InferiorRectusMuscle inferiorRectusMuscle) {
		this.inferiorRectusMuscle = inferiorRectusMuscle;
	}


	public Jaw getJaw() {
		return jaw;
	}


	public void setJaw(Jaw jaw) {
		this.jaw = jaw;
	}


	public LateralRectusMuscle getLateralRectusMuscle() {
		return lateralRectusMuscle;
	}


	public void setLateralRectusMuscle(LateralRectusMuscle lateralRectusMuscle) {
		this.lateralRectusMuscle = lateralRectusMuscle;
	}

	public LesserOccipitalNerve getLesserOccipitalNerve() {
		return lesserOccipitalNerve;
	}


	public void setLesserOccipitalNerve(LesserOccipitalNerve lesserOccipitalNerve) {
		this.lesserOccipitalNerve = lesserOccipitalNerve;
	}


	public LevatorAnguliOrisMuscle getLevatorAnguliOrisMuscle() {
		return levatorAnguliOrisMuscle;
	}


	public void setLevatorAnguliOrisMuscle(
			LevatorAnguliOrisMuscle levatorAnguliOrisMuscle) {
		this.levatorAnguliOrisMuscle = levatorAnguliOrisMuscle;
	}


	public LevatorLabiiSuperiorisAlaequeNasiMuscle getLevatorLabiiSuperiorisAlaequeNasiMusc() {
		return LevatorLabiiSuperiorisAlaequeNasiMusc;
	}


	public void setLevatorLabiiSuperiorisAlaequeNasiMusc(
			LevatorLabiiSuperiorisAlaequeNasiMuscle levatorLabiiSuperiorisAlaequeNasiMusc) {
		LevatorLabiiSuperiorisAlaequeNasiMusc = levatorLabiiSuperiorisAlaequeNasiMusc;
	}


	public LevatorLabiiSuperiorisMuscle getLevatorLabiiSuperiorisMuscle() {
		return LevatorLabiiSuperiorisMuscle;
	}


	public void setLevatorLabiiSuperiorisMuscle(
			LevatorLabiiSuperiorisMuscle levatorLabiiSuperiorisMuscle) {
		LevatorLabiiSuperiorisMuscle = levatorLabiiSuperiorisMuscle;
	}


	public LevatorPalpebraeSuperiorisMuscle getLevatorPalpebraeSuperiorisMuscle() {
		return levatorPalpebraeSuperiorisMuscle;
	}


	public void setLevatorPalpebraeSuperiorisMuscle(
			LevatorPalpebraeSuperiorisMuscle levatorPalpebraeSuperiorisMuscle) {
		this.levatorPalpebraeSuperiorisMuscle = levatorPalpebraeSuperiorisMuscle;
	}


	public LongCiliaryNerve getLongCiliaryNerve() {
		return longCiliaryNerve;
	}


	public void setLongCiliaryNerve(LongCiliaryNerve longCiliaryNerve) {
		this.longCiliaryNerve = longCiliaryNerve;
	}


	public MalarFatPad getMalarFatPad() {
		return malarFatPad;
	}


	public void setMalarFatPad(MalarFatPad malarFatPad) {
		this.malarFatPad = malarFatPad;
	}


	public MasseterMuscle getMasseterMuscle() {
		return masseterMuscle;
	}


	public void setMasseterMuscle(MasseterMuscle masseterMuscle) {
		this.masseterMuscle = masseterMuscle;
	}


	public MediallRectusMuscle getMediallRectusMuscle() {
		return mediallRectusMuscle;
	}


	public void setMediallRectusMuscle(MediallRectusMuscle mediallRectusMuscle) {
		this.mediallRectusMuscle = mediallRectusMuscle;
	}


	public MentalisMuscle getMentalisMuscle() {
		return mentalisMuscle;
	}


	public void setMentalisMuscle(MentalisMuscle mentalisMuscle) {
		this.mentalisMuscle = mentalisMuscle;
	}


	public Mouth getMouth() {
		return mouth;
	}


	public void setMouth(Mouth mouth) {
		this.mouth = mouth;
	}


	public NasalisMuscle getNasalis() {
		return nasalis;
	}


	public void setNasalis(NasalisMuscle nasalis) {
		this.nasalis = nasalis;
	}


	public Nose getNose() {
		return nose;
	}


	public void setNose(Nose nose) {
		this.nose = nose;
	}


	public OculomotorNerve getOculomotorNerve() {
		return oculomotorNerve;
	}


	public void setOculomotorNerve(OculomotorNerve oculomotorNerve) {
		this.oculomotorNerve = oculomotorNerve;
	}


	public OlfactoryNerve getOlfactoryNerve() {
		return olfactoryNerve;
	}


	public void setOlfactoryNerve(OlfactoryNerve olfactoryNerve) {
		this.olfactoryNerve = olfactoryNerve;
	}


	public OpticNerves getOpticNerves() {
		return opticNerves;
	}


	public void setOpticNerves(OpticNerves opticNerves) {
		this.opticNerves = opticNerves;
	}


	public OrbicularisOrisMuscle getOrbicularisOrisMuscle() {
		return orbicularisOrisMuscle;
	}


	public void setOrbicularisOrisMuscle(OrbicularisOrisMuscle orbicularisOrisMuscle) {
		this.orbicularisOrisMuscle = orbicularisOrisMuscle;
	}


	public PhrenicNerve getPhrenicNerve() {
		return phrenicNerve;
	}


	public void setPhrenicNerve(PhrenicNerve phrenicNerve) {
		this.phrenicNerve = phrenicNerve;
	}


	public PosteriorAuricularNerve getPosteriorAuricularNerve() {
		return posteriorAuricularNerve;
	}


	public void setPosteriorAuricularNerve(
			PosteriorAuricularNerve posteriorAuricularNerve) {
		this.posteriorAuricularNerve = posteriorAuricularNerve;
	}


	public ProcerusMuscle getProcerusMuscle() {
		return procerusMuscle;
	}


	public void setProcerusMuscle(ProcerusMuscle procerusMuscle) {
		this.procerusMuscle = procerusMuscle;
	}


	public PterygoideusExternusMuscle getPterygoideusExternusMuscle() {
		return PterygoideusExternusMuscle;
	}


	public void setPterygoideusExternusMuscle(
			PterygoideusExternusMuscle pterygoideusExternusMuscle) {
		PterygoideusExternusMuscle = pterygoideusExternusMuscle;
	}


	public PterygoideusInternusMuscle getPterygoideusInternusMuscle() {
		return PterygoideusInternusMuscle;
	}


	public void setPterygoideusInternusMuscle(
			PterygoideusInternusMuscle pterygoideusInternusMuscle) {
		PterygoideusInternusMuscle = pterygoideusInternusMuscle;
	}


	public QuadratusLabiiInferiorisMuscle getQuadratusLabiiInferiorisMuscle() {
		return quadratusLabiiInferiorisMuscle;
	}


	public void setQuadratusLabiiInferiorisMuscle(
			QuadratusLabiiInferiorisMuscle quadratusLabiiInferiorisMuscle) {
		this.quadratusLabiiInferiorisMuscle = quadratusLabiiInferiorisMuscle;
	}


	public QuadratusLabiiSuperiorisMuscle getQuadratusLabiiSuperiorisMuscle() {
		return quadratusLabiiSuperiorisMuscle;
	}


	public void setQuadratusLabiiSuperiorisMuscle(
			QuadratusLabiiSuperiorisMuscle quadratusLabiiSuperiorisMuscle) {
		this.quadratusLabiiSuperiorisMuscle = quadratusLabiiSuperiorisMuscle;
	}

	public RisoriusMuscle getRisoriusMuscle() {
		return RisoriusMuscle;
	}


	public void setRisoriusMuscle(RisoriusMuscle risoriusMuscle) {
		RisoriusMuscle = risoriusMuscle;
	}


	public ShortCiliaryNerve getShortCiliaryNerve() {
		return shortCiliaryNerve;
	}


	public void setShortCiliaryNerve(ShortCiliaryNerve shortCiliaryNerve) {
		this.shortCiliaryNerve = shortCiliaryNerve;
	}


	public Skull getSkull() {
		return skull;
	}


	public void setSkull(Skull skull) {
		this.skull = skull;
	}


	public SubOccipitalNerve getSubOccipitalNerve() {
		return subOccipitalNerve;
	}


	public void setSubOccipitalNerve(SubOccipitalNerve subOccipitalNerve) {
		this.subOccipitalNerve = subOccipitalNerve;
	}


	public SubOrbicularisFatPad getSubOrbicularisFatPad() {
		return SubOrbicularisFatPad;
	}


	public void setSubOrbicularisFatPad(SubOrbicularisFatPad subOrbicularisFatPad) {
		SubOrbicularisFatPad = subOrbicularisFatPad;
	}


	public SuperiorisMuscle getSuperiorisMuscle() {
		return superiorisMuscle;
	}


	public void setSuperiorisMuscle(SuperiorisMuscle superiorisMuscle) {
		this.superiorisMuscle = superiorisMuscle;
	}


	public SuperiorLongitudinalMuscle getSuperiorLongitudinalMuscle() {
		return superiorLongitudinalMuscle;
	}


	public void setSuperiorLongitudinalMuscle(
			SuperiorLongitudinalMuscle superiorLongitudinalMuscle) {
		this.superiorLongitudinalMuscle = superiorLongitudinalMuscle;
	}


	public SuperiorObliqueMuscle getSuperiorObliqueMuscle() {
		return superiorObliqueMuscle;
	}


	public void setSuperiorObliqueMuscle(SuperiorObliqueMuscle superiorObliqueMuscle) {
		this.superiorObliqueMuscle = superiorObliqueMuscle;
	}


	public SuperiorRectusMuscle getSuperiorRectusMuscle() {
		return superiorRectusMuscle;
	}


	public void setSuperiorRectusMuscle(SuperiorRectusMuscle superiorRectusMuscle) {
		this.superiorRectusMuscle = superiorRectusMuscle;
	}


	public TemporalisMuscle getTemporalisMuscle() {
		return temporalisMuscle;
	}


	public void setTemporalisMuscle(TemporalisMuscle temporalisMuscle) {
		this.temporalisMuscle = temporalisMuscle;
	}


	public TransversusMuscle getTransversusMuscle() {
		return transversusMuscle;
	}


	public void setTransversusMuscle(TransversusMuscle transversusMuscle) {
		this.transversusMuscle = transversusMuscle;
	}


	public TriangularisMuscle getTriangularisMuscle() {
		return triangularisMuscle;
	}


	public void setTriangularisMuscle(TriangularisMuscle triangularisMuscle) {
		this.triangularisMuscle = triangularisMuscle;
	}


	public TrigeminalNerve getTrigeminalNerve() {
		return trigeminalNerve;
	}


	public void setTrigeminalNerve(TrigeminalNerve trigeminalNerve) {
		this.trigeminalNerve = trigeminalNerve;
	}


	public TrochlearNerve getTrochlearNerve() {
		return trochlearNerve;
	}


	public void setTrochlearNerve(TrochlearNerve trochlearNerve) {
		this.trochlearNerve = trochlearNerve;
	}


	public VagusNerve getVagusNerve() {
		return vagusNerve;
	}


	public void setVagusNerve(VagusNerve vagusNerve) {
		this.vagusNerve = vagusNerve;
	}


	public VerticalisMuscle getVerticalisMuscle() {
		return verticalisMuscle;
	}


	public void setVerticalisMuscle(VerticalisMuscle verticalisMuscle) {
		this.verticalisMuscle = verticalisMuscle;
	}


	public VestibularNerve getVestibularNerve() {
		return vestibularNerve;
	}


	public void setVestibularNerve(VestibularNerve vestibularNerve) {
		this.vestibularNerve = vestibularNerve;
	}


	public ZygomaticusMajorMuscle getZygomaticusMajorMuscle() {
		return zygomaticusMajorMuscle;
	}


	public void setZygomaticusMajorMuscle(
			ZygomaticusMajorMuscle zygomaticusMajorMuscle) {
		this.zygomaticusMajorMuscle = zygomaticusMajorMuscle;
	}


	public ZygomaticusMinorMuscle getZygomaticusMinorMuscle() {
		return zygomaticusMinorMuscle;
	}


	public void setZygomaticusMinorMuscle(
			ZygomaticusMinorMuscle zygomaticusMinorMuscle) {
		this.zygomaticusMinorMuscle = zygomaticusMinorMuscle;
	}


	public ZygomaticusMuscle getZygomaticusMuscle() {
		return zygomaticusMuscle;
	}


	public void setZygomaticusMuscle(ZygomaticusMuscle zygomaticusMuscle) {
		this.zygomaticusMuscle = zygomaticusMuscle;
	}


	public HyoidBone getHyoidBone() {
		return hyoidBone;
	}


	public void setHyoidBone(HyoidBone hyoidBone) {
		this.hyoidBone = hyoidBone;
	}


	public InferiorNasalConchaBone getInferiorNasalConchaBone() {
		return inferiorNasalConchaBone;
	}


	public void setInferiorNasalConchaBone(
			InferiorNasalConchaBone inferiorNasalConchaBone) {
		this.inferiorNasalConchaBone = inferiorNasalConchaBone;
	}


	public LacrimalBone getLlacrimalBone() {
		return LlacrimalBone;
	}


	public void setLlacrimalBone(LacrimalBone llacrimalBone) {
		LlacrimalBone = llacrimalBone;
	}


	public MandibleBone getMandibleBone() {
		return mandibleBone;
	}


	public void setMandibleBone(MandibleBone mandibleBone) {
		this.mandibleBone = mandibleBone;
	}


	public MaxillaeBone getMaxillaeBone() {
		return maxillaeBone;
	}


	public void setMaxillaeBone(MaxillaeBone maxillaeBone) {
		this.maxillaeBone = maxillaeBone;
	}


	public PalatineBone getPalatineBone() {
		return palatineBone;
	}


	public void setPalatineBone(PalatineBone palatineBone) {
		this.palatineBone = palatineBone;
	}


	public VomerBone getVomerBone() {
		return vomerBone;
	}


	public void setVomerBone(VomerBone vomerBone) {
		this.vomerBone = vomerBone;
	}


	public ZygomaticBone getZygomaticBone() {
		return zygomaticBone;
	}


	public void setZygomaticBone(ZygomaticBone zygomaticBone) {
		this.zygomaticBone = zygomaticBone;
	}


	public Eyes getEyes() {
		return eyes;
	}


	public void setEyes(Eyes eyes) {
		this.eyes = eyes;
	}


}
