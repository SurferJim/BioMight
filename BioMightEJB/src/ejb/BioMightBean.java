package biomight.ejb;

import javax.ejb.Stateless;

import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightColor;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightText;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.view.DropDownPair;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.commons.lang.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


/********************************************************************************
 * Session Bean implementation class BioMightBean
 * 
 *******************************************************************************/

@Stateless
public class BioMightBean implements BioMightBeanLocal {

    /**
     * Default constructor. 
     */
    public BioMightBean() {
        // TODO Auto-generated constructor stub
    }
    	

 	
	/***************************************************************************************
	 * GET MATERIAL 
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightMaterial getMaterial(int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In Get Material EJB");
		
		// Create a BioMightMaterial object that will be 
		// returned by this method
		BioMightMaterial bioMightMaterial = new BioMightMaterial();
		
		String query =
			"SELECT "
				+ "diffuseColorRed, diffuseColorBlue, diffuseColorGreen "
				+ " FROM biomight.materials where id=" + materialID;
		//System.out.println("getMaterial Query = " + query);

		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			
			if (rs.next()) {
				//System.out.println("Have Material Record...");	
				//bioMightMaterial.setShininess(rs.getDouble("shininess"));
				//bioMightMaterial.setTransparency(rs.getDouble("transparency"));
				double red = rs.getDouble("diffuseColorRed");
				double blue = rs.getDouble("diffuseColorBlue");
				double green = rs.getDouble("diffuseColorGreen");	

				BioMightColor bioMightColor = new BioMightColor(red, blue, green); 
				bioMightMaterial.setDiffuseColor(bioMightColor);
				bioMightMaterial.setSpecularColor(bioMightColor);
				bioMightMaterial.setEmissiveColor(bioMightColor);
				//System.out.println("Set information into BioMightColor Red: " + bioMightColor.getRed());
				//System.out.println("Set information into BioMightColor Blue: " + bioMightColor.getBlue());
				//System.out.println("Set information into BioMightColor Green: " + bioMightColor.getGreen());
			}
			else
				System.out.println("No records for ID : "+ materialID);
			
		} catch (Exception e) {
			System.out.println("Exception during getMaterial():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getMaterial():" + e.toString());	
			}
		}

		return bioMightMaterial;
	}


	/***************************************************************************************
	 * GET MATERIALS DD MAP
	 * 
	 * Load up the name,value pair into a map that can be used as a drop down display
	 * picklist.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public HashMap getMaterialsDDMap() 
		throws DataException, DataSecurityException
	{	
		//System.out.println("BioMightBean: In Get MaterialsDDMap");
		
		String query = "SELECT id, name from biomight.materials";
		//String query = "SELECT id, name, comp_type from biomight.materials";
		 
		//System.out.println("getMaterials Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Declare Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		java.util.HashMap materials = new HashMap();
		try {
			//System.out.println("Executing Next!");
			while (rs.next()) {
				//System.out.println("Loading Materials");
				
				int id = rs.getInt("id"); 
				String name = rs.getString("name");
				materials.put(id,  name);
				//System.out.printlngro("BioMightBean.getMaterials - Loaded: " + id + "   " + name + "  " + comp_type);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getMaterial():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getMaterial():" + e.toString());	
			}
		}

		return materials;
	}

 	
	/***************************************************************************************
	 * GET TEXTURE 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTexture getTexture(int textureID) 
		throws DataException, DataSecurityException
	{	 
		//System.out.println("In Get Texture Method in EJB");
		
		// Create a BioMightTexture object that will be 
		// returned by this method
		BioMightTexture bioMightTexture = new BioMightTexture();
		
		String query =
			"SELECT "
				+ " texture_name, texture_file "
				+ " FROM biomight.textures where texture_id = " + textureID;
		//System.out.println("getTexture Query = " + query);

		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			
			if (rs.next()) {
				//System.out.println("Have Texture Record...");	
				bioMightTexture.setTextureId(textureID);
				bioMightTexture.setTextureName(rs.getString("texture_name"));
				bioMightTexture.setTextureFile(rs.getString("texture_file"));
			}
			else
				System.out.println("No records for ID : "+ textureID);
			
		} catch (Exception e) {
			System.out.println("Exception during getTexture():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getTexture():" + e.toString());	
			}
		}

		return bioMightTexture;
	}
	
	/***************************************************************************************
	 * GET TEXTURES DD MAP
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public HashMap getTexturesDDMap() 
		throws DataException, DataSecurityException
	{	
		//System.out.println("BioMightBean: In Get Textures");
		
		String query = "SELECT texture_id, texture_name from biomight.textures";
		//String query = "SELECT id, name, comp_type from biomight.textures";
		 
		//System.out.println("getTextures Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Declare Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		HashMap textures = new HashMap();
		try {
			//System.out.println("Executing Next!");
			while (rs.next()) {
				//System.out.println("Loading Textures");
				
				int id = rs.getInt("texture_id"); 
				String name = rs.getString("texture_name");
				textures.put(id,  name);
		
				//System.out.println("BioMightBean.getTextures - Loaded: " + bioMightTexture.getTextureId() + "   " + bioMightTexture.getTextureFile());
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getTextures():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getTextures():" + e.toString());	
			}
		}

		return textures;
	}

	
	
	/***************************************************************************************
	 * TEXTURES
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private ArrayList getTexturesOrig() 
		throws DataException, DataSecurityException
	{	
		//System.out.println("BioMightBean: In Get Textures");
		
		String query = "SELECT texture_id, texture_name, texture_file from biomight.textures";
		//String query = "SELECT id, name, comp_type from biomight.textures";
		 
		//System.out.println("getTextures Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Declare Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		ArrayList textures = new ArrayList();
		BioMightTexture bioMightTexture;
		try {
			//System.out.println("Executing Next!");
			while (rs.next()) {
				//System.out.println("Loading Textures");
				
				bioMightTexture = new BioMightTexture();
				bioMightTexture.setTextureId(rs.getInt("texture_id"));
				bioMightTexture.setTextureName(rs.getString("texture_name"));
				bioMightTexture.setTextureFile(rs.getString("texture_file"));
				
				textures.add(bioMightTexture);
				//System.out.println("BioMightBean.getTextures - Loaded: " + bioMightTexture.getTextureId() + "   " + bioMightTexture.getTextureFile());
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getTextures():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getTextures():" + e.toString());	
			}
		}

		return textures;
	}

	
	
	/***************************************************************************************
	 * GET FONTS
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public HashMap getFontsDDMap() 
		throws DataException, DataSecurityException
	{	
		//System.out.println("BioMightBean: In Get Fonts");
		String query = "SELECT id, name from biomight.biotext";
		 
		//System.out.println("getFonts Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Declare Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		HashMap fonts = new HashMap();
		try {
			//System.out.println("Executing Next!");
			while (rs.next()) {
				//System.out.println("Loading Fonts");	
				int id = rs.getInt("id"); 
				String name = rs.getString("name");
				fonts.put(id,  name);
				//System.out.printlngro("BioMightBean.getFonts - Loaded: " + id + "   " + name + "  " + comp_type);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getFonts():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getFonts():" + e.toString());	
			}
		}

		return fonts;
	}
	
	
	/***************************************************************************************
	 * GET COMPONENTS 
	 * 
	 * This method returns the components given the component Type, the parent ID, and
	 * the type of view one is looking through.    
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTransforms getComponentsByView(String componentType, String view) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Components");
		
		// Create an array of Tranform objects 
		// returned by this method
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		
		String query =
			"SELECT "
				+ "com.com.comp_id, comp_name, vertices, posX, posY, posZ, scaleX, scaleY, scaleZ, radius, "
				+ " height, orientX, orientY, orientZ, orientW, com.material, com.texture, com.font, " 
				+ " mat.transparency, mat.shininess, txt.texture_name, txt.texture_file, biotxt.family, biotxt.size, biotxt.style, biotxt.justify, biotxt.spacing, biotxt.maxEnt, "
				+ " diffuseColorRed, diffuseColorGreen, diffuseColorBlue, depth, depth_direction, comp_desc, height "
				+ " FROM biomight.biocomp com, biomight.materials mat, biomight.textures txt, biomight.biotext biotxt, biomight.focus fs "
				+ " where com.comp_type = '" + componentType + "'"
				+ " and fs.view = '" + view + "'"
				+ " and com.comp_id = fs.comp_id "
				+ " and com.parent_id = fs.parent_id " 
				+ " and com.material = mat.id " 
				+ " and com.texture = txt.texture_id " 
				+ " and com.font = biotxt.id "; 
		
		//System.out.println("getComponentByView = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			while (rs.next()) {
				// Create a transformation object
				BioMightTransform bioMightTransform = new BioMightTransform();
				//System.out.println("Found Component: " + rs.getString("comp_name"));	
				
				// Set the ID
				bioMightTransform.setComponentID(rs.getString("comp_id"));
				
				// Set the name
				bioMightTransform.setComponentName(rs.getString("comp_name"));
			
				//Set the Component Description into the BioText field- currently 512 varchar
				bioMightTransform.setBioText(rs.getString("comp_desc"));
	
				// Set up the Position
				BioMightPosition bioMightPosition = new BioMightPosition();
				bioMightPosition.setXPos(rs.getDouble("posX"));
				bioMightPosition.setYPos(rs.getDouble("posY"));
				bioMightPosition.setZPos(rs.getDouble("posZ"));
				bioMightTransform.setTranslation(bioMightPosition);

				// Set up the Scale
				BioMightScale bioMightScale = new BioMightScale();
				bioMightScale.setXScale(rs.getDouble("scaleX"));
				bioMightScale.setYScale(rs.getDouble("scaleY"));
				bioMightScale.setZScale(rs.getDouble("scaleZ"));
				bioMightTransform.setScale(bioMightScale);
				
				bioMightTransform.setRadius(rs.getDouble("radius"));
				bioMightTransform.setDepth(rs.getDouble("depth"));
				bioMightTransform.setDepth(rs.getInt("depth_direction"));
				
				// Set up the Orientation
				BioMightOrientation bioMightOrientation = new BioMightOrientation();
				bioMightOrientation.setXAxis(rs.getDouble("orientX"));
				bioMightOrientation.setYAxis(rs.getDouble("orientY"));
				bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
				bioMightOrientation.setDegrees(rs.getDouble("orientW"));
				bioMightTransform.setOrientation(bioMightOrientation);
				
				bioMightTransform.setHeight(rs.getDouble("height"));	
			 
				bioMightTransform.setCoordpoint(rs.getString("vertices"), rs.getDouble("depth"), rs.getInt("depth_direction"));
				//bioMightTransform.setCreaseAngle(0.524);   
				bioMightTransform.setCreaseAngle(1.57);
				
				// Set up the Material
				BioMightMaterial material = new BioMightMaterial();
				
				// Set up the Diffuse Color
				BioMightColor diffuseColor = new BioMightColor(rs.getDouble("diffuseColorRed"), rs.getDouble("diffuseColorGreen"), rs.getDouble("diffuseColorBlue"));
				material.setDiffuseColor(diffuseColor);  
				
				material.setShininess(rs.getDouble("shininess"));
				material.setTransparency(rs.getDouble("transparency"));
				
				// Store the Material into the Transform Object
				bioMightTransform.setMaterial(material);
				bioMightTransform.setMaterialID(rs.getInt("material"));
				
				bioMightTransform.setTextureID(rs.getInt("texture"));
				bioMightTransform.setTextureName(rs.getString("texture_name"));
				bioMightTransform.setTextureFile(rs.getString("texture_file"));
			
				BioMightText bioMightText = new BioMightText();
				bioMightTransform.setTextID(rs.getInt("font"));
				bioMightText.setFamily(rs.getString("family"));
				bioMightText.setStyle(rs.getString("style"));
				bioMightText.setJustify(rs.getString("justify"));
				bioMightText.setSize(rs.getDouble("size"));
				bioMightText.setSpacing(rs.getDouble("spacing"));
				bioMightText.setMaxEnt(rs.getDouble("maxEnt"));
				bioMightTransform.setBioMightText(bioMightText);
				
				// Get the associated vetices and store them in the transform
				//ArrayList vetices = getVerticies(rs.getString("comp_id"));
				
				// Add the transform to the collection of transforms
				bioMightTransforms.add(bioMightTransform);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getComponentsByView():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponentsByView():" + e.toString());	
			}
		}
				
		
		return bioMightTransforms;
	}
	
	/***************************************************************************************
	 * GET COMPONENTS 
	 * 
	 * This method returns the components given the component Type and the
	 * parent ID.  It joins with the biogroup table by parent id to get the
	 * components.  The parent ID determines which components are getting 
	 * affected
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTransforms getComponents(String componentType, String parentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Components");
		
		// Create an array of Tranform objects 
		// returned by this method
		BioMightTransforms bioMightTransforms = new BioMightTransforms();

		String query = "SELECT "
				+ "com.comp_id, comp_name, boundbox, vertices, posX, posY, posZ, scaleX, scaleY, scaleZ, radius, "
				+ " height, orientX, orientY, orientZ, orientW, com.material, com.texture, com.font, " 
				+ " mat.transparency, mat.shininess, txt.texture_name, txt.texture_file, biotxt.family, biotxt.size, biotxt.style, biotxt.justify, biotxt.spacing, biotxt.maxEnt, "
				+ " diffuseColorRed, diffuseColorGreen, diffuseColorBlue, depth, depth_direction, comp_desc "
				+ " FROM biomight.biocomp com, biomight.materials mat, biomight.textures txt, biomight.biotext biotxt, biomight.biogroup grp "
				+ " where com.comp_type = '" + componentType + "'" 
				+ " and grp.parent_id = '" + parentID + "'" 
				+ " and com.comp_id = grp.comp_id "
				+ " and com.material = mat.id " 
				+ " and com.texture = txt.texture_id  " 
				+ " and com.font = biotxt.id "; 
				
		//System.out.println("getComponents = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			while (rs.next()) {
				// Create a transformation object
				BioMightTransform bioMightTransform = new BioMightTransform();
				//System.out.println("Found Component: " + rs.getString("comp_name"));	
				
				// Set the component ID
				bioMightTransform.setComponentID(rs.getString("comp_id"));
				
				// Set the component name
				bioMightTransform.setComponentName(rs.getString("comp_name"));
				
				//Set the Component Description into the BioText field- currently 512 varchar
				bioMightTransform.setBioText(rs.getString("comp_desc"));
				
				// Set up the Position
				BioMightPosition bioMightPosition = new BioMightPosition();
				bioMightPosition.setXPos(rs.getDouble("posX"));
				bioMightPosition.setYPos(rs.getDouble("posY"));
				bioMightPosition.setZPos(rs.getDouble("posZ"));
				bioMightTransform.setTranslation(bioMightPosition);

				// Set up the Scale
				BioMightScale bioMightScale = new BioMightScale();
				bioMightScale.setXScale(rs.getDouble("scaleX"));
				bioMightScale.setYScale(rs.getDouble("scaleY"));
				bioMightScale.setZScale(rs.getDouble("scaleZ"));
				bioMightTransform.setScale(bioMightScale);
				
				
				// Set up the Orientation
				BioMightOrientation bioMightOrientation = new BioMightOrientation();
				bioMightOrientation.setXAxis(rs.getDouble("orientX"));
				bioMightOrientation.setYAxis(rs.getDouble("orientY"));
				bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
				bioMightOrientation.setDegrees(rs.getDouble("orientW"));
				bioMightTransform.setOrientation(bioMightOrientation);
		
				
				bioMightTransform.setRadius(rs.getDouble("radius"));
				bioMightTransform.setDepth(rs.getDouble("depth"));
				bioMightTransform.setDepthDirection(rs.getInt("depth_direction"));
				
				bioMightTransform.setHeight(rs.getDouble("height"));
				
				bioMightTransform.setBoundBox(rs.getString("boundbox"));				
				bioMightTransform.setCoordpoint(rs.getString("vertices"), rs.getDouble("depth"), rs.getInt("depth_direction"));
				
				//bioMightTransform.setCreaseAngle(0.524);   
				bioMightTransform.setCreaseAngle(1.57);
				
				// Set up the Material
				BioMightMaterial material = new BioMightMaterial();
						
				// Set up the Diffuse Color
				BioMightColor diffuseColor = new BioMightColor(rs.getDouble("diffuseColorRed"), rs.getDouble("diffuseColorGreen"), rs.getDouble("diffuseColorBlue"));
				material.setDiffuseColor(diffuseColor);  
				
				material.setShininess(rs.getDouble("shininess"));
				material.setTransparency(rs.getDouble("transparency"));
				
				// Store the Material into the Transform Object
				bioMightTransform.setMaterial(material);				
				bioMightTransform.setMaterialID(rs.getInt("material"));
				
				bioMightTransform.setTextureID(rs.getInt("texture"));	
				bioMightTransform.setTextureName(rs.getString("texture_name"));
				bioMightTransform.setTextureFile(rs.getString("texture_file"));
				
				BioMightText bioMightText = new BioMightText();
				bioMightTransform.setTextID(rs.getInt("font"));
				bioMightText.setFamily(rs.getString("family"));
				bioMightText.setStyle(rs.getString("style"));
				bioMightText.setJustify(rs.getString("justify"));
				bioMightText.setSize(rs.getDouble("size"));
				bioMightText.setSpacing(rs.getDouble("spacing"));
				bioMightText.setMaxEnt(rs.getDouble("maxEnt"));
				bioMightTransform.setBioMightText(bioMightText);
				
				
				// Get the associated vetices and store them in the transform
				//ArrayList vetices = getVerticies(rs.getString("comp_id"));
				
				// Add the transform to the collection of transforms
				bioMightTransforms.add(bioMightTransform);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getComponents():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponents():" + e.toString());	
			}
		}
			    		

		return bioMightTransforms;
	}
	

	/***************************************************************************************
	 * GET COMPONENTS BY PARENT
	 * 
	 * This method returns the components given the component Type and the
	 * parent ID.  It joins with the biogroup table by parent id to get the
	 * components.  The parent ID determines which components are getting 
	 * affected
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTransforms getComponentsByParent(String parentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get ComponentsByParent");
		
		// Create an array of Tranform objects 
		// returned by this method
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		
		String query =
			"SELECT "
				+ "com.comp_id, comp_name, boundbox, vertices, posX, posY, posZ, scaleX, scaleY, scaleZ, radius, "
				+ " height, orientX, orientY, orientZ, orientW, com.material, com.texture, com.font, " 
				+ " mat.transparency, mat.shininess, txt.texture_name, txt.texture_file, biotxt.family, biotxt.size, biotxt.style, biotxt.justify, biotxt.spacing, biotxt.maxEnt,"
				+ " diffuseColorRed, diffuseColorGreen, diffuseColorBlue, depth, depth_direction, comp_desc "
				+ " FROM biomight.biocomp com, biomight.materials mat, biomight.textures txt, biomight.biotext biotxt, biomight.biogroup grp "
				+ " where grp.parent_id = '" + parentID + "'" 
				+ " and com.material = mat.id" 
				+ " and com.comp_id = grp.comp_id "
				+ " and com.texture = txt.texture_id " 	 
				+ " and com.font = biotxt.id ";
		
		//System.out.println("getComponents = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			while (rs.next()) {
				// Create a transformation object
				BioMightTransform bioMightTransform = new BioMightTransform();
				//System.out.println("Found Component: " + rs.getString("comp_name"));	
				
				// Set the ID
				bioMightTransform.setComponentID(rs.getString("comp_id"));
				
				// Set the name
				bioMightTransform.setComponentName(rs.getString("comp_name"));
							
				//Set the Component Description into the BioText field- currently 512 varchar
				bioMightTransform.setBioText(rs.getString("comp_desc"));
	
				// Set up the Position
				BioMightPosition bioMightPosition = new BioMightPosition();
				bioMightPosition.setXPos(rs.getDouble("posX"));
				bioMightPosition.setYPos(rs.getDouble("posY"));
				bioMightPosition.setZPos(rs.getDouble("posZ"));
				bioMightTransform.setTranslation(bioMightPosition);

				// Set up the Translation
				BioMightScale bioMightScale = new BioMightScale();
				bioMightScale.setXScale(rs.getDouble("scaleX"));
				bioMightScale.setYScale(rs.getDouble("scaleY"));
				bioMightScale.setZScale(rs.getDouble("scaleZ"));
				bioMightTransform.setScale(bioMightScale);
			
				// Set up the Orientation
				BioMightOrientation bioMightOrientation = new BioMightOrientation();
				bioMightOrientation.setXAxis(rs.getDouble("orientX"));
				bioMightOrientation.setYAxis(rs.getDouble("orientY"));
				bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
				bioMightOrientation.setDegrees(rs.getDouble("orientW"));
				bioMightTransform.setOrientation(bioMightOrientation);
			
				
				bioMightTransform.setRadius(rs.getDouble("radius"));
				bioMightTransform.setDepth(rs.getDouble("depth"));
				bioMightTransform.setDepthDirection(rs.getInt("depth_direction"));

				bioMightTransform.setHeight(rs.getDouble("height"));
				
				bioMightTransform.setBoundBox(rs.getString("boundbox"));
			       
				bioMightTransform.setCoordpoint(rs.getString("vertices"), rs.getDouble("depth"), rs.getInt("depth_direction"));
				//bioMightTransform.setCreaseAngle(0.524);   
				bioMightTransform.setCreaseAngle(1.57);
				
				// Set up the Material
				BioMightMaterial material = new BioMightMaterial();
				
				// Set up the Diffuse Color
				BioMightColor diffuseColor = new BioMightColor(rs.getDouble("diffuseColorRed"), rs.getDouble("diffuseColorGreen"), rs.getDouble("diffuseColorBlue"));
				material.setDiffuseColor(diffuseColor);  
				
				material.setShininess(rs.getDouble("shininess"));
				material.setTransparency(rs.getDouble("transparency"));
				
				// Store the Material into the Transform Object
				bioMightTransform.setMaterial(material);
				
				bioMightTransform.setMaterialID(rs.getInt("material"));
				
				bioMightTransform.setTextureID(rs.getInt("texture"));	
				bioMightTransform.setTextureName(rs.getString("texture_name"));
				bioMightTransform.setTextureFile(rs.getString("texture_file"));
				
			
				BioMightText bioMightText = new BioMightText();
				bioMightTransform.setTextID(rs.getInt("font"));
				bioMightText.setFamily(rs.getString("family"));
				bioMightText.setStyle(rs.getString("style"));
				bioMightText.setJustify(rs.getString("justify"));
				bioMightText.setSize(rs.getDouble("size"));
				bioMightText.setSpacing(rs.getDouble("spacing"));
				bioMightText.setMaxEnt(rs.getDouble("maxEnt"));
				bioMightTransform.setBioMightText(bioMightText);
				
				
				// Get the associated vetices and store them in the transform
				//ArrayList vetices = getVerticies(rs.getString("comp_id"));
				
				// Add the transform to the collection of transforms
				bioMightTransforms.add(bioMightTransform);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getComponents():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponents():" + e.toString());	
			}
		}
				
	
		return bioMightTransforms;
	}
	    	
	
  	/***************************************************************************************
	 * GET COMPONENTS HISTORY
	 * 
	 * This keeps the current version of a component, self rendered, for quick access
	 *  
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTransforms getComponentsHist(String componentType, String parentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Components");
		
		// Create an array of Tranform objects 
		// returned by this method
		BioMightTransforms bioMightTransforms = new BioMightTransforms();
		
		String query =
			"SELECT "
				+ "com.comp_id, comp_name, boundbox, vertices, posX, posY, posZ, scaleX, scaleY, scaleZ, radius, " 
				+ " height, orientX, orientY, orientZ, orientW, " 
				+ " diffuseColorRed, diffuseColorGreen, diffuseColorBlue, depth, direction, x3d "
				+ " FROM biomight.biocomp_hst";

				
		//System.out.println("getComponentsHist = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			while (rs.next()) {
				// Create a transformation object
				BioMightTransform bioMightTransform = new BioMightTransform();
				//System.out.println("Found Component: " + rs.getString("comp_name"));	
				
				// Set the ID
				bioMightTransform.setComponentID(rs.getString("comp_id"));
				
				// Set the name
				bioMightTransform.setComponentName(rs.getString("comp_name"));
							
				//Set the Component Description into the BioText field- currently 512 varchar
				//bioMightTransform.setBioText(rs.getString("comp_desc"));
	
				// Set up the Position
				BioMightPosition bioMightPosition = new BioMightPosition();
				bioMightPosition.setXPos(rs.getDouble("posX"));
				bioMightPosition.setYPos(rs.getDouble("posY"));
				bioMightPosition.setZPos(rs.getDouble("posZ"));
				bioMightTransform.setTranslation(bioMightPosition);

				// Set up the Translation
				BioMightScale bioMightScale = new BioMightScale();
				bioMightScale.setXScale(rs.getDouble("scaleX"));
				bioMightScale.setYScale(rs.getDouble("scaleY"));
				bioMightScale.setZScale(rs.getDouble("scaleZ"));
				bioMightTransform.setScale(bioMightScale);
				
				// Set up the Orientation
				BioMightOrientation bioMightOrientation = new BioMightOrientation();
				bioMightOrientation.setXAxis(rs.getDouble("orientX"));
				bioMightOrientation.setYAxis(rs.getDouble("orientY"));
				bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
				bioMightOrientation.setDegrees(rs.getDouble("orientW"));
				bioMightTransform.setOrientation(bioMightOrientation);
		
					
				bioMightTransform.setRadius(rs.getDouble("radius"));
				bioMightTransform.setDepth(rs.getDouble("depth"));
				bioMightTransform.setDepthDirection(rs.getInt("depth_direction"));

				bioMightTransform.setHeight(rs.getDouble("height"));
				 
				bioMightTransform.setBoundBox(rs.getString("boundbox"));
			       
				bioMightTransform.setCoordpoint(rs.getString("vertices"), rs.getDouble("depth"), rs.getInt("depth_direction"));
				//bioMightTransform.setCreaseAngle(0.524);   
				bioMightTransform.setCreaseAngle(1.57);
					
				// Get the associated vetices and store them in the transform
				//ArrayList vetices = getVerticies(rs.getString("comp_id"));
		
				bioMightTransform.setX3D(rs.getString("x3d"));
	    		
				// Add the transform to the collection of transforms
				bioMightTransforms.add(bioMightTransform);
			}
			
		} catch (Exception e) {
			System.out.println("Exception during getComponentsHist():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponents():" + e.toString());	
			}
		}
				
		

		return bioMightTransforms;
	}

	
	/***************************************************************************************
	 * GET COMPONENT
	 * 
	 * This method returns the BioMight component given the component ID.  It does not
	 * join with the 'group data' as we  only need the one row in the biocomp data that
	 * contains the data
	 *   
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
  	public BioMightTransforms getComponent(String componentID) 
	throws DataException, DataSecurityException
{	
	//System.out.println("Get Component: " + componentID);
	
	// Create an array of Tranform objects 
	// returned by this method
	BioMightTransforms bioMightTransforms = new BioMightTransforms();

	String query = "SELECT "
			+ "com.comp_id, comp_name, boundbox, vertices, posX, posY, posZ, scaleX, scaleY, scaleZ, radius, " 
			+ " height, orientX, orientY, orientZ, orientW, com.material, com.texture, com.font, " 
			+ " mat.transparency, mat.shininess, txt.texture_name, txt.texture_file, biotxt.family, biotxt.size, biotxt.style, biotxt.justify, biotxt.spacing, biotxt.maxEnt, "
			+ " diffuseColorRed, diffuseColorGreen, diffuseColorBlue, depth, depth_direction, comp_desc, height "
			+ " FROM biomight.biocomp com, biomight.materials mat, biomight.textures txt, biomight.biotext biotxt "
			+ " where com.comp_id = '" + componentID + "'"  
			+ " and com.material = mat.id " 
			+ " and com.texture = txt.texture_id "
			+ " and com.font = biotxt.id ";	
	
	//System.out.println("getComponent = " + query);

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
		throw new DataException("Exception during prep of getComponent() query:" + e.toString());
	}
	
	
	try {
		while (rs.next()) {
			// Create a transformation object
			BioMightTransform bioMightTransform = new BioMightTransform();
			//System.out.println("Found Component: " + rs.getString("comp_name"));	
			
			// Set the ID
			bioMightTransform.setComponentID(rs.getString("comp_id"));
			
			// Set the name
			bioMightTransform.setComponentName(rs.getString("comp_name"));
			
			//Set the Component Description into the BioText field- currently 512 varchar
			bioMightTransform.setBioText(rs.getString("comp_desc"));
			
			// Set up the Position
			BioMightPosition bioMightPosition = new BioMightPosition();
			bioMightPosition.setXPos(rs.getDouble("posX"));
			bioMightPosition.setYPos(rs.getDouble("posY"));
			bioMightPosition.setZPos(rs.getDouble("posZ"));
			bioMightTransform.setTranslation(bioMightPosition);

			// Set up the Scale
			BioMightScale bioMightScale = new BioMightScale();
			bioMightScale.setXScale(rs.getDouble("scaleX"));
			bioMightScale.setYScale(rs.getDouble("scaleY"));
			bioMightScale.setZScale(rs.getDouble("scaleZ"));
			bioMightTransform.setScale(bioMightScale);
		
			// Set up the Orientation
			BioMightOrientation bioMightOrientation = new BioMightOrientation();
			bioMightOrientation.setXAxis(rs.getDouble("orientX"));
			bioMightOrientation.setYAxis(rs.getDouble("orientY"));
			bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
			bioMightOrientation.setDegrees(rs.getDouble("orientW"));
			bioMightTransform.setOrientation(bioMightOrientation);
	
			bioMightTransform.setRadius(rs.getDouble("radius"));
			bioMightTransform.setDepth(rs.getDouble("depth"));
			bioMightTransform.setDepthDirection(rs.getInt("depth_direction"));

			bioMightTransform.setHeight(rs.getDouble("height"));
			
			bioMightTransform.setBoundBox(rs.getString("boundbox"));
		       
			bioMightTransform.setCoordpoint(rs.getString("vertices"), rs.getDouble("depth"), rs.getInt("depth_direction"));
			//bioMightTransform.setCreaseAngle(0.524);   
			bioMightTransform.setCreaseAngle(1.57);
			
			// Set up the Material
			BioMightMaterial material = new BioMightMaterial();
			
			// Set up the Diffuse Color
			BioMightColor diffuseColor = new BioMightColor(rs.getDouble("diffuseColorRed"), rs.getDouble("diffuseColorGreen"), rs.getDouble("diffuseColorBlue"));
			material.setDiffuseColor(diffuseColor);  
			
			material.setShininess(rs.getDouble("shininess"));
			material.setTransparency(rs.getDouble("transparency"));
			
			// Store the Material into the Transform Object
			bioMightTransform.setMaterial(material);
			bioMightTransform.setMaterialID(rs.getInt("material"));
			
			// Set up the Texture info
			bioMightTransform.setTextureID(rs.getInt("texture"));	
			bioMightTransform.setTextureName(rs.getString("texture_name"));
			bioMightTransform.setTextureFile(rs.getString("texture_file"));
			

			BioMightText bioMightText = new BioMightText();
			bioMightTransform.setTextID(rs.getInt("font"));
			bioMightText.setFamily(rs.getString("family"));
			bioMightText.setStyle(rs.getString("style"));
			bioMightText.setJustify(rs.getString("justify"));
			bioMightText.setSize(rs.getDouble("size"));
			bioMightText.setSpacing(rs.getDouble("spacing"));
			bioMightText.setMaxEnt(rs.getDouble("maxEnt"));
			bioMightTransform.setBioMightText(bioMightText);
	
		
			// Get the associated vetices and store them in the transform
			//ArrayList vetices = getVerticies(rs.getString("comp_id"));
			
			// Add the transform to the collection of transforms
			bioMightTransforms.add(bioMightTransform);
		}
		
	} catch (Exception e) {
		System.out.println("Exception during getComponent():" + e.toString());
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Caught in Finally - getComponents():" + e.toString());	
		}
	}
		    		

	return bioMightTransforms;
}	
	
  

  	/***************************************************************************************
	 * GET  BIOCODE
	 * 
	 * This method returns the BioMight instruction set that builds a component
	 *   
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
  	public BioMightInstructSet getBioCode(String compType, String parentID) 
	throws DataException, DataSecurityException
	{	
  		BioMightInstructSet bioMightInstructSet = DBUtils.getBioCode(compType, parentID);
  		return bioMightInstructSet;
	}		
  	
  	
  	/***************************************************************************************
	 * INSERT BIOCODE
	 * 
	 * This method returns the BioMight instruction set that builds a component
	 *   
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
  	public int insertBioCode(String compType, String parentID, String startID, BioMightInstructSet bioMightInstructSet) 
	throws DataException, DataSecurityException
	{	
  		int returnCode = 0;
  		
  		returnCode = DBUtils.insertBioCode(compType, parentID, startID, bioMightInstructSet);
  		return returnCode;
	}		
  	
	
  	/***************************************************************************************
	 * GET COMPONENT PROPERTIES
	 * 
	 * This method returns the BioMight component properties given the component ID.
	 *   
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
  	public ArrayList getComponentProps(String componentID) 
	throws DataException, DataSecurityException
{	
	//System.out.println("Get ComponentProps: " + componentID);
	
	// Create an array of Tranform objects 
	// returned by this method
	ArrayList bioMightProperties = new ArrayList<BioMightPropertyView>();

	String query = "SELECT "
			+ "prop_id, prop_type, prop_name, prop_name_desc, prop_enabled " 
			+ " FROM biomight.bioprops "
			+ " where comp_id = '" + componentID + "'"; 
 
	//System.out.println("getComponentProps = " + query);

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
		throw new DataException("Exception during prep of getComponentProps() query:" + e.toString());
	}
	
	
	try {
		while (rs.next()) {
			// Create a transformation object
			BioMightPropertyView bioMightPropertyView = new BioMightPropertyView();
			//System.out.println("Found Component: " + rs.getString("prop_name"));	
			
			bioMightPropertyView.setPropertyID(rs.getString("prop_id"));
			bioMightPropertyView.setPropertyType(rs.getString("prop_type"));
			bioMightPropertyView.setPropertyName(rs.getString("prop_name"));
			bioMightPropertyView.setPropertyDesc(rs.getString("prop_name_desc"));
			String enable = rs.getString("prop_enabled");
			
			if (enable.equals("1"))
				bioMightPropertyView.setViewEnabled(true);
			else
				bioMightPropertyView.setViewEnabled(false);
	
			
			// Add the transform to the collection of transforms
			bioMightProperties.add(bioMightPropertyView);
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
		    		

	return bioMightProperties;
}	
	
  	
  	/***************************************************************************************
	 * INSERT COMPONENT PROPERTIES
	 * 
	 * This will save the component's properties to the database
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
  	public int insertComponentProps(String componentID, String componentType, String componentName, 
  			                 ArrayList<biomight.view.BioMightPropertyView> bioMightProperties) 
	throws DataException, DataSecurityException   		
	{	
		int returnCode = 0;  
		int bodyID = 1;
		int projectID = 1;
			
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmtGrp = null;
	
		// Get the Current Component ID, as we are updating from there
		int propertyNum = 0;
		String componentBase = "";
		
		// Store the Properties in the database.  We should probably just use the name,
		// but I'm including an ID due to the fact that we are doing a HAWKEYE lookup from BioAction
		//System.out.println("InsertComponentProps - NumProps: " + bioMightProperties.size());
		for (int numProp=0; numProp<bioMightProperties.size(); numProp++) 
		{
			// Get the instruction from the set of instrunctions 
			biomight.view.BioMightPropertyView bioMightPropertyView = (biomight.view.BioMightPropertyView) bioMightProperties.get(numProp);
			
			int dbEnabled = 0;
			boolean enabled = bioMightPropertyView.isViewEnabled();
			if (enabled)
				dbEnabled = 1;
			
			//System.out.println("Checking Component Property " + componentID + "," + componentType + " " + bioMightPropertyView.getPropertyName() + " enabled: " + enabled);
			//String props =  
			//	  bioMightPropertyView.getPropertyID() + "', '" 
			//	+ bioMightPropertyView.getPropertyType() + "', '" 
			//	+ bioMightPropertyView.getPropertyName() + "', '"
			//	+ bioMightPropertyView.getCanonicalName() + "',  '"
			//	+ bioMightPropertyView.getPropertyRef() + "',  '"
			//	+ bioMightPropertyView.getPropertyDesc() + ", "
			//	+ enabled; 
			
			if (!enabled)
			{
				// We do not have
				//System.out.println("Unable enabled flag: " + bioMightPropertyView.getPropertyID() + "  " + bioMightPropertyView.getPropertyName() + " enabled: " + dbEnabled);
				
	    		query =
	       			"UPDATE biomight.bioprops set prop_enabled = '" + dbEnabled +
	          			"' where prop_id = '" + bioMightPropertyView.getPropertyID() + "'" +
	    		    " and comp_id = '" + componentID + "'";
	       		//System.out.println("storeProperties - Update = " + query);
		        		
	       		// Declare Statement and Result set
	       		boolean bMissing = false;
	       		stmt1 = null;
	       		try {
	       			stmt1 = con.prepareStatement(query);
	       			//System.out.println("Props Query is prepared");
	       			returnCode = stmt1.executeUpdate();
	       			//System.out.println("Update Props Flag Query has executed: " + returnCode);
	       		} catch (Exception e) {
	       			System.out.println("There was an exception in updatePropertiesInfo Update");
	       			//throw new DataException("Exception during prep of query:" + e.toString());
	       			bMissing = true;
	       		}
			}
			else
			{	
	    		query =
	       			"UPDATE biomight.bioprops set prop_enabled = '" + dbEnabled +
	       			"' where prop_id = '" + bioMightPropertyView.getPropertyID() + "'" +
	    		    " and comp_id = '" + componentID + "'";
	       		//System.out.println("storeProperties - Update = " + query);
		        		
	    		
	       		// Declare Statement and Result set
	       		boolean bMissing = false;
	       		stmt1 = null;
	       		try {
	       			stmt1 = con.prepareStatement(query);
	       			//System.out.println("Props Query is prepared");
	       			returnCode = stmt1.executeUpdate();
	       			//System.out.println("Update Props Query has executed: " + returnCode);
	       		} catch (Exception e) {
	       			System.out.println("There was an exception in updatePropertiesInfo Update");
	       			//throw new DataException("Exception during prep of query:" + e.toString());
	       			bMissing = true;
	       		}
	   
	       		boolean bDuplicate = false;
	       		String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
		   		if (bMissing || returnCode == 0)
		   		{	       			       	 			
		   			query =
					"INSERT into biomight.bioprops " +
					"(body_id, project_id, comp_id, comp_type, comp_name, "
					+ "prop_id, prop_type, prop_name, prop_name_desc, prop_enabled) " 
					+ "values (" 
					+ bodyID + "," + projectID + ",'" + componentID + "','" 
					+ componentType + "','" + componentName + "','" 
					+ bioMightPropertyView.getPropertyID() + "','" 
					+ bioMightPropertyView.getPropertyType() + "','" 
					+ bioMightPropertyView.getPropertyName() + "','"
					+ bioMightPropertyView.getPropertyDesc() + "','" 
					+ dbEnabled + "')";
					 
	
	 			
	       			try {
	       				//System.out.println("Preparing InsertProperties: " + query);
	       				stmt2 = con.prepareStatement(query);
	       				//System.out.println("PropsQuery is prepared!");
	       				returnCode = stmt2.executeUpdate();
	       				//System.out.println("InsertPropsQry Completed: " + query);
	       			} catch (Exception e) {
	       				System.out.println("There was an exception in generateComponentRows Insert");
	       				//throw new DataException("Exception during prep of query:" + e.toString());
	       				bDuplicate = true;
	        		}	
	      		}
	       		else
	       		{
	       		//System.out.println("Property not Inserted --- bDuplicate: " + bDuplicate);
	       		}
			}
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
			System.out.println("Caught in Finally - insertComponentProps():" + e.toString());	
		}	
		
		return 0;
	}
	
  	
	/***************************************************************************************
	 * BUILD COMPONENT
	 * 
	 * This method will be called from the client to build a component.  It will be a 
	 * series of calls to create rows in the component database.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int buildComponents(BioMightPosition bioPosition, String componentRef, String componentType, String componentName, int startRef, int numElements, String parentID) 
		throws DataException, DataSecurityException
	{	
		int returnCode = 0;
		
		//System.out.println("In Build Component");
		String humanID = "Human:1";
		int projectID = 1;
		String vetices = "";

	
		// Create new Component in Database
		double x = bioPosition.getXPos();
		double y = bioPosition.getYPos();
		double z = bioPosition.getZPos();
		double depth = 1.25;

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		String componentID = "";
		for (int i=startRef; i<startRef+numElements; i++)
		{
			// Concat the instance to create a unique instance
			//int displace = i+1;
			
			if (i < 10)
				componentID = ":0000" + i ;
			else if (i < 100)
				componentID = ":000" + i;
			else if (i < 1000)
				componentID = ":00" + i;
			else if (i < 10000)
				componentID = ":0" + i;
			
			vetices = x + "," + y + "," + z + "," +
						(x+1.00) + "," + y + "," + z + "," +
						(x+1.00) + "," + y + "," + z + "," +
						x + "," + y + "," + z ;
			
 			// Insert the Component		
			String query =
				"INSERT into biomight.biocomp values( " +
				humanID + "," + projectID + ",'" + componentID + "','" + componentType + 
				"','" + componentRef + "','" + componentName + "','" + parentID + "','" + vetices + "'," +
				"7,0,0,0,1,1,1,1,.25)";
			//System.out.println("buildMolecules Insert = " + query);
	
			//Insert the Grouping
			String query2 =
				"INSERT into biomight.biogroup values('" + componentID + "','" + parentID + "')";
			//System.out.println("buildMolecules Insert = " + query);
	
			
			x = x + .25;
	
			
			// Decalre Statement and Result set 
			stmt = null;
			try {
				stmt = con.prepareStatement(query);
				//System.out.println("Query is prepared");
				returnCode = stmt.executeUpdate();
				//System.out.println("Query has executed");
			} catch (Exception e) {
				System.out.println("There was an exception in generateHair Update");
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
				System.out.println("There was an exception in generateHair Update");
				throw new DataException("Exception during prep of query:" + e.toString());
			}
			
		z = z - 0.75;
		x = -3.25;
		}
		
		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
				System.out.println("Caught in Finally - generateHair():" + e.toString());	
		}
		
		
		return returnCode;	
	}
    	
	
	/***************************************************************************************
	 * GET VERTICIES
	 * 
	 * This method returns the vetices that are assocated with a component
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public ArrayList getVerticies(String componentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Verticies");
		
		// Create a ArrayList object that will be 
		// returned by this method
		ArrayList vetices = new ArrayList();
		
		String query =
			"SELECT vetices FROM biomight.vetices "
				+ " where comp_id = '" + componentID + "'";

		
		//System.out.println("getVerticiesAttribute Query = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			if (rs.next()) {
				//System.out.println("Have Verticies Record...");		
				
				vetices.add(rs.getString("vetices"));
				//System.out.println("Loaded Data into ArrList");	
			}
			else
				System.out.println("No Verticies for ID : "+ componentID);
			
		} catch (Exception e) {
			System.out.println("Exception during getVerticies():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponent():" + e.toString());	
			}
		}

		return vetices;
	}


	
	
	/***************************************************************************************
	 * GET COMPONENT TRANSFORM
	 * 
	 * This method returns the Transform informatino that is associated with a biomight component
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTransform getComponentByName(String componentName) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Component - Transform");
		
		// Create a BioMightSphere object that will be 
		// returned by this method
		BioMightTransform bioMightTransform = new BioMightTransform();
		
		String query =
			"SELECT "
				+ "posX, posY, posZ, scaleX, scaleY, scaleZ, radius, "
				+ " height, orientX, orientY, orientZ, orientW " 
				+ " FROM biomight.biocomp "
				+ " where comp_name = " + componentName;

		
		//System.out.println("getComponentAttribute Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			//System.out.println("Executing Next!");
			if (rs.next()) {
				//System.out.println("Have Component Record...");	
				//bioMightMaterial.setShininess(rs.getDouble("shininess"));
				//bioMightMaterial.setTransparency(rs.getDouble("transparency"));

				// Set up the Position
				BioMightPosition bioMightPosition = new BioMightPosition();
				bioMightPosition.setXPos(rs.getDouble("posX"));
				bioMightPosition.setYPos(rs.getDouble("posY"));
				bioMightPosition.setZPos(rs.getDouble("posZ"));
				bioMightTransform.setTranslation(bioMightPosition);

				// Set up the Scale
				BioMightScale bioMightScale = new BioMightScale();
				bioMightScale.setXScale(rs.getDouble("scaleX"));
				bioMightScale.setYScale(rs.getDouble("scaleY"));
				bioMightScale.setZScale(rs.getDouble("scaleZ"));
				bioMightTransform.setScale(bioMightScale);
	
				// Set up the Orientation
				BioMightOrientation bioMightOrientation = new BioMightOrientation();
				bioMightOrientation.setXAxis(rs.getDouble("orientX"));
				bioMightOrientation.setYAxis(rs.getDouble("orientY"));
				bioMightOrientation.setZAxis(rs.getDouble("orientZ"));
				bioMightOrientation.setDegrees(rs.getDouble("orientW"));
				bioMightTransform.setOrientation(bioMightOrientation);
		
				bioMightTransform.setRadius(rs.getDouble("radius"));
				
				bioMightTransform.setHeight(rs.getDouble("height"));
				
				//System.out.println("Loaded Data into Sphere");	
			}
			else
				System.out.println("No records for ID : "+ componentName);
			
		} catch (Exception e) {
			System.out.println("Exception during getComponent():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponent():" + e.toString());	
			}
		}

		return bioMightTransform;
	}
	
	
	/***************************************************************************************
	 * GET COMPONENT MATERIAL 
	 * 
	 * This method returns the material that is associated with a biomight component
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightMaterial getComponentMaterial(int componentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Component Material");
		
		// Create a BioMightMaterial object that will be 
		// returned by this method
		BioMightMaterial bioMightMaterial = new BioMightMaterial();
		
		String query =
			"SELECT "
				+ "diffuseColorRed, diffuseColorBlue, diffuseColorGreen "
				+ " FROM biomight.materials mat, biomight.component com "
				+ " where com.id = " + componentID
				+ " and mat.id = com.material ";

		
		//System.out.println("getComponentMaterial Query = " + query);

		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			rs = stmt.executeQuery();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception executing Query");
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			//System.out.println("Executing Next!");
			if (rs.next()) {
				//System.out.println("Have Component Material Record...");	
				//bioMightMaterial.setShininess(rs.getDouble("shininess"));
				//bioMightMaterial.setTransparency(rs.getDouble("transparency"));
				double red = rs.getDouble("diffuseColorRed");
				double blue = rs.getDouble("diffuseColorBlue");
				double green = rs.getDouble("diffuseColorGreen");	

				BioMightColor bioMightColor = new BioMightColor(red, green, blue); 
				bioMightMaterial.setDiffuseColor(bioMightColor);
				bioMightMaterial.setSpecularColor(bioMightColor);
				bioMightMaterial.setEmissiveColor(bioMightColor);
				//System.out.println("Set information into BioMightColor Red: " + bioMightColor.getRed());
				//System.out.println("Set information into BioMightColor Blue: " + bioMightColor.getBlue());
				//System.out.println("Set information into BioMightColor Green: " + bioMightColor.getGreen());
			}
			else
				System.out.println("No records for ID : "+ componentID);
			
		} catch (Exception e) {
			System.out.println("Exception during getComponentMaterial():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponentMaterial():" + e.toString());	
			}
		}

		return bioMightMaterial;
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
	
	public int setComponentMaterial(String componentID, int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In BEAN.setComponentMaterial()");
		
		String query =
			"UPDATE biomight.biocomp set material= " + materialID + 
			" where comp_id = '" + componentID + "'";
		//System.out.println("setComponentMaterial Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in setMaterial Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setMaterial():" + e.toString());	
			}

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * SET MATERIAL 
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
	
	public int setMaterial(String componentID, int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In Set Material in EJB");
		
		String query =
			"UPDATE biomight.biocomp set material = " + materialID + 
			" where comp_id = '" + componentID + "'";
		//System.out.println("setMaterial Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in setMaterial Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setMaterial():" + e.toString());	
			}

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * SET MATERIAL 
	 * 
	 * This method sets the material for a specific component based on component type
	 * and parent ID if it is specified
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setMaterial(String componentType, String parentID, int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In set Material EJB");
		
		String query =
			"UPDATE biomight.biocomp set material= " + materialID  
			+ " where comp_type = '" + componentType + "'";
			
			if (!parentID.equals(""))
				query+= " and parent_id = '" + parentID + "'";
		
		//System.out.println("setMaterial Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in setMaterial Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setMaterial():" + e.toString());	
			}

		return returnCode;
	}
		
  	
	/***************************************************************************************
	 * SET COLLECTION MATERIAL 
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
	
	public int setCollectionMaterial(String parentID, int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In setCollection Material EJB");
		
		String query =
			"UPDATE biomight.biocomp com, biomight.biogroup grp "
			+ "set com.material= " + materialID  
			+ " where grp.parent_id = '" + parentID + "'"
			+ " and grp.comp_id = com.comp_id";
			
		//System.out.println("setCollectionMaterial Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in setCollectionMaterial Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setCollectionMaterial():" + e.toString());	
			}

		return returnCode;
	}

	
	/***************************************************************************************
	 * GET COMPONENT TEXTURE 
	 * 
	 * This method returns the texture that is associated with a biomight component
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public BioMightTexture getComponentTexture(int componentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Get Component Texture");
		
		// Create a BioMightTexture object that will be 
		// returned by this method
		BioMightTexture bioMightTexture = new BioMightTexture();
		
		String query =
			"SELECT "
				+ " texture_id, texture_name, texture_file, texture_data "
				+ " FROM biomight.textures txt, biomight.component com "
				+ " where com.id = " + componentID
				+ " and txt.id = com.texture ";

		
		//System.out.println("getComponentTexture Query = " + query);

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
			throw new DataException("Exception during prep of query:" + e.toString());
		}
		
		
		try {
			//System.out.println("Executing Next!");
			if (rs.next()) {
				//System.out.println("Have Component Texture Record...");	
				bioMightTexture.setTextureId(rs.getInt("texture_id"));
				bioMightTexture.setTextureName(rs.getString("texture_name"));
				bioMightTexture.setTextureFile(rs.getString("texture_file"));
				//bioMightTexture.setTextureData(rs.getString("texture_data"));
				//System.out.println("Set information into BioMightTexture: " + bioMightColor.getRed());
			}
			else
				System.out.println("No records for ID : "+ componentID);
			
		} catch (Exception e) {
			System.out.println("Exception during getComponentTexture():" + e.toString());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - getComponentTexture():" + e.toString());	
			}
		}

		return bioMightTexture;
	}


	/***************************************************************************************
	 * SET TEXTURE 
	 * 
	 * This method sets the texture for a specific component
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setTexture(String componentID, int textureID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In Set Texture in EJB");
		
		String query =
			"UPDATE biomight.biocomp set texture = " + textureID + 
			" where comp_id = '" + componentID + "'";
		//System.out.println("setTexture Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in setTexture Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setTexture():" + e.toString());	
			}

		return returnCode;
	}
		
	/***************************************************************************************
	 * SET COMPONENT TEXTURE
	 * 
	 * This method sets the texture for a specific component
	 * 
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setComponentTexture(String componentID, int textureID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In BEAN.setComponentTexture()");
		
		String query =
			"UPDATE biomight.biocomp set texture= " + textureID + 
			" where comp_id = '" + componentID + "'";
		System.out.println("setComponentTexture Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			returnCode = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("There was an exception in setTexture Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setTexture():" + e.toString());	
			}

		return returnCode;
	}	
	
	/***************************************************************************************
	 * SET TEXTURE 
	 * 
	 * This method sets the texture for a specific component based on component type
	 * and parent ID if it is specified
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setTexture(String componentType, String parentID, int materialID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In set Texture EJB");
		
		String query =
			"UPDATE biomight.biocomp set texture = " + materialID  
			+ " where comp_type = '" + componentType + "'";
			
			if (!parentID.equals(""))
				query+= " and parent_id = '" + parentID + "'";
		
		System.out.println("setTexture Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			returnCode = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("There was an exception in setTexture Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setTexture():" + e.toString());	
			}

		return returnCode;
	}
	
	/***************************************************************************************
	 * SET COLLECTION TEXTURE 
	 * 
	 * This method sets the texture for a specific component
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int setCollectionTexture(String parentID, int textureID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In setCollection Texture EJB");
		
		String query =
			"UPDATE biomight.biocomp com, biomight.biogroup grp "
			+ "set com.texture = " + textureID  
			+ " where grp.parent_id = '" + parentID + "'"
			+ " and grp.comp_id = com.comp_id";
			
		System.out.println("setCollectionTexture Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			returnCode = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("There was an exception in setCollectionTexture Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - setCollectionTexture"
						+ "():" + e.toString());	
			}

		return returnCode;
	}
	
	



	/***************************************************************************************
	 * UPDATE COMPONENT 
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
	
	public int updateComponent(String componentType, String parentID, BioMightTransform bioMightTransform) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("UPDATE COMPONENT!");
		
		// Extract the position and scale information from the Transform
		BioMightPosition bioMightPosition = bioMightTransform.getTranslation();
		BioMightScale bioMightScale = bioMightTransform.getScale();
		
		if (bioMightScale == null)
			System.out.println("WARNING - SCALE is NULL");
		if (bioMightPosition == null)
			System.out.println("WARNING - POSITION is NULL");		
		
		
		
		String query =
			"UPDATE biomight.biocomp set " +
				"material=" + bioMightTransform.getMaterialID() + ", " + 
				"texture=" + bioMightTransform.getTextureID() + ", " + 	
				"posX=" + bioMightPosition.getXPos() + ", " +
				"posY=" + bioMightPosition.getYPos() + ", " +
				"posZ=" + bioMightPosition.getZPos() + ", " +
				"scaleX=" + bioMightScale.getXScale() + ", " +
				"scaleY=" + bioMightScale.getYScale() + ", " +
				"scaleZ=" + bioMightScale.getZScale() + ", " +
				"radius=" + bioMightTransform.getRadius() + ", " +
    			" height = " + bioMightTransform.getHeight()  + ", " +
    			" orientX = " + bioMightTransform.getOrientation().getXAxis()  + ", " +
      			" orientY = " + bioMightTransform.getOrientation().getYAxis()  + ", " +
      			" orientZ = " + bioMightTransform.getOrientation().getZAxis()  + ", " +
      			" orientW = " + bioMightTransform.getOrientation().getDegrees()  + ", " +
				"depth=" + bioMightTransform.getDepth() +
			    " where comp_type = '" + componentType + "' " +
			    " and parent_id = '" + parentID + "'";
			//"vertices=" +
		
		//System.out.println("updateComponent Query = " + query);
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		// Decalre Statement and Result set 
		PreparedStatement stmt = null;
		int returnCode = 0;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Query is prepared");
			returnCode = stmt.executeUpdate();
			//System.out.println("Query has executed");
		} catch (Exception e) {
			System.out.println("There was an exception in updateComponent");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		//System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("Caught in Finally - updateComponent():" + e.toString());	
			}

		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE NOSE
	 * 
	 * This method will generate a nose
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateNose(String parentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("Generate Nose");
		
		int humanID = 1;
		int projectID = 1;
		String vetices = "";

		int returnCode = 0;

		
		String componentType = "NoseEpithelium";
		String componentName = "NoseEpithelium";
		parentID = "Head:1";

		
		BioMightTransforms bioMightTransforms;
		// Get the data for the Nose that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			System.out.println("Getting Nose for ParentID: " + parentID);
			bioMightTransforms = getComponents(componentType, parentID);
			//System.out.println("Have Nose Info from EJB"); 
			System.out.println("Exception Getting Components - Nose"); 	
		}catch (DataSecurityException  e) {
			System.out.println("Exception Getting Component");
			throw new ServerException("Data Exception getComponents():", e); 	
		}
		
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
	
		// See what function we are applying to the nose
		// If we are making it wider, then we need to determine
		// where the wideness begins and ends.  We need to map
		// the z sections as well.
		
		
		// The data represents a matrix of rows and columns
		int numRows=5;
		int numColumns = 6;
		int numPlatforms = 3;
		
		
		int offset = 252;
		
		// Start x at the negative side.  A nose is about 1/2 in across
		// at the top and 1/2 inch across at the bottom
		double x=-0.5;
		
		// Start y at 0.0 as the base of the nose is ground zero
		double y = 0.0;

		// Start z at -1.0 as the nose can have a height of 1 inch 
		// at the base
		double z = -1.0;
		
		
		// Set up base component id key for nose epithelium
		String componentID = "1.1000.050:";
		
		// Go from the bottom to the top
		//for (int platform=0; platform<numPlatforms; platform++)
		//{	

		// Declare Statement and Result set
		PreparedStatement stmt = null;
		
		// Go from right to left, when we hit the apex
		// start the pattern in reverse
		for (int row=0; row<numRows; row++)
		{	
			// Run from top to Bottom, as this matches the
			// symmetry of the nose
			for (int column=0; column<numColumns; column++)
			{
				// Concat the instance to create a unique instance
				int index = (row * numColumns) + column + offset;	
				if (index < 10)
					componentID = "NoseEpithelium:000" + index ;
				else if (index < 100)
					componentID = "NoseEpithelium:00" + index;
				else if (index < 1000)
					componentID = "NoseEpithelium:0" + index;
			
					/*vetices = x + "," + y + "," + z + "," +
					(x+width) + "," + y + "," + z + "," +
					(x+width) + "," + (y+height) + "," + (z+slope) + "," +
					x + "," + (y+height) + "," + (z+slope) ;
					*/
				
				// Map the database Transforms into the matrix
				int elem = index-offset; 
				System.out.println("Mapping into Matrix: " + elem);
				BioMightTransform bioMightTransform = (BioMightTransform) bioMightTransforms.get(elem);
				System.out.println("Mapping into Matrix: " + column + " " + row + " " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
		
				// Manipulate the matrix, moving positions within the matrix
				// up, down, left, right, etc.
				
				String query =
					"UPDATE biomight.biocomp set( " +
					humanID + "," + projectID + ",'" + componentID + "','" + componentType + 
					"','" + componentName + "','" + componentName + "','" + parentID + "','" + vetices + "'," +
					"34,0,0,0,1,1,1,1,.25)";
				System.out.println("generateNose Update = " + query);	
			

				/*
				stmt = null;
				try {
					stmt = con.prepareStatement(query);
					System.out.println("Query is prepared");
					returnCode = stmt.executeUpdate();
					System.out.println("Query has executed");
				} catch (Exception e) {
					System.out.println("There was an exception in generateHair Update");
					throw new DataException("Exception during prep of query:" + e.toString());
				}
				
				// As we construct the nose downward, increase the slope
				// by an eight of an inch 			
				y-=0;8
				*/
			}
			

			
			// Go back to zero for Y on each iteration
			y=0.0;
			
			// Divide the Nose into .25 inch sections
			x += 0.25;
		}
		
		System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				//stmt.close();
				con.close();
		} catch (Exception e) {
				System.out.println("Caught in Finally - generateHair():" + e.toString());	
		}
		
		return returnCode;	
	}
	

	/***************************************************************************************
	 * GENERATE HAIR
	 * 
	 * This method will be called never
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateHair(String parentID) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("In Generate Hair");
		
		String humanID = "Human:1";
		int projectID = 1;
		String vetices = "";

		int returnCode = 0;
		

		String componentType = "ScalpHair";
		String componentID = "ScalpHair:00001";
		String componentName = "ScalpHair";
		
		if (componentType.equals("ScalpHair"))
			return 0;
		
		// Get the connection to the database
		Connection con = DBUtils.getConnection();
		
		
		// Delete the hair that is already there
		String query = "DELETE from biomight.biocomp where comp_type = '" + componentType + "' "; 
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(query);
			//System.out.println("Delete Query: " + query);
			returnCode = stmt.executeUpdate();
			//System.out.println("Delete Query done!");
		} catch (Exception e) {
			System.out.println("There was an exception in generateHair Update");
			throw new DataException("Exception during prep of query:" + e.toString());
		}

		
		// Create new hair
		double x = -3.00;
		double y = 4.00;
		double height = 1.25;
		double z = -0.75;

		int numElements = 26;
		int numRows=8;
		for (int row=0; row<numRows; row++)
		{
		for (int i=1; i< numElements; i++)
		{
			// Concat the instance to create a unique instance
			int displace = (row * numElements) +1;
			
			if (i < 10)
				componentID = "1.1000.080:0000" + (i+displace) ;
			else if (i < 100)
				componentID = "1.1000.080:000" + (i+displace);
			else if (i < 1000)
				componentID = "1.1000.080:00" + (i+displace);
			else if (i < 10000)
				componentID = "1.1000.080:0" + (i+displace);
			
			vetices = x + "," + (y+height) + "," + z + "," +
						(x-0.05) + "," + (y+height) + "," + z + "," +
						(x-0.05) + "," + y + "," + z + "," +
						x + "," + y + "," + z ;
			
					
			query =
				"INSERT into biomight.biocomp values( " +
				humanID + "," + projectID + ",'" + componentID + "','" + componentType + 
				"','" + componentName + "','" + componentName + "','" + parentID + "','" + vetices + "'," +
				"52,0,0,0,1,1,1,1,.25)";
			//System.out.println("generateHair Insert = " + query);
	
			x = x + .25;
	
			
			// Decalre Statement and Result set 
			stmt = null;
			try {
				stmt = con.prepareStatement(query);
				//System.out.println("Query is prepared");
				returnCode = stmt.executeUpdate();
				//System.out.println("Query has executed");
			} catch (Exception e) {
				//System.out.println("There was an exception in generateHair Update");
				throw new DataException("Exception during prep of query:" + e.toString());
			}
		}
		z = z - 0.75;
		x = -3.25;
		}
		
		System.out.println("Closing Connection: " + returnCode);
		try {
			if (stmt != null)
				stmt.close();
				con.close();
		} catch (Exception e) {
				System.out.println("Caught in Finally - generateHair():" + e.toString());	
		}
		
		
		return returnCode;	
	}

	
   	/***************************************************************************************
	 * GENERATE HIP
	 * 
	 * This generates the Hip
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHip(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateHip: " + componentID + "   " + parentID + "   " + componentName);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		if (parentID.equals("Hip:01") && componentName.equals("FrontTop")) {
			
			// We can generate the Arm alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the Thigh.
			if (currentPoints == null )
			{
				double radius = 2.0;
				double[] startPos = {4.0, -30.0, 0.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			}
						
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
		   		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 1.0);
	    		}
	    	
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:01") && componentName.equals("FrontBottom")) {
			
			
			int nMaxSegs = 1;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:01") && componentName.equals("LeftFront")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.12, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.12, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.12, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.12, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:01") && componentName.equals("LeftBack")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}

		else if (parentID.equals("Hip:01") && componentName.equals("Right")) {
			
			
			int nMaxSegs = 1;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:01") && componentName.equals("Back")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:02") && componentName.equals("FrontTop")) {
					
						
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(.99, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:02") && componentName.equals("FrontBottom")) {
			
			
			int nMaxSegs = 1;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.2, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:02") && componentName.equals("RightFront")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.12, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.12, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.12, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.12, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:02") && componentName.equals("RightBack")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Hip:02") && componentName.equals("Back")) {
			
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.0, -2.0, 0.0);	
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    		}
	    	    
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for Hip: " + componentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}

	
	/***************************************************************************************
	 * GENERATE Heart
	 * 
	 * This generates the Heart
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHeart(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateHeart: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
		
	
		double radius = 1.8;
		
		// We can generate the Heart alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double[] startPos = {2.0, -19.25, -1.75};
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
    		System.out.println("GenerateHeart - Set StartPlane! ");
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		
		int nMaxSegs = 11;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(205.0, 205.0, 205.0);
    			bioInstruct.setTranslateMatrix(0.0, -0.0001, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
    			bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
    			bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 	   
        	}
    		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 	        			
        	}
	      	else if (numSegs==6){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
        	}  	
      		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);    			
        	}
      		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);        			
        	}
      		else if (numSegs==9){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.60, 0.60, 0.60);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);          			
        	}
      		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
    			bioInstruct.setTranslateMatrix(0.0, 0.125, -0.1);       			
        	}	
    		

    		else {
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
    			bioInstruct.setTranslateMatrix(-0.0025, 0.0, 0.0); 
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
    			
    		
		
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for Heart: " + componentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		
	return returnCode;
}

	
   	/***************************************************************************************
	 * GENERATE LIVER
	 * 
	 * This generates the Liver
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLiver(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateLiver: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
		
	
		double radius = 1.8;
		
		// We can generate the Liver alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double[] startPos = {2.0, -19.25, -1.75};
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
    		System.out.println("GenerateLiver - Set StartPlane! ");
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		
		int nMaxSegs = 21;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(205.0, 205.0, 201.0);
    			bioInstruct.setTranslateMatrix(-0.001, 0.0, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 2.45, 1.5);
    			bioInstruct.setTranslateMatrix(-0.25, -0.15, 0.0); 
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
    			bioInstruct.setTranslateMatrix(-0.25, -0.2, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.15, 1.15);
    			bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.0); 
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.30, 1.30);
    			bioInstruct.setTranslateMatrix(-0.5, -0.25, -0.15); 	   
        	}
    		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.20, 1.35);
    			bioInstruct.setTranslateMatrix(-0.5, -0.15, -0.1);       			
        	}	
      		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setTranslateMatrix(-0.5, -0.10, -0.35);       			
    			bioInstruct.setScaleMatrix(1.0, 1.05, 1.05);
        	}  		
    		
    		
      		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 0.99, 1.0);
    			bioInstruct.setTranslateMatrix(-0.05, 0.15, -0.1);       			
        	}
      		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(-0.15, 0.0, -0.1);       			
        	}
      		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.05);
    			bioInstruct.setTranslateMatrix(-0.05, -0.2, -0.1);       			
        	}
    		
    		
      		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.075, 1.05);
    			bioInstruct.setTranslateMatrix(-0.25, 0.05, -0.1);       			
        	}	
      		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.01, 1.075);
    			bioInstruct.setTranslateMatrix(-0.5, 0.05, -0.15);       			
        	}	
      		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.03, 1.0);
    			bioInstruct.setTranslateMatrix(-0.5, -0.05, -0.25);       			
      		}	
      		else if (numSegs==13){
      			orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setScaleMatrix(1.0, 1.02, 1.0);
        	}	
      		else if (numSegs==14){
      			orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
     			bioInstruct.setScaleMatrix(1.0, 1.025, 1.0);
    		}	   		
      		else if (numSegs==15){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.05, 1.05);
    			bioInstruct.setTranslateMatrix(-0.5, -0.1, -0.30);  			
        	}	
      		else if (numSegs==16){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.07, 1.07);
    			bioInstruct.setTranslateMatrix(-0.5, -0.1, -0.30);  			
        	}
      		else if (numSegs==17){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.1, 1.08);
    			bioInstruct.setTranslateMatrix(-0.5, -0.2, -0.20);
        	}	
      		else if (numSegs==18){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.02, 1.02);
    			bioInstruct.setTranslateMatrix(-0.5, -0.15, -0.05);
        	}
    		else if (numSegs==19){
      			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.03, 1.0);
    			bioInstruct.setTranslateMatrix(-0.5, -0.15, -0.05);
        	}
    		else if (numSegs==20){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
    			bioInstruct.setTranslateMatrix(-0.0025, -0.001, -0.001);
    	
        	}
    		
    		
    		else {
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
    			bioInstruct.setTranslateMatrix(-0.0025, 0.0, 0.0); 
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
    			
    		
		
	// Generate the object based on the instruction set
	System.out.println("Generating the Rows for Liver: " + componentID + "   " + componentType);
	DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		
	return returnCode;
}

	
	
 	/***************************************************************************************
	 * GENERATE PANCREAS
	 * 
	 * This generates the Pancreas
	 *
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePancreas(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GeneratePancreas: " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		double radius = 1.8;
		
		// We can generate the Pancreas alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
			double x =  -0.3;
    		double y =  -17.0;
    		double z =  -3.0;
			
    		double[] startPos = {x, y, z};		
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building i0
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 16;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Pancreas
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(25.0, 25.0, 25.0);
    			bioInstruct.setTranslateMatrix(0.0, 0.0025, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
       			bioInstruct.setScaleMatrix(7.0, 7.0, 7.0);
    			bioInstruct.setTranslateMatrix(-0.05, 0.125, 0.0);  
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
    			bioInstruct.setTranslateMatrix(-0.15, 0.25, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
    			bioInstruct.setTranslateMatrix(-0.18, 0.5, 0.0); 
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(-0.20, 0.5, 0.0); 
    		}
    		else if (numSegs==5){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==6){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation); 
    		}
    		else if (numSegs==7){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-25);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation); 
    		}
    		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
    			bioInstruct.setTranslateMatrix(0.5, 0.1, 0.0); 
    		}
    		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.94, 0.94, 1.0);
    			bioInstruct.setTranslateMatrix(0.5, 0.075, 0.0); 
    		}
    		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.90, 1.0);
    			bioInstruct.setTranslateMatrix(0.5, 0.25, 0.0); 
    		}
    		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(0.5, 0.05, 0.0); 
    		}
    		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
    			bioInstruct.setTranslateMatrix(0.5, 0.16, 0.0); 
    		}
    		else if (numSegs==13){	
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.75, 0.75, 1.0);
    			bioInstruct.setTranslateMatrix(0.5, 0.18, 0.0); 
    		}
    		else if (numSegs==14){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.70, 0.70, 1.0);
    			bioInstruct.setTranslateMatrix(0.5, 0.14, 0.0); 
    		}
    		else if (numSegs==15){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.80, 0.80, 1.0);
    			bioInstruct.setTranslateMatrix(0.5, 0.08, 0.0); 
    		}	
    		

    		
    		
    		else {
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
    			bioInstruct.setTranslateMatrix(0.25, 0.10, 0.0); 
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for Pancreas: " + componentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}

	
	
	/***************************************************************************************
	 * GENERATE STOMACH
	 * 
	 * This generates the Stomach.  It is defined by the space of the Abdominal cavity
	 * 
	 * The size of the stomach is defined by the Abdominal cavity.  It slides against 
	 * the backside of the Liver,so the Liver must move when the stomach pushes it.
	 * 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateStomach(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateStomach: " + componentID + "   " + parentID);
		int returnCode = 0;
		double radius = 1.8;
		
  		
		// We can generate the Stomach alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null )
		{
	 		double[] startPos = {-0.3,-17.0, -3.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		

		//Each of these movements makes a pivot point in the decision
		// as to where the cells will align.  They become the frame of the object
		// We should create a bounding box around it so that we can calculate shite.
		
		// As it is built using a tubular design, we can readily move through the tube
		// using the instruction set. We will know where the current points are and the 
		// next ponts are.  Rather than do this against the whole object, we will traverse
		// across the object using the instruction set.
		
		// We can move forward and backward in the instruction set to move. If we displace
		// an object into the 
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 18;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
    		// Extend out from the terminus of the Knee
    		if (numSegs==0)
    		{
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.20, -0.5, 0.01);
    		}
      		else if (numSegs==1){
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.35, -0.35, -0.05);
           	}
    		else if (numSegs==2){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		} 		
        	else if (numSegs==3){
        		bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(3.25, 1.0, 2.25);
    			bioInstruct.setTranslateMatrix(0.75, -0.50, 0.0);   			     			
    		}
     		else if (numSegs==4){
     			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.25, 1.0, 1.05);
    			bioInstruct.setTranslateMatrix(0.50, -0.40, 0.0); 	  			     			   	   			     			
    		}
    		else if (numSegs==5){
     			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(0.1, -0.45, 0.0); 	  			     			   	   			     			
    		}
    		else if (numSegs==6){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-22);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);  	  			     			   	   			     			
    		}		
     	  	else if (numSegs==7){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.1, -0.45, 0.0);      			     			
    		}  
      	  	else if (numSegs==8){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(-0.08, -0.45, 0.0);      			     			
    		}
     	  	else if (numSegs==9){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.97, 0.97, 0.97);
    			bioInstruct.setTranslateMatrix(-0.2, -0.45, 0.0);      			     			
    		}
     		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.18, -0.25, 0.0);      			     			
    		}
    		else if (numSegs==11){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);  	 
     			
     			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0); 
    		}
     	  	else if (numSegs==12){
     	  		BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
     			
     			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0); 
    		}  
    		else if (numSegs==13){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);  	
     			
     			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
    		}	
    		else if (numSegs==14){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(-20);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);  	
     			
     			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0); 	  			     			   	   			     			
    		}	
    		else if (numSegs==15){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);  	
     			
     			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0); 	    			     			
    		} 	
    		else if (numSegs==16){
	 			bioInstruct.setTransType(Constants.SCALE);
	 			bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
	 			bioInstruct.setTranslateMatrix(-0.5, 0.3, -0.18); 			     			
    		}
    		else if (numSegs==17){
	 			bioInstruct.setTransType(Constants.SCALE);
	 			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
	 			bioInstruct.setTranslateMatrix(-0.5, 0.22, -0.15); 			     			
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
		
		System.out.println("----- Updating the Stomach BioCode ---- ");
		DBUtils.insertBioCode(componentType, componentID, startID, bioMightInstructSet); 
	
		// Generate the object based on the instruction set
		System.out.println("Generating the Rows for Stomach: " + componentID + "   " + componentType);
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}

  	/**************	*************************************************************************
	 * GENERATE TRACHEA
	 * 
	 * This generates the Trachea.   It can generate the whole trachea, or it can create
	 * it in parts based on the parent that is passed in as a primary parameter. 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public BioMightGenerate generateTrachea(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateTracheaCPEJB: " + componentID + "   " + parentID);  		    		
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
					
		// We can generate the Trachea alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		// We are creating the Trachea for the neck
		if (parentID.equals("Neck:01") || parentID.equals("Organs:0") ) 
		{	

			
			int nMaxSegs = 7;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.40);	
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.35);	
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.20);		
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.05);	      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.1);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.00, 0.05);	      		     			     				      			
				}		
		
			
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      		
				}
	    
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Chest:01")) 
		{


			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==3){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
        		
        		
				else if (numSegs==5){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
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
			
		}
		
	     
		// Generate the object based on the instruction set
		double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for Trachea: " + componentID + "   " + componentType);
    		   
		// Set up the BioMightGenerate that will be returned to the client
		// so that its information can be used to build other objects
  		BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
  		System.out.println("Setup Trachea BioMightGenerate Object: " + lastPoints[0][0]);
		   
		return (bioMightGenerate);
	}


	/**************	*************************************************************************
	 * GENERATE TRACHEA
	 * 
	 * This generates the Trachea.   It can generate the whole trachea, or it can create
	 * it in parts based on the parent that is passed in as a primary parameter. 
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public BioMightGenerate generateTrachea(String startID, String componentType, String componentName, String componentID,  String parentID, BioMightConstruct bioMightConstruct) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateTracheaEJB: " + componentID + "   " + parentID);  		    		
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		double[][] connectPoints = null;
					
		// We can generate the Trachea alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		// We are creating the Trachea for the neck
		if (parentID.equals("Neck:01") || parentID.equals("Organs:0") ) 
		{	
			// If null, then we need to set up a default Bound Box
			// We also have to setup the default Connector Map
			if (bioMightConstruct == null )
			{
				// Not doing anything at the moment
			}	
			else  // Good, we have what we want
			{
		 		// Get the last connection points from the Incoming Generate Map
				// That is in the Constructor.  
				
				System.out.println("TracheaIn: " + componentID + "   " + parentID);
				connectPoints = bioMightConstruct.getBioMightGenerate().getConnectPoints();
			}
			System.out.println("Trachea StartPoints from BioMightGen: " + 
					connectPoints[0][0] + ",  " + connectPoints[0][1] + ",  " +  connectPoints[0][2]);

			
			int nMaxSegs = 7;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      		     			     				      			
				}		
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);	      		
				}
	    
				
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
		}
		else if (parentID.equals("Chest:01")) 
		{

			// If null, then we need to set up a default Bound Box
			// We also have to setup the default Connector Map
			if (bioMightConstruct == null )
			{	
				System.out.println("Trachea-Neck - BioMightConstruct is null!");					
				// Have to set up utility object
			}	
			else
			{
		 		// Get the last connection points from the Incoming Generate Map
				// That is in the Constructor.  
				System.out.println("Trachea BioGenIn: " + componentID + "   " + parentID);
				
				// Get the Bounding Box
				BioMightBoundBox bioMightBoundBox = bioMightConstruct.getBoundingBox(Constants.ChestRef);
				
			
			}
	
			
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==3){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
        		
        		
				else if (numSegs==5){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
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
			
		}
		
	     
		// Generate the object based on the instruction set
		double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, connectPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for Trachea: " + componentID + "   " + componentType);
    		   
		// Set up the BioMightGenerate that will be returned to the client
		// so that its information can be used to build other objects
  		BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
  		System.out.println("Setup Trachea BioMightGenerate Object: " + lastPoints[0][0]);
		   
		return (bioMightGenerate);
	}

	
	/***************************************************************************************
	 * GENERATE BRONCHUS
	 * 
	 * This generates the Bronchus
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateBronchus(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
		{	
			System.out.println("Bronchus: " + componentID + "   " + parentID);
			
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
			ArrayList mySqlList= new ArrayList();
			int returnCode = 0;
		
			// We can generate the Bronchus alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the base oral cavity
			if (currentPoints == null )
			{
				double circumference = 0.25;
			 	double[] startPos = {-0.3,-17.0, -3.5};
	    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);	
			 }
			

			// Allocate an instruction set for building it
			BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

			// To generate a right and left Symmetrical tree,then we could
			// call the same code with x changing from pos to neg
			// Create  an almost symmetrical tree - introduce randomness
			
			// LEFT SIDE
			// Left Bronchus
			if (parentID.equals("Bronchus:01")) 
			{	
				int nMaxSegs = 2;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(1.0, -0.65, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.750, -1.0, 0.0);
					}
					else {
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, 0.25, 0.29);
					}
					
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
		    
			} 
 			// Left Bronchus
			else if (parentID.equals("Bronchus:02")) {	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, -1.0, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, 0.25, 0.29);
					}
					else {
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-1.0, 0.25, 0.29);
					}
		
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}				
			}
 			
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for BronchusEpithelium: " + componentID + "   parent: " + parentID + "   " + componentType);
			
		return returnCode;
	}
		
	
	
 	/***************************************************************************************
	 * GENERATE LOBAR BRONCHUS
	 * 
	 * This generates the Bronchus
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateLobarBronchus(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
		{	
			System.out.println("In generateLobarBronchus() " + componentID + "   " + parentID);
			
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
			ArrayList mySqlList= new ArrayList();
			int returnCode = 0;
		
			// We can generate the LobarBronchus alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the base oral cavity
			if (currentPoints == null )
			{
				double circumference = 0.25;
			 	double[] startPos = {-0.3,-17.0, -3.5};
	    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);	
			 }
			

			// Allocate an instruction set for building it
			BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
			
			// LEFT SIDE HAS TWO BRANCHER
			// Left Bronchus:01 goes outward and upward
			if (parentID.equals("LobarBronchus:01")) 
			{	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(1.0, 0.75, 0.0);
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
 			// Left LobarBronchus:02 
			// Drops downward towards to corner of the lung
			else if (parentID.equals("LobarBronchus:02")) {	
				int nMaxSegs = 7;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
					System.out.println("We are doing LobarBronch:02 Segments: " + nMaxSegs);
					
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.50, -1.0, -0.1);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.5, -0.75, -0.1);
		    		}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.5, -0.50, 0.0);
		    		}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.1, -0.5, 0.0);
		    		}    					
					else if (numSegs==4){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.70, 0.70);
						bioInstruct.setTranslateMatrix(0.1, -0.5, 0.35);
		    		}    					
					else if (numSegs==5){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.70, 0.70);
						bioInstruct.setTranslateMatrix(0.25, -0.5, 0.30);
		    		}
					else if (numSegs==6){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
						bioInstruct.setTranslateMatrix(0.25, -0.5, 0.20);
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
			// RIGHT SIDE
 			// RightLobarBronchus:03 
			// Goes outward and upward
			else if (parentID.equals("LobarBronchus:03")) {	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.75, 0.05, 0.0);
					}
					
					else if (numSegs==1){
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(0.75, 0.05, 0.20);
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
			
 			// Right LobarBronchus
			else if (parentID.equals("LobarBronchus:04")) {	
				int nMaxSegs = 1;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
				     
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.75, 0.20, 0.0);
					}
					
					else if (numSegs==1){
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(-0.50, -0.750, 0.0);
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
 			// Right LobarBronchus
		    else if (parentID.equals("LobarBronchus:05")) {	
		    	int nMaxSegs = 7;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(-0.50, -1.00, 0.0);
					}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.35, -0.75, -0.20);
		    		}
  		    		else if (numSegs==2){
  		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
		    			bioInstruct.setTranslateMatrix(-0.45, -1.0, -0.15);
		    		}  
  		    		else if (numSegs==3){
  		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
		    			bioInstruct.setTranslateMatrix(-0.30, -0.5, -0.10);
		    		}  
  		    		else if (numSegs==4){
  		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(15);	
		    			bioInstruct.setPivotPoint(0);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}    
  		    		else if (numSegs==5){
  		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.05, -0.5, -0.10);	
		    		}
  		    		else if (numSegs==5){
  		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(0.1, -0.5, -0.10);	
		    		}
  		    		else if (numSegs==6){
  		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
		    			bioInstruct.setTranslateMatrix(0.1, -0.5, -0.10);	
		    		} 
  		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(1.0, -0.5, 0.0);
		   		}
				
				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		   }    		
			
			
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for LobarBronchusEpithelium: " + componentID + "   parent: " + parentID + "   " + componentType);
			
		return returnCode;
	}
		
	
  	/***************************************************************************************
	 * GENERATE SEGMENTALINIC BRONCHUS
	 * 
	 * This generates the Bronchus
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateSegmentalinicBronchus(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
		{	
			System.out.println("SegmentalinicBronchus: " + componentID + "   " + parentID);
			
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
			ArrayList mySqlList= new ArrayList();
			int returnCode = 0;
		
			// We can generate the SegmentalinicBronchus alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the base oral cavity
			if (currentPoints == null )
			{
				double circumference = 0.25;
			 	double[] startPos = {-0.3,-17.0, -3.5};
	    		currentPoints = BioGraphics.octogonXPlane(startPos, circumference);	
			 }
			
			BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
			
			// Allocate an instruction set for building it
			BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

			// To generate a right and left Symmetrical tree,then we could
			// call the same code with x changing from pos to neg
			// Create  an almost symmetrical tree - introduce randomness
			
			// LEFT SIDE
			// Top Left SegmentalinicBronchus:01 - Goes Upward
			if (parentID.equals("SegmentalinicBronchus:01")) 
			{	
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
		     
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.2, 0.5, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(-45);	
		    			bioInstruct.setPivotPoint(2);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
					}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
						bioInstruct.setTranslateMatrix(0.5, 0.35, 0.0);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
						bioInstruct.setTranslateMatrix(0.25, 0.1, 0.0);
					}
				
			
					
					else {
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(1.0, 0.50, 0.0);
					}
					
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
		    
			} 
 			// Top Left Middle SegmentalinicBronchus - Goes outward
			else if (parentID.equals("SegmentalinicBronchus:02")) {	
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
					if (numSegs==0){
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(0.5, -0.35, 0.0);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
						bioInstruct.setTranslateMatrix(0.50, -0.35, 0.25);
		    		}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
						bioInstruct.setTranslateMatrix(0.50, -0.35, 0.25);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.60, 0.60, 0.60);
						bioInstruct.setTranslateMatrix(0.20, -0.35, 0.15);
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
 			// Top Left Left Bottom SegmentalinicBronchus - Goes downward
			else if (parentID.equals("SegmentalinicBronchus:03")) {	
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
					if (numSegs==0){
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(0.50, -0.25, -0.10);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
						bioInstruct.setTranslateMatrix(0.50, -0.40, 0.0);
		    		}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
						bioInstruct.setTranslateMatrix(0.50, -0.40, -0.10);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
						bioInstruct.setTranslateMatrix(0.750, -0.30, 0.10);
					}
				
					else {
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
						bioInstruct.setTranslateMatrix(0.50, -0.50, -0.10);
					}
					
					
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
				}
			} 
			
		
 			// Bottom Left SegmentalinicBronchus - Goes upward
			else if (parentID.equals("SegmentalinicBronchus:04")) {	
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
			      
				     
					if (numSegs==0){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.50, -0.25, 0.15);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.TRANSLATE);
						bioInstruct.setTranslateMatrix(0.50, -0.20, 0.0);
					}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
						
						bioInstruct.setTranslateMatrix(0.50, -0.5, 0.0);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.450, 0.459, 0.450);
						bioInstruct.setTranslateMatrix(0.550, -0.65, 0.0);
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
			
			// Bottom Left SegmentalinicBronchus - Goes Downward to corner
		    else if (parentID.equals("SegmentalinicBronchus:05")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.015, -0.50, 0.0);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.25, -0.50, -0.15);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.25, -0.25, -0.05);
		    		}		
	


		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    } 
		    else if (parentID.equals("SegmentalinicBronchus:06")) {	
		    	int nMaxSegs = 4;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		      
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.25);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.50, 0.25);
	    		}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.10, -0.50, 0.25);
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -0.50, 0.25);
				}		
				else {
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-0.20, -0.50, 0.1);
				}
			
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		    else if (parentID.equals("SegmentalinicBronchus:07")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.50, 0.5, -0.15);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
		    			bioInstruct.setTranslateMatrix(-0.5, 0.25, -0.10);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.25, 0.35, -0.15);
		    		}
		    		
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.250, -0.25, 0.15);
		    		}	    		
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}
				
				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    } 
		    else if (parentID.equals("SegmentalinicBronchus:08")) {	
		    	int nMaxSegs = 4;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.50, 0.0, -0.10);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.50, 0.10, 0.0);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.05, -0.15);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
		    			bioInstruct.setTranslateMatrix(-0.75, 0.1, -0.15);
		    		}	
		    		
		       		
		    		else 
		    		{
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		    		}
				
				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    } 
		    else if (parentID.equals("SegmentalinicBronchus:09")) {	
		    	int nMaxSegs = 5;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.50, -0.35, -0.15);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(-30);	
		    			bioInstruct.setPivotPoint(4);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.35, -0.05, -0.10);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.50, -0.25, 0.20);
		    		}
		    		else if (numSegs==4){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.40, 0.40, 0.40);
		    			bioInstruct.setTranslateMatrix(-0.50, -0.35, -0.10);
		    		}
		    		
		    		
		    		else {
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(-45);	
		    			bioInstruct.setPivotPoint(2);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    } 
		    else if (parentID.equals("SegmentalinicBronchus:10")) {	
		    	int nMaxSegs = 5;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.0);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.40, -0.35, 0.05);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
		    			bioInstruct.setTranslateMatrix(-0.40, -0.45, 0.07);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
		    			bioInstruct.setTranslateMatrix(-0.40, -0.55, 0.07);
		    		}
		    		else if (numSegs==4){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.40, -0.65, 0.07);
		    		}
		 
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.01, 0.0);
		    		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:11")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.35, -0.35, -0.0);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.150, -0.25, 0.0);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.110, -0.10, 0.0);
		    		}
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:12")) {	
		    	int nMaxSegs = 4;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
						bioInstruct.setTransType(2);
						bioInstruct.setTranslateMatrix(0.350, -0.30, -0.10);
					}
					else if (numSegs==1){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
						bioInstruct.setTranslateMatrix(0.40, -0.50, 0.0);
		    		}
					else if (numSegs==2){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
						bioInstruct.setTranslateMatrix(0.150, -0.450, -0.10);
					}
					else if (numSegs==3){
						bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
						bioInstruct.setTranslateMatrix(-0.05, -0.40, 0.10);
					}
		    	
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.02, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals(Constants.RightMiddleMedialBronchusRef)) {	
		    	int nMaxSegs = 7;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.2, 0.25, 0.02);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(45);	
		    			bioInstruct.setPivotPoint(4);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(45);	
		    			bioInstruct.setPivotPoint(4);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.5, 0.15, 0.05);
		    		}
		    		else if (numSegs==4){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.5, 0.10, 0.07);
		    		}
		    		else if (numSegs==5){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.25, 0.0, -0.03);
		    		}
		    		else if (numSegs==6){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.20, -0.15, -0.03);
		    		}
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(-0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals(Constants.RightInferiorSuperiorBronchusRef)) {	
		    	int nMaxSegs = 4;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.5, 0.01, -0.01);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.02, 0.0);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.60, 0.60, 0.60);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.01, 0.0);
		    		}
		    		
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:15")) {	
		    	int nMaxSegs = 8;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.45, 0.0);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(45);	
		    			bioInstruct.setPivotPoint(6);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(-30);	
		    			bioInstruct.setPivotPoint(4);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==3){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.25, -0.1);
		    		}
		    		else if (numSegs==4){
		    			bioInstruct.setTransType(Constants.ROTATEOCTO);
		    			bioInstruct.setTheta(-30);	
		    			bioInstruct.setPivotPoint(4);	
		     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     			bioInstruct.setOrientation(orientation);
		    		}
		    		else if (numSegs==5){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.15, -0.1);
		    		}
		    		else if (numSegs==6){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.18, 0.0);
		    		}
		    		else if (numSegs==7){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(-0.5, -0.25, 0.05);
		    		}
		    		
		    		else {
		    			bioInstruct.setTransType(Constants.TRANSLATE);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:16")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.5, 0.15);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
		    			bioInstruct.setTranslateMatrix(0.1, -0.5, 0.13);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(Constants.SCALE);
						bioInstruct.setScaleMatrix(0.60, 0.60, 0.60);
		    			bioInstruct.setTranslateMatrix(-0.05, -0.25, 0.15);
		    		}
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:17")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.25);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.50, -0.5, 0.20);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.15);
		    		}
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		    else if (parentID.equals("SegmentalinicBronchus:18")) {	
		    	int nMaxSegs = 3;
		    	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
		    		// Create a place for an instruction 
		    		BioMightInstruction bioInstruct = new BioMightInstruction();
		      
		    		if (numSegs==0){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.25);
		    		}
		    		else if (numSegs==1){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.50, -0.5, 0.20);
		    		}
		    		else if (numSegs==2){
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, 0.0, 0.15);
		    		}
		    		else {
		    			bioInstruct.setTransType(2);
		    			bioInstruct.setTranslateMatrix(0.25, -0.45, 0.0);
		   		}

				
		    		// Add the instruction into the instruction set
		    		bioMightInstructSet.addElement(bioInstruct);
		    	}
		    }
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		System.out.println("Generated the Rows for SegmentalinicBronchusEpithelium: " + componentID + "   parent: " + parentID + "   " + componentType);
			
		return returnCode;
	}
		
	
	
	/***************************************************************************************
	 * GENERATE ESOPHAGUS
	 * 
	 * This generates the Esophagus. It will receive a BioMightConstructor object
	 * The constuctor will come from the Neck, Chest, and Abdomen. Regardless from
	 * whence it came,    
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateEsophagus(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
			throws DataException, DataSecurityException
	{	
		System.out.println("GenerateEsophagus: " + componentID + "   " + parentID);
		int returnCode = 0;
		
		
  		
		// We can generate the Stomach alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		if (currentPoints == null)
		{
			double radius = 1.8;
	 		double[] startPos = {-0.3,-17.0, -3.0};
	 		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
				
		System.out.println("GenerateEsophagus: " + componentID + "   " + parentID);  		    		
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
		
		// We can generate the Esophagus alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		// We are creating the Esophagus for the neck
		
		
	 if (parentID.equals("Organs:0") || parentID.equals("DigestiveSystem:0")) 
		{	
	
			// NECK PORTION
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		      
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.45);	
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.40);	
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, -0.35);		
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, -0.10);	
				}
				
	
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	  
				}
	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}
			
			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, "EsophagusEpithelium:00001", componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		
			
			// CHEST PORTION
			// Allocate an instruction set for building the Chest Portion
			bioMightInstructSet = new BioMightInstructSet();
		
			
			nMaxSegs = 8;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.15);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.20);
					}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.18);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.20);      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.15);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}	
				else if (numSegs==7) {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);   			     				      			
				}
				
				
		
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
    	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);

			}
			
			
			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, "EsophagusEpithelium:00160", componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			
			
			// ABDOMEN PORTION
			// Allocate an instruction set for building it
			bioMightInstructSet = new BioMightInstructSet();
	
			nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.10, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -0.5, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
					}
				else 
				{
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);  
				}
    	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);

			}
	
			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, "EsophagusEpithelium:00320", componentType, componentName, componentID, currentPoints, bioMightInstructSet);
			
		}
	 	else if (parentID.equals("Neck:01")) 
		{	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);	
				}
				
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	  
				}
	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
			}

			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);

		}
		else if (parentID.equals("Chest:01")) 
		{
			
			int nMaxSegs = 7;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
					}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}		
				else if (numSegs==7) {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}	
				
				else if (numSegs==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}
				else if (numSegs==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}
				else if (numSegs==11){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);   			     				      			
				}
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
    	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);

			}

			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);

		}
		else if (parentID.equals("Abd0"
				+ "omen:01")) 
		{
			
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
					}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
				}
				else 
				{
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);  
				}
    	    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);

			}
			
			// Generate the object based on the instruction set
			System.out.println("Generating the Rows for Esophagus: " + componentID + "   " + componentType);
			DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);

		}			
	     
		// Generate the object based on the instruction set
		//double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, connectPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Esophagus: " + componentID + "   " + componentType);
    		   
		// Set up the BioMightGenerate that will be returned to the client
		// so that its information can be used to build other objects
  		//BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
  		//System.out.println("Setup Esophagus BioMightGenerate Object: " + lastPoints[0][0]);
		   
		//return (bioMightGenerate);
		
		
			
		return returnCode;

	}

	

	/***************************************************************************************
	 * GENERATE ESOPHAGUS
	 * 
	 * This generates the Esophagus. It will receive a BioMightConstructor object
	 * The constuctor will come from the Neck, Chest, and Abdomen. Regardless from
	 * whence it came,    
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public BioMightGenerate generateEsophagusNew(String startID, String componentType, String componentName, String componentID,  String parentID, BioMightConstruct bioMightConstruct) 
		throws DataException, DataSecurityException
	{	
		System.out.println("GenerateEsophagus: " + componentID + "   " + parentID);  		    		
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		double[][] connectPoints = null;
				
		if (bioMightConstruct == null )
		{
			// Move the Bounding Box Setup routine into the Utility Class ---
			
			// Set up default points for Generate object if they
			// are not specified
			double radius = 0.3;
			double[] startPos = {0.0,-5.0, -1.0};
			connectPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			//BioMightGenerate bioMightGenerateEpi = new BioMightGenerate(neckTracheaPoints, 0, "");				
   		}
		else
		{
			// Get the Bounding Box from the Constructor
			System.out.println("Using Constructor to Create Esophagus");
			BioMightBoundBox bioMightBoundBox = bioMightConstruct.getBoundingBox("Esophagus");
			BioMightConnectors bioMightConnectors = bioMightBoundBox.getBioMightConnectors();
			BioMightConnector bioMightConnector = bioMightConnectors.getBioMightConnector("Esophagus");	
			connectPoints = bioMightConnector.getConnectorPoints();
			//System.out.println("Have Box and Connectors to Create Esophagus");
			
			// Get the Bounding Box for the neck from the Constructor
			//System.out.println("In generateEsophagus XBound: " + bioMightBoundBox.getxPos());
			//System.out.println("In generateEsophagus YBound: " + bioMightBoundBox.getyPos());
			//System.out.println("In generateEsophagus zBound: " + bioMightBoundBox.getzPos());	
	
		}
	
		
		// We can generate the Esophagus alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base oral cavity
		// We are creating the Esophagus for the neck
		if (parentID.equals("Neck:01")) 
		{	
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				
				
				else if (numSegs==6){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
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
		}
		else if (parentID.equals("Chest:01")) 
		{
			
			int nMaxSegs = 7;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==3){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==4){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
				}
        		
        		
				else if (numSegs==5){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
				}
				else if (numSegs==6){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
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
			
		}
		else if (parentID.equals("Abdomen:01")) 
		{
			
			int nMaxSegs = 2;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
    		
           		         
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
				}
				else if (numSegs==3){
					bioInstruct.setPivotPoint(3);
					bioInstruct.setRotateVector(0.0, 0.0, 1.0);
					bioInstruct.setTransType(2);
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
			
		}			
	     
		// Generate the object based on the instruction set
		double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, connectPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Esophagus: " + componentID + "   " + componentType);
    		   
		// Set up the BioMightGenerate that will be returned to the client
		// so that its information can be used to build other objects
  		BioMightGenerate  bioMightGenerate = new BioMightGenerate(lastPoints, 0, "");
  		//System.out.println("Setup Esophagus BioMightGenerate Object: " + lastPoints[0][0]);
		   
		return (bioMightGenerate);
	}

	

	/***************************************************************************************
	 * GENERATE BLADDER
	 * 
	 * This generates the bladder
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

   	public int generateBladder(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		System.out.println("GenerateBladder");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Bladder alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double circumference = 1.8;
	    	
			double x =  -8.0;
    		double y =  -10.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Bladder
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(2.0, 1.0, 1.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.5, 1.0, 1.5);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);    
        	}
    		else if (numSegs==4){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.75, 1.0, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);      			
        	}	
    		
    		
    		else if (numSegs==5){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);      			
        	}
    		else if (numSegs==6){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
        	}
    		
    		
    
    		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 		      			
        	}	
    		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
    		}	     		
    		else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		//Generate the Bladder
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Bladder: " + componentID + "   " + componentType);
        	
		return returnCode;
	}


  	/***************************************************************************************
	 * GENERATE GALL BLADDER
	 * 
	 * This generates the Gall Bladder
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateGallBladder(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate GallBladder");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Bladder alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double radius = 1.8;	    	 		
    		double[] startPos = {-3.0, -19.5, -2.75};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building the Bladder
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 11;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Bladder
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(50.0, 50.0, 50.0);
    			bioInstruct.setTranslateMatrix(-0.0025, -0.02, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(2.5, 2.5, 2.5);
    			bioInstruct.setTranslateMatrix(-0.05, -0.05, 0.0); 
           	}
    		else if (numSegs==2){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.5, 1.5, 1.35);
    			bioInstruct.setTranslateMatrix(-0.1, -0.1, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.5, 1.5, 1.35);
    			bioInstruct.setTranslateMatrix(-0.1, -0.1, 0.0);    
        	}
    		else if (numSegs==4){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.45, 1.45, 1.45);
    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0);      			
        	}	
    		
     		else if (numSegs==5){
    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-15);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);       			
        	}
    		else if (numSegs==6){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
    			bioInstruct.setTranslateMatrix(-0.15, -0.25, 0.0);         			
        	}
     		else if (numSegs==7){
       			bioInstruct.setTransType(Constants.SCALE);	
    			bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
    			bioInstruct.setTranslateMatrix(-0.12, -0.20, 0.0);         			
     		}
     		else if (numSegs==8){
       			bioInstruct.setTransType(Constants.SCALE);	
    			bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
    			bioInstruct.setTranslateMatrix(-0.08, -0.20, 0.0);         			
        	}		
    		else if (numSegs==9){
       			bioInstruct.setTransType(Constants.SCALE);	
    			bioInstruct.setScaleMatrix(0.35, 0.35, 0.35);
    			bioInstruct.setTranslateMatrix(0.0, -0.075, 0.0);         			
        	}
     		else if (numSegs==10){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.001, 0.001, 0.001);
    			bioInstruct.setTranslateMatrix(0.00, -0.0025, 0.0);     			
        	}
    		
    		
        	else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the GallBladder
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Gall Bladder: " + componentID + "   " + componentType);
        
		return returnCode;
	}

 	/***************************************************************************************
	 * GENERATE CYSTIC DUCT
	 * 
	 * This generates the Cystic Duct
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateCysticDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate CysticDuct");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, 0.08, 0.0);
				}
				else if (instructCount==1){			
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==2){
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-50);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.35, -0.05, 0.15);
				}
				
			
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for CysticDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}

   	
	/***************************************************************************************
	 * GENERATE COMMON HEPATIC DUCT
	 * 
	 * This generates the Common Hepatic Bile Duct and its Branches
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateCommonHepaticDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate CommonHepaticDuct");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

			int numInstructions = 7;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
		
				if (instructCount==0){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.5, 0.0);
				}
				else if (instructCount==1){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.1, 0.25, -0.05);
				}		
				else if (instructCount==2){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, 0.25, -0.1);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, 0.45, -0.1);
				}	
				else if (instructCount==4){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, 0.25, -0.1);
				}	
				else if (instructCount==5){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, 0.45, 0.0);
				}	
				else if (instructCount==6){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, 0.5, 0.02);
				}	
		
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for CommonHepaticDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}
   	
 	/***************************************************************************************
	 * GENERATE HEPATIC DUCTS
	 * 
	 * This generates the Hepatic Ducts (The left and right)
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateHepaticDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate HepaticDuct: " + componentID + "     parent: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		

		if (parentID.equals("HepaticDuct:01")) 
		{	
			// Do the left Kidney 
	   		int numInstructions = 4;
	   		for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{	
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
        		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.15, 0.15);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.10, 0.12);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.25, 0.25);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.15, 0.1);
				}
							   				
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("HepaticDuct:02")) 
		{	
			// Do the left Kidney 
	   		int numInstructions = 3;
	   		for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{	
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
        		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.35, 0.45, 0.25);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.35, 0.15);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.40, 0.25);
				}
		
							   				
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("HepaticDuct:03")) 
		{	
			// Do the left Kidney 
	   		int numInstructions = 3;
	   		for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{	
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
        		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, -0.05, 0.25);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.10, 0.35);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.20, 0.20);
				}
			   				
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("HepaticDuct:04")) 
		{	
			// Do the left Kidney 
	   		int numInstructions = 3;
	   		for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{	
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.0, 0.0);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.35, 0.05, 0.1);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.035, 0.15);
				}
			   				
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
	
		
		//********************************************************
		// Right Hepatic Ducts
		//
		//********************************************************

		else if (parentID.equals("HepaticDuct:05")) 
		{
	
			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    			
        		// Extend out from the terminus of the Knee
				if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.1, 0.0);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.15, -0.12);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.45, 0.20, -0.15);
				}
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.45, 0.10, -0.1);
				}
	
						
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		}
		
		else if (parentID.equals("HepaticDuct:06")) 
		{
	
			int numInstructions = 5;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
				
        		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, -0.25, -0.05);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(0);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, -0.5, -0.25);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, -0.20, -0.30);
				}
				else if (instructCount==4){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, -0.40, 0.1);
				}
    			
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.2);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		}
		
		else if (parentID.equals("HepaticDuct:07")) 
		{
	
			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    			
        		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, 0.35, -0.10);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(30);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.5, -0.20);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.20, -0.25);
				}	
							
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		}
		
		else if (parentID.equals("HepaticDuct:08")) 
		{
	
			int numInstructions = 3;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    					
		  		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.45, 0.0, -0.2);
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.45, 0.10, -0.15);
				}
				else if (instructCount==2){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.35, 0.15, -0.1);
				}		
							
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.15);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	
		}
		else if (parentID.equals("HepaticDuct:09")) 
		{
	
			int numInstructions = 3;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    					
		  		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, -0.1, -0.2);
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.1, -0.15);
				}
				else if (instructCount==2){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.5, 0.18, -0.1);
				}		
							
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.15);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	
		}
		
		//*******************************************************
		// MIDDLE BRANCH
		// 
		//*******************************************************
		
		else if (parentID.equals("HepaticDuct:10")) 
		{
	
			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    					
		  		// Extend out from the terminus of the Knee
		  		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.25, 0.025, 0.05);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-45);	
	    			bioInstruct.setPivotPoint(2);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
    			else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.35, 0.45, 0.08);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.30, 0.25, 0.05);
				}				
							
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.15);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	
		}
		else if (parentID.equals("HepaticDuct:11")) 
		{
	
			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
    					
		  		// Extend out from the terminus of the Knee
    			if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.025, 0.1);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
    			else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.45, 0.50, 0.28);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.55, 0.35, 0.30);
				}		
    			
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.15);
	    		}
		
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
	
		}

		
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for HepaticDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}


	/***************************************************************************************
	 * GENERATE COMMON BILE DUCT
	 * 
	 * This generates the Common Bile Duct and its Branches
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateCommonBileDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate CommonBileDuct");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

			int numInstructions = 16;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				

				if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, 0.0, 0.0);
				}
				else if (instructCount==1){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
				}		
				else if (instructCount==2){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==3){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(15);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
	     			bioInstruct.setOrientation(orientation);	
				}
				else if (instructCount==4){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, -0.40, -0.5);
				}
				else if (instructCount==5){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.10, -0.15, -0.25);	
				}
				else if (instructCount==6){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.10, -0.20, -0.45);
				}
				else if (instructCount==7){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(4);	
	     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
	     			bioInstruct.setOrientation(orientation);	
				}
				else if (instructCount==8){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.1, -0.25, -0.30);
				}
				else if (instructCount==9){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-15);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
	     			bioInstruct.setOrientation(orientation);	
				}
				else if (instructCount==10){				
					BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(-30);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
	     			bioInstruct.setOrientation(orientation);	
				}
				else if (instructCount==11){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.30, -0.5, 0.0);
				}
				else if (instructCount==12){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -0.5, 0.075);
				}	
				else if (instructCount==13){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.5, 0.1);
				}	
				else if (instructCount==14){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.35, -0.50, -0.12);
				}
				else if (instructCount==15){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.42, -0.075);
				}			
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, 0.0);
	    		}
		
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for CommonBileDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}

   	

	/***************************************************************************************
	 * GENERATE PANCREATIC DUCT
	 * 
	 * This generates the PancreaticDuct and its Branches
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generatePancreaticDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate PancreaticDuct");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

			int numInstructions = 12;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
				}
				else if (instructCount==1){			
					BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
					bioInstruct.setTransType(Constants.ROTATEOCTO);
	    			bioInstruct.setTheta(45);	
	    			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.45, -0.05);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.40, -0.05);
				}
				else if (instructCount==4){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.30, 0.0);
				}
				else if (instructCount==5){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.15, 0.0);
				}
				else if (instructCount==6){				
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setTranslateMatrix(0.5, 0.20, 0.0);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				}
				else if (instructCount==7){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.350, 0.0);
				}
				else if (instructCount==8){				
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setTranslateMatrix(0.5, 0.25, 0.0);
					bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				}
				else if (instructCount==9){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.15, 0.0);
				}
				else if (instructCount==10){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.15, 0.0);
				}
				else if (instructCount==11){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.20, 0.0);
				}		
				
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for PancreaticDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}

	/***************************************************************************************
	 * GENERATE ACCESSORY PANCREATIC DUCT
	 * 
	 * This generates the AccessoryPancreaticDuct and its Branches
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateAccessoryPancreaticDuct(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate AccessoryPancreaticDuct");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the BileDuct
		if (currentPoints == null )
		{
			double circumference = 0.00625;
			double[] startPos = {1.5, 0.25, 0.00};
			currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
		}
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

			int numInstructions = 4;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
									
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(null);
				bioInstruct.setFillAppendage(false); 
				
				if (instructCount==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.1, -0.35);
				}
				else if (instructCount==1){			
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.15, -0.15);
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.5, 0.20, 0.12);
				}
				else if (instructCount==3){				
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, 0.05, 0.10);
				}
				else {
	    			bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.15, -0.2, -0.02);
	    		}
		
				
				
	    		// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for AccessoryPancreaticDuct: " + componentID + "   " + componentType);
        
		return returnCode;
	}

 	/***************************************************************************************
	 * GENERATE THYROID GLAND
	 * 
	 * This generates the Gall Bladder
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
    
   	public int generateThyroidGland(String startID, String componentType, String componentName, String componentID, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate ThyroidGland");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ThyroidGland alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double radius = 1.8;
			double[] startPos = {-2.0, -20.5, -3.25};
			double[] orient = {0.0, 0.0, 0.05};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building the ThyroidGland
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the ThyroidGland
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(2.0, 1.0, 1.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.5, 1.0, 1.5);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0); 
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);    
        	}
    		else if (numSegs==4){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.75, 1.0, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);      			
        	}	
    		
    		
    		
        		else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the ThyroidGland
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for ThyroidGland: " + componentID + "   " + componentType);
        
		return returnCode;
	}

   	
   	/***************************************************************************************
	 * GENERATE EYELID
	 * 
	 * This method generates an eyelid
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

   	public int generateEyeLid(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("Generate EyeLid");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the EyeLid alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double circumference = 1.8;
	    	
			double x =  -8.0;
    		double y =  -10.0;
    		double z =  -1.0;
			
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
		
		
 		if (parentID.equals("EyeLid:01")) 
		{	
		
 			int nMaxSegs = 8;
 			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
 				// Create a place for an instruction 
 				BioMightInstruction bioInstruct = new BioMightInstruction();
     
 				
 				if (numSegs==0){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==1){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==2){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==3){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==4){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.0, 0.0, 0.5);
 				}	
 				else if (numSegs==5){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}	
 				else if (numSegs==6){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==7){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}     				
 				else if (numSegs==7){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}  

 				else {
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
 				}
	    
 				// Add the instruction into the instruction set
 				bioMightInstructSet.addElement(bioInstruct);
 			}
		}
 		else if (parentID.equals("EyeLid:02")) 
		{

 			int nMaxSegs = 5;
 			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
 				// Create a place for an instruction 
 				BioMightInstruction bioInstruct = new BioMightInstruction();
     
 				// Extend 
 				if (numSegs==0){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==1){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==2){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==3){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}
 				else if (numSegs==4){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.5, 0.0, 0.0);
 				}	
    		

 				else {
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
 				}
	    
 				// Add the instruction into the instruction set
 				bioMightInstructSet.addElement(bioInstruct);
 			}
		
		}    	
 		else if (parentID.equals("EyeLid:03")) 
		{

 			int nMaxSegs = 5;
 			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
 				// Create a place for an instruction 
 				BioMightInstruction bioInstruct = new BioMightInstruction();
     
 				// Extend 
 				if (numSegs==0){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==1){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==2){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==3){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==4){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}	
    		

 				else {
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
 				}
	    
 				// Add the instruction into the instruction set
 				bioMightInstructSet.addElement(bioInstruct);
 			}
		
		}  
 		else if (parentID.equals("EyeLid:04")) 
		{

 			int nMaxSegs = 5;
 			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
 				// Create a place for an instruction 
 				BioMightInstruction bioInstruct = new BioMightInstruction();
     
 				// Extend
 				if (numSegs==0){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==1){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==2){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==3){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}
 				else if (numSegs==4){
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(-0.5, 0.0, 0.0);
 				}	
    		

 				else {
 					bioInstruct.setTransType(Constants.TRANSLATE);
 					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
 				}
	    
 				// Add the instruction into the instruction set
 				bioMightInstructSet.addElement(bioInstruct);
 			}
		
		}  
 			
		
		// Generate the EyeLid
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
  		//System.out.println("Generated the Rows for EyeLid: " + componentID + "   " + componentType);  		
  	  
		return returnCode;
	}

   	
   	
	/***************************************************************************************
	 * GENERATE SPLEEN
	 * 
	 * This generates the Spleen
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

   	public int generateSpleen(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("GenerateSpleen");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Spleen alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double radius = 0.0025;
	    	
		
			double[] startPos = {4.0,-18.5, -4.75};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 10;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
    		// Extend out from the terminus of the Spleen
			//Follow the Rule; 1 x 3 x 5 are dimensions, 7oz between 9th and 11th ribs
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(30.0, 30.0, 30.0);
    			bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(6.0, 4.0, 3.5);
    			bioInstruct.setTranslateMatrix(0.05, -0.25, 0.0); 
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.2, 1.2, 1.0);
    			bioInstruct.setTranslateMatrix(0.075, -0.25, 0.0); 
    		}
    		else if (numSegs==3){
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.075, -0.25, 0.0);   
        	}
    		else if (numSegs==4){
				BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);      			
        	}	
    		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.1, -0.25, 0.0);        			
        	}
    		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
    			bioInstruct.setTranslateMatrix(-0.15, -0.25, 0.0);        			
        	}	 
       		else if (numSegs==7){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
    			bioInstruct.setTranslateMatrix(-0.15, -0.25, 0.0); 
           	}
       		else if (numSegs==8){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.70, 0.70, 0.70);
    			bioInstruct.setTranslateMatrix(-0.18, -0.25, 0.0); 
           	}
       		else if (numSegs==9){
       			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.0010, 0.0010, 0.0010);
    			bioInstruct.setTranslateMatrix(0.0, -0.002, 0.0); 
           	}		
    		
       	
    		
    		else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
	    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the Spleen based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
  		//System.out.println("Generated the Rows for Spleen: " + componentID + "   " + componentType);  		
  	  
		return returnCode;
	}
   	
	/***************************************************************************************
	 * GENERATE URETER
	 * 
	 * This generates the ureter
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

   
   	public int generateUreter(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
  	{	
		//System.out.println("GenerateUreter: " + componentID + "  " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Ureter alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double radius = 1.8;
		    
			double[] startPos = {3.75,-25.0,-6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		
		if (parentID.equals("Ureter:01")) 
		{	
			// Do the left ureter 
			int nMaxSegs = 11;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
				// Extend 
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.25, -1.0, 0.0);  
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -1.0, 0.0);  
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.10, -1.0, 0.25); 
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.07, -1.0, 0.25);     
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.25);     
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.25);     
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.07);     
				}
				else if (numSegs==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.05);       			
				}	
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.20, -1.0, 0.02);       			
				}	
				else if (numSegs==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.30, -1.0, 0.04);       			
				}	
				else if (numSegs==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(-0.35, -0.50, 0.02);       			
				}	

	
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Ureter:02")) 
		{	
	    	
    		int nMaxSegs = 11;
    		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
           		         
        		// Extend 
				if (numSegs==0){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.25, -1.0, 0.0);  
				}
				else if (numSegs==1){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.20, -1.0, 0.0);  
				}
				else if (numSegs==2){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.10, -1.0, 0.25); 
				}
				else if (numSegs==3){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.07, -1.0, 0.25);     
				}
				else if (numSegs==4){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.01, -1.0, 0.25);     
				}
				else if (numSegs==5){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.25);     
				}
				else if (numSegs==6){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.05, -1.0, 0.07);     
				}
				else if (numSegs==7){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.05);       			
				}	
				else if (numSegs==8){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.0, -1.0, 0.02);       			
				}	
				else if (numSegs==9){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.10, -1.0, 0.04);       			
				}	
				else if (numSegs==10){
					bioInstruct.setTransType(Constants.TRANSLATE);
					bioInstruct.setTranslateMatrix(0.15, -0.250, 0.02);       			
				}								
        		else {
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
        		}
    	    
        		// Add the instruction into the instruction set
        		bioMightInstructSet.addElement(bioInstruct);
    		}
			
		}
	
		
		// Generate the Ureter
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Ureter: " + componentID + "   " + componentType);  		
      	   		
		return returnCode;
	}

	
	
   	/***************************************************************************************
	 * GENERATE KIDNEY
	 * 
	 * This generates the Kidney
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateKidney(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Kidney for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Kidney alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double radius = 1.8;
			double[] startPos = {3.75,-23.0,-6.0};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		

		
		if (parentID.equals("Kidney:01")) 
		{	
			// Do the left Kidney 
	   		int nMaxSegs = 17;
    		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
        		// Extend out from the terminus of the Knee
    			if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(28.0, 28.0, 28.0);
	    			bioInstruct.setTranslateMatrix(0.0025, 0.0, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(5.0, 5.0, 5.0);
	    			bioInstruct.setTranslateMatrix(0.15, 0.0, 0.0); 
	           	}
	      		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.5, 1.5, 1.0);
	    			bioInstruct.setTranslateMatrix(0.20, 0.0, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(0.40, 0.0, 0.0);
	           	}		
	       		else if (numSegs==4){
    				BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
		 			bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
		 			bioInstruct.setTheta(-30);	
		 			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation); 
            	}		
	       		else if (numSegs==5){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
			 		bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
		    		bioInstruct.setTheta(-30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }			
	       		else if (numSegs==6){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(-30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }	
	       		else if (numSegs==7){
	       			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
        			bioInstruct.setTranslateMatrix(0.0, -0.35, 0.0);
               	}
        		else if (numSegs==8){
        			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
        			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
               	}	
          		else if (numSegs==9){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
        			bioInstruct.setTranslateMatrix(0.0, -0.35, 0.0);
               	}  				
	       		else if (numSegs==10){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(-30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }			
	       		else if (numSegs==11){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(-30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }				
	       		else if (numSegs==12){
		    		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
			   		bioInstruct.setTheta(-30);	
			   		bioInstruct.setPivotPoint(6);	
			   		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
			   		bioInstruct.setOrientation(orientation); 
		            }				
	    		else if (numSegs==13){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
        			bioInstruct.setTranslateMatrix(-0.20, 0.0, 0.0);
               	}
	    		else if (numSegs==14){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
        			bioInstruct.setTranslateMatrix(-0.20, 0.0, 0.0);
               	} 
	       		else if (numSegs==15){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
        			bioInstruct.setTranslateMatrix(-0.15, 0.0, 0.0);
               	}  		
        		else if (numSegs==16){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.001, 0.001, 0.001);
        			bioInstruct.setTranslateMatrix(-0.0025, 0.0, 0.0);
               	}
    					   				
    			
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Kidney:02")) 
		{	
	    	
    		int nMaxSegs = 17;
    		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
    		
    			// Create a place for an instruction 
    			BioMightInstruction bioInstruct = new BioMightInstruction();
    	 
    			
        		// Extend out from the terminus of the Knee
    			if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(28.0, 28.0, 28.0);
	    			bioInstruct.setTranslateMatrix(-0.0025, 0.0, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(5.0, 5.0, 5.0);
	    			bioInstruct.setTranslateMatrix(-0.15, 0.0, 0.0); 
	           	}
	      		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.5, 1.5, 1.0);
	    			bioInstruct.setTranslateMatrix(-0.20, 0.0, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
	    			bioInstruct.setTranslateMatrix(-0.40, 0.0, 0.0);
	           	}		
	       		else if (numSegs==4){
    				BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
		 			bioInstruct.setTransType(Constants.ROTATEOCTO);
		 			bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
		 			bioInstruct.setTheta(30);	
		 			bioInstruct.setPivotPoint(6);	
	     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
	     			bioInstruct.setOrientation(orientation); 
            	}		
	       		else if (numSegs==5){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTOSCALE);
			 		bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
		    		bioInstruct.setTheta(30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }			
	       		else if (numSegs==6){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }	
	       		else if (numSegs==7){
	       			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
        			bioInstruct.setTranslateMatrix(0.0, -0.35, 0.0);
               	}
        		else if (numSegs==8){
        			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
        			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
               	}	
          		else if (numSegs==9){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
        			bioInstruct.setTranslateMatrix(0.0, -0.35, 0.0);
               	}  				
	       		else if (numSegs==10){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }			
	       		else if (numSegs==11){
	    			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
		    		bioInstruct.setTheta(30);	
		    		bioInstruct.setPivotPoint(6);	
		     		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
		     		bioInstruct.setOrientation(orientation); 
	            }				
	       		else if (numSegs==12){
		    		BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			 		bioInstruct.setTransType(Constants.ROTATEOCTO);
			   		bioInstruct.setTheta(30);	
			   		bioInstruct.setPivotPoint(6);	
			   		bioInstruct.setRotateVector(0.0, 0.0, 1.0);
			   		bioInstruct.setOrientation(orientation); 
		            }				
	    		else if (numSegs==13){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
        			bioInstruct.setTranslateMatrix(0.20, 0.0, 0.0);
               	}
	    		else if (numSegs==14){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
        			bioInstruct.setTranslateMatrix(0.20, 0.0, 0.0);
               	} 
	       		else if (numSegs==15){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
        			bioInstruct.setTranslateMatrix(0.15, 0.0, 0.0);
               	}  		
        		else if (numSegs==16){
          			bioInstruct.setTransType(Constants.SCALE);
        			bioInstruct.setScaleMatrix(0.001, 0.001, 0.001);
        			bioInstruct.setTranslateMatrix(0.0025, 0.0, 0.0);
               	} 			
				
        		else {
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
        		}
    	    
        		// Add the instruction into the instruction set
        		bioMightInstructSet.addElement(bioInstruct);
    		}
			
		}


		// Generate the Kidney
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Kidney: " + componentID + "   " + componentType);  		
		
		return returnCode;
	}

  	/***************************************************************************************
	 * GENERATE ADRENAL GLAND
	 * 
	 * This generates the Kidney
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateAdrenalGland(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate AdrenalGland for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the AdrenalGland alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.125;
			double[] startPos = {-3.75,-21.0,-6.0};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
     		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		if (parentID.equals("AdrenalGland:01")) 
		{	
			// Do the left Adrenal Gland 
			int nMaxSegs = 6;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
				// Extend out from the terminus of the Knee
	  			if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(20.0, 20.0, 20.0);
	    			bioInstruct.setTranslateMatrix(0.025, -0.025, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(3.3, 3.3, 3.3);
	    			bioInstruct.setTranslateMatrix(0.10, -0.1, 0.0); 
	           	}
	      		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
	    			bioInstruct.setTranslateMatrix(0.1, -0.2, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.25);
	    			bioInstruct.setTranslateMatrix(0.1, -0.2, 0.0);
	           	}				
	    		else if (numSegs==4){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
	    			bioInstruct.setTranslateMatrix(0.1, -0.25, 0.0);
	           	}	
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.15, 0.0);
	           	}	
	  			
				else
        		{
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("AdrenalGland:02")) 
		{	
	    	
			int nMaxSegs = 6;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
				if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(20.0, 20.0, 20.0);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.025, 0.0); 
	    		}
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(3.3, 3.3, 3.3);
	    			bioInstruct.setTranslateMatrix(-0.10, -0.1, 0.0); 
	           	}
	      		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
	    			bioInstruct.setTranslateMatrix(-0.1, -0.2, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.25);
	    			bioInstruct.setTranslateMatrix(-0.1, -0.2, 0.0);
	           	}				
	    		else if (numSegs==4){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
	    			bioInstruct.setTranslateMatrix(-0.1, -0.25, 0.0);
	           	}	
	    		else if (numSegs==5){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.15, 0.0);
	           	}	
	  	
	  			
				else
        		{
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
        		}
	    		
    	    
        		// Add the instruction into the instruction set
        		bioMightInstructSet.addElement(bioInstruct);
    		}
			
		}


		// Generate the AdrenalGland
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for AdrenalGland: " + componentID + "   " + componentType);  		
		
		return returnCode;
	}


 	/***************************************************************************************
	 * GENERATE PITUITARY GLAND
	 * 
	 * This generates the Pituitary
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePituitaryGland(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate PituitaryGland for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Pituitary alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double circumference = 0.125;
			double[] startPos = {0.0, -1.50, -3.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
     		currentPoints = BioGraphics.octogonYPlane(startPos, circumference);	
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the PituitaryGland
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.0, 1.20);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.0, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
	      	}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0);    
	   	}
			else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 0.50);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0);      			
	   	}	
		
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the PituitaryGland
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for PituitaryGland: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}

	

 	/***************************************************************************************
	 * GENERATE BRAIN 
	 * 
	 * This method generates the Brain
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateBrain(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Brain for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Brain gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {0.0, -2.50, -1.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
     		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the Brain
			int nMaxSegs = 14;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(90.0, 25.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.10, 0.25);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.5);
				bioInstruct.setTranslateMatrix(0.0, 0.10, -0.10);  
	      	}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==6)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==7)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==8)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.10, -0.25);    
			}	
			else if (numSegs==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.05, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.10, -0.25);    
			}	
			else if (numSegs==11){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==12){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);  
			}	
					
			else if (numSegs==13)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);
			}	
			
			
			

			
			/*
			else if (numSegs==7){
				bioInstruct.setTransType(Constants.ROTATEMOVESCALE);
    			bioInstruct.setTheta(-22.5);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.0, 2.5);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
				bioInstruct.setOrientation(orientation);
			}		
		
		
			else if (numSegs==9){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);   
			}
			else if (numSegs==10){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);   
			}
			else if (numSegs==11){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-15);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);   
			}
			else if (numSegs==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, 0.5, 0.0);    
			}
			else if (numSegs==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.001, 0.001, 0.001);
				bioInstruct.setTranslateMatrix(0.0, 0.001, 0.0);    
			}
			*/
			
			
			
	
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the Brain
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Brain: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	
	/***************************************************************************************
	 * GENERATE CEREBRUM 
	 * 
	 * This method generates the Cerebum
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCerebrum(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Cerebrum for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Brain gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {0.0, -2.50, -1.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
     		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
		if (parentID.equals("Cerebrum:0"))
		{
		
			// Do the Brain
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(12.0, 8.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00125, 0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.25, 0.25);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);
			}
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation); 
	      	}	
			
			
			
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.25, -0.10); 
			}	
			else if (numSegs==6)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
	  			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(2); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation); 
			}	
			else if (numSegs==7)
			{
	  			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(2); 
				bioInstruct.setScaleMatrix(1.0, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.15, 0.15);
				bioInstruct.setOrientation(orientation); 
			}	

			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
		
		}
		else if (parentID.equals("Cerebrum:01"))
		{
			
			// Do the Brain
			int nMaxSegs = 13;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
 		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25.0, 1.0, 15.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00125, 0.0); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.05, 1.0, 1.05);
				bioInstruct.setTranslateMatrix(0.0, 0.25, 0.0);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setOrientation(orientation);
			}
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.ROTATEMOVESCALE);
				bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.20, 1.02);
				bioInstruct.setTranslateMatrix(0.0, 0.18, -0.075);
				bioInstruct.setOrientation(orientation);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.ROTATEMOVESCALE);
	  			bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.15, -0.15);
				bioInstruct.setOrientation(orientation); 
	      	}
	  		else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.2, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.50); 
			}
			else if (numSegs==6)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25); 
			}
			else if (numSegs==7)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.15, -0.50); 
			}	
			else if (numSegs==8)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==9)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==10){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==11){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-10);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);  
			}	
			else if (numSegs==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.80, 1.00, 0.80);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);  
			}	
			
			
			else if (numSegs==13){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);  
			}	
		
			
	
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Cerebrum:02"))
		{
			
			int nMaxSegs = 13;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
 		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25.0, 1.0, 15.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00125, 0.0); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.25, 0.0);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setOrientation(orientation);
			}
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.ROTATEMOVESCALE);
				bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.15, 1.03);
				bioInstruct.setTranslateMatrix(0.0, 0.18, -0.075);
				bioInstruct.setOrientation(orientation);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.ROTATEMOVESCALE);
	  			bioInstruct.setTheta(-30);
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.2, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.15, -0.15);
				bioInstruct.setOrientation(orientation); 
	      	}
	  		else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.2, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.50); 
			}
			else if (numSegs==6)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25); 
			}
			else if (numSegs==7)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.15, -0.50); 
			}	
			else if (numSegs==8)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==9)
			{
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==10){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);
			}	
			else if (numSegs==11){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-10);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(6); 
				bioInstruct.setScaleMatrix(1.0, 1.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.15);
				bioInstruct.setOrientation(orientation);  
			}	
			else if (numSegs==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.80, 1.00, 0.80);
				bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);  
			}	
			
			
			else if (numSegs==13){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);
      			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
    			bioInstruct.setPivotPoint(4); 
				bioInstruct.setScaleMatrix(1.0, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.25);
				bioInstruct.setOrientation(orientation);  
			}	
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Cerebrum:03"))
		{
			
			int nMaxSegs = 10;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(16.0, 12.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.25, 0.0, 0.25);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.20, 0.05, 0.50);
			}	
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.10, 0.05, 0.50);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
	  		else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.15, 0.50); 
			}
	  		else if (numSegs==6){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.50); 
	      	}
	  		else if (numSegs==7){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.50); 
	      	}
			else if (numSegs==8){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
			else if (numSegs==9){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
			
	
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Cerebrum:04"))
		{
			
			// Do the Brain
			int nMaxSegs = 10;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(16.0, 12.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.25, 0.0, 0.25);  
	      	}
			else if (numSegs==2)
			{
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.20, 0.05, 0.50);
			}	
			else if (numSegs==3)
			{
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.10, 0.05, 0.50);
			}
	  		else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
	  		else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.15, 0.50); 
			}
	  		else if (numSegs==6){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.50); 
	      	}
	  		else if (numSegs==7){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.50); 
	      	}
			else if (numSegs==8){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
			else if (numSegs==9){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.50); 
	      	}
			
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
	
		// Generate the Brain
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Brain: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	
 	/***************************************************************************************
	 * GENERATE CEREBELLUM 
	 * 
	 * This method generates the Cerebellum
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateCerebellum(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Cerebellum for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Cerebellum gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {0.0, -2.50, -1.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the Cerebellum
			int nMaxSegs = 8;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(4.0, 3.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.00, 2.35, 0.5);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
	      	}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.5); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.5);    
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 0.50, 0.50);
				bioInstruct.setTranslateMatrix(0.0, -0.20, -0.5);  
			}
			else if (numSegs==5)
			{
	 				bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.40, 0.40, 0.40);
					bioInstruct.setTranslateMatrix(0.0, -0.10, -0.25);      
			}
			else if (numSegs==6)
			{
	 				bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.050, 0.050, 1.0);
					bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);      
			}
			else if (numSegs==7)
			{
	 				bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.050, 0.050, 1.0);
					bioInstruct.setTranslateMatrix(0.0, 0.0, -0.00125);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the Cerebellum
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Cerebellum: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	

 	/***************************************************************************************
	 * GENERATE PONS 
	 * 
	 * This method generates the Pons
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePons(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Pons for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Pons gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {0.0, -2.50, -1.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the Pons working from top to bottom
			int nMaxSegs = 8;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.25, 1.0, 1.25);	
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.01); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.40, 1.0, 1.40);
				bioInstruct.setTranslateMatrix(0.0, -0.20, 0.03);
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.2, 1.0, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.35, 0.05); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.90, 0.90, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.20, -0.05); 
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 1.0, 0.80);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.125);     
			}
			else if (numSegs==5){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(1.12, 1.0, 1.12);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.07);     
			}
			else if (numSegs==6){
				bioInstruct.setTransType(Constants.SCALE);
	  			bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.03);     
			}
			else if (numSegs==7)
			{
	 			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.20, 0.20, 0.20);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, -0.0125);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the Pons
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Pons: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}

	/***************************************************************************************
	 * GENERATE MEDULLA OBLONGATA 
	 * 
	 * This method generates the MedullaOblongata
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateMedullaOblongata(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate MedullaOblongata for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the MedullaOblongata gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {0.0, -2.50, -1.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the MedullaOblongata
			int nMaxSegs = 6;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.10, 1.0, 1.10);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.00125); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.1); 
	      	}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.1); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.15);
				bioInstruct.setScaleMatrix(0.85, 1.0, 0.85);
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, -0.18);   
				bioInstruct.setScaleMatrix(0.80, 1.0, 0.80);
			}
			else if (numSegs==5)
			{
	 				bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.20, 1.0, 0.20);
					bioInstruct.setTranslateMatrix(0.0, 0.125, 0.125);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the MedullaOblongata
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for MedullaOblongata: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	
	
	/***************************************************************************************
	 * GENERATE PONS 
	 * 
	 * This method generates the Tongue
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateTongue(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Tongue for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Tongue gland, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{	
			double circumference = 0.0625;
			double[] startPos = {0.0, -3.75, -0.75};
			currentPoints = BioGraphics.octogonZPlane(startPos, circumference);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the Tongue
			int nMaxSegs = 6;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		        
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(6.0, 5.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
	  		else if (numSegs==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(6.0, 4.00, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25); 
			}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.10, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.50); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.10, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.50);     
			}
			else if (numSegs==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.5);     
			}
			else if (numSegs==5)
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.5);      
			}
			else 
			{
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.25);  
			}	
		
  
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the Tongue
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Tongue: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	
	
	/***************************************************************************************
	 * GENERATE THYMUS GLAND
	 * 
	 * This generates the Thymus
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateThymus(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Thymus for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Pituitary alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.125;
			double[] startPos = {0.0, -11.50, -3.50};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the Thymus
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.0, 1.20);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.0, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
	      	}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.950, 1.0, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.0625, 0.0);    
	   	}
			else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 0.50);
				bioInstruct.setTranslateMatrix(0.0, -0.0625, 0.0);      			
	   	}	
		
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the Thymus
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Thymus: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}
	
 	/***************************************************************************************
	 * GENERATE PARATHYROID GLAND
	 * 
	 * This generates the Kidney
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateParaThyroidGland(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate ParaThyroidGland for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ParaThyroidGland alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.0625;
			double[] startPos = {-3.75,-21.0,-6.0};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		if (parentID.equals("ParaThyroidGland:01")) 
		{	
			// Do the left Kidney 
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
	    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
	    		}
	    		else if (numSegs==1){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.10, 1.0, 1.45);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}
	    		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}				
				else
        		{
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("ParaThyroidGland:02")) 
		{	
	    	
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
	    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.0);
	    		}
	    		else if (numSegs==1){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.45, 1.0, 1.45);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}
	    		else if (numSegs==2){
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}
	    		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
	           	}				
				else
        		{
	      			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
        		}
	    		
    	    
        		// Add the instruction into the instruction set
        		bioMightInstructSet.addElement(bioInstruct);
    		}
			
		}


		// Generate the ParaThyroidGland
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for ParaThyroidGland: " + componentID + "   " + componentType);  		
		
		return returnCode;
	}
	
 	/***************************************************************************************
	 * GENERATE PINEAL GLAND
	 * 
	 * This generates the Pineal
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generatePinealGland(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate PinealGland for: " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Pineal alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			
			double radius = 0.100;
			double[] startPos = {0.0, 0.00, -2.00};
			
			// Create a equilateral octogon
    		double x =  startPos[0];
    		double y =  startPos[1];
    		double z =  startPos[2];
    		 
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 		}	

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
			// Do the PinealGland
			int nMaxSegs = 5;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
	       		         
	  		         
			// Extend out from the terminus of the ThyroidGland
			if (numSegs==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.0, 1.10);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
			}
	  		else if (numSegs==1){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.15);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
	      	}
			else if (numSegs==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0); 
			}
			else if (numSegs==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 0.90);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0);    
	   	}
			else if (numSegs==4){
	  			bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.50, 1.0, 0.50);
				bioInstruct.setTranslateMatrix(0.0, -0.125, 0.0);      			
	   	}	
		
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
	
	
		// Generate the PinealGland
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for PinealGland: " + componentID + "   " + componentType);  		
		
		return returnCode;
 	}

	
	/***************************************************************************************
	 * GENERATE LUNG
	 * 
	 * This generates the Lung
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/

	public int generateLung(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
	throws DataException, DataSecurityException
 	{	
		//System.out.println("Generate Lung");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Lung alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the base of the skull.
		if (currentPoints == null )
		{
			double circumference = 1.8;
		    	
			double x =  -8.0;
    		double y =  -25.0;
    		double z =  -4.0;
		
    		double xAxis = 1.0;
     		double yAxis = 0.0;
     		double zAxis = 0.0;
     		double degrees = 0.0;
     		
     		double startPos[] = {3.75, -23.0, -6.0};
    		double radius = 0.005; //bioMightTransform.getRadius();
			//System.out.println("Creating Lung Octogon with radius: " + radius);
			
			int numPoints = 8;
    		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		

		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		
		if (parentID.equals("Lung:01")) 
		{	
			// Do the left Lung 
			int nMaxSegs = 19;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
				
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(225, 225, 225);
	    			bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.0);
	    		}
	      		else if (numSegs==1){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(3.25, 1.0, 1.90);
	    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);  
	        	}		
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.5, 1.0, 1.75);
	    			bioInstruct.setTranslateMatrix(0.025, -0.5, 0.0);  
	        	}	
	      		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.0, 1.70);
	    			bioInstruct.setTranslateMatrix(0.25, -0.5, 0.0); 
	        	}                  	 
	       		else if (numSegs==4){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.02);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	           	}
	    		else if (numSegs==5){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.03);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	    		}
	    		else if (numSegs==6){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.02);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	           	}	
	      		else if (numSegs==7){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.00);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	           	}  		
	    		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.01, 1.0, 1.00);
	    			bioInstruct.setTranslateMatrix(0.345, -0.5, 0.0); 
	           	}  			
	    		else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.35, -0.5, 0.0); 
	           	}  					   				
	       		else if (numSegs==10){
	    			bioInstruct.setScaleMatrix(0.975, 1.00, 1.00);
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(0.18, -0.25, 0.0); 
	           	} 
	       		else if (numSegs==11){
		    		bioInstruct.setTransType(Constants.SCALE);
		    		bioInstruct.setScaleMatrix(1.1, 1.00, 1.00);
		    		bioInstruct.setTranslateMatrix(-0.075, -0.5, 0.0); 
		        }
	       		else if (numSegs==12){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==13){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(-0.06, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==14){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.20, -0.5, 0.0); 
	           	} 
	      		else if (numSegs==15){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.03, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.10, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==16){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.10, -0.5, 0.0); 
	           	} 
	    		else if (numSegs==17){
	       			bioInstruct.setTransType(Constants.ROTATEOCTO);
        			bioInstruct.setTheta(-7.5);
          			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
        			bioInstruct.setPivotPoint(4); 
		        } 
	    		else if (numSegs==18){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
	    			bioInstruct.setTranslateMatrix(0.0, -0.0001, 0.0);
	           	}		
	    		
	    		
	    		/*
	       		else if (numSegs==13){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(-0.25, -0.5, 0.0); 
	           	} 
	       	
	      		else if (numSegs==16){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.01, 1.0, 1.1);
	    			bioInstruct.setTranslateMatrix(0.15, -0.65, 0.0); 
	           	} 
	     
	           	
	           	*/
	    		
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}
		else if (parentID.equals("Lung:02")) 
		{	
			// Do the left Lung 
			int nMaxSegs = 19;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
				
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(225, 225, 225);
	    			bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.0);
	    		}
	      		else if (numSegs==1){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(3.25, 1.0, 1.90);
	    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);  
	        	}		
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.5, 1.0, 1.75);
	    			bioInstruct.setTranslateMatrix(-0.025, -0.5, 0.0);  
	        	}	
	      		else if (numSegs==3){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.25, 1.0, 1.70);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.5, 0.0); 
	        	}                  	 
	       		else if (numSegs==4){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.02);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.5, 0.0); 
	           	}
	    		else if (numSegs==5){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.02);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.5, 0.0); 
	    		}
	    		else if (numSegs==6){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.02);
	    			bioInstruct.setTranslateMatrix(-0.11, -0.5, 0.0); 
	           	}	
	      		else if (numSegs==7){
	      			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.00);
	    			bioInstruct.setTranslateMatrix(-0.11, -0.5, 0.0); 
	           	}  		
	    		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.00);
	    			bioInstruct.setTranslateMatrix(-0.12, -0.5, 0.0); 
	           	}  			
	    		else if (numSegs==9){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.01);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.5, 0.0); 
	           	}  					   				
	       		else if (numSegs==10){
	    			bioInstruct.setScaleMatrix(1.03, 1.00, 1.00);
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setTranslateMatrix(-0.15, -0.25, 0.0); 
	           	} 
	       		else if (numSegs==11){
		    		bioInstruct.setTransType(Constants.SCALE);
		    		bioInstruct.setScaleMatrix(1.03, 1.00, 1.0);
		    		bioInstruct.setTranslateMatrix(-0.05, -0.5, 0.0); 
		        }
	       		else if (numSegs==12){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.03, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==13){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.05, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==14){	
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.1, -0.5, 0.0); 
	           	} 
	      		else if (numSegs==15){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.12, -0.5, 0.0); 
	           	} 
	       		else if (numSegs==16){
	     			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.02, 1.0, 1.0);
	    			bioInstruct.setTranslateMatrix(0.15, -0.5, 0.0); 
	           	} 
	    		else if (numSegs==17){
	       			bioInstruct.setTransType(Constants.ROTATEOCTO);
        			bioInstruct.setTheta(7.5);
          			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
        			bioInstruct.setPivotPoint(0); 
		        } 
	    		else if (numSegs==18){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
	    			bioInstruct.setTranslateMatrix(0.0, -0.0001, 0.0);
	           	}	   
	    		
	    		
				else
        		{
        			bioInstruct.setTransType(Constants.TRANSLATE);
        			bioInstruct.setScaleMatrix(0.75, 1.0, 0.9);
        			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
        		}
    
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
			}
			
		}

		// Generate the Lung
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generated the Rows for Lung: " + componentID + "   " + componentType);  		
		
		return returnCode;
	}

   	
	/***************************************************************************************
	 * GENERATE NECK
	 * 
	 * This generates the neck
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
public BioMightGenerate generateNeck(String startID, String componentType, String componentName, String componentID,  String parentID, BioMightConstruct bioMightConstruct) 
throws DataException, DataSecurityException
{			
	//System.out.println("GenerateNeck: " + componentID + "   " +  parentID);
    	
	int bodyID = 1;
	int projectID = 1;
	String vertices = "";
	int returnCode = 0;
	double [][] currentPoints = null;
		
	double radius = 2.0;

	if (bioMightConstruct == null )
	{
		bioMightConstruct = new BioMightConstruct();
			
	    // Generate the Esophagus
		double[] startPos = {0.0, -5.0, -1.5};

    	// Create the octogon shaped object
		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 	}
	else
	{
		// Get the Bounding Box from the Constructor
		//System.out.println("Using Constructor to Generate Neck Epithelium");
		BioMightBoundBox bioMightBoundBox = bioMightConstruct.getBoundingBox("Neck");
		BioMightConnectors bioMightConnectors = bioMightBoundBox.getBioMightConnectors();
		BioMightConnector bioMightConnector = bioMightConnectors.getBioMightConnector("NeckEpithelium");
		currentPoints = bioMightConnector.getConnectorPoints();
		//System.out.println("Have Box and Connectors to Generate Neck");
	
		// Get the Bounding Box for the neck from the Constructor
		//System.out.println("In generateNeck XBound: " + bioMightBoundBox.getxPos());
		//System.out.println("In generateNeck YBound: " + bioMightBoundBox.getyPos());
		//System.out.println("In generateNeck zBound: " + bioMightBoundBox.getzPos());	
		
		//System.out.println("In generateNeck Bound: " + currentPoints[0][0]);
		//System.out.println("In generateNeck yBound: " + currentPoints[0][1]);
		//System.out.println("In generateNeck zBound: " + currentPoints[0][1]);	
	}
	
	
	// Allocate an instruction set for building it
	BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
	int nMaxSegs = 3;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
		
   		// For the base model, the neck starts at 3 inches from 0 at the base of ear
		// in the front it starts at 6 inches and goes for 3 until 5.5in the back
  		if (numSegs==0){
   			bioInstruct.setTransType(Constants.TRANSLATE);
   			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
   		}
   		else if (numSegs==1){
   			bioInstruct.setTransType(Constants.TRANSLATE);
   			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
       	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
  		
  		
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
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
	//System.out.println("Generating the Rows for NeckEpithelium: " + componentID + "   " + componentType);

	//double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);   
		
	// Store the results in the return object
	BioMightGenerate  bioMightGenerate = null; //new BioMightGenerate(lastPoints, 0, "");
		
	return (bioMightGenerate);
}


public int generateNeck(String startID, String componentType, String componentName, String componentID,  String parentID, double[][] currentPoints) 
throws DataException, DataSecurityException
{			
	//System.out.println("GenerateNeck: " + componentID + "   " +  parentID);
    	
	int bodyID = 1;
	int projectID = 1;
	String vertices = "";
	int returnCode = 0;	
	double radius = 2.0;

	if (currentPoints == null )
	{			
	    // Generate the Esophagus
		double[] startPos = {0.0, -5.0, -1.5};

    	// Create the octogon shaped object
		currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
 	}
	else
	{
		// Get the Bounding Box from the Constructor

	}
	
	
	// Allocate an instruction set for building it
	BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
	int nMaxSegs = 3;
	for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
		// Create a place for an instruction 
		BioMightInstruction bioInstruct = new BioMightInstruction();
		
   		// For the base model, the neck starts at 3 inches from 0 at the base of ear
		// in the front it starts at 6 inches and goes for 3 until 5.5in the back
  		if (numSegs==0){
   			bioInstruct.setTransType(Constants.TRANSLATE);
   			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
   		}
   		else if (numSegs==1){
   			bioInstruct.setTransType(Constants.TRANSLATE);
   			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
       	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
  		
  		
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
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
	//System.out.println("Generating the Rows for NeckEpithelium: " + componentID + "   " + componentType);

	//double[][] lastPoints = DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);   
		
	// Store the results in the return object
	BioMightGenerate  bioMightGenerate = null; //new BioMightGenerate(lastPoints, 0, "");
		
	return (returnCode);
}
	
	/***************************************************************************************
	 * GENERATE FINGER
	 * 
	 * This generates a finger
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateFinger(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateFinger");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Arm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Arm.
		if (currentPoints == null )
		{
			double circumference = 0.25;
    		
			double x =  -8.0;
    		double y =  -10.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		
    		
    		
    		else if (numSegs==3){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
        	}
    		else if (numSegs==4){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	}
    		else if (numSegs==5){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
    		}
    		else if (numSegs==6){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		      			     				      			
    		}		
    		else if (numSegs==7){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 		      			
        	}	
    		else if (numSegs==8){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	
    		else if (numSegs==9){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
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
		
		// Generate the object based on the instruction set
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}

	/***************************************************************************************
	 * GENERATE THUMB
	 * 
	 * This generates a Thumbs
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateThumb(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateThumb");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Arm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Arm.
		if (currentPoints == null )
		{
			double circumference = 0.25;
    		
			double x =  -8.0;
    		double y =  -10.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		 
			if (parentID.equals("Thumb:01")) {
				
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.75, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.50, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.25, -1.0, 0.0);
				}
				else {
        			bioInstruct.setTransType(2);
        			bioInstruct.setTranslateMatrix(-0.25, -1.0, 0.0);
        		}
    	    
			}
			else if (parentID.equals("Thumb:02")){
				// Extend out from the terminus of the Knee
				if (numSegs==0){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-0.75, -1.0, 0.0);
				}
				else if (numSegs==1){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-0.50, -1.0, 0.0);
				}
				else if (numSegs==2){
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(0.25, -1.0, 0.0);
				}
				else
				{
					bioInstruct.setTransType(2);
					bioInstruct.setTranslateMatrix(-0.25, -1.0, 0.0);
				}
			}
				
		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the Thumb
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	

	/***************************************************************************************
	 * GENERATE ARM
	 * 
	 * This generates an Arm
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateArm(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateArm");
		
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		double circumference = 1.8;
		
		// We can generate the Arm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Arm.
		if (currentPoints == null )
		{
			double x =  -8.0;
    		double y =  -10.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 10;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
        	} 
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);       			     			
    		}
    		else if (numSegs==6){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     				      			
    		}		
    		else if (numSegs==7){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 		      			
        	}	
    		else if (numSegs==8){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	    			
    		}	       		
       		else if (numSegs==9){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}
    		
    		
       		else if (numSegs==10){
       			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);       			
    		}	       		
    		
    		
    		
       		else if (numSegs==11){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
       		else if (numSegs==12){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	 
    		
    		
    		
       		else if (numSegs==13){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
       		else if (numSegs==14){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
       		else if (numSegs==15){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
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
		
		// Generate the Arm
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE ELBOW
	 * 
	 * This generates a Elbow
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/  	
	   	  	
	public int generateElbow(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateElbow");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Elbow alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null )
		{
			double circumference = 1.0;
	    	
			double x =  -8.0;
    		double y =  -20.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 3;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// 1 segment for my 1-unit Elbow
    		if (numSegs==0){
     			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		
    		
    		
    		else if (numSegs==3){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	} 
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
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
		
		// Generate the Wrist
		//DBUtils.generateFacedComponents(componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	/***************************************************************************************
	 * GENERATE FOREARM
	 * 
	 * This generates a forearm
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateForeArm(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateForeArm");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null )
		{
			double circumference = 1.4;
		    
			double x =  -8.0;
    		double y =  -20.0;
    		double z =  -1.0;
			
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
		
		
		// Base Default ForeArm length of 10 inches
		// Build 9 segments of 1 unit each
		// Double Segments on Zoon
		int nMaxSegs = 10;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		if (numSegs==0){
     			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
         	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	} 
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 	      			     			
    		}
    		else if (numSegs==6){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		      			     				      			
    		}		
    		else if (numSegs==7){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 		      			
        	}	
    		else if (numSegs==8){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);     			
    		}	       		
       		else if (numSegs==9){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
    		
    		
    		
       		else if (numSegs==10){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	 
       		else if (numSegs==12){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	 
       		else if (numSegs==13){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
       		else if (numSegs==14){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	       		
       		else if (numSegs==15){
    			bioInstruct.setPivotPoint(3);
    			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setTransType(2);
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
		
		// Generate the ForeArm
		//DBUtils.generateFacedComponents(componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	


	/***************************************************************************************
	 * GENERATE WRIST
	 * 
	 * This generates a wrist
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateWrist(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateWrist");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null )
		{
			double circumference = 1.0;
	    	
			double x =  -8.0;
    		double y =  -20.0;
    		double z =  -1.0;
			
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
		
		int nMaxSegs = 1;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// 1 segment for my 1-unit wrist
    		if (numSegs==0){
     			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
    		
    		
       		else if (numSegs==1){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	} 
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
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
		
		// Generate the Wrist
		//DBUtils.generateFacedComponents(componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	

  	/***************************************************************************************
	 * GENERATE HAND
	 * 
	 * This generates a wrist
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateHand(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateHand");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null )
		{
			double circumference = 2.0;
	    	
			double x =  -8.0;
    		double y =  -20.0;
    		double z =  -1.0;
			
			// Create an elongated octogon	
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
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// 5 segment for my 5-unit hand
    		if (numSegs==0){
     			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	} 
    		
    		
    		
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
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
		
		// Generate the Hand
		//DBUtils.generateFacedComponents(componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	

	/***************************************************************************************
	 * GENERATE PALM
	 * 
	 * This generates a wrist
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generatePalm(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GeneratePalm");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		
		// We can generate the Palm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null )
		{
			double radius = 2.0;	    	
			double[] startPos = {9.0,-31.0,-0.25};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}

		
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 5;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
       		         
    		// 5 segment for my 5-unit hand
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.35, 1.0, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
    		}
       		else if (numSegs==1){
       			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 
        	}
    		else if (numSegs==4){
      			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
        	} 
    		
    		
    		
    		else if (numSegs==5){
    			bioInstruct.setTransType(3);
    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
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
		
		// Generate the Palm
		//DBUtils.generateFacedComponents(componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	
	
	/***************************************************************************************
	 * GENERATE LARGE INTESTINE
	 * 
	 * This generates a large intestine in the space given by the abdominal cavity
	 * It starts at the terminus of the Small intestine
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateLargeIntestine(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateLargeIntestine");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		int returnCode = 0;

 		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null) {
			double radius = 0.4;
			double[] startPos = {-2.0,-24.0, -4.00};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
		int nMaxSegs = 57;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();

			
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.15);	
    		}
     		else if (numSegs==1){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.25, 1.25);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.0);
    		}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.25, 0.0, 0.0);
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}	
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		} 	
    		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.5, -0.05);	
    		}
    		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.75, -0.01);	
    		}
    		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.75, 0.0);	
    		}
    		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.75, 0.0);	
    		}
    		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.75, 0.03);	
    		}
    		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.750, 0.05);	
    		}
    		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, 0.750, -0.10);	
    		}	
    		else if (numSegs==13){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	      			
        	}
    		else if (numSegs==14){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	      			
    		}	
    		else if (numSegs==15){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	   
    		}
    		else if (numSegs==16){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, -0.15, 0.0);	
    		}
    		else if (numSegs==17){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, -0.05, 0.05);	
    		}    		
    		else if (numSegs==18){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, -0.15, 0.0);	
    		}
    		else if (numSegs==19){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, -0.10, -0.05);	 
    		}
    		else if (numSegs==20){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, 0.0, -0.10);		
    		}
    		else if (numSegs==21){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.65, 0.0, 0.0);	
    		}
    		else if (numSegs==22){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.50, 0.10, -0.25);	
    		}
    		else if (numSegs==23){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, 0.15, 0.0);	
        	}
       		else if (numSegs==24){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, 0.05, -0.15);	
    		}
       		else if (numSegs==25){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, 0.15, 0.0);	
    		}
       		else if (numSegs==26){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.75, 0.5, -0.05);	
    		}
       		else if (numSegs==27){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.50, 0.0, -0.10);	
    		}    		
    		else if (numSegs==28){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}    
    		else if (numSegs==29){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}  		
    		else if (numSegs==30){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}  
    		else if (numSegs==31){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}  
    		else if (numSegs==32){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}  
    		else if (numSegs==33){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.05, -0.750, 0.0);
    		} 		
    		else if (numSegs==34){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, -0.75, 0.0);
    		} 		
    		else if (numSegs==35){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-0.05, -0.750, 0.0);
    		} 		
    		else if (numSegs==36){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-0.15, -0.750, 0.0);
    		} 	
    		else if (numSegs==37){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.10, -0.750, 0.0);
    		} 	    			
       		else if (numSegs==38){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}    
    		else if (numSegs==39){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}  		
    		else if (numSegs==40){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}  
    		else if (numSegs==41){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-0.75, 0.0, 0.0);
    		} 		
    		else if (numSegs==42){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-0.75, 0.0, 0.15);
    		}	
    		else if (numSegs==43){
       			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.20);
    		} 		
    		else if (numSegs==44){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.10);
    		}	    		
    		else if (numSegs==45){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==46){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==47){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==48){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, -0.45, -0.75);
    		}	 
    		else if (numSegs==49){
    			bioInstruct.setTransType(Constants.TRANSLATE);
       			bioInstruct.setTranslateMatrix(0.0, -0.55, -0.75);
    		}	 
    		else if (numSegs==50){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}	 
    		else if (numSegs==51){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}	 
     		else if (numSegs==52){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}	 
    		else if (numSegs==53){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.75, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.75, -0.20);
    		}	 
    		else if (numSegs==54){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.75, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.75, -0.150);
    		}	 
    		else if (numSegs==55){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 0.75, 0.75);
    			bioInstruct.setTranslateMatrix(0.0, -0.5, -0.150);
    		}	 
    		else if (numSegs==56){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.85, 0.70, 0.70);
    			bioInstruct.setTranslateMatrix(0.0, -0.40, -0.150);
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
		
		// Generate the Large Intestine
		//System.out.println("Generating ComponentRows: " + componentID + "  " + componentName + " " + parentID);

		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}
	
	/***************************************************************************************
	 * GENERATE SMALL INTESTINE
	 * 
	 * This generates a small intestine in the space given by the abdominal cavity
	 * It starts at the terminus of the Stomach chamber and squiggles like a snake
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateSmallIntestine(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateSmallIntestine");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;

 		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null) {
			double radius = 0.4;
			double[] startPos = {-2.0,-24.0, -4.00};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		
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
		
		int nMaxSegs = 252; 
		for (int numSegs=0; numSegs<nMaxSegs;numSegs=numSegs+1) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			BioMightOrientation orientation = new BioMightOrientation(0.0, 0.0, -1.0, 90);
		
			// Leave sphincter going towards wall
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.5, 0.15, 0.0);	
    		}
     		else if (numSegs==1){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.25, 0.075, 0.0);	
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
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.25, -0.25, 0.0);	
    		} 
     		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.25, -0.75, 0.0);	
    		}
     		else if (numSegs==6){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(40);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.20, -0.75, -0.20);	
    		}
    		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.15, -0.5, -0.25);
    		}		
     		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(35);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.02, -0.20);	
    		}
     		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.1, -0.10);	
    		}
     		else if (numSegs==13){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(15);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		// TOP Line
     		else if (numSegs==14){
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.5, 0.22, 0.00);
    		}
     		else if (numSegs==15){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.15, -0.05);	
    		}
    		else if (numSegs==16){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.20, 0.0);	
    		}
    		else if (numSegs==17){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.12, 0.0);	
    		}	
    		else if (numSegs==18){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.1, 0.0);	
    		}
    		else if (numSegs==19){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.14, 0.15);	
    		}
    		else if (numSegs==20){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.0);	
    		}
    		else if (numSegs==21){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.250, 0.15);	
    		}
    		else if (numSegs==22){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.1, 0.15);	
    		}
    		else if (numSegs==23){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==24){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}    		
    		else if (numSegs==25){
     			
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.10, -0.250, 0.0);	
    		}
    		else if (numSegs==26){
     			
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.16, -0.250, 0.0);	
    		}
    		else if (numSegs==27){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
     		else if (numSegs==28){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		// Second Half line
    		else if (numSegs==29){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, -0.15, 0.0);
    		}
    		else if (numSegs==30){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, -0.10, 0.0);
    		}
    		else if (numSegs==31){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.0, -0.20);	
    		}
    		else if (numSegs==32){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.05, -0.35);
    		}
    		else if (numSegs==33){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, 0.0, -0.35);
    		}
    		else if (numSegs==34){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, 0.0, -0.40);
    		}	
    		else if (numSegs==35){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==36){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}	
    		else if (numSegs==37){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.01, -0.01, 0.05);		
    		}
    		else if (numSegs==38){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.02, -0.25, 0.15);		
    		}	
     		else if (numSegs==39){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==40){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		
    		// Third Half line
    		else if (numSegs==41){
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.05, 0.0);		
    		}
    		else if (numSegs==42){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.10, 0.0);		
    		}
     		else if (numSegs==43){
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.0);	
    		}
     		else if (numSegs==44){
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.15, 0.0);		
    		}	
     		else if (numSegs==45){
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.25, 0.0);			
    		}
     		else if (numSegs==46){
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.35, 0.0);			
    		}
    		else if (numSegs==47){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}	
     		else if (numSegs==48){
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
     		else if (numSegs==49){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.1, -0.250, -0.0);	
    		}	
    		
     		else if (numSegs==50){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.05, -0.250, 0.0);	
    		}
    		else if (numSegs==51){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.2, -0.250, 0.0);	
    		}
    		else if (numSegs==52){
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
      		else if (numSegs==53){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}  		
       		else if (numSegs==54){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.0, 0.25);		
    		} 
      		else if (numSegs==55){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.35);		
    		}		
    		else if (numSegs==56){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.20, 0.45);		
    		}			
      		else if (numSegs==57){
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.35, 0.35);		
    		}
    		else if (numSegs==58){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.45, 0.05);		
    		}		
    		else if (numSegs==59){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.0);		
    		}			
      		else if (numSegs==60){
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.0, 0.0);		
    		}	
      		else if (numSegs==61){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==62){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
      		else if (numSegs==63){
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);		
    		}
      		else if (numSegs==64){
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);		
    		}		
       		else if (numSegs==65){
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==66)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==67)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, -0.05, 0.0);			
    		}		
    		else if (numSegs==68)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.05, 0.0);		
    		}
    		else if (numSegs==69)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.10, 0.25);		
    		}
      		else if (numSegs==70)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.0, 0.35);	
    		}	
      		else if (numSegs==71)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.0, 0.05);	
    		}
      		else if (numSegs==72)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, -0.10, -0.20);	
    		}    			
      		else if (numSegs==73)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.35, -0.20);		
    		} 		
       		else if (numSegs==74)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.40, -0.35);	
    		}	
      		else if (numSegs==75)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.35, -0.10);	
    		}
    		else if (numSegs==76)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.0);		
    		}
    		// Going Right, heading down
       		else if (numSegs==77)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
      		else if (numSegs==78)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		} 
      		else if (numSegs==79)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.25, -0.15);				
    		} 	
      		else if (numSegs==80)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.50, -0.15);		
    		} 	  		
      		else if (numSegs==81)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 	
    		else if (numSegs==82)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}	
      		else if (numSegs==83)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.25, 0.25);
    		}
    		//******************************
    		// BOTTOM ROW
    		//******************************
      		else if (numSegs==84)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.20, 0.25);	
  	
    		}
     		else if (numSegs==85)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.25, 0.0);	
  	
    		} 
      		else if (numSegs==86)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.0);	
  
    		}
      		else if (numSegs==87)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, -0.05, -0.10);		
    		}
       		else if (numSegs==88)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, -0.45, -0.35);		
    		} 		
       		else if (numSegs==89)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, -0.35, 0.45);	
    		}
      		else if (numSegs==90)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, -0.15, 0.35);
    		}
    		else if (numSegs==91)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, -0.15, 0.20);	
    		}
    		else if (numSegs==92)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, 0.0);		
    		}
    		else if (numSegs==93)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, -0.25);			
    		}
    		else if (numSegs==94)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, -0.15);		
    		}
    		else if (numSegs==95)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.10, -0.25);		
    		}
    		else if (numSegs==96)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, -0.15);			
    		}
    		else if (numSegs==97)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.50, 0.0, -0.20);		
    		}
       		else if (numSegs==98)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
       		else if (numSegs==99)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
    		else if (numSegs==100)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.10, 0.0);			
    		}	
    		else if (numSegs==101)
      		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.150, 0.0);		
    		}
    		else if (numSegs==102)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==103)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(2);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==104)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.250, 0.0, -0.20);		
    		}	
    		else if (numSegs==105)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.250, 0.0, -0.20);	
    		}
    		else if (numSegs==106)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, -0.05, -0.20);	
    		}
    		else if (numSegs==107)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.0, -0.20);		
    		}
    		else if (numSegs==108)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
    		}	
    		else if (numSegs==109)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}	
    		else if (numSegs==110)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==111)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.25);		
    		}
    		else if (numSegs==112)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==113)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}
    		else if (numSegs==114)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==115)
    		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, 0.0, -0.10);
    		}
    		else if (numSegs==116)
    		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.5, -0.15, 0.20);
    		}
     		else if (numSegs==117)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, 0.0, 0.25);	
    		}
    		// Rotate Up as we heading upwards towards the stomach
     		else if (numSegs==118)
    		{
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==119)
    		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==120)
    		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==121)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.10, 0.10);
    		}
    		// Rotate Backwards over X - we are heading towards the back
    		else if (numSegs==122)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}    		
    		else if (numSegs==123)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
     		}
    		else if (numSegs==124)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
      		}
    		else if (numSegs==125)
      		{	// 
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.50);		
    		}
    		// Rotate around Y we are making a righthand turn
    		else if (numSegs==126)
    		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==127)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);
    		}
    		else if (numSegs==128)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==129)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.15);		
    		}
    		else if (numSegs==130)
    		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.20);
    		}
    		else if (numSegs==131)
    		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.0);	
    		}
    		else if (numSegs==132)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
    		else if (numSegs==133)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
      		else if (numSegs==134)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}  
      		else if (numSegs==135)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}  	
     		else if (numSegs==136)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		} 
     		else if (numSegs==137)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==138)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.10);			
    		} 
     		else if (numSegs==139)
    		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.45, 0.20);
    		}	
     		else if (numSegs==140)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.50, 0.15);		
    		} 
     		else if (numSegs==141)
    		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.10, 0.0, 0.0);
    		}
      		else if (numSegs==142)
    		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);	
    		}
     		else if (numSegs==143)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		} 
    		else if (numSegs==144)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		} 				
    		else if (numSegs==145)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
    		else if (numSegs==146)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
    		else if (numSegs==147)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
      		else if (numSegs==148)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.10, -0.10);		
    		} 
    		else if (numSegs==149)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.25, 0.0, 0.20);		
    		} 
    		else if (numSegs==150)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.20);		
    		} 
    		else if (numSegs==151)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
    		else if (numSegs==152)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
    		else if (numSegs==153)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
    		else if (numSegs==154)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
    		else if (numSegs==155)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
    		else if (numSegs==156)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
      		else if (numSegs==157)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.00, -0.10, 0.25);		
    		}
      		else if (numSegs==158)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, 0.05);		
    		}
      		else if (numSegs==159)
      		{	
       			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==160)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}    		
      		else if (numSegs==161)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
       		else if (numSegs==162)
      		{	
       			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==163)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}    		
      		else if (numSegs==164)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
       		else if (numSegs==165)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.15, 0.15);	
    		}
      		else if (numSegs==166)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.10, 0.0);		
    		}    		
      		else if (numSegs==167)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.00, 0.0, 0.0);		
    		}
      		else if (numSegs==168)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}	
     		else if (numSegs==169)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
     		else if (numSegs==170)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==171)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.10, 0.0);		
    		}
    		else if (numSegs==172)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);	
    		}	
     		else if (numSegs==173)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
     		else if (numSegs==174)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==175)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, -0.05, 0.0);		
    		}
      		else if (numSegs==176)
      		{	
       			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.05, 0.0);		
    		}
     		else if (numSegs==177)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.05, 0.0);			
    		}
       		else if (numSegs==178)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==179)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==180)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
     		else if (numSegs==181)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.20, 0.0);			
    		}    				
       		else if (numSegs==182)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
       		else if (numSegs==183)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
       		else if (numSegs==184)
      		{	
     			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(30);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}
      		else if (numSegs==185)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.10, 0.0);			
    		}    				
    		else if (numSegs==186)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, -0.05, 0.0);			
    		}    				
    		else if (numSegs==187)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.0);			
    		}    				
    		else if (numSegs==188)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}   	     	
    		else if (numSegs==189)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}    		
    		else if (numSegs==190)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==191)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==192)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==193)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-30);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==194)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		}    		
    		else if (numSegs==195)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
     			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		} 
    		else if (numSegs==196)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		} 
       		else if (numSegs==197)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.60, 0.0, 0.0);			
    		}
       		else if (numSegs==198)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		} 
       		else if (numSegs==199)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		} 
       		else if (numSegs==200)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 1.0, 0.0);			
    		} 
       		else if (numSegs==201)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
     			bioInstruct.setTranslateMatrix(0.0, 1.0, 0.0);				
    		}
    		else if (numSegs==202)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==203)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
       		else if (numSegs==204)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		} 
       		else if (numSegs==205)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.333, 0.0, 0.0);			
    		} 
    		else if (numSegs==206)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==207)
      		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);		
    		}
      		else if (numSegs==208)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.15, 0.0);			
    		} 
      		else if (numSegs==209)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
      		else if (numSegs==210)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}     		
      		else if (numSegs==211)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.40, 0.0, 0.0);			
    		} 
      		else if (numSegs==212)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
    		else if (numSegs==213)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}  		
     		else if (numSegs==214)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.15, 0.0, -1.00);			
    		} 
     		else if (numSegs==215)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -0.250);			
    		} 
    		else if (numSegs==216)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(47);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		} 
    		else if (numSegs==217)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(47);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);		
    		}
     		else if (numSegs==218)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		} 
      		else if (numSegs==219)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}  
      		else if (numSegs==220)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}  
    		else if (numSegs==221)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.15, 0.0);			
    		} 
      		else if (numSegs==222)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}  
      		else if (numSegs==223)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
      		else if (numSegs==224)
      		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.25, 0., 0.0);			
    		} 
      		else if (numSegs==225)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}  
      		else if (numSegs==226)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
      		else if (numSegs==227)
     		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);			
    		} 
      		else if (numSegs==228)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);	
     			bioInstruct.setOrientation(orientation);			
    		}  
      		else if (numSegs==229)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}     	
    		else if (numSegs==230)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}
    		else if (numSegs==231)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(1.0, 0.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}
     		else if (numSegs==232)
     		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);			
    		} 
     		else if (numSegs==233)
     		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, -1.0);			
    		}     		
     		else if (numSegs==234)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}
     		else if (numSegs==235)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);			
    		}    		
     		else if (numSegs==236)
     		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);			
    		} 
     		else if (numSegs==237)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		} 
     		else if (numSegs==238)
      		{	
      			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);			
    		}     		
    		else if (numSegs==239)
     		{	
     			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.150, 0.0);			
    		}   			
    		else if (numSegs==240)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);				
    		} 	
      		else if (numSegs==241)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(4);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);				
    		}  		
      		else if (numSegs==242)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);				
    		} 
    		else if (numSegs==243)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);				
    		} 
     		else if (numSegs==244)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, 0.0, 0.0);				
    		} 
     		else if (numSegs==245)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);				
    		}  	   		
    		else if (numSegs==246)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);				
    		} 		
    		else if (numSegs==247)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 1.0);				
    		}
    		else if (numSegs==248)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.0, 0.65);				
    		}     		
      		else if (numSegs==249)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);				
    		}   		
      		else if (numSegs==250)
     		{	
    			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(-45);	
    			bioInstruct.setPivotPoint(6);	
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
     			bioInstruct.setOrientation(orientation);				
    		}  
    		else if (numSegs==251)
     		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);				
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
	 * GENERATE DUODENUM
	 * 
	 * This code will section off a Duodenum
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateDuodenum(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateDudenum");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;

 		
		if (currentPoints == null) {
			double radius = 0.4;
			double[] startPos = {-2.0,-24.0, -4.00};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		
		
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
		
		// Make 7 feet of Duo
		int nMaxSegs = 84;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==1){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.45, 0.0);	
    		}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);
    		}	
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);
    		}
     		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);
    		} 
     		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, -0.50, 0.0);	
    		}
    		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}		
     		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);		
    		}
     		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);		
    		}
     		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.0, 0.0);	
    		}
     		else if (numSegs==13){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.15, 0.0);	
    		}
      		else if (numSegs==14){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.25, 0.0);	
    		}
    		else if (numSegs==15){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==16){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.650, -0.16);	
    		}
    		else if (numSegs==17){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.0, 0.850, -0.25);	
    		}
    		else if (numSegs==18){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-45.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==19){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-45.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==20){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-22.5);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==21){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.25, -1.0, -0.15);	
    		}
    		else if (numSegs==22){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==23){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
     		else if (numSegs==24){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-45.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
     		else if (numSegs==25){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.50, 0.15);	
    		}
    		else if (numSegs==26){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==27){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(45.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==28){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.15, -1.0, 0.35);	
    		}
    		else if (numSegs==29){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==30){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}	
    		else if (numSegs==31){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==32){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
       		else if (numSegs==33){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==34){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(1.00, 0.75, 0.35);		
    		}
    		else if (numSegs==35){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==36){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.00, 0.75, 0.25);		
    		}	
     		else if (numSegs==37){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==38){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==39){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==40){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.30);		
    		}
     		else if (numSegs==41){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.00, 0.0, 0.15);		
    		}
     		else if (numSegs==42){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.00, -0.25, -0.25);		
    		}	
     		else if (numSegs==43){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}	
     		else if (numSegs==44){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==45){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==46){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.00, -0.250, 0.15);		
    		}	
    		else if (numSegs==47){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}	
     		else if (numSegs==48){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==49){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}		
     		else if (numSegs==50){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(15.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}		
    		else if (numSegs==51){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.35, -0.15);		
    		}
    		else if (numSegs==52){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.20, 0.10);		
    		}
      		else if (numSegs==53){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.30, 0.10);		
    		}  		
       		else if (numSegs==54){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.10, 0.0);		
    		} 
      		else if (numSegs==55){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.15, 0.0);		
    		}		
    		else if (numSegs==56){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, -0.35, 0.10);		
    		}			
      		else if (numSegs==57){
    			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}		
      		else if (numSegs==58){
    			
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==59){
    			
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==60){
    			
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==61)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}	
      		else if (numSegs==62)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==63)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==64)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.30, -0.15);		
    		}
     		else if (numSegs==65)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.35, -0.20);		
    		}
      		else if (numSegs==66)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.15, 0.15);		
    		}
    		else if (numSegs==67)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.10, -0.25);		
    		}		
    		else if (numSegs==68)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, -0.35);		
    		}
    		else if (numSegs==69)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.20, -0.40);		
    		}
      		else if (numSegs==70)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}	
      		else if (numSegs==71)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==72)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}    		
    	
      		else if (numSegs==73)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.50, -0.35);		
    		} 		
       		else if (numSegs==74)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}	
      		else if (numSegs==75)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		else if (numSegs==76)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		
       		else if (numSegs==77)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.35, -0.40);		
    		} 
      		else if (numSegs==78)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, -0.25, 0.0);		
    		} 
      		else if (numSegs==79)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.0, 0.10);		
    		} 	
      		else if (numSegs==80)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.750, 0.0, 0.20);		
    		} 	
      		else if (numSegs==81)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.250, 0.0, 0.10);		
    		} 	
    		else if (numSegs==82)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}	
      		else if (numSegs==83)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
      		    		
    		
      		else {
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.00, -1.0, 0.0);		
    		}
    		
    		// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}
		
		// Generate the Duodenum
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, componentID, componentType, componentName, parentID, currentPoints, bioMightInstructSet);
		
		return returnCode;
	}

	
	/***************************************************************************************
	 * GENERATE JUJENUM
	 * 
	 * This generates a Jujenum in the space given by the abdominal cavity
	 * It starts at the terminus of the Stomach chamber and squiggles like a snake
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public int generateJujenum(String componentID, String componentType, String componentName, String parentID, double[][] currentPoints) 
		throws DataException, DataSecurityException
	{	
		//System.out.println("GenerateJujenum");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;

 		
		// We can generate the ForeArm alone, or when connected
		// The current points passed into the equation are assumed
		// to come from the Elbow.
		if (currentPoints == null) {
			double radius = 0.4;
			double[] startPos = {-2.0,-24.0, -4.00};
			currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		}
		
		
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
		
		int nMaxSegs = 138;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
       		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-1.0, 0.0, 0.0);	
    		}

      		else if (numSegs==1)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
     		else if (numSegs==2)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.25, 0.25);		
    		} 
      		else if (numSegs==3)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
      		else if (numSegs==4)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, 0.15);		
    		}
       		else if (numSegs==5)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.20);		
    		} 		
       		else if (numSegs==6)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.05, 0.15);		
    		} 
      		else if (numSegs==7)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==8)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.15);		
    		}
    		else if (numSegs==9)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.15, 0.20);		
    		}
    		else if (numSegs==10)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.10, 0.25);		
    		}
    		else if (numSegs==11)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.00, 0.20);		
    		}
    		else if (numSegs==12)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.00, 0.0);		
    		}
    		else if (numSegs==13)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.00, -0.05);		
    		}
    		else if (numSegs==14)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, -0.10);		
    		}
       		else if (numSegs==15)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, 0.10, 0.0);		
    		}
       		else if (numSegs==16)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, 0.10);		
    		}
    		else if (numSegs==17)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.750, -0.05, -0.10);		
    		}	
    		
    		else if (numSegs==18)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==102)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==103)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
     		else if (numSegs==104)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.25, 0.0);		
    		}	
    		else if (numSegs==105)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==106)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==107)
      		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==108)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.05, -0.15);		
    		}	
    		else if (numSegs==109)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.30, 0.10, 0.0);		
    		}	
    		else if (numSegs==110)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.45, 0.0, 0.0);		
    		}
    		else if (numSegs==111)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.0, 0.10);		
    		}
    		else if (numSegs==112)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.40, 0.02, -0.02);		
    		}
    		else if (numSegs==113)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.25, 0.02, -0.02);				
    		}
    		else if (numSegs==114)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==115)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==116)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
     		else if (numSegs==117)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.0, 0.45, 0.0);		
    		}
     		else if (numSegs==118)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==119)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==120)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(15.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(3);	
    		}
    		else if (numSegs==121)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, 0.25, -0.25);		
    		}
    		else if (numSegs==122)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.75, -0.06, -0.35);		
    		}
    		else if (numSegs==123)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.70, -0.30, -0.25);		
    		}
    		else if (numSegs==124)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.60, -0.30, -0.25);		
    		}
    		else if (numSegs==125)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(-0.60, -0.45, -0.20);		
    		}
    
    		else if (numSegs==126)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==127)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==128)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==129)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.05, 0.45, 0.0);		
    		}
    		else if (numSegs==130)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==131)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(-30.0);	      			
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
    			bioInstruct.setPivotPoint(7);	
    		}
    		else if (numSegs==132)
    		{	
    			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.20, 0.0);
    		}
    		else if (numSegs==133)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.40, 0.0);		
    		}
      		else if (numSegs==134)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, 0.45, 0.0);		
    		}  		
     		else if (numSegs==135)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.75, -0.20, 0.0);		
    		}  	
     		else if (numSegs==136)
      		{	
      			bioInstruct.setTransType(Constants.TRANSLATE);
    			bioInstruct.setTranslateMatrix(0.50, -0.10, 0.0);		
    		} 
     		else if (numSegs==137)
    		{	
      			bioInstruct.setTransType(Constants.ROTATE);
    			bioInstruct.setTheta(30.0);	      			
     			bioInstruct.setRotateVector(0.0, 1.0, 0.0);
    			bioInstruct.setPivotPoint(3);	
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
	 * GENERATE THIGH
	 * 
	 * This generates a Thigh
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int generateThigh(String startID,
			String componentType, String componentName, String componentID,
			String parentID, double[][] currentPoints) throws DataException, DataSecurityException 
	{
		//System.out.println("GenerateThigh");
		
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
		ArrayList mySqlList= new ArrayList();
		int returnCode = 0;
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();

		
		if (parentID.equals("Thigh:01")) {
			
			// We can generate the Arm alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the Thigh.
			if (currentPoints == null )
			{
				double radius = 2.0;
				double[] startPos = {4.0, -30.0, 0.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			}
			
	
			
			int nMaxSegs = 13;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	       		         
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.05);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0); 
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.025, 1.0, 1.025);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0); 
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.025, 1.0, 1.025);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0); 
	        	}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
	        	} 
	    		else if (numSegs==5){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 0.98);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0);       			     			
	    		}
	    		else if (numSegs==6){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.99);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0); 	      			     				      			
	    		}		
	    		else if (numSegs==7){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 0.98);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0); 	 		      			
	        	}	
	    		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 0.98);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0);    			
	    		}	       		
	       		else if (numSegs==9){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.97, 1.0, 0.97);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0);      			
	    		}	       		
	       		else if (numSegs==10){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.95, 1.0, 0.95);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);       			
	    		}	       		
	       		else if (numSegs==11){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.93, 1.0, 0.93);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);     			
	    		}	       		
	       		else if (numSegs==12){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);   			
	    		}	     
	    		
	    		
	       		else if (numSegs==13){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);  			
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
		else if (parentID.equals("Thigh:02")) {	
			
			
			// We can generate the Arm alone, or when connected
			// The current points passed into the equation are assumed
			// to come from the Thigh.
			if (currentPoints == null )
			{
				double radius = 2.0;
				double[] startPos = {4.0, -30.0, 0.0};
				currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			}
			
			int nMaxSegs = 13;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			
	    		// Extend out from the terminus of the Knee
	    		if (numSegs==0){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);
	    		}
	       		else if (numSegs==1){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.05);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0); 
	           	}
	    		else if (numSegs==2){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.05);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0); 
	    		}
	    		else if (numSegs==3){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(1.05, 1.0, 1.05);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0); 
	        	}
	    		else if (numSegs==4){
	    			bioInstruct.setTransType(Constants.TRANSLATE);
	    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
	        	} 
	    		else if (numSegs==5){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.99);
	    			bioInstruct.setTranslateMatrix(-0.1, -1.0, 0.0);       			     			
	    		}
	    		else if (numSegs==6){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.99);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0); 	      			     				      			
	    		}		
	    		else if (numSegs==7){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.99, 1.0, 0.99);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0); 	 		      			
	        	}	
	    		else if (numSegs==8){
	    			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.98, 1.0, 0.98);
	    			bioInstruct.setTranslateMatrix(-0.05, -1.0, 0.0);    			
	    		}	       		
	       		else if (numSegs==9){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.97, 1.0, 0.97);
	    			bioInstruct.setTranslateMatrix(0.05, -1.0, 0.0);      			
	    		}	       		
	       		else if (numSegs==10){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.95, 1.0, 0.95);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0);       			
	    		}	       		
	       		else if (numSegs==11){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.93, 1.0, 0.93);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0);     			
	    		}	       		
	       		else if (numSegs==12){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
	    			bioInstruct.setTranslateMatrix(0.1, -1.0, 0.0);   			
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
		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for ThighEpithelium: " + componentID + "   " + componentType);
		
		return returnCode;
	}
	
	

		/***************************************************************************************
		 * GENERATE KNEE
		 *  
		 * This generates Knee
		 * 
		 * @param key
		 * @param user
		 * @return
		 * @throws DataException
		 * @throws DataSecurityException
		 ***************************************************************************************/
		  	
		public int generateKnee(String startID,
				String componentType, String componentName, String componentID,
				String parentID, double[][] currentPoints) throws DataException, DataSecurityException 
	{	
		//System.out.println("GenerateKnee " + componentID + "   " + parentID);
		
		int bodyID = 1;
		int projectID = 1;
		int returnCode = 0;
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		if (parentID.equals("Knee:01"))
		{
			int nMaxSegs = 4;
			for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
			
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
			   		         
				// Extend out from the terminus of the Knee
	       		if (numSegs==0){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.93, 1.0, 0.93);
	    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
	    		}	       		
	       		else if (numSegs==1){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.92, 1.0, 0.92);
	    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
	    		}	       				
	       		else if (numSegs==2){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
	    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
	    		}
	       		else if (numSegs==3){
	       			bioInstruct.setTransType(Constants.SCALE);
	    			bioInstruct.setScaleMatrix(0.85, 1.0, 0.85);
	    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);      			
	    		}
		   		    
				// Add the instruction into the instruction set
				bioMightInstructSet.addElement(bioInstruct);
				
			}
		}
		else if (parentID.equals("Knee:02"))
			{
				int nMaxSegs = 4;
				for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
				
					// Create a place for an instruction 
					BioMightInstruction bioInstruct = new BioMightInstruction();
				   		         
					// Extend out from the terminus of the Knee
		       		if (numSegs==0){
		       			bioInstruct.setTransType(Constants.SCALE);
		    			bioInstruct.setScaleMatrix(0.93, 1.0, 0.93);
		    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 
		    		}	       		
		       		else if (numSegs==1){
		       			bioInstruct.setTransType(Constants.SCALE);
		    			bioInstruct.setScaleMatrix(0.92, 1.0, 0.92);
		    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
		    		}	       				
		       		else if (numSegs==2){
		       			bioInstruct.setTransType(Constants.SCALE);
		    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
		    			bioInstruct.setTranslateMatrix(0.0, -1.25, 0.0);      			
		    		}	
		       		else if (numSegs==3){
		       			bioInstruct.setTransType(Constants.SCALE);
		    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
		    			bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);      			
		    		}
			   		    
					// Add the instruction into the instruction set
					bioMightInstructSet.addElement(bioInstruct);
					
				}
			}			
	
		// Generate the object based on the instruction set		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for KneeEpithelium: " + componentID + "   " + componentType);
		return (returnCode);
			
	}
	
	/***************************************************************************************
	 * GENERATE CNEMIS
	 * 
	 * This generates a Cnemis
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
		
	public int generateCnemis(String startID,
				String componentType, String componentName, String componentID,
				String parentID, double[][] currentPoints) throws DataException, DataSecurityException 
	{	
		//System.out.println("GenerateCnemis");
		
		int bodyID = 1;
		int projectID = 1;
		int returnCode = 0;
	
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int nMaxSegs = 13;
		for (int numSegs=0; numSegs<nMaxSegs;numSegs++) {
		
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		   		         
    		// Extend out from the terminus of the Knee
    		if (numSegs==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.2, 1.0, 1.2);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
       		else if (numSegs==1){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
           	}
    		else if (numSegs==2){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
    		}
    		else if (numSegs==3){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	
        	}
    		else if (numSegs==4){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.98, 1.0, 0.98);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			
        	} 
    		else if (numSegs==5){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.96, 1.0, 0.96);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	      			     			
    		}
    		else if (numSegs==6){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.94, 1.0, 0.94);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);		      			     				      			
    		}		
    		else if (numSegs==7){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.94, 1.0, 0.94);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);	 		      			
        	}	
    		else if (numSegs==8){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.92, 1.0, 0.92);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);      			
    		}	
    		else if (numSegs==9){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.88, 1.0, 0.88);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0); 			
      		}
    		else if (numSegs==10){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.85, 1.0, 0.85);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}    		
    		else if (numSegs==11){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
    			bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
    		}
    		else if (numSegs==12){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(0.90, 1.0, 0.90);
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
		

		// Generate the object based on the instruction set		
		DBUtils.generateFacedComponents(Constants.QUADRANGLE, startID, componentType, componentName, componentID, currentPoints, bioMightInstructSet);
		//System.out.println("Generating the Rows for CnemisEpithelium: " + componentID + "   " + componentType);
		return (returnCode);
			
	}
	
	
  	
   	/***************************************************************************************
	 * SAVE ANIMATION
	 * 
	 * This method will save the animation/palette data to the database
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int saveAnimation(int projectID, ArrayList bioMightAnimations) 
		throws DataException, DataSecurityException   		
		{	
		////System.out.println("GenerateComponentRows");

  		int returnCode = 0;
  	  
		int bodyID = 1;
		String vertices = "";
		
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
	
		// Get the Current Component ID, as we are updating from there
  		int componentNum = 0;
		String componentBase = "";
		String componentID = "";
		
		// Get the Starting Point based on the value sent into the method
  		try
		{
			////System.out.println("Starting Update at ComponentID: " + startID);
			//componentNum = Integer.parseInt(startID.substring(startID.indexOf(":")+1));
			//componentBase = startID.substring(0,startID.indexOf(":"));
			////System.out.println("Starting at : " + componentBase + "   " + componentNum);
		}
		catch (Exception e) {
			//System.out.println("GenerateComponentRows - Bad Starting Position for Component:" + e.toString());
		} 
		
 		  		             
    	// we are going to get current and next points from the driving routine
		// nextPoints = applyRotation(currentPoints, pivotPoint, theta, rotateVector);
		
		////System.out.println("Instructions for Generata Rows" + bioMightInstructSet.getSize());
		for (int numSegs=0; numSegs<bioMightAnimations.size();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			//BioMightAnimation bioAnimation = bioMightInstructSet.getElement(numSegs);
			////System.out.println("Have Instruction " + bioInstruct.getTransType());
	    	    			
   	       	query =
   	       		"UPDATE biomight.biocomp set vertices = '" + vertices + "' " +
   	       		"where comp_id = '" + componentID + "'";
   	    	////System.out.println("generateRows Update = " + query);
	        		
	        		
   	       	// Decalre Statement and Result set
   	       	boolean bDup = false;
   	       	stmt = null;
   	       	try {
   	       		stmt = con.prepareStatement(query);
   	       		//System.out.println("Query is prepared");
   	       		returnCode = stmt.executeUpdate();
   	       		//System.out.println("Query has executed");
   	       	} catch (Exception e) {
   	       		//System.out.println("There was an exception in DBUtils.generateFacedComponents Update");
   	       		//throw new DataException("Exception during prep of query:" + e.toString());
   	       		bDup = true;
   	       	}
	    
   	       	String boundBox = "0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0,  0.0,0.0,0.0";
   	       	if (bDup || returnCode == 0)
   	       	{	       			
   	       			query =
   	       				"INSERT into biomight.biocomp values(" +
   	       			//	bodyID + "," + projectID + ",'" + componentID + "','" + componentType + 
   	       			//	"','" + componentName + "','" + componentName + "','" + parentID + "','" + boundBox + "','" + vertices + "'," +
   	       				"10, 0,0,0, 1,1,1, 1, 0.25, 0, 0)";  // material, xyz,scale,radius,depth,comp_group, direction
	        	
   	       			try {
   	       				stmt = con.prepareStatement(query);
   	       				//System.out.println("Query is prepared");
   	       				returnCode = stmt.executeUpdate();
   	       				//System.out.println("InsertQry: " + query);
   	       			} catch (Exception e) {
   	       				System.out.println("There was an exception in DBUtils.generateFacedComponents Insert");
   	       				//throw new DataException("Exception during prep of query:" + e.toString());
   	       				bDup = true;
   	        		}	
   	      	}
   	       	else
   	       	{
   	       		//System.out.println("bDup was false");
   	       	}
	     
   	       	// Increment the counter
   	       	componentNum++;
		}
		
			
	// Close it all down now	
	//System.out.println("Closing Connection: " + returnCode);
		
	try {
		if (stmt != null)
			stmt.close();
			con.close();
	} catch (Exception e) {
		System.out.println("Caught in Finally - DBUtils.generateFacedComponents():" + e.toString());	
	}	
	   
		
	return (0);
}



	
	/***************************************************************************************
	 * INSERT COMPONENT HISTORY 
	 * 
	 * This method inserts date into the component history.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
	public int addComponentHistory(String componentID, String componentType, String componentName, String parentID, String X3D) 
		throws DataException, DataSecurityException   		
		{	
		//System.out.println("getComponentHistory");
  		int returnCode = 0; 
		int bodyID = 1;
		int projectID = 1;
		String vertices = "";
		
	
		// Get the connection to the database
		String query ="";
		Connection con = DBUtils.getConnection();
		PreparedStatement stmt = null;
		
		// Get the Current Component ID, as we are updating from there
  		int componentNum = 0;
		String componentBase = "";
		
	
		boolean bDup = false;
		/*
		System.out.println("Inserting the Component History: " + componentNum + "   " +  componentID);  				
   	    query = "UPDATE biomight.biocomp_hst set x3d = '" + X3D + "' " +
   	       	    "where comp_id = '" + componentID + "'";
   	    System.out.println("componentHistory Update = " + query);
	        		
	        		
   	    // Decalre Statement and Result set
   	    boolean bDup = false;
   	    stmt = null;
   	    try {

   	    	SQLXML xmlConnection = con.createSQLXML();
   	    	
   	    	stmt = con.prepareStatement(query);
   	       	//System.out.println("Query is prepared");
   	       	returnCode = stmt.executeUpdate();
   	       	//System.out.println("Query has executed");
   	    } catch (Exception e) {
   	       	System.out.println("There was an exception in inserttRows Update");
   	       	//throw new DataException("Exception during prep of query:" + e.toString());
   	       	bDup = true;
   	    }
	    
		*/
		
   	    String versionID="1";
   	    String boundBox=vertices;
   	    bDup=false;
   	    if (bDup || returnCode == 0)
   	    {
   	    	query =
   	       		"INSERT into biomight.biocomp_hst values(" +
   	       		versionID + "," + bodyID + "," + projectID + ",'" + componentID + "','" + componentType + 
   	       		"','" + componentName + "','" + componentName + "','" + parentID + "','" + boundBox + "'," + 
   	       		vertices + "'," +
   	       		"10, 0,0,0, 1,1,1, 1, 0.25, 0, 0, '"  +X3D+ "')" ; 
	        	
   	       		try {
   	       			stmt = con.prepareStatement(query);
   	       			//System.out.println("Query is prepared");
   	       			returnCode = stmt.executeUpdate();
   	       			//System.out.println("InsertQuery has executed: " + query);
   	       		} catch (Exception e) {
   	      			System.out.println("There was an exception in InsertComponentHistory");
   	      			//throw new DataException("Exception during prep of query:" + e.toString());
   	       			bDup = true;
   	        	}	
   	    }
		
		
   	    // Close it all down now	
   	    //System.out.println("Closing Connection: " + returnCode);
		
   	    try {
   	    	if (stmt != null)
   	    		stmt.close();
   	    		con.close();
   	    } catch (Exception e) {
   	    	System.out.println("Caught in Finally - DBUtils.generateFacedComponents():" + e.toString());	
   	    }	
	
	int status = 0;
	return(status);
}



	/***************************************************************************************
		 * INSERT COMPONENT HISTORY 
		 * 
		 * This method inserts date into the component history.
		 * 
		 * @param key
		 * @param user
		 * @return
		 * @throws DataException
		 * @throws DataSecurityException
		 ***************************************************************************************/
		  	
		public int insertComponentHistory(String componentID, String componentType, String componentName, String parentID, String X3D) 
			throws DataException, DataSecurityException   		
			{	
			//System.out.println("getComponentHistory");
	  		int returnCode = 0; 
			int bodyID = 1;
			int projectID = 1;
			String vertices = "";
			
		
			// Get the connection to the database
			String query ="";
			Connection con = DBUtils.getConnection();
			PreparedStatement stmt = null;
			
			// Get the Current Component ID, as we are updating from there
	  		int componentNum = 0;
			String componentBase = "";
			
		
			boolean bDup = false;
			/*
			System.out.println("Inserting the Component History: " + componentNum + "   " +  componentID);  				
	   	    query = "UPDATE biomight.biocomp_hst set x3d = '" + X3D + "' " +
	   	       	    "where comp_id = '" + componentID + "'";
	   	    System.out.println("componentHistory Update = " + query);
		        		
		        		
	   	    // Decalre Statement and Result set
	   	    boolean bDup = false;
	   	    stmt = null;
	   	    try {
	
	   	    	SQLXML xmlConnection = con.createSQLXML();
	   	    	
	   	    	stmt = con.prepareStatement(query);
	   	       	//System.out.println("Query is prepared");
	   	       	returnCode = stmt.executeUpdate();
	   	       	//System.out.println("Query has executed");
	   	    } catch (Exception e) {
	   	       	System.out.println("There was an exception in inserttRows Update");
	   	       	//throw new DataException("Exception during prep of query:" + e.toString());
	   	       	bDup = true;
	   	    }
		    
			*/
			
	   	    String versionID="1";
	   	    String boundBox=vertices;
	   	    bDup=false;
	   	    if (bDup || returnCode == 0)
	   	    {
	   	    	query =
	   	       		"INSERT into biomight.biocomp_hst values(" +
	   	       		versionID + "," + bodyID + "," + projectID + ",'" + componentID + "','" + componentType + 
	   	       		"','" + componentName + "','" + componentName + "','" + parentID + "','" + boundBox + "'," + 
	   	       		vertices + "'," +
	   	       		"10, 0,0,0, 1,1,1, 1, 0.25, 0, 0, '"  +X3D+ "')" ; 
		        	
	   	       		try {
	   	       			stmt = con.prepareStatement(query);
	   	       			//System.out.println("Query is prepared");
	   	       			returnCode = stmt.executeUpdate();
	   	       			//System.out.println("InsertQuery has executed: " + query);
	   	       		} catch (Exception e) {
	   	      			System.out.println("There was an exception in InsertComponentHistory");
	   	      			//throw new DataException("Exception during prep of query:" + e.toString());
	   	       			bDup = true;
	   	        	}	
	   	    }
			
			
	   	    // Close it all down now	
	   	    //System.out.println("Closing Connection: " + returnCode);
			
	   	    try {
	   	    	if (stmt != null)
	   	    		stmt.close();
	   	    		con.close();
	   	    } catch (Exception e) {
	   	    	System.out.println("Caught in Finally - DBUtils.generateFacedComponents():" + e.toString());	
	   	    }	
		
		int status = 0;
		return(status);
	}	
	
	
}
