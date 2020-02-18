package biomight.ejb;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightGenerate;

import javax.ejb.Local;

@Local
public interface BioMightSkeletalBeanLocal {

	int generateRib(String startID, String componentType, String componentName,
			String componentID, String parentID, double[][] currentPoints)
			throws DataException, DataSecurityException;

	BioMightGenerate generateHumerus(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	BioMightGenerate generateRadius(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateUlna(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePelvis(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;	
	
	int generateSacrum(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateIlium(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFemur(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTibia(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFibula(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCervicalVertebra(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateThoracicVertebra(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateLumbarVertebra(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSacralVertebra(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;	
	
	int generateTrochanterHead(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTrochanterNeck(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLesserTrochanter(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateLateralEpiCondyle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateMedialEpiCondyle(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateSternum(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCarpal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMetaCarpal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHandMiddlePhalange(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateHandProximalPhalange(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHandDistalPhalange(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	
	/*
	int generateTarsal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMetaTarsal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHandMiddleTarsal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateHandProximalTarsal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHandDistalTarsal(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	*/
}
