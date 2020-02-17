package biomight.ejb;

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
public class BioMightLigamentBean implements BioMightLigamentBeanLocal {
	private static final int ROTATE  = 1;
	private static final int TRANSLATE  = 2;
	private static final int SCALE  = 3;
	
	
    /*************************************************************
     * Default constructor. 
     * 
     ************************************************************/
	
    public BioMightLigamentBean() {
        // TODO Auto-generated constructor stub
    }
    
 
	
    /***************************************************************************************
	 * GENERATE ANTERIOR COSTO TRANSVERSE LIGAMENT 
	 * 
	 * This generates the AnteriorCostoTransverseLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateAnteriorCostoTransverseLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("AnteriorCostoTransverseLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the AnteriorCostoTransverseLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorCostoTransverseLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("AnteriorCostoTransverseLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for AnteriorCostoTransverseLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ANTERIOR SACROCOCCYGEAL LIGAMENT 
	 * 
	 * This generates the AnteriorSacrococcygealLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateAnteriorSacrococcygealLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("AnteriorSacrococcygealLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the AnteriorCostoTransverseLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorSacrococcygealLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("AnteriorSacrococcygealLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for AnteriorSacrococcygealLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ANTERIOR SACROILIAC LIGAMENT 
	 * 
	 * This generates the AnteriorSacroiliacLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateAnteriorSacroiliacLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("AnteriorSacroiliacLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the AnteriorSacroiliacLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorSacroiliacLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("AnteriorSacroiliacLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for AnteriorSacroiliacLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE GASTROLIENAL LIGAMENT 
	 * 
	 * This generates the GastrolienalLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateGastrolienalLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GastrolienalLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the GastrolienalLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("GastrolienalLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("GastrolienalLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for GastrolienalLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ILIOLUMBAR LIGAMENT 
	 * 
	 * This generates the IliolumbarLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateIliolumbarLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("IliolumbarLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the IliolumbarLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("IliolumbarLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("IliolumbarLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for IliolumbarLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INTEROSSEOUS SACROILIAC LIGAMENT 
	 * 
	 * This generates the InterosseousSacroiliacLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateInterosseousSacroiliacLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("InterosseousSacroiliacLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the InterosseousSacroiliacLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double radius = 0.25;
    		double[] startPos = {-0.50,-8.0, -7,25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("InterosseousSacroiliacLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("InterosseousSacroiliacLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for InterosseousSacroiliacLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL SACROCOCCYGEAL LIGAMENT 
	 * 
	 * This generates the LateralSacrococcygealLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLateralSacrococcygealLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("LateralSacrococcygealLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the LateralSacrococcygealLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LateralSacrococcygealLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("LateralSacrococcygealLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LateralSacrococcygealLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LIGAMENT 
	 * 
	 * This generates the Ligament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("Ligament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the Ligament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Ligament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("Ligament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LIGAMENTS 
	 * 
	 * This generates the Ligaments
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLigaments(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("Ligaments: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the Ligaments alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("Ligaments:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("Ligaments:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LigamentsEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LIGAMENTUM PUBICUM INFERNIUS
	 * 
	 * This generates the LigamentumPubicumInferius
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLigamentumPubicumInferius(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("LigamentumPubicumInferius: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the LigamentumPubicumInferius alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LigamentumPubicumInferius:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("LigamentumPubicumInferius:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LigamentumPubicumInferiusEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PHRENICOLIENAL LIGAMENT
	 * 
	 * This generates the PhrenicolienalLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePhrenicolienalLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("PhrenicolienalLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the PhrenicolienalLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PhrenicolienalLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("PhrenicolienalLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PhrenicolienalLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR SACROCOCCYGEAL LIGAMENT
	 * 
	 * This generates the PosteriorSacrococcygealLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePosteriorSacrococcygealLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("PosteriorSacrococcygealLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the PosteriorSacrococcygealLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorSacrococcygealLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("PosteriorSacrococcygealLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PosteriorSacrococcygealLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR SACROILIAC LIGAMENT
	 * 
	 * This generates the PosteriorSacroiliacLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePosteriorSacroiliacLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("PosteriorSacroiliacLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the PosteriorSacroiliacLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorSacroiliacLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("PosteriorSacroiliacLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PosteriorSacroiliacLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RETINACULUM MUSCULORUM FLEXORUM PEDIS
	 * 
	 * This generates the RetinaculumMusculorumFlexorumPedis
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateRetinaculumMusculorumFlexorumPedis(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("RetinaculumMusculorumFlexorumPedis: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the RetinaculumMusculorumFlexorumPedis alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("RetinaculumMusculorumFlexorumPedis:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("RetinaculumMusculorumFlexorumPedis:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for RetinaculumMusculorumFlexorumPedisEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUSPENSORY LIGAMENT
	 * 
	 * This generates the SuspensoryLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateSuspensoryLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("SuspensoryLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the SuspensoryLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("SuspensoryLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("SuspensoryLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for SuspensoryLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ANTERIOR TALOFIBULAR LIGAMENT
	 * 
	 * This generates the AnteriorTalofibularLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateAnteriorTalofibularLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("AnteriorTalofibularLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the AnteriorTalofibularLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("AnteriorTalofibularLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("AnteriorTalofibularLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for AnteriorTalofibularLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE CALCANEOFIBULAR LIGAMENT
	 * 
	 * This generates the CalcaneofibularLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateCalcaneofibularLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("CalcaneofibularLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the CalcaneofibularLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("CalcaneofibularLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("CalcaneofibularLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for CalcaneofibularLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DELTOID LIGAMENT
	 * 
	 * This generates the DeltoidLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateDeltoidLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("DeltoidLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the DeltoidLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("DeltoidLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("DeltoidLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for DeltoidLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LONG PLANTAR LIGAMENT
	 * 
	 * This generates the LongPlantarLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLongPlantarLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("LongPlantarLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the LongPlantarLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LongPlantarLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("LongPlantarLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LongPlantarLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE POSTERIOR TALOFIBULAR LIGAMENT
	 * 
	 * This generates the PosteriorTalofibularLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePosteriorTalofibularLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("PosteriorTalofibularLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the PosteriorTalofibularLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PosteriorTalofibularLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("PosteriorTalofibularLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PosteriorTalofibularLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ELBOW ANTERIOR LIGAMENT
	 * 
	 * This generates the ElbowAnteriorLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateElbowAnteriorLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("ElbowAnteriorLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the ElbowAnteriorLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("ElbowAnteriorLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("ElbowAnteriorLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for ElbowAnteriorLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ELBOW POSTERIOR LIGAMENT
	 * 
	 * This generates the ElbowPosteriorLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateElbowPosteriorLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("ElbowPosteriorLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the ElbowPosteriorLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("ElbowPosteriorLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("ElbowPosteriorLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for ElbowPosteriorLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE RAIDAL COLLATERAL LIGAMENT
	 * 
	 * This generates the RadialCollateralLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateRadialCollateralLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("RadialCollateralLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the RadialCollateralLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("RadialCollateralLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("RadialCollateralLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for RadialCollateralLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE ULNAR COLLATERAL LIGAMENT
	 * 
	 * This generates the UlnarCollateralLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateUlnarCollateralLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("UlnarCollateralLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the UlnarCollateralLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("UlnarCollateralLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("UlnarCollateralLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for UlnarCollateralLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE NATATORY LIGAMENT
	 * 
	 * This generates the NatatoryLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateNatatoryLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("NatatoryLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the NatatoryLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("NatatoryLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("NatatoryLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for NatatoryLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VOLAR CARPAL LIGAMENT
	 * 
	 * This generates the VolarCarpalLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateVolarCarpalLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("VolarCarpalLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the VolarCarpalLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("VolarCarpalLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("VolarCarpalLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for VolarCarpalLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE DORSAL LIGAMENTS
	 * 
	 * This generates the DorsalLigaments
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateDorsalLigaments(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("DorsalLigaments: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the DorsalLigaments alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("DorsalLigaments:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("DorsalLigaments:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for DorsalLigamentsEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE INTEROSSEOUS LIGAMENTS
	 * 
	 * This generates the InterosseousLigaments
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateInterosseousLigaments(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("InterosseousLigaments: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the InterosseousLigaments alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("InterosseousLigaments:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("InterosseousLigaments:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for InterosseousLigamentsEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE VOLAR LIGAMENTS
	 * 
	 * This generates the VolarLigaments
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateVolarLigaments(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("VolarLigaments: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the VolarLigaments alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("VolarLigaments:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("VolarLigaments:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for VolarLigamentsEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE LATERAL CANTHAL TENDON
	 * 
	 * This generates the LateralCanthalTendon
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLateralCanthalTendon(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("LateralCanthalTendon: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the LateralCanthalTendon alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("LateralCanthalTendon:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("LateralCanthalTendon:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for LateralCanthalTendonEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE MEDIAL CANTHAL TENDON
	 * 
	 * This generates the MedialCanthalTendon
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateMedialCanthalTendon(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("MedialCanthalTendon: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the MedialCanthalTendon alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("MedialCanthalTendon:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("MedialCanthalTendon:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for MedialCanthalTendonEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE SUPERIOR OBLIQUE TENDON
	 * 
	 * This generates the SuperiorObliqueTendon
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateSuperiorObliqueTendon(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("SuperiorObliqueTendon: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the SuperiorObliqueTendon alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("SuperiorObliqueTendon:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("SuperiorObliqueTendon:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for SuperiorObliqueTendonEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE PERIODONTAL LIGAMENT
	 * 
	 * This generates the PeriodontalLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePeriodontalLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("PeriodontalLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the PeriodontalLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("PeriodontalLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("PeriodontalLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PeriodontalLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE HIP ARTICULAR CAPSULE LIGAMENT
	 * 
	 * This generates the HipArticularCapsuleLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHipArticularCapsuleLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("HipArticularCapsuleLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the HipArticularCapsuleLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("HipArticularCapsuleLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("HipArticularCapsuleLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for HipArticularCapsuleLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	
	
	
	
	
	/***************************************************************************************
	 * GENERATE HIP GLENOIDAL LABRUM LIGAMENT
	 * 
	 * This generates the HipGlenoidalLabrumLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHipGlenoidalLabrumLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("HipGlenoidalLabrumLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the HipGlenoidalLabrumLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("HipGlenoidalLabrumLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("HipGlenoidalLabrumLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for HipGlenoidalLabrumLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
	
	
	
	
	/***************************************************************************************
	 * GENERATE ILIO FENORAL LIGAMENT
	 * 
	 * This generates the IlioFemoralLigament
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateIlioFemoralLigament(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("IlioFemoralLigament: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// We can generate the IlioFemoralLigament alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double circumference = 0.25;
			
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
			// Create a equilateral octogon	
			currentPoints[0][0] =  x;
			currentPoints[0][1] =  y;
			currentPoints[0][2] =  z;
			
			currentPoints[1][0] =  x-circumference;
			currentPoints[1][1] =  y;
			currentPoints[1][2] =  z-circumference;
			
			currentPoints[2][0] =  x-circumference;
			currentPoints[2][1] =  y;
			currentPoints[2][2] =  z-circumference*2;
			
			currentPoints[3][0] =  x;
			currentPoints[3][1] =  y;
			currentPoints[3][2] =  z-circumference*3;
	
			currentPoints[4][0] =  x+circumference;
			currentPoints[4][1] =  y;
			currentPoints[4][2] =  z-circumference*3;
			
			currentPoints[5][0] =  x+circumference*2;
			currentPoints[5][1] =  y;
			currentPoints[5][2] =  z-circumference*2;
	
			currentPoints[6][0] =  x+circumference*2;
			currentPoints[6][1] =  y;
			currentPoints[6][2] =  z-circumference;

			currentPoints[7][0] =  x+circumference;
			currentPoints[7][1] =  y;
			currentPoints[7][2] =  z;
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		if (parentID.equals("IlioFemoralLigament:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(1);
        			bioInstruct.setTheta(45.0);
          			bioInstruct.setRotateVector(0.0, 0.0, -1.0);
        			bioInstruct.setPivotPoint(7);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-1.0, -0.25, 0.0);
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
	    
		} else if (parentID.equals("IlioFemoralLigament:02")) {	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(1.0, -0.25, 0.0);
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
		    
		}
	
		
		//generateComponentRows(startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for IlioFemoralLigamentEpithelium: " + componentID + "   " + componentType);
		
	return returnCode;
	}
    
}

