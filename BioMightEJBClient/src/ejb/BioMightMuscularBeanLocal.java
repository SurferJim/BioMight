package biomight.ejb;
import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;

@Local
public interface BioMightMuscularBeanLocal {

	int generateLongRotatorsMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLongusColliMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePalmarisLongusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePlatysmaMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTrapeziusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePectoralisMajorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBuccinatorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCaninusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePectoralisMinorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDiaphramMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateObliquusExternusAbdominisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateObliquusInternusAbdominisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePsoasMajorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePsoasMinorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePyramidalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateQuadratusLumborumMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCremasterMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRectusAdominisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTransversusAbdomisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnconeusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBicepsBrachiiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBrachialisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBrachioradialisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCoracoBrachialisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorCarpiRadialisBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorCarpiRadialisLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorCarpiUlnarisLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorDigitiMinimiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorDigitorumMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorPollicisLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTricepsBrachiiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDiaphragmMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIntercostalesExterniMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAbductorDigitiMinimiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAbductorHallucisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAbductorOssisMetatarsiQuintiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdductorHallucisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDorsalInterosseiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorDigitorumBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorHallucisBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorDigitiMinimiBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorDigitorumBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorHallucisBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInterosselMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLumbriclesMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePlantarInterosseiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateQuadratusPlantaeMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAntiBrachialFasciaMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorCarpiRadialisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorCarpiUlnarisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorDigitorumProfundusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorDigitorumSuperficialisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdductorBrevisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdductorLongusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdductorMagnusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdductorPollicisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorScaleneMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorVertebralMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateArticularisGenusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAuricularisAnteriorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBulboCavernosusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBulboSpongiosusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCoccygeusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCorrugatorSuperciliiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCricoArytenoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDeltoideusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDepressorAnguliOrisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateEpicraniusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorDigitorumLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorHallicusLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExtensorPollicisBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorDigitorumLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorPollicisBrevisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorPollicisLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFrontalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGenioHyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGluteusMaximusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGluteusMediusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGluteusMinimusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGracilisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHipMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIlotibialTractMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorLongitudinalMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorObliqueMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorRectusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInfraSpinatusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIrisSphincterMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIschiocavernosusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralCricoarytenoidMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralRectusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralVeterbralMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLevatorAnguliOrisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLevatorLabiiSuperiorisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMediallRectusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMusculusUvulaeMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateNasalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateObturatorExternusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateObturatorInternusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOpponensPollicisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOrbicularisOrisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePalmarisBrevisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePectineusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePeroneusBrevisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePeroneusLongusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePeroneusTertiusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePiriformisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePlantarisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePopliteusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateProcerusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePronatorQuadratusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePterygoideusInternusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateQuadratusLabiiSuperiorisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateQuadricepsFemorisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRectusCapitisAnteriorMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRectusFemorisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRisoriusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSartoriusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateScalenusAnteriorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateScalenusMediusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSoleusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSphincterAniExternusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSternoCleidoMastoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateStyloHyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorLongitudinalMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorObliqueMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorRectusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSupinatorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSupraInfrahyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSupraSpinatusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTemporalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTensorFasciaLataMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTeresMinorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateThyroArytenoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTibialisAnteriorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTransversusPerineiSuperficialisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTriangularisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVastusInterMediusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int AnteriorVeterbralMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBicepsFemorisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCorrugatorCutisAniMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCorrugatorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCricoThyroidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDepressorLabiiInferiorisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDepressorSeptiNasiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDigastricMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDilatatorNarisPosteriorMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFlexorHallicusLongusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGaleaAponeurotica(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGastrocnemiusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGemelliMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIliacusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateIliopsoasMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorGemelliMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralCervicleMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLevatorLabiiSuperiorisAlaequeNasiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLevatorPalpebraeSuperiorisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLongusCapitisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMasseterMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMentalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMylohyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOccipitalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOmoHyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOpponensDigitiMinimiMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOrbicularisOculiMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePronatorTeresMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSternoMastoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSternoThyroidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSubScapularisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperficialCervicalMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperficialFasciaMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorGemelliMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTeresMajorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateThyroHyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTibialisPosteriorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePterygoideusExternusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateQuadratusLabiiInferiorisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRectusCapitisLateralisMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateScalenusMinimusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateScalenusPosteriorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSemiMembranosusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSemitendinosusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSphincterAniInternusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSphincterUrethraeMembranaceaeMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSternoHyoidMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTransversusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTransversusPerineiProfundusMuscle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVastusLateralisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVastusMedialisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateZygomaticusMajorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateZygomaticusMinorMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVerticalisMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateZygomaticusMuscle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;	
}
