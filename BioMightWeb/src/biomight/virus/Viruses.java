/*
 * Created on Jun 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.virus;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.virus.astroviridae.AstroVirus;
import biomight.virus.caliciviridae.Calicivirus;
import biomight.virus.circoviridae.CircoVirus;
import biomight.virus.dna.Adenoviridae;
import biomight.virus.dna.Adenoviruses;
import biomight.virus.dna.Bacteriophages;
import biomight.virus.dna.CytoMegaloVirus;
import biomight.virus.dna.EpsteinBarrVirus;
import biomight.virus.dna.HepadnaVirus;
import biomight.virus.dna.HerpesSimplexVirus1;
import biomight.virus.dna.HerpesSimplexVirus2;
import biomight.virus.dna.HerpesVirus;
import biomight.virus.dna.HumanHerpesVirus6;
import biomight.virus.dna.HumanHerpesVirus8;
import biomight.virus.dna.PapoViruses;
import biomight.virus.dna.PapovaViridae;
import biomight.virus.dna.ParvoVirus;
import biomight.virus.dna.PoxViridae;
import biomight.virus.dna.Vaccinia;
import biomight.virus.dna.VaricellaZosterVirus;
import biomight.virus.entero.Echovirus;
import biomight.virus.papillomaviridae.PapillomaVirus;
import biomight.virus.picornaviridae.enteroviridae.CoxsackieA;
import biomight.virus.picornaviridae.enteroviridae.HepatitisAVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisBVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisDVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisEVirus;
import biomight.virus.picornaviridae.enteroviridae.PolioVirus;
import biomight.virus.polyomaviridae.BKVirus;
import biomight.virus.polyomaviridae.JCVirus;
import biomight.virus.rna.AIDSVirus;
import biomight.virus.rna.ArenaVirus;
import biomight.virus.rna.BunyaVirus;
import biomight.virus.rna.CaliciViruses;
import biomight.virus.rna.CoronaVirus;
import biomight.virus.rna.DeltaVirus;
import biomight.virus.rna.DengueVirus;
import biomight.virus.rna.EbolaVirus;
import biomight.virus.rna.EnteroViruses;
import biomight.virus.rna.FiloVirus;
import biomight.virus.rna.Filoviridae;
import biomight.virus.rna.FlaviVirus;
import biomight.virus.rna.HantaVirus;
import biomight.virus.rna.HepatitisCVirus;
import biomight.virus.rna.HepatitisDeltaVirus;
import biomight.virus.rna.JapaneseEncephalitisVirus;
import biomight.virus.rna.LentiVirus;
import biomight.virus.rna.LeukemiaViruses;
import biomight.virus.rna.MarburgVirus;
import biomight.virus.rna.MeaslesVirus;
import biomight.virus.rna.MumpsVirus;
import biomight.virus.rna.NoroViruses;
import biomight.virus.rna.OncoVirus;
import biomight.virus.rna.OrthomyxoViruses;
import biomight.virus.rna.ParamyxoViruses;
import biomight.virus.rna.ReoViruses;
import biomight.virus.rna.RespiratorySyncytialVirus;
import biomight.virus.rna.RetroVirus;
import biomight.virus.rna.RhabdoVirus;
import biomight.virus.rna.Rhabdoviridae;
import biomight.virus.rna.RotaViruses;
import biomight.virus.rna.RubellaVirus;
import biomight.virus.rna.SarcomaVirus;
import biomight.virus.rna.StLouisEncephalitisVirus;
import biomight.virus.rna.TogaViruses;
import biomight.virus.rna.WestNileVirus;
import biomight.virus.rna.YellowFeverVirus;
import biomight.virus.rna.picornaviridae.AphthoVirus;
import biomight.virus.rna.picornaviridae.CardioVirus;
import biomight.virus.rna.picornaviridae.CoxsackieBVirus;
import biomight.virus.rna.picornaviridae.EncephalomyocarditisVirus;
import biomight.virus.rna.picornaviridae.HepatoVirus;
import biomight.virus.rna.picornaviridae.MengoVirus;
import biomight.virus.rna.picornaviridae.PicornaVirus;
import biomight.virus.rna.picornaviridae.RhinoVirus;
import biomight.virus.rna.picornaviridae.RhinoVirus14;
import biomight.virus.rna.picornaviridae.RhinoVirus1A;



/**************************************************************************************************
 * @author SurferJim
 *
 * Representation of Viruses
 * 
 **************************************************************************************************/

public class Viruses extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	
	
	private CacheValleyVirus cacheValleyVirus;
	private EnteroViruses enteroViruses;
	private HendraVirus hendraVirus;
	private InfluenzaAViruses influenzaAViruses;
	private LassaFeverVirus lassaFeverVirus;	
	private LymphocyticChorioMeningitisVirus lymphocyticChorioMeningitisVirus;
	private MolluscumContagiosumVirus molluscumContagiosumVirus;
	private NipahVirus nipahVirus;	
	private NoroViruses noroViruses;	
	private WhitewaterArroyoVirus whitewaterArroyoVirus;	
	private AstroVirus astroVirus;
	private Calicivirus calicivirus;
	private CircoVirus circoVirus;
	private Adenoviridae adenoviridae;
	private Adenoviruses adenoviruses;
	private Bacteriophages bacteriophages;
	
	private CytoMegaloVirus CytoMegaloVirus; 	
	private EpsteinBarrVirus epsteinBarrVirus;
	private HepadnaVirus hepadnaVirus; 		
	private HerpesSimplexVirus1 HerpesSimplexVirus1;
	private HerpesSimplexVirus2 herpesSimplexVirus2;	
	private HerpesVirus herpesVirus; 	
	private HumanHerpesVirus6 humanHerpesVirus6; 	
	private HumanHerpesVirus8 humanHerpesVirus8;	
	private PapovaViridae papovaViridae;
	private PapoViruses papoViruses;
	private ParvoVirus parvoVirus;
	private PoxViridae poxViridae; 		
	private Vaccinia vaccinia; 
	private VaricellaZosterVirus varicellaZosterVirus;
	private Echovirus echovirus;
	private PapillomaVirus papillomaVirus;
	private CoxsackieA coxsackieA;
	private HepatitisAVirus hepatitisAVirus;
	private HepatitisBVirus HhepatitisBVirus;
	private HepatitisDVirus hepatitisDVirus;
	private HepatitisEVirus	hepatitisEVirus;
	private PolioVirus polioVirus;
	private BKVirus	bKVirus;
	private JCVirus jCVirus;

	private AIDSVirus aidsVirus;

	
	// RNA VIRUSES
	private ArenaVirus arenaVirus;
	private BunyaVirus bunyaVirus;
	private CaliciViruses caliciViruses;
	private CoronaVirus coronaVirus;
	private DeltaVirus deltaVirus;
	private DengueVirus dengueVirus;
	private EbolaVirus ebolaVirus;
	private Filoviridae filoviridae;
	private FiloVirus filoVirus;
	private FlaviVirus flaviVirus;	
	private HantaVirus hantaVirus;
	private HepatitisCVirus hepatitisCVirus;
	private HepatitisDeltaVirus hepatitisDeltaVirus;
	private JapaneseEncephalitisVirus japaneseEncephalitisVirus;
	private LentiVirus lentiVirus;
	private LeukemiaViruses LeukemiaViruses;
	private MarburgVirus marburgVirus;
	private MeaslesVirus measlesVirus;
	private MumpsVirus mumpsVirus;
	private OncoVirus oncoVirus;
	private OrthomyxoViruses orthomyxoViruses;
	private ParamyxoViruses paramyxoViruses;
	private ReoViruses reoViruses;
	private RespiratorySyncytialVirus RespiratorySyncytialVirus;
	private RetroVirus retroVirus;
	private Rhabdoviridae rhabdoviridae;
	private RhabdoVirus rhabdoVirus;
	private RotaViruses rotaviruses;
	private RubellaVirus rubellaVirus;
	private SarcomaVirus sarcomaVirus;
	private StLouisEncephalitisVirus stLouisEncephalitisVirus;
	private TogaViruses togaViruses;
	private WestNileVirus westNileVirus;
	private YellowFeverVirus yellowFeverVirus;	
	
	
	// RNA PICORNAVIRIDAE
	private AphthoVirus aphthoVirus;	
	private CardioVirus cardioVirus;
	private CoxsackieBVirus CoxsackieBVirus;
	private EncephalomyocarditisVirus EncephalomyocarditisVirus;
	private HepatoVirus HepatoVirus;
	private MengoVirus MengoVirus;
	private PicornaVirus PicornaVirus;
	private RhinoVirus RhinoVirus;
	private RhinoVirus14 RhinoVirus14;
	private RhinoVirus1A RhinoVirus1A;


	
	/************************************************************************
	 * Viruses Constructor 
	 *
	 ***********************************************************************/
	public Viruses()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.VirusRef, null, null);
	}

	/************************************************************************
	 * Viruses Constructor 
	 *
	 ***********************************************************************/
	public Viruses(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Viruses(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/************************************************************************
	 * Create Viruses
	 *
	 ***********************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Viruses.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Viruses for: " + parentID);		
		
		// Get the data for the Virus that is defined for this 
		// Virus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Viruses Info for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.VirusesRef, parentID);
			System.out.println("Have Viruses Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Viruses");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE CELL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();

		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Virus Transforms : " + transforms.size());

	
		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Viruses we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			gbioMightTransform  = bioMightTransform;

			componentID = bioMightTransform.getId();			
			System.out.println("Creating Viruses: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			if (lod == Constants.MAG1X)
			{
					// Just create an internal representation 
					// using the data from the default properties
					System.out.println("In Viruses - MAG1X - Just Initializing Properties");
					initProperties();
			}
			else  if (lod == Constants.MAG2X)
			{
				BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
				BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
				String bioTemplate="Viruses.x3d";
		
				
				System.out.println("In Virus - Creating Adenovirus");
				adenoviruses = new Adenoviruses(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
				initProperty(Constants.AdenovirusesRef, Constants.Adenoviruses, Constants.AdenovirusesRef, adenoviruses.getComponentID());
				System.out.println("In Virus - Adenoviruses is complete: " + adenoviruses.getComponentID());
		
				System.out.println("In Virus - Creating Bacteriophages");
				bacteriophages = new Bacteriophages(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
				initProperty(Constants.BacteriophagesRef, Constants.Bacteriophages, Constants.BacteriophagesRef, bacteriophages.getComponentID());
				System.out.println("In Virus - Bacteriophages is complete: " + bacteriophages.getComponentID());
		
				System.out.println("In Virus - Creating InfluenzaAViruses");
				influenzaAViruses = new InfluenzaAViruses(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
				//initProperty(Constants.AdenovirusesRef, Constants.Adenoviruses, Constants.AdenovirusesRef, adenoviruses.getCompo
				System.out.println("In Virus - InfluenzaAVirus is complete");
				initProperty("InfluenzaAVirus", Constants.InfluenzaAVirus, Constants.InfluenzaAVirusRef, influenzaAViruses.getComponentID());
				
				initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
				System.out.println("In Virus - Creating AIDS virus");
				aidsVirus = new AIDSVirus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Virus - AIDS is complete");
				initProperty("VirusMembrane", Constants.AIDSVirus, Constants.AIDSVirusRef, aidsVirus.getComponentID());
				
				System.out.println("In Virus - Creating HerpesVirus");
				herpesVirus = new HerpesVirus(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Virus - HerpesVirus is complete");
				initProperty("HerpesVirus", Constants.HerpesVirus, Constants.HerpesVirusRef, herpesVirus.getComponentID());
		
				System.out.println("In Virus - Creating Reovirus");
				reoViruses = new ReoViruses(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Viruses - Reovirus is complete");
				initProperty("ReoVirus", Constants.ReoVirus, Constants.ReoVirusRef, reoViruses.getComponentID());
		
				System.out.println("In Virus - Creating Rotaviruses");
				rotaviruses = new RotaViruses(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Virus - Rotavirus is complete");
				initProperty("RotaViruses", Constants.RotaViruses, Constants.RotaVirusesRef, rotaviruses.getComponentID());
		
				System.out.println("In Virus - Creating EnteroVirus");
				enteroViruses = new EnteroViruses(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Virus - EnteroViruses are complete");
				initProperty("EnteroViruses", Constants.EnteroViruses, Constants.EnteroVirusesRef, enteroViruses.getComponentID());
	
				System.out.println("In Virus - Creating RhabdoVirus");
				rhabdoVirus = new RhabdoVirus(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Virus - RhabdoVirus is complete");
				initProperty("RhabdoVirus", Constants.RhabdoVirus, Constants.RhabdoVirusRef, rhabdoVirus.getComponentID());
				
				System.out.println("In Virus - Creating DengueVirus");
				dengueVirus = new DengueVirus(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Virus - DengueVirus is complete");
				initProperty("DengueVirus", Constants.DengueVirus, Constants.DengueVirusRef, dengueVirus.getComponentID());
							
				System.out.println("In Virus - Creating WestNileVirus");
				westNileVirus = new WestNileVirus(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Virus - WestNileVirus is complete");
				initProperty("WestNileVirus", Constants.WestNileVirus, Constants.WestNileVirusRef, westNileVirus.getComponentID());
	
				System.out.println("In Virus - Creating FlaviVirus");
				flaviVirus = new FlaviVirus(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Virus - FlaviVirus is complete");
				initProperty("FlaviVirus", Constants.FlaviVirus, Constants.FlaviVirusRef, flaviVirus.getComponentID());
			
				initProperty(Constants.CacheValleyVirusRef, Constants.CacheValleyVirus, Constants.CacheValleyVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.EnteroVirusRef, Constants.EnteroVirus, Constants.EnteroVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HendraVirusRef, Constants.HendraVirus, Constants.HendraVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				//initProperty(Constants.InfluenzaAVirusRef, Constants.InfluenzaAVirus, Constants.InfluenzaAVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.LassaFeverVirusRef, Constants.LassaFeverVirus, Constants.LassaFeverVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.LymphocyticChorioMeningitisVirusRef, Constants.LymphocyticChorioMeningitisVirus, Constants.LymphocyticChorioMeningitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MolluscumContagiosumVirusRef, Constants.MolluscumContagiosumVirus, Constants.MolluscumContagiosumVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.NipahVirusRef, Constants.NipahVirus, Constants.NipahVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MolluscumContagiosumVirusRef, Constants.MolluscumContagiosumVirus, Constants.MolluscumContagiosumVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.WhitewaterArroyoVirusRef, Constants.WhitewaterArroyoVirus, Constants.WhitewaterArroyoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.AstroVirusRef, Constants.AstroVirus, Constants.AstroVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CalicivirusRef, Constants.Calicivirus, Constants.CalicivirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CircoVirusRef, Constants.CircoVirus, Constants.CircoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.AdenoviridaeRef, Constants.Adenoviridae, Constants.AdenoviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty("RNA Viruses", Constants.Title, Constants.Title,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ArenaVirusRef, Constants.ArenaVirus, Constants.ArenaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.BunyaVirusRef, Constants.BunyaVirus, Constants.BunyaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CaliciVirusesRef, Constants.CaliciViruses, Constants.CaliciVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CoronaVirusRef, Constants.CoronaVirus, Constants.CoronaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.DeltaVirusRef, Constants.DeltaVirus, Constants.DeltaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.DengueVirusRef, Constants.DengueVirus, Constants.DengueVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.EbolaVirusRef, Constants.EbolaVirus, Constants.EbolaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.FiloviridaeRef, Constants.Filoviridae, Constants.FiloviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				//initProperty(Constants.FiloVirusRef, Constants.FiloVirusRef, Constants.FiloVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.FlaviVirusRef, Constants.FlaviVirus, Constants.FlaviVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HantaVirusRef, Constants.HantaVirus, Constants.HantaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HepatitisCVirusRef, Constants.HepatitisCVirus, Constants.HepatitisCVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HepatitisDeltaVirusRef, Constants.HepatitisDeltaVirus, Constants.HepatitisDeltaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.JapaneseEncephalitisVirusRef, Constants.JapaneseEncephalitisVirus, Constants.JapaneseEncephalitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.LentiVirusRef, Constants.LentiVirus, Constants.LentiVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.LeukemiaVirusesRef, Constants.LeukemiaViruses, Constants.LeukemiaVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MarburgVirusRef, Constants.MarburgVirus, Constants.MarburgVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MeaslesVirusRef, Constants.MeaslesVirus, Constants.MeaslesVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MumpsVirusRef, Constants.MumpsVirus, Constants.MumpsVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.OncoVirusRef, Constants.OncoVirus, Constants.OncoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.OrthomyxoVirusesRef, Constants.OrthomyxoViruses, Constants.OrthomyxoVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ParamyxoVirusesRef, Constants.ParamyxoViruses, Constants.ParamyxoVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ReoVirusRef, Constants.ReoVirus, Constants.ReoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RespiratorySyncytialVirusRef, Constants.RespiratorySyncytialVirus, Constants.RespiratorySyncytialVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RhabdoviridaeRef, Constants.Rhabdoviridae, Constants.RhabdoviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RetroVirusRef, Constants.RetroVirus, Constants.RetroVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RhabdoVirusRef, Constants.RhabdoVirus, Constants.RhabdoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RotaVirusRef, Constants.RotaVirus, Constants.RotaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RubellaVirusRef, Constants.RubellaVirus, Constants.RubellaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.SarcomaVirusRef, Constants.SarcomaVirus, Constants.SarcomaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.StLouisEncephalitisVirusRef, Constants.StLouisEncephalitisVirus, Constants.StLouisEncephalitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.TogaVirusesRef, Constants.TogaViruses, Constants.TogaVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.YellowFeverVirusRef, Constants.YellowFeverVirus, Constants.YellowFeverVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				//initProperty(Constants.PicornaviridaeRef, Constants.Picornaviridae, Constants.PicornaviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.AphthoVirusRef, Constants.AphthoVirus, Constants.AphthoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CardioVirusRef, Constants.CardioVirus, Constants.CardioVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CoxsackieBVirusRef, Constants.CoxsackieBVirus, Constants.CoxsackieBVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.EncephalomyocarditisVirusRef, Constants.EncephalomyocarditisVirus, Constants.EncephalomyocarditisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HepatoVirusRef, Constants.HepatoVirus, Constants.HepatoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MengoVirusRef, Constants.MengoVirus, Constants.MengoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				//initProperty(Constants.PicornaVirusRef, Constants.PicornaVirus, Constants.PicornaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RhinoVirusRef, Constants.RhinoVirus, Constants.RhinoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RhinoVirus14Ref, Constants.RhinoVirus14, Constants.RhinoVirus14Ref,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.RhinoVirus1ARef, Constants.RhinoVirus1A, Constants.RhinoVirus1ARef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			}
		}
			
		//initProperties();
		System.out.println("Init Methods");
		initMethods();
		System.out.println("Created Virus");				
	}
	


	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Viruses.x3d";

		initProperty(Constants.AdenovirusesRef, Constants.Adenoviruses, Constants.AdenovirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AIDSVirusesRef, Constants.AIDSViruses, Constants.AIDSVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.BacteriophagesRef, Constants.Bacteriophages, Constants.BacteriophagesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.EnteroVirusesRef, Constants.EnteroViruses, Constants.EnteroVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.InfluenzaAVirusesRef, Constants.InfluenzaAViruses, Constants.InfluenzaAVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PoxVirusesRef, Constants.PoxViruses, Constants.PoxVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReoVirusesRef, Constants.ReoViruses, Constants.ReoVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RetroVirusesRef, Constants.RetroViruses, Constants.RetroVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RotaVirusesRef, Constants.RotaViruses, Constants.RotaVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NoroVirusesRef, Constants.NoroViruses, Constants.NoroVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
					
		
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HerpesVirusRef, Constants.HerpesVirus, Constants.HerpesVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhabdoVirusRef, Constants.RhabdoVirus, Constants.RhabdoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.DengueVirusRef, Constants.DengueVirus, Constants.DengueVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.WestNileVirusRef, Constants.WestNileVirus, Constants.WestNileVirusRef, "Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.FlaviVirusRef, Constants.FlaviVirus, Constants.FlaviVirusRef, "Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Common Viruses", Constants.Title, Constants.Title,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CacheValleyVirusRef, Constants.CacheValleyVirus, Constants.CacheValleyVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HendraVirusRef, Constants.HendraVirus, Constants.HendraVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LassaFeverVirusRef, Constants.LassaFeverVirus, Constants.LassaFeverVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LymphocyticChorioMeningitisVirusRef, Constants.LymphocyticChorioMeningitisVirus, Constants.LymphocyticChorioMeningitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MolluscumContagiosumVirusRef, Constants.MolluscumContagiosumVirus, Constants.MolluscumContagiosumVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NipahVirusRef, Constants.NipahVirus, Constants.NipahVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MolluscumContagiosumVirusRef, Constants.MolluscumContagiosumVirus, Constants.MolluscumContagiosumVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.WhitewaterArroyoVirusRef, Constants.WhitewaterArroyoVirus, Constants.WhitewaterArroyoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AstroVirusRef, Constants.AstroVirus, Constants.AstroVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CalicivirusRef, Constants.Calicivirus, Constants.CalicivirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CircoVirusRef, Constants.CircoVirus, Constants.CircoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdenoviridaeRef, Constants.Adenoviridae, Constants.AdenoviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("RNA Viruses", Constants.Title, Constants.Title,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ArenaVirusRef, Constants.ArenaVirus, Constants.ArenaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.BunyaVirusRef, Constants.BunyaVirus, Constants.BunyaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CaliciVirusesRef, Constants.CaliciViruses, Constants.CaliciVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoronaVirusRef, Constants.CoronaVirus, Constants.CoronaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.DeltaVirusRef, Constants.DeltaVirus, Constants.DeltaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.DengueVirusRef, Constants.DengueVirus, Constants.DengueVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.EbolaVirusRef, Constants.EbolaVirus, Constants.EbolaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.FiloviridaeRef, Constants.Filoviridae, Constants.FiloviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.FiloVirusRef, Constants.FiloVirusRef, Constants.FiloVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.FlaviVirusRef, Constants.FlaviVirus, Constants.FlaviVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HantaVirusRef, Constants.HantaVirus, Constants.HantaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HepatitisCVirusRef, Constants.HepatitisCVirus, Constants.HepatitisCVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HepatitisDeltaVirusRef, Constants.HepatitisDeltaVirus, Constants.HepatitisDeltaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.JapaneseEncephalitisVirusRef, Constants.JapaneseEncephalitisVirus, Constants.JapaneseEncephalitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LentiVirusRef, Constants.LentiVirus, Constants.LentiVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeukemiaVirusesRef, Constants.LeukemiaViruses, Constants.LeukemiaVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MarburgVirusRef, Constants.MarburgVirus, Constants.MarburgVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MeaslesVirusRef, Constants.MeaslesVirus, Constants.MeaslesVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MumpsVirusRef, Constants.MumpsVirus, Constants.MumpsVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.OncoVirusRef, Constants.OncoVirus, Constants.OncoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.OrthomyxoVirusesRef, Constants.OrthomyxoViruses, Constants.OrthomyxoVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ParamyxoVirusesRef, Constants.ParamyxoViruses, Constants.ParamyxoVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReoVirusRef, Constants.ReoVirus, Constants.ReoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RespiratorySyncytialVirusRef, Constants.RespiratorySyncytialVirus, Constants.RespiratorySyncytialVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhabdoviridaeRef, Constants.Rhabdoviridae, Constants.RhabdoviridaeRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhabdoVirusRef, Constants.RhabdoVirus, Constants.RhabdoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RubellaVirusRef, Constants.RubellaVirus, Constants.RubellaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SarcomaVirusRef, Constants.SarcomaVirus, Constants.SarcomaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StLouisEncephalitisVirusRef, Constants.StLouisEncephalitisVirus, Constants.StLouisEncephalitisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.TogaVirusesRef, Constants.TogaViruses, Constants.TogaVirusesRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.YellowFeverVirusRef, Constants.YellowFeverVirus, Constants.YellowFeverVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("RNA Picornaviridae", Constants.Title, Constants.Title,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AphthoVirusRef, Constants.AphthoVirus, Constants.AphthoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CardioVirusRef, Constants.CardioVirus, Constants.CardioVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoxsackieBVirusRef, Constants.CoxsackieBVirus, Constants.CoxsackieBVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.EncephalomyocarditisVirusRef, Constants.EncephalomyocarditisVirus, Constants.EncephalomyocarditisVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HepatoVirusRef, Constants.HepatoVirus, Constants.HepatoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MengoVirusRef, Constants.MengoVirus, Constants.MengoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.PicornaVirusRef, Constants.PicornaVirus, Constants.PicornaVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhinoVirusRef, Constants.RhinoVirus, Constants.RhinoVirusRef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhinoVirus14Ref, Constants.RhinoVirus14, Constants.RhinoVirus14Ref,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhinoVirus1ARef, Constants.RhinoVirus1A, Constants.RhinoVirus1ARef,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.xx, Constants.xx, Constants.xx,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.xx, Constants.xx, Constants.xx,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.xx, Constants.xx, Constants.xx,"Viruses:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	}
	
	
	public void initMethods() {

		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Metabolize");
		method.setMethodName("Metabolize");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Viruses.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Viruses
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Viruses.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Viruses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		
		String body = ""; 		
		if (lod == Constants.MAG1X)
		{
			System.out.println("In Viruses - MAG1X - Getting X3D");
			
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String viruses[] = {Constants.AdenovirusRef,  Constants.AIDSVirusRef, 
					            Constants.HerpesVirusRef, Constants.ReoVirusRef, Constants.RotaVirusRef, Constants.InfluenzaAVirusesRef,
					            Constants.EnteroVirusRef, Constants.RhabdoVirusRef, Constants.DengueVirusRef, Constants.WestNileVirusRef,
					            Constants.FlaviVirusRef, Constants.CacheValleyVirusRef, Constants.EnteroVirusRef, Constants.HendraVirusRef,
					            Constants.InfluenzaAVirusRef, Constants.LassaFeverVirusRef,  Constants.LymphocyticChorioMeningitisVirusRef,
					            Constants.MolluscumContagiosumVirusRef, Constants.LymphocyticChorioMeningitisVirusRef, Constants.MolluscumContagiosumVirusRef,
					            Constants.NipahVirusRef, Constants.LymphocyticChorioMeningitisVirus, Constants.NipahVirusRef, Constants.MolluscumContagiosumVirusRef,
					            Constants.MolluscumContagiosumVirusRef, Constants.NoroVirusRef, Constants.WhitewaterArroyoVirusRef, 
					            Constants.AstroVirusRef, Constants.CalicivirusRef, Constants.CircoVirusRef, Constants.AdenoviridaeRef,
					            Constants.ArenaVirusRef, Constants.BunyaVirusRef,  Constants.CaliciVirusesRef, Constants.CoronaVirusRef,
					            Constants.DeltaVirusRef, Constants.DengueVirusRef,	Constants.EbolaVirusRef, Constants.FiloviridaeRef,
					            Constants.FiloVirusRef, Constants.HantaVirusRef, Constants.HantaVirusRef, Constants.HepatitisCVirusRef,
					            Constants.HepatitisDeltaVirusRef, Constants.JapaneseEncephalitisVirusRef, Constants.LentiVirusRef,
					            Constants.LeukemiaVirusesRef, Constants.MarburgVirusRef,Constants.MarburgVirusRef, Constants.MeaslesVirusRef,
					            Constants.MarburgVirusRef, Constants.MumpsVirusRef, Constants.OncoVirusRef, Constants.OrthomyxoVirusesRef,
					            Constants.LeukemiaVirusesRef, Constants.MeaslesVirusRef, Constants.MumpsVirusRef, Constants.OrthomyxoVirusesRef,
					            Constants.ParamyxoVirusesRef, Constants.ReoVirusRef, Constants.RespiratorySyncytialVirusRef, Constants.RhabdoviridaeRef,
					            Constants.RetroVirusRef, Constants.RhabdoVirusRef, Constants.RotaVirusRef, Constants.RubellaVirusRef,
					            Constants.StaphylococcusAureus, Constants.SarcomaVirusRef, Constants.StLouisEncephalitisVirusRef,
					            Constants.TogaVirusesRef, Constants.YellowFeverVirusRef, Constants.AphthoVirusRef, Constants.CardioVirusRef, 
					            Constants.CoxsackieBVirusRef, Constants.EncephalomyocarditisVirusRef, Constants.EncephalomyocarditisVirusRef,
					            Constants.HepatoVirusRef, Constants.MengoVirusRef, Constants.PicornaVirusRef, Constants.RhinoVirusRef, 
					            Constants.RhinoVirus14Ref, Constants.RhinoVirus1ARef,
			};

			
			for (int i=0; i<viruses.length; i++)
			{
				//System.out.println("Creating X3D for : " + cells[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + viruses[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
				//System.out.println("Set Translation: ");				

				if (i % 11 == 0) {
					yPos = -7.0;
					xPos += 1.50;
				}
			 	yPos -= -1.00;

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + viruses[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + viruses[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + viruses[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+viruses[i]+"Touch' \n" +
	                   " description='"+viruses[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				//System.out.println("Set Transform: ");				

			}
		}
		else if (lod == Constants.MAG2X)
		{
			System.out.println("In Viruses - Getting X3D - MAG2X");
			body = 
					//dnaVirusTitle +
					adenoviruses.getX3D(true) +
					//bacteriophages.getX3D(true) +
					aidsVirus.getX3D(true) +
					reoViruses.getX3D(true) +
					rotaviruses.getX3D(true) +
					influenzaAViruses.getX3D(true) +
					enteroViruses.getX3D(true) +
					rhabdoVirus.getX3D(true) + 
					//rnaVirusTitle +
					dengueVirus.getX3D(true) +
					westNileVirus.getX3D(true) +
					flaviVirus.getX3D(true);
		}
		
		
		String viewpoint = "<Viewpoint DEF='Viewpoint1'\n" +
			 "description='Viewpoint1'\n" +
			 "jump='true'\n" +
			 "fieldOfView='0.785'\n" +
			 "position='5.0 -5.0 25.0'\n" +
			 "orientation='0 0 1 0'/>\n";
	
		
		//System.out.println("Virus Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return viewpoint + body;			
		else	
			return header + viewpoint + body + footer;
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Viruss.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3DOLDOLD(boolean snipet) {
		
		// Assemble the Viruses
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Viruses.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Viruses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		
		BioMightPosition bioMightPosition = new BioMightPosition(0.0, 1.15, 0.0);		
		String dnaVirusTitle = 
			"<Transform DEF='VirusText' \n" +
			"translation='" + bioMightPosition.getXPos() + " "  
			+ bioMightPosition.getYPos() + " "
			+ bioMightPosition.getZPos() + "'>\n" +
				"<Shape DEF='AIDSVirus'>\n" +
				"<Appearance\n" +
				"containerField='appearance'>\n" +
				"<Material containerField='material' DEF='Rust'/>\n" +
				"</Appearance>\n" +
				"<Text DEF='GeoText2'\n" +
				"containerField='geometry'\n" +
				"string='\"DNA Viruses\"'\n" +
				"maxExtent='0.000'>\n" +
				"<FontStyle\n" +
				"containerField='fontStyle'\n" +
				"family='SERIF'\n" +
				"style='ITALIC'\n" +
				"justify='\"BEGIN\" \"BEGIN\"'\n" +
				"size='0.500'\n" +
				"spacing='0.50'/>\n" +
				"</Text>\n" +
				"</Shape>\n" +
			"</Transform>\n";

		bioMightPosition = new BioMightPosition(9.5, 1.15, 0.0);
		String rnaVirusTitle = 
			"<Transform DEF='VirusText' \n" +
			"translation='" + bioMightPosition.getXPos() + " "  
			+ (bioMightPosition.getYPos()+0.00) + " "
			+ bioMightPosition.getZPos() + "'>\n" +
				"<Shape DEF='AIDSVirus'>\n" +
				"<Appearance\n" +
				"containerField='appearance'>\n" +
				"<Material containerField='material' USE='Rust'/>\n" +
				"</Appearance>\n" +
				"<Text DEF='GeoText2'\n" +
				"containerField='geometry'\n" +
				"string='\"RNA Viruses\"'\n" +
				"maxExtent='0.000'>\n" +
				"<FontStyle\n" +
				"containerField='fontStyle'\n" +
				"family='SERIF'\n" +
				"style='ITALIC'\n" +
				"justify='\"BEGIN\" \"BEGIN\"'\n" +
				"size='0.500'\n" +
				"spacing='0.50'/>\n" +
				"</Text>\n" +
				"</Shape>\n" +
			"</Transform>\n";		
	
	
		String body ="";

		
		System.out.println("Virus Collection X3D: " + body);
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
		
		
	/**
	 * @return
	 */
	public Adenoviridae getAdenoviridae() {
		return adenoviridae;
	}

	/**
	 * @return
	 */
	public Adenoviruses getAdenoviruses() {
		return adenoviruses;
	}

	/**
	 * @return
	 */
	public AstroVirus getAstroVirus() {
		return astroVirus;
	}

	/**
	 * @return
	 */
	public BKVirus getBKVirus() {
		return bKVirus;
	}

	/**
	 * @return
	 */
	public CacheValleyVirus getCacheValleyVirus() {
		return cacheValleyVirus;
	}

	/**
	 * @return
	 */
	public Calicivirus getCalicivirus() {
		return calicivirus;
	}

	/**
	 * @return
	 */
	public CircoVirus getCircoVirus() {
		return circoVirus;
	}

	/**
	 * @return
	 */
	public CoxsackieA getCoxsackieA() {
		return coxsackieA;
	}

	/**
	 * @return
	 */
	public CytoMegaloVirus getCytoMegaloVirus() {
		return CytoMegaloVirus;
	}

	/**
	 * @return
	 */
	public Echovirus getEchovirus() {
		return echovirus;
	}

	/**
	 * @return
	 */
	public EnteroViruses getEnteroViruses() {
		return enteroViruses;
	}

	/**
	 * @return
	 */
	public EpsteinBarrVirus getEpsteinBarrVirus() {
		return epsteinBarrVirus;
	}

	/**
	 * @return
	 */
	public HendraVirus getHendraVirus() {
		return hendraVirus;
	}

	/**
	 * @return
	 */
	public HepadnaVirus getHepadnaVirus() {
		return hepadnaVirus;
	}

	/**
	 * @return
	 */
	public HepatitisAVirus getHepatitisAVirus() {
		return hepatitisAVirus;
	}

	/**
	 * @return
	 */
	public HepatitisDVirus getHepatitisDVirus() {
		return hepatitisDVirus;
	}

	/**
	 * @return
	 */
	public HepatitisEVirus getHepatitisEVirus() {
		return hepatitisEVirus;
	}

	/**
	 * @return
	 */
	public HerpesSimplexVirus1 getHerpesSimplexVirus1() {
		return HerpesSimplexVirus1;
	}

	/**
	 * @return
	 */
	public HerpesSimplexVirus2 getHerpesSimplexVirus2() {
		return herpesSimplexVirus2;
	}

	/**
	 * @return
	 */
	public HerpesVirus getHerpesVirus() {
		return herpesVirus;
	}

	/**
	 * @return
	 */
	public HepatitisBVirus getHhepatitisBVirus() {
		return HhepatitisBVirus;
	}

	/**
	 * @return
	 */
	public HumanHerpesVirus6 getHumanHerpesVirus6() {
		return humanHerpesVirus6;
	}

	/**
	 * @return
	 */
	public HumanHerpesVirus8 getHumanHerpesVirus8() {
		return humanHerpesVirus8;
	}

	/**
	 * @return
	 */
	public InfluenzaAViruses getInfluenzaAViruses() {
		return influenzaAViruses;
	}

	/**
	 * @return
	 */
	public JCVirus getJCVirus() {
		return jCVirus;
	}

	/**
	 * @return
	 */
	public LassaFeverVirus getLassaFeverVirus() {
		return lassaFeverVirus;
	}

	/**
	 * @return
	 */
	public LymphocyticChorioMeningitisVirus getLymphocyticChorioMeningitisVirus() {
		return lymphocyticChorioMeningitisVirus;
	}

	/**
	 * @return
	 */
	public MolluscumContagiosumVirus getMolluscumContagiosumVirus() {
		return molluscumContagiosumVirus;
	}

	/**
	 * @return
	 */
	public NipahVirus getNipahVirus() {
		return nipahVirus;
	}



	/**
	 * @return
	 */
	public PapillomaVirus getPapillomaVirus() {
		return papillomaVirus;
	}

	/**
	 * @return
	 */
	public PapovaViridae getPapovaViridae() {
		return papovaViridae;
	}

	/**
	 * @return
	 */
	public PapoViruses getPapoViruses() {
		return papoViruses;
	}

	/**
	 * @return
	 */
	public ParvoVirus getParvoVirus() {
		return parvoVirus;
	}

	/**
	 * @return
	 */
	public PolioVirus getPolioVirus() {
		return polioVirus;
	}

	/**
	 * @return
	 */
	public PoxViridae getPoxViridae() {
		return poxViridae;
	}

	/**
	 * @return
	 */
	public Vaccinia getVaccinia() {
		return vaccinia;
	}

	/**
	 * @return
	 */
	public VaricellaZosterVirus getVaricellaZosterVirus() {
		return varicellaZosterVirus;
	}

	/**
	 * @return
	 */
	public WhitewaterArroyoVirus getWhitewaterArroyoVirus() {
		return whitewaterArroyoVirus;
	}

	/**
	 * @param adenoviridae
	 */
	public void setAdenoviridae(Adenoviridae adenoviridae) {
		this.adenoviridae = adenoviridae;
	}

	/**
	 * @param adenovirus
	 */
	public void setAdenovirus(Adenoviruses adenoviruses) {
		this.adenoviruses = adenoviruses;
	}

	/**
	 * @param virus
	 */
	public void setAstroVirus(AstroVirus virus) {
		astroVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setBKVirus(BKVirus virus) {
		bKVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setCacheValleyVirus(CacheValleyVirus virus) {
		cacheValleyVirus = virus;
	}

	/**
	 * @param calicivirus
	 */
	public void setCalicivirus(Calicivirus calicivirus) {
		this.calicivirus = calicivirus;
	}

	/**
	 * @param virus
	 */
	public void setCircoVirus(CircoVirus virus) {
		circoVirus = virus;
	}

	/**
	 * @param coxsackieA
	 */
	public void setCoxsackieA(CoxsackieA coxsackieA) {
		this.coxsackieA = coxsackieA;
	}

	/**
	 * @param virus
	 */
	public void setCytoMegaloVirus(CytoMegaloVirus virus) {
		CytoMegaloVirus = virus;
	}

	/**
	 * @param echovirus
	 */
	public void setEchovirus(Echovirus echovirus) {
		this.echovirus = echovirus;
	}

	/**
	 * @param virus
	 */
	public void setEnteroVirus(EnteroViruses viruses) {
		enteroViruses = viruses;
	}

	/**
	 * @param virus
	 */
	public void setEpsteinBarrVirus(EpsteinBarrVirus virus) {
		epsteinBarrVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHendraVirus(HendraVirus virus) {
		hendraVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHepadnaVirus(HepadnaVirus virus) {
		hepadnaVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHepatitisAVirus(HepatitisAVirus virus) {
		hepatitisAVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHepatitisDVirus(HepatitisDVirus virus) {
		hepatitisDVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHepatitisEVirus(HepatitisEVirus virus) {
		hepatitisEVirus = virus;
	}

	/**
	 * @param virus1
	 */
	public void setHerpesSimplexVirus1(HerpesSimplexVirus1 virus1) {
		HerpesSimplexVirus1 = virus1;
	}

	/**
	 * @param virus2
	 */
	public void setHerpesSimplexVirus2(HerpesSimplexVirus2 virus2) {
		herpesSimplexVirus2 = virus2;
	}

	/**
	 * @param virus
	 */
	public void setHerpesVirus(HerpesVirus virus) {
		herpesVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setHhepatitisBVirus(HepatitisBVirus virus) {
		HhepatitisBVirus = virus;
	}

	/**
	 * @param virus6
	 */
	public void setHumanHerpesVirus6(HumanHerpesVirus6 virus6) {
		humanHerpesVirus6 = virus6;
	}

	/**
	 * @param virus8
	 */
	public void setHumanHerpesVirus8(HumanHerpesVirus8 virus8) {
		humanHerpesVirus8 = virus8;
	}

	/**
	 * @param virus
	 */
	public void setInfluenzaAViruses(InfluenzaAViruses viruses) {
		influenzaAViruses = viruses;
	}

	/**
	 * @param virus
	 */
	public void setJCVirus(JCVirus virus) {
		jCVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setLassaFeverVirus(LassaFeverVirus virus) {
		lassaFeverVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setLymphocyticChorioMeningitisVirus(LymphocyticChorioMeningitisVirus virus) {
		lymphocyticChorioMeningitisVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setMolluscumContagiosumVirus(MolluscumContagiosumVirus virus) {
		molluscumContagiosumVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setNipahVirus(NipahVirus virus) {
		nipahVirus = virus;
	}


	/**
	 * @param virus
	 */
	public void setPapillomaVirus(PapillomaVirus virus) {
		papillomaVirus = virus;
	}

	/**
	 * @param viridae
	 */
	public void setPapovaViridae(PapovaViridae viridae) {
		papovaViridae = viridae;
	}

	/**
	 * @param viruses
	 */
	public void setPapoViruses(PapoViruses viruses) {
		papoViruses = viruses;
	}

	/**
	 * @param virus
	 */
	public void setParvoVirus(ParvoVirus virus) {
		parvoVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setPolioVirus(PolioVirus virus) {
		polioVirus = virus;
	}

	/**
	 * @param viridae
	 */
	public void setPoxViridae(PoxViridae viridae) {
		poxViridae = viridae;
	}

	/**
	 * @param vaccinia
	 */
	public void setVaccinia(Vaccinia vaccinia) {
		this.vaccinia = vaccinia;
	}

	/**
	 * @param virus
	 */
	public void setVaricellaZosterVirus(VaricellaZosterVirus virus) {
		varicellaZosterVirus = virus;
	}

	/**
	 * @param virus
	 */
	public void setWhitewaterArroyoVirus(WhitewaterArroyoVirus virus) {
		whitewaterArroyoVirus = virus;
	}

}
