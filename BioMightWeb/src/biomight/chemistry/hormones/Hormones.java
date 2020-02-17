
package biomight.chemistry.hormones;

import java.util.ArrayList;

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
import biomight.view.BioMightTransforms;

/************************************************************************************************
 * @author SurferJim
 *
 * Represents a collection of Hormones that are commonly
 * used in organics
 * 
 ************************************************************************************************/

public class Hormones extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	//private Aluminum aluminum;

		

	/************************************************************************
	 * Hormones Constructor 
	 *
	 ***********************************************************************/
	public Hormones()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.HormonesRef, null, null);
	}

	/************************************************************************
	 * Hormones Constructor 
	 *
	 ***********************************************************************/
	public Hormones(String parentID)
	{
		System.out.print("Calling parameterized Hormones Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Hormones(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Hormones
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Hormones.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Hormones for: " + parentID);
		
		// Get the data for the Hormones that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting HormonesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.HormonesRef, parentID);
			System.out.println("Have Hormones Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Hormones");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Hormones METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Hormones, NumTransforms : " + transforms.size());

		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Enymes.x3d";
		
		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			// A hack, I am using the values down below in the X3D method to set some appearance  and material values
			gbioMightTransform  = bioMightTransform;
			System.out.println("Set Global: " + gbioMightTransform.getComponentID());
					
			componentID = bioMightTransform.getId();
			System.out.println("Creating Hormones: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating Hormones - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Hormones: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Hormones at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				//System.out.println("In Hormones - Creating Carbon");
				//carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				//initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				//System.out.println("In Hormones - Carbon is complete");
			
				initProperty(Constants.LyaseRef, Constants.Lyase, Constants.LyaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.MaltaseRef, Constants.Maltase, Constants.MaltaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.TrypsinRef, Constants.Trypsin, Constants.TrypsinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
						
			}
		
		}
		
			
	
		initMethods();
		System.out.println("Created Hormones");				
	}
	
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ADPRef, Constants.ADP, Constants.ADPRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AP1Ref, Constants.ADP, Constants.ADPRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BetaEndorphinRef, Constants.BetaEndorphin, Constants.BetaEndorphinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BombesinRef, Constants.AdenosineTriPhosphate, Constants.AdenosineTriPhosphateRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CholecytoskininRef, Constants.Cholecytoskinin, Constants.CholecytoskininRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdiponectinRef, Constants.Adiponectin, Constants.AdiponectinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdrenoCorticotropicHormoneRef, Constants.AdrenoCorticotropicHormone, Constants.AdrenoCorticotropicHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AlphaDefensinsRef, Constants.AlphaDefensins, Constants.AlphaDefensinsRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AMHRef, Constants.AMH, Constants.AMHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AngiotensinRef, Constants.Angiotensin, Constants.AngiotensinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AngiotensinogenRef, Constants.Angiotensinogen, Constants.AngiotensinogenRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ANPRef, Constants.ANP, Constants.ANPRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AntidiureticHormoneRef, Constants.AntidiureticHormone, Constants.AntidiureticHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ArginineVasopressinRef, Constants.ArginineVasopressin, Constants.ArginineVasopressinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AtrialNatriureticPeptideRef, Constants.AtrialNatriureticPeptide, Constants.AtrialNatriureticPeptideRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BetaDefensinHDB1Ref, Constants.BetaDefensinHDB1, Constants.BetaDefensinHDB1Ref, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BetaDefensinHDB2Ref, Constants.BetaDefensinHDB2, Constants.BetaDefensinHDB2Ref, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BetaDefensins, Constants.BetaDefensins, Constants.BetaDefensinsRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CalcitoninRef, Constants.Chymotrypsin, Constants.ChymotrypsinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CCKRef, Constants.CCK, Constants.CCKRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CholecystokininRef, Constants.Cholecystokinin, Constants.CholecystokininRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoatAssociatedProteinRef, Constants.CoatAssociatedProtein, Constants.CoatAssociatedProteinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoatAssociatedProteinIRef, Constants.CoatAssociatedProteinI, Constants.CoatAssociatedProteinIRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoatAssociatedProteinIIRef, Constants.CoatAssociatedProteinII, Constants.CoatAssociatedProteinIIRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ConstitutiveAndrostaneReceptorRef, Constants.ConstitutiveAndrostaneReceptor, Constants.ConstitutiveAndrostaneReceptorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CorticotropinReleasingHormoneRef, Constants.CorticotropinReleasingHormone, Constants.CorticotropinReleasingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CRHRef, Constants.CRH, Constants.CRHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DefensinRef, Constants.Defensin, Constants.DefensinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EpidermalGrowthFactorRef, Constants.EpidermalGrowthFactor, Constants.EpidermalGrowthFactorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ErythropoietinRef, Constants.Erythropoietin, Constants.ErythropoietinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EstrogenReceptorRef, Constants.EstrogenReceptor, Constants.EstrogenReceptorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.FollicleStimulatingHormoneRef, Constants.FollicleStimulatingHormone, Constants.FollicleStimulatingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.FollistatinRef, Constants.FollistatinRef, Constants.FollistatinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GastrinRef, Constants.Gastrin, Constants.GastrinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GhrelinRef, Constants.Ghrelin, Constants.GhrelinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GHRHRef, Constants.GHRH, Constants.GHRHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GlucagonRef, Constants.Glucagon, Constants.GlucagonRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GnRHRef, Constants.GnRH, Constants.GnRHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GuanosineDiPhosphateRef, Constants.GuanosineDiPhosphate, Constants.GuanosineDiPhosphateRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.GuanosineTriPhosphateRef, Constants.GuanosineTriPhosphateRef, Constants.GuanosineTriPhosphateRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HCGRef, Constants.HCGRef, Constants.HCGRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HighDensityLipoProteinRef, Constants.HighDensityLipoProtein, Constants.HighDensityLipoProteinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InhibinRef, Constants.Inhibin, Constants.InhibinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InsulinRef, Constants.Insulin, Constants.InsulinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InsulinGrowthFactorIRef, Constants.InsulinGrowthFactorI, Constants.InsulinGrowthFactorIRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InsulinGrowthFactorIIRef, Constants.InsulinGrowthFactorII, Constants.InsulinGrowthFactorIIRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.IpanoicAcidRef, Constants.IpanoicAcid, Constants.IpanoicAcidRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.JanusKinaseRef, Constants.JanusKinase, Constants.JanusKinaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeptinRef, Constants.Leptin, Constants.LeptinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LowDensityLipoProteinRef, Constants.LowDensityLipoProtein, Constants.LowDensityLipoProteinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LuteinizingHormoneRef, Constants.LuteinizingHormone, Constants.LuteinizingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MelanoCortinReceptorRef, Constants.MelanoCortinReceptor, Constants.MelanoCortinReceptorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MelanocyteStimulatingHormoneRef, Constants.MelanocyteStimulatingHormone, Constants.MelanocyteStimulatingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MitosisAssociatedProteinKinaseRef, Constants.MitosisAssociatedProteinKinase, Constants.MitosisAssociatedProteinKinaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MonoAmineOxidaseRef, Constants.MonoAmineOxidase, Constants.MonoAmineOxidaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.NethylMaleimideSensitiveFactorRef, Constants.NethylMaleimideSensitiveFactor, Constants.NethylMaleimideSensitiveFactorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.NeuropeptideYRef, Constants.NeuropeptideY, Constants.NeuropeptideYRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.OxytocinRef, Constants.Oxytocin, Constants.OxytocinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.OxytoxinRef, Constants.Oxytoxin, Constants.OxytoxinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PeptideHormoneRef, Constants.PeptideHormone, Constants.PeptideHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProInsulinRef, Constants.ProInsulin, Constants.ProInsulinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PTHRef, Constants.PTH, Constants.PTHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RelaxinRef, Constants.Relaxin, Constants.RelaxinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReninRef, Constants.Renin, Constants.ReninRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ResistinRef, Constants.Resistin, Constants.ResistinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SecretinRef, Constants.Secretin, Constants.SecretinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SH2ProteinDomainRef, Constants.SH2ProteinDomain, Constants.SH2ProteinDomainRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SignalRecognitionParticleRef, Constants.SignalRecognitionParticle, Constants.SignalRecognitionParticleRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SignalRecognitionParticleReceptorRef, Constants.SignalRecognitionParticleReceptor, Constants.SignalRecognitionParticleReceptorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SomatostatinRef, Constants.Somatostatin, Constants.SomatostatinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SomatotropinRef, Constants.Somatotropin, Constants.SomatotropinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SrcFamilyKinasesRef, Constants.SrcFamilyKinases, Constants.SrcFamilyKinasesRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SterolCarrierProtein2Ref, Constants.SterolCarrierProtein2, Constants.SterolCarrierProtein2Ref, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThrombopoietinRef, Constants.Thrombopoietin, Constants.ThrombopoietinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroGlobulinRef, Constants.ThyroGlobulin, Constants.ThyroGlobulinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroPeriOxidaseRef, Constants.ThyroPeriOxidase, Constants.ThyroPeriOxidaseRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyrotropinReleasingHormoneRef, Constants.ThyrotropinReleasingHormone, Constants.ThyrotropinReleasingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroxineBindingGlobulinRef, Constants.ThyroxineBindingGlobulin, Constants.ThyroxineBindingGlobulinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroxinStimulatingHormoneRef, Constants.ThyroxinStimulatingHormone, Constants.ThyroxinStimulatingHormoneRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TransformingGrowthFactorRef, Constants.TransformingGrowthFactor, Constants.TransformingGrowthFactorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TransformingGrowthFactorAlphaRef, Constants.TransformingGrowthFactorAlpha, Constants.TransformingGrowthFactorAlphaRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TransformingGrowthFactorBetaRef, Constants.TransformingGrowthFactorBeta, Constants.TransformingGrowthFactorBetaRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TransThyretinRef, Constants.TransThyretin, Constants.TransThyretinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TriIodoThyroAceticAcidRef, Constants.TriIodoThyroAceticAcid, Constants.TriIodoThyroAceticAcidRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TSHRef, Constants.TSH, Constants.TSHRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TumorNecrosisFactorRef, Constants.TumorNecrosisFactor, Constants.TumorNecrosisFactorRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.VanillylmandelicAcidRef, Constants.VanillylmandelicAcid, Constants.VanillylmandelicAcidRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		//initProperty(Constants.VasopressinRef, Constants.Vasopressin, Constants.VasopressinRef, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				
		
		/*
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Hormones:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		*/	
					
	}
	
	
	public void initMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Create Molecule");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("Ionize");
		method.setHtmlType("checkbox");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("deIonize");
		method.setHtmlType("checkbox");
		methods.add(method);	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Molecules.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Molecules
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Molecules.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Molecules'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Creating X3D for Hormones----");	
		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String hormones[] = 
				{
				Constants.ActivinRef,  Constants.AdenosineDiPhosphateRef, Constants.AdenosineTriPhosphateRef, Constants.ADHRef, Constants.AdiponectinRef,
				Constants.AdrenoCorticotropicHormoneRef, Constants.AlphaDefensinsRef, Constants.AMHRef, Constants.AngiotensinRef, Constants.AngiotensinogenRef,
				Constants.AntidiureticHormoneRef, Constants.ArginineVasopressinRef, Constants.AtrialNatriureticPeptideRef, Constants.BetaDefensinHDB1Ref,
				Constants.BetaDefensinHDB2Ref,  Constants.BetaDefensinsRef, Constants.BetaDefensinHDB1Ref, Constants.BetaDefensinHDB2Ref, 
				Constants.CalcitoninRef, Constants.ChymotrypsinRef, Constants.CCKRef, Constants.CholecystokininRef, Constants.CoatAssociatedProteinRef,  
				Constants.CoatAssociatedProteinIRef, Constants.CoatAssociatedProteinIIRef, Constants.ConstitutiveAndrostaneReceptorRef, 
				Constants.CorticotropinReleasingHormoneRef, Constants.CRHRef, Constants.DefensinRef, Constants.EpidermalGrowthFactorRef, 
				Constants.ErythropoietinRef, Constants.EstrogenReceptorRef, Constants.FollicleStimulatingHormoneRef, Constants.FollistatinRef,
				Constants.GastrinRef, Constants.GhrelinRef, Constants.GHRHRef, Constants.GlucagonRef, Constants.GnRHRef, Constants.GuanosineDiPhosphateRef, 
				Constants.GuanosineTriPhosphateRef, Constants.HCGRef, Constants.HighDensityLipoProteinRef, Constants.InhibinRef, Constants.InsulinRef, 
				Constants.InsulinGrowthFactorIRef, Constants.InsulinGrowthFactorIIRef, Constants.IpanoicAcidRef, Constants.JanusKinaseRef, 
				Constants.LeptinRef, Constants.LowDensityLipoProteinRef, Constants.LuteinizingHormoneRef, Constants.MelanoCortinReceptorRef,
				Constants.MelanocyteStimulatingHormoneRef, Constants.MitosisAssociatedProteinKinaseRef, Constants.MonoAmineOxidaseRef, 
				Constants.NethylMaleimideSensitiveFactorRef, Constants.NeuropeptideYRef, Constants.OxytocinRef, Constants.OxytoxinRef, 
				Constants.PeptideHormoneRef, Constants.ProInsulinRef, Constants.PTHRef, Constants.RelaxinRef, Constants.ReninRef, 
				Constants.ResistinRef, Constants.SecretinRef, Constants.SH2ProteinDomainRef, Constants.SignalRecognitionParticleRef,
				Constants.SignalRecognitionParticleReceptorRef, Constants.SomatostatinRef, Constants.SomatotropinRef, Constants.SrcFamilyKinasesRef, 
				Constants.SterolCarrierProtein2Ref, Constants.ThrombopoietinRef, Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, 
				Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, Constants.ThyrotropinReleasingHormoneRef,
				Constants.ThyroxineBindingGlobulinRef, Constants.ThyroxinStimulatingHormoneRef, Constants.TransformingGrowthFactorRef,
				Constants.TransformingGrowthFactorAlphaRef, Constants.TransformingGrowthFactorBetaRef, Constants.TransThyretinRef,
				Constants.TriIodoThyroAceticAcidRef, Constants.TSHRef, Constants.TumorNecrosisFactorRef, Constants.VanillylmandelicAcidRef, 
				Constants.VasopressinRef 
				};
			

			
			
			String hormoneNames[] = 
				{
					Constants.ActivinRef,  Constants.AdenosineDiPhosphateRef, Constants.AdenosineTriPhosphateRef, Constants.ADHRef, Constants.AdiponectinRef,
					Constants.AdrenoCorticotropicHormoneRef, Constants.AlphaDefensinsRef, Constants.AMHRef, Constants.AngiotensinRef, Constants.AngiotensinogenRef,
					Constants.AntidiureticHormoneRef, Constants.ArginineVasopressinRef, Constants.AtrialNatriureticPeptideRef, Constants.BetaDefensinHDB1Ref,
					Constants.BetaDefensinHDB2Ref,  Constants.BetaDefensinsRef, Constants.BetaDefensinHDB1Ref, Constants.BetaDefensinHDB2Ref, 
					Constants.CalcitoninRef, Constants.ChymotrypsinRef, Constants.CCKRef, Constants.CholecystokininRef, Constants.CoatAssociatedProteinRef,  
					Constants.CoatAssociatedProteinIRef, Constants.CoatAssociatedProteinIIRef, Constants.ConstitutiveAndrostaneReceptorRef, 
					Constants.CorticotropinReleasingHormoneRef, Constants.CRHRef, Constants.DefensinRef, Constants.EpidermalGrowthFactorRef, 
					Constants.ErythropoietinRef, Constants.EstrogenReceptorRef, Constants.FollicleStimulatingHormoneRef, Constants.FollistatinRef,
					Constants.GastrinRef, Constants.GhrelinRef, Constants.GHRHRef, Constants.GlucagonRef, Constants.GnRHRef, Constants.GuanosineDiPhosphateRef, 
					Constants.GuanosineTriPhosphateRef, Constants.HCGRef, Constants.HighDensityLipoProteinRef, Constants.InhibinRef, Constants.InsulinRef, 
					Constants.InsulinGrowthFactorIRef, Constants.InsulinGrowthFactorIIRef, Constants.IpanoicAcidRef, Constants.JanusKinaseRef, 
					Constants.LeptinRef, Constants.LowDensityLipoProteinRef, Constants.LuteinizingHormoneRef, Constants.MelanoCortinReceptorRef,
					Constants.MelanocyteStimulatingHormoneRef, Constants.MitosisAssociatedProteinKinaseRef, Constants.MonoAmineOxidaseRef, 
					Constants.NethylMaleimideSensitiveFactorRef, Constants.NeuropeptideYRef, Constants.OxytocinRef, Constants.OxytoxinRef, 
					Constants.PeptideHormoneRef, Constants.ProInsulinRef, Constants.PTHRef, Constants.RelaxinRef, Constants.ReninRef, 
					Constants.ResistinRef, Constants.SecretinRef, Constants.SH2ProteinDomainRef, Constants.SignalRecognitionParticleRef,
					Constants.SignalRecognitionParticleReceptorRef, Constants.SomatostatinRef, Constants.SomatotropinRef, Constants.SrcFamilyKinasesRef, 
					Constants.SterolCarrierProtein2Ref, Constants.ThrombopoietinRef, Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, 
					Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, Constants.ThyrotropinReleasingHormoneRef,
					Constants.ThyroxineBindingGlobulinRef, Constants.ThyroxinStimulatingHormoneRef, Constants.TransformingGrowthFactorRef,
					Constants.TransformingGrowthFactorAlphaRef, Constants.TransformingGrowthFactorBetaRef, Constants.TransThyretinRef,
					Constants.TriIodoThyroAceticAcidRef, Constants.TSHRef, Constants.TumorNecrosisFactorRef, Constants.VanillylmandelicAcidRef, 
					Constants.VasopressinRef 				
			};
			
			String hormoneDesc[] = 
				{
					Constants.ActivinRef,  Constants.AdenosineDiPhosphateRef, Constants.AdenosineTriPhosphateRef, Constants.ADHRef, Constants.AdiponectinRef,
					Constants.AdrenoCorticotropicHormoneRef, Constants.AlphaDefensinsRef, Constants.AMHRef, Constants.AngiotensinRef, Constants.AngiotensinogenRef,
					Constants.AntidiureticHormoneRef, Constants.ArginineVasopressinRef, Constants.AtrialNatriureticPeptideRef, Constants.BetaDefensinHDB1Ref,
					Constants.BetaDefensinHDB2Ref,  Constants.BetaDefensinsRef, Constants.BetaDefensinHDB1Ref, Constants.BetaDefensinHDB2Ref, 
					Constants.CalcitoninRef, Constants.ChymotrypsinRef, Constants.CCKRef, Constants.CholecystokininRef, Constants.CoatAssociatedProteinRef,  
					Constants.CoatAssociatedProteinIRef, Constants.CoatAssociatedProteinIIRef, Constants.ConstitutiveAndrostaneReceptorRef, 
					Constants.CorticotropinReleasingHormoneRef, Constants.CRHRef, Constants.DefensinRef, Constants.EpidermalGrowthFactorRef, 
					Constants.ErythropoietinRef, Constants.EstrogenReceptorRef, Constants.FollicleStimulatingHormoneRef, Constants.FollistatinRef,
					Constants.GastrinRef, Constants.GhrelinRef, Constants.GHRHRef, Constants.GlucagonRef, Constants.GnRHRef, Constants.GuanosineDiPhosphateRef, 
					Constants.GuanosineTriPhosphateRef, Constants.HCGRef, Constants.HighDensityLipoProteinRef, Constants.InhibinRef, Constants.InsulinRef, 
					Constants.InsulinGrowthFactorIRef, Constants.InsulinGrowthFactorIIRef, Constants.IpanoicAcidRef, Constants.JanusKinaseRef, 
					Constants.LeptinRef, Constants.LowDensityLipoProteinRef, Constants.LuteinizingHormoneRef, Constants.MelanoCortinReceptorRef,
					Constants.MelanocyteStimulatingHormoneRef, Constants.MitosisAssociatedProteinKinaseRef, Constants.MonoAmineOxidaseRef, 
					Constants.NethylMaleimideSensitiveFactorRef, Constants.NeuropeptideYRef, Constants.OxytocinRef, Constants.OxytoxinRef, 
					Constants.PeptideHormoneRef, Constants.ProInsulinRef, Constants.PTHRef, Constants.RelaxinRef, Constants.ReninRef, 
					Constants.ResistinRef, Constants.SecretinRef, Constants.SH2ProteinDomainRef, Constants.SignalRecognitionParticleRef,
					Constants.SignalRecognitionParticleReceptorRef, Constants.SomatostatinRef, Constants.SomatotropinRef, Constants.SrcFamilyKinasesRef, 
					Constants.SterolCarrierProtein2Ref, Constants.ThrombopoietinRef, Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, 
					Constants.ThyroGlobulinRef, Constants.ThyroPeriOxidaseRef, Constants.ThyrotropinReleasingHormoneRef,
					Constants.ThyroxineBindingGlobulinRef, Constants.ThyroxinStimulatingHormoneRef, Constants.TransformingGrowthFactorRef,
					Constants.TransformingGrowthFactorAlphaRef, Constants.TransformingGrowthFactorBetaRef, Constants.TransThyretinRef,
					Constants.TriIodoThyroAceticAcidRef, Constants.TSHRef, Constants.TumorNecrosisFactorRef, Constants.VanillylmandelicAcidRef, 
					Constants.VasopressinRef 
			};
					
			System.out.println("Creating X3D for : " + hormones.length);	
			for (int i=0; i<hormones.length; i++)
			{
				System.out.println("Creating X3D for : " + hormones[i]);				
				
				if (i==15) {
					yPos = -0.5;
					xPos = 1.50;
				}
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + hormones[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
			 	yPos--;
			 	
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + hormones[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";


				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + hormoneNames[i] + ".jpg'/>";
					
		
				// HACKY
				System.out.println("Retreiving Global: " + gbioMightTransform.getComponentID());
				
				
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
				 	"<Sphere DEF='" + hormones[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+hormones[i]+"Touch' \n" +
	                   " description='"+hormoneDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}
	
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numHormones into the Create method.  Or we can just make a represention of
			// each cell type.
			body =  "";
					//carbon.getX3D(true) +
					//oxygen.getX3D(true);
		}
		
		
		//System.out.println("Cell Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}



}
