package biomight.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;



/***************************************************************************
 * Session Bean implementation class BioMightTissueBean
 * 
 * 
 ****************************************************************************/

@Stateless
public class BioMightChemistryBean implements BioMightChemistryBeanLocal {
	
	
    /**
     * Default constructor. 
     */
    public BioMightChemistryBean() {
        // TODO Auto-generated constructor stub
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
		int returnCode = generateCluster(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}

   	
   	
   	
	/*******************************************************************************************
	 * GENERATE CELLS
	 * 
	 * This method will be called to generate a collection of Cells  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	private int generateCluster(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		System.out.println("In GenerateCluster: " + startID);
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
		// Get the current cluster size
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

				// Apply Spatial Distribution Algorothm
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
					"(body_id, project_id, comp_id, comp_type, comp_name, comp_name_desc, parent_id, boundbox, vertices, material, " +
					"posX, posY, posZ, scaleX, scaleY, scaleZ, radius, depth, comp_group, depth_direction ) " +
					"values (" 
					+ bodyID + "," + projectID + ",'" + newComponentID + "','" 
					+ componentType + "','" + componentName + "','" + componentName + "','" 
					+ parentID + "','" + boundbox + "','" + vertices + "',"
					+ "7," + xPos + "," + yPos + "," + zPos + "," 
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
		
		return returnCode;	
	}

  
    
}
