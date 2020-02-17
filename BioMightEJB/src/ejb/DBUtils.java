package biomight.ejb;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.openejb.math.util.MathUtils;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightTransform;


/************************************************************************
 * 
 * @author SurferJim
 *
 *	Database Utility Class
 ***********************************************************************/


@Resource(name="biomightDS", type=javax.sql.DataSource.class)
public class DBUtils {
	public final static String DATASOURCE = "java:comp/env/biomightDS";	
	public final static String DATE_FORMAT_SQL = "yyyy-MM-dd";


	/*******************************************************************************************
	 * GET COMPONENT COUNT
	 * 
	 * This method will see if the current object exists.     
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static String convertID(int nextAvailNum, String componentBase)
	{		
		// Generate the Component ID
		String newComponentID = "";
		
		if (nextAvailNum < 10)
			newComponentID = componentBase + ":0000" + nextAvailNum;
		else if (nextAvailNum < 100)
			newComponentID = componentBase + ":000" + nextAvailNum;
		else if (nextAvailNum < 1000)
			newComponentID = componentBase + ":00" + nextAvailNum;
		else if (nextAvailNum < 10000)
			newComponentID = componentBase + ":0" + nextAvailNum;
		else if (nextAvailNum < 100000)
			newComponentID = componentBase + ":" + nextAvailNum;
		//System.out.println("convertID: " + componentBase + "  " + newComponentID);
		return(newComponentID);
	}
	
	
	
	/*******************************************************************************************
	 * GET COMPONENT ID
	 * 
	 * This method will count the # of objects that are currently persisted with the given
	 * component and parent
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static String getComponentID(int BodyID, int ProjectID, String componentType, String parentID) throws DataException, DataSecurityException
	{	
		int returnCode = 0;	
		String componentID = "";
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get the ID of the first record that has a record matching below
		//********************************************************************************************
		String countQuery =
			"SELECT comp.comp_id from biomight.biocomp comp, biomight.biogroup grp" +
			"  where comp.comp_type = '" + componentType + "' " +
			"  and grp.parent_id = '" + parentID + "' " +
			"  and comp.comp_id = grp.comp_id ";
		
		//System.out.println("getComponentID()  componentIDQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in DBUtils.getComponentID() Query preparation");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		try {
			while (rs.next()) {	
				componentID = rs.getString(1); 
				//System.out.println("DBUtils.getComponentID() -  Length is: " + componentID);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during DBUtils.getComponentID():" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - DBUtils.getComponentID():" + e.toString());	
			}
		}
		
	
		return (componentID);	
	}

	/*******************************************************************************************
	 * GET COMPONENT COUNT BY ID
	 * 
	 * This method will see if the current object exists.     
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getCountByID(int BodyID, int ProjectID, String componentID, String parentID) throws DataException, DataSecurityException
	{		
		int numCurrentNucleotides = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;

		//********************************************************************************************
		// Get the current Component Count
		//********************************************************************************************
		String countQuery =
			"SELECT count(comp.comp_id) from biomight.biocomp comp, biomight.biogroup grp" +
			"  where comp.comp_id = '" + componentID + "' " +
			"  and grp.parent_id = '" + parentID + "' " +
			"  and comp.comp_id = grp.comp_id ";
		//System.out.println("existComponent()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in existComponent()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		try {
			while (rs.next()) {	
				numCurrentNucleotides = rs.getInt(1); 
				//System.out.println("BioMightDNABean.existComponent() -  Length is: " + numCurrentNucleotides);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in existComponent():" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getChainCount - in existComponent():" + e.toString());	
			}
		}
		
		
		return (numCurrentNucleotides);	
	}


	/*******************************************************************************************
	 * GET COMPONENT COUNT BY COMPONENT TYPE and PARENT
	 * 
	 * This method will count the # of objects that are currently persisted for the
	 * given component type and parent
	 * 
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getComponentCount(int BodyID, int ProjectID, String componentType, String parentID) throws DataException, DataSecurityException
	{	
		int returnCode = 0;	
		int numElements = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get the current DNA Chain size
		//********************************************************************************************
		String countQuery =
			"SELECT count(comp.comp_id) from biomight.biocomp comp, biomight.biogroup grp" +
			"  where comp.comp_type = '" + componentType + "' " +
			"  and grp.parent_id = '" + parentID + "' " +
			"  and comp.comp_id = grp.comp_id ";
		
		//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting chainCount in getgetCountByType()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		try {
			while (rs.next()) {	
				numElements = rs.getInt(1); 
				//System.out.println("BioMightDNABean.getCountByType() -  Length is: " + numElements);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in getCountByType:" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - BioMightDNABean.getCountByType():" + e.toString());	
			}
		}
		
	
		return (numElements);	
	}

	/*******************************************************************************************
	 * GET COMPONENT COUNT BY COMPONENT TYPE
	 * 
	 * This method will count the # of objects that are currently persisted with the given
	 * component type, regardless of parent.  This will get the total number of a given
	 * component which is needed when adding new records
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getComponentCount(int BodyID, int ProjectID, String componentType) throws DataException, DataSecurityException
	{	
		int returnCode = 0;	
		int numElements = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get the current DNA Chain size
		//********************************************************************************************
		String countQuery =
			"SELECT count(comp_id) from biomight.biocomp " +
			"  where comp_type = '" + componentType + "'";
		//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting Count in getCountByType()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		try {
			while (rs.next()) {	
				numElements = rs.getInt(1); 
				//System.out.println("BioMightDNABean.getCountByType() is: " + numElements);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in getComponentCountByParent:" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - BioMightDNABean.getComponentCountByParent():" + e.toString());	
			}
		}
		
	
		return (numElements);	
	}

	/*******************************************************************************************
	 * GET MAX ID
	 * 
	 * This will get the MAX ID for a given component type.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getMaxID(int BodyID, int ProjectID, String componentType) throws DataException, DataSecurityException
	{	
		int returnCode = 0;	
		int numElements = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get MAX ID
		//********************************************************************************************
		String countQuery =
			"SELECT max(comp_id) from biomight.biocomp " +
			"  where comp_type = '" + componentType + "'";
		//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting Count in getMaxID()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		int nMaxID = 0;
		try {
			while (rs.next()) {	
				String maxIdStr = rs.getString(1);
				
				
				nMaxID = Integer.parseInt(maxIdStr.substring(maxIdStr.indexOf(":")+1));
				String componentBase = maxIdStr.substring(0, maxIdStr.indexOf(":"));
				
				//System.out.println("MaxID for component : " + componentType + "  " + numElements);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in getMaxID:" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - BioMightDNABean.getMaxID():" + e.toString());	
			}
		}
		
	
		return (nMaxID);	
	}

	
	/*******************************************************************************************
	 * GET MAX ID
	 * 
	 * This will get the MAX ID for a given component type.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getMaxID(int BodyID, int ProjectID, String componentType, String parentID) throws DataException, DataSecurityException
	{	
		int returnCode = 0;	
		int numElements = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get MAX ID
		//********************************************************************************************
		String countQuery =	
			"SELECT max(comp.comp_id) from biomight.biocomp comp, biomight.biogroup grp" +
			"  where comp.comp_type = '" + componentType + "' " +
			"  and grp.parent_id = '" + parentID + "' " +
			"  and comp.comp_id = grp.comp_id ";
			//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting Count in getMaxID()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		int nMaxID = 1;
		try {
			while (rs.next()) {	
				String maxIdStr = rs.getString(1);
				
				
				nMaxID = Integer.parseInt(maxIdStr.substring(maxIdStr.indexOf(":")+1));
				String componentBase = maxIdStr.substring(0, maxIdStr.indexOf(":"));
				
				//System.out.println("MaxID for component : " + componentType + "  " + numElements);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in getMaxID:" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - BioMightDNABean.getMaxID():" + e.toString());	
			}
		}
		
	
		return (nMaxID);	
	}

	
	
	/*******************************************************************************************
	 * GET MIN ID
	 * 
	 * This will get the MIN ID for a given component type.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getMinID(int BodyID, int ProjectID, String componentType) throws DataException, DataSecurityException
	{	
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get MIN ID
		//********************************************************************************************
		String countQuery =
			"SELECT min(comp_id) from biomight.biocomp " +
			"  where comp_type = '" + componentType + "'";
		
		//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting Count in getMinID)");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		int nMinID = 0; 
		try {
			while (rs.next()) {	
				String minIdStr = rs.getString(1);
				
				nMinID = Integer.parseInt(minIdStr.substring(minIdStr.indexOf(":")+1));
				String componentBase = minIdStr.substring(0, minIdStr.indexOf(":"));
				
				//System.out.println("MinID for component : " + componentType + "  " + nMinID);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during chainCount- in getMinID():" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - BioMightDNABean.getMinID():" + e.toString());	
			}
		}
		
	
		return (nMinID);	
	}


	
	/*******************************************************************************************
	 * GET MIN ID
	 * 
	 * This will get the MIN ID for a given component type.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/

	public static int getMinID(int BodyID, int ProjectID, String componentType, String parentID) throws DataException, DataSecurityException
	{	
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		//********************************************************************************************
		// Get MIN ID
		//********************************************************************************************
		String countQuery =
		"SELECT min(comp.comp_id) from biomight.biocomp comp, biomight.biogroup grp" +
		"  where comp.comp_type = '" + componentType + "' " +
		"  and grp.parent_id = '" + parentID + "' " +
		"  and comp.comp_id = grp.comp_id ";
		//System.out.println("getCountByType()  countQuery = " + countQuery);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(countQuery);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in getting Count in getMinID)");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		// Get the result
		int nMinID = 0; 
		try {
			while (rs.next()) {	
				String minIdStr = rs.getString(1);
				if (!StringUtils.isEmpty(minIdStr)) {
					nMinID = Integer.parseInt(minIdStr.substring(minIdStr.indexOf(":")+1));
					String componentBase = minIdStr.substring(0, minIdStr.indexOf(":"));
					//System.out.println("Located MinID for component : " + componentType + "  " + nMinID);
				}
				else
					System.out.println("No Records Found - MinID for component set to ZERO for: " + componentType);
			}
			
		} catch (Exception e) {
			System.out.println("Exception in getMinID():" + e.toString());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - DBUtils.getMinID():" + e.toString());	
			}
		}
		
	
		return (nMinID);	
	}

	

	
	/***************************************************************************************
	 * GENERATE CYLINDER THREAD
	 * 
	 * This will create generate a connected string of cylinder objects.  
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	  	public static double[] generateCylinderThread(String startID, String componentType, String componentName, String parentID, double[] startPoint, double[] currentOrient, BioMightInstructSet bioMightInstructSet) 
		throws DataException, DataSecurityException   		
		{	
		//System.out.println("GenerateCylinderThread");
	
		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	
		// Initialize to the base points
		double xPos = startPoint[0];
		double yPos = startPoint[1];
		double zPos = startPoint[2];
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		
		// Setup the start orientation
		double xOrient = currentOrient[0];
		double yOrient = currentOrient[1];
		double zOrient = currentOrient[2];
		double degrees = currentOrient[3];
		
		double radius = 0.005;
		double height = 0.06;
		double depth = 0.00125;
		int compGroup = 0;
		int depthDirection = 90;

		// Where  the Cylinder currently terminates
		double xEndPos = startPoint[0];
		double yEndPos = startPoint[1];
		double zEndPos = startPoint[2];
		
		double xEndOrient = currentOrient[0];
		double yEndOrient = currentOrient[1];
		double zEndOrient = currentOrient[2];
		double endDegrees = currentOrient[3];
		
		// Holds the ending location
		double[] nextPoint = {0, 0, 0};
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmtGrp = null;
			
	
		// Get the Current Component ID, as we are updating from there
		int componentNum = 0;
		String componentBase = "";
		
		// Get the Starting Point based on the value sent into the method
		try
		{
			//System.out.println("Starting Update at ComponentID: " + startID);
			componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
			componentBase = startID.substring(0,startID.indexOf(":"));
			//System.out.println("Starting at : " + componentBase + "   " + componentNum);
		}
		catch (Exception e) {
			System.out.println("GenerateCylinderRows - Bad Starting Position for Component:" + e.toString());
		} 
		
			  		             
		// we are going to get current and next points from the driving routine
		// nextPoints = applyRotation(currentPoints, pivotPoint, theta, rotateVector);
		
		//System.out.println("Instructions for Generata Rows" + bioMightInstructSet.getSize());
		
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize(); numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			//System.out.println("Have Instruction: " + bioInstruct.getTransType());
	    	
   			//System.out.println("Current Cylinder Point : " + xEndPos + "   " + yEndPos + "   " + zEndPos);
			//System.out.println("Current Cylinder Oriention: " + xEndOrient + "   " + yEndOrient + "   " + zEndOrient + "  " + endDegrees);

			// Find out the direction we are rotating
			double[] rotateVector =  bioInstruct.getRotateVector();
   			xEndOrient = rotateVector[0]; 
			yEndOrient = rotateVector[1]; 
			zEndOrient = rotateVector[2];
		
			//  Determine how far we are moving 
			double[] translateMatrix =  bioInstruct.getTranslateMatrix();
			double theta =  bioInstruct.getTheta();
			endDegrees += theta; 
			
			// Calculate the Distance to the New Point
			BioMightPosition startPosition = new BioMightPosition(xEndPos, yEndPos, zEndPos);
			BioMightPosition endPosition = new BioMightPosition(xEndPos+translateMatrix[0], yEndPos+translateMatrix[1], zEndPos+translateMatrix[2]);
			height = BioGraphics.distance(startPosition, endPosition);
			BigDecimal heightBD = new BigDecimal(height).setScale(6, BigDecimal.ROUND_CEILING);
	
   			//System.out.println("\nApplyRotate  : " + rotateVector[0] + "   " + rotateVector[1] + "   " + rotateVector[2] + " at: " + theta + " to: " + endDegrees);
	
   			// Imagine Creating the Cylinder so that its Center lies on (0, 0, 0) 
			// Position the Cylinder at pos (0 .5h  0) (0 0 .5r) so that it rotates
   			// according to the X3D model definition
   			double[][] currentPoints = {{xEndPos, yEndPos, zEndPos}};
   			
   			//nextPoint = BioGraphics.applyRotation(currentPoints, Math.toRadians(endDegrees), rotateVector);	
   			double nextPoints[][] = BioGraphics.rotateX(currentPoints, endDegrees);	
   			nextPoint= nextPoints[0];

			//System.out.println("EndPoint after Rotate : " + nextPoint[0] + "   " +  nextPoint[1] + "   " +  nextPoint[2]);
			//System.out.println("Orientation after Rotate: " + xEndOrient + "  " + yEndOrient + "   " + zEndOrient + "   " + endDegrees);
				 
			// Hoist it into position
			//System.out.println("\nApplyTranslate: " +  translateMatrix[0]  + "   " +  translateMatrix[1] + "   " +  translateMatrix[2]  + " for: " +  heightBD);
			nextPoint = BioGraphics.applyTranslation(nextPoint, bioInstruct.getTranslateMatrix());
			
			xEndPos = nextPoint[0];
			yEndPos = nextPoint[1];
			zEndPos = nextPoint[2];
		
			//System.out.println("EndPoint after Translate: " + xEndPos + "   " + yEndPos + "   " + zEndPos);
			//System.out.println("Orientation after Translate: " + xEndOrient + "  " + yEndOrient + "   " + zEndOrient + "   " + endDegrees);
			
			
			// Now that the points are generated, create there sides
			String componentID = "";
			
			// Generate the Component ID
			if (componentNum < 10)
				componentID = componentBase + ":0000" + componentNum;
			else if (componentNum < 100)
				componentID = componentBase + ":000" + componentNum;
			else if (componentNum < 1000)
				componentID = componentBase + ":00" + componentNum;
			else if (componentNum < 10000)
				componentID = componentBase + ":0" + componentNum;
	    
			;
			//System.out.println("Creating the Sides: " + componentNum + "   " +  componentID);
			vertices = "";

			BigDecimal xPosBD = new BigDecimal(xEndPos).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal yPosBD = new BigDecimal(yEndPos).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal zPosBD = new BigDecimal(zEndPos).setScale(6, BigDecimal.ROUND_CEILING);
				
			BigDecimal xOrientBD = new BigDecimal(xEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal yOrientBD = new BigDecimal(yEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal zOrientBD = new BigDecimal(zEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal degreesBD = new BigDecimal(endDegrees).setScale(6, BigDecimal.ROUND_CEILING);
			

			
	       	query =
	       		"UPDATE biomight.biocomp set "
	       			+ "posX = " + xPosBD + ","
	       			+ "posY = " + yPosBD + ","
	       			+ "posZ = " + zPosBD + ","
	       			+ "orientX = " + xOrientBD + ","
	       			+ "orientY = " + yOrientBD + ","
	       			+ "orientZ = " + zOrientBD + ","
	       			+ "orientW = " + degreesBD + ", "
	       			+ "radius = " + radius + ", "
	       			+ "height = " + heightBD + " "
	       		+ "where comp_id = '" + componentID + "'";
	       	//System.out.println("generateRows Update = " + query);
        		
        		
	       		// Decalre Statement and Result set
	       		boolean bMissing = false;
	       		stmt = null;
	       		try {
	       			stmt = con.prepareStatement(query);
	       			//System.out.println("Query is prepared");
	       			returnCode = stmt.executeUpdate();
	       			//System.out.println("Update Query has executed: " + returnCode);
	       		} catch (Exception e) {
	       			//System.out.println("There was an exception in generateComponentRows Update");
	       			//throw new DataException("Exception during prep of query:" + e.toString());
	       			bMissing = true;
	       			System.out.println("Missing Row: " + query);
	       		}
    
	       		
	       		boolean bDuplicate = false;
	       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	       		if (bMissing || returnCode == 0)
	       		{	       			       	 			
	       			query =
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
					+ height  + "," + xOrientBD + "," +  yOrientBD + "," + zOrientBD + "," + degreesBD + ")";

	 			
	       			try {
	       				stmt = con.prepareStatement(query);
	       				//System.out.println("Query is prepared");
	       				returnCode = stmt.executeUpdate();
	       				//System.out.println("InsertQry: " + query);
	       			} catch (Exception e) {
	       				System.out.println("There was an exception in generateComponentRows Insert");
	       				//throw new DataException("Exception during prep of query:" + e.toString());
	       				bDuplicate = true;
	        		}	
	       			
	       			if (!bDuplicate){
		       			//Insert the Grouping
						String query2 =
							"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
						//System.out.println("GrpInsert = " + query2);
										
						// Decalre Statement and Result set 
						stmtGrp = null;
						try {
							stmtGrp = con.prepareStatement(query2);
							//System.out.println("Query2 is prepared");
							returnCode = stmtGrp.executeUpdate();
							//System.out.println("Query2 has executed");
						} catch (Exception e) {
							System.out.println("Problem Inserting bioGroup Data into generateComponentRows()");
							//throw new DataException("Exception during prep of query:" + e.toString());
						}

	       			}
	      		}
	       		else
	       		{
	       		//System.out.println("bDuplicate: " + bDuplicate);
	       		}
     
	       		// Increment the counter
	       		componentNum++;
				

	    	//xPos = xPosEnd;
			//yPos = yPosEnd;
			//zPos = zPosEnd;
		
		}
			
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt != null)
				//stmt.close();
				con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - generateCylinderThreadRows():" + e.toString());	
		}	
	   
		
		return nextPoint;
	}

  	
	/***************************************************************************************
	 * GENERATE POINT INDEXED FACED COMPONENTS - COMPONENTS
	 * 
	 * This will create the information in the database   It is called from the generate()
	 * methods that create the individual components.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	  public static double[][] generatePointFacedComponents(int shape, String startID, String componentType, String componentName, String parentID, double[][] currentPoints, BioMightInstructSet bioMightInstructSet) 
		throws DataException, DataSecurityException   		
		{	
		//System.out.println("generatePointFacedComponents");
	
		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double radius = 0.5;
		double height = 1.0;
		double depth = 0.00125;
		int compGroup = 0;
		int depthDirection = 90;

		// Set up work arrays based on size of current array of points
		int numPoints=currentPoints.length;	
		double[][] tempPoints = new double[numPoints][2];
		double[][] nextPoints = new double[numPoints][2];	
		
		double[][] currentPointSet = new double[1][2];
		double[][] tempPointSet = new double[1][2];
		double[][] nextPointSet = new double[1][2];
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmtGrp = null;
			
	
		// Get the Current Component ID, as we are updating from there
		int componentNum = 0;
	
		// Get the Starting Point based on the value sent into the method
		if (!StringUtils.isEmpty(startID))
		{		
			// The ID was passed in, so use it
			try
			{
				//System.out.println("Starting Update at ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
				String componentBase = startID.substring(0,startID.indexOf(":"));
				//System.out.println("generatePointFacedComponents() - Using Predefined StartID: " + startID + "   " +  componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("generatePointFacedComponents - Bad Starting Position for Component:" + e.toString());
			} 
		
		}
		// Dynamically calculate the ID
		else
		{
			// Determine if this component already has a slot
			componentNum = getMinID(bodyID, projectID, componentType, parentID);
			//System.out.println("generatePointFacedComponents() - StartID for: " + componentType + "  " + parentID + "  is: " + componentNum);
			
			String componentID = "";	
			if (componentNum <= 0) {
				// Record are not defined for this component
				// Determine what's available for this database update			
				//System.out.println("No Records Defined for Parent-CompType Combo, getting next block for new component instance");
				componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				//System.out.println("generatePointFacedComponents() - Next StartSeq for " + componentType + "    is: " + componentNum);
			}
			else
			{ 
				//System.out.println("generatePointFacedComponents - Using Existing Records - Start Rewriting at: " + componentType + "   " + componentNum);
			}
			

			// Generate the Component ID
			componentID = DBUtils.convertID(componentNum, componentType);
			//System.out.println("Starting FacedComponents at: " + componentNum + "   " + " for type " + componentType + "    GenID: " + componentID);
		}
		
		// we are going to get current and next points from the driving routine
		// nextPoints = applyRotation(currentPoints, pivotPoint, theta, rotateVector);
		
		// We are beginning an instruction set, so we set pivot point to nada
		int pivotPoint = -1;
		
		int numSets = bioMightInstructSet.getSize()/numPoints;
		//System.out.println("InstructionSet size" + bioMightInstructSet.getSize() + "   Sets: " + numSets + "   Points" + numPoints);
		
		int currentInstr = 0;
		//bioMightInstructSet.getSize()
		
		// Run through all the instructions
		while (currentInstr < bioMightInstructSet.getSize() ) 
		{
			// There is an instruction for every point in the set
			// Run through numPoint Instructions at a time
			for (int currentPoint=0; currentPoint<numPoints; currentPoint++) 
			{
				// Get the instruction from the set of instrunctions 
				BioMightInstruction bioInstruct = bioMightInstructSet.getElement(currentInstr+currentPoint);
				//System.out.println("Have Instruction " + bioInstruct.getTransType());
		
				// Get the current Point into a double array for Graphic Routines
				currentPointSet[0] = currentPoints[currentPoint];
						
				// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
				switch (bioInstruct.getTransType()) {
		
					case Constants.ROTATE: 
						nextPointSet = BioGraphics.applyRotation(currentPointSet, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
						break;
						
					case Constants.ROTATEY: 
						nextPointSet = BioGraphics.rotateY(currentPointSet, bioInstruct.getTheta());
						break;
								
					case Constants.ROTATEYMOVE: 
						tempPointSet = BioGraphics.rotateY(currentPointSet, bioInstruct.getTheta());
						nextPointSet = BioGraphics.applyTranslation(tempPointSet, bioInstruct.getTranslateMatrix());
						break;
						
					case Constants.ROTATEX: 
						nextPointSet = BioGraphics.rotateX(currentPointSet, bioInstruct.getTheta());
						break;

					case Constants.ROTATEXMOVE: 
						tempPointSet = BioGraphics.rotateX(currentPointSet, bioInstruct.getTheta());
						nextPointSet = BioGraphics.applyTranslation(tempPointSet, bioInstruct.getTranslateMatrix());
						break;
						
					case Constants.ROTATEOCTO: 	
						nextPointSet = BioGraphics.rotateOctogon(currentPointSet, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
						break;

					case Constants.ROTATEMOVEOCTO: 	
						tempPoints = BioGraphics.rotateOctogon(currentPointSet, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
						nextPoints = BioGraphics.applyTranslation(tempPointSet, bioInstruct.getTranslateMatrix());
						break;
						
					case Constants.ROTATEOCTOSCALE: 	
						tempPointSet = BioGraphics.rotateOctogon(currentPointSet, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
						nextPointSet = BioGraphics.applyScale(tempPointSet, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
						break;			

					case Constants.OCTOMOVESCALE: 	
						tempPointSet = BioGraphics.applyScale(currentPointSet, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
						nextPointSet = BioGraphics.applyTranslation(tempPointSet, bioInstruct.getTranslateMatrix());
						break;	
					
					case Constants.ROTATEMOVESCALE: 	
						tempPointSet = BioGraphics.rotateOctogon(currentPointSet, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());							
						tempPointSet = BioGraphics.applyScale(tempPointSet, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
						nextPointSet = BioGraphics.applyTranslation(tempPointSet, bioInstruct.getTranslateMatrix());
						break;
						
					case Constants.TRANSLATE: 
						// Just a regular translation.  No need for a pivot point
						// Apply the Transformation to all 8 points      			
						nextPointSet = BioGraphics.applyTranslation(currentPointSet, bioInstruct.getTranslateMatrix());
						pivotPoint=-1;
						break;
		
					case Constants.SCALE: 
						// Just a regular translation.  No need for a pivot point
						// Apply the Transformation to all 8 points      	
						nextPointSet = BioGraphics.applyScale(currentPointSet, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
						pivotPoint=-1;
						break;
		
				} 
				
				// Place the new point back into the nextPoints set
				// After it has the instruction applied
				nextPoints[currentPoint] = nextPointSet[0];
			}
			
			// Update for the next set of instructions
			currentInstr+=numPoints;
	
			
			//*********************************************************************
			//
			// Now that the points are generated, create the sides
			//
			//*********************************************************************
			String componentID = "";
			
			boolean bApplyRoutine = false;			
			for (int octopos=0; octopos<numPoints; octopos++)
			{					
				// Only apply to a certain set of points if a pointset is specified.
				// We only want to draw sides for the vertices that we draw.  We don't
				// want to draw (create sides) for vertices that overlap.
				// See if the current point is a selected vertex.
				bApplyRoutine = true;
				
	
				if (bApplyRoutine)
				{
					// Generate the Component ID
					componentID = DBUtils.convertID(componentNum, componentType);
				
					//if (bApplyRoutine)
					//   System.out.println("Creating the QuadSide at: " + componentID);
			  	
					// Beginning Point
					BigDecimal c0xBD = new BigDecimal(currentPoints[0][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal c0yBD = new BigDecimal(currentPoints[0][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal c0zBD = new BigDecimal(currentPoints[0][2]).setScale(6, BigDecimal.ROUND_CEILING);
		    	
						// Current Point
					BigDecimal cxBD = new BigDecimal(currentPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal cyBD = new BigDecimal(currentPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal czBD = new BigDecimal(currentPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
		
					// Next Point
					BigDecimal xBD = new BigDecimal(nextPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal yBD = new BigDecimal(nextPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal zBD = new BigDecimal(nextPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
		
					
					if  (octopos < numPoints-1) {
		    	
						BigDecimal xBD1 = new BigDecimal(nextPoints[octopos+1][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal yBD1 = new BigDecimal(nextPoints[octopos+1][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal zBD1 = new BigDecimal(nextPoints[octopos+1][2]).setScale(6, BigDecimal.ROUND_CEILING);
		    	
						// Current Point plus 1,did the mixup on purpose so one does not confuse
						BigDecimal cx1BD = new BigDecimal(currentPoints[octopos+1][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal cy1BD = new BigDecimal(currentPoints[octopos+1][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal cz1BD = new BigDecimal(currentPoints[octopos+1][2]).setScale(6, BigDecimal.ROUND_CEILING);
					
					       				
						vertices = 
							cxBD  + "," + cyBD + "," + czBD + "," +
							xBD  + "," + yBD + "," + zBD + "," +
							xBD1  + "," + yBD1 + "," + zBD1 + "," +
							cx1BD  + "," + cy1BD + "," + cz1BD;
					} else {
		   			
						BigDecimal xBD0 = new BigDecimal(nextPoints[0][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal yBD0 = new BigDecimal(nextPoints[0][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal zBD0 = new BigDecimal(nextPoints[0][2]).setScale(6, BigDecimal.ROUND_CEILING);
		        	
						vertices = 
							cxBD  + "," + cyBD + "," + czBD + "," +
							xBD  + "," + yBD + "," + zBD + "," +
							xBD0  + "," + yBD0 + "," + zBD0 + "," +
							c0xBD  + "," + c0yBD + "," + c0zBD;
					}
		    			
			       		query =
			       			"UPDATE biomight.biocomp set vertices = '" + vertices + "' " +
			       			"where comp_id = '" + componentID + "'";
			       		//System.out.println("generateRows Update = " + query);
		        		
		        		
			       		// Decalre Statement and Result set
			       		boolean bMissing = false;
			       		stmt = null;
			       		try {
			       			stmt = con.prepareStatement(query);
			       			//System.out.println("Query is prepared");
			       			returnCode = stmt.executeUpdate();
			       			//System.out.println("Update Query has executed: " + returnCode);
			       		} catch (Exception e) {
			       			//System.out.println("There was an exception in generateComponentRows Update");
			       			//throw new DataException("Exception during prep of query:" + e.toString());
			       			bMissing = true;
			       			System.out.println("WARNING - Missing Row: " + query);
			       		}
		    
			       		
			       		boolean bDuplicate = false;
			       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
			       		if (bMissing || returnCode == 0)
			       		{	       			       	 			
			       			query =
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
		
			 			
			       			try {
			       				stmt = con.prepareStatement(query);
			       				//System.out.println("Query is prepared");
			       				returnCode = stmt.executeUpdate();
			       				//System.out.println("InsertQry: " + query);
			       			} catch (Exception e) {
			       				System.out.println("There was an exception in generateComponentRows Insert");
			       				//throw new DataException("Exception during prep of query:" + e.toString());
			       				bDuplicate = true;
			        		}	
			       			
			       			if (!bDuplicate){
				       			//Insert the Grouping
								String query2 =
									"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
								//System.out.println("GrpInsert = " + query2);
												
								// Decalre Statement and Result set 
								stmtGrp = null;
								try {
									stmtGrp = con.prepareStatement(query2);
									//System.out.println("Query2 is prepared");
									returnCode = stmtGrp.executeUpdate();
									//System.out.println("Query2 has executed");
								} catch (Exception e) {
									System.out.println("Problem Inserting bioGroup Data into generateComponentRows()");
									//throw new DataException("Exception during prep of query:" + e.toString());
								}
		
			       			}
			      		}
			       		else
			       		{
			       		//System.out.println("bDuplicate: " + bDuplicate);
			       		}
		     
			       		// Increment the counter
			       		componentNum++;
				}
			}
	
	    	
			// Set the old points to the new points    		
	    	for (int octopos=0; octopos<numPoints; octopos++)
	    	{
	    		currentPoints[octopos][0] = nextPoints[octopos][0];
	    		currentPoints[octopos][1] = nextPoints[octopos][1];
	     		currentPoints[octopos][2] = nextPoints[octopos][2];	
	    	}
		
		}
			
		
		
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - generateComponentRows():" + e.toString());	
		}	
	   
		
		return nextPoints;
	}

		  	
	  	
  	/***************************************************************************************
	 * GENERATE INDEXED FACED SETS - COMPONENTS
	 * 
	 * This will create the information in the database   It is called from the generate()
	 * methods that create the individual components.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	  	public static double[][] generateFacedComponents(int shape, String startID, String componentType, String componentName, String parentID, double[][] currentPoints, BioMightInstructSet bioMightInstructSet) 
		throws DataException, DataSecurityException   		
		{	
		//System.out.println("GenerateComponentRows");
	
		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double radius = 0.5;
		double height = 1.0;
		double depth = 0.00125;
		int compGroup = 0;
		int depthDirection = 90;

		// Set up work array based on size of current array
		int numPoints=currentPoints.length;	
		double[][] nextPoints = new double[numPoints][2];	
		double[][] tempPoints = new double[numPoints][2];
		
		if (componentName.contains("Hip")) 
			System.out.println("generateFacedComponents() NumPoints for Hip: " + numPoints);		
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmtGrp = null;
			
	
		// Get the Current Component ID, as we are updating from there
		int componentNum = 0;
	
		// Get the Starting Point based on the value sent into the method
		if (!StringUtils.isEmpty(startID))
		{		
			// The ID was passed in, so use it
			try
			{
				//System.out.println("Starting Update at ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
				String componentBase = startID.substring(0,startID.indexOf(":"));
				//System.out.println("generateFacedComponents() - Using Predefined StartID: " + startID + "   " +  componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("generateFacedComponents - Bad Starting Position for Component:" + e.toString());
			} 
		
		}
		// Dynamically calculate the ID
		else
		{
			// Determine if this component already has a slot
			componentNum = getMinID(bodyID, projectID, componentType, parentID);
			//System.out.println("generateFacedComponents() - StartID for: " + componentType + "  " + parentID + "  is: " + componentNum);
			
			String componentID = "";	
			if (componentNum <= 0) {
				// Record are not defined for this component
				// Determine what's available for this database update			
				//System.out.println("No Records Defined for Parent-CompType Combo, getting next block for new component instance");
				componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				//System.out.println("generateFacedComponents() - Next StartSeq for " + componentType + "    is: " + componentNum);
			}
			else
			{ 
				//System.out.println("GenerateFacedComponents - Using Existing Records - Start Rewriting at: " + componentType + "   " + componentNum);
			}
			

			// Generate the Component ID
			componentID = DBUtils.convertID(componentNum, componentType);
			//System.out.println("Starting FacedComponents at: " + componentNum + "   " + " for type " + componentType + "    GenID: " + componentID);
		}
		
		// we are going to get current and next points from the driving routine
		// nextPoints = applyRotation(currentPoints, pivotPoint, theta, rotateVector);
		
		// We are beginning an instruction set, so we set pivot point to nada
		int pivotPoint = -1;
		
   			
		//System.out.println("Instructions for Generata Rows" + bioMightInstructSet.getSize());
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			//System.out.println("Have Instruction " + bioInstruct.getTransType());
	    
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
					// If we are performing a rotation we have to 
				// translate to the pivot point,perform the rotation, and translate back to origin
				// Here, we translate to the pivot point
				case Constants.ROTATE: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
					break;
					
				case Constants.ROTATEY: 
					nextPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					break;
							
				case Constants.ROTATEYMOVE: 
					tempPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEX: 
					nextPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					break;

				case Constants.ROTATEXMOVE: 
					tempPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTO: 	
					nextPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					break;

				case Constants.ROTATEMOVEOCTO: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTOSCALE: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyScale(tempPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					break;			

				case Constants.OCTOMOVESCALE: 	
					tempPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;	
				
				case Constants.ROTATEMOVESCALE: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());							
					tempPoints = BioGraphics.applyScale(tempPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.TRANSLATE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      			
					nextPoints = BioGraphics.applyTranslation(currentPoints, bioInstruct.getTranslateMatrix());
					pivotPoint=-1;
					break;
	
				case Constants.SCALE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      	
					nextPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					pivotPoint=-1;
					break;
	
				} 
			
			if (componentName.contains("Hip")) 
				System.out.println("AFTER NumPoints for Hip: " + currentPoints.length  + " "  + nextPoints.length);		
			
				
			
			//*********************************************************************
			//
			// Now that the points are generated, create the sides
			//
			//*********************************************************************
			String componentID = "";
	
			// Get the point set that was defined for the instruction set
			int pointSet[] = bioInstruct.getPointSet();
			if (pointSet.length > 0)
			{
				//System.out.println("There is a pointSet for InstructionSet: " + numSegs);
				BioGraphics.dumpPoints("currentPoints", currentPoints);
				BioGraphics.dumpPoints("nextPoints", nextPoints);
			}
			
			boolean bApplyRoutine = false;
			for (int octopos=0; octopos<numPoints; octopos++)
			{			
				bApplyRoutine = false;
				if (pointSet.length > 0)
				{
					for (int applyPoint=0; applyPoint<pointSet.length; applyPoint++)
					{					
						if (pointSet[applyPoint] == octopos)
						{
							//System.out.println("Point in PointSet...Applying Transform: " + octopos);
							bApplyRoutine = true;
							break;
						}	
					}
					
					if (!bApplyRoutine)
					{
						//System.out.println("Point Not in PointSet...Not Applying Transform: " + octopos);
						nextPoints[octopos] = currentPoints[octopos];
					}
					
				}
			}
			
			if (pointSet.length > 0)
			{
				BioGraphics.dumpPoints("UpdatedPoints", nextPoints);
			}
			
			
			for (int octopos=0; octopos<numPoints; octopos++)
			{					
				// Only apply to a certain set of points if a pointset is specified.
				// We only want to draw sides for the vertices that we draw.  We don't
				// want to draw (create sides) for vertices that overlap.
				// See if the current point is a selected vertex.
				bApplyRoutine = false;
				
				if (pointSet.length > 0)
				{
					for (int applyPoint=0; applyPoint<pointSet.length; applyPoint++)
					{					
						if (pointSet[applyPoint] == octopos)
						{
							bApplyRoutine = true;
							//System.out.println("Applying Instruction to Point: " + octopos);
							break;
						}	
					}					
				}

			
				
				if (bApplyRoutine || pointSet.length == 0)
				{
					// Generate the Component ID
					componentID = DBUtils.convertID(componentNum, componentType);
				
					//if (bApplyRoutine)
					//   System.out.println("Creating the QuadSide at: " + componentID);
			  	
					// Beginning Point
					BigDecimal c0xBD = new BigDecimal(currentPoints[0][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal c0yBD = new BigDecimal(currentPoints[0][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal c0zBD = new BigDecimal(currentPoints[0][2]).setScale(6, BigDecimal.ROUND_CEILING);
		    	
					// Current Point
					BigDecimal cxBD = new BigDecimal(currentPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal cyBD = new BigDecimal(currentPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal czBD = new BigDecimal(currentPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
		
					// Next Point
					BigDecimal xBD = new BigDecimal(nextPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal yBD = new BigDecimal(nextPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
					BigDecimal zBD = new BigDecimal(nextPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
		
					
					if  (octopos < numPoints-1) {
		    	
						BigDecimal xBD1 = new BigDecimal(nextPoints[octopos+1][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal yBD1 = new BigDecimal(nextPoints[octopos+1][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal zBD1 = new BigDecimal(nextPoints[octopos+1][2]).setScale(6, BigDecimal.ROUND_CEILING);
		    	
						// Current Point plus 1,did the mixup on purpose so one does not confuse
						BigDecimal cx1BD = new BigDecimal(currentPoints[octopos+1][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal cy1BD = new BigDecimal(currentPoints[octopos+1][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal cz1BD = new BigDecimal(currentPoints[octopos+1][2]).setScale(6, BigDecimal.ROUND_CEILING);
					
					       				
						vertices = 
							cxBD  + "," + cyBD + "," + czBD + "," +
							xBD  + "," + yBD + "," + zBD + "," +
							xBD1  + "," + yBD1 + "," + zBD1 + "," +
							cx1BD  + "," + cy1BD + "," + cz1BD;
					} else {
		   			
						BigDecimal xBD0 = new BigDecimal(nextPoints[0][0]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal yBD0 = new BigDecimal(nextPoints[0][1]).setScale(6, BigDecimal.ROUND_CEILING);
						BigDecimal zBD0 = new BigDecimal(nextPoints[0][2]).setScale(6, BigDecimal.ROUND_CEILING);
		        	
						vertices = 
							cxBD  + "," + cyBD + "," + czBD + "," +
							xBD  + "," + yBD + "," + zBD + "," +
							xBD0  + "," + yBD0 + "," + zBD0 + "," +
							c0xBD  + "," + c0yBD + "," + c0zBD;
					}
		    			
			       		query =
			       			"UPDATE biomight.biocomp set vertices = '" + vertices + "' " +
			       			"where comp_id = '" + componentID + "'";
			       		//System.out.println("generateRows Update = " + query);
		        		
		        		
			       		// Decalre Statement and Result set
			       	    boolean bMissing = false;
			       		stmt = null;
			       		try {
			       			stmt = con.prepareStatement(query);
			       			//System.out.println("Query is prepared");
			       			returnCode = stmt.executeUpdate();
			       			//System.out.println("Update Query has executed: " + returnCode);
			       		} catch (Exception e) {
			       			//System.out.println("There was an exception in generateComponentRows Update");
			       			//throw new DataException("Exception during prep of query:" + e.toString());
			       			bMissing = true;
			       			System.out.println("Missing Row: " + query);
			       		}
		    
			       		
			       		boolean bDuplicate = false;
			       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
			       		if (bMissing || returnCode == 0)
			       		{	       			       	 			
			       			query =
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
		
			 			
			       			try {
			       				stmt = con.prepareStatement(query);
			       				//System.out.println("Query is prepared");
			       				returnCode = stmt.executeUpdate();
			       				//System.out.println("InsertQry: " + query);
			       			} catch (Exception e) {
			       				System.out.println("There was an exception in generateComponentRows Insert");
			       				//throw new DataException("Exception during prep of query:" + e.toString());
			       				bDuplicate = true;
			        		}	
			       			
			       			if (!bDuplicate){
				       			//Insert the Grouping
								String query2 =
									"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
								//System.out.println("GrpInsert = " + query2);
												
								// Decalre Statement and Result set 
								stmtGrp = null;
								try {
									stmtGrp = con.prepareStatement(query2);
									//System.out.println("Query2 is prepared");
									returnCode = stmtGrp.executeUpdate();
									//System.out.println("Query2 has executed");
								} catch (Exception e) {
									System.out.println("Problem Inserting bioGroup Data into generateComponentRows()");
									//throw new DataException("Exception during prep of query:" + e.toString());
								}
		
			       			}
			      		}
			       		else
			       		{
			       		//System.out.println("bDuplicate: " + bDuplicate);
			       		}
		     
			       		// Increment the counter
			       		componentNum++;
				}
			}
	
	    	
			// Set the old points to the new points    		
	    	for (int octopos=0; octopos<numPoints; octopos++)
	    	{
	    		currentPoints[octopos][0] = nextPoints[octopos][0];
	    		currentPoints[octopos][1] = nextPoints[octopos][1];
	     		currentPoints[octopos][2] = nextPoints[octopos][2];	
	    	}
		
		
		}
		
		
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - generateComponentRows():" + e.toString());	
		}	
	   
		
		return nextPoints;
	}
  	
	/*******************************************************************************************
	 * GENERATE SYMBOLS
	 * 
	 * This method will be called to generate a collection of Symbols  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public static int generateSymbols(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		System.out.println("In GenerateSymbols: " + startID);
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
		
		// Get the Current Component ID, as we are updating from there
		int componentNum = 0;
	
		// Get the Starting Point based on the value sent into the method
		if (!StringUtils.isEmpty(startID))
		{		
			// The ID was passed in, so use it
			try
			{
				//System.out.println("Starting Update at ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
				String componentBase = startID.substring(0,startID.indexOf(":"));
				System.out.println("generateSymbols() - Using Predefined StartID: " + startID + "   " +  componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("generateSymbols - Bad Starting Position for Component:" + e.toString());
			} 	
		}
		// Dynamically calculate the ID
		else
		{
			// Determine if this component already has a slot
			componentNum = getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("generateSymbols() - StartID for: " + componentType + "  " + parentID + "  is: " + componentNum);
			
			componentID = "";	
			if (componentNum <= 0) {
				// Record are not defined for this component
				// Determine what's available for this database update			
				System.out.println("No Records Defined for Parent-CompType Combo, getting next block for new component instance");
				componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("generateSymbols() - Next StartSeq for " + componentType + "    is: " + componentNum);
			}
			else
			{ 
				System.out.println("generateSymbols - Using Existing Records - Start Rewriting at: " + componentType + "   " + componentNum);
			}
			

			// Generate the Component ID
			componentID = DBUtils.convertID(componentNum, componentType);
			System.out.println("Starting generateSymbols at: " + componentNum + "   " + " for type " + componentType + "    GenID: " + componentID);
		}
		
		
		// Set up the initial values that are passed in through current points, 
		// technically, we should take the center of these points
		int pivotPoint = -1;
		//Position
		double xPos = currentPoints[0][0];
		double yPos = currentPoints[0][1];
		double zPos = currentPoints[0][2];
		//Scale
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		// Orientation
		double xOrient = 0.0;
		double yOrient = 0.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		
		double depth = 0.1;
		double height = 0.0;
		double endDegrees = 0.0;
		int font = 0;
		int texture = 0;
		int material = 0;

		// We are going to create from current Colony Count up to NumElements
		
		for (int i=colonyCount; i<=numElements; i++)
		{
			// Generate the Component ID
			componentID = DBUtils.convertID(componentNum, componentType);
	
			vertices = "" ;
			int depth_direction = 0;
			String compGroup = "";
			
			// We are going to update that which exists first
       		String query =
       			"UPDATE biomight.biocomp set " 
   			+ "posX = " + xPos + ","
   			+ "posY = " + yPos + ","
   			+ "posZ = " + zPos + ","
   			+ "scaleX = " + xScale + ","
   			+ "scaleY = " + yScale + ","
   			+ "scaleZ = " + zScale + ","
   			+ "orientX = " + xOrient + ","
   			+ "orientY = " + yOrient + ","
   			+ "orientZ = " + zOrient + ","
   			+ "orientW = " + wOrient + ", "
   			+ "radius = " + radius + ", "
   			+ "height = " + height + ", "
   			+ "material = " + material + ", "
   			+ "texture = " + texture + ", "
   			+ "font = " + font + " "
   			+ "where comp_id = '" + componentID + "'";
       		       		
       		//System.out.println("generateSymbols Update = " + query);
    		
       		// Decalre Statement and Result set
       	    boolean bMissing = false;
       		stmt = null;
       		try {
       			stmt = con.prepareStatement(query);
       			//System.out.println("Query is prepared");
       			returnCode = stmt.executeUpdate();
       			//System.out.println("Update Query has executed: " + returnCode);
       		} catch (Exception e) {
       			//System.out.println("There was an exception in generateComponentRows Update");
       			//throw new DataException("Exception during prep of query:" + e.toString());
       			bMissing = true;
       			System.out.println("Missing Row: " + query);
       		}
    
       		// We are going to insert as the update was not possible
       		boolean bDuplicate = false;
       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
       		if (bMissing || returnCode == 0)
       		{	       			       	 		
				// Insert the Component		
				query =
					"INSERT into biomight.biocomp " +
					"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, " +
					"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction, font) " +
					"values (" 
					+ bodyID + "," + projectID + ",'" + componentID + "','" 
					+ componentType + "','" + componentName + "','" + componentName + "','" 
					+ parentID + "','" + boundbox + "','" + vertices + "',"
					+ "7," + xPos + "," + yPos + "," + zPos + "," 
					+ xScale + "," + yScale + "," + zScale + "," 
					+ radius + ",'" + + depth + "','" + compGroup + "'," + depth_direction + "," + font + ")";
				System.out.println("generateCells INSERT = " + query);
		
				//Insert the Grouping
				String query2 =
					"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
				System.out.println("generateSymbols GrpInsert = " + query2);
		
		
				// Declare Statement and Result set 
				stmt = null;
				try {
					stmt = con.prepareStatement(query);
					//System.out.println("Query is prepared");
					returnCode = stmt.executeUpdate();
					//System.out.println("Query has executed");
				} catch (Exception e) {
					System.out.println("Exception in inserting bioComp Data in generateSymbols()");
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
					System.out.println("Exception in updating bioGroup Data in generateSymbols()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
       		}

			
			// Change the Y pos
			yPos = yPos - 1.5;
	       	// Increment the counter
	       	componentNum++;
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
		
		/**************************************8
		{
			//*******************************************************************************
			// The number of elements is less than the current Colony count,so we must
			// cull the collection
			//*******************************************************************************
			
	  		int componentNum = numElements;
			String componentBase = "";
			String newComponentID = "";
		
			// Get the Starting Point based on the value sent into the method
	  	
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
		
			
			System.out.println("Prune Symbols to ColonySize of : " + numElements);
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
				System.out.println("Culling Basophil with ID: " + newComponentID);

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
		*************************************/
		
		return returnCode;	
	}


	/***************************************************************************************
	 * GENERATE SPHERE COMPONENTS
	 * 
	 * This method will create sphere components in the persistent store based
	 * upon the mathematically defined spatial template set passed into it.  
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	  public static int generateSphereComponents(int numElements, double[] startPos, double radius, String componentType, String componentName, String parentID, double[][] currentPoints) 
	  throws DataException, DataSecurityException   		
	  {	
		System.out.println("generateSphereComponents with radius: " + radius);
	
		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	
		double xPos = startPos[0];
		double yPos = startPos[1];
		double zPos = startPos[2];
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double depth = 0.00125;
		double height = 0.0;
		double endDegrees = 0.0;
		
		int compGroup = 0;
		int depthDirection = 90;
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmtGrp = null;
		
		// Determine if this component already has a slot
		int componentNum = getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateSphereComponents() - MinID for: " + componentType + " is: " + componentNum);
		
		String componentID = "";	
		if (componentNum <= 0) {
			// Record are not defined for this component
			// Determine what's available for this database update			
			System.out.println("No Records Defined for Parent-CompType Combo");
			componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + componentNum);
			System.out.println("GenerateSphereComponents().Getting MAXID - GeneratedStart at: " + componentType + "   " + componentNum);
		}
		else
		{ 
			System.out.println("GenerateSphereComponents - Using Existing MinID - Rewriting at: " + componentType + "   " + componentNum);
		}

		// Generate the Component ID
		componentID = DBUtils.convertID(componentNum, componentType);
		System.out.println("Starting SphereComponentsGEN at: " + componentNum + "   " + "  "+ componentType + " ID: " + componentID);
		
		for (int j=0; j<numElements; j++) {
					 
			// Find out the direction we are rotating
			// double[] rotateVector =  bioInstruct.getRotateVector();
   			double xEndOrient = 0;  //rotateVector[0]; 
   			double yEndOrient = 0;  //rotateVector[1]; 
   			double zEndOrient = 1;  //rotateVector[2];
		
			endDegrees = 90; // += theta; 
		
			BigDecimal xOrientBD = new BigDecimal(xEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal yOrientBD = new BigDecimal(yEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal zOrientBD = new BigDecimal(zEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
			BigDecimal degreesBD = new BigDecimal(endDegrees).setScale(6, BigDecimal.ROUND_CEILING);
			
			vertices = "";
				
       		query =
       			"UPDATE biomight.biocomp set "
       			        + "vertices = '" + vertices + "', " 
    	       			+ "posX = " + xPos + ","
    	       			+ "posY = " + yPos + ","
    	       			+ "posZ = " + zPos + ","
    	       			+ "orientX = " + xOrientBD + ","
    	       			+ "orientY = " + yOrientBD + ","
    	       			+ "orientZ = " + zOrientBD + ","
    	       			+ "orientW = " + degreesBD + ", "
    	       			+ "radius = " + radius + ", "
    	       			+ "height = " + height + " "
    	       			+ "where comp_id = '" + componentID + "'";
       		
       		
       		System.out.println("GenerateSphereComponents Update = " + query);
    		
			
       		// Declare Statement and Result set
       		boolean bMissing = false;
       		stmt = null;
       		try {
       			stmt = con.prepareStatement(query);
       			System.out.println("Query is prepared");
       			returnCode = stmt.executeUpdate();
       			System.out.println("Update Query has executed: " + returnCode);
       		} catch (Exception e) {
       			System.out.println("There was an exception in GenerateSphereComponents Update");
       			//throw new DataException("Exception during prep of query:" + e.toString());
       			bMissing = true;
       			System.out.println("Missing Row: " + query);
       		}

       		
       		boolean bDuplicate = false;
       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
       		if (bMissing || returnCode == 0)
       		{	       			       	 			
       			query =
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

 			
       			try {
       				stmt = con.prepareStatement(query);
       				System.out.println("Query is prepared");
       				returnCode = stmt.executeUpdate();
       				System.out.println("InsertQry: " + query);
       			} catch (Exception e) {
       				System.out.println("There was an exception in GenerateSphereComponents Insert");
       				//throw new DataException("Exception during prep of query:" + e.toString());
       				bDuplicate = true;
        		}	
       			
       			if (!bDuplicate){
	       			//Insert the Grouping
					String query2 =
						"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
					//System.out.println("GrpInsert = " + query2);
									
					// Decalre Statement and Result set 
					stmtGrp = null;
					try {
						stmtGrp = con.prepareStatement(query2);
						//System.out.println("Query2 is prepared");
						returnCode = stmtGrp.executeUpdate();
						//System.out.println("Query2 has executed");
					} catch (Exception e) {
						System.out.println("Problem Inserting bioGroup Data into generateSphereComponent()");
						//throw new DataException("Exception during prep of query:" + e.toString());
					}

       			}
	       			
	      	}
	       	else
	       	{
	       		System.out.println("bDuplicate: " + bDuplicate);
	       	}
	    
	      	// Increment the counter
	      	componentNum++;
	       		
	       	// Generate the Component ID
	    	componentID = DBUtils.convertID(componentNum, componentType);
	   		System.out.println("INCREMENTING: " + componentID);
	    		
		}
		
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - generateSphereComponents():" + e.toString());	
		}	
	   
		
		return returnCode;
	}
  	
	  	
  	/***************************************************************************************
	 * GENERATE CYLINDRICAL COMPONENTS
	 * 
	 * This method will create cylindrical components in the persistent store based
	 * upon the instruction set passed into it.   This will allow the algorithm to place
	 * items on the surface of any tube generated object.  
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	  public static double[][] generateCylindricalComponents(int numElements, double radius, double height, String componentType, String componentName, String parentID, double[][] currentPoints, BioMightInstructSet bioMightInstructSet) 
	  throws DataException, DataSecurityException   		
	  {	
		System.out.println("generateCylindricalComponents");
	
		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double depth = 0.00125;
		double endDegrees = 0.0;
		
		int compGroup = 0;
		int depthDirection = 90;

		// Set up work array based on size of current array
		int numPoints=currentPoints.length;	
		double[][] nextPoints;
		if (numPoints == 1)
			nextPoints = BioGraphics.get1point();
		else if (numPoints == 4)
			nextPoints = BioGraphics.get4points();
		else if (numPoints == 5)
			nextPoints = BioGraphics.get5points();			
		else if (numPoints == 6)
			nextPoints = BioGraphics.get6points();
		else if (numPoints == 8)
			nextPoints = BioGraphics.get8points();
		else
			nextPoints = BioGraphics.get6points();	
		
		double[][] tempPoints;
		if (numPoints == 1)
			tempPoints = BioGraphics.get1point();
		else if (numPoints == 4)
			tempPoints = BioGraphics.get4points();
		else if (numPoints == 5)
			tempPoints = BioGraphics.get5points();			
		else if (numPoints == 6)
			tempPoints = BioGraphics.get6points();
		else if (numPoints == 8)
			tempPoints = BioGraphics.get8points();
		else
			tempPoints = BioGraphics.get6points();	
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmtGrp = null;
		
		// Determine if this component already has a slot
		int componentNum = getMinID(bodyID, projectID, componentType, parentID);
		System.out.println("GenerateCylindricalComponents() - MinID for: " + componentType + " is: " + componentNum);
		
		String componentID = "";	
		if (componentNum <= 0) {
			// Record are not defined for this component
			// Determine what's available for this database update			
			System.out.println("No Records Defined for Parent-CompType Combo");
			componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
			System.out.println("No Component Recs exist - Getting Next Block: " + componentNum);
			System.out.println("GenerateCylindricalComponents().Getting MAXID - GeneratedStart at: " + componentType + "   " + componentNum);
		}
		else
		{ 
			System.out.println("GenerateCylindricalComponents - Using Existing MinID - Rewriting at: " + componentType + "   " + componentNum);
		}

		// Generate the Component ID
		componentID = DBUtils.convertID(componentNum, componentType);
		System.out.println("Starting CylindricalComponentGEN at: " + componentNum + "   " + "  "+ componentType + " ID: " + componentID);
		
		//
	 	
		System.out.println("Num Instructions for GenerateCylindricalComponents: " + bioMightInstructSet.getSize());
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			//System.out.println("Have Instruction " + bioInstruct.getTransType());
	    	
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
				// If we are performing a rotation we have to 
				// translate to the pivot point,perform the rotation, and translate back to origin
				// Here, we translate to the pivot point
				case Constants.ROTATE: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
					break;
					
				case Constants.ROTATEY: 
					nextPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					break;
							
				case Constants.ROTATEYMOVE: 
					tempPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEX: 
					nextPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					break;
	
				case Constants.ROTATEXMOVE: 
					tempPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTO: 	
					nextPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					break;
	
				case Constants.ROTATEMOVEOCTO: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;

							
				case Constants.TRANSLATE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      			
					nextPoints = BioGraphics.applyTranslation(currentPoints, bioInstruct.getTranslateMatrix());
					break;
	
				case Constants.SCALE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      	
					nextPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					break;
	
			} 
		
			
			// Run through each of the points in the Ring and create a
			// protein spike.   The 
			for (int curpoint=0; curpoint<numPoints; curpoint++)
			{					
				// Based on the number of elements, we need to pick points randomly or in a defined
				// pattern or template to determine who gets what and where
				// Lets use the first point to start with----
				
				// Grab the next point where the cylinder will be
				BigDecimal xPosBD = new BigDecimal(currentPoints[curpoint][0]).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal yPosBD = new BigDecimal(currentPoints[curpoint][1]).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal zPosBD = new BigDecimal(currentPoints[curpoint][2]).setScale(6, BigDecimal.ROUND_CEILING);
	    	
				
				// Current Point
				//BigDecimal cxBD = new BigDecimal(currentPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
				//BigDecimal cyBD = new BigDecimal(currentPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
				//BigDecimal czBD = new BigDecimal(currentPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
	
				// Next Point
				//BigDecimal xBD = new BigDecimal(nextPoints[octopos][0]).setScale(6, BigDecimal.ROUND_CEILING);
				//BigDecimal yBD = new BigDecimal(nextPoints[octopos][1]).setScale(6, BigDecimal.ROUND_CEILING);
				//BigDecimal zBD = new BigDecimal(nextPoints[octopos][2]).setScale(6, BigDecimal.ROUND_CEILING);
				 
	
				// Find out the direction we are rotating
				//double[] rotateVector =  bioInstruct.getRotateVector();
	   			double xEndOrient = MathUtils.round(currentPoints[curpoint][0]/1, 8); //rotateVector[0]; 
	   			double yEndOrient = 0; //rotateVector[1]; 
	   			double zEndOrient = MathUtils.round(currentPoints[curpoint][2]/1, 8); //rotateVector[2];
			
	   			
				//  Determine how far we are moving 
				double[] translateMatrix =  bioInstruct.getTranslateMatrix();
				double theta =  bioInstruct.getTheta();
				endDegrees = 90; // += theta; 
			
				
				BigDecimal xOrientBD = new BigDecimal(xEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal yOrientBD = new BigDecimal(yEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal zOrientBD = new BigDecimal(zEndOrient).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal degreesBD = new BigDecimal(endDegrees).setScale(6, BigDecimal.ROUND_CEILING);
				BigDecimal heightBD = new BigDecimal(height).setScale(6, BigDecimal.ROUND_CEILING);
				
				vertices = "";
					
	       		query =
	       			"UPDATE biomight.biocomp set "
	       			        + "vertices = '" + vertices + "', " 
	    	       			+ "posX = " + xPosBD + ","
	    	       			+ "posY = " + yPosBD + ","
	    	       			+ "posZ = " + zPosBD + ","
	    	       			+ "orientX = " + xOrientBD + ","
	    	       			+ "orientY = " + yOrientBD + ","
	    	       			+ "orientZ = " + zOrientBD + ","
	    	       			+ "orientW = " + degreesBD + ", "
	    	       			+ "radius = " + radius + ", "
	    	       			+ "height = " + heightBD + " "
	    	       			+ "where comp_id = '" + componentID + "'";
	       		
	       		
	       		System.out.println("generateRows Update = " + query);
	    		
			
	       		// Decalre Statement and Result set
	       		boolean bMissing = false;
	       		stmt = null;
	       		try {
	       			stmt = con.prepareStatement(query);
	       			System.out.println("Query is prepared");
	       			returnCode = stmt.executeUpdate();
	       			System.out.println("Update Query has executed: " + returnCode);
	       		} catch (Exception e) {
	       			System.out.println("There was an exception in generateComponentRows Update");
	       			//throw new DataException("Exception during prep of query:" + e.toString());
	       			bMissing = true;
	       			System.out.println("Missing Row: " + query);
	       		}
	
	       		
	       		boolean bDuplicate = false;
	       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	       		if (bMissing || returnCode == 0)
	       		{	       			       	 			
	       			query =
					"INSERT into biomight.biocomp " +
					"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, texture, " +
					"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction, " +
					"height, orientX, orientY, orientZ,  orientW) " +
					"values (" 
					+ bodyID + "," + projectID + ",'" + componentID + "','" 
					+ componentType + "','" + componentName + "','" + componentName + "','" 
					+ parentID + "','" + boundbox + "','" + vertices + "',"
					+ "7, 0, " + xPosBD + "," + yPosBD + "," + zPosBD + "," 
					+ xScale + "," + yScale + "," + zScale + "," 
					+ radius + ",'" + + depth + "','" + compGroup + "'," + depthDirection + ","   
					+ height  + "," + xOrient + "," +  yOrient + "," + zOrient + "," + wOrient + ")";
	
	 			
	       			try {
	       				stmt = con.prepareStatement(query);
	       				System.out.println("Query is prepared");
	       				returnCode = stmt.executeUpdate();
	       				System.out.println("InsertQry: " + query);
	       			} catch (Exception e) {
	       				System.out.println("There was an exception in generateCylindricalComponents Insert");
	       				//throw new DataException("Exception during prep of query:" + e.toString());
	       				bDuplicate = true;
	        		}	
	       			
	       			if (!bDuplicate){
		       			//Insert the Grouping
						String query2 =
							"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
						//System.out.println("GrpInsert = " + query2);
										
						// Decalre Statement and Result set 
						stmtGrp = null;
						try {
							stmtGrp = con.prepareStatement(query2);
							//System.out.println("Query2 is prepared");
							returnCode = stmtGrp.executeUpdate();
							//System.out.println("Query2 has executed");
						} catch (Exception e) {
							System.out.println("Problem Inserting bioGroup Data into generateCylindricalComponents()");
							//throw new DataException("Exception during prep of query:" + e.toString());
						}
	
	       			}
		       			
		      	}
		       	else
		       	{
		       		System.out.println("bDuplicate: " + bDuplicate);
		       	}
	    
	       		// Increment the counter
	       		componentNum++;
	       		
	       		// Generate the Component ID
	    		componentID = DBUtils.convertID(componentNum, componentType);
	    		System.out.println("INCREMENTING: " + componentID);
	    		
	    			
			    //if (totalCreated < numElements)
		       	//}
		
				// Set the old points to the new points    		
		    	for (int octopos=0; octopos<numPoints; octopos++)
		    	{
		    		currentPoints[octopos][0] = nextPoints[octopos][0];
		    		currentPoints[octopos][1] = nextPoints[octopos][1];
		     		currentPoints[octopos][2] = nextPoints[octopos][2];	
		    	}
			}
			
		}
			
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - generateCylindricalComponents():" + e.toString());	
		}	
	   
		
		return nextPoints;
	}


	  	/***************************************************************************************
		 * GENERATE CYLINDRICAL COMPONENTS
		 * 
		 * This method will create cylindrical components in the persistent store based
		 * upon the radius of the sphere.  
		 * 
		 * @param key
		 * @param user
		 * @return
		 * @throws DataException
		 * @throws DataSecurityException
		 ***************************************************************************************/
		  	
		  public static int generateCylindricalComponents(int numElements, double[] startPos, double radius, double cyRadius, double cyHeight, String componentType, String componentName, String parentID) 
		  throws DataException, DataSecurityException   		
		  {	
			System.out.println("generateCylindricalComponents - RADIUS: " + radius);
		
			int returnCode = 0;
			  
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
			String boundbox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			double xOrient = 0.0;
			double yOrient = 1.0;
			double zOrient = 0.0;
			double depth = 0.00125;
			double degrees = 0.0;
			
			int compGroup = 0;
			int depthDirection = 90;

				
			// Get the connection to the database
			String query ="";
			Connection con = DBUtils.getConnection();
			PreparedStatement stmt = null;
			PreparedStatement stmtGrp = null;
			
			// Determine if this component already has a slot
			int componentNum = getMinID(bodyID, projectID, componentType, parentID);
			System.out.println("GenerateCylindricalComponents() - MinID for: " + componentType + " is: " + componentNum);
			
			String componentID = "";	
			if (componentNum <= 0) {
				// Record are not defined for this component
				// Determine what's available for this database update			
				System.out.println("No Records Defined for Parent-CompType Combo");
				componentNum = DBUtils.getComponentBlock(bodyID, projectID, componentType);
				System.out.println("No Component Recs exist - Getting Next Block: " + componentNum);
				System.out.println("GenerateCylindricalComponents().Getting MAXID - GeneratedStart at: " + componentType + "   " + componentNum);
			}
			else
			{ 
				System.out.println("GenerateCylindricalComponents - Using Existing MinID - Rewriting at: " + componentType + "   " + componentNum);
			}

			// Generate the Component ID
			componentID = DBUtils.convertID(componentNum, componentType);
			System.out.println("Starting CylindricalComponentGEN at: " + componentNum + "   " + "  "+ componentType + " ID: " + componentID);
			
	
			int numLongitude = 18;
			int numLatitude = 18;
			double rotateLatitude = 360/numLatitude;
			double rotateLongitude = 360/numLongitude;
			double angleLatitude = rotateLatitude;
			double angleLongitude = rotateLongitude;
			
			//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
			//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
			
			// Run from top of the sphere to the bottom (Longitude)
			
			for (int longitude=0; longitude<numLongitude ;longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = 0;
				//System.out.println("Completed Complete Rotation - Resetting Latitude");

				for (int latitude=0; latitude<numLatitude; latitude++)
				{					
					//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
					
					// Set the position on the surface of the sphere based on angle of latitude
					// Set the position on the surface of the sphere based on the longitude
					
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					//System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
					
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
					
					// Set the position
					xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
					yPos = MathUtils.round((radius * cosLong), 8);
					zPos = MathUtils.round((radius * (sinLat * sinLong)), 8); 

					//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
					//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
					//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
					//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
					
					// Set the Orientation of the Cylinder on the surface of the Sphere
					double perpindick = angleLatitude+90;
					double perpindickRadians = Math.toRadians(perpindick);
					//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
					
					xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
					yOrient =  0;  
					zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
			
					//System.out.println("X-AXIS: " + xOrient);
					//System.out.println("Y-AXIS: " + yOrient);
					//System.out.println("Z-AXIS: " + zOrient);
			
					
					degrees = -radiansLongitude;	
					vertices = "";
						
		       		query =
		       			"UPDATE biomight.biocomp set "
		       			        + "vertices = '" + vertices + "', " 
		    	       			+ "posX = " + xPos + ","
		    	       			+ "posY = " + yPos + ","
		    	       			+ "posZ = " + zPos + ","
		    	       			+ "orientX = " + xOrient + ","
		    	       			+ "orientY = " + yOrient + ","
		    	       			+ "orientZ = " + zOrient + ","
		    	       			+ "orientW = " + degrees + ", "
		    	       			+ "radius = " + cyRadius + ", "
		    	       			+ "height = " + cyHeight + " "
		    	       			+ "where comp_id = '" + componentID + "'";
		       		
		       		
		       		//System.out.println("generateRows Update = " + query);
		    		
				
		       		// Decalre Statement and Result set
		       		boolean bMissing = false;
		       		stmt = null;
		       		try {
		       			stmt = con.prepareStatement(query);
		       			//System.out.println("Query is prepared");
		       			returnCode = stmt.executeUpdate();
		       			//System.out.println("Update Query has executed: " + returnCode);
		       		} catch (Exception e) {
		       			System.out.println("There was an exception in generateComponentRows Update");
		       			//throw new DataException("Exception during prep of query:" + e.toString());
		       			bMissing = true;
		       			System.out.println("Missing Row: " + query);
		       		}
		
		       		
		       		boolean bDuplicate = false;
		       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		       		if (bMissing || returnCode == 0)
		       		{	       			       	 			
		       			query =
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
						+ cyRadius + ",'" + + depth + "','" + compGroup + "'," + depthDirection + ","   
						+ cyHeight  + "," + xOrient + "," +  yOrient + "," + zOrient + "," + degrees + ")";
		
		 			
		       			try {
		       				stmt = con.prepareStatement(query);
		       				//System.out.println("Query is prepared");
		       				returnCode = stmt.executeUpdate();
		       				//System.out.println("InsertQry: " + query);
		       			} catch (Exception e) {
		       				System.out.println("There was an exception in generateCylindricalComponents Insert");
		       				//throw new DataException("Exception during prep of query:" + e.toString());
		       				bDuplicate = true;
		        		}	
		       			
		       			if (!bDuplicate){
			       			//Insert the Grouping
							String query2 =
								"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
							//System.out.println("GrpInsert = " + query2);
											
							// Decalre Statement and Result set 
							stmtGrp = null;
							try {
								stmtGrp = con.prepareStatement(query2);
								//System.out.println("Query2 is prepared");
								returnCode = stmtGrp.executeUpdate();
								//System.out.println("Query2 has executed");
							} catch (Exception e) {
								System.out.println("Problem Inserting bioGroup Data into generateCylindricalComponents()");
								//throw new DataException("Exception during prep of query:" + e.toString());
							}
		
		       			}
			       			
			      	}
			       	else
			       	{
			       		System.out.println("bDuplicate: " + bDuplicate);
			       	}
		    
		       		// Increment the counter
		       		componentNum++;
		       		
		       		// Generate the Component ID
		    		componentID = DBUtils.convertID(componentNum, componentType);
		    		//System.out.println("Incremented ComponentID: " + componentID);
		    		
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
				
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
			}
				
			// Close it all down now	
			//System.out.println("Closing Connection: " + returnCode);
				
			try {
				if (stmt != null)
					stmt.close();
					con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - generateCylindricalComponents():" + e.toString());	
			}	
		   
			
			return returnCode;
		}
	  	
    	
	/*****************************************************************************
	 * UPDATE COMPONENT
	 * 
	 * This method updates a component in the database
	 * 
	 * ***************************************************************************/
	  	
	public static int updateComponent(BioMightTransform bioMightTransform) 
		throws DataException, DataSecurityException   		
	{  	
		int returnCode = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		String query = "";
		
		query =
      			"UPDATE biomight.biocomp " + 
      			" set vertices = '" + bioMightTransform.getCoordpointStr() + "', " +
      			" posX = " + bioMightTransform.getTranslation().getXPos()  + ", " +
      			" posY = " + bioMightTransform.getTranslation().getYPos()  + ", " +
      			" posZ = " + bioMightTransform.getTranslation().getZPos()  + ", " +
    			" height = " + bioMightTransform.getHeight()  + ", " +
    			" orientX = " + bioMightTransform.getOrientation().getXAxis()  + ", " +
      			" orientY = " + bioMightTransform.getOrientation().getYAxis()  + ", " +
      			" orientZ = " + bioMightTransform.getOrientation().getZAxis()  + ", " +
      			" orientW = " + bioMightTransform.getOrientation().getDegrees()  + ", " +
      			" comp_name = '" + bioMightTransform.getComponentName() + "', " +
      			" comp_name_desc = '" + bioMightTransform.getComponentName() + "' " +
      			"where comp_id = '" + bioMightTransform.getComponentID() + "'";
      	System.out.println("UpdateComponent() = " + query);
    		
    		
  		// Decalre Statement and Result set
  		stmt = null;
  		try {
  			stmt = con.prepareStatement(query);
  			//System.out.println("Query is prepared");
  			returnCode = stmt.executeUpdate();
  			//System.out.println("Query has executed");
  		} catch (Exception e) {
  			System.out.println("There was an exception in UpdateComponent()");
  			//throw new DataException("Exception during prep of query:" + e.toString());
  		}
		
      	//System.out.println("UpdateComponent() returnCode: " + returnCode);
    	return (returnCode);
	}  		
     

	/*****************************************************************************
	 * INSERT COMPONENT
	 * 
	 * Inserts a component into the database
	 * 
	 * ***************************************************************************/

	public static int insertComponent(BioMightTransform bioMightTransform) 
	throws DataException, DataSecurityException   		
	{  	
		int returnCode = 0;
		String compGroup="";
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		String query = "";
		//System.out.println("insertComponent: " + bioMightTransform.getComponentID());
      			
		query =
				"INSERT into biomight.biocomp " +
				"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, texture, " +
				"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction, "  +
				"height, orientX, orientY, orientZ, orientW ) " +
				"values (" 
				+ bioMightTransform.getBodyID() + "," + bioMightTransform.getProjectID() + ",'" + bioMightTransform.getComponentID() + "','" 
				+ bioMightTransform.getComponentType() + "','" + bioMightTransform.getComponentName() + "','" + bioMightTransform.getComponentName() + "','" 
				+ bioMightTransform.getParentID() + "','" + bioMightTransform.getBoundBoxStr() + "','" + bioMightTransform.getCoordpointStr() + "',"
				+ "7, 0, " + bioMightTransform.getTranslationStr() + ", " + bioMightTransform.getScaleStr() + ", " 
				+ bioMightTransform.getRadius() + ", " + bioMightTransform.getDepth() + ",'" + compGroup + "'," + bioMightTransform.getDepthDirection() + ", "  
				+ bioMightTransform.getHeight() + ", " + bioMightTransform.getOrientationStr() + ")";
		
	
		//System.out.println("insertComponent INSERT = " + query);
	    
		//Insert the Grouping
		String query2 =
		"INSERT into biomight.biogroup values('" + bioMightTransform.getComponentID() + "','" + bioMightTransform.getParentID() + "')";
		//System.out.println("generateDNAChain GrpInsert = " + query2);

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("INSERT Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("InsertQuery has executed: " + query);
		} catch (Exception e) {
			System.out.println("There was an exception in generateaDNAChain() Update");
			//throw new DataException("Exception during prep of query:" + e.toString());
		}	

		// Decalre Statement and Result set 
		stmt2 = null;
		try {
			stmt2 = con.prepareStatement(query2);
			//System.out.println("Query2 is prepared");
			returnCode = stmt2.executeUpdate();
			//System.out.println("Query2 has executed");
		} catch (Exception e) {
			System.out.println("Exception in inserting bioGroup Data in generateaDNAChain()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		return(returnCode);
  	}

	
	/*****************************************************************************
	 * INSERT-UPDATE COMPONENT
	 * 
	 * Inserts a component into the database
	 * 
	 * ***************************************************************************/

	public static int upsertComponent(BioMightTransform bioMightTransform) 
	throws DataException, DataSecurityException   		
	{  	
		int returnCode = 0;
		String compGroup="";
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		//System.out.println("upsertComponent: " + bioMightTransform.getComponentID());
      			
		// Try UPDATE first
  		String query =  		
  			"UPDATE biomight.biocomp " + 
			" set vertices = '" + bioMightTransform.getCoordpointStr() + "', " +
			" posX = " + bioMightTransform.getTranslation().getXPos()  + ", " +
			" posY = " + bioMightTransform.getTranslation().getYPos()  + ", " +
			" posZ = " + bioMightTransform.getTranslation().getZPos()  + ", " +
			" height = " + bioMightTransform.getHeight()  + ", " +
			" orientX = " + bioMightTransform.getOrientation().getXAxis()  + ", " +
			" orientY = " + bioMightTransform.getOrientation().getYAxis()  + ", " +
			" orientZ = " + bioMightTransform.getOrientation().getZAxis()  + ", " +
			" orientW = " + bioMightTransform.getOrientation().getDegrees()  + ", " +
			" comp_name = '" + bioMightTransform.getComponentName() + "', " +
			" comp_name_desc = '" + bioMightTransform.getComponentName() + "' " +
			"where comp_id = '" + bioMightTransform.getComponentID() + "'";

  	  		
       	//System.out.println("generateRows Update = " + query);
    		
		
   		// Declare Statement and Result set
   		boolean bMissing = false;
   		stmt = null;
   		try {
   			stmt = con.prepareStatement(query);
   			//System.out.println("Query is prepared");
   			returnCode = stmt.executeUpdate();
   			//System.out.println("Update Query has executed: " + returnCode);
   		} catch (Exception e) {
   			//System.out.println("There was an exception in generateComponentRows Update");
   			//throw new DataException("Exception during prep of query:" + e.toString());
   			bMissing = true;
   			System.out.println("Missing Row: " + query);
   		}

   		// INSERT records, as the update failed
   		boolean bDuplicate = false;
   		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
   		if (bMissing || returnCode == 0)
   		{	       			       	 			
   			query =
			"INSERT into biomight.biocomp " +
			"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, texture, " +
			"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction, "  +
			"height, orientX, orientY, orientZ, orientW ) " +
			"values (" 
			+ bioMightTransform.getBodyID() + "," + bioMightTransform.getProjectID() + ",'" + bioMightTransform.getComponentID() + "','" 
			+ bioMightTransform.getComponentType() + "','" + bioMightTransform.getComponentName() + "','" + bioMightTransform.getComponentName() + "','" 
			+ bioMightTransform.getParentID() + "','" + bioMightTransform.getBoundBoxStr() + "','" + bioMightTransform.getCoordpointStr() + "',"
			+ "7, 0, " + bioMightTransform.getTranslationStr() + ", " + bioMightTransform.getScaleStr() + ", " 
			+ bioMightTransform.getRadius() + ", " + bioMightTransform.getDepth() + ",'" + compGroup + "'," + bioMightTransform.getDepthDirection() + ", "  
			+ bioMightTransform.getHeight() + ", " + bioMightTransform.getOrientationStr() + ")";
	

   			//System.out.println("UpsertComponent INSERT = " + query);
	    
			//Insert the Grouping
			String query2 =
			"INSERT into biomight.biogroup values('" + bioMightTransform.getComponentID() + "','" + bioMightTransform.getParentID() + "')";
			//System.out.println("UpsertComponent GrpInsert = " + query2);
	
			boolean bException = false;
			try {
				stmt = con.prepareStatement(query);
				//System.out.println("INSERT Query is prepared");
				returnCode = stmt.executeUpdate();
				//System.out.println("InsertQuery has executed: " + query);
			} catch (Exception e) {
				System.out.println("There was an exception in upsertComponent");
				//throw new DataException("Exception during prep of query:" + e.toString());
				bException = true;
			}	
			
			if (!bException) {
				// Decalre Statement and Result set 
				stmt2 = null;
				try {
					stmt2 = con.prepareStatement(query2);
					//System.out.println("Query2 is prepared");
					returnCode = stmt2.executeUpdate();
					//System.out.println("Query2 has executed");
				} catch (Exception e) {
					System.out.println("Exception in inserting bioGroup Data in generateaDNAChain()");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
			}
		   	
   		}
			
		return(returnCode);
  	}

	

  	/***************************************************************************************
	 * GET BIO CODE
	 * 
	 * This method returns the BioMight code instructions that assemble the object
	 *   
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
  	public static BioMightInstructSet getBioCode(String compType, String parentID) 
	throws DataException, DataSecurityException
	{	
		System.out.println("GetBioCode(): " + compType + "    " + parentID);
		
		// Create an instruction set.   
		// returned by this method
		// Set up an instructin
		BioMightInstructSet instructSet = new BioMightInstructSet();
	
	
		String query = "SELECT "
				+ "code_id, trans_type, translate_matrix, scale_matrix, rotate_vector, pivot_point, " 
				+ "orientation, rotateAngle, appendage_flag " 
				+ " FROM biomight.biocode "
				+ " where comp_type = '" + compType + "' " 
				+ " and parent_id = '" + parentID + "'"; 
		
		System.out.println("getBioCode = " + query);
	
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of getBioCode() query:" + e.toString());
		}
		
		
		try {
			while (rs.next()) {
				// Create a transformation object
				BioMightInstruction bioInstruct = new BioMightInstruction();
				System.out.println("Have Instruction: " + rs.getString("code_id"));	
				
				bioInstruct.setTransType(rs.getString("trans_type"));
				bioInstruct.setTranslateMatrix(rs.getString("translate_matrix"));
				bioInstruct.setScale(rs.getString("scale_matrix"));
				bioInstruct.setRotateVector(rs.getString("rotate_vector"));
				bioInstruct.setPivotPoint(rs.getInt("pivot_point"));
				bioInstruct.setOrientation(rs.getString("orientation"));
				bioInstruct.setTheta(rs.getInt("rotate_angle"));
				bioInstruct.setFillAppendage(false);
				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				
				
				// Add the transform to the collection of transforms
				instructSet.addElement(bioInstruct);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getComponentProperties():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponentProperties():" + e.toString());	
			}
		}
			    		
	
		return instructSet;
	}	
	  	
  	
	/***************************************************************************************
	 * INSERT BIO CODE
	 * 
	 * This will save the component's properties to the database
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
  	public static int insertBioCode(String compType, String parentID, String startID, BioMightInstructSet bioMightInstructSet) 
	throws DataException, DataSecurityException   		
	{	
  		System.out.println("InsertBioCode: " + parentID);

		int returnCode = 0;
		  
		int bodyID = 1;
		int projectID = 1;
			
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
			
	
		// Get the Current Component ID, as we are updating from there
		int componentNum = 0;
		
		// Get the Starting Point based on the value sent into the method
		if (!StringUtils.isEmpty(startID))
		{		
			// The ID was passed in, so use it
			try
			{
				//System.out.println("Starting Update at ComponentID: " + startID);
				componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
				String componentBase = startID.substring(0,startID.indexOf(":"));
				System.out.println("updateBioCode() - Using Predefined StartID: " + startID + "   " +  componentBase + "   " + componentNum);
			}
			catch (Exception e) {
				System.out.println("updateBioCode - Bad Starting Position for Component:" + e.toString());
			} 
		}
		
		
		// Store the Properties in the database.  We should probably just use the name,
		// but I'm including an ID
		System.out.println("InsertBioCode - NumInstructions: " + bioMightInstructSet.getSize());
		for (int numProp=0; numProp<bioMightInstructSet.getSize(); numProp++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction  bioInstruct = (BioMightInstruction) bioMightInstructSet.getElement(numProp);
			  
			// Generate the Component ID
			String codeID = DBUtils.convertID(componentNum, compType);
			System.out.println("Store BioCode for CodeID: " + codeID + "    transformType: " + bioInstruct.getTransType());
			
    		query =
       			"UPDATE biomight.biocode set " + 		
    		    "trans_type = '" + bioInstruct.getTransType() + "', " +
    		    "translate_matrix = '" + bioInstruct.getTranslationMatrixStrWC() + "', " +
    		    "scale_matrix = '" + bioInstruct.getScaleStrWC() + "', " +
    		    "rotate_vector = '" + bioInstruct.getRotateVectorStrWC()  + "', " +	
    		    "pivot_point = " + bioInstruct.getPivotPoint() + ", " +	
    		    "orientation = '" + bioInstruct.getOrientation().getOrientationStrWC() + "', " +	
    		    "rotateAngle = " + bioInstruct.getTheta() + ", " +	
    		    "appendage_flag = " + bioInstruct.isFillAppendageInt() + " " +	
    		    
       			"where parent_id = '" + parentID + "' " +
       			"and comp_type = '" + compType + "' " +
       			"and code_id = '" + codeID + "' " ;
       			
       		System.out.println("BioCode - Update = " + query);
	        		
    		
       		// Declare Statement and Result set
       		boolean bMissing = false;
       		stmt1 = null;
       		try {
       			stmt1 = con.prepareStatement(query);
       			System.out.println("BioCoode Query is prepared");
       			returnCode = stmt1.executeUpdate();
       			System.out.println("BioCode Query has executed: " + returnCode);
       		} catch (Exception e) {
       			System.out.println("There was an exception in updateBioCoode Update");
       			//throw new DataException("Exception during prep of query:" + e.toString());
       			bMissing = true;
       		}
   
       		boolean bDuplicate = false;
       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
	   		if (bMissing || returnCode == 0)
	   		{	       			       	 			
	   			query =
				"INSERT into biomight.biocode " +
				"(body_id, project_id, parent_id, code_id, comp_type, "
				+ "trans_type, translate_matrix, scale_matrix, rotate_vector, pivot_point, "
				+ "orientation, rotateAngle, appendage_flag) "
				+ "values (" 
				+ bodyID + "," + projectID + ",'" + parentID + "','" 
				+ codeID + "','" + compType + "','" 
				+ bioInstruct.getTransType()  + "','" 
				+ bioInstruct.getTranslationMatrixStrWC() + "','" 
				+ bioInstruct.getScaleStrWC() + "','"
				+ bioInstruct.getRotateVectorStrWC() + "'," 
				+ bioInstruct.getPivotPoint() + ",'" 
				+ bioInstruct.getOrientation().getOrientationStrWC() + "'," 
				+ bioInstruct.getTheta() + "," 
				+ bioInstruct.isFillAppendageInt() + ")";
				 
 	
	   			
       			try {
       				System.out.println("Preparing InsertBioCode: " + query);
       				stmt2 = con.prepareStatement(query);
       				System.out.println("BioCode Query is prepared!");
       				returnCode = stmt2.executeUpdate();
       				System.out.println("BioCoode Insert Qry Completed: " + query);
       			} catch (Exception e) {
       				System.out.println("There was an exception in insertBioCode Insert");
       				//throw new DataException("Exception during prep of query:" + e.toString());
       				bDuplicate = true;
        		}	
       			
       			
      		}
       		else
       		{
       		//System.out.println("bDuplicate: " + bDuplicate);
       		}
	   		
	   		
	   		// Increment the counter
       		componentNum++;
		}
		
		// Close it all down now	
		//System.out.println("Closing Connection: " + returnCode);
			
		try {
			if (stmt1 != null)
				stmt1.close();

			if (stmt2 != null)
				stmt2.close();
			
			con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - insertBioCode():" + e.toString());	
		}	
	   
		
		return 0;
	}
	
  
	
	
	/*****************************************************************************
	 * DELETE COMPONENT
	 * 
	 * Deletes a component from the database
	 * 
	 * ***************************************************************************/

	public static int deleteComponent(String componentID) 
	throws DataException, DataSecurityException   		
	{  	
		int returnCode = 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		//System.out.println("deleteComponent() : " + componentID);
   
		// Insert the Component		
		String pruneQuery =
			"DELETE from biomight.biocomp where comp_id = '" + componentID + "'"; 
			//" and comp_id = '" +  + "'"; 
		System.out.println("deleteComponent() delquery = " + pruneQuery);

		String pruneQuery2 =
			"DELETE from biomight.biogroup where comp_id = '" + componentID + "'";
			//" and comp_id = '" + newComponentID + "'"; 
		//System.out.println("deleteComponent() = " + pruneQuery2);

		
		// Declare Statement and Result set 
		stmt = null;
		try {
			stmt = con.prepareStatement(pruneQuery);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("Exception in deleting bioComp Data in deleteComponent()");
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
			System.out.println("Exception in deleting bioGroup Data in deleteComponent()");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		return (returnCode);
	}
	
	
  	
	/*****************************************************************************
	 * GET COMPONENT BLOCK
	 * 
	 * This 
	 * 
	 * ***************************************************************************/
	  	
	public static int getComponentBlock(int bodyID, int projectID, String componentType) 
		throws DataException, DataSecurityException   		
	{  	
		int returnCode = 0;
		int curSequence = 1;
		int blockSize = 240;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		String query = "";
		
		// First, get the current block size
		query =
      		"select cur_seq, blocksize from biomight.bioseq " + 
      		" where body_id = " + bodyID + 
      		" and project_id = " + projectID + 
    		" and comp_type = '" + componentType + "'";
		
		
		System.out.println("getComponentBlock() = " + query);
	
		// Declare Statement and Result set 
		stmt = null;
		ResultSet rs = null;
		try {
				stmt = con.prepareStatement(query);
				//System.out.println("Query is prepared");
				rs = stmt.executeQuery();
				//System.out.println("Query has executed");
			} catch (Exception e) {
				System.out.println("Exception in getComponentBlock()");
				throw new DataException("Exception during prep of query:" + e.toString());
			}
				
			// Get the result
			try {
				while (rs.next()) {	
					curSequence = rs.getInt("cur_seq"); 
					blockSize = rs.getInt("blocksize"); 
					System.out.println("getComponentBlock() CurrentSeq: " + curSequence + " blockSize  " + blockSize);
				}
					
			} 
			catch (Exception e) 
			{
				System.out.println("Exception during getComponentBlock():" + e.toString());
			} 
			finally 
			{
				try {
	 				if (rs != null)
	 					rs.close();
	 				
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					System.out.println("Caught in Finally - getComponentBlock():" + e.toString());	
			}
		}

		// increment the block count by the blocksize
		int nextBlock = curSequence + blockSize;
		System.out.println("Next Block Starts at: " + nextBlock);
				
		query =
      			"UPDATE biomight.bioseq " + 
      			" set cur_seq = '" + nextBlock + "' " +
      			" where body_id = " + bodyID  +
      			" and project_id = " + projectID +
    			" and comp_type = '" + componentType + "'";
    			
      	System.out.println("UpdateComponentBlock() = " + query);
    		
    		
  		// Decalre Statement and Result set
  		stmt = null;
  		try {
  			stmt = con.prepareStatement(query);
  			// System.out.println("Query is prepared");
  			returnCode = stmt.executeUpdate();
  			//System.out.println("Query has executed");
  		} catch (Exception e) {
  			System.out.println("There was an exception in UpdateComponentBlock()");
  			//throw new DataException("Exception during prep of query:" + e.toString());
  		}		
  		 finally {
 			try {
 				if (stmt != null)
 					stmt.close();
 				con.close();
 			} catch (Exception e) {
 				System.out.println("Caught in Finally - UpdateComponentBlock():" + e.toString());	
 			}
 		}
  		
  		
      	//System.out.println("UpdateComponent() returnCode: " + returnCode);
    	return (curSequence);
	}  		
     
		
		
	/*****************************************************************************
	 * GET CONNECTION
	 * 
	 * 
	 * ***************************************************************************/
	
	public static Connection getConnection()
	throws DataException
	{
		java.sql.Connection conn = null;
		try {
			InitialContext ctx = new InitialContext();
			javax.sql.DataSource ds = (DataSource) ctx.lookup(DATASOURCE);		
			//System.out.println("Getting Connection");	
			conn = ds.getConnection();
			//System.out.println("Returning Connection");	
			return conn;
		}
		catch (Exception ex)
		{
			throw new DataException("Error getting DB connection to " + DATASOURCE +  ": " + ex);
		}
			
		
	}

	
	/*****************************************************************************
	 * CLOSE CONNECTION
	 * 
	 * 
	 * ***************************************************************************/

	public static void closeConnection(Connection con)
	{
		try {
			if (con!=null)
				con.close();
		}
		catch (Exception ex)
		{
			System.out.println("Error getting DB connection to " + DATASOURCE +  ": " + ex);
		}	
	}



	public static String getInClause(String[] values)
	{
		if (values == null || values.length==0)
			return "''";
		
		StringBuffer sb = new StringBuffer("");
		for (int i=0;i<values.length;i++)
			if (values[i] == null)
				sb.append("NULL,");
			else
				sb.append("'" + values[i] +"',");
		// Delete the last comma
		sb.deleteCharAt(sb.length()-1);

		return "(" + sb.toString() + ")";
	}


	public static String getIntInClause(int[] values)
	{
		if (values == null || values.length==0)
			return "''";
		
		StringBuffer sb = new StringBuffer("");
	
		for (int i=0;i<values.length;i++) {
			sb.append(values[i] +",");
		}
	
		// Delete the last comma
		sb.deleteCharAt(sb.length()-1);

		return "(" + sb.toString() + ")";
	}


	public static String date2SQLString(Date d)
	{
		DateFormat sDateFormat = new SimpleDateFormat(DATE_FORMAT_SQL);

		if (d==null)
			return null;
		else
			return 	sDateFormat.format(d);
	}

	public static String date2SQLStringNoNull(Date d)
	{
		DateFormat sDateFormat = new SimpleDateFormat(DATE_FORMAT_SQL);

		if (d==null)
			return "";
		else
			return 	sDateFormat.format(d);
	}

	public static String decimal2SQLString(BigDecimal d) {
		if(d == null) {
			return "";
		} else {
			return d.toString();
		}
	}
	
	
	
	/*************************************************************************
	 *  CONVERT COMPONENT NUM
	 *  
	 *  Convert the component number 
	 *  
	 ************************************************************************/ 
		
	public static String convertComponentID(String componentBaseName, int componentNum) 
	{ 
		String componentNumStr = "";
		// Generate the Component ID
		if (componentNum < 10)
			componentNumStr = componentBaseName + ":0000" + componentNum;
		else if (componentNum < 100)
			componentNumStr = componentBaseName + ":000" + componentNum;
		else if (componentNum < 1000)
			componentNumStr = componentBaseName + ":00" + componentNum;
		else if (componentNum < 10000)
			componentNumStr = componentBaseName + ":0" + componentNum;
   
		return(componentNumStr);
	}

	/*************************************************************************
	 *  COMBINE POINT SET
	 *  
	 *  Reduce the number of points in the list as we are not applying
	 *  the graphic routine to all points. 
	 *  
	 ************************************************************************/ 
		
	public static double[][] combinePointSet(int[] pointList, double[][] currentPoints) 
	{ 
		
		// Run through the point list and extract the current points.  
		double[][] newPoints = { {0, 0, 0} };
		return(newPoints);
	}
	

	
}
