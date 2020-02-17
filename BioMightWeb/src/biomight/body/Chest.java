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

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.hair.ChestHair;
import biomight.body.organ.Trachea;
import biomight.body.organ.heart.Heart;
import biomight.body.organ.lung.Bronchi;
import biomight.body.organ.lung.LobarBronchi;
import biomight.body.organ.lung.Lung;
import biomight.body.organ.lung.Lungs;
import biomight.body.organ.lung.SegmentalinicBronchi;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.chest.DiaphragmMuscle;
import biomight.system.muscular.chest.DiaphragmMuscles;
import biomight.system.muscular.chest.IntercostalesExterniMuscles;
import biomight.system.muscular.chest.IntercostalesInterniMuscles;
import biomight.system.muscular.chest.LevatoresCostarumMuscles;
import biomight.system.muscular.chest.PectoralisMajorMuscles;
import biomight.system.muscular.chest.PectoralisMinorMuscles;
import biomight.system.muscular.chest.SerratusPosteriorInferiorMuscles;
import biomight.system.muscular.chest.SerratusPosteriorSuperiorMuscles;
import biomight.system.muscular.chest.SubcostalisMuscles;
import biomight.system.muscular.chest.TransversusThoracisMuscles;
import biomight.system.skeletal.chest.Clavicle;
import biomight.system.skeletal.chest.Scapula;
import biomight.system.skeletal.chest.Sternum;
import biomight.system.skeletal.chest.XiphoidProcess;
import biomight.system.skeletal.ribs.RibCage;
import biomight.system.skeletal.ribs.Ribs;
import biomight.system.tissue.epithelial.EpitheliumTissue;
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
import biomight.system.vascular.arteries.chest.RightCoronaryArtery;
import biomight.system.vascular.arteries.chest.SubclavianArteries;
import biomight.system.vascular.arteries.chest.ThoracicArteries;
import biomight.system.vascular.arteries.head.CommonCarotidArteries;
import biomight.system.vascular.veins.chest.GreatCardiacVein;
import biomight.system.vascular.veins.chest.InferiorVenaCava;
import biomight.system.vascular.veins.chest.SmallCardiacVein;
import biomight.system.vascular.veins.chest.SubclavianVeins;
import biomight.system.vascular.veins.chest.SuperiorVenaCava;
import biomight.system.vascular.veins.neck.InnominateVeins;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
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


/**********************************************************************
 * @author SurferJim
 *
 *  This object represents the chest.
 *
 *********************************************************************/

public class Chest extends BioMightBase {
	private EpitheliumTissue epithelium;
	private ArrayList<BioMightPropertyView> localBioMightProperties;
	private ArrayList colors;
	
	// Organs
	private Lungs lungs;
	
	private Bronchi  bronchi;
	private LobarBronchi  lobarBronchi;
	private SegmentalinicBronchi segmentalinicBronchi;
	
	private Heart heart;
	
	// Internal Structures
	private DiaphragmMuscle diaphram;
	private Esophagus esophagus;
	private Trachea trachea;
	private XiphoidProcess xiphoidProcess;
	
	// Muscles
	private PectoralisMajorMuscles pectoralisMajorMuscles;
	private PectoralisMinorMuscles pectoralisMinorMuscles; 
	//private CoracoBrachialisMuscle coracoBrachialisMuscle;
	private DiaphragmMuscles diaphragmMuscles;
	private IntercostalesExterniMuscles intercostalesExterniMuscles;
	private IntercostalesInterniMuscles intercostalesInterniMuscles;
	private LevatoresCostarumMuscles levatoresCostarumMuscles;
	private SerratusPosteriorSuperiorMuscles serratusPosteriorSuperiorMuscles;
	private SerratusPosteriorInferiorMuscles serratusPosteriorInferiorMuscles;
	private SubcostalisMuscles subcostalisMuscles;
	private TransversusThoracisMuscles transversusThoracisMuscles;
	
	
	// Arteries of the Chest/Thorax
	private SuperiorVenaCava superiorVenaCava;
	private InferiorVenaCava inferiorVenaCava;
	private AortaArtery aortaArtery;
	private AscendingAortaArtery ascendingAortaArtery;
	private AxillaryArteries axillaryArteries;
	private BronchialArteries bronchialArteries;
	private ConusArtery conusArtery;
	private DescendingAortaArtery descendingAortaArtery;
	private InferiorAlveolarArtery inferiorAlveolarArtery;
	private CoronaryArteries coronaryArteries;
	private CommonCarotidArteries commonCarotidArteries;
	private ObtuseMarginalArtery obtuseMarginalArtery;
	private PulmonaryArteries pulmonaryArteries;
	private RightCoronaryArtery rightCoronaryArtery;
	private SubclavianArteries subclavianArteries;
	private ThoracicArteries thoracicArteries;
	private BrachioCephalicArtery brachioCephalicArtery;

	private GreatCardiacVein greatCardiacVein;
	private SmallCardiacVein smallCardiacVein;
	private InnominateVeins innominateVeins;
	private SubclavianVeins subclavianVeins;
	
	
	// Skeletal
	private Scapula scapula;
	private Sternum sternum;
	private RibCage ribCage;
	private Clavicle clavicle;
	private Ribs ribs;
	
	// Body
	private Nipples nipples;
	private ChestHair chestHair;
	
	
	//private MammaryGlands mammaryGlands;

	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Chest()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ChestRef, null, null);
	}

	public Chest(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Chest(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Chest.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		localBioMightProperties	 = bioMightProperties;
		
		// Get the Bounding Box from the Constructor that defines the Chest
		//HashMap boundingBoxesMap = null;
		// Get the Bounding Box from the Constructor that defines 
		// the perimeter of Chest  Pass that into the BoundingBoxes 
		// method so it can be divied up.
		
		//System.out.println("Chest - Getting BoundBox & Connectors!");
		//BioMightBoundBox componentBoundBox = null;
		//BioMightConstruct bioMightConstruct = null;
		//if (bioMightConstruct == null)
		//{
			// Its null, so set up default boundbox with connectors 
		//	componentBoundBox = setupDefaultBoundBox();
		//}
		//else
		//{
		//	// Use the incoming
		//	componentBoundBox = bioMightConstruct.getBoundingBox(Constants.ChestRef);	
		//}
		//BioMightConnectors componentConnectors = componentBoundBox.getBioMightConnectors();
		//if (componentConnectors == null)
		//	System.out.println("Chest - ComponentConnectors are NULL!!");
		
		
		//System.out.println("Chest - Setting up internal Bounding Boxes!");
		//boundingBoxesMap = setupBoundBoxes(componentBoundBox);

		// Set up a Constructor that will be used to pass informatino into the components
		//BioMightConstruct bioConstruct = null; 
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ChestInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ChestRef, parentID);
			System.out.println("Have Chest Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Chest");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Chest.x3d";
			
		// Run through Chest and build its components into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Chest NumTransforms: " + transforms.size());	
		
		// There will be only 1 instance of the BioMightSystems Library in the database
		boolean bStored = false;
		for (int i=0; i<transforms.size(); i++)
		{	
			// Get the information for the Chest
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Have Chest (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
		
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			ArrayList<BioMightPropertyView> bioMightStoredProperties;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting Property info for BioMightSystems: " + bioMightTransform.getId());
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightStoredProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
				if (bioMightStoredProperties != null)
					System.out.println("Have Systems Property Info from EJB - NumProps: " + bioMightStoredProperties.size());
				else
					System.out.println("Have No Systems Property Info from EJB - NumProps: " + 0);
					
			}catch (Exception e) { 
				System.out.println("Exception Getting Components Properties - BioMightSystems");
				throw new ServerException("Remote Exception getComponents():", e); 	
			} 
					
			
			// If localProperties are null, meaning we are coming into the screen from somewhere
			// else, then use the storedProperties
			if (localBioMightProperties == null || localBioMightProperties.size() == 0)
			{
				System.out.println("In BioMightSystems - BioMightLocalProperties are Null");
				localBioMightProperties = bioMightStoredProperties;
				System.out.println("Replaced Local Properties with Database Stored Properties");
				bStored = true;
			}
			else
			{
				System.out.println("In BioMightSystems - BioMightLocalProperties nonNull Size is: " + localBioMightProperties.size());
			}


		
			System.out.println("Creating Chest Epithelium: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
			epithelium = new EpitheliumTissue("ChestEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty("ChestEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.EpitheliumTissueRef, localBioMightProperties));
			
			System.out.println("Creating Heart using ParentID: " + bioMightTransform.getId());
			heart = new Heart(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Heart", Constants.Heart, Constants.HeartRef, heart.getComponentID());
			System.out.println("Heart is created");

			System.out.println("Creating Lungs using ParentID: " + bioMightTransform.getId());
			lungs = new Lungs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Lungs", Constants.Lungs, Constants.LungsRef, lungs.getComponentID());
			initProperty(Constants.LungsRef, Constants.Lungs, Constants.LungsRef, lungs.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.LungsRef, localBioMightProperties));						

			System.out.println("Lungs are created");
	
				
			// ESOPHAGUS		
			// The BioConstructor contains the Neck
			// We Access the Neck Map to the Esophagus BioMightGenerated object and use the
			// information in that to connect up here.
			System.out.println("Creating Esophagus using ParentID: " + bioMightTransform.getId());
			/*
			System.out.println("In Chest - Creating Esophagus Constructor");
			bioConstruct = new BioMightConstruct();
			// Set the connector from the parent if defined that defines the starting point  
			bioConstruct.setBoundingBox(Constants.EsophagusRef, (BioMightBoundBox)boundingBoxesMap.get(Constants.EsophagusRef));			
			System.out.println("In Chest -  Esophagus Constructor created");
			
			System.out.println("Creating Esophagus using ParentID: " + bioMightTransform.getId());
			*/
			String startID = "EsophagusEpithelium:00160";
			esophagus = new Esophagus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEsophagus = esophagus.getBioMightGenerate(); 
			initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.EsophagusRef, localBioMightProperties));				
			
			/*
			BioMightBoundBox tempboundingBox = bioConstruct.getBoundingBox(Constants.EsophagusRef);
			if (tempboundingBox  != null) {
				dimensions = tempboundingBox.getxPos() + " ," + tempboundingBox.getyPos() + " ," + tempboundingBox.getzPos() ;
				bioPos = tempboundingBox.getxPos() + " ," + tempboundingBox.getyPos() + " ," + tempboundingBox.getzPos() ;	
			}
			initProperty("Esophagus", Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			*/	
			System.out.println("Esophagus is created");
			
			
			// TRACHEA				
			//System.out.println("In Chest - Creating Trachea Constructor");
			//bioConstruct = new BioMightConstruct();
			//Set the connector from the parent if defined that defines the starting point  
			//bioConstruct.setBoundingBox(Constants.TracheaRef, (BioMightBoundBox)boundingBoxesMap.get(Constants.TracheaRef));			
			//System.out.println("In Chest -  Trachea Constructor created");
			
			System.out.println("Creating Trachea using ParentID: " + bioMightTransform.getId());
			trachea = new Trachea(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedTrachea = trachea.getBioMightGenerate(); 		
			initProperty(Constants.TracheaRef, Constants.Trachea, Constants.TracheaRef, esophagus.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.TracheaRef, localBioMightProperties));					
			System.out.println("Trachea is created");

			/*	
			tempboundingBox = bioConstruct.getBoundingBox(Constants.TracheaRef);
			if (tempboundingBox  != null) {
				dimensions = tempboundingBox.getXVector() + " ," + tempboundingBox.getYVector() + " ," + tempboundingBox.getZVector() ;
				bioPos = tempboundingBox.getXPos() + " ," + tempboundingBox.getYPos() + " ," + tempboundingBox.getZPos() ;
			}
			*/
			
			// BRONCHI
			//System.out.println("In Chest - Creating Bronchi Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.BronchiRef, (BioMightBoundBoxes) boundingBoxesMap.get(Constants.BronchiRef));			
			//System.out.println("In Chest - Bronchi Constructor created");
			
			System.out.println("Creating Bronchi using ParentID: " + bioMightTransform.getId());
			bronchi = new Bronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedBronchi = bronchi.getBioMightGenerate(); 		
			initProperty("Bronchi", Constants.Bronchi, Constants.BronchiRef, bronchi.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BronchiRef, localBioMightProperties));
			System.out.println("Bronchi are created");
			
			
		
			//BioMightGenerate bronchusLeftGen = generatedBronchi.getMapComponent(Constants.LeftBronchusRef);
			//BioMightGenerate bronchusRightGen = generatedBronchi.getMapComponent(Constants.RightBronchusRef);
			//System.out.println("LeftBronchiMapConn are created: " + bronchusLeftGen.getConnectType());
			//System.out.println("RightBronchiMapConn are created: " + bronchusRightGen.getConnectType());
			
			
			// LOBAR BRONCHI	
			//System.out.println("In Chest - Creating LobarBronchi Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.LobarBronchiRef, (BioMightBoundBoxes) boundingBoxesMap.get(Constants.LobarBronchiRef));
			//bioConstruct.setBioMightGenerate(generatedBronchi);
			//System.out.println("In Chest - LobarBronchi Constructor created");
			
			System.out.println("Creating LobarBronchi using ParentID: " + bioMightTransform.getId());
			lobarBronchi = new LobarBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedLobarBronchi = lobarBronchi.getBioMightGenerate(); 				
			initProperty("LobarBronchi", Constants.LobarBronchi, Constants.LobarBronchiRef, lobarBronchi.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, localBioMightProperties));
			System.out.println("LobarBronchi are created");
	
			// SEGMENTALINIC BRONCHI	
			//System.out.println("In Chest - Creating SegmentalinicBronchi Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.SegmentalinicBronchiRef, (BioMightBoundBoxes) boundingBoxesMap.get(Constants.SegmentalinicBronchiRef));			
			//System.out.println("In Chest - SegmentalinicBronchi Constructor created");

			
			System.out.println("Creating SegmentalinicBronchi using ParentID: " + bioMightTransform.getId());
			segmentalinicBronchi = new SegmentalinicBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedSegmentalinicBronchi = segmentalinicBronchi.getBioMightGenerate(); 				
			initProperty("SegmentalinicBronchi", Constants.SegmentalinicBronchi, Constants.SegmentalinicBronchiRef, segmentalinicBronchi.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, localBioMightProperties));
			System.out.println("SegmentalinicBronchi are created");
					
			System.out.println("Creating Sternum using ParentID: " + bioMightTransform.getId());
			sternum = new Sternum(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedSternum = esophagus.getBioMightGenerate(); 				
			initProperty("Sternum", Constants.Sternum, Constants.SternumRef, sternum.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SternumRef, localBioMightProperties));
			System.out.println("Sternum is created");

			System.out.println("Creating PulmonaryArteries using ParentID: " + bioMightTransform.getId());
			pulmonaryArteries = new PulmonaryArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("PulmonaryArteries", Constants.PulmonaryArteries, Constants.PulmonaryArteriesRef, pulmonaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.PulmonaryArteriesRef, localBioMightProperties));
			System.out.println("PulmonaryArteries is created");

			System.out.println("Creating the BrachioCephalicArtery for ParentID: " + bioMightTransform.getId());
			brachioCephalicArtery = new BrachioCephalicArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BrachioCephalicArtery", Constants.BrachioCephalicArtery, Constants.BrachioCephalicArteryRef, brachioCephalicArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BrachioCephalicArteryRef, localBioMightProperties));
			System.out.println("Created the BrachioCephalicArtery");
			
			System.out.println("Creating the ThoracicArteries for ParentID: " + bioMightTransform.getId());
			thoracicArteries = new ThoracicArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ThoracicArtery", Constants.ThoracicArteries, Constants.ThoracicArteriesRef, thoracicArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ThoracicArteriesRef, localBioMightProperties));
			System.out.println("Created the ThoracicArteries");

			System.out.println("Creating the SubclavianArteries for ParentID: " + bioMightTransform.getId());
			subclavianArteries = new SubclavianArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(Constants.SubclavianArteriesRef, Constants.SubclavianArteries, Constants.SubclavianArteriesRef, subclavianArteries.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SubclavianArteriesRef, localBioMightProperties));	
			System.out.println("Created the SubclavianArteries");
		
			System.out.println("Creating the BronchialArteries for ParentID: " + bioMightTransform.getId());
			bronchialArteries = new BronchialArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("BronchialArteries", Constants.BronchialArteries, Constants.BronchialArteriesRef, bronchialArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BronchialArteries, localBioMightProperties));
			System.out.println("Created the BronchialArtery");
		
			System.out.println("Creating the ConusArtery for ParentID: " + bioMightTransform.getId());
			conusArtery = new ConusArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ConusArtery", Constants.ConusArtery, Constants.ConusArteryRef, conusArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ConusArteryRef, localBioMightProperties));
			System.out.println("Created the ConusArtery");

			System.out.println("Creating the AortaArtery for ParentID: " + bioMightTransform.getId());
			aortaArtery = new AortaArtery(bioMightTransform.getId(), bioMightMethods);
			initProperty("AortaArtery", Constants.AortaArtery, Constants.AortaArteryRef, aortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AortaArteryRef, localBioMightProperties));
			System.out.println("Created the AortaArtery");
	
			System.out.println("Creating the DescendingAortaArtery for ParentID: " + bioMightTransform.getId());
			descendingAortaArtery = new DescendingAortaArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("DescendingAortaArtery", Constants.DescendingAortaArtery, Constants.DescendingAortaArteryRef, descendingAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.DescendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the DescendingAortaArtery");
		
			System.out.println("Creating the AscendingAortaArtery for ParentID: " + bioMightTransform.getId());		
			ascendingAortaArtery = new AscendingAortaArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("AscendingAortaArtery", Constants.AscendingAortaArtery, Constants.AscendingAortaArteryRef, ascendingAortaArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the AscendingAortaArtery");
			
			System.out.println("Creating the AxillaryArteries for ParentID: " + bioMightTransform.getId());
			axillaryArteries = new AxillaryArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("AxillaryArteries", Constants.AxillaryArteries, Constants.AxillaryArteriesRef, axillaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AxillaryArteriesRef, localBioMightProperties));
			System.out.println("Created the AxillaryArteries");
	
			System.out.println("Creating the SuperiorVenaCava for ParentID: " + bioMightTransform.getId());
			superiorVenaCava = new SuperiorVenaCava(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("SuperiorVenaCava", Constants.SuperiorVenaCava, Constants.SuperiorVenaCavaRef, superiorVenaCava.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SuperiorVenaCavaRef, localBioMightProperties));
			System.out.println("Created the SuperiorVenaCava");
	
			System.out.println("Creating the InferiorVenaCava for ParentID: " + bioMightTransform.getId());
			inferiorVenaCava = new InferiorVenaCava(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("InferiorVenaCava", Constants.InferiorVenaCava, Constants.InferiorVenaCavaRef, inferiorVenaCava.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the InferiorVenaCava");
		
			System.out.println("Creating the CoronaryArteries for ParentID: " + bioMightTransform.getId());
			coronaryArteries = new CoronaryArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CoronaryArteries", Constants.CoronaryArteries, Constants.CoronaryArteriesRef, coronaryArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.CoronaryArteriesRef, localBioMightProperties));
			System.out.println("Created the CoronaryArteries");
	
			System.out.println("Creating the CommonCarotidArteries for ParentID: " + bioMightTransform.getId());
			commonCarotidArteries = new CommonCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CommonCarotidArteries", Constants.CommonCarotidArteries, Constants.CommonCarotidArteriesRef, commonCarotidArteries.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.CommonCarotidArteriesRef, localBioMightProperties));
			System.out.println("Created the CommonCarotidArteries");
		
			System.out.println("Creating the ObtuseMarginalArtery for ParentID: " + bioMightTransform.getId());
			obtuseMarginalArtery = new ObtuseMarginalArtery(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ObtuseMarginalArtery", Constants.ObtuseMarginalArtery, Constants.ObtuseMarginalArteryRef, obtuseMarginalArtery.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ObtuseMarginalArteryRef, localBioMightProperties));
			System.out.println("Created the ObtuseMarginalArtery");
			
			//VEINS
			System.out.println("Creating the GreatCardiacVein for ParentID: " + bioMightTransform.getId());
			greatCardiacVein = new GreatCardiacVein(bioMightTransform.getId(), bioMightMethods);
			initProperty("GreatCardiacVein", Constants.GreatCardiacVein, Constants.GreatCardiacVeinRef, greatCardiacVein.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.GreatCardiacVeinRef, localBioMightProperties));
			System.out.println("Created the GreatCardiacVein");
	
			System.out.println("Creating the SmallCardiacVein for ParentID: " + bioMightTransform.getId());
			smallCardiacVein = new SmallCardiacVein(bioMightTransform.getId(), bioMightMethods);
			initProperty("SmallCardiacVein", Constants.SmallCardiacVein, Constants.SmallCardiacVeinRef, smallCardiacVein.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SmallCardiacVeinRef, localBioMightProperties));
			System.out.println("Created the SmallCardiacVein");
	
			System.out.println("Creating the InnominateVeins for ParentID: " + bioMightTransform.getId());
			innominateVeins = new InnominateVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("InnominateVeins", Constants.InnominateVeins, Constants.InnominateVeinsRef, innominateVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.InnominateVeinsRef, localBioMightProperties));
			System.out.println("Created the InnominateVeins");

			System.out.println("Creating the SubClavianVeins for ParentID: " + bioMightTransform.getId());
			subclavianVeins = new SubclavianVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("SubClavianVeins", Constants.SubclavianVeins, Constants.SubclavianVeinsRef, subclavianVeins.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.SubclavianVeinsRef, localBioMightProperties));
			System.out.println("Created the SubClavianVeins");

			System.out.println("Creating Ribs using ParentID: " + bioMightTransform.getId());
			ribs = new Ribs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("Ribs", Constants.Ribs, Constants.RibsRef, ribs.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.RibsRef, localBioMightProperties));
			System.out.println("Ribs are created");
	
			// Create the Muscles
			System.out.println("Creating the PectoralisMajorMuscles for parent: " + parentID);
			pectoralisMajorMuscles = new PectoralisMajorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("PectoralisMajorMuscles", Constants.PectoralisMajorMuscles, Constants.PectoralisMajorMusclesRef, pectoralisMajorMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.PectoralisMajorMusclesRef, localBioMightProperties));
			System.out.println("Created the PectoralisMajorMuscles");
	
			System.out.println("Creating the PectoralisMinorMuscles for parent: " + parentID);
			pectoralisMinorMuscles = new PectoralisMinorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("PectoralisMinorMuscles", Constants.PectoralisMinorMuscles, Constants.PectoralisMinorMusclesRef, pectoralisMinorMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.PectoralisMinorMusclesRef, localBioMightProperties));
			System.out.println("Created the PectoralisMinorMuscles");
	
			System.out.println("Creating the DiaphragmMuscles for parent: " + parentID);
			diaphragmMuscles = new DiaphragmMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("DiaphragmMuscles", Constants.DiaphragmMuscles, Constants.DiaphragmMusclesRef, diaphragmMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the DiaphragmMuscles");
	
			System.out.println("Creating the TransversusThoracisMuscles for parent: " + parentID);
			transversusThoracisMuscles = new TransversusThoracisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("TransversusThoracisMuscles", Constants.TransversusThoracisMuscles, Constants.TransversusThoracisMusclesRef, transversusThoracisMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the TransversusThoracisMuscles");
	
			System.out.println("Creating the IntercostalesExterniMuscles for parent: " + parentID);
			intercostalesExterniMuscles = new IntercostalesExterniMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("IntercostalesExterniMuscles", Constants.IntercostalesExterniMuscles, Constants.IntercostalesExterniMusclesRef, intercostalesExterniMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the IntercostalesExterniMuscles");
	
			System.out.println("Creating the IntercostalesInterniMuscles for parent: " + parentID);
			intercostalesInterniMuscles = new IntercostalesInterniMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("IntercostalesInterniMuscles", Constants.IntercostalesInterniMuscles, Constants.IntercostalesInterniMusclesRef, intercostalesInterniMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the IntercostalesInterniMuscles");
	
			System.out.println("Creating the SubcostalisMuscles for parent: " + parentID);
			subcostalisMuscles = new SubcostalisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SubcostalisMuscles", Constants.SubcostalisMuscles, Constants.SubcostalisMusclesRef, subcostalisMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the SubcostalisMuscles");
	
			System.out.println("Creating the LevatoresCostarumMuscles for parent: " + parentID);
			levatoresCostarumMuscles = new LevatoresCostarumMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("LevatoresCostarumMuscles", Constants.LevatoresCostarumMuscles, Constants.LevatoresCostarumMusclesRef, levatoresCostarumMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the LevatoresCostarumMuscles");
	
			System.out.println("Creating the SerratusPosteriorSuperiorMuscles for parent: " + parentID);
			serratusPosteriorSuperiorMuscles = new SerratusPosteriorSuperiorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SerratusPosteriorSuperiorMuscles", Constants.SerratusPosteriorSuperiorMuscles, Constants.SerratusPosteriorSuperiorMusclesRef, serratusPosteriorSuperiorMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the SerratusPosteriorSuperiorMuscles");
	
			System.out.println("Creating the SerratusPosteriorInferiorMuscles for parent: " + parentID);
			serratusPosteriorInferiorMuscles = new SerratusPosteriorInferiorMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SerratusPosteriorInferiorMuscles", Constants.SerratusPosteriorInferiorMuscles, Constants.SerratusPosteriorInferiorMusclesRef, serratusPosteriorInferiorMuscles.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AscendingAortaArteryRef, localBioMightProperties));
			System.out.println("Created the SerratusPosteriorInferiorMuscle");
	
			
			// Store all the connection points for the ChestMap.  
			// Then stuff this map into the BioGeneate Object for the chest.  
			//HashMap chestMap = new HashMap();
			//chestMap.put(Constants.EsophagusRef, generatedEsophagus);
			//chestMap.put(Constants.TracheaRef, generatedTrachea);
			//this.bioMightGenerate.setComponentMap(chestMap);
			//System.out.println("Stored Chest Map");
						
			
			/*int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("Sclera Eye is created");
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
		
			/*
			// Skeletal

					
			clavicle = new Clavicle(basePosition);
			System.out.println("Clavicle is created");

			ribCage = new RibCage(basePosition);
			System.out.println("RibCage is created");
		*/
						
		}		

		//initProperties();
		initMethods();
	}

	// Generate the Chest based on object defaults
	// This algorithm generates the default data in the database using key
	// data defined within the object.
	public void create()
	{
	  // Run from top of chest to bottom
		
		
		
	}
	

	
	public void initProperties() {
		
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Chest Hair");
		property.setCanonicalName(Constants.ChestHair);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Nipples");
		property.setCanonicalName(Constants.Nipples);
		properties.add(property);
		
		// ORGANS
		property = new BioMightPropertyView();
		property.setPropertyName("Title");
		property.setCanonicalName(Constants.Organs);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Lungs");
		property.setCanonicalName(Constants.Lungs);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Heart");
		property.setCanonicalName(Constants.Heart);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Esophagus");
		property.setCanonicalName(Constants.Esophagus);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Trachea");
		property.setCanonicalName(Constants.Trachea);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("XiphoidProcess");
		property.setCanonicalName(Constants.XiphoidProcess);
		properties.add(property);				
		
		// SKELETAL
		property = new BioMightPropertyView();
		property.setPropertyName("Skeletal");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Scapula");
		property.setCanonicalName(Constants.Scapula);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Sternum");
		property.setCanonicalName(Constants.Sternum);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("RibCage");
		property.setCanonicalName(Constants.RibCage);
		properties.add(property);
		
		
		// VASCULAR		
		property = new BioMightPropertyView();
		property.setPropertyName("Vascular");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Vena Cava");
		property.setCanonicalName(Constants.InferiorVenaCava);
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
		property.setPropertyName("Axillary Artery");
		property.setCanonicalName(Constants.AxillaryArtery);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Bronchial Artery");
		property.setCanonicalName(Constants.BronchialArtery);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Great Cardiac Vein");
		property.setCanonicalName(Constants.GreatCardiacVein);
		properties.add(property);	
	
		property = new BioMightPropertyView();
		property.setPropertyName("Conus Artery");
		property.setCanonicalName(Constants.ConusArtery);
		properties.add(property);	
	
		property = new BioMightPropertyView();
		property.setPropertyName("Descending Aorta");
		property.setCanonicalName(Constants.DescendingAortaArtery);
		properties.add(property);	
	
		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Alveolar Artery");
		property.setCanonicalName(Constants.InferiorAlveolarArtery);
		properties.add(property);	
	
		property = new BioMightPropertyView();
		property.setPropertyName("Left Coronary Artery");
		property.setCanonicalName(Constants.LeftCoronaryArtery);
		properties.add(property);	
	
		property = new BioMightPropertyView();
		property.setPropertyName("Left Main Coronary Artery");
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

	
		// LEFT MUSCULAR		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("Left Diaphragm Muscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Intercostales Externi Muscles");
		property.setCanonicalName(Constants.IntercostalesExterniMuscles);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Intercostales Interni Muscles");
		property.setCanonicalName(Constants.IntercostalesInterniMuscles);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Levatores Costarum Muscles");
		property.setCanonicalName(Constants.LevatoresCostarumMuscles);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Left Serratus Posterior Superior Muscles");
		property.setCanonicalName(Constants.SerratusPosteriorSuperiorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Left Serratus Posterior Inferior Muscle");
		property.setCanonicalName(Constants.SerratusPosteriorInferiorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Left Subcostales Muscle");
		property.setCanonicalName(Constants.SubcostalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Left Transversus Thoracis Muscle");
		property.setCanonicalName(Constants.TransversusThoracisMuscle);
		properties.add(property);		


		// RIGHT MUSCULAR						
		property = new BioMightPropertyView();
		property.setPropertyName("Right Diaphragm Muscle");
		property.setCanonicalName(Constants.DiaphragmMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Right Serratus Posterior Superior Muscle");
		property.setCanonicalName(Constants.SerratusPosteriorSuperiorMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Right Serratus Posterior Inferior Muscle");
		property.setCanonicalName(Constants.SerratusPosteriorInferiorMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Right Subcostales Muscle");
		property.setCanonicalName(Constants.SubcostalisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Right Transversus Thoracis Muscle");
		property.setCanonicalName(Constants.TransversusThoracisMuscle);
		properties.add(property);		
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Think");
		method.setHtmlType("text");
		method.setDataType("boolean");
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
		
		// Assemble the Chest
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Chest.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Chest'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
				epithelium.getX3D(true) + 
				superiorVenaCava.getX3D(true) + 
				inferiorVenaCava.getX3D(true) + 
				aortaArtery.getX3D(true) +
				ascendingAortaArtery.getX3D(true) +
				descendingAortaArtery.getX3D(true) +
				pulmonaryArteries.getX3D(true) + 
				brachioCephalicArtery.getX3D(true) +
				axillaryArteries.getX3D(true) +
				bronchialArteries.getX3D(true) +
				thoracicArteries.getX3D(true) +
				subclavianArteries.getX3D(true) +
				//obtuseMarginalArtery.getX3D(true) +
				greatCardiacVein.getX3D(true) +
				smallCardiacVein.getX3D(true) +
				innominateVeins.getX3D(true) +
				subclavianVeins.getX3D(true) +
				ribs.getX3D(true) +
				pectoralisMajorMuscles.getX3D(true) +
				pectoralisMinorMuscles.getX3D(true) +
				diaphragmMuscles.getX3D(true) +
				transversusThoracisMuscles.getX3D(true) +
				intercostalesExterniMuscles.getX3D(true) +
				intercostalesInterniMuscles.getX3D(true) +
				levatoresCostarumMuscles.getX3D(true) +
				serratusPosteriorSuperiorMuscles.getX3D(true) +
				serratusPosteriorInferiorMuscles.getX3D(true) +
				subcostalisMuscles.getX3D(true);
		
			
			if (BioWebUtils.isViewEnabled(Constants.HeartRef, localBioMightProperties)) {
				body += heart.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.LungsRef, localBioMightProperties)) {
				lungs.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.EsophagusRef, localBioMightProperties)) {
				body += esophagus.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.TracheaRef, localBioMightProperties)) {
				body += trachea.getX3D(true) ;
			}
			if (BioWebUtils.isViewEnabled(Constants.BronchiRef, localBioMightProperties)) {
				body += bronchi.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.CommonHepaticDuctRef, localBioMightProperties)) {
				//body += commonHepaticDuct.getX3D(true);
			}	
			if (BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, localBioMightProperties)) {
				body += lobarBronchi.getX3D(true);
			}	
			if (BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, localBioMightProperties)) {
				body += segmentalinicBronchi.getX3D(true);
			}	
			if (BioWebUtils.isViewEnabled(Constants.SternumRef, localBioMightProperties)) {
				body += sternum.getX3D(true);
			}		
			if (BioWebUtils.isViewEnabled(Constants.CoronaryArteriesRef, localBioMightProperties)) {
				body += coronaryArteries.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.CommonCarotidArteriesRef, localBioMightProperties)) {
				body += commonCarotidArteries.getX3D(true);
			}
			
		/*
		private InferiorAlveolarArtery inferiorAlveolarArtery;
		clavicle.getX3D(true) */  
		//System.out.println("Chest X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	/********************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Chest.  
	 *
	 * @return
	 ********************************************************************/
	private BioMightBoundBox setupDefaultBoundBox() 
	{
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 magnitude
		BigDecimal xVectorMag= new BigDecimal(1.0);
		BigDecimal yVectorMag= new BigDecimal(1.0); 
		BigDecimal zVectorMag= new BigDecimal(1.0);
	
		// Set to base 1x1x1 direction resulting in cube
		BigDecimal xVectorDir= new BigDecimal(1.0);
		BigDecimal yVectorDir= new BigDecimal(1.0); 
		BigDecimal zVectorDir= new BigDecimal(1.0);
	
		double theta = 45.0;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		
		//**********************************************************************
		// CHEST BOUND BOX		
		//
		// Set up the Bounding Box for the Chest
		// For default model, length of chest is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVectorMag= new BigDecimal(11.5);
		yVectorMag= new BigDecimal(6.0); 
		zVectorMag= new BigDecimal(5.0);
		
		// Setuo the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// CHEST - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ChestEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ChestEpitheliumRef, bioMightConnector);
	
		// Trachea Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -2.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.TracheaRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaRef, bioMightConnector);
	
		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// CHEST - VASCULAR CONNECTORS  
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
		// CHEST - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// CHEST - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Chest.   These boxes will define
	 *  the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
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
		BigDecimal xVectorMag= new BigDecimal(1.0);
		BigDecimal yVectorMag= new BigDecimal(1.0); 
		BigDecimal zVectorMag= new BigDecimal(1.0);

		// Rotation Vector
		BigDecimal xVectorDir= new BigDecimal(1.0);
		BigDecimal yVectorDir= new BigDecimal(1.0); 
		BigDecimal zVectorDir= new BigDecimal(1.0);

		// direction anlgle
		double theta = 30.0;
		
		// Initialize the BoundBoxes. This is used for
		// collections such as arms, legs,lungs,etc
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;

		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);

		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			System.out.println("Chest - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Chest
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-9.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(9.0);
		yVectorMag= new BigDecimal(8.0); 
		zVectorMag= new BigDecimal(4.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
		
		// Chest Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -9.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.0, -17.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, "ChestEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("ChestEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		boundingBoxMap.put(Constants.ChestEpitheliumRef, bioBoundBox);
		
		
		//********************************************************************* 
		// TRACHEA BOUNDBOX
		// Set up the Bounding Box for the Trachea
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-8.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(3.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Trachea Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.0, -11.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.TracheaEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaEpitheliumRef, bioMightConnector);
		
		// Trachea Muscle Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.00, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.0, -11.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, "TracheaMuscle","connType");
		bioMightConnectors.setBioMightConnector("TracheaMuscle", bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.TracheaRef, bioBoundBox);
		
		
		//********************************************************************* 
		// ESOPHAGUS BOUNDBOX
		// Set up the Bounding Box for the Esophagus
		// On a porportioned human, the Esophagus lie in the middle of the... 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-6.0);
		zPos= new BigDecimal(-2.5);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(5.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// EsophagusEpithelium StartConnector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -2.5);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.0, -12.0, -2.5);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.EsophagusEpitheliumRef, "");		
	
		bioMightConnectors.setBioMightConnector(Constants.EsophagusEpitheliumRef, bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.EsophagusRef, bioBoundBox);


		//********************************************************************* 
		// BRONCHI BOUND BOXES
		// Set up the Bounding Boxes for the Bronchi.   
		// The Bronchi attach to the end of the Trachea 
		//**********************************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
		
		//********************************************************************* 
		// LEFT BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-12.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftBronchusRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT BRONCHI BOUNDBOX
		// Set up the Bounding Box for the Bronchi
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-12.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-0.5, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-0.75, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.BronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightBronchusRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Bronchi 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.BronchiRef, bioBoundBoxes);		
		
		
		//*******************************************************************************
		//
		// LOBAR BRONCHI BOUND BOXES
		//
		// Set up the Bounding Box for the Lobar Bronchi
		// There are 3 bronus on the right branch and two bronchus on the left
		//
		//
		//*******************************************************************************
		
		// Setup the Boes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// LEFT SUPERIOR LOBE BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);
	
		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -13.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(1.5, -14.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorLobeBronchusRef, bioBoundBox);	

	
		//********************************************************************* 
		// LEFT INFERIOR LOBE BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(2.0);
		yPos = new BigDecimal(-13.5);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);
		
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(2.0, -13.5, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(2.5, -14.5, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorLobeBronchusRef, bioBoundBox);	

	
		//********************************************************************* 
		// RIGHT SUPERIOR LOBE BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -13.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-1.5, -14.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightSuperiorLobeBronchusRef, bioBoundBox);	

	
		//********************************************************************* 
		// RIGHT INFERIOR LOBE BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Middle Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-13.5);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -13.5, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-1.5, -14.5, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightMiddleLobeBronchusRef, bioBoundBox);	


		//********************************************************************* 
		// RIGHT INFERIOR LOBE BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-3.0);
		yPos = new BigDecimal(-13.75);
		zPos= new BigDecimal(-1.5);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-3.0, -13.75, -1.5);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-3.5, -14.50, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.LobarBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.LobarBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorLobeBronchusRef, bioBoundBox);	

		//*****************************************************
		// Put the BioMight BoundBoxes for the Lobar Bronchi 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.LobarBronchiRef, bioBoundBoxes);		

	
		//*******************************************************************************
		//
		// SEGMENTALINIC BRONCHI BOUND BOXES
		//
		// Set up the Bounding Box for the Segmentalinic Bronchi
		// There are 10 bronus on the right branch and 8 bronchus on the left
		//
		//
		//*******************************************************************************
		
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
			
		//********************************************************************* 
		// 01- LEFT SUPERIOR LOBE - APICO POSTERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -13.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(1.5, -14.00, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorApicoPosteriorBronchusRef, bioBoundBox);	


		//********************************************************************* 
		// 02- LEFT SUPERIOR LOBE - ANTERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(1.5, -15.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorAnteriorBronchusRef, bioBoundBox);	

		//********************************************************************* 
		// 03- LEFT SUPERIOR LOBE - INFERIOR LINGULAR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.5, -14.25, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(1.75, -15.25, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorInferiorLingularBronchusRef, bioBoundBox);	

		//********************************************************************* 
		// 04- LEFT SUPERIOR LOBE - SUPERIOR LINGULAR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(1.95, -15.75, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftSuperiorSuperiorLingularBronchusRef, bioBoundBox);	
		
		
		//********************************************************************* 
		// 05- LEFT INFERIOR LOBE - SUPERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorSuperiorBronchusRef, bioBoundBox);	
		
		//********************************************************************* 
		// 06- LEFT INFERIOR LOBE - ANTEROMEDIAL BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorAnteroMedialBasalBronchusRef, bioBoundBox);	
	
		
		//********************************************************************* 
		// 07- LEFT INFERIOR LOBE - POSTERIOR BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorPosteriorBasalBronchusRef, bioBoundBox);	
	
		//********************************************************************* 
		// 08- LEFT INFERIOR LOBE - LATERAL BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftInferiorLateralBasalBronchusRef, bioBoundBox);	
		
	
		//********************************************************************* 
		// 01- RIGHT SUPERIOR LOBE - APICAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -13.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightSuperiorApicalBronchusRef, bioBoundBox);	

			
		//********************************************************************* 
		// 02- RIGHT SUPERIOR LOBE - POSTERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -13.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightSuperiorPosteriorBronchusRef, bioBoundBox);	

		
		//********************************************************************* 
		// 03- RIGHT SUPERIOR LOBE - ANTERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Superior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-13.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -13.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightSuperiorAnteriorBronchusRef, bioBoundBox);	

		
		
		//********************************************************************* 
		// 04- RIGHT MIDDLE LOBE - LATERAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Middle Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightMiddleLateralBronchusRef, bioBoundBox);	

		
		//********************************************************************* 
		// 05- RIGHT MIDDLE LOBE - MEDIAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Right Middle Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-14.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-1.0, -14.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightMiddleMedialBronchusRef, bioBoundBox);	


		//********************************************************************* 
		// 06- RIGHT INFERIOR LOBE - SUPERIOR SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-3.5);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-3.5, -15.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorSuperiorBronchusRef, bioBoundBox);	

		
		//********************************************************************* 
		// 07- RIGHT INFERIOR LOBE - MEDIAL BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -15.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorMedialBasalBronchusRef, bioBoundBox);	
		
		//********************************************************************* 
		// 08- RIGHT INFERIOR LOBE - ANTERIOR BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -15.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorAnteriorBasalBronchusRef, bioBoundBox);	
	
		//********************************************************************* 
		// 09- RIGHT INFERIOR LOBE - LATERIOR BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -15.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorLateralBasalBronchusRef, bioBoundBox);	

		
		//********************************************************************* 
		// 10- RIGHT INFERIOR LOBE - POSTERIOR BASAL SEGMENTAL BRONCHUS BOUNDBOX
		// Set up the Bounding Box for the Left Inferior Bronchus
		// On a porportioned human, the Bronchi are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-2.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(2.0);
		yVectorMag= new BigDecimal(2.0); 
		zVectorMag= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// BronchusEpithelium Connector
		// This will look the same to the generic class as it should when using
		// the collection model of constructing objects
		circumference = 0.3;
		startPos = getStartPoints(-2.0, -15.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.SegmentalinicBronchusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.SegmentalinicBronchusEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightInferiorPosteriorBasalBronchusRef, bioBoundBox);	

		
		//*****************************************************
		// Put the BioMight BoundBoxes for the SegmentalinicBronchi 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.SegmentalinicBronchiRef, bioBoundBoxes);		

	
		return (boundingBoxMap);
	}
	

	
	public ChestHair getChestHair() {
		return chestHair;
	}

	public void setChestHair(ChestHair chestHair) {
		this.chestHair = chestHair;
	}

	public ConusArtery getConusArtery() {
		return conusArtery;
	}

	public void setConusArtery(ConusArtery conusArtery) {
		this.conusArtery = conusArtery;
	}
	
	public DiaphragmMuscle getDiaphram() {
		return diaphram;
	}

	public void setDiaphram(DiaphragmMuscle diaphram) {
		this.diaphram = diaphram;
	}

	public Esophagus getEsophagus() {
		return esophagus;
	}

	public void setEsophagus(Esophagus esophagus) {
		this.esophagus = esophagus;
	}

	public Heart getHeat() {
		return heart;
	}

	public void setHeat(Heart heat) {
		this.heart = heat;
	}

	public InferiorAlveolarArtery getInferiorAlveolarArtery() {
		return inferiorAlveolarArtery;
	}

	public void setInferiorAlveolarArtery(
			InferiorAlveolarArtery inferiorAlveolarArtery) {
		this.inferiorAlveolarArtery = inferiorAlveolarArtery;
	}

	public InferiorVenaCava getInferiorVenaCava() {
		return inferiorVenaCava;
	}

	public void setInferiorVenaCava(InferiorVenaCava inferiorVenaCava) {
		this.inferiorVenaCava = inferiorVenaCava;
	}


	public Nipples getNipples() {
		return nipples;
	}

	public void setNipples(Nipples nipples) {
		this.nipples = nipples;
	}

	public ObtuseMarginalArtery getObtuseMarginalArtery() {
		return obtuseMarginalArtery;
	}

	public void setObtuseMarginalArtery(ObtuseMarginalArtery obtuseMarginalArtery) {
		this.obtuseMarginalArtery = obtuseMarginalArtery;
	}

	public RightCoronaryArtery getRightCoronaryArtery() {
		return rightCoronaryArtery;
	}

	public void setRightCoronaryArtery(RightCoronaryArtery rightCoronaryArtery) {
		this.rightCoronaryArtery = rightCoronaryArtery;
	}

	public Scapula getScapula() {
		return scapula;
	}

	public void setScapula(Scapula scapula) {
		this.scapula = scapula;
	}


	public Sternum getSternum() {
		return sternum;
	}

	public void setSternum(Sternum sternum) {
		this.sternum = sternum;
	}

	public SuperiorVenaCava getSuperiorVenaCava() {
		return superiorVenaCava;
	}

	public void setSuperiorVenaCava(SuperiorVenaCava superiorVenaCava) {
		this.superiorVenaCava = superiorVenaCava;
	}

	public Trachea getTrachea() {
		return trachea;
	}

	public void setTrachea(Trachea trachea) {
		this.trachea = trachea;
	}

	public XiphoidProcess getXiphoidProcess() {
		return xiphoidProcess;
	}

	public void setXiphoidProcess(XiphoidProcess xiphoidProcess) {
		this.xiphoidProcess = xiphoidProcess;
	}
	
}
