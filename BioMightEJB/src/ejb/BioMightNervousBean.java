package biomight.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.ejb.Stateless;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;

/**
 * Session Bean implementation class BioMightNervousBean
 */
@Stateless
public class BioMightNervousBean implements BioMightNervousBeanLocal {
	private static final int ROTATE  = 1;
	private static final int TRANSLATE  = 2;
	private static final int SCALE  = 3;
	
	
    /*************************************************************
     * Default constructor. 
     * 
     ************************************************************/
	
    public BioMightNervousBean() {
        // TODO Auto-generated constructor stub
    }
 
    
  	/***************************************************************************************
	 * GENERATE MAXILLARY NERVE
	 * 
	 * This generates the Maxillary Nerve
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateMaxillaryNerve(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateMaxilllaryNerve: " + componentID + "   " + parentID);
		
		int returnCode = 0;
		
		// We can generate the MaxilllaryNerve alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			// Create the octogon shaped object at the starting position
			double[] startPos = {0.0, -3.0, -3.0};
			double circumference = 0.125;		
    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);   			
        	}
    		
 	
    		else {
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for MaxilllaryNerve: " + componentID + "   " + componentType);
    		
		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE PUDENDAL NERVE
	 * 
	 * This generates the Pudendal Nerve
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePudendalNerve(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GeneratePudendalNerve: " + componentID + "   " + parentID);
		
		int returnCode = 0;
		
		// We can generate the PudendalNerve alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			// Create the octogon shaped object at the starting position
			double[] startPos = {0.0, -3.0, -3.0};
			double circumference = 0.125;		
    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);   			
        	}
    		
 	
    		else {
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for PudendalNerve: " + componentID + "   " + componentType);
    		
		return returnCode;
	}


	/***************************************************************************************
	 * GENERATE OPTIC NERVE
	 * 
	 * This generates the Pudendal Nerve
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateOpticNerve(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateOpticNerve: " + componentID + "   " + parentID);
		
		int returnCode = 0;
		
		// We can generate the OpticNerve alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			// Create the octogon shaped object at the starting position
			double[] startPos = {0.0, -3.0, -1.0};
			double circumference = 0.125;		
    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 2;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);   			
        	}
    		
 	
    		else {
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for OpticNerve: " + componentID + "   " + componentType);
    		
		return returnCode;
	}


	/***************************************************************************************
	 * GENERATE VAGUS NERVE
	 * 
	 * This generates the Vagus Nerve
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateVagusNerve(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateVagusNerve: " + componentID + "   " + parentID);
		
		int returnCode = 0;
		
		// We can generate the VagusNerve alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			// Create the octogon shaped object at the starting position
			double[] startPos = {0.0, -3.0, -3.0};
			double circumference = 0.125;		
    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);   			
        	}
    		
 	
    		else {
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for VagusNerve: " + componentID + "   " + componentType);
    		
		return returnCode;
	}


	/***************************************************************************************
	 * GENERATE VIDIAN NERVE
	 * 
	 * This generates the Vidian Nerve
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateVidianNerve(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateVidianNerve: " + componentID + "   " + parentID);
		
		int returnCode = 0;
		
		// We can generate the VidianNerve alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			// Create the octogon shaped object at the starting position
			double[] startPos = {0.0, -3.0, -3.0};
			double circumference = 0.125;		
    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);   			
        	}
    		
 	
    		else {
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for VidianNerve: " + componentID + "   " + componentType);
    		
		return returnCode;
	}

	

	
	

	/***************************************************************************************
	 * GENERATE NODOSE GANGLION 
	 * 
	 * This generates the NodoseGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateNodoseGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat NodoseGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the NodoseGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("NodoseGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("NodoseGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the NodoseGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for NodoseGanglionNerveTissuE: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MYENTERIC PLEXUS 
	 * 
	 * This generates the MyentericPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMyentericPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MyentericPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MyentericPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MyentericPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MyentericPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MyentericPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MyentericPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUB MUCOSAL PLEXUS 
	 * 
	 * This generates the SubMucosalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSubMucosalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SubMucosalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SubMucosalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SubMucosalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SubMucosalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SubMucosalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SubMucosalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ALVEOLAR INFERIOR  
	 * 
	 * This generates the AlveolarInferior Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAlveolarInferiorNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AlveolarInferiorNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AlveolarInferiorNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AlveolarInferiorNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AlveolarInferiorNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AlveolarInferiorNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AlveolarInferiorNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ALVEOLAR SUPERIOR  
	 * 
	 * This generates the AlveolarSuperior Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAlveolarSuperior(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AlveolarSuperior");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AlveolarSuperior	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AlveolarSuperior:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AlveolarSuperior:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AlveolarSuperior	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AlveolarSuperiorNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AORTI CORENAL GANGLION  
	 * 
	 * This generates the AortiCorenalGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAortiCorenalGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AortiCorenalGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AortiCorenalGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AortiCorenalGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AortiCorenalGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AortiCorenalGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AortiCorenalGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AORTICOR RENAL GANGLION  
	 * 
	 * This generates the AorticorRenalGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAorticorRenalGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AorticorRenalGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AorticorRenalGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AorticorRenalGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AorticorRenalGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AorticorRenalGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AorticorRenalGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AORTIC PLEXUS  
	 * 
	 * This generates the AorticPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAorticPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AorticPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AorticPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AorticPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AorticPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AorticPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AorticPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AURICULO TEMPORAL  
	 * 
	 * This generates the AuriculoTemporal Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAuriculoTemporal(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AuriculoTemporal");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AuriculoTemporal	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AuriculoTemporal:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AuriculoTemporal:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AuriculoTemporal	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AuriculoTemporalNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CARDIAC PLEXUS  
	 * 
	 * This generates the CardiacPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCardiacPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CardiacPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CardiacPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CardiacPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CardiacPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CardiacPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CardiacPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CELIAC GANGLION  
	 * 
	 * This generates the CeliacGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCeliacGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CeliacGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CeliacGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CeliacGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CeliacGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CeliacGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CeliacGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CELIAC PLEXUS  
	 * 
	 * This generates the CeliacPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCeliacPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CeliacPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CeliacPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CeliacPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CeliacPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CeliacPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CeliacPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DIAPHRAGMATIC GANGLIION  
	 * 
	 * This generates the DiaphragmaticGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDiaphragmaticGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DiaphragmaticGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DiaphragmaticGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DiaphragmaticGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DiaphragmaticGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DiaphragmaticGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DiaphragmaticGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GANGLIA  
	 * 
	 * This generates the Ganglia Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGanglia(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Ganglia");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Ganglia	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Ganglia:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Ganglia:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Ganglia	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GangliaNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GASTRIC PLEXUS  
	 * 
	 * This generates the GastricPlexis Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGastricPlexis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GastricPlexis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GastricPlexis	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GastricPlexis:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GastricPlexis:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GastricPlexis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GastricPlexisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INFERIOR CERVICAL GANGLION  
	 * 
	 * This generates the InferiorCervicalGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInferiorCervicalGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InferiorCervicalGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InferiorCervicalGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InferiorCervicalGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InferiorCervicalGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InferiorCervicalGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InferiorCervicalGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INFERIOR MESENTERIC GANGLION  
	 * 
	 * This generates the InferiorMesentericGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInferiorMesentericGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InferiorMesentericGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InferiorMesentericGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InferiorMesentericGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InferiorMesentericGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InferiorMesentericGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InferiorMesentericGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LOWEST THORACIC GANGLION 
	 * 
	 * This generates the LowestThoracicGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLowestThoracicGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LowestThoracicGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LowestThoracicGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LowestThoracicGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LowestThoracicGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LowestThoracicGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LowestThoracicGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LUMBAR GANGLIA 
	 * 
	 * This generates the LumbarGanglia Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLumbarGanglia(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LumbarGanglia");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LumbarGanglia	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LumbarGanglia:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LumbarGanglia:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LumbarGanglia	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LumbarGangliaNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MAXILLARY 
	 * 
	 * This generates the Maxillary Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMaxillary(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Maxillary");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Maxillary	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Maxillary:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Maxillary:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Maxillary	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MaxillaryNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE NEUROBLAST 
	 * 
	 * This generates the Neuroblasts Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateNeuroblasts(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Neuroblasts");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Neuroblasts	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Neuroblasts:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Neuroblasts:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Neuroblasts	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for NeuroblastsNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHRENIC GANGLION 
	 * 
	 * This generates the PhrenicGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhrenicGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PhrenicGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PhrenicGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PhrenicGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PhrenicGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PhrenicGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PhrenicGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PLEXUS 
	 * 
	 * This generates the Plexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Plexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Plexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Plexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Plexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Plexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PULDENAL NERVE
	 * 
	 * This generates the PudendalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePudendal(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PudendalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PudendalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PudendalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PudendalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PudendalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PudendalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RECURRENT LARYNGEAL NERVE
	 * 
	 * This generates the RecurrentLaryngealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRecurrentLaryngeal(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat RecurrentLaryngealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the RecurrentLaryngealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("RecurrentLaryngealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RecurrentLaryngealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the RecurrentLaryngealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for RecurrentLaryngealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SCIATIC NERVE
	 * 
	 * This generates the SciaticNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSciaticNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SciaticNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SciaticNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SciaticNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SciaticNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SciaticNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SciaticNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SOMATIC MOTOR FIBERS 
	 * 
	 * This generates the SomaticMotorFibers Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSomaticMotorFibers(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SomaticMotorFibers");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SomaticMotorFibers	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SomaticMotorFibers:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SomaticMotorFibers:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SomaticMotorFibers	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SomaticMotorFibersNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SPINAL ACCESSORY 
	 * 
	 * This generates the SpinalAccessory Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSpinalAccessory(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SpinalAccessory");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SpinalAccessory	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SpinalAccessory:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SpinalAccessory:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SpinalAccessory	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SpinalAccessoryNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SPONGIOBLAST 
	 * 
	 * This generates the Spongioblasts Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSpongioblasts(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Spongioblasts");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Spongioblasts	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Spongioblasts:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Spongioblasts:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Spongioblasts	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SpongioblastsNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERIOR GANGLION 
	 * 
	 * This generates the SuperiorGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERIOR LARYNGEAL NERVE 
	 * 
	 * This generates the SuperiorLaryngealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorLaryngealNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorLaryngealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorLaryngealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorLaryngealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorLaryngealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorLaryngealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorLaryngealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SYMPATHETIC EFFERENT FIBERS 
	 * 
	 * This generates the SympatheticEfferentFibers Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSympatheticEfferentFibers(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SympatheticEfferentFibers");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SympatheticEfferentFibers	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SympatheticEfferentFibers:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SympatheticEfferentFibers:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SympatheticEfferentFibers	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SympatheticEfferentFibersNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SYMPATHETIC TRUNK 
	 * 
	 * This generates the SympatheticTrunk Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSympatheticTrunk(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SympatheticTrunk");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SympatheticTrunk	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SympatheticTrunk:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SympatheticTrunk:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SympatheticTrunk	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SympatheticTrunkNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE UPPER LUMBAR GANGLION 
	 * 
	 * This generates the UpperLumbarGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUpperLumbarGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UpperLumbarGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UpperLumbarGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UpperLumbarGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UpperLumbarGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UpperLumbarGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UpperLumbarGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE UPPER SACRAL GANGLION 
	 * 
	 * This generates the UpperSacralGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUpperSacralGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UpperSacralGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UpperSacralGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UpperSacralGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UpperSacralGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UpperSacralGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UpperSacralGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	

	/***************************************************************************************
	 * GENERATE BRACHIAL PLEXUS 
	 * 
	 * This generates the BrachialPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateBrachialPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat BrachialPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the BrachialPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("BrachialPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("BrachialPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the BrachialPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for BrachialPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DORSAL SCALPULAR NERVE 
	 * 
	 * This generates the DorsalScapularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDorsalScapularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DorsalScapularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DorsalScapularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DorsalScapularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DorsalScapularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DorsalScapularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DorsalScapularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LONG THORACIC NERVE 
	 * 
	 * This generates the LongThoracicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLongThoracicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LongThoracicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LongThoracicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LongThoracicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LongThoracicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LongThoracicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LongThoracicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPRA SCAPULAR NERVE
	 * 
	 * This generates the SupraScapularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSupraScapularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SupraScapularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SupraScapularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SupraScapularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SupraScapularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SupraScapularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SupraScapularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL CORD
	 * 
	 * This generates the LateralCord Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralCord(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralCord");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralCord	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralCord:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralCord:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralCord	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralCordNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	

	
	/***************************************************************************************
	 * GENERATE LATERAL PECTORAL NERVE
	 * 
	 * This generates the LateralPectoralNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralPectoralNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralPectoralNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralPectoralNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralPectoralNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralPectoralNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralCord	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralPectoralNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MUSCLO CUTANEOUS NERVE
	 * 
	 * This generates the MusculoCutaneousNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMusculoCutaneousNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MusculoCutaneousNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MusculoCutaneousNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MusculoCutaneousNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MusculoCutaneousNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MusculoCutaneousNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MusculoCutaneousNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL ANTE BRANCHIAL CUTANEOUS NERVE
	 * 
	 * This generates the MedialAnteBrachialCutaneousNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialAnteBrachialCutaneousNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialAnteBrachialCutaneousNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialAnteBrachialCutaneousNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialAnteBrachialCutaneousNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialAnteBrachialCutaneousNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialAnteBrachialCutaneousNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialAnteBrachialCutaneousNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL BRANCHIAL CUTANEOUS NERVE
	 * 
	 * This generates the MedialBrachialCutaneousNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialBrachialCutaneousNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialBrachialCutaneousNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialBrachialCutaneousNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialBrachialCutaneousNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialBrachialCutaneousNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialBrachialCutaneousNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialBrachialCutaneousNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL CORD 
	 * 
	 * This generates the MedialCord Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialCord(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialCord");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialCord	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialCord:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialCord:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialCord	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialCordNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL NERVE 
	 * 
	 * This generates the MedianNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedianNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedianNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedianNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedianNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedianNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedianNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedianNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL PECTORAL NERVE 
	 * 
	 * This generates the MedianPectoralNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedianPectoralNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedianPectoralNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedianPectoralNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedianPectoralNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedianPectoralNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedianPectoralNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedianPectoralNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ULNAR NERVE 
	 * 
	 * This generates the UlnarNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUlnarNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UlnarNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UlnarNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UlnarNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UlnarNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UlnarNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UlnarNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AXILLARY NERVE 
	 * 
	 * This generates the AxillaryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAxillaryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AxillaryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AxillaryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AxillaryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AxillaryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AxillaryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AxillaryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LOWER SUB SCAPULAR NERVE 
	 * 
	 * This generates the LowerSubScapularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLowerSubScapularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LowerSubScapularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LowerSubScapularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LowerSubScapularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LowerSubScapularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LowerSubScapularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LowerSubScapularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR CORD NERVE 
	 * 
	 * This generates the PosteriorCord Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePosteriorCord(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PosteriorCord");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PosteriorCord	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorCord:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PosteriorCord:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PosteriorCord	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PosteriorCordNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RADIAL NERVE 
	 * 
	 * This generates the RadialNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRadialNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat RadialNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the RadialNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("RadialNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RadialNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the RadialNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for RadialNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE THORACODORSAL NERVE 
	 * 
	 * This generates the ThoracodorsalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateThoracodorsalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ThoracodorsalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ThoracodorsalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ThoracodorsalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ThoracodorsalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ThoracodorsalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ThoracodorsalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE UPPER SUBSCAPULAR NERVE 
	 * 
	 * This generates the UpperSubscapularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUpperSubscapularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UpperSubscapularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UpperSubscapularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UpperSubscapularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UpperSubscapularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UpperSubscapularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UpperSubscapularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE UPPER ANTERIOR CORONARY PLEXUS 
	 * 
	 * This generates the AnteriorCoronaryPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAnteriorCoronaryPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AnteriorCoronaryPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AnteriorCoronaryPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorCoronaryPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AnteriorCoronaryPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AnteriorCoronaryPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AnteriorCoronaryPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CARDIAC GANGLOIN OF WRISBERG 
	 * 
	 * This generates the CardiacGangloinOfWrisberg Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCardiacGangloinOfWrisberg(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CardiacGangloinOfWrisberg");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CardiacGangloinOfWrisberg	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CardiacGangloinOfWrisberg:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CardiacGangloinOfWrisberg:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CardiacGangloinOfWrisberg	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CardiacGangloinOfWrisbergNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR CORONARY PLEXUS
	 * 
	 * This generates the PosteriorCoronaryPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePosteriorCoronaryPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PosteriorCoronaryPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PosteriorCoronaryPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorCoronaryPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PosteriorCoronaryPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PosteriorCoronaryPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PosteriorCoronaryPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ABDOMINAL AORTIC PLEXUS
	 * 
	 * This generates the AbdominalAorticPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAbdominalAorticPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AbdominalAorticPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AbdominalAorticPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AbdominalAorticPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AbdominalAorticPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AbdominalAorticPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AbdominalAorticPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CELIAC GANGLIA
	 * 
	 * This generates the CeliacGanglia Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCeliacGanglia(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CeliacGanglia");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CeliacGanglia	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CeliacGanglia:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CeliacGanglia:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CeliacGanglia	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CeliacGangliaNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE HEPATIC PLEXUS
	 * 
	 * This generates the HepaticPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateHepaticPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat HepaticPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the HepaticPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("HepaticPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("HepaticPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the HepaticPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for HepaticPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	


	
	/***************************************************************************************
	 * GENERATE INFERIOR MESENTERIC PLEXUS 
	 * 
	 * This generates the InferiorMesentericPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInferiorMesentericPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InferiorMesentericPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InferiorMesentericPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InferiorMesentericPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InferiorMesentericPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InferiorMesentericPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InferiorMesentericPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LINEAL PLEXUS 
	 * 
	 * This generates the LinealPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLinealPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LinealPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LinealPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LinealPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LinealPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LinealPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LinealPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHRENIC PLEXUS 
	 * 
	 * This generates the PhrenicPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhrenicPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PhrenicPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PhrenicPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PhrenicPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PhrenicPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PhrenicPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PhrenicPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RENAL PLEXUS 
	 * 
	 * This generates the RenalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRenalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat RenalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the RenalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("RenalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RenalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the RenalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for RenalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SIGMOID PLEXUS 
	 * 
	 * This generates the SigmoidPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSigmoidPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SigmoidPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SigmoidPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SigmoidPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SigmoidPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SigmoidPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SigmoidPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	

	/***************************************************************************************
	 * GENERATE SPERMATIC PLEXUS 
	 * 
	 * This generates the SpermaticPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSpermaticPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SpermaticPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SpermaticPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SpermaticPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SpermaticPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SpermaticPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SpermaticPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SURPERIOR GASTRIC PLEXUS 
	 * 
	 * This generates the SuperiorGastricPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorGastricPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorGastricPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorGastricPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorGastricPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorGastricPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorGastricPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorGastricPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SURPERIOR HEMORRHOIDAL PLEXUS 
	 * 
	 * This generates the SuperiorHemorrhoidalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorHemorrhoidalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorHemorrhoidalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorHemorrhoidalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorHemorrhoidalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorHemorrhoidalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorHemorrhoidalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorHemorrhoidalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SURPERIOR MESENTRIC PLEXUS 
	 * 
	 * This generates the SuperiorMesentericPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorMesentericPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorMesentericPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorMesentericPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorMesentericPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorMesentericPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorMesentericPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorMesentericPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPRARENAL PLEXUS 
	 * 
	 * This generates the SuprarenalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuprarenalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuprarenalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuprarenalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuprarenalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuprarenalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuprarenalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuprarenalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GREAT AURICULAR NERVE 
	 * 
	 * This generates the GreatAuricularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGreatAuricularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GreatAuricularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuprarenalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GreatAuricularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GreatAuricularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GreatAuricularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GreatAuricularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GREAT OCCIPITAL NERVE 
	 * 
	 * This generates the GreatOccipitalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGreatOccipitalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GreatOccipitalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GreatOccipitalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GreatOccipitalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GreatOccipitalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GreatOccipitalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GreatOccipitalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LESSER OCCIPITAL NERVE 
	 * 
	 * This generates the LesserOccipitalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLesserOccipitalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LesserOccipitalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LesserOccipitalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LesserOccipitalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LesserOccipitalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LesserOccipitalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LesserOccipitalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHRENIC NERVE 
	 * 
	 * This generates the PhrenicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhrenicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PhrenicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PhrenicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PhrenicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PhrenicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PhrenicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PhrenicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHRENIC NERVES 
	 * 
	 * This generates the PhrenicNerves Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhrenicNerves(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PhrenicNerves");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PhrenicNerves	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PhrenicNerves:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PhrenicNerves:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PhrenicNerves	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PhrenicNervesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR AURICULAR NERVE 
	 * 
	 * This generates the PosteriorAuricularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePosteriorAuricularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PosteriorAuricularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PosteriorAuricularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorAuricularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PosteriorAuricularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PosteriorAuricularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PosteriorAuricularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUB OCCIPITAL NERVE 
	 * 
	 * This generates the SubOccipitalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSubOccipitalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SubOccipitalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SubOccipitalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SubOccipitalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SubOccipitalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SubOccipitalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SubOccipitalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ABDUCENT NERVE
	 * 
	 * This generates the AbducentNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAbducentNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AbducentNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AbducentNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AbducentNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AbducentNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AbducentNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AbducentNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ACCESSORY NERVE
	 * 
	 * This generates the AccessoryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAccessoryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AccessoryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AccessoryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AccessoryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AccessoryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AccessoryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AccessoryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ACUSTIC NERVE
	 * 
	 * This generates the AcousticNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAcousticNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AcousticNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AcousticNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AcousticNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AcousticNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AcousticNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AcousticNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE FACIAL NERVE
	 * 
	 * This generates the FacialNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFacialNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat FacialNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the FacialNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("FacialNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("FacialNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the FacialNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for FacialNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GLOSSEPHARYNGEAL NERVE
	 * 
	 * This generates the GlossopharyngealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGlossopharyngealNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GlossopharyngealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GlossopharyngealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GlossopharyngealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GlossopharyngealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GlossopharyngealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GlossopharyngealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE HYPOGLOSSAL NERVE
	 * 
	 * This generates the HypoglossalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateHypoglossalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat HypoglossalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the HypoglossalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("HypoglossalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("HypoglossalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the HypoglossalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for HypoglossalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE OCULOMOTOR NERVE
	 * 
	 * This generates the OculomotorNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateOculomotorNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat OculomotorNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the OculomotorNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("OculomotorNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("OculomotorNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the OculomotorNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for OculomotorNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE OLFACTORY NERVE NERVE
	 * 
	 * This generates the OlfactoryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateOlfactoryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat OlfactoryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the OlfactoryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("OlfactoryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("OlfactoryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the OlfactoryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for OlfactoryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TRIGEMINAL NERVE
	 * 
	 * This generates the TrigeminalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrigeminalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat TrigeminalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the TrigeminalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("TrigeminalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrigeminalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the TrigeminalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for TrigeminalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TROCHLEAR NERVE
	 * 
	 * This generates the TrochlearNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochlearNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat TrochlearNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the TrochlearNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("TrochlearNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrochlearNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the TrochlearNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for TrochlearNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL PLANTAR NERVE
	 * 
	 * This generates the LateralPlantarNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralPlantarNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralPlantarNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralPlantarNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralPlantarNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralPlantarNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralPlantarNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralPlantarNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDICAL PLANTAR NERVE
	 * 
	 * This generates the MedialPlantarNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialPlantarNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialPlantarNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialPlantarNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialPlantarNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialPlantarNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialPlantarNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialPlantarNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE BUCCAL NERVE
	 * 
	 * This generates the BuccalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateBuccalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat BuccalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the BuccalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("BuccalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("BuccalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the BuccalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for BuccalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CHORDA TYMPANI NERVE
	 * 
	 * This generates the ChordaTympaniNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateChordaTympaniNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ChordaTympaniNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ChordaTympaniNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ChordaTympaniNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ChordaTympaniNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ChordaTympaniNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ChordaTympaniNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LONG CILIARY NERVE
	 * 
	 * This generates the LongCiliaryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLongCiliaryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LongCiliaryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LongCiliaryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LongCiliaryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LongCiliaryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LongCiliaryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LongCiliaryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POPLITEAL FOSSAL NERVE
	 * 
	 * This generates the PoplitealFossaNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePoplitealFossaNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PoplitealFossaNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PoplitealFossaNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PoplitealFossaNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PoplitealFossaNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PoplitealFossaNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PoplitealFossaNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SHORT CILIARY NERVE
	 * 
	 * This generates the ShortCiliaryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateShortCiliaryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ShortCiliaryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ShortCiliaryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ShortCiliaryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ShortCiliaryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ShortCiliaryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ShortCiliaryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE AUDITORY NERVE
	 * 
	 * This generates the AuditoryNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAuditoryNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AuditoryNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AuditoryNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AuditoryNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AuditoryNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AuditoryNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AuditoryNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE COCHLEAR NERVE
	 * 
	 * This generates the CochlearNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCochlearNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CochlearNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CochlearNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CochlearNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CochlearNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CochlearNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CochlearNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VESTIBULAR NERVE
	 * 
	 * This generates the VestibularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateVestibularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat VestibularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the VestibularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("VestibularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("VestibularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the VestibularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for VestibularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE HYPOGASTRIC PLEXUS
	 * 
	 * This generates the HypogastricPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateHypogastricPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat HypogastricPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the HypogastricPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("HypogastricPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("HypogastricPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the HypogastricPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for HypogastricPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MIDDLE HEMORROIDAL PLEXUS
	 * 
	 * This generates the MiddleHemorrhoidalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMiddleHemorrhoidalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MiddleHemorrhoidalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MiddleHemorrhoidalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MiddleHemorrhoidalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MiddleHemorrhoidalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MiddleHemorrhoidalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MiddleHemorrhoidalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PELVIC PLEXUS
	 * 
	 * This generates the PelvicPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePelvicPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PelvicPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PelvicPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PelvicPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PelvicPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PelvicPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PelvicPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PROSTATIC PLEXUS
	 * 
	 * This generates the ProstaticPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateProstaticPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ProstaticPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ProstaticPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ProstaticPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ProstaticPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ProstaticPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ProstaticPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE UTERINE PLEXUS
	 * 
	 * This generates the UterinePlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUterinePlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UterinePlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UterinePlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UterinePlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UterinePlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UterinePlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UterinePlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VAGINAL PLEXUS
	 * 
	 * This generates the VaginalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateVaginalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat VaginalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the VaginalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("VaginalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("VaginalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the VaginalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for VaginalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VESICAL PLEXUS
	 * 
	 * This generates the VesicalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateVesicalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat VesicalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the VesicalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("VesicalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("VesicalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the VesicalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for VesicalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TIBIAL NERVE
	 * 
	 * This generates the TibialNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTibialNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat TibialNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the TibialNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("TibialNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TibialNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the TibialNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for TibialNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE FEMORAL NERVE
	 * 
	 * This generates the FemoralNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFemoralNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat FemoralNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the FemoralNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("FemoralNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("FemoralNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the FemoralNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for FemoralNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE OBTURATOR NERVE
	 * 
	 * This generates the ObturatorNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateObturatorNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ObturatorNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ObturatorNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ObturatorNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ObturatorNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ObturatorNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ObturatorNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERIOR GLUTEAL NERVE
	 * 
	 * This generates the SuperiorGlutealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorGlutealNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorGlutealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorGlutealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorGlutealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorGlutealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorGlutealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorGlutealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CERVICAL NERVE
	 * 
	 * This generates the CervicalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCervicalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CervicalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CervicalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CervicalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CervicalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CervicalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CervicalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERFICIAL CERVICAL NERVE
	 * 
	 * This generates the SuperficialCervicalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperficialCervicalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperficialCervicalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperficialCervicalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperficialCervicalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperficialCervicalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperficialCervicalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperficialCervicalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE COCCYGEAL NERVE
	 * 
	 * This generates the CoccygealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCoccygealNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CoccygealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CoccygealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CoccygealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CoccygealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CoccygealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CoccygealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GENITO FEMORAL NERVE
	 * 
	 * This generates the GenitoFemoralNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGenitoFemoralNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GenitoFemoralNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GenitoFemoralNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GenitoFemoralNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GenitoFemoralNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GenitoFemoralNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GenitoFemoralNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ILIO HYPO GASTRIC NERVE
	 * 
	 * This generates the IlioHypoGastricNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateIlioHypoGastricNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat IlioHypoGastricNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the IlioHypoGastricNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("IlioHypoGastricNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("IlioHypoGastricNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the IlioHypoGastricNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for IlioHypoGastricNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ILIOINGUINAL NERVE
	 * 
	 * This generates the IlioinguinalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateIlioinguinalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat IlioinguinalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the IlioinguinalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("IlioinguinalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("IlioinguinalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the IlioinguinalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for IlioinguinalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL FEMORAL CUTANEOUS NERVE
	 * 
	 * This generates the LateralFemoralCutaneousNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralFemoralCutaneousNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralFemoralCutaneousNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralFemoralCutaneousNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralFemoralCutaneousNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralFemoralCutaneousNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralFemoralCutaneousNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralFemoralCutaneousNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LUMBAR NERVE
	 * 
	 * This generates the LumbarNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLumbarNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LumbarNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LumbarNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LumbarNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LumbarNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LumbarNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LumbarNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LUMBAR PLEXIS
	 * 
	 * This generates the LumbarPlexis Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLumbarPlexis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LumbarPlexis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LumbarPlexis	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LumbarPlexis:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LumbarPlexis:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LumbarPlexis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LumbarPlexisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	/***************************************************************************************
	 * GENERATE ANTERIOR BRANCHES
	 * 
	 * This generates the AnteriorBranches Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAnteriorBranches(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AnteriorBranches");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AnteriorBranches	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorBranches:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AnteriorBranches:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AnteriorBranches	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AnteriorBranchesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GREATER SPLANCHNIC NERVE
	 * 
	 * This generates the GreaterSplanchnicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGreaterSplanchnicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GreaterSplanchnicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GreaterSplanchnicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GreaterSplanchnicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GreaterSplanchnicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GreaterSplanchnicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GreaterSplanchnicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INTER COSTAL NERVES
	 * 
	 * This generates the InterCostalNerves Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInterCostalNerves(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InterCostalNerves");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InterCostalNerves	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InterCostalNerves:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InterCostalNerves:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InterCostalNerves	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InterCostalNervesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INTER COSTAL BRANCHI NERVE
	 * 
	 * This generates the InterCostoBrachialNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInterCostoBrachialNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InterCostoBrachialNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InterCostoBrachialNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InterCostoBrachialNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InterCostoBrachialNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InterCostoBrachialNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InterCostoBrachialNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL CUTANEOUS BRANCHES
	 * 
	 * This generates the LateralCutaneousBranches Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralCutaneousBranches(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralCutaneousBranches");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralCutaneousBranches	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralCutaneousBranches:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralCutaneousBranches:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralCutaneousBranches	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralCutaneousBranchesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LESSER SPLANCHNIC NERVE
	 * 
	 * This generates the LesserSplanchnicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLesserSplanchnicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LesserSplanchnicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LesserSplanchnicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LesserSplanchnicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LesserSplanchnicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LesserSplanchnicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LesserSplanchnicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LOWEST SPLANCHNIC NERVE
	 * 
	 * This generates the LowestSplanchnicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLowestSplanchnicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LowestSplanchnicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LowestSplanchnicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LowestSplanchnicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LowestSplanchnicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LowestSplanchnicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LowestSplanchnicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR BRANCHES
	 * 
	 * This generates the PosteriorBranches Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePosteriorBranches(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PosteriorBranches");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PosteriorBranches	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorBranches:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PosteriorBranches:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PosteriorBranches	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PosteriorBranchesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RAMI CUTANEI LATERALES
	 * 
	 * This generates the RamiCutaneiLaterales Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRamiCutaneiLaterales(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat RamiCutaneiLaterales");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the RamiCutaneiLaterales	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("RamiCutaneiLaterales:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RamiCutaneiLaterales:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the RamiCutaneiLaterales	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for RamiCutaneiLateralesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE THORACIC NERVE
	 * 
	 * This generates the ThoracicNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateThoracicNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ThoracicNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ThoracicNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ThoracicNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ThoracicNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ThoracicNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ThoracicNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE THORACICO ABDOMINAL INTERCOSTAL NERVES
	 * 
	 * This generates the ThoracicoAbdominalIntercostalNerves Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateThoracicoAbdominalIntercostalNerves(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ThoracicoAbdominalIntercostalNerves");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ThoracicoAbdominalIntercostalNerves	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ThoracicoAbdominalIntercostalNerves:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ThoracicoAbdominalIntercostalNerves:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ThoracicoAbdominalIntercostalNerves	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ThoracicoAbdominalIntercostalNervesNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAROTICOTYMPANIC
	 * 
	 * This generates the Caroticotympanic Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCaroticotympanic(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Caroticotympanic");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Caroticotympanic	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Caroticotympanic:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Caroticotympanic:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Caroticotympanic	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CaroticotympanicNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAROTID INTERNAL NERVE
	 * 
	 * This generates the CarotidInternalNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCarotidInternalNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CarotidInternalNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CarotidInternalNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CarotidInternalNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CarotidInternalNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CarotidInternalNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CarotidInternalNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAROTID INTERNAL PLEXUS
	 * 
	 * This generates the CarotidInternalPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCarotidInternalPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CarotidInternalPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CarotidInternalPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CarotidInternalPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CarotidInternalPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CarotidInternalPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CarotidInternalPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAVERNOUS PLEXUS
	 * 
	 * This generates the CavernousPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCavernousPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CavernousPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CavernousPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CavernousPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CavernousPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CavernousPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CavernousPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DEEP PETROSAL 
	 * 
	 * This generates the DeepPetrosal Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDeepPetrosal(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DeepPetrosal");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DeepPetrosal	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DeepPetrosal:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DeepPetrosal:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DeepPetrosal	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DeepPetrosalNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ANTERIOR BRANCH 
	 * 
	 * This generates the AnteriorBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAnteriorBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat AnteriorBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the AnteriorBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("AnteriorBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the AnteriorBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for AnteriorBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CARDIAC INFERIOR NERVE 
	 * 
	 * This generates the CardiacInferiorNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCardiacInferiorNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CardiacInferiorNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CardiacInferiorNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CardiacInferiorNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CardiacInferiorNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CardiacInferiorNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CardiacInferiorNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CARDIAC SUPERIOR NERVE 
	 * 
	 * This generates the CardiacSuperiorNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCardiacSuperiorNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CardiacSuperiorNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CardiacSuperiorNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CardiacSuperiorNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CardiacSuperiorNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CardiacSuperiorNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CardiacSuperiorNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INFERIOR BRANCH 
	 * 
	 * This generates the InferiorBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateInferiorBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat InferiorBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the InferiorBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("InferiorBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("InferiorBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the InferiorBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for InferiorBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE JUGULAR NERVE 
	 * 
	 * This generates the JugularNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateJugularNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat JugularNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the JugularNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("JugularNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("JugularNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the JugularNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for JugularNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LARYNGOPHARYNGEAL BRANCH 
	 * 
	 * This generates the LaryngopharyngealBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLaryngopharyngealBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LaryngopharyngealBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LaryngopharyngealBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LaryngopharyngealBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LaryngopharyngealBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LaryngopharyngealBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LaryngopharyngealBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL BRANCH 
	 * 
	 * This generates the LateralBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL BRANCH 
	 * 
	 * This generates the MedialBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHARYNGEAL PLEXUS 
	 * 
	 * This generates the PharyngealPlexus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePharyngealPlexus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PharyngealPlexus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PharyngealPlexus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PharyngealPlexus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PharyngealPlexus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PharyngealPlexus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PharyngealPlexusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GLOSSO PHARYNGEAL NERVE 
	 * 
	 * This generates the GlossoPharyngealNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGlossoPharyngealNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat GlossoPharyngealNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the GlossoPharyngealNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("GlossoPharyngealNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("GlossoPharyngealNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the GlossoPharyngealNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for GlossoPharyngealNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DEEP BRANCH OF RADIAL 
	 * 
	 * This generates the DeepBranchOfRadial Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDeepBranchOfRadial(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DeepBranchOfRadial");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DeepBranchOfRadial	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DeepBranchOfRadial:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DeepBranchOfRadial:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DeepBranchOfRadial	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DeepBranchOfRadialNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DORSAL BRANCH 
	 * 
	 * This generates the DorsalBranch Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDorsalBranch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DorsalBranch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DorsalBranch	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DorsalBranch:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DorsalBranch:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DorsalBranch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DorsalBranchNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL ANTERIOR THORACIC 
	 * 
	 * This generates the LateralAnteriorThoracic Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralAnteriorThoracic(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat LateralAnteriorThoracic");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the LateralAnteriorThoracic	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("LateralAnteriorThoracic:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralAnteriorThoracic:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralAnteriorThoracic	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for LateralAnteriorThoracicNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL ANTERIOR THORACIC 
	 * 
	 * This generates the MedialAnteriorThoracic Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialAnteriorThoracic(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedialAnteriorThoracic");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedialAnteriorThoracic	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedialAnteriorThoracic:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedialAnteriorThoracic:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedialAnteriorThoracic	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedialAnteriorThoracicNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERFICIAL BRANCH OF RADIAL 
	 * 
	 * This generates the SuperficialBranchOfRadial Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperficialBranchOfRadial(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperficialBranchOfRadial");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperficialBranchOfRadial	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperficialBranchOfRadial:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperficialBranchOfRadial:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperficialBranchOfRadial	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperficialBranchOfRadialNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ULNA NERVE 
	 * 
	 * This generates the UlnaNerve Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUlnaNerve(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat UlnaNerve");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the UlnaNerve	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("UlnaNerve:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UlnaNerve:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the UlnaNerve	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for UlnaNerveNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VOLAR INTEROSSEOUS 
	 * 
	 * This generates the VolarInterosseous Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateVolarInterosseous(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat VolarInterosseous");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the VolarInterosseous	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("VolarInterosseous:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("VolarInterosseous:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the VolarInterosseous	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for VolarInterosseousNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ARCHNOID SPINAL SHEATH 
	 * 
	 * This generates the ArachnoidSpinalSheath Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateArachnoidSpinalSheath(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ArachnoidSpinalSheath");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ArachnoidSpinalSheath	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ArachnoidSpinalSheath:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ArachnoidSpinalSheath:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ArachnoidSpinalSheath	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ArachnoidSpinalSheathNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAUDA EQUINA 
	 * 
	 * This generates the CaudaEquina Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCaudaEquina(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CaudaEquina");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CaudaEquina	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CaudaEquina:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CaudaEquina:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CaudaEquina	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CaudaEquinaNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CONUD MEDULLARIS 
	 * 
	 * This generates the ConusMedullaris Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateConusMedullaris(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ConusMedullaris");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ConusMedullaris	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ConusMedullaris:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ConusMedullaris:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ConusMedullaris	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ConusMedullarisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE COSTA FOVEA 
	 * 
	 * This generates the CostaFovea Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCostaFovea(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat CostaFovea");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the CostaFovea	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("CostaFovea:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CostaFovea:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the CostaFovea	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for CostaFoveaNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DURA MATER SPINAL SHEATH 
	 * 
	 * This generates the DuraMaterSpinalSheath Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDuraMaterSpinalSheath(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat DuraMaterSpinalSheath");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the DuraMaterSpinalSheath	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("DuraMaterSpinalSheath:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DuraMaterSpinalSheath:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the DuraMaterSpinalSheath	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for DuraMaterSpinalSheathNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE FILUM TERMINALE EXTERNUM 
	 * 
	 * This generates the FilumTerminaleExternum Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFilumTerminaleExternum(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat FilumTerminaleExternum");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the FilumTerminaleExternum	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("FilumTerminaleExternum:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("FilumTerminaleExternum:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the FilumTerminaleExternum	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for FilumTerminaleExternumNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE FILUM TERMINALE INTERNUM 
	 * 
	 * This generates the FilumTerminaleInternum Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFilumTerminaleInternum(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat FilumTerminaleInternum");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the FilumTerminaleInternum	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("FilumTerminaleInternum:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("FilumTerminaleInternum:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the FilumTerminaleInternum	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for FilumTerminaleInternumNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE FORAMEN TRANSVERSIUM 
	 * 
	 * This generates the ForamenTransversium Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateForamenTransversium(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat ForamenTransversium");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the ForamenTransversium	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("ForamenTransversium:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ForamenTransversium:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the ForamenTransversium	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for ForamenTransversiumNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS 
	 * 
	 * This generates the MedullaSpinalis Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalis	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalis:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalis:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS ANTERIOR FUNICULUS 
	 * 
	 * This generates the MedullaSpinalisAnteriorFuniculus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisAnteriorFuniculus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisAnteriorFuniculus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisAnteriorFuniculus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisAnteriorFuniculus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisAnteriorFuniculus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisAnteriorFuniculus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisAnteriorFuniculusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS ANTERIOR MEDIAN FISSURE 
	 * 
	 * This generates the MedullaSpinalisAnteriorMedianFissure Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisAnteriorMedianFissure(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisAnteriorMedianFissure");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisAnteriorMedianFissure	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisAnteriorMedianFissure:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisAnteriorMedianFissure:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisAnteriorMedianFissure	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisAnteriorMedianFissureNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS ARACHNOID CAVITY 
	 * 
	 * This generates the MedullaSpinalisArachnoidCavity Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisArachnoidCavity(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisArachnoidCavity");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisArachnoidCavity	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisArachnoidCavity:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisArachnoidCavity:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisArachnoidCavity	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisArachnoidCavityNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS CERVICAL ENLARGEMENT 
	 * 
	 * This generates the MedullaSpinalisCervicalEnlargement Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisCervicalEnlargement(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisCervicalEnlargement");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisCervicalEnlargement	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisCervicalEnlargement:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisCervicalEnlargement:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisCervicalEnlargement	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisCervicalEnlargementNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS EPIDURAL CAVITY 
	 * 
	 * This generates the MedullaSpinalisEpiduralCavity Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisEpiduralCavity(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisEpiduralCavity");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisEpiduralCavity	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisEpiduralCavity:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisEpiduralCavity:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisEpiduralCavity	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisEpiduralCavityNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS FASCICULUS CUNEATUS 
	 * 
	 * This generates the MedullaSpinalisFasciculusCuneatus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisFasciculusCuneatus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisFasciculusCuneatus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisFasciculusCuneatus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisFasciculusCuneatus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisFasciculusCuneatus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisFasciculusCuneatus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisFasciculusCuneatusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS FASCICULUS GRACILIS
	 * 
	 * This generates the MedullaSpinalisFasciculusGracilis Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisFasciculusGracilis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisFasciculusGracilis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisFasciculusCuneatus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisFasciculusGracilis:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisFasciculusGracilis:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisFasciculusGracilis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisFasciculusGracilisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS LATERAL FUNICULUS
	 * 
	 * This generates the MedullaSpinalisLateralFuniculus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisLateralFuniculus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisLateralFuniculus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisLateralFuniculus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisLateralFuniculus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisLateralFuniculus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisLateralFuniculus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisLateralFuniculusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS LUMBER ENLARGEMENT
	 * 
	 * This generates the MedullaSpinalisLumbarEnlargement Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisLumbarEnlargement(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisLumbarEnlargement");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisLumbarEnlargement	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisLumbarEnlargement:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisLumbarEnlargement:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisLumbarEnlargement	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisLumbarEnlargementNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS POSERIOR FUNICULUS
	 * 
	 * This generates the MedullaSpinalisPosteriorFuniculus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisPosteriorFuniculus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisPosteriorFuniculus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisPosteriorFuniculus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisPosteriorFuniculus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisPosteriorFuniculus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisPosteriorFuniculus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisPosteriorFuniculusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS POSERIOR MEDIAN SULCUS
	 * 
	 * This generates the MedullaSpinalisPosteriorMedianSulcus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisPosteriorMedianSulcus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisPosteriorMedianSulcus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisPosteriorMedianSulcus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisPosteriorMedianSulcus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisPosteriorMedianSulcus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisPosteriorMedianSulcus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisPosteriorMedianSulcusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS POSERO INTERMEDIATE SULCUS
	 * 
	 * This generates the MedullaSpinalisPosteroIntermediateSulcus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisPosteroIntermediateSulcus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisPosteroIntermediateSulcus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisPosteroIntermediateSulcus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisPosteroIntermediateSulcus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisPosteroIntermediateSulcus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisPosteroIntermediateSulcus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisPosteroIntermediateSulcusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS POSERO LATERAL SULCUS
	 * 
	 * This generates the MedullaSpinalisPosteroLateralSulcus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisPosteroLateralSulcus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisPosteroLateralSulcus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisPosteroLateralSulcus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisPosteroLateralSulcus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisPosteroLateralSulcus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisPosteroLateralSulcus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisPosteroLateralSulcusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS SUB ARCHNOID CAVITY
	 * 
	 * This generates the MedullaSpinalisSubArachnoidCavity Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisSubArachnoidCavity(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisSubArachnoidCavity");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisSubArachnoidCavity	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisSubArachnoidCavity:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisSubArachnoidCavity:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisSubArachnoidCavity	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisSubArachnoidCavityNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDULLA SPINALIS SUB DURAL CAVITY
	 * 
	 * This generates the MedullaSpinalisSubDuralCavity Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaSpinalisSubDuralCavity(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat MedullaSpinalisSubDuralCavity");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the MedullaSpinalisSubDuralCavity	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("MedullaSpinalisSubDuralCavity:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MedullaSpinalisSubDuralCavity:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the MedullaSpinalisSubDuralCavity	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for MedullaSpinalisSubDuralCavityNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE NEUROMERES
	 * 
	 * This generates the Neuromeres Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateNeuromeres(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat Neuromeres");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the Neuromeres	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("Neuromeres:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Neuromeres:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the Neuromeres	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for NeuromeresNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE NUCLEUS PULPOSUS
	 * 
	 * This generates the NucleusPulposus Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateNucleusPulposus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat NucleusPulposus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the NucleusPulposus	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("NucleusPulposus:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("NucleusPulposus:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the NucleusPulposus	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for NucleusPulposusNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PIA MATER SPINAL SHEATH
	 * 
	 * This generates the PiaMaterSpinalSheath Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePiaMaterSpinalSheath(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat PiaMaterSpinalSheath");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the PiaMaterSpinalSheath	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("PiaMaterSpinalSheath:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PiaMaterSpinalSheath:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the PiaMaterSpinalSheath	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for PiaMaterSpinalSheathNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SPINAL GANGLION
	 * 
	 * This generates the SpinalGanglion Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSpinalGanglion(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SpinalGanglion");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SpinalGanglion	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SpinalGanglion:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SpinalGanglion:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SpinalGanglion	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SpinalGanglionNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUBSTANTIAL GELATINOSA CENTRALIS
	 * 
	 * This generates the SubstantiaGelatinosaCentralis Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSubstantiaGelatinosaCentralis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SubstantiaGelatinosaCentralis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SubstantiaGelatinosaCentralis	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SubstantiaGelatinosaCentralis:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SubstantiaGelatinosaCentralis:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SubstantiaGelatinosaCentralis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SubstantiaGelatinosaCentralisNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUBSTANTIAL GELATINOSA OF ROLANDO
	 * 
	 * This generates the SubstantiaGelatinosaOfRolando Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSubstantiaGelatinosaOfRolando(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SubstantiaGelatinosaOfRolando");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SubstantiaGelatinosaOfRolando	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SubstantiaGelatinosaOfRolando:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SubstantiaGelatinosaOfRolando:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SubstantiaGelatinosaOfRolando	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SubstantiaGelatinosaOfRolandoNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERIOR ARTICULAR PROCESS
	 * 
	 * This generates the SuperiorArticularProcess Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSuperiorArticularProcess(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat SuperiorArticularProcess");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the SuperiorArticularProcess	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorArticularProcess:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SuperiorArticularProcess:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the SuperiorArticularProcess	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for SuperiorArticularProcessNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TRACT OF LISSAUER 
	 * 
	 * This generates the TractOfLissauer Nerve 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTractOfLissauer(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generat TractOfLissauer");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// We can generate the TractOfLissauer	
		if (currentPoints == null) {
			double circumference = 0.125;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;

			// Create a equilateral octogon
			currentPoints[0][0] = x;
			currentPoints[0][1] = y;
			currentPoints[0][2] = z;

			currentPoints[1][0] = x - circumference;
			currentPoints[1][1] = y;
			currentPoints[1][2] = z - circumference;

			currentPoints[2][0] = x - circumference;
			currentPoints[2][1] = y;
			currentPoints[2][2] = z - circumference * 2;

			currentPoints[3][0] = x;
			currentPoints[3][1] = y;
			currentPoints[3][2] = z - circumference * 3;

			currentPoints[4][0] = x + circumference;
			currentPoints[4][1] = y;
			currentPoints[4][2] = z - circumference * 3;

			currentPoints[5][0] = x + circumference * 2;
			currentPoints[5][1] = y;
			currentPoints[5][2] = z - circumference * 2;

			currentPoints[6][0] = x + circumference * 2;
			currentPoints[6][1] = y;
			currentPoints[6][2] = z - circumference;

			currentPoints[7][0] = x + circumference;
			currentPoints[7][1] = y;
			currentPoints[7][2] = z;
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstrutSet = new BioMightInstructSet();

		if (parentID.equals("TractOfLissauer:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TractOfLissauer:02")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, -0.10);
				} else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstrutSet.addElement(bioInstruct);
			}

		}

		// Generate the TractOfLissauer	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstrutSet);
		// System.out.println("Generated the Rows for TractOfLissauerNerveTissue: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
    
}