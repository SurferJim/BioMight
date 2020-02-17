package biomight.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightTransform;

/**
 * Session Bean implementation class BioMightSkeletalBean
 */
@Stateless
public class BioMightSkeletalBean implements BioMightSkeletalBeanLocal {
	private static final int ROTATE  = 1;
	private static final int TRANSLATE  = 2;
	private static final int SCALE  = 3;
	
	
	
    /**
     * Default constructor. 
     */
    public BioMightSkeletalBean() {
        // TODO Auto-generated constructor stub	
    }
    

    
    /***************************************************************************************
	 * GENERATE RIB
	 * 
	 * This generates the Rib
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateRib(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate Rib: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("Rib:01")) 
		{	
			int nMaxSegs = 16;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}	
				else if (numSegs==5){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.125, 0.5);
				}
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-35);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -0.175, 0.75);
				}
				else if (numSegs==9){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
				}
				else if (numSegs==11){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-37.250);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.225, 0.75);
				}
				else if (numSegs==13){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.225, 0.5);
				}
				else if (numSegs==14){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.04, 0.0);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75, -0.1325, 0.0);
				}
				
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("Rib:02")) {	
			int nMaxSegs = 17;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.40);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.40);
				}	
				else if (numSegs==5){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.25, 0.75);
				}
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.35, -0.30, 1.0);
				}
				else if (numSegs==9){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
				}
				else if (numSegs==11){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0,  -0.3, 0.75);
				}
				else if (numSegs==13){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0,  -0.3, 0.5);
				}
				else if (numSegs==14){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.2, 0.0);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.25, -0.05, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("Rib:03")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
				}
				else if (numSegs==3){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-25);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}	
				else if (numSegs==6){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==7){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, -0.3, 1.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, -0.3, 1.0);
				}
				else if (numSegs==9){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -0.3, 1.0);
				}
				else if (numSegs==11){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -0.3, 0.650);
				}
				else if (numSegs==13){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-27.5);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==14){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50,  -0.15, 0.50);
				}
				else if (numSegs==15){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.30, 0.2);
				}
				else if (numSegs==17){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.2);
				}
				else if (numSegs==18){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.1, 0.125);
				}

				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Rib:04")) {	
			int nMaxSegs = 21;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==4){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.75);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.75);
				}	
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}	
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.40, -0.3, 0.75);
				}
				else if (numSegs==9){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.40, -0.3, 0.75);
				}
				else if (numSegs==10){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.03, 0.0);
				}
				else if (numSegs==11){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.225, 0.750);
				}
				else if (numSegs==12){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==13){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -0.15, 0.50);
				}
				else if (numSegs==14){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -0.15, 0.50);
				}
				else if (numSegs==15){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-10.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75, -0.3, 0.750);
				}
				else if (numSegs==17){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75,  -0.22, 0.50);
				}
				else if (numSegs==18){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15.5);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==19){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.20, 0.0);
				}
				else if (numSegs==20){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.750, -0.225, 0.0);
				}
		
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Rib:05")) {	
			int nMaxSegs = 20;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.15, 0.0);
				}
				else if (numSegs==4){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.30, 0.75);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.30, 0.75);
				}	
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-10);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.30, -0.3, 1.00);
				}
				else if (numSegs==9){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.30, -0.25, 1.0);
				}
				
				else if (numSegs==10){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-10);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==11){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -0.15, 0.50);
				}
				else if (numSegs==12){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==13){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.175, -0.225, 0.75);
				}
				else if (numSegs==14){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0,  -0.3, 0.75);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0,  -0.30, 0.75);
				}
				else if (numSegs==18){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-0.10);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==17){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75,  -0.225, 0.0);
				}
				else if (numSegs==19){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75, -0.225, 0.0);
				}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Rib:06")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
				}
				else if (numSegs==4){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.3, 1.0);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.3, 1.0);
				}	
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.225, 1.0);
				}
				else if (numSegs==9){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-35);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.30, -0.30, 1.0);
				}	
				else if (numSegs==11){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.35, -0.3, 1.0);
				}
				else if (numSegs==13){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-30.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}
				else if (numSegs==14){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75,  -0.3, 0.5);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75,  -0.30, 0.5);
				}
				else if (numSegs==16){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-10);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
				}
				else if (numSegs==17){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.1);
				}	
				else if (numSegs==18){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.10, 0.05);
				}		

								
		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("Rib:07")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.750, -0.30, 1.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.750, -0.30, 1.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.30, 1.0);
			}	
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-10);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50, -0.25, 0.75);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-10);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.20, 0.50);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.225, 0.50);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.5);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.5);
			}
			else if (numSegs==17){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==18){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, -0.1);
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
	else if (parentID.equals("Rib:08")) {	
		int nMaxSegs = 18;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
			}
			else if (numSegs==5){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.35);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.25, 0.35);
			}	
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.25, 0.5);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.30, 1.0);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0,  -0.3, 1.0);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5,  -0.15, 0.5);
			}
			else if (numSegs==17){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
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
	else if (parentID.equals("Rib:09")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.35);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.25, 0.35);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.25, 0.5);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.30, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5,  -0.15, 0.5);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5,  -0.15, 0.5);
			}
			else if (numSegs==16){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
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
	else if (parentID.equals("Rib:10")) {	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.35);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.25, 0.35);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.25, 0.5);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.30, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.50,  -0.15, 0.50);
			}
			else if (numSegs==15){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
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
	else if (parentID.equals("Rib:11")) {	
		int nMaxSegs = 10;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.35);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.25, 0.35);
			}	
			else if (numSegs==6){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.25, 0.5);
			}
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.30, 1.0);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.3, 1.0);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75,  -0.28, 0.750);
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
				
	if (parentID.equals("Rib:12")) 
		{	
		int nMaxSegs = 10;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50, -0.15, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.250, -0.07, 0.0);
			}
			else if (numSegs==3){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50, -0.15, 0.175);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.25, 0.35);
			}	
			else if (numSegs==6){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.5);
			}
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(-35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.15, 1.0);
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

 
	if (parentID.equals("Rib:13")) 
	{	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.35);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.35);
			}	
			else if (numSegs==5){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.125, 0.5);
			}
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.175, 0.75);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(37.250);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.225, 0.75);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.225, 0.5);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.04, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.1325, 0.0);
			}
			
			
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
    
	} else if (parentID.equals("Rib:14")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.40);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.40);
			}	
			else if (numSegs==5){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.75);
			}
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.35, -0.30, 1.0);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 0.75);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 0.5);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.2, 0.0);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.05, 0.0);
			}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
				
	}
	else if (parentID.equals("Rib:15")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.225, 0.0);
			}
			else if (numSegs==3){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(25);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.65, -0.27, 0.50);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.65, -0.27, 0.50);
			}	
			else if (numSegs==6){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.3, 1.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.3, 1.0);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.20, -0.3, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.20, -0.3, 0.650);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(27.5);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50,  -0.15, 0.50);
			}
			else if (numSegs==15){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.2);
			}
			else if (numSegs==17){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.2);
			}
			else if (numSegs==18){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50, -0.1, 0.125);
			}

			
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	} 
	else if (parentID.equals("Rib:16")) {	
		int nMaxSegs = 21;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.225, 0.75);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.225, 0.75);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}	
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.40, -0.3, 0.75);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.40, -0.3, 0.75);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.03, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.225, 0.750);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.15, 0.50);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.15, 0.50);
			}
			else if (numSegs==15){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.3, 0.750);
			}
			else if (numSegs==17){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75,  -0.22, 0.50);
			}
			else if (numSegs==18){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(15.5);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==19){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.20, 0.0);
			}
			else if (numSegs==20){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.750, -0.225, 0.0);
			}
	
							
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	} 
	else if (parentID.equals("Rib:17")) {	
		int nMaxSegs = 20;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.15, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.30, 0.75);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.30, 0.75);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(10);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.30, -0.3, 1.00);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.30, -0.25, 0.75);
			}
			
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(5);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.15, 0.50);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.175, -0.225, 0.75);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(35.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 0.75);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.30, 0.75);
			}
			else if (numSegs==18){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(22.5);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==17){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75,  -0.225, 0.0);
			}
			else if (numSegs==19){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
			}
	
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	} 
	else if (parentID.equals("Rib:18")) 
	{	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.3, 1.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.3, 1.0);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(20);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.225, 1.0);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(35);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.30, -0.30, 1.0);
			}	
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.35, -0.3, 1.0);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(30.0);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75,  -0.3, 0.5);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75,  -0.30, 0.5);
			}
			else if (numSegs==16){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
    			bioInstruct.setTheta(10);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==17){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.1);
			}	
			else if (numSegs==18){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50, -0.10, 0.05);
			}		

							
		// Add the instruction into the instruction set
		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("Rib:19")) 
	{
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.750, -0.30, 1.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.750, -0.30, 1.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.30, 1.0);
			}	
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(10);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.50, -0.25, 0.75);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(10);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.15, -0.20, 0.50);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.25, -0.225, 0.50);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 0.35);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 0.35);
			}
			else if (numSegs==17){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==18){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, -0.25);
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
	else if (parentID.equals("Rib:20")) 
	{	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.0);
			}
			else if (numSegs==5){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.35);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.25, 0.35);
			}	
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(20);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.5);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(35);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.30, 1.0);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==14){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0,  -0.3, 1.0);
			}
			else if (numSegs==16){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5,  -0.15, 0.5);
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
	else if (parentID.equals("Rib:21")) 
	{	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.30, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.35);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.25, 0.35);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(20);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.5);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(35);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.30, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5,  -0.15, 0.5);
			}
			else if (numSegs==15){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5,  -0.15, 0.5);
			}
	
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(-0.750, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
			}			
		
		
			// Add the instruction into the instruction set
			bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("Rib:22")) 
	{	
		int nMaxSegs = 15;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.0);
			}
			else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.35);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.25, 0.35);
			}	
			else if (numSegs==7){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(20);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.5);
			}
			else if (numSegs==9){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(35);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.30, 1.0);
			}
			else if (numSegs==11){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==12){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==13){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==14){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.50,  -0.15, 0.50);
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
	else if (parentID.equals("Rib:23")) 
	{	
		int nMaxSegs = 10;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -0.3, 0.35);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.75, -0.25, 0.35);
			}	
			else if (numSegs==6){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(20);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.5);
			}
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(35);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.30, 1.0);
			}
			else if (numSegs==10){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==11){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.15, -0.3, 1.0);
			}
			else if (numSegs==12){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(30.0);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
			}
			else if (numSegs==13){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.75,  -0.28, 0.750);
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
	else if (parentID.equals("Rib:24")) 
	{	
		int nMaxSegs = 10;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	 
			if (numSegs==0){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.50, -0.15, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.50, -0.15, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.250, -0.07, 0.0);
			}
			else if (numSegs==3){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(15);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.50, -0.15, 0.15);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.25);
			}	
			else if (numSegs==6){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(20);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);
			}
			else if (numSegs==7){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.5);
			}
			else if (numSegs==8){
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
				bioInstruct.setTheta(35);	
				bioInstruct.setPivotPoint(0);	
	 			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	 			bioInstruct.setOrientation(orientation);
	 			bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.25, -0.1, 1.0);
			}

	
	   		// Add the instruction into the instruction set
	   		bioMightInstructSet.addElement(bioInstruct);
		}
	}

	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for Rib Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}
	
		
	/***************************************************************************************
	 * GENERATE HUMERUS
	 * 
	 * This generates the Humerus 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public BioMightGenerate generateHumerus(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Humerus");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		double lastPoints[][] = {{}};
		if (parentID.equals("Humerus:01")) {
			
			// Generate the Humerus	
			if (currentPoints == null) {
				double circumference = 0.5;
				double[] startPos = {-8.0,-10.00, -4.00};
				currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}
			
			int numInstructions = 18;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
							
				//bioMightTransform = new BioMightTransform();
				//bioMightTransform.setTextureID(5);
				//bioMightTransform.setTextureFile("PowderBlue.png");
				//bioMightTransform.setComponentName("Bone");
				
				// Place a transform object into each instruction set
				//bioInstruct.setBioMightTransform(bioMightTransform);
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 20.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.5);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.3);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.2);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);	
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 0.7);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 1.0, 0.6);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
					bioInstruct.setScaleMatrix(0.0, 1.0, 1.0);
				}			
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==15){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==16){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.35, 1.35, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==17){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}			
				else if (instructCount==18){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}	
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
					
							
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
			
			// Generate the Humerus	
			lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName,
			componentID, currentPoints, bioMightInstructSet);
			System.out.println("Generated the Rows for Humerus: "
			+ componentID + "   parent: " + parentID + "   " + componentType);

		
			
			// Generate the Olecron
			bioMightInstructSet = new BioMightInstructSet();
			double radius = 0.020;
			double[] startPos = {8.75, -9.0, -5.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		
				
			numInstructions = 5;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
							
				//bioMightTransform = new BioMightTransform();
				//bioMightTransform.setTextureID(5);
				//bioMightTransform.setTextureFile("PowderBlue.png");
				//bioMightTransform.setComponentName("Bone");
				
				// Place a transform object into each instruction set
				//bioInstruct.setBioMightTransform(bioMightTransform);
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 20.0);
					bioInstruct.setTranslateMatrix(0.00025, 0.00, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.3, 1.3, 1.3);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.00);   
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.00);  
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.00);  
				}	
				
				
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);	
				}		
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}


			
			// Generate the Humerus Olecron	
			 lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, "HumerusOsteocyte:08000", componentType, componentName,
			 componentID, currentPoints, bioMightInstructSet);
			 System.out.println("Generated the Rows for Humerus Olecron: "
			 + componentID + "   parent: " + parentID + "   " + componentType);


		} else if (parentID.equals("Humerus:02")) {
			
			// Generate the Humerus	
			if (currentPoints == null) {
				double circumference = 0.5;
				double[] startPos = {-8.0,-10.00, -4.00};
				currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}
			
			int numInstructions = 18;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
							
				//bioMightTransform = new BioMightTransform();
				//bioMightTransform.setTextureID(5);
				//bioMightTransform.setTextureFile("PowderBlue.png");
				//bioMightTransform.setComponentName("Bone");
				
				// Place a transform object into each instruction set
				//bioInstruct.setBioMightTransform(bioMightTransform);
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 20.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.5);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.3);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.2);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);	
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 0.7);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 1.0, 0.6);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
					bioInstruct.setScaleMatrix(0.0, 1.0, 1.0);
				}			
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==15){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==16){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.35, 1.35, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==17){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}		
				
				
				else if (instructCount==18){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}	
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

			
			// Generate the Humerus	
			 lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName,
			 componentID, currentPoints, bioMightInstructSet);
			 System.out.println("Generated the Rows for Humerus: "
			 + componentID + "   parent: " + parentID + "   " + componentType);
		
		
		
		 	// Generate the Olecron
			bioMightInstructSet = new BioMightInstructSet();
			double radius = 0.020;
			double[] startPos = {-8.75, -9.0, -5.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
			
			
			numInstructions = 5;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
							
				//bioMightTransform = new BioMightTransform();
				//bioMightTransform.setTextureID(5);
				//bioMightTransform.setTextureFile("PowderBlue.png");
				//bioMightTransform.setComponentName("Bone");
				
				// Place a transform object into each instruction set
				//bioInstruct.setBioMightTransform(bioMightTransform);
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 20.0);
					bioInstruct.setTranslateMatrix(-0.00025, 0.00, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
					bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.3, 1.3, 1.3);
					bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.00);   
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.00);  
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.00);  
				}	
				
				
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);	
				}			
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}


			// Generate the Humerus Olecron	
			 lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, "HumerusOsteocyte:08400", componentType, componentName,
			 componentID, currentPoints, bioMightInstructSet);
			 System.out.println("Generated the Rows for Humerus Olecron: " + lastPoints[0]  + ", " + lastPoints[1] + "   "
			 + componentID + "   parent: " + parentID + "   " + componentType);

		}

		 
		  
		// Set up the BioMightGenerate that will be returned to the client
 		// so that its information can be used to build other objects
   		BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
   		System.out.println("Setup Humerus BioMightGenerate Object: " + lastPoints[0][0]);
		   
 		return (bioMightGenerate);
	}
	
	
	
	/***************************************************************************************
	 * GENERATE OLECRANON
	 * 
	 * This generates the Olecranon 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateOlecranon(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Olecranon");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Humerus	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Olecranon:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Olecranon:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Olecranon	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Olecranon: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RADIALNOTCH
	 * 
	 * This generates the RadialNotch 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRadialNotch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate RadialNotch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the RadialNotch	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("RadialNotch:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RadialNotch:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the RadialNotch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for RadialNotch: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE RADIUS
	 * 
	 * This generates the Radius 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public BioMightGenerate generateRadius(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Radius");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Radius	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Radius:01")) {

			int numInstructions = 12;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 22.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.15);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.010, -1.0, 0.0);
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.09, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}			
				
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
					

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Radius:02")) {
			int numInstructions = 12;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
					
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(true); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 22.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.15);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.010, -1.0, 0.0);
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.09, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}			
				
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
					
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Radius	
		double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName,
		componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for Radius: " +
		componentID + "   parent: " + parentID + "   " + componentType);

		
		// Set up the BioMightGenerate that will be returned to the client
 		// so that its information can be used to build other objects
   		BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
   		System.out.println("Setup Trachea BioMightGenerate Object: " + lastPoints[0][0]);
		   
 		return (bioMightGenerate);

	}
	
	
	
	/***************************************************************************************
	 * GENERATE SEMIULNARNOTCH
	 * 
	 * This generates the SemiUlnarNotch 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSemiUlnarNotch(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate SemiUlnarNotch");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the SemiUlnarNotch	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("SemiUlnarNotch:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("SemiUlnarNotch:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the SemiUlnarNotch	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for SemiUlnarNotch: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
		

	/***************************************************************************************
	 * GENERATE ULNA
	 * 
	 * This generates the Ulna 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUlna(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Ulna");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Ulna	
		if (currentPoints == null) {
			double circumference = 0.025;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			System.out.println("Generate Ulna - Current Points are NULL!");
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		 if (parentID.equals("Ulna:01")) {
			int numInstructions = 12;
			for (int instructCount = 0; instructCount < numInstructions; instructCount++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 22.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.01, -1.0, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.15);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.075, -1.0, 0.0);
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.125, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -0.5, 0.0);
				}	
		
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (parentID.equals("Ulna:02")) {
			int numInstructions = 12;
			for (int instructCount = 0; instructCount < numInstructions; instructCount++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (instructCount==0){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(22.0, 22.0, 22.0);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.01, -1.0, 0.0);
				}	
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -1.0, 0.15);
				}	
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.075, -1.0, 0.0);
				}	
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}	
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}		
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.0);
				}	
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.125, -1.0, 0.0);
				}	
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0);
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -0.5, 0.0);
				}	
				
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} 

		// Generate the Ulna	
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for Ulna: " + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	/***************************************************************************************
	 * GENERATE ULNACORONOIDPROCESS
	 * 
	 * This generates the UlnaCoronoidProcess 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUlnaCoronoidProcess(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate UlnaCoronoidProcess");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the UlnaCoronoidProcess	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("UlnaCoronoidProcess:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UlnaCoronoidProcess:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the UlnaCoronoidProcess	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for UlnaCoronoidProcess: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	/***************************************************************************************
	 * GENERATE CLARVICLE
	 * 
	 * This generates the Clavicle 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateClavicle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Clavicle");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Clavicle	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Clavicle:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Clavicle:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Clavicle	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Clavicle: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SCAPULA
	 * 
	 * This generates the Scapula 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateScapula(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Scapula");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Scapula	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Scapula:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Scapula:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Scapula	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Scapula: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	/***************************************************************************************
	 * GENERATE STERNUM
	 * 
	 * This generates the Sternum 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSternum(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("SkeletalBeanGenerateSternum: " + componentName + "  " + componentID + "   " +parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Sternum	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 19;
		for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

			// Create a place for an instruction
			BioMightInstruction bioInstruct = new BioMightInstruction();

			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25.0, 1.0, 18.0);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.85, 1.0, 1.05);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.1);  
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.0, 1.05);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.1); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.75, 0.1);
			}	
			else if (numSegs == 4) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 
			else if (numSegs == 5) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 
			else if (numSegs == 6) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.65, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 
			else if (numSegs == 7) {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.05);
			} 
			else if (numSegs == 8) {	
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 	
			else if (numSegs == 9) {
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.05);
			} 
			else if (numSegs == 10) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.05);
			} 
			else if (numSegs == 11) {
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.05);
			} 
			else if (numSegs == 12) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 
			else if (numSegs == 13) {
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.025);
			} 	
			else if (numSegs == 14) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.05);
			} 
			else if (numSegs == 15) {
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.025);
			} 
			else if (numSegs == 16) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.025);
			} 
			else if (numSegs == 17) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.60, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
			} 
			else if (numSegs == 18) {
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 1.00);
				bioInstruct.setTranslateMatrix(0.0, -0.35, 0.0);
			} 
			else 
			{
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(-1.0, -1.0, 0.0);
			}

			// Add the instruction into the instruction set	
			bioMightInstructSet.addElement(bioInstruct);
			

		}
		// Generate the Sternum	

		System.out.println("Generating the Rows for SternumOsteocyte: " + componentID + "   " + componentType + "  Size: " + bioMightInstructSet.getSize());
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		return returnCode;
	}
	
	
	
	
	/***************************************************************************************
	 * GENERATE XIPHOIDPROCESS
	 * 
	 * This generates the XiphoidProcess 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateXiphoidProcess(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate XiphoidProcess");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the XiphoidProcess	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("XiphoidProcess:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("XiphoidProcess:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the XiphoidProcess	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for XiphoidProcess: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CALCANEUSBONE
	 * 
	 * This generates the CalcaneusBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCalcaneusBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate CalcaneusBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the CalcaneusBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("CalcaneusBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CalcaneusBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the CalcaneusBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for CalcaneusBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CUBOIDBONE
	 * 
	 * This generates the CuboidBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCuboidBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate CuboidBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the CuboidBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("CuboidBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CuboidBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the CuboidBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for CuboidBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DISTALPHALANAGES
	 * 
	 * This generates the DistalPhalanages 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDistalPhalanages(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate DistalPhalanages");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the DistalPhalanages	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("DistalPhalanages:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DistalPhalanages:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the DistalPhalanages	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for DistalPhalanages: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INTERMEDIATEPHALANAGES
	 * 
	 * This generates the IntermediatePhalanages 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateIntermediatePhalanages(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate IntermediatePhalanages");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the IntermediatePhalanages	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("IntermediatePhalanages:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("IntermediatePhalanages:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the IntermediatePhalanages	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for IntermediatePhalanages: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERALCUNEIFORMBONE
	 * 
	 * This generates the LateralCuneiformBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralCuneiformBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate LateralCuneiformBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the LateralCuneiformBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LateralCuneiformBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LateralCuneiformBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the LateralCuneiformBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for LateralCuneiformBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE METATARSALSBONE
	 * 
	 * This generates the MetaTarsalsBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMetaTarsalsBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate MetaTarsalsBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the MetaTarsalsBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("MetaTarsalsBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MetaTarsalsBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the MetaTarsalsBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for MetaTarsalsBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE NAVICULARCUNEIFORMS
	 * 
	 * This generates the NavicularCuneiforms 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateNavicularCuneiforms(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate NavicularCuneiforms");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the NavicularCuneiforms	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("NavicularCuneiforms:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("NavicularCuneiforms:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the NavicularCuneiforms	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for NavicularCuneiforms: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHALANGESFOOT
	 * 
	 * This generates the Phalangesfoot 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhalangesfoot(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Phalangesfoot");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Phalangesfoot	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Phalangesfoot:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Phalangesfoot:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Phalangesfoot	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Phalangesfoot: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE TALUSBONE
	 * 
	 * This generates the TalusBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTalusBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TalusBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TalusBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TalusBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TalusBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TalusBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TalusBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TARSALS
	 * 
	 * This generates the Tarsals 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTarsals(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Tarsals");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Tarsals	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Tarsals:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Tarsals:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Tarsals	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Tarsals: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CAPITATEBONE
	 * 
	 * This generates the CapitateBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCapitateBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate CapitateBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the CapitateBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("CapitateBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("CapitateBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the CapitateBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for CapitateBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	  
    /***************************************************************************************
	 * GENERATE CARPAL
	 * 
	 * This generates the Carpal bones of the hand
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateCarpal(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate Carpal: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("Carpal:01")) 
		{	
			int nMaxSegs = 16;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("Carpal:02")) {	
			int nMaxSegs = 17;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.40);
				}

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("Carpal:03")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
				}
				else if (numSegs==3){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-25);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}

							
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Carpal:04")) {	
			int nMaxSegs = 3;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Carpal:05")) {	
			int nMaxSegs = 4;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.15, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("Carpal:06")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
				}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("Carpal:07")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
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
	else if (parentID.equals("Carpal:08")) {	
		int nMaxSegs = 18;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("Carpal:09")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("Carpal:10")) {	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
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


	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for Carpal Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}
	
	  
    /***************************************************************************************
	 * GENERATE METACARPAL
	 * 
	 * This generates the MetaCarpal
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateMetaCarpal(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate MetaCarpal: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("MetaCarpal:01")) 
		{	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}

				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("MetaCarpal:02")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("MetaCarpal:03")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}					
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("MetaCarpal:04")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}			
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("MetaCarpal:05")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}	
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		
		// RIGHT SIDE
		else if (parentID.equals("MetaCarpal:06")) 
		{	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}

				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("MetaCarpal:07")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("MetaCarpal:08")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}					
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("MetaCarpal:09")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==7){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-15.0);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.06, 0.0);
				}			
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("MetaCarpal:10")) {	
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				}	
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 

	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for MetaCarpal Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}

	
	  
    /***************************************************************************************
	 * GENERATE HAND DISTAL PHALANGE
	 * 
	 * This generates the DistalPhalange for the Hand
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHandDistalPhalange(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate HandDistalPhalange: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("HandDistalPhalange:01")) 
		{	
			int nMaxSegs = 16;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("HandDistalPhalange:02")) {	
			int nMaxSegs = 17;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.40);
				}

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("HandDistalPhalange:03")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
				}
				else if (numSegs==3){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-25);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}

							
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandDistalPhalange:04")) {	
			int nMaxSegs = 3;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandDistalPhalange:05")) {	
			int nMaxSegs = 4;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.15, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandDistalPhalange:06")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
				}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("HandDistalPhalange:07")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
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
	else if (parentID.equals("HandDistalPhalange:08")) {	
		int nMaxSegs = 18;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandDistalPhalange:09")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandDistalPhalange:10")) {	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
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


	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for HandDistalPhalange Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}	
	
	
    /***************************************************************************************
	 * GENERATE HAND MIDDLE PHALANGE
	 * 
	 * This generates the Middle Phalange
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHandMiddlePhalange(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate HandMiddlePhalange: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("HandMiddlePhalange:01")) 
		{	
			int nMaxSegs = 16;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("HandMiddlePhalange:02")) {	
			int nMaxSegs = 17;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.40);
				}

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("HandMiddlePhalange:03")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
				}
				else if (numSegs==3){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-25);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}

							
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandMiddlePhalange:04")) {	
			int nMaxSegs = 3;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandMiddlePhalange:05")) {	
			int nMaxSegs = 4;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.15, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandMiddlePhalange:06")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
				}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("HandMiddlePhalange:07")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
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
	else if (parentID.equals("HandMiddlePhalange:08")) {	
		int nMaxSegs = 18;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandMiddlePhalange:09")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandMiddlePhalange:10")) {	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
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


	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for HandMiddlePhalange Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}	
	  
    /***************************************************************************************
	 * GENERATE HAND PROXIMAL PHALANGE
	 * 
	 * This generates the Proximal Phalange
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHandProximalPhalange(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("generate HandProximalPhalange: " + componentID + "   " + parentID);
		
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

		if (parentID.equals("HandProximalPhalange:01")) 
		{	
			int nMaxSegs = 16;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.35);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	    
		} else if (parentID.equals("HandProximalPhalange:02")) {	
			int nMaxSegs = 17;
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
				else if (numSegs==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-20);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.40);
				}

	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
					
		}
		else if (parentID.equals("HandProximalPhalange:03")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, -0.225, 0.0);
				}
				else if (numSegs==3){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEMOVEOCTO);
	    			bioInstruct.setTheta(-25);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.65, -0.27, 0.50);
				}

							
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandProximalPhalange:04")) {	
			int nMaxSegs = 3;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
				}
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandProximalPhalange:05")) {	
			int nMaxSegs = 4;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.15, 0.0);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		} 
		else if (parentID.equals("HandProximalPhalange:06")) {	
			int nMaxSegs = 19;
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
				else if (numSegs==2){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
				}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
	}
	else if (parentID.equals("HandProximalPhalange:07")) {	
		int nMaxSegs = 19;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
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
	else if (parentID.equals("HandProximalPhalange:08")) {	
		int nMaxSegs = 18;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandProximalPhalange:09")) {	
		int nMaxSegs = 17;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.30, 0.0);
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
	else if (parentID.equals("HandProximalPhalange:10")) {	
		int nMaxSegs = 16;
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
			else if (numSegs==2){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.3, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(TRANSLATE);
				bioInstruct.setTranslateMatrix(0.5, -0.15, 0.0);
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


	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
	System.out.println("Generated the Rows for HandProximalPhalange Osteocytes: " + componentID + "   parent: " + parentID + "   " + componentType);
		
	return returnCode;
}
	
	

	
	
	
	/***************************************************************************************
	 * GENERATE DIPJOINT
	 * 
	 * This generates the DipJoint 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDipJoint(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate DipJoint");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the DipJoint	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("DipJoint:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DipJoint:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the DipJoint	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for DipJoint: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	

	
	/***************************************************************************************
	 * GENERATE DISTALPHALANX
	 * 
	 * This generates the DistalPhalanx 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateDistalPhalanx(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate DistalPhalanx");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the DistalPhalanx	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("DistalPhalanx:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("DistalPhalanx:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the DistalPhalanx	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for DistalPhalanx: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	

	
	
	/***************************************************************************************
	 * GENERATE HAMATECAPITATEBONE
	 * 
	 * This generates the HamateCapitateBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateHamateCapitateBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate HamateCapitateBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the HamateCapitateBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("HamateCapitateBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("HamateCapitateBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the HamateCapitateBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for HamateCapitateBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LUNATEBONE
	 * 
	 * This generates the LunateBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLunateBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate LunateBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the LunateBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LunateBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("LunateBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the LunateBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for LunateBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE METACARPALS
	 * 
	 * This generates the MetaCarpals 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMetaCarpals(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate MetaCarpals");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the MetaCarpals	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("MetaCarpals:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MetaCarpals:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the MetaCarpals	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for MetaCarpals: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MIDDLEPHALANX
	 * 
	 * This generates the MiddlePhalanx 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMiddlePhalanx(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate MiddlePhalanx");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the MiddlePhalanx	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("MiddlePhalanx:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("MiddlePhalanx:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the MiddlePhalanx	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for MiddlePhalanx: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHALANGES
	 * 
	 * This generates the Phalanges 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePhalanges(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Phalanges");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Phalanges	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Phalanges:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Phalanges:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Phalanges	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Phalanges: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PIPJOINT
	 * 
	 * This generates the PipJoint 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePipJoint(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate PipJoint");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the PipJoint	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PipJoint:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PipJoint:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the PipJoint	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for PipJoint: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PISIFORMTRIQUETRUMBONE
	 * 
	 * This generates the PisiformTriquetrumBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePisiformTriquetrumBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate PisiformTriquetrumBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the PisiformTriquetrumBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PisiformTriquetrumBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PisiformTriquetrumBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the PisiformTriquetrumBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for PisiformTriquetrumBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PROXIMALPHALANX
	 * 
	 * This generates the ProximalPhalanx 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateProximalPhalanx(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate ProximalPhalanx");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the ProximalPhalanx	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("ProximalPhalanx:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ProximalPhalanx:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the ProximalPhalanx	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for ProximalPhalanx: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RADIALSTYLOIDPROCESS
	 * 
	 * This generates the RadialStyloidProcess 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateRadialStyloidProcess(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate RadialStyloidProcess");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the RadialStyloidProcess	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("RadialStyloidProcess:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("RadialStyloidProcess:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the RadialStyloidProcess	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for RadialStyloidProcess: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SCAPHOIDBONE
	 * 
	 * This generates the ScaphoidBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateScaphoidBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate ScaphoidBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the ScaphoidBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("ScaphoidBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("ScaphoidBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the ScaphoidBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for ScaphoidBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TRAPEZIUMBONE
	 * 
	 * This generates the TrapeziumBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrapeziumBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TrapeziumBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrapeziumBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TrapeziumBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrapeziumBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TrapeziumBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TrapeziumBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TRIQUETRALBONE
	 * 
	 * This generates the TriquetralBone 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTriquetralBone(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TriquetralBone");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TriquetralBone	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TriquetralBone:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TriquetralBone:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TriquetralBone	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TriquetralBone: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ULNARSTYLOIDPROCESS
	 * 
	 * This generates the UlnarStyloidProcess 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateUlnarStyloidProcess(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate UlnarStyloidProcess");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the UlnarStyloidProcess	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("UlnarStyloidProcess:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("UlnarStyloidProcess:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the UlnarStyloidProcess	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for UlnarStyloidProcess: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	/***************************************************************************************
	 * GENERATE PATELLA
	 * 
	 * This generates the Patella 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePatella(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Patella");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Patella	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Patella:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("Patella:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the Patella	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for Patella: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}

	
	

	/***************************************************************************************
	 * GENERATE PELVIS
	 * 
	 * This generates the Pelvis 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePelvis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Pelvis: " + componentID + "   " + parentID + "  " + componentName);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentName.equals("IliumLeft")) {
			int nMaxSegs = 12;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
		   			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 4.0, 2.0);
					bioInstruct.setTranslateMatrix(0.025, 0.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.2, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.0);
				} 
				else if (numSegs == 2) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.3, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.0);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.5, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.25, 0.0);
				} 
				else if (numSegs == 4) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.10, 0.0);
				} 
				else if (numSegs == 5) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.10, 0.25);
				}
				else if (numSegs == 6) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.10, 0.30);
				} 
				else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.30);
				} 
				else if (numSegs == 8) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.90, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.35);
				} 
				else if (numSegs == 9) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.35);
				} 
				else if (numSegs == 10) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.75, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.40);
				} 
				else if (numSegs == 11) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(0.0250, 0.0, 0.0);
				} 
			 
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (componentName.equals("IliumRight")) {
			int nMaxSegs = 12;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
		   			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 4.0, 2.0);
					bioInstruct.setTranslateMatrix(-0.025, 0.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.2, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.0);
				} 
				else if (numSegs == 2) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.3, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.0);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.5, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.25, 0.0);
				} 
				else if (numSegs == 4) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.10, 0.0);
				} 
				else if (numSegs == 5) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.10, 0.25);
				}
				else if (numSegs == 6) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.10, 0.30);
				} 
				else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.30);
				} 
				else if (numSegs == 8) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.90, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.35);
				} 
				else if (numSegs == 9) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.35);
				} 
				else if (numSegs == 10) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 0.75, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.40);
				} 
				else if (numSegs == 11) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(-0.0250, 0.0, 0.0);
				} 

				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		//******************************************
		// ISHIUM
		//******************************************
		else if (componentName.equals("IschiumLeft")) {
			int nMaxSegs = 13;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
		   			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 1.0, 3.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.05);
					bioInstruct.setTranslateMatrix(-0.05, -0.50, 0.0);
				} 
				else if (numSegs == 2) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.995);
					bioInstruct.setTranslateMatrix(-0.1, -0.50, 0.0);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.15, -0.50, 0.0);
				} 
				else if (numSegs == 4) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.05, -0.50, 0.0);
				} 
				else if (numSegs == 5) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (numSegs == 6) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.70, 0.70, 1.0);
					bioInstruct.setTranslateMatrix(-0.35, -0.40, 0.0);
				} 
				else if (numSegs == 7) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.80, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(-0.45, -0.350, 0.25);
				}
				else if (numSegs == 8) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.80, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(-0.45, -0.350, 0.30);
				} 
				else if (numSegs == 9) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				}
				else if (numSegs == 10) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.30, -0.05, 0.30);
				} 
				else if (numSegs == 11) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.30);
				} 
				else if (numSegs == 12) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.30);
				} 
	
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (componentName.equals("IschiumRight")) {
			int nMaxSegs = 13;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();


				if (numSegs == 0) {
		   			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 1.0, 3.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.05);
					bioInstruct.setTranslateMatrix(0.05, -0.50, 0.0);
				} 
				else if (numSegs == 2) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.995);
					bioInstruct.setTranslateMatrix(0.1, -0.50, 0.0);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.15, -0.50, 0.0);
				} 
				else if (numSegs == 4) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.05, -0.50, 0.0);
				} 
				else if (numSegs == 5) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (numSegs == 6) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.70, 0.70, 1.0);
					bioInstruct.setTranslateMatrix(0.35, -0.40, 0.0);
				} 
				else if (numSegs == 7) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.80, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(0.45, -0.350, 0.25);
				}
				else if (numSegs == 8) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.80, 0.80, 1.0);
					bioInstruct.setTranslateMatrix(0.45, -0.350, 0.30);
				} 
				else if (numSegs == 9) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	     			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				}
				else if (numSegs == 10) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 0.90, 1.0);
					bioInstruct.setTranslateMatrix(0.30, -0.05, 0.30);
				} 
				else if (numSegs == 11) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.50, -0.03, 0.30);
				} 
				else if (numSegs == 12) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.50, 0.0, 0.30);
				} 		
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (componentName.equals("Sacrum")) {
			int nMaxSegs = 5;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();


				if (numSegs == 0) {
		   			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(5.0, 1.0, 5.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.95, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 
				else if (numSegs == 2) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.95, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 
				else if (numSegs == 4) {
					bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.70, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.250, 0.0);
				} 
				
			
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (componentName.equals("IschiumLoopLeft")) {
			int nMaxSegs = 11;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();


				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.75, -0.25);
				} 
				else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.75, -0.25);
				} 
				else if (numSegs == 2) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, -0.5, -0.15);
				} 
				else if (numSegs == 4) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 		
				else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.5, 0.0, 0.0);
				} 
				else if (numSegs == 6) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 		
				else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.75, 0.5, 0.25);
				} 
				else if (numSegs == 8) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 	
				else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, 0.50, 0.25);
				} 
				else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, 0.350, 0.15);
				} 
		
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (componentName.equals("IschiumLoopRight")) {
			int nMaxSegs = 11;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.75, -0.25);
				} 
				else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.75, -0.25);
				} 
				else if (numSegs == 2) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 
				else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.5, -0.15);
				} 
				else if (numSegs == 4) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 		
				else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(1.5, 0.0, 0.0);
				} 
				else if (numSegs == 6) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 		
				else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.75, 0.5, 0.25);
				} 
				else if (numSegs == 8) {
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				} 	
				else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, 0.50, 0.25);
				} 
				else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, 0.350, 0.15);
				} 		
			
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}


		
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for PelvisOsteocyte: " + componentID + "   " + componentType + "  Size: " + bioMightInstructSet.getSize());
		return returnCode;
	}

	/***************************************************************************************
	 * GENERATE ILIUM
	 * 
	 * This generates the Ilium 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateIlium(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Ilium: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Ilium	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("Ilium:01")) {
			int nMaxSegs = 18;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.0, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.0, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.0, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -1.0, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("Ilium:02")) {
			int nMaxSegs = 18;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -1.0, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for IliumOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	

	/***************************************************************************************
	 * GENERATE FEMUR
	 * 
	 * This generates the Femur 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFemur(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Femur: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Femur	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("Femur:01")) {
			int nMaxSegs = 16;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.00, 0.20);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.20);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.20);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.15);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.05);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, -0.05);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, -0.04);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, -0.03);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, -0.02);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.08, -1.0, -0.02);
				} else if (numSegs == 14) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.04, -1.0, -0.02);
				} else if (numSegs == 15) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.02, -1.0, -0.02);
				}  
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("Femur:02")) {
			int nMaxSegs = 16;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.00, 0.20);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.20);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.20);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.15);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.10);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.10);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.05);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, -0.05);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, -0.04);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, -0.03);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, -0.02);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.08, -1.0, -0.02);
				} else if (numSegs == 14) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.04, -1.0, -0.02);
				} else if (numSegs == 15) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.02, -1.0, -0.02);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for FemurOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	


	/***************************************************************************************
	 * GENERATE FIBULA
	 * 
	 * This generates the Fibula 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFibula(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Fibula: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Fibula	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("Fibula:01")) {
			int nMaxSegs = 14;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();
		
				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -1.00, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -1.00, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.1, -1.00, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.075, -1.00, 0.0);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -1.0, 0.0);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.25, -1.0, 0.0);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -1.0, 0.0);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.0);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.0);
				}
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("Fibula:02")) {
			int nMaxSegs = 14;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.00, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, -1.00, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -1.00, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, -1.00, 0.0);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.075, -1.0, 0.0);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -1.0, 0.0);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, -1.0, 0.0);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -1.0, 0.0);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -1.0, 0.0);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -1.0, 0.0);			
				}
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for FibulaOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	

	/***************************************************************************************
	 * GENERATE TIBIA
	 * 
	 * This generates the Tibia 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTibia(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Tibia: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Tibia	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("Tibia:01")) {
			int nMaxSegs = 14;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 14) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 15) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 16) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("Tibia:02")) {
			int nMaxSegs = 14;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 7) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 8) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 9) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 10) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 11) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 12) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 13) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 14) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 15) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 16) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} 
				

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for TibiaOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}

	

	/***************************************************************************************
	 * GENERATE SACRUM
	 * 
	 * This generates the Sacrum 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSacrum(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate Sacrum: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Tibia	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("Sacrum:01")) {
			int nMaxSegs = 6;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 3) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 4) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 5) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} else if (numSegs == 6) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		} 

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for SacrumOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	/***************************************************************************************
	 * GENERATE CERVICAL VERTEBRA
	 * 
	 * This generates the LumbarVertebra 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCervicalVertebra(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate CervicalVertebra: " + componentID + "   " + parentID + "   " + componentName);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Femur	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("CervicalVertebra:01")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.05);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0., -0.25, 0.1);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("CervicalVertebra:02")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.1);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.00);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.1);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("CervicalVertebra:03")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.00);
					bioInstruct.setTranslateMatrix(0.0, -0.65, -0.40);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.0, 1.00);
					bioInstruct.setTranslateMatrix(0.0, -0.25, -0.1);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("CervicalVertebra:04")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.30);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.60, -0.1);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}		
		else if (componentID.equals("CervicalVertebra:05")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.1);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("CervicalVertebra:06")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.30);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("CervicalVertebra:07")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.250, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for CervicalVertebraOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	/***************************************************************************************
	 * GENERATE THORACIC VERTEBRA
	 * 
	 * This generates the ThoracicVertebra
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateThoracicVertebra(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate ThoracicVertebra: " + componentID + "   " + parentID + "   " + componentName);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the ThoracicVertebra	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("ThoracicVertebra:01")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("ThoracicVertebra:02")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.85, -0.45);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:03")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.40);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.20);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:04")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.60, 0.15);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}		
		else if (componentID.equals("ThoracicVertebra:05")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, -0.05);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:06")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, 0.05);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:07")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:08")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, 0.2);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:09")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:09")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.95, 0.30);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:10")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:11")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.05);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("ThoracicVertebra:12")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.1);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for ThoracicVertebraOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}

	/***************************************************************************************
	 * GENERATE LUMBAR VERTEBRA
	 * 
	 * This generates the LumbarVertebra 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLumbarVertebra(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate LumbarVertebra: " + componentID + "   " + parentID + "   " + componentName);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Femur	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("LumbarVertebra:01")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("LumbarVertebra:02")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.20);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("LumbarVertebra:03")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.35);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.20);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}	

		}
		else if (componentID.equals("LumbarVertebra:04")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.90, -0.40);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.15);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}		
		else if (componentID.equals("LumbarVertebra:05")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for LumbarVertebraOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE SACRAL VERTEBRA
	 * 
	 * This generates the SacralVertebra 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateSacralVertebra(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate SacralVertebra: " + componentID + "   " + parentID + "   " + componentName);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Femur	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("SacralVertebra:01")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.25);
					bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("SacralVertebra:02")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.25);
					bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("SacralVertebra:03")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, -0.10);
					bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		else if (componentID.equals("SacralVertebra:04")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setTranslateMatrix(0.0, -0.450, 0.0);
					bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}		
		else if (componentID.equals("SacralVertebra:05")) {
			int nMaxSegs = 1;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(SCALE);
					bioInstruct.setTranslateMatrix(0.0, -0.350, 0.25);
					bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.06, -0.50, 0.25);
				} 

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for SacralVertebraOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	

	
	/***************************************************************************************
	 * GENERATE FOVEACAPITIS
	 * 
	 * This generates the FoveaCapitis 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateFoveaCapitis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate FoveaCapitis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the FoveaCapitis	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("FoveaCapitis:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("FoveaCapitis:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the FoveaCapitis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for FoveaCapitis: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE GREATER TROCHANTER
	 * 
	 * This generates the GreaterTrochanter 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateGreaterTrochanter(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		
		System.out.println("Generate GreaterTrochanter: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate 
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("GreaterTrochanter:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("GreaterTrochanter:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for GreaterTrochanterOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	

	/***************************************************************************************
	 * GENERATE LESSER TROCHANTER
	 * 
	 * This generates the LesserTrochanter 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLesserTrochanter(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {

		System.out.println("Generate LesserTrochanter: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate 
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("LesserTrochanter:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("LesserTrochanter:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for LesserTrochanterOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	
	
	/***************************************************************************************
	 * GENERATE PIRIFORMIS
	 * 
	 * This generates the PiriFormis 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePiriFormis(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate PiriFormis");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the PiriFormis	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PiriFormis:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("PiriFormis:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the PiriFormis	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for PiriFormis: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE TROCHANTER HEAD
	 * 
	 * This generates the TrochanterHead 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochanterHead(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TrochanterHead: " + componentID + "   " + parentID);

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the Femur	
		if (currentPoints == null) {
			double radius = 0.5;

			double[] startPos = {3.65, -35.0, -6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("TrochanterHead:01")) {
			
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	      
	    		if (numSegs==0){
	    			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(3.0, 1.0, 3.0);
	    			bioInstruct.setTranslateMatrix(0.15, -0.15, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(2.0, 1.0, 2.0);
	    			bioInstruct.setTranslateMatrix(0.25, -0.25, 0.0); 
	           	}
	       		else if (numSegs==2){
	       			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
	    			bioInstruct.setTranslateMatrix(0.25, -0.25, 0.0); 
	           	}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.25, -0.25, 0.0); 
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
	    			bioInstruct.setTranslateMatrix(0.25, -0.25, 0.0);    
	        	}
	   	
	    		
	    	 
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.06, -0.50, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("TrochanterHead:02")) {
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			

	    		if (numSegs==0){
	    			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(3.0, 1.0, 3.0);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.15, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(2.0, 1.0, 2.0);
	    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0); 
	           	}
	       		else if (numSegs==2){
	       			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
	    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0); 
	           	}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0); 
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
	    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0);    
	        	}
	    		
	    			    		
	    	
	    			    		
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for TrochanterHeadOsteocyte: " + componentID + "   " + componentType);
		return returnCode;
	}
	
	
	

	/***************************************************************************************
	 * GENERATE TROCHANTERICFOSSA
	 * 
	 * This generates the TrochantericFossa 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochantericFossa(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TrochantericFossa");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochantericFossa	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TrochantericFossa:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrochantericFossa:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TrochantericFossa	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TrochantericFossa: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	

	/***************************************************************************************
	 * GENERATE TROCHANTERLATERALSURFACE
	 * 
	 * This generates the TrochanterLateralSurface 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochanterLateralSurface(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TrochanterLateralSurface");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochanterLateralSurface	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TrochanterLateralSurface:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrochanterLateralSurface:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TrochanterLateralSurface	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TrochanterLateralSurface: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	

	/***************************************************************************************
	 * GENERATE TROCHANTERMEDIALSURFACE
	 * 
	 * This generates the TrochanterMedialSurface 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochanterMedialSurface(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {
		System.out.println("Generate TrochanterMedialSurface");

		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochanterMedialSurface	
		if (currentPoints == null) {
			double circumference = 0.5;

			double x = -8.0;
			double y = -10.0;
			double z = -1.0;
			double[] startPos = {-1.50,-6.45, -4.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("TrochanterMedialSurface:01")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (parentID.equals("TrochanterMedialSurface:02")) {
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
				bioMightInstructSet.addElement(bioInstruct);
			}

		}

		// Generate the TrochanterMedialSurface	
		// generateComponentRows(startID, componentType, componentName,
		// componentID, currentPoints, bioMightInstructSet);
		// System.out.println("Generated the Rows for TrochanterMedialSurface: "
		// + componentID + "   parent: " + parentID + "   " + componentType);

		return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE TROCHANTER NECK
	 * 
	 * This generates the TrochanterNeck 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTrochanterNeck(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {

		System.out.println("Generate TrochanterNeck: " + componentID + "   " + parentID);


		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochanterNeck	
		if (currentPoints == null) {
			double circumference = 0.5;
			double[] startPos = {-8.0,-10.0, -1.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("TrochanterNeck:01")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, -0.250, 0.15);
				} 
				
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("TrochanterNeck:02")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.250, -0.250, 0.15);
				} 
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for TrochanterNeck: " + componentID + "   " + componentType);


		return returnCode;
	}
	    

	/***************************************************************************************
	 * GENERATE LATERAL EPICONDYLE 
	 * 
	 * This generates the LateralEpiCondyle 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLateralEpiCondyle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {

		System.out.println("Generate LateralEpiCondyle: " + componentID + "   " + parentID);


		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochanterNeck	
		if (currentPoints == null) {
			double circumference = 0.5;
			double[] startPos = {-8.0,-10.0, -1.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("LateralEpiCondyle:01")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, -0.250, 0.15);
				} 
				
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("LateralEpiCondyle:02")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.250, -0.250, 0.15);
				} 
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for LateralEpiCondyle: " + componentID + "   " + componentType);


		return returnCode;
	}
	 
	
	/***************************************************************************************
	 * GENERATE MEDIAL EPICONDYLE 
	 * 
	 * This generates the MedialEpiCondyle 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedialEpiCondyle(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException,
			DataSecurityException {

		System.out.println("Generate MedialEpiCondyle: " + componentID + "   " + parentID);


		int bodyID = 1;
		int projectID = 1;
		String vertices = "";

		ArrayList mySqlList = new ArrayList();
		int returnCode = 0;

		// Generate the TrochanterNeck	
		if (currentPoints == null) {
			double circumference = 0.5;
			double[] startPos = {-8.0,-10.0, -1.00};
			currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (componentID.equals("MedialEpiCondyle:01")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, -0.250, 0.15);
				} 
				
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		} else if (componentID.equals("MedialEpiCondyle:02")) {
			int nMaxSegs = 3;
			for (int numSegs = 0; numSegs < nMaxSegs; numSegs++) {

				// Create a place for an instruction
				BioMightInstruction bioInstruct = new BioMightInstruction();

				if (numSegs == 0) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 1) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.50, -0.50, 0.25);
				} else if (numSegs == 2) {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.250, -0.250, 0.15);
				} 
				
				else {
					bioInstruct.setTransType(TRANSLATE);
					bioInstruct.setTranslateMatrix(-1.0, -0.10, 0.0);
				}

				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

		}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generating the Rows for MedialEpiCondyle: " + componentID + "   " + componentType);


		return returnCode;
	}
	
}
