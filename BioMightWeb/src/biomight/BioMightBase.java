package biomight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightColor;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.virus.Capsid;
import biomight.virus.CapsidNeck;
import biomight.virus.CapsidTail;
import biomight.virus.DNAPolymerase;
import biomight.virus.GlycoProteinSpikes;
import biomight.virus.LipidEnvelope;
import biomight.virus.MatrixProtein;
import biomight.virus.NucleoCapsid;
import biomight.virus.VirusBasePlate;
import biomight.virus.VirusTailFibers;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class BioMightBase {
	// Exvery Component has a component ID is used to identify itself
	protected String componentID;
	
	// Every Component has a parent component ID
	protected String parentID;

	protected BioMightTransforms bioMightTransforms;
	
	protected BioMightTransform bioMightTransform;
	
	private int level;
	private boolean isTransparent;
	private boolean isVisible;
	private boolean isHighlight;

	// The Mesh
	private String mesh = "";

	// X3D XML
	private String x3D = "";
	
	protected int viewPerspective = 0;
	protected int lod = 0; // Level of Detail - Level of Depth
	protected int hierarchy = 0;
	
	// Holds Block levels that define where one is in the block grid
	// Picture a hominid dissected by the number of cubes in a level, 
	// where level 0 is the whole cube that surronds the human model.
	// BioMight is based on the decimal system and does increments of
	// resolution based upon a 0, 10, 100, 1000, 10,000, progression. 
	// The position in the arraylist defines the level of detail
	private ArrayList xBlocks;
	private ArrayList yBlocks;
	private ArrayList zBlocks;


	// Bounding Sphere
	// The Basic Dimensions that surround the Biological Component in terms of Sphere Geometry
	// The xyz-level specifies the level at which the component can fit in the entirety of one sphere.
	private BigDecimal boundSphereRadius;

	// Bounding Triangular 
	private BigDecimal xApex;
	private BigDecimal yApez;
	private BigDecimal zApex;
	private BigDecimal traingleBase;

	// Set up a position object.
	private BioMightPosition bioMightPosition;
	
	// Set up a material object
	private BioMightMaterial bioMightMaterial;
				
	// Base Image -- These will come from a database
	private String image = "";
	private int imageWidth = 320;
	private int imageHeight = 500;
	
	// Colors
	protected BioMightColor bioMightColor;
	
	// Pixelation
	
	// Store data about the generated object
	protected BioMightGenerate bioMightGenerate;
	
	// Everytime component will have a set of bounding boxes
	// That defines the rough area of where it should lie in the 
	// model that it is comprising
	protected BioMightBoundBox bioMightBoundBox;


	// Each object will have properties and methods.  This could
	//  have been done through introspection, but the list was not
	// ordered well, did not expose or hide elements easily. So
	// it made sense to just implement something simple
	protected ArrayList<BioMightPropertyView> properties;
	protected ArrayList<BioMightMethodView> methods;
	
	protected HashMap materialDDMap = new HashMap();
	protected HashMap textureDDMap= new HashMap();
 	
	// Base Constructor
	public BioMightBase() {
		
		// Set up a base color object in case one is not defined by the
		// object already
		bioMightColor = new BioMightColor(1.0, 1.0, 1.0);
		//xBlocks = new ArrayList(5);
		//yBlocks = new ArrayList(5);
		//zBlocks = new ArrayList(5);
		
		// initialize the properties and methods.  Every object
		// calls an init() methods and properties methods which
		// will fill in these objects with data
		properties = new ArrayList<BioMightPropertyView>(0);
		methods = new ArrayList<BioMightMethodView>(0);

		// Set up a Generate Object,as every generated component will 
		// need an object that can be used to return information about it
		bioMightGenerate = new BioMightGenerate();
		
		// Allocate the Connectors for Bounding Box
		// This allows all the boxes (pieces) to be put together	
		bioMightBoundBox = new BioMightBoundBox();	
		
		
		// Load the textures and materials that will be used in drop down 
		// selection by the user.   Even if I used a Singleton, the data will
		// need to brought into the object to use.
		loadMaterials();
		loadTextures();
	}
	
	// Add a property to the Properties list
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		// Create a property object that is associated with this Component and put it into the proprtyview array		
		String bioPos = "00.00 00.00, 00.00";
		String dimensions = "1.00 1.00, 1.00";
		String propType = Constants.SINGLE_COMPONENT;		
		BioMightPropertyView property = new BioMightPropertyView(componentName, canonicalName, componentRef, componentID, bioPos, dimensions, propType, true);
		properties.add(property);
	}

	
	// Add a property to the Properties 
	protected void initProperty(String componentName, String canonicalName, String componentRef, String compDesc, String componentID, BioMightPosition bioPos, BioMightScale bioScale, BioMightOrientation bioOrientation, String propType, String templates, boolean isViewEnabled) {
		// Create a property object that is associated with this Component and put it into the proprtyview array
		BioMightPropertyView property = new BioMightPropertyView(componentName, canonicalName, componentRef, compDesc, componentID, bioPos, bioScale, bioOrientation, propType, templates, isViewEnabled);
		properties.add(property);
	}

		
	// Add a property to the Properties 
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID, BioMightPosition bioPos, BioMightScale bioScale, BioMightOrientation bioOrientation, String propType, String templates, boolean isViewEnabled) {
		// Create a property object that is associated with this Component and put it into the proprtyview array
		BioMightPropertyView property = new BioMightPropertyView(componentName, canonicalName, componentRef, componentID, bioPos, bioScale, bioOrientation, propType, templates, isViewEnabled);
		properties.add(property);
	}
		

	// Add a property to the Properties 
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID, BioMightPosition bioPos, BioMightScale bioScale, String propType, String templates, boolean isViewEnabled) {
		// Create a property object that is associated with this Component and put it into the proprtyview array
		BioMightPropertyView property = new BioMightPropertyView(componentName, canonicalName, componentRef, componentID, bioPos, bioScale, propType, templates, isViewEnabled);
		properties.add(property);
	}

	
	// Add a property to the Properties 
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID, String bioPos, String dimensions, String propType, boolean isViewEnabled) {
		// Create a property object that is associated with this Component and put it into the proprtyview array
		BioMightPropertyView property = new BioMightPropertyView(componentName, canonicalName, componentRef, componentID, bioPos, dimensions, propType, isViewEnabled);
		properties.add(property);
	}

	
	
	public BioMightGenerate getBioMightGenerate() {
		return bioMightGenerate;
	}

	public void setBioMightGenerate(BioMightGenerate bioMightGenerate) {
		this.bioMightGenerate = bioMightGenerate;
	}
	
		

	// Set up a point array
	public double[] getStartPoints(double x, double y, double z) {
		
		double[] startPos = {x, y, z};
		return (startPos);
	}

	// Set up a point array
	public double[] getEndPoints(double x, double y, double z) {
		
		double[] endPos = {x, y, z};
		return (endPos);
	}

	
	public String getImage()
	{
		return image;
	}

	public String setImage(String newImage)
	{
		return image = newImage;
	}


	// Allows one to set a disease	
	public void setDisease() {
		
	}	

	// Allows one to set a disease	
	public void setInjury() {
	
	}	


	/**
	 * @return
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @return
	 */
	public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param i
	 */
	public void setImageHeight(int i) {
		imageHeight = i;
	}

	/**
	 * @param i
	 */
	public void setImageWidth(int i) {
		imageWidth = i;
	}

	/**
	 * @return
	 */
	public String getMesh() {
		return mesh;
	}

	/**
	 * @param string
	 */
	public void setMesh(String string) {
		mesh = string;
	}

	public int getLevel() {
		return level;
	}





	public void setLevel(int level) {
		this.level = level;
	}


	public String getX3D() {
		return x3D;
	}


	public void setX3D(String x3d) {
		x3D = x3d;
	}


	public BioMightPosition getBioMightPosition() {
		return bioMightPosition;
	}


	public void setBioMightPosition(BioMightPosition bioMightPosition) {
		this.bioMightPosition = bioMightPosition;
	}


	public BioMightColor getBioMightColor() {
		return bioMightColor;
	}

	public void setBioMightColor(BioMightColor bioMightColor) {
		this.bioMightColor = bioMightColor;
	}


	// Get and set the Component ID
	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public String getParentID() {
		return parentID;
	}


	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	
	// Properties
	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}

	// Methods
	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}

	public BioMightBoundBox getBioMightBoundBox() {
		return bioMightBoundBox;
	}

	public void setBioMightBoundBox(BioMightBoundBox bioMightBoundBox) {
		this.bioMightBoundBox = bioMightBoundBox;
	}

	
	public BioMightTransforms getBioMightTransforms() {
		return bioMightTransforms;
	}

	public void setBioMightTransforms(BioMightTransforms bioMightTransforms) {
		this.bioMightTransforms = bioMightTransforms;
	}
	
	public BioMightTransform getBioMightTransform() {
		return bioMightTransform;
	}

	public void setBioMightTransform(BioMightTransform bioMightTransform) {
		this.bioMightTransform = bioMightTransform;
	}

	/******************************************************************************************************************
	 * Get Property Orientation
	 *
	 * 
	 * ****************************************************************************************************************/
	
	public BioMightOrientation getPropertyOrientation(String propertyID) 
	{
		BioMightOrientation bioMightOrientation = new BioMightOrientation();
		{	
			for (int i=0; i<properties.size(); i++)
			{
				BioMightPropertyView propertyView = (BioMightPropertyView) properties.get(i);
				if ( propertyView.getPropertyID().equals(propertyID))
					bioMightOrientation = propertyView.getPropertyOrientation();
			}
		}	
		
		return (bioMightOrientation);
	}
	
	/******************************************************************************************************************
	 * Set Property Orientation
	 *
	 * 
	 * ****************************************************************************************************************/
	
	private int setPropertyOrientation(String propertyID, BioMightOrientation bioMightOrientation) 
	{
		int success = 0;
		for (int i=0; i<properties.size(); i++)
		{
			BioMightPropertyView propertyView = (BioMightPropertyView) properties.get(i);
			if ( propertyView.getPropertyName().equals(propertyID))
			{
				propertyView.getPropertyOrientation();
				success = 1;
			}
		}
		
		return(success);
	}
	

	
	/******************************************************************************************************************
	 * Dump Properties
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public BioMightPropertyView getProperty(String propertyID)
	{
		//System.out.println("get BioMightProperties...");
		

		BioMightPropertyView propertyView = null;
		for (int i=0; i<properties.size(); i++)
		{
			propertyView = (BioMightPropertyView) properties.get(i);
			if (propertyView.getPropertyID().equalsIgnoreCase(propertyID))
			{
				//System.out.println("Matched Property Element: " + i);
				//System.out.println("CanonicalName: " + propertyView.getCanonicalName());
				//System.out.println("PropertyName: " + propertyView.getPropertyName());
				//System.out.println("Property ID: " + propertyView.getPropertyID());
				return (propertyView);
			}
		}

		return(null);
	}
	
	
	
	public void loadMaterials() {
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting All Materials: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			materialDDMap = bioMightBean.getMaterialsDDMap();
			//System.out.println("Have Materials: " + materialDDMap.size());  		
		}catch (Exception e) { 
			System.out.println("BioMightBase: Exception Getting Materials");
		throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public void loadTextures() {
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting Textures: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);	
			textureDDMap = bioMightBean.getTexturesDDMap();						
			//System.out.println("Have Textures" + textures.size()); 		
		} 
		catch (Exception e)
		{
			//System.out.println("BioMightBase: Exception - Getting Textures");
		}
	}


	/******************************************************************************************
	 * SET MATERIAL
	 *
	 * This method will set the Material for the selec 
	 *****************************************************************************************/
	public void setMaterial(int material) {
		//System.out.println("SetMaterial: " + material);
		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting Material: " + this.componentID + "    " + this.parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
		    		 					
			double currentPoints[][] = null;
			//System.out.println("Calling SetMaterial for: " + parentID);
			int success = bioMightBean.setMaterial(this.parentID, material);
			
			//System.out.println("Set Material using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception SetMaterial()");
			throw new ServerException("Remote Exception SetMaterial():", e); 	
		}
	}
	
	
	/*****************************************************************************
	 * SET MATERIAL
	 * 
	 * Makes the call to set the color in the EJB
	 * 
	 * Set the color of the component based on the parent ID
	 * 
	 ****************************************************************************/
	public void setMaterial(int material, String parentID) {
			
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting Material for parent: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode =  bioMightBean.setCollectionMaterial(parentID, material);
			//System.out.println("Saved Material for parent: " + parentID); 	
		}catch (Exception e) { 
			System.out.println("Exception Setting Material");
			throw new ServerException("Remote Exception setMaterial():", e); 	
		}	
			
		//System.out.println("Set Body Component Color " + material);
	}
	
	/******************************************************************************************
	 * SET TEXTURE
	 *
	 * This method will set the Texture for the selected BioText.  
	 *****************************************************************************************/
	public void setTexture(int texture) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		//System.out.println("SetTexture: " + texture);
		
		// Generate the BioText		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Setting the Texture: " + this.componentID + "    " + this.parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
		    		 					
			double currentPoints[][] = null;
			//System.out.println("Calling SetTexture for: " + parentID);
			int success = bioMightBean.setTexture(this.parentID, texture);
			
			//System.out.println("Set Texture using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception SetTexture()");
			throw new ServerException("Remote Exception SetTexture():", e); 	
		}
	}


	/*****************************************************************************
	 * SET MATERIAL
	 * 
	 * Makes the call to set the color in the EJB
	 * 
	 * Set the color of the component based on the parent ID
	 * 
	 ****************************************************************************/
	public void setTexture(int texture, String parentID) {
			
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Setting Texture for parent: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode =  bioMightBean.setCollectionTexture(parentID, texture);
			//System.out.println("Saved Texture for parent: " + parentID); 	
		}catch (Exception e) { 
			System.out.println("Exception Setting Texture");
			throw new ServerException("Remote Exception setTexture():", e); 	
		}	
			
		System.out.println("Set Body Component Color " + texture);
	}
	/******************************************************************************************************************
	 * Dump Properties
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public void dumpProperties() 
	{
		System.out.println("Dumping BioMightProperties...");
		
		{	
			
			for (int i=0; i<properties.size(); i++)
			{
				BioMightPropertyView propertyView = (BioMightPropertyView) properties.get(i);
				System.out.println("Property Element: " + i);
				System.out.println("CanonicalName: " + propertyView.getCanonicalName());
				System.out.println("PropertyName: " + propertyView.getPropertyName());
				System.out.println("Property ID: " + propertyView.getPropertyID());
			}
		
		}	
	
	}
	
	
}