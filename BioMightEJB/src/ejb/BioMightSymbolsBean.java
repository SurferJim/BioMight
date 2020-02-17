package biomight.ejb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;



/***************************************************************************
 * Session Bean implementation class BioMightTissueBean
 * 
 * 
 ****************************************************************************/

@Stateless
public class BioMightSymbolsBean implements BioMightSymbolsBeanLocal {
	private static final int ROTATE  = 1;
	private static final int TRANSLATE  = 2;
	private static final int SCALE  = 3;
	
	
    /**
     * Default constructor. 
     */
    public BioMightSymbolsBean() {
        // TODO Auto-generated constructor stub
    }

    
    
 	/***************************************************************************************
	 * SET COMPONENT MATERIAL 
	 * 
	 * This method sets the material for a specific component
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setComponentDesc(String componentID, String compDesc) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In setComponentDesc()");
		
		String query =
			"UPDATE biomight.biocomp set comp_desc = '" + compDesc + "'" + 
			" where comp_id = '" + componentID + "'";
		//System.out.println("setBioText Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("setComponentDescQuery(): " + query);
			returnCode = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("There was an exception in setComponentDescQuery()");
			throw new DataException("Exception during preparation of setComponentDescQuery():" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setComponentDescQuery():" + e.toString());	
			}

		return returnCode;
	}
	
	/***************************************************************************************
	 * SET COMPONENT FONT
	 * 
	 * This method sets the font for a specific component
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setComponentFont(String componentID, int font) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In setComponentFont(): " + font);
		
		String query =
			"UPDATE biomight.biocomp set font = " + font + 
			" where comp_id = '" + componentID + "'";
		//System.out.println("setFont() Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("setComponentFontQuery(): " + query);
			returnCode = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("There was an exception in setComponentFontQuery()");
			throw new DataException("Exception during preparation of setComponentFontQuery():" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setComponentFontQuery():" + e.toString());	
			}

		return returnCode;
	}
	
	
	/*******************************************************************************************
	 * GENERATE BIO ARROWS
	 * 
	 * This method will be called to generate a collection of Arrow object that can be added 
	 * into a BioMight animation.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateBioArrows(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		//System.out.println("In GenerateBioArrows: " + startID);

   		int returnCode = DBUtils.generateSymbols(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}

   	
	/*******************************************************************************************
	 * GENERATE TEXTS
	 * 
	 * This method will be called to generate a collection of Text object that can be added 
	 * into a BioMight animation.  
	 *  
	 * @param key
	 * @param user
	 * @retur
	 * @throws DataException
	 * @throws DataSecurityException
	 ******************************************************************************************/
	
   	public int generateBioTexts(int numElements, String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
	{	
		//System.out.println("In GenerateBioTexts: " + startID);

   		int returnCode = DBUtils.generateSymbols(numElements, startID, componentType, componentName, componentID, parentID, currentPoints); 
		return returnCode;	
	}

   	
   	

   
    
}
