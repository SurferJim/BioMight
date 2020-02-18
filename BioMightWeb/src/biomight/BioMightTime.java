package biomight;

import java.math.BigDecimal;
import java.util.ArrayList;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightPosition;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Tghis object ticks the BioMight Model through time
 * Take a state snapshot of the current data
 * Determine what the user is looking at
 * Set that component in motion  
 * 
 * Currently, I only grab the current state.
 * Each component that is to be animated, needs to generate a clock sequence
 * Maybe this shold be added into the model as an afterthought? 
 * 
 * 
 */

public class BioMightTime {
	// Exvery Component has a component ID is used to identify itself
	protected String componentID;
	
	// Exvery Component has a parent component ID
	protected String parentID;

	protected BioMightTransforms bioMightTransforms;
	
	private int level;
	private boolean isTransparent;
	private boolean isVisible;
	private boolean isHighlight;

	// The Mesh
	private String mesh = "";

	// X3D XML
	private String x3D = "";
	
	protected int viewPerspective = 0;
	
	// Holds Block levels that define where one is in the block grid
	// Picture a hominid dissected by the number of cobes in a level, 
	// where level 0 is the whole cube that surronds the human model.
	// BioMight is based on the decimal system and does increments of
	// resolution based upon a 0, 10, 100, 1000, 10,000, progression. 
	// The position in the arraylist defines the level of detail
	private ArrayList xBlocks;
	private ArrayList yBlocks;
	private ArrayList zBlocks;

	// The Basic Dimensions that surrond the Mesh in terms of Cube Geometry
	// The xyzlevel specifies the level at which the component can fit in the 
	// entirety of one cube.
	private BigDecimal xLen;
	private BigDecimal yLen;
	private BigDecimal zLen;
	private BigDecimal xyzLevel;
	
	// Set up a position object.
	private BioMightPosition bioMightPosition;
	
	// Set up a material object
	private BioMightMaterial bioMightMaterial;
	
	// The Basic Dimensions that surrond the Mesh in terms of Triangular Geometry
	private BigDecimal xApex;
	private BigDecimal yApez;
	private BigDecimal zApex;
	private BigDecimal traingleBase;
	
	// Mesh Coordinates
	private ArrayList X;
	private ArrayList Y;
	private ArrayList Z;
	
	// Base Image -- These will come from a database
	private String image = "";
	private int imageWidth = 320;
	private int imageHeight = 500;
	
	// Colors
	protected BioMightColor bioMightColor;
	
	
	// Base Constructor
	public BioMightTime() {
		
		// Set up a base color object in case one is not defined by the
		// object already
		bioMightColor = new BioMightColor(1.0, 1.0, 1.0);
		//xBlocks = new ArrayList(5);
		//yBlocks = new ArrayList(5);
		//zBlocks = new ArrayList(5);
	
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
}
