package biomight.ejb;
import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;

@Local
public interface BioMightDNABeanLocal {


	int generateNucleotides(String dnaChain, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateNucleotide(String sNucleotide, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRibose(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateDeOxyRibose(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAmine(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCarboxyl(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePhosphate(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAdenine(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCytosine(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateGuanine(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateThymine(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateNucleobase(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCarbon(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHydrogen(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOxygen(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
}
