/*
 * Created on Feb 9, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.Esophagus;
import biomight.body.brain.Brain;
import biomight.body.gland.adrenal.AdrenalGlands;
import biomight.body.gland.gallbladder.GallBladder;
import biomight.body.gland.pineal.PinealGland;
import biomight.body.gland.pituitary.PituitaryGland;
import biomight.body.gland.spleen.Spleen;
import biomight.body.gland.thyroid.ParaThyroidGlands;
import biomight.body.gland.thyroid.ThyroidGland;
import biomight.body.organ.bladder.Bladder;
import biomight.body.organ.heart.Heart;
import biomight.body.organ.kidney.Kidneys;
import biomight.body.organ.kidney.Ureters;
import biomight.body.organ.largeintestine.LargeIntestine;
import biomight.body.organ.liver.Liver;
import biomight.body.organ.lung.Bronchi;
import biomight.body.organ.lung.LobarBronchi;
import biomight.body.organ.lung.Lung;
import biomight.body.organ.lung.Lungs;
import biomight.body.organ.lung.SegmentalinicBronchi;
import biomight.body.organ.pancreas.Pancreas;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.body.organ.stomach.Stomach;
import biomight.body.organ.thymus.Thymus;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConstruct;
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
 * Representation of Organs
 * 
 */

public class Organs extends BioMightBase {
	private Brain brain;
	private PituitaryGland pituitaryGland;
	private PinealGland pinealGland;
	private ParaThyroidGlands paraThyroidGlands;
	private ThyroidGland thyroidGland;
	private Thymus thymus;
	private Esophagus esophagus;
	private Trachea trachea;
	private Lungs lungs;
	
	private Bronchi bronchi;
	private LobarBronchi lobarBronchi;
	private SegmentalinicBronchi segmentalinicBronchi;
	
	private Heart heart;
	private Stomach stomach;
	private Kidneys kidneys;
	private AdrenalGlands adrenalGlands;
	private Liver liver;
	private Bladder bladder;
	private Ureters ureters; 
	private Pancreas pancreas;
	private Spleen spleen;
	private SmallIntestine smallIntestine;
	private LargeIntestine largeIntestine;
	private GallBladder gallBladder;
	
	
	/************************************************************************
	 * Organs Constructor 
	 *
	 ***********************************************************************/
	public Organs()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.OrgansRef, null, null);
	}

	/************************************************************************
	 * Organs Constructor 
	 *
	 ***********************************************************************/
	public Organs(String parentID)
	{
		System.out.print("Calling parameterized Organs Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Organs Constructor 
	 *
	 ***********************************************************************/
	public Organs(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Organs
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Organ.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		//System.out.println("Creating Organ for: " + parentID);
			
		// Get the data for the Organ that is defined for this 
		// Organ reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting OrgansInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.OrgansRef, parentID);
			//System.out.println("Have Organs Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Organs");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			//System.out.println("NEED TO EXECUTE Organs METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
			
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Organs, NumTransforms: " + transforms.size());
	
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		boolean bStored = false;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Organs.x3d";

		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			componentID = bioMightTransform.getId();
			System.out.println("Creating Organs: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null || bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for Organs: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(componentID);
					System.out.println("Have Organs Property Info from EJB - NumProps: " + bioMightProperties.size()); 
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - Organs");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("Organs: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				System.out.println("Organs - Using LocalProperties...");
			}
			System.out.println("Organs - PropertiesSize: " + bioMightProperties.size());
			//dumpProperties();
			
			
			
			if (BioWebUtils.isViewEnabled(Constants.BrainRef, bioMightProperties)) {
				//System.out.println("Creating the Brain for ParentID: " + bioMightTransform.getId());
				brain = new Brain(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedBrain = brain.getBioMightGenerate(); 
				initProperty(Constants.BrainRef, Constants.Brain, Constants.BrainRef, brain.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Brain");
			}
			else
				initProperty(Constants.BrainRef, Constants.Brain, BioWebUtils.getPropertyID(Constants.BrainRef, bioMightProperties), BioWebUtils.getPropertyID(Constants.BrainRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
			if (BioWebUtils.isViewEnabled(Constants.PituitaryGlandRef, bioMightProperties)) {
				//System.out.println("Creating the PituitaryGland for ParentID: " + bioMightTransform.getId());
				pituitaryGland = new PituitaryGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedPituitaryGland = pituitaryGland.getBioMightGenerate(); 
				initProperty(Constants.PituitaryGlandRef, Constants.PituitaryGland, Constants.PituitaryGlandRef, pituitaryGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the PituitaryGland");
			}
			else
				initProperty(Constants.PituitaryGlandRef, Constants.PituitaryGland, Constants.PituitaryGlandRef, BioWebUtils.getPropertyID(Constants.PituitaryGlandRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
		
			if (BioWebUtils.isViewEnabled(Constants.PinealGlandRef, bioMightProperties)) {
				//System.out.println("Creating the PinealGland for ParentID: " + bioMightTransform.getId());
				pinealGland = new PinealGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedPinealGland = pinealGland.getBioMightGenerate(); 
				initProperty(Constants.PinealGlandRef, Constants.PinealGland, Constants.PinealGlandRef, pinealGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);			
				System.out.println("Created the PinealGland");
			}
			else
				initProperty(Constants.PinealGlandRef, Constants.PinealGland, Constants.PinealGlandRef, BioWebUtils.getPropertyID(Constants.PinealGlandRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);			
						
			if (BioWebUtils.isViewEnabled(Constants.EsophagusRef, bioMightProperties)) {
				//System.out.println("Creating the Esophagus for ParentID: " + bioMightTransform.getId());
				esophagus = new Esophagus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedEsophagus = esophagus.getBioMightGenerate(); 
				initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);					
				System.out.println("Created the Esophagus");
			}	
			else
				initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, BioWebUtils.getPropertyID(Constants.EsophagusRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			
			if (BioWebUtils.isViewEnabled(Constants.ThyroidGlandRef, bioMightProperties)) {
				//System.out.println("Creating the ThyroidGland for ParentID: " + bioMightTransform.getId());
				thyroidGland = new ThyroidGland(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedThyroid = thyroidGland.getBioMightGenerate(); 
				initProperty(Constants.ThyroidGlandRef, Constants.ThyroidGland, Constants.ThyroidGlandRef, thyroidGland.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);					
				System.out.println("Created the ThyroidGland");
			}
			else
				initProperty(Constants.ThyroidGlandRef, Constants.ThyroidGland, Constants.ThyroidGlandRef, BioWebUtils.getPropertyID(Constants.ThyroidGlandRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				
			if (BioWebUtils.isViewEnabled(Constants.ParaThyroidGlandsRef, bioMightProperties)) {
				//System.out.println("Creating the ParaThyroidGlands for ParentID: " + bioMightTransform.getId());
				paraThyroidGlands = new ParaThyroidGlands(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedParaThyroidGlands = paraThyroidGlands.getBioMightGenerate(); 
				initProperty(Constants.ParaThyroidGlandsRef, Constants.ParaThyroidGlands, Constants.ParaThyroidGlandsRef, paraThyroidGlands.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the ParaThyroidGlands");
			}
			else
				initProperty(Constants.ParaThyroidGlandsRef, Constants.ParaThyroidGlands, Constants.ParaThyroidGlandsRef, BioWebUtils.getPropertyID(Constants.ParaThyroidGlandsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
											
						
			if (BioWebUtils.isViewEnabled(Constants.ThymusRef, bioMightProperties)) {
				//System.out.println("Creating the Thymus for ParentID: " + bioMightTransform.getId());
				thymus = new Thymus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedThymuss = thymus.getBioMightGenerate(); 
				initProperty(Constants.ThymusRef, Constants.Thymus, Constants.ThymusRef, thymus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Thymus");
			}
			else
				initProperty(Constants.ThymusRef, Constants.Thymus, Constants.ThymusRef, BioWebUtils.getPropertyID(Constants.ThymusRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
	
			if (BioWebUtils.isViewEnabled(Constants.LungsRef, bioMightProperties)) {
				//System.out.println("Creating the Lungs for ParentID: " + bioMightTransform.getId());
				lungs = new Lungs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedLungs = lungs.getBioMightGenerate(); 
				initProperty(Constants.LungsRef, Constants.Lungs, Constants.LungsRef, lungs.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Lungs");
			}
			else
				initProperty(Constants.LungsRef, Constants.Lungs, Constants.LungsRef, BioWebUtils.getPropertyID(Constants.LungsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
			if (BioWebUtils.isViewEnabled(Constants.TracheaRef, bioMightProperties)) {
				//System.out.println("Creating Trachea using ParentID: " + bioMightTransform.getId());
				trachea = new Trachea(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedTrachea = trachea.getBioMightGenerate(); 		
				initProperty(Constants.TracheaRef, Constants.Trachea, Constants.TracheaRef, trachea.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);	
				System.out.println("Created the Trachea");
			}
			else
				initProperty(Constants.TracheaRef, Constants.Trachea, Constants.TracheaRef, BioWebUtils.getPropertyID(Constants.TracheaRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	

			if (BioWebUtils.isViewEnabled(Constants.BronchiRef, bioMightProperties)) {
				//System.out.println("Creating Bronchi using ParentID: " + bioMightTransform.getId());
				bronchi = new Bronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedBronchi = bronchi.getBioMightGenerate(); 		
				initProperty("Bronchi", Constants.Bronchi, Constants.BronchiRef, bronchi.getComponentID() , bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);	
				System.out.println("Bronchi are created");
			}
			else
				initProperty("Bronchi", Constants.Bronchi, Constants.BronchiRef, BioWebUtils.getPropertyID(Constants.BronchiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	
			
			if (BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, bioMightProperties)) {
				//System.out.println("Creating LobarBronchi using ParentID: " + bioMightTransform.getId());
				lobarBronchi = new LobarBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedLobarBronchi = lobarBronchi.getBioMightGenerate(); 				
				initProperty("LobarBronchi", Constants.LobarBronchi, Constants.LobarBronchiRef, lobarBronchi.getComponentID(),  bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);	
				System.out.println("LobarBronchi are created");
			}
			else
				initProperty("LobarBronchi", Constants.LobarBronchi, Constants.LobarBronchiRef, BioWebUtils.getPropertyID(Constants.LobarBronchiRef, bioMightProperties),  bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	

			if (BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, bioMightProperties)) {
				//System.out.println("Creating SegmentalinicBronchi using ParentID: " + bioMightTransform.getId());
				segmentalinicBronchi = new SegmentalinicBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedSegmentalinicBronchi = segmentalinicBronchi.getBioMightGenerate(); 				
				initProperty(Constants.SegmentalinicBronchiRef, Constants.SegmentalinicBronchi, Constants.SegmentalinicBronchiRef, segmentalinicBronchi.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);	
				System.out.println("SegmentalinicBronchi are created");
			}
			else
				initProperty(Constants.SegmentalinicBronchiRef, Constants.SegmentalinicBronchi, BioWebUtils.getPropertyID(Constants.SegmentalinicBronchiRef, bioMightProperties), BioWebUtils.getPropertyID(Constants.SegmentalinicBronchiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	
			
			
			if (BioWebUtils.isViewEnabled(Constants.HeartRef, bioMightProperties)) {
				//System.out.println("Creating the Heart for parent: " + bioMightTransform.getId());
				heart = new Heart(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, heart.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);	
				System.out.println("Created the Heart");
			}
			else
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, BioWebUtils.getPropertyID(Constants.HeartRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	

			if (BioWebUtils.isViewEnabled(Constants.LiverRef, bioMightProperties)) {
				//System.out.println("Creating the Liver for ParentID: " + bioMightTransform.getId());
				liver = new Liver(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedLiver = liver.getBioMightGenerate(); 
				initProperty(Constants.LiverRef, Constants.Liver, Constants.LiverRef, liver.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);					
				System.out.println("Created the Liver");
				}
			else
				initProperty(Constants.LiverRef, Constants.Liver, Constants.LiverRef, BioWebUtils.getPropertyID(Constants.LiverRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					

			
			if (BioWebUtils.isViewEnabled(Constants.StomachRef, bioMightProperties)) {
				//System.out.println("Creating the Stomach for ParentID: " + bioMightTransform.getId());
				stomach = new Stomach(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedStomach = stomach.getBioMightGenerate(); 
				initProperty(Constants.StomachRef, Constants.Stomach, Constants.StomachRef, stomach.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				System.out.println("Created the Stomach");
			}
			else
				initProperty(Constants.StomachRef, Constants.Stomach, Constants.StomachRef, BioWebUtils.getPropertyID(Constants.StomachRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
						
			localVP = Constants.VIEW_DETACHED;
			localLOD = Constants.MAG1X;
		
			if (BioWebUtils.isViewEnabled(Constants.SmallIntestineRef, bioMightProperties)) {
				//System.out.println("Creating the SmallIntestine for VIEW DETACHED ParentID: " + bioMightTransform.getId());
				smallIntestine = new SmallIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedSmallIntestine = smallIntestine.getBioMightGenerate(); 
				initProperty(Constants.SmallIntestineRef, Constants.SmallIntestine, Constants.SmallIntestineRef, smallIntestine.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the SmallIntestine");
			}
			else
				initProperty(Constants.SmallIntestineRef, Constants.SmallIntestine, Constants.SmallIntestineRef, BioWebUtils.getPropertyID(Constants.SmallIntestineRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
	
			if (BioWebUtils.isViewEnabled(Constants.LargeIntestineRef, bioMightProperties)) {
				//System.out.println("Creating the LargeIntestine for ParentID: " + bioMightTransform.getId());
				largeIntestine = new LargeIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedLargeIntestine = largeIntestine.getBioMightGenerate(); 
				initProperty(Constants.LargeIntestineRef, Constants.LargeIntestine, Constants.LargeIntestineRef, largeIntestine.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the LargeIntestine");
			}
			else
				initProperty(Constants.LargeIntestineRef, Constants.LargeIntestine, Constants.LargeIntestineRef, BioWebUtils.getPropertyID(Constants.LargeIntestineRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			if (BioWebUtils.isViewEnabled(Constants.KidneysRef, bioMightProperties)) {
				//System.out.println("Creating the Kidneys for ParentID: " + bioMightTransform.getId());
				kidneys = new Kidneys(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedKidneys = kidneys.getBioMightGenerate(); 
				initProperty(Constants.KidneysRef, Constants.Kidneys, Constants.KidneysRef, kidneys.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Kidneys");
			}
			else
				initProperty(Constants.KidneysRef, Constants.Kidneys, Constants.KidneysRef, BioWebUtils.getPropertyID(Constants.KidneysRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			
			if (BioWebUtils.isViewEnabled(Constants.AdrenalGlandsRef, bioMightProperties)) {
				//System.out.println("Creating the AdrenalGlands for ParentID: " + bioMightTransform.getId());
				adrenalGlands = new AdrenalGlands(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedAdrenalGlands = adrenalGlands.getBioMightGenerate(); 
				initProperty(Constants.AdrenalGlandsRef, Constants.AdrenalGlands, Constants.AdrenalGlandsRef, adrenalGlands.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the AdrenalGlands");
			}
			else
				initProperty(Constants.AdrenalGlandsRef, Constants.AdrenalGlands, Constants.AdrenalGlandsRef, BioWebUtils.getPropertyID(Constants.AdrenalGlandsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
			
			if (BioWebUtils.isViewEnabled(Constants.PancreasRef, bioMightProperties)) {
				//System.out.println("Creating Pancreas: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				pancreas = new Pancreas(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.PancreasRef, Constants.Pancreas, Constants.PancreasRef, pancreas.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);
				System.out.println("Created the Pancreas");
			}
			else
				initProperty(Constants.PancreasRef, Constants.Pancreas, Constants.PancreasRef, BioWebUtils.getPropertyID(Constants.PancreasRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
					
			if (BioWebUtils.isViewEnabled(Constants.BladderRef, bioMightProperties)) {
				//System.out.println("Creating the Bladder for ParentID: " + bioMightTransform.getId());
				bladder = new Bladder(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedBladder = bladder.getBioMightGenerate(); 
				initProperty(Constants.BladderRef, Constants.Bladder, Constants.BladderRef, bladder.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Bladder");
			}
			else
				initProperty(Constants.BladderRef, Constants.Bladder, Constants.BladderRef, BioWebUtils.getPropertyID(Constants.BladderRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
			
			if (BioWebUtils.isViewEnabled(Constants.GallBladderRef, bioMightProperties)) {
				//System.out.println("Creating the GallBladder for parent: " + bioMightTransform.getId());
				gallBladder = new GallBladder(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.GallBladderRef, Constants.GallBladder, Constants.GallBladderRef, gallBladder.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the GallBladder");	
			}
			else
				initProperty(Constants.GallBladderRef, Constants.GallBladder, Constants.GallBladderRef, BioWebUtils.getPropertyID(Constants.GallBladderRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
			
			if (BioWebUtils.isViewEnabled(Constants.SpleenRef, bioMightProperties)) {
				//System.out.println("Creating the Spleen for ParentID: " + bioMightTransform.getId());
				spleen = new Spleen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedSpleen = spleen.getBioMightGenerate();
				initProperty(Constants.SpleenRef, Constants.Spleen, Constants.SpleenRef, spleen.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Spleen");
			}
			else
				initProperty(Constants.SpleenRef, Constants.Spleen, Constants.SpleenRef, BioWebUtils.getPropertyID(Constants.SpleenRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			if (BioWebUtils.isViewEnabled(Constants.UretersRef, bioMightProperties)) {
				//System.out.println("Creating the Ureter for ParentID: " + bioMightTransform.getId());
				ureters = new Ureters(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedUreter = ureters.getBioMightGenerate();
				initProperty(Constants.UretersRef, Constants.Ureters, Constants.UretersRef, ureters.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Ureters");
			}
			else
				initProperty(Constants.UretersRef, Constants.Ureters, Constants.UretersRef, BioWebUtils.getPropertyID(Constants.UretersRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						System.out.println("Setting Property info for Organs: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.OrgansRef, bioMightTransform.getComponentName(), properties);      
						System.out.println("Stored Organs Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - Organs");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}
		}
		
		//System.out.println("Init Properties");	
		//initProperties();
		initMethods();				
	}
	
	



	public void initProperties() {
		
		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Stomach");
		property.setCanonicalName(Constants.Stomach);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Kidneys");
		property.setCanonicalName(Constants.Kidneys);
		properties.add(property);

	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
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
	 * This method will return the X3D for the Organs.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Organs
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Organs.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Organs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = "";

			
		if (BioWebUtils.isViewEnabled(Constants.EsophagusRef, properties)) {
			body += esophagus.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ThyroidGlandRef, properties)) {
			body += thyroidGland.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ParaThyroidGlandsRef, properties)) {
			body += paraThyroidGlands.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ThymusRef, properties)) {
			body += thymus.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LungsRef, properties)) {
			body += lungs.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.TracheaRef, properties)) {
			body += trachea.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BronchiRef, properties)) {
			body += bronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, properties)) {
			body += lobarBronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, properties)) {
			body += segmentalinicBronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.HeartRef, properties)) {
			body += heart.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.StomachRef, properties)) {
			body += stomach.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SmallIntestineRef, properties)) {
			body += smallIntestine.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LargeIntestineRef, properties)) {
			body += largeIntestine.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.KidneysRef, properties)) {
			body += kidneys.getX3D(true);
		}	 
		if (BioWebUtils.isViewEnabled(Constants.PancreasRef, properties)) {
			body += pancreas.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.KidneysRef, properties)) {
			body += kidneys.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.SpleenRef, properties)) {
			body += spleen.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.AdrenalGlandsRef, properties)) {
			body += adrenalGlands.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.BrainRef, properties)) {
			body += brain.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.PituitaryGlandRef, properties)) {
			body += pituitaryGland.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.PinealGlandRef, properties)) {
			body += pinealGland.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.LiverRef, properties)) {
			body += liver.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.UretersRef, properties)) {
			body += ureters.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BladderRef, properties)) {
			body += bladder.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.GallBladderRef, properties)) {
			body += gallBladder.getX3D(true);
		}
	
		//System.out.println("Organ Collection X3D: " + body);
		
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	/**
	public void onContact(Object obj)
	{	
		if (obj instanceof CytotoxicTOrgan)
		{
			// Cytotoxic T Organs will interact strongly
			// if the cell is virus infected.	
		}
	}
	***/

}
