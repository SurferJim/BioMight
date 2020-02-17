package biomightweb.actions;


import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.body.Abdomen;
import biomight.body.Ankle;
import biomight.body.Back;
import biomight.body.Body;
import biomight.body.Chest;
import biomight.body.Elbow;
import biomight.body.Elbows;
import biomight.body.Esophagus;
import biomight.body.LeftButtock;
import biomight.body.LeftElbow;
import biomight.body.LeftNipple;
import biomight.body.LeftShoulder;
import biomight.body.Nipples;
import biomight.body.RightButtock;
import biomight.body.RightElbow;
import biomight.body.RightForeArm;
import biomight.body.RightNipple;
import biomight.body.RightShoulder;
import biomight.body.Shoulder;
import biomight.body.Shoulders;
import biomight.body.Torso;
import biomight.body.Waist;
import biomight.body.Wrist;
import biomight.body.Wrists;
import biomight.body.arm.Arm;
import biomight.body.arm.Arms;
import biomight.body.arm.ForeArm;
import biomight.body.arm.ForeArms;
import biomight.body.arm.LeftArm;
import biomight.body.arm.LeftForeArm;
import biomight.body.arm.RightArm;
import biomight.body.brain.Brain;
import biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Cerebellum;
import biomight.body.female.Breast;
import biomight.body.female.Vagina;
import biomight.body.foot.Feet;
import biomight.body.foot.Foot;
import biomight.body.foot.LeftFoot;
import biomight.body.foot.RightFoot;
import biomight.body.gland.adrenal.AdrenalGland;
import biomight.body.gland.adrenal.AdrenalGlands;
import biomight.body.gland.gallbladder.GallBladder;
import biomight.body.gland.pineal.PinealGland;
import biomight.body.gland.pituitary.PituitaryGland;
import biomight.body.gland.spleen.Spleen;
import biomight.body.gland.spleen.SpleenAnteriorBorder;
import biomight.body.gland.spleen.SpleenPosteriorBorder;
import biomight.body.gland.thyroid.ParaThyroidGland;
import biomight.body.gland.thyroid.ParaThyroidGlands;
import biomight.body.gland.thyroid.ThyroidGland;
import biomight.body.hand.Finger;
import biomight.body.hand.FingerNail;
import biomight.body.hand.Fingers;
import biomight.body.hand.Hand;
import biomight.body.hand.Hands;
import biomight.body.hand.IndexFinger;
import biomight.body.hand.LittleFinger;
import biomight.body.hand.MiddleFinger;
import biomight.body.hand.Palm;
import biomight.body.hand.RingFinger;
import biomight.body.hand.Thumb;
import biomight.body.head.Head;
import biomight.body.head.Jaw;
import biomight.body.head.ear.Auricle;
import biomight.body.head.ear.Cochlea;
import biomight.body.head.ear.Ear;
import biomight.body.head.ear.Ears;
import biomight.body.head.ear.ExternalCanal;
import biomight.body.head.ear.Incus;
import biomight.body.head.ear.Malleus;
import biomight.body.head.ear.Saccule;
import biomight.body.head.ear.SemiCircularCanals;
import biomight.body.head.ear.Stapes;
import biomight.body.head.ear.TympanicMembrane;
import biomight.body.head.ear.Utricle;
import biomight.body.head.eye.AnteriorChamber;
import biomight.body.head.eye.CanalOfSchlemm;
import biomight.body.head.eye.Choroid;
import biomight.body.head.eye.CiliaryBody;
import biomight.body.head.eye.CiliaryMuscle;
import biomight.body.head.eye.CiliaryProcess;
import biomight.body.head.eye.Cone;
import biomight.body.head.eye.Conjunctiva;
import biomight.body.head.eye.Cornea;
import biomight.body.head.eye.Eye;
import biomight.body.head.eye.EyeLashes;
import biomight.body.head.eye.EyeLens;
import biomight.body.head.eye.Eyes;
import biomight.body.head.eye.Fovea;
import biomight.body.head.eye.Iris;
import biomight.body.head.eye.Lens;
import biomight.body.head.eye.LowerEyeLid;
import biomight.body.head.eye.Macula;
import biomight.body.head.eye.MobomiumGland;
import biomight.body.head.eye.OpticDisc;
import biomight.body.head.eye.ParsPlana;
import biomight.body.head.eye.Photopsin;
import biomight.body.head.eye.PosteriorChamber;
import biomight.body.head.eye.Pupil;
import biomight.body.head.eye.PupilMargin;
import biomight.body.head.eye.PupilSphincter;
import biomight.body.head.eye.Retina;
import biomight.body.head.eye.Rod;
import biomight.body.head.eye.Sclera;
import biomight.body.head.eye.SebaciousCyst;
import biomight.body.head.eye.Trabeculum;
import biomight.body.head.eye.UpperEyeLid;
import biomight.body.head.eye.VitreousHumor;
import biomight.body.head.eye.ZonularFibers;
import biomight.body.head.mouth.Lip;
import biomight.body.head.mouth.Lips;
import biomight.body.head.mouth.LowerLip;
import biomight.body.head.mouth.Mouth;
import biomight.body.head.mouth.SalivaryGland;
import biomight.body.head.mouth.SalivaryGlands;
import biomight.body.head.mouth.UpperLip;
import biomight.body.head.mouth.tongue.CircumvallatePapilla;
import biomight.body.head.mouth.tongue.CircumvallatePapillae;
import biomight.body.head.mouth.tongue.FiliformPapilla;
import biomight.body.head.mouth.tongue.FiliformPapillae;
import biomight.body.head.mouth.tongue.FoliatePapilla;
import biomight.body.head.mouth.tongue.FoliatePapillae;
import biomight.body.head.mouth.tongue.FungiformPapilla;
import biomight.body.head.mouth.tongue.FungiformPapillae;
import biomight.body.head.mouth.tongue.Tongue;
import biomight.body.head.nose.Nose;
import biomight.body.head.tooth.Teeth;
import biomight.body.head.tooth.Tooth;
import biomight.body.leg.Calf;
import biomight.body.leg.Knee;
import biomight.body.leg.Knees;
import biomight.body.leg.cnemis.Cnemes;
import biomight.body.leg.cnemis.Cnemis;
import biomight.body.leg.thigh.LeftThigh;
import biomight.body.leg.thigh.RightThigh;
import biomight.body.leg.thigh.Thigh;
import biomight.body.leg.thigh.Thighs;
import biomight.body.male.Penis;
import biomight.body.neck.Neck;
import biomight.body.organ.CommonBileDuct;
import biomight.body.organ.CommonHepaticDuct;
import biomight.body.organ.CysticDuct;
import biomight.body.organ.HepaticDuct;
import biomight.body.organ.HepaticDucts;
import biomight.body.organ.Organs;
import biomight.body.organ.Trachea;
import biomight.body.organ.bladder.Bladder;
import biomight.body.organ.heart.AorticArch;
import biomight.body.organ.heart.Heart;
import biomight.body.organ.heart.LeftAtrium;
import biomight.body.organ.heart.LeftVentricle;
import biomight.body.organ.heart.RightAtrium;
import biomight.body.organ.kidney.Calyces;
import biomight.body.organ.kidney.Kidney;
import biomight.body.organ.kidney.KidneyVisceralEpithelium;
import biomight.body.organ.kidney.Kidneys;
import biomight.body.organ.kidney.MaculaDensa;
import biomight.body.organ.kidney.RenalFibrousCapsule;
import biomight.body.organ.kidney.RenalPapilla;
import biomight.body.organ.kidney.RenalPelvis;
import biomight.body.organ.kidney.RenalSinus;
import biomight.body.organ.kidney.Ureter;
import biomight.body.organ.kidney.Ureters;
import biomight.body.organ.largeintestine.Intestines;
import biomight.body.organ.largeintestine.LargeIntestine;
import biomight.body.organ.liver.Liver;
import biomight.body.organ.liver.LiverLeftLateralLobe;
import biomight.body.organ.liver.LiverQuadrateLobe;
import biomight.body.organ.liver.LiverRightLateralLobe;
import biomight.body.organ.liver.LiverRightMedialLobe;
import biomight.body.organ.lung.Bronchi;
import biomight.body.organ.lung.Bronchus;
import biomight.body.organ.lung.LobarBronchi;
import biomight.body.organ.lung.LobarBronchus;
import biomight.body.organ.lung.Lung;
import biomight.body.organ.lung.LungAnteriorBorder;
import biomight.body.organ.lung.LungApexPulmonis;
import biomight.body.organ.lung.LungBasisPulmonis;
import biomight.body.organ.lung.LungCostalSurface;
import biomight.body.organ.lung.LungInferiorLobe;
import biomight.body.organ.lung.LungMediastinalSurface;
import biomight.body.organ.lung.LungMiddleLobe;
import biomight.body.organ.lung.LungSuperiorLobe;
import biomight.body.organ.lung.Lungs;
import biomight.body.organ.lung.SegmentalinicBronchi;
import biomight.body.organ.lung.SegmentalinicBronchus;
import biomight.body.organ.pancreas.Pancreas;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.body.organ.stomach.Antrum;
import biomight.body.organ.stomach.GreaterCurvature;
import biomight.body.organ.stomach.LesserCurvature;
import biomight.body.organ.stomach.LowerEsophagealSphincter;
import biomight.body.organ.stomach.Pylorus;
import biomight.body.organ.stomach.Stomach;
import biomight.body.organ.stomach.StomachCardiacNotch;
import biomight.body.organ.thymus.Thymus;
import biomight.body.substructs.cardia.Cardia;
import biomight.body.substructs.pharynx.Pharynx;
import biomight.cascades.Cascades;
import biomight.chemistry.molecule.Molecules;
import biomight.exceptions.DataException;
import biomight.exceptions.ServerException;
import biomight.pathway.Pathways;
import biomight.system.BioMightSystems;
import biomight.system.CirculatorySystem;
import biomight.system.DigestiveSystem;
import biomight.system.EndocrineSystem;
import biomight.system.ExecretorySystem;
import biomight.system.ImmuneSystem;
import biomight.system.IntegumentarySystem;
import biomight.system.LymphaticSystem;
import biomight.system.MuscularSystem;
import biomight.system.NervousSystem;
import biomight.system.ReproductiveSystem;
import biomight.system.RespiratorySystem;
import biomight.system.SkeletalSystem;
import biomight.system.UrinarySystem;
import biomight.system.muscular.hand.ThenarEminence;
import biomightweb.view.BioMightComponent;




/*******************************************************************************************************
 * Maps the Body instance into the proper class 
 * 
 * 
 * SurferJim
 ******************************************************************************************************/

public class BioMightViewBody {
	
	
	public BioMightViewBody() {
		
	}
	

	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {
		
		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		String bioMightComponentID = bioMightComponent.getBioMightComponentID();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
		
		
		if (bioMightComponentRef.equals(Constants.BioMightSystems))
		{
			BioMightSystems bioMightSystems = (BioMightSystems) bioMightInstance;
			bioMightComponent.setImage(bioMightSystems.getImage());

			bioMightComponent.setImage(bioMightSystems.getImage());
			bioMightComponent.setWidth(bioMightSystems.getImageWidth());
			bioMightComponent.setHeight(bioMightSystems.getImageHeight());
			bioMightComponent.setBioMightProperties(bioMightSystems.getProperties());
			bioMightComponent.setBioMightMethods(bioMightSystems.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BioMightSystems: "  + bioMightComponentName +  "     ID: " +bioMightSystems.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioMightSystems.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			bioMightComponent.setX3D(bioMightSystems.getX3D(snippet));	
			//bioMightComponent.dumpProperties();
			//System.out.println("Done here!");
		}			
	
		/**************************************************************************
		*
		* DIGESTIVE SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
											
		else if (bioMightComponentRef.equals(Constants.DigestiveSystem)) 
		{	
			DigestiveSystem digestiveSystem = (DigestiveSystem) bioMightInstance;
			bioMightComponent.setImage(digestiveSystem.getImage());	
			bioMightComponent.setWidth(digestiveSystem.getImageWidth());
			bioMightComponent.setHeight(digestiveSystem.getImageHeight());
			bioMightComponent.setBioMightProperties(digestiveSystem.getProperties());
			bioMightComponent.setBioMightMethods(digestiveSystem.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DigestiveSystem: "  + bioMightComponentName +  "     ID: " + digestiveSystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(digestiveSystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Thumbs Methods!");
			//	thumb.executeMethods(methodParams);
			//	thumb.redraw(0);
			//}
			bioMightComponent.setX3D(digestiveSystem.getX3D(snippet));	
		}
		
		/**************************************************************************
		*
		* VASCULAR/CIRCULATORY SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
	
		else if (bioMightComponentRef.equals(Constants.CirculatorySystem))
		{
			CirculatorySystem circulatorySystem = (CirculatorySystem) bioMightInstance;
	
			bioMightComponent.setImage(circulatorySystem.getImage());
			bioMightComponent.setWidth(circulatorySystem.getImageWidth());
			bioMightComponent.setHeight(circulatorySystem.getImageHeight());
			bioMightComponent.setBioMightProperties(circulatorySystem.getProperties());
			bioMightComponent.setBioMightMethods(circulatorySystem.getMethods());
			bioMightComponent.setBioMightCollection(false);	
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CirculatorySystem: "  + bioMightComponentName +  "     ID: " + circulatorySystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(circulatorySystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CirculatorySystem Methods!");
			//	circulatorySystem(methodParams);
			//	circulatorySystem.redraw(0);
			//}
			System.out.println("Getting X3D for CirculatorySystem!");
			bioMightComponent.setX3D(circulatorySystem.getX3D(snippet));			
		}

		/**************************************************************************
		*
		* IMMUNE SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
					
		else if (bioMightComponentRef.equals(Constants.ImmuneSystem))
		{
			ImmuneSystem immuneSystem = (ImmuneSystem) bioMightInstance;
			bioMightComponent.setImage(immuneSystem.getImage());
			bioMightComponent.setBioMightProperties(immuneSystem.getProperties());
			bioMightComponent.setBioMightMethods(immuneSystem.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for immuneSystem: "  + bioMightComponentName +  "     ID: " + immuneSystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(immuneSystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ImmuneSystem Methods!");
			//	immuneSystem.executeMethods(methodParams);
			//	immuneSystem.redraw(0);
			//}
			System.out.println("Getting X3D for ImmuneSystem!");
			bioMightComponent.setX3D(immuneSystem.getX3D(snippet));
		}

		
		/**************************************************************************
		*
		* MUSCULAR SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/

		
		else if (bioMightComponentRef.equals(Constants.MuscularSystem))
		{
			MuscularSystem muscularSystem = (MuscularSystem) bioMightInstance;
			bioMightComponent.setImage(muscularSystem.getImage());
			
			bioMightComponent.setWidth(muscularSystem.getImageWidth());
			bioMightComponent.setHeight(muscularSystem.getImageHeight());
			bioMightComponent.setBioMightProperties(muscularSystem.getProperties());
			bioMightComponent.setBioMightMethods(muscularSystem.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MuscularSystem: "  + bioMightComponentName +  "     ID: " + muscularSystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(muscularSystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.   
			//if (executeMethods) {
			//	System.out.println("Executing MuscularSystem Methods!");
			//	muscularSystem.executeMethods(methodParams);
			//	muscularSystem.redraw(0);
			//}
			System.out.println("Getting X3D for MuscularSystem!");
			bioMightComponent.setX3D(muscularSystem.getX3D(snippet));	
		}

		else if (bioMightComponentRef.equals(Constants.RespiratorySystem))
		{
			RespiratorySystem respiratorySystem = (RespiratorySystem) bioMightInstance;
			bioMightComponent.setImage(respiratorySystem.getImage());
			bioMightComponent.setBioMightProperties(respiratorySystem.getProperties());
			bioMightComponent.setBioMightMethods(respiratorySystem.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RespiratorySystem: "  + bioMightComponentName +  "     ID: " + respiratorySystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(respiratorySystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Thumbs Methods!");
			//	thumb.executeMethods(methodParams);
			//	thumb.redraw(0);
			//}
			bioMightComponent.setX3D(respiratorySystem.getX3D(snippet));
		}


		/**************************************************************************
		*
		* SKELETAL SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/		
		else if (bioMightComponentRef.equals(Constants.SkeletalSystem))
		{
			SkeletalSystem skeletalSystem  = (SkeletalSystem) bioMightInstance;
			bioMightComponent.setImage(skeletalSystem.getImage());
			
			bioMightComponent.setWidth(skeletalSystem.getImageWidth());
			bioMightComponent.setHeight(skeletalSystem.getImageHeight());
			bioMightComponent.setBioMightProperties(skeletalSystem.getProperties());
			bioMightComponent.setBioMightMethods(skeletalSystem.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SkeletalSystem: "  + bioMightComponentName +  "     ID: " + skeletalSystem.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(skeletalSystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MuscularSystem Methods!");
			//	muscularSystem.executeMethods(methodParams);
			//	muscularSystem.redraw(0);
			//}
			System.out.println("Getting X3D for SkeletalSystem!");
			bioMightComponent.setX3D(skeletalSystem.getX3D(snippet));
		}
			

		/**************************************************************************
		*
		* NERVOUS SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/			
		
		else if (bioMightComponentRef.equals(Constants.NervousSystem))
		{
			NervousSystem nervousSystem = (NervousSystem) bioMightInstance;
			bioMightComponent.setImage(nervousSystem.getImage());
			bioMightComponent.setBioMightProperties(nervousSystem.getProperties());
			bioMightComponent.setBioMightMethods(nervousSystem.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LymphaticSystem))
		{
			LymphaticSystem lymphaticSystem = (LymphaticSystem) bioMightInstance;
			bioMightComponent.setImage(lymphaticSystem.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.ReproductiveSystem))
		{
			ReproductiveSystem reproductiveSystem = (ReproductiveSystem) bioMightInstance;
			bioMightComponent.setImage(reproductiveSystem.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.ExecretorySystem))
		{
			ExecretorySystem execretorySystem = (ExecretorySystem) bioMightInstance;
			bioMightComponent.setImage(execretorySystem.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.CirculatorySystem))
		{
			CirculatorySystem circulatorySystem = (CirculatorySystem) bioMightInstance;
			bioMightComponent.setImage(circulatorySystem.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.EndocrineSystem))
		{
			EndocrineSystem endocrineSystem = (EndocrineSystem) bioMightInstance;
			bioMightComponent.setImage(endocrineSystem.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.IntegumentarySystem))
		{
			IntegumentarySystem integumentarySystem = (IntegumentarySystem) bioMightInstance;
			bioMightComponent.setImage(integumentarySystem.getImage());
			bioMightComponent.setWidth(integumentarySystem.getImageWidth());
			bioMightComponent.setHeight(integumentarySystem.getImageHeight());
		}			
		

		/**************************************************************************
		*
		* URINARY SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/			
	
		
		else if (bioMightComponentRef.equals(Constants.UrinarySystem))
		{
			UrinarySystem urinarySystem = (UrinarySystem) bioMightInstance;
			bioMightComponent.setImage(urinarySystem.getImage());
			bioMightComponent.setWidth(urinarySystem.getImageWidth());
			bioMightComponent.setHeight(urinarySystem.getImageHeight());
			bioMightComponent.setBioMightProperties(urinarySystem.getProperties());
			bioMightComponent.setBioMightMethods(urinarySystem.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.Ureters))
		{
			Ureters ureters = (Ureters) bioMightInstance;
			bioMightComponent.setImage(ureters.getImage());
			bioMightComponent.setWidth(ureters.getImageWidth());
			bioMightComponent.setHeight(ureters.getImageHeight());
			

			bioMightComponent.setHeight(ureters.getImageHeight());
			bioMightComponent.setBioMightProperties(ureters.getProperties());
			bioMightComponent.setBioMightMethods(ureters.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ureters: "  + bioMightComponent +  "     ID: " + ureters.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ureters.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	ureters.executeMethods(methodParams);
			//	ureters.redraw(0);
			//}
			
			System.out.println("Getting X3D for ureters!");
			bioMightComponent.setX3D(ureters.getX3D(snippet));

		}	
		else if (bioMightComponentRef.equals(Constants.Ureter))
		{
			Ureter ureter = (Ureter) bioMightInstance;
			bioMightComponent.setImage(ureter.getImage());
			bioMightComponent.setWidth(ureter.getImageWidth());
			bioMightComponent.setHeight(ureter.getImageHeight());
		}

		
		/**************************************************************************
		*
		* ORGANS
		* 
		***************************************************************************/

		else if (bioMightComponentRef.equals(Constants.Organs))
		{
			Organs organs = (Organs) bioMightInstance;
			bioMightComponent.setImage(organs.getImage());
			bioMightComponent.setBioMightProperties(organs.getProperties());
			bioMightComponent.setBioMightMethods(organs.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Organs: "  + bioMightComponent +  "     ID: " + organs.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(organs.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Organs Methods!");
			//	organs(methodParams);
			//	organs(0);
			//}
			System.out.println("Getting X3D for Organs!");
			bioMightComponent.setX3D(organs.getX3D(snippet));	
		}
				
		/**************************************************************************
		*
		* BLADDER
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.Bladder))
		{
			Bladder bladder = (Bladder) bioMightInstance;
			bioMightComponent.setImage(bladder.getImage());
			bioMightComponent.setBioMightProperties(bladder.getProperties());
			bioMightComponent.setBioMightMethods(bladder.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Bladder: "  + bioMightComponent +  "     ID: " + bladder.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bladder.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	bladder.executeMethods(methodParams);
			//	bladder.redraw(0);
			//}
			System.out.println("Getting X3D for Bladder!");
			bioMightComponent.setX3D(bladder.getX3D(snippet));	
		}
		
		/**************************************************************************
		*
		* GALL BLADDER
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.GallBladder))
		{
			GallBladder gallBladder = (GallBladder) bioMightInstance;
			bioMightComponent.setImage(gallBladder.getImage());
			bioMightComponent.setBioMightProperties(gallBladder.getProperties());
			bioMightComponent.setBioMightMethods(gallBladder.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GallBladder: "  + bioMightComponent +  "     ID: " + gallBladder.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gallBladder.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	heart.executeMethods(methodParams);
			//	heart.redraw(0);
			//}
			System.out.println("Getting X3D for GallBladder!");
			bioMightComponent.setX3D(gallBladder.getX3D(snippet));	
		}

		/**************************************************************************
		*
		* HEART
		*  
		***************************************************************************/			
		
		else if (bioMightComponentRef.equals(Constants.Heart))
		{
			Heart heart = (Heart) bioMightInstance;
			bioMightComponent.setImage(heart.getImage());
			bioMightComponent.setBioMightProperties(heart.getProperties());
			bioMightComponent.setBioMightMethods(heart.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Heart: "  + bioMightComponent +  "     ID: " + heart.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(heart.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	heart.executeMethods(methodParams);
			//	heart.redraw(0);
			//}
			System.out.println("Getting X3D for Heart!");
			bioMightComponent.setX3D(heart.getX3D(snippet));		
		}	
		else if (bioMightComponentRef.equals(Constants.AorticArch))
		{
			AorticArch aorticArch = (AorticArch) bioMightInstance;
			bioMightComponent.setImage(aorticArch.getImage());
			//bioMightComponent.setBioMightProperties(aorticArch.getProperties());
			//bioMightComponent.setBioMightMethods(aorticArch.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightAtrium))
		{
			RightAtrium rightAtrium = (RightAtrium) bioMightInstance;
			bioMightComponent.setImage(rightAtrium.getImage());
			//bioMightComponent.setBioMightProperties(rightAtrium.getProperties());
			//bioMightComponent.setBioMightMethods(rightAtrium.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftAtrium))
		{
			LeftAtrium leftAtrium = (LeftAtrium) bioMightInstance;
			bioMightComponent.setImage(leftAtrium.getImage());
			//bioMightComponent.setBioMightProperties(leftAtrium.getProperties());
			//bioMightComponent.setBioMightMethods(leftAtrium.getMethods());
		}					
		else if (bioMightComponentRef.equals(Constants.LeftVentricle))
		{
			LeftVentricle leftVentricle = (LeftVentricle) bioMightInstance;
			bioMightComponent.setImage(leftVentricle.getImage());
			//bioMightComponent.setBioMightProperties(leftVentricle.getProperties());
			//bioMightComponent.setBioMightMethods(leftVentricle.getMethods());
		}		
	
		/**************************************************************************
		*
		* STOMACH
		*  
		***************************************************************************/			
		
		else if (bioMightComponentRef.equals(Constants.Stomach))
		{
			Stomach stomach = (Stomach) bioMightInstance;
			bioMightComponent.setImage(stomach.getImage());
			bioMightComponent.setWidth(stomach.getImageWidth());
			bioMightComponent.setHeight(stomach.getImageHeight());
			bioMightComponent.setBioMightProperties(stomach.getProperties());
			bioMightComponent.setBioMightMethods(stomach.getMethods());			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Stomach: "  + bioMightComponent +  "     ID: " + stomach.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(stomach.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	stomach.executeMethods(methodParams);
			//	stomach.redraw(0);
			//}
			System.out.println("Getting X3D for Stomach!");
			bioMightComponent.setX3D(stomach.getX3D(snippet));	
		}	
		else if (bioMightComponentRef.equals(Constants.StomachCardiacNotch))
		{
			StomachCardiacNotch stomachCardiacNotch = (StomachCardiacNotch) bioMightInstance;
			bioMightComponent.setImage(stomachCardiacNotch.getImage());
			bioMightComponent.setWidth(stomachCardiacNotch.getImageWidth());
			bioMightComponent.setHeight(stomachCardiacNotch.getImageHeight());
			//bioMightComponent.setBioMightProperties(stomachCardiacNotch.getProperties());
			//bioMightComponent.setBioMightMethods(stomachCardiacNotch.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.Antrum))
		{
			Antrum antrum = (Antrum) bioMightInstance;
			bioMightComponent.setImage(antrum.getImage());
			bioMightComponent.setWidth(antrum.getImageWidth());
			bioMightComponent.setHeight(antrum.getImageHeight());
			//bioMightComponent.setBioMightProperties(antrum.getProperties());
			//bioMightComponent.setBioMightMethods(antrum.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.Pylorus))
		{
			Pylorus pylorus = (Pylorus) bioMightInstance;
			bioMightComponent.setImage(pylorus.getImage());
			bioMightComponent.setWidth(pylorus.getImageWidth());
			bioMightComponent.setHeight(pylorus.getImageHeight());
			//bioMightComponent.setBioMightProperties(pylorus.getProperties());
			//bioMightComponent.setBioMightMethods(pylorus.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.StomachLesserCurvature))
		{
			LesserCurvature lesserCurvature = (LesserCurvature) bioMightInstance;
			bioMightComponent.setImage(lesserCurvature.getImage());
			bioMightComponent.setWidth(lesserCurvature.getImageWidth());
			bioMightComponent.setHeight(lesserCurvature.getImageHeight());
			//bioMightComponent.setBioMightProperties(lesserCurvature.getProperties());
			//bioMightComponent.setBioMightMethods(lesserCurvature.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.StomachGreaterCurvature))
		{
			GreaterCurvature greaterCurvature = (GreaterCurvature) bioMightInstance;
			bioMightComponent.setImage(greaterCurvature.getImage());
			bioMightComponent.setWidth(greaterCurvature.getImageWidth());
			bioMightComponent.setHeight(greaterCurvature.getImageHeight());
			//bioMightComponent.setBioMightProperties(greaterCurvature.getProperties());
			//bioMightComponent.setBioMightMethods(greaterCurvature.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LowerEsophagealSphincter))
		{
			LowerEsophagealSphincter lowerEsophagealSphincter = (LowerEsophagealSphincter) bioMightInstance;
			bioMightComponent.setImage(lowerEsophagealSphincter.getImage());
			bioMightComponent.setWidth(lowerEsophagealSphincter.getImageWidth());
			bioMightComponent.setHeight(lowerEsophagealSphincter.getImageHeight());
			//bioMightComponent.setBioMightProperties(lowerEsophagealSphincter.getProperties());
			//bioMightComponent.setBioMightMethods(lowerEsophagealSphincter.getMethods());
		}
		
		
		/**************************************************************************
		*
		* LIVER
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.Liver))
		{
			Liver liver = (Liver) bioMightInstance;
			bioMightComponent.setImage(liver.getImage());
			bioMightComponent.setWidth(liver.getImageWidth());
			bioMightComponent.setHeight(liver.getImageHeight());
			bioMightComponent.setBioMightProperties(liver.getProperties());
			bioMightComponent.setBioMightMethods(liver.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Liver: "  + bioMightComponent +  "     ID: " + liver.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(liver.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	liver.executeMethods(methodParams);
			//	liver.redraw(0);
			//}
			System.out.println("Getting X3D for Liver!");
			bioMightComponent.setX3D(liver.getX3D(snippet));	
		}	
		else if (bioMightComponentRef.equals(Constants.LiverLeftLateralLobe))
		{
			LiverLeftLateralLobe leftLateralLobe = (LiverLeftLateralLobe) bioMightInstance;
			bioMightComponent.setImage(leftLateralLobe.getImage());
			bioMightComponent.setWidth(leftLateralLobe.getImageWidth());
			bioMightComponent.setHeight(leftLateralLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLateralLobe.getProperties());
			//bioMightComponent.setBioMightMethods(leftLateralLobe.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LiverRightMedialLobe))
		{
			LiverRightMedialLobe liverRightMedialLobe = (LiverRightMedialLobe) bioMightInstance;
			bioMightComponent.setImage(liverRightMedialLobe.getImage());
			bioMightComponent.setWidth(liverRightMedialLobe.getImageWidth());
			bioMightComponent.setHeight(liverRightMedialLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(liverRightMedialLobe.getProperties());
			//bioMightComponent.setBioMightMethods(liverRightMedialLobe.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LiverRightLateralLobe))
		{
			LiverRightLateralLobe liverRightLateralLobe = (LiverRightLateralLobe) bioMightInstance;
			bioMightComponent.setImage(liverRightLateralLobe.getImage());
			bioMightComponent.setWidth(liverRightLateralLobe.getImageWidth());
			bioMightComponent.setHeight(liverRightLateralLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(liverRightLateralLobe.getProperties());
			//bioMightComponent.setBioMightMethods(liverRightLateralLobe.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LiverQuadrateLobe))
		{
			LiverQuadrateLobe liverQuadrateLobe = (LiverQuadrateLobe) bioMightInstance;
			bioMightComponent.setImage(liverQuadrateLobe.getImage());
			bioMightComponent.setWidth(liverQuadrateLobe.getImageWidth());
			bioMightComponent.setHeight(liverQuadrateLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(liverQuadrateLobe.getProperties());
			//bioMightComponent.setBioMightMethods(liverQuadrateLobe.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.CommonBileDuct))
		{
			CommonBileDuct commonBileDuct = (CommonBileDuct) bioMightInstance;
			bioMightComponent.setImage(commonBileDuct.getImage());
			bioMightComponent.setWidth(commonBileDuct.getImageWidth());
			bioMightComponent.setHeight(commonBileDuct.getImageHeight());
			bioMightComponent.setBioMightProperties(commonBileDuct.getProperties());
			bioMightComponent.setBioMightMethods(commonBileDuct.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CommonBileDuct: "  + bioMightComponent +  "     ID: " + commonBileDuct.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(commonBileDuct.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	commonBileDuct.executeMethods(methodParams);
			//	commonBileDuct.redraw(0);
			//}
			System.out.println("Getting X3D for CommonBileDuct!");
			bioMightComponent.setX3D(commonBileDuct.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.CysticDuct))
		{
			CysticDuct cysticDuct = (CysticDuct) bioMightInstance;
			bioMightComponent.setImage(cysticDuct.getImage());
			bioMightComponent.setWidth(cysticDuct.getImageWidth());
			bioMightComponent.setHeight(cysticDuct.getImageHeight());
			bioMightComponent.setBioMightProperties(cysticDuct.getProperties());
			bioMightComponent.setBioMightMethods(cysticDuct.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CysticDuct: "  + bioMightComponent +  "     ID: " + cysticDuct.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cysticDuct.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	cysticDuct.executeMethods(methodParams);
			//	cysticDuct.redraw(0);
			//}
			System.out.println("Getting X3D for CysticDuct!");
			bioMightComponent.setX3D(cysticDuct.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.HepaticDucts))
		{
			HepaticDucts hepaticDucts = (HepaticDucts) bioMightInstance;
			bioMightComponent.setImage(hepaticDucts.getImage());
			bioMightComponent.setWidth(hepaticDucts.getImageWidth());
			bioMightComponent.setHeight(hepaticDucts.getImageHeight());
			bioMightComponent.setBioMightProperties(hepaticDucts.getProperties());
			bioMightComponent.setBioMightMethods(hepaticDucts.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HepaticDucts: "  + bioMightComponent +  "     ID: " + hepaticDucts.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hepaticDucts.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	hepaticDuct.executeMethods(methodParams);
			//	hepaticDuct.redraw(0);
			//}
			System.out.println("Getting X3D for HepaticDuct!");
			bioMightComponent.setX3D(hepaticDucts.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.HepaticDuct))
		{
			HepaticDuct hepaticDuct = (HepaticDuct) bioMightInstance;
			bioMightComponent.setImage(hepaticDuct.getImage());
			bioMightComponent.setWidth(hepaticDuct.getImageWidth());
			bioMightComponent.setHeight(hepaticDuct.getImageHeight());
			bioMightComponent.setBioMightProperties(hepaticDuct.getProperties());
			bioMightComponent.setBioMightMethods(hepaticDuct.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HepaticDuct: "  + bioMightComponent +  "     ID: " + hepaticDuct.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hepaticDuct.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	hepaticDuct.executeMethods(methodParams);
			//	hepaticDuct.redraw(0);
			//}
			System.out.println("Getting X3D for HepaticDuct!");
			bioMightComponent.setX3D(hepaticDuct.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.CommonHepaticDuct))
		{
			CommonHepaticDuct commonHepaticDuct = (CommonHepaticDuct) bioMightInstance;
			bioMightComponent.setImage(commonHepaticDuct.getImage());
			bioMightComponent.setWidth(commonHepaticDuct.getImageWidth());
			bioMightComponent.setHeight(commonHepaticDuct.getImageHeight());
			bioMightComponent.setBioMightProperties(commonHepaticDuct.getProperties());
			bioMightComponent.setBioMightMethods(commonHepaticDuct.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CommonHepaticDuct: "  + bioMightComponent +  "     ID: " + commonHepaticDuct.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(commonHepaticDuct.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	commonHepaticDuct.executeMethods(methodParams);
			//	commonHepaticDuct.redraw(0);
			//}
			System.out.println("Getting X3D for CommonHepaticDuct!");
			bioMightComponent.setX3D(commonHepaticDuct.getX3D(snippet));	
		}

		else if (bioMightComponentRef.equals(Constants.Trachea))
		{
			Trachea trachea = (Trachea) bioMightInstance;
			bioMightComponent.setImage(trachea.getImage());
			bioMightComponent.setWidth(trachea.getImageWidth());
			bioMightComponent.setHeight(trachea.getImageHeight());
			bioMightComponent.setBioMightProperties(trachea.getProperties());
			bioMightComponent.setBioMightMethods(trachea.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Trachea: "  + bioMightComponent +  "     ID: " + trachea.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(trachea.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Trachea Methods!");
			//	trachea.executeMethods(methodParams);
			//	trachea.redraw(0);
			//}
			
			System.out.println("Getting X3D for Trachea!");
			bioMightComponent.setX3D(trachea.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Bronchus))
		{
			Bronchus bronchus = (Bronchus) bioMightInstance;
			bioMightComponent.setImage(bronchus.getImage());
			bioMightComponent.setWidth(bronchus.getImageWidth());
			bioMightComponent.setHeight(bronchus.getImageHeight());
			bioMightComponent.setBioMightProperties(bronchus.getProperties());
			bioMightComponent.setBioMightMethods(bronchus.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Bronchus: "  + bioMightComponent +  "     ID: " + bronchus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bronchus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bronchus Methods!");
			//	bronchus.executeMethods(methodParams);
			//	bronchus.redraw(0);
			//}
			
			System.out.println("Getting X3D for Bronchus!");
			bioMightComponent.setX3D(bronchus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Bronchi))
		{
			Bronchi bronchi = (Bronchi) bioMightInstance;
			bioMightComponent.setImage(bronchi.getImage());
			bioMightComponent.setWidth(bronchi.getImageWidth());
			bioMightComponent.setHeight(bronchi.getImageHeight());
			bioMightComponent.setBioMightProperties(bronchi.getProperties());
			bioMightComponent.setBioMightMethods(bronchi.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Bronchi: "  + bioMightComponent +  "     ID: " + bronchi.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bronchi.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bronchi Methods!");
			//	bronchi.executeMethods(methodParams);
			//	bronchi.redraw(0);
			//}
			
			System.out.println("Getting X3D for Bronchi!");
			bioMightComponent.setX3D(bronchi.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.LobarBronchus))
		{
			LobarBronchus lobarBronchus = (LobarBronchus) bioMightInstance;
			bioMightComponent.setImage(lobarBronchus.getImage());
			bioMightComponent.setWidth(lobarBronchus.getImageWidth());
			bioMightComponent.setHeight(lobarBronchus.getImageHeight());
			bioMightComponent.setBioMightProperties(lobarBronchus.getProperties());
			bioMightComponent.setBioMightMethods(lobarBronchus.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LobarBronchus: "  + bioMightComponent +  "     ID: " + lobarBronchus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lobarBronchus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LobarBronchus Methods!");
			//	lobarBronchus.executeMethods(methodParams);
			//	lobarBronchus.redraw(0);
			//}
			
			System.out.println("Getting X3D for LobarBronchus!");
			bioMightComponent.setX3D(lobarBronchus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.LobarBronchi))
		{
			LobarBronchi lobarBronchi = (LobarBronchi) bioMightInstance;
			bioMightComponent.setImage(lobarBronchi.getImage());
			bioMightComponent.setWidth(lobarBronchi.getImageWidth());
			bioMightComponent.setHeight(lobarBronchi.getImageHeight());
			bioMightComponent.setBioMightProperties(lobarBronchi.getProperties());
			bioMightComponent.setBioMightMethods(lobarBronchi.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LobarBronchi: "  + bioMightComponent +  "     ID: " + lobarBronchi.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lobarBronchi.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LobarBronchi Methods!");
			//	lobarBronchi.executeMethods(methodParams);
			//	lobarBronchi.redraw(0);
			//}
			
			System.out.println("Getting X3D for LobarBronchi!");
			bioMightComponent.setX3D(lobarBronchi.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SegmentalinicBronchi))
		{
			SegmentalinicBronchi segmentalinicBronchi = (SegmentalinicBronchi) bioMightInstance;
			bioMightComponent.setImage(segmentalinicBronchi.getImage());
			bioMightComponent.setWidth(segmentalinicBronchi.getImageWidth());
			bioMightComponent.setHeight(segmentalinicBronchi.getImageHeight());
			bioMightComponent.setBioMightProperties(segmentalinicBronchi.getProperties());
			bioMightComponent.setBioMightMethods(segmentalinicBronchi.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SegmentalinicBronchi: "  + bioMightComponent +  "     ID: " + segmentalinicBronchi.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(segmentalinicBronchi.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SegmentalinicBronchi Methods!");
			//	segmentalinicBronchi.executeMethods(methodParams);
			//	segmentalinicBronchi.redraw(0);
			//}
			
			System.out.println("Getting X3D for SegmentalinicBronchi!");
			bioMightComponent.setX3D(segmentalinicBronchi.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SegmentalinicBronchus))
		{
			SegmentalinicBronchus segmentalinicBronchus = (SegmentalinicBronchus) bioMightInstance;
			bioMightComponent.setImage(segmentalinicBronchus.getImage());
			bioMightComponent.setWidth(segmentalinicBronchus.getImageWidth());
			bioMightComponent.setHeight(segmentalinicBronchus.getImageHeight());
			bioMightComponent.setBioMightProperties(segmentalinicBronchus.getProperties());
			bioMightComponent.setBioMightMethods(segmentalinicBronchus.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SegmentalinicBronchus: "  + bioMightComponent +  "     ID: " + segmentalinicBronchus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(segmentalinicBronchus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SegmentalinicBronchus Methods!");
			//	segmentalinicBronchus.executeMethods(methodParams);
			//	segmentalinicBronchus.redraw(0);
			//}
			
			System.out.println("Getting X3D for SegmentalinicBronchus!");
			bioMightComponent.setX3D(segmentalinicBronchus.getX3D(snippet));
		}
	
	
		/**************************************************************************
		*
		* LUNGS
		*  
		***************************************************************************/			
		
		else if (bioMightComponentRef.equals(Constants.Lungs))
		{
			Lungs lungs = (Lungs) bioMightInstance;
			bioMightComponent.setImage(lungs.getImage());
			bioMightComponent.setWidth(lungs.getImageWidth());
			bioMightComponent.setHeight(lungs.getImageHeight());
			bioMightComponent.setBioMightProperties(lungs.getProperties());
			bioMightComponent.setBioMightMethods(lungs.getMethods());				
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Lungs: "  + bioMightComponent +  "     ID: " + lungs.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lungs.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	lungs.executeMethods(methodParams);
			//	lungs.redraw(0);
			//}
			System.out.println("Getting X3D for Lungs!");
			bioMightComponent.setX3D(lungs.getX3D(snippet));	
		}		
		else if (bioMightComponentRef.equals(Constants.Lung))
		{
			Lung lung = (Lung) bioMightInstance;
			bioMightComponent.setImage(lung.getImage());
			bioMightComponent.setWidth(lung.getImageWidth());
			bioMightComponent.setHeight(lung.getImageHeight());
			bioMightComponent.setBioMightProperties(lung.getProperties());
			bioMightComponent.setBioMightMethods(lung.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Lung: "  + bioMightComponent +  "     ID: " + lung.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lung.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	lung.executeMethods(methodParams);
			//	lung.redraw(0);
			//}
			System.out.println("Getting X3D for Lung!");
			bioMightComponent.setX3D(lung.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.LungApexPulmonis))
		{
			LungApexPulmonis leftLungApexPulmonis = (LungApexPulmonis) bioMightInstance;
			bioMightComponent.setImage(leftLungApexPulmonis.getImage());
			bioMightComponent.setWidth(leftLungApexPulmonis.getImageWidth());
			bioMightComponent.setHeight(leftLungApexPulmonis.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungApexPulmonis.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungApexPulmonis.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LungBasisPulmonis))
		{
			LungBasisPulmonis leftLungBasisPulmonis = (LungBasisPulmonis) bioMightInstance;
			bioMightComponent.setImage(leftLungBasisPulmonis.getImage());
			bioMightComponent.setWidth(leftLungBasisPulmonis.getImageWidth());
			bioMightComponent.setHeight(leftLungBasisPulmonis.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungBasisPulmonis.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungBasisPulmonis.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.LungHilum))
		{
			LungBasisPulmonis leftLungBasisPulmonis = (LungBasisPulmonis) bioMightInstance;
			bioMightComponent.setImage(leftLungBasisPulmonis.getImage());
			bioMightComponent.setWidth(leftLungBasisPulmonis.getImageWidth());
			bioMightComponent.setHeight(leftLungBasisPulmonis.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungBasisPulmonis.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungBasisPulmonis.getMethods());
		}
		
		// LOBES
		else if (bioMightComponentRef.equals(Constants.LungSuperiorLobe))
		{
			LungSuperiorLobe leftLungSuperiorLobe = (LungSuperiorLobe) bioMightInstance;
			bioMightComponent.setImage(leftLungSuperiorLobe.getImage());
			bioMightComponent.setWidth(leftLungSuperiorLobe.getImageWidth());
			bioMightComponent.setHeight(leftLungSuperiorLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungSuperiorLobe.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungSuperiorLobe.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LungInferiorLobe))
		{
			LungInferiorLobe leftLungInferiorLobe = (LungInferiorLobe) bioMightInstance;
			bioMightComponent.setImage(leftLungInferiorLobe.getImage());
			bioMightComponent.setWidth(leftLungInferiorLobe.getImageWidth());
			bioMightComponent.setHeight(leftLungInferiorLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungSuperiorLobe.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungSuperiorLobe.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LungMiddleLobe))
		{
			LungMiddleLobe rightLungMiddleLobe = (LungMiddleLobe) bioMightInstance;
			bioMightComponent.setImage(rightLungMiddleLobe.getImage());
			bioMightComponent.setWidth(rightLungMiddleLobe.getImageWidth());
			bioMightComponent.setHeight(rightLungMiddleLobe.getImageHeight());
			//bioMightComponent.setBioMightProperties(rightLungMiddleLobe.getProperties());
			//bioMightComponent.setBioMightMethods(rightLungMiddleLobe.getMethods());
		}
		// SURFACES
		else if (bioMightComponentRef.equals(Constants.LungCostalSurface))
		{
			LungCostalSurface lungCostalSurface = (LungCostalSurface) bioMightInstance;
			bioMightComponent.setImage(lungCostalSurface.getImage());
			bioMightComponent.setWidth(lungCostalSurface.getImageWidth());
			bioMightComponent.setHeight(lungCostalSurface.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungCostalSurface.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungCostalSurface.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LungMediastinalSurface))
		{
			LungMediastinalSurface lungMediastinalSurface = (LungMediastinalSurface) bioMightInstance;
			bioMightComponent.setImage(lungMediastinalSurface.getImage());
			bioMightComponent.setWidth(lungMediastinalSurface.getImageWidth());
			bioMightComponent.setHeight(lungMediastinalSurface.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungMediastinalSurface.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungMediastinalSurface.getMethods());
		}			
		// BORDERS
		else if (bioMightComponentRef.equals(Constants.LungAnteriorBorder))
		{
			LungAnteriorBorder lungAnteriorBorder = (LungAnteriorBorder) bioMightInstance;
			bioMightComponent.setImage(lungAnteriorBorder.getImage());
			bioMightComponent.setWidth(lungAnteriorBorder.getImageWidth());
			bioMightComponent.setHeight(lungAnteriorBorder.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftLungAnteriorBorder.getProperties());
			//bioMightComponent.setBioMightMethods(leftLungAnteriorBorder.getMethods());
		}	
		
		/**************************************************************************
		*
		* KIDNEYS
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.Kidneys))
		{
			Kidneys kidneys = (Kidneys) bioMightInstance;
			bioMightComponent.setImage(kidneys.getImage());
			bioMightComponent.setWidth(kidneys.getImageWidth());
			bioMightComponent.setHeight(kidneys.getImageHeight());	
			bioMightComponent.setBioMightProperties(kidneys.getProperties());
			bioMightComponent.setBioMightMethods(kidneys.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Kidneys: "  + bioMightComponent +  "     ID: " + kidneys.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(kidneys.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	kidneys.executeMethods(methodParams);
			//	kidneys.redraw(0);
			//}
			System.out.println("Getting X3D for Kidneys!");
			bioMightComponent.setX3D(kidneys.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.Kidney))
		{
			Kidney kidney = (Kidney) bioMightInstance;
			bioMightComponent.setImage(kidney.getImage());
			bioMightComponent.setWidth(kidney.getImageWidth());
			bioMightComponent.setHeight(kidney.getImageHeight());	
			bioMightComponent.setBioMightProperties(kidney.getProperties());
			bioMightComponent.setBioMightMethods(kidney.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Kidneys: "  + bioMightComponent +  "     ID: " + kidney.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(kidney.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	kidneys.executeMethods(methodParams);
			//	kidneys.redraw(0);
			//}
			System.out.println("Getting X3D for Kidney!");
			bioMightComponent.setX3D(kidney.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.Calyces))
		{
			Calyces calyces = (Calyces) bioMightInstance;
			bioMightComponent.setImage(calyces.getImage());
			bioMightComponent.setWidth(calyces.getImageWidth());
			bioMightComponent.setHeight(calyces.getImageHeight());	
			//bioMightComponent.setBioMightProperties(calyces.getProperties());
			//bioMightComponent.setBioMightMethods(calyces.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.KidneyVisceralEpithelium))
		{
			KidneyVisceralEpithelium kidneyVisceralEpithelium = (KidneyVisceralEpithelium) bioMightInstance;
			bioMightComponent.setImage(kidneyVisceralEpithelium.getImage());
			bioMightComponent.setWidth(kidneyVisceralEpithelium.getImageWidth());
			bioMightComponent.setHeight(kidneyVisceralEpithelium.getImageHeight());	
			//bioMightComponent.setBioMightProperties(kidneyVisceralEpithelium.getProperties());
			//bioMightComponent.setBioMightMethods(kidneyVisceralEpithelium.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RenalSinus))
		{
			RenalSinus renalSinus = (RenalSinus) bioMightInstance;
			bioMightComponent.setImage(renalSinus.getImage());
			bioMightComponent.setWidth(renalSinus.getImageWidth());
			bioMightComponent.setHeight(renalSinus.getImageHeight());	
			//bioMightComponent.setBioMightProperties(renalSinus.getProperties());
			//bioMightComponent.setBioMightMethods(renalSinus.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.RenalPelvis))
		{
			RenalPelvis renalPelvis = (RenalPelvis) bioMightInstance;
			bioMightComponent.setImage(renalPelvis.getImage());
			bioMightComponent.setWidth(renalPelvis.getImageWidth());
			bioMightComponent.setHeight(renalPelvis.getImageHeight());	
			//bioMightComponent.setBioMightProperties(renalPelvis.getProperties());
			//bioMightComponent.setBioMightMethods(renalPelvis.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.MaculaDensa))
		{
			MaculaDensa maculaDensa = (MaculaDensa) bioMightInstance;
			bioMightComponent.setImage(maculaDensa.getImage());
			bioMightComponent.setWidth(maculaDensa.getImageWidth());
			bioMightComponent.setHeight(maculaDensa.getImageHeight());	
			//bioMightComponent.setBioMightProperties(maculaDensa.getProperties());
			//bioMightComponent.setBioMightMethods(maculaDensa.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RenalPapilla))
		{
			RenalPapilla renalPapilla = (RenalPapilla) bioMightInstance;
			bioMightComponent.setImage(renalPapilla.getImage());
			bioMightComponent.setWidth(renalPapilla.getImageWidth());
			bioMightComponent.setHeight(renalPapilla.getImageHeight());	
			//bioMightComponent.setBioMightProperties(renalPapilla.getProperties());
			//bioMightComponent.setBioMightMethods(renalPapilla.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RenalPapilla))
		{
			RenalPapilla renalPapilla = (RenalPapilla) bioMightInstance;
			bioMightComponent.setImage(renalPapilla.getImage());
			bioMightComponent.setWidth(renalPapilla.getImageWidth());
			bioMightComponent.setHeight(renalPapilla.getImageHeight());	
			//bioMightComponent.setBioMightProperties(renalPapilla.getProperties());
			//bioMightComponent.setBioMightMethods(renalPapilla.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.RenalFibrousCapsule))
		{
			RenalFibrousCapsule renalFibrousCapsule = (RenalFibrousCapsule) bioMightInstance;
			bioMightComponent.setImage(renalFibrousCapsule.getImage());
			bioMightComponent.setWidth(renalFibrousCapsule.getImageWidth());
			bioMightComponent.setHeight(renalFibrousCapsule.getImageHeight());	
			//bioMightComponent.setBioMightProperties(renalFibrousCapsule.getProperties());
			//bioMightComponent.setBioMightMethods(renalFibrousCapsule.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.AdrenalGlands))
		{
			AdrenalGlands adrenalGlands = (AdrenalGlands) bioMightInstance;
			bioMightComponent.setImage(adrenalGlands.getImage());
			bioMightComponent.setWidth(adrenalGlands.getImageWidth());
			bioMightComponent.setHeight(adrenalGlands.getImageHeight());	
			bioMightComponent.setBioMightProperties(adrenalGlands.getProperties());
			bioMightComponent.setBioMightMethods(adrenalGlands.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdrenalGlands: "  + bioMightComponent +  "     ID: " + adrenalGlands.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adrenalGlands.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	adrenalGlands.executeMethods(methodParams);
			//	adrenalGlands.redraw(0);
			//}
			System.out.println("Getting X3D for AdrenalGlands!");
			bioMightComponent.setX3D(adrenalGlands.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.AdrenalGland))
		{
			AdrenalGland adrenalGland = (AdrenalGland) bioMightInstance;
			bioMightComponent.setImage(adrenalGland.getImage());
			bioMightComponent.setWidth(adrenalGland.getImageWidth());
			bioMightComponent.setHeight(adrenalGland.getImageHeight());	
			bioMightComponent.setBioMightProperties(adrenalGland.getProperties());
			bioMightComponent.setBioMightMethods(adrenalGland.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdrenalGlands: "  + bioMightComponent +  "     ID: " + adrenalGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adrenalGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	adrenalGlands.executeMethods(methodParams);
			//	adrenalGlands.redraw(0);
			//}
			System.out.println("Getting X3D for AdrenalGland!");
			bioMightComponent.setX3D(adrenalGland.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.PituitaryGland))
		{
			PituitaryGland pituitaryGland = (PituitaryGland) bioMightInstance;
			bioMightComponent.setImage(pituitaryGland.getImage());
			bioMightComponent.setWidth(pituitaryGland.getImageWidth());
			bioMightComponent.setHeight(pituitaryGland.getImageHeight());	
			bioMightComponent.setBioMightProperties(pituitaryGland.getProperties());
			bioMightComponent.setBioMightMethods(pituitaryGland.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PituitaryGlands: "  + bioMightComponent +  "     ID: " + pituitaryGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pituitaryGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	pituitaryGlands.executeMethods(methodParams);
			//	pituitaryGlands.redraw(0);
			//}
			System.out.println("Getting X3D for PituitaryGland!");
			bioMightComponent.setX3D(pituitaryGland.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.PinealGland))
		{
			PinealGland pinealGland = (PinealGland) bioMightInstance;
			bioMightComponent.setImage(pinealGland.getImage());
			bioMightComponent.setWidth(pinealGland.getImageWidth());
			bioMightComponent.setHeight(pinealGland.getImageHeight());	
			bioMightComponent.setBioMightProperties(pinealGland.getProperties());
			bioMightComponent.setBioMightMethods(pinealGland.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PinealGlands: "  + bioMightComponent +  "     ID: " + pinealGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pinealGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	pinealGlands.executeMethods(methodParams);
			//	pinealGlands.redraw(0);
			//}
			System.out.println("Getting X3D for PinealGland!");
			bioMightComponent.setX3D(pinealGland.getX3D(snippet));					
		}
		
		else if (bioMightComponentRef.equals(Constants.ParaThyroidGlands))
		{
			ParaThyroidGlands paraThyroidGlands = (ParaThyroidGlands) bioMightInstance;
			bioMightComponent.setImage(paraThyroidGlands.getImage());
			bioMightComponent.setWidth(paraThyroidGlands.getImageWidth());
			bioMightComponent.setHeight(paraThyroidGlands.getImageHeight());	
			bioMightComponent.setBioMightProperties(paraThyroidGlands.getProperties());
			bioMightComponent.setBioMightMethods(paraThyroidGlands.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ParaThyroidGlands: "  + bioMightComponent +  "     ID: " + paraThyroidGlands.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(paraThyroidGlands.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	paraThyroidGlands.executeMethods(methodParams);
			//	paraThyroidGlands.redraw(0);
			//}
			System.out.println("Getting X3D for ParaThyroidGlands!");
			bioMightComponent.setX3D(paraThyroidGlands.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.ParaThyroidGland))
		{
			ParaThyroidGland paraThyroidGland = (ParaThyroidGland) bioMightInstance;
			bioMightComponent.setImage(paraThyroidGland.getImage());
			bioMightComponent.setWidth(paraThyroidGland.getImageWidth());
			bioMightComponent.setHeight(paraThyroidGland.getImageHeight());	
			bioMightComponent.setBioMightProperties(paraThyroidGland.getProperties());
			bioMightComponent.setBioMightMethods(paraThyroidGland.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ParaThyroidGlands: "  + bioMightComponent +  "     ID: " + paraThyroidGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(paraThyroidGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	paraThyroidGlands.executeMethods(methodParams);
			//	paraThyroidGlands.redraw(0);
			//}
			System.out.println("Getting X3D for ParaThyroidGland!");
			bioMightComponent.setX3D(paraThyroidGland.getX3D(snippet));					
		}
		else if (bioMightComponentRef.equals(Constants.Thymus))
		{
			Thymus thymus = (Thymus) bioMightInstance;
			bioMightComponent.setImage(thymus.getImage());
			bioMightComponent.setWidth(thymus.getImageWidth());
			bioMightComponent.setHeight(thymus.getImageHeight());	
			bioMightComponent.setBioMightProperties(thymus.getProperties());
			bioMightComponent.setBioMightMethods(thymus.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Thymuss: "  + bioMightComponent +  "     ID: " + thymus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thymus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	thymuss.executeMethods(methodParams);
			//	thymuss.redraw(0);
			//}
			System.out.println("Getting X3D for Thymus!");
			bioMightComponent.setX3D(thymus.getX3D(snippet));					
		}
		
		/**************************************************************************
		*
		* INTESTINES
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.Intestines))
		{
			Intestines intestines = (Intestines) bioMightInstance;
			bioMightComponent.setImage(intestines.getImage());
			bioMightComponent.setWidth(intestines.getImageWidth());
			bioMightComponent.setHeight(intestines.getImageHeight());
			bioMightComponent.setBioMightProperties(intestines.getProperties());
			bioMightComponent.setBioMightMethods(intestines.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LargeIntestine))
		{
			LargeIntestine largeIntestine = (LargeIntestine) bioMightInstance;
			bioMightComponent.setImage(largeIntestine.getImage());
			bioMightComponent.setWidth(largeIntestine.getImageWidth());
			bioMightComponent.setHeight(largeIntestine.getImageHeight());
			bioMightComponent.setBioMightProperties(largeIntestine.getProperties());
			bioMightComponent.setBioMightMethods(largeIntestine.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LargeIntestine: "  + bioMightComponent +  "     ID: " + largeIntestine.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(largeIntestine.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LargeIntestine Methods!");
			//	kidneys.executeMethods(methodParams);
			//	largeIntestine.redraw(0);
			//}
			System.out.println("Getting X3D for LargeIntestine!");
			bioMightComponent.setX3D(largeIntestine.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SmallIntestine))
		{
			SmallIntestine smallIntestine = (SmallIntestine) bioMightInstance;
			bioMightComponent.setImage(smallIntestine.getImage());
			bioMightComponent.setWidth(smallIntestine.getImageWidth());
			bioMightComponent.setHeight(smallIntestine.getImageHeight());
			bioMightComponent.setBioMightProperties(smallIntestine.getProperties());
			bioMightComponent.setBioMightMethods(smallIntestine.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for smallIntestine: "  + bioMightComponent +  "     ID: " + smallIntestine.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(smallIntestine.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SmallIntestine Methods!");
			//	smallIntestine.executeMethods(methodParams);
			//	smallIntestine.redraw(0);
			//}
			
			System.out.println("Getting X3D for Small Intestine!");
			bioMightComponent.setX3D(smallIntestine.getX3D(snippet));		
		
		}	
		
		/**************************************************************************
		*
		* PANCREAS
		*  
		***************************************************************************/			

		
		else if (bioMightComponentRef.equals(Constants.Pancreas))
		{
			Pancreas pancreas = (Pancreas) bioMightInstance;
			bioMightComponent.setImage(pancreas.getImage());
			bioMightComponent.setWidth(pancreas.getImageWidth());
			bioMightComponent.setHeight(pancreas.getImageHeight());
			bioMightComponent.setBioMightProperties(pancreas.getProperties());
			bioMightComponent.setBioMightMethods(pancreas.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Pancreas: "  + bioMightComponent +  "     ID: " + pancreas.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pancreas.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Pancreas Methods!");
			//	pancreas.executeMethods(methodParams);
			//	pancreas.redraw(0);
			//}
			
			System.out.println("Getting X3D for Pancreas!");
			bioMightComponent.setX3D(pancreas.getX3D(snippet));
		}			
		else if (bioMightComponentRef.equals(Constants.Pharynx))
		{
			Pharynx pharynx = (Pharynx) bioMightInstance;
			bioMightComponent.setImage(pharynx.getImage());
			bioMightComponent.setWidth(pharynx.getImageWidth());
			bioMightComponent.setHeight(pharynx.getImageHeight());
			bioMightComponent.setBioMightProperties(pharynx.getProperties());
			bioMightComponent.setBioMightMethods(pharynx.getMethods());				
		}			
		else if (bioMightComponentRef.equals(Constants.Esophagus))
		{
			Esophagus esophagus = (Esophagus) bioMightInstance;
			bioMightComponent.setImage(esophagus.getImage());
			bioMightComponent.setWidth(esophagus.getImageWidth());
			bioMightComponent.setHeight(esophagus.getImageHeight());
			bioMightComponent.setBioMightProperties(esophagus.getProperties());
			bioMightComponent.setBioMightMethods(esophagus.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Esophagus: "  + bioMightComponent +  "     ID: " + esophagus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(esophagus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Esophagus Methods!");
			//	esophagus.executeMethods(methodParams);
			//	esophagus.redraw(0);
			//}
			
			System.out.println("Getting X3D for Esophagus!");
			bioMightComponent.setX3D(esophagus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Cardia))
		{
			Cardia cardia = (Cardia) bioMightInstance;
			bioMightComponent.setImage(cardia.getImage());
			bioMightComponent.setWidth(cardia.getImageWidth());
			bioMightComponent.setHeight(cardia.getImageHeight());
		}
		
		/**************************************************************************
		*
		* SPLEEN
		*  
		***************************************************************************/			

		else if (bioMightComponentRef.equals(Constants.Spleen))
		{
			Spleen spleen = (Spleen) bioMightInstance;
			bioMightComponent.setImage(spleen.getImage());
			bioMightComponent.setWidth(spleen.getImageWidth());
			bioMightComponent.setHeight(spleen.getImageHeight());
			bioMightComponent.setBioMightProperties(spleen.getProperties());
			bioMightComponent.setBioMightMethods(spleen.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Spleen: "  + bioMightComponent +  "     ID: " + spleen.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(spleen.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	spleen.executeMethods(methodParams);
			//	spleen.redraw(0);
			//}
			
			System.out.println("Getting X3D for Spleen!");
			bioMightComponent.setX3D(spleen.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SpleenAnteriorBorder))
		{
			SpleenAnteriorBorder spleenAnteriorBorder = (SpleenAnteriorBorder) bioMightInstance;
			bioMightComponent.setImage(spleenAnteriorBorder.getImage());
			bioMightComponent.setWidth(spleenAnteriorBorder.getImageWidth());
			bioMightComponent.setHeight(spleenAnteriorBorder.getImageHeight());
			//bioMightComponent.setBioMightProperties(spleenAnteriorBorder.getProperties());
			//bioMightComponent.setBioMightMethods(spleenAnteriorBorder.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.SpleenPosteriorBorder))
		{
			SpleenPosteriorBorder spleenPosteriorBorder = (SpleenPosteriorBorder) bioMightInstance;
			bioMightComponent.setImage(spleenPosteriorBorder.getImage());
			bioMightComponent.setWidth(spleenPosteriorBorder.getImageWidth());
			bioMightComponent.setHeight(spleenPosteriorBorder.getImageHeight());
			//bioMightComponent.setBioMightProperties(spleenAnteriorBorder.getProperties());
			//bioMightComponent.setBioMightMethods(spleenAnteriorBorder.getMethods());
		}				
		
		/*
		private  spleenPosteriorBorder;
		private SpleenInferiorBorder spleenInferiorBorder;
		private SpleenAreolae spleenAreolae;
		private SpleenExternalSerousCoat externalSerousCoat;
		private SpleenFibroelasticCoat fibroelasticCoat;
		private SpleenGastricSurface spleenGastricSurface;
		private SpleenRenalSurface spleenRenalSurface;
		private MalpighianBodies malpighianBodies;
		private LienalArtery linealArtery;
		private PulpVein pulpVein;
		private TrabecularArtery trabecularArtery;
		private TrabecularVein trabecularVein;
		private GastrolienalLigament gastrolienalLigament;
		private PhrenicolienalLigament phrenicolienalLigament;
		private SplenicPulp splenicPulp;
		private SplenicCord splenicCord;
		private SplenicSinus splenicSinus;
		private LymphaticVessels lymphaticVessels;
		*/
		
		/**************************************************************************
		*
		* THYROID GLAND 
		*  
		***************************************************************************/			


		else if (bioMightComponentRef.equals(Constants.ThyroidGland))
		{
			ThyroidGland thyroidGland = (ThyroidGland) bioMightInstance;
			bioMightComponent.setImage(thyroidGland.getImage());
			bioMightComponent.setWidth(thyroidGland.getImageWidth());
			bioMightComponent.setHeight(thyroidGland.getImageHeight());
			bioMightComponent.setBioMightProperties(thyroidGland.getProperties());
			bioMightComponent.setBioMightMethods(thyroidGland.getMethods());			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ThyroidGland: "  + bioMightComponent +  "     ID: " + thyroidGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thyroidGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	ThyroidGland.executeMethods(methodParams);
			//	ThyroidGland.redraw(0);
			//}
			System.out.println("Getting X3D for ThyroidGland!");
			bioMightComponent.setX3D(thyroidGland.getX3D(snippet));	
		}	

		/**************************************************************************
		*
		* BODY
		* 
		***************************************************************************/

		else if (bioMightComponentRef.equals(Constants.Body))
		{
			Body body = (Body) bioMightInstance;
			bioMightComponent.setImage(body.getImage());
			bioMightComponent.setWidth(body.getImageWidth());
			bioMightComponent.setHeight(body.getImageHeight());
			bioMightComponent.setBioMightMethods(body.getMethods());
			bioMightComponent.setBioMightProperties(body.getProperties());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(body.getComponentID());			
			System.out.println("Storing BodyKey: " + bioMightComponent + "   ID: " + body.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Body");
			bioMightComponent.setX3D(body.getX3D(true));	
		}
		else if (bioMightComponentRef.equals(Constants.Head))
		{
			Head head = (Head) bioMightInstance;
			bioMightComponent.setImage(head.getImage());
			bioMightComponent.setWidth(head.getImageWidth());
			bioMightComponent.setHeight(head.getImageHeight());
			bioMightComponent.setBioMightMethods(head.getMethods());
			bioMightComponent.setBioMightProperties(head.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Head: "  + bioMightComponent +  "     ID: " + head.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(head.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}

			System.out.println("Getting X3D for HEAD!");
			bioMightComponent.setX3D(head.getX3D(snippet));					
		}			
		
		
		else if (bioMightComponentRef.equals(Constants.Brain))
		{
			Brain brain = (Brain) bioMightInstance;
			bioMightComponent.setImage(brain.getImage());
			bioMightComponent.setWidth(brain.getImageWidth());
			bioMightComponent.setHeight(brain.getImageHeight());
			bioMightComponent.setBioMightMethods(brain.getMethods());
			bioMightComponent.setBioMightProperties(brain.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Brain: "  + bioMightComponent +  "     ID: " + brain.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brain.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	brain.executeMethods(methodParams);
			//	brain.redraw(0);
			//}

			bioMightComponent.setX3D(brain.getX3D(snippet));					
		}	
		else if (bioMightComponentRef.equals(Constants.Cerebellum))
		{
			Cerebellum cerebellum = (Cerebellum) bioMightInstance;
			bioMightComponent.setImage(cerebellum.getImage());
			bioMightComponent.setWidth(cerebellum.getImageWidth());
			bioMightComponent.setHeight(cerebellum.getImageHeight());
			bioMightComponent.setBioMightMethods(cerebellum.getMethods());
			bioMightComponent.setBioMightProperties(cerebellum.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Cerebellum: "  + bioMightComponent +  "     ID: " + cerebellum.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cerebellum.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	cerebellum.executeMethods(methodParams);
			//	cerebellum.redraw(0);
			//}

			bioMightComponent.setX3D(cerebellum.getX3D(snippet));					
		}	
		
		else if (bioMightComponentRef.equals(Constants.Neck))
		{
			Neck neck = (Neck) bioMightInstance;
			bioMightComponent.setImage(neck.getImage());
			bioMightComponent.setWidth(neck.getImageWidth());
			bioMightComponent.setHeight(neck.getImageHeight());
			bioMightComponent.setBioMightMethods(neck.getMethods());
			bioMightComponent.setBioMightProperties(neck.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Head: "  + bioMightComponent +  "  ID: " + neck.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(neck.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing NECK Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing NECK!");
				//neck.redraw(0);
			//}
			bioMightComponent.setX3D(neck.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Shoulders))
		{
			Shoulders shoulders = (Shoulders) bioMightInstance;
			bioMightComponent.setImage(shoulders.getImage());
			bioMightComponent.setWidth(shoulders.getImageWidth());
			bioMightComponent.setHeight(shoulders.getImageHeight());
			bioMightComponent.setBioMightMethods(shoulders.getMethods());
			bioMightComponent.setBioMightProperties(shoulders.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Shoulders: "  + bioMightComponent +  "  ID: " + shoulders.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(shoulders.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing NECK Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing NECK!");
				//neck.redraw(0);
			//}
			bioMightComponent.setX3D(shoulders.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Shoulder))
		{
			Shoulder shoulder = (Shoulder) bioMightInstance;
			bioMightComponent.setImage(shoulder.getImage());
			bioMightComponent.setWidth(shoulder.getImageWidth());
			bioMightComponent.setHeight(shoulder.getImageHeight());
			bioMightComponent.setBioMightMethods(shoulder.getMethods());
			bioMightComponent.setBioMightProperties(shoulder.getProperties());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Shoulder: "  + bioMightComponent +  "  ID: " + shoulder.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(shoulder.getComponentID());
			bioMightKeys.setKey(bioMightKey);
		
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing NECK Methods!");
				//shoulder.executeMethods(methodParams);
				//System.out.println("Redrawing NECK!");
				//shoulder.redraw(0);
			//}
			bioMightComponent.setX3D(shoulder.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.RightShoulder))
		{
			RightShoulder rightShoulder = (RightShoulder) bioMightInstance;
			bioMightComponent.setImage(rightShoulder.getImage());
			bioMightComponent.setWidth(rightShoulder.getImageWidth());
			bioMightComponent.setHeight(rightShoulder.getImageHeight());
			bioMightComponent.setBioMightMethods(rightShoulder.getMethods());
			bioMightComponent.setBioMightProperties(rightShoulder.getProperties());
		}
		else if (bioMightComponentRef.equals(Constants.LeftShoulder))
		{
			LeftShoulder leftShoulder = (LeftShoulder) bioMightInstance;
			bioMightComponent.setImage(leftShoulder.getImage());
			bioMightComponent.setWidth(leftShoulder.getImageWidth());
			bioMightComponent.setHeight(leftShoulder.getImageHeight());
			bioMightComponent.setBioMightMethods(leftShoulder.getMethods());
			bioMightComponent.setBioMightProperties(leftShoulder.getProperties());
		}
		else if (bioMightComponentRef.equals(Constants.Arms))
		{
			Arms arms = (Arms) bioMightInstance;
			bioMightComponent.setImage(arms.getImage());
			bioMightComponent.setWidth(arms.getImageWidth());
			bioMightComponent.setHeight(arms.getImageHeight());
			bioMightComponent.setBioMightProperties(arms.getProperties());
			bioMightComponent.setBioMightMethods(arms.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Arms: "  + bioMightComponent +  "     ID: " + arms.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(arms.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ARMS Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}
			bioMightComponent.setX3D(arms.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Arm))
		{
			Arm arm = (Arm) bioMightInstance;
			bioMightComponent.setImage(arm.getImage());
			bioMightComponent.setWidth(arm.getImageWidth());
			bioMightComponent.setHeight(arm.getImageHeight());
			bioMightComponent.setBioMightProperties(arm.getProperties());
			bioMightComponent.setBioMightMethods(arm.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Arm: "  + bioMightComponent +  "     ID: " + arm.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(arm.getComponentID());
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ARM Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}
			bioMightComponent.setX3D(arm.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftArm))
		{
			LeftArm leftArm = (LeftArm) bioMightInstance;
			bioMightComponent.setImage(leftArm.getImage());
			bioMightComponent.setWidth(leftArm.getImageWidth());
			bioMightComponent.setHeight(leftArm.getImageHeight());
			//bioMightComponent.setBioMightProperties(leftArm.getProperties());
			//bioMightComponent.setBioMightMethods(leftArm.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightArm))
		{
			RightArm rightArm = (RightArm) bioMightInstance;
			bioMightComponent.setImage(rightArm.getImage());
			bioMightComponent.setWidth(rightArm.getImageWidth());
			bioMightComponent.setHeight(rightArm.getImageHeight());
			//bioMightComponent.setBioMightProperties(rightArm.getProperties());
			//	bioMightComponent.setBioMightMethods(rightArm.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.ForeArms))
		{
			ForeArms foreArms = (ForeArms) bioMightInstance;
			bioMightComponent.setImage(foreArms.getImage());
			bioMightComponent.setWidth(foreArms.getImageWidth());
			bioMightComponent.setHeight(foreArms.getImageHeight());
			bioMightComponent.setBioMightProperties(foreArms.getProperties());
			bioMightComponent.setBioMightMethods(foreArms.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ForeArms: "  + bioMightComponent +  "     ID: " + foreArms.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(foreArms.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Forearms Methods!");
			//	foreArms.executeMethods(methodParams);
			//	foreArms.redraw(0);
			//}
			bioMightComponent.setX3D(foreArms.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.ForeArm))
		{
			ForeArm foreArm = (ForeArm) bioMightInstance;
			bioMightComponent.setImage(foreArm.getImage());
			bioMightComponent.setWidth(foreArm.getImageWidth());
			bioMightComponent.setHeight(foreArm.getImageHeight());
			bioMightComponent.setBioMightProperties(foreArm.getProperties());
			bioMightComponent.setBioMightMethods(foreArm.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ForeArm: "  + bioMightComponent +  "     ID: " + foreArm.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(foreArm.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Forearms Methods!");
			//	foreArm.executeMethods(methodParams);
			//	foreArm.redraw(0);
			//}
			bioMightComponent.setX3D(foreArm.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftForeArm))
		{
			LeftForeArm leftForeArm = (LeftForeArm) bioMightInstance;
			bioMightComponent.setImage(leftForeArm.getImage());
			//bioMightComponent.setBioMightProperties(leftForeArm.getProperties());
			//bioMightComponent.setBioMightMethods(leftForeArm.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightForeArm))
		{
			RightForeArm rightForeArm = (RightForeArm) bioMightInstance;
			bioMightComponent.setImage(rightForeArm.getImage());
			bioMightComponent.setWidth(rightForeArm.getImageWidth());
			bioMightComponent.setHeight(rightForeArm.getImageHeight());
			//bioMightComponent.setBioMightProperties(rightForeArm.getProperties());
			//bioMightComponent.setBioMightMethods(rightForeArm.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.Elbows))
		{
			Elbows elbows = (Elbows) bioMightInstance;
			bioMightComponent.setImage(elbows.getImage());
			bioMightComponent.setWidth(elbows.getImageWidth());
			bioMightComponent.setHeight(elbows.getImageHeight());
			bioMightComponent.setBioMightProperties(elbows.getProperties());
			bioMightComponent.setBioMightMethods(elbows.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Elbows: "  + bioMightComponent +  "     ID: " + elbows.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(elbows.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Elbows Methods!");
			//	elbows.executeMethods(methodParams);
			//	elbows.redraw(0);
			//}
			bioMightComponent.setX3D(elbows.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Elbow))
		{
			Elbow elbow = (Elbow) bioMightInstance;
			bioMightComponent.setImage(elbow.getImage());
			bioMightComponent.setWidth(elbow.getImageWidth());
			bioMightComponent.setHeight(elbow.getImageHeight());
			bioMightComponent.setBioMightProperties(elbow.getProperties());
			bioMightComponent.setBioMightMethods(elbow.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Elbow: "  + bioMightComponent +  "     ID: " + elbow.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(elbow.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Elbow Methods!");
			//	elbows.executeMethods(methodParams);
			//	elbows.redraw(0);
			//}
			bioMightComponent.setX3D(elbow.getX3D(snippet));								
		}			
		else if (bioMightComponentRef.equals(Constants.RightElbow))
		{
			RightElbow rightElbow = (RightElbow) bioMightInstance;
			bioMightComponent.setImage(rightElbow.getImage());
			bioMightComponent.setWidth(rightElbow.getImageWidth());
			bioMightComponent.setHeight(rightElbow.getImageHeight());
			bioMightComponent.setBioMightProperties(rightElbow.getProperties());
			bioMightComponent.setBioMightMethods(rightElbow.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftElbow))
		{
			LeftElbow leftElbow = (LeftElbow) bioMightInstance;
			bioMightComponent.setImage(leftElbow.getImage());
			bioMightComponent.setWidth(leftElbow.getImageWidth());
			bioMightComponent.setHeight(leftElbow.getImageHeight());
			bioMightComponent.setBioMightProperties(leftElbow.getProperties());
			bioMightComponent.setBioMightMethods(leftElbow.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.Feet))
		{
			Feet feet = (Feet) bioMightInstance;
			bioMightComponent.setImage(feet.getImage());
			bioMightComponent.setWidth(feet.getImageWidth());
			bioMightComponent.setHeight(feet.getImageHeight());
			bioMightComponent.setBioMightProperties(feet.getProperties());
			bioMightComponent.setBioMightMethods(feet.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Feet: "  + bioMightComponent +  "     ID: " +feet.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(feet.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	feet.executeMethods(methodParams);
			//	feet.redraw(0);
			//}
			bioMightComponent.setX3D(feet.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Foot))
		{
			Foot foot = (Foot) bioMightInstance;
			bioMightComponent.setImage(foot.getImage());
			bioMightComponent.setWidth(foot.getImageWidth());
			bioMightComponent.setHeight(foot.getImageHeight());
			bioMightComponent.setBioMightProperties(foot.getProperties());
			bioMightComponent.setBioMightMethods(foot.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for foot: "  + bioMightComponent +  "     ID: " + foot.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(foot.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Foot Methods!");
			//	feet.executeMethods(methodParams);
			//	feet.redraw(0);
			//}
			bioMightComponent.setX3D(foot.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftFoot))
		{
			LeftFoot leftFoot = (LeftFoot) bioMightInstance;
			bioMightComponent.setImage(leftFoot.getImage());
			bioMightComponent.setWidth(leftFoot.getImageWidth());
			bioMightComponent.setHeight(leftFoot.getImageHeight());
			bioMightComponent.setBioMightProperties(leftFoot.getProperties());
			bioMightComponent.setBioMightMethods(leftFoot.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightFoot))
		{
			RightFoot rightFoot = (RightFoot) bioMightInstance;
			bioMightComponent.setImage(rightFoot.getImage());
			bioMightComponent.setWidth(rightFoot.getImageWidth());
			bioMightComponent.setHeight(rightFoot.getImageHeight());
			bioMightComponent.setBioMightProperties(rightFoot.getProperties());
			bioMightComponent.setBioMightMethods(rightFoot.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftButtock))
		{
			LeftButtock leftButtock = (LeftButtock) bioMightInstance;
			bioMightComponent.setImage(leftButtock.getImage());
			bioMightComponent.setWidth(leftButtock.getImageWidth());
			bioMightComponent.setHeight(leftButtock.getImageHeight());
			bioMightComponent.setBioMightProperties(leftButtock.getProperties());
			bioMightComponent.setBioMightMethods(leftButtock.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightButtock))
		{
			RightButtock rightButtock = (RightButtock) bioMightInstance;
			bioMightComponent.setImage(rightButtock.getImage());
			bioMightComponent.setWidth(rightButtock.getImageWidth());
			bioMightComponent.setHeight(rightButtock.getImageHeight());
			bioMightComponent.setBioMightProperties(rightButtock.getProperties());
			bioMightComponent.setBioMightMethods(rightButtock.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.Abdomen))
		{
			Abdomen abdomen = (Abdomen) bioMightInstance;
			bioMightComponent.setWidth(abdomen.getImageWidth());
			bioMightComponent.setHeight(abdomen.getImageHeight());
			bioMightComponent.setImage(abdomen.getImage());
			bioMightComponent.setBioMightProperties(abdomen.getProperties());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Abdomen: "  + bioMightComponent +  "  ID: " + abdomen.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(abdomen.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(abdomen.getX3D(snippet));
		}						
		else if (bioMightComponentRef.equals(Constants.Waist))
		{
			Waist waist = (Waist) bioMightInstance;
			bioMightComponent.setImage(waist.getImage());
			bioMightComponent.setWidth(waist.getImageWidth());
			bioMightComponent.setHeight(waist.getImageHeight());
			bioMightComponent.setBioMightMethods(waist.getMethods());
			bioMightComponent.setBioMightProperties(waist.getProperties());
			bioMightComponent.setBioMightMethods(waist.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.Torso))
		{
			Torso torso = (Torso) bioMightInstance;
			bioMightComponent.setImage(torso.getImage());
			bioMightComponent.setWidth(torso.getImageWidth());
			bioMightComponent.setHeight(torso.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Chest))
		{
			Chest chest = (Chest) bioMightInstance;
			bioMightComponent.setImage(chest.getImage());
			bioMightComponent.setWidth(chest.getImageWidth());
			bioMightComponent.setHeight(chest.getImageHeight());
			bioMightComponent.setBioMightProperties(chest.getProperties());
			bioMightComponent.setBioMightMethods(chest.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Chest: "  + bioMightComponent +  "  ID: " + chest.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(chest.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing CHEST Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing CHEST!");
				//neck.redraw(0);
			}
			bioMightComponent.setX3D(chest.getX3D(snippet));
			
		}
		else if (bioMightComponentRef.equals(Constants.Nipples))
		{
			Nipples nipples = (Nipples) bioMightInstance;
			bioMightComponent.setImage(nipples.getImage());
			bioMightComponent.setWidth(nipples.getImageWidth());
			bioMightComponent.setHeight(nipples.getImageHeight());			
			bioMightComponent.setBioMightProperties(nipples.getProperties());
			bioMightComponent.setBioMightMethods(nipples.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftNipple))
		{
			LeftNipple leftNipple = (LeftNipple) bioMightInstance;
			bioMightComponent.setImage(leftNipple.getImage());
			bioMightComponent.setWidth(leftNipple.getImageWidth());
			bioMightComponent.setHeight(leftNipple.getImageHeight());			
		}
		else if (bioMightComponentRef.equals(Constants.RightNipple))
		{
			RightNipple rightNipple = (RightNipple) bioMightInstance;
			bioMightComponent.setImage(rightNipple.getImage());
			bioMightComponent.setWidth(rightNipple.getImageWidth());
			bioMightComponent.setHeight(rightNipple.getImageHeight());			
		}			
		else if (bioMightComponentRef.equals(Constants.Back))
		{
			Back back = (Back) bioMightInstance;
			bioMightComponent.setImage(back.getImage());
			bioMightComponent.setWidth(back.getImageWidth());
			bioMightComponent.setHeight(back.getImageHeight());
			bioMightComponent.setBioMightProperties(back.getProperties());
			bioMightComponent.setBioMightMethods(back.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Back: "  + bioMightComponent +  "  ID: " + back.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(back.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(back.getX3D(snippet));			
		}
		/*
		else if (bioMightComponentRef.equals(Constants.LeftLeg))
		{
			LeftLeg leftLeg = (LeftLeg) bioMightInstance;
			bioMightComponent.setImage(leftLeg.getImage());
			bioMightComponent.setWidth(leftLeg.getImageWidth());
			bioMightComponent.setHeight(leftLeg.getImageHeight());				
			bioMightComponent.setBioMightProperties(leftLeg.getProperties());
			bioMightComponent.setBioMightMethods(leftLeg.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightLeg))
		{
			RightLeg rightLeg = (RightLeg) bioMightInstance;
			bioMightComponent.setImage(rightLeg.getImage());
			bioMightComponent.setWidth(rightLeg.getImageWidth());
			bioMightComponent.setHeight(rightLeg.getImageHeight());
			bioMightComponent.setBioMightProperties(rightLeg.getProperties());
			bioMightComponent.setBioMightMethods(rightLeg.getMethods());
		}
		*/
		else if (bioMightComponentRef.equals(Constants.Thighs))
		{
			Thighs thighs = (Thighs) bioMightInstance;
			bioMightComponent.setImage(thighs.getImage());
			bioMightComponent.setWidth(thighs.getImageWidth());
			bioMightComponent.setHeight(thighs.getImageHeight());
			bioMightComponent.setBioMightProperties(thighs.getProperties());
			bioMightComponent.setBioMightMethods(thighs.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Thighs: "  + bioMightComponent +  "     ID: " +thighs.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			//bioMightKey.setComponentID(thighs.getComponentID());
			// This is an aggregation relationship, so we store the same parent
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Thighs Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}
			bioMightComponent.setX3D(thighs.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Thigh))
		{
			Thigh thigh = (Thigh) bioMightInstance;
			bioMightComponent.setImage(thigh.getImage());
			bioMightComponent.setWidth(thigh.getImageWidth());
			bioMightComponent.setHeight(thigh.getImageHeight());
			bioMightComponent.setBioMightProperties(thigh.getProperties());
			bioMightComponent.setBioMightMethods(thigh.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Thigh: "  + bioMightComponent +  "     ID: " +thigh.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			//bioMightKey.setComponentID(thighs.getComponentID());
			// This is an aggregation relationship, so we store the same parent
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(true);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Thighs Methods!");
			//	thigh.executeMethods(methodParams);
			//	thigh.redraw(0);
			//}
			bioMightComponent.setX3D(thigh.getX3D(snippet));								
		}		
		else if (bioMightComponentRef.equals(Constants.RightThigh))
		{
			Thigh rightThigh = (RightThigh) bioMightInstance;
			bioMightComponent.setImage(rightThigh.getImage());
			bioMightComponent.setWidth(rightThigh.getImageWidth());
			bioMightComponent.setHeight(rightThigh.getImageHeight());
			bioMightComponent.setBioMightProperties(rightThigh.getProperties());
			bioMightComponent.setBioMightMethods(rightThigh.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftThigh))
		{
			LeftThigh leftThigh = (LeftThigh) bioMightInstance;
			bioMightComponent.setImage(leftThigh.getImage());
			bioMightComponent.setWidth(leftThigh.getImageWidth());
			bioMightComponent.setHeight(leftThigh.getImageHeight());
			bioMightComponent.setBioMightProperties(leftThigh.getProperties());
			bioMightComponent.setBioMightMethods(leftThigh.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.Knees))
		{
			Knees knees = (Knees) bioMightInstance;
			bioMightComponent.setImage(knees.getImage());
			bioMightComponent.setWidth(knees.getImageWidth());
			bioMightComponent.setHeight(knees.getImageHeight());
			bioMightComponent.setBioMightProperties(knees.getProperties());
			bioMightComponent.setBioMightMethods(knees.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Knees: "  + bioMightComponent +  "     ID: " +knees.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(knees.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Knees Methods!");
			//	hips.executeMethods(methodParams);
			//	hips.redraw(0);
			//}
			bioMightComponent.setX3D(knees.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Knee))
		{
			Knee knee = (Knee) bioMightInstance;
			bioMightComponent.setImage(knee.getImage());
			bioMightComponent.setWidth(knee.getImageWidth());
			bioMightComponent.setHeight(knee.getImageHeight());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Knee: "  + bioMightComponent +  "     ID: " +knee.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(knee.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Knee Methods!");
			//	knee.executeMethods(methodParams);
			//	knee.redraw(0);
			//}
			bioMightComponent.setX3D(knee.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Cnemes))
		{
			Cnemes cnemes = (Cnemes) bioMightInstance;
			bioMightComponent.setImage(cnemes.getImage());
			bioMightComponent.setWidth(cnemes.getImageWidth());
			bioMightComponent.setHeight(cnemes.getImageHeight());
			bioMightComponent.setBioMightProperties(cnemes.getProperties());
			bioMightComponent.setBioMightMethods(cnemes.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Cnemes: "  + bioMightComponent +  "     ID: " + cnemes.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cnemes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Cnemis Methods!");
			//	hips.executeMethods(methodParams);
			//	hips.redraw(0);
			//}
			bioMightComponent.setX3D(cnemes.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Cnemis))
		{
			Cnemis cnemis = (Cnemis) bioMightInstance;
			bioMightComponent.setImage(cnemis.getImage());
			bioMightComponent.setWidth(cnemis.getImageWidth());
			bioMightComponent.setHeight(cnemis.getImageHeight());
			bioMightComponent.setBioMightProperties(cnemis.getProperties());
			bioMightComponent.setBioMightMethods(cnemis.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Cnemis: "  + bioMightComponent +  "     ID: " + cnemis.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cnemis.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Knees Methods!");
			//	cnemis.executeMethods(methodParams);
			//	cnemis.redraw(0);
			//}
			bioMightComponent.setX3D(cnemis.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.RightCnemis))
		{
			Cnemis rightCnemis = (Cnemis) bioMightInstance;
			bioMightComponent.setImage(rightCnemis.getImage());
			bioMightComponent.setWidth(rightCnemis.getImageWidth());
			bioMightComponent.setHeight(rightCnemis.getImageHeight());
			bioMightComponent.setBioMightProperties(rightCnemis.getProperties());
			bioMightComponent.setBioMightMethods(rightCnemis.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftCnemis))
		{
			Cnemis leftCnemis = (Cnemis) bioMightInstance;
			bioMightComponent.setImage(leftCnemis.getImage());
			bioMightComponent.setWidth(leftCnemis.getImageWidth());
			bioMightComponent.setHeight(leftCnemis.getImageHeight());
			bioMightComponent.setBioMightProperties(leftCnemis.getProperties());
			bioMightComponent.setBioMightMethods(leftCnemis.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.Calf))
		{
			Calf calf = (Calf) bioMightInstance;
			bioMightComponent.setImage(calf.getImage());
			bioMightComponent.setWidth(calf.getImageWidth());
			bioMightComponent.setHeight(calf.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RightCalf))
		{
			Calf rightCalf = (Calf) bioMightInstance;
			bioMightComponent.setImage(rightCalf.getImage());
			bioMightComponent.setWidth(rightCalf.getImageWidth());
			bioMightComponent.setHeight(rightCalf.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LeftCalf))
		{
			Calf leftCalf = (Calf) bioMightInstance;
			bioMightComponent.setImage(leftCalf.getImage());
			bioMightComponent.setWidth(leftCalf.getImageWidth());
			bioMightComponent.setHeight(leftCalf.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Ankle))
		{
			Ankle ankle = (Ankle) bioMightInstance;
			bioMightComponent.setImage(ankle.getImage());
			bioMightComponent.setWidth(ankle.getImageWidth());
			bioMightComponent.setHeight(ankle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Mouth))
		{
			Mouth mouth = (Mouth) bioMightInstance;
			bioMightComponent.setImage(mouth.getImage());
			bioMightComponent.setBioMightProperties(mouth.getProperties());
			bioMightComponent.setBioMightMethods(mouth.getMethods());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(mouth.getComponentID());			
			System.out.println("Storing mouthKey: " + bioMightComponent + "   ID: " + mouth.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Mouth");
			bioMightComponent.setX3D(mouth.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Lips))
		{
			Lips lips = (Lips) bioMightInstance;
			bioMightComponent.setImage(lips.getImage());
			bioMightComponent.setBioMightProperties(lips.getProperties());
			bioMightComponent.setBioMightMethods(lips.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lips.getComponentID());			
			System.out.println("Storing lipsKey: " + bioMightComponent + "   ID: " + lips.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	lips.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Lips");
			bioMightComponent.setX3D(lips.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.Lip))
		{
			Lip lip = (Lip) bioMightInstance;
			bioMightComponent.setImage(lip.getImage());
			bioMightComponent.setBioMightProperties(lip.getProperties());
			bioMightComponent.setBioMightMethods(lip.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lip.getComponentID());			
			System.out.println("Storing lipKey: " + bioMightComponent + "   ID: " + lip.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	lips.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Lips");
			bioMightComponent.setX3D(lip.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.LowerLip))
		{
			LowerLip lowerLip = (LowerLip) bioMightInstance;
			bioMightComponent.setImage(lowerLip.getImage());
			bioMightComponent.setBioMightProperties(lowerLip.getProperties());
			bioMightComponent.setBioMightMethods(lowerLip.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LowerLip: "  + bioMightComponent +  "  ID: " + lowerLip.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lowerLip.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(lowerLip.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.UpperLip))
		{
			UpperLip upperLip = (UpperLip) bioMightInstance;
			bioMightComponent.setImage(upperLip.getImage());
			bioMightComponent.setBioMightProperties(upperLip.getProperties());
			bioMightComponent.setBioMightMethods(upperLip.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for upperLip: "  + bioMightComponent +  "  ID: " + upperLip.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(upperLip.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(upperLip.getX3D(snippet));						
		}	
		else if (bioMightComponentRef.equals(Constants.Tongue))
		{
			Tongue tongue = (Tongue) bioMightInstance;
			bioMightComponent.setImage(tongue.getImage());
			bioMightComponent.setBioMightProperties(tongue.getProperties());
			bioMightComponent.setBioMightMethods(tongue.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Tongue: "  + bioMightComponent +  "  ID: " + tongue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(tongue.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(tongue.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SalivaryGlands))
		{
			SalivaryGlands salivaryGlands = (SalivaryGlands) bioMightInstance;
			bioMightComponent.setImage(salivaryGlands.getImage());
			bioMightComponent.setBioMightProperties(salivaryGlands.getProperties());
			bioMightComponent.setBioMightMethods(salivaryGlands.getMethods());
		
			// Based on the parent ID that was passed in, the component will be`
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SalivaryGlands: "  + bioMightComponent +  "  ID: " + salivaryGlands.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salivaryGlands.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(salivaryGlands.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SalivaryGland))
		{
			SalivaryGland salivaryGland = (SalivaryGland) bioMightInstance;
			bioMightComponent.setImage(salivaryGland.getImage());
			bioMightComponent.setBioMightProperties(salivaryGland.getProperties());
			bioMightComponent.setBioMightMethods(salivaryGland.getMethods());
		
			// Based on the parent ID that was passed in, the component will be`
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SalivaryGland: "  + bioMightComponent +  "  ID: " + salivaryGland.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salivaryGland.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(salivaryGland.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.FungiformPapillae))
		{
			FungiformPapillae fungiformPapillae = (FungiformPapillae) bioMightInstance;
			bioMightComponent.setImage(fungiformPapillae.getImage());
			bioMightComponent.setBioMightProperties(fungiformPapillae.getProperties());
			bioMightComponent.setBioMightMethods(fungiformPapillae.getMethods());
		    bioMightComponent.setBioMightCollection(true);
		    
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Tongue: "  + bioMightComponent +  "  ID: " + fungiformPapillae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(fungiformPapillae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(fungiformPapillae.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.FungiformPapilla))
		{
			FungiformPapilla fungiformPapilla = (FungiformPapilla) bioMightInstance;
			bioMightComponent.setImage(fungiformPapilla.getImage());
			bioMightComponent.setBioMightProperties(fungiformPapilla.getProperties());
			bioMightComponent.setBioMightMethods(fungiformPapilla.getMethods());
		    
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Tongue: "  + bioMightComponent +  "  ID: " + fungiformPapilla.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(fungiformPapilla.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(fungiformPapilla.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.FiliformPapillae))
		{
			FiliformPapillae filiformPapillae = (FiliformPapillae) bioMightInstance;
			bioMightComponent.setImage(filiformPapillae.getImage());
			bioMightComponent.setBioMightProperties(filiformPapillae.getProperties());
			bioMightComponent.setBioMightMethods(filiformPapillae.getMethods());
		    bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FiliformPapillae: "  + bioMightComponent +  "  ID: " + filiformPapillae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(filiformPapillae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(filiformPapillae.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.FiliformPapilla))
		{
			FiliformPapilla filiformPapilla = (FiliformPapilla) bioMightInstance;
			bioMightComponent.setImage(filiformPapilla.getImage());
			bioMightComponent.setBioMightProperties(filiformPapilla.getProperties());
			bioMightComponent.setBioMightMethods(filiformPapilla.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FiliformPapillae: "  + bioMightComponent +  "  ID: " + filiformPapilla.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(filiformPapilla.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(filiformPapilla.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CircumvallatePapillae))
		{
			CircumvallatePapillae circumvallatePapillae = (CircumvallatePapillae) bioMightInstance;
			bioMightComponent.setImage(circumvallatePapillae.getImage());
			bioMightComponent.setBioMightProperties(circumvallatePapillae.getProperties());
			bioMightComponent.setBioMightMethods(circumvallatePapillae.getMethods());
		    bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CircumvallatePap1illae: "  + bioMightComponent +  "  ID: " + circumvallatePapillae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(circumvallatePapillae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(circumvallatePapillae.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CircumvallatePapilla))
		{
			CircumvallatePapilla circumvallatePapilla = (CircumvallatePapilla) bioMightInstance;
			bioMightComponent.setImage(circumvallatePapilla.getImage());
			bioMightComponent.setBioMightProperties(circumvallatePapilla.getProperties());
			bioMightComponent.setBioMightMethods(circumvallatePapilla.getMethods());	   
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CircumvallatePap1illa: "  + bioMightComponent +  "  ID: " + circumvallatePapilla.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(circumvallatePapilla.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(circumvallatePapilla.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.FoliatePapillae))
		{
			FoliatePapillae foliatePapillae = (FoliatePapillae) bioMightInstance;
			bioMightComponent.setImage(foliatePapillae.getImage());
			bioMightComponent.setBioMightProperties(foliatePapillae.getProperties());
			bioMightComponent.setBioMightMethods(foliatePapillae.getMethods());
		    bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FoliatePapillae: "  + bioMightComponent +  "  ID: " + foliatePapillae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(foliatePapillae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(foliatePapillae.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.FoliatePapilla))
		{
			FoliatePapilla foliatePapilla = (FoliatePapilla) bioMightInstance;
			bioMightComponent.setImage(foliatePapilla.getImage());
			bioMightComponent.setBioMightProperties(foliatePapilla.getProperties());
			bioMightComponent.setBioMightMethods(foliatePapilla.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FoliatePapilla: "  + bioMightComponent +  "  ID: " + foliatePapilla.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(foliatePapilla.getComponentID());
			bioMightKeys.setKey(bioMightKey);
	
			bioMightComponent.setX3D(foliatePapilla.getX3D(snippet));			
		}				
		
		// TEETH
		else if (bioMightComponentRef.equals(Constants.Teeth))
		{
			Teeth teeth = (Teeth) bioMightInstance;
			bioMightComponent.setImage(teeth.getImage());
			bioMightComponent.setBioMightProperties(teeth.getProperties());
			bioMightComponent.setBioMightMethods(teeth.getMethods());
		    bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(teeth.getComponentID());			
			System.out.println("Storing Teeth Key: " + bioMightComponent + "   ID: " + teeth.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	lips.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Teeth");
			bioMightComponent.setX3D(teeth.getX3D(snippet));		
		}	
		else if (bioMightComponentRef.equals(Constants.Tooth))
		{
			Tooth tooth = (Tooth) bioMightInstance;
			bioMightComponent.setImage(tooth.getImage());
			bioMightComponent.setBioMightProperties(tooth.getProperties());
			bioMightComponent.setBioMightMethods(tooth.getMethods());
		    bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(tooth.getComponentID());			
			System.out.println("Storing Tooth Key: " + bioMightComponent + "   ID: " + tooth.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	tooth.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Teeth");
			bioMightComponent.setX3D(tooth.getX3D(snippet));		
		}		
		/*********
		// LEFT UPPER TEETH
		else if (bioMightComponentRef.equals(Constants.LeftUpperCentralIncisor))
		{
			LeftUpperCentralIncisor leftUpperCentralIncisor = (LeftUpperCentralIncisor) bioMightInstance;
			bioMightComponent.setImage(leftUpperCentralIncisor.getImage());
			bioMightComponent.setBioMightProperties(leftUpperCentralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(leftUpperCentralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftUpperLateralIncisor))
		{
			LeftUpperLateralIncisor leftUpperLateralIncisor = (LeftUpperLateralIncisor) bioMightInstance;
			bioMightComponent.setImage(leftUpperLateralIncisor.getImage());
			bioMightComponent.setBioMightProperties(leftUpperLateralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(leftUpperLateralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftUpperCanine))
		{
			LeftUpperCanine leftUpperCanine = (LeftUpperCanine) bioMightInstance;
			bioMightComponent.setImage(leftUpperCanine.getImage());
			bioMightComponent.setBioMightProperties(leftUpperCanine.getProperties());
			bioMightComponent.setBioMightMethods(leftUpperCanine.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftUpper1stPreMolar))
		{
			LeftUpper1stPreMolar leftUpper1stPreMolar = (LeftUpper1stPreMolar) bioMightInstance;
			bioMightComponent.setImage(leftUpper1stPreMolar.getImage());
			bioMightComponent.setBioMightProperties(leftUpper1stPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftUpper1stPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftUpper2ndPreMolar))
		{
			LeftUpper2ndPreMolar leftUpper2ndPreMolar = (LeftUpper2ndPreMolar) bioMightInstance;
			bioMightComponent.setImage(leftUpper2ndPreMolar.getImage());
			bioMightComponent.setBioMightProperties(leftUpper2ndPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftUpper2ndPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftUpper1stMolar))
		{
			LeftUpper1stMolar leftUpper1stMolar = (LeftUpper1stMolar) bioMightInstance;
			bioMightComponent.setImage(leftUpper1stMolar.getImage());
			bioMightComponent.setBioMightProperties(leftUpper1stMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftUpper1stMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftUpper2ndMolar))
		{
			LeftUpper2ndMolar leftUpper2ndMolar = (LeftUpper2ndMolar) bioMightInstance;
			bioMightComponent.setImage(leftUpper2ndMolar.getImage());
			bioMightComponent.setBioMightProperties(leftUpper2ndMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftUpper2ndMolar.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftUpper3rdMolar))
		{
			LeftUpper3rdMolar leftUpper3rdMolar = (LeftUpper3rdMolar) bioMightInstance;
			bioMightComponent.setImage(leftUpper3rdMolar.getImage());
			bioMightComponent.setBioMightProperties(leftUpper3rdMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftUpper3rdMolar.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftUpperWisdomTooth))
		{
			LeftUpperWisdomTooth leftUpperWisdomTooth = (LeftUpperWisdomTooth) bioMightInstance;
			bioMightComponent.setImage(leftUpperWisdomTooth.getImage());
			bioMightComponent.setBioMightProperties(leftUpperWisdomTooth.getProperties());
			bioMightComponent.setBioMightMethods(leftUpperWisdomTooth.getMethods());
		}				
		// RIGHT UPPER TEETH
		else if (bioMightComponentRef.equals(Constants.RightUpperCentralIncisor))
		{
			RightUpperCentralIncisor rightUpperCentralIncisor = (RightUpperCentralIncisor) bioMightInstance;
			bioMightComponent.setImage(rightUpperCentralIncisor.getImage());
			bioMightComponent.setBioMightProperties(rightUpperCentralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(rightUpperCentralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightUpperLateralIncisor))
		{
			RightUpperLateralIncisor rightUpperLateralIncisor = (RightUpperLateralIncisor) bioMightInstance;
			bioMightComponent.setImage(rightUpperLateralIncisor.getImage());
			bioMightComponent.setBioMightProperties(rightUpperLateralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(rightUpperLateralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightUpperCanine))
		{
			RightUpperCanine rightUpperCanine = (RightUpperCanine) bioMightInstance;
			bioMightComponent.setImage(rightUpperCanine.getImage());
			bioMightComponent.setBioMightProperties(rightUpperCanine.getProperties());
			bioMightComponent.setBioMightMethods(rightUpperCanine.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.RightUpper1stPreMolar))
		{
			RightUpper1stPreMolar rightUpper1stPreMolar = (RightUpper1stPreMolar) bioMightInstance;
			bioMightComponent.setImage(rightUpper1stPreMolar.getImage());
			bioMightComponent.setBioMightProperties(rightUpper1stPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(rightUpper1stPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightUpper2ndPreMolar))
		{
			RightUpper2ndPreMolar RightUpper2ndPreMolar = (RightUpper2ndPreMolar) bioMightInstance;
			bioMightComponent.setImage(RightUpper2ndPreMolar.getImage());
			bioMightComponent.setBioMightProperties(RightUpper2ndPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightUpper2ndPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightUpper1stMolar))
		{
			RightUpper1stMolar RightUpper1stMolar = (RightUpper1stMolar) bioMightInstance;
			bioMightComponent.setImage(RightUpper1stMolar.getImage());
			bioMightComponent.setBioMightProperties(RightUpper1stMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightUpper1stMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightUpper2ndMolar))
		{
			RightUpper2ndMolar RightUpper2ndMolar = (RightUpper2ndMolar) bioMightInstance;
			bioMightComponent.setImage(RightUpper2ndMolar.getImage());
			bioMightComponent.setBioMightProperties(RightUpper2ndMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightUpper2ndMolar.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.RightUpper3rdMolar))
		{
			RightUpper3rdMolar RightUpper3rdMolar = (RightUpper3rdMolar) bioMightInstance;
			bioMightComponent.setImage(RightUpper3rdMolar.getImage());
			bioMightComponent.setBioMightProperties(RightUpper3rdMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightUpper3rdMolar.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightUpperWisdomTooth))
		{
			RightUpperWisdomTooth rightUpperWisdomTooth = (RightUpperWisdomTooth) bioMightInstance;
			bioMightComponent.setImage(rightUpperWisdomTooth.getImage());
			bioMightComponent.setBioMightProperties(rightUpperWisdomTooth.getProperties());
			bioMightComponent.setBioMightMethods(rightUpperWisdomTooth.getMethods());
		}	
		// LEFT LOWER TEETH
		else if (bioMightComponentRef.equals(Constants.LeftLowerCentralIncisor))
		{
			LeftLowerCentralIncisor leftLowerCentralIncisor = (LeftLowerCentralIncisor) bioMightInstance;
			bioMightComponent.setImage(leftLowerCentralIncisor.getImage());
			bioMightComponent.setBioMightProperties(leftLowerCentralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(leftLowerCentralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftLowerLateralIncisor))
		{
			LeftLowerLateralIncisor leftLowerLateralIncisor = (LeftLowerLateralIncisor) bioMightInstance;
			bioMightComponent.setImage(leftLowerLateralIncisor.getImage());
			bioMightComponent.setBioMightProperties(leftLowerLateralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(leftLowerLateralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftLowerCanine))
		{
			LeftLowerCanine leftLowerCanine = (LeftLowerCanine) bioMightInstance;
			bioMightComponent.setImage(leftLowerCanine.getImage());
			bioMightComponent.setBioMightProperties(leftLowerCanine.getProperties());
			bioMightComponent.setBioMightMethods(leftLowerCanine.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftLower1stPreMolar))
		{
			LeftLower1stPreMolar leftLower1stPreMolar = (LeftLower1stPreMolar) bioMightInstance;
			bioMightComponent.setImage(leftLower1stPreMolar.getImage());
			bioMightComponent.setBioMightProperties(leftLower1stPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftLower1stPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftLower2ndPreMolar))
		{
			LeftLower2ndPreMolar leftLower2ndPreMolar = (LeftLower2ndPreMolar) bioMightInstance;
			bioMightComponent.setImage(leftLower2ndPreMolar.getImage());
			bioMightComponent.setBioMightProperties(leftLower2ndPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftLower2ndPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftLower1stMolar))
		{
			LeftLower1stMolar leftLower1stMolar = (LeftLower1stMolar) bioMightInstance;
			bioMightComponent.setImage(leftLower1stMolar.getImage());
			bioMightComponent.setBioMightProperties(leftLower1stMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftLower1stMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.LeftLower2ndMolar))
		{
			LeftLower2ndMolar leftLower2ndMolar = (LeftLower2ndMolar) bioMightInstance;
			bioMightComponent.setImage(leftLower2ndMolar.getImage());
			bioMightComponent.setBioMightProperties(leftLower2ndMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftLower2ndMolar.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.LeftLower3rdMolar))
		{
			LeftLower3rdMolar leftLower3rdMolar = (LeftLower3rdMolar) bioMightInstance;
			bioMightComponent.setImage(leftLower3rdMolar.getImage());
			bioMightComponent.setBioMightProperties(leftLower3rdMolar.getProperties());
			bioMightComponent.setBioMightMethods(leftLower3rdMolar.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftLowerWisdomTooth))
		{
			LeftLowerWisdomTooth leftLowerWisdomTooth = (LeftLowerWisdomTooth) bioMightInstance;
			bioMightComponent.setImage(leftLowerWisdomTooth.getImage());
			bioMightComponent.setBioMightProperties(leftLowerWisdomTooth.getProperties());
			bioMightComponent.setBioMightMethods(leftLowerWisdomTooth.getMethods());
		}				
		// RIGHT LOWER TEETH
		else if (bioMightComponentRef.equals(Constants.RightLowerCentralIncisor))
		{
			RightLowerCentralIncisor rightLowerCentralIncisor = (RightLowerCentralIncisor) bioMightInstance;
			bioMightComponent.setImage(rightLowerCentralIncisor.getImage());
			bioMightComponent.setBioMightProperties(rightLowerCentralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(rightLowerCentralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightLowerLateralIncisor))
		{
			RightLowerLateralIncisor rightLowerLateralIncisor = (RightLowerLateralIncisor) bioMightInstance;
			bioMightComponent.setImage(rightLowerLateralIncisor.getImage());
			bioMightComponent.setBioMightProperties(rightLowerLateralIncisor.getProperties());
			bioMightComponent.setBioMightMethods(rightLowerLateralIncisor.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightLowerCanine))
		{
			RightLowerCanine rightLowerCanine = (RightLowerCanine) bioMightInstance;
			bioMightComponent.setImage(rightLowerCanine.getImage());
			bioMightComponent.setBioMightProperties(rightLowerCanine.getProperties());
			bioMightComponent.setBioMightMethods(rightLowerCanine.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.RightLower1stPreMolar))
		{
			RightLower1stPreMolar rightLower1stPreMolar = (RightLower1stPreMolar) bioMightInstance;
			bioMightComponent.setImage(rightLower1stPreMolar.getImage());
			bioMightComponent.setBioMightProperties(rightLower1stPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(rightLower1stPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightLower2ndPreMolar))
		{
			RightLower2ndPreMolar RightLower2ndPreMolar = (RightLower2ndPreMolar) bioMightInstance;
			bioMightComponent.setImage(RightLower2ndPreMolar.getImage());
			bioMightComponent.setBioMightProperties(RightLower2ndPreMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightLower2ndPreMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightLower1stMolar))
		{
			RightLower1stMolar RightLower1stMolar = (RightLower1stMolar) bioMightInstance;
			bioMightComponent.setImage(RightLower1stMolar.getImage());
			bioMightComponent.setBioMightProperties(RightLower1stMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightLower1stMolar.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightLower2ndMolar))
		{
			RightLower2ndMolar RightLower2ndMolar = (RightLower2ndMolar) bioMightInstance;
			bioMightComponent.setImage(RightLower2ndMolar.getImage());
			bioMightComponent.setBioMightProperties(RightLower2ndMolar.getProperties());
			bioMightComponent.setBioMightMethods(RightLower2ndMolar.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.RightLower3rdMolar))
		{
			RightLower3rdMolar rightLower3rdMolar = (RightLower3rdMolar) bioMightInstance;
			bioMightComponent.setImage(rightLower3rdMolar.getImage());
			bioMightComponent.setBioMightProperties(rightLower3rdMolar.getProperties());
			bioMightComponent.setBioMightMethods(rightLower3rdMolar.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.RightLowerWisdomTooth))
		{
			RightLowerWisdomTooth rightLowerWisdomTooth = (RightLowerWisdomTooth) bioMightInstance;
			bioMightComponent.setImage(rightLowerWisdomTooth.getImage());
			bioMightComponent.setBioMightProperties(rightLowerWisdomTooth.getProperties());
			bioMightComponent.setBioMightMethods(rightLowerWisdomTooth.getMethods());
		}	
		*******/

		
		else if (bioMightComponentRef.equals(Constants.Jaw))
		{
			Jaw jaw = (Jaw) bioMightInstance;
			bioMightComponent.setImage(jaw.getImage()); 
			bioMightComponent.setBioMightProperties(jaw.getProperties());
			bioMightComponent.setBioMightMethods(jaw.getMethods());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(jaw.getComponentID());			
			System.out.println("Storing Jaw Key: " + bioMightComponent + "   ID: " + jaw.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Jaw Methods!");
			//	jaw.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Mouth");
			bioMightComponent.setX3D(jaw.getX3D(snippet));
		}
		
		
		else if (bioMightComponentRef.equals(Constants.Nose))
		{
			Nose nose = (Nose) bioMightInstance;
			bioMightComponent.setImage(nose.getImage());
			bioMightComponent.setWidth(nose.getImageWidth());
			bioMightComponent.setHeight(nose.getImageHeight());
			bioMightComponent.setBioMightProperties(nose.getProperties());
			bioMightComponent.setBioMightMethods(nose.getMethods());
			bioMightComponent.setX3D(nose.getX3D(snippet));
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Head: "  + bioMightComponent +  "     ID: " + nose.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(nose.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing HEAD Methods!");
				//nose.executeMethods(methodParams);
				//System.out.println("Redrawing HEAD!");
				//nose.redraw(0);
			}
			
			bioMightComponent.setX3D(nose.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Penis))
		{
			Penis penis = (Penis) bioMightInstance;
			bioMightComponent.setImage(penis.getImage());
			bioMightComponent.setWidth(penis.getImageWidth());
			bioMightComponent.setHeight(penis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Vagina))
		{
			Vagina vagina = (Vagina) bioMightInstance;
			bioMightComponent.setImage(vagina.getImage());
			bioMightComponent.setWidth(vagina.getImageWidth());
			bioMightComponent.setHeight(vagina.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LeftBreast))
		{
			Breast leftBreast = (Breast) bioMightInstance;
			bioMightComponent.setImage(leftBreast.getImage());
			bioMightComponent.setWidth(leftBreast.getImageWidth());
			bioMightComponent.setHeight(leftBreast.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RightBreast))
		{
			Breast rightBreast = (Breast) bioMightInstance;
			bioMightComponent.setImage(rightBreast.getImage());
			bioMightComponent.setWidth(rightBreast.getImageWidth());
			bioMightComponent.setHeight(rightBreast.getImageHeight());
		}

		/**************************************************************************
		*
		* EAR
		* 
		***************************************************************************/

		else if (bioMightComponentRef.equals(Constants.Ears))
		{
			Ears ears = (Ears) bioMightInstance;
			bioMightComponent.setImage(ears.getImage());
			bioMightComponent.setWidth(ears.getImageWidth());
			bioMightComponent.setHeight(ears.getImageHeight());
			bioMightComponent.setBioMightProperties(ears.getProperties());
			bioMightComponent.setBioMightMethods(ears.getMethods());
						
			// Assoicate the BioMightComponent with its key in  database
			System.out.println("Creating Key for Ears: "  + bioMightComponent  +  "    "  + ears.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			// This is an aggregation relationship, so we store the same parent
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) { 
				//System.out.println("Executing Ears Methods!");
				//ears.executeMethods(methodParams);
				//System.out.println("Redrawing Ears!");
				//ears.redraw(0);
			}
			System.out.println("Getting X3D for Ears");
			bioMightComponent.setX3D(ears.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Ear))
		{
			Ear ear = (Ear) bioMightInstance;
			bioMightComponent.setImage(ear.getImage());
			bioMightComponent.setBioMightProperties(ear.getProperties());
			bioMightComponent.setBioMightMethods(ear.getMethods());
			bioMightComponent.setX3D(ear.getX3D(snippet));
			
			// Assoicate the BioMightComponent with its key in  database
			System.out.println("Creating Key for Ear: "  + bioMightComponent  +  "    "  + bioMightComponentID);				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing Ear Methods!");
				//ears.executeMethods(methodParams);
				//System.out.println("Redrawing Ear!");
				//ears.redraw(0);
			}
			//System.out.println("Getting X3D for Ear");
			bioMightComponent.setX3D(ear.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Auricle))
		{
			Auricle auricle = (Auricle) bioMightInstance;
			bioMightComponent.setImage(auricle.getImage());
			bioMightComponent.setWidth(auricle.getImageWidth());
			bioMightComponent.setHeight(auricle.getImageHeight());
			bioMightComponent.setBioMightProperties(auricle.getProperties());
			bioMightComponent.setBioMightMethods(auricle.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Auricle: "  + bioMightComponent +  "     ID: " +auricle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(auricle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	auricle.executeMethods(methodParams);
			//	auricle.redraw(0);
			//}
			bioMightComponent.setX3D(auricle.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Cochlea))
		{
			Cochlea cochlea = (Cochlea) bioMightInstance;
			bioMightComponent.setImage(cochlea.getImage());
			bioMightComponent.setWidth(cochlea.getImageWidth());
			bioMightComponent.setHeight(cochlea.getImageHeight());
			bioMightComponent.setBioMightProperties(cochlea.getProperties());
			bioMightComponent.setBioMightMethods(cochlea.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Cochlea: "  + bioMightComponent +  "     ID: " +cochlea.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cochlea.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	cochlea.executeMethods(methodParams);
			//	cochlea.redraw(0);
			//}
			bioMightComponent.setX3D(cochlea.getX3D(snippet));	
		
		}
		else if (bioMightComponentRef.equals(Constants.ExternalCanal))
		{
			ExternalCanal externalCanal = (ExternalCanal) bioMightInstance;
			bioMightComponent.setImage(externalCanal.getImage());
			bioMightComponent.setWidth(externalCanal.getImageWidth());
			bioMightComponent.setHeight(externalCanal.getImageHeight());
			//bioMightComponent.setBioMightProperties(externalCanal.getProperties());
			//bioMightComponent.setBioMightMethods(externalCanal.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExternalCanal: "  + bioMightComponent +  "     ID: " +externalCanal.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(externalCanal.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	externalCanal.executeMethods(methodParams);
			//	externalCanal.redraw(0);
			//}
			bioMightComponent.setX3D(externalCanal.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Incus))
		{
			Incus incus = (Incus) bioMightInstance;
			bioMightComponent.setImage(incus.getImage());
			bioMightComponent.setWidth(incus.getImageWidth());
			bioMightComponent.setHeight(incus.getImageHeight());
			//bioMightComponent.setBioMightProperties(hands.getProperties());
			//bioMightComponent.setBioMightMethods(hands.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Incus: "  + bioMightComponent +  "     ID: " +incus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(incus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	incus.executeMethods(methodParams);
			//	incus.redraw(0);
			//}
			bioMightComponent.setX3D(incus.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Malleus))
		{
			Malleus malleus = (Malleus) bioMightInstance;
			bioMightComponent.setImage(malleus.getImage());
			bioMightComponent.setWidth(malleus.getImageWidth());
			bioMightComponent.setHeight(malleus.getImageHeight());
			//bioMightComponent.setBioMightProperties(hands.getProperties());
			//bioMightComponent.setBioMightMethods(hands.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Malleus: "  + bioMightComponent +  "     ID: " +malleus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(malleus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Malleus Methods!");
			//	malleus.executeMethods(methodParams);
			//	malleus.redraw(0);
			//}
			bioMightComponent.setX3D(malleus.getX3D(snippet));	
		}			
		else if (bioMightComponentRef.equals(Constants.Saccule))
		{
			Saccule saccule = (Saccule) bioMightInstance;
			bioMightComponent.setImage(saccule.getImage());
			bioMightComponent.setWidth(saccule.getImageWidth());
			bioMightComponent.setHeight(saccule.getImageHeight());
			//bioMightComponent.setBioMightProperties(hands.getProperties());
			//bioMightComponent.setBioMightMethods(hands.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Saccule: "  + bioMightComponent +  "     ID: " +saccule.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(saccule.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	malleus.executeMethods(methodParams);
			//	malleus.redraw(0);
			//}
			bioMightComponent.setX3D(saccule.getX3D(snippet));	
		
		}
		else if (bioMightComponentRef.equals(Constants.SemiCircularCanals))
		{
			SemiCircularCanals semiCircularCanals = (SemiCircularCanals) bioMightInstance;
			bioMightComponent.setImage(semiCircularCanals.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.Stapes))
		{
			Stapes stapes = (Stapes) bioMightInstance;
			bioMightComponent.setImage(stapes.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.TympanicMembrane))
		{
			TympanicMembrane tympanicMembrane = (TympanicMembrane) bioMightInstance;
			bioMightComponent.setImage(tympanicMembrane.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.Utricle))
		{
			Utricle utricle = (Utricle) bioMightInstance;
			bioMightComponent.setImage(utricle.getImage());
		}	

		/**************************************************************************
		*
		* EYE
		* 
		***************************************************************************/

		else if (bioMightComponentRef.equals(Constants.AnteriorChamber))
		{
			AnteriorChamber anteriorChamber = (AnteriorChamber) bioMightInstance;
			bioMightComponent.setImage(anteriorChamber.getImage());
			bioMightComponent.setWidth(anteriorChamber.getImageWidth());
			bioMightComponent.setHeight(anteriorChamber.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CanalOfSchlemm))
		{
			CanalOfSchlemm canalOfSchlemm = (CanalOfSchlemm) bioMightInstance;
			bioMightComponent.setImage(canalOfSchlemm.getImage());
			bioMightComponent.setWidth(canalOfSchlemm.getImageWidth());
			bioMightComponent.setHeight(canalOfSchlemm.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Choroid))
		{
			Choroid choroid = (Choroid) bioMightInstance;
			bioMightComponent.setImage(choroid.getImage());
			bioMightComponent.setWidth(choroid.getImageWidth());
			bioMightComponent.setHeight(choroid.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CiliaryBody))
		{
			CiliaryBody ciliaryBody = (CiliaryBody) bioMightInstance;
			bioMightComponent.setImage(ciliaryBody.getImage());
			bioMightComponent.setWidth(ciliaryBody.getImageWidth());
			bioMightComponent.setHeight(ciliaryBody.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CiliaryMuscle))
		{
			CiliaryMuscle ciliaryMuscle = (CiliaryMuscle) bioMightInstance;
			bioMightComponent.setImage(ciliaryMuscle.getImage());
			bioMightComponent.setWidth(ciliaryMuscle.getImageWidth());
			bioMightComponent.setHeight(ciliaryMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CiliaryProcess))
		{
			CiliaryProcess ciliaryProcess = (CiliaryProcess) bioMightInstance;
			bioMightComponent.setImage(ciliaryProcess.getImage());
			bioMightComponent.setWidth(ciliaryProcess.getImageWidth());
			bioMightComponent.setHeight(ciliaryProcess.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Cone))
		{
			Cone cone = (Cone) bioMightInstance;
			bioMightComponent.setImage(cone.getImage());
			bioMightComponent.setWidth(cone.getImageWidth());
			bioMightComponent.setHeight(cone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Conjunctiva))
		{
			Conjunctiva conjunctiva = (Conjunctiva) bioMightInstance;
			bioMightComponent.setImage(conjunctiva.getImage());
			bioMightComponent.setWidth(conjunctiva.getImageWidth());
			bioMightComponent.setHeight(conjunctiva.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Cornea))
		{
			Cornea cornea = (Cornea) bioMightInstance;
			bioMightComponent.setImage(cornea.getImage());
			bioMightComponent.setWidth(cornea.getImageWidth());
			bioMightComponent.setHeight(cornea.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Eyes))
		{
			Eyes eyes = (Eyes) bioMightInstance;
			bioMightComponent.setImage(eyes.getImage());
			bioMightComponent.setWidth(eyes.getImageWidth());
			bioMightComponent.setHeight(eyes.getImageHeight());
			bioMightComponent.setBioMightProperties(eyes.getProperties());
			bioMightComponent.setBioMightMethods(eyes.getMethods());
			bioMightComponent.setBioMightCollection(true);
						
			// Assoicate the BioMightComponent with its key in  database
			//System.out.println("Creating Key for Eyes: "  + bioMightComponent  +  "    "  + eyes.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			// This is an aggregation relationship, so we store the same parent
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) { 
				//System.out.println("Executing Eyes Methods!");
				//eyes.executeMethods(methodParams);
			}
			
			//System.out.println("Getting X3D for Eyes");
			bioMightComponent.setX3D(eyes.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Eye))
		{
			Eye eye = (Eye) bioMightInstance;
			bioMightComponent.setImage(eye.getImage());
			bioMightComponent.setWidth(eye.getImageWidth());
			bioMightComponent.setHeight(eye.getImageHeight());
			bioMightComponent.setBioMightProperties(eye.getProperties());
			bioMightComponent.setBioMightMethods(eye.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Eye: "  + bioMightComponent +  "   " + bioMightComponentID);				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing HEAD Methods!");
				//eye.executeMethods(methodParams);
				//System.out.println("Redrawing HEAD!");
				//eye.redraw(0);
			}
			System.out.println("Getting X3D for Eye!");
			bioMightComponent.setX3D(eye.getX3D(snippet));				
		}
		else if (bioMightComponentRef.equals(Constants.EyeLashes))
		{
			EyeLashes eyeLashes = (EyeLashes) bioMightInstance;
			bioMightComponent.setImage(eyeLashes.getImage());
			bioMightComponent.setWidth(eyeLashes.getImageWidth());
			bioMightComponent.setHeight(eyeLashes.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.EyeLens))
		{
			EyeLens eyeLens = (EyeLens) bioMightInstance;
			bioMightComponent.setImage(eyeLens.getImage());
			bioMightComponent.setWidth(eyeLens.getImageWidth());
			bioMightComponent.setHeight(eyeLens.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LowerEyeLid))
		{
			LowerEyeLid eyelidLower = (LowerEyeLid) bioMightInstance;
			bioMightComponent.setImage(eyelidLower.getImage());
			bioMightComponent.setWidth(eyelidLower.getImageWidth());
			bioMightComponent.setHeight(eyelidLower.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.UpperEyeLid))
		{
			UpperEyeLid eyelidUpper = (UpperEyeLid) bioMightInstance;
			bioMightComponent.setImage(eyelidUpper.getImage());
			bioMightComponent.setWidth(eyelidUpper.getImageWidth());
			bioMightComponent.setHeight(eyelidUpper.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Fovea))
		{
			Fovea fovea = (Fovea) bioMightInstance;
			bioMightComponent.setImage(fovea.getImage());
			bioMightComponent.setWidth(fovea.getImageWidth());
			bioMightComponent.setHeight(fovea.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Iris))
		{
			Iris iris = (Iris) bioMightInstance;
			bioMightComponent.setImage(iris.getImage());
			bioMightComponent.setWidth(iris.getImageWidth());
			bioMightComponent.setHeight(iris.getImageHeight());
			bioMightComponent.setBioMightProperties(iris.getProperties());
			bioMightComponent.setBioMightMethods(iris.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Iris: "  + bioMightComponent +  "   " + iris.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioMightComponentID);
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing HEAD Methods!");
				//iris.executeMethods(methodParams);
				//System.out.println("Redrawing HEAD!");
				//iris.redraw(0);
			}
			System.out.println("Getting X3D for Iris!");
			bioMightComponent.setX3D(iris.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Lens))
		{
			Lens lens = (Lens) bioMightInstance;
			bioMightComponent.setImage(lens.getImage());
			bioMightComponent.setWidth(lens.getImageWidth());
			bioMightComponent.setHeight(lens.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Macula))
		{
			Macula macula = (Macula) bioMightInstance;
			bioMightComponent.setImage(macula.getImage());
			bioMightComponent.setWidth(macula.getImageWidth());
			bioMightComponent.setHeight(macula.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MobomiumGland))
		{
			MobomiumGland mobomiumGland = (MobomiumGland) bioMightInstance;
			bioMightComponent.setImage(mobomiumGland.getImage());
			bioMightComponent.setWidth(mobomiumGland.getImageWidth());
			bioMightComponent.setHeight(mobomiumGland.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OpticDisc))
		{
			OpticDisc opticDisc = (OpticDisc) bioMightInstance;
			bioMightComponent.setImage(opticDisc.getImage());
			bioMightComponent.setWidth(opticDisc.getImageWidth());
			bioMightComponent.setHeight(opticDisc.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ParsPlana))
		{
			ParsPlana parsPlana = (ParsPlana) bioMightInstance;
			bioMightComponent.setImage(parsPlana.getImage());
			bioMightComponent.setWidth(parsPlana.getImageWidth());
			bioMightComponent.setHeight(parsPlana.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Photopsin))
		{
			Photopsin photopsin = (Photopsin) bioMightInstance;
			bioMightComponent.setImage(photopsin.getImage());
			bioMightComponent.setWidth(photopsin.getImageWidth());
			bioMightComponent.setHeight(photopsin.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PosteriorChamber))
		{
			PosteriorChamber posteriorChamber = (PosteriorChamber) bioMightInstance;
			bioMightComponent.setImage(posteriorChamber.getImage());
			bioMightComponent.setWidth(posteriorChamber.getImageWidth());
			bioMightComponent.setHeight(posteriorChamber.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Pupil))
		{
			Pupil pupil = (Pupil) bioMightInstance;
			bioMightComponent.setImage(pupil.getImage());
			bioMightComponent.setWidth(pupil.getImageWidth());
			bioMightComponent.setHeight(pupil.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PupilMargin))
		{
			PupilMargin pupilMargin = (PupilMargin) bioMightInstance;
			bioMightComponent.setImage(pupilMargin.getImage());
			bioMightComponent.setWidth(pupilMargin.getImageWidth());
			bioMightComponent.setHeight(pupilMargin.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PupilSphincter))
		{
			PupilSphincter pupilSphincter = (PupilSphincter) bioMightInstance;
			bioMightComponent.setImage(pupilSphincter.getImage());
			bioMightComponent.setWidth(pupilSphincter.getImageWidth());
			bioMightComponent.setHeight(pupilSphincter.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Retina))
		{
			Retina retina = (Retina) bioMightInstance;
			bioMightComponent.setImage(retina.getImage());
			bioMightComponent.setWidth(retina.getImageWidth());
			bioMightComponent.setHeight(retina.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Rod))
		{
			Rod rod = (Rod) bioMightInstance;
			bioMightComponent.setImage(rod.getImage());
			bioMightComponent.setWidth(rod.getImageWidth());
			bioMightComponent.setHeight(rod.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Sclera))
		{
			Sclera sclera = (Sclera) bioMightInstance;
			bioMightComponent.setImage(sclera.getImage());
			bioMightComponent.setWidth(sclera.getImageWidth());
			bioMightComponent.setHeight(sclera.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SebaciousCyst))
		{
			SebaciousCyst sebaciousCyst = (SebaciousCyst) bioMightInstance;
			bioMightComponent.setImage(sebaciousCyst.getImage());
			bioMightComponent.setWidth(sebaciousCyst.getImageWidth());
			bioMightComponent.setHeight(sebaciousCyst.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Trabeculum))
		{
			Trabeculum trabeculum = (Trabeculum) bioMightInstance;
			bioMightComponent.setImage(trabeculum.getImage());
			bioMightComponent.setWidth(trabeculum.getImageWidth());
			bioMightComponent.setHeight(trabeculum.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.VitreousHumor))
		{
			VitreousHumor vitreousHumor = (VitreousHumor) bioMightInstance;
			bioMightComponent.setImage(vitreousHumor.getImage());
			bioMightComponent.setWidth(vitreousHumor.getImageWidth());
			bioMightComponent.setHeight(vitreousHumor.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ZonularFibers))
		{
			ZonularFibers zonularFibers = (ZonularFibers) bioMightInstance;
			bioMightComponent.setImage(zonularFibers.getImage());
			bioMightComponent.setWidth(zonularFibers.getImageWidth());
			bioMightComponent.setHeight(zonularFibers.getImageHeight());
		}
	
		/**************************************************************************
		*
		* HANDS
		* 
		***************************************************************************/

		else if (bioMightComponentRef.equals(Constants.Hands))
		{
			Hands hands = (Hands) bioMightInstance;
			bioMightComponent.setImage(hands.getImage());
			bioMightComponent.setWidth(hands.getImageWidth());
			bioMightComponent.setHeight(hands.getImageHeight());
			bioMightComponent.setBioMightProperties(hands.getProperties());
			bioMightComponent.setBioMightMethods(hands.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hands: "  + bioMightComponent +  "     ID: " +hands.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hands.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	hands.executeMethods(methodParams);
			//	hands.redraw(0);
			//}
			bioMightComponent.setX3D(hands.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Hand))
		{
			Hand hand = (Hand) bioMightInstance;
			bioMightComponent.setImage(hand.getImage());
			bioMightComponent.setWidth(hand.getImageWidth());
			bioMightComponent.setHeight(hand.getImageHeight());
			bioMightComponent.setBioMightProperties(hand.getProperties());
			bioMightComponent.setBioMightMethods(hand.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hand: "  + bioMightComponent +  "     ID: " +hand.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hand.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	hand.executeMethods(methodParams);
			//	hand.redraw(0);
			//}
			bioMightComponent.setX3D(hand.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftHand))
		{
			Hand leftHand = (Hand) bioMightInstance;
			bioMightComponent.setImage(leftHand.getImage());
			bioMightComponent.setWidth(leftHand.getImageWidth());
			bioMightComponent.setHeight(leftHand.getImageHeight());
			bioMightComponent.setBioMightProperties(leftHand.getProperties());
			bioMightComponent.setBioMightMethods(leftHand.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.RightHand))
		{
			Hand rightHand = (Hand) bioMightInstance;
			bioMightComponent.setImage(rightHand.getImage());
			bioMightComponent.setWidth(rightHand.getImageWidth());
			bioMightComponent.setHeight(rightHand.getImageHeight());
			bioMightComponent.setBioMightProperties(rightHand.getProperties());
			bioMightComponent.setBioMightMethods(rightHand.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.Fingers))
		{
			Fingers fingers = (Fingers) bioMightInstance;
			bioMightComponent.setImage(fingers.getImage());
			bioMightComponent.setWidth(fingers.getImageWidth());
			bioMightComponent.setHeight(fingers.getImageHeight());
			bioMightComponent.setBioMightProperties(fingers.getProperties());
			bioMightComponent.setBioMightMethods(fingers.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hands: "  + bioMightComponent +  "     ID: " +fingers.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(fingers.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	fingers.executeMethods(methodParams);
			//	fingers.redraw(0);
			//}
			bioMightComponent.setX3D(fingers.getX3D(snippet));								
			
		}	
		else if (bioMightComponentRef.equals(Constants.Finger))
		{
			Finger finger = (Finger) bioMightInstance;
			bioMightComponent.setImage(finger.getImage());
			bioMightComponent.setWidth(finger.getImageWidth());
			bioMightComponent.setHeight(finger.getImageHeight());
			bioMightComponent.setBioMightProperties(finger.getProperties());
			bioMightComponent.setBioMightMethods(finger.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hands: "  + bioMightComponent +  "     ID: " +finger.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(finger.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	hands.executeMethods(methodParams);
			//	hands.redraw(0);
			//}
			bioMightComponent.setX3D(finger.getX3D(snippet));								
		}				
		else if (bioMightComponentRef.equals(Constants.FingerNail))
		{
			FingerNail fingerNail = (FingerNail) bioMightInstance;
			bioMightComponent.setImage(fingerNail.getImage());
			bioMightComponent.setWidth(fingerNail.getImageWidth());
			bioMightComponent.setHeight(fingerNail.getImageHeight());
		}								
		else if (bioMightComponentRef.equals(Constants.Palm))
		{
			Palm palm = (Palm) bioMightInstance;
			bioMightComponent.setImage(palm.getImage());
			bioMightComponent.setWidth(palm.getImageWidth());
			bioMightComponent.setHeight(palm.getImageHeight());
			bioMightComponent.setBioMightProperties(palm.getProperties());
			bioMightComponent.setBioMightMethods(palm.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hands: "  + bioMightComponent +  "     ID: " +palm.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palm.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	hands.executeMethods(methodParams);
			//	hands.redraw(0);
			//}
			bioMightComponent.setX3D(palm.getX3D(snippet));									
		}		
		else if (bioMightComponentRef.equals(Constants.Thumb))
		{
			Thumb thumb = (Thumb) bioMightInstance;
			bioMightComponent.setImage(thumb.getImage());
			bioMightComponent.setWidth(thumb.getImageWidth());
			bioMightComponent.setHeight(thumb.getImageHeight());
			bioMightComponent.setBioMightProperties(thumb.getProperties());
			bioMightComponent.setBioMightMethods(thumb.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Thumbs: "  + bioMightComponent +  "     ID: " +thumb.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thumb.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Thumbs Methods!");
			//	thumb.executeMethods(methodParams);
			//	thumb.redraw(0);
			//}
			bioMightComponent.setX3D(thumb.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftMiddleFinger))
		{
			MiddleFinger leftMiddleFinger = (MiddleFinger) bioMightInstance;
			bioMightComponent.setImage(leftMiddleFinger.getImage());
			bioMightComponent.setWidth(leftMiddleFinger.getImageWidth());
			bioMightComponent.setHeight(leftMiddleFinger.getImageHeight());
		}			
		else if (bioMightComponentRef.equals(Constants.RightMiddleFinger))
		{
			MiddleFinger rightMiddleFinger = (MiddleFinger) bioMightInstance;
			bioMightComponent.setImage(rightMiddleFinger.getImage());
			bioMightComponent.setWidth(rightMiddleFinger.getImageWidth());
			bioMightComponent.setHeight(rightMiddleFinger.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LeftLittleFinger))
		{
			LittleFinger leftLittleFinger = (LittleFinger) bioMightInstance;
			bioMightComponent.setImage(leftLittleFinger.getImage());
			bioMightComponent.setWidth(leftLittleFinger.getImageWidth());
			bioMightComponent.setHeight(leftLittleFinger.getImageHeight());
		}			
		else if (bioMightComponentRef.equals(Constants.RightLittleFinger))
		{
			LittleFinger rightLittleFinger = (LittleFinger) bioMightInstance;
			bioMightComponent.setImage(rightLittleFinger.getImage());
			bioMightComponent.setWidth(rightLittleFinger.getImageWidth());
			bioMightComponent.setHeight(rightLittleFinger.getImageHeight());
		}	
		else if (bioMightComponentRef.equals(Constants.LeftIndexFinger))
		{
			IndexFinger leftIndexFinger = (IndexFinger) bioMightInstance;
			bioMightComponent.setImage(leftIndexFinger.getImage());
			bioMightComponent.setWidth(leftIndexFinger.getImageWidth());
			bioMightComponent.setHeight(leftIndexFinger.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RightIndexFinger))
		{
			IndexFinger rightIndexFinger = (IndexFinger) bioMightInstance;
			bioMightComponent.setImage(rightIndexFinger.getImage());
			bioMightComponent.setWidth(rightIndexFinger.getImageWidth());
			bioMightComponent.setHeight(rightIndexFinger.getImageHeight());
		}			
		else if (bioMightComponentRef.equals(Constants.RightRingFinger))
		{
			RingFinger rightRingFinger = (RingFinger) bioMightInstance;
			bioMightComponent.setImage(rightRingFinger.getImage());
			bioMightComponent.setWidth(rightRingFinger.getImageWidth());
			bioMightComponent.setHeight(rightRingFinger.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LeftRingFinger))
		{
			RingFinger leftRingFinger = (RingFinger) bioMightInstance;
			bioMightComponent.setImage(leftRingFinger.getImage());
			bioMightComponent.setWidth(leftRingFinger.getImageWidth());
			bioMightComponent.setHeight(leftRingFinger.getImageHeight());
		}			
		else if (bioMightComponentRef.equals(Constants.Wrists))
		{
			Wrists wrists = (Wrists) bioMightInstance;
			bioMightComponent.setImage(wrists.getImage());
			bioMightComponent.setWidth(wrists.getImageWidth());
			bioMightComponent.setHeight(wrists.getImageHeight());
			//bioMightComponent.setBioMightProperties(feet.getProperties());
			//bioMightComponent.setBioMightMethods(feet.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Wrists: "  + bioMightComponent +  "     ID: " + wrists.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(wrists.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	wrists.executeMethods(methodParams);
			//	wrists.redraw(0);
			//}
			bioMightComponent.setX3D(wrists.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Wrist))
		{
			Wrist wrist = (Wrist) bioMightInstance;
			bioMightComponent.setImage(wrist.getImage());
			bioMightComponent.setWidth(wrist.getImageWidth());
			bioMightComponent.setHeight(wrist.getImageHeight());
			bioMightComponent.setBioMightProperties(wrist.getProperties());
			bioMightComponent.setBioMightMethods(wrist.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Wrist: "  + bioMightComponent +  "     ID: " + wrist.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(wrist.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hands Methods!");
			//	wrist.executeMethods(methodParams);
			//	wrist.redraw(0);
			//}
			bioMightComponent.setX3D(wrist.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.LeftWrist))
		{
			Wrist leftWrist = (Wrist) bioMightInstance;
			bioMightComponent.setImage(leftWrist.getImage());
			bioMightComponent.setWidth(leftWrist.getImageWidth());
			bioMightComponent.setHeight(leftWrist.getImageHeight());
		}			
		else if (bioMightComponentRef.equals(Constants.RightWrist))
		{
			Wrist rightWrist = (Wrist) bioMightInstance;
			bioMightComponent.setImage(rightWrist.getImage());
			bioMightComponent.setWidth(rightWrist.getImageWidth());
			bioMightComponent.setHeight(rightWrist.getImageHeight());
		}	
		else if (bioMightComponentRef.equals(Constants.ThenarEminence))
		{
			ThenarEminence thenarEminence = (ThenarEminence) bioMightInstance;
			bioMightComponent.setImage(thenarEminence.getImage());
			bioMightComponent.setWidth(thenarEminence.getImageWidth());
			bioMightComponent.setHeight(thenarEminence.getImageHeight());
		}			

			/*					
			public final static String AdamsApple = "biomight.body.AdamsApple";
			public final static String Hair = "biomight.body.Hair";
			public final static String LeftNipple = "biomight.body.LeftNipple";
			public final static String RightNipple = "biomight.body.RightNipple";
			*/
		else
		{
			System.out.println("BioMightView Component NOT MATCHED: " + bioMightComponentRef + "  " +  bioMightComponentName);
		}
		
		//System.out.println("X3D is: " + bioMightComponent.getX3D());
		return bioMightComponent;
	}
	
}
