package biomight.ejb;

import java.util.ArrayList;
import javax.ejb.Local;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightTransforms;

@Local
public interface BioMightSymbolsBeanLocal {
	
	int generateBioTexts(int nElements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int setComponentDesc(String componentID, String compDesc)
			throws DataException, DataSecurityException;

	int setComponentFont(String componentID, int font)
			throws DataException, DataSecurityException;
	
	int generateBioArrows(int numElements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
}

