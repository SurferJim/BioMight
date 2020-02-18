package biomight.ejb;
import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;

@Local
public interface BioMightNervousBeanLocal {

	int generateMaxillaryNerve(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePudendalNerve(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOpticNerve(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVidianNerve(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVagusNerve(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
}
