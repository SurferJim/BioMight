/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.bacteria.cocci.gramnegative.Gonococci;
import biomight.bacteria.cocci.gramnegative.Meningococci;
import biomight.bacteria.cocci.grampositive.StaphylococcusAureus;
import biomight.bacteria.cocci.grampositive.StaphylococcusEpidermidis;
import biomight.bacteria.cocci.grampositive.StaphylococcusSaprophyticus;
import biomight.bacteria.cocci.grampositive.StreptococcusAgalactiae;
import biomight.bacteria.cocci.grampositive.StreptococcusAnginosus;
import biomight.bacteria.cocci.grampositive.StreptococcusSanguinis;
import biomight.bacteria.cocci.grampositive.StreptococcusBovis;
import biomight.bacteria.cocci.grampositive.StreptococcusFaecalis;
import biomight.bacteria.cocci.grampositive.StreptococcusGordoni;
import biomight.bacteria.cocci.grampositive.StreptococcusIntermedius;
import biomight.bacteria.cocci.grampositive.StreptococcusMitis;
import biomight.bacteria.cocci.grampositive.StreptococcusMutans;
import biomight.bacteria.cocci.grampositive.StreptococciPneumoniae;
import biomight.bacteria.cocci.grampositive.StreptococcusPyogenes;
import biomight.bacteria.cocci.grampositive.StreptococcusSalivarius;
import biomight.bacteria.cocci.grampositive.StreptococcusViridans;
import biomight.bacteria.coccobacillus.gramnegative.BordetellaPertussises;
import biomight.bacteria.misc.Achromobacter;
import biomight.bacteria.misc.AcinetobacterBaumannii;
import biomight.bacteria.misc.Actinobacillus;
import biomight.bacteria.misc.Aeromonas;
import biomight.bacteria.misc.Alcaligenes;
import biomight.bacteria.misc.ArizonaHinshawii;
import biomight.bacteria.misc.CoxiellaBurnetii;
import biomight.bacteria.misc.ErysipelothrixRhusiopathiae;
import biomight.bacteria.misc.KlebsiellaPneumoniae;
import biomight.bacteria.misc.LegionellaPneumophila;
import biomight.bacteria.misc.LeptospiraInterrogans;
import biomight.bacteria.misc.OrientiaTsutsugamushi;
import biomight.bacteria.misc.PorphyromonasGingivalis;
import biomight.bacteria.misc.PseudomonasPseudomallei;
import biomight.bacteria.misc.RhodococcusEqui;
import biomight.bacteria.misc.RickettsiaProwazekii;
import biomight.bacteria.misc.RickettsiaRickettsii;
import biomight.bacteria.misc.TropherymaWhippelii;
import biomight.bacteria.misc.YersinaOuterProteins;
import biomight.bacteria.misc.YersiniaEnterocolitica;
import biomight.bacteria.misc.YersiniaPestis;
import biomight.bacteria.misc.YersiniaPseudoTuberculosis;
import biomight.bacteria.misc.YopJ;
import biomight.bacteria.pleomorphic.gramnegative.FrancisellaTularensis;
import biomight.bacteria.pleomorphic.gramnegative.HaemophilusInfluenzae;
import biomight.bacteria.pleomorphic.grampositive.ActinomycesGerencseriae;
import biomight.bacteria.pleomorphic.grampositive.ActinomycesIsraelii;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumAviumIntracellulareComplex;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumBovis;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumKansasii;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumLeprae;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumMarinum;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumTuberculosis;
import biomight.bacteria.pleomorphic.grampositive.PropioniBacteriumPropionicus;
import biomight.bacteria.rods.gramnegative.AeromonasHydrophilias;
import biomight.bacteria.rods.gramnegative.AlcaligenesFaecalis;
import biomight.bacteria.rods.gramnegative.ArachniaPropionica;
import biomight.bacteria.rods.gramnegative.EColiStrain0157H7;
import biomight.bacteria.rods.gramnegative.EscherichiaColi;
import biomight.bacteria.rods.gramnegative.PasteurellaMulticoda;
import biomight.bacteria.rods.gramnegative.PseudomonasAeruginosa;
import biomight.bacteria.rods.gramnegative.SalmonellaEnteritidis;
import biomight.bacteria.rods.gramnegative.Shigella;
import biomight.bacteria.rods.gramnegative.ShigellaDysenteriae;
import biomight.bacteria.rods.gramnegative.VibrioCholerae;
import biomight.bacteria.rods.gramnegative.VibrioCholeraes;
import biomight.bacteria.rods.gramnegative.VibrioParahaemolyticus;
import biomight.bacteria.rods.gramnegative.YerseniaEnterocolitica;
import biomight.bacteria.rods.grampositive.AnthraxSpore;
import biomight.bacteria.rods.grampositive.BacilliAnthracis;
import biomight.bacteria.rods.grampositive.BacillusAnthracis;
import biomight.bacteria.rods.grampositive.BacillusCereus;
import biomight.bacteria.rods.grampositive.ClostridiumBotulinum;
import biomight.bacteria.rods.grampositive.ClostridiumDifficile;
import biomight.bacteria.rods.grampositive.ClostridiumPerfringens;
import biomight.bacteria.rods.grampositive.ClostridiumTetani;
import biomight.bacteria.rods.grampositive.ClostridiumTetanis;
import biomight.bacteria.rods.grampositive.CoryneBacteriumDiphtheriae;
import biomight.bacteria.rods.grampositive.CorynebacteriumJeikeium;
import biomight.bacteria.rods.grampositive.CutaneousAnthrax;
import biomight.bacteria.rods.grampositive.GastroIntestinalAntrax;
import biomight.bacteria.rods.grampositive.ListeriaMonocytogenes;
import biomight.bacteria.rods.grampositive.PulmonaryAnthrax;
import biomight.bacteria.spirillum.CampylobacterJejuni;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;



/*******************************************************************************
 * @author SurferJim
 *
 * Representation of the Bacterias.  This allows one to drill down into the
 * various types of Bacteria.  As the number grows, these will most likely be
 * broken down by pyhla
 * 
 ********************************************************************************/

public class Bacterias extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private String componentID;
	private String parentID;
	private ArrayList colors;

	
	// Cocci
	private Gonococci gonococci;
	private Meningococci meningococci;

	  
	// Cocci - gram positive
	private StaphylococcusAureus staphylococcusAureus;
	private StaphylococcusEpidermidis staphylococcusEpidermidis;
	private StaphylococcusSaprophyticus staphylococcusSaprophyticus;
	private StreptococcusAgalactiae streptococcusAgalactiae;
	private StreptococcusAnginosus streptococcusAnginosus;
	private StreptococcusSanguinis streptococcusSanguinis;
	private StreptococcusBovis streptococcusBovis;
	private StreptococcusFaecalis streptococcusFaecalis;
	private StreptococcusGordoni streptococcusGordoni;
	private StreptococcusIntermedius streptococcusIntermedius;
	private StreptococcusMitis streptococcusMitis;
	private StreptococcusMutans streptococcusMutans;
	private StreptococciPneumoniae streptococciPneumoniae;
	private StreptococcusPyogenes streptococcusPyogenes;
	private StreptococcusSalivarius streptococcusSalivarius;
	private StreptococcusViridans streptococcusViridans;
	
	// MISC	
	private Achromobacter achromobacter;
	private AcinetobacterBaumannii acinetobacterBaumannii;
	private Actinobacillus actinobacillus;
	private Aeromonas aeromonas;
	private AeromonasHydrophilias aeromonasHydrophilias;
	private Alcaligenes alcaligenes;
	private AlcaligenesFaecalis alcaligenesFaecalis;
	private ArachniaPropionica arachniaPropionica;
	private ArizonaHinshawii arizonaHinshawii;
	private CorynebacteriumJeikeium corynebacteriumJeikeium;
	private CoxiellaBurnetii coxiellaBurnetii;
	private ErysipelothrixRhusiopathiae erysipelothrixRhusiopathiae;
	private KlebsiellaPneumoniae klebsiellaPneumoniae;
  	private LegionellaPneumophila legionellaPneumophila;
  	private LeptospiraInterrogans leptospiraInterrogans;
  	private OrientiaTsutsugamushi orientiaTsutsugamushi;
  	private PorphyromonasGingivalis porphyromonasGingivalis;
  	private PseudomonasPseudomallei pseudomonasPseudomallei;
  	private RhodococcusEqui rhodococcusEqui;
  	private RickettsiaProwazekii rickettsiaProwazekii;
  	private RickettsiaRickettsii RickettsiaRickettsii;
  	private TropherymaWhippelii tropherymaWhippelii;
  	private YersinaOuterProteins yersinaOuterProteins;
  	private YersiniaEnterocolitica yersiniaEnterocolitica;
  	private YersiniaPestis YersiniaPestis;
  	private YersiniaPseudoTuberculosis yersiniaPseudoTuberculosis;
  	private YopJ yopJ;  	
  
	// GRAM NEGATIVE PLEOMORPHIC
    private BordetellaPertussises bordetellaPertussises;
  	private FrancisellaTularensis francisellaTularensis;
  	private HaemophilusInfluenzae haemophilusInfluenzae;
 
 	// GRAM POSITIVE PLEOMORPHIC  	
  	private ActinomycesGerencseriae actinomycesGerencseriae;
  	private ActinomycesIsraelii actinomycesIsraelii;
  	private MycobacteriumAviumIntracellulareComplex MycobacteriumAviumIntracellulareComplex;
  	private MycobacteriumBovis MycobacteriumBovis;
  	private MycobacteriumKansasii MycobacteriumKansasii;
  	private MycobacteriumLeprae MycobacteriumLeprae;
  	private MycobacteriumMarinum MycobacteriumMarinum;
  	private MycobacteriumTuberculosis MycobacteriumTuberculosis;
	private PropioniBacteriumPropionicus PropioniBacteriumPropionicus;

  	
  	// RODS - GRAM NEGATIVE
  	private CampylobacterJejuni campylobacterJejuni;
  	private EColiStrain0157H7 eColiStrain0157H7;
  	private EscherichiaColi escherichiaColi;
  	private PasteurellaMulticoda pasteurellaMulticoda;
  	private PseudomonasAeruginosa pseudomonasAeruginosa;
  	private SalmonellaEnteritidis salmonellaEnteritidis;
  	private Shigella shigella;
  	private ShigellaDysenteriae shigellaDysenteriae;
  	private VibrioCholeraes vibrioCholeraes;
  	private VibrioParahaemolyticus vibrioParahaemolyticus;
  	private YerseniaEnterocolitica yerseniaEnterocolitica;

  	// RODS - GRAM POSITIVE
  	private AnthraxSpore AnthraxSpore;
  	private BacilliAnthracis bacilliAnthracis;
  	private BacillusCereus bacillusCereus;
  	private ClostridiumBotulinum clostridiumBotulinum;
  	private ClostridiumDifficile clostridiumDifficile;
  	private ClostridiumPerfringens clostridiumPerfringens;
  	private ClostridiumTetanis clostridiumTetanis;
  	private CoryneBacteriumDiphtheriae coryneBacteriumDiphtheriae;
  	private CutaneousAnthrax cutaneousAnthrax;
  	private GastroIntestinalAntrax gastroIntestinalAntrax;
  	private ListeriaMonocytogenes listeriaMonocytogenes;
  	private PulmonaryAnthrax pulmonaryAnthrax;
  	
  	
  
		
	private static String cells[] = {
		  Constants.AcinetobacterBaumanniiRef,
		  Constants.AeromonasHydrophiliaRef, 
		  Constants.AlcaligenesFaecalisRef,
		  Constants.BacilliAnthracisRef, 
		  Constants.BordetellaPertussisesRef,
		  Constants.CampylobacterJejuniRef,
		  Constants.CorynebacteriumJeikeiumRef,
		  
		  Constants.GonococciRef, 
		  Constants.MeningococciRef, 
			
		  Constants.SalmonellaEntericasRef,
		  Constants.SalmonellaTyphiRef,
		  Constants.SalmonellaTyphimuriumRef,
		  
		  Constants.StaphylococcusAureus, 
		  Constants.StaphylococcusEpidermidisRef, 
		  Constants.StaphylococcusSaprophyticusRef, 
		
		  Constants.StreptococcusAgalactiaeRef,
		  Constants.StreptococcusAnginosusRef, 
		  Constants.StreptococcusSanguinisRef, 
		  Constants.StreptococcusBovisRef, 
		  Constants.StreptococcusFaecalisRef,
		  Constants.StreptococcusGordoniRef, 
		  Constants.StreptococcusIntermediusRef,	
		  Constants.StreptococcusMitisRef, 
		  Constants.StreptococcusMutansRef, 
		  Constants.StreptococcusPneumoniaeRef,
		  Constants.StreptococcusPyogenesRef,
		  Constants.StreptococcusSalivariusRef, 
		  Constants.StreptococcusViridansRef,
		  
		  Constants.TreponemaPallidumRef,
		  
		  Constants.VibrioCholeraesRef,
		  
		  Constants.ClostridiumTetanisRef,
		  
		  //  Constants.AchromobacterRef, 
		  Constants.ActinobacillusRef,
		  Constants.PseudomonasPseudomalleiRef, Constants.RhodococcusEquiRef, Constants.RickettsiaProwazekiiRef, Constants.RickettsiaRickettsiiRef,
		  Constants.SalmonellaTyphiRef, Constants.SalmonellaTyphimuriumRef, Constants.TropherymaWhippeliiRef, Constants.YersiniaEnterocoliticaRef,
		  Constants.YersiniaPestisRef, Constants.YersiniaEnterocoliticaRef, Constants.YersiniaPseudoTuberculosisRef,
		  Constants.eColiStrain0157H7Ref, Constants.EscherichiaColiRef, Constants.PasteurellaMulticodaRef, Constants.PseudomonasAeruginosaRef,
		  Constants.SalmonellaEnteritidisRef, Constants.ShigellaRef, Constants.ShigellaDysenteriaeRef, 
		  Constants.VibrioParahaemolyticusRef, Constants.YerseniaEnterocoliticaRef, Constants.AnthraxSporeRef, Constants.BacillusCereusRef,
		  Constants.ClostridiumBotulinumRef, Constants.ClostridiumDifficileRef, Constants.ClostridiumPerfringensRef, Constants.CoryneBacteriumDiphtheriaeRef,
		    Constants.CutaneousAnthraxRef, Constants.GastroIntestinalAntraxRef, Constants.ListeriaMonocytogenesRef,
		  Constants.PulmonaryAnthraxRef, Constants.ActinomycesGerencseriaeRef, Constants.ActinomycesIsraeliiRef, Constants.MycobacteriumAviumIntracellulareComplexRef,
		  Constants.MycobacteriumBovisRef, Constants.MycobacteriumKansasiileRef, Constants.MycobacteriumLepraeRef, Constants.MycobacteriumMarinumRef,
		  Constants.MycobacteriumTuberculosisRef
	};
	
	private static String cellsDesc[] = {	
		  Constants.AcinetobacterBaumanniisRef + "-GramNegative, aerobic, coccobacillus, nonMotile, oxidaseNegstive",	
		  Constants.AeromonasHydrophiliaRef + "-GramNegative, RodShaped, Heterotrophic, PolarFlagellum",
		  Constants.AlcaligenesFaecalisRef + "-GramNegative, RodShaped, motile, alphaHemolytic, obligateAerobe",
		 
		  Constants.BacilliAnthracisRef + "-GramPositive, RodShaped, EndoSporeForming", 
		  Constants.BordetellaPertussisesRef + "-GramNegative, aerobic coccobacillus capsulate",	
		  
		  Constants.CampylobacterJejuniRef + "-HelicalShaped, NonSporeForming, GramNegative, Microaerophilic",
		  Constants.CorynebacteriumJeikeiumRef + "-GramPositive, CatalasePositve, RodShaped",
		  
		  Constants.GonococciRef + "-(Neisseria gonorrhoeae) GramNegative, Diplococci, BeanShaped", 
		  Constants.MeningococciRef + "-(Neisseria meningitidis) GramNegative, Diplococci",
		  
		  Constants.SalmonellaEntericasRef + "-GramNegative, RodShaped",
		  Constants.SalmonellaTyphiRef + "-GramNegative, Enteric Bacillus, motile, FaculativeAnaerobe",
		  Constants.SalmonellaTyphimuriumRef + "-GramNegative, RodShaped, Flagellated, aerobic",
	
	      Constants.StaphylococciAureusRef + "-GramPositive, Coccal, Firmicutes, CatalasePositive", 
	      Constants.StaphylococciEpidermidisRef + "-GramPositive, Coccal, CoagulaseNegative ", 
		  Constants.StaphylococciSaprophyticusRef + "-GramPositive, Coccal, CoAgulaseNegative", 

	      
		  Constants.StreptococcusAgalactiaeRef + "-(Group B) GramPositive, Diplococcal, BetaHemolytic, NonMotile", 
		  Constants.StreptococcusAnginosusRef + "-GramPositive, Coccal, May be BetaHemolytic, CatalaseFree",
		  Constants.StreptococcusBovisRef  + "-GramPositive, Coccal, catalase-oxidase negative",
		  Constants.StreptococcusFaecalisRef  + "-GramPositive, Coccal, commensal, NonMotile, faculative anerobic",
		  Constants.StreptococcusGordoniRef  + "-GramPositive, Coccal, mesophillic, non-motile",
		  Constants.StreptococcusIntermediusRef + "-GramPositive, Coccal, commensal", 	
		  Constants.StreptococcusMitisRef + "-GramPositive, coccus, mesophilic, faculative anaerobe, AlphaHemolytic", 
		  Constants.StreptococcusMutansRef + "-GramPositive, Coccal, faculatively anaerobic", 
		  Constants.StreptococcusPneumoniaeRef + "-(Group A) GramPositive, Coccal, AlphaHemolytic, faculative anaerobe", 
		  Constants.StreptococcusPyogenesRef + "-GramPositive, Spherical, CatalaseNegative", 
		  Constants.StreptococcusSalivariusRef + "-GramPositive, Spherical", 
		  Constants.StreptococcusSanguinisRef + "-GramPositive, CoccusShaped, faculative aerobic, PeptidoglycanCellWall",
		  Constants.StreptococcusViridansRef + "-GramPositive, Coccal,  optochin-resistant",

		  Constants.TreponemaPallidumRef + "-Motile Spirochete,  CorkscrewShaped",
	
		  Constants.VibrioCholeraesRef + "-TearDrop Shaped",
			
		  Constants.ClostridiumTetanisRef + "-Tadpole Shaped", 
		  
		 // Constants.AchromobacterRef, 
		  Constants.ActinobacillusRef,
		  Constants.CoxiellaBurnetiiRef, 
		  Constants.ErysipelothrixRhusiopathiaeRef, 
		  Constants.KlebsiellaPneumoniaeRef, 
		  Constants.LegionellaPneumophilaRef, 
		  Constants.LeptospiraInterrogansRef, 
		  Constants.OrientiaTsutsugamushiRef, 
		  Constants.PorphyromonasGingivalisRef,
		  Constants.PseudomonasPseudomalleiRef, 
		  Constants.RhodococcusEquiRef, 
		  Constants.RickettsiaProwazekiiRef, 
		  Constants.RickettsiaRickettsiiRef,
		  Constants.SalmonellaTyphiRef, 
		  Constants.SalmonellaTyphimuriumRef, 
		  Constants.TropherymaWhippeliiRef, 
		  Constants.YersiniaEnterocoliticaRef,
		  Constants.YersiniaPestisRef, 
		  Constants.YersiniaEnterocoliticaRef, 
		  Constants.YersiniaPseudoTuberculosisRef, 

		  Constants.eColiStrain0157H7Ref, 
		  Constants.EscherichiaColiRef, 
		  Constants.PasteurellaMulticodaRef, 
		  Constants.PseudomonasAeruginosaRef,
		  Constants.SalmonellaEnteritidisRef, 
		  Constants.ShigellaRef, 
		  Constants.ShigellaDysenteriaeRef, 
		  
		  Constants.VibrioParahaemolyticusRef, 
		  Constants.YerseniaEnterocoliticaRef, 
		  Constants.AnthraxSporeRef, 
		  Constants.BacillusCereusRef,
		  Constants.ClostridiumBotulinumRef, 
		  Constants.ClostridiumDifficileRef, 
		  Constants.ClostridiumPerfringensRef, 
		  Constants.CoryneBacteriumDiphtheriaeRef,
		 
		  Constants.CutaneousAnthraxRef, 
		  Constants.GastroIntestinalAntraxRef, 
		  Constants.ListeriaMonocytogenesRef,
		  Constants.PulmonaryAnthraxRef, 
		  Constants.ActinomycesGerencseriaeRef, 
		  Constants.ActinomycesIsraeliiRef, 
		  Constants.MycobacteriumAviumIntracellulareComplexRef,
		  Constants.MycobacteriumBovisRef, 
		  Constants.MycobacteriumKansasiileRef, 
		  Constants.MycobacteriumLepraeRef, 
		  Constants.MycobacteriumMarinumRef,
		  Constants.MycobacteriumTuberculosisRef
	};



  	
	/************************************************************************
	 * Bacterias Constructor 
	 *
	 ***********************************************************************/
	public Bacterias()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BacteriaRef, null, null);
	}

	/************************************************************************
	 * Bacterias Constructor 
	 *
	 ***********************************************************************/
	public Bacterias(String parentID)
	{
		System.out.print("Calling parameterized Bacterias Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Bacterias Constructor 
	 *
	 ***********************************************************************/
	public Bacterias(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/************************************************************************
	 * Create Bacterias
	 *
	 ***********************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Bacterias.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Bacterias for: " + parentID);
			
		// Get the data for the Bacterias that is defined for this 
		// Virus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BacteriasInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BacteriasRef, parentID);
			System.out.println("Have Bacterias Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bacterias");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Bacterias METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
			
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Bacterias from EJB - NumTransforms: " + transforms.size());
	
	
		// Run through the Bacterias instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Bacterias we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			gbioMightTransform  = bioMightTransform;

			componentID = bioMightTransform.getId();			
			System.out.println("Creating Bacterias: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			if (lod == Constants.MAG1X)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("In Bacterias - MAG1X - Just Initializing Properties");
				initProperties();
			}
			else  if (lod == Constants.MAG2X)
			{
				BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
				BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
				String bioTemplate="Bacterias.x3d";
				
				System.out.println("In Bacterias - MAG2X - Creating Components");
				
				System.out.println("In Bacterias - Creating BacillusAnthracis: " +  bioMightTransform.getId());
				bacilliAnthracis = new BacilliAnthracis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Bacterias - BacillusAnthracis is complete");
				initProperty(Constants.BacilliAnthracisRef, Constants.BacilliAnthracis, Constants.BacilliAnthracisRef, bacilliAnthracis.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
				System.out.println("In Bacterias - Creating StaphylococcusAureus: " +  bioMightTransform.getId());
				staphylococcusAureus = new StaphylococcusAureus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Bacterias - StaphylococcusAureus is complete");
				initProperty(Constants.StaphylococcusAureusRef, Constants.StaphylococcusAureus, Constants.StaphylococcusAureusRef, staphylococcusAureus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				
				System.out.println("In Bacterias - Creating StreptococciPneumoniae: " +  bioMightTransform.getId());
				streptococciPneumoniae = new 	StreptococciPneumoniae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Bacterias - StreptococciPneumoniae is complete");
				initProperty("StreptococciPneumoniae", Constants.StreptococciPneumoniae, Constants.StreptococciPneumoniaeRef, streptococciPneumoniae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
					
				System.out.println("In Bacterias - Creating StreptococcusViridans: " +  bioMightTransform.getId());
				streptococcusViridans = new StreptococcusViridans(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Bacterias - StreptococcusViridans is complete");
				initProperty("StreptococcusViridans", Constants.StreptococcusViridans, Constants.StreptococcusViridansRef, streptococcusViridans.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
				System.out.println("In Bacterias - Creating StaphylococcusEpidermidis: " +  bioMightTransform.getId());
				staphylococcusEpidermidis = new StaphylococcusEpidermidis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Bacterias - StaphylococcusEpidermidis is complete");
				initProperty("StaphylococcusEpidermidis", Constants.StaphylococcusEpidermidis, Constants.StaphylococcusEpidermidisRef, staphylococcusEpidermidis.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
				// get the rest for now
				//initProperties();
			}
		}
		
		
		//initProperties();
		//initMethods();
		System.out.println("Created Bacterias");				
	}
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="Bacterias.x3d";
			
		//public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String compDesc, String componentID, BioMightPosition bioPos, BioMightScale dimensions, BioMightOrientation bioOrient, String propType, String templates, boolean viewEnabled)
		int n=0;
		initProperty(Constants.AcinetobacterBaumanniisRef, Constants.AcinetobacterBaumanniis, Constants.AcinetobacterBaumanniisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AeromonasHydrophiliasRef, Constants.AeromonasHydrophilias, Constants.AeromonasHydrophiliasRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AlcaligenesFaecalisesRef, Constants.AlcaligenesFaecalises, Constants.AlcaligenesFaecalisesRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		initProperty(Constants.BacilliAnthracisRef, Constants.BacilliAnthracis, Constants.BacilliAnthracisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.BordetellaPertussisesRef, Constants.BordetellaPertussises, Constants.BordetellaPertussisesRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CampylobacterJejunisRef, Constants.CampylobacterJejunis, Constants.CampylobacterJejunisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CorynebacteriumJeikeiumsRef, Constants.CorynebacteriumJeikeiums, Constants.CorynebacteriumJeikeiumsRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		initProperty(Constants.GonococciRef, Constants.Gonococci, Constants.GonococciRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MeningococciRef, Constants.Meningococci, Constants.MeningococciRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.SalmonellaEntericasRef, Constants.SalmonellaEntericas, Constants.SalmonellaEntericas, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SalmonellaTyphisRef, Constants.SalmonellaTyphis, Constants.SalmonellaTyphisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SalmonellaTyphimuriumsRef, Constants.SalmonellaTyphimuriums, Constants.SalmonellaTyphimuriums, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
		initProperty(Constants.StaphylococciAureusRef, Constants.StaphylococciAureus, Constants.StaphylococciAureusRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StaphylococciEpidermidisRef, Constants.StaphylococciEpidermidis, Constants.StaphylococciEpidermidisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StaphylococciSaprophyticusRef, Constants.StaphylococciSaprophyticus, Constants.StaphylococciSaprophyticusRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		initProperty(Constants.StreptococciAgalactiaeRef, Constants.StreptococciAgalactiae, Constants.StreptococciAgalactiaeRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		
		initProperty(Constants.StreptococciAnginosusRef, Constants.StreptococciAnginosus, Constants.StreptococciAnginosusRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		initProperty(Constants.StreptococciBovisRef, Constants.StreptococciBovis, Constants.StreptococciBovisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		initProperty(Constants.StreptococciFaecalisRef, Constants.StreptococciFaecalis, Constants.StreptococciFaecalisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient,Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciGordoniRef, Constants.StreptococciGordoni, Constants.StreptococciGordoniRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient,Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciIntermediusRef, Constants.StreptococciIntermedius, Constants.StreptococciIntermediusRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient,Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciMitisRef, Constants.StreptococciMitis, Constants.StreptococciMitisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		initProperty(Constants.StreptococciMutansRef, Constants.StreptococciMutans, Constants.StreptococciMutansRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciPneumoniaeRef, Constants.StreptococciPneumoniae, Constants.StreptococciPneumoniaeRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient,  Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciPyogenesRef, Constants.StreptococciPyogenes, Constants.StreptococciPyogenesRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);	 
		initProperty(Constants.StreptococciSalivariusRef, Constants.StreptococciSalivarius, Constants.StreptococciSalivariusRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StreptococciSanguinisRef, Constants.StreptococciSanguinis, Constants.StreptococciSanguinisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);		
		initProperty(Constants.StreptococciViridansRef, Constants.StreptococciViridans, Constants.StreptococciViridansRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);	
		initProperty(Constants.TreponemaPallidumsRef, Constants.TreponemaPallidums, Constants.TreponemaPallidumsRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.VibrioCholeraesRef, Constants.VibrioCholeraes, Constants.VibrioCholeraesRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ClostridiumTetanisRef, Constants.ClostridiumTetanis, Constants.ClostridiumTetanisRef, cellsDesc[n++], "Bacterias:0", bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		// initProperty(Constants.AchromobacterRef, Constants.Achromobacter, Constants.Achromobacter,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.ActinobacillusRef, Constants.Actinobacillus, Constants.ActinobacillusRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.CoxiellaBurnetiiRef, Constants.CoxiellaBurnetii, Constants.CoxiellaBurnetiiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ErysipelothrixRhusiopathiaeRef, Constants.ErysipelothrixRhusiopathiae, Constants.ErysipelothrixRhusiopathiaeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.KlebsiellaPneumoniaeRef, Constants.KlebsiellaPneumoniae, Constants.KlebsiellaPneumoniaeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LegionellaPneumophilaRef, Constants.LegionellaPneumophila, Constants.LegionellaPneumophilaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeptospiraInterrogansRef, Constants.LeptospiraInterrogans, Constants.LeptospiraInterrogansRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.OrientiaTsutsugamushiRef, Constants.OrientiaTsutsugamushi, Constants.OrientiaTsutsugamushiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PorphyromonasGingivalisRef, Constants.PorphyromonasGingivalis, Constants.PorphyromonasGingivalisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PseudomonasPseudomalleiRef, Constants.PseudomonasPseudomallei, Constants.PseudomonasPseudomalleiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.RhodococcusEquiRef, Constants.RhodococcusEqui, Constants.RhodococcusEquiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RickettsiaProwazekiiRef, Constants.RickettsiaProwazekii, Constants.RickettsiaProwazekiiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RickettsiaRickettsiiRef, Constants.RickettsiaRickettsii, Constants.RickettsiaRickettsiiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SalmonellaTyphimuriumRef, Constants.SalmonellaTyphimurium, Constants.SalmonellaTyphimuriumRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.TropherymaWhippeliiRef, Constants.TropherymaWhippelii, Constants.TropherymaWhippeliiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YersiniaEnterocoliticaRef, Constants.YersiniaEnterocolitica, Constants.YersiniaEnterocoliticaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YersiniaPestisRef, Constants.YersiniaPestis, Constants.YersiniaPestisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YersiniaEnterocoliticaRef, Constants.YersiniaEnterocolitica, Constants.YersiniaEnterocoliticaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YersiniaPseudoTuberculosisRef, Constants.YersiniaPseudoTuberculosis, Constants.YersiniaPseudoTuberculosisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.eColiStrain0157H7Ref, Constants.eColiStrain0157H7, Constants.eColiStrain0157H7Ref,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.EscherichiaColiRef, Constants.EscherichiaColi, Constants.EscherichiaColiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PasteurellaMulticodaRef, Constants.PasteurellaMulticoda, Constants.PasteurellaMulticodaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PseudomonasAeruginosaRef, Constants.PseudomonasAeruginosa, Constants.PseudomonasAeruginosaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SalmonellaEnteritidisRef, Constants.SalmonellaEnteritidis, Constants.SalmonellaEnteritidisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ShigellaRef, Constants.Shigella, Constants.ShigellaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ShigellaDysenteriaeRef, Constants.ShigellaDysenteriae, Constants.ShigellaDysenteriaeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.VibrioParahaemolyticusRef, Constants.VibrioParahaemolyticus, Constants.VibrioParahaemolyticusRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YerseniaEnterocoliticaRef, Constants.YerseniaEnterocolitica, Constants.YerseniaEnterocoliticaRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Gram Postive Rods", Constants.Title, Constants.Title,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AnthraxSporeRef, Constants.AnthraxSpore, Constants.AnthraxSporeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.BacillusAnthracisRef, Constants.BacillusAnthracis, Constants.BacillusAnthracisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.BacillusCereusRef, Constants.BacillusCereus, Constants.BacillusCereusRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ClostridiumBotulinumRef, Constants.ClostridiumBotulinum, Constants.ClostridiumBotulinumRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ClostridiumDifficileRef, Constants.ClostridiumDifficile, Constants.ClostridiumDifficile,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ClostridiumPerfringensRef, Constants.ClostridiumPerfringens, Constants.ClostridiumPerfringensRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoryneBacteriumDiphtheriaeRef, Constants.CoryneBacteriumDiphtheriae, Constants.CoryneBacteriumDiphtheriaeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CutaneousAnthraxRef, Constants.CutaneousAnthrax, Constants.CutaneousAnthraxRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.GastroIntestinalAntraxRef, Constants.GastroIntestinalAntrax, Constants.GastroIntestinalAntraxRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ListeriaMonocytogenesRef, Constants.ListeriaMonocytogenes, Constants.ListeriaMonocytogenesRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PulmonaryAnthraxRef, Constants.PulmonaryAnthrax, Constants.PulmonaryAnthraxRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Gram Postive Pleomorphic", Constants.Title, Constants.Title,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ActinomycesGerencseriaeRef, Constants.ActinomycesGerencseriae, Constants.ActinomycesGerencseriaeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ActinomycesIsraeliiRef, Constants.ActinomycesIsraelii, Constants.ActinomycesIsraeliiRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumAviumIntracellulareComplexRef, Constants.MycobacteriumAviumIntracellulareComplex, Constants.MycobacteriumAviumIntracellulareComplexRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumBovisRef, Constants.MycobacteriumBovis, Constants.MycobacteriumBovisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumKansasiileRef, Constants.MycobacteriumKansasiile, Constants.MycobacteriumKansasiileRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumLepraeRef, Constants.MycobacteriumLeprae, Constants.MycobacteriumLepraeRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumMarinumRef, Constants.MycobacteriumMarinum, Constants.MycobacteriumMarinumRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MycobacteriumTuberculosisRef, Constants.MycobacteriumTuberculosis, Constants.MycobacteriumTuberculosisRef,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.xx, Constants.xx, Constants.xx,"Bacterias:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
	}
	
	
	public void initMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Replicate");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Exchange Opsonin");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);
	}

	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Bacterias.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Bacterias
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Bacterias.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bacterias'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		System.out.println("Bacterias Snipet is: " + snipet);	
		
		String body = ""; 		
		if (lod == Constants.MAG1X)
		{
			System.out.println("In Bacterias - MAG1X - Getting X3D");
			
			double xPos = -3.0;
			double yPos = 2.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
		
			System.out.println("Creating X3D for all Bacterial Cells: " + cells.length);	
			for (int i=0; i<cells.length; i++)
			{
				System.out.println("Creating X3D for : " + cells[i]);				
				
				if (i % 11 == 0) {
					yPos = 2.0;
					xPos += 1.50;
				}
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + cells[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
				//System.out.println("Set Translation: ");				


		
				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + cells[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + cells[i] + ".jpg'/>";
					
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ gbioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ gbioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ gbioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='" + cells[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+cells[i]+"Touch' \n" +
	                   " description='"+cellsDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				//System.out.println("Set Transform: ");				
			 	yPos = yPos-1.00;
			}
		}
		else if (lod == Constants.MAG2X)
		{
			System.out.println("In Bacterias - Getting X3D - MAG2X");
			body = 
				staphylococcusAureus.getX3D(true) +
				staphylococcusEpidermidis.getX3D(true) +
				bacilliAnthracis.getX3D(true) +
				streptococciPneumoniae.getX3D(true);
				streptococcusViridans.getX3D(true);
		}
		
		
		String viewpoint = "<Viewpoint DEF='Viewpoint1'\n" +
			 "description='Viewpoint1'\n" +
			 "jump='true'\n" +
			 "fieldOfView='0.785'\n" +
			 "position='5.0 -5.0 25.0'\n" +
			 "orientation='0 0 1 0'/>\n";
	
		
		//System.out.println("Bacteria Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return viewpoint + body;			
		else	
			return header + viewpoint + body + footer;
	}


}
