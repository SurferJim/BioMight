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
import biomight.body.spine.Spine;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.arm.Humeri;
import biomight.system.skeletal.arm.Radii;
import biomight.system.skeletal.arm.Ulna;
import biomight.system.skeletal.arm.Ulnae;
import biomight.system.skeletal.chest.Clavicle;
import biomight.system.skeletal.chest.Scapula;
import biomight.system.skeletal.chest.Sternum;
import biomight.system.skeletal.foot.CalcaneusBone;
import biomight.system.skeletal.foot.CuboidBone;
import biomight.system.skeletal.foot.DistalPhalanages;
import biomight.system.skeletal.foot.IntermediatePhalanages;
import biomight.system.skeletal.foot.LateralCuneiformBone;
import biomight.system.skeletal.foot.MetaTarsalsBone;
import biomight.system.skeletal.foot.NavicularCuneiforms;
import biomight.system.skeletal.foot.ProximalPhalanges;
import biomight.system.skeletal.foot.TalusBone;
import biomight.system.skeletal.foot.Tarsals;
import biomight.system.skeletal.hand.CapitateBone;
import biomight.system.skeletal.hand.Carpals;
import biomight.system.skeletal.hand.DipJoint;
import biomight.system.skeletal.hand.DistalPhalanx;
import biomight.system.skeletal.hand.HamateCapitateBone;
import biomight.system.skeletal.hand.LunateBone;
import biomight.system.skeletal.hand.MetaCarpals;
import biomight.system.skeletal.hand.MiddlePhalanx;
import biomight.system.skeletal.hand.PipJoint;
import biomight.system.skeletal.hand.PisiformTriquetrumBone;
import biomight.system.skeletal.hand.ProximalPhalanx;
import biomight.system.skeletal.hand.RadialStyloidProcess;
import biomight.system.skeletal.hand.ScaphoidBone;
import biomight.system.skeletal.hand.TrapeziumBone;
import biomight.system.skeletal.hand.TriquetralBone;
import biomight.system.skeletal.hand.UlnarStyloidProcess;
import biomight.system.skeletal.leg.Fibulas;
import biomight.system.skeletal.leg.Patellas;
import biomight.system.skeletal.leg.femur.Femurs;
import biomight.system.skeletal.leg.tibia.Tibias;
import biomight.system.skeletal.pelvis.IliumOld;
import biomight.system.skeletal.pelvis.Ischium;
import biomight.system.skeletal.pelvis.Pelvis;
import biomight.system.skeletal.pelvis.Pubis;
import biomight.system.skeletal.pelvis.SacrumBone;
import biomight.system.skeletal.ribs.RibCage;
import biomight.system.skeletal.ribs.Ribs;
import biomight.system.skeletal.skull.Skull;
import biomight.system.skeletal.spine.CervicalVertebrae;
import biomight.system.skeletal.spine.LumbarVertebrae;
import biomight.system.skeletal.spine.SacralVertebrae;
import biomight.system.skeletal.spine.Sacrum;
import biomight.system.skeletal.spine.ThoracicVertebrae;
import biomight.system.skeletal.wrist.WristDistalRow;
import biomight.system.skeletal.wrist.WristProximalRow;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Skeletal System
 * 
 *****************************************************************************/

public class SkeletalSystem extends BioMightBase{	
	// Head
	private Skull skull;	

	// Neck and Back
	private Spine spine;
	private CervicalVertebrae cervicalVertebrae;
	private ThoracicVertebrae thoracicVertebrae;
	private LumbarVertebrae lumbarVertebrae;
	private SacralVertebrae sacralVertebrae;
	private Sacrum sacrum;
	
	// Chest
	private Clavicle clavicle;
	private Scapula scapula;
	private Sternum sternum;
	private Ribs ribs;
	
	// Arm
	private Humeri humeri;
	private Radii radii;
	private Ulnae ulnae;
	
	// Wrist and Hand
	private WristDistalRow wristDistalRow;
	private WristProximalRow wristProximalRow;
	private CapitateBone capitateBone;
	private Carpals carpals;
	private DipJoint dipJoint;
	private DistalPhalanx distalPhalanx;
	private HamateCapitateBone hamateCapitateBone;
	private LunateBone lunateBone;
	private MetaCarpals metaCarpals;
	private MiddlePhalanx middlePhalanx;
	
	
	//private Phalanges phalanges;
	private PipJoint pipJoint;
	private PisiformTriquetrumBone pisiformTriquetrumBone;
	private ProximalPhalanx ProximalPhalanx;
	private RadialStyloidProcess radialStyloidProcess;
	private ScaphoidBone scaphoidBone;
	private TrapeziumBone trapeziumBone;
	private TriquetralBone triquetralBone;
	private UlnarStyloidProcess ulnarStyloidProcess;
	
	// Pelvis
	private IliumOld iliumBone;
	private Ischium ischium;
	private Pelvis pelvis;
	private Pubis pubis;
	private SacrumBone sacrumBone;
	
	// Leg
	private Femurs femurs;
	private Fibulas fibulas;
	private Tibias tibias;
	private Patellas patellas;

	// Foot
	private CalcaneusBone calcaneusBone;
	private CuboidBone cuboidBone;
	private DistalPhalanages distalPhalanages;
	private IntermediatePhalanages intermediatePhalanages;
	private LateralCuneiformBone lateralCuneiformBone;
	private MetaTarsalsBone metaTarsalsBone;
	private NavicularCuneiforms navicularCuneiforms;
	private ProximalPhalanges ProximalPhalanges;
	private TalusBone TalusBone;
	private Tarsals tarsals;
	
	
	
	/************************************************************************
	 * SKELETAL SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public SkeletalSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SkeletalSystem, null, null);
	}

	public SkeletalSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public SkeletalSystem(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE SKELETAL SYSTEM
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SkeletalSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting SkeletalSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SkeletalSystemRef, parentID);
			//System.out.println("Have SkeletalSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SkeletalSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		localVP = Constants.VIEW_HAWKEYE;
		localLOD = Constants.MAG1X;
		boolean bStored = false;	
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="SkeletalSystem.x3d";

		// Run through the collection of SkeletalSystems and build them into the model
		// In the default case, we get one instance of the SkeletalSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("SkeletalSystem NumTransforms: " + transforms.size());
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the SkeletalSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			componentID = bioMightTransform.getId();
			System.out.println("Creating SkeletalSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
		
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null || bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for SkeletalSystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(componentID);
					System.out.println("Have SkeletalSystem Property Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - SkeletalSystem");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("SkeletalSystem: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				System.out.println("SkeletalSystem - Using LocalProperties...");
			}
			System.out.println("In SkeletalSystem - PropertiesSize: " + bioMightProperties.size());
			
							
			// Use the properties to determine what components are to be built, construct a new set of properties
			// ARM BONES
			if (BioWebUtils.isViewEnabled(Constants.HumeriRef, bioMightProperties)) {		
				//System.out.println("Creating the Humeri for parent: " + bioMightTransform.getId());
				humeri = new Humeri(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.HumeriRef, Constants.Humeri, Constants.HumeriRef, humeri.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Humeri");
			}
			else
				initProperty(Constants.HumeriRef, Constants.Humeri, Constants.HumeriRef, BioWebUtils.getPropertyID(Constants.HumeriRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.RadiiRef, bioMightProperties)) {		
				//System.out.println("Creating the Radii for parent: " + bioMightTransform.getId());
				radii = new Radii(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.RadiiRef, Constants.Radii, Constants.RadiiRef, radii.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Humeri");
			}
			else
				initProperty(Constants.RadiiRef, Constants.Radii, Constants.RadiiRef, BioWebUtils.getPropertyID(Constants.RadiiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
	
			if (BioWebUtils.isViewEnabled(Constants.UlnaeRef, bioMightProperties)) {		
				//System.out.println("Creating the Ulnae for parent: " + bioMightTransform.getId());
				ulnae = new Ulnae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.UlnaeRef, Constants.Ulnae, Constants.UlnaeRef, ulnae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Ulnae");
			}
			else
				initProperty(Constants.UlnaeRef, Constants.Ulnae, Constants.UlnaeRef, BioWebUtils.getPropertyID(Constants.UlnaeRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			// HAND BONES
			if (BioWebUtils.isViewEnabled(Constants.MetaCarpalsRef, bioMightProperties)) {		
				//System.out.println("Creating the MetaCarpals for parent: " + bioMightTransform.getId());
				metaCarpals = new MetaCarpals(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.MetaCarpalsRef, Constants.MetaCarpals, Constants.MetaCarpalsRef, metaCarpals.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the MetaCarpals");
			}
			else
				initProperty(Constants.MetaCarpalsRef, Constants.MetaCarpals, Constants.MetaCarpalsRef, BioWebUtils.getPropertyID(Constants.MetaCarpalsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			// LEG BONES
			if (BioWebUtils.isViewEnabled(Constants.FemursRef, bioMightProperties)) {		
				//System.out.println("Creating the Femurs for parent: " + bioMightTransform.getId());
				femurs = new Femurs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.FemursRef, Constants.Femurs, Constants.FemursRef, femurs.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Femurs");
			}
			else
				initProperty(Constants.FemursRef, Constants.Femurs, Constants.FemursRef, BioWebUtils.getPropertyID(Constants.FemursRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.FibulasRef, bioMightProperties)) {	
				//System.out.println("Creating the Fibulas for parent: " + bioMightTransform.getId());
				fibulas = new Fibulas(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.FibulasRef, Constants.Fibulas, Constants.FibulasRef, fibulas.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Fibulas");
			}
			else
				initProperty(Constants.FibulasRef, Constants.Fibulas, Constants.FibulasRef, BioWebUtils.getPropertyID(Constants.FibulasRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.TibiasRef, bioMightProperties)) {	
				//System.out.println("Creating the Tibias for parent: " + bioMightTransform.getId());
				tibias = new Tibias(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.TibiasRef, Constants.Tibias, Constants.TibiasRef, tibias.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Tibias");
			}
			else
				initProperty(Constants.TibiasRef, Constants.Tibias, Constants.TibiasRef, BioWebUtils.getPropertyID(Constants.TibiasRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
				
			// VERTEBRAE	
			if (BioWebUtils.isViewEnabled(Constants.CervicalVertebraeRef, bioMightProperties)) {	
				//System.out.println("Creating the CervicalVertebrae for parent: " + bioMightTransform.getId());
				cervicalVertebrae = new CervicalVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.CervicalVertebraeRef, Constants.CervicalVertebrae, Constants.CervicalVertebraeRef, cervicalVertebrae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the CervicalVertebrae");
			}
			else
				initProperty(Constants.CervicalVertebraeRef, Constants.CervicalVertebrae, Constants.CervicalVertebraeRef, BioWebUtils.getPropertyID(Constants.CervicalVertebraeRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.ThoracicVertebraeRef, bioMightProperties)) {	
				//System.out.println("Creating the ThoracicVertebrae for parent: " + bioMightTransform.getId());
				thoracicVertebrae = new ThoracicVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.ThoracicVertebraeRef, Constants.ThoracicVertebrae, Constants.ThoracicVertebraeRef, thoracicVertebrae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the ThoracicVertebrae");
			}
			else
				initProperty(Constants.ThoracicVertebraeRef, Constants.ThoracicVertebrae, Constants.ThoracicVertebraeRef, BioWebUtils.getPropertyID(Constants.ThoracicVertebraeRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
				
			if (BioWebUtils.isViewEnabled(Constants.LumbarVertebraeRef, bioMightProperties)) {	
				//System.out.println("Creating the LumbarVertebrae for parent: " + bioMightTransform.getId());
				lumbarVertebrae = new LumbarVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.LumbarVertebraeRef, Constants.LumbarVertebrae, Constants.LumbarVertebraeRef, lumbarVertebrae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the LumbarVertebrae");
			}
			else
				initProperty(Constants.LumbarVertebraeRef, Constants.LumbarVertebrae, Constants.LumbarVertebraeRef, BioWebUtils.getPropertyID(Constants.LumbarVertebraeRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.SacralVertebraeRef, bioMightProperties)) {	
				//System.out.println("Creating the SacralVertebrae for parent: " + bioMightTransform.getId());
				sacralVertebrae = new SacralVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SacralVertebraeRef, Constants.SacralVertebrae, Constants.SacralVertebraeRef, sacralVertebrae.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the SacralVertebrae");
				}
			else
				initProperty(Constants.SacralVertebraeRef, Constants.SacralVertebrae, Constants.SacralVertebraeRef, BioWebUtils.getPropertyID(Constants.SacralVertebraeRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			//System.out.println("Creating the Ribs for parent: " + bioMightTransform.getId());
			//if (BioWebUtils.isViewEnabled(Constants.RibsRef, bioMightProperties)) {	
			//	System.out.println("Creating the Ribs for parent: " + bioMightTransform.getId());
			//	ribs = new Ribs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//	initProperty(Constants.RibsRef, Constants.Ribs, Constants.RibsRef, ribs.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
			//	System.out.println("Created the Ribs: " + ribs.getComponentID());
			//}
			//else
			//	initProperty(Constants.RibsRef, Constants.Ribs, Constants.RibsRef, BioWebUtils.getPropertyID(Constants.RibsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			if (BioWebUtils.isViewEnabled(Constants.SternumRef, bioMightProperties)) {	
				//System.out.println("Creating the Sternum for parent: " + bioMightTransform.getId());
				sternum = new Sternum(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SternumRef, Constants.Sternum, Constants.SternumRef, sternum.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Sternum: " + sternum.getComponentID());
			}
			else
				initProperty(Constants.SternumRef, Constants.Sternum, Constants.SternumRef, BioWebUtils.getPropertyID(Constants.SternumRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
						
			if (BioWebUtils.isViewEnabled(Constants.PelvisRef, bioMightProperties)) {	
				//System.out.println("Creating the Pelvis for parent: " + bioMightTransform.getId());
				pelvis = new Pelvis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("Pelvis", Constants.Pelvis, Constants.PelvisRef, pelvis.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);		
				System.out.println("Created the Pelvis");	
			}
			else
				initProperty("Pelvis", Constants.Pelvis, Constants.PelvisRef, BioWebUtils.getPropertyID(Constants.PelvisRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);		
			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						System.out.println("Setting Property info for SkeletalSystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.SkeletalSystemRef, bioMightTransform.getComponentName(), properties);      
						System.out.println("Stored SkeletalSystem Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - SkeletalSystem");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}
	
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create SkeletalSystem Completed");
	}


			
	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Skull");
		property.setCanonicalName(Constants.Skull);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Spine");
		//property.setCanonicalName(Constants.Spine);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Clavicle");
		property.setCanonicalName(Constants.Clavicle);
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
		
		property = new BioMightPropertyView();
		property.setPropertyName("Arm");
		property.setCanonicalName(Constants.Arm);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Humerus");
		property.setCanonicalName(Constants.Humerus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Radius");
		property.setCanonicalName(Constants.Radius);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ulna");
		property.setCanonicalName(Constants.Ulna);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Wrist");
		property.setCanonicalName(Constants.Wrist);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("WristDistalRow");
		property.setCanonicalName(Constants.WristDistalRow);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("WristProximalRow");
		property.setCanonicalName(Constants.WristProximalRow);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Hand");
		property.setCanonicalName(Constants.Hand);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CapitateBone");
		property.setCanonicalName(Constants.CapitateBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Carpals");
		property.setCanonicalName(Constants.Carpals);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DipJoint");
		property.setCanonicalName(Constants.DipJoint);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DistalPhalanx");
		property.setCanonicalName(Constants.DistalPhalanx);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("HamateCapitateBone");
		property.setCanonicalName(Constants.HamateCapitateBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LunateBone");
		property.setCanonicalName(Constants.LunateBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MetaCarpals");
		property.setCanonicalName(Constants.MetaCarpals);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("MiddlePhalanx");
		property.setCanonicalName(Constants.MiddlePhalanx);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PipJoint");
		property.setCanonicalName(Constants.PipJoint);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PisiformTriquetrumBone");
		property.setCanonicalName(Constants.PisiformTriquetrumBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ProximalPhalanx");
		property.setCanonicalName(Constants.ProximalPhalanx);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RadialStyloidProcess");
		property.setCanonicalName(Constants.RadialStyloidProcess);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ScaphoidBone");
		property.setCanonicalName(Constants.ScaphoidBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TrapeziumBone");
		property.setCanonicalName(Constants.TrapeziumBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TriquetralBone");
		property.setCanonicalName(Constants.TriquetralBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("UlnarStyloidProcess");
		property.setCanonicalName(Constants.UlnarStyloidProcess);
		properties.add(property);
		
		// Pelvis
		property = new BioMightPropertyView();
		property.setPropertyName("Pelvis");
		property.setCanonicalName(Constants.Pelvis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ilium");
		property.setCanonicalName(Constants.Ilium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ischium");
		property.setCanonicalName(Constants.Ischium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pelvis");
		property.setCanonicalName(Constants.Pelvis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pubis");
		property.setCanonicalName(Constants.Pubis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SacrumBone");
		property.setCanonicalName(Constants.SacrumBone);
		properties.add(property);
		
		//	Leg
		property = new BioMightPropertyView();
		property.setPropertyName("Leg");
		property.setCanonicalName(Constants.Leg);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Fibula");
		property.setCanonicalName(Constants.Fibula);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Patella");
		//property.setCanonicalName(Constants.Patella);
		properties.add(property);
		
		// Foot
		property = new BioMightPropertyView();
		property.setPropertyName("Foot");
		property.setCanonicalName(Constants.Foot);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CalcaneusBone");
		property.setCanonicalName(Constants.CalcaneusBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CuboidBone");
		property.setCanonicalName(Constants.CuboidBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DistalPhalanages");
		property.setCanonicalName(Constants.HandDistalPhalanges);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("MiddlePhalanages");
		property.setCanonicalName(Constants.HandMiddlePhalanges);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LateralCuneiformBone");
		property.setCanonicalName(Constants.LateralCuneiformBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MetaTarsalsBone");
		property.setCanonicalName(Constants.MetaTarsalsBone);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("NavicularCuneiforms");
		property.setCanonicalName(Constants.NavicularCuneiforms);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HandProximalPhalanges");
		property.setCanonicalName(Constants.HandProximalPhalanges);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("TalusBone");
		property.setCanonicalName(Constants.TalusBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tarsals");
		property.setCanonicalName(Constants.Tarsals);
		properties.add(property);
	
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();		
		method = new BioMightMethodView();
		method.setMethodName("Bone Mass");
		method.setHtmlType("text");
		methods.add(method);

	}
	
	
	
	/*******************************************************************
	 * GENERATE the SkeletalSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingSkeletalSystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Generating the SkeletalSystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingSkeletalSystemEndothelium of the stomach
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
	
				//System.out.println("Calling Generate SkeletalSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateSkeletalSystem("SkeletalSystemEndothelium:00001", "SkeletalSystemEndothelium", 
				//	"SkeletalSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("SkeletalSystemEndothelium:00001", "SkeletalSystemEndothelium", 
				//		"SkeletalSystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingSkeletalSystemEndothelium of the stomach
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
	
				//System.out.println("Calling Generate SkeletalSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateSkeletalSystem("SkeletalSystemEndothelium:00080", "SkeletalSystemEndothelium", 
				//	"SkeletalSystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				//System.out.println("Calling Generate SkeletalSystemEndothelium NoParent");
							
			}
			
			System.out.println("Created SkeletalSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SkeletalSystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
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
		"title='SkeletalSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		//System.out.println("Getting SkeletalSystem X3D!");	
		String body = "";
			
				 
			if (BioWebUtils.isViewEnabled(Constants.HumeriRef, properties)) {
				body +=  humeri.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.UlnaeRef, properties)) {
				body +=  ulnae.getX3D(true);
			}	
			if (BioWebUtils.isViewEnabled(Constants.RadiiRef, properties)) {
				body +=  radii.getX3D(true);
			}		
			if (BioWebUtils.isViewEnabled(Constants.CervicalVertebraeRef, properties)) {
				body +=  cervicalVertebrae.getX3D(true);
			}			
			if (BioWebUtils.isViewEnabled(Constants.ThoracicVertebraeRef, properties)) {
				body +=  thoracicVertebrae.getX3D(true);
			}			
			if (BioWebUtils.isViewEnabled(Constants.LumbarVertebraeRef, properties)) {
				body +=  lumbarVertebrae.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.SacralVertebraeRef, properties)) {
				body +=  sacralVertebrae.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.RibsRef, properties)) {
				//body +=  ribs.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.SternumRef, properties)) {
				body +=  sternum.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.PelvisRef, properties)) {
				body +=  pelvis.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.FemursRef, properties)) {
				body +=  femurs.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.FibulasRef, properties)) {
				body +=  fibulas.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.TibiasRef, properties)) {
				body +=  tibias.getX3D(true);
			}
			if (BioWebUtils.isViewEnabled(Constants.MetaCarpalsRef, properties)) {
				body +=  metaCarpals.getX3D(true);
			}		
			
			
		//System.out.println("SkeletalSystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		
	
	public void setBoneDensity()
	{
	}


	public CalcaneusBone getCalcaneusBone() {
		return calcaneusBone;
	}


	public void setCalcaneusBone(CalcaneusBone calcaneusBone) {
		this.calcaneusBone = calcaneusBone;
	}


	public CapitateBone getCapitateBone() {
		return capitateBone;
	}


	public void setCapitateBone(CapitateBone capitateBone) {
		this.capitateBone = capitateBone;
	}


	public Carpals getCarpals() {
		return carpals;
	}


	public void setCarpals(Carpals carpals) {
		this.carpals = carpals;
	}


	public Clavicle getClavicle() {
		return clavicle;
	}


	public void setClavicle(Clavicle clavicle) {
		this.clavicle = clavicle;
	}


	public CuboidBone getCuboidBone() {
		return cuboidBone;
	}


	public void setCuboidBone(CuboidBone cuboidBone) {
		this.cuboidBone = cuboidBone;
	}


	public DipJoint getDipJoint() {
		return dipJoint;
	}


	public void setDipJoint(DipJoint dipJoint) {
		this.dipJoint = dipJoint;
	}


	public DistalPhalanages getDistalPhalanages() {
		return distalPhalanages;
	}


	public void setDistalPhalanages(DistalPhalanages distalPhalanages) {
		this.distalPhalanages = distalPhalanages;
	}


	public DistalPhalanx getDistalPhalanx() {
		return distalPhalanx;
	}


	public void setDistalPhalanx(DistalPhalanx distalPhalanx) {
		this.distalPhalanx = distalPhalanx;
	}


	public Fibulas getFibulas() {
		return fibulas;
	}


	public void setFibulas(Fibulas fibulas) {
		this.fibulas = fibulas;
	}


	public HamateCapitateBone getHamateCapitateBone() {
		return hamateCapitateBone;
	}


	public void setHamateCapitateBone(HamateCapitateBone hamateCapitateBone) {
		this.hamateCapitateBone = hamateCapitateBone;
	}

	public IliumOld getIliumBone() {
		return iliumBone;
	}


	public void setIliumBone(IliumOld iliumBone) {
		this.iliumBone = iliumBone;
	}


	public IntermediatePhalanages getIntermediatePhalanages() {
		return intermediatePhalanages;
	}


	public void setIntermediatePhalanages(
			IntermediatePhalanages intermediatePhalanages) {
		this.intermediatePhalanages = intermediatePhalanages;
	}


	public Ischium getIschium() {
		return ischium;
	}


	public void setIschium(Ischium ischium) {
		this.ischium = ischium;
	}


	public LateralCuneiformBone getLateralCuneiformBone() {
		return lateralCuneiformBone;
	}


	public void setLateralCuneiformBone(LateralCuneiformBone lateralCuneiformBone) {
		this.lateralCuneiformBone = lateralCuneiformBone;
	}


	public LunateBone getLunateBone() {
		return lunateBone;
	}


	public void setLunateBone(LunateBone lunateBone) {
		this.lunateBone = lunateBone;
	}


	public MetaCarpals getMetaCarpals() {
		return metaCarpals;
	}


	public void setMetaCarpals(MetaCarpals metaCarpals) {
		this.metaCarpals = metaCarpals;
	}


	public MetaTarsalsBone getMetaTarsalsBone() {
		return metaTarsalsBone;
	}


	public void setMetaTarsalsBone(MetaTarsalsBone metaTarsalsBone) {
		this.metaTarsalsBone = metaTarsalsBone;
	}


	public MiddlePhalanx getMiddlePhalanx() {
		return middlePhalanx;
	}


	public void setMiddlePhalanx(MiddlePhalanx middlePhalanx) {
		this.middlePhalanx = middlePhalanx;
	}


	public NavicularCuneiforms getNavicularCuneiforms() {
		return navicularCuneiforms;
	}


	public void setNavicularCuneiforms(NavicularCuneiforms navicularCuneiforms) {
		this.navicularCuneiforms = navicularCuneiforms;
	}


	public Patellas getPatellas() {
		return patellas;
	}


	public void setPatella(Patellas patellas) {
		this.patellas = patellas;
	}


	public Pelvis getPelvis() {
		return pelvis;
	}


	public void setPelvis(Pelvis pelvis) {
		this.pelvis = pelvis;
	}


	public PipJoint getPipJoint() {
		return pipJoint;
	}


	public void setPipJoint(PipJoint pipJoint) {
		this.pipJoint = pipJoint;
	}


	public PisiformTriquetrumBone getPisiformTriquetrumBone() {
		return pisiformTriquetrumBone;
	}


	public void setPisiformTriquetrumBone(
			PisiformTriquetrumBone pisiformTriquetrumBone) {
		this.pisiformTriquetrumBone = pisiformTriquetrumBone;
	}


	public ProximalPhalanges getProximalPhalanges() {
		return ProximalPhalanges;
	}


	public void setProximalPhalanges(ProximalPhalanges proximalPhalanges) {
		ProximalPhalanges = proximalPhalanges;
	}


	public ProximalPhalanx getProximalPhalanx() {
		return ProximalPhalanx;
	}


	public void setProximalPhalanx(ProximalPhalanx proximalPhalanx) {
		ProximalPhalanx = proximalPhalanx;
	}


	public Pubis getPubis() {
		return pubis;
	}


	public void setPubis(Pubis pubis) {
		this.pubis = pubis;
	}


	public RadialStyloidProcess getRadialStyloidProcess() {
		return radialStyloidProcess;
	}


	public void setRadialStyloidProcess(RadialStyloidProcess radialStyloidProcess) {
		this.radialStyloidProcess = radialStyloidProcess;
	}


	public SacrumBone getSacrumBone() {
		return sacrumBone;
	}


	public void setSacrumBone(SacrumBone sacrumBone) {
		this.sacrumBone = sacrumBone;
	}


	public ScaphoidBone getScaphoidBone() {
		return scaphoidBone;
	}


	public void setScaphoidBone(ScaphoidBone scaphoidBone) {
		this.scaphoidBone = scaphoidBone;
	}


	public Scapula getScapula() {
		return scapula;
	}


	public void setScapula(Scapula scapula) {
		this.scapula = scapula;
	}


	public Skull getSkull() {
		return skull;
	}


	public void setSkull(Skull skull) {
		this.skull = skull;
	}


	public Spine getSpine() {
		return spine;
	}


	public void setSpine(Spine spine) {
		this.spine = spine;
	}


	public Sternum getSternum() {
		return sternum;
	}


	public void setSternum(Sternum sternum) {
		this.sternum = sternum;
	}


	public TalusBone getTalusBone() {
		return TalusBone;
	}


	public void setTalusBone(TalusBone talusBone) {
		TalusBone = talusBone;
	}


	public Tarsals getTarsals() {
		return tarsals;
	}


	public void setTarsals(Tarsals tarsals) {
		this.tarsals = tarsals;
	}


	public TrapeziumBone getTrapeziumBone() {
		return trapeziumBone;
	}


	public void setTrapeziumBone(TrapeziumBone trapeziumBone) {
		this.trapeziumBone = trapeziumBone;
	}


	public TriquetralBone getTriquetralBone() {
		return triquetralBone;
	}


	public void setTriquetralBone(TriquetralBone triquetralBone) {
		this.triquetralBone = triquetralBone;
	}

	public UlnarStyloidProcess getUlnarStyloidProcess() {
		return ulnarStyloidProcess;
	}


	public void setUlnarStyloidProcess(UlnarStyloidProcess ulnarStyloidProcess) {
		this.ulnarStyloidProcess = ulnarStyloidProcess;
	}


	public WristDistalRow getWristDistalRow() {
		return wristDistalRow;
	}


	public void setWristDistalRow(WristDistalRow wristDistalRow) {
		this.wristDistalRow = wristDistalRow;
	}


	public WristProximalRow getWristProximalRow() {
		return wristProximalRow;
	}


	public void setWristProximalRow(WristProximalRow wristProximalRow) {
		this.wristProximalRow = wristProximalRow;
	}
}
