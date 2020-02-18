package biomight.ejb;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.Local;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

@Local
public interface BioMightBeanLocal {
	BioMightMaterial getMaterial(int materialID) throws DataException,
	DataSecurityException;

	HashMap getMaterialsDDMap() throws DataException, DataSecurityException;
	HashMap getTexturesDDMap() throws DataException, DataSecurityException;	
	HashMap getFontsDDMap() throws DataException, DataSecurityException;
	
	BioMightTexture getTexture(int textureID) throws DataException,
	DataSecurityException;
	
	BioMightTransforms getComponentsByView(String componentType, String view)
		throws DataException, DataSecurityException;
	
	BioMightTransforms getComponents(String componentType, String parentID)
		throws DataException, DataSecurityException;
	
	BioMightTransforms getComponent(String componentID) throws DataException,
		DataSecurityException;
	
	ArrayList getVerticies(String componentID) throws DataException,
		DataSecurityException;
	
	BioMightTransform getComponentByName(String componentName)
		throws DataException, DataSecurityException;
	
	BioMightMaterial getComponentMaterial(int componentID)
		throws DataException, DataSecurityException;
	
	int setComponentMaterial(String componentID, int materialID)
		throws DataException, DataSecurityException;
	
	int setMaterial(String componentID, int materialID) throws DataException,
		DataSecurityException;
	
	int setMaterial(String componentType, String parentID, int materialID)
		throws DataException, DataSecurityException;
	
	int setCollectionMaterial(String parentID, int materialID)
		throws DataException, DataSecurityException;

	int setComponentTexture(String componentID, int textureID)
			throws DataException, DataSecurityException;
	
	int setTexture(String componentType, String parentID, int materialID)
			throws DataException, DataSecurityException;
	
	int setTexture(String componentID, int textureID) throws DataException,
	DataSecurityException;

	
	int setCollectionTexture(String parentID, int materialID)
			throws DataException, DataSecurityException;
	
	int updateComponent(String componentType, String parentID,
		BioMightTransform bioMightTransform) throws DataException,
		DataSecurityException;
	
	BioMightInstructSet getBioCode(String compType, String parentID)
		throws DataException, DataSecurityException;
	
	int insertBioCode(String compType, String parentID, String startID, BioMightInstructSet bioMightInstructSet) 
			throws DataException, DataSecurityException; 
		
	int generateNose(String parentID) throws DataException,
		DataSecurityException;
	
	int generateHair(String parentID) throws DataException,
		DataSecurityException;
	
	int generateSmallIntestine(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateLargeIntestine(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateForeArm(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateArm(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateElbow(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateThigh(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCnemis(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateKnee(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateFinger(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateEsophagus(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	BioMightGenerate generateTrachea(String startID, String componentType,
		String componentName, String componentID, String parentID,  double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	BioMightGenerate generateTrachea(String startID, String componentType,
			String componentName, String componentID, String parentID, BioMightConstruct BioMightConstruct)
			throws DataException, DataSecurityException;
	
	int generateHip(String startID, String componentType, 
		String componentName, String componentID, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateStomach(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateLiver(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;

	int generateHeart(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateWrist(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateHand(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generatePalm(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateThumb(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateBladder(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateUreter(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateSpleen(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateEyeLid(String componentID, String componentType,
		String componentName, String parentID, double[][] currentPoints)
		throws DataException, DataSecurityException;
	
	int generateKidney(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generatePancreas(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateLung(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateGallBladder(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateCommonBileDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCysticDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateCommonHepaticDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateHepaticDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePancreaticDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateAccessoryPancreaticDuct(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateThyroidGland(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	BioMightGenerate generateNeck(String startID, String componentType,
		String componentName, String componentID, String parentID, BioMightConstruct BioMightConstruct)
	throws DataException, DataSecurityException;
	
	int generateNeck(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateBronchus(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateLobarBronchus(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generateSegmentalinicBronchus(String startID, String componentType,
		String componentName, String componentID, String parentID,
		double[][] currentPoints) throws DataException,
		DataSecurityException;
	
	int generatePituitaryGland(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generatePinealGland(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateBrain(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCerebrum(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateCerebellum(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generatePons(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateMedullaOblongata(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateParaThyroidGland(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateThymus(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int generateAdrenalGland(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;

	int generateTongue(String startID, String componentType,
			String componentName, String componentID, String parentID,
			double[][] currentPoints) throws DataException,
			DataSecurityException;
	
	int insertComponentProps(String componentID, String componentType, String componentName, 
              ArrayList<BioMightPropertyView> bioMightProperties)
            throws DataException, 	DataSecurityException;
          	
	BioMightTransforms getComponentsByParent(String parentID)
		throws DataException, DataSecurityException;
	
	BioMightTransforms getComponentsHist(String componentType, String parentID)
		throws DataException, DataSecurityException;
	
	int addComponentHistory(String componentID, String componentType, String componentName, String parentID, String X3D) 
		throws DataException, DataSecurityException;		

	ArrayList<BioMightPropertyView> getComponentProps(String parentID)
			throws DataException, DataSecurityException;
}

