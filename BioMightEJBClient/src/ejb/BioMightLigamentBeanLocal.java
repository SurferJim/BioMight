package biomight.ejb;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightPosition;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface BioMightLigamentBeanLocal {

	int generateAnteriorCostoTransverseLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
			throws DataException, DataSecurityException;
	
	int generateInterosseousSacroiliacLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
			throws DataException, DataSecurityException;

}
