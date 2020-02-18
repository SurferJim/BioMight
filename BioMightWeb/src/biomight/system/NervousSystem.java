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
import biomight.body.brain.*;
import biomight.body.brain.rhombencephalon.metencephalon.pons.Pons;
import biomight.body.brain.rhombencephalon.myelencephalon.MedullaOblongata;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.nervous.nerves.*;
import biomight.system.nervous.nerves.cranial.*;
import biomight.system.nervous.nerves.cervicalspinal.*;
import biomight.system.nervous.nerves.head.*;
import biomight.system.nervous.nerves.head.ear.*;
import biomight.system.nervous.nerves.leg.thigh.*;
import biomight.system.nervous.nerves.leg.cnemus.*;
import biomight.system.nervous.nerves.hypogastricplexus.*;
import biomight.system.nervous.nerves.spinal.thoracic.*;
import biomight.system.nervous.nerves.sympathetic.cephalic.*;
import biomight.system.nervous.nerves.neck.*;
import biomight.system.nervous.nerves.shoulder.*;
import biomight.system.nervous.nerves.spinal.lumbarplexus.*;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class NervousSystem extends BioMightBase {
	private ArrayList<BioMightPropertyView> localBioMightProperties;
	
	private CoccygealNerve coccygealNerve;
	
	// Head
	private Brain brain;
	private Pons pons;
	private MedullaOblongata medullaOblongata;
	
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
	private OpticNerve opticNerve;
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
	
	// Neck
	private SuperficialCervicalNerve superficialCervicalNerve;
	
	// Thoracic Nerve
	private AnteriorBranches anteriorBranches;
	private GreaterSplanchnicNerve greaterSplanchnicNerve;
	private InterCostalNerves interCostalNerves;
	private InterCostoBrachialNerve interCostoBrachialNerve;
	private LateralCutaneousBranches lateralCutaneousBranches;
	private LesserSplanchnicNerve lesserSplanchnicNerve;
	private LowestSplanchnicNerve lowestSplanchnicNerve;
	private PosteriorBranches posteriorBranches;
	private RamiCutaneiLaterales ramiCutaneiLaterales;
	private ThoracicNerveT1 thoracicNerveT1;
	private ThoracicNerveT2 ThoracicNerveT2;
	private ThoracicNerveT3 ThoracicNerveT3;
	private ThoracicNerveT4 ThoracicNerveT4;
	private ThoracicNerveT5 ThoracicNerveT5;
	private ThoracicNerveT6 ThoracicNerveT6;
	private ThoracicNerveT7 ThoracicNerveT7;
	private ThoracicNerveT8 ThoracicNerveT8;
	private ThoracicNerveT9 ThoracicNerveT9;
	private ThoracicNerveT10 ThoracicNerveT10;
	private ThoracicNerveT11 ThoracicNerveT11;
	
	// Cephalic
	private Caroticotympanic Caroticotympanic;
	private CarotidInternalNerve CarotidInternalNerve;
	private CarotidInternalPlexus carotidInternalPlexus;
	private CavernousPlexus CavernousPlexus;
	private DeepPetrosal DeepPetrosal;
	
	
	private SomaticMotorFibers somaticMotorFibers;
	private SympatheticEfferentFibers sympatheticEfferentFibers;
	private SuperiorGanglion superiorGanglion;
	private LumbarGanglia lumbarGanglia;
	private PhrenicGanglion PhrenicGanglion;
	private CeliacGanglion celiacGanglion;
	private UpperSacralGanglion upperSacralGanglion;
	private UpperLumbarGanglion upperLumbarGanglion;
	private LowestThoracicGanglion lowestThoracicGanglion;
	private InferiorMesentericGanglion InferiorMesentericGanglion;
	private DiaphragmaticGanglion diaphragmaticGanglion;
	private AorticorRenalGanglion aorticorRenalGanglion;
	
	private HypogastricPlexus hypogastricPlexus;
	private MiddleHemorrhoidalPlexus middleHemorrhoidalPlexus;
	private UterinePlexus uterinePlexus;
	private VaginalPlexus vaginalPlexus;
	private VesicalPlexus vesicalPlexus;
	
	// Lumbar Plexis
	private LumbarPlexis lumbarPlexis;
	private GenitoFemoralNerve genitoFemoralNerve;
	private IlioHypoGastricNerve ilioHypoGastricNerve;
	private IlioinguinalNerve ilioinguinalNerve;
	private LateralFemoralCutaneousNerve lateralFemoralCutaneousNerve;
	
	private SympatheticTrunk symatheticTrunk;
	
	private VidianNerve vidianNerve;
	private PudendalNerve pudendalNerve;
	private SciaticNerve sciaticNerve;
	
	// Leg
	private FemoralNerve femoralNerve;
	private ObturatorNerve ObturatorNerve;
	private SuperiorGlutealNerve superiorGlutealNerve;
	private TibialNerve tibialNerve;
	
	
	// Foot
	

	/***************************************************************
	 * Constructors 
	 * 
	 **************************************************************/

	public NervousSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.NervousSystemRef, null, null);
	}

	public NervousSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public NervousSystem(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public NervousSystem(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/NervousSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		localBioMightProperties	 = bioMightProperties;
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NervousSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NervousSystemRef, parentID);
			System.out.println("Have NervousSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - NervousSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Run through the collection of NervousSystems and build them into the model
		// In the default case, we get one instance of the NervousSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("NervousSystem NumTransforms: " + transforms.size());

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		boolean bStored = false;
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="NervousSystem.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created NervousSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			
			System.out.println("Creating the Brain for ParentID: " + bioMightTransform.getId());
			brain = new Brain(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			BioMightGenerate generatedBrain = brain.getBioMightGenerate(); 
			initProperty(Constants.BrainRef, Constants.Brain, Constants.BrainRef, brain.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BrainRef, localBioMightProperties));								
			System.out.println("Created the Brain");

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
	
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateNervousSystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING NervousSystem METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
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
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		BioMightPropertyView property;
		
		// Head
		property = new BioMightPropertyView();
		property.setPropertyName("Head");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Brain");
		property.setCanonicalName(Constants.Brain);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CoccygealNerve");
		property.setCanonicalName(Constants.CoccygealNerve);
		properties.add(property);
		
		
		property = new BioMightPropertyView();
		property.setPropertyName("BuccalNerve");
		property.setCanonicalName(Constants.BuccalNerve);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ChordaTympaniNerve");
		property.setCanonicalName(Constants.ChordaTympaniNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongCiliaryNerve");
		property.setCanonicalName(Constants.LongCiliaryNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ShortCiliaryNerve");
		property.setCanonicalName(Constants.ShortCiliaryNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AuditoryNerve");
		property.setCanonicalName(Constants.AuditoryNerve);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CochlearNerve");
		property.setCanonicalName(Constants.CochlearNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VestibularNerve");
		property.setCanonicalName(Constants.VestibularNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AbducentNerve");
		property.setCanonicalName(Constants.AbducentNerve);
		properties.add(property);

		// Cranial
		property = new BioMightPropertyView();
		property.setPropertyName("Cranial");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AccessoryNerve");
		property.setCanonicalName(Constants.AccessoryNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AcousticNerve");
		property.setCanonicalName(Constants.AcousticNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("FacialNerve");
		property.setCanonicalName(Constants.FacialNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GlossopharyngealNerve");
		property.setCanonicalName(Constants.GlossopharyngealNerve);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("HypoglossalNerve");
		property.setCanonicalName(Constants.HypoglossalNerve);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("OculomotorNerve");
		property.setCanonicalName(Constants.OculomotorNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("OlfactoryNerve");
		property.setCanonicalName(Constants.OlfactoryNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("OpticNerve");
		property.setCanonicalName(Constants.OpticNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TrigeminalNerve");
		property.setCanonicalName(Constants.TrigeminalNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TrochlearNerve");
		property.setCanonicalName(Constants.TrochlearNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VagusNerve");
		property.setCanonicalName(Constants.VagusNerve);
		properties.add(property);

		// Cervical Spinal
		property = new BioMightPropertyView();
		property.setPropertyName("Cervical Spinal");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreatAuricularNerve");
		property.setCanonicalName(Constants.GreatAuricularNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreatOccipitalNerve");
		property.setCanonicalName(Constants.GreatOccipitalNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LesserOccipitalNerve");
		property.setCanonicalName(Constants.LesserOccipitalNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PhrenicNerve");
		property.setCanonicalName(Constants.PhrenicNerve);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorAuricularNerve");
		property.setCanonicalName(Constants.PosteriorAuricularNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubOccipitalNerve");
		property.setCanonicalName(Constants.SubOccipitalNerve);
		properties.add(property);

		// Neck
		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.Neck);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialCervicalNerve");
		property.setCanonicalName(Constants.SuperficialCervicalNerve);
		properties.add(property);
		
		// Thoracic
		property = new BioMightPropertyView();
		property.setPropertyName("Thoracic");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorBranches");
		property.setCanonicalName(Constants.AnteriorBranches);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreaterSplanchnicNerve");
		property.setCanonicalName(Constants.GreaterSplanchnicNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterCostalNerves");
		property.setCanonicalName(Constants.InterCostalNerves);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("InterCostoBrachialNerve");
		property.setCanonicalName(Constants.InterCostoBrachialNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralCutaneousBranches");
		property.setCanonicalName(Constants.LateralCutaneousBranches);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LesserSplanchnicNerve");
		property.setCanonicalName(Constants.LesserSplanchnicNerve);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("LowestSplanchnicNerve");
		property.setCanonicalName(Constants.LowestSplanchnicNerve);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorBranches");
		property.setCanonicalName(Constants.PosteriorBranches);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RamiCutaneiLaterales");
		property.setCanonicalName(Constants.RamiCutaneiLaterales);
		properties.add(property);

		// Cephalic
		property = new BioMightPropertyView();
		property.setPropertyName("Cephalic");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Caroticotympanic");
		property.setCanonicalName(Constants.Caroticotympanic);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarotidInternalNerve");
		property.setCanonicalName(Constants.CarotidInternalNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarotidInternalPlexus");
		property.setCanonicalName(Constants.CarotidInternalPlexus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CavernousPlexus");
		property.setCanonicalName(Constants.CavernousPlexus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DeepPetrosal");
		property.setCanonicalName(Constants.DeepPetrosal);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SomaticMotorFibers");
		property.setCanonicalName(Constants.SomaticMotorFibers);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SympatheticEfferentFibers");
		property.setCanonicalName(Constants.SympatheticEfferentFibers);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorGanglion");
		property.setCanonicalName(Constants.SuperiorGanglion);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LumbarGanglia");
		property.setCanonicalName(Constants.LumbarGanglia);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PhrenicGanglion");
		property.setCanonicalName(Constants.PhrenicGanglion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CeliacGanglion");
		property.setCanonicalName(Constants.CeliacGanglion);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("UpperSacralGanglion");
		property.setCanonicalName(Constants.UpperSacralGanglion);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("UpperLumbarGanglion");
		property.setCanonicalName(Constants.UpperLumbarGanglion);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LowestThoracicGanglion");
		property.setCanonicalName(Constants.LowestThoracicGanglion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorMesentericGanglion");
		property.setCanonicalName(Constants.InferiorMesentericGanglion);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DiaphragmaticGanglion");
		property.setCanonicalName(Constants.DiaphragmaticGanglion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HypogastricPlexus");
		property.setCanonicalName(Constants.HypogastricPlexus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MiddleHemorrhoidalPlexus");
		property.setCanonicalName(Constants.MiddleHemorrhoidalPlexus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("UterinePlexus");
		property.setCanonicalName(Constants.UterinePlexus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("VaginalPlexus");
		property.setCanonicalName(Constants.VaginalPlexus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VesicalPlexus");
		property.setCanonicalName(Constants.VesicalPlexus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LumbarPlexis");
		property.setCanonicalName(Constants.LumbarPlexis);
		properties.add(property);

		// Lumbar Plexis
		property = new BioMightPropertyView();
		property.setPropertyName("Lumbar Plexus");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GenitoFemoralNerve");
		property.setCanonicalName(Constants.GenitoFemoralNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IlioHypoGastricNerve");
		property.setCanonicalName(Constants.IlioHypoGastricNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IlioinguinalNerve");
		property.setCanonicalName(Constants.IlioinguinalNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralFemoralCutaneousNerve");
		property.setCanonicalName(Constants.LateralFemoralCutaneousNerve);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SympatheticTrunk");
		property.setCanonicalName(Constants.SympatheticTrunk);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("VidianNerve");
		property.setCanonicalName(Constants.VidianNerve);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("PudendalNerve");
		property.setCanonicalName(Constants.PudendalNerve);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("SciaticNerve");
		property.setCanonicalName(Constants.SciaticNerve);
		properties.add(property);		
		
		// Leg
		property = new BioMightPropertyView();
		property.setPropertyName("Leg");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("FemoralNerve");
		property.setCanonicalName(Constants.FemoralNerve);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("ObturatorNerve");
		property.setCanonicalName(Constants.ObturatorNerve);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorGlutealNerve");
		property.setCanonicalName(Constants.SuperiorGlutealNerve);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("TibialNerve");
		property.setCanonicalName(Constants.TibialNerve);
		properties.add(property);		
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Breathe");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Inhale");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Exhale");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Capacity");
		method.setHtmlType("text");
		methods.add(method);
		
		return methods;
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='NervousSystem.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='NervousSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
				brain.getX3D(true) + 
				pons.getX3D(true) + 
				medullaOblongata.getX3D(true); 
		
		//System.out.println("NervousSystem X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setDopaLevel()
	{
	}
	
	public void setAcetylCholineLevel()
	{
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

	public AnteriorBranches getAnteriorBranches() {
		return anteriorBranches;
	}

	public void setAnteriorBranches(AnteriorBranches anteriorBranches) {
		this.anteriorBranches = anteriorBranches;
	}

	public AorticorRenalGanglion getAorticorRenalGanglion() {
		return aorticorRenalGanglion;
	}

	public void setAorticorRenalGanglion(AorticorRenalGanglion aorticorRenalGanglion) {
		this.aorticorRenalGanglion = aorticorRenalGanglion;
	}

	public AuditoryNerve getAuditoryNerve() {
		return auditoryNerve;
	}

	public void setAuditoryNerve(AuditoryNerve auditoryNerve) {
		this.auditoryNerve = auditoryNerve;
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

	public Caroticotympanic getCaroticotympanic() {
		return Caroticotympanic;
	}

	public void setCaroticotympanic(Caroticotympanic caroticotympanic) {
		Caroticotympanic = caroticotympanic;
	}

	public CarotidInternalNerve getCarotidInternalNerve() {
		return CarotidInternalNerve;
	}

	public void setCarotidInternalNerve(CarotidInternalNerve carotidInternalNerve) {
		CarotidInternalNerve = carotidInternalNerve;
	}

	public CarotidInternalPlexus getCarotidInternalPlexus() {
		return carotidInternalPlexus;
	}

	public void setCarotidInternalPlexus(CarotidInternalPlexus carotidInternalPlexus) {
		this.carotidInternalPlexus = carotidInternalPlexus;
	}

	public CavernousPlexus getCavernousPlexus() {
		return CavernousPlexus;
	}

	public void setCavernousPlexus(CavernousPlexus cavernousPlexus) {
		CavernousPlexus = cavernousPlexus;
	}

	public CeliacGanglion getCeliacGanglion() {
		return celiacGanglion;
	}

	public void setCeliacGanglion(CeliacGanglion celiacGanglion) {
		this.celiacGanglion = celiacGanglion;
	}

	public ChordaTympaniNerve getChordaTympaniNerve() {
		return ChordaTympaniNerve;
	}

	public void setChordaTympaniNerve(ChordaTympaniNerve chordaTympaniNerve) {
		ChordaTympaniNerve = chordaTympaniNerve;
	}

	public CoccygealNerve getCoccygealNerve() {
		return coccygealNerve;
	}

	public void setCoccygealNerve(CoccygealNerve coccygealNerve) {
		this.coccygealNerve = coccygealNerve;
	}

	public CochlearNerve getCochlearNerve() {
		return cochlearNerve;
	}

	public void setCochlearNerve(CochlearNerve cochlearNerve) {
		this.cochlearNerve = cochlearNerve;
	}

	public DeepPetrosal getDeepPetrosal() {
		return DeepPetrosal;
	}

	public void setDeepPetrosal(DeepPetrosal deepPetrosal) {
		DeepPetrosal = deepPetrosal;
	}

	public DiaphragmaticGanglion getDiaphragmaticGanglion() {
		return diaphragmaticGanglion;
	}

	public void setDiaphragmaticGanglion(DiaphragmaticGanglion diaphragmaticGanglion) {
		this.diaphragmaticGanglion = diaphragmaticGanglion;
	}

	public FacialNerve getFacialNerve() {
		return facialNerve;
	}

	public void setFacialNerve(FacialNerve facialNerve) {
		this.facialNerve = facialNerve;
	}

	public FemoralNerve getFemoralNerve() {
		return femoralNerve;
	}

	public void setFemoralNerve(FemoralNerve femoralNerve) {
		this.femoralNerve = femoralNerve;
	}

	public GenitoFemoralNerve getGenitoFemoralNerve() {
		return genitoFemoralNerve;
	}

	public void setGenitoFemoralNerve(GenitoFemoralNerve genitoFemoralNerve) {
		this.genitoFemoralNerve = genitoFemoralNerve;
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

	public GreaterSplanchnicNerve getGreaterSplanchnicNerve() {
		return greaterSplanchnicNerve;
	}

	public void setGreaterSplanchnicNerve(
			GreaterSplanchnicNerve greaterSplanchnicNerve) {
		this.greaterSplanchnicNerve = greaterSplanchnicNerve;
	}

	public GreatOccipitalNerve getGreatOccipitalNerve() {
		return greatOccipitalNerve;
	}

	public void setGreatOccipitalNerve(GreatOccipitalNerve greatOccipitalNerve) {
		this.greatOccipitalNerve = greatOccipitalNerve;
	}

	public HypogastricPlexus getHypogastricPlexus() {
		return hypogastricPlexus;
	}

	public void setHypogastricPlexus(HypogastricPlexus hypogastricPlexus) {
		this.hypogastricPlexus = hypogastricPlexus;
	}

	public HypoglossalNerve getHypoglossalNerve() {
		return hypoglossalNerve;
	}

	public void setHypoglossalNerve(HypoglossalNerve hypoglossalNerve) {
		this.hypoglossalNerve = hypoglossalNerve;
	}

	public IlioHypoGastricNerve getIlioHypoGastricNerve() {
		return ilioHypoGastricNerve;
	}

	public void setIlioHypoGastricNerve(IlioHypoGastricNerve ilioHypoGastricNerve) {
		this.ilioHypoGastricNerve = ilioHypoGastricNerve;
	}

	public IlioinguinalNerve getIlioinguinalNerve() {
		return ilioinguinalNerve;
	}

	public void setIlioinguinalNerve(IlioinguinalNerve ilioinguinalNerve) {
		this.ilioinguinalNerve = ilioinguinalNerve;
	}

	public InferiorMesentericGanglion getInferiorMesentericGanglion() {
		return InferiorMesentericGanglion;
	}

	public void setInferiorMesentericGanglion(
			InferiorMesentericGanglion inferiorMesentericGanglion) {
		InferiorMesentericGanglion = inferiorMesentericGanglion;
	}

	public InterCostalNerves getInterCostalNerves() {
		return interCostalNerves;
	}

	public void setInterCostalNerves(InterCostalNerves interCostalNerves) {
		this.interCostalNerves = interCostalNerves;
	}

	public InterCostoBrachialNerve getInterCostoBrachialNerve() {
		return interCostoBrachialNerve;
	}

	public void setInterCostoBrachialNerve(
			InterCostoBrachialNerve interCostoBrachialNerve) {
		this.interCostoBrachialNerve = interCostoBrachialNerve;
	}

	public LateralCutaneousBranches getLateralCutaneousBranches() {
		return lateralCutaneousBranches;
	}

	public void setLateralCutaneousBranches(
			LateralCutaneousBranches lateralCutaneousBranches) {
		this.lateralCutaneousBranches = lateralCutaneousBranches;
	}

	public LateralFemoralCutaneousNerve getLateralFemoralCutaneousNerve() {
		return lateralFemoralCutaneousNerve;
	}

	public void setLateralFemoralCutaneousNerve(
			LateralFemoralCutaneousNerve lateralFemoralCutaneousNerve) {
		this.lateralFemoralCutaneousNerve = lateralFemoralCutaneousNerve;
	}

	public LesserOccipitalNerve getLesserOccipitalNerve() {
		return lesserOccipitalNerve;
	}

	public void setLesserOccipitalNerve(LesserOccipitalNerve lesserOccipitalNerve) {
		this.lesserOccipitalNerve = lesserOccipitalNerve;
	}

	public LesserSplanchnicNerve getLesserSplanchnicNerve() {
		return lesserSplanchnicNerve;
	}

	public void setLesserSplanchnicNerve(LesserSplanchnicNerve lesserSplanchnicNerve) {
		this.lesserSplanchnicNerve = lesserSplanchnicNerve;
	}

	public LongCiliaryNerve getLongCiliaryNerve() {
		return longCiliaryNerve;
	}

	public void setLongCiliaryNerve(LongCiliaryNerve longCiliaryNerve) {
		this.longCiliaryNerve = longCiliaryNerve;
	}

	public LowestSplanchnicNerve getLowestSplanchnicNerve() {
		return lowestSplanchnicNerve;
	}

	public void setLowestSplanchnicNerve(LowestSplanchnicNerve lowestSplanchnicNerve) {
		this.lowestSplanchnicNerve = lowestSplanchnicNerve;
	}

	public LowestThoracicGanglion getLowestThoracicGanglion() {
		return lowestThoracicGanglion;
	}

	public void setLowestThoracicGanglion(
			LowestThoracicGanglion lowestThoracicGanglion) {
		this.lowestThoracicGanglion = lowestThoracicGanglion;
	}

	public LumbarGanglia getLumbarGanglia() {
		return lumbarGanglia;
	}

	public void setLumbarGanglia(LumbarGanglia lumbarGanglia) {
		this.lumbarGanglia = lumbarGanglia;
	}

	public LumbarPlexis getLumbarPlexis() {
		return lumbarPlexis;
	}

	public void setLumbarPlexis(LumbarPlexis lumbarPlexis) {
		this.lumbarPlexis = lumbarPlexis;
	}

	public MiddleHemorrhoidalPlexus getMiddleHemorrhoidalPlexus() {
		return middleHemorrhoidalPlexus;
	}

	public void setMiddleHemorrhoidalPlexus(
			MiddleHemorrhoidalPlexus middleHemorrhoidalPlexus) {
		this.middleHemorrhoidalPlexus = middleHemorrhoidalPlexus;
	}

	public ObturatorNerve getObturatorNerve() {
		return ObturatorNerve;
	}

	public void setObturatorNerve(ObturatorNerve obturatorNerve) {
		ObturatorNerve = obturatorNerve;
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

	public OpticNerve getOpticNerve() {
		return opticNerve;
	}

	public void setOpticNerve(OpticNerve opticNerve) {
		this.opticNerve = opticNerve;
	}

	public PhrenicGanglion getPhrenicGanglion() {
		return PhrenicGanglion;
	}

	public void setPhrenicGanglion(PhrenicGanglion phrenicGanglion) {
		PhrenicGanglion = phrenicGanglion;
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

	public PosteriorBranches getPosteriorBranches() {
		return posteriorBranches;
	}

	public void setPosteriorBranches(PosteriorBranches posteriorBranches) {
		this.posteriorBranches = posteriorBranches;
	}

	public PudendalNerve getPudendalNerve() {
		return pudendalNerve;
	}

	public void setPudendalNerve(PudendalNerve pudendalNerve) {
		this.pudendalNerve = pudendalNerve;
	}

	public RamiCutaneiLaterales getRamiCutaneiLaterales() {
		return ramiCutaneiLaterales;
	}

	public void setRamiCutaneiLaterales(RamiCutaneiLaterales ramiCutaneiLaterales) {
		this.ramiCutaneiLaterales = ramiCutaneiLaterales;
	}

	public SciaticNerve getSciaticNerve() {
		return sciaticNerve;
	}

	public void setSciaticNerve(SciaticNerve sciaticNerve) {
		this.sciaticNerve = sciaticNerve;
	}

	public ShortCiliaryNerve getShortCiliaryNerve() {
		return shortCiliaryNerve;
	}

	public void setShortCiliaryNerve(ShortCiliaryNerve shortCiliaryNerve) {
		this.shortCiliaryNerve = shortCiliaryNerve;
	}

	public SomaticMotorFibers getSomaticMotorFibers() {
		return somaticMotorFibers;
	}

	public void setSomaticMotorFibers(SomaticMotorFibers somaticMotorFibers) {
		this.somaticMotorFibers = somaticMotorFibers;
	}

	public SubOccipitalNerve getSubOccipitalNerve() {
		return subOccipitalNerve;
	}

	public void setSubOccipitalNerve(SubOccipitalNerve subOccipitalNerve) {
		this.subOccipitalNerve = subOccipitalNerve;
	}

	public SuperficialCervicalNerve getSuperficialCervicalNerve() {
		return superficialCervicalNerve;
	}

	public void setSuperficialCervicalNerve(
			SuperficialCervicalNerve superficialCervicalNerve) {
		this.superficialCervicalNerve = superficialCervicalNerve;
	}

	public SuperiorGanglion getSuperiorGanglion() {
		return superiorGanglion;
	}

	public void setSuperiorGanglion(SuperiorGanglion superiorGanglion) {
		this.superiorGanglion = superiorGanglion;
	}

	public SuperiorGlutealNerve getSuperiorGlutealNerve() {
		return superiorGlutealNerve;
	}

	public void setSuperiorGlutealNerve(SuperiorGlutealNerve superiorGlutealNerve) {
		this.superiorGlutealNerve = superiorGlutealNerve;
	}

	public SympatheticTrunk getSymatheticTrunk() {
		return symatheticTrunk;
	}

	public void setSymatheticTrunk(SympatheticTrunk symatheticTrunk) {
		this.symatheticTrunk = symatheticTrunk;
	}

	public SympatheticEfferentFibers getSympatheticEfferentFibers() {
		return sympatheticEfferentFibers;
	}

	public void setSympatheticEfferentFibers(
			SympatheticEfferentFibers sympatheticEfferentFibers) {
		this.sympatheticEfferentFibers = sympatheticEfferentFibers;
	}

	public ThoracicNerveT1 getThoracicNerveT1() {
		return thoracicNerveT1;
	}

	public void setThoracicNerveT1(ThoracicNerveT1 thoracicNerveT1) {
		this.thoracicNerveT1 = thoracicNerveT1;
	}

	public ThoracicNerveT10 getThoracicNerveT10() {
		return ThoracicNerveT10;
	}

	public void setThoracicNerveT10(ThoracicNerveT10 thoracicNerveT10) {
		ThoracicNerveT10 = thoracicNerveT10;
	}

	public ThoracicNerveT11 getThoracicNerveT11() {
		return ThoracicNerveT11;
	}

	public void setThoracicNerveT11(ThoracicNerveT11 thoracicNerveT11) {
		ThoracicNerveT11 = thoracicNerveT11;
	}

	public ThoracicNerveT2 getThoracicNerveT2() {
		return ThoracicNerveT2;
	}

	public void setThoracicNerveT2(ThoracicNerveT2 thoracicNerveT2) {
		ThoracicNerveT2 = thoracicNerveT2;
	}

	public ThoracicNerveT3 getThoracicNerveT3() {
		return ThoracicNerveT3;
	}

	public void setThoracicNerveT3(ThoracicNerveT3 thoracicNerveT3) {
		ThoracicNerveT3 = thoracicNerveT3;
	}

	public ThoracicNerveT4 getThoracicNerveT4() {
		return ThoracicNerveT4;
	}

	public void setThoracicNerveT4(ThoracicNerveT4 thoracicNerveT4) {
		ThoracicNerveT4 = thoracicNerveT4;
	}

	public ThoracicNerveT5 getThoracicNerveT5() {
		return ThoracicNerveT5;
	}

	public void setThoracicNerveT5(ThoracicNerveT5 thoracicNerveT5) {
		ThoracicNerveT5 = thoracicNerveT5;
	}

	public ThoracicNerveT6 getThoracicNerveT6() {
		return ThoracicNerveT6;
	}

	public void setThoracicNerveT6(ThoracicNerveT6 thoracicNerveT6) {
		ThoracicNerveT6 = thoracicNerveT6;
	}

	public ThoracicNerveT7 getThoracicNerveT7() {
		return ThoracicNerveT7;
	}

	public void setThoracicNerveT7(ThoracicNerveT7 thoracicNerveT7) {
		ThoracicNerveT7 = thoracicNerveT7;
	}

	public ThoracicNerveT8 getThoracicNerveT8() {
		return ThoracicNerveT8;
	}

	public void setThoracicNerveT8(ThoracicNerveT8 thoracicNerveT8) {
		ThoracicNerveT8 = thoracicNerveT8;
	}

	public ThoracicNerveT9 getThoracicNerveT9() {
		return ThoracicNerveT9;
	}

	public void setThoracicNerveT9(ThoracicNerveT9 thoracicNerveT9) {
		ThoracicNerveT9 = thoracicNerveT9;
	}

	public TibialNerve getTibialNerve() {
		return tibialNerve;
	}

	public void setTibialNerve(TibialNerve tibialNerve) {
		this.tibialNerve = tibialNerve;
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

	public UpperLumbarGanglion getUpperLumbarGanglion() {
		return upperLumbarGanglion;
	}

	public void setUpperLumbarGanglion(UpperLumbarGanglion upperLumbarGanglion) {
		this.upperLumbarGanglion = upperLumbarGanglion;
	}

	public UpperSacralGanglion getUpperSacralGanglion() {
		return upperSacralGanglion;
	}

	public void setUpperSacralGanglion(UpperSacralGanglion upperSacralGanglion) {
		this.upperSacralGanglion = upperSacralGanglion;
	}

	public UterinePlexus getUterinePlexus() {
		return uterinePlexus;
	}

	public void setUterinePlexus(UterinePlexus uterinePlexus) {
		this.uterinePlexus = uterinePlexus;
	}

	public VaginalPlexus getVaginalPlexus() {
		return vaginalPlexus;
	}

	public void setVaginalPlexus(VaginalPlexus vaginalPlexus) {
		this.vaginalPlexus = vaginalPlexus;
	}

	public VagusNerve getVagusNerve() {
		return vagusNerve;
	}

	public void setVagusNerve(VagusNerve vagusNerve) {
		this.vagusNerve = vagusNerve;
	}

	public VesicalPlexus getVesicalPlexus() {
		return vesicalPlexus;
	}

	public void setVesicalPlexus(VesicalPlexus vesicalPlexus) {
		this.vesicalPlexus = vesicalPlexus;
	}

	public VestibularNerve getVestibularNerve() {
		return vestibularNerve;
	}

	public void setVestibularNerve(VestibularNerve vestibularNerve) {
		this.vestibularNerve = vestibularNerve;
	}

	public VidianNerve getVidianNerve() {
		return vidianNerve;
	}

	public void setVidianNerve(VidianNerve vidianNerve) {
		this.vidianNerve = vidianNerve;
	}
	
	
	
	
}
