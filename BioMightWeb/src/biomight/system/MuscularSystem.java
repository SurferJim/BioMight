/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.LongRotatorsMuscle;
import biomight.system.muscular.LongusColliMuscle;
import biomight.system.muscular.PalmarisLongusMuscle;
import biomight.system.muscular.PlatysmaMuscle;
import biomight.system.muscular.PlatysmaMuscles;
import biomight.system.muscular.TrapeziusMuscle;
import biomight.system.muscular.TrapeziusMuscles;
import biomight.system.muscular.abdomen.CremasterMuscle;
import biomight.system.muscular.abdomen.ObliquusExternusAbdominisMuscle;
import biomight.system.muscular.abdomen.ObliquusInternusAbdominisMuscle;
import biomight.system.muscular.abdomen.PsoasMajorMuscle;
import biomight.system.muscular.abdomen.PsoasMinorMuscle;
import biomight.system.muscular.abdomen.PyramidalisMuscle;
import biomight.system.muscular.abdomen.QuadratusLumborumMuscle;
import biomight.system.muscular.abdomen.RectusAdominisMuscle;
import biomight.system.muscular.abdomen.TransversusAbdominisMuscle;
import biomight.system.muscular.arm.AnconeusMuscle;
import biomight.system.muscular.arm.BicepsBrachiiMuscles;
import biomight.system.muscular.arm.BrachialisMuscles;
import biomight.system.muscular.arm.BrachioradialisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisBrevisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisLongusMuscle;
import biomight.system.muscular.arm.ExtensorCarpiUlnarisMuscle;
import biomight.system.muscular.arm.ExtensorDigitiMinimiMuscle;
import biomight.system.muscular.arm.ExtensorDigitorumMuscle;
import biomight.system.muscular.arm.ExtensorPollicisLongusMuscle;
import biomight.system.muscular.arm.TricepsBrachiiMuscle;
import biomight.system.muscular.arm.TricepsBrachiiMuscles;
import biomight.system.muscular.back.InterTransversariiMuscle;
import biomight.system.muscular.back.LongissimusCapitisMuscles;
import biomight.system.muscular.back.LongissimusCervicisMuscles;
import biomight.system.muscular.back.LongissimusThoracisMuscles;
import biomight.system.muscular.back.RotatoresSpinaeMuscleLeft1;
import biomight.system.muscular.back.SacroSpinalisMuscle;
import biomight.system.muscular.back.SemiSpinalisMuscle;
import biomight.system.muscular.back.SpleniusCapitisMuscle;
import biomight.system.muscular.back.SpleniusCervicisMuscle;
import biomight.system.muscular.chest.DiaphragmMuscles;
import biomight.system.muscular.chest.IntercostalesExterniMuscle;
import biomight.system.muscular.chest.IntercostalesInterniMuscle;
import biomight.system.muscular.chest.LevatoresCostarumMuscle;
import biomight.system.muscular.chest.SerratusPosteriorInferiorMuscle;
import biomight.system.muscular.chest.SerratusPosteriorSuperiorMuscle;
import biomight.system.muscular.chest.SubcostalisMuscle;
import biomight.system.muscular.chest.TransversusThoracisMuscle;
import biomight.system.muscular.foot.AbductorDigitiMinimiMuscle;
import biomight.system.muscular.foot.AbductorHallucisMuscle;
import biomight.system.muscular.foot.AbductorOssisMetatarsiQuintiMuscle;
import biomight.system.muscular.foot.AdductorHallucisMuscle;
import biomight.system.muscular.foot.DorsalInterosseiMuscle;
import biomight.system.muscular.foot.ExtensorDigitorumBrevis;
import biomight.system.muscular.foot.ExtensorHallucisBrevisMuscle;
import biomight.system.muscular.foot.FlexorDigitiMinimiBrevis;
import biomight.system.muscular.foot.FlexorDigitorumBrevisMuscle;
import biomight.system.muscular.foot.FlexorHallucisBrevisMuscle;
import biomight.system.muscular.foot.InterosselMuscle;
import biomight.system.muscular.foot.LumbriclesMuscle;
import biomight.system.muscular.foot.PlantarInterosseiMuscle;
import biomight.system.muscular.foot.QuadratusPlantaeMuscle;
import biomight.system.muscular.forearm.FlexorCarpiRadialisMuscle;
import biomight.system.muscular.forearm.FlexorCarpiUlnarisMuscle;
import biomight.system.muscular.forearm.FlexorCarpiUlnarisMuscles;
import biomight.system.muscular.forearm.FlexorDigitorumProfundusMuscle;
import biomight.system.muscular.forearm.FlexorDigitorumSuperficialisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisBrevisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisLongusMuscle;
import biomight.system.muscular.forearm.PronatorQuadratusMuscle;
import biomight.system.muscular.forearm.PronatorTeresMuscle;
import biomight.system.muscular.forearm.PronatorTeresMuscles;
import biomight.system.muscular.forearm.SupinatorMuscle;
import biomight.system.muscular.hand.AbductorPollicisBrevisMuscle;
import biomight.system.muscular.hand.AbductorPollicisLongusMuscle;
import biomight.system.muscular.hand.AdductorPollicisMuscle;
import biomight.system.muscular.hand.DorsalInterosseiMuscles;
import biomight.system.muscular.hand.ExtensorPollicisBrevisMuscle;
import biomight.system.muscular.hand.LumbricalMuscles;
import biomight.system.muscular.hand.OpponensDigitiMinimiMuscle;
import biomight.system.muscular.hand.OpponensPollicisMuscle;
import biomight.system.muscular.hand.PalmarInterosseiMuscles;
import biomight.system.muscular.hand.PalmarisBrevisMuscle;
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
import biomight.system.muscular.leg.thigh.AdductorMagnusMuscles;
import biomight.system.muscular.hip.ArticularisGenusMuscle;
import biomight.system.muscular.hip.CoccygeusMuscle;
import biomight.system.muscular.hip.GemelliMuscle;
import biomight.system.muscular.hip.GluteusMaximusMuscle;
import biomight.system.muscular.hip.IliopsoasMuscle;
import biomight.system.muscular.hip.IlotibialTractMuscle;
import biomight.system.muscular.hip.InferiorGemelliMuscle;
import biomight.system.muscular.hip.PiriformisMuscle;
import biomight.system.muscular.hip.SuperiorGemelliMuscle;
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
import biomight.system.muscular.leg.thigh.AdductorBrevisMuscle;
import biomight.system.muscular.leg.thigh.AdductorBrevisMuscles;
import biomight.system.muscular.leg.thigh.AdductorLongusMuscle;
import biomight.system.muscular.leg.thigh.AdductorLongusMuscles;
import biomight.system.muscular.leg.thigh.BicepsFemorisMuscle;
import biomight.system.muscular.leg.thigh.GluteusMediusMuscle;
import biomight.system.muscular.leg.thigh.GracilisMuscle;
import biomight.system.muscular.leg.thigh.IliacusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorExternusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorInternusMuscle;
import biomight.system.muscular.leg.thigh.PectineusMuscle;
import biomight.system.muscular.leg.thigh.PopliteusMuscle;
import biomight.system.muscular.leg.thigh.QuadricepsFemorisMuscle;
import biomight.system.muscular.leg.thigh.RectusFemorisMuscle;
import biomight.system.muscular.leg.thigh.SartoriusMuscle;
import biomight.system.muscular.leg.thigh.SemiMembranosusMuscle;
import biomight.system.muscular.leg.thigh.SemitendinosusMuscle;
import biomight.system.muscular.leg.thigh.TensorFasciaLataMuscle;
import biomight.system.muscular.leg.thigh.VastusInterMediusMuscle;
import biomight.system.muscular.leg.thigh.VastusLateralisMuscle;
import biomight.system.muscular.leg.thigh.VastusMedialisMuscle;
import biomight.system.muscular.neck.AnteriorScaleneMuscle;
import biomight.system.muscular.neck.AnteriorVeterbralMuscle;
import biomight.system.muscular.neck.DigastricMuscle;
import biomight.system.muscular.neck.GenioHyoidMuscle;
import biomight.system.muscular.neck.LateralCervicleMuscle;
import biomight.system.muscular.neck.LongusCapitisMuscle;
import biomight.system.muscular.neck.MylohyoidMuscle;
import biomight.system.muscular.neck.OmoHyoidMuscle;
import biomight.system.muscular.neck.RectusCapitisAnteriorMuscle;
import biomight.system.muscular.neck.RectusCapitisLateralisMuscle;
import biomight.system.muscular.neck.ScalenusAnteriorMuscle;
import biomight.system.muscular.neck.ScalenusMediusMuscle;
import biomight.system.muscular.neck.ScalenusPosteriorMuscle;
import biomight.system.muscular.neck.SternoHyoidMuscle;
import biomight.system.muscular.neck.SternoMastoidMuscle;
import biomight.system.muscular.neck.SternoThyroidMuscle;
import biomight.system.muscular.neck.StyloHyoidMuscle;
import biomight.system.muscular.neck.SuperficialCervicalMuscle;
import biomight.system.muscular.neck.SupraInfrahyoidMuscle;
import biomight.system.muscular.neck.ThyroHyoidMuscle;
import biomight.system.muscular.perineum.BulboSpongiosusMuscle;
import biomight.system.muscular.perineum.CorrugatorCutisAniMuscle;
import biomight.system.muscular.perineum.IschiocavernosusMuscle;
import biomight.system.muscular.perineum.SphincterAniExternusMuscle;
import biomight.system.muscular.perineum.SphincterAniInternusMuscle;
import biomight.system.muscular.perineum.SphincterUrethraeMembranaceaeMuscle;
import biomight.system.muscular.perineum.TransversusPerineiProfundusMuscle;
import biomight.system.muscular.perineum.TransversusPerineiSuperficialisMuscle;
import biomight.system.muscular.shoulder.DeltoideusMuscle;
import biomight.system.muscular.shoulder.InfraSpinatusMuscles;
import biomight.system.muscular.shoulder.SubScapularisMuscle;
import biomight.system.muscular.shoulder.SupraSpinatusMuscle;
import biomight.system.muscular.shoulder.TeresMajorMuscle;
import biomight.system.muscular.shoulder.TeresMinorMuscle;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;

/**
 * @author SurferJim
 *
 * Representation of the Muscular System
 * 
 */

public class MuscularSystem extends BioMightBase {

	private InfraSpinatusMuscles infraSpinatusMuscles;
	private LongissimusCapitisMuscles longissimusCapitisMuscles;
	private LongissimusCervicisMuscles longissimusCervicisMuscles;
	private LongissimusThoracisMuscles longissimusThoracisMuscles;
	private LongRotatorsMuscle longRotatorsMuscles;
	
	private PlatysmaMuscles platysmaMuscles;
	private TrapeziusMuscles trapeziusMuscles;
	
	// Head
	private EpicraniusMuscle epicraniusMuscle;	
	private FrontalisMuscle frontalisMuscle;


	private DiaphragmMuscles DiaphragmMuscles;
	//private ThenarMuscle thenarMuscle;
	
	// Facial
	private AuricularisAnteriorMuscle auricularisAnteriorMuscle;
	private CorrugatorSuperciliiMuscle corrugatorSuperciliiMuscle;
	private LevatorLabiiSuperiorisAlaequeNasiMuscle levatorLabiiSuperiorisAlaequeNasiMusc;
	private LevatorLabiiSuperiorisMuscle levatorLabiiSuperiorisMuscle;
	//private OrbicularisOculiMuscle orbicularisOculiMuscle;
	private OrbicularisOrisMuscle orbicularisOrisMuscle;
	
	
	// Eyelid
	private CorrugatorMuscle corrugatorMuscle;
	private LevatorPalpebraeSuperiorisMuscle levatorPalpebraeSuperiorisMuscle;
	//private OrbicularisOculiMuscle OrbicularisOculiMuscle;
	private SuperiorisMuscle superiorisMuscle;
	
	
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
	private RisoriusMuscle risoriusMuscle;
	private TriangularisMuscle triangularisMuscle; 
	private ZygomaticusMajorMuscle zygomaticusMajorMuscle;
	private ZygomaticusMinorMuscle zygomaticusMinorMuscle;
	private ZygomaticusMuscle zygomaticusMuscle;
	
	// Masstication
	private MasseterMuscle masseterMuscle;
	private PterygoideusExternusMuscle pterygoideusExternusMuscle;
	private PterygoideusInternusMuscle pterygoideusInternusMuscle; 
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
	
	// Neck
	private AnteriorScaleneMuscle anteriorScaleneMuscle;
	private AnteriorVeterbralMuscle anteriorVeterbralMuscle;
	private DigastricMuscle digastricMuscle;
	private GenioHyoidMuscle genioHyoidMuscle;
	private LateralCervicleMuscle lateralCervicleMuscle;
	private MylohyoidMuscle mylohyoidMuscle;
	private OmoHyoidMuscle omoHyoidMuscle;
	//private ScalenusMinimusMuscle scalenusMinimusMuscle;
	private SternoHyoidMuscle sternoHyoidMuscle;
	private SternoMastoidMuscle sternoMastoidMuscle;
	private SternoThyroidMuscle sternoThyroidMuscle;
	private StyloHyoidMuscle styloHyoidMuscle;
	private SuperficialCervicalMuscle superficialCervicalMuscle;
	private SupraInfrahyoidMuscle supraInfrahyoidMuscle;
	private ThyroHyoidMuscle thyroHyoidMuscle;
	
	private ScalenusAnteriorMuscle scalenusAnteriorMuscle;
	private ScalenusMediusMuscle scalenusMediusMuscle;
	private ScalenusPosteriorMuscle scalenusPosteriorMuscle;
	
	
	// Anterior Vertebral Muscles
	private LongusCapitisMuscle	longusCapitisMuscle;
	private LongusColliMuscle longusColliMuscle;
	private RectusCapitisAnteriorMuscle	rectusCapitisAnteriorMuscle;
	private RectusCapitisLateralisMuscle rectusCapitisLateralisMuscle;
	
		
	// Deep Muscles of the Back
	private SpleniusCapitisMuscle spleniusCapitisMuscle;
	private SpleniusCervicisMuscle spleniusCervicisMuscle;
	private InterTransversariiMuscle interTransversariiMuscle;
	private RotatoresSpinaeMuscleLeft1 rotatoresMuscle;
	private SacroSpinalisMuscle	sacroSpinalisMuscle;
	private SemiSpinalisMuscle semiSpinalisMuscle;
	
		
	// The suboccipital muscles
	
	
	// Chest
	//private CoracoBrachialisMuscle coracoBrachialisMuscle;
	private DiaphragmMuscles diaphragmMuscles;
	private IntercostalesExterniMuscle intercostalesExterniMuscle;
	private IntercostalesInterniMuscle intercostalesInterniMuscle;
	private LevatoresCostarumMuscle levatoresCostarumMuscle;
	private SerratusPosteriorSuperiorMuscle serratusPosteriorSuperiorMuscle;
	private SerratusPosteriorInferiorMuscle serratusPosteriorInferiorMuscle;
	private SubcostalisMuscle subcostalisMuscle;
	private TransversusThoracisMuscle transversusThoracisMuscle;
	
	// Shoulder
	private DeltoideusMuscle deltoideusMuscle;
	private SubScapularisMuscle subScapularisMuscle;
	private SupraSpinatusMuscle supraSpinatusMuscle;
	private TeresMajorMuscle teresMajorMuscle;
	private TeresMinorMuscle teresMinorMuscle;
	
	// Arms
	private AnconeusMuscle anconeusMuscle;
	private BicepsBrachiiMuscles bicepsBrachiiMuscles;
	private BrachialisMuscles brachialisMuscles;
	private TricepsBrachiiMuscles tricepsBrachiiMuscles;
	
	private BrachioradialisMuscle brachioradialisMuscle;
	private ExtensorCarpiRadialisBrevisMuscle extensorCarpiRadialisBrevisMuscle;
	private ExtensorCarpiRadialisLongusMuscle extensorCarpiRadialisLongusMuscle;
	private ExtensorCarpiUlnarisMuscle extensorCarpiUlnarisMuscle;
	private ExtensorDigitiMinimiMuscle extensorDigitiMinimiMuscle;
	private ExtensorDigitorumMuscle extensorDigitorumMuscle;
	private ExtensorPollicisLongusMuscle extensorPollicisLongusMuscle;
	private FlexorCarpiRadialisMuscle flexorCarpiRadialisMuscle;
	private FlexorCarpiUlnarisMuscles flexorCarpiUlnarisMuscles;
	private FlexorDigitorumProfundusMuscle flexorDigitorumProfundusMuscle;
	private FlexorDigitorumSuperficialisMuscle flexorDigitorumSuperficialisMuscle;
	private FlexorPollicisLongusMuscle flexorPollicisLongusMuscle;
	private FlexorPollicisBrevisMuscle flexorPollicisBrevisMuscle;
	private PronatorQuadratusMuscle pronatorQuadratusMuscle;
	private PronatorTeresMuscles pronatorTeresMuscles;
	private PalmarisLongusMuscle palmarisLongusMuscle;
	private SupinatorMuscle supinatorMuscle;
	
	// Hands
	private AbductorPollicisBrevisMuscle abductorPollicisBrevisMuscle;
	private AbductorPollicisLongusMuscle abductorPollicisLongusMuscle;
	private AdductorPollicisMuscle adductorPollicisMuscle;
	private DorsalInterosseiMuscles dorsalInterosseiMuscles;
	private ExtensorPollicisBrevisMuscle extensorPollicisBrevisMuscle;
	private PalmarInterosseiMuscles palmarInterosseiMuscles;
	private PalmarisBrevisMuscle palmarisBrevisMuscle;
	private OpponensDigitiMinimiMuscle opponensDigitiMinimiMuscle;
	private OpponensPollicisMuscle opponensPollicisMuscle;
	private LumbricalMuscles lumbricalMuscles;
	
	
	// Abdomen
	private CremasterMuscle cremasterMuscle;
	private ObliquusExternusAbdominisMuscle obliquusExternusAbdominisMuscle;
	private ObliquusInternusAbdominisMuscle  obliquusInternusAbdominisMuscle;
	private PsoasMajorMuscle psoasMajorMuscle;
	private PsoasMinorMuscle psoasMinorMuscle;
	private PyramidalisMuscle pyramidalisMuscle;
	private QuadratusLumborumMuscle quadratusLumborumMuscle;
	private RectusAdominisMuscle rectusAdominisMuscle;
	private TransversusAbdominisMuscle transversusAbdominisMuscle;
	
	// Pelvis
	private AdductorBrevisMuscles adductorBrevisMuscles;
	
	
	private AdductorMagnusMuscles adductorMagnusMuscles;
	private ArticularisGenusMuscle articularisGenusMuscle;
	private GemelliMuscle gemelliMuscle;
	//private IliacusMuscle iliacusMuscle;
	private IliopsoasMuscle iliopsoasMuscle;
	private IlotibialTractMuscle ilotibialTractMuscle;
	private InferiorGemelliMuscle inferiorGemelliMuscle;
	private PiriformisMuscle piriformisMuscle;
	private SuperiorGemelliMuscle superiorGemelliMuscle;
	private GluteusMaximusMuscle gluteusMaximusMuscle;
	private CoccygeusMuscle coccygeusMuscle;
	
	// Muscles of the perineum
	private BulboSpongiosusMuscle bulboSpongiosusMuscle;
	private CorrugatorCutisAniMuscle corrugatorCutisAniMuscle;
	private IschiocavernosusMuscle ischiocavernosusMuscle;
	private SphincterAniExternusMuscle sphincterAniExternusMuscle;
	private SphincterAniInternusMuscle sphincterAniInternusMuscle;
	private SphincterUrethraeMembranaceaeMuscle sphincterUrethraeMembranaceaeMuscle;
	private TransversusPerineiProfundusMuscle transversusPerineiProfundusMuscle;
	private TransversusPerineiSuperficialisMuscle transversusPerineiSuperficialisMuscle;
	
	
	// Leg - Thigh
	private AdductorLongusMuscles adductorLongusMuscles;
	private BicepsFemorisMuscle bicepsFemorisMuscle;
	//private GluteusMaximusMuscle GluteusMaximusMuscle;
	private GluteusMediusMuscle gluteusMediusMuscle;
	private GracilisMuscle gracilisMuscle;
	private IliacusMuscle iliacusMuscle;
	private ObturatorExternusMuscle obturatorExternusMuscle;
	private ObturatorInternusMuscle obturatorInternusMuscle;
	private PectineusMuscle pectineusMuscle;
	private PopliteusMuscle popliteusMuscle;
	private QuadricepsFemorisMuscle quadricepsFemorisMuscle;
	private RectusFemorisMuscle rectusFemorisMuscle;
	private SartoriusMuscle sartoriusMuscle;
	private SemiMembranosusMuscle semiMembranosusMuscle;
	private SemitendinosusMuscle semiTendinosusMuscle;
	private TensorFasciaLataMuscle tensorFasciaLataMuscle;
	private VastusInterMediusMuscle vastusInterMediusMuscle;
	private VastusLateralisMuscle vastusLateralisMuscle;
	private VastusMedialisMuscle vastusMedialisMuscle;
	
	
	// Leg - Cnemus
	private ExtensorDigitorumLongusMuscle extensorDigitorumLongusMuscle;
	private ExtensorHallicusLongusMuscle extensorHallicusLongusMuscle;
	private FlexorDigitorumLongusMuscle flexorDigitorumLongusMuscle;
	private FlexorHallicusLongusMuscle flexorHallicusLongusMuscle;
	private GastrocnemiusMuscle gastrocnemiusMuscle;
	private PeroneusLongusMuscle peroneusLongusMuscle;
	private PeroneusTertiusMuscle peroneusTertiusMuscle;
	private PeroneusBrevisMuscle peroniusBrevisMuscle;
	private PlantarisMuscle plantarisMuscle;
	private SoleusMuscle soleusMuscle;
	private TibialisAnteriorMuscle tibialisAnteriorMuscle;
	private TibialisPosteriorMuscle tibialisPosteriorMuscle;
		
	// FEET
	private AbductorDigitiMinimiMuscle abductorDigitiMinimiMuscle;
	private AbductorHallucisMuscle abductorHallucisMuscle;
	private AbductorOssisMetatarsiQuintiMuscle abductorOssisMetatarsiQuintiMuscle;
	private AdductorHallucisMuscle adductorHallucisMuscle;
	private DorsalInterosseiMuscle dorsalInterosseiMuscle;
	private ExtensorDigitorumBrevis extensorDigitorumBrevis;
	private ExtensorHallucisBrevisMuscle extensorHallucisBrevisMuscle;
	private FlexorDigitiMinimiBrevis flexorDigitiMinimiBrevis;
	private FlexorDigitorumBrevisMuscle flexorDigitorumBrevisMuscle;
	private FlexorHallucisBrevisMuscle flexorHallucisBrevisMuscle;
	private InterosselMuscle interosselMuscle;
	private LumbriclesMuscle LumbriclesMuscle;
	private PlantarInterosseiMuscle plantarInterosseiMuscle;
	private QuadratusPlantaeMuscle quadratusPlantaeMuscle;
	
	
	
	/************************************************************************
	 * MUSCULAR SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public MuscularSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.MuscularSystem, null, null);
	}

	public MuscularSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public MuscularSystem(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		//create(parentID, bioMightConstruct, bioMightMethods);
	}
	
	
	public MuscularSystem(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE MUSCULAR SYSTEM
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/MuscularSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Arteries.x3d";

		boolean bStored = false;
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting MuscularSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.MuscularSystemRef, parentID);
			System.out.println("Have MuscularSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MuscularSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection of MuscularSystems and build them into the model
		// In the default case, we get one instance of the MuscularSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("MuscularSystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the MuscularSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created MuscularSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null ||bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for MuscularSystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
					System.out.println("Have MuscularSystem Properties Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - MuscularSystem");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("MuscularSystem: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				//System.out.println("Arteries - Using LocalProperties...");
			}
			//System.out.println("Arteries - PropertiesSize: " + bioMightProperties.size());

			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG2X;
		
			
			// ARMS
			if (BioWebUtils.isViewEnabled(Constants.BicepsBrachiiMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the BicepsBrachiiMuscles for parent: " + parentID);
				bicepsBrachiiMuscles = new BicepsBrachiiMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("Im back from Creating the BicepsBrachiiMuscles   ");
				//initProperty(Constants.BicepsBrachiiMusclesRef, Constants.BicepsBrachiiMuscles, Constants.BicepsBrachiiMusclesRef, bicepsBrachiiMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the BicepsBrachiiMuscle");
			}
			else
				initProperty(Constants.BicepsBrachiiMusclesRef, Constants.BicepsBrachiiMuscles, Constants.BicepsBrachiiMusclesRef, BioWebUtils.getPropertyID(Constants.BicepsBrachiiMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			if (BioWebUtils.isViewEnabled(Constants.BrachialisMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the BrachialisMuscles for parent: " + parentID);
				brachialisMuscles = new BrachialisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.BrachialisMusclesRef, Constants.BrachialisMuscles, Constants.BrachialisMusclesRef, bicepsBrachiiMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the BrachialisMuscle");
			}
			else
				initProperty(Constants.BrachialisMusclesRef, Constants.BrachialisMuscles, Constants.BrachialisMusclesRef, BioWebUtils.getPropertyID(Constants.BrachialisMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			
			if (BioWebUtils.isViewEnabled(Constants.FlexorCarpiUlnarisMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the FlexorCarpiUlnarisMuscles for parent: " + parentID);
				flexorCarpiUlnarisMuscles = new FlexorCarpiUlnarisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.FlexorCarpiUlnarisMusclesRef, Constants.FlexorCarpiUlnarisMuscles, Constants.FlexorCarpiUlnarisMusclesRef, flexorCarpiUlnarisMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the FlexorCarpiUlnarisMuscles");
			}
			else
				initProperty(Constants.FlexorCarpiUlnarisMusclesRef, Constants.FlexorCarpiUlnarisMuscles, Constants.FlexorCarpiUlnarisMusclesRef, BioWebUtils.getPropertyID(Constants.FlexorCarpiUlnarisMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
			/*
			System.out.println("Creating the BrachialisMuscle for parent: " + parentID);
			brachialisMuscle = new BrachialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BrachialisMuscle, Constants.BrachialisMuscleRef, brachialisMuscle.getComponentID());
			System.out.println("Created the BrachialisMuscle");
			
			System.out.println("Creating the TricepsBrachiiMuscle for parent: " + parentID);
			tricepsBrachiiMuscle = new TricepsBrachiiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TricepsBrachiiMuscle, Constants.TricepsBrachiiMuscleRef, tricepsBrachiiMuscle.getComponentID());
			System.out.println("Created the TricepsBrachiiMuscle");
			 */
			
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the InfraSpinatusMuscles for parent: " + bioMightTransform.getId());
				infraSpinatusMuscles = new InfraSpinatusMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("InfraSpinatusMuscles", Constants.InfraSpinatusMuscle, Constants.InfraSpinatusMusclesRef, infraSpinatusMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the InfraSpinatusMuscle");
				}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			
			if (BioWebUtils.isViewEnabled(Constants.LongissimusCervicisMusclesRef, bioMightProperties)) {	
				System.out.println("Creating the LongissimusCervicisMuscles for parent: " + bioMightTransform.getId());
				longissimusCervicisMuscles = new LongissimusCervicisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("LongissimusCervicisMuscles", Constants.LongissimusCervicisMuscles, Constants.LongissimusCervicisMusclesRef, longissimusCervicisMuscles.getComponentID(),  bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the LongissimusCervicisMuscles");
			}
			else
				initProperty(Constants.LongissimusCervicisMusclesRef, Constants.LongissimusCervicisMuscles, Constants.LongissimusCervicisMusclesRef, BioWebUtils.getPropertyID(Constants.LongissimusCervicisMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
			if (BioWebUtils.isViewEnabled(Constants.LongissimusThoracisMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the LongissimusThoracisMuscles for parent: " + bioMightTransform.getId());
				longissimusThoracisMuscles = new LongissimusThoracisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("LongissimusThoracisMuscles", Constants.LongissimusThoracisMuscle, Constants.LongissimusThoracisMuscleRef, longissimusThoracisMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the LongissimusThoracisMuscles");
			}
			else
				initProperty(Constants.LongissimusThoracisMusclesRef, Constants.LongissimusThoracisMuscles, Constants.LongissimusThoracisMusclesRef, BioWebUtils.getPropertyID(Constants.LongissimusThoracisMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			
			if (BioWebUtils.isViewEnabled(Constants.PronatorTeresMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the PronatorTeresMuscles for parent: " + bioMightTransform.getId());
				pronatorTeresMuscles = new PronatorTeresMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.PronatorTeresMusclesRef, Constants.PronatorTeresMuscles, Constants.PronatorTeresMusclesRef, pronatorTeresMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PronatorTeresMuscle");
			}
			else
				initProperty(Constants.PronatorTeresMusclesRef, Constants.PronatorTeresMuscles, Constants.PronatorTeresMusclesRef, BioWebUtils.getPropertyID(Constants.PronatorTeresMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
			if (BioWebUtils.isViewEnabled(Constants.PlatysmaMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the PlatysmaMuscles for parent: " + bioMightTransform.getId());
				platysmaMuscles = new PlatysmaMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.PlatysmaMusclesRef, Constants.PlatysmaMuscles, Constants.PlatysmaMusclesRef, platysmaMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the PlatysmaMuscle");
			}
			else
				initProperty(Constants.PlatysmaMusclesRef, Constants.PlatysmaMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
			

			if (BioWebUtils.isViewEnabled(Constants.AdductorMagnusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the AdductorMagnusMuscles for parent: " + bioMightTransform.getId());
				adductorMagnusMuscles = new AdductorMagnusMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AdductorMagnusMusclesRef, Constants.AdductorMagnusMuscles, Constants.AdductorMagnusMusclesRef, adductorMagnusMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AdductorMagnusMuscles");
			}
			else
				initProperty(Constants.AdductorMagnusMusclesRef, Constants.AdductorMagnusMuscles, Constants.AdductorMagnusMusclesRef, BioWebUtils.getPropertyID(Constants.AdductorMagnusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		
			
			// Leg - Thigh

			
			// PELVIS
			if (BioWebUtils.isViewEnabled(Constants.AdductorLongusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the AdductorLongusMuscles for parent: " + bioMightTransform.getId());
				adductorLongusMuscles = new AdductorLongusMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AdductorLongusMusclesRef, Constants.AdductorLongusMuscles, Constants.AdductorLongusMusclesRef, adductorLongusMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AdductorLongusMuscles");
			}
			else
				initProperty(Constants.AdductorLongusMusclesRef, Constants.AdductorLongusMuscles, Constants.AdductorLongusMusclesRef, BioWebUtils.getPropertyID(Constants.AdductorLongusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			if (BioWebUtils.isViewEnabled(Constants.AdductorBrevisMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the AdductorBrevisMuscles for parent: " + bioMightTransform.getId());
				adductorBrevisMuscles = new AdductorBrevisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.AdductorBrevisMusclesRef, Constants.AdductorBrevisMuscles, Constants.AdductorBrevisMusclesRef, adductorBrevisMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the AdductorBrevisMuscles");
			}
			else
				initProperty(Constants.AdductorBrevisMusclesRef, Constants.AdductorBrevisMuscles, Constants.AdductorBrevisMusclesRef, BioWebUtils.getPropertyID(Constants.AdductorBrevisMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);


			// CHEST
			if (BioWebUtils.isViewEnabled(Constants.DiaphragmMuscleRef, bioMightProperties)) {		
				System.out.println("Creating the DiaphragmMuscle for parent: " + bioMightTransform.getId());
				diaphragmMuscles = new DiaphragmMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.DiaphragmMuscleRef, Constants.DiaphragmMuscle, Constants.DiaphragmMuscleRef, diaphragmMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				System.out.println("Created the DiaphragmMuscle");
			}
			else
				initProperty(Constants.DiaphragmMuscleRef, Constants.DiaphragmMuscle, Constants.DiaphragmMuscleRef, BioWebUtils.getPropertyID(Constants.DiaphragmMuscleRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			
			if (BioWebUtils.isViewEnabled(Constants.TrapeziusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the TrapeziusMuscles for parent: " + parentID);
				trapeziusMuscles = new TrapeziusMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.TrapeziusMuscle, Constants.TrapeziusMuscleRef, trapeziusMuscles.getComponentID());
				System.out.println("Created the TrapeziusMuscles");
				
			}
			else
				initProperty(Constants.TrapeziusMusclesRef, Constants.TrapeziusMuscles, Constants.TrapeziusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
	
			

			/*
			 * 
		
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the LongusColliMuscle for parent: " + parentID);
				longusColliMuscle = new LongusColliMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.LongusColliMuscle, Constants.LongusColliMuscleRef, longusColliMuscle.getComponentID());
				System.out.println("Created the LongusColliMuscle");
			}
			else
			{
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			}	
		
				if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the EpicraniusMuscle for parent: " + parentID);
				epicraniusMuscle = new EpicraniusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.EpicraniusMuscle, Constants.EpicraniusMuscleRef, epicraniusMuscle.getComponentID());
				System.out.println("Created the EpicraniusMuscle");
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the FrontalisMuscle for parent: " + parentID);
				frontalisMuscle = new FrontalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.FrontalisMuscle, Constants.FrontalisMuscleRef, frontalisMuscle.getComponentID());
				System.out.println("Created the FrontalisMuscle");
			}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the AuricularisAnteriorMuscle for parent: " + parentID);
				auricularisAnteriorMuscle = new AuricularisAnteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.AuricularisAnteriorMuscle, Constants.AuricularisAnteriorMuscleRef, auricularisAnteriorMuscle.getComponentID());
				System.out.println("Created the AuricularisAnteriorMuscle");
				}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the CorrugatorSuperciliiMuscle for parent: " + parentID);
				corrugatorSuperciliiMuscle = new CorrugatorSuperciliiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.CorrugatorSuperciliiMuscle, Constants.CorrugatorSuperciliiMuscleRef, corrugatorSuperciliiMuscle.getComponentID());
				System.out.println("Created the CorrugatorSuperciliiMuscle");
				}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the LevatorLabiiSuperiorisAlaequeNasiMuscle for parent: " + parentID);
				levatorLabiiSuperiorisAlaequeNasiMusc = new LevatorLabiiSuperiorisAlaequeNasiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.LevatorLabiiSuperiorisAlaequeNasiMuscle, Constants.LevatorLabiiSuperiorisAlaequeNasiMuscleRef, levatorLabiiSuperiorisAlaequeNasiMusc.getComponentID());
				System.out.println("Created the LevatorLabiiSuperiorisAlaequeNasiMuscle");
			}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the LevatorLabiiSuperiorisMuscle for parent: " + parentID);
				levatorLabiiSuperiorisMuscle = new LevatorLabiiSuperiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.LevatorLabiiSuperiorisMuscle, Constants.LevatorLabiiSuperiorisMuscleRef, levatorLabiiSuperiorisMuscle.getComponentID());
				System.out.println("Created the LevatorLabiiSuperiorisMuscle");
			}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {		
				System.out.println("Creating the OrbicularisOrisMuscle for parent: " + parentID);
				orbicularisOrisMuscle = new OrbicularisOrisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.OrbicularisOrisMuscle, Constants.OrbicularisOrisMuscleRef, orbicularisOrisMuscle.getComponentID());
				System.out.println("Created the OrbicularisOrisMuscle");
			}
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
	
			if (BioWebUtils.isViewEnabled(Constants.InfraSpinatusMusclesRef, bioMightProperties)) {	
		        System.out.println("Creating the CorrugatorMuscle for parent: " + parentID);
				corrugatorMuscle = new CorrugatorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.CorrugatorMuscle, Constants.CorrugatorMuscleRef, corrugatorMuscle.getComponentID());
				System.out.println("Created the CorrugatorMuscle");
			else
				initProperty(Constants.InfraSpinatusMusclesRef, Constants.InfraSpinatusMuscles, Constants.InfraSpinatusMusclesRef, BioWebUtils.getPropertyID(Constants.InfraSpinatusMusclesRef, bioMightProperties), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
	
				System.out.println("Creating the LevatorPalpebraeSuperiorisMuscle for parent: " + parentID);
				levatorPalpebraeSuperiorisMuscle = new LevatorPalpebraeSuperiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.LevatorPalpebraeSuperiorisMuscle, Constants.LevatorPalpebraeSuperiorisMuscleRef, levatorPalpebraeSuperiorisMuscle.getComponentID());
				System.out.println("Created the LevatorPalpebraeSuperiorisMuscle");
	
				System.out.println("Creating the SuperiorisMuscle for parent: " + parentID);
				superiorisMuscle = new SuperiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("BasilicVein", Constants.SuperiorisMuscle, Constants.SuperiorisMuscleRef, superiorisMuscle.getComponentID());
				System.out.println("Created the SuperiorisMuscle");

				
		
			// Eye
			System.out.println("Creating the InferiorObliqueMuscle for parent: " + parentID);
			inferiorObliqueMuscle = new InferiorObliqueMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.InferiorObliqueMuscle, Constants.InferiorObliqueMuscleRef, inferiorObliqueMuscle.getComponentID());
			System.out.println("Created the InferiorObliqueMuscle");
			
			System.out.println("Creating the InferiorRectusMuscle for parent: " + parentID);
			inferiorRectusMuscle = new InferiorRectusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.InferiorRectusMuscle, Constants.InferiorRectusMuscleRef, inferiorRectusMuscle.getComponentID());
			System.out.println("Created the InferiorRectusMuscle");
			
			System.out.println("Creating the LateralRectusMuscle for parent: " + parentID);
			lateralRectusMuscle = new LateralRectusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LateralRectusMuscle, Constants.LateralRectusMuscleRef, lateralRectusMuscle.getComponentID());
			System.out.println("Created the LateralRectusMuscle");
			
			System.out.println("Creating the MediallRectusMuscle for parent: " + parentID);
			mediallRectusMuscle = new MediallRectusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.MediallRectusMuscle, Constants.MediallRectusMuscleRef, mediallRectusMuscle.getComponentID());
			System.out.println("Created the MediallRectusMuscle");
			
			System.out.println("Creating the SuperiorObliqueMuscle for parent: " + parentID);
			superiorObliqueMuscle = new SuperiorObliqueMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SuperiorObliqueMuscle, Constants.SuperiorObliqueMuscleRef, superiorObliqueMuscle.getComponentID());
			System.out.println("Created the SuperiorObliqueMuscle");
			
			System.out.println("Creating the SuperiorRectusMuscle for parent: " + parentID);
			superiorRectusMuscle = new SuperiorRectusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SuperiorRectusMuscle, Constants.SuperiorRectusMuscleRef, superiorRectusMuscle.getComponentID());
			System.out.println("Created the SuperiorRectusMuscle");
		
			// Mouth

			System.out.println("Creating the BuccinatorMuscle for parent: " + parentID);
			buccinatorMuscle = new BuccinatorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BuccinatorMuscle, Constants.BuccinatorMuscleRef, buccinatorMuscle.getComponentID());
			System.out.println("Created the BuccinatorMuscle");
			
			System.out.println("Creating the CaninusMuscle for parent: " + parentID);
			caninusMuscle = new CaninusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.CaninusMuscle, Constants.CaninusMuscleRef, caninusMuscle.getComponentID());
			System.out.println("Created the CaninusMuscle");
			
			System.out.println("Creating the DepressorAnguliOrisMuscle for parent: " + parentID);
			depressorAnguliOrisMuscle = new DepressorAnguliOrisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DepressorAnguliOrisMuscle, Constants.DepressorAnguliOrisMuscleRef, depressorAnguliOrisMuscle.getComponentID());
			System.out.println("Created the DepressorAnguliOrisMuscle");
			
			System.out.println("Creating the DepressorLabiiInferiorisMuscle for parent: " + parentID);
			depressorLabiiInferiorisMuscle = new DepressorLabiiInferiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DepressorLabiiInferiorisMuscle, Constants.DepressorLabiiInferiorisMuscleRef, depressorLabiiInferiorisMuscle.getComponentID());
			System.out.println("Created the DepressorLabiiInferiorisMuscle");
		
			System.out.println("Creating the LevatorAnguliOrisMuscle for parent: " + parentID);
			levatorAnguliOrisMuscle = new LevatorAnguliOrisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LevatorAnguliOrisMuscle, Constants.LevatorAnguliOrisMuscleRef, levatorAnguliOrisMuscle.getComponentID());
			System.out.println("Created the LevatorAnguliOrisMuscle");
			
			System.out.println("Creating the MentalisMuscle for parent: " + parentID);
			mentalisMuscle = new MentalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.MentalisMuscle, Constants.MentalisMuscleRef, mentalisMuscle.getComponentID());
			System.out.println("Created the MentalisMuscle");
			
			System.out.println("Creating the QuadratusLabiiInferiorisMuscle for parent: " + parentID);
			quadratusLabiiInferiorisMuscle = new QuadratusLabiiInferiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.QuadratusLabiiInferiorisMuscle, Constants.QuadratusLabiiInferiorisMuscleRef, quadratusLabiiInferiorisMuscle.getComponentID());
			System.out.println("Created the QuadratusLabiiInferiorisMuscle");
			 
			System.out.println("Creating the QuadratusLabiiSuperiorisMuscle for parent: " + parentID);
			quadratusLabiiSuperiorisMuscle = new QuadratusLabiiSuperiorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.QuadratusLabiiSuperiorisMuscle, Constants.QuadratusLabiiSuperiorisMuscleRef, quadratusLabiiSuperiorisMuscle.getComponentID());
			System.out.println("Created the QuadratusLabiiSuperiorisMuscle");
			
			System.out.println("Creating the RisoriusMuscle for parent: " + parentID);
			risoriusMuscle = new RisoriusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RisoriusMuscle, Constants.RisoriusMuscleRef, risoriusMuscle.getComponentID());
			System.out.println("Created the RisoriusMuscle");
			 
			System.out.println("Creating the TriangularisMuscle for parent: " + parentID);
			triangularisMuscle = new TriangularisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TriangularisMuscle, Constants.TriangularisMuscleRef, triangularisMuscle.getComponentID());
			System.out.println("Created the TriangularisMuscle");
			
			System.out.println("Creating the ZygomaticusMajorMuscle for parent: " + parentID);
			zygomaticusMajorMuscle = new ZygomaticusMajorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ZygomaticusMajorMuscle, Constants.ZygomaticusMajorMuscleRef, zygomaticusMajorMuscle.getComponentID());
			System.out.println("Created the ZygomaticusMajorMuscle");
			
			System.out.println("Creating the ZygomaticusMinorMuscle for parent: " + parentID);
			zygomaticusMinorMuscle = new ZygomaticusMinorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ZygomaticusMinorMuscle, Constants.ZygomaticusMinorMuscleRef, zygomaticusMinorMuscle.getComponentID());
			System.out.println("Created the ZygomaticusMinorMuscle");
			
			System.out.println("Creating the ZygomaticusMuscle for parent: " + parentID);
			zygomaticusMuscle = new ZygomaticusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ZygomaticusMuscle, Constants.ZygomaticusMuscleRef, zygomaticusMuscle.getComponentID());
			System.out.println("Created the ZygomaticusMuscle");
			
			// Masstication

			System.out.println("Creating the MasseterMuscle for parent: " + parentID);
			masseterMuscle = new MasseterMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.MasseterMuscle, Constants.MasseterMuscleRef, masseterMuscle.getComponentID());
			System.out.println("Created the MasseterMuscle");
			
			System.out.println("Creating the PterygoideusExternusMuscle for parent: " + parentID);
			pterygoideusExternusMuscle = new PterygoideusExternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PterygoideusExternusMuscle, Constants.PterygoideusExternusMuscleRef, pterygoideusExternusMuscle.getComponentID());
			System.out.println("Created the PterygoideusExternusMuscle");
			 
			System.out.println("Creating the PterygoideusInternusMuscle for parent: " + parentID);
			pterygoideusInternusMuscle = new PterygoideusInternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PterygoideusInternusMuscle, Constants.PterygoideusInternusMuscleRef, pterygoideusInternusMuscle.getComponentID());
			System.out.println("Created the PterygoideusInternusMuscle");
			
			//temporalisMuscle = new TemporalisMuscle();

			// Tongue

			System.out.println("Creating the InferiorLongitudinalMuscle for parent: " + parentID);
			inferiorLongitudinalMuscle = new InferiorLongitudinalMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.InferiorLongitudinalMuscle, Constants.InferiorLongitudinalMuscleRef, inferiorLongitudinalMuscle.getComponentID());
			System.out.println("Created the InferiorLongitudinalMuscle");
			
			System.out.println("Creating the SuperiorLongitudinalMuscle for parent: " + parentID);
			superiorLongitudinalMuscle = new SuperiorLongitudinalMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SuperiorLongitudinalMuscle, Constants.SuperiorLongitudinalMuscleRef, superiorLongitudinalMuscle.getComponentID());
			System.out.println("Created the SuperiorLongitudinalMuscle");
			
			System.out.println("Creating the TransversusMuscle for parent: " + parentID);
			transversusMuscle = new TransversusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TransversusMuscle, Constants.TransversusMuscleRef, transversusMuscle.getComponentID());
			System.out.println("Created the TransversusMuscle");
			
			System.out.println("Creating the VerticalisMuscle for parent: " + parentID);
			verticalisMuscle = new VerticalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.VerticalisMuscle, Constants.VerticalisMuscleRef, verticalisMuscle.getComponentID());
			System.out.println("Created the VerticalisMuscle");
			
			// Nose

			System.out.println("Creating the DepressorSeptiNasiMuscle for parent: " + parentID);
			depressorSepti = new DepressorSeptiNasiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DepressorSeptiNasiMuscle, Constants.DepressorSeptiNasiMuscleRef, depressorSepti.getComponentID());
			System.out.println("Created the DepressorSeptiNasiMuscle");
			
			System.out.println("Creating the DilatatorNarisPosteriorMuscle for parent: " + parentID);
			dilatatorNarisPosteriorMuscle = new DilatatorNarisPosteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DilatatorNarisPosteriorMuscle, Constants.DilatatorNarisPosteriorMuscleRef, dilatatorNarisPosteriorMuscle.getComponentID());
			System.out.println("Created the DilatatorNarisPosteriorMuscle");
			
			System.out.println("Creating the NasalisMuscle for parent: " + parentID);
			nasalis = new NasalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.NasalisMuscle, Constants.NasalisMuscleRef, nasalis.getComponentID());
			System.out.println("Created the NasalisMuscle");
			
			System.out.println("Creating the ProcerusMuscle for parent: " + parentID);
			procerusMuscle = new ProcerusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ProcerusMuscle, Constants.ProcerusMuscleRef, procerusMuscle.getComponentID());
			System.out.println("Created the ProcerusMuscle");	
			
			// Neck

			System.out.println("Creating the AnteriorScaleneMuscle for parent: " + parentID);
			anteriorScaleneMuscle = new AnteriorScaleneMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AnteriorScaleneMuscle, Constants.AnteriorScaleneMuscleRef, anteriorScaleneMuscle.getComponentID());
			System.out.println("Created the AnteriorScaleneMuscle");
			
			System.out.println("Creating the AnteriorVeterbralMuscle for parent: " + parentID);
			anteriorVeterbralMuscle = new AnteriorVeterbralMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AnteriorVeterbralMuscle, Constants.AnteriorVeterbralMuscleRef, anteriorVeterbralMuscle.getComponentID());
			System.out.println("Created the AnteriorVeterbralMuscle");
			
			System.out.println("Creating the DigastricMuscle for parent: " + parentID);
			digastricMuscle = new DigastricMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DigastricMuscle, Constants.DigastricMuscleRef, digastricMuscle.getComponentID());
			System.out.println("Created the DigastricMuscle");
			
			System.out.println("Creating the GenioHyoidMuscle for parent: " + parentID);
			genioHyoidMuscle = new GenioHyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GenioHyoidMuscle, Constants.GenioHyoidMuscleRef, genioHyoidMuscle.getComponentID());
			System.out.println("Created the GenioHyoidMuscle");
			
			System.out.println("Creating the LateralCervicleMuscle for parent: " + parentID);
			lateralCervicleMuscle = new LateralCervicleMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LateralCervicleMuscle, Constants.LateralCervicleMuscleRef, lateralCervicleMuscle.getComponentID());
			System.out.println("Created the LateralCervicleMuscle");
			
			System.out.println("Creating the MylohyoidMuscle for parent: " + parentID);
			mylohyoidMuscle = new MylohyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.MylohyoidMuscle, Constants.MylohyoidMuscleRef, mylohyoidMuscle.getComponentID());
			System.out.println("Created the MylohyoidMuscle");
			
			System.out.println("Creating the OmoHyoidMuscle for parent: " + parentID);
			omoHyoidMuscle = new OmoHyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.OmoHyoidMuscle, Constants.OmoHyoidMuscleRef, omoHyoidMuscle.getComponentID());
			System.out.println("Created the OmoHyoidMuscle");
			
			//private ScalenusMinimusMuscle scalenusMinimusMuscle;

			System.out.println("Creating the SternoHyoidMuscle for parent: " + parentID);
			sternoHyoidMuscle = new SternoHyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SternoHyoidMuscle, Constants.SternoHyoidMuscleRef, sternoHyoidMuscle.getComponentID());
			System.out.println("Created the SternoHyoidMuscle");
			
			System.out.println("Creating the SternoMastoidMuscle for parent: " + parentID);
			sternoMastoidMuscle = new SternoMastoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SternoMastoidMuscle, Constants.SternoMastoidMuscleRef, sternoMastoidMuscle.getComponentID());
			System.out.println("Created the SternoMastoidMuscle");
			
			System.out.println("Creating the SternoThyroidMuscle for parent: " + parentID);
			sternoThyroidMuscle = new SternoThyroidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SternoThyroidMuscle, Constants.SternoThyroidMuscleRef, sternoThyroidMuscle.getComponentID());
			System.out.println("Created the SternoThyroidMuscle");
			
			System.out.println("Creating the StyloHyoidMuscle for parent: " + parentID);
			styloHyoidMuscle = new StyloHyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.StyloHyoidMuscle, Constants.StyloHyoidMuscleRef, styloHyoidMuscle.getComponentID());
			System.out.println("Created the StyloHyoidMuscle");
			
			System.out.println("Creating the SuperficialCervicalMuscle for parent: " + parentID);
			superficialCervicalMuscle = new SuperficialCervicalMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SuperficialCervicalMuscle, Constants.SuperficialCervicalMuscleRef, superficialCervicalMuscle.getComponentID());
			System.out.println("Created the SuperficialCervicalMuscle");
			
			System.out.println("Creating the SupraInfrahyoidMuscle for parent: " + parentID);
			supraInfrahyoidMuscle = new SupraInfrahyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SupraInfrahyoidMuscle, Constants.SupraInfrahyoidMuscleRef, supraInfrahyoidMuscle.getComponentID());
			System.out.println("Created the SupraInfrahyoidMuscle");
			
			System.out.println("Creating the ThyroHyoidMuscle for parent: " + parentID);
			thyroHyoidMuscle = new ThyroHyoidMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ThyroHyoidMuscle, Constants.ThyroHyoidMuscleRef, thyroHyoidMuscle.getComponentID());
			System.out.println("Created the ThyroHyoidMuscle");
			
			System.out.println("Creating the ScalenusAnteriorMuscle for parent: " + parentID);
			scalenusAnteriorMuscle = new ScalenusAnteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ScalenusAnteriorMuscle, Constants.ScalenusAnteriorMuscleRef, scalenusAnteriorMuscle.getComponentID());
			System.out.println("Created the ScalenusAnteriorMuscle");
			
			System.out.println("Creating the ScalenusMediusMuscle for parent: " + parentID);
			scalenusMediusMuscle = new ScalenusMediusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ScalenusMediusMuscle, Constants.ScalenusMediusMuscleRef, scalenusMediusMuscle.getComponentID());
			System.out.println("Created the ScalenusMediusMuscle");
			
			System.out.println("Creating the ScalenusPosteriorMuscle for parent: " + parentID);
			scalenusPosteriorMuscle = new ScalenusPosteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ScalenusPosteriorMuscle, Constants.ScalenusPosteriorMuscleRef, scalenusPosteriorMuscle.getComponentID());
			System.out.println("Created the ScalenusPosteriorMuscle");
			
			// Anterior Vertebral Muscles
			
			System.out.println("Creating the LongusCapitisMuscle for parent: " + parentID);
			longusCapitisMuscle = new LongusCapitisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LongusCapitisMuscle, Constants.LongusCapitisMuscleRef, longusCapitisMuscle.getComponentID());
			System.out.println("Created the LongusCapitisMuscle");
			
			System.out.println("Creating the LongusColliMuscle for parent: " + parentID);
			longusColliMuscle = new LongusColliMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LongusColliMuscle, Constants.LongusColliMuscleRef, longusColliMuscle.getComponentID());
			System.out.println("Created the LongusColliMuscle");
			
			System.out.println("Creating the RectusCapitisAnteriorMuscle for parent: " + parentID);
			rectusCapitisAnteriorMuscle = new RectusCapitisAnteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RectusCapitisAnteriorMuscle, Constants.RectusCapitisAnteriorMuscleRef, rectusCapitisAnteriorMuscle.getComponentID());
			System.out.println("Created the RectusCapitisAnteriorMuscle");
			
			System.out.println("Creating the RectusCapitisLateralisMuscle for parent: " + parentID);
			rectusCapitisLateralisMuscle = new RectusCapitisLateralisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RectusCapitisLateralisMuscle, Constants.RectusCapitisLateralisMuscleRef, rectusCapitisLateralisMuscle.getComponentID());
			System.out.println("Created the RectusCapitisLateralisMuscle");
		
			// Deep Muscles of the Back
			
			System.out.println("Creating the SpleniusCapitisMuscle for parent: " + parentID);
			spleniusCapitisMuscle = new SpleniusCapitisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SpleniusCapitisMuscle, Constants.SpleniusCapitisMuscleRef, spleniusCapitisMuscle.getComponentID());
			System.out.println("Created the SpleniusCapitisMuscle");
			
			System.out.println("Creating the SpleniusCervicisMuscle for parent: " + parentID);
			spleniusCervicisMuscle = new SpleniusCervicisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SpleniusCervicisMuscle, Constants.SpleniusCervicisMuscleRef, spleniusCervicisMuscle.getComponentID());
			System.out.println("Created the SpleniusCervicisMuscle");
					
			System.out.println("Creating the InterTransversariiMuscle for parent: " + parentID);
			interTransversariiMuscle = new InterTransversariiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.InterTransversariiMuscle, Constants.InterTransversariiMuscleRef, interTransversariiMuscle.getComponentID());
			System.out.println("Created the InterTransversariiMuscle");
			
			System.out.println("Creating the RotatoresSpinaeMuscleLeft1 for parent: " + parentID);
			rotatoresMuscle = new RotatoresSpinaeMuscleLeft1(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RotatoresSpinaeMuscleLeft1, Constants.RotatoresSpinaeMuscleLeft1Ref, rotatoresMuscle.getComponentID());
			System.out.println("Created the RotatoresSpinaeMuscleLeft1");
			
			System.out.println("Creating the SacroSpinalisMuscle for parent: " + parentID);
			sacroSpinalisMuscle = new SacroSpinalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SacroSpinalisMuscle, Constants.SacroSpinalisMuscleRef, sacroSpinalisMuscle.getComponentID());
			System.out.println("Created the SacroSpinalisMuscle");
			
			System.out.println("Creating the SemiSpinalisMuscle for parent: " + parentID);
			semiSpinalisMuscle = new SemiSpinalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SemiSpinalisMuscle, Constants.SemiSpinalisMuscleRef, semiSpinalisMuscle.getComponentID());
			System.out.println("Created the SemiSpinalisMuscle");
		
			// Chest
			//private CoracoBrachialisMuscle coracoBrachialisMuscle;
		
			
			System.out.println("Creating the IntercostalesExterniMuscle for parent: " + parentID);
			intercostalesExterniMuscle = new IntercostalesExterniMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IntercostalesExterniMuscle, Constants.IntercostalesExterniMuscleRef, intercostalesExterniMuscle.getComponentID());
			System.out.println("Created the IntercostalesExterniMuscle");
			
			System.out.println("Creating the IntercostalesInterniMuscle for parent: " + parentID);
			intercostalesInterniMuscle = new IntercostalesInterniMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IntercostalesInterniMuscle, Constants.IntercostalesInterniMuscleRef, intercostalesInterniMuscle.getComponentID());
			System.out.println("Created the IntercostalesInterniMuscle");
			
			System.out.println("Creating the LevatoresCostarumMuscle for parent: " + parentID);
			levatoresCostarumMuscle = new LevatoresCostarumMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LevatoresCostarumMuscle, Constants.LevatoresCostarumMuscleRef, levatoresCostarumMuscle.getComponentID());
			System.out.println("Created the LevatoresCostarumMuscle");
			
			System.out.println("Creating the SerratusPosteriorSuperiorMuscle for parent: " + parentID);
			serratusPosteriorSuperiorMuscle = new SerratusPosteriorSuperiorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SerratusPosteriorSuperiorMuscle, Constants.SerratusPosteriorSuperiorMuscleRef, serratusPosteriorSuperiorMuscle.getComponentID());
			System.out.println("Created the SerratusPosteriorSuperiorMuscle");
			
			System.out.println("Creating the SerratusPosteriorInferiorMuscle for parent: " + parentID);
			serratusPosteriorInferiorMuscle = new SerratusPosteriorInferiorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SerratusPosteriorInferiorMuscle, Constants.SerratusPosteriorInferiorMuscleRef, serratusPosteriorInferiorMuscle.getComponentID());
			System.out.println("Created the SerratusPosteriorInferiorMuscle");
			
			System.out.println("Creating the SubcostalisMuscle for parent: " + parentID);
			subcostalisMuscle = new SubcostalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SubcostalisMuscle, Constants.SubcostalisMuscleRef, subcostalisMuscle.getComponentID());
			System.out.println("Created the SubcostalisMuscle");
			
			System.out.println("Creating the TransversusThoracisMuscle for parent: " + parentID);
			transversusThoracisMuscle = new TransversusThoracisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TransversusThoracisMuscle, Constants.TransversusThoracisMuscleRef, transversusThoracisMuscle.getComponentID());
			System.out.println("Created the TransversusThoracisMuscle");
			
			// Shoulder
			
			System.out.println("Creating the DeltoideusMuscle for parent: " + parentID);
			deltoideusMuscle = new DeltoideusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DeltoideusMuscle, Constants.DeltoideusMuscleRef, deltoideusMuscle.getComponentID());
			System.out.println("Created the DeltoideusMuscle");
			
			System.out.println("Creating the SubScapularisMuscle for parent: " + parentID);
			subScapularisMuscle = new SubScapularisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SubScapularisMuscle, Constants.SubScapularisMuscleRef, subScapularisMuscle.getComponentID());
			System.out.println("Created the SubScapularisMuscle");
			
			System.out.println("Creating the SupraSpinatusMuscle for parent: " + parentID);
			supraSpinatusMuscle = new SupraSpinatusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SupraSpinatusMuscle, Constants.SupraSpinatusMuscleRef, supraSpinatusMuscle.getComponentID());
			System.out.println("Created the SupraSpinatusMuscle");
			
			System.out.println("Creating the TeresMajorMuscle for parent: " + parentID);
			teresMajorMuscle = new TeresMajorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TeresMajorMuscle, Constants.TeresMajorMuscleRef, teresMajorMuscle.getComponentID());
			System.out.println("Created the TeresMajorMuscle");
			
			System.out.println("Creating the TeresMinorMuscle for parent: " + parentID);
			teresMinorMuscle = new TeresMinorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TeresMinorMuscle, Constants.TeresMinorMuscleRef, teresMinorMuscle.getComponentID());
			System.out.println("Created the TeresMinorMuscle");
			
			// Arms
		   
			System.out.println("Creating the AnconeusMuscle for parent: " + parentID);
			anconeusMuscle = new AnconeusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AnconeusMuscle, Constants.AnconeusMuscleRef, anconeusMuscle.getComponentID());
			System.out.println("Created the AnconeusMuscle");
			
			
			System.out.println("Creating the BrachioradialisMuscle for parent: " + parentID);
			brachioradialisMuscle = new BrachioradialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BrachioradialisMuscle, Constants.BrachioradialisMuscleRef, brachioradialisMuscle.getComponentID());
			System.out.println("Created the BrachioradialisMuscle");
			
			System.out.println("Creating the ExtensorCarpiRadialisBrevisMuscle for parent: " + parentID);
			extensorCarpiRadialisBrevisMuscle = new ExtensorCarpiRadialisBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorCarpiRadialisBrevisMuscle, Constants.ExtensorCarpiRadialisBrevisMuscleRef, extensorCarpiRadialisBrevisMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiRadialisBrevisMuscle");
			
			System.out.println("Creating the ExtensorCarpiRadialisLongusMuscle for parent: " + parentID);
			extensorCarpiRadialisLongusMuscle = new ExtensorCarpiRadialisLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorCarpiRadialisLongusMuscle, Constants.ExtensorCarpiRadialisLongusMuscleRef, extensorCarpiRadialisLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiRadialisLongusMuscle");
			
			System.out.println("Creating the ExtensorCarpiUlnarisMuscle for parent: " + parentID);
			extensorCarpiUlnarisMuscle = new ExtensorCarpiUlnarisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorCarpiUlnarisMuscle, Constants.ExtensorCarpiUlnarisMuscleRef, extensorCarpiUlnarisMuscle.getComponentID());
			System.out.println("Created the ExtensorCarpiUlnarisMuscle");
			
			System.out.println("Creating the ExtensorDigitiMinimiMuscle for parent: " + parentID);
			extensorDigitiMinimiMuscle = new ExtensorDigitiMinimiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorDigitiMinimiMuscle, Constants.ExtensorDigitiMinimiMuscleRef, extensorDigitiMinimiMuscle.getComponentID());
			System.out.println("Created the ExtensorDigitiMinimiMuscle");
			
			System.out.println("Creating the ExtensorDigitorumMuscle for parent: " + parentID);
			extensorDigitorumMuscle = new ExtensorDigitorumMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorDigitorumMuscle, Constants.ExtensorDigitorumMuscleRef, extensorDigitorumMuscle.getComponentID());
			System.out.println("Created the ExtensorDigitorumMuscle");
			
			System.out.println("Creating the ExtensorPollicisLongusMuscle for parent: " + parentID);
			extensorPollicisLongusMuscle = new ExtensorPollicisLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorPollicisLongusMuscle, Constants.ExtensorPollicisLongusMuscleRef, extensorPollicisLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorPollicisLongusMuscle");
			
			System.out.println("Creating the FlexorCarpiRadialisMuscle for parent: " + parentID);
			flexorCarpiRadialisMuscle = new FlexorCarpiRadialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorCarpiRadialisMuscle, Constants.FlexorCarpiRadialisMuscleRef, flexorCarpiRadialisMuscle.getComponentID());
			System.out.println("Created the FlexorCarpiRadialisMuscle");
			
			
			System.out.println("Creating the FlexorDigitorumProfundusMuscle for parent: " + parentID);
			flexorDigitorumProfundusMuscle = new FlexorDigitorumProfundusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorDigitorumProfundusMuscle, Constants.FlexorDigitorumProfundusMuscleRef, flexorDigitorumProfundusMuscle.getComponentID());
			System.out.println("Created the FlexorDigitorumProfundusMuscle");
			
			System.out.println("Creating the FlexorDigitorumSuperficialisMuscle for parent: " + parentID);
			flexorDigitorumSuperficialisMuscle = new FlexorDigitorumSuperficialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorDigitorumSuperficialisMuscle, Constants.FlexorDigitorumSuperficialisMuscleRef, flexorDigitorumSuperficialisMuscle.getComponentID());
			System.out.println("Created the FlexorDigitorumSuperficialisMuscle");
			
			System.out.println("Creating the FlexorPollicisLongusMuscle for parent: " + parentID);
			flexorPollicisLongusMuscle = new FlexorPollicisLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorPollicisLongusMuscle, Constants.FlexorPollicisLongusMuscleRef, flexorPollicisLongusMuscle.getComponentID());
			System.out.println("Created the FlexorPollicisLongusMuscle");
			
			System.out.println("Creating the FlexorPollicisBrevisMuscle for parent: " + parentID);
			flexorPollicisBrevisMuscle = new FlexorPollicisBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorPollicisBrevisMuscle, Constants.FlexorPollicisBrevisMuscleRef, flexorPollicisBrevisMuscle.getComponentID());
			System.out.println("Created the FlexorPollicisBrevisMuscle");
			
			System.out.println("Creating the PronatorQuadratusMuscle for parent: " + parentID);
			pronatorQuadratusMuscle = new PronatorQuadratusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PronatorQuadratusMuscle, Constants.PronatorQuadratusMuscleRef, pronatorQuadratusMuscle.getComponentID());
			System.out.println("Created the PronatorQuadratusMuscle");
			
			System.out.println("Creating the PronatorTeresMuscle for parent: " + parentID);
			pronatorTeresMuscle = new PronatorTeresMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PronatorTeresMuscle, Constants.PronatorTeresMuscleRef, pronatorTeresMuscle.getComponentID());
			System.out.println("Created the PronatorTeresMuscle");
			
			System.out.println("Creating the PalmarisLongusMuscle for parent: " + parentID);
			palmarisLongusMuscle = new PalmarisLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PalmarisLongusMuscle, Constants.PalmarisLongusMuscleRef, palmarisLongusMuscle.getComponentID());
			System.out.println("Created the PalmarisLongusMuscle");
			
			System.out.println("Creating the SupinatorMuscle for parent: " + parentID);
			supinatorMuscle = new SupinatorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SupinatorMuscle, Constants.SupinatorMuscleRef, supinatorMuscle.getComponentID());
			System.out.println("Created the SupinatorMuscle");
		
			// Hands
			
			System.out.println("Creating the AbductorPollicisBrevisMuscle for parent: " + parentID);
			abductorPollicisBrevisMuscle = new AbductorPollicisBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AbductorPollicisBrevisMuscle, Constants.AbductorPollicisBrevisMuscleRef, abductorPollicisBrevisMuscle.getComponentID());
			System.out.println("Created the AbductorPollicisBrevisMuscle");
			
			System.out.println("Creating the AbductorPollicisLongusMuscle for parent: " + parentID);
			abductorPollicisLongusMuscle = new AbductorPollicisLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AbductorPollicisLongusMuscle, Constants.AbductorPollicisLongusMuscleRef, abductorPollicisLongusMuscle.getComponentID());
			System.out.println("Created the AbductorPollicisLongusMuscle");
			
			System.out.println("Creating the AdductorPollicisMuscle for parent: " + parentID);
			adductorPollicisMuscle = new AdductorPollicisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AdductorPollicisMuscle, Constants.AdductorPollicisMuscleRef, adductorPollicisMuscle.getComponentID());
			System.out.println("Created the AdductorPollicisMuscle");
			
			System.out.println("Creating the DorsalInterosseiMuscles for parent: " + parentID);
			dorsalInterosseiMuscles = new DorsalInterosseiMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.DorsalInterosseiMuscles, Constants.DorsalInterosseiMusclesRef, dorsalInterosseiMuscles.getComponentID());
			System.out.println("Created the DorsalInterosseiMuscles");
			
			System.out.println("Creating the ExtensorPollicisBrevisMuscle for parent: " + parentID);
			extensorPollicisBrevisMuscle = new ExtensorPollicisBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorPollicisBrevisMuscle, Constants.ExtensorPollicisBrevisMuscleRef, extensorPollicisBrevisMuscle.getComponentID());
			System.out.println("Created the ExtensorPollicisBrevisMuscle");
			
			System.out.println("Creating the PalmarInterosseiMuscles for parent: " + parentID);
			palmarInterosseiMuscles = new PalmarInterosseiMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PalmarInterosseiMuscles, Constants.PalmarInterosseiMusclesRef, palmarInterosseiMuscles.getComponentID());
			System.out.println("Created the PalmarInterosseiMuscles");
			
			System.out.println("Creating the PalmarisBrevisMuscle for parent: " + parentID);
			palmarisBrevisMuscle = new PalmarisBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PalmarisBrevisMuscle, Constants.PalmarisBrevisMuscleRef, palmarisBrevisMuscle.getComponentID());
			System.out.println("Created the PalmarisBrevisMuscle");
			
			System.out.println("Creating the OpponensDigitiMinimiMuscle for parent: " + parentID);
			opponensDigitiMinimiMuscle = new OpponensDigitiMinimiMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.OpponensDigitiMinimiMuscle, Constants.OpponensDigitiMinimiMuscleRef, opponensDigitiMinimiMuscle.getComponentID());
			System.out.println("Created the OpponensDigitiMinimiMuscle");
			
			System.out.println("Creating the OpponensPollicisMuscle for parent: " + parentID);
			opponensPollicisMuscle = new OpponensPollicisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.OpponensPollicisMuscle, Constants.OpponensPollicisMuscleRef, opponensPollicisMuscle.getComponentID());
			System.out.println("Created the OpponensPollicisMuscle");
			
			System.out.println("Creating the LumbricalMuscles for parent: " + parentID);
			lumbricalMuscles = new LumbricalMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.LumbricalMuscles, Constants.LumbricalMusclesRef, lumbricalMuscles.getComponentID());
			System.out.println("Created the LumbricalMuscles");
		
			// Abdomen
			
			System.out.println("Creating the CremasterMuscle for parent: " + parentID);
			cremasterMuscle = new CremasterMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.CremasterMuscle, Constants.CremasterMuscleRef, cremasterMuscle.getComponentID());
			System.out.println("Created the CremasterMuscle");
			
			System.out.println("Creating the ObliquusExternusAbdominisMuscle for parent: " + parentID);
			obliquusExternusAbdominisMuscle = new ObliquusExternusAbdominisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ObliquusExternusAbdominisMuscle, Constants.ObliquusExternusAbdominisMuscleRef, obliquusExternusAbdominisMuscle.getComponentID());
			System.out.println("Created the ObliquusExternusAbdominisMuscle");
			
			System.out.println("Creating the ObliquusInternusAbdominisMuscle for parent: " + parentID);
			obliquusInternusAbdominisMuscle = new ObliquusInternusAbdominisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ObliquusInternusAbdominisMuscle, Constants.ObliquusInternusAbdominisMuscleRef, obliquusInternusAbdominisMuscle.getComponentID());
			System.out.println("Created the ObliquusInternusAbdominisMuscle");
			
			System.out.println("Creating the PsoasMajorMuscle for parent: " + parentID);
			psoasMajorMuscle = new PsoasMajorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PsoasMajorMuscle, Constants.PsoasMajorMuscleRef, psoasMajorMuscle.getComponentID());
			System.out.println("Created the PsoasMajorMuscle");
			
			System.out.println("Creating the PsoasMinorMuscle for parent: " + parentID);
			psoasMinorMuscle = new PsoasMinorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PsoasMinorMuscle, Constants.PsoasMinorMuscleRef, psoasMinorMuscle.getComponentID());
			System.out.println("Created the PsoasMinorMuscle");
			
			System.out.println("Creating the PyramidalisMuscle for parent: " + parentID);
			pyramidalisMuscle = new PyramidalisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PyramidalisMuscle, Constants.PyramidalisMuscleRef, pyramidalisMuscle.getComponentID());
			System.out.println("Created the PyramidalisMuscle");
			
			System.out.println("Creating the QuadratusLumborumMuscle for parent: " + parentID);
			quadratusLumborumMuscle = new QuadratusLumborumMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.QuadratusLumborumMuscle, Constants.QuadratusLumborumMuscleRef, quadratusLumborumMuscle.getComponentID());
			System.out.println("Created the QuadratusLumborumMuscle");
			
			System.out.println("Creating the RectusAdominisMuscle for parent: " + parentID);
			rectusAdominisMuscle = new RectusAdominisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RectusAdominisMuscle, Constants.RectusAdominisMuscleRef, rectusAdominisMuscle.getComponentID());
			System.out.println("Created the RectusAdominisMuscle");
			
			System.out.println("Creating the TransversusAbdominisMuscle for parent: " + parentID);
			transversusAbdominisMuscle = new TransversusAbdominisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TransversusAbdominisMuscle, Constants.TransversusAbdominisMuscleRef, transversusAbdominisMuscle.getComponentID());
			System.out.println("Created the TransversusAbdominisMuscle");
			
			// Pelvis
			
			System.out.println("Creating the AdductorBrevisMuscle for parent: " + parentID);
			adductorBrevisMuscle = new AdductorBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.AdductorBrevisMuscle, Constants.AdductorBrevisMuscleRef, adductorBrevisMuscle.getComponentID());
			System.out.println("Created the AdductorBrevisMuscle");
			
			System.out.println("Creating the ArticularisGenusMuscle for parent: " + parentID);
			articularisGenusMuscle = new ArticularisGenusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ArticularisGenusMuscle, Constants.ArticularisGenusMuscleRef, articularisGenusMuscle.getComponentID());
			System.out.println("Created the ArticularisGenusMuscle");
			
			System.out.println("Creating the GemelliMuscle for parent: " + parentID);
			gemelliMuscle = new GemelliMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GemelliMuscle, Constants.GemelliMuscleRef, gemelliMuscle.getComponentID());
			System.out.println("Created the GemelliMuscle");
			
			System.out.println("Creating the IliacusMuscle for parent: " + parentID);
			iliacusMuscle = new IliacusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IliacusMuscle, Constants.IliacusMuscleRef, iliacusMuscle.getComponentID());
			System.out.println("Created the IliacusMuscle");
			
			System.out.println("Creating the IliopsoasMuscle for parent: " + parentID);
			iliopsoasMuscle = new IliopsoasMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IliopsoasMuscle, Constants.IliopsoasMuscleRef, iliopsoasMuscle.getComponentID());
			System.out.println("Created the IliopsoasMuscle");
			
			System.out.println("Creating the IlotibialTractMuscle for parent: " + parentID);
			ilotibialTractMuscle = new IlotibialTractMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IlotibialTractMuscle, Constants.IlotibialTractMuscleRef, ilotibialTractMuscle.getComponentID());
			System.out.println("Created the IlotibialTractMuscle");
			
			System.out.println("Creating the InferiorGemelliMuscle for parent: " + parentID);
			inferiorGemelliMuscle = new InferiorGemelliMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.InferiorGemelliMuscle, Constants.InferiorGemelliMuscleRef, inferiorGemelliMuscle.getComponentID());
			System.out.println("Created the InferiorGemelliMuscle");
			
			System.out.println("Creating the PiriformisMuscle for parent: " + parentID);
			piriformisMuscle = new PiriformisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PiriformisMuscle, Constants.PiriformisMuscleRef, piriformisMuscle.getComponentID());
			System.out.println("Created the PiriformisMuscle");
			
			System.out.println("Creating the SuperiorGemelliMuscle for parent: " + parentID);
			superiorGemelliMuscle = new SuperiorGemelliMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SuperiorGemelliMuscle, Constants.SuperiorGemelliMuscleRef, superiorGemelliMuscle.getComponentID());
			System.out.println("Created the SuperiorGemelliMuscle");
			
			System.out.println("Creating the TensorFasciaLataMuscle for parent: " + parentID);
			tensorFasciaLataMuscle = new TensorFasciaLataMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TensorFasciaLataMuscle, Constants.TensorFasciaLataMuscleRef, tensorFasciaLataMuscle.getComponentID());
			System.out.println("Created the TensorFasciaLataMuscle");
			
			System.out.println("Creating the GluteusMaximusMuscle for parent: " + parentID);
			gluteusMaximusMuscle = new GluteusMaximusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GluteusMaximusMuscle, Constants.GluteusMaximusMuscleRef, gluteusMaximusMuscle.getComponentID());
			System.out.println("Created the GluteusMaximusMuscle");
			
			System.out.println("Creating the CoccygeusMuscle for parent: " + parentID);
			coccygeusMuscle = new CoccygeusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.CoccygeusMuscle, Constants.CoccygeusMuscleRef, coccygeusMuscle.getComponentID());
			System.out.println("Created the CoccygeusMuscle");
		
			// Muscles of the perineum
			
			System.out.println("Creating the BulboSpongiosusMuscle for parent: " + parentID);
			bulboSpongiosusMuscle = new BulboSpongiosusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BulboSpongiosusMuscle, Constants.BulboSpongiosusMuscleRef, bulboSpongiosusMuscle.getComponentID());
			System.out.println("Created the BulboSpongiosusMuscle");
			
			System.out.println("Creating the CorrugatorCutisAniMuscle for parent: " + parentID);
			corrugatorCutisAniMuscle = new CorrugatorCutisAniMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.CorrugatorCutisAniMuscle, Constants.CorrugatorCutisAniMuscleRef, corrugatorCutisAniMuscle.getComponentID());
			System.out.println("Created the CorrugatorCutisAniMuscle");
			
			System.out.println("Creating the IschiocavernosusMuscle for parent: " + parentID);
			ischiocavernosusMuscle = new IschiocavernosusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IschiocavernosusMuscle, Constants.IschiocavernosusMuscleRef, ischiocavernosusMuscle.getComponentID());
			System.out.println("Created the IschiocavernosusMuscle");
			
			System.out.println("Creating the SphincterAniExternusMuscle for parent: " + parentID);
			sphincterAniExternusMuscle = new SphincterAniExternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SphincterAniExternusMuscle, Constants.SphincterAniExternusMuscleRef, sphincterAniExternusMuscle.getComponentID());
			System.out.println("Created the SphincterAniExternusMuscle");
			
			System.out.println("Creating the SphincterAniInternusMuscle for parent: " + parentID);
			sphincterAniInternusMuscle = new SphincterAniInternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SphincterAniInternusMuscle, Constants.SphincterAniInternusMuscleRef, sphincterAniInternusMuscle.getComponentID());
			System.out.println("Created the SphincterAniInternusMuscle");
			
			System.out.println("Creating the SphincterUrethraeMembranaceaeMuscle for parent: " + parentID);
			sphincterUrethraeMembranaceaeMuscle = new SphincterUrethraeMembranaceaeMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SphincterUrethraeMembranaceaeMuscle, Constants.SphincterUrethraeMembranaceaeMuscleRef, sphincterUrethraeMembranaceaeMuscle.getComponentID());
			System.out.println("Created the SphincterUrethraeMembranaceaeMuscle");
			
			System.out.println("Creating the TransversusPerineiProfundusMuscle for parent: " + parentID);
			transversusPerineiProfundusMuscle = new TransversusPerineiProfundusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TransversusPerineiProfundusMuscle, Constants.TransversusPerineiProfundusMuscleRef, transversusPerineiProfundusMuscle.getComponentID());
			System.out.println("Created the TransversusPerineiProfundusMuscle");
			
			System.out.println("Creating the TransversusPerineiSuperficialisMuscle for parent: " + parentID);
			transversusPerineiSuperficialisMuscle = new TransversusPerineiSuperficialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TransversusPerineiSuperficialisMuscle, Constants.TransversusPerineiSuperficialisMuscleRef, transversusPerineiSuperficialisMuscle.getComponentID());
			System.out.println("Created the TransversusPerineiSuperficialisMuscle");
		
			
			
			System.out.println("Creating the BicepsFemorisMuscle for parent: " + parentID);
			bicepsFemorisMuscle = new BicepsFemorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.BicepsFemorisMuscle, Constants.BicepsFemorisMuscleRef, bicepsFemorisMuscle.getComponentID());
			System.out.println("Created the BicepsFemorisMuscle");
			
			//private GluteusMaximusMuscle GluteusMaximusMuscle;
			
			System.out.println("Creating the GluteusMediusMuscle for parent: " + parentID);
			gluteusMediusMuscle = new GluteusMediusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GluteusMediusMuscle, Constants.GluteusMediusMuscleRef, gluteusMediusMuscle.getComponentID());
			System.out.println("Created the GluteusMediusMuscle");
			
			System.out.println("Creating the GracilisMuscle for parent: " + parentID);
			gracilisMuscle = new GracilisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GracilisMuscle, Constants.GracilisMuscleRef, gracilisMuscle.getComponentID());
			System.out.println("Created the GracilisMuscle");
			
			System.out.println("Creating the IliacusMuscle for parent: " + parentID);
			iliacusMuscle = new IliacusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.IliacusMuscle, Constants.IliacusMuscleRef, iliacusMuscle.getComponentID());
			System.out.println("Created the IliacusMuscle");
			
			System.out.println("Creating the ObturatorExternusMuscle for parent: " + parentID);
			obturatorExternusMuscle = new ObturatorExternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ObturatorExternusMuscle, Constants.ObturatorExternusMuscleRef, obturatorExternusMuscle.getComponentID());
			System.out.println("Created the ObturatorExternusMuscle");
			
			System.out.println("Creating the ObturatorInternusMuscle for parent: " + parentID);
			obturatorInternusMuscle = new ObturatorInternusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ObturatorInternusMuscle, Constants.ObturatorInternusMuscleRef, obturatorInternusMuscle.getComponentID());
			System.out.println("Created the ObturatorInternusMuscle");
			
			System.out.println("Creating the PectineusMuscle for parent: " + parentID);
			pectineusMuscle = new PectineusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PectineusMuscle, Constants.PectineusMuscleRef, pectineusMuscle.getComponentID());
			System.out.println("Created the PectineusMuscle");

			System.out.println("Creating the PopliteusMuscle for parent: " + parentID);
			popliteusMuscle = new PopliteusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PopliteusMuscle, Constants.PopliteusMuscleRef, popliteusMuscle.getComponentID());
			System.out.println("Created the PopliteusMuscle");
			
			System.out.println("Creating the QuadricepsFemorisMuscle for parent: " + parentID);
			quadricepsFemorisMuscle = new QuadricepsFemorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.QuadricepsFemorisMuscle, Constants.QuadricepsFemorisMuscleRef, quadricepsFemorisMuscle.getComponentID());
			System.out.println("Created the QuadricepsFemorisMuscle");
			
			System.out.println("Creating the RectusFemorisMuscle for parent: " + parentID);
			rectusFemorisMuscle = new RectusFemorisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.RectusFemorisMuscle, Constants.RectusFemorisMuscleRef, rectusFemorisMuscle.getComponentID());
			System.out.println("Created the RectusFemorisMuscle");
			
			System.out.println("Creating the SartoriusMuscle for parent: " + parentID);
			sartoriusMuscle = new SartoriusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SartoriusMuscle, Constants.SartoriusMuscleRef, sartoriusMuscle.getComponentID());
			System.out.println("Created the SartoriusMuscle");
			
			System.out.println("Creating the SemiMembranosusMuscle for parent: " + parentID);
			semiMembranosusMuscle = new SemiMembranosusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SemiMembranosusMuscle, Constants.SemiMembranosusMuscleRef, semiMembranosusMuscle.getComponentID());
			System.out.println("Created the SemiMembranosusMuscle");
			
			System.out.println("Creating the SemitendinosusMuscle for parent: " + parentID);
			semiTendinosusMuscle = new SemitendinosusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SemitendinosusMuscle, Constants.SemitendinosusMuscleRef, semiTendinosusMuscle.getComponentID());
			System.out.println("Created the SemitendinosusMuscle");
			
			System.out.println("Creating the TensorFasciaLataMuscle for parent: " + parentID);
			tensorFasciaLataMuscle = new TensorFasciaLataMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TensorFasciaLataMuscle, Constants.TensorFasciaLataMuscleRef, tensorFasciaLataMuscle.getComponentID());
			System.out.println("Created the TensorFasciaLataMuscle");
			
			System.out.println("Creating the VastusInterMediusMuscle for parent: " + parentID);
			vastusInterMediusMuscle = new VastusInterMediusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.VastusInterMediusMuscle, Constants.VastusInterMediusMuscleRef, vastusInterMediusMuscle.getComponentID());
			System.out.println("Created the VastusInterMediusMuscle");
			
			System.out.println("Creating the VastusLateralisMuscle for parent: " + parentID);
			vastusLateralisMuscle = new VastusLateralisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.VastusLateralisMuscle, Constants.VastusLateralisMuscleRef, vastusLateralisMuscle.getComponentID());
			System.out.println("Created the VastusLateralisMuscle");
			
			System.out.println("Creating the VastusMedialisMuscle for parent: " + parentID);
			vastusMedialisMuscle = new VastusMedialisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.VastusMedialisMuscle, Constants.VastusMedialisMuscleRef, vastusMedialisMuscle.getComponentID());
			System.out.println("Created the VastusMedialisMuscle");
		
			// Leg - Cnemus
			
			
			System.out.println("Creating the ExtensorDigitorumLongusMuscle for parent: " + parentID);
			extensorDigitorumLongusMuscle = new ExtensorDigitorumLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorDigitorumLongusMuscle, Constants.ExtensorDigitorumLongusMuscleRef, extensorDigitorumLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorDigitorumLongusMuscle");
			
			System.out.println("Creating the ExtensorHallicusLongusMuscle for parent: " + parentID);
			extensorHallicusLongusMuscle = new ExtensorHallicusLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.ExtensorHallicusLongusMuscle, Constants.ExtensorHallicusLongusMuscleRef, extensorHallicusLongusMuscle.getComponentID());
			System.out.println("Created the ExtensorHallicusLongusMuscle");
			
			System.out.println("Creating the FlexorDigitorumLongusMuscle for parent: " + parentID);
			flexorDigitorumLongusMuscle = new FlexorDigitorumLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorDigitorumLongusMuscle, Constants.FlexorDigitorumLongusMuscleRef, flexorDigitorumLongusMuscle.getComponentID());
			System.out.println("Created the FlexorDigitorumLongusMuscle");
			
			System.out.println("Creating the FlexorHallicusLongusMuscle for parent: " + parentID);
			flexorHallicusLongusMuscle = new FlexorHallicusLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.FlexorHallicusLongusMuscle, Constants.FlexorHallicusLongusMuscleRef, flexorHallicusLongusMuscle.getComponentID());
			System.out.println("Created the FlexorHallicusLongusMuscle");
			
			System.out.println("Creating the GastrocnemiusMuscle for parent: " + parentID);
			gastrocnemiusMuscle = new GastrocnemiusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.GastrocnemiusMuscle, Constants.GastrocnemiusMuscleRef, gastrocnemiusMuscle.getComponentID());
			System.out.println("Created the GastrocnemiusMuscle");
			
			System.out.println("Creating the PeroneusLongusMuscle for parent: " + parentID);
			peroneusLongusMuscle = new PeroneusLongusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PeroneusLongusMuscle, Constants.PeroneusLongusMuscleRef, peroneusLongusMuscle.getComponentID());
			System.out.println("Created the PeroneusLongusMuscle");
			
			System.out.println("Creating the PeroneusTertiusMuscle for parent: " + parentID);
			peroneusTertiusMuscle = new PeroneusTertiusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PeroneusTertiusMuscle, Constants.PeroneusTertiusMuscleRef, peroneusTertiusMuscle.getComponentID());
			System.out.println("Created the PeroneusTertiusMuscle");
			
			System.out.println("Creating the PeroneusBrevisMuscle for parent: " + parentID);
			peroniusBrevisMuscle = new PeroneusBrevisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PeroneusBrevisMuscle, Constants.PeroneusBrevisMuscleRef, peroniusBrevisMuscle.getComponentID());
			System.out.println("Created the PeroneusBrevisMuscle");
			
			System.out.println("Creating the PlantarisMuscle for parent: " + parentID);
			plantarisMuscle = new PlantarisMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.PlantarisMuscle, Constants.PlantarisMuscleRef, plantarisMuscle.getComponentID());
			System.out.println("Created the PlantarisMuscle");
			
			System.out.println("Creating the SoleusMuscle for parent: " + parentID);
			soleusMuscle = new SoleusMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.SoleusMuscle, Constants.SoleusMuscleRef, soleusMuscle.getComponentID());
			System.out.println("Created the SoleusMuscle");
			
			System.out.println("Creating the TibialisAnteriorMuscle for parent: " + parentID);
			tibialisAnteriorMuscle = new TibialisAnteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TibialisAnteriorMuscle, Constants.TibialisAnteriorMuscleRef, tibialisAnteriorMuscle.getComponentID());
			System.out.println("Created the TibialisAnteriorMuscle");
			
			System.out.println("Creating the TibialisPosteriorMuscle for parent: " + parentID);
			tibialisPosteriorMuscle = new TibialisPosteriorMuscle(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BasilicVein", Constants.TibialisPosteriorMuscle, Constants.TibialisPosteriorMuscleRef, tibialisPosteriorMuscle.getComponentID());
			System.out.println("Created the TibialisPosteriorMuscle");
			******/

			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			System.out.println("Storing MuscularSystem Properties" +  properties.size()     + "   flag: "+   bStored);
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
								Constants.MuscularSystemRef, bioMightTransform.getComponentName(), properties);
				
						System.out.println("Stored MuscularSystem Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - MuscularSystem");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}	
			dumpProperties();
		
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create MuscularSystem Completed");
	}
	
	
	/*******************************************************************
	 * GENERATE the MuscularSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingMuscularSystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the MuscularSystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingMuscularSystemEndothelium of the stomach
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
	
				System.out.println("Calling Generate MuscularSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateMuscularSystem("MuscularSystemEndothelium:00001", "MuscularSystemEndothelium", 
				//	"MuscularSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("MuscularSystemEndothelium:00001", "MuscularSystemEndothelium", 
				//		"MuscularSystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingMuscularSystemEndothelium of the stomach
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
	
				System.out.println("Calling Generate MuscularSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateMuscularSystem("MuscularSystemEndothelium:00080", "MuscularSystemEndothelium", 
				//	"MuscularSystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate MuscularSystemEndothelium NoParent");
							
			}
			
			System.out.println("Created MuscularSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MuscularSystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
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



	public  void initProperties() {

		BioMightPropertyView property;
		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscle");
		property.setCanonicalName(Constants.Muscle);
		properties.add(property);
		
		// Muscules of the head
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles of the Head");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Frontalis Muscle");
		property.setCanonicalName(Constants.FrontalisMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Diaphragm Muscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);		
		

		// Facial
		property = new BioMightPropertyView();
		property.setPropertyName("Facial Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Auricularis Anterior Muscle");
		property.setCanonicalName(Constants.AuricularisAnteriorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Corrugator Supercilii Muscle");
		property.setCanonicalName(Constants.CorrugatorSuperciliiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Levator Labii Superioris Alaeque Nasi Muscle");
		property.setCanonicalName(Constants.LevatorLabiiSuperiorisAlaequeNasiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Levator Labii Superioris Muscle");
		property.setCanonicalName(Constants.LevatorLabiiSuperiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Orbicularis Oris Muscle");
		property.setCanonicalName(Constants.OrbicularisOrisMuscle);
		properties.add(property);		
	
		// Eyelid
		property = new BioMightPropertyView();
		property.setPropertyName("Eye Lid");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Corrugator Muscle");
		property.setCanonicalName(Constants.CorrugatorMuscle);
		properties.add(property);			

		property = new BioMightPropertyView();
		property.setPropertyName("Levator Palpebrae Superioris Muscle");
		property.setCanonicalName(Constants.LevatorPalpebraeSuperiorisMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Superioris Muscle");
		property.setCanonicalName(Constants.SuperiorisMuscle);
		properties.add(property);	
		
		// Eye
		property = new BioMightPropertyView();
		property.setPropertyName("Eye");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Oblique Muscle");
		property.setCanonicalName(Constants.InferiorObliqueMuscle);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Rectus Muscle");
		property.setCanonicalName(Constants.InferiorRectusMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Lateral Rectus Muscle");
		property.setCanonicalName(Constants.LateralRectusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Mediall Rectus Muscle");
		property.setCanonicalName(Constants.MediallRectusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Superior Oblique Muscle");
		property.setCanonicalName(Constants.SuperiorObliqueMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Superior Rectus Muscle");
		property.setCanonicalName(Constants.SuperiorRectusMuscle);
		properties.add(property);

		// Mouth
		property = new BioMightPropertyView();
		property.setPropertyName("Mouth");
		property.setCanonicalName(Constants.Title);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Buccinator Muscle");
		property.setCanonicalName(Constants.BuccinatorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CaninusMuscle");
		property.setCanonicalName(Constants.CaninusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Depressor Anguli Oris Muscle");
		property.setCanonicalName(Constants.DepressorAnguliOrisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Depressor Labii Inferioris");
		property.setCanonicalName(Constants.DepressorLabiiInferiorisMuscle);
		properties.add(property);


		property = new BioMightPropertyView();
		property.setPropertyName("Levator Anguli Oris Muscle");
		property.setCanonicalName(Constants.LevatorAnguliOrisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Mentalis Muscle");
		property.setCanonicalName(Constants.MentalisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Quadratus Labii Inferioris");
		property.setCanonicalName(Constants.QuadratusLabiiInferiorisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Quadratus Labii Superioris");
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
		property.setPropertyName("Zygomaticus Minor Muscle");
		property.setCanonicalName(Constants.ZygomaticusMinorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Zygomaticus Muscle");
		property.setCanonicalName(Constants.ZygomaticusMuscle);
		properties.add(property);

		// Masstication
		property = new BioMightPropertyView();
		property.setPropertyName("Mastication");
		property.setCanonicalName(Constants.Title);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Masseter Muscle");
		property.setCanonicalName(Constants.MasseterMuscle);
		
		properties.add(property);
		property = new BioMightPropertyView();
		property.setPropertyName("Pterygoideus Externus Muscle");
		property.setCanonicalName(Constants.PterygoideusExternusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pterygoideus Internus Muscle");
		property.setCanonicalName(Constants.PterygoideusInternusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Temporalis Muscle");
		property.setCanonicalName(Constants.TemporalisMuscle);
		properties.add(property);

		// Tongue
		property = new BioMightPropertyView();
		property.setPropertyName("Tongue");
		property.setCanonicalName(Constants.Title);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Longitudinal Muscle");
		property.setCanonicalName(Constants.InferiorLongitudinalMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Superior Longitudinal Muscle");
		property.setCanonicalName(Constants.SuperiorLongitudinalMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TransversusMuscle");
		property.setCanonicalName(Constants.TransversusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Verticalis Muscle");
		property.setCanonicalName(Constants.VerticalisMuscle);
		properties.add(property);
		
		// NOSE
		property = new BioMightPropertyView();
		property.setPropertyName("Nose");
		property.setCanonicalName(Constants.Title);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DepressorSeptiNasiMuscle");
		property.setCanonicalName(Constants.DepressorSeptiNasiMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DilatatorNarisPosterior");
		property.setCanonicalName(Constants.DilatatorNarisPosterior);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Nasalis Muscle");
		property.setCanonicalName(Constants.NasalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ProcerusMuscle");
		property.setCanonicalName(Constants.ProcerusMuscle);
		properties.add(property);
		
		// NECK
		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorScaleneMuscle");
		property.setCanonicalName(Constants.AnteriorScaleneMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorVeterbralMuscle");
		property.setCanonicalName(Constants.AnteriorVeterbralMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DigastricMuscle");
		property.setCanonicalName(Constants.DigastricMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GenioHyoidMuscle");
		property.setCanonicalName(Constants.GenioHyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralCervicleMuscle");
		property.setCanonicalName(Constants.LateralCervicleMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MylohyoidMuscle");
		property.setCanonicalName(Constants.MylohyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("OmoHyoidMuscle");
		property.setCanonicalName(Constants.OmoHyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ScalenusMinimusMuscle");
		property.setCanonicalName(Constants.ScalenusMinimusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SternoHyoidMuscle");
		property.setCanonicalName(Constants.SternoHyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SternoMastoidMuscle");
		property.setCanonicalName(Constants.SternoMastoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SternoThyroidMuscle");
		property.setCanonicalName(Constants.SternoThyroidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("StyloHyoidMuscle");
		property.setCanonicalName(Constants.StyloHyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialCervicalMuscle");
		property.setCanonicalName(Constants.SuperficialCervicalMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SupraInfrahyoidMuscle");
		property.setCanonicalName(Constants.SupraInfrahyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThyroHyoidMuscle");
		property.setCanonicalName(Constants.ThyroHyoidMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ScalenusAnteriorMuscle");
		property.setCanonicalName(Constants.ScalenusAnteriorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ScalenusMediusMuscle");
		property.setCanonicalName(Constants.ScalenusMediusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ScalenusPosteriorMuscle");
		property.setCanonicalName(Constants.ScalenusPosteriorMuscle);
		properties.add(property);

		// Anterior Vertebral Muscles
		property = new BioMightPropertyView();
		property.setPropertyName("Veterbral");
		property.setCanonicalName(Constants.Title);
			
		property = new BioMightPropertyView();
		property.setPropertyName("LongusCapitisMuscle");
		property.setCanonicalName(Constants.LongusCapitisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongusColliMuscle");
		property.setCanonicalName(Constants.LongusColliMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RectusCapitisAnteriorMuscle");
		property.setCanonicalName(Constants.RectusCapitisAnteriorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RectusCapitisLateralisMuscle");
		property.setCanonicalName(Constants.RectusCapitisLateralisMuscle);
		properties.add(property);
		
		// Deep Muscles of the Back
		property = new BioMightPropertyView();
		property.setPropertyName("Deep Back Muscles");
		property.setCanonicalName(Constants.Title);

		property = new BioMightPropertyView();
		property.setPropertyName("SpleniusCapitisMuscle");
		property.setCanonicalName(Constants.SpleniusCapitisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RotatoresSpinaeMuscles");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscles);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SpleniusCervicisMuscle");
		property.setCanonicalName(Constants.SpleniusCervicisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterSpinalesMuscle");
		property.setCanonicalName(Constants.InterSpinalesMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterTransversariiMuscle");
		property.setCanonicalName(Constants.InterTransversariiMuscle);
		properties.add(property);
			
		property = new BioMightPropertyView();
		property.setPropertyName("SacroSpinalisMuscle");
		property.setCanonicalName(Constants.SacroSpinalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemiSpinalisMuscle");
		property.setCanonicalName(Constants.SemiSpinalisMuscle);
		properties.add(property);

		// CHEST
		property = new BioMightPropertyView();
		property.setPropertyName("Chest");
		property.setCanonicalName(Constants.Title);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("CoracoBrachialisMuscle");
		property.setCanonicalName(Constants.CoracoBrachialisMuscle);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("DiaphragmMuscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("IntercostalesExterniMuscle");
		property.setCanonicalName(Constants.IntercostalesExterniMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("IntercostalesInterniMuscle");
		property.setCanonicalName(Constants.IntercostalesInterniMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("LevatoresCostarumMuscle");
		property.setCanonicalName(Constants.LevatoresCostarumMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("SerratusPosteriorSuperiorMuscle");
		property.setCanonicalName(Constants.SerratusPosteriorSuperiorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SerratusPosteriorInferiorMuscle");
		property.setCanonicalName(Constants.SerratusPosteriorInferiorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubcostalisMuscle");
		property.setCanonicalName(Constants.SubcostalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TransversusThoracisMuscle");
		property.setCanonicalName(Constants.TransversusThoracisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeltoideusMuscle");
		property.setCanonicalName(Constants.DeltoideusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubScapularisMuscle");
		property.setCanonicalName(Constants.SubScapularisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SupraSpinatusMuscle");
		property.setCanonicalName(Constants.SupraSpinatusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TeresMajorMuscle");
		property.setCanonicalName(Constants.TeresMajorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TeresMinorMuscle");
		property.setCanonicalName(Constants.TeresMinorMuscle);
		properties.add(property);


		// SHOULDERS	
		property = new BioMightPropertyView();
		property.setPropertyName("Shoulders");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeltoideusMuscle");
		property.setCanonicalName(Constants.DeltoideusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubScapularisMuscle");
		property.setCanonicalName(Constants.SubScapularisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SupraSpinatusMuscle");
		property.setCanonicalName(Constants.SupraSpinatusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TeresMajorMuscle");
		property.setCanonicalName(Constants.TeresMajorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TeresMinorMuscle");
		property.setCanonicalName(Constants.TeresMinorMuscle);
		properties.add(property);

		// ARMS
		property = new BioMightPropertyView();
		property.setPropertyName("Arms");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnconeusMuscle");
		property.setCanonicalName(Constants.AnconeusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BicepsBrachiiMuscle");
		property.setCanonicalName(Constants.BicepsBrachiiMuscle);
		properties.add(property);			

		property = new BioMightPropertyView();
		property.setPropertyName("BrachialisMuscle");
		property.setCanonicalName(Constants.BrachialisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TricepsBrachiiMuscle");
		property.setCanonicalName(Constants.TricepsBrachiiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BrachioradialisMuscle");
		property.setCanonicalName(Constants.BrachioradialisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorCarpiRadialisBrevisMuscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorCarpiRadialisLongusMuscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorCarpiUlnarisMuscle");
		property.setCanonicalName(Constants.ExtensorCarpiUlnarisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorDigitiMinimi");
		property.setCanonicalName(Constants.ExtensorDigitiMinimiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorDigitorumMuscle");
		property.setCanonicalName(Constants.ExtensorDigitorumMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorPollicisLongusMuscle");
		property.setCanonicalName(Constants.ExtensorPollicisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorCarpiRadialisMuscle");
		property.setCanonicalName(Constants.FlexorCarpiRadialisMuscle);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorCarpiUlnarisMuscle");
		property.setCanonicalName(Constants.FlexorCarpiUlnarisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorDigitorumProfundusMuscle");
		property.setCanonicalName(Constants.FlexorDigitorumProfundusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorDigitorumSuperficialisMuscle");
		property.setCanonicalName(Constants.FlexorDigitorumSuperficialisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorPollicisLongusMuscle");
		property.setCanonicalName(Constants.FlexorPollicisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorPollicisBrevisMuscle");
		property.setCanonicalName(Constants.FlexorPollicisBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PronatorQuadratusMuscle");
		property.setCanonicalName(Constants.PronatorQuadratusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PronatorTeresMuscle");
		property.setCanonicalName(Constants.PronatorTeresMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PalmarisLongusMuscle");
		property.setCanonicalName(Constants.PalmarisLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SupinatorMuscle");
		property.setCanonicalName(Constants.SupinatorMuscle);
		properties.add(property);

		// HANDS
		property = new BioMightPropertyView();
		property.setPropertyName("Hands");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AbductorPollicisBrevisMuscle");
		property.setCanonicalName(Constants.AbductorPollicisBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AbductorPollicisLongusMuscle");
		property.setCanonicalName(Constants.AbductorPollicisLongusMuscle);
		properties.add(property);
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("AdductorPollicisMuscle");
		property.setCanonicalName(Constants.AdductorPollicisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DorsalInterosseiMuscles");
		property.setCanonicalName(Constants.DorsalInterosseiMuscles);
		properties.add(property);
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorPollicisBrevisMuscle");
		property.setCanonicalName(Constants.ExtensorPollicisBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PalmarInterosseiMuscles");
		property.setCanonicalName(Constants.PalmarInterosseiMuscles);
		properties.add(property);
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("PalmarisBrevisMuscle");
		property.setCanonicalName(Constants.PalmarisBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OpponensDigitiMinimiMuscle");
		property.setCanonicalName(Constants.OpponensDigitiMinimiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OpponensPollicisMuscle");
		property.setCanonicalName(Constants.OpponensPollicisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LumbricalMuscles");
		property.setCanonicalName(Constants.LumbricalMuscles);
		properties.add(property);

				
		// Torso
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles of the Torso");
		property.setCanonicalName(Constants.Nucleolus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles of the Abdomen");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		// ABDOMEN
		property = new BioMightPropertyView();
		property.setPropertyName("Cremaster Muscle");
		property.setCanonicalName(Constants.CremasterMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Obliquus Externus Abdominis Muscle");
		property.setCanonicalName(Constants.ObliquusExternusAbdominisMuscle);
		properties.add(property);
			
		property = new BioMightPropertyView();
		property.setPropertyName("PsoasMinorMuscle");
		property.setCanonicalName(Constants.PsoasMinorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ObliquusInternusAbdominisMuscle");
		property.setCanonicalName(Constants.ObliquusInternusAbdominisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PsoasMajorMuscle");
		property.setCanonicalName(Constants.PsoasMajorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("QuadratusLumborumMuscle");
		property.setCanonicalName(Constants.QuadratusLumborumMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("RectusAdominisMuscle");
		property.setCanonicalName(Constants.RectusAdominisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TransversusAbdominisMuscle");
		property.setCanonicalName(Constants.TransversusAbdominisMuscle);
		properties.add(property);
		
		// PELVIS
		property = new BioMightPropertyView();
		property.setPropertyName("Pelvis");
		property.setCanonicalName(Constants.Pelvis);
		properties.add(property);

		
		property = new BioMightPropertyView();
		property.setPropertyName("AdductorBrevisMuscle");
		property.setCanonicalName(Constants.AdductorBrevisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdductorMagnusMuscle");
		property.setCanonicalName(Constants.AdductorMagnusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArticularisGenusMuscle");
		property.setCanonicalName(Constants.ArticularisGenusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliacusMuscle");
		property.setCanonicalName(Constants.IliacusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliopsoasMuscle");
		property.setCanonicalName(Constants.IliopsoasMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IlotibialTractMuscle");
		property.setCanonicalName(Constants.IlotibialTractMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorGemelliMuscle");
		property.setCanonicalName(Constants.InferiorGemelliMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PiriformisMuscle");
		property.setCanonicalName(Constants.PiriformisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorGemelliMuscle");
		property.setCanonicalName(Constants.SuperiorGemelliMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TensorFasciaeLataMuscle");
		property.setCanonicalName(Constants.TensorFasciaeLataMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GluteusMaximusMuscle");
		property.setCanonicalName(Constants.GluteusMaximusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CoccygeusMuscle");
		property.setCanonicalName(Constants.CoccygeusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Perenium");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("BulboSpongiosusMuscle");
		property.setCanonicalName(Constants.BulboSpongiosusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CorrugatorCutisAniMuscle");
		property.setCanonicalName(Constants.CorrugatorCutisAniMuscle);
		properties.add(property);

		
		property = new BioMightPropertyView();
		property.setPropertyName("IschiocavernosusMuscle");
		property.setCanonicalName(Constants.IschiocavernosusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SphincterAniExternusMuscle");
		property.setCanonicalName(Constants.SphincterAniExternusMuscle);
		properties.add(property);

		
		property = new BioMightPropertyView();
		property.setPropertyName("SphincterAniInternusMuscle");
		property.setCanonicalName(Constants.SphincterAniInternusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SphincterUrethraeMembranaceaeMuscle");
		property.setCanonicalName(Constants.SphincterUrethraeMembranaceaeMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TransversusPerineiProfundusMuscle");
		property.setCanonicalName(Constants.TransversusPerineiProfundusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TransversusPerineiSuperficialisMuscle");
		property.setCanonicalName(Constants.TransversusPerineiSuperficialisMuscle);
		properties.add(property);

		// Leg - Thigh
		property = new BioMightPropertyView();
		property.setPropertyName("Thigh");
		property.setCanonicalName(Constants.TransversusPerineiSuperficialisMuscle);
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
		property.setPropertyName("GluteusMaximusMuscle");
		property.setCanonicalName(Constants.GluteusMaximusMuscle);
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

		// Leg - Cnemus
		property = new BioMightPropertyView();
		property.setPropertyName("Cnemus");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorDigitorumLongusMuscle");
		property.setCanonicalName(Constants.ExtensorDigitorumLongusMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorHallicusLongusMuscle");
		property.setCanonicalName(Constants.ExtensorHallicusLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Digitorum Longus Muscle");
		property.setCanonicalName(Constants.FlexorDigitorumLongusMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Flexor Hallicus Longus Muscle");
		property.setCanonicalName(Constants.FlexorHallicusLongusMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Gastrocnemius Muscle");
		property.setCanonicalName(Constants.GastrocnemiusMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Peroneus Longus Muscle");
		property.setCanonicalName(Constants.PeroneusLongusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Peroneus Tertius Muscle");
		property.setCanonicalName(Constants.PeroneusTertiusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PeroniusBrevisMuscle");
		property.setCanonicalName(Constants.PeroneusBrevisMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PlantarisMuscle");
		property.setCanonicalName(Constants.PlantarisMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("SoleusMuscle");
		property.setCanonicalName(Constants.SoleusMuscle);
		properties.add(property);
			
		property = new BioMightPropertyView();
		property.setPropertyName("TibialisAnteriorMuscle");
		property.setCanonicalName(Constants.TibialisAnteriorMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("TibialisPosteriorMuscle");
		property.setCanonicalName(Constants.TibialisPosteriorMuscle);
		properties.add(property);	

		// FEET
		property = new BioMightPropertyView();
		property.setPropertyName("AbductorDigitiMinimiMuscle");
		property.setCanonicalName(Constants.AbductorDigitiMinimiMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("AbductorHallucisMuscle");
		property.setCanonicalName(Constants.AbductorHallucisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AbductorOssisMetatarsiQuintiMuscle");
		property.setCanonicalName(Constants.AbductorOssisMetatarsiQuintiMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdductorHallucisMuscle");
		property.setCanonicalName(Constants.AdductorHallucisMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("DorsalInterosseiMuscle");
		property.setCanonicalName(Constants.DorsalInterosseiMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorDigitorumBrevis");
		property.setCanonicalName(Constants.ExtensorDigitorumBrevis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExtensorHallucisBrevisMuscle");
		property.setCanonicalName(Constants.ExtensorHallucisBrevisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("FlexorDigitiMinimiBrevis");
		property.setCanonicalName(Constants.FlexorDigitiMinimiBrevis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FlexorDigitorumBrevisMuscle");
		property.setCanonicalName(Constants.FlexorDigitorumBrevisMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("FlexorHallucisBrevisMuscle");
		property.setCanonicalName(Constants.FlexorHallucisBrevisMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("InterosselMuscle");
		property.setCanonicalName(Constants.InterosselMuscle);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("LumbriclesMuscle");
		property.setCanonicalName(Constants.LumbriclesMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PlantarInterosseiMuscle");
		property.setCanonicalName(Constants.PlantarInterosseiMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("QuadratusPlantaeMuscle");
		property.setCanonicalName(Constants.QuadratusPlantaeMuscle);
		properties.add(property);

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
		 "<meta name='BioMightImage' content='Abdomen.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='MuscularSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
	
		//*******************************************
		// ARM
		//********************************************
		if (BioWebUtils.isViewEnabled(Constants.BicepsBrachiiMusclesRef, properties)) {
			body +=  bicepsBrachiiMuscles.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.BrachialisMusclesRef, properties)) {
			body +=  brachialisMuscles.getX3D(true); 
		}
	
		// THORAX
		if (BioWebUtils.isViewEnabled(Constants. InfraSpinatusMusclesRef, properties)) {
			body +=  infraSpinatusMuscles.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants. LongissimusCervicisMusclesRef, properties)) {
			body +=  longissimusCervicisMuscles.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants. LongissimusThoracisMusclesRef, properties)) {
			body +=  longissimusThoracisMuscles.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants. PronatorTeresMusclesRef, properties)) {
			body +=  pronatorTeresMuscles.getX3D(true); 
		}
		if (BioWebUtils.isViewEnabled(Constants.FlexorCarpiUlnarisMusclesRef, properties)) {
			body +=  flexorCarpiUlnarisMuscles.getX3D(true); 
		}
		
	
		//**********************************************
		// CHEST
		//**********************************************
	
		if (BioWebUtils.isViewEnabled(Constants.DiaphragmMusclesRef, properties)) {
			body +=  diaphragmMuscles.getX3D(true);	
		}
		//**********************************************
		// LEG
		//**********************************************
		if (BioWebUtils.isViewEnabled(Constants.AdductorLongusMusclesRef, properties)) {
			body +=  adductorLongusMuscles.getX3D(true);	
		}
		if (BioWebUtils.isViewEnabled(Constants.AdductorBrevisMusclesRef, properties)) {
			body +=  adductorBrevisMuscles.getX3D(true);	
		}
		if (BioWebUtils.isViewEnabled(Constants.AdductorMagnusMusclesRef, properties)) {
			body +=  adductorMagnusMuscles.getX3D(true);	
		}
		if (BioWebUtils.isViewEnabled(Constants. PlatysmaMusclesRef, properties)) {
			body +=  platysmaMuscles.getX3D(true);	
		}
		if (BioWebUtils.isViewEnabled(Constants.TrapeziusMusclesRef, properties)) {
			body +=  trapeziusMuscles.getX3D(true);
		}
		
		System.out.println("Done with All muscles  movin on");
		
		/*****
			  * LongissimusCapitasMuscles
			 longissimusCervicisMuscles.getX3D(true);
	
			 longRotatorsMuscle.getX3D(true) +
			 platysmaMuscle.getX3D(true) +
			 trapeziusMuscle.getX3D(true) +
			
			// Head
			  epicraniusMuscle.getX3D(true) +	
			  frontalisMuscle.getX3D(true) +

			// ThenarMuscle thenarMuscle;
			
			// Facial
			  //auricularisAnteriorMuscle.getX3D(true) +
			  corrugatorSuperciliiMuscle.getX3D(true) +
			  levatorLabiiSuperiorisAlaequeNasiMusc.getX3D(true) +
			  levatorLabiiSuperiorisMuscle.getX3D(true) +
			// OrbicularisOculiMuscle orbicularisOculiMuscle;
			  orbicularisOrisMuscle.getX3D(true) +
			
			
			// Eyelid
		    corrugatorMuscle.getX3D(true) +
			levatorPalpebraeSuperiorisMuscle.getX3D(true) +
			// OrbicularisOculiMuscle OrbicularisOculiMuscle;
			superiorisMuscle.getX3D(true) +
			
			
			// Eye
				if (BioWebUtils.isViewEnabled(Constants.InferiorObliqueMuscleRef, properties)) {
			`	inferiorObliqueMuscle.getX3D(true) +
			}
			
			inferiorRectusMuscle.getX3D(true) +
			lateralRectusMuscle.getX3D(true) +
			mediallRectusMuscle.getX3D(true) +
			superiorObliqueMuscle.getX3D(true) +
			superiorRectusMuscle.getX3D(true) +
			
			// Mouth
			buccinatorMuscle.getX3D(true) +
			caninusMuscle.getX3D(true) +
			depressorAnguliOrisMuscle.getX3D(true) +
		    depressorLabiiInferiorisMuscle.getX3D(true) +
			levatorAnguliOrisMuscle.getX3D(true) +
		    mentalisMuscle.getX3D(true) +
		    quadratusLabiiInferiorisMuscle.getX3D(true) +
			quadratusLabiiSuperiorisMuscle.getX3D(true) +
			risoriusMuscle.getX3D(true) +
			triangularisMuscle.getX3D(true) +
			zygomaticusMajorMuscle.getX3D(true) +
			zygomaticusMinorMuscle.getX3D(true) +
			zygomaticusMuscle.getX3D(true) +
			
			// Masstication
			masseterMuscle.getX3D(true) +
			pterygoideusExternusMuscle.getX3D(true) +
			pterygoideusInternusMuscle.getX3D(true) +
			temporalisMuscle.getX3D(true) +
			
			// Tongue
			inferiorLongitudinalMuscle.getX3D(true) +
			superiorLongitudinalMuscle.getX3D(true) +
			transversusMuscle.getX3D(true) +
			verticalisMuscle.getX3D(true) +
			
			// Nose
			depressorSepti.getX3D(true) +
			dilatatorNarisPosteriorMuscle.getX3D(true) +
			nasalis.getX3D(true) +
			procerusMuscle.getX3D(true) +
			
			// Neck
			anteriorScaleneMuscle.getX3D(true) +
			anteriorVeterbralMuscle.getX3D(true) +
			digastricMuscle.getX3D(true) +
			genioHyoidMuscle.getX3D(true) +
			lateralCervicleMuscle.getX3D(true) +
			mylohyoidMuscle.getX3D(true) +
			omoHyoidMuscle.getX3D(true) +
			
			// ScalenusMinimusMuscle scalenusMinimusMuscle;
			sternoHyoidMuscle.getX3D(true) +
			sternoMastoidMuscle.getX3D(true) +
			sternoThyroidMuscle.getX3D(true) +
			styloHyoidMuscle.getX3D(true) +
			superficialCervicalMuscle.getX3D(true) +
			supraInfrahyoidMuscle.getX3D(true) +
			thyroHyoidMuscle.getX3D(true) +
			scalenusAnteriorMuscle.getX3D(true) +
			scalenusMediusMuscle.getX3D(true) +
			scalenusPosteriorMuscle.getX3D(true) +
			
			
			// Anterior Vertebral Muscles
			longusCapitisMuscle.getX3D(true) +
			longusColliMuscle.getX3D(true) +
			rectusCapitisAnteriorMuscle.getX3D(true) +
			rectusCapitisLateralisMuscle.getX3D(true) +
			
				
			// Deep Muscles of the Back
			spleniusCapitisMuscle.getX3D(true) +
			spleniusCervicisMuscle.getX3D(true) +
			interTransversariiMuscle.getX3D(true) +
			rotatoresMuscle.getX3D(true) +
			sacroSpinalisMuscle.getX3D(true) +
			semiSpinalisMuscle.getX3D(true) +
			
				
			// The suboccipital muscles
			
			
			// Chest
			// CoracoBrachialisMuscle coracoBrachialisMuscle;
			intercostalesExterniMuscle.getX3D(true) +
			intercostalesInterniMuscle.getX3D(true) +
			levatoresCostarumMuscle.getX3D(true) +
			serratusPosteriorSuperiorMuscle.getX3D(true) +
			serratusPosteriorInferiorMuscle.getX3D(true) +
			subcostalisMuscle.getX3D(true) +
			transversusThoracisMuscle.getX3D(true) +
			
			// Shoulder
			deltoideusMuscle.getX3D(true) +
			subScapularisMuscle.getX3D(true) +
			supraSpinatusMuscle.getX3D(true) +
			teresMajorMuscle.getX3D(true) +
			teresMinorMuscle.getX3D(true) +
			
			// Arms
			anconeusMuscle.getX3D(true) +
			bicepsBrachiiMuscle.getX3D(true) +
			brachialisMuscle.getX3D(true) +
			tricepsBrachiiMuscle.getX3D(true) +
			brachioradialisMuscle.getX3D(true) +
			extensorCarpiRadialisBrevisMuscle.getX3D(true) +
			extensorCarpiRadialisLongusMuscle.getX3D(true) +
			extensorCarpiUlnarisMuscle.getX3D(true) +
			extensorDigitiMinimiMuscle.getX3D(true) +
			extensorDigitorumMuscle.getX3D(true) +
			extensorPollicisLongusMuscle.getX3D(true) +
			flexorCarpiRadialisMuscle.getX3D(true) +
			flexorCarpiUlnarisMuscle.getX3D(true) +
			flexorDigitorumProfundusMuscle.getX3D(true) +
			flexorDigitorumSuperficialisMuscle.getX3D(true) +
			flexorPollicisLongusMuscle.getX3D(true) +
			flexorPollicisBrevisMuscle.getX3D(true) +
			pronatorQuadratusMuscle.getX3D(true) +
			pronatorTeresMuscle.getX3D(true) +
			palmarisLongusMuscle.getX3D(true) +
			supinatorMuscle.getX3D(true) +
			
			// Hands
			abductorPollicisBrevisMuscle.getX3D(true) +
			abductorPollicisLongusMuscle.getX3D(true) +
			adductorPollicisMuscle.getX3D(true) +
			dorsalInterosseiMuscles.getX3D(true) +
			extensorPollicisBrevisMuscle.getX3D(true) +
			palmarInterosseiMuscles.getX3D(true) +
			palmarisBrevisMuscle.getX3D(true) +
			opponensDigitiMinimiMuscle.getX3D(true) +
			opponensPollicisMuscle.getX3D(true) +
			lumbricalMuscles.getX3D(true) +
			
			
			// Abdomen
			cremasterMuscle.getX3D(true) +
			obliquusExternusAbdominisMuscle.getX3D(true) +
			obliquusInternusAbdominisMuscle.getX3D(true) +
			psoasMajorMuscle.getX3D(true) +
			psoasMinorMuscle.getX3D(true) +
			pyramidalisMuscle.getX3D(true) +
			quadratusLumborumMuscle.getX3D(true) +
			rectusAdominisMuscle.getX3D(true) +
			transversusAbdominisMuscle.getX3D(true) +
			
			// Pelvis
			adductorBrevisMuscle.getX3D(true) +
			adductorMagnusMuscle.getX3D(true) +
			articularisGenusMuscle.getX3D(true) +
			gemelliMuscle.getX3D(true) +
			
			// IliacusMuscle iliacusMuscle;
			iliopsoasMuscle.getX3D(true) +
			ilotibialTractMuscle.getX3D(true) +
			inferiorGemelliMuscle.getX3D(true) +
			piriformisMuscle.getX3D(true) +
		    superiorGemelliMuscle.getX3D(true) +
			gluteusMaximusMuscle.getX3D(true) +
			coccygeusMuscle.getX3D(true) +
		
			// Muscles of the perineum
			bulboSpongiosusMuscle.getX3D(true) +
			corrugatorCutisAniMuscle.getX3D(true) +
			ischiocavernosusMuscle.getX3D(true) +
			sphincterAniExternusMuscle.getX3D(true) +
			sphincterAniInternusMuscle.getX3D(true) +
			sphincterUrethraeMembranaceaeMuscle.getX3D(true) +
			transversusPerineiProfundusMuscle.getX3D(true) +
			transversusPerineiSuperficialisMuscle.getX3D(true) +
			
			*/
			
			//************************************************************
			// Leg - Thigh
			//************************************************************
	
			
			/*
			 * 
			bicepsFemorisMuscle.getX3D(true) +
			
			 // GluteusMaximusMuscle GluteusMaximusMuscle;
			 gluteusMediusMuscle.getX3D(true) +
			 gracilisMuscle.getX3D(true) +
			 iliacusMuscle.getX3D(true) +
			 obturatorExternusMuscle.getX3D(true) +
			 obturatorInternusMuscle.getX3D(true) +
			 pectineusMuscle.getX3D(true) +
			 popliteusMuscle.getX3D(true) +
			 quadricepsFemorisMuscle.getX3D(true) +
			 rectusFemorisMuscle.getX3D(true) +
			 sartoriusMuscle.getX3D(true) +
			 semiMembranosusMuscle.getX3D(true) +
			 semiTendinosusMuscle.getX3D(true) +
			 tensorFasciaLataMuscle.getX3D(true) +
		     vastusInterMediusMuscle.getX3D(true) +
	     	 vastusLateralisMuscle.getX3D(true) +
			 vastusMedialisMuscle.getX3D(true) +
			
			
			// Leg - Cnemus
			extensorDigitorumLongusMuscle.getX3D(true) +
			extensorHallicusLongusMuscle.getX3D(true) +
			flexorDigitorumLongusMuscle.getX3D(true) +
			flexorHallicusLongusMuscle.getX3D(true) +
			gastrocnemiusMuscle.getX3D(true) +
			peroneusLongusMuscle.getX3D(true) +
			peroneusTertiusMuscle.getX3D(true) +
		    peroniusBrevisMuscle.getX3D(true) +
			plantarisMuscle.getX3D(true) +
			soleusMuscle.getX3D(true) +
			tibialisAnteriorMuscle.getX3D(true) +
			tibialisPosteriorMuscle.getX3D(true) +
				
			// FEET
			abductorDigitiMinimiMuscle.getX3D(true) +
			abductorHallucisMuscle.getX3D(true) +
			abductorOssisMetatarsiQuintiMuscle.getX3D(true) +
			adductorHallucisMuscle.getX3D(true) +
			dorsalInterosseiMuscle.getX3D(true) +
			extensorDigitorumBrevisMuscle.getX3D(true) +
			extensorHallucisBrevisMuscle.getX3D(true) +
			flexorDigitiMinimiBrevis.getX3D(true) +
			flexorDigitorumBrevisMuscle.getX3D(true) +
			flexorHallucisBrevisMuscle.getX3D(true) +
			interosselMuscle.getX3D(true) +
			lumbriclesMuscle.getX3D(true) +
			plantarInterosseiMuscle.getX3D(true) +
			quadratusPlantaeMuscle.getX3D(true)
			********/

			
		//System.out.println("MuscularSystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	


	
	public void setMuscleDensity(float muscleDensity)
	{
		
	}
		

	public void setFatigue()
	{
		
	}


	public void flex()
	{
		
	}
	
	public void relax()
	{
		
	}	
	

	public AbductorPollicisBrevisMuscle getAbductorPollicisBrevisMuscle() {
		return abductorPollicisBrevisMuscle;
	}

	public void setAbductorPollicisBrevisMuscle(
			AbductorPollicisBrevisMuscle abductorPollicisBrevisMuscle) {
		this.abductorPollicisBrevisMuscle = abductorPollicisBrevisMuscle;
	}

	
}
  