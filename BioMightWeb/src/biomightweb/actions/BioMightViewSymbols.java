package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.body.Bursae;
import biomight.system.ligament.AnteriorSacrococcygealLigament;
import biomight.system.ligament.AnteriorSacroiliacLigament;
import biomight.system.ligament.GastrolienalLigament;
import biomight.system.ligament.IliolumbarLigament;
import biomight.system.ligament.InterosseousSacroiliacLigament;
import biomight.system.ligament.LateralSacrococcygealLigament;
import biomight.system.ligament.Ligament;
import biomight.system.ligament.Ligaments;
import biomight.system.ligament.LigamentumPubicumInferius;
import biomight.system.ligament.PhrenicolienalLigament;
import biomight.system.ligament.PosteriorSacrococcygealLigament;
import biomight.system.ligament.PosteriorSacroiliacLigament;
import biomight.system.ligament.RetinaculumMusculorumFlexorumPedis;
import biomight.system.ligament.ankle.AnteriorTalofibularLigament;
import biomight.system.ligament.ankle.CalcaneofibularLigament;
import biomight.system.ligament.ankle.DeltoidLigament;
import biomight.system.ligament.ankle.LongPlantarLigament;
import biomight.system.ligament.ankle.PosteriorTalofibularLigament;
import biomight.system.ligament.elbow.ElbowAnteriorLigament;
import biomight.system.ligament.elbow.ElbowPosteriorLigament;
import biomight.system.ligament.elbow.RadialCollateralLigament;
import biomight.system.ligament.elbow.UlnarCollateralLigament;
import biomight.system.ligament.hand.NatatoryLigament;
import biomight.system.ligament.hand.VolarCarpalLigament;
import biomight.system.ligament.hand.metacarpals.DorsalLigaments;
import biomight.system.ligament.hand.metacarpals.InterosseousLigaments;
import biomight.system.ligament.hand.metacarpals.VolarLigaments;
import biomight.system.ligament.head.mouth.PeriodontalLigament;
import biomight.system.ligament.hip.HipArticularCapsuleLigament;
import biomight.system.ligament.hip.HipGlenoidalLabrumLigament;
import biomight.system.ligament.hip.IlioFemoralLigament;
import biomight.system.ligament.hip.IschioCapsularLigament;
import biomight.system.ligament.hip.IschiofemoralLigament;
import biomight.system.ligament.hip.LigamentOfBigelow;
import biomight.system.ligament.hip.LigamentumTeresFemoris;
import biomight.system.ligament.hip.PubocapsularLigament;
import biomight.system.ligament.hip.PubofemoralLigament;
import biomight.system.ligament.hip.TransverseAcetabularLigament;
import biomight.system.ligament.intertarsal.AnteriorTalocalcanealLigament;
import biomight.system.ligament.intertarsal.BifurcatedLigament;
import biomight.system.ligament.intertarsal.DorsalCalcaneocuboidLigament;
import biomight.system.ligament.intertarsal.DorsalTalonavicularLigament;
import biomight.system.ligament.intertarsal.InterosseousTalocalcanealLigament;
import biomight.system.ligament.intertarsal.LateralTalocalcanealLigament;
import biomight.system.ligament.intertarsal.MedialTalocalcanealLigament;
import biomight.system.ligament.intertarsal.PlantarCalcaneocuboidLigament;
import biomight.system.ligament.intertarsal.PlantarCalcaneonavicularLigament;
import biomight.system.ligament.intertarsal.PosteriorTalocalcanealLigament;
import biomight.system.ligament.intertarsal.TalocalcanealArticulation;
import biomight.system.ligament.knee.AnteriorCruciateLigament;
import biomight.system.ligament.knee.FibularCollateralLigament;
import biomight.system.ligament.knee.KneeCoronaryLigament;
import biomight.system.ligament.knee.LateralCollateralLigament;
import biomight.system.ligament.knee.LateralMenisci;
import biomight.system.ligament.knee.LigamentOfWrisberg;
import biomight.system.ligament.knee.LigamentumPatellae;
import biomight.system.ligament.knee.MedialCollateralLigament;
import biomight.system.ligament.knee.ObliquePoplitealLigament;
import biomight.system.ligament.knee.PosteriorCruciateLigament;
import biomight.system.ligament.knee.ShortFibularCollateralLigament;
import biomight.system.ligament.knee.SynovialMembrane;
import biomight.system.ligament.knee.TibialCollateralLigament;
import biomight.system.ligament.mandible.ArticularCapsuleLigament;
import biomight.system.ligament.mandible.SphenomandibularLigament;
import biomight.system.ligament.mandible.StylomandibularLigament;
import biomight.system.ligament.mandible.TemporomandibularLigament;
import biomight.system.ligament.neck.CricoThyroidLigament;
import biomight.system.ligament.neck.VocalLigament;
import biomight.system.ligament.neck.VocalLigaments;
import biomight.system.ligament.radius.AnnularLigament;
import biomight.system.ligament.radius.DorsalRadioulnarLigament;
import biomight.system.ligament.radius.RadiusArticularDisk;
import biomight.system.ligament.radius.VolarRadioulnarLigament;
import biomight.system.ligament.ribs.InterarticularLigament;
import biomight.system.ligament.ribs.RadiateLigament;
import biomight.system.ligament.shoulder.CoracohumeralLigament;
import biomight.system.ligament.shoulder.GlenohumeralLigament;
import biomight.system.ligament.shoulder.GlenoidalLabrumLigament;
import biomight.system.ligament.shoulder.TransverseHumeralLigament;
import biomight.system.ligament.spinal.PosteriorAtlantoaxialLigament;
import biomight.system.ligament.sternum.CostoxiphoidLigament;
import biomight.system.ligament.sternum.InterarticularSternocostalLigament;
import biomight.system.ligament.sternum.RadiateSternocostalLigament;
import biomight.system.ligament.tibiafibula.AnteriorLigament;
import biomight.system.ligament.tibiafibula.InferiorTransverseLigament;
import biomight.system.ligament.tibiafibula.InterosseousLigament;
import biomight.system.ligament.tibiafibula.PosteriorLigament;
import biomight.system.ligament.tibiafibula.TibiaFibulaArticularCapsuleLigament;
import biomight.system.ligament.vertebral.AlarLigament;
import biomight.system.ligament.vertebral.AnteriorAtlantoaxialLigament;
import biomight.system.ligament.vertebral.AnteriorLongitudinalLigament;
import biomight.system.ligament.vertebral.InterspinalLigaments;
import biomight.system.ligament.vertebral.InterspinousLigament;
import biomight.system.ligament.vertebral.IntertransverseLigament;
import biomight.system.ligament.vertebral.IntertransverseLigaments;
import biomight.system.ligament.vertebral.LigamentaFlava;
import biomight.system.ligament.vertebral.LigamentumCoracohumerale;
import biomight.system.ligament.vertebral.LigamentumFlavumLigament;
import biomight.system.ligament.vertebral.LigamentumNuchaeLigament;
import biomight.system.ligament.vertebral.LliolumbarLigament;
import biomight.system.ligament.vertebral.MedialMenisci;
import biomight.system.ligament.vertebral.NuchaeLigament;
import biomight.system.ligament.vertebral.PosteriorAtlantoAxialLigament;
import biomight.system.ligament.vertebral.PosteriorLongitudinalLigament;
import biomight.system.ligament.vertebral.SacroiliacLigament;
import biomight.system.ligament.vertebral.SacrospinousLigament;
import biomight.system.ligament.vertebral.SacrotuberousLigament;
import biomight.system.ligament.vertebral.SupraspinalLigament;
import biomight.system.ligament.vertebral.SupraspinousLigament;
import biomight.system.ligament.vertebral.TransverseOfAtlasLigament;
import biomight.text.BioArrow;
import biomight.text.BioArrows;
import biomight.text.BioSymbols;
import biomight.text.BioText;
import biomight.text.BioTexts;
import biomightweb.view.BioMightComponent;

/**************************************************************************
 * 
 * Maps BioMight Symbols Components into the associated Java class.
 * 
 * SurferJim
 * 
 *************************************************************************/

public class BioMightViewSymbols {

	
	public void BioMightViewSymbols() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
	
		
		if (bioMightComponentRef.equals(Constants.BioSymbols))
		{
			BioSymbols bioSymbols = (BioSymbols) bioMightInstance;
			bioMightComponent.setImage(bioSymbols.getImage());
			bioMightComponent.setBioMightMethods(bioSymbols.getMethods());
			bioMightComponent.setBioMightProperties(bioSymbols.getProperties());
			bioMightComponent.setBioMightCollection(true);
	
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioSymbols.getComponentID());			
			System.out.println("Storing bioSymbolsKey: " + bioMightComponent + "   ID: " + bioSymbols.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	bioSymbols.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(bioSymbols.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.BioArrows))
		{
			BioArrows bioArrows = (BioArrows) bioMightInstance;
			bioMightComponent.setImage(bioArrows.getImage());
			bioMightComponent.setBioMightMethods(bioArrows.getMethods());
			bioMightComponent.setBioMightProperties(bioArrows.getProperties());
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioArrows.getComponentID());			
			System.out.println("Storing bioArrowsKey: " + bioMightComponent + "   ID: " + bioArrows.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(bioArrows.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.BioArrow))
		{
			BioArrow bioArrow = (BioArrow) bioMightInstance;
			bioMightComponent.setImage(bioArrow.getImage());
			bioMightComponent.setBioMightMethods(bioArrow.getMethods());
			bioMightComponent.setBioMightProperties(bioArrow.getProperties());
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioArrow.getComponentID());			
			System.out.println("Storing bioArrowKey: " + bioMightComponentName + "   ID: " + bioArrow.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(bioArrow.getX3D(snippet));	
		}	

		else if (bioMightComponentRef.equals(Constants.BioTexts))
		{
			BioTexts bioTexts = (BioTexts) bioMightInstance;
			bioMightComponent.setImage(bioTexts.getImage());
			bioMightComponent.setBioMightMethods(bioTexts.getMethods());
			bioMightComponent.setBioMightProperties(bioTexts.getProperties());
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioTexts.getComponentID());			
			System.out.println("Storing bioTextsKey: " + bioMightComponent + "   ID: " + bioTexts.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(bioTexts.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.BioText))
		{
			BioText bioText = (BioText) bioMightInstance;
			bioMightComponent.setImage(bioText.getImage());
			bioMightComponent.setBioMightMethods(bioText.getMethods());
			bioMightComponent.setBioMightProperties(bioText.getProperties());
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bioText.getComponentID());			
			System.out.println("Storing bioTextKey: " + bioMightComponent + "   ID: " + bioText.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(bioText.getX3D(snippet));	
		}	
		else
		{
			System.out.println("BioMightView Tissue Component NOT MATCHED: " + bioMightComponentRef + "  " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
