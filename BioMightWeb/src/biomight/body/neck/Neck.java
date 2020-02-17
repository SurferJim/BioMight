/*
 * Created on May 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.neck;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.Esophagus;
import biomight.body.gland.thyroid.ParaThyroidGland;
import biomight.body.gland.thyroid.ThyroidGland;
import biomight.body.organ.Trachea;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.CricoidCartilage;
import biomight.system.cartilage.ThyroidCartilage;
import biomight.system.lymphatic.neck.SubMaxillaryGland;
import biomight.system.lymphatic.neck.SupraSternalNotch;
import biomight.system.muscular.LongusColliMuscle;
import biomight.system.muscular.TrapeziusMuscle;
import biomight.system.muscular.neck.AnteriorVeterbralMuscle;
import biomight.system.muscular.neck.LateralCervicleMuscle;
import biomight.system.muscular.neck.SternoMastoidMuscle;
import biomight.system.muscular.neck.SuperficialCervicalMuscle;
import biomight.system.muscular.neck.SupraInfrahyoidMuscle;
import biomight.system.myology.fasciae.PreVertebralFascia;
import biomight.system.nervous.nerves.RecurrentLaryngealNerve;
import biomight.system.nervous.nerves.SpinalAccessoryNerve;
import biomight.system.skeletal.chest.Clavicle;
import biomight.system.skeletal.spine.CervicalVertebrae;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.head.CommonCarotidArteries;
import biomight.system.vascular.arteries.head.ExternalCarotidArteries;
import biomight.system.vascular.arteries.head.InferiorCarotidArteries;
import biomight.system.vascular.arteries.head.InternalCarotidArteries;
import biomight.system.vascular.arteries.neck.SuperiorThyroidAtery;
import biomight.system.vascular.veins.neck.ExternalJugularVeins;
import biomight.system.vascular.veins.neck.InferiorThyroidVeins;
import biomight.system.vascular.veins.neck.InternalJugularVeins;
import biomight.system.vascular.veins.neck.MiddleThyroidVeins;
import biomight.system.vascular.veins.neck.SuperiorThyroidVeins;
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

/************************************************************************
 * @author SurferJim
 * 
 * Representation of the Neck
 * 
 * Copyright BioMight Inc
 * 
 ************************************************************************/

public class Neck extends BioMightBase {	
	private EpitheliumTissue epithelium;
	private Esophagus esophagus;
	
	// Glands
	private ThyroidGland thyroidGland;
	private ParaThyroidGland paraThyroidGland;
	
	
	// Larynx
	private Larynx larynx;
	
	// Lymphatic
	private SubMaxillaryGland subMaxillaryGland;
	
	// Muscular
	private AnteriorVeterbralMuscle anteriorVeterbralMuscle;
	private LateralCervicleMuscle LateralCervicleMuscle;
	private SuperficialCervicalMuscle SuperficialCervicalMuscle;
	private SupraInfrahyoidMuscle SupraInfrahyoidMuscle;
	private SternoMastoidMuscle sternoMastoidMuscle;
	private TrapeziusMuscle trapeziusMuscle;
	private LongusColliMuscle longusColliMuscle;
	
	
	// Nerves
	private SpinalAccessoryNerve spinalAccessoryNerve;
	
	
	// Cartilage
	private CricoidCartilage cricoidCartilage;
	private ThyroidCartilage ThyroidCartilage;

	private SupraSternalNotch suprasSternalNotch;
	private Trachea trachea;
	
	// Bones
	private Clavicle clavicle;
	private PreVertebralFascia preVertebralFascia;
	private RecurrentLaryngealNerve recurrentLaryngealNerve;
	private CervicalVertebrae cervicalVertebrae;
	private String componentID = "";

	
	// Vascular
	//private CarotidArteries carotidArteries;
	private CommonCarotidArteries commonCarotidArteries;
	private InternalCarotidArteries internalCarotidArteries;
	private ExternalCarotidArteries externalCarotidArteries;
	
	private InferiorCarotidArteries inferiorCarotidArteries;
	private SuperiorThyroidAtery superiorThyroidArtery;	
	
	private ExternalJugularVeins externalJugularVeins;
	private InternalJugularVeins internalJugularVeins;
	
	
	// Thyroid veins
	private SuperiorThyroidVeins superiorThyroidVeins;
	private MiddleThyroidVeins middleThyroidVeins;
	private InferiorThyroidVeins inferiorThyroidVeins;

	

	/************************************************************************
	 * Neck Constructor 
	 *
	 ***********************************************************************/
	public Neck()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.NeckRef, null, null);
	}

	/************************************************************************
	 * Neck Constructor 
	 *
	 ***********************************************************************/
	public Neck(String parentID)
	{
		System.out.print("Calling parameterized Neck Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Neck Constructor 
	 *
	 ***********************************************************************/
	public Neck(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Neck with MethodParams!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Neck
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		this.setImage("images/Neck.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		this.parentID = parentID;
				
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Neck
		// Either get from the Constructor or set up defaults
		System.out.println("NECK - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		BioMightConstruct bioMightConstruct = null;
		if (bioMightConstruct == null)
		{
			System.out.println("NECK - Setting up Default Bound Box");
			componentBoundBox = setupDefaultBoundBox();			
		}
		else {
			System.out.println("NECK - Using incoming Bound Box");		
			componentBoundBox = bioMightConstruct.getBoundingBox(Constants.NeckRef);	
		}
		if (componentBoundBox == null)
			System.out.println("NECK - Component BoundBox is null!!");
		
		BioMightConnectors componentConnectors = componentBoundBox.getBioMightConnectors();
		if (componentConnectors == null)
			System.out.println("NECK - ComponentConnectors are NULL!!");
		
		
		System.out.println("NECK - Setting up internal Bounding Boxes!");
		boundingBoxes = setupBoundBoxes(componentBoundBox);

		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NeckInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NeckRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Neck");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		// Run through Neck and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Neck NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Neck we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Neck (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();

			
			
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Neck - Setting up Epithelium Constructor");
			bioConstruct = new BioMightConstruct(); 	
			bioConstruct.setBoundingBox(Constants.NeckEpitheliumRef, (BioMightBoundBox)boundingBoxes.get(Constants.NeckEpitheliumRef));	
			System.out.println("In Neck - Epithelium Constructor Set");
			
			System.out.println("Calling generate Neck Epithelium: " + parentID);	
			// Generate the Kidney Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID, bioConstruct);
			}
		
			System.out.println("Creating Epithelium using ParentID: " + bioMightTransform.getId());	
			epithelium = new EpitheliumTissue("NeckEpithelium:00001", "NeckEpithelium",  "NeckEpithelium", bioMightTransform.getId(), bioConstruct, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate(); 		
			initProperty("NeckEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("Epithelium is created");
			
			
			// ESOPHAGUS
			System.out.println("In Neck - Creating Esophagus Constructor");
			bioConstruct = new BioMightConstruct();  
			bioConstruct.setBoundingBox(Constants.EsophagusRef, (BioMightBoundBox)boundingBoxes.get(Constants.EsophagusRef));			
			System.out.println("In Neck -  Esophagus Constructor created");
			
			System.out.println("Creating Esophagus using ParentID: " + bioMightTransform.getId());
			esophagus = new Esophagus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEsophagus = esophagus.getBioMightGenerate(); 
			initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			System.out.println("Esophagus is created");
			
			
			// TRACHEA				
			System.out.println("In Neck - Creating Trachea Constructor");
			bioConstruct = new BioMightConstruct();		
			bioConstruct.setBoundingBox(Constants.TracheaRef, (BioMightBoundBox)boundingBoxes.get(Constants.TracheaRef));
			System.out.println("In Neck -  Trachea Constructor created");
			
			System.out.println("Creating Trachea using ParentID: " + bioMightTransform.getId());
			trachea = new Trachea(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedTrachea = trachea.getBioMightGenerate(); 		
			initProperty("Trachea", Constants.Trachea, Constants.TracheaRef, trachea.getComponentID());
			System.out.println("Trachea is created");
		

			// Create the Vertebrae in the Neck
			cervicalVertebrae = new CervicalVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedCervicalVertebrae = cervicalVertebrae.getBioMightGenerate(); 
			initProperty("CervicalVertebrae", Constants.CervicalVertebrae, Constants.CervicalVertebraeRef, cervicalVertebrae.getComponentID());
			System.out.println("Created the CervicalVertebrae");
		
		
			System.out.println("Creating the ThyroidGland for ParentID: " + bioMightTransform.getId());
			thyroidGland = new ThyroidGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedThyroid = thyroidGland.getBioMightGenerate(); 
			initProperty(Constants.ThyroidGlandRef, Constants.ThyroidGland, Constants.ThyroidGlandRef, thyroidGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			System.out.println("Created the ThyroidGland");
			
			System.out.println("Creating the CommonCarotidArteries for ParentID: " + bioMightTransform.getId());
			commonCarotidArteries = new CommonCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedCommonCarotidArteries = commonCarotidArteries.getBioMightGenerate(); 
			initProperty("CommonCarotidArteries", Constants.CommonCarotidArteries, Constants.CommonCarotidArteriesRef, commonCarotidArteries.getComponentID());
			System.out.println("Created the CommonCarotidArteries");
		
			System.out.println("Creating the InternalCarotidArteries for ParentID: " + bioMightTransform.getId());
			internalCarotidArteries = new InternalCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedInternalCarotidArteries = internalCarotidArteries.getBioMightGenerate(); 
			initProperty("InternalCarotidArteries", Constants.InternalCarotidArteries, Constants.InternalCarotidArteriesRef, internalCarotidArteries.getComponentID());
			System.out.println("Created the InternalCarotidArteries");
	
			System.out.println("Creating the ExternalCarotidArteries for ParentID: " + bioMightTransform.getId());
			externalCarotidArteries = new ExternalCarotidArteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ExternalCarotidArteries", Constants.ExternalCarotidArteries, Constants.ExternalCarotidArteriesRef, externalCarotidArteries.getComponentID());
			System.out.println("Created the ExternalCarotidArteries");
			
			System.out.println("Creating the ExternalJugularVeins for ParentID: " + bioMightTransform.getId());
			externalJugularVeins = new ExternalJugularVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("ExternalJugularVeins", Constants.ExternalJugularVeins, Constants.ExternalJugularVeinsRef, externalJugularVeins.getComponentID());
			System.out.println("Created the ExternalJugularVeins");

			System.out.println("Creating the InternalJugularVeins for ParentID: " + bioMightTransform.getId());
			internalJugularVeins = new InternalJugularVeins(bioMightTransform.getId(), bioMightMethods);
			initProperty("InternalJugularVeins", Constants.InternalJugularVeins, Constants.InternalJugularVeinsRef, internalJugularVeins.getComponentID());
			System.out.println("Created the InternalJugularVeins");

			//System.out.println("Creating the SuperiorThyroidVeins for ParentID: " + bioMightTransform.getId());
			//superiorThyroidVeins = new SuperiorThyroidVeins(bioMightTransform.getId(), bioMightConstruct, bioMightMethods);
			//initProperty("SuperiorThyroidVeins", Constants.SuperiorThyroidVeins, Constants.SuperiorThyroidVeinsRef, superiorThyroidVeins.getComponentID());
			//System.out.println("Created the SuperiorThyroidVeins");

			//System.out.println("Creating the MiddleThyroidVeins for ParentID: " + bioMightTransform.getId());
			//middleThyroidVeins = new MiddleThyroidVeins(bioMightTransform.getId(), bioMightConstruct, bioMightMethods);
			//initProperty("MiddleThyroidVeins", Constants.MiddleThyroidVeins, Constants.MiddleThyroidVeinsRef, middleThyroidVeins.getComponentID());
			//System.out.println("Created the MiddleThyroidVeins");

			//System.out.println("Creating the InferiorThyroidVeins for ParentID: " + bioMightTransform.getId());
			//inferiorThyroidVeins = new InferiorThyroidVeins(bioMightTransform.getId(), bioMightConstruct, bioMightMethods);
			//initProperty("InferiorThyroidVeins", Constants.InferiorThyroidVeins, Constants.InferiorThyroidVeinsRef, inferiorThyroidVeins.getComponentID());
			//System.out.println("Created the InferiorThyroidVeins");

		
			// Store all the connection points for the Neck
			// in the NeckMap.  Then stuff this map into the BioGeneate Object
			// for the neck.  We pass parent and child on the way down,
			// now we pass the child back up to parent
			HashMap neckMap = new HashMap();
			neckMap.put(Constants.EsophagusRef, generatedEsophagus);
			neckMap.put(Constants.TracheaRef, generatedTrachea);
			this.bioMightGenerate.setComponentMap(neckMap);
			
			/*neckMap.put(Constants.ChestRef, bioMightBoundBoxChest);
			neckMap.put(Constants.ShouldersRef, bioMightBoundBoxesShoulder);
			neckMap.put(Constants.ArmRef, bioMightBoundBoxesArm);
			neckMap.put(Constants.ElbowRef, bioMightBoundBoxesElbow);
			neckMap.put(Constants.ForeArmRef, bioMightBoundBoxesForeArm);
			neckMap.put(Constants.WristRef, bioMightBoundBoxesWrist);
			neckMap.put(Constants.HandRef, bioMightBoundBoxesHand);		
			neckMap.put(Constants.FingersRef, "xyzBox");
			neckMap.put(Constants.AbdomenRef, bioMightBoundBoxAbdomen);
			neckMap.put(Constants.HipRef, bioMightBoundBoxHip);
			neckMap.put(Constants.ThighRef, bioMightBoundBoxesThigh);
			neckMap.put(Constants.KneeRef, bioMightBoundBoxesKnee);
			neckMap.put(Constants.CnemisRef, bioMightBoundBoxesCnemes);
			//neckHash.put(Constants.AnkleRef, "xyzBox");
			neckMap.put(Constants.FootRef, bioMightBoundBoxesFeet);
			//bodyHash.put(Constants.ToeRef, "xyzBox");
			*/
			System.out.println("Stored BioGenerateNeck Map Components");
			
			
			// Create the Larynx
			//Larynx larynx = new Larynx(bioMightTransform.getId());;
			
			System.out.println("SpineCervicalRegion completed");			
		}		


		//initProperties();
		initMethods();
	}
	
	/***************************************************************************
	 * GENERATE
	 * 
	 * At the the back of the head, the neck reaches up into the base of the skull
	 * From the front, it starts at the base of your Jaw.  On a the Y axis,
	 * in the Y plane, we see that in the back of the neck it rises to a higher
	 * plane 
	 * 
	 ***************************************************************************/
				
	private BioMightGenerate generate(String parentID, String componentID, BioMightConstruct bioMightConstruct)
	{
			// Generate the Neck Epithelium		
			BioMightBeanLocal bioMightBean;
			BioMightGenerate generatedNeck = null;
			
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Neck ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				// We are creating the Neck
				if (componentID.equals("Neck:01")) 
				{		
					double radius = 2.75;
					double[] startPos = {0.0, -5.0, -3.25};
					double[] scale = {1.0, 1.0, 1.10};
					double[][] currentPoints = BioGraphics.createCylinderInPlaneScaled(Constants.YPLANE, startPos, radius, scale, 8);

					// Store information about the generation into a BioMightGenerate object
					int sucess = bioMightBean.generateNeck("NeckEpithelium:00001", "NeckEpithelium", 
					"NeckEpithelium", componentID, parentID, currentPoints);			
					System.out.println("Generated Neck for ParentID: " + parentID);
				}			
				
				System.out.println("Created NeckEpithelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - NeckEpithelium");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
		return (generatedNeck);	
	}
		
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Adams Apple");
		property.setCanonicalName(Constants.AdamsApple);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Glands");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThyroidGland");
		property.setCanonicalName(Constants.ThyroidGland);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("ParaThyroidGland");
		property.setCanonicalName(Constants.ParaThyroidGland);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarotidArteries");
		property.setCanonicalName(Constants.CarotidArteries);
		properties.add(property);		

		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Anterior Veterbral Muscle");
		property.setCanonicalName(Constants.AnteriorVeterbralMuscle);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("Lateral Cervicle Muscle");
		property.setCanonicalName(Constants.LateralCervicleMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Superficial Cervical Muscle");
		property.setCanonicalName(Constants.SuperficialCervicalMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Supra Infrahyoid Muscle");
		property.setCanonicalName(Constants.SupraInfrahyoidMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Sterno Mastoid Muscle");
		property.setCanonicalName(Constants.SternoMastoidMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Trapezius Muscle");
		property.setCanonicalName(Constants.TrapeziusMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Longus Colli Muscle");
		property.setCanonicalName(Constants.LongusColliMuscle);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("Vascular");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalJugularVein");
		property.setCanonicalName(Constants.ExternalJugularVein);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("InternalJugularVein");
		property.setCanonicalName(Constants.InternalJugularVein);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftInnominateVein");
		property.setCanonicalName(Constants.LeftInnominateVein);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("RightInnominateVein");
		property.setCanonicalName(Constants.RightInnominateVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorThyroidVein");
		property.setCanonicalName(Constants.SuperiorThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleThyroidVein");
		property.setCanonicalName(Constants.MiddleThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorThyroidVein");
		property.setCanonicalName(Constants.InferiorThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorThyroidAtery");
		property.setCanonicalName(Constants.SuperiorThyroidAtery);
		properties.add(property);
	}
	
	
	public void initMethods() {
		methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Turn");
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
		
		// Assemble the Neck
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Neck.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Neck'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			cervicalVertebrae.getX3D(true) + 
			epithelium.getX3D(true)+
			trachea.getX3D(true) + 
			esophagus.getX3D(true) +
			thyroidGland.getX3D(true)+
			commonCarotidArteries.getX3D(true) +
			internalCarotidArteries.getX3D(true) +
			externalCarotidArteries.getX3D(true) +
			//inferiorThyroidVeins.getX3D(true) +
			//middleThyroidVeins.getX3D(true) +
			//superiorThyroidVeins.getX3D(true) +
			internalJugularVeins.getX3D(true) +
			externalJugularVeins.getX3D(true);
		//System.out.println("Neck X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	

	/********************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Neck.  
	 *
	 * @return
	 ********************************************************************/
	private BioMightBoundBox setupDefaultBoundBox() 
	{		
		// Set up the Bounding Box for the Neck
		// For default model, length of neck is 4.5
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(-7.75);
		BigDecimal zPos= new BigDecimal(-3.0);
		
		// Set base cube
		BigDecimal xVector= new BigDecimal(6.0);
		BigDecimal yVector= new BigDecimal(6.0); 
		BigDecimal zVector= new BigDecimal(6.0);
			
		xVector= new BigDecimal(2.5);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.5);
		
		// Create the BoundBox
		BioMightBoundBox bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		
		// Create the Connectors
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = new BioMightConnectors();
		
		// Define some vars
		double circumference = 0.0;
		double[] startPos = {0.0, -5.0, 0.0};
		double[][] startPoints = null;
		
		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		//********************************************
		// ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		double radius = 2.25;
		double[] startPosNE = {0.0, -5.0, -2.5};
		double[] scale = {1.0, 1.0, 1.5};
		double[][] currentPoints = BioGraphics.createCylinderInPlaneScaled(Constants.YPLANE, startPosNE, radius, scale, 8);

		bioMightConnector = new BioMightConnector(currentPoints, "NeckEpithelium", "connType");
		bioMightConnectors.setBioMightConnector("NeckEpithelium", bioMightConnector);
	
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
		// VASCULAR CONNECTORS  
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
		// MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		//SKELETAL CONNECTORS
		//********************************************

		// CervicalVertebrae C5 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		
		return (bioBoundBox);	
	}	
	

	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Neck.   These boxes will define
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
		double[][] startPoints = null;
		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			
			System.out.println("Neck - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Neck
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-5.0);
		zPos= new BigDecimal(-1.0);
		
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		// Neck Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "NeckEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("NeckEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("NeckEpithelium", bioBoundBox);
		
		
		//********************************************************************* 
		// TRACHEA BOUNDBOX
		// Set up the Bounding Box for the Trachea
		// On a porportioned human, the 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-6.0);
		zPos= new BigDecimal(-4.0);
		
		xVector= new BigDecimal(1.0);
		yVector= new BigDecimal(4.0); 
		zVector= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Trachea Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "TracheaEpithelium","connType");
		bioMightConnectors.setBioMightConnector("TracheaEpithelium", bioMightConnector);
		
		// Trachea Muscle Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.00, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "TracheaMuscle","connType");
		bioMightConnectors.setBioMightConnector("TracheaMuscle", bioMightConnector);
		
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("Trachea", bioBoundBox);
		
		
		//********************************************************************* 
		// ESOPHAGUS BOUNDBOX
		// Set up the Bounding Box for the Esophagus
		// On a porportioned human, the Esophagus lie in the middle of the... 
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-6.0);
		zPos= new BigDecimal(-5.5);
		
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(4.5); 
		zVector= new BigDecimal(4.5);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// EsophagusEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "EsophagusEpithelium","connType");
		bioMightConnectors.setBioMightConnector("EsophagusEpithelium", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("Esophagus", bioBoundBox);
		
		
	
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

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	
	
	/************
	BioMightBoundBox tempBox = (BioMightBoundBox) boundingBoxes.get(Constants.TracheaRef);
	if (tempBox == null)
		System.out.println("In Neck - Trachea BoundBox is NULL");	
	
	BioMightConnector tempConn = componentConnectors.getBioMightConnector(Constants.TracheaRef);
	if (tempConn == null)
		System.out.println("In Neck - Trachea Connector is NULL");	
	******/
}
 