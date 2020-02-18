package biomight.ejb;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;

import javax.ejb.Local;

@Local
public interface BioMightVascularBeanLocal {
	
	int generateAorticArch(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDescendingAortaArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAbdominalAortaArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBrachioCephalicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateRadialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHepaticArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateUlnarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAnteriorUlnarRecurrentArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePosteriorUlnarRecurrentArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRadialRecurrentArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAnteriorInterosseousArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePosteriorInterosseousArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInterosseousRecurrentArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	

	int generateAdrenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAppendicularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorEpigastricArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInferiorLateralSacralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperiorLateralSacralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCommonHepaticArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperiorSupraRenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInferiorPhrenicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCysticArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGastroEpiploicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePulmonaryArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorMesentericArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorSupraRenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMiddleSupraRenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorPancreaticoDuodenalArtery(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateProperHepaticArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGastroDuodenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorPancreaticoDuodenalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSplenicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateGastricArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSpleenCentralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTrabecularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	
	int generateAortaArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAscendingAortaArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCeliacArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAtrium(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVentricle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSubclavianArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBronchialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorVenaCava(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;


	int generateInferiorVenaCava(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	
	int generateConusArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAxillaryArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateThoracicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCoronaryArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	BioMightGenerate generateCommonCarotidArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInternalCarotidArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExternalCarotidArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAngularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBasilarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateBuccalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateFacialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorTibialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAnteriorTibialVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePosteriorTibialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePosteriorTibialVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateFibularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateTransverseFacialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDorsalNasalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLacrimalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateOccipitalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateOphthalmicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMentalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRanineArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateFrontalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateStylomastoidArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMedialPalpebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCerebellarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorCerebellarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAnteriorInferiorCerebellarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePosteriorInferiorCerebellarArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCerebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorCerebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMiddleCerebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePosteriorCerebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperiorHypophysealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorHypophysealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorCommunicatingArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePosteriorCommunicatingArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateVertebralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAnteriorSpinalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperficialTemporalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;	
	
	int generatePontineArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAscendingPalatineArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDescendingPalatineArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInternalMaxillaryArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExternalMaxillaryArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLingualArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAccessoryMeningealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMiddleMeningealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePosteriorMeningealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAscendingPharyngealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInferiorLabialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperiorLabialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInfraOrbitalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSupraOrbitalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSupraTrochlearArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateBrachialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDeepBrachialArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAnteriorCircumflexHumeralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;	

	int generatePosteriorCircumflexHumeralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorUlnarCollateralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInferiorUlnarCollateralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRadialCollateralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMiddleCollateralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateArteries(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVeins(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateBrachialVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBasilicVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAccessoryCephalicVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
			
	int generateCephalicVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateObturatorArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateColicArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperiorThyroidArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperficialEpigastricArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperiorEpigastricArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateColicVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTrabecularVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGastroEpiploicVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateGreatCardiacVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSmallCardiacVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSubclavianVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInnominateVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateExternalJugularVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateInternalJugularVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAngularVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	BioMightGenerate generateInferiorThyroidVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			BioMightConstruct bioMightConstruct) throws DataException,
			DataSecurityException;

	BioMightGenerate generateMiddleThyroidVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			BioMightConstruct bioMightConstruct) throws DataException,
			DataSecurityException;

	BioMightGenerate generateSuperiorThyroidVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			BioMightConstruct bioMightConstruct) throws DataException,
			DataSecurityException;

	int generateMentalVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCommonIliacArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCommonIliacVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePoplitealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePoplitealVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePeronealArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePeronealVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDeepFemoralVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateExternalIliacArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateExternalIliacVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInternalIliacArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateInternalIliacVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCommonFemoralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDeepFemoralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	


	int generateGreatSaphenousVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSmallSaphenousVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateSuperficialFemoralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSuperficialFemoralVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateLateralCircumflexFemoralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralCircumflexFemoralVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMedialCircumflexFemoralArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDescendingGenicularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDescendingGenicularArticularArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDescendingGenicularSaphenousArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	
	int generateSuperficialPalmarArchArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDeepPalmarArchArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePalmarCarpalBranchArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePrincepsPollicisArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateRadialisIndicisArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePalmarMetacarpalArtery(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateDorsalMetatarsalVein(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
}
