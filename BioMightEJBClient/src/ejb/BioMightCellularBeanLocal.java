package biomight.ejb;
import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;

@Local
public interface BioMightCellularBeanLocal {

	int generateBasophils(int numElelements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateEosinophils(int numElements, String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateGolgiApparatus(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double radius, double[] startPos) throws DataException,
			DataSecurityException;

	int generateGolgiApparatusFold(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double radius, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateEndoPlasmicReticulum(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double radius, double[] startPos) throws DataException,
			DataSecurityException;

	int generatePeroxisomes(int numElements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateRibosomes(int numElements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;


	int generateFimbriae(int numElements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateFimbria(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCoreMembrane(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateOuterMembrane(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCapsid(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCapsidSphere(double[] startPos, double radius,
			String componentType, String componentName, String componentID,
			String parentID) throws DataException,
			DataSecurityException;
	
	int generateCapsidNeck(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCapsidTail(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;	

	int generateLateralBody(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMembraneTubules(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateVirusBasePlate(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateVirusTailFibers(int numElements, double[] startPos, 
			double circumference, double radius, double height, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateVirusTailFiber(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateVirusTailFiberSegment(double angle,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateGlycoProteinSpike(double[] startPos, 
			double radius, double cyRadius, double cyHeight,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateGlycoProteinSpikes(int numElements, 
			double radius, double cyRadius, double cyHeight,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCellMembrane(int numElelements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double radius, double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	
	int generateSpirochete(String componentID, String componentType,
			String componentName, String parentID, double[][] currentPoints)
			throws DataException, DataSecurityException;

	int generateEurythrocyte(int numElelements, String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException;
}
