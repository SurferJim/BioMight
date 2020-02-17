/*
 * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.body.gland.gallbladder.GallBladder;
import biomight.body.gland.ovary.FallopianTubes;
import biomight.body.gland.ovary.Ovaries;
import biomight.body.gland.spleen.Spleen;
import biomight.body.organ.bladder.Bladder;
import biomight.body.organ.kidney.Kidneys;
import biomight.body.organ.kidney.Ureters;
import biomight.body.organ.kidney.Urethra;
import biomight.body.organ.largeintestine.LargeIntestine;
import biomight.body.organ.liver.Liver;
import biomight.body.organ.pancreas.Pancreas;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.body.organ.stomach.Stomach;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.abdomen.CremasterMuscles;
import biomight.system.muscular.abdomen.ObliquusExternusAbdominisMuscles;
import biomight.system.muscular.abdomen.ObliquusInternusAbdominisMuscles;
import biomight.system.muscular.abdomen.PsoasMajorMuscles;
import biomight.system.muscular.abdomen.PsoasMinorMuscles;
import biomight.system.muscular.abdomen.PyramidalisMuscles;
import biomight.system.muscular.abdomen.QuadratusLumborumMuscles;
import biomight.system.muscular.abdomen.RectusAdominisMuscles;
import biomight.system.muscular.abdomen.TransversusAbdominisMuscles;
import biomight.system.skeletal.pelvis.Pelvis;
import biomight.system.skeletal.spine.LumbarVertebrae;
import biomight.system.skeletal.spine.SacralVertebrae;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.CeliacArtery;
import biomight.system.vascular.arteries.abdomen.AbdominalAortaArtery;
import biomight.system.vascular.arteries.abdomen.AppendicularArtery;
import biomight.system.vascular.arteries.abdomen.CommonHepaticArtery;
import biomight.system.vascular.arteries.abdomen.CysticArtery;
import biomight.system.vascular.arteries.abdomen.GastroEpiploicArteries;
import biomight.system.vascular.arteries.abdomen.InferiorEpigastricArteries;
import biomight.system.vascular.arteries.abdomen.InferiorMesentericArtery;
import biomight.system.vascular.arteries.abdomen.InferiorPancreaticoDuodenalArtery;
import biomight.system.vascular.arteries.abdomen.InferiorSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.MiddleSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.ProperHepaticArtery;
import biomight.system.vascular.arteries.abdomen.SpleenCentralArteries;
import biomight.system.vascular.arteries.abdomen.SuperiorEpigastricArteries;
import biomight.system.vascular.arteries.abdomen.SuperiorMesentericArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorPancreaticoDuodenalArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorSupraRenalArteries;
import biomight.system.vascular.arteries.abdomen.TrabecularArteries;
import biomight.system.vascular.arteries.chest.DescendingAortaArtery;
import biomight.system.vascular.veins.abdomen.ColicVeins;
import biomight.system.vascular.veins.abdomen.CysticVein;
import biomight.system.vascular.veins.abdomen.GastroEpiploicVeins;
import biomight.system.vascular.veins.abdomen.HemiazygosVein;
import biomight.system.vascular.veins.abdomen.HepaticPortalVein;
import biomight.system.vascular.veins.abdomen.HepaticVein;
import biomight.system.vascular.veins.abdomen.IleocolicVein;
import biomight.system.vascular.veins.abdomen.IliolumbarVein;
import biomight.system.vascular.veins.abdomen.InferiorEpigastricVeins;
import biomight.system.vascular.veins.abdomen.LiverCentralVeins;
import biomight.system.vascular.veins.abdomen.OvarianVein;
import biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVeins;
import biomight.system.vascular.veins.abdomen.RenalVeins;
import biomight.system.vascular.veins.abdomen.RetroperitonealVeins;
import biomight.system.vascular.veins.abdomen.SuperiorEpigastricVeins;
import biomight.system.vascular.veins.abdomen.TrabecularVeins;
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


/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *********************************************************************************/

public class Abdomen extends BodyPart {
	
	// What is the tone on a scale of 1 - 10
	// with 10 being rock, with washboard stomach`
	private int tone;
	

	// Organs
	private EpitheliumTissue epithelium;
	private Esophagus esophagus;
	private Stomach stomach;
	private Liver liver;
	private Pancreas pancreas;
	private Spleen spleen;
	private Kidneys kidneys;
	private SmallIntestine smallIntestine;
	private LargeIntestine largeIntestine;
	private GallBladder gallBladder;
	private Bladder bladder;
	private Ureters ureters; 
	
	// female 
	private Ovaries ovaries;
	private FallopianTubes fallopianTubes;	
	private Urethra urethra;
	private UmbilicalChord umbilicalChord;

	
	// Muscles
	private CremasterMuscles cremasterMuscles;
	private ObliquusExternusAbdominisMuscles obliquusExternusAbdominisMuscles;
	private ObliquusInternusAbdominisMuscles obliquusInternusAbdominisMuscles;
	private PsoasMajorMuscles psoasMajorMuscles;
	private PsoasMinorMuscles psoasMinorMuscles;
	private PyramidalisMuscles pyramidalisMuscles;
	private QuadratusLumborumMuscles quadratusLumborumMuscles;
	private RectusAdominisMuscles rectusAdominisMuscles;
	private TransversusAbdominisMuscles transversusAbdominisMuscles;

	
	// Vascular
	private DescendingAortaArtery descendingAortaArtery;
	private AbdominalAortaArtery abdominalAortaArtery;
	//private AdrenalArteries adrenalArteries;
	private AppendicularArtery appendicularArtery;
	private CommonHepaticArtery commonHepaticArtery;
	private ProperHepaticArtery properHepaticArtery;	
	private CysticArtery cysticArtery;
	private GastroEpiploicArteries gastroEpiploicArteries;
	private InferiorEpigastricArteries inferiorEpigastricArteries;
	private CeliacArtery celiacArtery;
	
	// Arteries run vertically parallel to the Arota as they decend into Pelvis
	private InferiorMesentericArtery inferiorMesentericArtery;
	private SuperiorMesentericArtery superiorMesentericArtery;

	private InferiorSupraRenalArteries inferiorSupraRenalArteries;
	private MiddleSupraRenalArteries middleSupraRenalArteries;
	private SuperiorSupraRenalArteries superiorSupraRenalArteries;

	//private PancreaticoDuodenalArteries pancreaticoDuodenalArteries;
	private InferiorPancreaticoDuodenalArtery inferiorPancreaticoDuodenalArtery;
	private SuperiorPancreaticoDuodenalArtery superiorPancreaticoDuodenalArtery;
	private SpleenCentralArteries spleenCentralArteries;
	private SuperiorEpigastricArteries superiorEpigastricArteries;
	private TrabecularArteries trabecularArteries;
	
	// Veins
	private ColicVeins colicVeins;
	private CysticVein cysticVein;
	private GastroEpiploicVeins gastroEpiploicVeins;
	private HemiazygosVein hemiazygosVein;
	private HepaticPortalVein hepaticPortalVein;
	private HepaticVein hepaticVein;
	private IleocolicVein ileocolicVein;
	private IliolumbarVein iliolumbarVein;
	private InferiorEpigastricVeins inferiorEpigastricVeins;
	private LiverCentralVeins liverCentralVeins;
	private OvarianVein ovarianVein;
	private PancreaticoDuodenalVeins pancreaticoDuodenalVeins;
	private RenalVeins renalVeins;
	private RetroperitonealVeins retroperitonealVeins;
	private SuperiorEpigastricVeins superiorEpigastricVeins;
	private TrabecularVeins trabecularVeins;
	private LumbarVertebrae lumbarVertebrae;
	private SacralVertebrae sacralVertebrae;

	// Bones
	private Pelvis pelvis;
	
	
	
	public Abdomen()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AbdomenRef, null, null);
	}
	
	public Abdomen(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public Abdomen(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/******************************************************************************
	 * CREATE ABDOMEN
	 *
	 ******************************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("imas/Abdomen.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);		

		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box from the Constructor that defines 
		// the perimeter of Abdomen  Pass that into the BoundingBoxes 
		// method so it can be divied up.
		System.out.println("ABDOMEN - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;			
		//if (bioMightConstruct == null)
		//{
			// Its null, so set up default boundbox with connectors 
		//	componentBoundBox = setupDefaultBoundBox();
		//}
		//else
		//{
			// Use the incoming
		//	componentBoundBox = bioMightConstruct.getBoundingBox(Constants.AbdomenRef);	
		//}
		//BioMightConnectors componentConnectors = componentBoundBox.getBioMightConnectors();
		//if (componentConnectors == null)
		//	System.out.println("ABDOMEN - ComponentConnectors are NULL!!");
		
		
		System.out.println("ABDOMEN - Setting up internal Bounding Boxes!");
		boundingBoxes = setupBoundBoxes(componentBoundBox);

		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
	
	
		try {
			// Get the information from the database via the Enterprise Bean		
			
			System.out.println("Getting AbdomenInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AbdomenRef, parentID);
			System.out.println("Have Abdomen Info from EJB");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Abdomen");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
		
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";
		
		// Run through the collection of Abdomens and build them into the model
		// In the default case, we get one instance of the Abdomen
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Abdomen NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Abdomen we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				
			System.out.println("Created Abdomen: " + bioMightTransform.getName() + "  " + bioMightTransform.getComponentID());
			this.componentID = bioMightTransform.getId();

			// Skin that surronds the abdominal region
			System.out.println("Creating Abdomen Epithelium: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
			epithelium = new EpitheliumTissue("AbdomenEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty("AbdomenEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());

			// ESOPHAGUS
			System.out.println("In Abdomen - Creating Esophagus Constructor");
			bioConstruct = new BioMightConstruct();
			//Set the BoundBox for the Esophagus  
			bioConstruct.setBoundingBox(Constants.EsophagusRef, (BioMightBoundBox)boundingBoxes.get(Constants.EsophagusRef));					
			System.out.println("Creating Esophagus using ParentID: " + bioMightTransform.getId());
		
			esophagus = new Esophagus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedEsophagus = esophagus.getBioMightGenerate(); 
			initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			
			System.out.println("Creating the Stomach for ParentID: " + bioMightTransform.getId());
			stomach = new Stomach(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedStomach = stomach.getBioMightGenerate(); 
			initProperty("Stomach", Constants.Stomach, Constants.StomachRef, stomach.getComponentID());
			System.out.println("Created the Stomach");

			System.out.println("Creating Liver: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			liver = new Liver(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedLiver = liver.getBioMightGenerate(); 				
			initProperty("Liver", Constants.Liver, Constants.LiverRef, liver.getComponentID());
			
			System.out.println("Creating Spleen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			spleen = new Spleen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedSpleen = spleen.getBioMightGenerate();
			initProperty(Constants.SpleenRef, Constants.Spleen, Constants.SpleenRef, spleen.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
			
			System.out.println("Creating Kidneys: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			kidneys = new Kidneys(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			initProperty("Kidneys", Constants.Kidneys, Constants.KidneysRef, kidneys.getComponentID());
					
			System.out.println("Creating Pancreas: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			pancreas = new Pancreas(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Pancreas", Constants.Pancreas, Constants.PancreasRef, pancreas.getComponentID());
				
			localVP = Constants.VIEW_DETACHED;
			localLOD = Constants.MAG1X;
			System.out.println("Creating SmallIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			smallIntestine = new SmallIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SmallIntestine", Constants.SmallIntestine, Constants.SmallIntestineRef, smallIntestine.getComponentID());
			
			System.out.println("Creating LargeIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			largeIntestine = new LargeIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("LargeIntestine", Constants.LargeIntestine, Constants.LargeIntestineRef, largeIntestine.getComponentID());

			// Muscles
			System.out.println("Creating the CremasterMuscles for parent: " + parentID);
			cremasterMuscles = new CremasterMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("CremasterMuscles", Constants.CremasterMuscles, Constants.CremasterMusclesRef, cremasterMuscles.getComponentID());
			System.out.println("Created the CremasterMuscles");
	
			System.out.println("Creating the ObliquusExternusAbdominisMuscles for parent: " + parentID);
			obliquusExternusAbdominisMuscles = new ObliquusExternusAbdominisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("ObliquusExternusAbdominisMuscles", Constants.ObliquusExternusAbdominisMuscles, Constants.ObliquusExternusAbdominisMusclesRef, obliquusExternusAbdominisMuscles.getComponentID());
			System.out.println("Created the ObliquusExternusAbdominisMuscles");
			
			System.out.println("Creating the ObliquusInternusAbdominisMuscles for parent: " + parentID);
			obliquusInternusAbdominisMuscles = new ObliquusInternusAbdominisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("ObliquusInternusAbdominisMuscles", Constants.ObliquusInternusAbdominisMuscles, Constants.ObliquusInternusAbdominisMusclesRef, obliquusInternusAbdominisMuscles.getComponentID());
			System.out.println("Created the ObliquusInternusAbdominisMuscles");
		
			System.out.println("Creating the PsoasMajorMuscles for parent: " + parentID);
			psoasMajorMuscles = new PsoasMajorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("PsoasMajorMuscles", Constants.PsoasMajorMuscles, Constants.PsoasMajorMusclesRef, psoasMajorMuscles.getComponentID());
			System.out.println("Created the PsoasMajorMuscles");
			
			System.out.println("Creating the PsoasMinorMuscles for parent: " + bioMightTransform.getId());
			psoasMinorMuscles = new PsoasMinorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("PsoasMinorMuscles", Constants.PsoasMinorMuscles, Constants.PsoasMinorMusclesRef, psoasMinorMuscles.getComponentID());
			System.out.println("Created the PsoasMinorMuscles");
	
			System.out.println("Creating the QuadratusLumborumMuscles for parent: " + bioMightTransform.getId());
			quadratusLumborumMuscles = new QuadratusLumborumMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("QuadratusLumborumMuscles", Constants.QuadratusLumborumMuscles, Constants.QuadratusLumborumMusclesRef, quadratusLumborumMuscles.getComponentID());
			System.out.println("Created the QuadratusLumborumMuscles");
	
			System.out.println("Creating the RectusAdominisMuscles for parent: " + bioMightTransform.getId());
			rectusAdominisMuscles = new RectusAdominisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("RectusAdominisMuscles", Constants.RectusAdominisMuscles, Constants.RectusAdominisMusclesRef, rectusAdominisMuscles.getComponentID());
			System.out.println("Created the RectusAdominisMuscles");
	
			System.out.println("Creating the TransversusAbdominisMuscles for parent: " + bioMightTransform.getId());
			transversusAbdominisMuscles = new TransversusAbdominisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("LargeIntestine", Constants.LargeIntestine, Constants.LargeIntestineRef, largeIntestine.getComponentID());
			System.out.println("Created the TransversusAbdominisMuscles");	
	
			System.out.println("Creating the PyramidalisMuscles for parent: " + bioMightTransform.getId());
			pyramidalisMuscles = new PyramidalisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("PyramidalisMuscles", Constants.PyramidalisMuscles, Constants.PyramidalisMusclesRef, pyramidalisMuscles.getComponentID());
			System.out.println("Created the PyramidalisMuscles");	
	
			System.out.println("Creating the Bladder for parent: " + bioMightTransform.getId());
			bladder = new Bladder(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Bladder", Constants.Bladder, Constants.BladderRef, bladder.getComponentID());
			System.out.println("Created the Bladder");	
	
			System.out.println("Creating the GallBladder for parent: " + bioMightTransform.getId());
			gallBladder = new GallBladder(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("GallBladder", Constants.GallBladder, Constants.GallBladderRef, gallBladder.getComponentID());
			System.out.println("Created the GallBladder");	
			
			System.out.println("Creating the Bladder for parent: " + bioMightTransform.getId());
			ureters = new Ureters(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Ureters", Constants.Ureters, Constants.UretersRef, ureters.getComponentID());
			System.out.println("Created the Ureters");	
	
			
			// ARTERIES
			System.out.println("Creating the DescendingAortaArtery for ParentID: " + bioMightTransform.getId());
			descendingAortaArtery = new DescendingAortaArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("DescendingAortaArtery", Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, descendingAortaArtery.getComponentID());
			System.out.println("Created the DescendingAortaArtery");
	
			System.out.println("Creating the AbdominalAortaArtery for ParentID: " + bioMightTransform.getId());
			abdominalAortaArtery = new AbdominalAortaArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("AbdominalAortaArtery", Constants.AbdominalAortaArtery, Constants.AbdominalAortaArteryRef, abdominalAortaArtery.getComponentID());
			System.out.println("Created the AbdominalAortaArtery");
	
			System.out.println("Creating the CeliacArtery for ParentID: " + bioMightTransform.getId());
			celiacArtery = new CeliacArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CeliacArtery", Constants.CeliacArtery, Constants.CeliacArteryRef, celiacArtery.getComponentID());
			System.out.println("Created the CeliacArtery");
	
			
			//System.out.println("Creating the AdrenalArteries for parent: " + parentID);
			//adrenalArteries = new AdrenalArteries(bioMightTransform.getId(), bioMightMethods);
			//initProperty("AdrenalArteries", Constants.AdrenalArteries, Constants.AdrenalArteriesRef, adrenalArteries.getComponentID());
			//System.out.println("Created the AdrenalArteries");	
	
			System.out.println("Creating the AppendicularArtery for parent: " + parentID);
			appendicularArtery = new AppendicularArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("AppendicularArtery", Constants.AppendicularArtery, Constants.AppendicularArteryRef, appendicularArtery.getComponentID());
			System.out.println("Created the AppendicularArtery");	
		
			System.out.println("Creating the CommonHepaticArtery for parent: " + parentID);
			commonHepaticArtery = new CommonHepaticArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CommonHepaticArtery", Constants.CommonHepaticArtery, Constants.CommonHepaticArteryRef, commonHepaticArtery.getComponentID());
			System.out.println("Created the CommonHepaticArtery");	
	
			System.out.println("Creating the CysticArtery for parent: " + parentID);
			cysticArtery = new CysticArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CysticArtery", Constants.CysticArtery, Constants.CysticArteryRef, cysticArtery.getComponentID());
			System.out.println("Created the CysticArtery");	
	
			System.out.println("Creating the GastroEpiploicArteries for parent: " + parentID);
			gastroEpiploicArteries = new GastroEpiploicArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("GastroEpiploicArteries", Constants.GastroEpiploicArteries, Constants.GastroEpiploicArteriesRef, gastroEpiploicArteries.getComponentID());
			System.out.println("Created the GastroEpiploicArteries");	
	
			System.out.println("Creating the InferiorEpigastricArteries for parent: " + parentID);
			inferiorEpigastricArteries = new InferiorEpigastricArteries(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("InferiorEpigastricArteries", Constants.InferiorEpigastricArteries, Constants.InferiorEpigastricArteriesRef, inferiorEpigastricArteries.getComponentID());
			System.out.println("Created the InferiorEpigastricArteries");	
			
			System.out.println("Creating the InferiorMesentericArtery for parent: " + parentID);
			inferiorMesentericArtery = new InferiorMesentericArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorMesentericArtery", Constants.InferiorMesentericArtery, Constants.InferiorMesentericArteryRef, inferiorMesentericArtery.getComponentID());
			System.out.println("Created the InferiorMesentericArtery");	
			
			System.out.println("Creating the InferiorSupraRenalArteries for parent: " + parentID);
			inferiorSupraRenalArteries = new InferiorSupraRenalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorSupraRenalArteries", Constants.InferiorSupraRenalArteries, Constants.InferiorSupraRenalArteriesRef, inferiorSupraRenalArteries.getComponentID());
			System.out.println("Created the InferiorSupraRenalArtery");	
		
			System.out.println("Creating the MiddleSupraRenalArteries for parent: " + parentID);
			middleSupraRenalArteries = new MiddleSupraRenalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("MiddleSupraRenalArteries", Constants.MiddleSupraRenalArteries, Constants.MiddleSupraRenalArteriesRef, middleSupraRenalArteries.getComponentID());
			System.out.println("Created the MiddleSupraRenalArteries");	
			
			System.out.println("Creating the InferiorPancreaticoDuodenalArtery for parent: " + parentID);
			inferiorPancreaticoDuodenalArtery = new InferiorPancreaticoDuodenalArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorPancreaticoDuodenalArtery", Constants.InferiorPancreaticoDuodenalArtery, Constants.InferiorPancreaticoDuodenalArteryRef, inferiorPancreaticoDuodenalArtery.getComponentID());
			System.out.println("Created the InferiorPancreaticoDuodenalArtery");	
		
			System.out.println("Creating the ProperHepaticArtery for parent: " + parentID);
			properHepaticArtery = new ProperHepaticArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ProperHepaticArtery", Constants.ProperHepaticArtery, Constants.ProperHepaticArteryRef, properHepaticArtery.getComponentID());
			System.out.println("Created the ProperHepaticArtery");	
	
			System.out.println("Creating the SpleenCentralArteries for parent: " + parentID);
			spleenCentralArteries = new SpleenCentralArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SpleenCentralArteries", Constants.SpleenCentralArteries, Constants.SpleenCentralArteriesRef, spleenCentralArteries.getComponentID());
			System.out.println("Created the SpleenCentralArteries");	
	
			System.out.println("Creating the SuperiorEpigastricArteries for parent: " + parentID);
			superiorEpigastricArteries = new SuperiorEpigastricArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SuperiorEpigastricArteries", Constants.SuperiorEpigastricArteries, Constants.SuperiorEpigastricArteriesRef, superiorEpigastricArteries.getComponentID());
			System.out.println("Created the SuperiorEpigastricArteries");	
			
			System.out.println("Creating the SuperiorMesentericArtery for parent: " + parentID);
			superiorMesentericArtery = new SuperiorMesentericArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorSupraRenalArteries", Constants.SuperiorMesentericArtery, Constants.SuperiorMesentericArteryRef, superiorMesentericArtery.getComponentID());
			System.out.println("Created the SuperiorMesentericArtery");	
		
			System.out.println("Creating the SuperiorPancreaticoDuodenalArtery for parent: " + parentID);
			superiorPancreaticoDuodenalArtery = new SuperiorPancreaticoDuodenalArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SuperiorPancreaticoDuodenalArtery", Constants.SuperiorPancreaticoDuodenalArtery, Constants.SuperiorPancreaticoDuodenalArteryRef, superiorPancreaticoDuodenalArtery.getComponentID());
			System.out.println("Created the SuperiorPancreaticoDuodenalArtery");	
		
			System.out.println("Creating the SuperiorSupraRenalArteries for parent: " + parentID);
			superiorSupraRenalArteries = new SuperiorSupraRenalArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SuperiorSupraRenalArteries", Constants.SuperiorSupraRenalArteries, Constants.SuperiorSupraRenalArteriesRef, superiorSupraRenalArteries.getComponentID());
			System.out.println("Created the SuperiorSupraRenalArteries");	
			
			System.out.println("Creating the TrabecularArteries for parent: " + parentID);
			trabecularArteries = new TrabecularArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorSupraRenalArteries", Constants.TrabecularArteries, Constants.TrabecularArteriesRef, trabecularArteries.getComponentID());
			System.out.println("Created the TrabecularArteries");				
		
			
			// VEINS
			System.out.println("Creating the ColicVeins for parent: " + parentID);
			colicVeins = new ColicVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("ColicVeins", Constants.ColicVeins, Constants.ColicVeinsRef, colicVeins.getComponentID());
			System.out.println("Created the ColicVeins");	
			
			System.out.println("Creating the GastroEpiploicVeins for parent: " + parentID);
			gastroEpiploicVeins = new GastroEpiploicVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("GastroEpiploicVeins", Constants.GastroEpiploicVeins, Constants.GastroEpiploicVeinsRef, colicVeins.getComponentID());
			System.out.println("Created the GastroEpiploicVeins");	

			System.out.println("Creating the TrabecularVeins for parent: " + parentID);
			trabecularVeins = new TrabecularVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("TrabecularVeins", Constants.TrabecularVeins, Constants.TrabecularVeinsRef, trabecularVeins.getComponentID());
			System.out.println("Created the TrabecularVeins");	
			

			// Create the Vertebrae 
			lumbarVertebrae = new LumbarVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("LumbarVertebrae", Constants.LumbarVertebrae, Constants.LumbarVertebraeRef, lumbarVertebrae.getComponentID());
			System.out.println("Created the LumbarVertebrae");
	
			sacralVertebrae = new SacralVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SacralVertebrae", Constants.SacralVertebrae, Constants.SacralVertebraeRef, sacralVertebrae.getComponentID());
			System.out.println("Created the SacralVertebrae");
			
			System.out.println("Creating the Pelvis for ParentID: " + bioMightTransform.getId());
			pelvis = new Pelvis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Pelvis", Constants.Pelvis, Constants.PelvisRef, pelvis.getComponentID());
			System.out.println("Created the Pelvis");

		
			// Store all the connection points for the Abdomen
			// in the AbdomenMap.  Then stuff this map into the BioGeneate Object
			// for the chest.  
			HashMap abdomenMap = new HashMap();
			//abdomenMap.put(Constants.EsophagusRef, generatedEsophagus);
			//abdomenMap.put(Constants.TracheaRef, );
			this.bioMightGenerate.setComponentMap(abdomenMap);
			System.out.println("Stored A Abdomen Map");
		}
		
		System.out.println("Create Abdomen Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Abdomen METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		//initProperties();
		initMethods();
	}

	
	
	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	

	public void initProperties() {
		properties = new ArrayList<BioMightPropertyView>();
		
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Belly");
		property.setCanonicalName(Constants.Abdomen);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Belly Button");
		property.setCanonicalName(Constants.Abdomen);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Organs");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Liver");
		property.setCanonicalName(Constants.Liver);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Kidneys");
		property.setCanonicalName(Constants.Kidneys);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Pancreas");
		property.setCanonicalName(Constants.Pancreas);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Spleen");
		property.setCanonicalName(Constants.Spleen);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Large Intestine");
		property.setCanonicalName(Constants.LargeIntestine);
		properties.add(property);		
				
		property = new BioMightPropertyView();
		property.setPropertyName("Small Intestine");
		property.setCanonicalName(Constants.SmallIntestine);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Gall Bladder");
		property.setCanonicalName(Constants.GallBladder);
		properties.add(property);		
	
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("CremasterMuscle");
		property.setCanonicalName(Constants.CremasterMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("ObliquusExternusAbdominisMuscle");
		property.setCanonicalName(Constants.ObliquusExternusAbdominisMuscle);
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
		property.setPropertyName("PsoasMinorMuscle");
		property.setCanonicalName(Constants.PsoasMinorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PyramidalisMuscle");
		property.setCanonicalName(Constants.PyramidalisMuscle);
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

	}
	
	
	public void initMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Bend");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);	
		
	}


	
	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
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
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Abdomen'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 	
			epithelium.getX3D(true) +
			esophagus.getX3D(true) +
			stomach.getX3D(true) + 
			liver.getX3D(true) +
			bladder.getX3D(true) + 
			gallBladder.getX3D(true) + 
			spleen.getX3D(true) +
			kidneys.getX3D(true) +
			pancreas.getX3D(true) +
			cremasterMuscles.getX3D(true) +
			obliquusExternusAbdominisMuscles.getX3D(true) +
			obliquusInternusAbdominisMuscles.getX3D(true) +
			psoasMajorMuscles.getX3D(true) +
			psoasMinorMuscles.getX3D(true) +
			pyramidalisMuscles.getX3D(true) +
			quadratusLumborumMuscles.getX3D(true) +
			rectusAdominisMuscles.getX3D(true) +
			transversusAbdominisMuscles.getX3D(true) +
			
			descendingAortaArtery.getX3D(true) +
			abdominalAortaArtery.getX3D(true) +
			//adrenalArteries.getX3D(true) +
			appendicularArtery.getX3D(true) +
			commonHepaticArtery.getX3D(true) +
			celiacArtery.getX3D(true) +
			cysticArtery.getX3D(true) +
			gastroEpiploicArteries.getX3D(true) + 
			inferiorEpigastricArteries.getX3D(true) +
			inferiorMesentericArtery.getX3D(true) +
			inferiorSupraRenalArteries.getX3D(true) +
			middleSupraRenalArteries.getX3D(true) +
			inferiorPancreaticoDuodenalArtery.getX3D(true) +
			properHepaticArtery.getX3D(true) +
			spleenCentralArteries.getX3D(true) +
			superiorEpigastricArteries.getX3D(true)+
			superiorMesentericArtery.getX3D(true)+
			superiorPancreaticoDuodenalArtery.getX3D(true) +
			superiorSupraRenalArteries.getX3D(true) +
			lumbarVertebrae.getX3D(true) + sacralVertebrae.getX3D(true) +
			ureters.getX3D(true) + 
			smallIntestine.getX3D(true) + 
			largeIntestine.getX3D(true) +
			pelvis.getX3D(true) 
			
			
			
			//trabecularArteries.getX3D(true)	
			;
			
		//System.out.println("Abdomen X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Abdomen.  
	 *
	 * @return
	 ***************************************************************************/
	private BioMightBoundBox setupDefaultBoundBox() 
	{
		// Initialize the position of the bounding box 
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(-15.0);
		BigDecimal zPos= new BigDecimal(-5.0);
		
		// Set to base 10x10x10 cube
		BigDecimal xVector= new BigDecimal(10.0);
		BigDecimal yVector= new BigDecimal(10.0); 
		BigDecimal zVector= new BigDecimal(10.0);
	
		// Create the BoundBox
		BioMightBoundBox bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = new BioMightConnectors(); 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		// Initialize some vars
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = null;;
		
	
		//********************************************
		// ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -15.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.AbdomenEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.AbdomenEpitheliumRef, bioMightConnector);
	
		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -16.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// CONNECTORS  
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
		// CONNECTORS
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
	 * Setup the Bounding Boxes for the Abdomen.   These boxes will define
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
		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			
			System.out.println("Abdomen - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Abdomen
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-1.0);
		
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Abdomen Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -15.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "AbdomenEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("AbdomenEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("AbdomenEpithelium", bioBoundBox);
		
				
		//********************************************************************* 
		// ESOPHAGUS BOUNDBOX
		// Set up the Bounding Box for the Esophagus
		// On a porportioned human, the Esophagus lie in the middle of the... 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-16.0);
		zPos= new BigDecimal(-5.5);
		
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(4.5); 
		zVector= new BigDecimal(4.5);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Esophagus Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -16.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.EsophagusRef, bioBoundBox);
		
	
	return (boundingBoxMap);
	}
	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Body.   These boxes will define
	 * the define the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 *
	 * @return
	 *******************************************************************
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBox, String some) 
	{
	// Set up the bounding boxes for the various components
	// The various components locations will be driven by the
	// bounding boxes

	// Set up the Bounding Boxes for each component of the body
	// Build everything within in the confines of of the given box
	HashMap boundingBoxMap = new HashMap();

	// Set up the Bounding Box for the Abdomen
	// On a porportioned human, the pupils lie in the middle of the face
	// For the Default model, the length is 7x9x9
	// This puts the bounding box at the center of the head
	BigDecimal xPos = new BigDecimal(0.0);
	BigDecimal yPos = new BigDecimal(0.0);
	BigDecimal zPos= new BigDecimal(-4.5);
	
	BigDecimal xVector= new BigDecimal(3.5);
	BigDecimal yVector= new BigDecimal(4.5); 
	BigDecimal zVector= new BigDecimal(4.5);
	//BioMightBoundBox bioMightBoundBoxHead = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
	
	// ABDOMEN EPITHELIUM
	xPos = new BigDecimal(0.0);
	yPos = new BigDecimal(-7.75);
	zPos= new BigDecimal(-3.0); 
	
	xVector= new BigDecimal(2.5);
	yVector= new BigDecimal(2.0); 
	zVector= new BigDecimal(2.5);
	BioMightBoundBox bioMightBoundBoxNose = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	// Stuff in the Bounding Box Map
	boundingBoxMap.put("AbdomenEpithelium:01",bioMightBoundBoxNose);
	


	// ESOPHAGUS
	xPos = new BigDecimal(0.0);
	yPos = new BigDecimal(-15.0);
	zPos= new BigDecimal(-5.0);
	
	xVector= new BigDecimal(11.5);
	yVector= new BigDecimal(6.0); 
	zVector= new BigDecimal(5.0);		
	BioMightBoundBox bioMightBoundBoxEsophagus = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	// Stuff in the Bounding Box Map
	boundingBoxMap.put("Esophagus:01", bioMightBoundBoxEsophagus);

	
	// STOMACH
	xPos = new BigDecimal(0.0);
	yPos = new BigDecimal(-7.75);
	zPos= new BigDecimal(-3.0); 
	
	xVector= new BigDecimal(2.5);
	yVector= new BigDecimal(2.0); 
	zVector= new BigDecimal(2.5);
	BioMightBoundBox bioMightBoundBoxStomach = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
	// SMALL INTESTINE
	// Set up the Bounding Box for the Chest
	// From 9-20 so 15 is in the middle
	xPos = new BigDecimal(0.0);
	yPos = new BigDecimal(-15.0);
	zPos= new BigDecimal(-5.0);
	
	xVector= new BigDecimal(11.5);
	yVector= new BigDecimal(6.0); 
	zVector= new BigDecimal(5.0);		
	BioMightBoundBox bioMightBoundBoxSmallIntestine = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);

	// LARGE INTESTINE
	// Set up the Bounding Box for the Left Shoulder
	xPos = new BigDecimal(10.0);
	yPos = new BigDecimal(-10.0);
	zPos= new BigDecimal(-1.0);
	
	xVector= new BigDecimal(3.0);
	yVector= new BigDecimal(3.0); 
	zVector= new BigDecimal(3.0);
	BioMightBoundBox bioMightBoundBoxLargeIntestine = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);

	
	
	
	// INTERNAL JUGULAR VEIN
	// Set up the Bounding Box for the Right arm
	xPos = new BigDecimal(-10.0);
	yPos = new BigDecimal(-12.0);
	zPos= new BigDecimal(0.0); 
	
	xVector= new BigDecimal(3.0);
	yVector= new BigDecimal(3.0); 
	zVector= new BigDecimal(3.0);
	BioMightBoundBox bioMightBoundBoxLeftInternalJugularVein = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
	xPos = new BigDecimal(-10.0);
	yPos = new BigDecimal(-12.0);
	zPos= new BigDecimal(0.0); 

	xVector= new BigDecimal(1.5);
	yVector= new BigDecimal(1.5); 
	zVector= new BigDecimal(3.0);
	BioMightBoundBox bioMightBoundBoxRightInternalJugularVein = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);

	BioMightBoundBoxes bioMightBoundBoxesInternalJugularVein = new BioMightBoundBoxes();
	bioMightBoundBoxesInternalJugularVein.add(bioMightBoundBoxLeftInternalJugularVein);	
	bioMightBoundBoxesInternalJugularVein.add(bioMightBoundBoxRightInternalJugularVein);
	
	// Stuff in the Bounding Box Map
	boundingBoxMap.put("InternalJugularVeins:0", bioMightBoundBoxesInternalJugularVein);


	// EXTERNAL JUGULAR VEIN
	// Set up the Bounding Box for the Right arm
	xPos = new BigDecimal(-10.0);
	yPos = new BigDecimal(-12.0);
	zPos= new BigDecimal(0.0); 
	
	xVector= new BigDecimal(3.0);
	yVector= new BigDecimal(3.0); 
	zVector= new BigDecimal(3.0);
	BioMightBoundBox bioMightBoundBoxLeftExternalJugularVein = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
	
	xPos = new BigDecimal(-10.0);
	yPos = new BigDecimal(-12.0);
	zPos= new BigDecimal(0.0); 

	xVector= new BigDecimal(1.5);
	yVector= new BigDecimal(1.5); 
	zVector= new BigDecimal(3.0);
	BioMightBoundBox bioMightBoundBoxRightExternalJugularVein = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);

	BioMightBoundBoxes bioMightBoundBoxesExternalJugularVein = new BioMightBoundBoxes();
	bioMightBoundBoxesExternalJugularVein.add(bioMightBoundBoxLeftExternalJugularVein);	
	bioMightBoundBoxesExternalJugularVein.add(bioMightBoundBoxRightExternalJugularVein);
	
	// Stuff in the Bounding Box Map
	boundingBoxMap.put("ExternalJugularVeins:0", bioMightBoundBoxesExternalJugularVein);

	
	return (boundingBoxMap);
	}
	**/
	
	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}	

	public Bladder getBladder() {
		return bladder;
	}

	public void setBladder(Bladder bladder) {
		this.bladder = bladder;
	}


	public FallopianTubes getFallopianTubes() {
		return fallopianTubes;
	}

	public void setFallopianTubes(FallopianTubes fallopianTubes) {
		this.fallopianTubes = fallopianTubes;
	}

	public GallBladder getGallBladder() {
		return gallBladder;
	}

	public void setGallBladder(GallBladder gallBladder) {
		this.gallBladder = gallBladder;
	}

	public LargeIntestine getLargeIntestine() {
		return largeIntestine;
	}

	public void setLargeIntestine(LargeIntestine largeIntestine) {
		this.largeIntestine = largeIntestine;
	}

	public Liver getLiver() {
		return liver;
	}

	public void setLiver(Liver liver) {
		this.liver = liver;
	}

	public Ovaries getOvaries() {
		return ovaries;
	}

	public void setOvaries(Ovaries ovaries) {
		this.ovaries = ovaries;
	}

	public Pancreas getPancreas() {
		return pancreas;
	}

	public void setPancreas(Pancreas pancreas) {
		this.pancreas = pancreas;
	}

	

	public SmallIntestine getSmallIntestine() {
		return smallIntestine;
	}

	public void setSmallIntestine(SmallIntestine smallIntestine) {
		this.smallIntestine = smallIntestine;
	}

	public Spleen getSpleen() {
		return spleen;
	}

	public void setSpleen(Spleen spleen) {
		this.spleen = spleen;
	}

	public Stomach getStomach() {
		return stomach;
	}

	public void setStomach(Stomach stomach) {
		this.stomach = stomach;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}

	
	public UmbilicalChord getUmbilicalChord() {
		return umbilicalChord;
	}

	public void setUmbilicalChord(UmbilicalChord umbilicalChord) {
		this.umbilicalChord = umbilicalChord;
	}

	public Ureters getUreters() {
		return ureters;
	}

	public void setUreters(Ureters ureters) {
		this.ureters = ureters;
	}

	public Urethra getUrethra() {
		return urethra;
	}

	public void setUrethra(Urethra urethra) {
		this.urethra = urethra;
	}
}
