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
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Vascular Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewLigament {

	
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
		* LIGAMENTS SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/

		//*****************************************************************************
		// biomight.system.ligament
		//*****************************************************************************	
		
		if (bioMightComponent.equals(Constants.Ligament))
		{
			Ligament ligament = (Ligament) bioMightInstance;
			bioMightComponent.setImage(ligament.getImage());
			bioMightComponent.setWidth(ligament.getImageWidth());
			bioMightComponent.setHeight(ligament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.Ligaments))
		{
			Ligaments ligaments = (Ligaments) bioMightInstance;
			bioMightComponent.setImage(ligaments.getImage());
			bioMightComponent.setWidth(ligaments.getImageWidth());
			bioMightComponent.setHeight(ligaments.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorSacrococcygealLigament))
		{
			AnteriorSacrococcygealLigament anteriorSacrococcygealLigament = (AnteriorSacrococcygealLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorSacrococcygealLigament.getImage());
			bioMightComponent.setWidth(anteriorSacrococcygealLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorSacrococcygealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorSacroiliacLigament))
		{
			AnteriorSacroiliacLigament anteriorSacroiliacLigament = (AnteriorSacroiliacLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorSacroiliacLigament.getImage());
			bioMightComponent.setWidth(anteriorSacroiliacLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorSacroiliacLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.GastrolienalLigament))
		{
			GastrolienalLigament gastrolienalLigament = (GastrolienalLigament) bioMightInstance;
			bioMightComponent.setImage(gastrolienalLigament.getImage());
			bioMightComponent.setWidth(gastrolienalLigament.getImageWidth());
			bioMightComponent.setHeight(gastrolienalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IliolumbarLigament))
		{
			IliolumbarLigament iliolumbarLigament = (IliolumbarLigament) bioMightInstance;
			bioMightComponent.setImage(iliolumbarLigament.getImage());
			bioMightComponent.setWidth(iliolumbarLigament.getImageWidth());
			bioMightComponent.setHeight(iliolumbarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterosseousSacroiliacLigament))
		{
			InterosseousSacroiliacLigament interosseousSacroiliacLigament = (InterosseousSacroiliacLigament) bioMightInstance;
			bioMightComponent.setImage(interosseousSacroiliacLigament.getImage());
			bioMightComponent.setWidth(interosseousSacroiliacLigament.getImageWidth());
			bioMightComponent.setHeight(interosseousSacroiliacLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LateralSacrococcygealLigament))
		{
			LateralSacrococcygealLigament lateralSacrococcygealLigament = (LateralSacrococcygealLigament) bioMightInstance;
			bioMightComponent.setImage(lateralSacrococcygealLigament.getImage());
			bioMightComponent.setWidth(lateralSacrococcygealLigament.getImageWidth());
			bioMightComponent.setHeight(lateralSacrococcygealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumPubicumInferius))
		{
			LigamentumPubicumInferius ligamentumPubicumInferius = (LigamentumPubicumInferius) bioMightInstance;
			bioMightComponent.setImage(ligamentumPubicumInferius.getImage());
			bioMightComponent.setWidth(ligamentumPubicumInferius.getImageWidth());
			bioMightComponent.setHeight(ligamentumPubicumInferius.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PhrenicolienalLigament))
		{
			PhrenicolienalLigament phrenicolienalLigament = (PhrenicolienalLigament) bioMightInstance;
			bioMightComponent.setImage(phrenicolienalLigament.getImage());
			bioMightComponent.setWidth(phrenicolienalLigament.getImageWidth());
			bioMightComponent.setHeight(phrenicolienalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorLongitudinalLigament))
		{
			PosteriorLongitudinalLigament posteriorLongitudinalLigament = (PosteriorLongitudinalLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorLongitudinalLigament.getImage());
			bioMightComponent.setWidth(posteriorLongitudinalLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorLongitudinalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorSacrococcygealLigament))
		{
			PosteriorSacrococcygealLigament posteriorSacrococcygealLigament = (PosteriorSacrococcygealLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorSacrococcygealLigament.getImage());
			bioMightComponent.setWidth(posteriorSacrococcygealLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorSacrococcygealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorSacroiliacLigament))
		{
			PosteriorSacroiliacLigament posteriorSacroiliacLigament = (PosteriorSacroiliacLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorSacroiliacLigament.getImage());
			bioMightComponent.setWidth(posteriorSacroiliacLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorSacroiliacLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.RetinaculumMusculorumFlexorumPedis))
		{
			RetinaculumMusculorumFlexorumPedis retinaculumMusculorumFlexorumPedis = (RetinaculumMusculorumFlexorumPedis) bioMightInstance;
			bioMightComponent.setImage(retinaculumMusculorumFlexorumPedis.getImage());
			bioMightComponent.setWidth(retinaculumMusculorumFlexorumPedis.getImageWidth());
			bioMightComponent.setHeight(retinaculumMusculorumFlexorumPedis.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacrospinousLigament))
		{
			SacrospinousLigament sacrospinousLigament = (SacrospinousLigament) bioMightInstance;
			bioMightComponent.setImage(sacrospinousLigament.getImage());
			bioMightComponent.setWidth(sacrospinousLigament.getImageWidth());
			bioMightComponent.setHeight(sacrospinousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacrotuberousLigament))
		{
			SacrotuberousLigament sacrotuberousLigament = (SacrotuberousLigament) bioMightInstance;
			bioMightComponent.setImage(sacrotuberousLigament.getImage());
			bioMightComponent.setWidth(sacrotuberousLigament.getImageWidth());
			bioMightComponent.setHeight(sacrotuberousLigament.getImageHeight());
		}
		
		//*****************************************************************************
		// biomight.system.ligament.ankle
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AnteriorTalofibularLigament))
		{
			AnteriorTalofibularLigament anteriorTalofibularLigament = (AnteriorTalofibularLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorTalofibularLigament.getImage());
			bioMightComponent.setWidth(anteriorTalofibularLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorTalofibularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.CalcaneofibularLigament))
		{
			CalcaneofibularLigament calcaneofibularLigament = (CalcaneofibularLigament) bioMightInstance;
			bioMightComponent.setImage(calcaneofibularLigament.getImage());
			bioMightComponent.setWidth(calcaneofibularLigament.getImageWidth());
			bioMightComponent.setHeight(calcaneofibularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.DeltoidLigament))
		{
			DeltoidLigament deltoidLigament = (DeltoidLigament) bioMightInstance;
			bioMightComponent.setImage(deltoidLigament.getImage());
			bioMightComponent.setWidth(deltoidLigament.getImageWidth());
			bioMightComponent.setHeight(deltoidLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LongPlantarLigament))
		{
			LongPlantarLigament longPlantarLigament = (LongPlantarLigament) bioMightInstance;
			bioMightComponent.setImage(longPlantarLigament.getImage());
			bioMightComponent.setWidth(longPlantarLigament.getImageWidth());
			bioMightComponent.setHeight(longPlantarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorTalofibularLigament))
		{
			PosteriorTalofibularLigament posteriorTalofibularLigament = (PosteriorTalofibularLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorTalofibularLigament.getImage());
			bioMightComponent.setWidth(posteriorTalofibularLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorTalofibularLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.elbow
		//*****************************************************************************	

		else if (bioMightComponent.equals(Constants.AnteriorLigament))
		{
			ElbowAnteriorLigament anteriorLigament = (ElbowAnteriorLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorLigament.getImage());
			bioMightComponent.setWidth(anteriorLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorLigament))
		{
			ElbowPosteriorLigament posteriorLigament = (ElbowPosteriorLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorLigament.getImage());
			bioMightComponent.setWidth(posteriorLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.RadialCollateralLigament))
		{
			RadialCollateralLigament radialCollateralLigament = (RadialCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(radialCollateralLigament.getImage());
			bioMightComponent.setWidth(radialCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(radialCollateralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.UlnarCollateralLigament))
		{
			UlnarCollateralLigament ulnarCollateralLigament = (UlnarCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(ulnarCollateralLigament.getImage());
			bioMightComponent.setWidth(ulnarCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(ulnarCollateralLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.hand
		//*****************************************************************************	

		else if (bioMightComponent.equals(Constants.NatatoryLigament))
		{
			NatatoryLigament natatoryLigament = (NatatoryLigament) bioMightInstance;
			bioMightComponent.setImage(natatoryLigament.getImage());
			bioMightComponent.setWidth(natatoryLigament.getImageWidth());
			bioMightComponent.setHeight(natatoryLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.VolarCarpalLigament))
		{
			VolarCarpalLigament volarCarpalLigament = (VolarCarpalLigament) bioMightInstance;
			bioMightComponent.setImage(volarCarpalLigament.getImage());
			bioMightComponent.setWidth(volarCarpalLigament.getImageWidth());
			bioMightComponent.setHeight(volarCarpalLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.hand.metacarpals
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.DorsalLigaments))
		{
			DorsalLigaments dorsalLigaments = (DorsalLigaments) bioMightInstance;
			bioMightComponent.setImage(dorsalLigaments.getImage());
			bioMightComponent.setWidth(dorsalLigaments.getImageWidth());
			bioMightComponent.setHeight(dorsalLigaments.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterosseousLigaments))
		{
			InterosseousLigaments interosseousLigaments = (InterosseousLigaments) bioMightInstance;
			bioMightComponent.setImage(interosseousLigaments.getImage());
			bioMightComponent.setWidth(interosseousLigaments.getImageWidth());
			bioMightComponent.setHeight(interosseousLigaments.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.VolarLigaments))
		{
			VolarLigaments volarLigaments = (VolarLigaments) bioMightInstance;
			bioMightComponent.setImage(volarLigaments.getImage());
			bioMightComponent.setWidth(volarLigaments.getImageWidth());
			bioMightComponent.setHeight(volarLigaments.getImageHeight());
		}
		
		//*****************************************************************************
		// biomight.system.ligament.head.mouth
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.PeriodontalLigament))
		{
			PeriodontalLigament periodontalLigament = (PeriodontalLigament) bioMightInstance;
			bioMightComponent.setImage(periodontalLigament.getImage());
			bioMightComponent.setWidth(periodontalLigament.getImageWidth());
			bioMightComponent.setHeight(periodontalLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.hip
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.ArticularCapsuleLigament))
		{
			HipArticularCapsuleLigament articularCapsuleLigament = (HipArticularCapsuleLigament) bioMightInstance;
			bioMightComponent.setImage(articularCapsuleLigament.getImage());
			bioMightComponent.setWidth(articularCapsuleLigament.getImageWidth());
			bioMightComponent.setHeight(articularCapsuleLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.GlenoidalLabrumLigament))
		{
			HipGlenoidalLabrumLigament glenoidalLabrumLigament = (HipGlenoidalLabrumLigament) bioMightInstance;
			bioMightComponent.setImage(glenoidalLabrumLigament.getImage());
			bioMightComponent.setWidth(glenoidalLabrumLigament.getImageWidth());
			bioMightComponent.setHeight(glenoidalLabrumLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IlioFemoralLigament))
		{
			IlioFemoralLigament ilioFemoralLigament = (IlioFemoralLigament) bioMightInstance;
			bioMightComponent.setImage(ilioFemoralLigament.getImage());
			bioMightComponent.setWidth(ilioFemoralLigament.getImageWidth());
			bioMightComponent.setHeight(ilioFemoralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IschioCapsularLigament))
		{
			IschioCapsularLigament ischioCapsularLigament = (IschioCapsularLigament) bioMightInstance;
			bioMightComponent.setImage(ischioCapsularLigament.getImage());
			bioMightComponent.setWidth(ischioCapsularLigament.getImageWidth());
			bioMightComponent.setHeight(ischioCapsularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IschiofemoralLigament))
		{
			IschiofemoralLigament ischiofemoralLigament = (IschiofemoralLigament) bioMightInstance;
			bioMightComponent.setImage(ischiofemoralLigament.getImage());
			bioMightComponent.setWidth(ischiofemoralLigament.getImageWidth());
			bioMightComponent.setHeight(ischiofemoralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentOfBigelow))
		{
			LigamentOfBigelow ligamentOfBigelow = (LigamentOfBigelow) bioMightInstance;
			bioMightComponent.setImage(ligamentOfBigelow.getImage());
			bioMightComponent.setWidth(ligamentOfBigelow.getImageWidth());
			bioMightComponent.setHeight(ligamentOfBigelow.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumTeresFemoris))
		{
			LigamentumTeresFemoris ligamentumTeresFemoris = (LigamentumTeresFemoris) bioMightInstance;
			bioMightComponent.setImage(ligamentumTeresFemoris.getImage());
			bioMightComponent.setWidth(ligamentumTeresFemoris.getImageWidth());
			bioMightComponent.setHeight(ligamentumTeresFemoris.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PubocapsularLigament))
		{
			PubocapsularLigament pubocapsularLigament = (PubocapsularLigament) bioMightInstance;
			bioMightComponent.setImage(pubocapsularLigament.getImage());
			bioMightComponent.setWidth(pubocapsularLigament.getImageWidth());
			bioMightComponent.setHeight(pubocapsularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PubofemoralLigament))
		{
			PubofemoralLigament pubofemoralLigament = (PubofemoralLigament) bioMightInstance;
			bioMightComponent.setImage(pubofemoralLigament.getImage());
			bioMightComponent.setWidth(pubofemoralLigament.getImageWidth());
			bioMightComponent.setHeight(pubofemoralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TransverseAcetabularLigament))
		{
			TransverseAcetabularLigament transverseAcetabularLigament = (TransverseAcetabularLigament) bioMightInstance;
			bioMightComponent.setImage(transverseAcetabularLigament.getImage());
			bioMightComponent.setWidth(transverseAcetabularLigament.getImageWidth());
			bioMightComponent.setHeight(transverseAcetabularLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.intertarsal
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AnteriorTalocalcanealLigament))
		{
			AnteriorTalocalcanealLigament anteriorTalocalcanealLigament = (AnteriorTalocalcanealLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorTalocalcanealLigament.getImage());
			bioMightComponent.setWidth(anteriorTalocalcanealLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorTalocalcanealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.BifurcatedLigament))
		{
			BifurcatedLigament bifurcatedLigament = (BifurcatedLigament) bioMightInstance;
			bioMightComponent.setImage(bifurcatedLigament.getImage());
			bioMightComponent.setWidth(bifurcatedLigament.getImageWidth());
			bioMightComponent.setHeight(bifurcatedLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.DorsalCalcaneocuboidLigament))
		{
			DorsalCalcaneocuboidLigament dorsalCalcaneocuboidLigament = (DorsalCalcaneocuboidLigament) bioMightInstance;
			bioMightComponent.setImage(dorsalCalcaneocuboidLigament.getImage());
			bioMightComponent.setWidth(dorsalCalcaneocuboidLigament.getImageWidth());
			bioMightComponent.setHeight(dorsalCalcaneocuboidLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.DorsalTalonavicularLigament))
		{
			DorsalTalonavicularLigament dorsalTalonavicularLigament = (DorsalTalonavicularLigament) bioMightInstance;
			bioMightComponent.setImage(dorsalTalonavicularLigament.getImage());
			bioMightComponent.setWidth(dorsalTalonavicularLigament.getImageWidth());
			bioMightComponent.setHeight(dorsalTalonavicularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterosseousTalocalcanealLigament))
		{
			InterosseousTalocalcanealLigament interosseousTalocalcanealLigament = (InterosseousTalocalcanealLigament) bioMightInstance;
			bioMightComponent.setImage(interosseousTalocalcanealLigament.getImage());
			bioMightComponent.setWidth(interosseousTalocalcanealLigament.getImageWidth());
			bioMightComponent.setHeight(interosseousTalocalcanealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LateralTalocalcanealLigament))
		{
			LateralTalocalcanealLigament lateralTalocalcanealLigament = (LateralTalocalcanealLigament) bioMightInstance;
			bioMightComponent.setImage(lateralTalocalcanealLigament.getImage());
			bioMightComponent.setWidth(lateralTalocalcanealLigament.getImageWidth());
			bioMightComponent.setHeight(lateralTalocalcanealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.MedialTalocalcanealLigament))
		{
			MedialTalocalcanealLigament medialTalocalcanealLigament = (MedialTalocalcanealLigament) bioMightInstance;
			bioMightComponent.setImage(medialTalocalcanealLigament.getImage());
			bioMightComponent.setWidth(medialTalocalcanealLigament.getImageWidth());
			bioMightComponent.setHeight(medialTalocalcanealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PlantarCalcaneocuboidLigament))
		{
			PlantarCalcaneocuboidLigament plantarCalcaneocuboidLigament = (PlantarCalcaneocuboidLigament) bioMightInstance;
			bioMightComponent.setImage(plantarCalcaneocuboidLigament.getImage());
			bioMightComponent.setWidth(plantarCalcaneocuboidLigament.getImageWidth());
			bioMightComponent.setHeight(plantarCalcaneocuboidLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PlantarCalcaneonavicularLigament))
		{
			PlantarCalcaneonavicularLigament plantarCalcaneonavicularLigament = (PlantarCalcaneonavicularLigament) bioMightInstance;
			bioMightComponent.setImage(plantarCalcaneonavicularLigament.getImage());
			bioMightComponent.setWidth(plantarCalcaneonavicularLigament.getImageWidth());
			bioMightComponent.setHeight(plantarCalcaneonavicularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorTalocalcanealLigament))
		{
			PosteriorTalocalcanealLigament posteriorTalocalcanealLigament = (PosteriorTalocalcanealLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorTalocalcanealLigament.getImage());
			bioMightComponent.setWidth(posteriorTalocalcanealLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorTalocalcanealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TalocalcanealArticulation))
		{
			TalocalcanealArticulation talocalcanealArticulation = (TalocalcanealArticulation) bioMightInstance;
			bioMightComponent.setImage(talocalcanealArticulation.getImage());
			bioMightComponent.setWidth(talocalcanealArticulation.getImageWidth());
			bioMightComponent.setHeight(talocalcanealArticulation.getImageHeight());
		}

		//*****************************************************************************
		// bbiomight.system.ligament.knee
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AnteriorCruciateLigament))
		{
			AnteriorCruciateLigament anteriorCruciateLigament = (AnteriorCruciateLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorCruciateLigament.getImage());
			bioMightComponent.setWidth(anteriorCruciateLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorCruciateLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.Bursae))
		{
			Bursae bursae = (Bursae) bioMightInstance;
			bioMightComponent.setImage(bursae.getImage());
			bioMightComponent.setWidth(bursae.getImageWidth());
			bioMightComponent.setHeight(bursae.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.CoronaryLigament))
		{
			KneeCoronaryLigament coronaryLigament = (KneeCoronaryLigament) bioMightInstance;
			bioMightComponent.setImage(coronaryLigament.getImage());
			bioMightComponent.setWidth(coronaryLigament.getImageWidth());
			bioMightComponent.setHeight(coronaryLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.FibularCollateralLigament))
		{
			FibularCollateralLigament fibularCollateralLigament = (FibularCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(fibularCollateralLigament.getImage());
			bioMightComponent.setWidth(fibularCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(fibularCollateralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LateralCollateralLigament))
		{
			LateralCollateralLigament lateralCollateralLigament = (LateralCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(lateralCollateralLigament.getImage());
			bioMightComponent.setWidth(lateralCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(lateralCollateralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LateralMenisci))
		{
			LateralMenisci lateralMenisci = (LateralMenisci) bioMightInstance;
			bioMightComponent.setImage(lateralMenisci.getImage());
			bioMightComponent.setWidth(lateralMenisci.getImageWidth());
			bioMightComponent.setHeight(lateralMenisci.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentOfWrisberg))
		{
			LigamentOfWrisberg ligamentOfWrisberg = (LigamentOfWrisberg) bioMightInstance;
			bioMightComponent.setImage(ligamentOfWrisberg.getImage());
			bioMightComponent.setWidth(ligamentOfWrisberg.getImageWidth());
			bioMightComponent.setHeight(ligamentOfWrisberg.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumPatellae))
		{
			LigamentumPatellae ligamentumPatellae = (LigamentumPatellae) bioMightInstance;
			bioMightComponent.setImage(ligamentumPatellae.getImage());
			bioMightComponent.setWidth(ligamentumPatellae.getImageWidth());
			bioMightComponent.setHeight(ligamentumPatellae.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.MedialCollateralLigament))
		{
			MedialCollateralLigament medialCollateralLigament = (MedialCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(medialCollateralLigament.getImage());
			bioMightComponent.setWidth(medialCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(medialCollateralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.ObliquePoplitealLigament))
		{
			ObliquePoplitealLigament obliquePoplitealLigament = (ObliquePoplitealLigament) bioMightInstance;
			bioMightComponent.setImage(obliquePoplitealLigament.getImage());
			bioMightComponent.setWidth(obliquePoplitealLigament.getImageWidth());
			bioMightComponent.setHeight(obliquePoplitealLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorCruciateLigament))
		{
			PosteriorCruciateLigament posteriorCruciateLigament = (PosteriorCruciateLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorCruciateLigament.getImage());
			bioMightComponent.setWidth(posteriorCruciateLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorCruciateLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.ShortFibularCollateralLigament))
		{
			ShortFibularCollateralLigament shortFibularCollateralLigament = (ShortFibularCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(shortFibularCollateralLigament.getImage());
			bioMightComponent.setWidth(shortFibularCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(shortFibularCollateralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SynovialMembrane))
		{
			SynovialMembrane synovialMembrane = (SynovialMembrane) bioMightInstance;
			bioMightComponent.setImage(synovialMembrane.getImage());
			bioMightComponent.setWidth(synovialMembrane.getImageWidth());
			bioMightComponent.setHeight(synovialMembrane.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TibialCollateralLigament))
		{
			TibialCollateralLigament tibialCollateralLigament = (TibialCollateralLigament) bioMightInstance;
			bioMightComponent.setImage(tibialCollateralLigament.getImage());
			bioMightComponent.setWidth(tibialCollateralLigament.getImageWidth());
			bioMightComponent.setHeight(tibialCollateralLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.mandible
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.ArticularCapsuleLigament))
		{
			HipArticularCapsuleLigament articularCapsuleLigament = (HipArticularCapsuleLigament) bioMightInstance;
			bioMightComponent.setImage(articularCapsuleLigament.getImage());
			bioMightComponent.setWidth(articularCapsuleLigament.getImageWidth());
			bioMightComponent.setHeight(articularCapsuleLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.MandibleArticularDisk))
		{
			RadiusArticularDisk articularDisk = (RadiusArticularDisk) bioMightInstance;
			bioMightComponent.setImage(articularDisk.getImage());
			bioMightComponent.setWidth(articularDisk.getImageWidth());
			bioMightComponent.setHeight(articularDisk.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SphenomandibularLigament))
		{
			SphenomandibularLigament sphenomandibularLigament = (SphenomandibularLigament) bioMightInstance;
			bioMightComponent.setImage(sphenomandibularLigament.getImage());
			bioMightComponent.setWidth(sphenomandibularLigament.getImageWidth());
			bioMightComponent.setHeight(sphenomandibularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.StylomandibularLigament))
		{
			StylomandibularLigament stylomandibularLigament = (StylomandibularLigament) bioMightInstance;
			bioMightComponent.setImage(stylomandibularLigament.getImage());
			bioMightComponent.setWidth(stylomandibularLigament.getImageWidth());
			bioMightComponent.setHeight(stylomandibularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TemporomandibularLigament))
		{
			TemporomandibularLigament temporomandibularLigament = (TemporomandibularLigament) bioMightInstance;
			bioMightComponent.setImage(temporomandibularLigament.getImage());
			bioMightComponent.setWidth(temporomandibularLigament.getImageWidth());
			bioMightComponent.setHeight(temporomandibularLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.neck
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.CricoThyroidLigament))
		{
			CricoThyroidLigament cricoThyroidLigament = (CricoThyroidLigament) bioMightInstance;
			bioMightComponent.setImage(cricoThyroidLigament.getImage());
			bioMightComponent.setWidth(cricoThyroidLigament.getImageWidth());
			bioMightComponent.setHeight(cricoThyroidLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.VocalLigament))
		{
			VocalLigament vocalLigament = (VocalLigament) bioMightInstance;
			bioMightComponent.setImage(vocalLigament.getImage());
			bioMightComponent.setWidth(vocalLigament.getImageWidth());
			bioMightComponent.setHeight(vocalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.VocalLigaments))
		{
			VocalLigaments vocalLigaments = (VocalLigaments) bioMightInstance;
			bioMightComponent.setImage(vocalLigaments.getImage());
			bioMightComponent.setWidth(vocalLigaments.getImageWidth());
			bioMightComponent.setHeight(vocalLigaments.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.radius
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AnnularLigament))
		{
			AnnularLigament annularLigament = (AnnularLigament) bioMightInstance;
			bioMightComponent.setImage(annularLigament.getImage());
			bioMightComponent.setWidth(annularLigament.getImageWidth());
			bioMightComponent.setHeight(annularLigament.getImageHeight());
			bioMightComponent.setBioMightProperties(annularLigament.getProperties());
			bioMightComponent.setBioMightMethods(annularLigament.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnnularLigament: "  + bioMightComponent +  "     ID: " + annularLigament.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(annularLigament.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LUNG Methods!");
			//	annularLigament.executeMethods(methodParams);
			//	annularLigament.redraw(0);
			//}
			System.out.println("Getting X3D for AnnularLigament!");
			bioMightComponent.setX3D(annularLigament.getX3D(snippet));	
			
		}
		else if (bioMightComponent.equals(Constants.DorsalRadioulnarLigament))
		{
			DorsalRadioulnarLigament dorsalRadioulnarLigament = (DorsalRadioulnarLigament) bioMightInstance;
			bioMightComponent.setImage(dorsalRadioulnarLigament.getImage());
			bioMightComponent.setWidth(dorsalRadioulnarLigament.getImageWidth());
			bioMightComponent.setHeight(dorsalRadioulnarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.RadiusArticularDisk))
		{
			RadiusArticularDisk radiusArticularDisk = (RadiusArticularDisk) bioMightInstance;
			bioMightComponent.setImage(radiusArticularDisk.getImage());
			bioMightComponent.setWidth(radiusArticularDisk.getImageWidth());
			bioMightComponent.setHeight(radiusArticularDisk.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.VolarRadioulnarLigament))
		{
			VolarRadioulnarLigament volarRadioulnarLigament = (VolarRadioulnarLigament) bioMightInstance;
			bioMightComponent.setImage(volarRadioulnarLigament.getImage());
			bioMightComponent.setWidth(volarRadioulnarLigament.getImageWidth());
			bioMightComponent.setHeight(volarRadioulnarLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.ribs
		//*****************************************************************************	
		//else if (bioMightComponent.equals(Constants.CapsularLigament))
		//{
		//	CapsularLigament capsularLigament = (CapsularLigament) bioMightInstance;
		//	bioMightComponent.setImage(capsularLigament.getImage());
		//	bioMightComponent.setWidth(capsularLigament.getImageWidth());
		//	bioMightComponent.setHeight(capsularLigament.getImageHeight());
		//}
		else if (bioMightComponent.equals(Constants.InterarticularLigament))
		{
			InterarticularLigament interarticularLigament = (InterarticularLigament) bioMightInstance;
			bioMightComponent.setImage(interarticularLigament.getImage());
			bioMightComponent.setWidth(interarticularLigament.getImageWidth());
			bioMightComponent.setHeight(interarticularLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.RadiateLigament))
		{
			RadiateLigament radiateLigament = (RadiateLigament) bioMightInstance;
			bioMightComponent.setImage(radiateLigament.getImage());
			bioMightComponent.setWidth(radiateLigament.getImageWidth());
			bioMightComponent.setHeight(radiateLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.shoulder
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.ArticularCapsuleLigament))
		{
			ArticularCapsuleLigament articularCapsuleLigament = (ArticularCapsuleLigament) bioMightInstance;
			bioMightComponent.setImage(articularCapsuleLigament.getImage());
			bioMightComponent.setWidth(articularCapsuleLigament.getImageWidth());
			bioMightComponent.setHeight(articularCapsuleLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.CoracohumeralLigament))
		{
			CoracohumeralLigament coracohumeralLigament = (CoracohumeralLigament) bioMightInstance;
			bioMightComponent.setImage(coracohumeralLigament.getImage());
			bioMightComponent.setWidth(coracohumeralLigament.getImageWidth());
			bioMightComponent.setHeight(coracohumeralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.GlenohumeralLigament))
		{
			GlenohumeralLigament glenohumeralLigament = (GlenohumeralLigament) bioMightInstance;
			bioMightComponent.setImage(glenohumeralLigament.getImage());
			bioMightComponent.setWidth(glenohumeralLigament.getImageWidth());
			bioMightComponent.setHeight(glenohumeralLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.GlenoidalLabrumLigament))
		{
			GlenoidalLabrumLigament glenoidalLabrumLigament = (GlenoidalLabrumLigament) bioMightInstance;
			bioMightComponent.setImage(glenoidalLabrumLigament.getImage());
			bioMightComponent.setWidth(glenoidalLabrumLigament.getImageWidth());
			bioMightComponent.setHeight(glenoidalLabrumLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TransverseHumeralLigament))
		{
			TransverseHumeralLigament transverseHumeralLigament = (TransverseHumeralLigament) bioMightInstance;
			bioMightComponent.setImage(transverseHumeralLigament.getImage());
			bioMightComponent.setWidth(transverseHumeralLigament.getImageWidth());
			bioMightComponent.setHeight(transverseHumeralLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.spinal
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AlarLigament))
		{
			AlarLigament alarLigament = (AlarLigament) bioMightInstance;
			bioMightComponent.setImage(alarLigament.getImage());
			bioMightComponent.setWidth(alarLigament.getImageWidth());
			bioMightComponent.setHeight(alarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorAtlantoaxialLigament))
		{
			AnteriorAtlantoaxialLigament anteriorAtlantoaxialLigament = (AnteriorAtlantoaxialLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorAtlantoaxialLigament.getImage());
			bioMightComponent.setWidth(anteriorAtlantoaxialLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorAtlantoaxialLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorLongitudinalLigament))
		{
			AnteriorLongitudinalLigament anteriorLongitudinalLigament = (AnteriorLongitudinalLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorLongitudinalLigament.getImage());
			bioMightComponent.setWidth(anteriorLongitudinalLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorLongitudinalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterspinousLigament))
		{
			InterspinousLigament interspinousLigament = (InterspinousLigament) bioMightInstance;
			bioMightComponent.setImage(interspinousLigament.getImage());
			bioMightComponent.setWidth(interspinousLigament.getImageWidth());
			bioMightComponent.setHeight(interspinousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IntertransverseLigament))
		{
			IntertransverseLigament intertransverseLigament = (IntertransverseLigament) bioMightInstance;
			bioMightComponent.setImage(intertransverseLigament.getImage());
			bioMightComponent.setWidth(intertransverseLigament.getImageWidth());
			bioMightComponent.setHeight(intertransverseLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumCoracohumerale))
		{
			LigamentumCoracohumerale ligamentumCoracohumerale = (LigamentumCoracohumerale) bioMightInstance;
			bioMightComponent.setImage(ligamentumCoracohumerale.getImage());
			bioMightComponent.setWidth(ligamentumCoracohumerale.getImageWidth());
			bioMightComponent.setHeight(ligamentumCoracohumerale.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumFlavumLigament))
		{
			LigamentumFlavumLigament ligamentumFlavumLigament = (LigamentumFlavumLigament) bioMightInstance;
			bioMightComponent.setImage(ligamentumFlavumLigament.getImage());
			bioMightComponent.setWidth(ligamentumFlavumLigament.getImageWidth());
			bioMightComponent.setHeight(ligamentumFlavumLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumNuchaeLigament))
		{
			LigamentumNuchaeLigament ligamentumNuchaeLigament = (LigamentumNuchaeLigament) bioMightInstance;
			bioMightComponent.setImage(ligamentumNuchaeLigament.getImage());
			bioMightComponent.setWidth(ligamentumNuchaeLigament.getImageWidth());
			bioMightComponent.setHeight(ligamentumNuchaeLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LliolumbarLigament))
		{
			LliolumbarLigament lliolumbarLigament = (LliolumbarLigament) bioMightInstance;
			bioMightComponent.setImage(lliolumbarLigament.getImage());
			bioMightComponent.setWidth(lliolumbarLigament.getImageWidth());
			bioMightComponent.setHeight(lliolumbarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorAtlantoaxialLigament))
		{
			PosteriorAtlantoaxialLigament posteriorAtlantoaxialLigament = (PosteriorAtlantoaxialLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorAtlantoaxialLigament.getImage());
			bioMightComponent.setWidth(posteriorAtlantoaxialLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorAtlantoaxialLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacroiliacLigament))
		{
			SacroiliacLigament sacroiliacLigament = (SacroiliacLigament) bioMightInstance;
			bioMightComponent.setImage(sacroiliacLigament.getImage());
			bioMightComponent.setWidth(sacroiliacLigament.getImageWidth());
			bioMightComponent.setHeight(sacroiliacLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SupraspinousLigament))
		{
			SupraspinousLigament supraspinousLigament = (SupraspinousLigament) bioMightInstance;
			bioMightComponent.setImage(supraspinousLigament.getImage());
			bioMightComponent.setWidth(supraspinousLigament.getImageWidth());
			bioMightComponent.setHeight(supraspinousLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.sternum
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.CostoxiphoidLigament))
		{
			CostoxiphoidLigament costoxiphoidLigament = (CostoxiphoidLigament) bioMightInstance;
			bioMightComponent.setImage(costoxiphoidLigament.getImage());
			bioMightComponent.setWidth(costoxiphoidLigament.getImageWidth());
			bioMightComponent.setHeight(costoxiphoidLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterarticularSternocostalLigament))
		{
			InterarticularSternocostalLigament interarticularSternocostalLigament = (InterarticularSternocostalLigament) bioMightInstance;
			bioMightComponent.setImage(interarticularSternocostalLigament.getImage());
			bioMightComponent.setWidth(interarticularSternocostalLigament.getImageWidth());
			bioMightComponent.setHeight(interarticularSternocostalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.RadiateSternocostalLigament))
		{
			RadiateSternocostalLigament radiateSternocostalLigament = (RadiateSternocostalLigament) bioMightInstance;
			bioMightComponent.setImage(radiateSternocostalLigament.getImage());
			bioMightComponent.setWidth(radiateSternocostalLigament.getImageWidth());
			bioMightComponent.setHeight(radiateSternocostalLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.tibiafibula
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AnteriorLigament))
		{
			AnteriorLigament anteriorLigament = (AnteriorLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorLigament.getImage());
			bioMightComponent.setWidth(anteriorLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.ArticularCapsuleLigament))
		{
			TibiaFibulaArticularCapsuleLigament articularCapsuleLigament = (TibiaFibulaArticularCapsuleLigament) bioMightInstance;
			bioMightComponent.setImage(articularCapsuleLigament.getImage());
			bioMightComponent.setWidth(articularCapsuleLigament.getImageWidth());
			bioMightComponent.setHeight(articularCapsuleLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InferiorTransverseLigament))
		{
			InferiorTransverseLigament inferiorTransverseLigament = (InferiorTransverseLigament) bioMightInstance;
			bioMightComponent.setImage(inferiorTransverseLigament.getImage());
			bioMightComponent.setWidth(inferiorTransverseLigament.getImageWidth());
			bioMightComponent.setHeight(inferiorTransverseLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterosseousLigament))
		{
			InterosseousLigament interosseousLigament = (InterosseousLigament) bioMightInstance;
			bioMightComponent.setImage(interosseousLigament.getImage());
			bioMightComponent.setWidth(interosseousLigament.getImageWidth());
			bioMightComponent.setHeight(interosseousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorLigament))
		{
			PosteriorLigament posteriorLigament = (PosteriorLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorLigament.getImage());
			bioMightComponent.setWidth(posteriorLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorLigament.getImageHeight());
		}

		//*****************************************************************************
		// biomight.system.ligament.vertebral
		//*****************************************************************************	
		else if (bioMightComponent.equals(Constants.AlarLigament))
		{
			AlarLigament alarLigament = (AlarLigament) bioMightInstance;
			bioMightComponent.setImage(alarLigament.getImage());
			bioMightComponent.setWidth(alarLigament.getImageWidth());
			bioMightComponent.setHeight(alarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorAtlantoaxialLigament))
		{
			AnteriorAtlantoaxialLigament anteriorAtlantoaxialLigament = (AnteriorAtlantoaxialLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorAtlantoaxialLigament.getImage());
			bioMightComponent.setWidth(anteriorAtlantoaxialLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorAtlantoaxialLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.AnteriorLongitudinalLigament))
		{
			AnteriorLongitudinalLigament anteriorLongitudinalLigament = (AnteriorLongitudinalLigament) bioMightInstance;
			bioMightComponent.setImage(anteriorLongitudinalLigament.getImage());
			bioMightComponent.setWidth(anteriorLongitudinalLigament.getImageWidth());
			bioMightComponent.setHeight(anteriorLongitudinalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterspinalLigaments))
		{
			InterspinalLigaments interspinalLigaments = (InterspinalLigaments) bioMightInstance;
			bioMightComponent.setImage(interspinalLigaments.getImage());
			bioMightComponent.setWidth(interspinalLigaments.getImageWidth());
			bioMightComponent.setHeight(interspinalLigaments.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.InterspinousLigament))
		{
			InterspinousLigament interspinousLigament = (InterspinousLigament) bioMightInstance;
			bioMightComponent.setImage(interspinousLigament.getImage());
			bioMightComponent.setWidth(interspinousLigament.getImageWidth());
			bioMightComponent.setHeight(interspinousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IntertransverseLigament))
		{
			IntertransverseLigament intertransverseLigament = (IntertransverseLigament) bioMightInstance;
			bioMightComponent.setImage(intertransverseLigament.getImage());
			bioMightComponent.setWidth(intertransverseLigament.getImageWidth());
			bioMightComponent.setHeight(intertransverseLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.IntertransverseLigaments))
		{
			IntertransverseLigaments intertransverseLigaments = (IntertransverseLigaments) bioMightInstance;
			bioMightComponent.setImage(intertransverseLigaments.getImage());
			bioMightComponent.setWidth(intertransverseLigaments.getImageWidth());
			bioMightComponent.setHeight(intertransverseLigaments.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentaFlava))
		{
			LigamentaFlava ligamentaFlava = (LigamentaFlava) bioMightInstance;
			bioMightComponent.setImage(ligamentaFlava.getImage());
			bioMightComponent.setWidth(ligamentaFlava.getImageWidth());
			bioMightComponent.setHeight(ligamentaFlava.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumCoracohumerale))
		{
			LigamentumCoracohumerale ligamentumCoracohumerale = (LigamentumCoracohumerale) bioMightInstance;
			bioMightComponent.setImage(ligamentumCoracohumerale.getImage());
			bioMightComponent.setWidth(ligamentumCoracohumerale.getImageWidth());
			bioMightComponent.setHeight(ligamentumCoracohumerale.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumFlavumLigament))
		{
			LigamentumFlavumLigament ligamentumFlavumLigament = (LigamentumFlavumLigament) bioMightInstance;
			bioMightComponent.setImage(ligamentumFlavumLigament.getImage());
			bioMightComponent.setWidth(ligamentumFlavumLigament.getImageWidth());
			bioMightComponent.setHeight(ligamentumFlavumLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LigamentumNuchaeLigament))
		{
			LigamentumNuchaeLigament ligamentumNuchaeLigament = (LigamentumNuchaeLigament) bioMightInstance;
			bioMightComponent.setImage(ligamentumNuchaeLigament.getImage());
			bioMightComponent.setWidth(ligamentumNuchaeLigament.getImageWidth());
			bioMightComponent.setHeight(ligamentumNuchaeLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.LliolumbarLigament))
		{
			LliolumbarLigament lliolumbarLigament = (LliolumbarLigament) bioMightInstance;
			bioMightComponent.setImage(lliolumbarLigament.getImage());
			bioMightComponent.setWidth(lliolumbarLigament.getImageWidth());
			bioMightComponent.setHeight(lliolumbarLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.MedialMenisci))
		{
			MedialMenisci medialMenisci = (MedialMenisci) bioMightInstance;
			bioMightComponent.setImage(medialMenisci.getImage());
			bioMightComponent.setWidth(medialMenisci.getImageWidth());
			bioMightComponent.setHeight(medialMenisci.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.NuchaeLigament))
		{
			NuchaeLigament nuchaeLigament = (NuchaeLigament) bioMightInstance;
			bioMightComponent.setImage(nuchaeLigament.getImage());
			bioMightComponent.setWidth(nuchaeLigament.getImageWidth());
			bioMightComponent.setHeight(nuchaeLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorAtlantoAxialLigament))
		{
			PosteriorAtlantoAxialLigament posteriorAtlantoAxialLigament = (PosteriorAtlantoAxialLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorAtlantoAxialLigament.getImage());
			bioMightComponent.setWidth(posteriorAtlantoAxialLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorAtlantoAxialLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.PosteriorLongitudinalLigament))
		{
			PosteriorLongitudinalLigament posteriorLongitudinalLigament = (PosteriorLongitudinalLigament) bioMightInstance;
			bioMightComponent.setImage(posteriorLongitudinalLigament.getImage());
			bioMightComponent.setWidth(posteriorLongitudinalLigament.getImageWidth());
			bioMightComponent.setHeight(posteriorLongitudinalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacroiliacLigament))
		{
			SacroiliacLigament sacroiliacLigament = (SacroiliacLigament) bioMightInstance;
			bioMightComponent.setImage(sacroiliacLigament.getImage());
			bioMightComponent.setWidth(sacroiliacLigament.getImageWidth());
			bioMightComponent.setHeight(sacroiliacLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacrospinousLigament))
		{
			SacrospinousLigament sacrospinousLigament = (SacrospinousLigament) bioMightInstance;
			bioMightComponent.setImage(sacrospinousLigament.getImage());
			bioMightComponent.setWidth(sacrospinousLigament.getImageWidth());
			bioMightComponent.setHeight(sacrospinousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SacrotuberousLigament))
		{
			SacrotuberousLigament sacrotuberousLigament = (SacrotuberousLigament) bioMightInstance;
			bioMightComponent.setImage(sacrotuberousLigament.getImage());
			bioMightComponent.setWidth(sacrotuberousLigament.getImageWidth());
			bioMightComponent.setHeight(sacrotuberousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SupraspinalLigament))
		{
			SupraspinalLigament supraspinalLigament = (SupraspinalLigament) bioMightInstance;
			bioMightComponent.setImage(supraspinalLigament.getImage());
			bioMightComponent.setWidth(supraspinalLigament.getImageWidth());
			bioMightComponent.setHeight(supraspinalLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.SupraspinousLigament))
		{
			SupraspinousLigament supraspinousLigament = (SupraspinousLigament) bioMightInstance;
			bioMightComponent.setImage(supraspinousLigament.getImage());
			bioMightComponent.setWidth(supraspinousLigament.getImageWidth());
			bioMightComponent.setHeight(supraspinousLigament.getImageHeight());
		}
		else if (bioMightComponent.equals(Constants.TransverseOfAtlasLigament))
		{
			TransverseOfAtlasLigament transverseOfAtlasLigament = (TransverseOfAtlasLigament) bioMightInstance;
			bioMightComponent.setImage(transverseOfAtlasLigament.getImage());
			bioMightComponent.setWidth(transverseOfAtlasLigament.getImageWidth());
			bioMightComponent.setHeight(transverseOfAtlasLigament.getImageHeight());
		}
		else
		{
			System.out.println("BioMightView Tissue Component NOT MATCHED: " + bioMightComponentRef + "  " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
