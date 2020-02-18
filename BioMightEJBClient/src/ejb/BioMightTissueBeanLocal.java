package biomight.ejb;
import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;

@Local
public interface BioMightTissueBeanLocal {

	int generateBlood(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	
	int generateCostalCartilage(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
}
