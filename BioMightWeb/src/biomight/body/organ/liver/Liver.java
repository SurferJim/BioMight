/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.liver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.body.organ.stomach.GreaterCurvature;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.membranes.peritoneum.Peritoneum;
import biomight.system.tissue.membranes.peritoneum.VisceralPeritoneum;
import biomight.system.vascular.arteries.abdomen.CommonHepaticArtery;
import biomight.system.vascular.arteries.abdomen.ProperHepaticArtery;
import biomight.system.vascular.veins.EmbryonicUmbilicalVein;
import biomight.system.vascular.veins.abdomen.HepaticPortalVein;
import biomight.system.vascular.veins.abdomen.LiverCentralVeins;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.virus.picornaviridae.enteroviridae.HepatitisAVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisBVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisDVirus;
import biomight.virus.picornaviridae.enteroviridae.HepatitisEVirus;
import biomight.virus.rna.HepatitisCVirus;


/***************************************************************************************
 * @author SurferJim
 *
 * Representation of the Liver
 * 
 ***************************************************************************************/


public class Liver extends Organ {
	protected EpitheliumTissue epithelium;
	
	
	// LOBES
	private LiverLeftLateralLobe liverLeftLateralLobe;
	private LiverRightMedialLobe liverRightMedialLobe;
	private LiverRightLateralLobe liverRightLateralLobe;
	private LiverQuadrateLobe liverQuadrateLobe;
	
	// SURFACES
	//private LiverSuperiorSurface liverSuperiorSurface;
	private LiverInferiorSurface liverInferiorSurface;
	private LiverPosteriorSurface liverPosteriorSurface;
	
	// LIGAMENTS
	private FalciformLigament falciformLigament;
	//private RightTriangularLigaments rightTriangularLigaments;
	private LeftTriangularLigaments leftTriangularLigaments;
	private LigamentumVenosum ligamentumVenosum;
	private LigamentumTeres ligamentumTeres;
	private TransverseFissure transverseFissure;
	private CoronaryLigament coronaryLigament;
	private RoundLigament roundLigament;
	
	private LiverLobules liverLobules;
	private EmbryonicUmbilicalVein embryonicUmbilicalVein;
	
	// Surface features
	private LeftSagittalFossa leftSagittalFossa;
	private DuodenalImpression duodenalImpression;
	private LiverRenalImpression liverRenalImpression;
	private LiverColicImpression liverColicImpression;
	//private LiverSupraRenalImpression liverSupraRenalImpression;
	
	// 
	private CaudateLobe caudateLobe;
	private CaudateProcess caudateProcess;
	
	
	// Vascular
	private CommonHepaticArtery HepaticommoncArtery;	
	private ProperHepaticArtery properHepaticArtery;
	private HepaticPortalVein portalVein;
	
	// There is one on each Lobule
	private LiverCentralVeins liverCentralVeins;
	
	private BileCanaliculi bileCanaliculi;		
	private Peritoneum Peritoneum;

	private Sinusoids sinusoids;
	private SpaceOfDisse spaceOfDisse;
	
	// Lines all outside of the liver
	private VisceralPeritoneum  visceralPeritoneum;
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Liver()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LiverRef, null, null);
	}

	public Liver(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Liver(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
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
		this.setImage("images/Liver.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LiverInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LiverRef, parentID);
			System.out.println("Have Liver Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Liver");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
				
		// Run through the collection of Livers and build them into the model
		// In the default case, we get one instance of the Liver for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Liver NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Liver we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Liver: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Liver Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "LiverEpithelium:00001";
				System.out.println("HawkEye - Creating Liver Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "LiverEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("LiverEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
						
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Liver Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				
				System.out.println("Creating LiverQuadrateLobe: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				liverQuadrateLobe = new LiverQuadrateLobe(bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
				
				System.out.println("Creating CaudateLobe : " + bioMightTransform.getId());				
				caudateLobe = new CaudateLobe(bioMightTransform.getId(), bioMightMethods);	
				initProperty(bioMightTransform.getName(), Constants.CaudateLobe, Constants.CaudateLobeRef, caudateLobe.getComponentID());
		
				System.out.println("Creating FalciformLigament : " + bioMightTransform.getId());				
				falciformLigament = new FalciformLigament(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.FalciformLigamentRef, bioMightTransform.getId());
			
				
				
				/*
				System.out.println("Creating liverLeftLateralLobe : " + bioMightTransform.getId());				
				liverLeftLateralLobe = new LiverLeftLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.Hand, Constants.HandRef, bioMightTransform.getId());
		
				System.out.println("Creating LiverRightMedialLobe : " + bioMightTransform.getId());				
				liverRightMedialLobe = new LiverRightMedialLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating LiverRightLateralLobe : " + bioMightTransform.getId());				
				liverRightLateralLobe = new LiverRightLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating LiverSuperiorSurface : " + bioMightTransform.getId());				
				liverSuperiorSurface = new LiverSuperiorSurface(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating LiverInferiorSurface : " + bioMightTransform.getId());				
				liverInferiorSurface = new LiverInferiorSurface(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating LiverPosteriorSurface : " + bioMightTransform.getId());				
				liverPosteriorSurface = new LiverPosteriorSurface(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
			
				System.out.println("Creating RightTriangularLigaments : " + bioMightTransform.getId());				
				rightTriangularLigaments = new RightTriangularLigaments(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, bioMightTransform.getId());
			
				System.out.println("Creating LeftTriangularLigaments : " + bioMightTransform.getId());				
				leftTriangularLigaments = new LeftTriangularLigaments(bioMightTransform.getId());

				System.out.println("Creating LeftSagittalFossa : " + bioMightTransform.getId());				
				leftSagittalFossa = new LeftSagittalFossa(bioMightTransform.getId());

				System.out.println("Creating DuodenalImpression : " + bioMightTransform.getId());				
				duodenalImpression = new DuodenalImpression(bioMightTransform.getId());
				
				System.out.println("Creating LiverRenalImpression : " + bioMightTransform.getId());				
				liverRenalImpression = new LiverRenalImpression(bioMightTransform.getId());
		
				System.out.println("Creating LiverColicImpression : " + bioMightTransform.getId());				
				liverColicImpression = new LiverColicImpression(bioMightTransform.getId());

				System.out.println("Creating LiverSupraRenalImpression : " + bioMightTransform.getId());				
				liverSupraRenalImpression = new LiverSupraRenalImpression(bioMightTransform.getId());
		
				System.out.println("Creating CaudateProcess : " + bioMightTransform.getId());				
				caudateProcess = new CaudateProcess(bioMightTransform.getId());
				*/	
			}
				
		
		
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateLiver Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Liver METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	/****************************************************
	 * GENERATE LIVER
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Liver Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Liver: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.001;
		
			if (componentID.equals("Liver:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {2.0, -17.75, -2.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateLiver("LiverEpithelium:00001", "LiverEpithelium", 
					"LiverEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created LiverEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LiverEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		// LOBES
		initProperty(Constants.LiverLeftLateralLobeRef, Constants.LiverLeftLateralLobe, Constants.LiverLeftLateralLobeRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverRightMedialLobeRef, Constants.LiverRightMedialLobe, Constants.LiverRightMedialLobeRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverRightLateralLobeRef, Constants.LiverRightLateralLobe, Constants.LiverRightLateralLobeRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverQuadrateLobeRef, Constants.LiverQuadrateLobe, Constants.LiverQuadrateLobeRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		// SURFACES
		initProperty(Constants.LiverSuperiorSurfaceRef, Constants.LiverSuperiorSurface, Constants.LiverSuperiorSurfaceRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverInferiorSurfaceRef, Constants.LiverInferiorSurface, Constants.LiverInferiorSurfaceRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverPosteriorSurfaceRef, Constants.LiverPosteriorSurface, Constants.LiverPosteriorSurfaceRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverTransverseFissureRef, Constants.LiverTransverseFissure, Constants.LiverTransverseFissureRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.FalciformLigamentRef, Constants.FalciformLigament, Constants.FalciformLigamentRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CaudateLobeRef, Constants.CaudateLobe, Constants.CaudateLobeRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CaudateProcessRef, Constants.CaudateProcess, Constants.CaudateProcessRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PapillaryProcessRef, Constants.PapillaryProcess, Constants.PapillaryProcessRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TuberOmentaleRef, Constants.TuberOmentale, Constants.TuberOmentaleRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverGastricImpressionRef, Constants.LiverGastricImpression, Constants.LiverGastricImpressionRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverColicImpressionRef, Constants.LiverColicImpression, Constants.LiverColicImpressionRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverRenalImpressionRef, Constants.LiverRenalImpression, Constants.LiverRenalImpressionRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RightTriangularLigamentsRef, Constants.RightTriangularLigaments, Constants.RightTriangularLigamentsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeftTriangularLigamentsRef, Constants.LeftTriangularLigaments, Constants.LeftTriangularLigamentsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LigamentumVenosumRef, Constants.LigamentumVenosum, Constants.LigamentumVenosumRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LigamentumTeresRef, Constants.LigamentumTeres, Constants.LigamentumTeresRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverTransverseFissureRef, Constants.LiverTransverseFissure, Constants.LiverTransverseFissureRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoronaryLigamentRef, Constants.CoronaryLigament, Constants.CoronaryLigamentRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RoundLigamentRef, Constants.RoundLigament, Constants.RoundLigamentRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EmbryonicUmbilicalVeinRef, Constants.EmbryonicUmbilicalVein, Constants.EmbryonicUmbilicalVeinRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeftSagittalFossaRef, Constants.LeftSagittalFossa, Constants.LeftSagittalFossaRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DuodenalImpressionRef, Constants.DuodenalImpression, Constants.DuodenalImpressionRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CommonHepaticArteryRef, Constants.CommonHepaticArtery, Constants.CommonHepaticArtery, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HepaticPortalVeinRef, Constants.HepaticPortalVein, Constants.HepaticPortalVeinRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverLobulesRef, Constants.LiverLobules, Constants.LiverLobulesRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LiverCentralVeinsRef, Constants.LiverCentralVeins, Constants.LiverCentralVeinsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BileCanaliculiRef, Constants.BileCanaliculi, Constants.BileCanaliculi, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BileDuctsRef, Constants.BileDucts, Constants.BileDuctsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HepaticDuctsRef, Constants.HepaticDucts, Constants.HepaticDuctsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CommonHepaticDuctRef, Constants.CommonHepaticDuct, Constants.CommonHepaticDuctRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProperHepaticArteryRef, Constants.ProperHepaticArtery, Constants.ProperHepaticArteryRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PeritoneumRef, Constants.Peritoneum, Constants.PeritoneumRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SinusoidsRef, Constants.Sinusoids, Constants.SinusoidsRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SpaceOfDisseRef, Constants.SpaceOfDisse, Constants.SpaceOfDisseRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.VisceralPeritoneumRef, Constants.VisceralPeritoneum, Constants.VisceralPeritoneumRef, "Liver:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
	}
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Secrete Bile");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Fibrinogen");
		method.setHtmlType("text");
		methods.add(method);	


		method = new BioMightMethodView();
		method.setMethodName("Albumin");
		method.setHtmlType("text");
		methods.add(method);		
	}
		


	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Chin
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Liver.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Liver'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		
		
		viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE) {
			System.out.println("Getting Liver X3D - HawkEye");
			body = epithelium.getX3D(true); 
		}
		else {
			System.out.println("Getting Liver X3D - Not HawkEye");
			body = liverQuadrateLobe.getX3D(true); // + caudateLobe.getX3D(true) 	;  
				/*leftSagittalFossa.getX3D(true) + 
				duodenalImpression.getX3D(true) +
				liverRenalImpression.getX3D(true) +
				liverColicImpression.getX3D(true) +
				liverSupraRenalImpression.getX3D(true) +
				caudateLobe.getX3D(true) +
				caudateProcess.getX3D(true) +
				liverLeftLateralLobe.getX3D(true) +
				liverRightMedialLobe.getX3D(true) +
				liverRightLateralLobe.getX3D(true) +
				liverSuperiorSurface.getX3D(true) +
				liverInferiorSurface.getX3D(true) +				
				liverPosteriorSurface.getX3D(true) +
				falciformLigament.getX3D(true) +		
				rightTriangularLigaments.getX3D(true) +
				leftTriangularLigaments.getX3D(true) +				
				leftSagittalFossa.getX3D(true) +				
				duodenalImpression.getX3D(true) +			
				liverRenalImpression.getX3D(true) +			
				liverColicImpression.getX3D(true) +				
				liverSupraRenalImpression.getX3D(true) +			
				caudateProcess.getX3D(true); */

		}

		//System.out.println("Liver X3D: " + body);		
		
		
		body+= "<Viewpoint DEF='Viewpoint_Liver'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -19.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	public void onContact(Object obj)
	{
		
		if (obj instanceof HepatitisAVirus)
		{
			// Hepatitus
		}
		
		if (obj instanceof HepatitisBVirus)
		{
			// Hepatitus
		}		

		if (obj instanceof HepatitisCVirus)
		{
			// Hepatitus
		}			

		if (obj instanceof HepatitisDVirus)
		{
			// Hepatitus
		}
		
		if (obj instanceof HepatitisEVirus)
		{
			// Hepatitus
		}

	}

	public void setCirrhosis()
	{
	}
	
	public void HemoChromatosis()
	{
	}
	
	public void setWilsonsDisease()
	{
	}
	
	public void setBuddChiariSyndrome()
	{
	}

	public void setAlbuminMass()
	{
	}

	public void SynthesizeBile()
	{
	}
	
		
	public void SecreteBile()
	{
	}
	
	public void setFibrinogenLevel()
	{	
	}
	
	
	public void setGilbertsSyndrome()
	{
	}
	
	public void SynthesizeCholesterol()
	{
	}
	
	public void SynthesizeLipoproteins()
	{
	}
	
	public void storeGlucose()
	{
	}
	
	public void releaseGlucose()
	{
	}	
	
	public void SetALTLevel()
	{
		// Elevate on inflammation
		// AlanineAminoTransferase
		// moderate (100-300 U/L) 
	}

	public void SetASTLevel()
	{
		// AspartateAminoTransferase
		// moderate (100-300 U/L) 
	}	
	
	public void setBilirubinUptake()
	{
	}
	
	public void storeVitaminA()
	{
	}

	public void storeVitaminD()
	{
	}	
	
	public void storeVitaminE()
	{
	}

	public void storeVitaminK()
	{
	}
		
	public void storeFolateVitamin()
	{
	} 
 
	public void storeVitaminB12()
	{
	}

	public void storeCopper()
	{
	}
 
	public void storeIron()
	{
	}
	
	public void setSexHormoneBindingGlobulin()
	{	
	}

	public BileCanaliculi getBileCanaliculi() {
		return bileCanaliculi;
	}

	public void setBileCanaliculi(BileCanaliculi bileCanaliculi) {
		this.bileCanaliculi = bileCanaliculi;
	}

	public CoronaryLigament getCoronaryLigament() {
		return coronaryLigament;
	}

	public void setCoronaryLigament(CoronaryLigament coronaryLigament) {
		this.coronaryLigament = coronaryLigament;
	}

	public DuodenalImpression getDuodenalImpression() {
		return duodenalImpression;
	}

	public void setDuodenalImpression(DuodenalImpression duodenalImpression) {
		this.duodenalImpression = duodenalImpression;
	}

	public EmbryonicUmbilicalVein getEmbryonicUmbilicalVein() {
		return embryonicUmbilicalVein;
	}

	public void setEmbryonicUmbilicalVein(
			EmbryonicUmbilicalVein embryonicUmbilicalVein) {
		this.embryonicUmbilicalVein = embryonicUmbilicalVein;
	}

	public FalciformLigament getFalciformLigament() {
		return falciformLigament;
	}

	public void setFalciformLigament(FalciformLigament falciformLigament) {
		this.falciformLigament = falciformLigament;
	}


	public LeftSagittalFossa getLeftSagittalFossa() {
		return leftSagittalFossa;
	}

	public void setLeftSagittalFossa(LeftSagittalFossa leftSagittalFossa) {
		this.leftSagittalFossa = leftSagittalFossa;
	}

	public LeftTriangularLigaments getLeftTriangularLigaments() {
		return leftTriangularLigaments;
	}

	public void setLeftTriangularLigaments(
			LeftTriangularLigaments leftTriangularLigaments) {
		this.leftTriangularLigaments = leftTriangularLigaments;
	}

	public LigamentumTeres getLigamentumTeres() {
		return ligamentumTeres;
	}

	public void setLigamentumTeres(LigamentumTeres ligamentumTeres) {
		this.ligamentumTeres = ligamentumTeres;
	}

	public LigamentumVenosum getLigamentumVenosum() {
		return ligamentumVenosum;
	}

	public void setLigamentumVenosum(LigamentumVenosum ligamentumVenosum) {
		this.ligamentumVenosum = ligamentumVenosum;
	}

	public LiverCentralVeins getLiverCentralVeins() {
		return liverCentralVeins;
	}

	public void setLiverCentralVeins(LiverCentralVeins liverCentralVeins) {
		this.liverCentralVeins = liverCentralVeins;
	}

	public LiverLobules getLiverLobules() {
		return liverLobules;
	}

	public void setLiverLobules(LiverLobules liverLobules) {
		this.liverLobules = liverLobules;
	}

	public Peritoneum getPeritoneum() {
		return Peritoneum;
	}

	public void setPeritoneum(Peritoneum peritoneum) {
		Peritoneum = peritoneum;
	}

	public HepaticPortalVein getPortalVein() {
		return portalVein;
	}

	public void setPortalVein(HepaticPortalVein portalVein) {
		this.portalVein = portalVein;
	}

	

	public RoundLigament getRoundLigament() {
		return roundLigament;
	}

	public void setRoundLigament(RoundLigament roundLigament) {
		this.roundLigament = roundLigament;
	}

	public Sinusoids getSinusoids() {
		return sinusoids;
	}

	public void setSinusoids(Sinusoids sinusoids) {
		this.sinusoids = sinusoids;
	}

	public SpaceOfDisse getSpaceOfDisse() {
		return spaceOfDisse;
	}

	public void setSpaceOfDisse(SpaceOfDisse spaceOfDisse) {
		this.spaceOfDisse = spaceOfDisse;
	}

	public TransverseFissure getTransverseFissure() {
		return transverseFissure;
	}

	public void setTransverseFissure(TransverseFissure transverseFissure) {
		this.transverseFissure = transverseFissure;
	}

	public VisceralPeritoneum getVisceralPeritoneum() {
		return visceralPeritoneum;
	}

	public void setVisceralPeritoneum(VisceralPeritoneum visceralPeritoneum) {
		this.visceralPeritoneum = visceralPeritoneum;
	}
	
}
