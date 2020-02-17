/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg.thigh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.leg.thigh.AdductorBrevisMuscle;
import biomight.system.muscular.leg.thigh.AdductorLongusMuscle;
import biomight.system.muscular.leg.thigh.AdductorMagnusMuscle;
import biomight.system.muscular.leg.thigh.BicepsFemorisMuscle;
import biomight.system.muscular.leg.thigh.GluteusMediusMuscle;
import biomight.system.muscular.leg.thigh.GracilisMuscle;
import biomight.system.muscular.leg.thigh.IliacusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorExternusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorInternusMuscle;
import biomight.system.muscular.leg.thigh.PectineusMuscle;
import biomight.system.muscular.leg.thigh.PopliteusMuscle;
import biomight.system.muscular.leg.thigh.RectusFemorisMuscle;
import biomight.system.muscular.leg.thigh.SartoriusMuscle;
import biomight.system.muscular.leg.thigh.SemiMembranosusMuscle;
import biomight.system.muscular.leg.thigh.SemitendinosusMuscle;
import biomight.system.muscular.leg.thigh.TensorFasciaLataMuscle;
import biomight.system.muscular.leg.thigh.VastusInterMediusMuscle;
import biomight.system.muscular.leg.thigh.VastusLateralisMuscle;
import biomight.system.muscular.leg.thigh.VastusMedialisMuscle;
import biomight.system.skeletal.leg.femur.Femur;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.leg.CommonFemoralArtery;
import biomight.system.vascular.arteries.leg.DeepFemoralArtery;
import biomight.system.vascular.arteries.leg.DescendingGenicularArtery;
import biomight.system.vascular.arteries.leg.LateralCircumflexFemoralArtery;
import biomight.system.vascular.arteries.leg.MedialCircumflexFemoralArtery;
import biomight.system.vascular.arteries.leg.ObturatorArtery;
import biomight.system.vascular.arteries.leg.PoplitealArtery;
import biomight.system.vascular.arteries.leg.SuperficialFemoralArtery;
import biomight.system.vascular.veins.leg.FemoralVein;
import biomight.system.vascular.veins.leg.GreatSaphenousVein;
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

/*********************************************************************
 * @author SurferJim
 *
 * Representation of the Thigh
 * 
 **********************************************************************/
public class Thigh extends BioMightBase {
	protected EpitheliumTissue epithelium;
	
	//Bones
	private Femur femur;
	
	//Muscles
	private AdductorLongusMuscle adductorLongusMuscle;
	private AdductorBrevisMuscle adductorBrevisMuscle;
	private AdductorMagnusMuscle adductorMagnusMuscle;
	private BicepsFemorisMuscle bicepsFemorisMuscle;
	private GracilisMuscle gracilisMuscle;
	private RectusFemorisMuscle rectusFemorisMuscle;
	private SartoriusMuscle sartoriusMuscle;
	private PopliteusMuscle popliteusMuscle;
	private VastusMedialisMuscle vastusMedialisMuscle;
	private VastusInterMediusMuscle vastusInterMediusMuscle;
	private VastusLateralisMuscle vastusLateralisMuscle;
	//private QuadricepsFemorisMuscle quadricepsFemorisMuscle;
	private ObturatorExternusMuscle obturatorExternusMuscle;
	private ObturatorInternusMuscle obturatorInternusMuscle;
	private GluteusMediusMuscle gluteusMediusMuscle;
	private TensorFasciaLataMuscle tensorFasciaLataMuscle;
	private SemitendinosusMuscle semiTendinosusMuscle;
	private PectineusMuscle pectineusMuscle;
	private SemiMembranosusMuscle semiMembranosusMuscle;
	private IliacusMuscle iliacusMuscle;
	private SemitendinosusMuscle semitendinosusMuscle;
	
	
	// Vascular
	private CommonFemoralArtery  commonFemoralArtery;
	private SuperficialFemoralArtery  superficialFemoralArtery;
	private DeepFemoralArtery deepFemoralArtery;
	private FemoralVein femoralVein;
	private LateralCircumflexFemoralArtery lateralCircumflexFemoralArtery;
	private MedialCircumflexFemoralArtery medialCircumflexFemoralArtery;
	private ObturatorArtery  obturatorArtery;
	private DescendingGenicularArtery  descendingGenicularArtery;
	private PoplitealArtery poplitealArtery;
	
	
	// This is als under the cnemis parent
	private GreatSaphenousVein greatSaphenousVein;
	
	public Thigh()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ThighRef, null, null);
	}

	public Thigh(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Thigh(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Thigh Create");
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
		this.setImage("images/Thigh.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		componentID=parentID;

		/*
		// If the constructor is empty,then we just get the information from the database
		// and assemble the model.  If the Constructor has information, then this
		// component is receiving direct change,or getting instructions from its parent
		// to update.
		HashMap boundingBoxes = null;
		
		// Get the Bounding Box and Connectors for the Thigh
		// Either get from the Constructor or set up defaults
		System.out.println("Thigh - Getting BoundBox & Connectors!");
		BioMightBoundBox componentBoundBox = null;
		if (bioMightConstruct == null)
		{
			System.out.println("Thigh - Setting up Default BoundBox");
			componentBoundBox = setupDefaultBoundBox(parentID);		

			System.out.println("Thigh - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(componentBoundBox);
		}
		else 
		{
			System.out.println("Thigh - Using incoming Bounding Box Map");		
			boundingBoxes = bioMightConstruct.getBoundBoxMap();
			if (boundingBoxes==null){
				System.out.println("Thigh - BoundingBoxes are NULL");						
			}
		}
		
	
		// Set up a Constructor that will be used to pass information into the components
		BioMightConstruct bioConstruct = null; 
		*/

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Thigh METHODS: " + bioMightMethods.size());
			}

			// Generate the Thigh Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			/*
			System.out.println("In Thigh - Getting the BoundBox: " + parentID);			
			BioMightBoundBoxes tempBioMightBoundBoxes = bioMightConstruct.getBoundingBoxes(parentID);
			if (tempBioMightBoundBoxes != null)
				System.out.println("In Thigh - Constructor Loaded with: " + parentID + " BoundBox");
			else
				System.out.println("In Thigh - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			// Create and Load Constructor object
			System.out.println("In Thigh - Setting up Epithelium Constructor for: " + parentID);
			bioConstruct = new BioMightConstruct();
			
			BioMightBoundBox tempBoundBox = (BioMightBoundBox) tempBioMightBoundBoxes.getBoundingBox(Constants.ThighEpitheliumRef);
			if (tempBoundBox != null)
				System.out.println("In Thigh - Constructor has Epithelium BoundBox: " + Constants.ThighEpitheliumRef);
			else
				System.out.println("In Thigh - Constructor NOT Loaded with Epithelium BoundBox: " + Constants.ThighEpitheliumRef);
			
			bioConstruct.setBoundingBox(Constants.ThighEpitheliumRef, tempBoundBox);		
			System.out.println("In Thigh - Epithelium Constructor Set");
				
			// Create the 'skin' for the portion of the Thigh we are looking at 
			String startID = "";
			if (parentID.equals(Constants.LeftThighRef)) 
			{
				startID="ThighEpithelium:00001";
			}			
			// We are creating the Esophagus for the Thigh
			else if (parentID.equals(Constants.RightThighRef)) 
			{	
				startID="ThighEpithelium:00480";
			}
			*/
			
					
			System.out.println("Creating Thigh Epithelium: " + parentID);	
			String startID = "ThighEpithelium:00001";
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.ThighEpitheliumRef,  Constants.EpitheliumTissueRef, parentID, bioMightProperties, bioMightMethods);
			initProperty(Constants.ThighEpitheliumRef, "ThighEpithelium", Constants.ThighEpitheliumRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			System.out.println("ThighEpithelium is created");			
				
			System.out.println("Creating the ObturatorArtery for parent: " + parentID);
			obturatorArtery = new ObturatorArtery(parentID, bioMightMethods);
			initProperty("ObturatorArtery", Constants.ObturatorArtery, Constants.ObturatorArteryRef, obturatorArtery.getComponentID());
			System.out.println("Created the ObturatorArtery");
	
			System.out.println("Creating the FemoralVein for parent: " + parentID);
			femoralVein = new FemoralVein(parentID, bioMightMethods);
			initProperty("FemoralVein", Constants.FemoralVein, Constants.FemoralVeinRef, femoralVein.getComponentID());
			System.out.println("Created the FemoralVein");
		
			System.out.println("Creating the DeepFemoralArtery for parent: " + parentID);
			deepFemoralArtery = new DeepFemoralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DeepFemoralArtery", Constants.DeepFemoralArtery, Constants.DeepFemoralArteryRef, deepFemoralArtery.getComponentID());
			System.out.println("Created the DeepFemoralArtery");
		
			System.out.println("Creating the CommonFemoralArtery for parent: " + parentID);
			commonFemoralArtery = new CommonFemoralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CommonFemoralArtery", Constants.CommonFemoralArtery, Constants.CommonFemoralArteryRef, commonFemoralArtery.getComponentID());
			System.out.println("Created the CommonFemoralArtery");
	
			System.out.println("Creating the SuperficialFemoralArtery for parent: " + parentID);
			superficialFemoralArtery = new SuperficialFemoralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SuperficialFemoralArtery", Constants.SuperficialFemoralArtery, Constants.SuperficialFemoralArteryRef, superficialFemoralArtery.getComponentID());
			System.out.println("Created the SuperficialFemoralArtery");
	
			System.out.println("Creating the GreatSaphenousVein for parent: " + parentID);
			greatSaphenousVein = new GreatSaphenousVein(parentID, bioMightMethods);
			initProperty("GreatSaphenousVein", Constants.GreatSaphenousVein, Constants.GreatSaphenousVeinRef, greatSaphenousVein.getComponentID());
			System.out.println("Created the GreatSaphenousVein");
			
			System.out.println("Creating the LateralCircumflexFemoralArtery for parent: " + parentID);
			lateralCircumflexFemoralArtery = new LateralCircumflexFemoralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("LateralCircumflexFemoralArtery", Constants.LateralCircumflexFemoralArtery, Constants.LateralCircumflexFemoralArtery, lateralCircumflexFemoralArtery.getComponentID());
			System.out.println("Created the LateralCircumflexFemoralArtery");
	
			System.out.println("Creating the MedialCircumflexFemoralArtery for parent: " + parentID);
			medialCircumflexFemoralArtery = new MedialCircumflexFemoralArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CommonFemoralArtery", Constants.MedialCircumflexFemoralArtery, Constants.MedialCircumflexFemoralArteryRef, medialCircumflexFemoralArtery.getComponentID());
			System.out.println("Created the MedialCircumflexFemoralArtery");
	
			System.out.println("Creating the DescendingGenicularArtery for parent: " + parentID);
			descendingGenicularArtery = new DescendingGenicularArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("DescendingGenicularArtery", Constants.DescendingGenicularArtery, Constants.DescendingGenicularArteryRef, descendingGenicularArtery.getComponentID());
			System.out.println("Created the DescendingGenicularArtery");
			
			System.out.println("Creating the PoplitealArtery for parent: " + parentID);
			poplitealArtery = new PoplitealArtery(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("PoplitealArtery", Constants.PoplitealArtery, Constants.PoplitealArteryRef, poplitealArtery.getComponentID());
			System.out.println("Created the PoplitealAtery");
	
			
			System.out.println("Creating the Femur for parent: " + parentID);
			femur = new Femur(parentID, bioMightMethods);  
			initProperty("Femur", Constants.Femur, Constants.FemurRef, epithelium.getComponentID());
			System.out.println("Created the Femur");
			
			System.out.println("Creating the AdductorLongusMuscle for parent: " + parentID);
			adductorLongusMuscle = new AdductorLongusMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AdductorLongusMuscle", Constants.AdductorLongusMuscle, Constants.AdductorLongusMuscleRef, adductorLongusMuscle.getComponentID());
			System.out.println("Created the AdductorLongusMuscle");

			System.out.println("Creating the AdductorBrevisMuscle for parent: " + parentID);
			adductorBrevisMuscle = new AdductorBrevisMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("AdductorBrevisMuscle", Constants.AdductorBrevisMuscle, Constants.AdductorBrevisMuscleRef, adductorBrevisMuscle.getComponentID());
			System.out.println("Created the AdductorBrevisMuscle");

			//System.out.println("Creating the AdductorMagnusMuscle for parent: " + parentID);
			//adductorMagnusMuscle = new AdductorMagnusMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			//initProperty("AdductorMagnusMuscle", Constants.AdductorMagnusMuscle, Constants.AdductorMagnusMuscleRef, adductorMagnusMuscle.getComponentID());
			//System.out.println("Created the AdductorMagnusMuscle");
			
			System.out.println("Creating the BicepsFemorisMuscle for parent: " + parentID);
			bicepsFemorisMuscle = new BicepsFemorisMuscle(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("BicepsFemorisMuscle", Constants.BicepsFemorisMuscle, Constants.BicepsFemorisMuscleRef, bicepsFemorisMuscle.getComponentID());
			System.out.println("Created the BicepsFemorisMuscle");
	
			System.out.println("Creating the GracilisMuscle for parent: " + parentID);
			gracilisMuscle = new GracilisMuscle(parentID, bioMightMethods);
			initProperty("GracilisMuscle", Constants.GracilisMuscle, Constants.GracilisMuscleRef, gracilisMuscle.getComponentID());
			System.out.println("Created the GracilisMuscle");

			System.out.println("Creating the RectusFemorisMuscle for parent: " + parentID);
			rectusFemorisMuscle = new RectusFemorisMuscle(parentID, bioMightMethods);
			initProperty("RectusFemorisMuscle", Constants.RectusFemorisMuscle, Constants.RectusFemorisMuscleRef, rectusFemorisMuscle.getComponentID());
			System.out.println("Created the RectusFemorisMuscle");

			System.out.println("Creating the SartoriusMuscle for parent: " + parentID);
			sartoriusMuscle = new SartoriusMuscle(parentID, bioMightMethods);
			initProperty("SartoriusMuscle", Constants.SartoriusMuscle, Constants.SartoriusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SartoriusMuscle");

			System.out.println("Creating the PopliteusMuscle for parent: " + parentID);
			popliteusMuscle = new PopliteusMuscle(parentID, bioMightMethods);
			initProperty("PopliteusMuscle", Constants.PopliteusMuscle, Constants.PopliteusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the PopliteusMuscle");
			
			System.out.println("Creating the VastusMedialisMuscle for parent: " + parentID);
			vastusMedialisMuscle = new VastusMedialisMuscle(parentID, bioMightMethods);
			initProperty("VastusMedialisMuscle", Constants.VastusMedialisMuscle, Constants.VastusMedialisMuscleRef, epithelium.getComponentID());
			System.out.println("Created the VastusMedialisMuscle");
			
			System.out.println("Creating the VastusInterMediusMuscle for parent: " + parentID);
			vastusInterMediusMuscle = new VastusInterMediusMuscle(parentID, bioMightMethods);
			initProperty("VastusInterMediusMuscle", Constants.VastusInterMediusMuscle, Constants.VastusInterMediusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the VastusInterMediusMuscle");
		
			System.out.println("Creating the ObturatorExternusMuscle for parent: " + parentID);
			obturatorExternusMuscle = new ObturatorExternusMuscle(parentID, bioMightMethods);
			initProperty("ObturatorExternusMuscle", Constants.ObturatorExternusMuscle, Constants.ObturatorExternusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the ObturatorExternusMuscle");

			System.out.println("Creating the ObturatorInternusMuscle for parent: " + parentID);
			obturatorInternusMuscle = new ObturatorInternusMuscle(parentID, bioMightMethods);
			initProperty("ObturatorInternusMuscle", Constants.ObturatorInternusMuscle, Constants.ObturatorInternusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the ObturatorInternusMuscle");
			
			System.out.println("Creating the GluteusMediusMuscle for parent: " + parentID);
			gluteusMediusMuscle = new GluteusMediusMuscle(parentID, bioMightMethods);
			initProperty("GluteusMediusMuscle", Constants.GluteusMediusMuscle, Constants.GluteusMediusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the GluteusMediusMuscle");
	
			System.out.println("Creating the h for parent: " + parentID);
			tensorFasciaLataMuscle = new TensorFasciaLataMuscle(parentID, bioMightMethods);
			initProperty("TensorFasciaLataMuscle", Constants.TensorFasciaLataMuscle, Constants.TensorFasciaLataMuscleRef, epithelium.getComponentID());
			System.out.println("Created the TensorFasciaLataMuscle");
		
			System.out.println("Creating the SemitendinosusMuscle for parent: " + parentID);
			semitendinosusMuscle = new SemitendinosusMuscle(parentID, bioMightMethods);
			initProperty("SemitendinosusMuscle", Constants.SemitendinosusMuscle, Constants.SemitendinosusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SemitendinosusMuscle");
			
			System.out.println("Creating the PectineusMuscle for parent: " + parentID);
			pectineusMuscle = new PectineusMuscle(parentID, bioMightMethods);
			initProperty("PectineusMuscle", Constants.PectineusMuscle, Constants.PectineusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the PectineusMuscle");
		
			System.out.println("Creating the SemiMembranosusMuscle for parent: " + parentID);
			semiMembranosusMuscle = new SemiMembranosusMuscle(parentID, bioMightMethods);
			initProperty("SemiMembranosusMuscle", Constants.SemiMembranosusMuscle, Constants.SemiMembranosusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the SemiMembranosusMuscle");
		
			System.out.println("Creating the IliacusMuscle for parent: " + parentID);
			iliacusMuscle = new IliacusMuscle(parentID, bioMightMethods);
			initProperty("IliacusMuscle", Constants.IliacusMuscle, Constants.IliacusMuscleRef, epithelium.getComponentID());
			System.out.println("Created the IliacusMuscle");
		
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}
	
	
	/****************************************************
	 * GENERATE
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Wrist E		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Thigh Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 3.5;
			
			if (parentID.equals("Thigh:01")) {
				
				// Generate the thigh epithelium
				double[] startPos = {4.00, -32.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateThigh("ThighEpithelium:00001", "ThighEpithelium", 
						"ThighEpitheliumLeft", componentID, parentID, currentPoints);				
			}
			else if (parentID.equals("Thigh:02")) {
				
				// Generate the thigh epithelium
				double[] startPos = {-4.00, -32.0, -4.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateThigh("ThighEpithelium:00320", "ThighEpithelium", 
						"ThighEpitheliumLeft", componentID, parentID, currentPoints);	
			}		
			else  
			{	
				System.out.println("Calling Generate WristEpithelium NoParent");		
			}

			
			System.out.println("Created WristEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - WristEpithelium");
			throw new ServerException("Remote Exception WristEpithelium():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Femur");
		property.setCanonicalName(Constants.Femur);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Gyrate");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
		
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Thigh.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Thigh
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thigh.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thigh'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true) +
			obturatorArtery.getX3D(true) +
			//femoralVein.getX3D(true) +
			commonFemoralArtery.getX3D(true) +
			descendingGenicularArtery.getX3D(true) +
			superficialFemoralArtery.getX3D(true) +
			deepFemoralArtery.getX3D(true) +
			lateralCircumflexFemoralArtery.getX3D(true) +
			medialCircumflexFemoralArtery.getX3D(true) +
			poplitealArtery.getX3D(true) +
			greatSaphenousVein.getX3D(true) +
			bicepsFemorisMuscle.getX3D(true) +
			adductorLongusMuscle.getX3D(true) +
			adductorBrevisMuscle.getX3D(true) +
			//adductorMagnusMuscle.getX3D(true) +
			rectusFemorisMuscle.getX3D(true) +
			sartoriusMuscle.getX3D(true) +
			popliteusMuscle.getX3D(true) +
			vastusMedialisMuscle.getX3D(true) +
			//vastusInterMediusMuscle.getX3D(true) +
			//vastusLateralisMuscle.getX3D(true) +
			obturatorExternusMuscle.getX3D(true) +
			obturatorInternusMuscle.getX3D(true) +
			gluteusMediusMuscle.getX3D(true) +			
			gracilisMuscle.getX3D(true) +
			tensorFasciaLataMuscle.getX3D(true) +
			pectineusMuscle.getX3D(true) +
			semiMembranosusMuscle.getX3D(true) +
			femur.getX3D(true);
		
		  
		//System.out.println("Thigh X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	

	public ArrayList getProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AdductorLongusMuscle");
		property.setCanonicalName(Constants.AdductorLongusMuscle);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Fibula");
		property.setCanonicalName(Constants.Fibula);
		properties.add(property);				
	
		return properties;
	}
	
	
	public ArrayList getMethods() {

		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Girth");
		method.setHtmlType("text");
		methods.add(method);	
			
		return methods;
	
	}		
	
	

	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CONTACT"))
		{
			// Send a message to the brain
			
			// Start Digestion
			 
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("CONTRACT"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("EXTEND"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}

	}
	
	

	
	/***************************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Thigh.  
	 * This routine will be called when looking at an individual Thigh with
	 * default values
	 * 
	 * @return
	 ****************************************************************************/
	private BioMightBoundBox setupDefaultBoundBox(String parentID) 
	{
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
		
		
		//**********************************************************************
		// THIGHS BOUND BOX		
		//
		// Set up the Bounding Box for the Thigh
		// For default model, length of chest is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);
		
		// Setuo the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// THIGH - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
	

		//********************************************	
		// THIGH - VASCULAR CONNECTORS  
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
		// THIGH - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// THIGH - SKELETAL CONNECTORS
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
	 * Setup the Bounding Boxes for the Thigh.   These boxes will define
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
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);

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
		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			System.out.println("Thigh - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
	
		//********************************************************************* 
		// THIGHS BOUND BOXES
		// Set up the Bounding Box for the Thigh
		// On a porportioned human, the Thigh are located in the --- 
		//**********************************************************************
		
		//********************************************************************* 
		// LEFT THIGHS BOUNDBOX
		// Set up the Bounding Box for the Left Thigh
		// On a porportioned human, the Thigh are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBoxes = new BioMightBoundBoxes();
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ThighEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftThighRef, bioBoundBox);	

		//********************************************************************* 
		// RIGHT THIGHS BOUNDBOX
		// Set up the Bounding Box for the Thigh
		// On a porportioned human, the Thigh are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-1.0);
		yPos = new BigDecimal(-11.0);
		zPos= new BigDecimal(-3.5);
		
		xVector= new BigDecimal(2.0);
		yVector= new BigDecimal(2.0); 
		zVector= new BigDecimal(2.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// ThighEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightThighRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Thigh 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ThighsRef, bioBoundBoxes);		
		
		
		return (boundingBoxMap);
	}	

	
	
	public CommonFemoralArtery getCommonFemoralArtery() {
		return commonFemoralArtery;
	}


	public void setCommonFemoralArtery(CommonFemoralArtery commonFemoralArtery) {
		this.commonFemoralArtery = commonFemoralArtery;
	}


	public DeepFemoralArtery getDeepFemoralArtery() {
		return deepFemoralArtery;
	}


	public void setDeepFemoralArtery(DeepFemoralArtery deepFemoralArtery) {
		this.deepFemoralArtery = deepFemoralArtery;
	}


	public FemoralVein getFemoralVein() {
		return femoralVein;
	}


	public void setFemoralVein(FemoralVein femoralVein) {
		this.femoralVein = femoralVein;
	}


}
