package biomight.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ejb.Stateless;

import org.apache.openejb.math.util.MathUtils;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightAppendage;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;



/***************************************************************************
 * Session Bean implementation class BioMightTissueBean
 * 
 * 
 ****************************************************************************/

@Stateless
public class BioMightCellularBean implements BioMightCellularBeanLocal {
	
	
    /**
     * Default constructor. 
     */
    public BioMightCellularBean() {
        // TODO Auto-generated constructor stub
    }

    
 	/***************************************************************************************
	 * GENERATE GOLGI APPARATUS
	 * 
	 * This generates the Golgi Apparatus
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateGolgiApparatusFold(String startID, String componentType, String componentName, String componentID,  String parentID, double radius, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateGolgiApparatusFold: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";		

 		double xAxis = 1.0;
 		double yAxis = 0.0;
 		double zAxis = 0.0;
 		double degrees = 0.0;
 		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double angle = 0.0;
		int returnCode = 0;
		
		
 		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
 			
 		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 4.00, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	 		

	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatusFold: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
				
				
		return returnCode;
	}
    
 	/***************************************************************************************
	 * GENERATE GOLGI APPARATUS
	 * 
	 * This generates the Golgi Apparatus
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateGolgiApparatus(String startID, String componentType, String componentName, String componentID,  String parentID, double radius, double[] startPos) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateGolgiApparatus: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";		

 		double xAxis = 1.0;
 		double yAxis = 0.0;
 		double zAxis = 0.0;
 		double degrees = 0.0;
 		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double angle = 0.0;
		int returnCode = 0;
		
		
		double[][] currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
 		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
 		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		// Create the firs fold
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 4.00, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	 	
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
			
		
		//******************************************************
		// Create the 2nd fold
		//******************************************************
		startPos[2] -= 0.00675;
 		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
 		startID = "GolgiApparatusEpithelium:00060";
 		
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.00, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
	
		
		//******************************************************
		// Create the 3rd fold
		//******************************************************

		startPos[1] += 0.00625;
		startPos[2] -= 0.0125;	
 		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
 		startID = "GolgiApparatusEpithelium:000120";
 		
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 6.25, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
	
		
		
		//******************************************************
		// Create the 4th fold
		//******************************************************

		//startPos[1] += 0.0125;
		startPos[2] -= 0.0125;	
 		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
 		startID = "GolgiApparatusEpithelium:000180";
 		
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 6.45, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
	
	
		
		/***
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 4.00, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	 		

	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
	
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
				bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 4.00, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	

	 		

	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for GolgiApparatus: " + parentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		****/
		
		
				
		return returnCode;
	}

	
    
 	/***************************************************************************************
	 * GENERATE ENDOPLASMIC RETICULUM
	 * 
	 * This generates the EndoplasmicReticulum
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
  	
public int generateEndoPlasmicReticulum(String startID, String componentType, String componentName, String componentID,  String parentID, double radius, double[] startPos) 
	throws DataException, DataSecurityException
{	
	System.out.println("generateEndoPlasmicReticulum: " + componentID + "   " + parentID);
	
	int bodyID = 1;
	int projectID = 1;
	String vertices = "";		

	double xAxis = 1.0;
	double yAxis = 0.0;
	double zAxis = 0.0;
	double degrees = 0.0;
		
	double xScale = 1.0;
	double yScale = 1.0;
	double zScale = 1.0;

	double xOrient = 0.0;
	double yOrient = 1.0;
	double zOrient = 0.0;
	double wOrient = 0.0;
	double angle = 0.0;
	int returnCode = 0;
		
	
	double[][] currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
	
	// Allocate an instruction set for building it
	BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
	// Create the firs fold
	int nMaxSegs = 5;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
	
	        
		if (numSegs==0){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
			bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
		}
  		else if (numSegs==1){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 4.00, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==2){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==3){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==4){
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==5)
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
		}
		else 
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
		}	

 	
		// Add the instruction into the instruction set
		bioMightInstructSet.addElement(bioInstruct);
	}
	
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for EndoPlasmicReticulum: " + parentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
	
	//******************************************************
	// Create the 2nd fold
	//******************************************************
	startPos[2] -= 0.00675;
		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
		startID = "EndoPlasmicReticulumEpithelium:00060";
		
	// Allocate an instruction set for building it
	bioMightInstructSet = new BioMightInstructSet();
	
	nMaxSegs = 5;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
	
	        
		if (numSegs==0){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
			bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
		}
  		else if (numSegs==1){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 5.00, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==2){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==3){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==4){
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==5)
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
		}
		else 
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
		}	


		// Add the instruction into the instruction set
		bioMightInstructSet.addElement(bioInstruct);
	}
	
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for EndoPlasmicReticulum: " + parentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);

	
	//******************************************************
	// Create the 3rd fold
	//******************************************************

	startPos[1] += 0.00625;
	startPos[2] -= 0.0125;	
		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
		startID = "EndoPlasmicReticulumEpithelium:000120";
		
	// Allocate an instruction set for building it
	bioMightInstructSet = new BioMightInstructSet();
	
	nMaxSegs = 5;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
	
	        
		if (numSegs==0){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
			bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
		}
  		else if (numSegs==1){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 6.25, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==2){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==3){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==4){
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==5)
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
		}
		else 
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
		}	


		// Add the instruction into the instruction set
		bioMightInstructSet.addElement(bioInstruct);
	}
	
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for EndoPlasmicReticulum: " + parentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);

	
	
	//******************************************************
	// Create the 4th fold
	//******************************************************

	//startPos[1] += 0.0125;
	startPos[2] -= 0.0125;	
		currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
		startID = "EndoPlasmicReticulumEpithelium:000180";
		
	// Allocate an instruction set for building it
	bioMightInstructSet = new BioMightInstructSet();
	
	nMaxSegs = 5;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
	
	        
		if (numSegs==0){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 5.0, 1.25);
			bioInstruct.setTranslateMatrix(-0.00125, 0.0, 0.0); 
		}
  		else if (numSegs==1){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 6.45, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==2){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0); 
		}
		else if (numSegs==3){
			bioInstruct.setTransType(Constants.SCALE);
			bioInstruct.setScaleMatrix(1.0, 1.10, 1.25);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==4){
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);     
		}
		else if (numSegs==5)
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(-0.0125, 0.0, 0.0);      
		}
		else 
		{
			bioInstruct.setTransType(Constants.TRANSLATE);
			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
		}	


		// Add the instruction into the instruction set
		bioMightInstructSet.addElement(bioInstruct);
	}
	
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for EndoPlasmicReticulum: " + parentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);

	
			
	return returnCode;
}

	
	
	/*******************************************************************************************
	 * GENERATE CELL MEMBRANE
	 * 
	 * This method will be called to generate a Cell Membrane in the database. 
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateCellMembrane(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double radius, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{
   		System.out.println("GenerateCellMembrane() " + componentID + "   " + parentID + "   with radius: " + radius);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		int returnCode = 0;

		double[] startPos = {0.0, 0.0, 0.0};
		
		if (currentPoints == null )
		{
			double circumference = 0.0025;	
			
			// Create a equilateral octogon	
    		//double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}		
		BioMightInstructSet bioMightInstructSet = null;
		

		if (parentID.contains(Constants.ErythrocyteRef))
   		{
   			System.out.println("In GenerateCellMembrane EJB method for: " + parentID);
   			startID="";

 
   			//radius = 0.0125;
   			
   			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
			
			int nMaxSegs = 18;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1000.0, 1000.0, 1000.0);
	    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0); 
				}
				else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
	    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.0); 
				}
				else if (numSegs==2){
		  			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0); 
				}	
				else if (numSegs==3){
		 			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				// Level Off
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==7){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==9){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==11){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
				}	
				else if (numSegs==13){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
				}
				else if (numSegs==14){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.75, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}	
				else if (numSegs==17){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.75, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				
				else {
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
	    			bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
	    		}				
	    				
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}

 			System.out.println("In GenerateCellMembrane EJB method - Generating Composable Shell");
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			System.out.println("Generated the Rows for cellMembrane: " + componentID + "   " + componentType);

 		}

		else if (parentID.contains(Constants.TreponemaPallidumRef))
   		{
   			System.out.println("In GenerateCellMembrane EJB method");
   			startID="";

 
   			radius = 0.0125;
   			
   			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
			
			int nMaxSegs = 48;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0125, 0, 0.0); 
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.125, 0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.ROTATEXMOVE);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setTranslateMatrix(0.125, 0.0,  0.0);
	     			bioInstruct.setOrientation(orientation);
				}	
				else if (numSegs == (nMaxSegs-1)){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.1, 0.1, 0.1);
	    			bioInstruct.setTranslateMatrix(0.0125, 0.0, 0.0);
				}
	    		else {
	    			bioInstruct.setTransType(Constants.ROTATEXMOVE);
	    			bioInstruct.setTheta(30);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setTranslateMatrix(0.125, 0.0,  0.0);
	     			bioInstruct.setOrientation(orientation);
	    		}				
	    				
								
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}

 			System.out.println("In GenerateCellMembrane EJB method - Generating Composable Shell");
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			System.out.println("Generated the Rows for cellMembrane: " + componentID + "   " + componentType);

 		}

		else if (parentID.contains(Constants.VibrioCholeraeRef))
   		{
   			System.out.println("In GenerateCellMembrane EJB method");
   			startID="";
   			
   			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
	
			int nMaxSegs = 17;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0125, 0, 0.0); 
				}
				else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(2, 2, 2);
	    			bioInstruct.setTranslateMatrix(0.0500, 0.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.125);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.125);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.125);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}	
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}		
				else if (numSegs==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, -0.125);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, -0.125);
				}
				else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0,  -0.125);
				}
				else if (numSegs==10){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0, -0.125);
				}
				else if (numSegs==11){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.175, 0.175, 0.175);
	    			bioInstruct.setTranslateMatrix(0.0125, 0.0,  -0.100);
				}
				else if (numSegs==12){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.350, 0.0, 0.0);
				}
				else if (numSegs==13){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.350, 0.0, 0.05);
				}
				else if (numSegs==14){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.350, 0.0, -0.07);
				}
				else if (numSegs==15){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.350, 0.0, 0.0);
				}
				else if (numSegs==16){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.350, 0.0, 0.1);
				}
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}

 			System.out.println("In GenerateCellMembrane EJB method - Generating Composable TearDrop Shell");
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			System.out.println("Generated the Rows for cellMembrane: " + componentID + "   " + componentType);

 		}
		else if (parentID.contains(Constants.ClostridiumTetaniRef))
   		{
   			System.out.println("In GenerateCellMembrane EJB method");
   			startID="";
   			
   			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
	
			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0125, 0, 0.0); 
				}
				else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(2, 2, 2);
	    			bioInstruct.setTranslateMatrix(0.0500, 0.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}
				else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
	    			bioInstruct.setTranslateMatrix(0.050, 0.0, 0.0);
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}	
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.250, 0, 0.0);
				}		
				else if (numSegs==7){
		  			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.0);
				}
				else if (numSegs==8){
		  			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.0);
				}
				else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.0);
				}
				else if (numSegs==10){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.0);
				}
				else if (numSegs==11){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.1, 0.1, 0.1);
	    			bioInstruct.setTranslateMatrix(0.0125, 0.0, 0.0);
				}
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}

 			System.out.println("In GenerateCellMembrane EJB method - Generating Composable TearDrop Shell");
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			System.out.println("Generated the Rows for cellMembrane: " + componentID + "   " + componentType);

 		}
   	
   		else
   		{
   			// Create the Sphere Representation
   			System.out.println("In GenerateCellMembrane EJB method - Generating Spherical Unit: " + radius);
   			DBUtils.generateSphereComponents(1, startPos, radius, componentType, componentName, parentID, currentPoints);
   		}
   		
		return returnCode;	
	}

	
	
   	
	/*******************************************************************************************
	 * GENERATE PEROXISOMES
	 * 
	 * This method will be called to generate a collection of Peroxisomes  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generatePeroxisomes(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = generateCells(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}
   	
   	
	
	/*******************************************************************************************
	 * GENERATE RIBOSOMES
	 * 
	 * This method will be called to generate a collection of Ribosomes  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateRibosomes(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = generateCells(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}
	
	
	/*******************************************************************************************
	 * GENERATE EOSINOPHILS
	 * 
	 * This method will be called to generate a collection of Eosinophils  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateEosinophils(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = generateCells(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}

   	
	/*******************************************************************************************
	 * GENERATE BASOPHILS
	 * 
	 * This method will be called to generate a collection of Basophils  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateBasophils(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = generateCells(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}

   
   	
	/*******************************************************************************************
	 * GENERATE CELLS
	 * 
	 * This method will be called to generate a collection of Cells.  It presents them in a random
	 * distribution  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	private int generateCells(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		System.out.println("In GenerateCells: " + startID);
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		double radius = 0.5;
		int colonyCount = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		

		//********************************************************************************************
		// Get the current colony size
		//********************************************************************************************
		String countQuery =
			"SELECT count(comp_id) from biomight.biocomp where comp_type = '" + componentType + "'";
		//System.out.println("generateell countQuery = " + countQuery);

		// Declare Statement and Result set 
		stmt3 = null;
		ResultSet rs = null;
		try {
			stmt3 = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt3.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting ColonyCount in generateCells()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		try {
			while (rs.next()) {	
				colonyCount = rs.getInt(1); 
				System.out.println("BioMightCellularBean.generateCells -  Count is: " + colonyCount);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getColonyCount- in generateCells():" + e.toString());
		} finally {
			try {
				if (stmt3 != null)
					stmt3.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getColonyCount - in generateCells():" + e.toString());	
			}
		}
		
		
		//********************************************************************************************
		// If the number of elements is greater than the current colonyCount, then amp up the
		//colony with new members.
		//********************************************************************************************
		if (numElements>colonyCount)
		{
			// Vars for processing
	  		int componentNum = 0;
			String componentBase = "";
			
			/*********
	  		try
			{
				System.out.println("Starting Basophil Creation at ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")));
				componentNum += colonyCount;
				componentBase = startID.substring(0,startID.indexOf(":"));
				System.out.println("Starting at : " + componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("GenerateCells - Bad Starting Position for Component:" + e.toString());
			} 
			********/
			
			//
			// Number of Elements is Greater then the current Colony Count so we need to 
			// increase it. 
			System.out.println("Current # of Cells is : " + colonyCount);
			componentBase = startID.substring(0,startID.indexOf(":"));
			
			// Generate the Component ID
			String newComponentID = "";
			colonyCount++;
			System.out.println("Creating New Cells at: " + colonyCount);

			
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			zPos = - (colonyCount * 0.75);

			// We are going to create from current Colony Count up to NumElements
			//int xMax=5;
			//int yMax=5;
			//int zMax=5;
			
			//double xRandom = 0.0;
			//double yRandom = 0.0;
			//double zRandom = 0.0;
			
			for (int i=colonyCount; i<=numElements; i++)
			{
				// Concat the instance to create a unique instance
				//int displace = i+1;
							
				// Generate the Component ID
				if (componentNum < 10)
					newComponentID = componentBase + ":0000" + i;
				else if (componentNum < 100)
					newComponentID = componentBase + ":000" + i;
				else if (componentNum < 1000)
					newComponentID = componentBase + ":00" + i;
				else if (componentNum < 10000)
					newComponentID = componentBase + ":0" + i;
				System.out.println("Creating New Cells with ID: " + newComponentID);

				xPos = (Math.random() * 10)/2;
				yPos = (Math.random() * 10)/2;
				zPos = (Math.random() * 10)/2;
				
				vertices = "" ;
				int depth_direction = 0;
				int depth = 1;
				String compGroup = "";
	    		
				// Insert the Component		
				String query =
					"INSERT into biomight.biocomp " +
					"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, texture, " +
					"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction ) " +
					"values (" 
					+ bodyID + "," + projectID + ",'" + newComponentID + "','" 
					+ componentType + "','" + componentName + "','" + componentName + "','" 
					+ parentID + "','" + boundbox + "','" + vertices + "',"
					+ "7, 0, " + xPos + "," + yPos + "," + zPos + "," 
					+ xScale + "," + yScale + "," + zScale + "," 
					+ radius + ",'" + + depth + "','" + compGroup + "'," + depth_direction + ")";
				System.out.println("generateCells INSERT = " + query);
		
				//Insert the Grouping
				String query2 =
					"INSERT into biomight.biogroup values('" + newComponentID + "','" + parentID + "')";
				System.out.println("generateCells GrpInsert = " + query2);
		
				
	
				// Declare Statement and Result set 
				stmt = null;
				try {
					stmt = con.prepareStatement(query);
					//System.out.println("Query is prepared");
					returnCode = stmt.executeUpdate();
					//System.out.println("Query has executed");
				} catch (Exception e) {
					System.out.println("Exception in inserting bioComp Data in generateCells()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
				
				// Decalre Statement and Result set 
				stmt2 = null;
				try {
					stmt2 = con.prepareStatement(query2);
					//System.out.println("Query2 is prepared");
					returnCode = stmt2.executeUpdate();
					//System.out.println("Query2 has executed");
				} catch (Exception e) {
					System.out.println("Exception in inserting bioGroup Data in generateCells()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
				
			}
				
			
			//System.out.println("Closing Connection: " + returnCode);
			try {
				if (stmt != null)
					stmt.close();
					
				if (stmt2 != null)
					stmt2.close();
				
				con.close();	
			} catch (Exception e) {
					System.out.println("Caught in Finally - generateCells():" + e.toString());	
			}
		
		}
		else
		{
			//*******************************************************************************
			// The number of elements is less than the current Colony count,so we must
			// cull the collection
			//*******************************************************************************
			
	  		int componentNum = numElements;
			String componentBase = "";
			String newComponentID = "";
			

			// Get the Starting Point based on the value sent into the method
	  		/********************8
			try
			{
				System.out.println("Starting Basophil Deletion at Base ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
				componentNum = colonyCount;
				componentBase = startID.substring(0,startID.indexOf(":"));
				System.out.println("Deleting at : " + componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("GenerateBasophils - Bad Starting Position for Component:" + e.toString());
			} 
			********/
			
			System.out.println("Prune Cells to ColonySize of : " + numElements);
			componentBase = startID.substring(0,startID.indexOf(":"));

			// Cull the elements from NumElements up to the current Colony Count
			// This will get rid of everything past the amount the user/app wants
			int startElement = numElements+1;
			for (int i=startElement; i<=colonyCount; i++)
			{
				// Concat the instance to create a unique instance
				//int displace = i+1;
							
				// Generate the Component ID
				if (componentNum < 10)
					newComponentID = componentBase + ":0000" + i;
				else if (componentNum < 100)
					newComponentID = componentBase + ":000" + i;
				else if (componentNum < 1000)
					newComponentID = componentBase + ":00" + i;
				else if (componentNum < 10000)
					newComponentID = componentBase + ":0" + i;
				System.out.println("Culling Cells with ID: " + newComponentID);

				// Insert the Component		
				String pruneQuery =
					"DELETE from biomight.biocomp where comp_id = '" + newComponentID + "'"; 
					//" and comp_id = '" +  + "'"; 
				System.out.println("generateCells delquery = " + pruneQuery);
		
				String pruneQuery2 =
					"DELETE from biomight.biogroup where comp_id = '" + newComponentID + "'";
					//" and comp_id = '" + newComponentID + "'"; 
				System.out.println("generateCells delquery = " + pruneQuery2);
		
				
					// Declare Statement and Result set 
				stmt = null;
				try {
					stmt = con.prepareStatement(pruneQuery);
					//System.out.println("Query is prepared");
					returnCode = stmt.executeUpdate();
					//System.out.println("Query has executed");
				} catch (Exception e) {
					System.out.println("Exception in deleting bioComp Data in generateCells()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
					
				// Decalre Statement and Result set 
				stmt2 = null;
				try {
					stmt2 = con.prepareStatement(pruneQuery2);
					//System.out.println("Query2 is prepared");
					returnCode = stmt2.executeUpdate();
					//System.out.println("Query2 has executed");
				} catch (Exception e) {
					System.out.println("Exception in deleting bioGroup Data in generateCells()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
			}
		}
						
		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
					
			if (stmt2 != null)
				stmt2.close();
				
			con.close();	
		} catch (Exception e) {
				System.out.println("Caught in Finally - generateCells():" + e.toString());	
		}			
		
		return returnCode;	
	}

   	
	
	/*******************************************************************************************
	 * GENERATE PILI
	 * 
	 * This method will be called to generate a collection of Cylinders. 
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
	   	private int generatePili(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
		{	
	   		System.out.println("In GeneratePili: " + startID);
	   	  	return( generateSurfacePosts(numElements, startID, componentType, componentName,  componentID,  parentID, currentPoints) ); 
		}

   	
		/*******************************************************************************************
		 * GENERATE SURFACE POSTS
		 * 
		 * This method will be called to generate a collection of Cylinders. 
		 *  
		 * @param key
		 * @param user
		 * @retur
		 * @throws DataException
		 * @throws DataSecurityException
		 ******************************************************************************************/
		
	   	private int generateSurfacePosts(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
		{	
			int returnCode = 0;
			
			System.out.println("In GeneratePili: " + startID);
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
			int colonyCount = 0;
			
			// Get the connection to the database
			Connection con = DBUtils.getConnection();
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			

			//********************************************************************************************
			// Get the current colony size
			//********************************************************************************************
			colonyCount = DBUtils.getComponentCount(bodyID, projectID, componentType, parentID);
			
			//********************************************************************************************
			// If the number of elements is greater than the current colonyCount, then amp up the
			//colony with new members.
			//********************************************************************************************
			if (numElements>colonyCount)
			{
				// Vars for processing
		  		int componentNum = 0;
				String componentBase = "";
				
				//
				// Number of Elements is Greater then the current Colony Count so we need to 
				// increase it. 
				System.out.println("Current # of Posts is : " + colonyCount);
				componentBase = startID.substring(0,startID.indexOf(":"));
				
				// Generate the Component ID
				String newComponentID = "";
				colonyCount++;
				System.out.println("Creating New Posts at: " + colonyCount);

				
				double radius = 0.5;
				double xPos = 0.0;
				double yPos = 0.0;
				double zPos = 0.0;
				double xScale = 1.0;
				double yScale = 1.0;
				double zScale = 1.0;
				double height = 1.0;
				double xOrient = 0.0;
				double yOrient = 1.0;
				double zOrient = 0.0;
				double wOrient = 0.0;

				zPos = - (colonyCount * 0.75);
				
				for (int i=colonyCount; i<=numElements; i++)
				{
					// Concat the instance to create a unique instance
					//int displace = i+1;
								
					// Generate the Component ID
					if (componentNum < 10)
						newComponentID = componentBase + ":0000" + i;
					else if (componentNum < 100)
						newComponentID = componentBase + ":000" + i;
					else if (componentNum < 1000)
						newComponentID = componentBase + ":00" + i;
					else if (componentNum < 10000)
						newComponentID = componentBase + ":0" + i;
					System.out.println("Creating New Posts with ID: " + newComponentID);

					xPos = (Math.random() * 10)/2;
					yPos = (Math.random() * 10)/2;
					zPos = (Math.random() * 10)/2;
					
					vertices = "" ;
					int depthDirection = 0;
					int depth = 1;
					String compGroup = "";

					
					
					// Insert the Component		
					String query =				
					"INSERT into biomight.biocomp " +
					"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, texture, " +
					"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction, " +
					"height, orientX, orientY, orientZ,  orientW) " +
					"values (" 
					+ bodyID + "," + projectID + ",'" + componentID + "','" 
					+ componentType + "','" + componentName + "','" + componentName + "','" 
					+ parentID + "','" + boundbox + "','" + vertices + "',"
					+ "7, 0, " + xPos + "," + yPos + "," + zPos + "," 
					+ xScale + "," + yScale + "," + zScale + "," 
					+ radius + ",'" + + depth + "','" + compGroup + "'," + depthDirection + ","   
					+ height  + "," + xOrient + "," +  yOrient + "," + zOrient + "," + wOrient + ")";
					System.out.println("generateSurfacePosts INSERT = " + query);
			

					
					//Insert the Grouping
					String query2 =
						"INSERT into biomight.biogroup values('" + newComponentID + "','" + parentID + "')";
					System.out.println("generateSurfacePosts GrpInsert = " + query2);
			
					
		
					// Declare Statement and Result set 
					stmt = null;
					try {
						stmt = con.prepareStatement(query);
						//System.out.println("Query is prepared");
						returnCode = stmt.executeUpdate();
						//System.out.println("Query has executed");
					} catch (Exception e) {
						System.out.println("Exception in inserting bioComp Data in generateSurfacePosts()");
						throw new DataException("Exception during prep of query:" + e.toString());
					}
					
					// Declare Statement and Result set 
					stmt2 = null;
					try {
						stmt2 = con.prepareStatement(query2);
						//System.out.println("Query2 is prepared");
						returnCode = stmt2.executeUpdate();
						//System.out.println("Query2 has executed");
					} catch (Exception e) {
						System.out.println("Exception in inserting bioGroup Data in generateSurfacePosts()");
						throw new DataException("Exception during prep of query:" + e.toString());
					}
					
				}
					
				
				//System.out.println("Closing Connection: " + returnCode);
				try {
					if (stmt != null)
						stmt.close();
						
					if (stmt2 != null)
						stmt2.close();
					
					con.close();	
				} catch (Exception e) {
						System.out.println("Caught in Finally - generateSurfacePosts():" + e.toString());	
				}
			
			}
			else
			{
				//*******************************************************************************
				// The number of elements is less than the current Colony count,so we must
				// cull the collection
				//*******************************************************************************
				
		  		int componentNum = numElements;
				String componentBase = "";
				String newComponentID = "";
				

				// Get the Starting Point based on the value sent into the method
		  		/********************
				try
				{
					System.out.println("Starting Basophil Deletion at Base ComponentID: " + startID);
					componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
					componentNum = colonyCount;
					componentBase = startID.substring(0,startID.indexOf(":"));
					System.out.println("Deleting at : " + componentBase + "   " + componentNum);
				}
				catch (Exception e) {
					System.out.println("GenerateBasophils - Bad Starting Position for Component:" + e.toString());
				} 
				********/
				
				System.out.println("Prune Cells to ColonySize of : " + numElements);
				componentBase = startID.substring(0,startID.indexOf(":"));

				// Cull the elements from NumElements up to the current Colony Count
				// This will get rid of everything past the amount the user/app wants
				int startElement = numElements+1;
				for (int i=startElement; i<=colonyCount; i++)
				{
					// Concat the instance to create a unique instance
					//int displace = i+1;
								
					// Generate the Component ID
					if (componentNum < 10)
						newComponentID = componentBase + ":0000" + i;
					else if (componentNum < 100)
						newComponentID = componentBase + ":000" + i;
					else if (componentNum < 1000)
						newComponentID = componentBase + ":00" + i;
					else if (componentNum < 10000)
						newComponentID = componentBase + ":0" + i;
					System.out.println("Culling SurfacePosts with ID: " + newComponentID);

					// Insert the Component		
					String pruneQuery =
						"DELETE from biomight.biocomp where comp_id = '" + newComponentID + "'"; 
						//" and comp_id = '" +  + "'"; 
					System.out.println("generateSurfacePosts delquery = " + pruneQuery);
			
					String pruneQuery2 =
						"DELETE from biomight.biogroup where comp_id = '" + newComponentID + "'";
						//" and comp_id = '" + newComponentID + "'"; 
					System.out.println("generateSurfacePosts delquery = " + pruneQuery2);
			
					
						// Declare Statement and Result set 
					stmt = null;
					try {
						stmt = con.prepareStatement(pruneQuery);
						//System.out.println("Query is prepared");
						returnCode = stmt.executeUpdate();
						//System.out.println("Query has executed");
					} catch (Exception e) {
						System.out.println("Exception in deleting bioComp Data in generateSurfacePosts()");
						throw new DataException("Exception during prep of query:" + e.toString());
					}
						
					// Decalre Statement and Result set 
					stmt2 = null;
					try {
						stmt2 = con.prepareStatement(pruneQuery2);
						//System.out.println("Query2 is prepared");
						returnCode = stmt2.executeUpdate();
						//System.out.println("Query2 has executed");
					} catch (Exception e) {
						System.out.println("Exception in deleting bioGroup Data in generateSurfacePosts()");
						throw new DataException("Exception during prep of query:" + e.toString());
					}
				}
			}
							
			//System.out.println("Closing Connection: " + returnCode);
			try {
				if (stmt != null)
					stmt.close();
						
				if (stmt2 != null)
					stmt2.close();
					
				con.close();	
			} catch (Exception e) {
					System.out.println("Caught in Finally - generateSurfacePosts():" + e.toString());	
			}			
			
			return returnCode;	
		}
  	
   
	/***************************************************************************************
  	 * GENERATE FIMBRIAE
  	 * 
  	 * This generates the Fimbriae by calling upon the child routine to create the
  	 * individual fimbria
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateFimbriae(int numElements, String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("Fimbriae: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		int returnCode = 0;
	
		double circumference = 0.25;	
		
		// Create a equilateral octogon	
		double[] startPos = {0.50, 0.0, 0.0};
		currentPoints = BioGraphics.octogonYPlane(startPos, circumference);

		generateFimbria(startID,  componentType,  componentName,  componentID,   parentID, currentPoints);
		System.out.println("Creating the next Fimbria: " + componentID + "   " + componentType);

		
		return returnCode;

  	}	

    
   	/***************************************************************************************
  	 * GENERATE FIMBRIA
  	 * 
  	 * This generates the Fimbria
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateFimbria(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateFimbria(): " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ExternalJugularVein
		if (currentPoints == null )
		{
			double circumference = 0.25;	
			
			// Create a equilateral octogon	
    		double[] startPos = {0.50, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 4;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.25);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.25);
			}		
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.10);
			}		
			else if (numSegs==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
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
		System.out.println("Generating the Rows for Fimbria: " + componentID + "   " + componentType);

		
		return returnCode;

  	}


  	/***************************************************************************************
  	 * GENERATE CAPSID
  	 * 
  	 * This directs the creation of a CAPSID for a variety virus types
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateCapsid(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateCapsid() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;

		if (componentID.startsWith(Constants.PoxVirusRef)) 
		{	
			// First determine if this component already has a slot
			System.out.println("GenerateCapsid - PoxVirus - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs - PoxVirus - exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("PoxVirusVirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}			
			
			//***********************************************
			// Create the Pox Virus 
		  	//***********************************************
		  	double[] nukStartPos = {0.0, 0.250, 0.00};
		  	double radius = 0.000625;
			double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
			
			// Move the point around, and connect it, creating a wall of 
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			
			int numInstructions = 11;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				// Make the name come out for the capsid
				//bioMightTransform.setComponentName("Capsid");
				
				// Place a transform object into each instruction set
				//bioInstruct.setBioMightTransform(bioMightTransform);
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(25, 25, 25);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.75,1.75, 1.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
				}
				
				
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
				}

				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}
		else if (componentID.startsWith(Constants.AdenovirusRef)) 
		{	
			
			// First determine if this component already has a slot
			System.out.println("GenerateCapsid -Adenovirus - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("Adenovirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}
	
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0); 
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.1, 0.1, 0.1);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0);
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
		else if (componentID.startsWith(Constants.BacteriophageRef)) 
		{	
			if (currentPoints == null )				
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}
	
			// First determine if this component already has a slot
			System.out.println("GenerateCapsid - Bacteriophage - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("Bacteriophage StartID is : " + startID);

			
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0); 
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.1, 0.1, 0.1);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0);
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
		else if (componentID.startsWith(Constants.InfluenzaAVirusRef)) 
		{
			// First determine if this component already has a slot
			System.out.println("GenerateCapsid - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("InfluenaAVirus StartID is : " + startID);
	
			// We can generate the ExternalJugularVein
			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}
	
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
			int nMaxSegs = 11;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(30.0, 30.0, 30.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0); 
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(20.0, 20.0, 20.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.20, 0.0); 
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.3, 1.3, 1.3);
	    			bioInstruct.setTranslateMatrix(0.0, -0.30, 0.0); 
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.2, 1.2, 1.2);
	    			bioInstruct.setTranslateMatrix(0.0, -0.40, 0.0); 
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.05, 1.05);
	    			bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0); 
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.10, 0.0);
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
	    			bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0); 
				}
				else if (numSegs==7){
					bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
	    			bioInstruct.setTranslateMatrix(0.0, -0.40, 0.0);
				}
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
					bioInstruct.setTranslateMatrix(0.0, -0.30, 0.0);
				}
				else if (numSegs==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
					bioInstruct.setTranslateMatrix(0.0, -0.20, 0.0);
				}
				else if (numSegs==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.01, 0.01, 0.01);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
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
		else
		{
			
		}
			    
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Capsid: " + componentID + "   " + componentType);

		
		return returnCode;

  	}


  	/***************************************************************************************
  	 * GENERATE VIRUS CORE MEMBRANE
  	 * 
  	 * This creates a Virus Core Membrane that is found in the Pox Virus
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateCoreMembrane(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateCoreMembrane() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;

		if (componentID.startsWith(Constants.PoxVirusRef)) 
		{	
			// First determine if this component already has a slot
			System.out.println("GenerateCoreMembrane - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("CoreMembrane StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}			
			
			//***********************************************
			// Create the Pox Virus 
		  	//***********************************************
		  	double[] nukStartPos = {0.0, 0.250, 0.00};
		  	double radius = 0.000625;
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
			
			// Move the point around, and connect it, creating a wall of 
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			
			int numInstructions = 11;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(25, 25, 15);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);   
					
					// Do not create appendages on the endcap
					bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(2.5, 2.5, 1.25);
					bioInstruct.setTranslateMatrix(0.0, -0.00225, 0.00); 
					
					// Do not create appendages on endcap
					bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.00);

					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.65, 0.65, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.65, 1.65, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);
					
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.98, 0.98, 0.98);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);
					
					// Do not create appendages on endcap
					//bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);
					
					// Do not create appendages on endcap
					bioInstruct.setBioMightAppendage(null);
				}
				
				
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
		
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}
		else if (componentID.startsWith(Constants.AdenovirusRef)) 
		{	
			
			// First determine if this component already has a slot
			System.out.println("GenerateCapsid - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("InfluenaAVirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}
	
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(10.0, 10.0, 10.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0); 
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				}
				else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.1, 0.1, 0.1);
	    			bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0);
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
		else
		{
			
		}
			    
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for CoreMembrane: " + componentID + "   " + componentType);

		
		return returnCode;

  	}


	/***************************************************************************************
  	 * GENERATE OUTER MEMBRANE
  	 * 
  	 * This creates the Outer Membrane
  	 * 
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateOuterMembrane(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateOuterMembrane() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;

		if (componentID.startsWith(Constants.PoxVirusRef)) 
		{	
			// First determine if this component already has a slot
			System.out.println("GeneratOuterMembrane - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("PoxVirusVirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}			
			
			//***********************************************
			// Create the Pox Virus 
		  	//***********************************************
		  	double[] nukStartPos = {0.0, 0.250, 0.00};
		  	double radius = 0.000625;
			double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
			
			// Move the point around, and connect it, creating a wall of 
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			
			int numInstructions = 11;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(25, 25, 25);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);
					bioInstruct.setBioMightAppendage(null);
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0);
					bioInstruct.setBioMightAppendage(null);	
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.75,1.75, 1.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   			
					bioInstruct.setBioMightAppendage(null);
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);     
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);
				}

				
				
				
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
				}

				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}	
		else
		{
			
		}
			    		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for OuterMembrane: " + componentID + "   " + componentType);

		return returnCode;

  	}


	/***************************************************************************************
  	 * GENERATE LATERAL BODY
  	 * 
  	 * This creates the Lateral Body of a Pox Virus
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateLateralBody(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateLateralBody() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;

		if (componentID.startsWith(Constants.PoxVirusRef)) 
		{	
			// First determine if this component already has a slot
			System.out.println("GeneratLateralBody - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("PoxVirusVirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}			
			
			//***********************************************
			// Create the Pox Virus 
		  	//***********************************************
		  	double[] nukStartPos = {0.0, 0.250, 0.00};
		  	double radius = 0.000625;
			double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
			
			// Move the point around, and connect it, creating a wall of 
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			
			int numInstructions = 11;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(20, 20, 20);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
				}
				
				
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
				}

				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}	
		else
		{
			
		}
			    		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for LateralBody: " + componentID + "   " + componentType);

		return returnCode;

  	}

	/***************************************************************************************
  	 * GENERATE MEMBRANE TUBULES
  	 * 
  	 * This creates a Virus Membrane Tubules
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateMembraneTubules(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateMembraneTubules() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;

		if (componentID.startsWith(Constants.PoxVirusRef)) 
		{	
			// First determine if this component already has a slot
			System.out.println("GenerateMembraneTubules - Getting MinID");
			int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
			
			if (startNum <= 0){
				startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
			}
			else
				System.out.println("Component Recs exist at: " + startNum);
			
			startID = DBUtils.convertComponentID(componentType, startNum); 
		 	System.out.println("PoxVirusVirus StartID is : " + startID);

			if (currentPoints == null )
			{
				double circumference = 0.0025;	
				
				// Create a equilateral octogon	
	    		double[] startPos = {0.0, 0.0, 0.0};
				currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}			
			
			//***********************************************
			// Create the Pox Virus 
		  	//***********************************************
		  	double[] nukStartPos = {0.0, 0.250, 0.00};
		  	double radius = 0.000625;
			double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
			
			// Move the point around, and connect it, creating a wall of 
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
			
			int numInstructions = 11;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(20, 20, 20);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
					bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
				}
				
				
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
					bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
				}
				else if (instructCount==14){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
				}

				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}	
		else
		{
			
		}
			    		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Capsid: " + componentID + "   " + componentType);

		return returnCode;

  	}

  
  	
	/***************************************************************************************
  	 * GENERATE CAPSID
  	 * 
  	 * This generates the CAPSID Sphere
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateCapsidSphere(double[] startPos, double radius, String componentType, String componentName, String componentID,  String parentID) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateCapsidSphere() " + componentID + "   " + parentID);
 		
 		int bodyID = 1;
 		int projectID = 1;
 		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		int colonyCount = 0;

 		int returnCode = 0;
 
 		double[][] currentPoints = null;
 		BioMightInstructSet instructSet = null;
 		DBUtils.generateSphereComponents(1, startPos, radius, componentType, componentName, parentID, currentPoints);
 		return returnCode;
   		
  	}

  	
  	
 	/***************************************************************************************
  	 * GET INSTRUCTION SET
  	 * 
  	 * This routine gets the stored instruction set from the persistent store thus that
  	 * the user or BioMight may re-manipulate it.
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public BioMightInstructSet getInstructionSet(int bodyID, int projectID, String componentType, String componentName, String componentID,  String parentID) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("getInstructionSet() for coomponentID: " + componentID + "   " + parentID);

		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		BioMightInstructSet bioMightInstructSet = null;
		
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
	
		int nMaxSegs = 11;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {

			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();

			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(30.0, 30.0, 30.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0); 
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20.0, 20.0, 20.0);
				bioInstruct.setTranslateMatrix(0.0, -0.20, 0.0); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.3, 1.3, 1.3);
				bioInstruct.setTranslateMatrix(0.0, -0.30, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.2, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.40, 0.0); 
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.05, 1.05, 1.05);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0); 
			}
			else if (numSegs==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.10, 0.0);
			}
			else if (numSegs==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0); 
			}
			else if (numSegs==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.40, 0.0);
			}
			else if (numSegs==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.0, -0.30, 0.0);
			}
			else if (numSegs==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.20, 0.0);
			}
			else if (numSegs==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.01, 0.01, 0.01);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
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

	
		return bioMightInstructSet;

  	}


  	

	/***************************************************************************************
  	 * GENERATE CAPSID TAIL
  	 * 
  	 * This generates the Capsid Tail
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateCapsidTail(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateCapsidTail() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// First determine if this component already has a slot
		System.out.println("GenerateCapsidTail - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("CapsidTail StartID is : " + startID);

		
		if (currentPoints == null )
		{
			double circumference = 0.0025;	
			
			// Create a equilateral octogon	
    		double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 4;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.045, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.045, 0.0);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.045, 0.0);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.045, 0.0);
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
		//System.out.println("Generated the Rows for CapsidTail: " + componentID + "   " + componentType);

		
		return returnCode;

  	}
  	
	/***************************************************************************************
  	 * GENERATE CAPSID NECK
  	 * 
  	 * This generates the Capsid Neck
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateCapsidNeck(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateCapsidNeck() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// First determine if this component already has a slot
		System.out.println("GenerateCapsidNeck - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	
		System.out.println("CapsidNeck StartID is : " + startNum);

		
		if (currentPoints == null )
		{
			double circumference = 0.0025;	
			
			// Create a equilateral octogon	
    		double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 1;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.250, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0);
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
		//System.out.println("Generated the Rows for CapsidNeck: " + componentID + "   " + componentType);

		
		return returnCode;

  	}	
  	
	
	/***************************************************************************************
  	 * GENERATE VIRUS BASEPLATE
  	 * 
  	 * This generates the Capsid Neck
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateVirusBasePlate(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateVirusBasePlate() " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// First determine if this component already has a slot
		System.out.println("GenerateVirusBasePlate - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("VirusBasePlate StartID is : " + startID);

		
		if (currentPoints == null )
		{
			double circumference = 0.0025;	
			
			// Create a equilateral octogon	
    		double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 2;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			   
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.08, 0.0); 
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.015, 0.0);
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
		//System.out.println("Generated the Rows for VirusBasePlate: " + componentID + "   " + componentType);

		
		return returnCode;

  	}	
  

  	 
 	/***************************************************************************************
   	 * GENERATE GLYCOPROTEIN SPIKES
   	 * 
   	 * This method will create a number of spikes on the outside of the capsid 
   	 *
   	 * @param key
   	 * @param user
   	 * @return
   	 * @throws DataException
   	 * @throws DataSecurityException
   	 ***************************************************************************************/
   	  	
   	public int generateGlycoProteinSpikes(int numElements, double radius, double cyRadius, double cyHeight, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
   		throws DataException, DataSecurityException
   	{	
 		System.out.println("generateGlycoProteinSpikes: " + componentID + "   " + parentID + " NumCreate: " + numElements);
 		
 		int bodyID = 1;
 		int projectID = 1;
 		int returnCode = 0;
 	
		BioMightInstructSet bioMightInstructSet = getInstructionSet(bodyID, projectID, componentType, componentName, componentID,  parentID); 
		System.out.println("Have generateGlycoProteinSpike!");
				
		//DBUtils.generateCylindricalComponents(numElements, radius, height, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for GlycoProteinSpikes: " + componentID + "   " + componentType);
		
		double[] startPos = {0.0, 0.0,0.0};
		DBUtils.generateCylindricalComponents(numElements, startPos, radius, cyRadius, cyHeight, componentType, componentName, componentID);
		System.out.println("Generated the Rows for GlycoProteinSpikes: " + componentID + "   " + componentType);
	
		
 		return returnCode;
   	}	
  	

    
 	/***************************************************************************************
   	 * GENERATE GLYCOPROTEIN SPIKE
   	 * 
   	 * This 
   	 *
   	 * @param key
   	 * @param user
   	 * @return
   	 * @throws DataException
   	 * @throws DataSecurityException
   	 ***************************************************************************************/
   	  	
   	public int generateGlycoProteinSpike(double[] startPos, double radius, double cyRadius, double cyHeight, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
   		throws DataException, DataSecurityException
   	{	
 		System.out.println("generateGlycoProteinSpike: " + componentID + "   " + parentID);
 		
 		int bodyID = 1;
 		int projectID = 1;
 		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		int colonyCount = 0;

 		int returnCode = 0;
 	
 		double xAxis = 1.0;
 		double yAxis = 0.0;
 		double zAxis = 0.0;
 		double degrees = 0.0;
 		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double angle = 0.0;
		
		
 		String componentBase="generateGlycoProteinSpike";
 		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
 		double[][] cylinder = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
 		String genComponentID = "";
 		//System.out.println("CylinderVertices: " + cylinder.length + "   with circumference: " + circumference);
 		//System.out.println("Raduis: " + radius + "  height: " + height);
 		
 
 		// Convert to a component ID
		genComponentID = DBUtils.convertComponentID(componentBase, 1); 
		//System.out.println("Creating New Fibers with ID: " + genComponentID);
		vertices = "" ;
		int depthDirection = 0;
		
		BioMightTransform bioMightTransform = new BioMightTransform(bodyID, projectID, genComponentID, componentType, componentName, parentID);
				
		bioMightTransform.setCreaseAngle(0.52);
		bioMightTransform.setMaterialID(7);
		bioMightTransform.setRadius(cyRadius);
		bioMightTransform.setHeight(cyHeight);

		bioMightTransform.setDepthDirection(depthDirection);
		BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
		bioMightTransform.setScale(bioMightScale);
		
 		//System.out.println("Current Position: " + cylinder[j][0] + "  " +  cylinder[j][1] + "  " + cylinder[j][2]);
		
 		// Set the Axis of Rotation
		xOrient = MathUtils.round(Math.cos(angle), 8);
		yOrient = 0;
		zOrient = MathUtils.round(Math.sin(angle),8);
		wOrient = 45;
		//System.out.println("Axis of Orientation: " + xOrient + "  " +  yOrient + "  " + zOrient);
		BioMightOrientation bioMightOrientation = new BioMightOrientation(xOrient, yOrient, zOrient, wOrient);
		bioMightTransform.setOrientation(bioMightOrientation);
		 
 		
 		double mirrorX = MathUtils.round(Math.cos(angle+180), 8);
		double mirrorY = 0;
		double mirrorZ = MathUtils.round(Math.sin(angle+180), 8);
 		//System.out.println("Mirror Position: " + mirrorX + "  " +  mirrorY + "  " + mirrorZ);
 		
 		double[][]onePoint = {{mirrorX, mirrorY, mirrorZ}};
 		double newPoints [][] = BioGraphics.applyRotation(currentPoints,  -1, 45, new double[] {mirrorX, mirrorY, mirrorZ });
		//System.out.println("Mirror Position After Rotation: " + newPoints[0][0] + "  " +  newPoints[0][1]  + "  " + newPoints[0][2] );
		 			
		DBUtils.upsertComponent(bioMightTransform);
 		
 		
 		return returnCode;
   	}	

    
 	/***************************************************************************************
   	 * GENERATE VIRUS TAIL FIBERS
   	 * 
   	 * This generates a collection of Virus Tail Fibers that are distributed around the
   	 * base of the currently generated virus model.   This method generates one database
   	 * record for each Tail component
   	 *
   	 * @param key
   	 * @param user
   	 * @return
   	 * @throws DataException
   	 * @throws DataSecurityException
   	 ***************************************************************************************/
   	  	
   	public int generateVirusTailFibers(int numElements, double[] startPos, double circumference,  double radius, double height, String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
   		throws DataException, DataSecurityException
   	{	
 		System.out.println("generateVirusTailFibers: " + componentID + "   " + parentID + " NumCreate: " + numElements);
 		
 		int bodyID = 1;
 		int projectID = 1;
 		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		int colonyCount = 0;

 		int returnCode = 0;
 	
 		double xAxis = 1.0;
 		double yAxis = 0.0;
 		double zAxis = 0.0;
 		double degrees = 0.0;
 		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;

		
		// Create the Positions where the fibers are going to be located equidistant from the center
 		String componentBase="VirusTailFiber";
 		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
 		double[][] cylinder = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, circumference, numElements);
 		String genComponentID = "";

 
		// First determine if this component already has a slot
		System.out.println("GenerateVirusTailFibers - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("Virus StartID is : " + startID);

 	
 		double angle = 0;
 		double incrementAngle = MathUtils.round(360/numElements, 8);
 		
 		// Stuff each one of the positions into a record in the database.
 		// Use the Angle of Orientation when building the object in detail so that
 		// we know what direction it is residing in
 		
 		for (int j=0; j<cylinder.length; j++)
 		{
	 		// Convert to a component ID
 			genComponentID = DBUtils.convertComponentID(componentBase, j+startNum); 
 			System.out.println("Creating New Fibers with ID: " + genComponentID + " derived from: " + (j+startNum) );
			vertices = "" ;
			int depthDirection = 0;
			
			BioMightTransform bioMightTransform = new BioMightTransform(bodyID, projectID, genComponentID, componentType, componentName, parentID);
					
			bioMightTransform.setCreaseAngle(0.52);
			bioMightTransform.setMaterialID(7);
			bioMightTransform.setRadius(radius);
			bioMightTransform.setHeight(height);

			bioMightTransform.setDepthDirection(depthDirection);
			BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
			bioMightTransform.setScale(bioMightScale);
			
	 		//System.out.println("Current Position: " + cylinder[j][0] + "  " +  cylinder[j][1] + "  " + cylinder[j][2]);
			
	 		// Set the Axis of Rotation and Orientation Angle
			// 
			xOrient = MathUtils.round(Math.cos(angle), 8);
			yOrient = 0;
			zOrient = MathUtils.round(Math.sin(angle),8);
			wOrient = j*incrementAngle;
			BioMightOrientation bioMightOrientation = new BioMightOrientation(xOrient, yOrient, zOrient, wOrient);
			bioMightTransform.setOrientation(bioMightOrientation);
			//System.out.println("Axis of Orientation: " + xOrient + "  " +  yOrient + "  " + zOrient);
					 
	 		
	 		double mirrorX = MathUtils.round(Math.cos(angle+180), 8);
			double mirrorY = 0;
			double mirrorZ = MathUtils.round(Math.sin(angle+180), 8);
	 		//System.out.println("Mirror Position: " + mirrorX + "  " +  mirrorY + "  " + mirrorZ);
	 		
	 		double[][]onePoint = {{mirrorX, mirrorY, mirrorZ}};
	 		double newPoints [][] = BioGraphics.applyRotation(currentPoints,  -1, 45, new double[] {mirrorX, mirrorY, mirrorZ });
			//System.out.println("Mirror Position After Rotation: " + newPoints[0][0] + "  " +  newPoints[0][1]  + "  " + newPoints[0][2] );
			 
			
	 		mirrorX = MathUtils.round(mirrorX*circumference, 8);
			mirrorY = 0;
			mirrorZ = MathUtils.round(mirrorZ*circumference, 8);
	 		//System.out.println("Mirror Position with Radius applied: " + mirrorX + "  " +  mirrorY + "  " + mirrorZ);
	 			
	 	
			
			// We need to displace the cylinders.....
			double tempX = MathUtils.round(cylinder[j][0] - mirrorX, 8);
			double tempY = cylinder[j][1];
			double tempZ = MathUtils.round(cylinder[j][2] - mirrorZ, 8);
			
			//System.out.println("Offset Position: " + tempX + "  " +  tempY + "  " + tempZ);
			
			BioMightPosition bioMightPosition = new BioMightPosition(tempX, tempY, tempZ);
			bioMightTransform.setTranslation(bioMightPosition);
			
			DBUtils.upsertComponent(bioMightTransform);

			angle+=60;
 		}
 		
 		return returnCode;
   	}	
  	
  	
    
 	/***************************************************************************************
   	 * GENERATE VIRUS TAIL FIBERS - UNDONE!!!!
   	 * 
   	 * This generates a collection of Virus Tail Fibers that are distributed around the
   	 * base of the currently generated virus model.   This methhod generates one database
   	 * record for each Tail component
   	 *
   	 * @param key
   	 * @param user
   	 * @return
   	 * @throws DataException
   	 * @throws DataSecurityException
   	 ***************************************************************************************/
   	  	
   	public int generateVirusTailFibersDontKnow(int numElements, String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
   		throws DataException, DataSecurityException
   	{	
 		System.out.println("generateVirusTailFibers: " + componentID + "   " + parentID + " NumCreate: " + numElements);
 		
 		int bodyID = 1;
 		int projectID = 1;
 		String vertices = "";
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		int colonyCount = 0;

 		int returnCode = 0;
 	
 		double radius = 0.0025;

 		// Set up initial position
 		double xPos = 0.0;
 		double yPos = 0.0;
 		double zPos = 0.0;
 		
 		double xAxis = 1.0;
 		double yAxis = 0.0;
 		double zAxis = 0.0;
 		double degrees = 0.0;
 		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double height = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;

		
 		String componentBase="VirusTailFiber";
 	
 		// Create a Hexagon
 		double[] startPos = {xPos, yPos, zPos};
 		double[] startOrient = {xAxis, yAxis, zAxis, degrees};
 		
 		// Create one cylinder that represents that starting points
 		double[][] innerCylinder = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
 		
 		double[][] outerCylinder = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, 1.5 * radius, 6);
 		
 		//  Use a rotation Algorith to determine where the Tail Fiber Record will be located

	 		
		//********************************************************************************************
		// Get the current colony size 
		//********************************************************************************************
		colonyCount = DBUtils.getComponentCount(bodyID, projectID, componentType, parentID);
									
		// Generate the New Component ID
		String newComponentID = "";
		colonyCount++;
		//System.out.println("Creating New Fibers at: " + colonyCount);
			
		for (int j=colonyCount; j<=numElements; j++)
		{	
				//System.out.println("Creating New Posts with ID: " + newComponentID);
				
				// We need to keep a running count of the ID so we generate unique records
				int componentNum = (j*5)+1;
		 		
		 		// Convert to a component ID
		 		startID = DBUtils.convertComponentID(componentBase, componentNum); 
		 	
				//System.out.println("Creating New Posts with ID: " + newComponentID);
	 		
				xPos = (Math.random() * 10)/2;
				yPos = (Math.random() * 10)/2;
				zPos = (Math.random() * 10)/2;
				
				vertices = "" ;
				int depthDirection = 0;
				int depth = 1;
				String compGroup = "";

				
				
				BioMightTransform bioMightTransform = new BioMightTransform(bodyID, projectID, newComponentID, componentType, componentName, parentID);
				
				BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);
				bioMightTransform.setTranslation(bioMightPosition);
			
				bioMightTransform.setTranslation(bioMightPosition);
				bioMightTransform.setCreaseAngle(0.52);
				bioMightTransform.setMaterialID(7);
				bioMightTransform.setRadius(radius);
				bioMightTransform.setDepthDirection(depthDirection);
				BioMightScale bioMightScale = new BioMightScale(xScale, yScale, zScale);
				bioMightTransform.setScale(bioMightScale);
					
				DBUtils.insertComponent(bioMightTransform);
						
			
	 		
     		
	 		// Set the Tail Fibers Uniformily around the tail based on the number
 			// get Distribution points
 			xPos += 0.20;
 			zPos -= 0.20;
 		}
 		
 		return returnCode;
   	}	
  	
   	

  

	/***************************************************************************************
  	 * GENERATE VIRUS TAIL FIBER
  	 * 
  	 * This generates the Virus Tail Fiber. 
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
 	  
   	
  	public int generateVirusTailFiber(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints, double[] startOrient) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateVirusTailFiber() FACES  " + startID + "    "  + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		int returnCode = 0;

		if (startOrient == null )
		{
	 		double degrees = 0.0;
			startOrient[0] = 1.0;
			startOrient[1] = 0.0;
			startOrient[2] = 0.0;
			startOrient[3] = degrees;
		}
		
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);

		int nMaxSegs = 9;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
	  		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.0);	
    		}
     		else if (numSegs==1){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.25, 0.0);	
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.25, 0.0);	
    		}
    		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.25, 0.0);		
    		}
     		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.25, 0.0);		
    		}	
     		else if (numSegs==7){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
			
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
			    
		
		//DBUtils.generateCylinderThread(startID, componentType, componentName, componentID, startPos, startOrient, bioMightInstructSet);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for generateVirusTailFiber: " + componentID + "   " + componentType);

		
		return returnCode;

  	}
  	
  	
	/***************************************************************************************
  	 * GENERATE VIRUS TAIL FIBER
  	 * 
  	 * This generates the Virus Tail Fiber
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
  	  	
  	public int generateVirusTailFiber(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("generateVirusTailFiber()  " + startID + "    "  + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// First determine if this component already has a slot
		System.out.println("GenerateVirusTailFiber - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("VirusTailFiber StartID is : " + startID);

	 	
	 	
		if (currentPoints == null )
		{
			double circumference = 0.0005;	
			
			// Create a equilateral octogon	
    		double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
			}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();


		int nMaxSegs = 1;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
     
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.015, 0.0);
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
		//System.out.println("Generated the Rows for generateVirusTailFiber: " + componentID + "   " + componentType);

		
		return returnCode;

  	}	
  	
  	

	/***************************************************************************************
  	 * GENERATE VIRUS TAIL FIBER SEGMENT
  	 * 
  	 * This generates the VirusTailFiberSegment
  	 *
  	 * @param key
  	 * @param user
  	 * @return
  	 * @throws DataException
  	 * @throws DataSecurityException
  	 ***************************************************************************************/
 	  
   	
  	public int generateVirusTailFiberSegment(double rotateAngle, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
  		throws DataException, DataSecurityException
  	{	
		System.out.println("CellularBean:generateVirusTailFiberSegment()  " + rotateAngle + "    "  + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		int returnCode = 0;

		// First determine if this component already has a slot
		System.out.println("GenerateVirusTailFiberSegment - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateComponents().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		String startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("VirusTailFiberSegment StartID is : " + startID);

		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		
		// The first leg starts off at 0 degrees and goes East along the X-axis
		// We displace along X and vary the height on Y.  Z remains static
		if (rotateAngle == 0.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);		
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);		
	    		}
	     		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}
	     		else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}	
	    		else if (numSegs==10){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}	
	       		else if (numSegs==11){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}
	
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		// The second leg starts off at 60 degrees and goes NNE
		// We displace along X and Z using sin/cos functions and vary the height on Y.
		else if (rotateAngle == 60.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, -0.016);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, -0.016);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, -0.016);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, -0.016);
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, -0.016);	
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, -0.016);
	    		}
	     		else if (numSegs==8){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, -0.016);
	    		}
	     		else if (numSegs==9){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, -0.016);
	    		}	
	    		else if (numSegs==10){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, -0.016);
	    		}	
	       		else if (numSegs==11){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, -0.016);
	    		}
	
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		// The third leg starts off at 120 degrees and goes NNW
		// We displace along -X and -Z using sin/cos functions and vary the height on Y.		
		else if (rotateAngle == 120.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
								
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, -0.016);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, -0.016);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, -0.016);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, -0.016);
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, -0.016);	
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, -0.016);
	    		}
	     		else if (numSegs==8){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, -0.016);
	    		}
	     		else if (numSegs==9){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, -0.016);
	    		}	
	    		else if (numSegs==10){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, -0.016);
	    		}	
	       		else if (numSegs==11){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, -0.016);
	    		}

	
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		// The third leg starts off at 180 degrees and goes WEST
		// We displace along -X and -Z using sin/cos functions and vary the height on Y.		
		else if (rotateAngle == 180.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, 0.035, 0.0);		
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(15);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(15);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.035, 0.0);		
	    		}
	     		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.035, 0.0);	
	    		}
	     		else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.035, 0.0);	
	    		}	
	    		else if (numSegs==10){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.035, 0.0);	
	    		}	
	       		else if (numSegs==11){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.035, 0.0);	
	    		}
		  		
		  		
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		// The third leg starts off at 240 degrees and goes WSW
		// We displace along -X and vary the height on Y.  Z remains constant		
		else if (rotateAngle == 240.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, 0.016);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, 0.016);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, 0.016);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, 0.016);
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, 0.035, 0.016);	
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, 0.016);
	    		}
	     		else if (numSegs==8){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, 0.016);
	    		}
	     		else if (numSegs==9){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, 0.016);
	    		}	
	    		else if (numSegs==10){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, 0.016);
	    		}	
	       		else if (numSegs==11){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.009, -0.035, 0.016);
	    		}
		  		
		  		
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		// The third leg starts off at 300 degrees and goes SSE
		// We displace along -X and vary the height on Y.  Z remains constant		
		else if (rotateAngle == 300.0) {

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, 0.016);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, 0.016);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, 0.016);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, 0.016);
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, 0.035, 0.016);	
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, 0.016);
	    		}
	     		else if (numSegs==8){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, 0.016);
	    		}
	     		else if (numSegs==9){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, 0.016);
	    		}	
	    		else if (numSegs==10){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, 0.016);
	    		}	
	       		else if (numSegs==11){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.009, -0.035, 0.016);
	    		}
		  		
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
		else 
		{

			int nMaxSegs = 12;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	     
				
		  		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==1){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	     		else if (numSegs==2){
	     			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);	
	    		}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, 0.035, 0.0);		
	    		}
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
	    		}
	     		else if (numSegs==6){
	      			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);		
	    		}	
	     		else if (numSegs==7){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);		
	    		}
	     		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}
	     		else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}	
	    		else if (numSegs==10){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}	
	       		else if (numSegs==11){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.025, -0.035, 0.0);	
	    		}
	
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
			   
		}
	
		
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for generateVirusTailFiberSegment: " + componentID + "   " + componentType);

		
		return returnCode;

  	}
  		
  	
  	/***************************************************************************************
	 * GENERATE SPIROCHETE
	 * 
	 * This generates a spirochaete 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateSpirochete(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("Enter GenerateSpirochete()");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;

 		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null) {
			double circumference = 0.4;
			double[] startPos = {-2.0,-24.0, -4.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
		
		
		// First determine if this component already has a slot
		System.out.println("GenerateSpirochete - Getting MinID");
		int startNum = DBUtils.getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateSpirochete().GenerateMinStart at: " + startNum);
		
		if (startNum <= 0){
			startNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + startNum);
		}
		else
			System.out.println("Component Recs exist at: " + startNum);
		
		String startID = DBUtils.convertComponentID(componentType, startNum); 
	 	System.out.println("Spirochete StartID is : " + startID);

		
		double[][] nextPoints = { 
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0},
   				{0, 0, 0}
    		};	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		
		int nMaxSegs = 30; 
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
    		// Extend out from the terminus of the Knee
  
			// Leave Stomach heading towards right body wall
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==1){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.45, 0.0);	
    		}
    		// Turn and head down
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}	
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		} 
     		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.00, 0.0);	
    		}
    		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}		
     		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.10);	
    		}
     		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.05, 0.0);	
    		}
     		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.0);	
    		}
     		else if (numSegs==13){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.15, -0.05);	
    		}
      		else if (numSegs==14){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.25, 0.0);	
    		}
    		else if (numSegs==15){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==16){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.650, 0.0);	
    		}
    		else if (numSegs==17){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.850, 0.15);	
    		}
    		else if (numSegs==18){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==19){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==20){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==21){
    			
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==22){
     			
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.10, -0.75, 0.0);	
    		}
    		else if (numSegs==23){
     			
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);	
    		}
    		else if (numSegs==24){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
     		else if (numSegs==25){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
     		else if (numSegs==26){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==27){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, -0.15, 0.0);
    		}
    		else if (numSegs==28){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, -0.10, 0.0);
    		}	
    		else if (numSegs==29){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.0, -0.20);	
    		}
    		else if (numSegs==30){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.05, -0.35);
    		}
     		else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.00, -1.0, 0.0);		
    		}
    		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the Small Intestine
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
  	
  	
	 /***************************************************************************************
	 * GENERATE Erythrocyte
	 * 
	 * This method generates Blood for use within the Vascular System.
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
  	public int generateEurythrocyte(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints)   	
		throws DataException, DataSecurityException
	{	
		System.out.println("generateEurythrocyte: " + componentID + "   " + parentID);
		
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
			double radius = 0.125;
			// Generate the Palm
			double[] startPos = {-0.3,-17.0,-3.0};
			currentPoints = BioGraphics.octogonXPlane(startPos, radius);
		}

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		int nMaxSegs = 6;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
    
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.15, 0.10);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.20);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.50);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
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
		System.out.println("Generated the Rows for Eurythrocyte: " + componentID + "   parent: " + parentID + "   " + componentType);
		
		return returnCode;
	}
  	
  	

	 /***************************************************************************************
	 * GENERATE MITOCHONDRIA
	 * 
	 * This method generates Blood for use within the Vascular System.
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
 	public int generateMitochondria(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints)   	
		throws DataException, DataSecurityException
	{	
		System.out.println("generateMitochondria: " + componentID + "   " + parentID);
		
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
			double radius = 0.125;
			// Generate the Palm
			double[] startPos = {0.0, 0.0, 0.0};
			currentPoints = BioGraphics.octogonXPlane(startPos, radius);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		int nMaxSegs = 6;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
	
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
   
			if (numSegs==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.25);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.15, 0.10);
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.20);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(1.0, -0.10, 0.50);
			}
			else if (numSegs==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
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
		System.out.println("Generated the Rows for Mitochondria: " + componentID + "   parent: " + parentID + "   " + componentType);
		
		return returnCode;
	}
  	
  	
}
