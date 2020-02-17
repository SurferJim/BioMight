package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.body.hip.Hip;
import biomight.body.hip.Hips;
import biomight.system.SkeletalSystem;
import biomight.system.skeletal.arm.Humeri;
import biomight.system.skeletal.arm.Humerus;
import biomight.system.skeletal.arm.Radii;
import biomight.system.skeletal.arm.Radius;
import biomight.system.skeletal.arm.Ulna;
import biomight.system.skeletal.arm.Ulnae;
import biomight.system.skeletal.chest.Clavicle;
import biomight.system.skeletal.chest.Scapula;
import biomight.system.skeletal.chest.Sternum;
import biomight.system.skeletal.chest.XiphoidProcess;
import biomight.system.skeletal.foot.CalcaneusBone;
import biomight.system.skeletal.foot.CuboidBone;
import biomight.system.skeletal.foot.DistalPhalanages;
import biomight.system.skeletal.foot.IntermediatePhalanages;
import biomight.system.skeletal.foot.LateralCuneiformBone;
import biomight.system.skeletal.foot.MetaTarsalsBone;
import biomight.system.skeletal.foot.NavicularCuneiforms;
import biomight.system.skeletal.foot.Phalangesfoot;
import biomight.system.skeletal.foot.ProximalPhalanges;
import biomight.system.skeletal.foot.TalusBone;
import biomight.system.skeletal.foot.Tarsals;
import biomight.system.skeletal.hand.CapitateBone;
import biomight.system.skeletal.hand.Carpals;
import biomight.system.skeletal.hand.DipJoint;
import biomight.system.skeletal.hand.DistalPhalanx;
import biomight.system.skeletal.hand.HamateCapitateBone;
import biomight.system.skeletal.hand.HandDistalPhalanges;
import biomight.system.skeletal.hand.HandMiddlePhalanges;
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
import biomight.system.skeletal.leg.Fibula;
import biomight.system.skeletal.leg.Fibulas;
import biomight.system.skeletal.leg.Patella;
import biomight.system.skeletal.leg.femur.Femur;
import biomight.system.skeletal.leg.femur.Femurs;
import biomight.system.skeletal.leg.femur.FoveaCapitis;
import biomight.system.skeletal.leg.femur.GreaterTrochanter;
import biomight.system.skeletal.leg.femur.LesserTrochanter;
import biomight.system.skeletal.leg.femur.PiriFormis;
import biomight.system.skeletal.leg.femur.TrochanterHead;
import biomight.system.skeletal.leg.femur.TrochanterLateralSurface;
import biomight.system.skeletal.leg.femur.TrochanterMedialSurface;
import biomight.system.skeletal.leg.femur.TrochanterNeck;
import biomight.system.skeletal.leg.femur.TrochantericFossa;
import biomight.system.skeletal.leg.tibia.LateralCondyle;
import biomight.system.skeletal.leg.tibia.MedialCondyle;
import biomight.system.skeletal.leg.tibia.Tibia;
import biomight.system.skeletal.leg.tibia.TibiaCondyles;
import biomight.system.skeletal.leg.tibia.Tibias;
import biomight.system.skeletal.pelvis.IliumOld;
import biomight.system.skeletal.pelvis.Ischium;
import biomight.system.skeletal.pelvis.Pelvis;
import biomight.system.skeletal.pelvis.Pubis;
import biomight.system.skeletal.pelvis.SacrumBone;
import biomight.system.skeletal.pelvis.SymphysisPubis;
import biomight.system.skeletal.ribs.FalseRibs;
import biomight.system.skeletal.ribs.FloatingRibs;
import biomight.system.skeletal.ribs.Rib;
import biomight.system.skeletal.ribs.RibCage;
import biomight.system.skeletal.ribs.Ribs;
import biomight.system.skeletal.ribs.TrueRibs;
import biomight.system.skeletal.skull.Skull;
import biomight.system.skeletal.skull.cranial.CranialBones;
import biomight.system.skeletal.skull.cranial.EthmoidBone;
import biomight.system.skeletal.skull.cranial.FrontalBone;
import biomight.system.skeletal.skull.cranial.OccipitalBone;
import biomight.system.skeletal.skull.cranial.ParietalBones;
import biomight.system.skeletal.skull.cranial.SphenoidBone;
import biomight.system.skeletal.skull.cranial.TemporalBone;
import biomight.system.skeletal.skull.facial.FacialBones;
import biomight.system.skeletal.skull.facial.HyoidBone;
import biomight.system.skeletal.skull.facial.InferiorNasalConchaBone;
import biomight.system.skeletal.skull.facial.LacrimalBone;
import biomight.system.skeletal.skull.facial.MandibleBone;
import biomight.system.skeletal.skull.facial.MaxillaeBone;
import biomight.system.skeletal.skull.facial.PalatineBone;
import biomight.system.skeletal.skull.facial.VomerBone;
import biomight.system.skeletal.skull.facial.ZygomaticBone;
import biomight.system.skeletal.spine.CervicalVertebra;
import biomight.system.skeletal.spine.CervicalVertebrae;
import biomight.system.skeletal.spine.LumbarVertebra;
import biomight.system.skeletal.spine.LumbarVertebrae;
import biomight.system.skeletal.spine.SacralVertebra;
import biomight.system.skeletal.spine.SacralVertebrae;
import biomight.system.skeletal.spine.ThoracicVertebra;
import biomight.system.skeletal.spine.ThoracicVertebrae;
import biomight.system.skeletal.wrist.WristDistalRow;
import biomight.system.skeletal.wrist.WristProximalRow;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Vascular Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewSkeletal {

	
	public void BioMightViewVacular() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		String bioMightComponentID = bioMightComponent.getBioMightComponentID();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
		
		

		/**************************************************************************
		*
		* SKELETAL SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/		
		if (bioMightComponentRef.equals(Constants.SkeletalSystem))
		{
			SkeletalSystem skeletalSystem = (SkeletalSystem) bioMightInstance;
			bioMightComponent.setImage(skeletalSystem.getImage());
			bioMightComponent.setWidth(skeletalSystem.getImageWidth());
			bioMightComponent.setHeight(skeletalSystem.getImageHeight());
			bioMightComponent.setBioMightProperties(skeletalSystem.getProperties());
			bioMightComponent.setBioMightMethods(skeletalSystem.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SkeletalSystem: "  +  "     ID: " + skeletalSystem.getComponentID() + "  " + bioMightComponentName);				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(skeletalSystem.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			//System.out.println("In Skelly Mapper");
			//bioMightComponent.dumpProperties();
			bioMightComponent.setX3D(skeletalSystem.getX3D(snippet));	
		}
		
		//*****************************************************************************
		// biomight.system.skeletal.neck
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.CervicalVertebrae))
		{
			CervicalVertebrae cervicalVertebrae = (CervicalVertebrae) bioMightInstance;
			bioMightComponent.setImage(cervicalVertebrae.getImage());
			bioMightComponent.setWidth(cervicalVertebrae.getImageWidth());
			bioMightComponent.setHeight(cervicalVertebrae.getImageHeight());
			bioMightComponent.setBioMightProperties(cervicalVertebrae.getProperties());
			bioMightComponent.setBioMightMethods(cervicalVertebrae.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for cervicalVertebrae: "  + bioMightComponentRef +  "     ID: " + cervicalVertebrae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cervicalVertebrae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing cervicalVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			System.out.println("Getting X3D for cervicalVertebrae");
			bioMightComponent.setX3D(cervicalVertebrae.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.CervicalVertebra))
		{
			CervicalVertebra cervicalVertebra = (CervicalVertebra) bioMightInstance;
			bioMightComponent.setImage(cervicalVertebra.getImage());
			bioMightComponent.setWidth(cervicalVertebra.getImageWidth());
			bioMightComponent.setHeight(cervicalVertebra.getImageHeight());
			bioMightComponent.setBioMightProperties(cervicalVertebra.getProperties());
			bioMightComponent.setBioMightMethods(cervicalVertebra.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for cervicalVertebra: "  + bioMightComponentRef +  "     ID: " + cervicalVertebra.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cervicalVertebra.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing cervicalVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			System.out.println("Getting X3D for cervicalVertebra");
			bioMightComponent.setX3D(cervicalVertebra.getX3D(snippet));	
		}	
		
		//*****************************************************************************
		// biomight.system.skeletal.spine
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.ThoracicVertebrae))
		{
			ThoracicVertebrae thoracicVertebrae = (ThoracicVertebrae) bioMightInstance;
			bioMightComponent.setImage(thoracicVertebrae.getImage());
			bioMightComponent.setWidth(thoracicVertebrae.getImageWidth());
			bioMightComponent.setHeight(thoracicVertebrae.getImageHeight());
			bioMightComponent.setBioMightProperties(thoracicVertebrae.getProperties());
			bioMightComponent.setBioMightMethods(thoracicVertebrae.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for thoracicVertebrae: "  + bioMightComponentRef +  "     ID: " + thoracicVertebrae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thoracicVertebrae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing thoracicVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for ThoracicVertebrae");
			bioMightComponent.setX3D(thoracicVertebrae.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.ThoracicVertebra))
		{
			ThoracicVertebra thoracicVertebra = (ThoracicVertebra) bioMightInstance;
			bioMightComponent.setImage(thoracicVertebra.getImage());
			bioMightComponent.setWidth(thoracicVertebra.getImageWidth());
			bioMightComponent.setHeight(thoracicVertebra.getImageHeight());
			bioMightComponent.setBioMightProperties(thoracicVertebra.getProperties());
			bioMightComponent.setBioMightMethods(thoracicVertebra.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for thoracicVertebra: "  + bioMightComponentRef +  "     ID: " + thoracicVertebra.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thoracicVertebra.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing thoracicVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for thoracicVertebra");
			bioMightComponent.setX3D(thoracicVertebra.getX3D(snippet));	
		}	
		else if (bioMightComponentRef.equals(Constants.LumbarVertebrae))
		{
			LumbarVertebrae lumbarVertebrae = (LumbarVertebrae) bioMightInstance;
			bioMightComponent.setImage(lumbarVertebrae.getImage());
			bioMightComponent.setWidth(lumbarVertebrae.getImageWidth());
			bioMightComponent.setHeight(lumbarVertebrae.getImageHeight());
			bioMightComponent.setBioMightProperties(lumbarVertebrae.getProperties());
			bioMightComponent.setBioMightMethods(lumbarVertebrae.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for lumbarVertebrae: "  + bioMightComponentRef +  "     ID: " + lumbarVertebrae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lumbarVertebrae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing lumbarVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for lumbarVertebrae");
			bioMightComponent.setX3D(lumbarVertebrae.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.LumbarVertebra))
		{
			LumbarVertebra lumbarVertebra = (LumbarVertebra) bioMightInstance;
			bioMightComponent.setImage(lumbarVertebra.getImage());
			bioMightComponent.setWidth(lumbarVertebra.getImageWidth());
			bioMightComponent.setHeight(lumbarVertebra.getImageHeight());
			bioMightComponent.setBioMightProperties(lumbarVertebra.getProperties());
			bioMightComponent.setBioMightMethods(lumbarVertebra.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for lumbarVertebra: "  + bioMightComponentRef +  "     ID: " + lumbarVertebra.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lumbarVertebra.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing lumbarVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for lumbarVertebra");
			bioMightComponent.setX3D(lumbarVertebra.getX3D(snippet));	
		}	
		else if (bioMightComponentRef.equals(Constants.SacralVertebrae))
		{
			SacralVertebrae sacralVertebrae = (SacralVertebrae) bioMightInstance;
			bioMightComponent.setImage(sacralVertebrae.getImage());
			bioMightComponent.setWidth(sacralVertebrae.getImageWidth());
			bioMightComponent.setHeight(sacralVertebrae.getImageHeight());
			bioMightComponent.setBioMightProperties(sacralVertebrae.getProperties());
			bioMightComponent.setBioMightMethods(sacralVertebrae.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for sacralVertebrae: "  + bioMightComponentRef +  "     ID: " + sacralVertebrae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(sacralVertebrae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing sacralVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for sacralVertebrae");
			bioMightComponent.setX3D(sacralVertebrae.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.SacralVertebra))
		{
			SacralVertebra sacralVertebra = (SacralVertebra) bioMightInstance;
			bioMightComponent.setImage(sacralVertebra.getImage());
			bioMightComponent.setWidth(sacralVertebra.getImageWidth());
			bioMightComponent.setHeight(sacralVertebra.getImageHeight());
			bioMightComponent.setBioMightProperties(sacralVertebra.getProperties());
			bioMightComponent.setBioMightMethods(sacralVertebra.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for sacralVertebra: "  + bioMightComponentRef +  "     ID: " + sacralVertebra.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(sacralVertebra.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing sacralVertebra Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for sacralVertebra");
			bioMightComponent.setX3D(sacralVertebra.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Radii))
		{
			Radii radii = (Radii) bioMightInstance;
			bioMightComponent.setImage(radii.getImage());
			bioMightComponent.setWidth(radii.getImageWidth());
			bioMightComponent.setHeight(radii.getImageHeight());
			bioMightComponent.setBioMightProperties(radii.getProperties());
			bioMightComponent.setBioMightMethods(radii.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Radii: "  + bioMightComponentRef +  "  ID: " + radii.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(radii.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			bioMightComponent.setX3D(radii.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Ribs))
		{
			Ribs ribs = (Ribs) bioMightInstance;
			bioMightComponent.setImage(ribs.getImage());
			bioMightComponent.setWidth(ribs.getImageWidth());
			bioMightComponent.setHeight(ribs.getImageHeight());
			bioMightComponent.setBioMightProperties(ribs.getProperties());
			bioMightComponent.setBioMightMethods(ribs.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Radii: "  + bioMightComponentRef +  "  ID: " + ribs.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ribs.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			bioMightComponent.setX3D(ribs.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Rib))
		{
			Rib rib = (Rib) bioMightInstance;
			bioMightComponent.setImage(rib.getImage());
			bioMightComponent.setWidth(rib.getImageWidth());
			bioMightComponent.setHeight(rib.getImageHeight());
			bioMightComponent.setBioMightProperties(rib.getProperties());
			bioMightComponent.setBioMightMethods(rib.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Rib: "  + bioMightComponentRef +  "  ID: " + rib.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(rib.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			bioMightComponent.setX3D(rib.getX3D(snippet));
		}
		
		
		//*****************************************************************************
		// biomight.system.skeletal.arm
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.Humeri))
		{
			Humeri humeri = (Humeri) bioMightInstance;
			bioMightComponent.setImage(humeri.getImage());
			bioMightComponent.setWidth(humeri.getImageWidth());
			bioMightComponent.setHeight(humeri.getImageHeight());
			bioMightComponent.setBioMightProperties(humeri.getProperties());
			bioMightComponent.setBioMightMethods(humeri.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Humeri: "  + bioMightComponentRef +  "  ID: " + humeri.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(humeri.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing CHEST Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing humerus!");
				//humerus.redraw(0);
			}
			bioMightComponent.setX3D(humeri.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.Humerus))
		{
			Humerus humerus = (Humerus) bioMightInstance;
			bioMightComponent.setImage(humerus.getImage());
			bioMightComponent.setWidth(humerus.getImageWidth());
			bioMightComponent.setHeight(humerus.getImageHeight());
			bioMightComponent.setBioMightProperties(humerus.getProperties());
			bioMightComponent.setBioMightMethods(humerus.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Humerus: "  + bioMightComponentRef +  "  ID: " + humerus.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(humerus.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing CHEST Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing humerus!");
				//humerus.redraw(0);
			}
			bioMightComponent.setX3D(humerus.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.Radii))
		{
			Radii radii = (Radii) bioMightInstance;
			bioMightComponent.setImage(radii.getImage());
			bioMightComponent.setWidth(radii.getImageWidth());
			bioMightComponent.setHeight(radii.getImageHeight());
			bioMightComponent.setBioMightProperties(radii.getProperties());
			bioMightComponent.setBioMightMethods(radii.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Radii: "  + bioMightComponentRef +  "  ID: " + radii.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(radii.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			bioMightComponent.setX3D(radii.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Radius))
		{
			Radius radius = (Radius) bioMightInstance;
			bioMightComponent.setImage(radius.getImage());
			bioMightComponent.setWidth(radius.getImageWidth());
			bioMightComponent.setHeight(radius.getImageHeight());
			bioMightComponent.setBioMightProperties(radius.getProperties());
			bioMightComponent.setBioMightMethods(radius.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Radius: "  + bioMightComponentRef +  "  ID: " + radius.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(radius.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing CHEST Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing humerus!");
				//radius.redraw(0);
			}
			bioMightComponent.setX3D(radius.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Ulnae))
		{
			Ulnae ulnae = (Ulnae) bioMightInstance;
			bioMightComponent.setImage(ulnae.getImage());
			bioMightComponent.setWidth(ulnae.getImageWidth());
			bioMightComponent.setHeight(ulnae.getImageHeight());
			bioMightComponent.setBioMightProperties(ulnae.getProperties());
			bioMightComponent.setBioMightMethods(ulnae.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Ulna: "  + bioMightComponentRef +  "  ID: " + ulnae.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ulnae.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing Ulna Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing Ulna!");
				//ulnae.redraw(0);
			}
			bioMightComponent.setX3D(ulnae.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.Ulna))
		{
			Ulna ulna = (Ulna) bioMightInstance;
			bioMightComponent.setImage(ulna.getImage());
			bioMightComponent.setWidth(ulna.getImageWidth());
			bioMightComponent.setHeight(ulna.getImageHeight());
			bioMightComponent.setBioMightProperties(ulna.getProperties());
			bioMightComponent.setBioMightMethods(ulna.getMethods());
			bioMightComponent.setBioMightCollection(false);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Ulna: "  + bioMightComponentRef +  "  ID: " + ulna.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ulna.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing Ulna Methods!");
				//neck.executeMethods(methodParams);
				//System.out.println("Redrawing Ulna!");
				//ulna.redraw(0);
			}
			bioMightComponent.setX3D(ulna.getX3D(snippet));			
		}
		//*****************************************************************************
		// biomight.system.skeletal.chest
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.Clavicle))
		{
			Clavicle clavicle = (Clavicle) bioMightInstance;
			bioMightComponent.setImage(clavicle.getImage());
			bioMightComponent.setWidth(clavicle.getImageWidth());
			bioMightComponent.setHeight(clavicle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Scapula))
		{
			Scapula scapula = (Scapula) bioMightInstance;
			bioMightComponent.setImage(scapula.getImage());
			bioMightComponent.setWidth(scapula.getImageWidth());
			bioMightComponent.setHeight(scapula.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Sternum))
		{
			Sternum sternum = (Sternum) bioMightInstance;
			bioMightComponent.setImage(sternum.getImage());
			bioMightComponent.setWidth(sternum.getImageWidth());
			bioMightComponent.setHeight(sternum.getImageHeight());
			bioMightComponent.setBioMightProperties(sternum.getProperties());
			bioMightComponent.setBioMightMethods(sternum.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Sternum: "  + bioMightComponentRef +  "     ID: " + sternum.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(sternum.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			System.out.println("Getting X3D for Sternum!");
			bioMightComponent.setX3D(sternum.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.XiphoidProcess))
		{
			XiphoidProcess xiphoidProcess = (XiphoidProcess) bioMightInstance;
			bioMightComponent.setImage(xiphoidProcess.getImage());
			bioMightComponent.setWidth(xiphoidProcess.getImageWidth());
			bioMightComponent.setHeight(xiphoidProcess.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.skeletal.foot
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.CalcaneusBone))
		{
			CalcaneusBone calcaneusBone = (CalcaneusBone) bioMightInstance;
			bioMightComponent.setImage(calcaneusBone.getImage());
			bioMightComponent.setWidth(calcaneusBone.getImageWidth());
			bioMightComponent.setHeight(calcaneusBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CuboidBone))
		{
			CuboidBone cuboidBone = (CuboidBone) bioMightInstance;
			bioMightComponent.setImage(cuboidBone.getImage());
			bioMightComponent.setWidth(cuboidBone.getImageWidth());
			bioMightComponent.setHeight(cuboidBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HandDistalPhalanges))
		{
			HandDistalPhalanges handDistalPhalanages = (HandDistalPhalanges) bioMightInstance;
			bioMightComponent.setImage(handDistalPhalanages.getImage());
			bioMightComponent.setWidth(handDistalPhalanages.getImageWidth());
			bioMightComponent.setHeight(handDistalPhalanages.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HandMiddlePhalanges))
		{
			HandMiddlePhalanges handMiddlePhalanges = (HandMiddlePhalanges) bioMightInstance;
			bioMightComponent.setImage(handMiddlePhalanges.getImage());
			bioMightComponent.setWidth(handMiddlePhalanges.getImageWidth());
			bioMightComponent.setHeight(handMiddlePhalanges.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LateralCuneiformBone))
		{
			LateralCuneiformBone lateralCuneiformBone = (LateralCuneiformBone) bioMightInstance;
			bioMightComponent.setImage(lateralCuneiformBone.getImage());
			bioMightComponent.setWidth(lateralCuneiformBone.getImageWidth());
			bioMightComponent.setHeight(lateralCuneiformBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MetaTarsalsBone))
		{
			MetaTarsalsBone metaTarsalsBone = (MetaTarsalsBone) bioMightInstance;
			bioMightComponent.setImage(metaTarsalsBone.getImage());
			bioMightComponent.setWidth(metaTarsalsBone.getImageWidth());
			bioMightComponent.setHeight(metaTarsalsBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.NavicularCuneiforms))
		{
			NavicularCuneiforms navicularCuneiforms = (NavicularCuneiforms) bioMightInstance;
			bioMightComponent.setImage(navicularCuneiforms.getImage());
			bioMightComponent.setWidth(navicularCuneiforms.getImageWidth());
			bioMightComponent.setHeight(navicularCuneiforms.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HandMiddlePhalanges))
		{
			//Phalanges phalanges = (Phalanges) bioMightInstance;
			//bioMightComponent.setImage(phalanges.getImage());
			//bioMightComponent.setWidth(phalanges.getImageWidth());
			//bioMightComponent.setHeight(phalanges.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HandProximalPhalanges))
		{
			ProximalPhalanges proximalPhalanges = (ProximalPhalanges) bioMightInstance;
			bioMightComponent.setImage(proximalPhalanges.getImage());
			bioMightComponent.setWidth(proximalPhalanges.getImageWidth());
			bioMightComponent.setHeight(proximalPhalanges.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TalusBone))
		{
			TalusBone talusBone = (TalusBone) bioMightInstance;
			bioMightComponent.setImage(talusBone.getImage());
			bioMightComponent.setWidth(talusBone.getImageWidth());
			bioMightComponent.setHeight(talusBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Tarsals))
		{
			Tarsals tarsals = (Tarsals) bioMightInstance;
			bioMightComponent.setImage(tarsals.getImage());
			bioMightComponent.setWidth(tarsals.getImageWidth());
			bioMightComponent.setHeight(tarsals.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.skeletal.hand
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.CapitateBone))
		{
			CapitateBone capitateBone = (CapitateBone) bioMightInstance;
			bioMightComponent.setImage(capitateBone.getImage());
			bioMightComponent.setWidth(capitateBone.getImageWidth());
			bioMightComponent.setHeight(capitateBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Carpals))
		{
			Carpals carpals = (Carpals) bioMightInstance;
			bioMightComponent.setImage(carpals.getImage());
			bioMightComponent.setWidth(carpals.getImageWidth());
			bioMightComponent.setHeight(carpals.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DipJoint))
		{
			DipJoint dipJoint = (DipJoint) bioMightInstance;
			bioMightComponent.setImage(dipJoint.getImage());
			bioMightComponent.setWidth(dipJoint.getImageWidth());
			bioMightComponent.setHeight(dipJoint.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DistalPhalanx))
		{
			DistalPhalanx distalPhalanx = (DistalPhalanx) bioMightInstance;
			bioMightComponent.setImage(distalPhalanx.getImage());
			bioMightComponent.setWidth(distalPhalanx.getImageWidth());
			bioMightComponent.setHeight(distalPhalanx.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HamateCapitateBone))
		{
			HamateCapitateBone hamateCapitateBone = (HamateCapitateBone) bioMightInstance;
			bioMightComponent.setImage(hamateCapitateBone.getImage());
			bioMightComponent.setWidth(hamateCapitateBone.getImageWidth());
			bioMightComponent.setHeight(hamateCapitateBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LunateBone))
		{
			LunateBone lunateBone = (LunateBone) bioMightInstance;
			bioMightComponent.setImage(lunateBone.getImage());
			bioMightComponent.setWidth(lunateBone.getImageWidth());
			bioMightComponent.setHeight(lunateBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MetaCarpals))
		{
			MetaCarpals metaCarpals = (MetaCarpals) bioMightInstance;
			bioMightComponent.setImage(metaCarpals.getImage());
			bioMightComponent.setWidth(metaCarpals.getImageWidth());
			bioMightComponent.setHeight(metaCarpals.getImageHeight());
			bioMightComponent.setBioMightProperties(metaCarpals.getProperties());
			bioMightComponent.setBioMightMethods(metaCarpals.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MetaCarpals: "  + bioMightComponentRef +  "     ID: " + metaCarpals.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(metaCarpals.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			bioMightComponent.setX3D(metaCarpals.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.MiddlePhalanx))
		{
			MiddlePhalanx middlePhalanx = (MiddlePhalanx) bioMightInstance;
			bioMightComponent.setImage(middlePhalanx.getImage());
			bioMightComponent.setWidth(middlePhalanx.getImageWidth());
			bioMightComponent.setHeight(middlePhalanx.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FootMiddlePhalanges))
		{
			Phalangesfoot phalanges = (Phalangesfoot) bioMightInstance;
			bioMightComponent.setImage(phalanges.getImage());
			bioMightComponent.setWidth(phalanges.getImageWidth());
			bioMightComponent.setHeight(phalanges.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PipJoint))
		{
			PipJoint pipJoint = (PipJoint) bioMightInstance;
			bioMightComponent.setImage(pipJoint.getImage());
			bioMightComponent.setWidth(pipJoint.getImageWidth());
			bioMightComponent.setHeight(pipJoint.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PisiformTriquetrumBone))
		{
			PisiformTriquetrumBone pisiformTriquetrumBone = (PisiformTriquetrumBone) bioMightInstance;
			bioMightComponent.setImage(pisiformTriquetrumBone.getImage());
			bioMightComponent.setWidth(pisiformTriquetrumBone.getImageWidth());
			bioMightComponent.setHeight(pisiformTriquetrumBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ProximalPhalanx))
		{
			ProximalPhalanx proximalPhalanx = (ProximalPhalanx) bioMightInstance;
			bioMightComponent.setImage(proximalPhalanx.getImage());
			bioMightComponent.setWidth(proximalPhalanx.getImageWidth());
			bioMightComponent.setHeight(proximalPhalanx.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RadialStyloidProcess))
		{
			RadialStyloidProcess radialStyloidProcess = (RadialStyloidProcess) bioMightInstance;
			bioMightComponent.setImage(radialStyloidProcess.getImage());
			bioMightComponent.setWidth(radialStyloidProcess.getImageWidth());
			bioMightComponent.setHeight(radialStyloidProcess.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ScaphoidBone))
		{
			ScaphoidBone scaphoidBone = (ScaphoidBone) bioMightInstance;
			bioMightComponent.setImage(scaphoidBone.getImage());
			bioMightComponent.setWidth(scaphoidBone.getImageWidth());
			bioMightComponent.setHeight(scaphoidBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrapeziumBone))
		{
			TrapeziumBone trapeziumBone = (TrapeziumBone) bioMightInstance;
			bioMightComponent.setImage(trapeziumBone.getImage());
			bioMightComponent.setWidth(trapeziumBone.getImageWidth());
			bioMightComponent.setHeight(trapeziumBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TriquetralBone))
		{
			TriquetralBone triquetralBone = (TriquetralBone) bioMightInstance;
			bioMightComponent.setImage(triquetralBone.getImage());
			bioMightComponent.setWidth(triquetralBone.getImageWidth());
			bioMightComponent.setHeight(triquetralBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.UlnarStyloidProcess))
		{
			UlnarStyloidProcess ulnarStyloidProcess = (UlnarStyloidProcess) bioMightInstance;
			bioMightComponent.setImage(ulnarStyloidProcess.getImage());
			bioMightComponent.setWidth(ulnarStyloidProcess.getImageWidth());
			bioMightComponent.setHeight(ulnarStyloidProcess.getImageHeight());
		}			
		//*****************************************************************************
		// biomight.system.skeletal.leg
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.Fibulas))
		{
			Fibulas fibulas = (Fibulas) bioMightInstance;
			bioMightComponent.setImage(fibulas.getImage());
			bioMightComponent.setWidth(fibulas.getImageWidth());
			bioMightComponent.setHeight(fibulas.getImageHeight());
			bioMightComponent.setBioMightProperties(fibulas.getProperties());
			bioMightComponent.setBioMightMethods(fibulas.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Fibulas: "  + bioMightComponentRef +  "     ID: " + fibulas.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(fibulas.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			bioMightComponent.setX3D(fibulas.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Fibula))
		{
			Fibula fibula = (Fibula) bioMightInstance;
			bioMightComponent.setImage(fibula.getImage());
			bioMightComponent.setWidth(fibula.getImageWidth());
			bioMightComponent.setHeight(fibula.getImageHeight());
			bioMightComponent.setBioMightProperties(fibula.getProperties());
			bioMightComponent.setBioMightMethods(fibula.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Fibula: "  + bioMightComponentRef +  "     ID: " + fibula.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(fibula.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			//System.out.println("Getting X3D for Fibula!");
			bioMightComponent.setX3D(fibula.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Patella))
		{
			Patella patella = (Patella) bioMightInstance;
			bioMightComponent.setImage(patella.getImage());
			bioMightComponent.setWidth(patella.getImageWidth());
			bioMightComponent.setHeight(patella.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.skeletal.leg.femur
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.Femurs))
		{
			Femurs femurs = (Femurs) bioMightInstance;
			bioMightComponent.setImage(femurs.getImage());
			bioMightComponent.setWidth(femurs.getImageWidth());
			bioMightComponent.setHeight(femurs.getImageHeight());
			bioMightComponent.setBioMightProperties(femurs.getProperties());
			bioMightComponent.setBioMightMethods(femurs.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Femurs: "  + bioMightComponentRef +  "     ID: " + femurs.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(femurs.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			bioMightComponent.setX3D(femurs.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Femur))
		{
			Femur femur = (Femur) bioMightInstance;
			bioMightComponent.setImage(femur.getImage());
			bioMightComponent.setWidth(femur.getImageWidth());
			bioMightComponent.setHeight(femur.getImageHeight());
			bioMightComponent.setBioMightProperties(femur.getProperties());
			bioMightComponent.setBioMightMethods(femur.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Femur: "  + bioMightComponentRef +  "     ID: " + femur.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(femur.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	femur.executeMethods(methodParams);
			//	femur.redraw(0);
			//}
			bioMightComponent.setX3D(femur.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.FoveaCapitis))
		{
			FoveaCapitis foveaCapitis = (FoveaCapitis) bioMightInstance;
			bioMightComponent.setImage(foveaCapitis.getImage());
			bioMightComponent.setWidth(foveaCapitis.getImageWidth());
			bioMightComponent.setHeight(foveaCapitis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GreaterTrochanter))
		{
			GreaterTrochanter greaterTrochanter = (GreaterTrochanter) bioMightInstance;
			bioMightComponent.setImage(greaterTrochanter.getImage());
			bioMightComponent.setWidth(greaterTrochanter.getImageWidth());
			bioMightComponent.setHeight(greaterTrochanter.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LesserTrochanter))
		{
			LesserTrochanter lesserTrochanter = (LesserTrochanter) bioMightInstance;
			bioMightComponent.setImage(lesserTrochanter.getImage());
			bioMightComponent.setWidth(lesserTrochanter.getImageWidth());
			bioMightComponent.setHeight(lesserTrochanter.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PiriFormis))
		{
			PiriFormis piriFormis = (PiriFormis) bioMightInstance;
			bioMightComponent.setImage(piriFormis.getImage());
			bioMightComponent.setWidth(piriFormis.getImageWidth());
			bioMightComponent.setHeight(piriFormis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrochanterHead))
		{
			TrochanterHead trochanterHead = (TrochanterHead) bioMightInstance;
			bioMightComponent.setImage(trochanterHead.getImage());
			bioMightComponent.setWidth(trochanterHead.getImageWidth());
			bioMightComponent.setHeight(trochanterHead.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrochantericFossa))
		{
			TrochantericFossa trochantericFossa = (TrochantericFossa) bioMightInstance;
			bioMightComponent.setImage(trochantericFossa.getImage());
			bioMightComponent.setWidth(trochantericFossa.getImageWidth());
			bioMightComponent.setHeight(trochantericFossa.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrochanterLateralSurface))
		{
			TrochanterLateralSurface trochanterLateralSurface = (TrochanterLateralSurface) bioMightInstance;
			bioMightComponent.setImage(trochanterLateralSurface.getImage());
			bioMightComponent.setWidth(trochanterLateralSurface.getImageWidth());
			bioMightComponent.setHeight(trochanterLateralSurface.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrochanterMedialSurface))
		{
			TrochanterMedialSurface trochanterMedialSurface = (TrochanterMedialSurface) bioMightInstance;
			bioMightComponent.setImage(trochanterMedialSurface.getImage());
			bioMightComponent.setWidth(trochanterMedialSurface.getImageWidth());
			bioMightComponent.setHeight(trochanterMedialSurface.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TrochanterNeck))
		{
			TrochanterNeck trochanterNeck = (TrochanterNeck) bioMightInstance;
			bioMightComponent.setImage(trochanterNeck.getImage());
			bioMightComponent.setWidth(trochanterNeck.getImageWidth());
			bioMightComponent.setHeight(trochanterNeck.getImageHeight());
		}			
		//*****************************************************************************
		// biomight.system.skeletal.leg.tibia
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.LateralCondyle))
		{
			LateralCondyle lateralCondyle = (LateralCondyle) bioMightInstance;
			bioMightComponent.setImage(lateralCondyle.getImage());
			bioMightComponent.setWidth(lateralCondyle.getImageWidth());
			bioMightComponent.setHeight(lateralCondyle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MedialCondyle))
		{
			MedialCondyle medialCondyle = (MedialCondyle) bioMightInstance;
			bioMightComponent.setImage(medialCondyle.getImage());
			bioMightComponent.setWidth(medialCondyle.getImageWidth());
			bioMightComponent.setHeight(medialCondyle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Tibias))
		{
			Tibias tibias = (Tibias) bioMightInstance;
			bioMightComponent.setImage(tibias.getImage());
			bioMightComponent.setWidth(tibias.getImageWidth());
			bioMightComponent.setHeight(tibias.getImageHeight());
			bioMightComponent.setHeight(tibias.getImageHeight());
			bioMightComponent.setBioMightProperties(tibias.getProperties());
			bioMightComponent.setBioMightMethods(tibias.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Tibias: "  + bioMightComponentRef +  "     ID: " + tibias.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(tibias.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			bioMightComponent.setX3D(tibias.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Tibia))
		{
			Tibia tibia = (Tibia) bioMightInstance;
			bioMightComponent.setImage(tibia.getImage());
			bioMightComponent.setWidth(tibia.getImageWidth());
			bioMightComponent.setHeight(tibia.getImageHeight());
			bioMightComponent.setHeight(tibia.getImageHeight());
			bioMightComponent.setBioMightProperties(tibia.getProperties());
			bioMightComponent.setBioMightMethods(tibia.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Tibia: "  + bioMightComponentRef +  "     ID: " + tibia.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(tibia.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	tibia.executeMethods(methodParams);
			//	tibia.redraw(0);
			//}
			bioMightComponent.setX3D(tibia.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.TibiaCondyles))
		{
			TibiaCondyles tibiaCondyles = (TibiaCondyles) bioMightInstance;
			bioMightComponent.setImage(tibiaCondyles.getImage());
			bioMightComponent.setWidth(tibiaCondyles.getImageWidth());
			bioMightComponent.setHeight(tibiaCondyles.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.skeletal.pelvis
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.Hips))
		{
			Hips hips = (Hips) bioMightInstance;
			bioMightComponent.setImage(hips.getImage());
			bioMightComponent.setWidth(hips.getImageWidth());
			bioMightComponent.setHeight(hips.getImageHeight());
			bioMightComponent.setBioMightProperties(hips.getProperties());
			bioMightComponent.setBioMightMethods(hips.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hips: "  + bioMightComponentRef +  "     ID: " +hips.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hips.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hips Methods!");
			//	hips.executeMethods(methodParams);
			//	hips.redraw(0);
			//}
			bioMightComponent.setX3D(hips.getX3D(snippet));								
		}
		else if (bioMightComponentRef.equals(Constants.Hip))
		{
			Hip hip = (Hip) bioMightInstance;
			bioMightComponent.setImage(hip.getImage());
			bioMightComponent.setWidth(hip.getImageWidth());
			bioMightComponent.setHeight(hip.getImageHeight());
			bioMightComponent.setBioMightProperties(hip.getProperties());
			bioMightComponent.setBioMightMethods(hip.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Hip: "  + bioMightComponentRef +  "     ID: " +hip.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hip.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Hips Methods!");
			//	hip.executeMethods(methodParams);
			//	hip.redraw(0);
			//}
			bioMightComponent.setX3D(hip.getX3D(snippet));								

		}
		else if (bioMightComponentRef.equals(Constants.Ilium))
		{
			IliumOld iliumBone = (IliumOld) bioMightInstance;
			bioMightComponent.setImage(iliumBone.getImage());
			bioMightComponent.setWidth(iliumBone.getImageWidth());
			bioMightComponent.setHeight(iliumBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Ischium))
		{
			Ischium ischium = (Ischium) bioMightInstance;
			bioMightComponent.setImage(ischium.getImage());
			bioMightComponent.setWidth(ischium.getImageWidth());
			bioMightComponent.setHeight(ischium.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.Pelvis))
		{
			Pelvis pelvis = (Pelvis) bioMightInstance;
			bioMightComponent.setImage(pelvis.getImage());
			bioMightComponent.setWidth(pelvis.getImageWidth());
			bioMightComponent.setHeight(pelvis.getImageHeight());
			bioMightComponent.setBioMightProperties(pelvis.getProperties());
			bioMightComponent.setBioMightMethods(pelvis.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Pelvis: "  + bioMightComponentRef +  "     ID: " +pelvis.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pelvis.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Pelviss Methods!");
			//	pelvis.executeMethods(methodParams);
			//	pelvis.redraw(0);
			//}
			bioMightComponent.setX3D(pelvis.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.Pubis))
		{
			Pubis pubis = (Pubis) bioMightInstance;
			bioMightComponent.setImage(pubis.getImage());
			bioMightComponent.setWidth(pubis.getImageWidth());
			bioMightComponent.setHeight(pubis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SacrumBone))
		{
			SacrumBone sacrumBone = (SacrumBone) bioMightInstance;
			bioMightComponent.setImage(sacrumBone.getImage());
			bioMightComponent.setWidth(sacrumBone.getImageWidth());
			bioMightComponent.setHeight(sacrumBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SymphysisPubis))
		{
			SymphysisPubis symphysisPubis = (SymphysisPubis) bioMightInstance;
			bioMightComponent.setImage(symphysisPubis.getImage());
			bioMightComponent.setWidth(symphysisPubis.getImageWidth());
			bioMightComponent.setHeight(symphysisPubis.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.skeletal.skull
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.Skull))
		{
			Skull skull = (Skull) bioMightInstance;
			bioMightComponent.setImage(skull.getImage());
			bioMightComponent.setWidth(skull.getImageWidth());
			bioMightComponent.setHeight(skull.getImageHeight());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Skull: "  + bioMightComponentRef +  "     ID: " + skull.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(skull.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	tibia.executeMethods(methodParams);
			//	tibia.redraw(0);
			//}
			
			bioMightComponent.setX3D(skull.getX3D(snippet));	
		}
		//*****************************************************************************
		// biomight.system.skeletal.skull.cranial
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.CranialBones))
		{
			CranialBones cranialBones = (CranialBones) bioMightInstance;
			bioMightComponent.setImage(cranialBones.getImage());
			bioMightComponent.setWidth(cranialBones.getImageWidth());
			bioMightComponent.setHeight(cranialBones.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.EthmoidBone))
		{
			EthmoidBone ethmoidBone = (EthmoidBone) bioMightInstance;
			bioMightComponent.setImage(ethmoidBone.getImage());
			bioMightComponent.setWidth(ethmoidBone.getImageWidth());
			bioMightComponent.setHeight(ethmoidBone.getImageHeight());
			bioMightComponent.setBioMightProperties(ethmoidBone.getProperties());
			bioMightComponent.setBioMightMethods(ethmoidBone.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for EthmoidBone: "  + bioMightComponentRef +  "     ID: " + ethmoidBone.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ethmoidBone.getComponentID());
			bioMightKeys.setKey(bioMightKey);
						
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Bladder Methods!");
			//	ethmoidBone.executeMethods(methodParams);
			//	ethmoidBone.redraw(0);
			//}
			System.out.println("Getting X3D for EthmoidBone!");
			bioMightComponent.setX3D(ethmoidBone.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.FrontalBone))
		{
			FrontalBone frontalBone = (FrontalBone) bioMightInstance;
			bioMightComponent.setImage(frontalBone.getImage());
			bioMightComponent.setWidth(frontalBone.getImageWidth());
			bioMightComponent.setHeight(frontalBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OccipitalBone))
		{
			OccipitalBone occipitalBone = (OccipitalBone) bioMightInstance;
			bioMightComponent.setImage(occipitalBone.getImage());
			bioMightComponent.setWidth(occipitalBone.getImageWidth());
			bioMightComponent.setHeight(occipitalBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ParietalBone))
		{
			ParietalBones parietalBone = (ParietalBones) bioMightInstance;
			bioMightComponent.setImage(parietalBone.getImage());
			bioMightComponent.setWidth(parietalBone.getImageWidth());
			bioMightComponent.setHeight(parietalBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SphenoidBone))
		{
			SphenoidBone sphenoidBone = (SphenoidBone) bioMightInstance;
			bioMightComponent.setImage(sphenoidBone.getImage());
			bioMightComponent.setWidth(sphenoidBone.getImageWidth());
			bioMightComponent.setHeight(sphenoidBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TemporalBone))
		{
			TemporalBone temporalBone = (TemporalBone) bioMightInstance;
			bioMightComponent.setImage(temporalBone.getImage());
			bioMightComponent.setWidth(temporalBone.getImageWidth());
			bioMightComponent.setHeight(temporalBone.getImageHeight());
		}			
		//*****************************************************************************
		// biomight.system.skeletal.skull.facial
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.FacialBones))
		{
			FacialBones facialBones = (FacialBones) bioMightInstance;
			bioMightComponent.setImage(facialBones.getImage());
			bioMightComponent.setWidth(facialBones.getImageWidth());
			bioMightComponent.setHeight(facialBones.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.HyoidBone))
		{
			HyoidBone hyoidBone = (HyoidBone) bioMightInstance;
			bioMightComponent.setImage(hyoidBone.getImage());
			bioMightComponent.setWidth(hyoidBone.getImageWidth());
			bioMightComponent.setHeight(hyoidBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InferiorNasalConchaBone))
		{
			InferiorNasalConchaBone inferiorNasalConchaBone = (InferiorNasalConchaBone) bioMightInstance;
			bioMightComponent.setImage(inferiorNasalConchaBone.getImage());
			bioMightComponent.setWidth(inferiorNasalConchaBone.getImageWidth());
			bioMightComponent.setHeight(inferiorNasalConchaBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LacrimalBone))
		{
			LacrimalBone lacrimalBone = (LacrimalBone) bioMightInstance;
			bioMightComponent.setImage(lacrimalBone.getImage());
			bioMightComponent.setWidth(lacrimalBone.getImageWidth());
			bioMightComponent.setHeight(lacrimalBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MandibleBone))
		{
			MandibleBone mandibleBone = (MandibleBone) bioMightInstance;
			bioMightComponent.setImage(mandibleBone.getImage());
			bioMightComponent.setWidth(mandibleBone.getImageWidth());
			bioMightComponent.setHeight(mandibleBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MaxillaeBone))
		{
			MaxillaeBone maxillaeBone = (MaxillaeBone) bioMightInstance;
			bioMightComponent.setImage(maxillaeBone.getImage());
			bioMightComponent.setWidth(maxillaeBone.getImageWidth());
			bioMightComponent.setHeight(maxillaeBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PalatineBone))
		{
			PalatineBone palatineBone = (PalatineBone) bioMightInstance;
			bioMightComponent.setImage(palatineBone.getImage());
			bioMightComponent.setWidth(palatineBone.getImageWidth());
			bioMightComponent.setHeight(palatineBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.VomerBone))
		{
			VomerBone vomerBone = (VomerBone) bioMightInstance;
			bioMightComponent.setImage(vomerBone.getImage());
			bioMightComponent.setWidth(vomerBone.getImageWidth());
			bioMightComponent.setHeight(vomerBone.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ZygomaticBone))
		{
			ZygomaticBone zygomaticBone = (ZygomaticBone) bioMightInstance;
			bioMightComponent.setImage(zygomaticBone.getImage());
			bioMightComponent.setWidth(zygomaticBone.getImageWidth());
			bioMightComponent.setHeight(zygomaticBone.getImageHeight());
		}			
		//*****************************************************************************
		// biomight.system.skeletal.wrist
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.WristDistalRow))
		{
			WristDistalRow wristDistalRow = (WristDistalRow) bioMightInstance;
			bioMightComponent.setImage(wristDistalRow.getImage());
			bioMightComponent.setWidth(wristDistalRow.getImageWidth());
			bioMightComponent.setHeight(wristDistalRow.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.WristProximalRow))
		{
			WristProximalRow wristProximalRow = (WristProximalRow) bioMightInstance;
			bioMightComponent.setImage(wristProximalRow.getImage());
			bioMightComponent.setWidth(wristProximalRow.getImageWidth());
			bioMightComponent.setHeight(wristProximalRow.getImageHeight());
		}
		else
		{
			System.out.println("BioMightView Tissue Component NOT MATCHED: " + bioMightComponentRef + "  " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
