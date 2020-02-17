package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.system.MuscularSystem;
import biomight.system.muscular.LongRotatorsMuscle;
import biomight.system.muscular.LongusColliMuscle;
import biomight.system.muscular.PalmarisLongusMuscle;
import biomight.system.muscular.PlatysmaMuscle;
import biomight.system.muscular.TrapeziusMuscle;
import biomight.system.muscular.abdomen.CremasterMuscle;
import biomight.system.muscular.abdomen.ObliquusExternusAbdominisMuscle;
import biomight.system.muscular.abdomen.ObliquusInternusAbdominisMuscle;
import biomight.system.muscular.abdomen.PsoasMajorMuscle;
import biomight.system.muscular.abdomen.PsoasMinorMuscle;
import biomight.system.muscular.abdomen.PyramidalisMuscle;
import biomight.system.muscular.abdomen.QuadratusLumborumMuscle;
import biomight.system.muscular.abdomen.RectusAdominisMuscle;
import biomight.system.muscular.abdomen.TransversusAbdominisMuscle;
import biomight.system.muscular.arm.AnconeusMuscle;
import biomight.system.muscular.arm.BicepsBrachiiMuscle;
import biomight.system.muscular.arm.BrachialisMuscle;
import biomight.system.muscular.arm.BrachioradialisMuscle;
import biomight.system.muscular.arm.CoracoBrachialisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisBrevisMuscle;
import biomight.system.muscular.arm.ExtensorCarpiRadialisLongusMuscle;
import biomight.system.muscular.arm.ExtensorCarpiUlnarisMuscle;
import biomight.system.muscular.arm.ExtensorDigitiMinimiMuscle;
import biomight.system.muscular.arm.ExtensorDigitorumMuscle;
import biomight.system.muscular.arm.ExtensorPollicisLongusMuscle;
import biomight.system.muscular.arm.TricepsBrachiiMuscle;
import biomight.system.muscular.back.InterSpinalesMuscle;
import biomight.system.muscular.back.InterTransversariiMuscle;
import biomight.system.muscular.back.LongissimusCapitisMuscle;
import biomight.system.muscular.back.LongissimusCervicisMuscle;
import biomight.system.muscular.back.LongissimusCervicisMuscles;
import biomight.system.muscular.back.LongissimusDorsiMuscle;
import biomight.system.muscular.back.LongissimusThoracisMuscle;
import biomight.system.muscular.back.LongissimusThoracisMuscles;
import biomight.system.muscular.back.MultifudisSpinaeCervicalRegionLeft;
import biomight.system.muscular.back.RotatoresSpinaeMuscleLeft1;
import biomight.system.muscular.back.SacroSpinalisMuscle;
import biomight.system.muscular.back.SemiSpinalisMuscle;
import biomight.system.muscular.back.SpleniusCapitisMuscle;
import biomight.system.muscular.back.SpleniusCervicisMuscle;
import biomight.system.muscular.chest.DiaphragmMuscle;
import biomight.system.muscular.chest.IntercostalesExterniMuscles;
import biomight.system.muscular.chest.LevatoresCostarumMuscles;
import biomight.system.muscular.chest.PectoralisMajorMuscle;
import biomight.system.muscular.chest.PectoralisMajorMuscles;
import biomight.system.muscular.chest.PectoralisMinorMuscle;
import biomight.system.muscular.chest.PectoralisMinorMuscles;
import biomight.system.muscular.chest.SerratusPosteriorInferiorMuscle;
import biomight.system.muscular.chest.SerratusPosteriorSuperiorMuscle;
import biomight.system.muscular.chest.SubcostalisMuscle;
import biomight.system.muscular.chest.TransversusThoracisMuscle;
import biomight.system.muscular.foot.AbductorDigitiMinimiMuscle;
import biomight.system.muscular.foot.AbductorHallucisMuscle;
import biomight.system.muscular.foot.AbductorOssisMetatarsiQuintiMuscle;
import biomight.system.muscular.foot.AdductorHallucisMuscle;
import biomight.system.muscular.foot.DorsalInterosseiMuscle;
import biomight.system.muscular.foot.ExtensorDigitorumBrevis;
import biomight.system.muscular.foot.ExtensorHallucisBrevisMuscle;
import biomight.system.muscular.foot.FlexorDigitiMinimiBrevis;
import biomight.system.muscular.foot.FlexorDigitorumBrevisMuscle;
import biomight.system.muscular.foot.FlexorHallucisBrevisMuscle;
import biomight.system.muscular.foot.InterosselMuscle;
import biomight.system.muscular.foot.LumbriclesMuscle;
import biomight.system.muscular.foot.PlantarInterosseiMuscle;
import biomight.system.muscular.foot.QuadratusPlantaeMuscle;
import biomight.system.muscular.forearm.FlexorCarpiRadialisMuscle;
import biomight.system.muscular.forearm.FlexorCarpiUlnarisMuscle;
import biomight.system.muscular.forearm.FlexorDigitorumProfundusMuscle;
import biomight.system.muscular.forearm.FlexorDigitorumSuperficialisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisBrevisMuscle;
import biomight.system.muscular.forearm.FlexorPollicisLongusMuscle;
import biomight.system.muscular.forearm.PronatorQuadratusMuscle;
import biomight.system.muscular.forearm.PronatorTeresMuscle;
import biomight.system.muscular.forearm.SupinatorMuscle;
import biomight.system.muscular.hand.AbductorPollicisBrevisMuscle;
import biomight.system.muscular.hand.AbductorPollicisLongusMuscle;
import biomight.system.muscular.hand.AdductorPollicisMuscle;
import biomight.system.muscular.hand.DorsalInterosseiMuscles;
import biomight.system.muscular.hand.ExtensorPollicisBrevisMuscle;
import biomight.system.muscular.hand.LumbricalMuscles;
import biomight.system.muscular.hand.OpponensDigitiMinimiMuscle;
import biomight.system.muscular.hand.OpponensPollicisMuscle;
import biomight.system.muscular.hand.PalmarInterosseiMuscles;
import biomight.system.muscular.hand.PalmarisBrevisMuscle;
import biomight.system.muscular.head.AuricularisAnteriorMuscle;
import biomight.system.muscular.head.EpicraniusMuscle;
import biomight.system.muscular.head.FrontalisMuscle;
import biomight.system.muscular.head.GaleaAponeuroticaMuscle;
import biomight.system.muscular.head.OccipitalisMuscle;
import biomight.system.muscular.head.SuperficialFascia;
import biomight.system.muscular.head.eye.InferiorObliqueMuscle;
import biomight.system.muscular.head.eye.InferiorRectusMuscle;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.system.muscular.head.eye.MediallRectusMuscle;
import biomight.system.muscular.head.eye.SuperiorObliqueMuscle;
import biomight.system.muscular.head.eye.SuperiorRectusMuscle;
import biomight.system.muscular.head.eyelid.CorrugatorMuscle;
import biomight.system.muscular.head.eyelid.LevatorPalpebraeSuperiorisMuscle;
import biomight.system.muscular.head.eyelid.SuperiorisMuscle;
import biomight.system.muscular.head.facial.CorrugatorSuperciliiMuscle;
import biomight.system.muscular.head.facial.LevatorLabiiSuperiorisAlaequeNasiMuscle;
import biomight.system.muscular.head.facial.LevatorLabiiSuperiorisMuscle;
import biomight.system.muscular.head.facial.OrbicularisOculiMuscle;
import biomight.system.muscular.head.facial.OrbicularisOrisMuscle;
import biomight.system.muscular.head.mastication.MasseterMuscle;
import biomight.system.muscular.head.mastication.PterygoideusExternusMuscle;
import biomight.system.muscular.head.mastication.PterygoideusInternusMuscle;
import biomight.system.muscular.head.mastication.TemporalisMuscle;
import biomight.system.muscular.head.mouth.BuccinatorMuscle;
import biomight.system.muscular.head.mouth.CaninusMuscle;
import biomight.system.muscular.head.mouth.DepressorAnguliOrisMuscle;
import biomight.system.muscular.head.mouth.DepressorLabiiInferiorisMuscle;
import biomight.system.muscular.head.mouth.LevatorAnguliOrisMuscle;
import biomight.system.muscular.head.mouth.MentalisMuscle;
import biomight.system.muscular.head.mouth.QuadratusLabiiInferiorisMuscle;
import biomight.system.muscular.head.mouth.QuadratusLabiiSuperiorisMuscle;
import biomight.system.muscular.head.mouth.RisoriusMuscle;
import biomight.system.muscular.head.mouth.TriangularisMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMajorMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMinorMuscle;
import biomight.system.muscular.head.mouth.ZygomaticusMuscle;
import biomight.system.muscular.head.mouth.tongue.InferiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.SuperiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.TransversusMuscle;
import biomight.system.muscular.head.mouth.tongue.VerticalisMuscle;
import biomight.system.muscular.head.nose.DepressorSeptiNasiMuscle;
import biomight.system.muscular.head.nose.DilatatorNarisPosterior;
import biomight.system.muscular.head.nose.NasalisMuscle;
import biomight.system.muscular.head.nose.ProcerusMuscle;
import biomight.system.muscular.leg.thigh.AdductorBrevisMuscle;
import biomight.system.muscular.leg.thigh.AdductorMagnusMuscle;
import biomight.system.muscular.hip.ArticularisGenusMuscle;
import biomight.system.muscular.hip.CoccygeusMuscle;
import biomight.system.muscular.hip.GemelliMuscle;
import biomight.system.muscular.hip.GluteusMaximusMuscle;
import biomight.system.muscular.hip.IliopsoasMuscle;
import biomight.system.muscular.hip.IlotibialTractMuscle;
import biomight.system.muscular.hip.InferiorGemelliMuscle;
import biomight.system.muscular.hip.PiriformisMuscle;
import biomight.system.muscular.hip.SuperiorGemelliMuscle;
import biomight.system.muscular.leg.cnemis.ExtensorDigitorumLongusMuscle;
import biomight.system.muscular.leg.cnemis.ExtensorHallicusLongusMuscle;
import biomight.system.muscular.leg.cnemis.FlexorDigitorumLongusMuscle;
import biomight.system.muscular.leg.cnemis.FlexorHallicusLongusMuscle;
import biomight.system.muscular.leg.cnemis.GastrocnemiusMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusBrevisMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusLongusMuscle;
import biomight.system.muscular.leg.cnemis.PeroneusTertiusMuscle;
import biomight.system.muscular.leg.cnemis.PlantarisMuscle;
import biomight.system.muscular.leg.cnemis.SoleusMuscle;
import biomight.system.muscular.leg.cnemis.TibialisAnteriorMuscle;
import biomight.system.muscular.leg.cnemis.TibialisPosteriorMuscle;
import biomight.system.muscular.leg.thigh.AdductorLongusMuscle;
import biomight.system.muscular.leg.thigh.BicepsFemorisMuscle;
import biomight.system.muscular.leg.thigh.GluteusMediusMuscle;
import biomight.system.muscular.leg.thigh.GluteusMinimusMuscle;
import biomight.system.muscular.leg.thigh.GracilisMuscle;
import biomight.system.muscular.leg.thigh.IliacusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorExternusMuscle;
import biomight.system.muscular.leg.thigh.ObturatorInternusMuscle;
import biomight.system.muscular.leg.thigh.PectineusMuscle;
import biomight.system.muscular.leg.thigh.PopliteusMuscle;
import biomight.system.muscular.leg.thigh.QuadricepsFemorisMuscle;
import biomight.system.muscular.leg.thigh.RectusFemorisMuscle;
import biomight.system.muscular.leg.thigh.SartoriusMuscle;
import biomight.system.muscular.leg.thigh.SemiMembranosusMuscle;
import biomight.system.muscular.leg.thigh.SemitendinosusMuscle;
import biomight.system.muscular.leg.thigh.TensorFasciaLataMuscle;
import biomight.system.muscular.leg.thigh.VastusInterMediusMuscle;
import biomight.system.muscular.leg.thigh.VastusLateralisMuscle;
import biomight.system.muscular.leg.thigh.VastusMedialisMuscle;
import biomight.system.muscular.neck.AnteriorScaleneMuscle;
import biomight.system.muscular.neck.AnteriorVeterbralMuscle;
import biomight.system.muscular.neck.CricoArytenoidMuscle;
import biomight.system.muscular.neck.CricoThyroidMuscle;
import biomight.system.muscular.neck.DigastricMuscle;
import biomight.system.muscular.neck.GenioHyoidMuscle;
import biomight.system.muscular.neck.LateralCervicleMuscle;
import biomight.system.muscular.neck.LateralCricoarytenoidMuscle;
import biomight.system.muscular.neck.LateralVeterbralMuscle;
import biomight.system.muscular.neck.LongusCapitisMuscle;
import biomight.system.muscular.neck.MusculusUvulae;
import biomight.system.muscular.neck.MylohyoidMuscle;
import biomight.system.muscular.neck.OmoHyoidMuscle;
import biomight.system.muscular.neck.RectusCapitisAnteriorMuscle;
import biomight.system.muscular.neck.RectusCapitisLateralisMuscle;
import biomight.system.muscular.neck.ScalenusAnteriorMuscle;
import biomight.system.muscular.neck.ScalenusMediusMuscle;
import biomight.system.muscular.neck.ScalenusMinimusMuscle;
import biomight.system.muscular.neck.ScalenusPosteriorMuscle;
import biomight.system.muscular.neck.SternoCleidoMastoidMuscle;
import biomight.system.muscular.neck.SternoHyoidMuscle;
import biomight.system.muscular.neck.SternoMastoidMuscle;
import biomight.system.muscular.neck.SternoThyroidMuscle;
import biomight.system.muscular.neck.StyloHyoidMuscle;
import biomight.system.muscular.neck.SuperficialCervicalMuscle;
import biomight.system.muscular.neck.SupraInfrahyoidMuscle;
import biomight.system.muscular.neck.ThyroArytenoidMuscle;
import biomight.system.muscular.neck.ThyroHyoidMuscle;
import biomight.system.muscular.perineum.BulboSpongiosusMuscle;
import biomight.system.muscular.perineum.CorrugatorCutisAniMuscle;
import biomight.system.muscular.perineum.IschiocavernosusMuscle;
import biomight.system.muscular.perineum.SphincterAniExternusMuscle;
import biomight.system.muscular.perineum.SphincterAniInternusMuscle;
import biomight.system.muscular.perineum.SphincterUrethraeMembranaceaeMuscle;
import biomight.system.muscular.perineum.TransversusPerineiProfundusMuscle;
import biomight.system.muscular.perineum.TransversusPerineiSuperficialisMuscle;
import biomight.system.muscular.shoulder.DeltoideusMuscle;
import biomight.system.muscular.shoulder.InfraSpinatusMuscle;
import biomight.system.muscular.shoulder.InfraSpinatusMuscles;
import biomight.system.muscular.shoulder.SubScapularisMuscle;
import biomight.system.muscular.shoulder.SupraSpinatusMuscle;
import biomight.system.muscular.shoulder.TeresMajorMuscle;
import biomight.system.muscular.shoulder.TeresMinorMuscle;
import biomight.system.tissue.muscle.Muscle;
import biomight.system.tissue.muscle.Muscles;
import biomight.system.tissue.muscle.cardiac.CardiacMuscle;
import biomightweb.view.BioMightComponent;



/**
 * Maps BioMight Muscular Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewMuscular {

	
	public void BioMightViewVacular() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
			
		
		/**************************************************************************
		*
		* MUSCULAR SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
						

		if (bioMightComponentRef.equals(Constants.Muscles))
		{
			Muscles muscules = (Muscles) bioMightInstance;
			bioMightComponent.setImage(muscules.getImage());
			bioMightComponent.setBioMightMethods(muscules.getMethods());
			bioMightComponent.setBioMightProperties(muscules.getProperties());
		}
		// Place here rather than in tissue
		else if (bioMightComponentRef.equals(Constants.Muscle))
		{
			Muscle muscle = (Muscle) bioMightInstance;
			bioMightComponent.setImage(muscle.getImage());
			bioMightComponent.setBioMightMethods(muscle.getMethods());
			bioMightComponent.setBioMightProperties(muscle.getProperties());
		}			
		
		else if (bioMightComponentRef.equals(Constants.CardiacMuscle))
		{
			CardiacMuscle cardiacMuscle = (CardiacMuscle) bioMightInstance;
			bioMightComponent.setImage(cardiacMuscle.getImage());
			bioMightComponent.setBioMightProperties(cardiacMuscle.getProperties());
			bioMightComponent.setBioMightMethods(cardiacMuscle.getMethods());
		}	
		
		// CROSS SECTIONAL 
		else if (bioMightComponentRef.equals(Constants.FlexorDigitorumProfundusMuscle))
		{
			FlexorDigitorumProfundusMuscle flexorDigitorumProfundusMuscle = (FlexorDigitorumProfundusMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorDigitorumProfundusMuscle.getImage());
			bioMightComponent.setWidth(flexorDigitorumProfundusMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorDigitorumProfundusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorDigitorumSuperficialisMuscle))
		{
			FlexorDigitorumSuperficialisMuscle flexorDigitorumSuperficialisMuscle = (FlexorDigitorumSuperficialisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorDigitorumSuperficialisMuscle.getImage());
			bioMightComponent.setWidth(flexorDigitorumSuperficialisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorDigitorumSuperficialisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorPollicisBrevisMuscle))
		{
			FlexorPollicisBrevisMuscle flexorPollicisBrevisMuscle = (FlexorPollicisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorPollicisBrevisMuscle.getImage());
			bioMightComponent.setWidth(flexorPollicisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorPollicisBrevisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(flexorPollicisBrevisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(flexorPollicisBrevisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FlexorPollicisBrevisMuscle: "  + bioMightComponent +  "     ID: " + flexorPollicisBrevisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(flexorPollicisBrevisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	flexorPollicisBrevisMuscle.executeMethods(methodParams);
			//	flexorPollicisBrevisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for FlexorPollicisBrevisMuscle!");
			bioMightComponent.setX3D(flexorPollicisBrevisMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.FlexorPollicisLongusMuscle))
		{
			FlexorPollicisLongusMuscle flexorPollicisLongusMuscle = (FlexorPollicisLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorPollicisLongusMuscle.getImage());
			bioMightComponent.setWidth(flexorPollicisLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorPollicisLongusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(flexorPollicisLongusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(flexorPollicisLongusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FlexorPollicisLongusMuscle: "  + bioMightComponent +  "     ID: " + flexorPollicisLongusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(flexorPollicisLongusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	flexorPollicisLongusMuscle.executeMethods(methodParams);
			//	flexorPollicisLongusMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for FlexorPollicisBrevisMuscle!");
			bioMightComponent.setX3D(flexorPollicisLongusMuscle.getX3D(false));			
		}
		else if (bioMightComponentRef.equals(Constants.LongissimusCapitisMuscle))
		{
			LongissimusCapitisMuscle longissimusCapitisMuscle = (LongissimusCapitisMuscle) bioMightInstance;
			bioMightComponent.setImage(longissimusCapitisMuscle.getImage());
			bioMightComponent.setWidth(longissimusCapitisMuscle.getImageWidth());
			bioMightComponent.setHeight(longissimusCapitisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(longissimusCapitisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(longissimusCapitisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LongissimusCapitisMuscle: "  + bioMightComponent +  "     ID: " + longissimusCapitisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(longissimusCapitisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	longissimusCapitisMuscle.executeMethods(methodParams);
			//	longissimusCapitisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for LongissimusCapitisMuscle!");
			bioMightComponent.setX3D(longissimusCapitisMuscle.getX3D(false));			
		}
		else if (bioMightComponentRef.equals(Constants.LongissimusCervicisMuscles))
		{
			LongissimusCervicisMuscles longissimusCervicisMuscles = (LongissimusCervicisMuscles) bioMightInstance;
			bioMightComponent.setImage(longissimusCervicisMuscles.getImage());
			bioMightComponent.setWidth(longissimusCervicisMuscles.getImageWidth());
			bioMightComponent.setHeight(longissimusCervicisMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(longissimusCervicisMuscles.getProperties());
			bioMightComponent.setBioMightMethods(longissimusCervicisMuscles.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LongissimusCervicisMuscles: "  + bioMightComponent +  "     ID: " + longissimusCervicisMuscles.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(longissimusCervicisMuscles.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	longissimusCervicisMuscles.executeMethods(methodParams);
			//	longissimusCervicisMuscles.redraw(0);
			//}
			System.out.println("Getting X3D for LongissimusCervicisMuscles!");
			bioMightComponent.setX3D(longissimusCervicisMuscles.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.LongissimusCervicisMuscle))
		{
			LongissimusCervicisMuscle longissimusCervicisMuscle = (LongissimusCervicisMuscle) bioMightInstance;
			bioMightComponent.setImage(longissimusCervicisMuscle.getImage());
			bioMightComponent.setWidth(longissimusCervicisMuscle.getImageWidth());
			bioMightComponent.setHeight(longissimusCervicisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(longissimusCervicisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(longissimusCervicisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LongissimusCervicisMuscle: "  + bioMightComponent +  "     ID: " + longissimusCervicisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(longissimusCervicisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	longissimusCervicisMuscle.executeMethods(methodParams);
			//	longissimusCervicisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for LongissimusCervicisMuscle!");
			bioMightComponent.setX3D(longissimusCervicisMuscle.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.LongissimusThoracisMuscles))
		{
			LongissimusThoracisMuscles longissimusThoracisMuscles = (LongissimusThoracisMuscles) bioMightInstance;
			bioMightComponent.setImage(longissimusThoracisMuscles.getImage());
			bioMightComponent.setWidth(longissimusThoracisMuscles.getImageWidth());
			bioMightComponent.setHeight(longissimusThoracisMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(longissimusThoracisMuscles.getProperties());
			bioMightComponent.setBioMightMethods(longissimusThoracisMuscles.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LongissimusThoracisMuscles: "  + bioMightComponent +  "     ID: " + longissimusThoracisMuscles.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(longissimusThoracisMuscles.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	longissimusThoracisMuscles.executeMethods(methodParams);
			//	longissimusThoracisMuscles.redraw(0);
			//}
			System.out.println("Getting X3D for LongissimusThoracisMuscles!");
			bioMightComponent.setX3D(longissimusThoracisMuscles.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.	Muscle))
		{
			LongissimusThoracisMuscle longissimusThoracisMuscle = (LongissimusThoracisMuscle) bioMightInstance;
			bioMightComponent.setImage(longissimusThoracisMuscle.getImage());
			bioMightComponent.setWidth(longissimusThoracisMuscle.getImageWidth());
			bioMightComponent.setHeight(longissimusThoracisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(longissimusThoracisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(longissimusThoracisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LongissimusThoracisMuscle: "  + bioMightComponent +  "     ID: " + longissimusThoracisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(longissimusThoracisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	longissimusThoracisMuscle.executeMethods(methodParams);
			//	longissimusThoracisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for LongissimusThoracisMuscle!");
			bioMightComponent.setX3D(longissimusThoracisMuscle.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.LongRotatorsMuscle))
		{
			LongRotatorsMuscle longRotatorsMuscle = (LongRotatorsMuscle) bioMightInstance;
			bioMightComponent.setImage(longRotatorsMuscle.getImage());
			bioMightComponent.setWidth(longRotatorsMuscle.getImageWidth());
			bioMightComponent.setHeight(longRotatorsMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LongusColliMuscle))
		{
			LongusColliMuscle longusColliMuscle = (LongusColliMuscle) bioMightInstance;
			bioMightComponent.setImage(longusColliMuscle.getImage());
			bioMightComponent.setWidth(longusColliMuscle.getImageWidth());
			bioMightComponent.setHeight(longusColliMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PalmarisLongusMuscle))
		{
			PalmarisLongusMuscle palmarisLongusMuscle = (PalmarisLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(palmarisLongusMuscle.getImage());
			bioMightComponent.setWidth(palmarisLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(palmarisLongusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(palmarisLongusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(palmarisLongusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalmarisLongusMuscle: "  + bioMightComponent +  "     ID: " + palmarisLongusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palmarisLongusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	palmarisLongusMuscle.executeMethods(methodParams);
			//	palmarisLongusMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for PalmarisLongusMuscle!");
			bioMightComponent.setX3D(palmarisLongusMuscle.getX3D(false));			
		}
		else if (bioMightComponentRef.equals(Constants.PlatysmaMuscle))
		{
			PlatysmaMuscle platysmaMuscle = (PlatysmaMuscle) bioMightInstance;
			bioMightComponent.setImage(platysmaMuscle.getImage());
			bioMightComponent.setWidth(platysmaMuscle.getImageWidth());
			bioMightComponent.setHeight(platysmaMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PronatorQuadratusMuscle))
		{
			PronatorQuadratusMuscle pronatorQuadratusMuscle = (PronatorQuadratusMuscle) bioMightInstance;
			bioMightComponent.setImage(pronatorQuadratusMuscle.getImage());
			bioMightComponent.setWidth(pronatorQuadratusMuscle.getImageWidth());
			bioMightComponent.setHeight(pronatorQuadratusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PronatorTeresMuscle))
		{
			PronatorTeresMuscle pronatorTeresMuscle = (PronatorTeresMuscle) bioMightInstance;
			bioMightComponent.setImage(pronatorTeresMuscle.getImage());
			bioMightComponent.setWidth(pronatorTeresMuscle.getImageWidth());
			bioMightComponent.setHeight(pronatorTeresMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SupinatorMuscle))
		{
			SupinatorMuscle supinatorMuscle = (SupinatorMuscle) bioMightInstance;
			bioMightComponent.setImage(supinatorMuscle.getImage());
			bioMightComponent.setWidth(supinatorMuscle.getImageWidth());
			bioMightComponent.setHeight(supinatorMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(supinatorMuscle.getProperties());
			bioMightComponent.setBioMightMethods(supinatorMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SupinatorMuscle: "  + bioMightComponent +  "     ID: " + supinatorMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(supinatorMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	supinatorMuscle.executeMethods(methodParams);
			//	supinatorMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for SupinatorMuscle!");
			bioMightComponent.setX3D(supinatorMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.TrapeziusMuscle))
		{
			TrapeziusMuscle trapeziusMuscle = (TrapeziusMuscle) bioMightInstance;
			bioMightComponent.setImage(trapeziusMuscle.getImage());
			bioMightComponent.setWidth(trapeziusMuscle.getImageWidth());
			bioMightComponent.setHeight(trapeziusMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.abdomen
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.CremasterMuscle))
		{
			CremasterMuscle cremasterMuscle = (CremasterMuscle) bioMightInstance;
			bioMightComponent.setImage(cremasterMuscle.getImage());
			bioMightComponent.setWidth(cremasterMuscle.getImageWidth());
			bioMightComponent.setHeight(cremasterMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ObliquusExternusAbdominisMuscle))
		{
			ObliquusExternusAbdominisMuscle obliquusExternusAbdominisMuscle = (ObliquusExternusAbdominisMuscle) bioMightInstance;
			bioMightComponent.setImage(obliquusExternusAbdominisMuscle.getImage());
			bioMightComponent.setWidth(obliquusExternusAbdominisMuscle.getImageWidth());
			bioMightComponent.setHeight(obliquusExternusAbdominisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ObliquusInternusAbdominisMuscle))
		{
			ObliquusInternusAbdominisMuscle obliquusInternusAbdominisMuscle = (ObliquusInternusAbdominisMuscle) bioMightInstance;
			bioMightComponent.setImage(obliquusInternusAbdominisMuscle.getImage());
			bioMightComponent.setWidth(obliquusInternusAbdominisMuscle.getImageWidth());
			bioMightComponent.setHeight(obliquusInternusAbdominisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PsoasMajorMuscle))
		{
			PsoasMajorMuscle psoasMajorMuscle = (PsoasMajorMuscle) bioMightInstance;
			bioMightComponent.setImage(psoasMajorMuscle.getImage());
			bioMightComponent.setWidth(psoasMajorMuscle.getImageWidth());
			bioMightComponent.setHeight(psoasMajorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PsoasMinorMuscle))
		{
			PsoasMinorMuscle psoasMinorMuscle = (PsoasMinorMuscle) bioMightInstance;
			bioMightComponent.setImage(psoasMinorMuscle.getImage());
			bioMightComponent.setWidth(psoasMinorMuscle.getImageWidth());
			bioMightComponent.setHeight(psoasMinorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PyramidalisMuscle))
		{
			PyramidalisMuscle pyramidalisMuscle = (PyramidalisMuscle) bioMightInstance;
			bioMightComponent.setImage(pyramidalisMuscle.getImage());
			bioMightComponent.setWidth(pyramidalisMuscle.getImageWidth());
			bioMightComponent.setHeight(pyramidalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.QuadratusLumborumMuscle))
		{
			QuadratusLumborumMuscle quadratusLumborumMuscle = (QuadratusLumborumMuscle) bioMightInstance;
			bioMightComponent.setImage(quadratusLumborumMuscle.getImage());
			bioMightComponent.setWidth(quadratusLumborumMuscle.getImageWidth());
			bioMightComponent.setHeight(quadratusLumborumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RectusAdominisMuscle))
		{
			RectusAdominisMuscle rectusAdominisMuscle = (RectusAdominisMuscle) bioMightInstance;
			bioMightComponent.setImage(rectusAdominisMuscle.getImage());
			bioMightComponent.setWidth(rectusAdominisMuscle.getImageWidth());
			bioMightComponent.setHeight(rectusAdominisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TransversusAbdominisMuscle))
		{
			TransversusAbdominisMuscle transversusAbdominisMuscle = (TransversusAbdominisMuscle) bioMightInstance;
			bioMightComponent.setImage(transversusAbdominisMuscle.getImage());
			bioMightComponent.setWidth(transversusAbdominisMuscle.getImageWidth());
			bioMightComponent.setHeight(transversusAbdominisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.arm
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AnconeusMuscle))
		{
			AnconeusMuscle anconeusMuscle = (AnconeusMuscle) bioMightInstance;
			bioMightComponent.setImage(anconeusMuscle.getImage());
			bioMightComponent.setWidth(anconeusMuscle.getImageWidth());
			bioMightComponent.setHeight(anconeusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.BicepsBrachiiMuscle))
		{
			BicepsBrachiiMuscle bicepsBrachiiMuscle = (BicepsBrachiiMuscle) bioMightInstance;
			bioMightComponent.setImage(bicepsBrachiiMuscle.getImage());
			bioMightComponent.setWidth(bicepsBrachiiMuscle.getImageWidth());
			bioMightComponent.setHeight(bicepsBrachiiMuscle.getImageHeight());
			
			bioMightComponent.setBioMightProperties(bicepsBrachiiMuscle.getProperties());
			bioMightComponent.setBioMightMethods(bicepsBrachiiMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for B]  rachialisMuscle: "  + bioMightComponent +  "     ID: " + bicepsBrachiiMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bicepsBrachiiMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	bicepsBrachiiMuscle.executeMethods(methodParams);
			//	bicepsBrachiiMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for BrachialisMuscle!");
			bioMightComponent.setX3D(bicepsBrachiiMuscle.getX3D(false));					
		}
		else if (bioMightComponentRef.equals(Constants.BrachialisMuscle))
		{
			BrachialisMuscle brachialisMuscle = (BrachialisMuscle) bioMightInstance;
			bioMightComponent.setImage(brachialisMuscle.getImage());
			bioMightComponent.setWidth(brachialisMuscle.getImageWidth());
			bioMightComponent.setHeight(brachialisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(brachialisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(brachialisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for B]  rachialisMuscle: "  + bioMightComponent +  "     ID: " + brachialisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brachialisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	brachialisMuscle.executeMethods(methodParams);
			//	brachialisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for BrachialisMuscle!");
			bioMightComponent.setX3D(brachialisMuscle.getX3D(false));					
		}
		else if (bioMightComponentRef.equals(Constants.BrachioradialisMuscle))
		{
			BrachioradialisMuscle brachioradialisMuscle = (BrachioradialisMuscle) bioMightInstance;
			bioMightComponent.setImage(brachioradialisMuscle.getImage());
			bioMightComponent.setWidth(brachioradialisMuscle.getImageWidth());
			bioMightComponent.setHeight(brachioradialisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(brachioradialisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(brachioradialisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for brachioradialisMuscle: "  + bioMightComponent +  "     ID: " + brachioradialisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brachioradialisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	brachioradialisMuscle.executeMethods(methodParams);
			//	brachioradialisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for BrachialisMuscle!");
			bioMightComponent.setX3D(brachioradialisMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.CoracoBrachialisMuscle))
		{
			CoracoBrachialisMuscle coracoBrachialisMuscle = (CoracoBrachialisMuscle) bioMightInstance;
			bioMightComponent.setImage(coracoBrachialisMuscle.getImage());
			bioMightComponent.setWidth(coracoBrachialisMuscle.getImageWidth());
			bioMightComponent.setHeight(coracoBrachialisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorCarpiRadialisBrevisMuscle))
		{
			ExtensorCarpiRadialisBrevisMuscle extensorCarpiRadialisBrevisMuscle = (ExtensorCarpiRadialisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorCarpiRadialisBrevisMuscle.getImage());
			bioMightComponent.setWidth(extensorCarpiRadialisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorCarpiRadialisBrevisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(extensorCarpiRadialisBrevisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(extensorCarpiRadialisBrevisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for extensorCarpiRadialisBrevisMuscle: "  + bioMightComponent +  "     ID: " + extensorCarpiRadialisBrevisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(extensorCarpiRadialisBrevisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	extensorCarpiRadialisBrevisMuscle.executeMethods(methodParams);
			//	extensorCarpiRadialisBrevisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for extensorCarpiRadialisBrevisMuscle!");
			bioMightComponent.setX3D(extensorCarpiRadialisBrevisMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorCarpiRadialisLongusMuscle))
		{
			ExtensorCarpiRadialisLongusMuscle extensorCarpiRadialisLongusMuscle = (ExtensorCarpiRadialisLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorCarpiRadialisLongusMuscle.getImage());
			bioMightComponent.setWidth(extensorCarpiRadialisLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorCarpiRadialisLongusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(extensorCarpiRadialisLongusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(extensorCarpiRadialisLongusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for extensorCarpiRadialisBrevisMuscle: "  + bioMightComponent +  "     ID: " + extensorCarpiRadialisLongusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(extensorCarpiRadialisLongusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	extensorCarpiRadialisLongusMuscle.executeMethods(methodParams);
			//	extensorCarpiRadialisLongusMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for extensorCarpiRadialisLongusMuscle!");
			bioMightComponent.setX3D(extensorCarpiRadialisLongusMuscle.getX3D(false));

		}
		else if (bioMightComponentRef.equals(Constants.ExtensorCarpiUlnarisMuscle))
		{
			ExtensorCarpiUlnarisMuscle extensorCarpiUlnarisMuscle = (ExtensorCarpiUlnarisMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorCarpiUlnarisMuscle.getImage());
			bioMightComponent.setWidth(extensorCarpiUlnarisMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorCarpiUlnarisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorDigitiMinimiMuscle))
		{
			ExtensorDigitiMinimiMuscle extensorDigitiMinimiMuscle = (ExtensorDigitiMinimiMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorDigitiMinimiMuscle.getImage());
			bioMightComponent.setWidth(extensorDigitiMinimiMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorDigitiMinimiMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(extensorDigitiMinimiMuscle.getProperties());
			bioMightComponent.setBioMightMethods(extensorDigitiMinimiMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExtensorDigitiMinimiMuscle: "  + bioMightComponent +  "     ID: " + extensorDigitiMinimiMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(extensorDigitiMinimiMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	extensorDigitiMinimiMuscle.executeMethods(methodParams);
			//	extensorDigitiMinimiMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for ExtensorDigitiMinimiMuscle!");
			bioMightComponent.setX3D(extensorDigitiMinimiMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorDigitorumMuscle))
		{
			ExtensorDigitorumMuscle extensorDigitorumMuscle = (ExtensorDigitorumMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorDigitorumMuscle.getImage());
			bioMightComponent.setWidth(extensorDigitorumMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorDigitorumMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(extensorDigitorumMuscle.getProperties());
			bioMightComponent.setBioMightMethods(extensorDigitorumMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExtensorDigitiMinimiMuscle: "  + bioMightComponent +  "     ID: " + extensorDigitorumMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(extensorDigitorumMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExtensorDigitorumMuscle Methods!");
			//	extensorDigitorumMuscle.executeMethods(methodParams);
			//	extensorDigitorumMuscle.redraw(0);
			//
			System.out.println("Getting X3D for ExtensorDigitorumMuscle!");
			bioMightComponent.setX3D(extensorDigitorumMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorPollicisLongusMuscle))
		{
			ExtensorPollicisLongusMuscle extensorPollicisLongusMuscle = (ExtensorPollicisLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorPollicisLongusMuscle.getImage());
			bioMightComponent.setWidth(extensorPollicisLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorPollicisLongusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(extensorPollicisLongusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(extensorPollicisLongusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExtensorPollicisLongusMuscle: "  + bioMightComponent +  "     ID: " + extensorPollicisLongusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(extensorPollicisLongusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExtensorPollicisLongusMuscle Methods!");
			//	extensorPollicisLongusMuscle.executeMethods(methodParams);
			//	extensorPollicisLongusMuscle.redraw(0);
			//
			System.out.println("Getting X3D for ExtensorPollicisLongusMuscle!");
			bioMightComponent.setX3D(extensorPollicisLongusMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.FlexorCarpiRadialisMuscle))
		{
			FlexorCarpiRadialisMuscle flexorCarpiRadialisMuscle = (FlexorCarpiRadialisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorCarpiRadialisMuscle.getImage());
			bioMightComponent.setWidth(flexorCarpiRadialisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorCarpiRadialisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(flexorCarpiRadialisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(flexorCarpiRadialisMuscle.getMethods());
			
			/*
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FlexorCarpiRadialisMuscle: "  + bioMightComponent +  "     ID: " + flexorCarpiRadialisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(flexorCarpiRadialisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExtensorPollicisLongusMuscle Methods!");
			//	flexorCarpiRadialisMuscle.executeMethods(methodParams);
			//	flexorCarpiRadialisMuscle.redraw(0);
			//
			System.out.println("Getting X3D for FlexorCarpiRadialisMuscle!");
			bioMightComponent.setX3D(flexorCarpiRadialisMuscle.getX3D(false));
			*/
		}
		else if (bioMightComponentRef.equals(Constants.FlexorCarpiUlnarisMuscle))
		{
			FlexorCarpiUlnarisMuscle flexorCarpiUlnarisMuscle = (FlexorCarpiUlnarisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorCarpiUlnarisMuscle.getImage());
			bioMightComponent.setWidth(flexorCarpiUlnarisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorCarpiUlnarisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TricepsBrachiiMuscle))
		{
			TricepsBrachiiMuscle tricepsBrachiiMuscle = (TricepsBrachiiMuscle) bioMightInstance;
			bioMightComponent.setImage(tricepsBrachiiMuscle.getImage());
			bioMightComponent.setWidth(tricepsBrachiiMuscle.getImageWidth());
			bioMightComponent.setHeight(tricepsBrachiiMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.back
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.InterSpinalesMuscle))
		{
			InterSpinalesMuscle interSpinalesMuscle = (InterSpinalesMuscle) bioMightInstance;
			bioMightComponent.setImage(interSpinalesMuscle.getImage());
			bioMightComponent.setWidth(interSpinalesMuscle.getImageWidth());
			bioMightComponent.setHeight(interSpinalesMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InterTransversariiMuscle))
		{
			InterTransversariiMuscle interTransversariiMuscle = (InterTransversariiMuscle) bioMightInstance;
			bioMightComponent.setImage(interTransversariiMuscle.getImage());
			bioMightComponent.setWidth(interTransversariiMuscle.getImageWidth());
			bioMightComponent.setHeight(interTransversariiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MultifidusMuscle))
		{
			MultifudisSpinaeCervicalRegionLeft multifudisSpinaeCervicalRegionLeft = 
			 (MultifudisSpinaeCervicalRegionLeft) bioMightInstance;
			bioMightComponent.setImage(multifudisSpinaeCervicalRegionLeft.getImage());
			bioMightComponent.setWidth(multifudisSpinaeCervicalRegionLeft.getImageWidth());
			bioMightComponent.setHeight(multifudisSpinaeCervicalRegionLeft.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RotatoresMuscle))
		{
			RotatoresSpinaeMuscleLeft1 rotatoresMuscle = (RotatoresSpinaeMuscleLeft1) bioMightInstance;
			bioMightComponent.setImage(rotatoresMuscle.getImage());
			bioMightComponent.setWidth(rotatoresMuscle.getImageWidth());
			bioMightComponent.setHeight(rotatoresMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SacroSpinalisMuscle))
		{
			SacroSpinalisMuscle sacroSpinalisMuscle = (SacroSpinalisMuscle) bioMightInstance;
			bioMightComponent.setImage(sacroSpinalisMuscle.getImage());
			bioMightComponent.setWidth(sacroSpinalisMuscle.getImageWidth());
			bioMightComponent.setHeight(sacroSpinalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SemiSpinalisMuscle))
		{
			SemiSpinalisMuscle semiSpinalisMuscle = (SemiSpinalisMuscle) bioMightInstance;
			bioMightComponent.setImage(semiSpinalisMuscle.getImage());
			bioMightComponent.setWidth(semiSpinalisMuscle.getImageWidth());
			bioMightComponent.setHeight(semiSpinalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SpleniusCapitisMuscle))
		{
			SpleniusCapitisMuscle spleniusCapitisMuscle = (SpleniusCapitisMuscle) bioMightInstance;
			bioMightComponent.setImage(spleniusCapitisMuscle.getImage());
			bioMightComponent.setWidth(spleniusCapitisMuscle.getImageWidth());
			bioMightComponent.setHeight(spleniusCapitisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SpleniusCervicisMuscle))
		{
			SpleniusCervicisMuscle spleniusCervicisMuscle = (SpleniusCervicisMuscle) bioMightInstance;
			bioMightComponent.setImage(spleniusCervicisMuscle.getImage());
			bioMightComponent.setWidth(spleniusCervicisMuscle.getImageWidth());
			bioMightComponent.setHeight(spleniusCervicisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.chest
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.DiaphragmMuscle))
		{
			DiaphragmMuscle diaphragmMuscle = (DiaphragmMuscle) bioMightInstance;
			bioMightComponent.setImage(diaphragmMuscle.getImage());
			bioMightComponent.setWidth(diaphragmMuscle.getImageWidth());
			bioMightComponent.setHeight(diaphragmMuscle.getImageHeight());
		}
		
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscle))
		{
			IntercostalesExterniMuscles intercostalesExterniMuscles = (IntercostalesExterniMuscles) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscles.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscles.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscles.getImageHeight());
			//bioMightComponent.setBioMightProperties(intercostalesExterniMuscle.getProperties());
			//bioMightComponent.setBioMightMethods(intercostalesExterniMuscle.getMethods());	
		}			
		/*
		// LEFT SIDE - 11 in number
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft1))
		{
			IntercostalesExterniMuscleLeft1 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft1) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(intercostalesExterniMuscle.getProperties());
			bioMightComponent.setBioMightMethods(intercostalesExterniMuscle.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft2))
		{
			IntercostalesExterniMuscleLeft2 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft2) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft3))
		{
			IntercostalesExterniMuscleLeft3 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft3) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft4))
		{
			IntercostalesExterniMuscleLeft4 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft4) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft5))
		{
			IntercostalesExterniMuscleLeft5 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft5) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft6))
		{
			IntercostalesExterniMuscleLeft6 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft6) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft7))
		{
			IntercostalesExterniMuscleLeft7 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft7) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft8))
		{
			IntercostalesExterniMuscleLeft8 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft8) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft9))
		{
			IntercostalesExterniMuscleLeft9 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft9) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft10))
		{
			IntercostalesExterniMuscleLeft10 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft10) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleLeft11))
		{
			IntercostalesExterniMuscleLeft11 intercostalesExterniMuscle = (IntercostalesExterniMuscleLeft11) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		
		// RIGHT SIDE - 11 in number
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight1))
		{
			IntercostalesExterniMuscleRight1 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight1) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight2))
		{
			IntercostalesExterniMuscleRight2 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight2) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight3))
		{
			IntercostalesExterniMuscleRight3 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight3) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight4))
		{
			IntercostalesExterniMuscleRight4 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight4) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight5))
		{
			IntercostalesExterniMuscleRight5 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight5) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight6))
		{
			IntercostalesExterniMuscleRight6 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight6) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight7))
		{
			IntercostalesExterniMuscleRight7 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight7) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight8))
		{
			IntercostalesExterniMuscleRight8 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight8) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight9))
		{
			IntercostalesExterniMuscleRight9 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight9) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight10))
		{
			IntercostalesExterniMuscleRight10 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight10) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesExterniMuscleRight11))
		{
			IntercostalesExterniMuscleRight11 intercostalesExterniMuscle = (IntercostalesExterniMuscleRight11) bioMightInstance;
			bioMightComponent.setImage(intercostalesExterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesExterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesExterniMuscle.getImageHeight());
		}	
		
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscles))
		{
			IntercostalesInterniMuscles intercostalesInterniMuscles = (IntercostalesInterniMuscles) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscles.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscles.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(intercostalesInterniMuscles.getProperties());
			bioMightComponent.setBioMightMethods(intercostalesInterniMuscles.getMethods());	
		}
		// LEFT SIDE - 11 in number
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft1))
		{
			IntercostalesInterniMuscleLeft1 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft1) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft2))
		{
			IntercostalesInterniMuscleLeft2 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft2) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft3))
		{
			IntercostalesInterniMuscleLeft3 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft3) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft4))
		{
			IntercostalesInterniMuscleLeft4 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft4) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft5))
		{
			IntercostalesInterniMuscleLeft5 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft5) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft6))
		{
			IntercostalesInterniMuscleLeft6 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft6) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft7))
		{
			IntercostalesInterniMuscleLeft7 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft7) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft8))
		{
			IntercostalesInterniMuscleLeft8 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft8) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft9))
		{
			IntercostalesInterniMuscleLeft9 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft9) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft10))
		{
			IntercostalesInterniMuscleLeft10 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft10) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleLeft11))
		{
			IntercostalesInterniMuscleLeft11 intercostalesInterniMuscle = (IntercostalesInterniMuscleLeft11) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		// RIGHT SIDE - 11 in number
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight1))
		{
			IntercostalesInterniMuscleRight1 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight1) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight2))
		{
			IntercostalesInterniMuscleRight2 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight2) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight3))
		{
			IntercostalesInterniMuscleRight3 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight3) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight4))
		{
			IntercostalesInterniMuscleRight4 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight4) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight5))
		{
			IntercostalesInterniMuscleRight5 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight5) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight6))
		{
			IntercostalesInterniMuscleRight6 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight6) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight7))
		{
			IntercostalesInterniMuscleRight7 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight7) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight8))
		{
			IntercostalesInterniMuscleRight8 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight8) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight9))
		{
			IntercostalesInterniMuscleRight9 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight9) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight10))
		{
			IntercostalesInterniMuscleRight10 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight10) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IntercostalesInterniMuscleRight11))
		{
			IntercostalesInterniMuscleRight11 intercostalesInterniMuscle = (IntercostalesInterniMuscleRight11) bioMightInstance;
			bioMightComponent.setImage(intercostalesInterniMuscle.getImage());
			bioMightComponent.setWidth(intercostalesInterniMuscle.getImageWidth());
			bioMightComponent.setHeight(intercostalesInterniMuscle.getImageHeight());
		}
		*/
		
		// LEVATORES COSTARUM MUSCLE
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscles))
		{
			LevatoresCostarumMuscles levatoresCostarumMuscles = (LevatoresCostarumMuscles) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscles.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscles.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(levatoresCostarumMuscles.getProperties());
			bioMightComponent.setBioMightMethods(levatoresCostarumMuscles.getMethods());
		}
		// LEFT SIDE - 11 in number
		/*
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft1))
		{
			LevatoresCostarumMuscleLeft1 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft1) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft2))
		{
			LevatoresCostarumMuscleLeft2 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft2) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft3))
		{
			LevatoresCostarumMuscleLeft3 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft3) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft4))
		{
			LevatoresCostarumMuscleLeft4 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft4) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft5))
		{
			LevatoresCostarumMuscleLeft5 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft5) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft6))
		{
			LevatoresCostarumMuscleLeft6 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft6) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft7))
		{
			LevatoresCostarumMuscleLeft7 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft7) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft8))
		{
			LevatoresCostarumMuscleLeft8 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft8) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft9))
		{
			LevatoresCostarumMuscleLeft9 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft9) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft10))
		{
			LevatoresCostarumMuscleLeft10 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft10) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleLeft11))
		{
			LevatoresCostarumMuscleLeft11 levatoresCostarumMuscle = (LevatoresCostarumMuscleLeft11) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		// RIGHT SIDE - 11 in number
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight1))
		{
			LevatoresCostarumMuscleRight1 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight1) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight2))
		{
			LevatoresCostarumMuscleRight2 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight2) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight3))
		{
			LevatoresCostarumMuscleRight3 LevatoresCostarumMuscle = (LevatoresCostarumMuscleRight3) bioMightInstance;
			bioMightComponent.setImage(LevatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(LevatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(LevatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight4))
		{
			LevatoresCostarumMuscleRight4 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight4) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight5))
		{
			LevatoresCostarumMuscleRight5 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight5) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight6))
		{
			LevatoresCostarumMuscleRight6 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight6) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight7))
		{
			LevatoresCostarumMuscleRight7 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight7) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight8))
		{
			LevatoresCostarumMuscleRight8 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight8) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight9))
		{
			LevatoresCostarumMuscleRight9 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight9) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight10))
		{
			LevatoresCostarumMuscleRight10 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight10) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatoresCostarumMuscleRight11))
		{
			LevatoresCostarumMuscleRight11 levatoresCostarumMuscle = (LevatoresCostarumMuscleRight11) bioMightInstance;
			bioMightComponent.setImage(levatoresCostarumMuscle.getImage());
			bioMightComponent.setWidth(levatoresCostarumMuscle.getImageWidth());
			bioMightComponent.setHeight(levatoresCostarumMuscle.getImageHeight());
		}
		*/
		
		
		
		
		else if (bioMightComponentRef.equals(Constants.SerratusPosteriorInferiorMuscle))
		{
			SerratusPosteriorInferiorMuscle serratusPosteriorInferiorMuscle = (SerratusPosteriorInferiorMuscle) bioMightInstance;
			bioMightComponent.setImage(serratusPosteriorInferiorMuscle.getImage());
			bioMightComponent.setWidth(serratusPosteriorInferiorMuscle.getImageWidth());
			bioMightComponent.setHeight(serratusPosteriorInferiorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SerratusPosteriorSuperiorMuscle))
		{
			SerratusPosteriorSuperiorMuscle serratusPosteriorSuperiorMuscle = (SerratusPosteriorSuperiorMuscle) bioMightInstance;
			bioMightComponent.setImage(serratusPosteriorSuperiorMuscle.getImage());
			bioMightComponent.setWidth(serratusPosteriorSuperiorMuscle.getImageWidth());
			bioMightComponent.setHeight(serratusPosteriorSuperiorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SubcostalisMuscle))
		{
			SubcostalisMuscle subcostalesMuscle = (SubcostalisMuscle) bioMightInstance;
			bioMightComponent.setImage(subcostalesMuscle.getImage());
			bioMightComponent.setWidth(subcostalesMuscle.getImageWidth());
			bioMightComponent.setHeight(subcostalesMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TransversusThoracisMuscle))
		{
			TransversusThoracisMuscle transversusThoracisMuscle = (TransversusThoracisMuscle) bioMightInstance;
			bioMightComponent.setImage(transversusThoracisMuscle.getImage());
			bioMightComponent.setWidth(transversusThoracisMuscle.getImageWidth());
			bioMightComponent.setHeight(transversusThoracisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.foot
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AbductorDigitiMinimiMuscle))
		{
			AbductorDigitiMinimiMuscle abductorDigitiMinimiMuscle = (AbductorDigitiMinimiMuscle) bioMightInstance;
			bioMightComponent.setImage(abductorDigitiMinimiMuscle.getImage());
			bioMightComponent.setWidth(abductorDigitiMinimiMuscle.getImageWidth());
			bioMightComponent.setHeight(abductorDigitiMinimiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AbductorHallucisMuscle))
		{
			AbductorHallucisMuscle abductorHallucisMuscle = (AbductorHallucisMuscle) bioMightInstance;
			bioMightComponent.setImage(abductorHallucisMuscle.getImage());
			bioMightComponent.setWidth(abductorHallucisMuscle.getImageWidth());
			bioMightComponent.setHeight(abductorHallucisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AbductorOssisMetatarsiQuintiMuscle))
		{
			AbductorOssisMetatarsiQuintiMuscle abductorOssisMetatarsiQuintiMuscle = (AbductorOssisMetatarsiQuintiMuscle) bioMightInstance;
			bioMightComponent.setImage(abductorOssisMetatarsiQuintiMuscle.getImage());
			bioMightComponent.setWidth(abductorOssisMetatarsiQuintiMuscle.getImageWidth());
			bioMightComponent.setHeight(abductorOssisMetatarsiQuintiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AdductorHallucisMuscle))
		{
			AdductorHallucisMuscle adductorHallucisMuscle = (AdductorHallucisMuscle) bioMightInstance;
			bioMightComponent.setImage(adductorHallucisMuscle.getImage());
			bioMightComponent.setWidth(adductorHallucisMuscle.getImageWidth());
			bioMightComponent.setHeight(adductorHallucisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DorsalInterosseiMuscle))
		{
			DorsalInterosseiMuscle dorsalInterosseiMuscle = (DorsalInterosseiMuscle) bioMightInstance;
			bioMightComponent.setImage(dorsalInterosseiMuscle.getImage());
			bioMightComponent.setWidth(dorsalInterosseiMuscle.getImageWidth());
			bioMightComponent.setHeight(dorsalInterosseiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorDigitorumBrevis))
		{
			ExtensorDigitorumBrevis extensorDigitorumBrevis = (ExtensorDigitorumBrevis) bioMightInstance;
			bioMightComponent.setImage(extensorDigitorumBrevis.getImage());
			bioMightComponent.setWidth(extensorDigitorumBrevis.getImageWidth());
			bioMightComponent.setHeight(extensorDigitorumBrevis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorHallucisBrevisMuscle))
		{
			ExtensorHallucisBrevisMuscle extensorHallucisBrevisMuscle = (ExtensorHallucisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorHallucisBrevisMuscle.getImage());
			bioMightComponent.setWidth(extensorHallucisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorHallucisBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorDigitiMinimiBrevis))
		{
			FlexorDigitiMinimiBrevis flexorDigitiMinimiBrevis = (FlexorDigitiMinimiBrevis) bioMightInstance;
			bioMightComponent.setImage(flexorDigitiMinimiBrevis.getImage());
			bioMightComponent.setWidth(flexorDigitiMinimiBrevis.getImageWidth());
			bioMightComponent.setHeight(flexorDigitiMinimiBrevis.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorDigitorumBrevisMuscle))
		{
			FlexorDigitorumBrevisMuscle flexorDigitorumBrevisMuscle = (FlexorDigitorumBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorDigitorumBrevisMuscle.getImage());
			bioMightComponent.setWidth(flexorDigitorumBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorDigitorumBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorHallucisBrevisMuscle))
		{
			FlexorHallucisBrevisMuscle flexorHallucisBrevisMuscle = (FlexorHallucisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorHallucisBrevisMuscle.getImage());
			bioMightComponent.setWidth(flexorHallucisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorHallucisBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InterosselMuscle))
		{
			InterosselMuscle interosselMuscle = (InterosselMuscle) bioMightInstance;
			bioMightComponent.setImage(interosselMuscle.getImage());
			bioMightComponent.setWidth(interosselMuscle.getImageWidth());
			bioMightComponent.setHeight(interosselMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LumbriclesMuscle))
		{
			LumbriclesMuscle lumbriclesMuscle = (LumbriclesMuscle) bioMightInstance;
			bioMightComponent.setImage(lumbriclesMuscle.getImage());
			bioMightComponent.setWidth(lumbriclesMuscle.getImageWidth());
			bioMightComponent.setHeight(lumbriclesMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PlantarInterosseiMuscle))
		{
			PlantarInterosseiMuscle plantarInterosseiMuscle = (PlantarInterosseiMuscle) bioMightInstance;
			bioMightComponent.setImage(plantarInterosseiMuscle.getImage());
			bioMightComponent.setWidth(plantarInterosseiMuscle.getImageWidth());
			bioMightComponent.setHeight(plantarInterosseiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.QuadratusPlantaeMuscle))
		{
			QuadratusPlantaeMuscle quadratusPlantaeMuscle = (QuadratusPlantaeMuscle) bioMightInstance;
			bioMightComponent.setImage(quadratusPlantaeMuscle.getImage());
			bioMightComponent.setWidth(quadratusPlantaeMuscle.getImageWidth());
			bioMightComponent.setHeight(quadratusPlantaeMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.hand
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AbductorPollicisBrevisMuscle))
		{
			AbductorPollicisBrevisMuscle abductorPollicisBrevisMuscle = (AbductorPollicisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(abductorPollicisBrevisMuscle.getImage());
			bioMightComponent.setWidth(abductorPollicisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(abductorPollicisBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AbductorPollicisLongusMuscle))
		{
			AbductorPollicisLongusMuscle abductorPollicisLongusMuscle = (AbductorPollicisLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(abductorPollicisLongusMuscle.getImage());
			bioMightComponent.setWidth(abductorPollicisLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(abductorPollicisLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AdductorPollicisMuscle))
		{
			AdductorPollicisMuscle adductorPollicisMuscle = (AdductorPollicisMuscle) bioMightInstance;
			bioMightComponent.setImage(adductorPollicisMuscle.getImage());
			bioMightComponent.setWidth(adductorPollicisMuscle.getImageWidth());
			bioMightComponent.setHeight(adductorPollicisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DorsalInterosseiMuscles))
		{
			DorsalInterosseiMuscles dorsalInterosseiMuscles = (DorsalInterosseiMuscles) bioMightInstance;
			bioMightComponent.setImage(dorsalInterosseiMuscles.getImage());
			bioMightComponent.setWidth(dorsalInterosseiMuscles.getImageWidth());
			bioMightComponent.setHeight(dorsalInterosseiMuscles.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorPollicisBrevisMuscle))
		{
			ExtensorPollicisBrevisMuscle extensorPollicisBrevisMuscle = (ExtensorPollicisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorPollicisBrevisMuscle.getImage());
			bioMightComponent.setWidth(extensorPollicisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorPollicisBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LumbricalMuscles))
		{
			LumbricalMuscles lumbricalMuscles = (LumbricalMuscles) bioMightInstance;
			bioMightComponent.setImage(lumbricalMuscles.getImage());
			bioMightComponent.setWidth(lumbricalMuscles.getImageWidth());
			bioMightComponent.setHeight(lumbricalMuscles.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OpponensDigitiMinimiMuscle))
		{
			OpponensDigitiMinimiMuscle opponensDigitiMinimiMuscle = (OpponensDigitiMinimiMuscle) bioMightInstance;
			bioMightComponent.setImage(opponensDigitiMinimiMuscle.getImage());
			bioMightComponent.setWidth(opponensDigitiMinimiMuscle.getImageWidth());
			bioMightComponent.setHeight(opponensDigitiMinimiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OpponensPollicisMuscle))
		{
			OpponensPollicisMuscle opponensPollicisMuscle = (OpponensPollicisMuscle) bioMightInstance;
			bioMightComponent.setImage(opponensPollicisMuscle.getImage());
			bioMightComponent.setWidth(opponensPollicisMuscle.getImageWidth());
			bioMightComponent.setHeight(opponensPollicisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PalmarInterosseiMuscles))
		{
			PalmarInterosseiMuscles palmarInterosseiMuscles = (PalmarInterosseiMuscles) bioMightInstance;
			bioMightComponent.setImage(palmarInterosseiMuscles.getImage());
			bioMightComponent.setWidth(palmarInterosseiMuscles.getImageWidth());
			bioMightComponent.setHeight(palmarInterosseiMuscles.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PalmarisBrevisMuscle))
		{
			PalmarisBrevisMuscle palmarisBrevisMuscle = (PalmarisBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(palmarisBrevisMuscle.getImage());
			bioMightComponent.setWidth(palmarisBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(palmarisBrevisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.head
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AuricularisAnteriorMuscle))
		{
			AuricularisAnteriorMuscle auricularisAnteriorMuscle = (AuricularisAnteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(auricularisAnteriorMuscle.getImage());
			bioMightComponent.setWidth(auricularisAnteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(auricularisAnteriorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.EpicraniusMuscle))
		{
			EpicraniusMuscle epicraniusMuscle = (EpicraniusMuscle) bioMightInstance;
			bioMightComponent.setImage(epicraniusMuscle.getImage());
			bioMightComponent.setWidth(epicraniusMuscle.getImageWidth());
			bioMightComponent.setHeight(epicraniusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FrontalisMuscle))
		{
			FrontalisMuscle frontalisMuscle = (FrontalisMuscle) bioMightInstance;
			bioMightComponent.setImage(frontalisMuscle.getImage());
			bioMightComponent.setWidth(frontalisMuscle.getImageWidth());
			bioMightComponent.setHeight(frontalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GaleaAponeuroticaMuscle))
		{
			GaleaAponeuroticaMuscle galeaAponeuroticaMuscle = (GaleaAponeuroticaMuscle) bioMightInstance;
			bioMightComponent.setImage(galeaAponeuroticaMuscle.getImage());
			bioMightComponent.setWidth(galeaAponeuroticaMuscle.getImageWidth());
			bioMightComponent.setHeight(galeaAponeuroticaMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OccipitalisMuscle))
		{
			OccipitalisMuscle occipitalisMuscle = (OccipitalisMuscle) bioMightInstance;
			bioMightComponent.setImage(occipitalisMuscle.getImage());
			bioMightComponent.setWidth(occipitalisMuscle.getImageWidth());
			bioMightComponent.setHeight(occipitalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperficialFascia))
		{
			SuperficialFascia superficialFascia = (SuperficialFascia) bioMightInstance;
			bioMightComponent.setImage(superficialFascia.getImage());
			bioMightComponent.setWidth(superficialFascia.getImageWidth());
			bioMightComponent.setHeight(superficialFascia.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.head.eye
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.InferiorObliqueMuscle))
		{
			InferiorObliqueMuscle inferiorObliqueMuscle = (InferiorObliqueMuscle) bioMightInstance;
			bioMightComponent.setImage(inferiorObliqueMuscle.getImage());
			bioMightComponent.setWidth(inferiorObliqueMuscle.getImageWidth());
			bioMightComponent.setHeight(inferiorObliqueMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InferiorRectusMuscle))
		{
			InferiorRectusMuscle inferiorRectusMuscle = (InferiorRectusMuscle) bioMightInstance;
			bioMightComponent.setImage(inferiorRectusMuscle.getImage());
			bioMightComponent.setWidth(inferiorRectusMuscle.getImageWidth());
			bioMightComponent.setHeight(inferiorRectusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LateralRectusMuscle))
		{
			LateralRectusMuscle lateralRectusMuscle = (LateralRectusMuscle) bioMightInstance;
			bioMightComponent.setImage(lateralRectusMuscle.getImage());
			bioMightComponent.setWidth(lateralRectusMuscle.getImageWidth());
			bioMightComponent.setHeight(lateralRectusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MediallRectusMuscle))
		{
			MediallRectusMuscle mediallRectusMuscle = (MediallRectusMuscle) bioMightInstance;
			bioMightComponent.setImage(mediallRectusMuscle.getImage());
			bioMightComponent.setWidth(mediallRectusMuscle.getImageWidth());
			bioMightComponent.setHeight(mediallRectusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorObliqueMuscle))
		{
			SuperiorObliqueMuscle superiorObliqueMuscle = (SuperiorObliqueMuscle) bioMightInstance;
			bioMightComponent.setImage(superiorObliqueMuscle.getImage());
			bioMightComponent.setWidth(superiorObliqueMuscle.getImageWidth());
			bioMightComponent.setHeight(superiorObliqueMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorRectusMuscle))
		{
			SuperiorRectusMuscle superiorRectusMuscle = (SuperiorRectusMuscle) bioMightInstance;
			bioMightComponent.setImage(superiorRectusMuscle.getImage());
			bioMightComponent.setWidth(superiorRectusMuscle.getImageWidth());
			bioMightComponent.setHeight(superiorRectusMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.head.eyelid
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.CorrugatorMuscle))
		{
			CorrugatorMuscle corrugatorMuscle = (CorrugatorMuscle) bioMightInstance;
			bioMightComponent.setImage(corrugatorMuscle.getImage());
			bioMightComponent.setWidth(corrugatorMuscle.getImageWidth());
			bioMightComponent.setHeight(corrugatorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatorPalpebraeSuperiorisMuscle))
		{
			LevatorPalpebraeSuperiorisMuscle levatorPalpebraeSuperiorisMuscle = (LevatorPalpebraeSuperiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(levatorPalpebraeSuperiorisMuscle.getImage());
			bioMightComponent.setWidth(levatorPalpebraeSuperiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(levatorPalpebraeSuperiorisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorisMuscle))
		{
			SuperiorisMuscle superiorisMuscle = (SuperiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(superiorisMuscle.getImage());
			bioMightComponent.setWidth(superiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(superiorisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.head.facial
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.CorrugatorSuperciliiMuscle))
		{
			CorrugatorSuperciliiMuscle corrugatorSuperciliiMuscle = (CorrugatorSuperciliiMuscle) bioMightInstance;
			bioMightComponent.setImage(corrugatorSuperciliiMuscle.getImage());
			bioMightComponent.setWidth(corrugatorSuperciliiMuscle.getImageWidth());
			bioMightComponent.setHeight(corrugatorSuperciliiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatorLabiiSuperiorisAlaequeNasiMuscle))
		{
			LevatorLabiiSuperiorisAlaequeNasiMuscle levatorLabiiSuperiorisAlaequeNasiMuscle = (LevatorLabiiSuperiorisAlaequeNasiMuscle) bioMightInstance;
			bioMightComponent.setImage(levatorLabiiSuperiorisAlaequeNasiMuscle.getImage());
			bioMightComponent.setWidth(levatorLabiiSuperiorisAlaequeNasiMuscle.getImageWidth());
			bioMightComponent.setHeight(levatorLabiiSuperiorisAlaequeNasiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatorLabiiSuperiorisMuscle))
		{
			LevatorLabiiSuperiorisMuscle levatorLabiiSuperiorisMuscle = (LevatorLabiiSuperiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(levatorLabiiSuperiorisMuscle.getImage());
			bioMightComponent.setWidth(levatorLabiiSuperiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(levatorLabiiSuperiorisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OrbicularisOculiMuscle))
		{
			OrbicularisOculiMuscle orbicularisOculiMuscle = (OrbicularisOculiMuscle) bioMightInstance;
			bioMightComponent.setImage(orbicularisOculiMuscle.getImage());
			bioMightComponent.setWidth(orbicularisOculiMuscle.getImageWidth());
			bioMightComponent.setHeight(orbicularisOculiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OrbicularisOrisMuscle))
		{
			OrbicularisOrisMuscle orbicularisOrisMuscle = (OrbicularisOrisMuscle) bioMightInstance;
			bioMightComponent.setImage(orbicularisOrisMuscle.getImage());
			bioMightComponent.setWidth(orbicularisOrisMuscle.getImageWidth());
			bioMightComponent.setHeight(orbicularisOrisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.head.mastication
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.MasseterMuscle))
		{
			MasseterMuscle masseterMuscle = (MasseterMuscle) bioMightInstance;
			bioMightComponent.setImage(masseterMuscle.getImage());
			bioMightComponent.setWidth(masseterMuscle.getImageWidth());
			bioMightComponent.setHeight(masseterMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PterygoideusExternusMuscle))
		{
			PterygoideusExternusMuscle pterygoideusExternusMuscle = (PterygoideusExternusMuscle) bioMightInstance;
			bioMightComponent.setImage(pterygoideusExternusMuscle.getImage());
			bioMightComponent.setWidth(pterygoideusExternusMuscle.getImageWidth());
			bioMightComponent.setHeight(pterygoideusExternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PterygoideusInternusMuscle))
		{
			PterygoideusInternusMuscle pterygoideusInternusMuscle = (PterygoideusInternusMuscle) bioMightInstance;
			bioMightComponent.setImage(pterygoideusInternusMuscle.getImage());
			bioMightComponent.setWidth(pterygoideusInternusMuscle.getImageWidth());
			bioMightComponent.setHeight(pterygoideusInternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TemporalisMuscle))
		{
			TemporalisMuscle temporalisMuscle = (TemporalisMuscle) bioMightInstance;
			bioMightComponent.setImage(temporalisMuscle.getImage());
			bioMightComponent.setWidth(temporalisMuscle.getImageWidth());
			bioMightComponent.setHeight(temporalisMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.head.mouth
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.BuccinatorMuscle))
		{
			BuccinatorMuscle buccinatorMuscle = (BuccinatorMuscle) bioMightInstance;
			bioMightComponent.setImage(buccinatorMuscle.getImage());
			bioMightComponent.setWidth(buccinatorMuscle.getImageWidth());
			bioMightComponent.setHeight(buccinatorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CaninusMuscle))
		{
			CaninusMuscle caninusMuscle = (CaninusMuscle) bioMightInstance;
			bioMightComponent.setImage(caninusMuscle.getImage());
			bioMightComponent.setWidth(caninusMuscle.getImageWidth());
			bioMightComponent.setHeight(caninusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DepressorAnguliOrisMuscle))
		{
			DepressorAnguliOrisMuscle depressorAnguliOrisMuscle = (DepressorAnguliOrisMuscle) bioMightInstance;
			bioMightComponent.setImage(depressorAnguliOrisMuscle.getImage());
			bioMightComponent.setWidth(depressorAnguliOrisMuscle.getImageWidth());
			bioMightComponent.setHeight(depressorAnguliOrisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DepressorLabiiInferiorisMuscle))
		{
			DepressorLabiiInferiorisMuscle depressorLabiiInferiorisMuscle = (DepressorLabiiInferiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(depressorLabiiInferiorisMuscle.getImage());
			bioMightComponent.setWidth(depressorLabiiInferiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(depressorLabiiInferiorisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LevatorAnguliOrisMuscle))
		{
			LevatorAnguliOrisMuscle levatorAnguliOrisMuscle = (LevatorAnguliOrisMuscle) bioMightInstance;
			bioMightComponent.setImage(levatorAnguliOrisMuscle.getImage());
			bioMightComponent.setWidth(levatorAnguliOrisMuscle.getImageWidth());
			bioMightComponent.setHeight(levatorAnguliOrisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MentalisMuscle))
		{
			MentalisMuscle mentalisMuscle = (MentalisMuscle) bioMightInstance;
			bioMightComponent.setImage(mentalisMuscle.getImage());
			bioMightComponent.setWidth(mentalisMuscle.getImageWidth());
			bioMightComponent.setHeight(mentalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.QuadratusLabiiInferiorisMuscle))
		{
			QuadratusLabiiInferiorisMuscle quadratusLabiiInferiorisMuscle = (QuadratusLabiiInferiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(quadratusLabiiInferiorisMuscle.getImage());
			bioMightComponent.setWidth(quadratusLabiiInferiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(quadratusLabiiInferiorisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.QuadratusLabiiSuperiorisMuscle))
		{
			QuadratusLabiiSuperiorisMuscle quadratusLabiiSuperiorisMuscle = (QuadratusLabiiSuperiorisMuscle) bioMightInstance;
			bioMightComponent.setImage(quadratusLabiiSuperiorisMuscle.getImage());
			bioMightComponent.setWidth(quadratusLabiiSuperiorisMuscle.getImageWidth());
			bioMightComponent.setHeight(quadratusLabiiSuperiorisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RisoriusMuscle))
		{
			RisoriusMuscle risoriusMuscle = (RisoriusMuscle) bioMightInstance;
			bioMightComponent.setImage(risoriusMuscle.getImage());
			bioMightComponent.setWidth(risoriusMuscle.getImageWidth());
			bioMightComponent.setHeight(risoriusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TriangularisMuscle))
		{
			TriangularisMuscle triangularisMuscle = (TriangularisMuscle) bioMightInstance;
			bioMightComponent.setImage(triangularisMuscle.getImage());
			bioMightComponent.setWidth(triangularisMuscle.getImageWidth());
			bioMightComponent.setHeight(triangularisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ZygomaticusMajorMuscle))
		{
			ZygomaticusMajorMuscle zygomaticusMajorMuscle = (ZygomaticusMajorMuscle) bioMightInstance;
			bioMightComponent.setImage(zygomaticusMajorMuscle.getImage());
			bioMightComponent.setWidth(zygomaticusMajorMuscle.getImageWidth());
			bioMightComponent.setHeight(zygomaticusMajorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ZygomaticusMinorMuscle))
		{
			ZygomaticusMinorMuscle zygomaticusMinorMuscle = (ZygomaticusMinorMuscle) bioMightInstance;
			bioMightComponent.setImage(zygomaticusMinorMuscle.getImage());
			bioMightComponent.setWidth(zygomaticusMinorMuscle.getImageWidth());
			bioMightComponent.setHeight(zygomaticusMinorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ZygomaticusMuscle))
		{
			ZygomaticusMuscle zygomaticusMuscle = (ZygomaticusMuscle) bioMightInstance;
			bioMightComponent.setImage(zygomaticusMuscle.getImage());
			bioMightComponent.setWidth(zygomaticusMuscle.getImageWidth());
			bioMightComponent.setHeight(zygomaticusMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.head.mouth.tongue
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.InferiorLongitudinalMuscle))
		{
			InferiorLongitudinalMuscle inferiorLongitudinalMuscle = (InferiorLongitudinalMuscle) bioMightInstance;
			bioMightComponent.setImage(inferiorLongitudinalMuscle.getImage());
			bioMightComponent.setWidth(inferiorLongitudinalMuscle.getImageWidth());
			bioMightComponent.setHeight(inferiorLongitudinalMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorLongitudinalMuscle))
		{
			SuperiorLongitudinalMuscle superiorLongitudinalMuscle = (SuperiorLongitudinalMuscle) bioMightInstance;
			bioMightComponent.setImage(superiorLongitudinalMuscle.getImage());
			bioMightComponent.setWidth(superiorLongitudinalMuscle.getImageWidth());
			bioMightComponent.setHeight(superiorLongitudinalMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TransversusMuscle))
		{
			TransversusMuscle transversusMuscle = (TransversusMuscle) bioMightInstance;
			bioMightComponent.setImage(transversusMuscle.getImage());
			bioMightComponent.setWidth(transversusMuscle.getImageWidth());
			bioMightComponent.setHeight(transversusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.VerticalisMuscle))
		{
			VerticalisMuscle verticalisMuscle = (VerticalisMuscle) bioMightInstance;
			bioMightComponent.setImage(verticalisMuscle.getImage());
			bioMightComponent.setWidth(verticalisMuscle.getImageWidth());
			bioMightComponent.setHeight(verticalisMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.head.nose
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.DepressorSeptiNasiMuscle))
		{
			DepressorSeptiNasiMuscle depressorSeptiNasiMuscle = (DepressorSeptiNasiMuscle) bioMightInstance;
			bioMightComponent.setImage(depressorSeptiNasiMuscle.getImage());
			bioMightComponent.setWidth(depressorSeptiNasiMuscle.getImageWidth());
			bioMightComponent.setHeight(depressorSeptiNasiMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DilatatorNarisPosterior))
		{
			DilatatorNarisPosterior dilatatorNarisPosterior = (DilatatorNarisPosterior) bioMightInstance;
			bioMightComponent.setImage(dilatatorNarisPosterior.getImage());
			bioMightComponent.setWidth(dilatatorNarisPosterior.getImageWidth());
			bioMightComponent.setHeight(dilatatorNarisPosterior.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.NasalisMuscle))
		{
			NasalisMuscle nasalisMuscle = (NasalisMuscle) bioMightInstance;
			bioMightComponent.setImage(nasalisMuscle.getImage());
			bioMightComponent.setWidth(nasalisMuscle.getImageWidth());
			bioMightComponent.setHeight(nasalisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ProcerusMuscle))
		{
			ProcerusMuscle procerusMuscle = (ProcerusMuscle) bioMightInstance;
			bioMightComponent.setImage(procerusMuscle.getImage());
			bioMightComponent.setWidth(procerusMuscle.getImageWidth());
			bioMightComponent.setHeight(procerusMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.hip
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AdductorBrevisMuscle))
		{
			AdductorBrevisMuscle adductorBrevisMuscle = (AdductorBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(adductorBrevisMuscle.getImage());
			bioMightComponent.setWidth(adductorBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(adductorBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AdductorMagnusMuscle))
		{
			AdductorMagnusMuscle adductorMagnusMuscle = (AdductorMagnusMuscle) bioMightInstance;
			bioMightComponent.setImage(adductorMagnusMuscle.getImage());
			bioMightComponent.setWidth(adductorMagnusMuscle.getImageWidth());
			bioMightComponent.setHeight(adductorMagnusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ArticularisGenusMuscle))
		{
			ArticularisGenusMuscle articularisGenusMuscle = (ArticularisGenusMuscle) bioMightInstance;
			bioMightComponent.setImage(articularisGenusMuscle.getImage());
			bioMightComponent.setWidth(articularisGenusMuscle.getImageWidth());
			bioMightComponent.setHeight(articularisGenusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CoccygeusMuscle))
		{
			CoccygeusMuscle coccygeusMuscle = (CoccygeusMuscle) bioMightInstance;
			bioMightComponent.setImage(coccygeusMuscle.getImage());
			bioMightComponent.setWidth(coccygeusMuscle.getImageWidth());
			bioMightComponent.setHeight(coccygeusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GemelliMuscle))
		{
			GemelliMuscle gemelliMuscle = (GemelliMuscle) bioMightInstance;
			bioMightComponent.setImage(gemelliMuscle.getImage());
			bioMightComponent.setWidth(gemelliMuscle.getImageWidth());
			bioMightComponent.setHeight(gemelliMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GluteusMaximusMuscle))
		{
			GluteusMaximusMuscle gluteusMaximusMuscle = (GluteusMaximusMuscle) bioMightInstance;
			bioMightComponent.setImage(gluteusMaximusMuscle.getImage());
			bioMightComponent.setWidth(gluteusMaximusMuscle.getImageWidth());
			bioMightComponent.setHeight(gluteusMaximusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IliacusMuscle))
		{
			IliacusMuscle iliacusMuscle = (IliacusMuscle) bioMightInstance;
			bioMightComponent.setImage(iliacusMuscle.getImage());
			bioMightComponent.setWidth(iliacusMuscle.getImageWidth());
			bioMightComponent.setHeight(iliacusMuscle.getImageHeight());
			
		}
		else if (bioMightComponentRef.equals(Constants.IliopsoasMuscle))
		{
			IliopsoasMuscle iliopsoasMuscle = (IliopsoasMuscle) bioMightInstance;
			bioMightComponent.setImage(iliopsoasMuscle.getImage());
			bioMightComponent.setWidth(iliopsoasMuscle.getImageWidth());
			bioMightComponent.setHeight(iliopsoasMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IlotibialTractMuscle))
		{
			IlotibialTractMuscle ilotibialTractMuscle = (IlotibialTractMuscle) bioMightInstance;
			bioMightComponent.setImage(ilotibialTractMuscle.getImage());
			bioMightComponent.setWidth(ilotibialTractMuscle.getImageWidth());
			bioMightComponent.setHeight(ilotibialTractMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InferiorGemelliMuscle))
		{
			InferiorGemelliMuscle inferiorGemelliMuscle = (InferiorGemelliMuscle) bioMightInstance;
			bioMightComponent.setImage(inferiorGemelliMuscle.getImage());
			bioMightComponent.setWidth(inferiorGemelliMuscle.getImageWidth());
			bioMightComponent.setHeight(inferiorGemelliMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PiriformisMuscle))
		{
			PiriformisMuscle piriformisMuscle = (PiriformisMuscle) bioMightInstance;
			bioMightComponent.setImage(piriformisMuscle.getImage());
			bioMightComponent.setWidth(piriformisMuscle.getImageWidth());
			bioMightComponent.setHeight(piriformisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorGemelliMuscle))
		{
			SuperiorGemelliMuscle superiorGemelliMuscle = (SuperiorGemelliMuscle) bioMightInstance;
			bioMightComponent.setImage(superiorGemelliMuscle.getImage());
			bioMightComponent.setWidth(superiorGemelliMuscle.getImageWidth());
			bioMightComponent.setHeight(superiorGemelliMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TensorFasciaeLataMuscle))
		{
			TensorFasciaLataMuscle tensorFasciaeLataMuscle = (TensorFasciaLataMuscle) bioMightInstance;
			bioMightComponent.setImage(tensorFasciaeLataMuscle.getImage());
			bioMightComponent.setWidth(tensorFasciaeLataMuscle.getImageWidth());
			bioMightComponent.setHeight(tensorFasciaeLataMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.leg.cnemus
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.ExtensorDigitorumLongusMuscle))
		{
			ExtensorDigitorumLongusMuscle extensorDigitorumLongusMuscle = (ExtensorDigitorumLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorDigitorumLongusMuscle.getImage());
			bioMightComponent.setWidth(extensorDigitorumLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorDigitorumLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ExtensorHallicusLongusMuscle))
		{
			ExtensorHallicusLongusMuscle extensorHallicusLongusMuscle = (ExtensorHallicusLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(extensorHallicusLongusMuscle.getImage());
			bioMightComponent.setWidth(extensorHallicusLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(extensorHallicusLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorDigitorumLongusMuscle))
		{
			FlexorDigitorumLongusMuscle flexorDigitorumLongusMuscle = (FlexorDigitorumLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorDigitorumLongusMuscle.getImage());
			bioMightComponent.setWidth(flexorDigitorumLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorDigitorumLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.FlexorHallicusLongusMuscle))
		{
			FlexorHallicusLongusMuscle flexorHallicusLongusMuscle = (FlexorHallicusLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(flexorHallicusLongusMuscle.getImage());
			bioMightComponent.setWidth(flexorHallicusLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(flexorHallicusLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GastrocnemiusMuscle))
		{
			GastrocnemiusMuscle gastrocnemiusMuscle = (GastrocnemiusMuscle) bioMightInstance;
			bioMightComponent.setImage(gastrocnemiusMuscle.getImage());
			bioMightComponent.setWidth(gastrocnemiusMuscle.getImageWidth());
			bioMightComponent.setHeight(gastrocnemiusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PeroneusLongusMuscle))
		{
			PeroneusLongusMuscle peroneusLongusMuscle = (PeroneusLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(peroneusLongusMuscle.getImage());
			bioMightComponent.setWidth(peroneusLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(peroneusLongusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PeroneusTertiusMuscle))
		{
			PeroneusTertiusMuscle peroneusTertiusMuscle = (PeroneusTertiusMuscle) bioMightInstance;
			bioMightComponent.setImage(peroneusTertiusMuscle.getImage());
			bioMightComponent.setWidth(peroneusTertiusMuscle.getImageWidth());
			bioMightComponent.setHeight(peroneusTertiusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PeroneusBrevisMuscle))
		{
			PeroneusBrevisMuscle peroneusBrevisMuscle = (PeroneusBrevisMuscle) bioMightInstance;
			bioMightComponent.setImage(peroneusBrevisMuscle.getImage());
			bioMightComponent.setWidth(peroneusBrevisMuscle.getImageWidth());
			bioMightComponent.setHeight(peroneusBrevisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PlantarisMuscle))
		{
			PlantarisMuscle plantarisMuscle = (PlantarisMuscle) bioMightInstance;
			bioMightComponent.setImage(plantarisMuscle.getImage());
			bioMightComponent.setWidth(plantarisMuscle.getImageWidth());
			bioMightComponent.setHeight(plantarisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SoleusMuscle))
		{
			SoleusMuscle soleusMuscle = (SoleusMuscle) bioMightInstance;
			bioMightComponent.setImage(soleusMuscle.getImage());
			bioMightComponent.setWidth(soleusMuscle.getImageWidth());
			bioMightComponent.setHeight(soleusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TibialisAnteriorMuscle))
		{
			TibialisAnteriorMuscle tibialisAnteriorMuscle = (TibialisAnteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(tibialisAnteriorMuscle.getImage());
			bioMightComponent.setWidth(tibialisAnteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(tibialisAnteriorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TibialisPosteriorMuscle))
		{
			TibialisPosteriorMuscle tibialisPosteriorMuscle = (TibialisPosteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(tibialisPosteriorMuscle.getImage());
			bioMightComponent.setWidth(tibialisPosteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(tibialisPosteriorMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.leg.thigh
		//*****************************************************************************
		else if (bioMightComponentRef.equals(Constants.AdductorLongusMuscle))
		{
			AdductorLongusMuscle adductorLongusMuscle = (AdductorLongusMuscle) bioMightInstance;
			bioMightComponent.setImage(adductorLongusMuscle.getImage());
			bioMightComponent.setWidth(adductorLongusMuscle.getImageWidth());
			bioMightComponent.setHeight(adductorLongusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(adductorLongusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(adductorLongusMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdductorLongusMuscle: "  + bioMightComponent +  "   " + adductorLongusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adductorLongusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing AdductorLongusMuscle Methods!");
				//adductorLongusMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing AdductorLongusMuscle!");
				//adductorLongusMuscle.redraw(0);
			}
			System.out.println("Getting X3D for AdductorLongusMuscle!");
			bioMightComponent.setX3D(adductorLongusMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.BicepsFemorisMuscle))
		{
			BicepsFemorisMuscle bicepsFemorisMuscle = (BicepsFemorisMuscle) bioMightInstance;
			bioMightComponent.setImage(bicepsFemorisMuscle.getImage());
			bioMightComponent.setWidth(bicepsFemorisMuscle.getImageWidth());
			bioMightComponent.setHeight(bicepsFemorisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(bicepsFemorisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(bicepsFemorisMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BicepsFemorisMuscle: "  + bioMightComponent +  "   " + bicepsFemorisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bicepsFemorisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing BicepsFemorisMuscle Methods!");
				//bicepsFemorisMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing BicepsFemorisMuscle!");
				//bicepsFemorisMuscle.redraw(0);
			}
			System.out.println("Getting X3D for BicepsFemorisMuscle!");
			bioMightComponent.setX3D(bicepsFemorisMuscle.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.GluteusMaximusMuscle))
		{
			GluteusMaximusMuscle gluteusMaximusMuscle = (GluteusMaximusMuscle) bioMightInstance;
			bioMightComponent.setImage(gluteusMaximusMuscle.getImage());
			bioMightComponent.setWidth(gluteusMaximusMuscle.getImageWidth());
			bioMightComponent.setHeight(gluteusMaximusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GluteusMediusMuscle))
		{
			GluteusMediusMuscle gluteusMediusMuscle = (GluteusMediusMuscle) bioMightInstance;
			bioMightComponent.setImage(gluteusMediusMuscle.getImage());
			bioMightComponent.setWidth(gluteusMediusMuscle.getImageWidth());
			bioMightComponent.setHeight(gluteusMediusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GluteusMinimusMuscle))
		{
			GluteusMinimusMuscle gluteusMinimusMuscle = (GluteusMinimusMuscle) bioMightInstance;
			bioMightComponent.setImage(gluteusMinimusMuscle.getImage());
			bioMightComponent.setWidth(gluteusMinimusMuscle.getImageWidth());
			bioMightComponent.setHeight(gluteusMinimusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GracilisMuscle))
		{
			GracilisMuscle gracilisMuscle = (GracilisMuscle) bioMightInstance;
			bioMightComponent.setImage(gracilisMuscle.getImage());
			bioMightComponent.setWidth(gracilisMuscle.getImageWidth());
			bioMightComponent.setHeight(gracilisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(gracilisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(gracilisMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GracilisMuscle: "  + bioMightComponent +  "   " + gracilisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gracilisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing AdductorLongusMuscle Methods!");
				//gracilisMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing GracilisMuscle!");
				//gracilisMuscle.redraw(0);
			}
			System.out.println("Getting X3D for GracilisMuscle!");
			bioMightComponent.setX3D(gracilisMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.IliacusMuscle))
		{
			IliacusMuscle illiacusMuscle = (IliacusMuscle) bioMightInstance;
			bioMightComponent.setImage(illiacusMuscle.getImage());
			bioMightComponent.setWidth(illiacusMuscle.getImageWidth());
			bioMightComponent.setHeight(illiacusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(illiacusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(illiacusMuscle.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdductorLongusMuscle: "  + bioMightComponent +  "   " + illiacusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(illiacusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing AdductorLongusMuscle Methods!");
				//gracilisMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing HEAD!");
				//gracilisMuscle.redraw(0);
			}
			System.out.println("Getting X3D for Iris!");
			bioMightComponent.setX3D(illiacusMuscle.getX3D(false));				
		}
		else if (bioMightComponentRef.equals(Constants.ObturatorExternusMuscle))
		{
			ObturatorExternusMuscle obturatorExternusMuscle = (ObturatorExternusMuscle) bioMightInstance;
			bioMightComponent.setImage(obturatorExternusMuscle.getImage());
			bioMightComponent.setWidth(obturatorExternusMuscle.getImageWidth());
			bioMightComponent.setHeight(obturatorExternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ObturatorInternusMuscle))
		{
			ObturatorInternusMuscle obturatorInternusMuscle = (ObturatorInternusMuscle) bioMightInstance;
			bioMightComponent.setImage(obturatorInternusMuscle.getImage());
			bioMightComponent.setWidth(obturatorInternusMuscle.getImageWidth());
			bioMightComponent.setHeight(obturatorInternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PectineusMuscle))
		{
			PectineusMuscle pectineusMuscle = (PectineusMuscle) bioMightInstance;
			bioMightComponent.setImage(pectineusMuscle.getImage());
			bioMightComponent.setWidth(pectineusMuscle.getImageWidth());
			bioMightComponent.setHeight(pectineusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.PopliteusMuscle))
		{
			PopliteusMuscle popliteusMuscle = (PopliteusMuscle) bioMightInstance;
			bioMightComponent.setImage(popliteusMuscle.getImage());
			bioMightComponent.setWidth(popliteusMuscle.getImageWidth());
			bioMightComponent.setHeight(popliteusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(popliteusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(popliteusMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PopliteusMuscle: "  + bioMightComponent +  "   " + popliteusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(popliteusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing PopliteusMuscle Methods!");
				//popliteusMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing PopliteusMuscle!");
				//popliteusMuscle.redraw(0);
			}
			System.out.println("Getting X3D for PopliteusMuscle!");
			bioMightComponent.setX3D(popliteusMuscle.getX3D(false));				
		}	
		else if (bioMightComponentRef.equals(Constants.PectoralisMajorMuscles))
		{
			PectoralisMajorMuscles pectoralisMajorMuscles = (PectoralisMajorMuscles) bioMightInstance;
			bioMightComponent.setImage(pectoralisMajorMuscles.getImage());
			bioMightComponent.setWidth(pectoralisMajorMuscles.getImageWidth());
			bioMightComponent.setHeight(pectoralisMajorMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(pectoralisMajorMuscles.getProperties());
			bioMightComponent.setBioMightMethods(pectoralisMajorMuscles.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PectoralisMajorMuscles: "  + bioMightComponent +  "     ID: " + pectoralisMajorMuscles.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pectoralisMajorMuscles.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ARMS Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}
			bioMightComponent.setX3D(pectoralisMajorMuscles.getX3D(false));								
		}
		else if (bioMightComponentRef.equals(Constants.PectoralisMajorMuscle))
		{
			PectoralisMajorMuscle pectoralisMajorMuscle = (PectoralisMajorMuscle) bioMightInstance;
			bioMightComponent.setImage(pectoralisMajorMuscle.getImage());
			bioMightComponent.setWidth(pectoralisMajorMuscle.getImageWidth());
			bioMightComponent.setHeight(pectoralisMajorMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(pectoralisMajorMuscle.getProperties());
			bioMightComponent.setBioMightMethods(pectoralisMajorMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PectoralisMajorMuscle: "  + bioMightComponent +  "   " + pectoralisMajorMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pectoralisMajorMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing PectoralisMajorMuscle Methods!");
				//pectoralisMajorMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing PectoralisMajorMuscle!");
				//pectoralisMajorMuscle.redraw(0);
			}
			System.out.println("Getting X3D for PectoralisMajorMuscle!");
			bioMightComponent.setX3D(pectoralisMajorMuscle.getX3D(false));				
		}
		else if (bioMightComponentRef.equals(Constants.PectoralisMinorMuscles))
		{
			PectoralisMinorMuscles pectoralisMinorMuscles = (PectoralisMinorMuscles) bioMightInstance;
			bioMightComponent.setImage(pectoralisMinorMuscles.getImage());
			bioMightComponent.setWidth(pectoralisMinorMuscles.getImageWidth());
			bioMightComponent.setHeight(pectoralisMinorMuscles.getImageHeight());
			bioMightComponent.setBioMightProperties(pectoralisMinorMuscles.getProperties());
			bioMightComponent.setBioMightMethods(pectoralisMinorMuscles.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PectoralisMajorMuscles: "  + bioMightComponent +  "     ID: " + pectoralisMinorMuscles.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pectoralisMinorMuscles.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ARMS Methods!");
			//	head.executeMethods(methodParams);
			//	head.redraw(0);
			//}
			bioMightComponent.setX3D(pectoralisMinorMuscles.getX3D(false));								
		}	
		else if (bioMightComponentRef.equals(Constants.PectoralisMinorMuscle))
		{
			PectoralisMinorMuscle pectoralisMinorMuscle = (PectoralisMinorMuscle) bioMightInstance;
			bioMightComponent.setImage(pectoralisMinorMuscle.getImage());
			bioMightComponent.setWidth(pectoralisMinorMuscle.getImageWidth());
			bioMightComponent.setHeight(pectoralisMinorMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(pectoralisMinorMuscle.getProperties());
			bioMightComponent.setBioMightMethods(pectoralisMinorMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PectoralisMinorMuscle: "  + bioMightComponent +  "   " + pectoralisMinorMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pectoralisMinorMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing PectoralisMinorMuscle Methods!");
				//pectoralisMinorMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing PectoralisMinorMuscle!");
				//pectoralisMinorMuscle.redraw(0);
			}
			System.out.println("Getting X3D for PectoralisMinorMuscle!");
			bioMightComponent.setX3D(pectoralisMinorMuscle.getX3D(false));				
		}		
		else if (bioMightComponentRef.equals(Constants.QuadricepsFemorisMuscle))
		{
			QuadricepsFemorisMuscle quadricepsFemorisMuscle = (QuadricepsFemorisMuscle) bioMightInstance;
			bioMightComponent.setImage(quadricepsFemorisMuscle.getImage());
			bioMightComponent.setWidth(quadricepsFemorisMuscle.getImageWidth());
			bioMightComponent.setHeight(quadricepsFemorisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(quadricepsFemorisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(quadricepsFemorisMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PopliteusMuscle: "  + bioMightComponent +  "   " + quadricepsFemorisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(quadricepsFemorisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing PopliteusMuscle Methods!");
				//quadricepsFemorisMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing PopliteusMuscle!");
				//quadricepsFemorisMuscle.redraw(0);
			}
			System.out.println("Getting X3D for QuadricepsFemorisMuscle!");
			bioMightComponent.setX3D(quadricepsFemorisMuscle.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.RectusFemorisMuscle))
		{
			RectusFemorisMuscle rectusFemorisMuscle = (RectusFemorisMuscle) bioMightInstance;
			bioMightComponent.setImage(rectusFemorisMuscle.getImage());
			bioMightComponent.setWidth(rectusFemorisMuscle.getImageWidth());
			bioMightComponent.setHeight(rectusFemorisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(rectusFemorisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(rectusFemorisMuscle.getMethods());
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RectusFemorisMuscle: "  + bioMightComponent +  "   " + rectusFemorisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(rectusFemorisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing PopliteusMuscle Methods!");
				//quadricepsFemorisMuscle.executeMethods(methodParams);
				//System.out.println("Redrawing PopliteusMuscle!");
				//quadricepsFemorisMuscle.redraw(0);
			}
			System.out.println("Getting X3D for RectusFemorisMuscle!");
			bioMightComponent.setX3D(rectusFemorisMuscle.getX3D(false));	
		}
		else if (bioMightComponentRef.equals(Constants.SartoriusMuscle))
		{
			SartoriusMuscle sartoriusMuscle = (SartoriusMuscle) bioMightInstance;
			bioMightComponent.setImage(sartoriusMuscle.getImage());
			bioMightComponent.setWidth(sartoriusMuscle.getImageWidth());
			bioMightComponent.setHeight(sartoriusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(sartoriusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(sartoriusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SartoriusMuscle: "  + bioMightComponent +  "     ID: " + sartoriusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(sartoriusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SartoriusMuscle Methods!");
			//	sartoriusMuscle.executeMethods(methodParams);
			//	sartoriusMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for SupinatorMuscle!");
			bioMightComponent.setX3D(sartoriusMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.SemiMembranosusMuscle))
		{
			SemiMembranosusMuscle semiMembranosusMuscle = (SemiMembranosusMuscle) bioMightInstance;
			bioMightComponent.setImage(semiMembranosusMuscle.getImage());
			bioMightComponent.setWidth(semiMembranosusMuscle.getImageWidth());
			bioMightComponent.setHeight(semiMembranosusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SemitendinosusMuscle))
		{
			SemitendinosusMuscle semitendinosusMuscle = (SemitendinosusMuscle) bioMightInstance;
			bioMightComponent.setImage(semitendinosusMuscle.getImage());
			bioMightComponent.setWidth(semitendinosusMuscle.getImageWidth());
			bioMightComponent.setHeight(semitendinosusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TensorFasciaLataMuscle))
		{
			TensorFasciaLataMuscle tensorFasciaLataMuscle = (TensorFasciaLataMuscle) bioMightInstance;
			bioMightComponent.setImage(tensorFasciaLataMuscle.getImage());
			bioMightComponent.setWidth(tensorFasciaLataMuscle.getImageWidth());
			bioMightComponent.setHeight(tensorFasciaLataMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.VastusInterMediusMuscle))
		{
			VastusInterMediusMuscle vastusInterMediusMuscle = (VastusInterMediusMuscle) bioMightInstance;
			bioMightComponent.setImage(vastusInterMediusMuscle.getImage());
			bioMightComponent.setWidth(vastusInterMediusMuscle.getImageWidth());
			bioMightComponent.setHeight(vastusInterMediusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(vastusInterMediusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(vastusInterMediusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for VastusInterMediusMuscle: "  + bioMightComponent +  "     ID: " + vastusInterMediusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(vastusInterMediusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	vastusInterMediusMuscle.executeMethods(methodParams);
			//	vastusInterMediusMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for SupinatorMuscle!");
			bioMightComponent.setX3D(vastusInterMediusMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.VastusLateralisMuscle))
		{
			VastusLateralisMuscle vastusLateralisMuscle = (VastusLateralisMuscle) bioMightInstance;
			bioMightComponent.setImage(vastusLateralisMuscle.getImage());
			bioMightComponent.setWidth(vastusLateralisMuscle.getImageWidth());
			bioMightComponent.setHeight(vastusLateralisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(vastusLateralisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(vastusLateralisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for VastusInterMediusMuscle: "  + bioMightComponent +  "     ID: " + vastusLateralisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(vastusLateralisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	vastusLateralisMuscle.executeMethods(methodParams);
			//	vastusLateralisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for SupinatorMuscle!");
			bioMightComponent.setX3D(vastusLateralisMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.VastusMedialisMuscle))
		{
			VastusMedialisMuscle vastusMedialisMuscle = (VastusMedialisMuscle) bioMightInstance;
			bioMightComponent.setImage(vastusMedialisMuscle.getImage());
			bioMightComponent.setWidth(vastusMedialisMuscle.getImageWidth());
			bioMightComponent.setHeight(vastusMedialisMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(vastusMedialisMuscle.getProperties());
			bioMightComponent.setBioMightMethods(vastusMedialisMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for VastusInterMediusMuscle: "  + bioMightComponent +  "     ID: " + vastusMedialisMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(vastusMedialisMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	vastusMedialisMuscle.executeMethods(methodParams);
			//	vastusMedialisMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for VastusMedialisMuscle!");
			bioMightComponent.setX3D(vastusMedialisMuscle.getX3D(false));
		}
		//*****************************************************************************
		//  biomight.system.muscular.neck
		//*****************************************************************************			
		else if (bioMightComponentRef.equals(Constants.AnteriorScaleneMuscle))
		{
			AnteriorScaleneMuscle anteriorScaleneMuscle = (AnteriorScaleneMuscle) bioMightInstance;
			bioMightComponent.setImage(anteriorScaleneMuscle.getImage());
			bioMightComponent.setWidth(anteriorScaleneMuscle.getImageWidth());
			bioMightComponent.setHeight(anteriorScaleneMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.AnteriorVeterbralMuscle))
		{
			AnteriorVeterbralMuscle anteriorVeterbralMuscle = (AnteriorVeterbralMuscle) bioMightInstance;
			bioMightComponent.setImage(anteriorVeterbralMuscle.getImage());
			bioMightComponent.setWidth(anteriorVeterbralMuscle.getImageWidth());
			bioMightComponent.setHeight(anteriorVeterbralMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CricoArytenoidMuscle))
		{
			CricoArytenoidMuscle cricoArytenoidMuscle = (CricoArytenoidMuscle) bioMightInstance;
			bioMightComponent.setImage(cricoArytenoidMuscle.getImage());
			bioMightComponent.setWidth(cricoArytenoidMuscle.getImageWidth());
			bioMightComponent.setHeight(cricoArytenoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CricoThyroidMuscle))
		{
			CricoThyroidMuscle cricoThyroidMuscle = (CricoThyroidMuscle) bioMightInstance;
			bioMightComponent.setImage(cricoThyroidMuscle.getImage());
			bioMightComponent.setWidth(cricoThyroidMuscle.getImageWidth());
			bioMightComponent.setHeight(cricoThyroidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.DigastricMuscle))
		{
			DigastricMuscle digastricMuscle = (DigastricMuscle) bioMightInstance;
			bioMightComponent.setImage(digastricMuscle.getImage());
			bioMightComponent.setWidth(digastricMuscle.getImageWidth());
			bioMightComponent.setHeight(digastricMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.GenioHyoidMuscle))
		{
			GenioHyoidMuscle genioHyoidMuscle = (GenioHyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(genioHyoidMuscle.getImage());
			bioMightComponent.setWidth(genioHyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(genioHyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LateralCervicleMuscle))
		{
			LateralCervicleMuscle lateralCervicleMuscle = (LateralCervicleMuscle) bioMightInstance;
			bioMightComponent.setImage(lateralCervicleMuscle.getImage());
			bioMightComponent.setWidth(lateralCervicleMuscle.getImageWidth());
			bioMightComponent.setHeight(lateralCervicleMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LateralCricoarytenoidMuscle))
		{
			LateralCricoarytenoidMuscle lateralCricoarytenoidMuscle = (LateralCricoarytenoidMuscle) bioMightInstance;
			bioMightComponent.setImage(lateralCricoarytenoidMuscle.getImage());
			bioMightComponent.setWidth(lateralCricoarytenoidMuscle.getImageWidth());
			bioMightComponent.setHeight(lateralCricoarytenoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LateralVeterbralMuscle))
		{
			LateralVeterbralMuscle lateralVeterbralMuscle = (LateralVeterbralMuscle) bioMightInstance;
			bioMightComponent.setImage(lateralVeterbralMuscle.getImage());
			bioMightComponent.setWidth(lateralVeterbralMuscle.getImageWidth());
			bioMightComponent.setHeight(lateralVeterbralMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.LongusCapitisMuscle))
		{
			LongusCapitisMuscle longusCapitisMuscle = (LongusCapitisMuscle) bioMightInstance;
			bioMightComponent.setImage(longusCapitisMuscle.getImage());
			bioMightComponent.setWidth(longusCapitisMuscle.getImageWidth());
			bioMightComponent.setHeight(longusCapitisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MusculusUvulae))
		{
			MusculusUvulae musculusUvulae = (MusculusUvulae) bioMightInstance;
			bioMightComponent.setImage(musculusUvulae.getImage());
			bioMightComponent.setWidth(musculusUvulae.getImageWidth());
			bioMightComponent.setHeight(musculusUvulae.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.MylohyoidMuscle))
		{
			MylohyoidMuscle mylohyoidMuscle = (MylohyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(mylohyoidMuscle.getImage());
			bioMightComponent.setWidth(mylohyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(mylohyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.OmoHyoidMuscle))
		{
			OmoHyoidMuscle omoHyoidMuscle = (OmoHyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(omoHyoidMuscle.getImage());
			bioMightComponent.setWidth(omoHyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(omoHyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RectusCapitisAnteriorMuscle))
		{
			RectusCapitisAnteriorMuscle rectusCapitisAnteriorMuscle = (RectusCapitisAnteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(rectusCapitisAnteriorMuscle.getImage());
			bioMightComponent.setWidth(rectusCapitisAnteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(rectusCapitisAnteriorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.RectusCapitisLateralisMuscle))
		{
			RectusCapitisLateralisMuscle rectusCapitisLateralisMuscle = (RectusCapitisLateralisMuscle) bioMightInstance;
			bioMightComponent.setImage(rectusCapitisLateralisMuscle.getImage());
			bioMightComponent.setWidth(rectusCapitisLateralisMuscle.getImageWidth());
			bioMightComponent.setHeight(rectusCapitisLateralisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ScalenusAnteriorMuscle))
		{
			ScalenusAnteriorMuscle scalenusAnteriorMuscle = (ScalenusAnteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(scalenusAnteriorMuscle.getImage());
			bioMightComponent.setWidth(scalenusAnteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(scalenusAnteriorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ScalenusMediusMuscle))
		{
			ScalenusMediusMuscle scalenusMediusMuscle = (ScalenusMediusMuscle) bioMightInstance;
			bioMightComponent.setImage(scalenusMediusMuscle.getImage());
			bioMightComponent.setWidth(scalenusMediusMuscle.getImageWidth());
			bioMightComponent.setHeight(scalenusMediusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ScalenusMinimusMuscle))
		{
			ScalenusMinimusMuscle scalenusMinimusMuscle = (ScalenusMinimusMuscle) bioMightInstance;
			bioMightComponent.setImage(scalenusMinimusMuscle.getImage());
			bioMightComponent.setWidth(scalenusMinimusMuscle.getImageWidth());
			bioMightComponent.setHeight(scalenusMinimusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ScalenusPosteriorMuscle))
		{
			ScalenusPosteriorMuscle scalenusPosteriorMuscle = (ScalenusPosteriorMuscle) bioMightInstance;
			bioMightComponent.setImage(scalenusPosteriorMuscle.getImage());
			bioMightComponent.setWidth(scalenusPosteriorMuscle.getImageWidth());
			bioMightComponent.setHeight(scalenusPosteriorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SternoCleidoMastoidMuscle))
		{
			SternoCleidoMastoidMuscle sternoCleidoMastoidMuscle = (SternoCleidoMastoidMuscle) bioMightInstance;
			bioMightComponent.setImage(sternoCleidoMastoidMuscle.getImage());
			bioMightComponent.setWidth(sternoCleidoMastoidMuscle.getImageWidth());
			bioMightComponent.setHeight(sternoCleidoMastoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SternoHyoidMuscle))
		{
			SternoHyoidMuscle sternoHyoidMuscle = (SternoHyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(sternoHyoidMuscle.getImage());
			bioMightComponent.setWidth(sternoHyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(sternoHyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SternoMastoidMuscle))
		{
			SternoMastoidMuscle sternoMastoidMuscle = (SternoMastoidMuscle) bioMightInstance;
			bioMightComponent.setImage(sternoMastoidMuscle.getImage());
			bioMightComponent.setWidth(sternoMastoidMuscle.getImageWidth());
			bioMightComponent.setHeight(sternoMastoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SternoThyroidMuscle))
		{
			SternoThyroidMuscle sternoThyroidMuscle = (SternoThyroidMuscle) bioMightInstance;
			bioMightComponent.setImage(sternoThyroidMuscle.getImage());
			bioMightComponent.setWidth(sternoThyroidMuscle.getImageWidth());
			bioMightComponent.setHeight(sternoThyroidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.StyloHyoidMuscle))
		{
			StyloHyoidMuscle styloHyoidMuscle = (StyloHyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(styloHyoidMuscle.getImage());
			bioMightComponent.setWidth(styloHyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(styloHyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SuperficialCervicalMuscle))
		{
			SuperficialCervicalMuscle superficialCervicalMuscle = (SuperficialCervicalMuscle) bioMightInstance;
			bioMightComponent.setImage(superficialCervicalMuscle.getImage());
			bioMightComponent.setWidth(superficialCervicalMuscle.getImageWidth());
			bioMightComponent.setHeight(superficialCervicalMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SupraInfrahyoidMuscle))
		{
			SupraInfrahyoidMuscle supraInfrahyoidMuscle = (SupraInfrahyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(supraInfrahyoidMuscle.getImage());
			bioMightComponent.setWidth(supraInfrahyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(supraInfrahyoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ThyroArytenoidMuscle))
		{
			ThyroArytenoidMuscle thyroArytenoidMuscle = (ThyroArytenoidMuscle) bioMightInstance;
			bioMightComponent.setImage(thyroArytenoidMuscle.getImage());
			bioMightComponent.setWidth(thyroArytenoidMuscle.getImageWidth());
			bioMightComponent.setHeight(thyroArytenoidMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.ThyroHyoidMuscle))
		{
			ThyroHyoidMuscle thyroHyoidMuscle = (ThyroHyoidMuscle) bioMightInstance;
			bioMightComponent.setImage(thyroHyoidMuscle.getImage());
			bioMightComponent.setWidth(thyroHyoidMuscle.getImageWidth());
			bioMightComponent.setHeight(thyroHyoidMuscle.getImageHeight());
		}
		//*****************************************************************************
		//  biomight.system.muscular.perineum
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.BulboSpongiosusMuscle))
		{
			BulboSpongiosusMuscle bulboSpongiosusMuscle = (BulboSpongiosusMuscle) bioMightInstance;
			bioMightComponent.setImage(bulboSpongiosusMuscle.getImage());
			bioMightComponent.setWidth(bulboSpongiosusMuscle.getImageWidth());
			bioMightComponent.setHeight(bulboSpongiosusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.CorrugatorCutisAniMuscle))
		{
			CorrugatorCutisAniMuscle corrugatorCutisAniMuscle = (CorrugatorCutisAniMuscle) bioMightInstance;
			bioMightComponent.setImage(corrugatorCutisAniMuscle.getImage());
			bioMightComponent.setWidth(corrugatorCutisAniMuscle.getImageWidth());
			bioMightComponent.setHeight(corrugatorCutisAniMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.IschiocavernosusMuscle))
		{
			IschiocavernosusMuscle ischiocavernosusMuscle = (IschiocavernosusMuscle) bioMightInstance;
			bioMightComponent.setImage(ischiocavernosusMuscle.getImage());
			bioMightComponent.setWidth(ischiocavernosusMuscle.getImageWidth());
			bioMightComponent.setHeight(ischiocavernosusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TransversusPerineiProfundusMuscle))
		{
			TransversusPerineiProfundusMuscle ransversusPerineiProfundusMuscle = (TransversusPerineiProfundusMuscle) bioMightInstance;
			bioMightComponent.setImage(ransversusPerineiProfundusMuscle.getImage());
			bioMightComponent.setWidth(ransversusPerineiProfundusMuscle.getImageWidth());
			bioMightComponent.setHeight(ransversusPerineiProfundusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SphincterAniExternusMuscle))
		{
			SphincterAniExternusMuscle sphincterAniExternusMuscle = (SphincterAniExternusMuscle) bioMightInstance;
			bioMightComponent.setImage(sphincterAniExternusMuscle.getImage());
			bioMightComponent.setWidth(sphincterAniExternusMuscle.getImageWidth());
			bioMightComponent.setHeight(sphincterAniExternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SphincterAniInternusMuscle))
		{
			SphincterAniInternusMuscle sphincterAniInternusMuscle = (SphincterAniInternusMuscle) bioMightInstance;
			bioMightComponent.setImage(sphincterAniInternusMuscle.getImage());
			bioMightComponent.setWidth(sphincterAniInternusMuscle.getImageWidth());
			bioMightComponent.setHeight(sphincterAniInternusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SphincterUrethraeMembranaceaeMuscle))
		{
			SphincterUrethraeMembranaceaeMuscle sphincterUrethraeMembranaceaeMuscle = (SphincterUrethraeMembranaceaeMuscle) bioMightInstance;
			bioMightComponent.setImage(sphincterUrethraeMembranaceaeMuscle.getImage());
			bioMightComponent.setWidth(sphincterUrethraeMembranaceaeMuscle.getImageWidth());
			bioMightComponent.setHeight(sphincterUrethraeMembranaceaeMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TransversusPerineiSuperficialisMuscle))
		{
			TransversusPerineiSuperficialisMuscle transversusPerineiSuperficialisMuscle = (TransversusPerineiSuperficialisMuscle) bioMightInstance;
			bioMightComponent.setImage(transversusPerineiSuperficialisMuscle.getImage());
			bioMightComponent.setWidth(transversusPerineiSuperficialisMuscle.getImageWidth());
			bioMightComponent.setHeight(transversusPerineiSuperficialisMuscle.getImageHeight());
		}
		//*****************************************************************************
		// biomight.system.muscular.shoulder
		//*****************************************************************************	
		else if (bioMightComponentRef.equals(Constants.DeltoideusMuscle))
		{
			DeltoideusMuscle deltoideusMuscle = (DeltoideusMuscle) bioMightInstance;
			bioMightComponent.setImage(deltoideusMuscle.getImage());
			bioMightComponent.setWidth(deltoideusMuscle.getImageWidth());
			bioMightComponent.setHeight(deltoideusMuscle.getImageHeight());
			bioMightComponent.setBioMightProperties(deltoideusMuscle.getProperties());
			bioMightComponent.setBioMightMethods(deltoideusMuscle.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SupinatorMuscle: "  + bioMightComponent +  "     ID: " + deltoideusMuscle.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(deltoideusMuscle.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HEAD Methods!");
			//	supinatorMuscle.executeMethods(methodParams);
			//	supinatorMuscle.redraw(0);
			//}
			System.out.println("Getting X3D for SupinatorMuscle!");
			bioMightComponent.setX3D(deltoideusMuscle.getX3D(false));
		}
		else if (bioMightComponentRef.equals(Constants.InfraSpinatusMuscle))
		{
			InfraSpinatusMuscle infraSpinatusMuscle = (InfraSpinatusMuscle) bioMightInstance;
			bioMightComponent.setImage(infraSpinatusMuscle.getImage());
			bioMightComponent.setWidth(infraSpinatusMuscle.getImageWidth());
			bioMightComponent.setHeight(infraSpinatusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.InfraSpinatusMuscles))
		{
			InfraSpinatusMuscles infraSpinatusMuscles = (InfraSpinatusMuscles) bioMightInstance;
			bioMightComponent.setImage(infraSpinatusMuscles.getImage());
			bioMightComponent.setWidth(infraSpinatusMuscles.getImageWidth());
			bioMightComponent.setHeight(infraSpinatusMuscles.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SubScapularisMuscle))
		{
			SubScapularisMuscle subScapularisMuscle = (SubScapularisMuscle) bioMightInstance;
			bioMightComponent.setImage(subScapularisMuscle.getImage());
			bioMightComponent.setWidth(subScapularisMuscle.getImageWidth());
			bioMightComponent.setHeight(subScapularisMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.SupraSpinatusMuscle))
		{
			SupraSpinatusMuscle supraSpinatusMuscle = (SupraSpinatusMuscle) bioMightInstance;
			bioMightComponent.setImage(supraSpinatusMuscle.getImage());
			bioMightComponent.setWidth(supraSpinatusMuscle.getImageWidth());
			bioMightComponent.setHeight(supraSpinatusMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TeresMajorMuscle))
		{
			TeresMajorMuscle teresMajorMuscle = (TeresMajorMuscle) bioMightInstance;
			bioMightComponent.setImage(teresMajorMuscle.getImage());
			bioMightComponent.setWidth(teresMajorMuscle.getImageWidth());
			bioMightComponent.setHeight(teresMajorMuscle.getImageHeight());
		}
		else if (bioMightComponentRef.equals(Constants.TeresMinorMuscle))
		{
			TeresMinorMuscle teresMinorMuscle = (TeresMinorMuscle) bioMightInstance;
			bioMightComponent.setImage(teresMinorMuscle.getImage());
			bioMightComponent.setWidth(teresMinorMuscle.getImageWidth());
			bioMightComponent.setHeight(teresMinorMuscle.getImageHeight());
		}
	
		
		else
		{
			System.out.println("BioMightViewMuscular Component NOT MATCHED: " + bioMightComponentRef +  "  " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
