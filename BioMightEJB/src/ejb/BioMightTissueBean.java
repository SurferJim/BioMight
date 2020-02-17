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
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;



/**
 * Session Bean implementation class BioMightTissueBean
 */
@Stateless
public class BioMightTissueBean implements BioMightTissueBeanLocal {
	private static final int ROTATE  = 1;
	private static final int TRANSLATE  = 2;
	private static final int SCALE  = 3;
	
	
    /**
     * Default constructor. 
     */
    public BioMightTissueBean() {
        // TODO Auto-generated constructor stub
    }

 
	 /***************************************************************************************
	 * GENERATE BLOOD
	 * 
	 * This method generates Blood for use within the Vascular System.
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateBlood(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generateBlood: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the Blood alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
			double[] startPos = {-0.3,-17.0, -3.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		int nMaxSegs = 6;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.15, 0.10);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.20);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.50);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, 0.0, 0.25);
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
	
	
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for Blood: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
	}
		

	
	  /***************************************************************************************
		 * GENERATE CAPSULAR CARTILAGE
		 * 
		 * This generates the CostalCartilage
		 *
		 * @param key
		 * @param user
		 * @return
		 * @throws DataException
		 * @throws DataSecurityException
		 ***************************************************************************************/
		  	
		public int generateCostalCartilage(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
			throws DataException, DataSecurityException
		{	
			System.out.println("generateCostalCartilage: " + componentID + "   " + parentID);
			
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
			ArrayList mySqlList= new ArrayList();
			int returnCode = 0;
		
			// We can generate the DescendingAortaArtery alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the base oral cavity
			if (currentPoints == null )
			{
				double radius = 0.25;
				
				double x =  -0.3;
	    		double y =  -17.0;
	    		double z =  -3.0;
				
	    		double[] startPos = {-0.50,-8.0, -7,25};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
			}
			

			// Allocate an instruction set for building it
			BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

			if (parentID.equals("CostalCartilage:01")) 
			{	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.0);
					}
					else {
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.75, -0.1325, 0.0);
					}
					
					
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
		    
			} else if (parentID.equals("CostalCartilage:02")) {	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, -0.3, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.750, -0.225, 0.0);
					}
				
					else {
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.25, -0.075, 0.0);
					}
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
						
			}
			else if (parentID.equals("CostalCartilage:03")) {	
				int nMaxSegs = 2;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.750, -0.175, 0.0);
					}

		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
			} 
			else if (parentID.equals("CostalCartilage:04")) {	
				int nMaxSegs = 2;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
					}

									
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
			} 
			else if (parentID.equals("CostalCartilage:05")) {	
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, -0.2, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, -0.2, 0.05);
					}
					else if (numSegs==2){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, -0.1, 0.1);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.025);
					}
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
			} 
			
			else if (parentID.equals("CostalCartilage:06")) {	
				int nMaxSegs = 3;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, -0.1, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, -0.1, 0.0);
					}
					else if (numSegs==2){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.00, 0.10, 0.0);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.35, 0.10, 0.0);
					}

									
			
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("CostalCartilage:07")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.2, 0.15);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.05, 0.15);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.15);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.2, 0.25);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.2, 0.35);
				}
				
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setScaleMatrix(0.750, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}	
				
		
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}			
		}
		else if (parentID.equals("CostalCartilage:08")) {	
			int nMaxSegs = 6;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.2, 0.35);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.05, 0.35);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.25);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.15);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.25, -0.15);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.35, -0.15);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.45, -0.1);
				}
				
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setScaleMatrix(0.750, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}	
				
		
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}			
		}
		else if (parentID.equals("CostalCartilage:09")) {	
			int nMaxSegs = 8;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.50);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.50);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.45);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.20, 0.45);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 07.50, 0.35);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 1.0, 0.35);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.250, 0.25, 0.20);
				}
				else if (numSegs==7){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.01, 0.035, 0.050);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("CostalCartilage:10")) {	
			int nMaxSegs = 8;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.1, 0.50);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, -0.05, 0.45);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.15, 0.45);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.25, 0.40);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.40, 0.40);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.650, 0.20);
				}	
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, 0.650, -0.10);
				}	
				else if (numSegs==7){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.75, -0.15);
				}	

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("CostalCartilage:11")) {	
			int nMaxSegs = 0;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
				}
	
					
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
					
		else if (parentID.equals("CostalCartilage:12")) 
			{	
			int nMaxSegs = 0;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
				}
		
				
		   		// Add the instruction into the instruction set
		   		bioMightInstructSet.addElement(bioInstruct);
				}
			}
			
			
		//**************************************************************************************
		//**************************************************************************************
		//
		// Start on the Right Side
		//
		//**************************************************************************************
		//**************************************************************************************

	 
		else if (parentID.equals("CostalCartilage:13")) 
		{	
			int nMaxSegs = 1;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.0);
				}
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.1325, 0.0);
				}
				
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("CostalCartilage:14")) {	
			int nMaxSegs = 1;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.3, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.750, -0.225, 0.0);
				}
			
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, -0.075, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("CostalCartilage:15")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.750, -0.175, 0.0);
				}

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("CostalCartilage:16")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}

								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("CostalCartilage:17")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.1, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		
		else if (parentID.equals("CostalCartilage:18")) {	
			int nMaxSegs = 3;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.00, -0.1, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.35, -0.1, 0.0);
				}

								
		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("CostalCartilage:19")) {	
		int nMaxSegs = 4;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, -0.2, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.2, 0.0);
			}

			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(0.750, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
			}	
			
	
			// Add the instruction into the instruction set
			bioMightInstructSet.addElement(bioInstruct);
		}			
	}
	else if (parentID.equals("CostalCartilage:20")) {	
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
			}
			
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("CostalCartilage:21")) {	
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
			}
	
		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("CostalCartilage:22")) {	
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
			}
						
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(0.750, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.75, 0.0, 1.0);
			}		
			

    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("CostalCartilage:23")) {	
		int nMaxSegs = 0;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();

			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
			}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
				
	else if (parentID.equals("CostalCartilage:24")) 
		{	
		int nMaxSegs = 0;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.0);
			}
	
	   		// Add the instruction into the instruction set
	   		bioMightInstructSet.addElement(bioInstruct);
			}
		}
	
	
	
	
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for CostalCartilage Tissue: " + componentID + "   parent: " + parentID + "   " + componentType);
			
		return returnCode;
	}
		
    
}
