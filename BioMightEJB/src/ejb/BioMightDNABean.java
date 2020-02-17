package biomight.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ejb.Stateless;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;



/***************************************************************************
 * Session Bean implementation class BioMightTissueBean
 * 
 * 
 ****************************************************************************/

@Stateless
public class BioMightDNABean implements BioMightDNABeanLocal {
	
	
    /**
     * Default constructor. 
     */
    public BioMightDNABean() {
        // TODO Auto-generated constructor stub
    }
   	
   
	/*******************************************************************************************
	 * GENERATE NUCLEOTIDES
	 * 
	 * This method will create a representation of the Nucleotide chain the user enters  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateNucleotides(String dnaChain, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		System.out.println("In GenerateNucleotides - ComponentID: " + componentID + "    parentID: " + parentID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition;

		// We are not going to allow the client to set a collection value < 0
		int numNucleotides = dnaChain.length();
		System.out.println(": " + numNucleotides);
		
		if (numNucleotides < 1)
		{
			System.out.println("In GenerateNucleotides - Skipping as length < 1");
			return(0);
		}

		// Vars for processing
  		int componentNum = 0;
		String componentBase = "Nucleotide";
		String newComponentID; 
		System.out.println("Checking on Nucleotides for parentID " + parentID);
			
		// First determine if this component already has a slot
		System.out.println("GenerateNucleotides - Checking for records...Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateNucleotides() - Start Updating at: " + startNum);
		
		if (startNum <= 0){
			
			// There are currently no members in the database
			
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Nucleotide records exist - Next Block starts at: " + startNum);
		}
		else
			System.out.println("Component Recs already exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("GenerateNucleotides StartID is : " + startID);
				
		//********************************************************************************************
		// Replace the existing elements if we are within the current count.  Insert extra
		// where needed. Cull the extra
		// Number of Elements is Greater then the current Colony Count so we need to 
		// increase it. 
		//********************************************************************************************
		
		// Get a count of the existing nucleotides to see what's there
		int numCurrentNucleotides = DBUtils.getComponentCount(bodyID, projectID, componentType, parentID); 
		System.out.println("generateNucleotides() -  Current Nucleotide Count: " + numCurrentNucleotides);	 	
	 			
		// Generate the Component ID	
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
	
		
		// Get the length of the chain that the user wishes to create
		// Not sure if dynamically allocating or setting up a block set??
		// Create a record for each nucleotide in the chain 
		for (int nNucelotide=0; nNucelotide<numNucleotides; nNucelotide++)
		{
			char nucleoChar = dnaChain.charAt(nNucelotide);
			if(nucleoChar == 'A') {
				System.out.println("Creating Nucleotide Adenine");	
				componentName = "Adenine";
			}
			else if(nucleoChar == 'C') {
				System.out.println("Creating Nucleotide Cytosine");
				componentName = "Cytosine";
			}
			else if(nucleoChar == 'G') {
				System.out.println("Creating Nucleotide Guanine");
				componentName = "Guanine";
			}
			else if(nucleoChar == 'T') {
				System.out.println("Creating Nucleotide Thymine");
				componentName = "Thymine";
			}
			else if(nucleoChar == 'U') {
				System.out.println("Creating Nucleotide Uracil");
				componentName = "Uracil";
			}
			else {
				System.out.println("Undiscernable Nucleotides: " + nucleoChar);				
			}
					
			
			//zPos = 0.00; // (nNucelotide * 0.75);
			yPos += 0.5;
			//zPos = 0.5;	
			bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

			// We already have the element in the database
			bioMightTransform = new BioMightTransform(bodyID, projectID, startID, componentType, componentName, parentID);
			bioMightTransform.setTranslation(bioMightPosition);
			
			
			// No need to set now as we are dealing with sphere's at this level
			// bioMightTransform.setCoordpointStr(coordStr, depth, depthDirection);
			
			if (nNucelotide < numCurrentNucleotides)
			{	
				System.out.println("Calling UpsertComponent : " + numNucleotides +  "    " + startID);
				// We already have the element in the database
				DBUtils.upsertComponent(bioMightTransform); 
			}
			else if (nNucelotide >= numCurrentNucleotides)
			{
				System.out.println("Calling InsertComponent: "  + startID);
				bioMightTransform.setCreaseAngle(0.52);
				bioMightTransform.setMaterialID(7);
				bioMightTransform.setRadius(radius);
				bioMightTransform.setDepthDirection(depthDirection);
				
				BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
				bioMightTransform.setScale(bioMightScale);
				// Insert the element into the database
				DBUtils.insertComponent( bioMightTransform);
			}
						
			// Increment the counter
			startNum++;
			startID = DBUtils.convertID(startNum, componentBase);		
		}

		

		// Clear out the Extra records that were part of prior chain
		System.out.println("Prune Nucleotides to Chain Length of : " + numNucleotides);			
		for (int nNucelotide=numNucleotides; nNucelotide<numCurrentNucleotides; nNucelotide++)
		{
			// Cull the elements from NumElements up to the current Colony Count
			// This will get rid of everything past the amount the user/app wants
			//int startElement = nNucelotide+1;
						
			// Generate the Component ID
			newComponentID = DBUtils.convertID(startNum, componentBase);
			System.out.println("Culling Nucleotide Chain ID: " + newComponentID);
		
			// Set up the base elements for this DNA chain
			DBUtils.deleteComponent(newComponentID); 
			startNum++;
		}
	
							
		return returnCode;	
	}


   	/*******************************************************************************************
	 * GENERATE NUCLEOTIDES
	 * 
	 * This method will create a representation of the Nucleotide chain the user enters  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateNucleotidesOLD(String dnaChain, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		System.out.println("In GenerateNucleotides  startID: " + startID + "   ComponentID: " + componentID + "    parentID: " + parentID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		int numCurrentNucleotides = 0;
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition;
		
		
		// Get a count of the existing nucleotides to see what's there
		numCurrentNucleotides = DBUtils.getComponentCount(bodyID, projectID, componentType, parentID); 
		System.out.println("BioMightDNABean.GenerateNucleotides() -  Length is: " + numCurrentNucleotides);

		
		/****
		
		
		// NUCLEOTIDE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Nucleotide");
		String nucleotideID = DBUtils.getComponentID(bodyID, projectID, Constants.NucleotideRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  NucleotideID: " + nucleotideID + " for parent: " + parentID);
		
		if (nucleotideID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextNucleotideID = DBUtils.getComponentCount(bodyID, projectID, Constants.NucleotideRef); 
			System.out.println("No Component Found - CurrentCount: " + nextNucleotideID + " for parent: " + parentID);
			nextNucleotideID++;
			componentBase = Constants.NucleotideRef;
			newComponentID = DBUtils.convertID(nextNucleotideID, componentBase);				
			System.out.println("generateNucleotide() New Nucleotide ComponentID: " + newComponentID);		

		
		****/
		
		//********************************************************************************************
		// Replace the existing elements if we are within the current count.  Insert extra
		// where needed. Cull the extra
		//********************************************************************************************

		// Vars for processing
  		int componentNum = 0;
		String componentBase = "";
			
		// Number of Elements is Greater then the current Colony Count so we need to 
		// increase it. 
		System.out.println("Current Nucleotides Length: " + numCurrentNucleotides);
		componentBase = startID.substring(0,startID.indexOf(":"));
		
		// Generate the Component ID
		String newComponentID = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
	
		
		// Get the length of the chain that the user wishes to create
		// Not sure if dynamically allocating or setting up a block set??
		int numNucleotides = dnaChain.length();
		System.out.println("numNucleotides is: " + numNucleotides);
		
		// Create a record for each nucleotide in the chain 
		for (int nNucelotide=0; nNucelotide<numNucleotides; nNucelotide++)
		{
			char nucleoChar = dnaChain.charAt(nNucelotide);
			if(nucleoChar == 'A') {
				System.out.println("Creating Nucleotide Adenine");	
				componentName = "Adenine";
			}
			else if(nucleoChar == 'C') {
				System.out.println("Creating Nucleotide Cytosine");
				componentName = "Cytosine";
			}
			else if(nucleoChar == 'G') {
				System.out.println("Creating Nucleotide Guanine");
				componentName = "Guanine";
			}
			else if(nucleoChar == 'T') {
				System.out.println("Creating Nucleotide Thymine");
				componentName = "Thymine";
			}
			else if(nucleoChar == 'U') {
				System.out.println("Creating Nucleotide Uracil");
				componentName = "Uracil";
			}
			else {
				System.out.println("Undiscernable Nucleotides: " + nucleoChar);				
			}
					
			// Generate the Component ID
			int dbNucelo = nNucelotide + 1;
			newComponentID = DBUtils.convertID(dbNucelo, componentBase);
			
			//zPos = 0.00; // (nNucelotide * 0.75);
			yPos += 0.5;
			//zPos = 0.5;	
			bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

			// We already have the element in the database
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, componentType, componentName, parentID);
			bioMightTransform.setTranslation(bioMightPosition);
			
			// No neeed to set now as we are dealing with sphere's at this level
			// bioMightTransform.setCoordpointStr(coordStr, depth, depthDirection);
			
			if (nNucelotide < numCurrentNucleotides)
			{	
				System.out.println("Calling UpdateComponent : " + numNucleotides);
				// We already have the element in the database
				DBUtils.updateComponent(bioMightTransform); 
			}
			else if (nNucelotide >= numCurrentNucleotides)
			{
				bioMightTransform.setCreaseAngle(0.52);
				bioMightTransform.setMaterialID(7);
				bioMightTransform.setRadius(radius);
				bioMightTransform.setDepthDirection(depthDirection);
				
				BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
				bioMightTransform.setScale(bioMightScale);
				// Insert the element into the database
				DBUtils.insertComponent( bioMightTransform);
			}
						
			// Increment the counter
			componentNum++;
		}

		
		// Clear out the Extra records so that they does not display
		System.out.println("Prune Nucleotides to Chain Length of : " + numNucleotides);
		//componentBase = startID.substring(0,startID.indexOf(":"));			
		for (int nNucelotide=numNucleotides; nNucelotide<numCurrentNucleotides; nNucelotide++)
		{
			// Cull the elements from NumElements up to the current Colony Count
			// This will get rid of everything past the amount the user/app wants
			//int startElement = nNucelotide+1;
						
			// Generate the Component ID
			int dbNucelo = nNucelotide + 1;
			newComponentID = DBUtils.convertID(dbNucelo, componentBase);
			System.out.println("Culling Nucleotide Chain ID: " + newComponentID);
		
			// Set up the base elements for this DNA chain
			DBUtils.deleteComponent(newComponentID); 
		}
			
							
		return returnCode;	
	}

   	
   	
   	/*******************************************************************************************
	 * GENERATE NUCLEOTIDE
	 * 
	 * This method will create a representation of a Nucleotide in the data repository
	 *   
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateNucleotide(String sNucleotide, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateNucleotide: " + startID);
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		double radius = 0.0825;
		
		// Vars for processing
		String componentBase = "";
			
		// Generate the Component ID
		String newComponentID = "";;
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;
		int compGroup = 0;		
		vertices = "" ;
	
		
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// NUCLEOTIDE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Nucleotide");
		String nucleotideID = DBUtils.getComponentID(bodyID, projectID, Constants.NucleotideRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  NucleotideID: " + nucleotideID + " for parent: " + parentID);
		
		if (nucleotideID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextNucleotideID = DBUtils.getComponentCount(bodyID, projectID, Constants.NucleotideRef); 
			System.out.println("No Component Found - CurrentCount: " + nextNucleotideID + " for parent: " + parentID);
			nextNucleotideID++;
			componentBase = Constants.NucleotideRef;
			newComponentID = DBUtils.convertID(nextNucleotideID, componentBase);				
			System.out.println("generateNucleotide() New Nucleotide ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleotideRef, Constants.NucleotideRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Nucleotide Transform Object
			newComponentID = nucleotideID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleotideRef, Constants.NucleotideRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleotide() - Nucleotide Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
				
		return returnCode;	
	}

 	
 	/*******************************************************************************************
	 * GENERATE DEOXYRIBOSE
	 * 
	 * This method will create a representation of a DeOxyRibose in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateDeOxyRibose(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateDeOxyRibose : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for DeOxyRibose");
		String riboseID = DBUtils.getComponentID(bodyID, projectID, Constants.DeOxyRiboseRef, parentID); 
		System.out.println("BioMightDNABean.generateDeOxyRibose() -  DeOxyRiboseID: " + riboseID + " for parent: " + parentID);
		
		if (riboseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextRiboseID = DBUtils.getComponentCount(bodyID, projectID, Constants.DeOxyRiboseRef); 
			System.out.println("No Component Found - CurrentCount: " + nextRiboseID + " for parent: " + parentID);
			nextRiboseID++;
			componentBase = "DeOxyRibose";
			newComponentID = DBUtils.convertID(nextRiboseID, componentBase);				
			System.out.println("generateDeOxyRibose() New DeOxyRibose ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.DeOxyRiboseRef, Constants.DeOxyRiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the DeOxyRibose Transform Object
			newComponentID = riboseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.DeOxyRiboseRef, Constants.DeOxyRiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateDeOxyRibose() - DeOxyRibose Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}


 	/*******************************************************************************************
	 * GENERATE RIBOSE
	 * 
	 * This method will create a representation of a Ribose in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateRibose(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateRibose : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Ribose");
		String riboseID = DBUtils.getComponentID(bodyID, projectID, Constants.RiboseRef, parentID); 
		System.out.println("BioMightDNABean.generateRibose() -  RiboseID: " + riboseID + " for parent: " + parentID);
		
		if (riboseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextRiboseID = DBUtils.getComponentCount(bodyID, projectID, Constants.RiboseRef); 
			System.out.println("No Component Found - CurrentCount: " + nextRiboseID + " for parent: " + parentID);
			nextRiboseID++;
			componentBase = "Ribose";
			newComponentID = DBUtils.convertID(nextRiboseID, componentBase);				
			System.out.println("generateRibose() New Ribose ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.RiboseRef, Constants.RiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Ribose Transform Object
			newComponentID = riboseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.RiboseRef, Constants.RiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateRibose() - Ribose Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}

	
 	/*******************************************************************************************
	 * GENERATE AMINE
	 * 
	 * This method will create a representation of a Amine in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateAmine(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateAmine : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// AMINE
		// See if a Amine is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Amine");
		String amineID = DBUtils.getComponentID(bodyID, projectID, Constants.AmineRef, parentID); 
		System.out.println("BioMightDNABean.generateAmine() -  AmineID: " + amineID + " for parent: " + parentID);
		
		if (amineID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextAmineID = DBUtils.getComponentCount(bodyID, projectID, Constants.AmineRef); 
			System.out.println("No Component Found - CurrentCount: " + nextAmineID + " for parent: " + parentID);
			nextAmineID++;
			componentBase = "Amine";
			newComponentID = DBUtils.convertID(nextAmineID, componentBase);				
			System.out.println("generateAmine() New Amine ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.AmineRef, Constants.AmineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the DeOxyRibose Transform Object
			newComponentID = amineID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.AmineRef, Constants.AmineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateAmine() - Amine Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}


	/*******************************************************************************************
	 * GENERATE CARBOXYL
	 * 
	 * This method will create a representation of a Carboxyl in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateCarboxyl(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateCarboxyl : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// AMINE
		// See if a Carboxyl is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Carboxyl");
		String carboxylID = DBUtils.getComponentID(bodyID, projectID, Constants.CarboxylRef, parentID); 
		System.out.println("BioMightDNABean.generateCarboxyl() -  CarboxylID: " + carboxylID + " for parent: " + parentID);
		
		if (carboxylID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextCarboxylID = DBUtils.getComponentCount(bodyID, projectID, Constants.CarboxylRef); 
			System.out.println("No Component Found - CurrentCount: " + nextCarboxylID + " for parent: " + parentID);
			nextCarboxylID++;
			componentBase = "Carboxyl";
			newComponentID = DBUtils.convertID(nextCarboxylID, componentBase);				
			System.out.println("generateCarboxyl() New Carboxyl ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CarboxylRef, Constants.CarboxylRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the DeOxyRibose Transform Object
			newComponentID = carboxylID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CarboxylRef, Constants.CarboxylRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateCarboxyl() - Carboxyl Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}

 	
 	/*******************************************************************************************
	 * GENERATE THYMINE
	 * 
	 * This method will create a representation of a Thymine in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateThymine(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateThymine : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// THYMINE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Thymine");
		String riboseID = DBUtils.getComponentID(bodyID, projectID, Constants.ThymineRef, parentID); 
		System.out.println("BioMightDNABean.generateThymine() -  ThymineID: " + riboseID + " for parent: " + parentID);
		
		if (riboseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextThymineID = DBUtils.getComponentCount(bodyID, projectID, Constants.ThymineRef); 
			System.out.println("No Component Found - CurrentCount: " + nextThymineID + " for parent: " + parentID);
			nextThymineID++;
			componentBase = "Thymine";
			newComponentID = DBUtils.convertID(nextThymineID, componentBase);				
			System.out.println("generateThymine() New Thymine ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.ThymineRef, Constants.ThymineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Thymine Transform Object
			newComponentID = riboseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.ThymineRef, Constants.ThymineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateThymine() - Thymine Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}

	/*******************************************************************************************
	 * GENERATE GUANINE
	 * 
	 * This method will create a representation of a Guanine in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateGuanine(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateGuanine : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// THYMINE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Guanine");
		String guanineID = DBUtils.getComponentID(bodyID, projectID, Constants.GuanineRef, parentID); 
		System.out.println("BioMightDNABean.generateGuanine() -  GuanineID: " + guanineID + " for parent: " + parentID);
		
		if (guanineID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextGuanineID = DBUtils.getComponentCount(bodyID, projectID, Constants.GuanineRef); 
			System.out.println("No Component Found - CurrentCount: " + nextGuanineID + " for parent: " + parentID);
			nextGuanineID++;
			componentBase = "Guanine";
			newComponentID = DBUtils.convertID(nextGuanineID, componentBase);				
			System.out.println("generateGuanine() New Guanine ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.GuanineRef, Constants.GuanineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Guanine Transform Object
			newComponentID = guanineID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.GuanineRef, Constants.GuanineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateGuanine() - Guanine Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}

 	/*******************************************************************************************
	 * GENERATE CYTOSINE
	 * 
	 * This method will create a representation of a Cytosine in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateCytosine(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateCytosine : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// THYMINE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Cytosine");
		String cytosineID = DBUtils.getComponentID(bodyID, projectID, Constants.CytosineRef, parentID); 
		System.out.println("BioMightDNABean.generateCytosine() -  CytosineID: " + cytosineID + " for parent: " + parentID);
		
		if (cytosineID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextCytosineID = DBUtils.getComponentCount(bodyID, projectID, Constants.CytosineRef); 
			System.out.println("No Component Found - CurrentCount: " + nextCytosineID + " for parent: " + parentID);
			nextCytosineID++;
			componentBase = "Cytosine";
			newComponentID = DBUtils.convertID(nextCytosineID, componentBase);				
			System.out.println("generateCytosine() New Cytosine ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CytosineRef, Constants.CytosineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Cytosine Transform Object
			newComponentID = cytosineID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CytosineRef, Constants.CytosineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateCytosine() - Cytosine Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}
 	

 	/*******************************************************************************************
	 * GENERATE CYTOSINE
	 * 
	 * This method will create a representation of a Cytosine in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateAdenine(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateAdenine : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// THYMINE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Adenine");
		String adenineID = DBUtils.getComponentID(bodyID, projectID, Constants.AdenineRef, parentID); 
		System.out.println("BioMightDNABean.generateAdenine() -  AdenineID: " + adenineID + " for parent: " + parentID);
		
		if (adenineID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextAdenineID = DBUtils.getComponentCount(bodyID, projectID, Constants.AdenineRef); 
			System.out.println("No Component Found - CurrentCount: " + nextAdenineID + " for parent: " + parentID);
			nextAdenineID++;
			componentBase = "Adenine";
			newComponentID = DBUtils.convertID(nextAdenineID, componentBase);				
			System.out.println("generateAdenine() New Adenine ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.AdenineRef, Constants.AdenineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Adenine Transform Object
			newComponentID = adenineID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.AdenineRef, Constants.AdenineRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateAdenine() - Adenine Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}
 	
 	/*******************************************************************************************
	 * GENERATE HYDROGEN
	 * 
	 * This method will create a representation of a Hydrogen in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateHydrogen(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateHydrogen : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Hydrogen is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Hydrogen");
		String hydrogenID = DBUtils.getComponentID(bodyID, projectID, Constants.HydrogenRef, parentID); 
		System.out.println("BioMightDNABean.generateHydrogen() -  HydrogenID: " + hydrogenID + " for parent: " + parentID);
		
		if (hydrogenID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextHydrogenID = DBUtils.getComponentCount(bodyID, projectID, Constants.HydrogenRef); 
			System.out.println("No Component Found - CurrentCount: " + nextHydrogenID + " for parent: " + parentID);
			nextHydrogenID++;
			componentBase = "Hydrogen";
			newComponentID = DBUtils.convertID(nextHydrogenID, componentBase);				
			System.out.println("generateHydrogen() New Hydrogen ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.HydrogenRef, Constants.HydrogenRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Hydrogen Transform Object
			newComponentID = hydrogenID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.HydrogenRef, Constants.HydrogenRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateHydrogen() - Hydrogen Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}
 	
 	

 	/*******************************************************************************************
	 * GENERATE OXYGEN
	 * 
	 * This method will create a representation of a Oxygen in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateOxygen(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateOxygen : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Oxygen is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Oxygen");
		String oxygenID = DBUtils.getComponentID(bodyID, projectID, Constants.OxygenRef, parentID); 
		System.out.println("BioMightDNABean.generateOxygen() -  OxygenID: " + oxygenID + " for parent: " + parentID);
		
		if (oxygenID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextOxygenID = DBUtils.getComponentCount(bodyID, projectID, Constants.OxygenRef); 
			System.out.println("No Component Found - CurrentCount: " + nextOxygenID + " for parent: " + parentID);
			nextOxygenID++;
			componentBase = "Oxygen";
			newComponentID = DBUtils.convertID(nextOxygenID, componentBase);				
			System.out.println("generateOxygen() New Oxygen ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.OxygenRef, Constants.OxygenRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Oxygen Transform Object
			newComponentID = oxygenID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.OxygenRef, Constants.OxygenRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateOxygen() - Oxygen Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}
 	
 	/*******************************************************************************************
	 * GENERATE PHOSPHATE
	 * 
	 * This method will create a representation of a Phosphate in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generatePhosphate(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generatePhosphate : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Phosphate is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Phosphate");
		String phosphateID = DBUtils.getComponentID(bodyID, projectID, Constants.PhosphateRef, parentID); 
		System.out.println("BioMightDNABean.generatePhosphate() -  PhosphateID: " + phosphateID + " for parent: " + parentID);
		
		if (phosphateID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextPhosphateID = DBUtils.getComponentCount(bodyID, projectID, Constants.PhosphateRef); 
			System.out.println("No Component Found - CurrentCount: " + nextPhosphateID + " for parent: " + parentID);
			nextPhosphateID++;
			componentBase = "Phosphate";
			newComponentID = DBUtils.convertID(nextPhosphateID, componentBase);				
			System.out.println("generatePhosphate() New Phosphate ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.PhosphateRef, Constants.PhosphateRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Phosphate Transform Object
			newComponentID = phosphateID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.PhosphateRef, Constants.PhosphateRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generatePhosphate() - Phosphate Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
		return returnCode;	
	}

 	/*******************************************************************************************
	 * GENERATE NUCLEOBASE
	 * 
	 * This method will create a representation of a Nucleobase in the data repository    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateNucleobase(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateNucleobase : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Nucleobase is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Nucleobase");
		String nucleobaseID = DBUtils.getComponentID(bodyID, projectID, Constants.NucleobaseRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleobase() -  NucleobaseID: " + nucleobaseID + " for parent: " + parentID);
		
		if (nucleobaseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextNucleobaseID = DBUtils.getComponentCount(bodyID, projectID, Constants.NucleobaseRef); 
			System.out.println("No Component Found - CurrentCount: " + nextNucleobaseID + " for parent: " + parentID);
			nextNucleobaseID++;
			componentBase = "Nucleobase";
			newComponentID = DBUtils.convertID(nextNucleobaseID, componentBase);				
			System.out.println("generateNucleobase() New Nucleobase ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleobaseRef, Constants.NucleobaseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Nucleobase Transform Object
			newComponentID = nucleobaseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleobaseRef, Constants.NucleobaseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleobase() - Nucleobase Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
		return returnCode;	
	}
 	
	/*******************************************************************************************
	 * GENERATE NUCLEOTIDE TEMP
	 * 
	 * This method will create a representation of a Nucleotide in the data repository
	 * It will set up the Ribose, Phosphate, and the Nitrogeneous Base that is
	 * specified in the input parameters.   
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	private int generateNucleotideTemp(String sNucleotide, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateNucleotide: " + startID);
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;
		int compGroup = 0;		
		vertices = "" ;
		boolean bFail = false;		

		
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Ribose is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Ribose");
		String riboseID = DBUtils.getComponentID(bodyID, projectID, Constants.RiboseRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  RiboseID: " + riboseID + " for parent: " + parentID);
		
		if (riboseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextRiboseID = DBUtils.getComponentCount(bodyID, projectID, Constants.RiboseRef); 
			System.out.println("No Component Found - CurrentCount: " + nextRiboseID + " for parent: " + parentID);
			nextRiboseID++;
			componentBase = "Ribose";
			newComponentID = DBUtils.convertID(nextRiboseID, componentBase);				
			System.out.println("generateNucleotide() New Ribose ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.RiboseRef, Constants.RiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Ribose Transform Object
			newComponentID = riboseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.RiboseRef, Constants.RiboseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleotide() - Ribose Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	

		// PHOSPHATE
		// See if this phophate is already set up on the database
		System.out.println("Checking for Phosphate");
		String phosphateID = DBUtils.getComponentID(bodyID, projectID, Constants.PhosphateRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  PhosphateID: " + phosphateID + " for parent: " + parentID);
		
		if (phosphateID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextPhosphateID = DBUtils.getComponentCount(bodyID, projectID, Constants.PhosphateRef); 
			System.out.println("No Component Found - CurrentCount: " + nextPhosphateID + " for parent: " + parentID);
			nextPhosphateID++;
			componentBase = "Phosphate";
			newComponentID = DBUtils.convertID(nextPhosphateID, componentBase);				
			System.out.println("generateNucleotide() New Phosphate ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.PhosphateRef, Constants.PhosphateRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Phosphate Transform Object
			newComponentID = phosphateID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.PhosphateRef, Constants.PhosphateRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleotide() - Phosphate Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}		

		// NUCLEOBASE
		// See if this Nuceobase is already set up in the database
		System.out.println("Checking for Nucleobase");
		String nucleobaseID = DBUtils.getComponentID(bodyID, projectID, Constants.NucleobaseRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  NucleobaseID: " + nucleobaseID + " for parent: " + parentID);
		
		if (nucleobaseID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextNucleobaseID = DBUtils.getComponentCount(bodyID, projectID, Constants.NucleobaseRef); 
			System.out.println("No Component Found - CurrentCount: " + nextNucleobaseID + " for parent: " + parentID);
			nextNucleobaseID++;
			componentBase = "Nucleobase";
			newComponentID = DBUtils.convertID(nextNucleobaseID, componentBase);				
			System.out.println("generateNucleotide() New Nucleobase ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleobaseRef, Constants.NucleobaseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Nucleobase Transform Object
			newComponentID = nucleobaseID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.NucleobaseRef, Constants.NucleobaseRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleotide() - Nucleobase Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}		
				
		return returnCode;	
	}

 	
 	/*******************************************************************************************
	 * GENERATE CARBON
	 * 
	 * This method will create a representation of a Carbon molecule    
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
 	public int generateCarbon(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		// We need the start position for the first molecule and we 
		// need the orientation so that we know how to align.
		
		System.out.println("In generateCarbon : " + startID);
		int bodyID = 1;
		int projectID = 1;
		double radius = 0.0825;
		
		// Vars for processing
  		int componentNum = 0;
		String componentBase = componentBase = startID.substring(0,startID.indexOf(":"));
			
		// Generate the Component ID
		String newComponentID = "";
		String query = "";
		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		int depthDirection = 0;
		double depth = 0.0825;	
	
	
		// Set up the Transform objects and then stuff them into the database
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		BioMightTransform bioMightTransform;
		BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);

		// RIBOSE
		// See if a Carbon is already set up on the nucleotide in the persistent store
		System.out.println("Checking for Carbon");
		String carbonID = DBUtils.getComponentID(bodyID, projectID, Constants.CarbonRef, parentID); 
		System.out.println("BioMightDNABean.generateNucleotide() -  CarbonID: " + carbonID + " for parent: " + parentID);
		
		if (carbonID.equals(""))
		{
			// The record does not exist so we need to create a new one
			// Generate the new Component ID by getting the next available element
			int nextCarbonID = DBUtils.getComponentCount(bodyID, projectID, Constants.CarbonRef); 
			System.out.println("No Component Found - CurrentCount: " + nextCarbonID + " for parent: " + parentID);
			nextCarbonID++;
			componentBase = "Carbon";
			newComponentID = DBUtils.convertID(nextCarbonID, componentBase);				
			System.out.println("generateNucleotide() New Carbon ComponentID: " + newComponentID);		
	
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CarbonRef, Constants.CarbonRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
			// Insert the element into the database
			DBUtils.insertComponent( bioMightTransform);				

		}
		else
		{
			// Setup the Carbon Transform Object
			newComponentID = carbonID;
			bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, Constants.CarbonRef, Constants.CarbonRef, componentID);
			bioMightTransform.setTranslation(bioMightPosition);

			System.out.println("BioMightDNABean.generateNucleotide() - Carbon Exists - Updating" + newComponentID);
			DBUtils.updateComponent(bioMightTransform); 			
		}
	
			
		return returnCode;	
	}
   	
}
